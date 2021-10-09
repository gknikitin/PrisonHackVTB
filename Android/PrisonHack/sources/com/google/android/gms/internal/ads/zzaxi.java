package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzaxi extends zzbbo<zzaxi, zza> implements zzbcw {
    private static volatile zzbdf<zzaxi> zzakh;
    /* access modifiers changed from: private */
    public static final zzaxi zzdkv = new zzaxi();
    private String zzdks = "";
    private zzbah zzdkt = zzbah.zzdpq;
    private int zzdku;

    public static final class zza extends zzbbo.zza<zzaxi, zza> implements zzbcw {
        private zza() {
            super(zzaxi.zzdkv);
        }

        /* synthetic */ zza(zzaxj zzaxj) {
            this();
        }

        public final zza zzai(zzbah zzbah) {
            zzadh();
            ((zzaxi) this.zzdtx).zzah(zzbah);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzadh();
            ((zzaxi) this.zzdtx).zza(zzb);
            return this;
        }

        public final zza zzeb(String str) {
            zzadh();
            ((zzaxi) this.zzdtx).zzea(str);
            return this;
        }
    }

    public enum zzb implements zzbbr {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzbbs<zzb> zzall = null;
        private final int value;

        static {
            zzall = new zzaxk();
        }

        private zzb(int i) {
            this.value = i;
        }

        public static zzb zzaw(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        public final int zzhq() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzbbo.zza(zzaxi.class, zzdkv);
    }

    private zzaxi() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 == null) {
            throw new NullPointerException();
        }
        this.zzdku = zzb2.zzhq();
    }

    /* access modifiers changed from: private */
    public final void zzah(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdkt = zzbah;
    }

    /* access modifiers changed from: private */
    public final void zzea(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdks = str;
    }

    public static zza zzyz() {
        return (zza) ((zzbbo.zza) zzdkv.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
    }

    public static zzaxi zzza() {
        return zzdkv;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbbo$zzb, com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxi>] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaxi> zzbdf;
        switch (zzaxj.zzakf[i - 1]) {
            case 1:
                return new zzaxi();
            case 2:
                return new zza((zzaxj) null);
            case 3:
                return zza((zzbcu) zzdkv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzdks", "zzdkt", "zzdku"});
            case 4:
                return zzdkv;
            case 5:
                zzbdf<zzaxi> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaxi.class) {
                    zzbdf<zzaxi> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb2 = new zzbbo.zzb(zzdkv);
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

    public final String zzyw() {
        return this.zzdks;
    }

    public final zzbah zzyx() {
        return this.zzdkt;
    }

    public final zzb zzyy() {
        zzb zzaw = zzb.zzaw(this.zzdku);
        return zzaw == null ? zzb.UNRECOGNIZED : zzaw;
    }
}
