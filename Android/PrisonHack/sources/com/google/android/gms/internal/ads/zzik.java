package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzik extends zzbfc<zzik> {
    private int[] zzans = zzbfl.zzeby;
    private Integer zzanu = null;

    public zzik() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzm */
    public final zzik zza(zzbez zzbez) throws IOException {
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
            } else if (zzabk == 16) {
                int zzb = zzbfl.zzb(zzbez, 16);
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
            } else if (zzabk == 18) {
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
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzanu != null) {
            zzbfa.zzm(1, this.zzanu.intValue());
        }
        if (this.zzans != null && this.zzans.length > 0) {
            for (int zzm : this.zzans) {
                zzbfa.zzm(2, zzm);
            }
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzanu != null) {
            zzr += zzbfa.zzq(1, this.zzanu.intValue());
        }
        if (this.zzans == null || this.zzans.length <= 0) {
            return zzr;
        }
        int i = 0;
        for (int zzce : this.zzans) {
            i += zzbfa.zzce(zzce);
        }
        return zzr + i + (this.zzans.length * 1);
    }
}
