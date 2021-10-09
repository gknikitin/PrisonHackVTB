package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkh extends zzaca<zzkh> {
    private static volatile zzkh[] zzasg;
    public zzkk zzash = null;
    public zzki zzasi = null;
    public Boolean zzasj = null;
    public String zzask = null;

    public zzkh() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzkh[] zzlp() {
        if (zzasg == null) {
            synchronized (zzace.zzbxq) {
                if (zzasg == null) {
                    zzasg = new zzkh[0];
                }
            }
        }
        return zzasg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return false;
        }
        zzkh zzkh = (zzkh) obj;
        if (this.zzash == null) {
            if (zzkh.zzash != null) {
                return false;
            }
        } else if (!this.zzash.equals(zzkh.zzash)) {
            return false;
        }
        if (this.zzasi == null) {
            if (zzkh.zzasi != null) {
                return false;
            }
        } else if (!this.zzasi.equals(zzkh.zzasi)) {
            return false;
        }
        if (this.zzasj == null) {
            if (zzkh.zzasj != null) {
                return false;
            }
        } else if (!this.zzasj.equals(zzkh.zzasj)) {
            return false;
        }
        if (this.zzask == null) {
            if (zzkh.zzask != null) {
                return false;
            }
        } else if (!this.zzask.equals(zzkh.zzask)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkh.zzbxg == null || zzkh.zzbxg.isEmpty() : this.zzbxg.equals(zzkh.zzbxg);
    }

    public final int hashCode() {
        zzkk zzkk = this.zzash;
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (zzkk == null ? 0 : zzkk.hashCode());
        zzki zzki = this.zzasi;
        int hashCode2 = ((((((hashCode * 31) + (zzki == null ? 0 : zzki.hashCode())) * 31) + (this.zzasj == null ? 0 : this.zzasj.hashCode())) * 31) + (this.zzask == null ? 0 : this.zzask.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode2 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzash != null) {
            zza += zzaby.zzb(1, (zzacg) this.zzash);
        }
        if (this.zzasi != null) {
            zza += zzaby.zzb(2, (zzacg) this.zzasi);
        }
        if (this.zzasj != null) {
            this.zzasj.booleanValue();
            zza += zzaby.zzaq(3) + 1;
        }
        return this.zzask != null ? zza + zzaby.zzc(4, this.zzask) : zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzash != null) {
            zzaby.zza(1, (zzacg) this.zzash);
        }
        if (this.zzasi != null) {
            zzaby.zza(2, (zzacg) this.zzasi);
        }
        if (this.zzasj != null) {
            zzaby.zza(3, this.zzasj.booleanValue());
        }
        if (this.zzask != null) {
            zzaby.zzb(4, this.zzask);
        }
        super.zza(zzaby);
    }

    public final /* synthetic */ zzacg zzb(zzabx zzabx) throws IOException {
        zzacg zzacg;
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf == 10) {
                if (this.zzash == null) {
                    this.zzash = new zzkk();
                }
                zzacg = this.zzash;
            } else if (zzvf == 18) {
                if (this.zzasi == null) {
                    this.zzasi = new zzki();
                }
                zzacg = this.zzasi;
            } else if (zzvf == 24) {
                this.zzasj = Boolean.valueOf(zzabx.zzvg());
            } else if (zzvf == 34) {
                this.zzask = zzabx.readString();
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
            zzabx.zza(zzacg);
        }
    }
}
