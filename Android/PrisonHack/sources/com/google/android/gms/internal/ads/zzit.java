package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzit extends zzbfc<zzit> {
    public Integer zzaot = null;
    public Integer zzaou = null;
    public Integer zzaov = null;

    public zzit() {
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
                this.zzaot = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 16) {
                this.zzaou = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 24) {
                this.zzaov = Integer.valueOf(zzbez.zzacc());
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzaot != null) {
            zzbfa.zzm(1, this.zzaot.intValue());
        }
        if (this.zzaou != null) {
            zzbfa.zzm(2, this.zzaou.intValue());
        }
        if (this.zzaov != null) {
            zzbfa.zzm(3, this.zzaov.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzaot != null) {
            zzr += zzbfa.zzq(1, this.zzaot.intValue());
        }
        if (this.zzaou != null) {
            zzr += zzbfa.zzq(2, this.zzaou.intValue());
        }
        return this.zzaov != null ? zzr + zzbfa.zzq(3, this.zzaov.intValue()) : zzr;
    }
}
