package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzaxx extends zzbbo<zzaxx, zza> implements zzbcw {
    private static volatile zzbdf<zzaxx> zzakh;
    /* access modifiers changed from: private */
    public static final zzaxx zzdme = new zzaxx();
    private String zzdmd = "";

    public static final class zza extends zzbbo.zza<zzaxx, zza> implements zzbcw {
        private zza() {
            super(zzaxx.zzdme);
        }

        /* synthetic */ zza(zzaxy zzaxy) {
            this();
        }
    }

    static {
        zzbbo.zza(zzaxx.class, zzdme);
    }

    private zzaxx() {
    }

    public static zzaxx zzaac() {
        return zzdme;
    }

    public static zzaxx zzak(zzbah zzbah) throws zzbbu {
        return (zzaxx) zzbbo.zza(zzdme, zzbah);
    }

    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxx>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaxx> zzbdf;
        switch (zzaxy.zzakf[i - 1]) {
            case 1:
                return new zzaxx();
            case 2:
                return new zza((zzaxy) null);
            case 3:
                return zza((zzbcu) zzdme, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzdmd"});
            case 4:
                return zzdme;
            case 5:
                zzbdf<zzaxx> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaxx.class) {
                    zzbdf<zzaxx> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdme);
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

    public final String zzaab() {
        return this.zzdmd;
    }
}
