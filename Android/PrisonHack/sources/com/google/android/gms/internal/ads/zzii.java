package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzii extends zzbfc<zzii> {
    private Integer zzang = null;
    public String zzanh = null;
    private Integer zzani = null;
    private Integer zzanj = null;
    private zzit zzank = null;
    public long[] zzanl = zzbfl.zzebz;
    public zzig zzanm = null;
    private zzih zzann = null;
    private zzim zzano = null;
    public zzib zzanp = null;

    public zzii() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzk */
    public final zzii zza(zzbez zzbez) throws IOException {
        zzbfi zzbfi;
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    return this;
                case 72:
                    this.zzang = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 82:
                    this.zzanh = zzbez.readString();
                    continue;
                case 88:
                    this.zzani = Integer.valueOf(zzbez.zzacc());
                    continue;
                case 96:
                    int position = zzbez.getPosition();
                    try {
                        this.zzanj = Integer.valueOf(zzia.zzd(zzbez.zzacc()));
                        continue;
                    } catch (IllegalArgumentException unused) {
                        zzbez.zzdc(position);
                        zza(zzbez, zzabk);
                        break;
                    }
                case 106:
                    if (this.zzank == null) {
                        this.zzank = new zzit();
                    }
                    zzbfi = this.zzank;
                    break;
                case 112:
                    int zzb = zzbfl.zzb(zzbez, 112);
                    int length = this.zzanl == null ? 0 : this.zzanl.length;
                    long[] jArr = new long[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzanl, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzbez.zzacd();
                        zzbez.zzabk();
                        length++;
                    }
                    jArr[length] = zzbez.zzacd();
                    this.zzanl = jArr;
                    continue;
                case 114:
                    int zzbr = zzbez.zzbr(zzbez.zzacc());
                    int position2 = zzbez.getPosition();
                    int i = 0;
                    while (zzbez.zzagn() > 0) {
                        zzbez.zzacd();
                        i++;
                    }
                    zzbez.zzdc(position2);
                    int length2 = this.zzanl == null ? 0 : this.zzanl.length;
                    long[] jArr2 = new long[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzanl, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzbez.zzacd();
                        length2++;
                    }
                    this.zzanl = jArr2;
                    zzbez.zzbs(zzbr);
                    continue;
                case 122:
                    if (this.zzanm == null) {
                        this.zzanm = new zzig();
                    }
                    zzbfi = this.zzanm;
                    break;
                case 130:
                    if (this.zzann == null) {
                        this.zzann = new zzih();
                    }
                    zzbfi = this.zzann;
                    break;
                case 138:
                    if (this.zzano == null) {
                        this.zzano = new zzim();
                    }
                    zzbfi = this.zzano;
                    break;
                case 146:
                    if (this.zzanp == null) {
                        this.zzanp = new zzib();
                    }
                    zzbfi = this.zzanp;
                    break;
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
        if (this.zzang != null) {
            zzbfa.zzm(9, this.zzang.intValue());
        }
        if (this.zzanh != null) {
            zzbfa.zzf(10, this.zzanh);
        }
        if (this.zzani != null) {
            int intValue = this.zzani.intValue();
            zzbfa.zzl(11, 0);
            zzbfa.zzde(intValue);
        }
        if (this.zzanj != null) {
            zzbfa.zzm(12, this.zzanj.intValue());
        }
        if (this.zzank != null) {
            zzbfa.zza(13, (zzbfi) this.zzank);
        }
        if (this.zzanl != null && this.zzanl.length > 0) {
            for (long zza : this.zzanl) {
                zzbfa.zza(14, zza);
            }
        }
        if (this.zzanm != null) {
            zzbfa.zza(15, (zzbfi) this.zzanm);
        }
        if (this.zzann != null) {
            zzbfa.zza(16, (zzbfi) this.zzann);
        }
        if (this.zzano != null) {
            zzbfa.zza(17, (zzbfi) this.zzano);
        }
        if (this.zzanp != null) {
            zzbfa.zza(18, (zzbfi) this.zzanp);
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzang != null) {
            zzr += zzbfa.zzq(9, this.zzang.intValue());
        }
        if (this.zzanh != null) {
            zzr += zzbfa.zzg(10, this.zzanh);
        }
        if (this.zzani != null) {
            zzr += zzbfa.zzcd(11) + zzbfa.zzcl(this.zzani.intValue());
        }
        if (this.zzanj != null) {
            zzr += zzbfa.zzq(12, this.zzanj.intValue());
        }
        if (this.zzank != null) {
            zzr += zzbfa.zzb(13, (zzbfi) this.zzank);
        }
        if (this.zzanl != null && this.zzanl.length > 0) {
            int i = 0;
            for (long zzy : this.zzanl) {
                i += zzbfa.zzy(zzy);
            }
            zzr = zzr + i + (this.zzanl.length * 1);
        }
        if (this.zzanm != null) {
            zzr += zzbfa.zzb(15, (zzbfi) this.zzanm);
        }
        if (this.zzann != null) {
            zzr += zzbfa.zzb(16, (zzbfi) this.zzann);
        }
        if (this.zzano != null) {
            zzr += zzbfa.zzb(17, (zzbfi) this.zzano);
        }
        return this.zzanp != null ? zzr + zzbfa.zzb(18, (zzbfi) this.zzanp) : zzr;
    }
}
