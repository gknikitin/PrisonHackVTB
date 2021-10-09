package com.google.android.gms.internal.ads;

public final class zzbfe implements Cloneable {
    private static final zzbff zzebm = new zzbff();
    private int mSize;
    private boolean zzebn;
    private int[] zzebo;
    private zzbff[] zzebp;

    zzbfe() {
        this(10);
    }

    private zzbfe(int i) {
        this.zzebn = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzebo = new int[idealIntArraySize];
        this.zzebp = new zzbff[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzdh(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzebo[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzbfe zzbfe = new zzbfe(i);
        System.arraycopy(this.zzebo, 0, zzbfe.zzebo, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzebp[i2] != null) {
                zzbfe.zzebp[i2] = (zzbff) this.zzebp[i2].clone();
            }
        }
        zzbfe.mSize = i;
        return zzbfe;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbfe)) {
            return false;
        }
        zzbfe zzbfe = (zzbfe) obj;
        if (this.mSize != zzbfe.mSize) {
            return false;
        }
        int[] iArr = this.zzebo;
        int[] iArr2 = zzbfe.zzebo;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzbff[] zzbffArr = this.zzebp;
            zzbff[] zzbffArr2 = zzbfe.zzebp;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzbffArr[i4].equals(zzbffArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzebo[i2]) * 31) + this.zzebp[i2].hashCode();
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzbff zzbff) {
        int zzdh = zzdh(i);
        if (zzdh >= 0) {
            this.zzebp[zzdh] = zzbff;
            return;
        }
        int i2 = zzdh ^ -1;
        if (i2 >= this.mSize || this.zzebp[i2] != zzebm) {
            if (this.mSize >= this.zzebo.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzbff[] zzbffArr = new zzbff[idealIntArraySize];
                System.arraycopy(this.zzebo, 0, iArr, 0, this.zzebo.length);
                System.arraycopy(this.zzebp, 0, zzbffArr, 0, this.zzebp.length);
                this.zzebo = iArr;
                this.zzebp = zzbffArr;
            }
            if (this.mSize - i2 != 0) {
                int i3 = i2 + 1;
                System.arraycopy(this.zzebo, i2, this.zzebo, i3, this.mSize - i2);
                System.arraycopy(this.zzebp, i2, this.zzebp, i3, this.mSize - i2);
            }
            this.zzebo[i2] = i;
            this.zzebp[i2] = zzbff;
            this.mSize++;
            return;
        }
        this.zzebo[i2] = i;
        this.zzebp[i2] = zzbff;
    }

    /* access modifiers changed from: package-private */
    public final zzbff zzdf(int i) {
        int zzdh = zzdh(i);
        if (zzdh < 0 || this.zzebp[zzdh] == zzebm) {
            return null;
        }
        return this.zzebp[zzdh];
    }

    /* access modifiers changed from: package-private */
    public final zzbff zzdg(int i) {
        return this.zzebp[i];
    }
}
