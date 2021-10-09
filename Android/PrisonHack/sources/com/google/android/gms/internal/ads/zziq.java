package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zziq extends zzbfc<zziq> {
    private Integer zzaon = null;
    private Integer zzaoo = null;

    public zziq() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 8) {
                this.zzaon = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 16) {
                this.zzaoo = Integer.valueOf(zzbez.zzacc());
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzaon != null) {
            zzbfa.zzm(1, this.zzaon.intValue());
        }
        if (this.zzaoo != null) {
            zzbfa.zzm(2, this.zzaoo.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzaon != null) {
            zzr += zzbfa.zzq(1, this.zzaon.intValue());
        }
        return this.zzaoo != null ? zzr + zzbfa.zzq(2, this.zzaoo.intValue()) : zzr;
    }
}
