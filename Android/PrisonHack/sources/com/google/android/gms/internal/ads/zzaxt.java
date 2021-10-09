package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzaxt extends zzbbo<zzaxt, zza> implements zzbcw {
    private static volatile zzbdf<zzaxt> zzakh;
    /* access modifiers changed from: private */
    public static final zzaxt zzdlz = new zzaxt();
    private int zzdlq;
    private int zzdlr;
    private zzbbt<zzb> zzdly = zzadd();

    public static final class zza extends zzbbo.zza<zzaxt, zza> implements zzbcw {
        private zza() {
            super(zzaxt.zzdlz);
        }

        /* synthetic */ zza(zzaxu zzaxu) {
            this();
        }

        public final zza zzb(zzb zzb) {
            zzadh();
            ((zzaxt) this.zzdtx).zza(zzb);
            return this;
        }

        public final zza zzbb(int i) {
            zzadh();
            ((zzaxt) this.zzdtx).zzba(i);
            return this;
        }
    }

    public static final class zzb extends zzbbo<zzb, zza> implements zzbcw {
        private static volatile zzbdf<zzb> zzakh;
        /* access modifiers changed from: private */
        public static final zzb zzdma = new zzb();
        private String zzdks = "";
        private int zzdlj;
        private int zzdlv;
        private int zzdlw;

        public static final class zza extends zzbbo.zza<zzb, zza> implements zzbcw {
            private zza() {
                super(zzb.zzdma);
            }

            /* synthetic */ zza(zzaxu zzaxu) {
                this();
            }

            public final zza zzb(zzaxl zzaxl) {
                zzadh();
                ((zzb) this.zzdtx).zza(zzaxl);
                return this;
            }

            public final zza zzb(zzayd zzayd) {
                zzadh();
                ((zzb) this.zzdtx).zza(zzayd);
                return this;
            }

            public final zza zzbd(int i) {
                zzadh();
                ((zzb) this.zzdtx).zzbc(i);
                return this;
            }

            public final zza zzeh(String str) {
                zzadh();
                ((zzb) this.zzdtx).zzea(str);
                return this;
            }
        }

        static {
            zzbbo.zza(zzb.class, zzdma);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzaxl zzaxl) {
            if (zzaxl == null) {
                throw new NullPointerException();
            }
            this.zzdlv = zzaxl.zzhq();
        }

        /* access modifiers changed from: private */
        public final void zza(zzayd zzayd) {
            if (zzayd == null) {
                throw new NullPointerException();
            }
            this.zzdlj = zzayd.zzhq();
        }

        /* access modifiers changed from: private */
        public final void zzbc(int i) {
            this.zzdlw = i;
        }

        /* access modifiers changed from: private */
        public final void zzea(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzdks = str;
        }

        public static zza zzzw() {
            return (zza) ((zzbbo.zza) zzdma.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
        }

        /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxt$zzb>, com.google.android.gms.internal.ads.zzbbo$zzb] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzbdf<zzb> zzbdf;
            switch (zzaxu.zzakf[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzaxu) null);
                case 3:
                    return zza((zzbcu) zzdma, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzdks", "zzdlv", "zzdlw", "zzdlj"});
                case 4:
                    return zzdma;
                case 5:
                    zzbdf<zzb> zzbdf2 = zzakh;
                    if (zzbdf2 != null) {
                        return zzbdf2;
                    }
                    synchronized (zzb.class) {
                        zzbdf<zzb> zzbdf3 = zzakh;
                        zzbdf = zzbdf3;
                        if (zzbdf3 == null) {
                            ? zzb = new zzbbo.zzb(zzdma);
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
    }

    static {
        zzbbo.zza(zzaxt.class, zzdlz);
    }

    private zzaxt() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 == null) {
            throw new NullPointerException();
        }
        if (!this.zzdly.zzaay()) {
            zzbbt<zzb> zzbbt = this.zzdly;
            int size = zzbbt.size();
            this.zzdly = zzbbt.zzbm(size == 0 ? 10 : size << 1);
        }
        this.zzdly.add(zzb2);
    }

    /* access modifiers changed from: private */
    public final void zzba(int i) {
        this.zzdlr = i;
    }

    public static zza zzzu() {
        return (zza) ((zzbbo.zza) zzdlz.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxt>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaxt> zzbdf;
        switch (zzaxu.zzakf[i - 1]) {
            case 1:
                return new zzaxt();
            case 2:
                return new zza((zzaxu) null);
            case 3:
                return zza((zzbcu) zzdlz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdlq", "zzdlr", "zzdly", zzb.class});
            case 4:
                return zzdlz;
            case 5:
                zzbdf<zzaxt> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaxt.class) {
                    zzbdf<zzaxt> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb2 = new zzbbo.zzb(zzdlz);
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
}
