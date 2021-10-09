package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkm extends zzaca<zzkm> {
    public String zzadm = null;
    public Long zzatb = null;
    private Integer zzatc = null;
    public zzkn[] zzatd = zzkn.zzls();
    public zzkl[] zzate = zzkl.zzlr();
    public zzkf[] zzatf = zzkf.zzln();

    public zzkm() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkm)) {
            return false;
        }
        zzkm zzkm = (zzkm) obj;
        if (this.zzatb == null) {
            if (zzkm.zzatb != null) {
                return false;
            }
        } else if (!this.zzatb.equals(zzkm.zzatb)) {
            return false;
        }
        if (this.zzadm == null) {
            if (zzkm.zzadm != null) {
                return false;
            }
        } else if (!this.zzadm.equals(zzkm.zzadm)) {
            return false;
        }
        if (this.zzatc == null) {
            if (zzkm.zzatc != null) {
                return false;
            }
        } else if (!this.zzatc.equals(zzkm.zzatc)) {
            return false;
        }
        if (zzace.equals((Object[]) this.zzatd, (Object[]) zzkm.zzatd) && zzace.equals((Object[]) this.zzate, (Object[]) zzkm.zzate) && zzace.equals((Object[]) this.zzatf, (Object[]) zzkm.zzatf)) {
            return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkm.zzbxg == null || zzkm.zzbxg.isEmpty() : this.zzbxg.equals(zzkm.zzbxg);
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzatb == null ? 0 : this.zzatb.hashCode())) * 31) + (this.zzadm == null ? 0 : this.zzadm.hashCode())) * 31) + (this.zzatc == null ? 0 : this.zzatc.hashCode())) * 31) + zzace.hashCode((Object[]) this.zzatd)) * 31) + zzace.hashCode((Object[]) this.zzate)) * 31) + zzace.hashCode((Object[]) this.zzatf)) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzatb != null) {
            zza += zzaby.zzc(1, this.zzatb.longValue());
        }
        if (this.zzadm != null) {
            zza += zzaby.zzc(2, this.zzadm);
        }
        if (this.zzatc != null) {
            zza += zzaby.zzf(3, this.zzatc.intValue());
        }
        if (this.zzatd != null && this.zzatd.length > 0) {
            int i = zza;
            for (zzkn zzkn : this.zzatd) {
                if (zzkn != null) {
                    i += zzaby.zzb(4, (zzacg) zzkn);
                }
            }
            zza = i;
        }
        if (this.zzate != null && this.zzate.length > 0) {
            int i2 = zza;
            for (zzkl zzkl : this.zzate) {
                if (zzkl != null) {
                    i2 += zzaby.zzb(5, (zzacg) zzkl);
                }
            }
            zza = i2;
        }
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzkf zzkf : this.zzatf) {
                if (zzkf != null) {
                    zza += zzaby.zzb(6, (zzacg) zzkf);
                }
            }
        }
        return zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzatb != null) {
            zzaby.zzb(1, this.zzatb.longValue());
        }
        if (this.zzadm != null) {
            zzaby.zzb(2, this.zzadm);
        }
        if (this.zzatc != null) {
            zzaby.zze(3, this.zzatc.intValue());
        }
        if (this.zzatd != null && this.zzatd.length > 0) {
            for (zzkn zzkn : this.zzatd) {
                if (zzkn != null) {
                    zzaby.zza(4, (zzacg) zzkn);
                }
            }
        }
        if (this.zzate != null && this.zzate.length > 0) {
            for (zzkl zzkl : this.zzate) {
                if (zzkl != null) {
                    zzaby.zza(5, (zzacg) zzkl);
                }
            }
        }
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzkf zzkf : this.zzatf) {
                if (zzkf != null) {
                    zzaby.zza(6, (zzacg) zzkf);
                }
            }
        }
        super.zza(zzaby);
    }

    public final /* synthetic */ zzacg zzb(zzabx zzabx) throws IOException {
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf == 8) {
                this.zzatb = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 18) {
                this.zzadm = zzabx.readString();
            } else if (zzvf == 24) {
                this.zzatc = Integer.valueOf(zzabx.zzvh());
            } else if (zzvf == 34) {
                int zzb = zzacj.zzb(zzabx, 34);
                int length = this.zzatd == null ? 0 : this.zzatd.length;
                zzkn[] zzknArr = new zzkn[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzatd, 0, zzknArr, 0, length);
                }
                while (length < zzknArr.length - 1) {
                    zzknArr[length] = new zzkn();
                    zzabx.zza(zzknArr[length]);
                    zzabx.zzvf();
                    length++;
                }
                zzknArr[length] = new zzkn();
                zzabx.zza(zzknArr[length]);
                this.zzatd = zzknArr;
            } else if (zzvf == 42) {
                int zzb2 = zzacj.zzb(zzabx, 42);
                int length2 = this.zzate == null ? 0 : this.zzate.length;
                zzkl[] zzklArr = new zzkl[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzate, 0, zzklArr, 0, length2);
                }
                while (length2 < zzklArr.length - 1) {
                    zzklArr[length2] = new zzkl();
                    zzabx.zza(zzklArr[length2]);
                    zzabx.zzvf();
                    length2++;
                }
                zzklArr[length2] = new zzkl();
                zzabx.zza(zzklArr[length2]);
                this.zzate = zzklArr;
            } else if (zzvf == 50) {
                int zzb3 = zzacj.zzb(zzabx, 50);
                int length3 = this.zzatf == null ? 0 : this.zzatf.length;
                zzkf[] zzkfArr = new zzkf[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzatf, 0, zzkfArr, 0, length3);
                }
                while (length3 < zzkfArr.length - 1) {
                    zzkfArr[length3] = new zzkf();
                    zzabx.zza(zzkfArr[length3]);
                    zzabx.zzvf();
                    length3++;
                }
                zzkfArr[length3] = new zzkf();
                zzabx.zza(zzkfArr[length3]);
                this.zzatf = zzkfArr;
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
