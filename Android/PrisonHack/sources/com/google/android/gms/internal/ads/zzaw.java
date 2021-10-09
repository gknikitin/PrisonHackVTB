package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaw extends zzbfc<zzaw> {
    private String stackTrace = null;
    public String zzco = null;
    public Long zzcp = null;
    private String zzcq = null;
    private String zzcr = null;
    private Long zzcs = null;
    private Long zzct = null;
    private String zzcu = null;
    private Long zzcv = null;
    private String zzcw = null;

    public zzaw() {
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    return this;
                case 10:
                    this.zzco = zzbez.readString();
                    break;
                case 16:
                    this.zzcp = Long.valueOf(zzbez.zzacd());
                    break;
                case 26:
                    this.stackTrace = zzbez.readString();
                    break;
                case 34:
                    this.zzcq = zzbez.readString();
                    break;
                case 42:
                    this.zzcr = zzbez.readString();
                    break;
                case 48:
                    this.zzcs = Long.valueOf(zzbez.zzacd());
                    break;
                case 56:
                    this.zzct = Long.valueOf(zzbez.zzacd());
                    break;
                case 66:
                    this.zzcu = zzbez.readString();
                    break;
                case 72:
                    this.zzcv = Long.valueOf(zzbez.zzacd());
                    break;
                case 82:
                    this.zzcw = zzbez.readString();
                    break;
                default:
                    if (super.zza(zzbez, zzabk)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzco != null) {
            zzbfa.zzf(1, this.zzco);
        }
        if (this.zzcp != null) {
            zzbfa.zzi(2, this.zzcp.longValue());
        }
        if (this.stackTrace != null) {
            zzbfa.zzf(3, this.stackTrace);
        }
        if (this.zzcq != null) {
            zzbfa.zzf(4, this.zzcq);
        }
        if (this.zzcr != null) {
            zzbfa.zzf(5, this.zzcr);
        }
        if (this.zzcs != null) {
            zzbfa.zzi(6, this.zzcs.longValue());
        }
        if (this.zzct != null) {
            zzbfa.zzi(7, this.zzct.longValue());
        }
        if (this.zzcu != null) {
            zzbfa.zzf(8, this.zzcu);
        }
        if (this.zzcv != null) {
            zzbfa.zzi(9, this.zzcv.longValue());
        }
        if (this.zzcw != null) {
            zzbfa.zzf(10, this.zzcw);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzco != null) {
            zzr += zzbfa.zzg(1, this.zzco);
        }
        if (this.zzcp != null) {
            zzr += zzbfa.zzd(2, this.zzcp.longValue());
        }
        if (this.stackTrace != null) {
            zzr += zzbfa.zzg(3, this.stackTrace);
        }
        if (this.zzcq != null) {
            zzr += zzbfa.zzg(4, this.zzcq);
        }
        if (this.zzcr != null) {
            zzr += zzbfa.zzg(5, this.zzcr);
        }
        if (this.zzcs != null) {
            zzr += zzbfa.zzd(6, this.zzcs.longValue());
        }
        if (this.zzct != null) {
            zzr += zzbfa.zzd(7, this.zzct.longValue());
        }
        if (this.zzcu != null) {
            zzr += zzbfa.zzg(8, this.zzcu);
        }
        if (this.zzcv != null) {
            zzr += zzbfa.zzd(9, this.zzcv.longValue());
        }
        return this.zzcw != null ? zzr + zzbfa.zzg(10, this.zzcw) : zzr;
    }
}
