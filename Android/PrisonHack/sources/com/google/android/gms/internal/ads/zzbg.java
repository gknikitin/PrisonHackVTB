package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbg extends zzbfc<zzbg> {
    public Integer zzfe;
    private Integer zzff;
    public byte[] zzgq = null;
    public byte[][] zzgv = zzbfl.zzece;

    public zzbg() {
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzbg zza(zzbez zzbez) throws IOException {
        int i;
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                int zzb = zzbfl.zzb(zzbez, 10);
                int length = this.zzgv == null ? 0 : this.zzgv.length;
                byte[][] bArr = new byte[(zzb + length)][];
                if (length != 0) {
                    System.arraycopy(this.zzgv, 0, bArr, 0, length);
                }
                while (length < bArr.length - 1) {
                    bArr[length] = zzbez.readBytes();
                    zzbez.zzabk();
                    length++;
                }
                bArr[length] = zzbez.readBytes();
                this.zzgv = bArr;
            } else if (zzabk == 18) {
                this.zzgq = zzbez.readBytes();
            } else if (zzabk == 24) {
                i = zzbez.getPosition();
                this.zzff = Integer.valueOf(zzaz.zze(zzbez.zzacc()));
            } else if (zzabk == 32) {
                i = zzbez.getPosition();
                try {
                    this.zzfe = Integer.valueOf(zzaz.zzf(zzbez.zzacc()));
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
        if (this.zzgv != null && this.zzgv.length > 0) {
            for (byte[] bArr : this.zzgv) {
                if (bArr != null) {
                    zzbfa.zza(1, bArr);
                }
            }
        }
        if (this.zzgq != null) {
            zzbfa.zza(2, this.zzgq);
        }
        if (this.zzff != null) {
            zzbfa.zzm(3, this.zzff.intValue());
        }
        if (this.zzfe != null) {
            zzbfa.zzm(4, this.zzfe.intValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzgv != null && this.zzgv.length > 0) {
            int i = 0;
            int i2 = 0;
            for (byte[] bArr : this.zzgv) {
                if (bArr != null) {
                    i2++;
                    i += zzbfa.zzv(bArr);
                }
            }
            zzr = zzr + i + (i2 * 1);
        }
        if (this.zzgq != null) {
            zzr += zzbfa.zzb(2, this.zzgq);
        }
        if (this.zzff != null) {
            zzr += zzbfa.zzq(3, this.zzff.intValue());
        }
        return this.zzfe != null ? zzr + zzbfa.zzq(4, this.zzfe.intValue()) : zzr;
    }
}
