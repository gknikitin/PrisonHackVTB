package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzie extends zzbfc<zzie> {
    private String zzamj = null;
    private zzic[] zzamk = zzic.zzhr();
    private Integer zzaml = null;
    private Integer zzamm = null;
    private Integer zzamn = null;

    public zzie() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzh */
    public final zzie zza(zzbez zzbez) throws IOException {
        int i;
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                this.zzamj = zzbez.readString();
            } else if (zzabk == 18) {
                int zzb = zzbfl.zzb(zzbez, 18);
                int length = this.zzamk == null ? 0 : this.zzamk.length;
                zzic[] zzicArr = new zzic[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzamk, 0, zzicArr, 0, length);
                }
                while (length < zzicArr.length - 1) {
                    zzicArr[length] = new zzic();
                    zzbez.zza(zzicArr[length]);
                    zzbez.zzabk();
                    length++;
                }
                zzicArr[length] = new zzic();
                zzbez.zza(zzicArr[length]);
                this.zzamk = zzicArr;
            } else if (zzabk == 24) {
                i = zzbez.getPosition();
                this.zzaml = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
            } else if (zzabk == 32) {
                i = zzbez.getPosition();
                this.zzamm = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
            } else if (zzabk == 40) {
                i = zzbez.getPosition();
                try {
                    this.zzamn = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                } catch (IllegalArgumentException unused) {
                    zzbez.zzdc(i);
                    zza(zzbez, zzabk);
                }
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzamj != null) {
            zzbfa.zzf(1, this.zzamj);
        }
        if (this.zzamk != null && this.zzamk.length > 0) {
            for (zzic zzic : this.zzamk) {
                if (zzic != null) {
                    zzbfa.zza(2, (zzbfi) zzic);
                }
            }
        }
        if (this.zzaml != null) {
            zzbfa.zzm(3, this.zzaml.intValue());
        }
        if (this.zzamm != null) {
            zzbfa.zzm(4, this.zzamm.intValue());
        }
        if (this.zzamn != null) {
            zzbfa.zzm(5, this.zzamn.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzamj != null) {
            zzr += zzbfa.zzg(1, this.zzamj);
        }
        if (this.zzamk != null && this.zzamk.length > 0) {
            for (zzic zzic : this.zzamk) {
                if (zzic != null) {
                    zzr += zzbfa.zzb(2, (zzbfi) zzic);
                }
            }
        }
        if (this.zzaml != null) {
            zzr += zzbfa.zzq(3, this.zzaml.intValue());
        }
        if (this.zzamm != null) {
            zzr += zzbfa.zzq(4, this.zzamm.intValue());
        }
        return this.zzamn != null ? zzr + zzbfa.zzq(5, this.zzamn.intValue()) : zzr;
    }
}
