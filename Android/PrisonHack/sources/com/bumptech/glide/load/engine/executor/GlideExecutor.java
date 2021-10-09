package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class GlideExecutor extends ThreadPoolExecutor {
    private static final String ANIMATION_EXECUTOR_NAME = "animation";
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    public static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    public static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    public static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final boolean executeSynchronously;

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT = LOG;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() {
            public void handle(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy LOG = new UncaughtThrowableStrategy() {
            public void handle(Throwable th) {
                if (th != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                    Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
                }
            }
        };
        public static final UncaughtThrowableStrategy THROW = new UncaughtThrowableStrategy() {
            public void handle(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        void handle(Throwable th);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, uncaughtThrowableStrategy);
    }

    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(i, str, uncaughtThrowableStrategy, true, false);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), "source", UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, uncaughtThrowableStrategy);
    }

    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(i, str, uncaughtThrowableStrategy, false, false);
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false, false, new SynchronousQueue());
    }

    public static GlideExecutor newAnimationExecutor() {
        return new GlideExecutor(0, calculateBestThreadCount() >= 4 ? 2 : 1, KEEP_ALIVE_TIME_MS, ANIMATION_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, true, false, new PriorityBlockingQueue());
    }

    GlideExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z, boolean z2) {
        this(i, i, 0, str, uncaughtThrowableStrategy, z, z2);
    }

    GlideExecutor(int i, int i2, long j, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z, boolean z2) {
        this(i, i2, j, str, uncaughtThrowableStrategy, z, z2, new PriorityBlockingQueue());
    }

    GlideExecutor(int i, int i2, long j, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z, boolean z2, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, TimeUnit.MILLISECONDS, blockingQueue, new DefaultThreadFactory(str, uncaughtThrowableStrategy, z));
        this.executeSynchronously = z2;
    }

    public void execute(Runnable runnable) {
        if (this.executeSynchronously) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @NonNull
    public Future<?> submit(Runnable runnable) {
        return maybeWait(super.submit(runnable));
    }

    private <T> Future<T> maybeWait(Future<T> future) {
        if (this.executeSynchronously) {
            boolean z = false;
            while (!future.isDone()) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        return future;
    }

    @NonNull
    public <T> Future<T> submit(Runnable runnable, T t) {
        return maybeWait(super.submit(runnable, t));
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return maybeWait(super.submit(callable));
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            File[] fileArr = null;
            try {
                File file = new File(CPU_LOCATION);
                final Pattern compile = Pattern.compile(CPU_NAME_REGEX);
                File[] listFiles = file.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return compile.matcher(str).matches();
                    }
                });
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = listFiles;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
            bestThreadCount = Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0));
        }
        return bestThreadCount;
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final String name;
        final boolean preventNetworkOperations;
        private int threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy2, boolean z) {
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            this.preventNetworkOperations = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C05141 r0;
            r0 = new Thread(runnable, "glide-" + this.name + "-thread-" + this.threadNum) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th);
                    }
                }
            };
            this.threadNum = this.threadNum + 1;
            return r0;
        }
    }
}
