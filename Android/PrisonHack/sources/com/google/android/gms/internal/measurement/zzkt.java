package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkt extends zzaca<zzkt> {
    public long[] zzauw = zzacj.zzbxw;
    public long[] zzaux = zzacj.zzbxw;

    public zzkt() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkt)) {
            return false;
        }
        zzkt zzkt = (zzkt) obj;
        if (zzace.equals(this.zzauw, zzkt.zzauw) && zzace.equals(this.zzaux, zzkt.zzaux)) {
            return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkt.zzbxg == null || zzkt.zzbxg.isEmpty() : this.zzbxg.equals(zzkt.zzbxg);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((getClass().getName().hashCode() + 527) * 31) + zzace.hashCode(this.zzauw)) * 31) + zzace.hashCode(this.zzaux)) * 31) + ((this.zzbxg == null || this.zzbxg.isEmpty()) ? 0 : this.zzbxg.hashCode());
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzauw != null && this.zzauw.length > 0) {
            int i = 0;
            for (long zzao : this.zzauw) {
                i += zzaby.zzao(zzao);
            }
            zza = zza + i + (this.zzauw.length * 1);
        }
        if (this.zzaux == null || this.zzaux.length <= 0) {
            return zza;
        }
        int i2 = 0;
        for (long zzao2 : this.zzaux) {
            i2 += zzaby.zzao(zzao2);
        }
        return zza + i2 + (this.zzaux.length * 1);
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzauw != null && this.zzauw.length > 0) {
            for (long zza : this.zzauw) {
                zzaby.zza(1, zza);
            }
        }
        if (this.zzaux != null && this.zzaux.length > 0) {
            for (long zza2 : this.zzaux) {
                zzaby.zza(2, zza2);
            }
        }
        super.zza(zzaby);
    }

    public final /* synthetic */ zzacg zzb(zzabx zzabx) throws IOException {
        int i;
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf != 8) {
                if (zzvf == 10) {
                    i = zzabx.zzaf(zzabx.zzvh());
                    int position = zzabx.getPosition();
                    int i2 = 0;
                    while (zzabx.zzvl() > 0) {
                        zzabx.zzvi();
                        i2++;
                    }
                    zzabx.zzam(position);
                    int length = this.zzauw == null ? 0 : this.zzauw.length;
                    long[] jArr = new long[(i2 + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzauw, 0, jArr, 0, length);
                    }
                    while (length < jArr.length) {
                        jArr[length] = zzabx.zzvi();
                        length++;
                    }
                    this.zzauw = jArr;
                } else if (zzvf == 16) {
                    int zzb = zzacj.zzb(zzabx, 16);
                    int length2 = this.zzaux == null ? 0 : this.zzaux.length;
                    long[] jArr2 = new long[(zzb + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaux, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length - 1) {
                        jArr2[length2] = zzabx.zzvi();
                        zzabx.zzvf();
                        length2++;
                    }
                    jArr2[length2] = zzabx.zzvi();
                    this.zzaux = jArr2;
                } else if (zzvf == 18) {
                    i = zzabx.zzaf(zzabx.zzvh());
                    int position2 = zzabx.getPosition();
                    int i3 = 0;
                    while (zzabx.zzvl() > 0) {
                        zzabx.zzvi();
                        i3++;
                    }
                    zzabx.zzam(position2);
                    int length3 = this.zzaux == null ? 0 : this.zzaux.length;
                    long[] jArr3 = new long[(i3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaux, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length) {
                        jArr3[length3] = zzabx.zzvi();
                        length3++;
                    }
                    this.zzaux = jArr3;
                } else if (!super.zza(zzabx, zzvf)) {
                    return this;
                }
                zzabx.zzal(i);
            } else {
                int zzb2 = zzacj.zzb(zzabx, 8);
                int length4 = this.zzauw == null ? 0 : this.zzauw.length;
                long[] jArr4 = new long[(zzb2 + length4)];
                if (length4 != 0) {
                    System.arraycopy(this.zzauw, 0, jArr4, 0, length4);
                }
                while (length4 < jArr4.length - 1) {
                    jArr4[length4] = zzabx.zzvi();
                    zzabx.zzvf();
                    length4++;
                }
                jArr4[length4] = zzabx.zzvi();
                this.zzauw = jArr4;
            }
        }
    }
}
