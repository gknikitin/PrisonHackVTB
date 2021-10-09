package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzki extends zzaca<zzki> {
    public Integer zzasl = null;
    public Boolean zzasm = null;
    public String zzasn = null;
    public String zzaso = null;
    public String zzasp = null;

    public zzki() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzki zzb(zzabx zzabx) throws IOException {
        int zzvh;
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf == 8) {
                try {
                    zzvh = zzabx.zzvh();
                    if (zzvh < 0 || zzvh > 4) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzvh);
                        sb.append(" is not a valid enum ComparisonType");
                    } else {
                        this.zzasl = Integer.valueOf(zzvh);
                    }
                } catch (IllegalArgumentException unused) {
                    zzabx.zzam(zzabx.getPosition());
                    zza(zzabx, zzvf);
                }
            } else if (zzvf == 16) {
                this.zzasm = Boolean.valueOf(zzabx.zzvg());
            } else if (zzvf == 26) {
                this.zzasn = zzabx.readString();
            } else if (zzvf == 34) {
                this.zzaso = zzabx.readString();
            } else if (zzvf == 42) {
                this.zzasp = zzabx.readString();
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzvh);
        sb2.append(" is not a valid enum ComparisonType");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzki)) {
            return false;
        }
        zzki zzki = (zzki) obj;
        if (this.zzasl == null) {
            if (zzki.zzasl != null) {
                return false;
            }
        } else if (!this.zzasl.equals(zzki.zzasl)) {
            return false;
        }
        if (this.zzasm == null) {
            if (zzki.zzasm != null) {
                return false;
            }
        } else if (!this.zzasm.equals(zzki.zzasm)) {
            return false;
        }
        if (this.zzasn == null) {
            if (zzki.zzasn != null) {
                return false;
            }
        } else if (!this.zzasn.equals(zzki.zzasn)) {
            return false;
        }
        if (this.zzaso == null) {
            if (zzki.zzaso != null) {
                return false;
            }
        } else if (!this.zzaso.equals(zzki.zzaso)) {
            return false;
        }
        if (this.zzasp == null) {
            if (zzki.zzasp != null) {
                return false;
            }
        } else if (!this.zzasp.equals(zzki.zzasp)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzki.zzbxg == null || zzki.zzbxg.isEmpty() : this.zzbxg.equals(zzki.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzasl == null ? 0 : this.zzasl.intValue())) * 31) + (this.zzasm == null ? 0 : this.zzasm.hashCode())) * 31) + (this.zzasn == null ? 0 : this.zzasn.hashCode())) * 31) + (this.zzaso == null ? 0 : this.zzaso.hashCode())) * 31) + (this.zzasp == null ? 0 : this.zzasp.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzasl != null) {
            zza += zzaby.zzf(1, this.zzasl.intValue());
        }
        if (this.zzasm != null) {
            this.zzasm.booleanValue();
            zza += zzaby.zzaq(2) + 1;
        }
        if (this.zzasn != null) {
            zza += zzaby.zzc(3, this.zzasn);
        }
        if (this.zzaso != null) {
            zza += zzaby.zzc(4, this.zzaso);
        }
        return this.zzasp != null ? zza + zzaby.zzc(5, this.zzasp) : zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzasl != null) {
            zzaby.zze(1, this.zzasl.intValue());
        }
        if (this.zzasm != null) {
            zzaby.zza(2, this.zzasm.booleanValue());
        }
        if (this.zzasn != null) {
            zzaby.zzb(3, this.zzasn);
        }
        if (this.zzaso != null) {
            zzaby.zzb(4, this.zzaso);
        }
        if (this.zzasp != null) {
            zzaby.zzb(5, this.zzasp);
        }
        super.zza(zzaby);
    }
}
