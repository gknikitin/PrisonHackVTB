package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzim implements Runnable {
    private final /* synthetic */ zzdz zzano;
    private final /* synthetic */ zzij zzapn;
    private final /* synthetic */ AtomicReference zzapo;

    zzim(zzij zzij, AtomicReference atomicReference, zzdz zzdz) {
        this.zzapn = zzij;
        this.zzapo = atomicReference;
        this.zzano = zzdz;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zzapo) {
            try {
                zzez zzd = this.zzapn.zzaph;
                if (zzd == null) {
                    this.zzapn.zzgf().zzis().log("Failed to get app instance id");
                    this.zzapo.notify();
                    return;
                }
                this.zzapo.set(zzd.zzc(this.zzano));
                String str = (String) this.zzapo.get();
                if (str != null) {
                    this.zzapn.zzfv().zzbq(str);
                    this.zzapn.zzgg().zzakk.zzbr(str);
                }
                this.zzapn.zzcu();
                atomicReference = this.zzapo;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzapn.zzgf().zzis().zzg("Failed to get app instance id", e);
                    atomicReference = this.zzapo;
                } catch (Throwable th) {
                    this.zzapo.notify();
                    throw th;
                }
            }
        }
    }
}
