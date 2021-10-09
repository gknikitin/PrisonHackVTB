package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkk extends zzaca<zzkk> {
    public Integer zzast = null;
    public String zzasu = null;
    public Boolean zzasv = null;
    public String[] zzasw = zzacj.zzbya;

    public zzkk() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final zzkk zzb(zzabx zzabx) throws IOException {
        int zzvh;
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf == 8) {
                try {
                    zzvh = zzabx.zzvh();
                    if (zzvh < 0 || zzvh > 6) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzvh);
                        sb.append(" is not a valid enum MatchType");
                    } else {
                        this.zzast = Integer.valueOf(zzvh);
                    }
                } catch (IllegalArgumentException unused) {
                    zzabx.zzam(zzabx.getPosition());
                    zza(zzabx, zzvf);
                }
            } else if (zzvf == 18) {
                this.zzasu = zzabx.readString();
            } else if (zzvf == 24) {
                this.zzasv = Boolean.valueOf(zzabx.zzvg());
            } else if (zzvf == 34) {
                int zzb = zzacj.zzb(zzabx, 34);
                int length = this.zzasw == null ? 0 : this.zzasw.length;
                String[] strArr = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzasw, 0, strArr, 0, length);
                }
                while (length < strArr.length - 1) {
                    strArr[length] = zzabx.readString();
                    zzabx.zzvf();
                    length++;
                }
                strArr[length] = zzabx.readString();
                this.zzasw = strArr;
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append(zzvh);
        sb2.append(" is not a valid enum MatchType");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkk)) {
            return false;
        }
        zzkk zzkk = (zzkk) obj;
        if (this.zzast == null) {
            if (zzkk.zzast != null) {
                return false;
            }
        } else if (!this.zzast.equals(zzkk.zzast)) {
            return false;
        }
        if (this.zzasu == null) {
            if (zzkk.zzasu != null) {
                return false;
            }
        } else if (!this.zzasu.equals(zzkk.zzasu)) {
            return false;
        }
        if (this.zzasv == null) {
            if (zzkk.zzasv != null) {
                return false;
            }
        } else if (!this.zzasv.equals(zzkk.zzasv)) {
            return false;
        }
        if (!zzace.equals((Object[]) this.zzasw, (Object[]) zzkk.zzasw)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkk.zzbxg == null || zzkk.zzbxg.isEmpty() : this.zzbxg.equals(zzkk.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzast == null ? 0 : this.zzast.intValue())) * 31) + (this.zzasu == null ? 0 : this.zzasu.hashCode())) * 31) + (this.zzasv == null ? 0 : this.zzasv.hashCode())) * 31) + zzace.hashCode((Object[]) this.zzasw)) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzast != null) {
            zza += zzaby.zzf(1, this.zzast.intValue());
        }
        if (this.zzasu != null) {
            zza += zzaby.zzc(2, this.zzasu);
        }
        if (this.zzasv != null) {
            this.zzasv.booleanValue();
            zza += zzaby.zzaq(3) + 1;
        }
        if (this.zzasw == null || this.zzasw.length <= 0) {
            return zza;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.zzasw) {
            if (str != null) {
                i2++;
                i += zzaby.zzfk(str);
            }
        }
        return zza + i + (i2 * 1);
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzast != null) {
            zzaby.zze(1, this.zzast.intValue());
        }
        if (this.zzasu != null) {
            zzaby.zzb(2, this.zzasu);
        }
        if (this.zzasv != null) {
            zzaby.zza(3, this.zzasv.booleanValue());
        }
        if (this.zzasw != null && this.zzasw.length > 0) {
            for (String str : this.zzasw) {
                if (str != null) {
                    zzaby.zzb(4, str);
                }
            }
        }
        super.zza(zzaby);
    }
}
