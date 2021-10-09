package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks {

    private static final class zza implements zzb {
        private final CountDownLatch zzfd;

        private zza() {
            this.zzfd = new CountDownLatch(1);
        }

        /* synthetic */ zza(zzv zzv) {
            this();
        }

        public final void await() throws InterruptedException {
            this.zzfd.await();
        }

        public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zzfd.await(j, timeUnit);
        }

        public final void onCanceled() {
            this.zzfd.countDown();
        }

        public final void onFailure(@NonNull Exception exc) {
            this.zzfd.countDown();
        }

        public final void onSuccess(Object obj) {
            this.zzfd.countDown();
        }
    }

    interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    private static final class zzc implements zzb {
        private final Object mLock = new Object();
        private final zzu<Void> zzafh;
        @GuardedBy("mLock")
        private Exception zzagh;
        private final int zzagl;
        @GuardedBy("mLock")
        private int zzagm;
        @GuardedBy("mLock")
        private int zzagn;
        @GuardedBy("mLock")
        private int zzago;
        @GuardedBy("mLock")
        private boolean zzagp;

        public zzc(int i, zzu<Void> zzu) {
            this.zzagl = i;
            this.zzafh = zzu;
        }

        @GuardedBy("mLock")
        private final void zzdu() {
            if (this.zzagm + this.zzagn + this.zzago != this.zzagl) {
                return;
            }
            if (this.zzagh != null) {
                zzu<Void> zzu = this.zzafh;
                int i = this.zzagn;
                int i2 = this.zzagl;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i);
                sb.append(" out of ");
                sb.append(i2);
                sb.append(" underlying tasks failed");
                zzu.setException(new ExecutionException(sb.toString(), this.zzagh));
            } else if (this.zzagp) {
                this.zzafh.zzdp();
            } else {
                this.zzafh.setResult(null);
            }
        }

        public final void onCanceled() {
            synchronized (this.mLock) {
                this.zzago++;
                this.zzagp = true;
                zzdu();
            }
        }

        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.mLock) {
                this.zzagn++;
                this.zzagh = exc;
                zzdu();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.mLock) {
                this.zzagm++;
                zzdu();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza((zzv) null);
        zza(task, zza2);
        zza2.await();
        return zzb(task);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza((zzv) null);
        zza(task, zza2);
        if (zza2.await(j, timeUnit)) {
            return zzb(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzv(zzu, callable));
        return zzu;
    }

    public static <TResult> Task<TResult> forCanceled() {
        zzu zzu = new zzu();
        zzu.zzdp();
        return zzu;
    }

    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzu zzu = new zzu();
        zzu.setException(exc);
        return zzu;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzu zzu = new zzu();
        zzu.setResult(tresult);
        return zzu;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzu zzu = new zzu();
        zzc zzc2 = new zzc(collection.size(), zzu);
        for (Task zza2 : collection) {
            zza(zza2, zzc2);
        }
        return zzu;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult((Object) null) : whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWithTask(new zzx(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWith(new zzw(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        return whenAllSuccess((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static void zza(Task<?> task, zzb zzb2) {
        task.addOnSuccessListener(TaskExecutors.zzagd, (OnSuccessListener<? super Object>) zzb2);
        task.addOnFailureListener(TaskExecutors.zzagd, (OnFailureListener) zzb2);
        task.addOnCanceledListener(TaskExecutors.zzagd, (OnCanceledListener) zzb2);
    }

    private static <TResult> TResult zzb(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }
}
