package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzawm extends zzbbo<zzawm, zza> implements zzbcw {
    private static volatile zzbdf<zzawm> zzakh;
    /* access modifiers changed from: private */
    public static final zzawm zzdji = new zzawm();
    private zzaxn zzdjh;

    public static final class zza extends zzbbo.zza<zzawm, zza> implements zzbcw {
        private zza() {
            super(zzawm.zzdji);
        }

        /* synthetic */ zza(zzawn zzawn) {
            this();
        }
    }

    static {
        zzbbo.zza(zzawm.class, zzdji);
    }

    private zzawm() {
    }

    public static zzawm zzxq() {
        return zzdji;
    }

    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzawm>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzawm> zzbdf;
        switch (zzawn.zzakf[i - 1]) {
            case 1:
                return new zzawm();
            case 2:
                return new zza((zzawn) null);
            case 3:
                return zza((zzbcu) zzdji, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0003\u0000\u0000\u0000\u0002\t", new Object[]{"zzdjh"});
            case 4:
                return zzdji;
            case 5:
                zzbdf<zzawm> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzawm.class) {
                    zzbdf<zzawm> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdji);
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

    public final zzaxn zzxp() {
        return this.zzdjh == null ? zzaxn.zzzc() : this.zzdjh;
    }
}
