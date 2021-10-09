package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzaws extends zzbbo<zzaws, zza> implements zzbcw {
    private static volatile zzbdf<zzaws> zzakh;
    /* access modifiers changed from: private */
    public static final zzaws zzdjq = new zzaws();
    private int zzdih;
    private zzbah zzdip = zzbah.zzdpq;
    private zzawu zzdjp;

    public static final class zza extends zzbbo.zza<zzaws, zza> implements zzbcw {
        private zza() {
            super(zzaws.zzdjq);
        }

        /* synthetic */ zza(zzawt zzawt) {
            this();
        }

        public final zza zzar(int i) {
            zzadh();
            ((zzaws) this.zzdtx).setVersion(0);
            return this;
        }

        public final zza zzb(zzawu zzawu) {
            zzadh();
            ((zzaws) this.zzdtx).zza(zzawu);
            return this;
        }

        public final zza zzy(zzbah zzbah) {
            zzadh();
            ((zzaws) this.zzdtx).zzk(zzbah);
            return this;
        }
    }

    static {
        zzbbo.zza(zzaws.class, zzdjq);
    }

    private zzaws() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzdih = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzawu zzawu) {
        if (zzawu == null) {
            throw new NullPointerException();
        }
        this.zzdjp = zzawu;
    }

    /* access modifiers changed from: private */
    public final void zzk(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdip = zzbah;
    }

    public static zzaws zzx(zzbah zzbah) throws zzbbu {
        return (zzaws) zzbbo.zza(zzdjq, zzbah);
    }

    public static zza zzya() {
        return (zza) ((zzbbo.zza) zzdjq.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
    }

    public final int getVersion() {
        return this.zzdih;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaws>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaws> zzbdf;
        switch (zzawt.zzakf[i - 1]) {
            case 1:
                return new zzaws();
            case 2:
                return new zza((zzawt) null);
            case 3:
                return zza((zzbcu) zzdjq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzdih", "zzdjp", "zzdip"});
            case 4:
                return zzdjq;
            case 5:
                zzbdf<zzaws> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaws.class) {
                    zzbdf<zzaws> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdjq);
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

    public final zzbah zzwv() {
        return this.zzdip;
    }

    public final zzawu zzxz() {
        return this.zzdjp == null ? zzawu.zzyf() : this.zzdjp;
    }
}
