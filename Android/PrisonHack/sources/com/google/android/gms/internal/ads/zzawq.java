package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzawq extends zzbbo<zzawq, zza> implements zzbcw {
    private static volatile zzbdf<zzawq> zzakh;
    /* access modifiers changed from: private */
    public static final zzawq zzdjo = new zzawq();
    private zzaww zzdjl;
    private zzawm zzdjm;
    private int zzdjn;

    public static final class zza extends zzbbo.zza<zzawq, zza> implements zzbcw {
        private zza() {
            super(zzawq.zzdjo);
        }

        /* synthetic */ zza(zzawr zzawr) {
            this();
        }
    }

    static {
        zzbbo.zza(zzawq.class, zzdjo);
    }

    private zzawq() {
    }

    public static zzawq zzxx() {
        return zzdjo;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzawq>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzawq> zzbdf;
        switch (zzawr.zzakf[i - 1]) {
            case 1:
                return new zzawq();
            case 2:
                return new zza((zzawr) null);
            case 3:
                return zza((zzbcu) zzdjo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzdjl", "zzdjm", "zzdjn"});
            case 4:
                return zzdjo;
            case 5:
                zzbdf<zzawq> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzawq.class) {
                    zzbdf<zzawq> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdjo);
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

    public final zzaww zzxu() {
        return this.zzdjl == null ? zzaww.zzyk() : this.zzdjl;
    }

    public final zzawm zzxv() {
        return this.zzdjm == null ? zzawm.zzxq() : this.zzdjm;
    }

    public final zzawk zzxw() {
        zzawk zzaq = zzawk.zzaq(this.zzdjn);
        return zzaq == null ? zzawk.UNRECOGNIZED : zzaq;
    }
}
