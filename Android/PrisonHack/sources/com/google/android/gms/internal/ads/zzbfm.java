package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbfm extends zzbfc<zzbfm> {
    public String url = null;
    public Integer zzamf = null;
    private Integer zzecg = null;
    public String zzech = null;
    private String zzeci = null;
    public zzbfn zzecj = null;
    public zzbfu[] zzeck = zzbfu.zzagu();
    public String zzecl = null;
    public zzbft zzecm = null;
    private Boolean zzecn = null;
    private String[] zzeco = zzbfl.zzecd;
    private String zzecp = null;
    private Boolean zzecq = null;
    private Boolean zzecr = null;
    private byte[] zzecs = null;
    public zzbfv zzect = null;
    public String[] zzecu = zzbfl.zzecd;
    public String[] zzecv = zzbfl.zzecd;

    public zzbfm() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        throw new java.lang.IllegalArgumentException(r5.toString());
     */
    /* renamed from: zzaa */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfm zza(com.google.android.gms.internal.ads.zzbez r7) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r7.zzabk()
            r1 = 0
            switch(r0) {
                case 0: goto L_0x01d0;
                case 10: goto L_0x01c8;
                case 18: goto L_0x01c0;
                case 26: goto L_0x01b8;
                case 34: goto L_0x0178;
                case 40: goto L_0x016c;
                case 50: goto L_0x0138;
                case 58: goto L_0x0130;
                case 64: goto L_0x0124;
                case 72: goto L_0x0118;
                case 80: goto L_0x00e1;
                case 88: goto L_0x00b3;
                case 98: goto L_0x00a1;
                case 106: goto L_0x0099;
                case 114: goto L_0x008b;
                case 122: goto L_0x0083;
                case 138: goto L_0x0075;
                case 162: goto L_0x0042;
                case 170: goto L_0x000f;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r7, r0)
            if (r0 != 0) goto L_0x0000
            return r6
        L_0x000f:
            r0 = 170(0xaa, float:2.38E-43)
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            java.lang.String[] r2 = r6.zzecv
            if (r2 != 0) goto L_0x001b
            r2 = 0
            goto L_0x001e
        L_0x001b:
            java.lang.String[] r2 = r6.zzecv
            int r2 = r2.length
        L_0x001e:
            int r0 = r0 + r2
            java.lang.String[] r0 = new java.lang.String[r0]
            if (r2 == 0) goto L_0x0028
            java.lang.String[] r3 = r6.zzecv
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x0028:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x0039
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x0028
        L_0x0039:
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r6.zzecv = r0
            goto L_0x0000
        L_0x0042:
            r0 = 162(0xa2, float:2.27E-43)
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            java.lang.String[] r2 = r6.zzecu
            if (r2 != 0) goto L_0x004e
            r2 = 0
            goto L_0x0051
        L_0x004e:
            java.lang.String[] r2 = r6.zzecu
            int r2 = r2.length
        L_0x0051:
            int r0 = r0 + r2
            java.lang.String[] r0 = new java.lang.String[r0]
            if (r2 == 0) goto L_0x005b
            java.lang.String[] r3 = r6.zzecu
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x005b:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x006c
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x005b
        L_0x006c:
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r6.zzecu = r0
            goto L_0x0000
        L_0x0075:
            com.google.android.gms.internal.ads.zzbfv r0 = r6.zzect
            if (r0 != 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzbfv r0 = new com.google.android.gms.internal.ads.zzbfv
            r0.<init>()
            r6.zzect = r0
        L_0x0080:
            com.google.android.gms.internal.ads.zzbfv r0 = r6.zzect
            goto L_0x00ae
        L_0x0083:
            byte[] r0 = r7.readBytes()
            r6.zzecs = r0
            goto L_0x0000
        L_0x008b:
            com.google.android.gms.internal.ads.zzbft r0 = r6.zzecm
            if (r0 != 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzbft r0 = new com.google.android.gms.internal.ads.zzbft
            r0.<init>()
            r6.zzecm = r0
        L_0x0096:
            com.google.android.gms.internal.ads.zzbft r0 = r6.zzecm
            goto L_0x00ae
        L_0x0099:
            java.lang.String r0 = r7.readString()
            r6.zzecl = r0
            goto L_0x0000
        L_0x00a1:
            com.google.android.gms.internal.ads.zzbfn r0 = r6.zzecj
            if (r0 != 0) goto L_0x00ac
            com.google.android.gms.internal.ads.zzbfn r0 = new com.google.android.gms.internal.ads.zzbfn
            r0.<init>()
            r6.zzecj = r0
        L_0x00ac:
            com.google.android.gms.internal.ads.zzbfn r0 = r6.zzecj
        L_0x00ae:
            r7.zza(r0)
            goto L_0x0000
        L_0x00b3:
            int r1 = r7.getPosition()
            int r2 = r7.zzabn()     // Catch:{ IllegalArgumentException -> 0x0110 }
            if (r2 < 0) goto L_0x00c8
            r3 = 4
            if (r2 > r3) goto L_0x00c8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r6.zzecg = r2     // Catch:{ IllegalArgumentException -> 0x0110 }
            goto L_0x0000
        L_0x00c8:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0110 }
            r4 = 39
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0110 }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            java.lang.String r2 = " is not a valid enum Verdict"
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            java.lang.String r2 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x0110 }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0110 }
        L_0x00e1:
            int r1 = r7.getPosition()
            int r2 = r7.zzabn()     // Catch:{ IllegalArgumentException -> 0x0110 }
            if (r2 < 0) goto L_0x00f7
            r3 = 9
            if (r2 > r3) goto L_0x00f7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r6.zzamf = r2     // Catch:{ IllegalArgumentException -> 0x0110 }
            goto L_0x0000
        L_0x00f7:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0110 }
            r4 = 42
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0110 }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            java.lang.String r2 = " is not a valid enum ReportType"
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            java.lang.String r2 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x0110 }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0110 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0110 }
        L_0x0110:
            r7.zzdc(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x0118:
            boolean r0 = r7.zzabq()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzecr = r0
            goto L_0x0000
        L_0x0124:
            boolean r0 = r7.zzabq()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzecq = r0
            goto L_0x0000
        L_0x0130:
            java.lang.String r0 = r7.readString()
            r6.zzecp = r0
            goto L_0x0000
        L_0x0138:
            r0 = 50
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            java.lang.String[] r2 = r6.zzeco
            if (r2 != 0) goto L_0x0144
            r2 = 0
            goto L_0x0147
        L_0x0144:
            java.lang.String[] r2 = r6.zzeco
            int r2 = r2.length
        L_0x0147:
            int r0 = r0 + r2
            java.lang.String[] r0 = new java.lang.String[r0]
            if (r2 == 0) goto L_0x0151
            java.lang.String[] r3 = r6.zzeco
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x0151:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x0162
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x0151
        L_0x0162:
            java.lang.String r1 = r7.readString()
            r0[r2] = r1
            r6.zzeco = r0
            goto L_0x0000
        L_0x016c:
            boolean r0 = r7.zzabq()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzecn = r0
            goto L_0x0000
        L_0x0178:
            r0 = 34
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            com.google.android.gms.internal.ads.zzbfu[] r2 = r6.zzeck
            if (r2 != 0) goto L_0x0184
            r2 = 0
            goto L_0x0187
        L_0x0184:
            com.google.android.gms.internal.ads.zzbfu[] r2 = r6.zzeck
            int r2 = r2.length
        L_0x0187:
            int r0 = r0 + r2
            com.google.android.gms.internal.ads.zzbfu[] r0 = new com.google.android.gms.internal.ads.zzbfu[r0]
            if (r2 == 0) goto L_0x0191
            com.google.android.gms.internal.ads.zzbfu[] r3 = r6.zzeck
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x0191:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x01a8
            com.google.android.gms.internal.ads.zzbfu r1 = new com.google.android.gms.internal.ads.zzbfu
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x0191
        L_0x01a8:
            com.google.android.gms.internal.ads.zzbfu r1 = new com.google.android.gms.internal.ads.zzbfu
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r6.zzeck = r0
            goto L_0x0000
        L_0x01b8:
            java.lang.String r0 = r7.readString()
            r6.zzeci = r0
            goto L_0x0000
        L_0x01c0:
            java.lang.String r0 = r7.readString()
            r6.zzech = r0
            goto L_0x0000
        L_0x01c8:
            java.lang.String r0 = r7.readString()
            r6.url = r0
            goto L_0x0000
        L_0x01d0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfm.zza(com.google.android.gms.internal.ads.zzbez):com.google.android.gms.internal.ads.zzbfm");
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.url != null) {
            zzbfa.zzf(1, this.url);
        }
        if (this.zzech != null) {
            zzbfa.zzf(2, this.zzech);
        }
        if (this.zzeci != null) {
            zzbfa.zzf(3, this.zzeci);
        }
        if (this.zzeck != null && this.zzeck.length > 0) {
            for (zzbfu zzbfu : this.zzeck) {
                if (zzbfu != null) {
                    zzbfa.zza(4, (zzbfi) zzbfu);
                }
            }
        }
        if (this.zzecn != null) {
            zzbfa.zzf(5, this.zzecn.booleanValue());
        }
        if (this.zzeco != null && this.zzeco.length > 0) {
            for (String str : this.zzeco) {
                if (str != null) {
                    zzbfa.zzf(6, str);
                }
            }
        }
        if (this.zzecp != null) {
            zzbfa.zzf(7, this.zzecp);
        }
        if (this.zzecq != null) {
            zzbfa.zzf(8, this.zzecq.booleanValue());
        }
        if (this.zzecr != null) {
            zzbfa.zzf(9, this.zzecr.booleanValue());
        }
        if (this.zzamf != null) {
            zzbfa.zzm(10, this.zzamf.intValue());
        }
        if (this.zzecg != null) {
            zzbfa.zzm(11, this.zzecg.intValue());
        }
        if (this.zzecj != null) {
            zzbfa.zza(12, (zzbfi) this.zzecj);
        }
        if (this.zzecl != null) {
            zzbfa.zzf(13, this.zzecl);
        }
        if (this.zzecm != null) {
            zzbfa.zza(14, (zzbfi) this.zzecm);
        }
        if (this.zzecs != null) {
            zzbfa.zza(15, this.zzecs);
        }
        if (this.zzect != null) {
            zzbfa.zza(17, (zzbfi) this.zzect);
        }
        if (this.zzecu != null && this.zzecu.length > 0) {
            for (String str2 : this.zzecu) {
                if (str2 != null) {
                    zzbfa.zzf(20, str2);
                }
            }
        }
        if (this.zzecv != null && this.zzecv.length > 0) {
            for (String str3 : this.zzecv) {
                if (str3 != null) {
                    zzbfa.zzf(21, str3);
                }
            }
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.url != null) {
            zzr += zzbfa.zzg(1, this.url);
        }
        if (this.zzech != null) {
            zzr += zzbfa.zzg(2, this.zzech);
        }
        if (this.zzeci != null) {
            zzr += zzbfa.zzg(3, this.zzeci);
        }
        if (this.zzeck != null && this.zzeck.length > 0) {
            int i = zzr;
            for (zzbfu zzbfu : this.zzeck) {
                if (zzbfu != null) {
                    i += zzbfa.zzb(4, (zzbfi) zzbfu);
                }
            }
            zzr = i;
        }
        if (this.zzecn != null) {
            this.zzecn.booleanValue();
            zzr += zzbfa.zzcd(5) + 1;
        }
        if (this.zzeco != null && this.zzeco.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zzeco) {
                if (str != null) {
                    i3++;
                    i2 += zzbfa.zzeo(str);
                }
            }
            zzr = zzr + i2 + (i3 * 1);
        }
        if (this.zzecp != null) {
            zzr += zzbfa.zzg(7, this.zzecp);
        }
        if (this.zzecq != null) {
            this.zzecq.booleanValue();
            zzr += zzbfa.zzcd(8) + 1;
        }
        if (this.zzecr != null) {
            this.zzecr.booleanValue();
            zzr += zzbfa.zzcd(9) + 1;
        }
        if (this.zzamf != null) {
            zzr += zzbfa.zzq(10, this.zzamf.intValue());
        }
        if (this.zzecg != null) {
            zzr += zzbfa.zzq(11, this.zzecg.intValue());
        }
        if (this.zzecj != null) {
            zzr += zzbfa.zzb(12, (zzbfi) this.zzecj);
        }
        if (this.zzecl != null) {
            zzr += zzbfa.zzg(13, this.zzecl);
        }
        if (this.zzecm != null) {
            zzr += zzbfa.zzb(14, (zzbfi) this.zzecm);
        }
        if (this.zzecs != null) {
            zzr += zzbfa.zzb(15, this.zzecs);
        }
        if (this.zzect != null) {
            zzr += zzbfa.zzb(17, (zzbfi) this.zzect);
        }
        if (this.zzecu != null && this.zzecu.length > 0) {
            int i4 = 0;
            int i5 = 0;
            for (String str2 : this.zzecu) {
                if (str2 != null) {
                    i5++;
                    i4 += zzbfa.zzeo(str2);
                }
            }
            zzr = zzr + i4 + (i5 * 2);
        }
        if (this.zzecv == null || this.zzecv.length <= 0) {
            return zzr;
        }
        int i6 = 0;
        int i7 = 0;
        for (String str3 : this.zzecv) {
            if (str3 != null) {
                i7++;
                i6 += zzbfa.zzeo(str3);
            }
        }
        return zzr + i6 + (i7 * 2);
    }
}
