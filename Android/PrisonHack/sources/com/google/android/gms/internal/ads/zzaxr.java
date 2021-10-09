package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;
import java.util.List;

public final class zzaxr extends zzbbo<zzaxr, zza> implements zzbcw {
    private static volatile zzbdf<zzaxr> zzakh;
    /* access modifiers changed from: private */
    public static final zzaxr zzdlt = new zzaxr();
    private int zzdlq;
    private int zzdlr;
    private zzbbt<zzb> zzdls = zzadd();

    public static final class zza extends zzbbo.zza<zzaxr, zza> implements zzbcw {
        private zza() {
            super(zzaxr.zzdlt);
        }

        /* synthetic */ zza(zzaxs zzaxs) {
            this();
        }
    }

    public static final class zzb extends zzbbo<zzb, zza> implements zzbcw {
        private static volatile zzbdf<zzb> zzakh;
        /* access modifiers changed from: private */
        public static final zzb zzdlx = new zzb();
        private int zzdlj;
        private zzaxi zzdlu;
        private int zzdlv;
        private int zzdlw;

        public static final class zza extends zzbbo.zza<zzb, zza> implements zzbcw {
            private zza() {
                super(zzb.zzdlx);
            }

            /* synthetic */ zza(zzaxs zzaxs) {
                this();
            }
        }

        static {
            zzbbo.zza(zzb.class, zzdlx);
        }

        private zzb() {
        }

        /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxr$zzb>, com.google.android.gms.internal.ads.zzbbo$zzb] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzbdf<zzb> zzbdf;
            switch (zzaxs.zzakf[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzaxs) null);
                case 3:
                    return zza((zzbcu) zzdlx, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzdlu", "zzdlv", "zzdlw", "zzdlj"});
                case 4:
                    return zzdlx;
                case 5:
                    zzbdf<zzb> zzbdf2 = zzakh;
                    if (zzbdf2 != null) {
                        return zzbdf2;
                    }
                    synchronized (zzb.class) {
                        zzbdf<zzb> zzbdf3 = zzakh;
                        zzbdf = zzbdf3;
                        if (zzbdf3 == null) {
                            ? zzb = new zzbbo.zzb(zzdlx);
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

        public final boolean zzzo() {
            return this.zzdlu != null;
        }

        public final zzaxi zzzp() {
            return this.zzdlu == null ? zzaxi.zzza() : this.zzdlu;
        }

        public final zzaxl zzzq() {
            zzaxl zzax = zzaxl.zzax(this.zzdlv);
            return zzax == null ? zzaxl.UNRECOGNIZED : zzax;
        }

        public final int zzzr() {
            return this.zzdlw;
        }

        public final zzayd zzzs() {
            zzayd zzbg = zzayd.zzbg(this.zzdlj);
            return zzbg == null ? zzayd.UNRECOGNIZED : zzbg;
        }
    }

    static {
        zzbbo.zza(zzaxr.class, zzdlt);
    }

    private zzaxr() {
    }

    public static zzaxr zzj(byte[] bArr) throws zzbbu {
        return (zzaxr) zzbbo.zzb(zzdlt, bArr);
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxr>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaxr> zzbdf;
        switch (zzaxs.zzakf[i - 1]) {
            case 1:
                return new zzaxr();
            case 2:
                return new zza((zzaxs) null);
            case 3:
                return zza((zzbcu) zzdlt, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdlq", "zzdlr", "zzdls", zzb.class});
            case 4:
                return zzdlt;
            case 5:
                zzbdf<zzaxr> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaxr.class) {
                    zzbdf<zzaxr> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb2 = new zzbbo.zzb(zzdlt);
                        zzakh = zzb2;
                        zzbdf = zzb2;
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

    public final int zzzk() {
        return this.zzdlr;
    }

    public final List<zzb> zzzl() {
        return this.zzdls;
    }

    public final int zzzm() {
        return this.zzdls.size();
    }
}
