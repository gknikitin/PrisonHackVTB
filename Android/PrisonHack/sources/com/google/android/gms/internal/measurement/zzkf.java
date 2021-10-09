package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkf extends zzaca<zzkf> {
    private static volatile zzkf[] zzarw;
    public Integer zzarx = null;
    public zzkj[] zzary = zzkj.zzlq();
    public zzkg[] zzarz = zzkg.zzlo();

    public zzkf() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzkf[] zzln() {
        if (zzarw == null) {
            synchronized (zzace.zzbxq) {
                if (zzarw == null) {
                    zzarw = new zzkf[0];
                }
            }
        }
        return zzarw;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf zzkf = (zzkf) obj;
        if (this.zzarx == null) {
            if (zzkf.zzarx != null) {
                return false;
            }
        } else if (!this.zzarx.equals(zzkf.zzarx)) {
            return false;
        }
        if (zzace.equals((Object[]) this.zzary, (Object[]) zzkf.zzary) && zzace.equals((Object[]) this.zzarz, (Object[]) zzkf.zzarz)) {
            return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkf.zzbxg == null || zzkf.zzbxg.isEmpty() : this.zzbxg.equals(zzkf.zzbxg);
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + (this.zzarx == null ? 0 : this.zzarx.hashCode())) * 31) + zzace.hashCode((Object[]) this.zzary)) * 31) + zzace.hashCode((Object[]) this.zzarz)) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzarx != null) {
            zza += zzaby.zzf(1, this.zzarx.intValue());
        }
        if (this.zzary != null && this.zzary.length > 0) {
            int i = zza;
            for (zzkj zzkj : this.zzary) {
                if (zzkj != null) {
                    i += zzaby.zzb(2, (zzacg) zzkj);
                }
            }
            zza = i;
        }
        if (this.zzarz != null && this.zzarz.length > 0) {
            for (zzkg zzkg : this.zzarz) {
                if (zzkg != null) {
                    zza += zzaby.zzb(3, (zzacg) zzkg);
                }
            }
        }
        return zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzarx != null) {
            zzaby.zze(1, this.zzarx.intValue());
        }
        if (this.zzary != null && this.zzary.length > 0) {
            for (zzkj zzkj : this.zzary) {
                if (zzkj != null) {
                    zzaby.zza(2, (zzacg) zzkj);
                }
            }
        }
        if (this.zzarz != null && this.zzarz.length > 0) {
            for (zzkg zzkg : this.zzarz) {
                if (zzkg != null) {
                    zzaby.zza(3, (zzacg) zzkg);
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
                this.zzarx = Integer.valueOf(zzabx.zzvh());
            } else if (zzvf == 18) {
                int zzb = zzacj.zzb(zzabx, 18);
                int length = this.zzary == null ? 0 : this.zzary.length;
                zzkj[] zzkjArr = new zzkj[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzary, 0, zzkjArr, 0, length);
                }
                while (length < zzkjArr.length - 1) {
                    zzkjArr[length] = new zzkj();
                    zzabx.zza(zzkjArr[length]);
                    zzabx.zzvf();
                    length++;
                }
                zzkjArr[length] = new zzkj();
                zzabx.zza(zzkjArr[length]);
                this.zzary = zzkjArr;
            } else if (zzvf == 26) {
                int zzb2 = zzacj.zzb(zzabx, 26);
                int length2 = this.zzarz == null ? 0 : this.zzarz.length;
                zzkg[] zzkgArr = new zzkg[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzarz, 0, zzkgArr, 0, length2);
                }
                while (length2 < zzkgArr.length - 1) {
                    zzkgArr[length2] = new zzkg();
                    zzabx.zza(zzkgArr[length2]);
                    zzabx.zzvf();
                    length2++;
                }
                zzkgArr[length2] = new zzkg();
                zzabx.zza(zzkgArr[length2]);
                this.zzarz = zzkgArr;
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
