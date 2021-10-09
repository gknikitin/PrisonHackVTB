package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzio implements Runnable {
    private final /* synthetic */ zzif zzapf;
    private final /* synthetic */ zzij zzapn;

    zzio(zzij zzij, zzif zzif) {
        this.zzapn = zzij;
        this.zzapf = zzif;
    }

    public final void run() {
        long j;
        String str;
        String str2;
        String packageName;
        zzez zzd = this.zzapn.zzaph;
        if (zzd == null) {
            this.zzapn.zzgf().zzis().log("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zzapf == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzapn.getContext().getPackageName();
            } else {
                j = this.zzapf.zzaot;
                str = this.zzapf.zzul;
                str2 = this.zzapf.zzaos;
                packageName = this.zzapn.getContext().getPackageName();
            }
            zzd.zza(j, str, str2, packageName);
            this.zzapn.zzcu();
        } catch (RemoteException e) {
            this.zzapn.zzgf().zzis().zzg("Failed to send current screen to the service", e);
        }
    }
}
