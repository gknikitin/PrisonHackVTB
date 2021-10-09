package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzid extends zzbfc<zzid> {
    private String zzacp = null;
    private zzic[] zzamh = zzic.zzhr();
    private Integer zzami = null;

    public zzid() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final zzid zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                this.zzacp = zzbez.readString();
            } else if (zzabk == 18) {
                int zzb = zzbfl.zzb(zzbez, 18);
                int length = this.zzamh == null ? 0 : this.zzamh.length;
                zzic[] zzicArr = new zzic[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzamh, 0, zzicArr, 0, length);
                }
                while (length < zzicArr.length - 1) {
                    zzicArr[length] = new zzic();
                    zzbez.zza(zzicArr[length]);
                    zzbez.zzabk();
                    length++;
                }
                zzicArr[length] = new zzic();
                zzbez.zza(zzicArr[length]);
                this.zzamh = zzicArr;
            } else if (zzabk == 24) {
                int position = zzbez.getPosition();
                try {
                    this.zzami = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                } catch (IllegalArgumentException unused) {
                    zzbez.zzdc(position);
                    zza(zzbez, zzabk);
                }
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzacp != null) {
            zzbfa.zzf(1, this.zzacp);
        }
        if (this.zzamh != null && this.zzamh.length > 0) {
            for (zzic zzic : this.zzamh) {
                if (zzic != null) {
                    zzbfa.zza(2, (zzbfi) zzic);
                }
            }
        }
        if (this.zzami != null) {
            zzbfa.zzm(3, this.zzami.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzacp != null) {
            zzr += zzbfa.zzg(1, this.zzacp);
        }
        if (this.zzamh != null && this.zzamh.length > 0) {
            for (zzic zzic : this.zzamh) {
                if (zzic != null) {
                    zzr += zzbfa.zzb(2, (zzbfi) zzic);
                }
            }
        }
        return this.zzami != null ? zzr + zzbfa.zzq(3, this.zzami.intValue()) : zzr;
    }
}
