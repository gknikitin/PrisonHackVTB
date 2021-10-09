package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzit implements Runnable {
    private final /* synthetic */ zzdz zzano;
    private final /* synthetic */ String zzanr;
    private final /* synthetic */ String zzans;
    private final /* synthetic */ String zzant;
    private final /* synthetic */ zzij zzapn;
    private final /* synthetic */ AtomicReference zzapo;

    zzit(zzij zzij, AtomicReference atomicReference, String str, String str2, String str3, zzdz zzdz) {
        this.zzapn = zzij;
        this.zzapo = atomicReference;
        this.zzant = str;
        this.zzanr = str2;
        this.zzans = str3;
        this.zzano = zzdz;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzee> zze;
        synchronized (this.zzapo) {
            try {
                zzez zzd = this.zzapn.zzaph;
                if (zzd == null) {
                    this.zzapn.zzgf().zzis().zzd("Failed to get conditional properties", zzfh.zzbl(this.zzant), this.zzanr, this.zzans);
                    this.zzapo.set(Collections.emptyList());
                    this.zzapo.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzant)) {
                    atomicReference2 = this.zzapo;
                    zze = zzd.zza(this.zzanr, this.zzans, this.zzano);
                } else {
                    atomicReference2 = this.zzapo;
                    zze = zzd.zze(this.zzant, this.zzanr, this.zzans);
                }
                atomicReference2.set(zze);
                this.zzapn.zzcu();
                atomicReference = this.zzapo;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzapn.zzgf().zzis().zzd("Failed to get conditional properties", zzfh.zzbl(this.zzant), this.zzanr, e);
                    this.zzapo.set(Collections.emptyList());
                    atomicReference = this.zzapo;
                } catch (Throwable th) {
                    this.zzapo.notify();
                    throw th;
                }
            }
        }
    }
}
