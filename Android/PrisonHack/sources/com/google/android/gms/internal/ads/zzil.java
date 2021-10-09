package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzil extends zzbfc<zzil> {
    private zzis zzant = null;
    private Integer zzanu = null;
    private zzij zzanv = null;
    private zzir[] zzanw = zzir.zzhs();

    public zzil() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzn */
    public final zzil zza(zzbez zzbez) throws IOException {
        zzbfi zzbfi;
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                if (this.zzanv == null) {
                    this.zzanv = new zzij();
                }
                zzbfi = this.zzanv;
            } else if (zzabk == 18) {
                int zzb = zzbfl.zzb(zzbez, 18);
                int length = this.zzanw == null ? 0 : this.zzanw.length;
                zzir[] zzirArr = new zzir[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzanw, 0, zzirArr, 0, length);
                }
                while (length < zzirArr.length - 1) {
                    zzirArr[length] = new zzir();
                    zzbez.zza(zzirArr[length]);
                    zzbez.zzabk();
                    length++;
                }
                zzirArr[length] = new zzir();
                zzbez.zza(zzirArr[length]);
                this.zzanw = zzirArr;
            } else if (zzabk == 24) {
                int position = zzbez.getPosition();
                try {
                    this.zzanu = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                } catch (IllegalArgumentException unused) {
                    zzbez.zzdc(position);
                    zza(zzbez, zzabk);
                }
            } else if (zzabk == 34) {
                if (this.zzant == null) {
                    this.zzant = new zzis();
                }
                zzbfi = this.zzant;
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
            zzbez.zza(zzbfi);
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzanv != null) {
            zzbfa.zza(1, (zzbfi) this.zzanv);
        }
        if (this.zzanw != null && this.zzanw.length > 0) {
            for (zzir zzir : this.zzanw) {
                if (zzir != null) {
                    zzbfa.zza(2, (zzbfi) zzir);
                }
            }
        }
        if (this.zzanu != null) {
            zzbfa.zzm(3, this.zzanu.intValue());
        }
        if (this.zzant != null) {
            zzbfa.zza(4, (zzbfi) this.zzant);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzanv != null) {
            zzr += zzbfa.zzb(1, (zzbfi) this.zzanv);
        }
        if (this.zzanw != null && this.zzanw.length > 0) {
            for (zzir zzir : this.zzanw) {
                if (zzir != null) {
                    zzr += zzbfa.zzb(2, (zzbfi) zzir);
                }
            }
        }
        if (this.zzanu != null) {
            zzr += zzbfa.zzq(3, this.zzanu.intValue());
        }
        return this.zzant != null ? zzr + zzbfa.zzb(4, (zzbfi) this.zzant) : zzr;
    }
}
