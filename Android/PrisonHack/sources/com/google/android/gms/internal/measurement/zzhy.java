package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhy implements Runnable {
    private final /* synthetic */ AtomicReference zzaof;
    private final /* synthetic */ zzhl zzaog;

    zzhy(zzhl zzhl, AtomicReference atomicReference) {
        this.zzaog = zzhl;
        this.zzaof = atomicReference;
    }

    public final void run() {
        synchronized (this.zzaof) {
            try {
                AtomicReference atomicReference = this.zzaof;
                zzeg zzgh = this.zzaog.zzgh();
                atomicReference.set(Integer.valueOf(zzgh.zzb(zzgh.zzfw().zzah(), zzey.zzahz)));
                this.zzaof.notify();
            } catch (Throwable th) {
                this.zzaof.notify();
                throw th;
            }
        }
    }
}
