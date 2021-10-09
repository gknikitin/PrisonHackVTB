package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzabx {
    private final byte[] buffer;
    private int zzbrn = 64;
    private int zzbro = 67108864;
    private int zzbrs;
    private int zzbru = Integer.MAX_VALUE;
    private final int zzbwz;
    private final int zzbxa;
    private int zzbxb;
    private int zzbxc;
    private int zzbxd;
    private int zzbxe;

    private zzabx(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbwz = i;
        int i3 = i2 + i;
        this.zzbxb = i3;
        this.zzbxa = i3;
        this.zzbxc = i;
    }

    public static zzabx zza(byte[] bArr, int i, int i2) {
        return new zzabx(bArr, 0, i2);
    }

    private final void zzan(int i) throws IOException {
        if (i < 0) {
            throw zzacf.zzvr();
        } else if (this.zzbxc + i > this.zzbru) {
            zzan(this.zzbru - this.zzbxc);
            throw zzacf.zzvq();
        } else if (i <= this.zzbxb - this.zzbxc) {
            this.zzbxc += i;
        } else {
            throw zzacf.zzvq();
        }
    }

    public static zzabx zzi(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private final void zztj() {
        this.zzbxb += this.zzbrs;
        int i = this.zzbxb;
        if (i > this.zzbru) {
            this.zzbrs = i - this.zzbru;
            this.zzbxb -= this.zzbrs;
            return;
        }
        this.zzbrs = 0;
    }

    private final byte zzvm() throws IOException {
        if (this.zzbxc == this.zzbxb) {
            throw zzacf.zzvq();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbxc;
        this.zzbxc = i + 1;
        return bArr[i];
    }

    public final int getPosition() {
        return this.zzbxc - this.zzbwz;
    }

    public final String readString() throws IOException {
        int zzvh = zzvh();
        if (zzvh < 0) {
            throw zzacf.zzvr();
        } else if (zzvh > this.zzbxb - this.zzbxc) {
            throw zzacf.zzvq();
        } else {
            String str = new String(this.buffer, this.zzbxc, zzvh, zzace.UTF_8);
            this.zzbxc += zzvh;
            return str;
        }
    }

    public final void zza(zzacg zzacg) throws IOException {
        int zzvh = zzvh();
        if (this.zzbxe >= this.zzbrn) {
            throw zzacf.zzvt();
        }
        int zzaf = zzaf(zzvh);
        this.zzbxe++;
        zzacg.zzb(this);
        zzaj(0);
        this.zzbxe--;
        zzal(zzaf);
    }

    public final void zza(zzacg zzacg, int i) throws IOException {
        if (this.zzbxe >= this.zzbrn) {
            throw zzacf.zzvt();
        }
        this.zzbxe++;
        zzacg.zzb(this);
        zzaj((i << 3) | 4);
        this.zzbxe--;
    }

    public final int zzaf(int i) throws zzacf {
        if (i < 0) {
            throw zzacf.zzvr();
        }
        int i2 = i + this.zzbxc;
        int i3 = this.zzbru;
        if (i2 > i3) {
            throw zzacf.zzvq();
        }
        this.zzbru = i2;
        zztj();
        return i3;
    }

    public final void zzaj(int i) throws zzacf {
        if (this.zzbxd != i) {
            throw new zzacf("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzak(int i) throws IOException {
        int zzvf;
        switch (i & 7) {
            case 0:
                zzvh();
                return true;
            case 1:
                zzvk();
                return true;
            case 2:
                zzan(zzvh());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzvj();
                return true;
            default:
                throw new zzacf("Protocol message tag had invalid wire type.");
        }
        do {
            zzvf = zzvf();
            if (zzvf == 0 || !zzak(zzvf)) {
                zzaj(((i >>> 3) << 3) | 4);
                return true;
            }
            zzvf = zzvf();
            zzaj(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzak(zzvf));
        zzaj(((i >>> 3) << 3) | 4);
        return true;
    }

    public final void zzal(int i) {
        this.zzbru = i;
        zztj();
    }

    public final void zzam(int i) {
        zzd(i, this.zzbxd);
    }

    public final byte[] zzc(int i, int i2) {
        if (i2 == 0) {
            return zzacj.zzbyc;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbwz + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, int i2) {
        if (i > this.zzbxc - this.zzbwz) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(this.zzbxc - this.zzbwz);
            throw new IllegalArgumentException(sb.toString());
        } else if (i < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            this.zzbxc = this.zzbwz + i;
            this.zzbxd = i2;
        }
    }

    public final int zzvf() throws IOException {
        if (this.zzbxc == this.zzbxb) {
            this.zzbxd = 0;
            return 0;
        }
        this.zzbxd = zzvh();
        if (this.zzbxd != 0) {
            return this.zzbxd;
        }
        throw new zzacf("Protocol message contained an invalid tag (zero).");
    }

    public final boolean zzvg() throws IOException {
        return zzvh() != 0;
    }

    public final int zzvh() throws IOException {
        int i;
        byte zzvm = zzvm();
        if (zzvm >= 0) {
            return zzvm;
        }
        byte b = zzvm & Byte.MAX_VALUE;
        byte zzvm2 = zzvm();
        if (zzvm2 >= 0) {
            i = zzvm2 << 7;
        } else {
            b |= (zzvm2 & Byte.MAX_VALUE) << 7;
            byte zzvm3 = zzvm();
            if (zzvm3 >= 0) {
                i = zzvm3 << 14;
            } else {
                b |= (zzvm3 & Byte.MAX_VALUE) << 14;
                byte zzvm4 = zzvm();
                if (zzvm4 >= 0) {
                    i = zzvm4 << 21;
                } else {
                    byte b2 = b | ((zzvm4 & Byte.MAX_VALUE) << 21);
                    byte zzvm5 = zzvm();
                    byte b3 = b2 | (zzvm5 << 28);
                    if (zzvm5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (zzvm() >= 0) {
                            return b3;
                        }
                    }
                    throw zzacf.zzvs();
                }
            }
        }
        return b | i;
    }

    public final long zzvi() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            byte zzvm = zzvm();
            long j2 = j | (((long) (zzvm & Byte.MAX_VALUE)) << i);
            if ((zzvm & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw zzacf.zzvs();
    }

    public final int zzvj() throws IOException {
        return (zzvm() & 255) | ((zzvm() & 255) << 8) | ((zzvm() & 255) << 16) | ((zzvm() & 255) << 24);
    }

    public final long zzvk() throws IOException {
        return (((long) zzvm()) & 255) | ((((long) zzvm()) & 255) << 8) | ((((long) zzvm()) & 255) << 16) | ((((long) zzvm()) & 255) << 24) | ((((long) zzvm()) & 255) << 32) | ((((long) zzvm()) & 255) << 40) | ((((long) zzvm()) & 255) << 48) | ((((long) zzvm()) & 255) << 56);
    }

    public final int zzvl() {
        if (this.zzbru == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbru - this.zzbxc;
    }
}
