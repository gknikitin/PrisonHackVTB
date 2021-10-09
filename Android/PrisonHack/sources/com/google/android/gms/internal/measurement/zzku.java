package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzku extends zzaca<zzku> {
    private static volatile zzku[] zzauy;
    public String name = null;
    public String zzajo = null;
    private Float zzarn = null;
    public Double zzaro = null;
    public Long zzatq = null;
    public Long zzauz = null;

    public zzku() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzku[] zzlx() {
        if (zzauy == null) {
            synchronized (zzace.zzbxq) {
                if (zzauy == null) {
                    zzauy = new zzku[0];
                }
            }
        }
        return zzauy;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzku)) {
            return false;
        }
        zzku zzku = (zzku) obj;
        if (this.zzauz == null) {
            if (zzku.zzauz != null) {
                return false;
            }
        } else if (!this.zzauz.equals(zzku.zzauz)) {
            return false;
        }
        if (this.name == null) {
            if (zzku.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzku.name)) {
            return false;
        }
        if (this.zzajo == null) {
            if (zzku.zzajo != null) {
                return false;
            }
        } else if (!this.zzajo.equals(zzku.zzajo)) {
            return false;
        }
        if (this.zzatq == null) {
            if (zzku.zzatq != null) {
                return false;
            }
        } else if (!this.zzatq.equals(zzku.zzatq)) {
            return false;
        }
        if (this.zzarn == null) {
            if (zzku.zzarn != null) {
                return false;
            }
        } else if (!this.zzarn.equals(zzku.zzarn)) {
            return false;
        }
        if (this.zzaro == null) {
            if (zzku.zzaro != null) {
                return false;
            }
        } else if (!this.zzaro.equals(zzku.zzaro)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzku.zzbxg == null || zzku.zzbxg.isEmpty() : this.zzbxg.equals(zzku.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzauz == null ? 0 : this.zzauz.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzajo == null ? 0 : this.zzajo.hashCode())) * 31) + (this.zzatq == null ? 0 : this.zzatq.hashCode())) * 31) + (this.zzarn == null ? 0 : this.zzarn.hashCode())) * 31) + (this.zzaro == null ? 0 : this.zzaro.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzauz != null) {
            zza += zzaby.zzc(1, this.zzauz.longValue());
        }
        if (this.name != null) {
            zza += zzaby.zzc(2, this.name);
        }
        if (this.zzajo != null) {
            zza += zzaby.zzc(3, this.zzajo);
        }
        if (this.zzatq != null) {
            zza += zzaby.zzc(4, this.zzatq.longValue());
        }
        if (this.zzarn != null) {
            this.zzarn.floatValue();
            zza += zzaby.zzaq(5) + 4;
        }
        if (this.zzaro == null) {
            return zza;
        }
        this.zzaro.doubleValue();
        return zza + zzaby.zzaq(6) + 8;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzauz != null) {
            zzaby.zzb(1, this.zzauz.longValue());
        }
        if (this.name != null) {
            zzaby.zzb(2, this.name);
        }
        if (this.zzajo != null) {
            zzaby.zzb(3, this.zzajo);
        }
        if (this.zzatq != null) {
            zzaby.zzb(4, this.zzatq.longValue());
        }
        if (this.zzarn != null) {
            zzaby.zza(5, this.zzarn.floatValue());
        }
        if (this.zzaro != null) {
            zzaby.zza(6, this.zzaro.doubleValue());
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
                this.zzauz = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 18) {
                this.name = zzabx.readString();
            } else if (zzvf == 26) {
                this.zzajo = zzabx.readString();
            } else if (zzvf == 32) {
                this.zzatq = Long.valueOf(zzabx.zzvi());
            } else if (zzvf == 45) {
                this.zzarn = Float.valueOf(Float.intBitsToFloat(zzabx.zzvj()));
            } else if (zzvf == 49) {
                this.zzaro = Double.valueOf(Double.longBitsToDouble(zzabx.zzvk()));
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
