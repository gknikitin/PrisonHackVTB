package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzavo extends zzbbo<zzavo, zza> implements zzbcw {
    private static volatile zzbdf<zzavo> zzakh;
    /* access modifiers changed from: private */
    public static final zzavo zzdik = new zzavo();
    private int zzdih;
    private zzavs zzdii;
    private zzaxc zzdij;

    public static final class zza extends zzbbo.zza<zzavo, zza> implements zzbcw {
        private zza() {
            super(zzavo.zzdik);
        }

        /* synthetic */ zza(zzavp zzavp) {
            this();
        }

        public final zza zzal(int i) {
            zzadh();
            ((zzavo) this.zzdtx).setVersion(i);
            return this;
        }

        public final zza zzb(zzavs zzavs) {
            zzadh();
            ((zzavo) this.zzdtx).zza(zzavs);
            return this;
        }

        public final zza zzb(zzaxc zzaxc) {
            zzadh();
            ((zzavo) this.zzdtx).zza(zzaxc);
            return this;
        }
    }

    static {
        zzbbo.zza(zzavo.class, zzdik);
    }

    private zzavo() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzdih = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzavs zzavs) {
        if (zzavs == null) {
            throw new NullPointerException();
        }
        this.zzdii = zzavs;
    }

    /* access modifiers changed from: private */
    public final void zza(zzaxc zzaxc) {
        if (zzaxc == null) {
            throw new NullPointerException();
        }
        this.zzdij = zzaxc;
    }

    public static zzavo zzi(zzbah zzbah) throws zzbbu {
        return (zzavo) zzbbo.zza(zzdik, zzbah);
    }

    public static zza zzwp() {
        return (zza) ((zzbbo.zza) zzdik.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
    }

    public final int getVersion() {
        return this.zzdih;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzavo>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzavo> zzbdf;
        switch (zzavp.zzakf[i - 1]) {
            case 1:
                return new zzavo();
            case 2:
                return new zza((zzavp) null);
            case 3:
                return zza((zzbcu) zzdik, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzdih", "zzdii", "zzdij"});
            case 4:
                return zzdik;
            case 5:
                zzbdf<zzavo> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzavo.class) {
                    zzbdf<zzavo> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdik);
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

    public final zzavs zzwn() {
        return this.zzdii == null ? zzavs.zzwx() : this.zzdii;
    }

    public final zzaxc zzwo() {
        return this.zzdij == null ? zzaxc.zzyo() : this.zzdij;
    }
}
