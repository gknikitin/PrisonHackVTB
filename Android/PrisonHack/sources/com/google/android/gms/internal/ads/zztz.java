package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzal;
import com.google.android.gms.ads.internal.zzbv;

final class zztz {
    zzal zzbor;
    @Nullable
    zzjj zzbos;
    zzst zzbot;
    long zzbou;
    boolean zzbov;
    private final /* synthetic */ zzty zzbow;
    boolean zzwa;

    zztz(zzty zzty, zzss zzss) {
        this.zzbow = zzty;
        this.zzbor = zzss.zzaw(zzty.zzye);
        this.zzbot = new zzst();
        zzst zzst = this.zzbot;
        zzal zzal = this.zzbor;
        zzal.zza((zzkh) new zzsu(zzst));
        zzal.zza((zzla) new zztc(zzst));
        zzal.zza((zzod) new zzte(zzst));
        zzal.zza((zzke) new zztg(zzst));
        zzal.zza((zzahe) new zzti(zzst));
    }

    zztz(zzty zzty, zzss zzss, zzjj zzjj) {
        this(zzty, zzss);
        this.zzbos = zzjj;
    }

    /* access modifiers changed from: package-private */
    public final boolean load() {
        if (this.zzwa) {
            return false;
        }
        this.zzbov = this.zzbor.zzb(zztw.zzi(this.zzbos != null ? this.zzbos : this.zzbow.zzboo));
        this.zzwa = true;
        this.zzbou = zzbv.zzer().currentTimeMillis();
        return true;
    }
}
