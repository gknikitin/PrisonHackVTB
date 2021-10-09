package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbb extends zzbfc<zzbb> {
    private static volatile zzbb[] zzfo;
    public Long zzdo = null;
    public Long zzdp = null;
    public Long zzfp = null;
    public Long zzfq = null;
    public Long zzfr = null;
    public Long zzfs = null;
    public Integer zzft;
    public Long zzfu = null;
    public Long zzfv = null;
    public Long zzfw = null;
    public Integer zzfx;
    public Long zzfy = null;
    public Long zzfz = null;
    public Long zzga = null;
    public Long zzgb = null;
    public Long zzgc = null;
    public Long zzgd = null;
    public Long zzge = null;
    public Long zzgf = null;
    private Long zzgg = null;
    private Long zzgh = null;

    public zzbb() {
        this.zzebt = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbb zza(com.google.android.gms.internal.ads.zzbez r4) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r4.zzabk()
            switch(r0) {
                case 0: goto L_0x0118;
                case 8: goto L_0x010c;
                case 16: goto L_0x0100;
                case 24: goto L_0x00f4;
                case 32: goto L_0x00e8;
                case 40: goto L_0x00dc;
                case 48: goto L_0x00d0;
                case 56: goto L_0x00b4;
                case 64: goto L_0x00a8;
                case 72: goto L_0x009c;
                case 80: goto L_0x0090;
                case 88: goto L_0x007c;
                case 96: goto L_0x0071;
                case 104: goto L_0x0066;
                case 112: goto L_0x005b;
                case 120: goto L_0x0050;
                case 128: goto L_0x0045;
                case 136: goto L_0x003a;
                case 144: goto L_0x002f;
                case 152: goto L_0x0024;
                case 160: goto L_0x0019;
                case 168: goto L_0x000e;
                default: goto L_0x0007;
            }
        L_0x0007:
            boolean r0 = super.zza(r4, r0)
            if (r0 != 0) goto L_0x0000
            return r3
        L_0x000e:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgh = r0
            goto L_0x0000
        L_0x0019:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgg = r0
            goto L_0x0000
        L_0x0024:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgf = r0
            goto L_0x0000
        L_0x002f:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzge = r0
            goto L_0x0000
        L_0x003a:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgd = r0
            goto L_0x0000
        L_0x0045:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgc = r0
            goto L_0x0000
        L_0x0050:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzgb = r0
            goto L_0x0000
        L_0x005b:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzga = r0
            goto L_0x0000
        L_0x0066:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfz = r0
            goto L_0x0000
        L_0x0071:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfy = r0
            goto L_0x0000
        L_0x007c:
            int r1 = r4.getPosition()
            int r2 = r4.zzacc()     // Catch:{ IllegalArgumentException -> 0x00c8 }
            int r2 = com.google.android.gms.internal.ads.zzaz.zzd(r2)     // Catch:{ IllegalArgumentException -> 0x00c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x00c8 }
            r3.zzfx = r2     // Catch:{ IllegalArgumentException -> 0x00c8 }
            goto L_0x0000
        L_0x0090:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfw = r0
            goto L_0x0000
        L_0x009c:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfv = r0
            goto L_0x0000
        L_0x00a8:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfu = r0
            goto L_0x0000
        L_0x00b4:
            int r1 = r4.getPosition()
            int r2 = r4.zzacc()     // Catch:{ IllegalArgumentException -> 0x00c8 }
            int r2 = com.google.android.gms.internal.ads.zzaz.zzd(r2)     // Catch:{ IllegalArgumentException -> 0x00c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x00c8 }
            r3.zzft = r2     // Catch:{ IllegalArgumentException -> 0x00c8 }
            goto L_0x0000
        L_0x00c8:
            r4.zzdc(r1)
            r3.zza(r4, r0)
            goto L_0x0000
        L_0x00d0:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfs = r0
            goto L_0x0000
        L_0x00dc:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfr = r0
            goto L_0x0000
        L_0x00e8:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfq = r0
            goto L_0x0000
        L_0x00f4:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzfp = r0
            goto L_0x0000
        L_0x0100:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzdp = r0
            goto L_0x0000
        L_0x010c:
            long r0 = r4.zzacd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.zzdo = r0
            goto L_0x0000
        L_0x0118:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbb.zza(com.google.android.gms.internal.ads.zzbez):com.google.android.gms.internal.ads.zzbb");
    }

    public static zzbb[] zzs() {
        if (zzfo == null) {
            synchronized (zzbfg.zzebs) {
                if (zzfo == null) {
                    zzfo = new zzbb[0];
                }
            }
        }
        return zzfo;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzdo != null) {
            zzbfa.zzi(1, this.zzdo.longValue());
        }
        if (this.zzdp != null) {
            zzbfa.zzi(2, this.zzdp.longValue());
        }
        if (this.zzfp != null) {
            zzbfa.zzi(3, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzbfa.zzi(4, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzbfa.zzi(5, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzbfa.zzi(6, this.zzfs.longValue());
        }
        if (this.zzft != null) {
            zzbfa.zzm(7, this.zzft.intValue());
        }
        if (this.zzfu != null) {
            zzbfa.zzi(8, this.zzfu.longValue());
        }
        if (this.zzfv != null) {
            zzbfa.zzi(9, this.zzfv.longValue());
        }
        if (this.zzfw != null) {
            zzbfa.zzi(10, this.zzfw.longValue());
        }
        if (this.zzfx != null) {
            zzbfa.zzm(11, this.zzfx.intValue());
        }
        if (this.zzfy != null) {
            zzbfa.zzi(12, this.zzfy.longValue());
        }
        if (this.zzfz != null) {
            zzbfa.zzi(13, this.zzfz.longValue());
        }
        if (this.zzga != null) {
            zzbfa.zzi(14, this.zzga.longValue());
        }
        if (this.zzgb != null) {
            zzbfa.zzi(15, this.zzgb.longValue());
        }
        if (this.zzgc != null) {
            zzbfa.zzi(16, this.zzgc.longValue());
        }
        if (this.zzgd != null) {
            zzbfa.zzi(17, this.zzgd.longValue());
        }
        if (this.zzge != null) {
            zzbfa.zzi(18, this.zzge.longValue());
        }
        if (this.zzgf != null) {
            zzbfa.zzi(19, this.zzgf.longValue());
        }
        if (this.zzgg != null) {
            zzbfa.zzi(20, this.zzgg.longValue());
        }
        if (this.zzgh != null) {
            zzbfa.zzi(21, this.zzgh.longValue());
        }
        super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = super.zzr();
        if (this.zzdo != null) {
            zzr += zzbfa.zzd(1, this.zzdo.longValue());
        }
        if (this.zzdp != null) {
            zzr += zzbfa.zzd(2, this.zzdp.longValue());
        }
        if (this.zzfp != null) {
            zzr += zzbfa.zzd(3, this.zzfp.longValue());
        }
        if (this.zzfq != null) {
            zzr += zzbfa.zzd(4, this.zzfq.longValue());
        }
        if (this.zzfr != null) {
            zzr += zzbfa.zzd(5, this.zzfr.longValue());
        }
        if (this.zzfs != null) {
            zzr += zzbfa.zzd(6, this.zzfs.longValue());
        }
        if (this.zzft != null) {
            zzr += zzbfa.zzq(7, this.zzft.intValue());
        }
        if (this.zzfu != null) {
            zzr += zzbfa.zzd(8, this.zzfu.longValue());
        }
        if (this.zzfv != null) {
            zzr += zzbfa.zzd(9, this.zzfv.longValue());
        }
        if (this.zzfw != null) {
            zzr += zzbfa.zzd(10, this.zzfw.longValue());
        }
        if (this.zzfx != null) {
            zzr += zzbfa.zzq(11, this.zzfx.intValue());
        }
        if (this.zzfy != null) {
            zzr += zzbfa.zzd(12, this.zzfy.longValue());
        }
        if (this.zzfz != null) {
            zzr += zzbfa.zzd(13, this.zzfz.longValue());
        }
        if (this.zzga != null) {
            zzr += zzbfa.zzd(14, this.zzga.longValue());
        }
        if (this.zzgb != null) {
            zzr += zzbfa.zzd(15, this.zzgb.longValue());
        }
        if (this.zzgc != null) {
            zzr += zzbfa.zzd(16, this.zzgc.longValue());
        }
        if (this.zzgd != null) {
            zzr += zzbfa.zzd(17, this.zzgd.longValue());
        }
        if (this.zzge != null) {
            zzr += zzbfa.zzd(18, this.zzge.longValue());
        }
        if (this.zzgf != null) {
            zzr += zzbfa.zzd(19, this.zzgf.longValue());
        }
        if (this.zzgg != null) {
            zzr += zzbfa.zzd(20, this.zzgg.longValue());
        }
        return this.zzgh != null ? zzr + zzbfa.zzd(21, this.zzgh.longValue()) : zzr;
    }
}
