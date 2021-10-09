package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzko extends zzaca<zzko> {
    private static volatile zzko[] zzath;
    public Integer zzarx = null;
    public zzkt zzati = null;
    public zzkt zzatj = null;
    public Boolean zzatk = null;

    public zzko() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public static zzko[] zzlt() {
        if (zzath == null) {
            synchronized (zzace.zzbxq) {
                if (zzath == null) {
                    zzath = new zzko[0];
                }
            }
        }
        return zzath;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzko)) {
            return false;
        }
        zzko zzko = (zzko) obj;
        if (this.zzarx == null) {
            if (zzko.zzarx != null) {
                return false;
            }
        } else if (!this.zzarx.equals(zzko.zzarx)) {
            return false;
        }
        if (this.zzati == null) {
            if (zzko.zzati != null) {
                return false;
            }
        } else if (!this.zzati.equals(zzko.zzati)) {
            return false;
        }
        if (this.zzatj == null) {
            if (zzko.zzatj != null) {
                return false;
            }
        } else if (!this.zzatj.equals(zzko.zzatj)) {
            return false;
        }
        if (this.zzatk == null) {
            if (zzko.zzatk != null) {
                return false;
            }
        } else if (!this.zzatk.equals(zzko.zzatk)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzko.zzbxg == null || zzko.zzbxg.isEmpty() : this.zzbxg.equals(zzko.zzbxg);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.zzarx == null ? 0 : this.zzarx.hashCode());
        zzkt zzkt = this.zzati;
        int hashCode2 = (hashCode * 31) + (zzkt == null ? 0 : zzkt.hashCode());
        zzkt zzkt2 = this.zzatj;
        int hashCode3 = ((((hashCode2 * 31) + (zzkt2 == null ? 0 : zzkt2.hashCode())) * 31) + (this.zzatk == null ? 0 : this.zzatk.hashCode())) * 31;
        if (this.zzbxg != null && !this.zzbxg.isEmpty()) {
            i = this.zzbxg.hashCode();
        }
        return hashCode3 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzarx != null) {
            zza += zzaby.zzf(1, this.zzarx.intValue());
        }
        if (this.zzati != null) {
            zza += zzaby.zzb(2, (zzacg) this.zzati);
        }
        if (this.zzatj != null) {
            zza += zzaby.zzb(3, (zzacg) this.zzatj);
        }
        if (this.zzatk == null) {
            return zza;
        }
        this.zzatk.booleanValue();
        return zza + zzaby.zzaq(4) + 1;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzarx != null) {
            zzaby.zze(1, this.zzarx.intValue());
        }
        if (this.zzati != null) {
            zzaby.zza(2, (zzacg) this.zzati);
        }
        if (this.zzatj != null) {
            zzaby.zza(3, (zzacg) this.zzatj);
        }
        if (this.zzatk != null) {
            zzaby.zza(4, this.zzatk.booleanValue());
        }
        super.zza(zzaby);
    }

    public final /* synthetic */ zzacg zzb(zzabx zzabx) throws IOException {
        zzkt zzkt;
        while (true) {
            int zzvf = zzabx.zzvf();
            if (zzvf == 0) {
                return this;
            }
            if (zzvf != 8) {
                if (zzvf == 18) {
                    if (this.zzati == null) {
                        this.zzati = new zzkt();
                    }
                    zzkt = this.zzati;
                } else if (zzvf == 26) {
                    if (this.zzatj == null) {
                        this.zzatj = new zzkt();
                    }
                    zzkt = this.zzatj;
                } else if (zzvf == 32) {
                    this.zzatk = Boolean.valueOf(zzabx.zzvg());
                } else if (!super.zza(zzabx, zzvf)) {
                    return this;
                }
                zzabx.zza(zzkt);
            } else {
                this.zzarx = Integer.valueOf(zzabx.zzvh());
            }
        }
    }
}
