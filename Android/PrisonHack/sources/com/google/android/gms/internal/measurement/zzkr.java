package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkr extends zzaca<zzkr> {
    public zzks[] zzatr = zzks.zzlw();

    public zzkr() {
        this.zzbxg = null;
        this.zzbxr = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkr)) {
            return false;
        }
        zzkr zzkr = (zzkr) obj;
        if (!zzace.equals((Object[]) this.zzatr, (Object[]) zzkr.zzatr)) {
            return false;
        }
        return (this.zzbxg == null || this.zzbxg.isEmpty()) ? zzkr.zzbxg == null || zzkr.zzbxg.isEmpty() : this.zzbxg.equals(zzkr.zzbxg);
    }

    public final int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + zzace.hashCode((Object[]) this.zzatr)) * 31) + ((this.zzbxg == null || this.zzbxg.isEmpty()) ? 0 : this.zzbxg.hashCode());
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzatr != null && this.zzatr.length > 0) {
            for (zzks zzks : this.zzatr) {
                if (zzks != null) {
                    zza += zzaby.zzb(1, (zzacg) zzks);
                }
            }
        }
        return zza;
    }

    public final void zza(zzaby zzaby) throws IOException {
        if (this.zzatr != null && this.zzatr.length > 0) {
            for (zzks zzks : this.zzatr) {
                if (zzks != null) {
                    zzaby.zza(1, (zzacg) zzks);
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
            if (zzvf == 10) {
                int zzb = zzacj.zzb(zzabx, 10);
                int length = this.zzatr == null ? 0 : this.zzatr.length;
                zzks[] zzksArr = new zzks[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzatr, 0, zzksArr, 0, length);
                }
                while (length < zzksArr.length - 1) {
                    zzksArr[length] = new zzks();
                    zzabx.zza(zzksArr[length]);
                    zzabx.zzvf();
                    length++;
                }
                zzksArr[length] = new zzks();
                zzabx.zza(zzksArr[length]);
                this.zzatr = zzksArr;
            } else if (!super.zza(zzabx, zzvf)) {
                return this;
            }
        }
    }
}
