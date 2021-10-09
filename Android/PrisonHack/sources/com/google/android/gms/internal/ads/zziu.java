package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zziu extends zzbfc<zziu> {
    private static volatile zziu[] zzaow;
    private zziy zzaox = null;
    private zzja zzaoy = null;
    private zzjb zzaoz = null;
    private zzjc zzapa = null;
    private zziv zzapb = null;
    private zziz zzapc = null;
    private zzix zzapd = null;
    private Integer zzape = null;
    private Integer zzapf = null;
    private zzis zzapg = null;
    private Integer zzaph = null;
    private Integer zzapi = null;
    private Integer zzapj = null;
    private Integer zzapk = null;
    private Integer zzapl = null;
    private Long zzapm = null;

    public zziu() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    public static zziu[] zzhu() {
        if (zzaow == null) {
            synchronized (zzbfg.zzebs) {
                if (zzaow == null) {
                    zzaow = new zziu[0];
                }
            }
        }
        return zzaow;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        zzbfi zzbfi;
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    return this;
                case 42:
                    if (this.zzaox == null) {
                        this.zzaox = new zziy();
                    }
                    zzbfi = this.zzaox;
                    break;
                case 50:
                    if (this.zzaoy == null) {
                        this.zzaoy = new zzja();
                    }
                    zzbfi = this.zzaoy;
                    break;
                case 58:
                    if (this.zzaoz == null) {
                        this.zzaoz = new zzjb();
                    }
                    zzbfi = this.zzaoz;
                    break;
                case 66:
                    if (this.zzapa == null) {
                        this.zzapa = new zzjc();
                    }
                    zzbfi = this.zzapa;
                    break;
                case 74:
                    if (this.zzapb == null) {
                        this.zzapb = new zziv();
                    }
                    zzbfi = this.zzapb;
                    break;
                case 82:
                    if (this.zzapc == null) {
                        this.zzapc = new zziz();
                    }
                    zzbfi = this.zzapc;
                    break;
                case 90:
                    if (this.zzapd == null) {
                        this.zzapd = new zzix();
                    }
                    zzbfi = this.zzapd;
                    break;
                case 96:
                    this.zzape = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 104:
                    this.zzapf = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 114:
                    if (this.zzapg == null) {
                        this.zzapg = new zzis();
                    }
                    zzbfi = this.zzapg;
                    break;
                case 120:
                    this.zzaph = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 128:
                    this.zzapi = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 136:
                    this.zzapj = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 144:
                    this.zzapk = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 152:
                    this.zzapl = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 160:
                    this.zzapm = Long.valueOf(zzbez.zzacd());
                    continue;
                default:
                    if (!super.zza(zzbez, zzabk)) {
                        return this;
                    }
                    continue;
            }
            zzbez.zza(zzbfi);
        }
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzaox != null) {
            zzbfa.zza(5, (zzbfi) this.zzaox);
        }
        if (this.zzaoy != null) {
            zzbfa.zza(6, (zzbfi) this.zzaoy);
        }
        if (this.zzaoz != null) {
            zzbfa.zza(7, (zzbfi) this.zzaoz);
        }
        if (this.zzapa != null) {
            zzbfa.zza(8, (zzbfi) this.zzapa);
        }
        if (this.zzapb != null) {
            zzbfa.zza(9, (zzbfi) this.zzapb);
        }
        if (this.zzapc != null) {
            zzbfa.zza(10, (zzbfi) this.zzapc);
        }
        if (this.zzapd != null) {
            zzbfa.zza(11, (zzbfi) this.zzapd);
        }
        if (this.zzape != null) {
            zzbfa.zzm(12, this.zzape.intValue());
        }
        if (this.zzapf != null) {
            zzbfa.zzm(13, this.zzapf.intValue());
        }
        if (this.zzapg != null) {
            zzbfa.zza(14, (zzbfi) this.zzapg);
        }
        if (this.zzaph != null) {
            zzbfa.zzm(15, this.zzaph.intValue());
        }
        if (this.zzapi != null) {
            zzbfa.zzm(16, this.zzapi.intValue());
        }
        if (this.zzapj != null) {
            zzbfa.zzm(17, this.zzapj.intValue());
        }
        if (this.zzapk != null) {
            zzbfa.zzm(18, this.zzapk.intValue());
        }
        if (this.zzapl != null) {
            zzbfa.zzm(19, this.zzapl.intValue());
        }
        if (this.zzapm != null) {
            zzbfa.zza(20, this.zzapm.longValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzaox != null) {
            zzr += zzbfa.zzb(5, (zzbfi) this.zzaox);
        }
        if (this.zzaoy != null) {
            zzr += zzbfa.zzb(6, (zzbfi) this.zzaoy);
        }
        if (this.zzaoz != null) {
            zzr += zzbfa.zzb(7, (zzbfi) this.zzaoz);
        }
        if (this.zzapa != null) {
            zzr += zzbfa.zzb(8, (zzbfi) this.zzapa);
        }
        if (this.zzapb != null) {
            zzr += zzbfa.zzb(9, (zzbfi) this.zzapb);
        }
        if (this.zzapc != null) {
            zzr += zzbfa.zzb(10, (zzbfi) this.zzapc);
        }
        if (this.zzapd != null) {
            zzr += zzbfa.zzb(11, (zzbfi) this.zzapd);
        }
        if (this.zzape != null) {
            zzr += zzbfa.zzq(12, this.zzape.intValue());
        }
        if (this.zzapf != null) {
            zzr += zzbfa.zzq(13, this.zzapf.intValue());
        }
        if (this.zzapg != null) {
            zzr += zzbfa.zzb(14, (zzbfi) this.zzapg);
        }
        if (this.zzaph != null) {
            zzr += zzbfa.zzq(15, this.zzaph.intValue());
        }
        if (this.zzapi != null) {
            zzr += zzbfa.zzq(16, this.zzapi.intValue());
        }
        if (this.zzapj != null) {
            zzr += zzbfa.zzq(17, this.zzapj.intValue());
        }
        if (this.zzapk != null) {
            zzr += zzbfa.zzq(18, this.zzapk.intValue());
        }
        if (this.zzapl != null) {
            zzr += zzbfa.zzq(19, this.zzapl.intValue());
        }
        return this.zzapm != null ? zzr + zzbfa.zze(20, this.zzapm.longValue()) : zzr;
    }
}
