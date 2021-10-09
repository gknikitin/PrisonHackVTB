package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

final class zzbas extends zzbaq {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzdqd;
    private int zzdqe;
    private int zzdqf;
    private int zzdqg;
    private int zzdqh;

    private zzbas(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzdqh = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzdqf = this.pos;
        this.zzdqd = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzacc() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.limit
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L_0x006d
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0024:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r3 = r2
            goto L_0x006a
        L_0x0031:
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x003f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x006a
        L_0x003f:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r1 = r1[r2]
            if (r1 < 0) goto L_0x006d
        L_0x006a:
            r5.pos = r3
            return r0
        L_0x006d:
            long r0 = r5.zzabz()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbas.zzacc():int");
    }

    private final long zzacd() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        byte b;
        long j4;
        int i2 = this.pos;
        if (this.limit != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.pos = i3;
                return (long) b2;
            } else if (this.limit - i3 >= 9) {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << 14);
                    if (b4 >= 0) {
                        j4 = (long) (b4 ^ 16256);
                        i = i5;
                        j = j4;
                        this.pos = i;
                        return j;
                    }
                    i4 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 21);
                    if (b5 < 0) {
                        b = b5 ^ -2080896;
                    } else {
                        long j5 = (long) b5;
                        int i6 = i4 + 1;
                        long j6 = j5 ^ (((long) bArr[i4]) << 28);
                        if (j6 >= 0) {
                            j3 = 266354560;
                        } else {
                            int i7 = i6 + 1;
                            long j7 = j6 ^ (((long) bArr[i6]) << 35);
                            if (j7 < 0) {
                                j2 = -34093383808L;
                            } else {
                                i6 = i7 + 1;
                                j6 = j7 ^ (((long) bArr[i7]) << 42);
                                if (j6 >= 0) {
                                    j3 = 4363953127296L;
                                } else {
                                    i7 = i6 + 1;
                                    j7 = j6 ^ (((long) bArr[i6]) << 49);
                                    if (j7 < 0) {
                                        j2 = -558586000294016L;
                                    } else {
                                        int i8 = i7 + 1;
                                        long j8 = (j7 ^ (((long) bArr[i7]) << 56)) ^ 71499008037633920L;
                                        if (j8 < 0) {
                                            int i9 = i8 + 1;
                                            if (((long) bArr[i8]) >= 0) {
                                                i8 = i9;
                                            }
                                        }
                                        j = j8;
                                        this.pos = i;
                                        return j;
                                    }
                                }
                            }
                            j = j7 ^ j2;
                            i = i7;
                            this.pos = i;
                            return j;
                        }
                        j = j6 ^ j3;
                        this.pos = i;
                        return j;
                    }
                }
                j4 = (long) b;
                i = i4;
                j = j4;
                this.pos = i;
                return j;
            }
        }
        return zzabz();
    }

    private final int zzace() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzbbu.zzadl();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzacf() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzbbu.zzadl();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private final void zzacg() {
        this.limit += this.zzdqe;
        int i = this.limit - this.zzdqf;
        if (i > this.zzdqh) {
            this.zzdqe = i - this.zzdqh;
            this.limit -= this.zzdqe;
            return;
        }
        this.zzdqe = 0;
    }

    private final byte zzach() throws IOException {
        if (this.pos == this.limit) {
            throw zzbbu.zzadl();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzacf());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzace());
    }

    public final String readString() throws IOException {
        int zzacc = zzacc();
        if (zzacc > 0 && zzacc <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzacc, zzbbq.UTF_8);
            this.pos += zzacc;
            return str;
        } else if (zzacc == 0) {
            return "";
        } else {
            if (zzacc < 0) {
                throw zzbbu.zzadm();
            }
            throw zzbbu.zzadl();
        }
    }

    public final int zzabk() throws IOException {
        if (zzaca()) {
            this.zzdqg = 0;
            return 0;
        }
        this.zzdqg = zzacc();
        if ((this.zzdqg >>> 3) != 0) {
            return this.zzdqg;
        }
        throw zzbbu.zzado();
    }

    public final long zzabl() throws IOException {
        return zzacd();
    }

    public final long zzabm() throws IOException {
        return zzacd();
    }

    public final int zzabn() throws IOException {
        return zzacc();
    }

    public final long zzabo() throws IOException {
        return zzacf();
    }

    public final int zzabp() throws IOException {
        return zzace();
    }

    public final boolean zzabq() throws IOException {
        return zzacd() != 0;
    }

    public final String zzabr() throws IOException {
        int zzacc = zzacc();
        if (zzacc <= 0 || zzacc > this.limit - this.pos) {
            if (zzacc == 0) {
                return "";
            }
            if (zzacc <= 0) {
                throw zzbbu.zzadm();
            }
            throw zzbbu.zzadl();
        } else if (!zzbem.zzf(this.buffer, this.pos, this.pos + zzacc)) {
            throw zzbbu.zzads();
        } else {
            int i = this.pos;
            this.pos += zzacc;
            return new String(this.buffer, i, zzacc, zzbbq.UTF_8);
        }
    }

    public final zzbah zzabs() throws IOException {
        byte[] bArr;
        int zzacc = zzacc();
        if (zzacc > 0 && zzacc <= this.limit - this.pos) {
            zzbah zzc = zzbah.zzc(this.buffer, this.pos, zzacc);
            this.pos += zzacc;
            return zzc;
        } else if (zzacc == 0) {
            return zzbah.zzdpq;
        } else {
            if (zzacc > 0 && zzacc <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzacc;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzacc > 0) {
                throw zzbbu.zzadl();
            } else if (zzacc == 0) {
                bArr = zzbbq.zzduq;
            } else {
                throw zzbbu.zzadm();
            }
            return zzbah.zzp(bArr);
        }
    }

    public final int zzabt() throws IOException {
        return zzacc();
    }

    public final int zzabu() throws IOException {
        return zzacc();
    }

    public final int zzabv() throws IOException {
        return zzace();
    }

    public final long zzabw() throws IOException {
        return zzacf();
    }

    public final int zzabx() throws IOException {
        return zzbu(zzacc());
    }

    public final long zzaby() throws IOException {
        return zzl(zzacd());
    }

    /* access modifiers changed from: package-private */
    public final long zzabz() throws IOException {
        long j = 0;
        int i = 0;
        while (i < 64) {
            byte zzach = zzach();
            long j2 = j | (((long) (zzach & Byte.MAX_VALUE)) << i);
            if ((zzach & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw zzbbu.zzadn();
    }

    public final boolean zzaca() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzacb() {
        return this.pos - this.zzdqf;
    }

    public final void zzbp(int i) throws zzbbu {
        if (this.zzdqg != i) {
            throw zzbbu.zzadp();
        }
    }

    public final boolean zzbq(int i) throws IOException {
        int zzabk;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzbbu.zzadn();
                }
                while (i2 < 10) {
                    if (zzach() < 0) {
                        i2++;
                    }
                }
                throw zzbbu.zzadn();
                return true;
            case 1:
                zzbt(8);
                return true;
            case 2:
                zzbt(zzacc());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzbt(4);
                return true;
            default:
                throw zzbbu.zzadq();
        }
        do {
            zzabk = zzabk();
            if (zzabk == 0 || !zzbq(zzabk)) {
                zzbp(((i >>> 3) << 3) | 4);
                return true;
            }
            zzabk = zzabk();
            zzbp(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzbq(zzabk));
        zzbp(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzbr(int i) throws zzbbu {
        if (i < 0) {
            throw zzbbu.zzadm();
        }
        int zzacb = i + zzacb();
        int i2 = this.zzdqh;
        if (zzacb > i2) {
            throw zzbbu.zzadl();
        }
        this.zzdqh = zzacb;
        zzacg();
        return i2;
    }

    public final void zzbs(int i) {
        this.zzdqh = i;
        zzacg();
    }

    public final void zzbt(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzbbu.zzadm();
        } else {
            throw zzbbu.zzadl();
        }
    }
}
