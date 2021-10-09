package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzib extends zzbfc<zzib> {
    public Integer zzalt = null;
    private Integer zzalu = null;
    private zzid zzalv = null;
    public zzie zzalw = null;
    private zzic[] zzalx = zzic.zzhr();
    private zzif zzaly = null;
    private zzio zzalz = null;
    private zzin zzama = null;
    private zzik zzamb = null;
    private zzil zzamc = null;
    private zziu[] zzamd = zziu.zzhu();

    public zzib() {
        this.zzebk = null;
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zze */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzib zza(com.google.android.gms.internal.ads.zzbez r7) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r7.zzabk()
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0142;
                case 56: goto L_0x010b;
                case 64: goto L_0x00f7;
                case 74: goto L_0x00e5;
                case 82: goto L_0x00d7;
                case 90: goto L_0x0097;
                case 98: goto L_0x0089;
                case 106: goto L_0x007b;
                case 114: goto L_0x006c;
                case 122: goto L_0x005d;
                case 130: goto L_0x004e;
                case 138: goto L_0x000f;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r7, r0)
            if (r0 != 0) goto L_0x0000
            return r6
        L_0x000f:
            r0 = 138(0x8a, float:1.93E-43)
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            com.google.android.gms.internal.ads.zziu[] r2 = r6.zzamd
            if (r2 != 0) goto L_0x001b
            r2 = 0
            goto L_0x001e
        L_0x001b:
            com.google.android.gms.internal.ads.zziu[] r2 = r6.zzamd
            int r2 = r2.length
        L_0x001e:
            int r0 = r0 + r2
            com.google.android.gms.internal.ads.zziu[] r0 = new com.google.android.gms.internal.ads.zziu[r0]
            if (r2 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zziu[] r3 = r6.zzamd
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x0028:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x003f
            com.google.android.gms.internal.ads.zziu r1 = new com.google.android.gms.internal.ads.zziu
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x0028
        L_0x003f:
            com.google.android.gms.internal.ads.zziu r1 = new com.google.android.gms.internal.ads.zziu
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r6.zzamd = r0
            goto L_0x0000
        L_0x004e:
            com.google.android.gms.internal.ads.zzil r0 = r6.zzamc
            if (r0 != 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzil r0 = new com.google.android.gms.internal.ads.zzil
            r0.<init>()
            r6.zzamc = r0
        L_0x0059:
            com.google.android.gms.internal.ads.zzil r0 = r6.zzamc
            goto L_0x00f2
        L_0x005d:
            com.google.android.gms.internal.ads.zzik r0 = r6.zzamb
            if (r0 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzik r0 = new com.google.android.gms.internal.ads.zzik
            r0.<init>()
            r6.zzamb = r0
        L_0x0068:
            com.google.android.gms.internal.ads.zzik r0 = r6.zzamb
            goto L_0x00f2
        L_0x006c:
            com.google.android.gms.internal.ads.zzin r0 = r6.zzama
            if (r0 != 0) goto L_0x0077
            com.google.android.gms.internal.ads.zzin r0 = new com.google.android.gms.internal.ads.zzin
            r0.<init>()
            r6.zzama = r0
        L_0x0077:
            com.google.android.gms.internal.ads.zzin r0 = r6.zzama
            goto L_0x00f2
        L_0x007b:
            com.google.android.gms.internal.ads.zzio r0 = r6.zzalz
            if (r0 != 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzio r0 = new com.google.android.gms.internal.ads.zzio
            r0.<init>()
            r6.zzalz = r0
        L_0x0086:
            com.google.android.gms.internal.ads.zzio r0 = r6.zzalz
            goto L_0x00f2
        L_0x0089:
            com.google.android.gms.internal.ads.zzif r0 = r6.zzaly
            if (r0 != 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzif r0 = new com.google.android.gms.internal.ads.zzif
            r0.<init>()
            r6.zzaly = r0
        L_0x0094:
            com.google.android.gms.internal.ads.zzif r0 = r6.zzaly
            goto L_0x00f2
        L_0x0097:
            r0 = 90
            int r0 = com.google.android.gms.internal.ads.zzbfl.zzb(r7, r0)
            com.google.android.gms.internal.ads.zzic[] r2 = r6.zzalx
            if (r2 != 0) goto L_0x00a3
            r2 = 0
            goto L_0x00a6
        L_0x00a3:
            com.google.android.gms.internal.ads.zzic[] r2 = r6.zzalx
            int r2 = r2.length
        L_0x00a6:
            int r0 = r0 + r2
            com.google.android.gms.internal.ads.zzic[] r0 = new com.google.android.gms.internal.ads.zzic[r0]
            if (r2 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzic[] r3 = r6.zzalx
            java.lang.System.arraycopy(r3, r1, r0, r1, r2)
        L_0x00b0:
            int r1 = r0.length
            int r1 = r1 + -1
            if (r2 >= r1) goto L_0x00c7
            com.google.android.gms.internal.ads.zzic r1 = new com.google.android.gms.internal.ads.zzic
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r7.zzabk()
            int r2 = r2 + 1
            goto L_0x00b0
        L_0x00c7:
            com.google.android.gms.internal.ads.zzic r1 = new com.google.android.gms.internal.ads.zzic
            r1.<init>()
            r0[r2] = r1
            r1 = r0[r2]
            r7.zza(r1)
            r6.zzalx = r0
            goto L_0x0000
        L_0x00d7:
            com.google.android.gms.internal.ads.zzie r0 = r6.zzalw
            if (r0 != 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzie r0 = new com.google.android.gms.internal.ads.zzie
            r0.<init>()
            r6.zzalw = r0
        L_0x00e2:
            com.google.android.gms.internal.ads.zzie r0 = r6.zzalw
            goto L_0x00f2
        L_0x00e5:
            com.google.android.gms.internal.ads.zzid r0 = r6.zzalv
            if (r0 != 0) goto L_0x00f0
            com.google.android.gms.internal.ads.zzid r0 = new com.google.android.gms.internal.ads.zzid
            r0.<init>()
            r6.zzalv = r0
        L_0x00f0:
            com.google.android.gms.internal.ads.zzid r0 = r6.zzalv
        L_0x00f2:
            r7.zza(r0)
            goto L_0x0000
        L_0x00f7:
            int r1 = r7.getPosition()
            int r2 = r7.zzacc()     // Catch:{ IllegalArgumentException -> 0x013a }
            int r2 = com.google.android.gms.internal.ads.zzia.zzd(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            r6.zzalu = r2     // Catch:{ IllegalArgumentException -> 0x013a }
            goto L_0x0000
        L_0x010b:
            int r1 = r7.getPosition()
            int r2 = r7.zzacc()     // Catch:{ IllegalArgumentException -> 0x013a }
            if (r2 < 0) goto L_0x0121
            r3 = 9
            if (r2 > r3) goto L_0x0121
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            r6.zzalt = r2     // Catch:{ IllegalArgumentException -> 0x013a }
            goto L_0x0000
        L_0x0121:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x013a }
            r4 = 43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x013a }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x013a }
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            java.lang.String r2 = " is not a valid enum AdInitiater"
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            java.lang.String r2 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x013a }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x013a }
            throw r3     // Catch:{ IllegalArgumentException -> 0x013a }
        L_0x013a:
            r7.zzdc(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x0142:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzib.zza(com.google.android.gms.internal.ads.zzbez):com.google.android.gms.internal.ads.zzib");
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzalt != null) {
            zzbfa.zzm(7, this.zzalt.intValue());
        }
        if (this.zzalu != null) {
            zzbfa.zzm(8, this.zzalu.intValue());
        }
        if (this.zzalv != null) {
            zzbfa.zza(9, (zzbfi) this.zzalv);
        }
        if (this.zzalw != null) {
            zzbfa.zza(10, (zzbfi) this.zzalw);
        }
        if (this.zzalx != null && this.zzalx.length > 0) {
            for (zzic zzic : this.zzalx) {
                if (zzic != null) {
                    zzbfa.zza(11, (zzbfi) zzic);
                }
            }
        }
        if (this.zzaly != null) {
            zzbfa.zza(12, (zzbfi) this.zzaly);
        }
        if (this.zzalz != null) {
            zzbfa.zza(13, (zzbfi) this.zzalz);
        }
        if (this.zzama != null) {
            zzbfa.zza(14, (zzbfi) this.zzama);
        }
        if (this.zzamb != null) {
            zzbfa.zza(15, (zzbfi) this.zzamb);
        }
        if (this.zzamc != null) {
            zzbfa.zza(16, (zzbfi) this.zzamc);
        }
        if (this.zzamd != null && this.zzamd.length > 0) {
            for (zziu zziu : this.zzamd) {
                if (zziu != null) {
                    zzbfa.zza(17, (zzbfi) zziu);
                }
            }
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzalt != null) {
            zzr += zzbfa.zzq(7, this.zzalt.intValue());
        }
        if (this.zzalu != null) {
            zzr += zzbfa.zzq(8, this.zzalu.intValue());
        }
        if (this.zzalv != null) {
            zzr += zzbfa.zzb(9, (zzbfi) this.zzalv);
        }
        if (this.zzalw != null) {
            zzr += zzbfa.zzb(10, (zzbfi) this.zzalw);
        }
        if (this.zzalx != null && this.zzalx.length > 0) {
            int i = zzr;
            for (zzic zzic : this.zzalx) {
                if (zzic != null) {
                    i += zzbfa.zzb(11, (zzbfi) zzic);
                }
            }
            zzr = i;
        }
        if (this.zzaly != null) {
            zzr += zzbfa.zzb(12, (zzbfi) this.zzaly);
        }
        if (this.zzalz != null) {
            zzr += zzbfa.zzb(13, (zzbfi) this.zzalz);
        }
        if (this.zzama != null) {
            zzr += zzbfa.zzb(14, (zzbfi) this.zzama);
        }
        if (this.zzamb != null) {
            zzr += zzbfa.zzb(15, (zzbfi) this.zzamb);
        }
        if (this.zzamc != null) {
            zzr += zzbfa.zzb(16, (zzbfi) this.zzamc);
        }
        if (this.zzamd != null && this.zzamd.length > 0) {
            for (zziu zziu : this.zzamd) {
                if (zziu != null) {
                    zzr += zzbfa.zzb(17, (zzbfi) zziu);
                }
            }
        }
        return zzr;
    }
}
