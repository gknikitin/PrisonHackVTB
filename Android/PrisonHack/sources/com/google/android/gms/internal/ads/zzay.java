package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzay extends zzbfc<zzay> {
    public String zzcx;
    private String zzcy;
    private String zzcz;
    private String zzda;
    private String zzdb;

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                this.zzcx = zzbez.readString();
            } else if (zzabk == 18) {
                this.zzcy = zzbez.readString();
            } else if (zzabk == 26) {
                this.zzcz = zzbez.readString();
            } else if (zzabk == 34) {
                this.zzda = zzbez.readString();
            } else if (zzabk == 42) {
                this.zzdb = zzbez.readString();
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzcx != null) {
            zzbfa.zzf(1, this.zzcx);
        }
        if (this.zzcy != null) {
            zzbfa.zzf(2, this.zzcy);
        }
        if (this.zzcz != null) {
            zzbfa.zzf(3, this.zzcz);
        }
        if (this.zzda != null) {
            zzbfa.zzf(4, this.zzda);
        }
        if (this.zzdb != null) {
            zzbfa.zzf(5, this.zzdb);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzcx != null) {
            zzr += zzbfa.zzg(1, this.zzcx);
        }
        if (this.zzcy != null) {
            zzr += zzbfa.zzg(2, this.zzcy);
        }
        if (this.zzcz != null) {
            zzr += zzbfa.zzg(3, this.zzcz);
        }
        if (this.zzda != null) {
            zzr += zzbfa.zzg(4, this.zzda);
        }
        return this.zzdb != null ? zzr + zzbfa.zzg(5, this.zzdb) : zzr;
    }
}
