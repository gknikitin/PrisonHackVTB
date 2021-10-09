package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzavq extends zzbbo<zzavq, zza> implements zzbcw {
    private static volatile zzbdf<zzavq> zzakh;
    /* access modifiers changed from: private */
    public static final zzavq zzdin = new zzavq();
    private zzavu zzdil;
    private zzaxe zzdim;

    public static final class zza extends zzbbo.zza<zzavq, zza> implements zzbcw {
        private zza() {
            super(zzavq.zzdin);
        }

        /* synthetic */ zza(zzavr zzavr) {
            this();
        }
    }

    static {
        zzbbo.zza(zzavq.class, zzdin);
    }

    private zzavq() {
    }

    public static zzavq zzj(zzbah zzbah) throws zzbbu {
        return (zzavq) zzbbo.zza(zzdin, zzbah);
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzavq>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzavq> zzbdf;
        switch (zzavr.zzakf[i - 1]) {
            case 1:
                return new zzavq();
            case 2:
                return new zza((zzavr) null);
            case 3:
                return zza((zzbcu) zzdin, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzdil", "zzdim"});
            case 4:
                return zzdin;
            case 5:
                zzbdf<zzavq> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzavq.class) {
                    zzbdf<zzavq> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdin);
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

    public final zzavu zzwr() {
        return this.zzdil == null ? zzavu.zzwz() : this.zzdil;
    }

    public final zzaxe zzws() {
        return this.zzdim == null ? zzaxe.zzyq() : this.zzdim;
    }
}
