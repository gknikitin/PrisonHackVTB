package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzgh extends zzhi {
    /* access modifiers changed from: private */
    public static final AtomicLong zzamg = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzalw;
    /* access modifiers changed from: private */
    public zzgl zzalx;
    /* access modifiers changed from: private */
    public zzgl zzaly;
    private final PriorityBlockingQueue<zzgk<?>> zzalz = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzgk<?>> zzama = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzamb = new zzgj(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzamc = new zzgj(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzamd = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzame = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzamf;

    zzgh(zzgm zzgm) {
        super(zzgm);
    }

    private final void zza(zzgk<?> zzgk) {
        synchronized (this.zzamd) {
            this.zzalz.add(zzgk);
            if (this.zzalx == null) {
                this.zzalx = new zzgl(this, "Measurement Worker", this.zzalz);
                this.zzalx.setUncaughtExceptionHandler(this.zzamb);
                this.zzalx.start();
            } else {
                this.zzalx.zzju();
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|(1:19)(1:20)|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r2 = zzgf().zziv();
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r4.length() == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r3 = "Timed out waiting for ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2.log(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = zzgf().zziv();
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r4.length() != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r3 = "Interrupted waiting for ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r3 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r2.log(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r1 = r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zza(java.util.concurrent.atomic.AtomicReference<T> r1, long r2, java.lang.String r4, java.lang.Runnable r5) {
        /*
            r0 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgh r2 = r0.zzge()     // Catch:{ all -> 0x005c }
            r2.zzc((java.lang.Runnable) r5)     // Catch:{ all -> 0x005c }
            r2 = 15000(0x3a98, double:7.411E-320)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0037 }
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L_0x0036
            com.google.android.gms.internal.measurement.zzfh r2 = r0.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Timed out waiting for "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x002d
            java.lang.String r3 = r3.concat(r4)
            goto L_0x0033
        L_0x002d:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3)
            r3 = r4
        L_0x0033:
            r2.log(r3)
        L_0x0036:
            return r1
        L_0x0037:
            com.google.android.gms.internal.measurement.zzfh r2 = r0.zzgf()     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()     // Catch:{ all -> 0x005c }
            java.lang.String r3 = "Interrupted waiting for "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x005c }
            int r5 = r4.length()     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x0050
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x005c }
            goto L_0x0056
        L_0x0050:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x005c }
            r4.<init>(r3)     // Catch:{ all -> 0x005c }
            r3 = r4
        L_0x0056:
            r2.log(r3)     // Catch:{ all -> 0x005c }
            r2 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            return r2
        L_0x005c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgh.zza(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final void zzab() {
        if (Thread.currentThread() != this.zzalx) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(callable);
        zzgk zzgk = new zzgk(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalx) {
            if (!this.zzalz.isEmpty()) {
                zzgf().zziv().log("Callable skipped the worker queue.");
            }
            zzgk.run();
            return zzgk;
        }
        zza((zzgk<?>) zzgk);
        return zzgk;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final <V> Future<V> zzc(Callable<V> callable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(callable);
        zzgk zzgk = new zzgk(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalx) {
            zzgk.run();
            return zzgk;
        }
        zza((zzgk<?>) zzgk);
        return zzgk;
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(runnable);
        zza((zzgk<?>) new zzgk(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzd(Runnable runnable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(runnable);
        zzgk zzgk = new zzgk(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzamd) {
            this.zzama.add(zzgk);
            if (this.zzaly == null) {
                this.zzaly = new zzgl(this, "Measurement Network", this.zzama);
                this.zzaly.setUncaughtExceptionHandler(this.zzamc);
                this.zzaly.start();
            } else {
                this.zzaly.zzju();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final void zzft() {
        if (Thread.currentThread() != this.zzaly) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzdu zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzhl zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzeq zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzij zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzig zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfd zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzff zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzkc zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzji zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzgh zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfh zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzfs zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzeg zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzec zzgi() {
        return super.zzgi();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return false;
    }

    public final boolean zzjr() {
        return Thread.currentThread() == this.zzalx;
    }

    /* access modifiers changed from: package-private */
    public final ExecutorService zzjs() {
        ExecutorService executorService;
        synchronized (this.zzamd) {
            if (this.zzalw == null) {
                this.zzalw = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzalw;
        }
        return executorService;
    }
}
