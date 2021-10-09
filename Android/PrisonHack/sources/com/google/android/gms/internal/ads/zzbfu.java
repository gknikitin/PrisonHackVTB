package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbfu extends zzbfc<zzbfu> {
    private static volatile zzbfu[] zzedm;
    public String url = null;
    public Integer zzedn = null;
    public zzbfp zzedo = null;
    private zzbfr zzedp = null;
    private Integer zzedq = null;
    private int[] zzedr = zzbfl.zzeby;
    private String zzeds = null;
    public Integer zzedt = null;
    public String[] zzedu = zzbfl.zzecd;

    public zzbfu() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzac */
    public final zzbfu zza(zzbez zzbez) throws IOException {
        zzbfi zzbfi;
        int zzabn;
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    return this;
                case 8:
                    this.zzedn = Integer.valueOf(zzbez.zzabn());
                    continue;
                case 18:
                    this.url = zzbez.readString();
                    continue;
                case 26:
                    if (this.zzedo == null) {
                        this.zzedo = new zzbfp();
                    }
                    zzbfi = this.zzedo;
                    break;
                case 34:
                    if (this.zzedp == null) {
                        this.zzedp = new zzbfr();
                    }
                    zzbfi = this.zzedp;
                    break;
                case 40:
                    this.zzedq = Integer.valueOf(zzbez.zzabn());
                    continue;
                case 48:
                    int zzb = zzbfl.zzb(zzbez, 48);
                    int length = this.zzedr == null ? 0 : this.zzedr.length;
                    int[] iArr = new int[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzedr, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzbez.zzabn();
                        zzbez.zzabk();
                        length++;
                    }
                    iArr[length] = zzbez.zzabn();
                    this.zzedr = iArr;
                    continue;
                case 50:
                    int zzbr = zzbez.zzbr(zzbez.zzacc());
                    int position = zzbez.getPosition();
                    int i = 0;
                    while (zzbez.zzagn() > 0) {
                        zzbez.zzabn();
                        i++;
                    }
                    zzbez.zzdc(position);
                    int length2 = this.zzedr == null ? 0 : this.zzedr.length;
                    int[] iArr2 = new int[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzedr, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzbez.zzabn();
                        length2++;
                    }
                    this.zzedr = iArr2;
                    zzbez.zzbs(zzbr);
                    continue;
                case 58:
                    this.zzeds = zzbez.readString();
                    continue;
                case 64:
                    try {
                        zzabn = zzbez.zzabn();
                        if (zzabn < 0 || zzabn > 3) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append(zzabn);
                            sb.append(" is not a valid enum AdResourceType");
                            break;
                        } else {
                            this.zzedt = Integer.valueOf(zzabn);
                            continue;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbez.zzdc(zzbez.getPosition());
                        zza(zzbez, zzabk);
                        break;
                    }
                case 74:
                    int zzb2 = zzbfl.zzb(zzbez, 74);
                    int length3 = this.zzedu == null ? 0 : this.zzedu.length;
                    String[] strArr = new String[(zzb2 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzedu, 0, strArr, 0, length3);
                    }
                    while (length3 < strArr.length - 1) {
                        strArr[length3] = zzbez.readString();
                        zzbez.zzabk();
                        length3++;
                    }
                    strArr[length3] = zzbez.readString();
                    this.zzedu = strArr;
                    continue;
                default:
                    if (!super.zza(zzbez, zzabk)) {
                        return this;
                    }
                    continue;
            }
            zzbez.zza(zzbfi);
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzabn);
        sb2.append(" is not a valid enum AdResourceType");
        throw new IllegalArgumentException(sb2.toString());
    }

    public static zzbfu[] zzagu() {
        if (zzedm == null) {
            synchronized (zzbfg.zzebs) {
                if (zzedm == null) {
                    zzedm = new zzbfu[0];
                }
            }
        }
        return zzedm;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        zzbfa.zzm(1, this.zzedn.intValue());
        if (this.url != null) {
            zzbfa.zzf(2, this.url);
        }
        if (this.zzedo != null) {
            zzbfa.zza(3, (zzbfi) this.zzedo);
        }
        if (this.zzedp != null) {
            zzbfa.zza(4, (zzbfi) this.zzedp);
        }
        if (this.zzedq != null) {
            zzbfa.zzm(5, this.zzedq.intValue());
        }
        if (this.zzedr != null && this.zzedr.length > 0) {
            for (int zzm : this.zzedr) {
                zzbfa.zzm(6, zzm);
            }
        }
        if (this.zzeds != null) {
            zzbfa.zzf(7, this.zzeds);
        }
        if (this.zzedt != null) {
            zzbfa.zzm(8, this.zzedt.intValue());
        }
        if (this.zzedu != null && this.zzedu.length > 0) {
            for (String str : this.zzedu) {
                if (str != null) {
                    zzbfa.zzf(9, str);
                }
            }
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr() + zzbfa.zzq(1, this.zzedn.intValue());
        if (this.url != null) {
            zzr += zzbfa.zzg(2, this.url);
        }
        if (this.zzedo != null) {
            zzr += zzbfa.zzb(3, (zzbfi) this.zzedo);
        }
        if (this.zzedp != null) {
            zzr += zzbfa.zzb(4, (zzbfi) this.zzedp);
        }
        if (this.zzedq != null) {
            zzr += zzbfa.zzq(5, this.zzedq.intValue());
        }
        if (this.zzedr != null && this.zzedr.length > 0) {
            int i = 0;
            for (int zzce : this.zzedr) {
                i += zzbfa.zzce(zzce);
            }
            zzr = zzr + i + (this.zzedr.length * 1);
        }
        if (this.zzeds != null) {
            zzr += zzbfa.zzg(7, this.zzeds);
        }
        if (this.zzedt != null) {
            zzr += zzbfa.zzq(8, this.zzedt.intValue());
        }
        if (this.zzedu == null || this.zzedu.length <= 0) {
            return zzr;
        }
        int i2 = 0;
        int i3 = 0;
        for (String str : this.zzedu) {
            if (str != null) {
                i3++;
                i2 += zzbfa.zzeo(str);
            }
        }
        return zzr + i2 + (i3 * 1);
    }
}
