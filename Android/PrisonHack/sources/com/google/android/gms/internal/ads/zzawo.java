package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzawo extends zzbbo<zzawo, zza> implements zzbcw {
    private static volatile zzbdf<zzawo> zzakh;
    /* access modifiers changed from: private */
    public static final zzawo zzdjk = new zzawo();
    private zzawq zzdjj;

    public static final class zza extends zzbbo.zza<zzawo, zza> implements zzbcw {
        private zza() {
            super(zzawo.zzdjk);
        }

        /* synthetic */ zza(zzawp zzawp) {
            this();
        }
    }

    static {
        zzbbo.zza(zzawo.class, zzdjk);
    }

    private zzawo() {
    }

    public static zzawo zzw(zzbah zzbah) throws zzbbu {
        return (zzawo) zzbbo.zza(zzdjk, zzbah);
    }

    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzawo>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzawo> zzbdf;
        switch (zzawp.zzakf[i - 1]) {
            case 1:
                return new zzawo();
            case 2:
                return new zza((zzawp) null);
            case 3:
                return zza((zzbcu) zzdjk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\t", new Object[]{"zzdjj"});
            case 4:
                return zzdjk;
            case 5:
                zzbdf<zzawo> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzawo.class) {
                    zzbdf<zzawo> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdjk);
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

    public final zzawq zzxs() {
        return this.zzdjj == null ? zzawq.zzxx() : this.zzdjj;
    }
}
