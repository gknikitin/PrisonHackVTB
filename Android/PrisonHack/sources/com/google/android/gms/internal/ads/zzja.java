package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzja extends zzbfc<zzja> {
    private Integer zzanu = null;
    private Integer zzape = null;
    private Integer zzapf = null;
    private zziw zzapn = null;
    private Integer zzapr = null;
    private Long zzaps = null;

    public zzja() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzx */
    public final zzja zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 8) {
                int position = zzbez.getPosition();
                try {
                    this.zzanu = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                } catch (IllegalArgumentException unused) {
                    zzbez.zzdc(position);
                    zza(zzbez, zzabk);
                }
            } else if (zzabk == 18) {
                if (this.zzapn == null) {
                    this.zzapn = new zziw();
                }
                zzbez.zza(this.zzapn);
            } else if (zzabk == 24) {
                this.zzape = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 32) {
                this.zzapf = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 40) {
                this.zzapr = Integer.valueOf(zzbez.zzacc());
            } else if (zzabk == 48) {
                this.zzaps = Long.valueOf(zzbez.zzacd());
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzanu != null) {
            zzbfa.zzm(1, this.zzanu.intValue());
        }
        if (this.zzapn != null) {
            zzbfa.zza(2, (zzbfi) this.zzapn);
        }
        if (this.zzape != null) {
            zzbfa.zzm(3, this.zzape.intValue());
        }
        if (this.zzapf != null) {
            zzbfa.zzm(4, this.zzapf.intValue());
        }
        if (this.zzapr != null) {
            zzbfa.zzm(5, this.zzapr.intValue());
        }
        if (this.zzaps != null) {
            zzbfa.zza(6, this.zzaps.longValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzanu != null) {
            zzr += zzbfa.zzq(1, this.zzanu.intValue());
        }
        if (this.zzapn != null) {
            zzr += zzbfa.zzb(2, (zzbfi) this.zzapn);
        }
        if (this.zzape != null) {
            zzr += zzbfa.zzq(3, this.zzape.intValue());
        }
        if (this.zzapf != null) {
            zzr += zzbfa.zzq(4, this.zzapf.intValue());
        }
        if (this.zzapr != null) {
            zzr += zzbfa.zzq(5, this.zzapr.intValue());
        }
        return this.zzaps != null ? zzr + zzbfa.zze(6, this.zzaps.longValue()) : zzr;
    }
}
