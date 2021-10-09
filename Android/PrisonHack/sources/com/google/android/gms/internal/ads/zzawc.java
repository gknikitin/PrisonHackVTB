package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzawc extends zzbbo<zzawc, zza> implements zzbcw {
    private static volatile zzbdf<zzawc> zzakh;
    /* access modifiers changed from: private */
    public static final zzawc zzdiy = new zzawc();
    private int zzdit;

    public static final class zza extends zzbbo.zza<zzawc, zza> implements zzbcw {
        private zza() {
            super(zzawc.zzdiy);
        }

        /* synthetic */ zza(zzawd zzawd) {
            this();
        }
    }

    static {
        zzbbo.zza(zzawc.class, zzdiy);
    }

    private zzawc() {
    }

    public static zzawc zzxi() {
        return zzdiy;
    }

    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzawc>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzawc> zzbdf;
        switch (zzawd.zzakf[i - 1]) {
            case 1:
                return new zzawc();
            case 2:
                return new zza((zzawd) null);
            case 3:
                return zza((zzbcu) zzdiy, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzdit"});
            case 4:
                return zzdiy;
            case 5:
                zzbdf<zzawc> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzawc.class) {
                    zzbdf<zzawc> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdiy);
                        zzakh = zzb;
                        zzbdf = zzb;
                    }
                }
                return zzbdf;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final int zzxb() {
        return this.zzdit;
    }
}
