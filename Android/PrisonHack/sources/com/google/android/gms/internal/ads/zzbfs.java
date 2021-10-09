package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbfs extends zzbfc<zzbfs> {
    private byte[] zzedg = null;
    private Integer zzedj = null;
    private byte[] zzedk = null;

    public zzbfs() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 8) {
                this.zzedj = Integer.valueOf(zzbez.zzabn());
            } else if (zzabk == 18) {
                this.zzedk = zzbez.readBytes();
            } else if (zzabk == 26) {
                this.zzedg = zzbez.readBytes();
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzedj != null) {
            zzbfa.zzm(1, this.zzedj.intValue());
        }
        if (this.zzedk != null) {
            zzbfa.zza(2, this.zzedk);
        }
        if (this.zzedg != null) {
            zzbfa.zza(3, this.zzedg);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzedj != null) {
            zzr += zzbfa.zzq(1, this.zzedj.intValue());
        }
        if (this.zzedk != null) {
            zzr += zzbfa.zzb(2, this.zzedk);
        }
        return this.zzedg != null ? zzr + zzbfa.zzb(3, this.zzedg) : zzr;
    }
}
