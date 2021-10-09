package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkq extends zzaca<zzkq> {
    private static volatile zzkq[] zzatp;
    public String name = null;
    public String zzajo = null;
    private Float zzarn = null;
    public Double zzaro = null;
    public Long zzatq = null;

    public zzkq() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzkq[] zzlv() {
        if (zzatp == null) {
            synchronized (zzace.zzbxq) {
                if (zzatp == null) {
                    zzatp = new zzkq[0];
                }
            }
        }
        return zzatp;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkq)) {
            return false;
        }
        zzkq zzkq = (zzkq) obj;
        if (this.name == null) {
            if (zzkq.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzkq.name)) {
            return false;
        }
        if (this.zzajo == null) {
            if (zzkq.zzajo != null) {
                return false;
            }
        } else if (!this.zzajo.equals(zzkq.zzajo)) {
            return false;
        }
        if (this.zzatq == null) {
            if (zzkq.zzatq != null) {
                return false;
            }
        } else if (!this.zzatq.equals(zzkq.zzatq)) {
            return false;
        }
        if (this.zzarn == null) {
            if (zzkq.zzarn != null) {
                return false;
            }
        } else if (!this.zzarn.equals(zzkq.zzarn)) {
            return false;
        }
        if (this.zzaro == null) {
            if (zzkq.zzaro != null) {
                return false;
            }
        } else if (!this.zzaro.equals(zzkq.zzaro)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkq.zzbxg == null || zzkq.zzbxg.isEmpty() : this.zzbxg.equals(zzkq.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzajo == null ? 0 : this.zzajo.hashCode())) * 31) + (this.zzatq == null ? 0 : this.zzatq.hashCode())) * 31) + (this.zzarn == null ? 0 : this.zzarn.hashCode())) * 31) + (this.zzaro == null ? 0 : this.zzaro.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.name != null) {
            zza += zzaby.zzc(1, this.name);
        }
        if (this.zzajo != null) {
            zza += zzaby.zzc(2, this.zzajo);
        }
        if (this.zzatq != null) {
            zza += zzaby.zzc(3, this.zzatq.longValue());
        }
        if (this.zzarn != null) {
            this.zzarn.floatValue();
            zza += zzaby.zzaq(4) + 4;
        }
        if (this.zzaro == null) {
            return zza;
        }
        this.zzaro.doubleValue();
        return zza + zzaby.zzaq(5) + 8;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.name != null) {
            zzaby.zzb(1, this.name);
        }
        if (this.zzajo != null) {
            zzaby.zzb(2, this.zzajo);
        }
        if (this.zzatq != null) {
            zzaby.zzb(3, this.zzatq.longValue());
        }
        if (this.zzarn != null) {
            zzaby.zza(4, this.zzarn.floatValue());
        }
        if (this.zzaro != null) {
            zzaby.zza(5, this.zzaro.doubleValue());
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
                this.name = zzabx.readString();
            } else if (zzvf == 18) {
                this.zzajo = zzabx.readString();
            } else if (zzvf == 24) {
                this.zzatq = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 37) {
                this.zzarn = Float.valueOf(Float.intBitsToFloat(zzabx.zzvj()));
            } else if (zzvf == 41) {
                this.zzaro = Double.valueOf(Double.longBitsToDouble(zzabx.zzvk()));
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
