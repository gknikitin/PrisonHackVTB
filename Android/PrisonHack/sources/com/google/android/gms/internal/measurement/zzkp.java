package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkp extends zzaca<zzkp> {
    private static volatile zzkp[] zzatl;
    public Integer count = null;
    public String name = null;
    public zzkq[] zzatm = zzkq.zzlv();
    public Long zzatn = null;
    public Long zzato = null;

    public zzkp() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzkp[] zzlu() {
        if (zzatl == null) {
            synchronized (zzace.zzbxq) {
                if (zzatl == null) {
                    zzatl = new zzkp[0];
                }
            }
        }
        return zzatl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp zzkp = (zzkp) obj;
        if (!zzace.equals((Object[]) this.zzatm, (Object[]) zzkp.zzatm)) {
            return false;
        }
        if (this.name == null) {
            if (zzkp.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzkp.name)) {
            return false;
        }
        if (this.zzatn == null) {
            if (zzkp.zzatn != null) {
                return false;
            }
        } else if (!this.zzatn.equals(zzkp.zzatn)) {
            return false;
        }
        if (this.zzato == null) {
            if (zzkp.zzato != null) {
                return false;
            }
        } else if (!this.zzato.equals(zzkp.zzato)) {
            return false;
        }
        if (this.count == null) {
            if (zzkp.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzkp.count)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkp.zzbxg == null || zzkp.zzbxg.isEmpty() : this.zzbxg.equals(zzkp.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + zzace.hashCode((Object[]) this.zzatm)) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzatn == null ? 0 : this.zzatn.hashCode())) * 31) + (this.zzato == null ? 0 : this.zzato.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzatm != null && this.zzatm.length > 0) {
            for (zzkq zzkq : this.zzatm) {
                if (zzkq != null) {
                    zza += zzaby.zzb(1, (zzacg) zzkq);
                }
            }
        }
        if (this.name != null) {
            zza += zzaby.zzc(2, this.name);
        }
        if (this.zzatn != null) {
            zza += zzaby.zzc(3, this.zzatn.longValue());
        }
        if (this.zzato != null) {
            zza += zzaby.zzc(4, this.zzato.longValue());
        }
        return this.count != null ? zza + zzaby.zzf(5, this.count.intValue()) : zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzatm != null && this.zzatm.length > 0) {
            for (zzkq zzkq : this.zzatm) {
                if (zzkq != null) {
                    zzaby.zza(1, (zzacg) zzkq);
                }
            }
        }
        if (this.name != null) {
            zzaby.zzb(2, this.name);
        }
        if (this.zzatn != null) {
            zzaby.zzb(3, this.zzatn.longValue());
        }
        if (this.zzato != null) {
            zzaby.zzb(4, this.zzato.longValue());
        }
        if (this.count != null) {
            zzaby.zze(5, this.count.intValue());
        }
        super.zza(zzaby);
    }

    public final /* synthetic */ zzacg zzb(zzabx zzabx) throws IOException {
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf == 10) {
                int zzb = zzacj.zzb(zzabx, 10);
                int length = this.zzatm == null ? 0 : this.zzatm.length;
                zzkq[] zzkqArr = new zzkq[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzatm, 0, zzkqArr, 0, length);
                }
                while (length < zzkqArr.length - 1) {
                    zzkqArr[length] = new zzkq();
                    zzabx.zza(zzkqArr[length]);
                    zzabx.zzvf();
                    length++;
                }
                zzkqArr[length] = new zzkq();
                zzabx.zza(zzkqArr[length]);
                this.zzatm = zzkqArr;
            } else if (zzvf == 18) {
                this.name = zzabx.readString();
            } else if (zzvf == 24) {
                this.zzatn = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 32) {
                this.zzato = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 40) {
                this.count = Integer.valueOf(zzabx.zzvh());
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
