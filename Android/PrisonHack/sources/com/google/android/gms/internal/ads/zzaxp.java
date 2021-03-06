package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

public final class zzaxp extends zzbbo<zzaxp, zza> implements zzbcw {
    private static volatile zzbdf<zzaxp> zzakh;
    /* access modifiers changed from: private */
    public static final zzaxp zzdlp = new zzaxp();
    private String zzdks = "";
    private String zzdll = "";
    private int zzdlm;
    private boolean zzdln;
    private String zzdlo = "";

    public static final class zza extends zzbbo.zza<zzaxp, zza> implements zzbcw {
        private zza() {
            super(zzaxp.zzdlp);
        }

        /* synthetic */ zza(zzaxq zzaxq) {
            this();
        }

        public final zza zzao(boolean z) {
            zzadh();
            ((zzaxp) this.zzdtx).zzan(true);
            return this;
        }

        public final zza zzaz(int i) {
            zzadh();
            ((zzaxp) this.zzdtx).zzay(0);
            return this;
        }

        public final zza zzee(String str) {
            zzadh();
            ((zzaxp) this.zzdtx).zzec(str);
            return this;
        }

        public final zza zzef(String str) {
            zzadh();
            ((zzaxp) this.zzdtx).zzea(str);
            return this;
        }

        public final zza zzeg(String str) {
            zzadh();
            ((zzaxp) this.zzdtx).zzed(str);
            return this;
        }
    }

    static {
        zzbbo.zza(zzaxp.class, zzdlp);
    }

    private zzaxp() {
    }

    /* access modifiers changed from: private */
    public final void zzan(boolean z) {
        this.zzdln = z;
    }

    /* access modifiers changed from: private */
    public final void zzay(int i) {
        this.zzdlm = i;
    }

    /* access modifiers changed from: private */
    public final void zzea(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdks = str;
    }

    /* access modifiers changed from: private */
    public final void zzec(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdll = str;
    }

    /* access modifiers changed from: private */
    public final void zzed(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdlo = str;
    }

    public static zza zzzi() {
        return (zza) ((zzbbo.zza) zzdlp.zza(zzbbo.zze.zzdue, (Object) null, (Object) null));
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzaxp>, com.google.android.gms.internal.ads.zzbbo$zzb] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzbdf<zzaxp> zzbdf;
        switch (zzaxq.zzakf[i - 1]) {
            case 1:
                return new zzaxp();
            case 2:
                return new zza((zzaxq) null);
            case 3:
                return zza((zzbcu) zzdlp, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0006\u0000\u0000\u0000\u0001??\u0002??\u0003\u000b\u0004\u0007\u0005??", new Object[]{"zzdll", "zzdks", "zzdlm", "zzdln", "zzdlo"});
            case 4:
                return zzdlp;
            case 5:
                zzbdf<zzaxp> zzbdf2 = zzakh;
                if (zzbdf2 != null) {
                    return zzbdf2;
                }
                synchronized (zzaxp.class) {
                    zzbdf<zzaxp> zzbdf3 = zzakh;
                    zzbdf = zzbdf3;
                    if (zzbdf3 == null) {
                        ? zzb = new zzbbo.zzb(zzdlp);
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

    public final String zzyw() {
        return this.zzdks;
    }

    public final String zzze() {
        return this.zzdll;
    }

    public final int zzzf() {
        return this.zzdlm;
    }

    public final boolean zzzg() {
        return this.zzdln;
    }

    public final String zzzh() {
        return this.zzdlo;
    }
}
