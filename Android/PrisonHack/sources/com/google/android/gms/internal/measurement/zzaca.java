package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaca;
import java.io.IOException;

public abstract class zzaca<M extends zzaca<M>> extends zzacg {
    protected zzacc zzbxg;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaca zzaca = (zzaca) super.clone();
        zzace.zza(this, zzaca);
        return zzaca;
    }

    /* access modifiers changed from: protected */
    public int zza() {
        if (this.zzbxg == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbxg.size(); i2++) {
            i += this.zzbxg.zzau(i2).zza();
        }
        return i;
    }

    public final <T> T zza(zzacb<M, T> zzacb) {
        zzacd zzat;
        if (this.zzbxg == null || (zzat = this.zzbxg.zzat(zzacb.tag >>> 3)) == null) {
            return null;
        }
        return zzat.zzb(zzacb);
    }

    public void zza(zzaby zzaby) throws IOException {
        if (this.zzbxg != null) {
            for (int i = 0; i < this.zzbxg.size(); i++) {
                this.zzbxg.zzau(i).zza(zzaby);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzabx zzabx, int i) throws IOException {
        int position = zzabx.getPosition();
        if (!zzabx.zzak(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzaci zzaci = new zzaci(i, zzabx.zzc(position, zzabx.getPosition() - position));
        zzacd zzacd = null;
        if (this.zzbxg == null) {
            this.zzbxg = new zzacc();
        } else {
            zzacd = this.zzbxg.zzat(i2);
        }
        if (zzacd == null) {
            zzacd = new zzacd();
            this.zzbxg.zza(i2, zzacd);
        }
        zzacd.zza(zzaci);
        return true;
    }

    public final /* synthetic */ zzacg zzvo() throws CloneNotSupportedException {
        return (zzaca) clone();
    }
}
