package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzis extends zzbfc<zzis> {
    private static volatile zzis[] zzaoq;
    private Integer zzaor = null;
    private Integer zzaos = null;

    public zzis() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    public static zzis[] zzht() {
        if (zzaoq == null) {
            synchronized (zzbfg.zzebs) {
                if (zzaoq == null) {
                    zzaoq = new zzis[0];
                }
            }
        }
        return zzaoq;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 8) {
                this.zzaor = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 16) {
                this.zzaos = Integer.valueOf(zzbez.zzacc());
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzaor != null) {
            zzbfa.zzm(1, this.zzaor.intValue());
        }
        if (this.zzaos != null) {
            zzbfa.zzm(2, this.zzaos.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzaor != null) {
            zzr += zzbfa.zzq(1, this.zzaor.intValue());
        }
        return this.zzaos != null ? zzr + zzbfa.zzq(2, this.zzaos.intValue()) : zzr;
    }
}
