package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzij extends zzbfc<zzij> {
    private String zzanq = null;
    private Integer zzanr = null;
    private int[] zzans = zzbfl.zzeby;
    private zzis zzant = null;

    public zzij() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzl */
    public final zzij zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                this.zzanq = zzbez.readString();
            } else if (zzabk == 16) {
                int position = zzbez.getPosition();
                try {
                    this.zzanr = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                } catch (IllegalArgumentException unused) {
                    zzbez.zzdc(position);
                    zza(zzbez, zzabk);
                }
            } else if (zzabk == 24) {
                int zzb = zzbfl.zzb(zzbez, 24);
                int length = this.zzans == null ? 0 : this.zzans.length;
                int[] iArr = new int[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzans, 0, iArr, 0, length);
                }
                while (length < iArr.length - 1) {
                    iArr[length] = zzbez.zzacc();
                    zzbez.zzabk();
                    length++;
                }
                iArr[length] = zzbez.zzacc();
                this.zzans = iArr;
            } else if (zzabk == 26) {
                int zzbr = zzbez.zzbr(zzbez.zzacc());
                int position2 = zzbez.getPosition();
                int i = 0;
                while (zzbez.zzagn() > 0) {
                    zzbez.zzacc();
                    i++;
                }
                zzbez.zzdc(position2);
                int length2 = this.zzans == null ? 0 : this.zzans.length;
                int[] iArr2 = new int[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzans, 0, iArr2, 0, length2);
                }
                while (length2 < iArr2.length) {
                    iArr2[length2] = zzbez.zzacc();
                    length2++;
                }
                this.zzans = iArr2;
                zzbez.zzbs(zzbr);
            } else if (zzabk == 34) {
                if (this.zzant == null) {
                    this.zzant = new zzis();
                }
                zzbez.zza(this.zzant);
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzanq != null) {
            zzbfa.zzf(1, this.zzanq);
        }
        if (this.zzanr != null) {
            zzbfa.zzm(2, this.zzanr.intValue());
        }
        if (this.zzans != null && this.zzans.length > 0) {
            for (int zzm : this.zzans) {
                zzbfa.zzm(3, zzm);
            }
        }
        if (this.zzant != null) {
            zzbfa.zza(4, (zzbfi) this.zzant);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzanq != null) {
            zzr += zzbfa.zzg(1, this.zzanq);
        }
        if (this.zzanr != null) {
            zzr += zzbfa.zzq(2, this.zzanr.intValue());
        }
        if (this.zzans != null && this.zzans.length > 0) {
            int i = 0;
            for (int zzce : this.zzans) {
                i += zzbfa.zzce(zzce);
            }
            zzr = zzr + i + (this.zzans.length * 1);
        }
        return this.zzant != null ? zzr + zzbfa.zzb(4, (zzbfi) this.zzant) : zzr;
    }
}
