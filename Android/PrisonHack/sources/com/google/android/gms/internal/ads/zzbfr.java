package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbfr extends zzbfc<zzbfr> {
    private zzbfo[] zzeda = zzbfo.zzagt();
    private byte[] zzedb = null;
    private byte[] zzedc = null;
    private Integer zzedd = null;
    private zzbfs zzedh = null;
    private byte[] zzedi = null;

    public zzbfr() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            if (zzabk == 0) {
                return this;
            }
            if (zzabk == 10) {
                if (this.zzedh == null) {
                    this.zzedh = new zzbfs();
                }
                zzbez.zza(this.zzedh);
            } else if (zzabk == 18) {
                int zzb = zzbfl.zzb(zzbez, 18);
                int length = this.zzeda == null ? 0 : this.zzeda.length;
                zzbfo[] zzbfoArr = new zzbfo[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzeda, 0, zzbfoArr, 0, length);
                }
                while (length < zzbfoArr.length - 1) {
                    zzbfoArr[length] = new zzbfo();
                    zzbez.zza(zzbfoArr[length]);
                    zzbez.zzabk();
                    length++;
                }
                zzbfoArr[length] = new zzbfo();
                zzbez.zza(zzbfoArr[length]);
                this.zzeda = zzbfoArr;
            } else if (zzabk == 26) {
                this.zzedb = zzbez.readBytes();
            } else if (zzabk == 34) {
                this.zzedc = zzbez.readBytes();
            } else if (zzabk == 40) {
                this.zzedd = Integer.valueOf(zzbez.zzabn());
            } else if (zzabk == 50) {
                this.zzedi = zzbez.readBytes();
            } else if (!super.zza(zzbez, zzabk)) {
                return this;
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzedh != null) {
            zzbfa.zza(1, (zzbfi) this.zzedh);
        }
        if (this.zzeda != null && this.zzeda.length > 0) {
            for (zzbfo zzbfo : this.zzeda) {
                if (zzbfo != null) {
                    zzbfa.zza(2, (zzbfi) zzbfo);
                }
            }
        }
        if (this.zzedb != null) {
            zzbfa.zza(3, this.zzedb);
        }
        if (this.zzedc != null) {
            zzbfa.zza(4, this.zzedc);
        }
        if (this.zzedd != null) {
            zzbfa.zzm(5, this.zzedd.intValue());
        }
        if (this.zzedi != null) {
            zzbfa.zza(6, this.zzedi);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzedh != null) {
            zzr += zzbfa.zzb(1, (zzbfi) this.zzedh);
        }
        if (this.zzeda != null && this.zzeda.length > 0) {
            for (zzbfo zzbfo : this.zzeda) {
                if (zzbfo != null) {
                    zzr += zzbfa.zzb(2, (zzbfi) zzbfo);
                }
            }
        }
        if (this.zzedb != null) {
            zzr += zzbfa.zzb(3, this.zzedb);
        }
        if (this.zzedc != null) {
            zzr += zzbfa.zzb(4, this.zzedc);
        }
        if (this.zzedd != null) {
            zzr += zzbfa.zzq(5, this.zzedd.intValue());
        }
        return this.zzedi != null ? zzr + zzbfa.zzb(6, this.zzedi) : zzr;
    }
}
