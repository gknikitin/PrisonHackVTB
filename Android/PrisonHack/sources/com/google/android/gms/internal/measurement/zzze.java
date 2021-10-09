package com.google.android.gms.internal.measurement;

class zzze extends zzzd {
    protected final byte[] zzbrm;

    zzze(byte[] bArr) {
        this.zzbrm = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyy) || size() != ((zzyy) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzze)) {
            return obj.equals(this);
        }
        zzze zzze = (zzze) obj;
        int zztg = zztg();
        int zztg2 = zzze.zztg();
        if (zztg == 0 || zztg2 == 0 || zztg == zztg2) {
            return zza(zzze, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzbrm.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzzt.zza(i, this.zzbrm, zzth(), i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzyy zzyy, int i, int i2) {
        if (i2 > zzyy.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzyy.size()) {
            int size2 = zzyy.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzyy instanceof zzze)) {
            return zzyy.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzze zzze = (zzze) zzyy;
            byte[] bArr = this.zzbrm;
            byte[] bArr2 = zzze.zzbrm;
            int zzth = zzth() + i2;
            int zzth2 = zzth();
            int zzth3 = zzze.zzth();
            while (zzth2 < zzth) {
                if (bArr[zzth2] != bArr2[zzth3]) {
                    return false;
                }
                zzth2++;
                zzth3++;
            }
            return true;
        }
    }

    public byte zzae(int i) {
        return this.zzbrm[i];
    }

    public final zzyy zzb(int i, int i2) {
        int zzb = zzb(0, i2, size());
        return zzb == 0 ? zzyy.zzbrh : new zzzb(this.zzbrm, zzth(), zzb);
    }

    /* access modifiers changed from: protected */
    public int zzth() {
        return 0;
    }
}
