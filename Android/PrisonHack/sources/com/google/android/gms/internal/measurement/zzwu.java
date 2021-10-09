package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.support.p000v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class zzwu<T> {
    private static final Object zzbno = new Object();
    private static boolean zzbnp = false;
    private static volatile Boolean zzbnq;
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzqx;
    private final zzxe zzbnr;
    final String zzbns;
    private final String zzbnt;
    private final T zzbnu;
    private T zzbnv;
    private volatile zzwr zzbnw;
    private volatile SharedPreferences zzbnx;

    private zzwu(zzxe zzxe, String str, T t) {
        this.zzbnv = null;
        this.zzbnw = null;
        this.zzbnx = null;
        if (zzxe.zzbod == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzbnr = zzxe;
        String valueOf = String.valueOf(zzxe.zzboe);
        String valueOf2 = String.valueOf(str);
        this.zzbnt = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(zzxe.zzbof);
        String valueOf4 = String.valueOf(str);
        this.zzbns = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        this.zzbnu = t;
    }

    /* synthetic */ zzwu(zzxe zzxe, String str, Object obj, zzwy zzwy) {
        this(zzxe, str, obj);
    }

    public static void init(Context context) {
        synchronized (zzbno) {
            if (Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (zzqx != context) {
                zzbnq = null;
            }
            zzqx = context;
        }
        zzbnp = false;
    }

    /* access modifiers changed from: private */
    public static zzwu<Double> zza(zzxe zzxe, String str, double d) {
        return new zzxb(zzxe, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzwu<Integer> zza(zzxe zzxe, String str, int i) {
        return new zzwz(zzxe, str, Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public static zzwu<Long> zza(zzxe zzxe, String str, long j) {
        return new zzwy(zzxe, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzwu<String> zza(zzxe zzxe, String str, String str2) {
        return new zzxc(zzxe, str, str2);
    }

    /* access modifiers changed from: private */
    public static zzwu<Boolean> zza(zzxe zzxe, String str, boolean z) {
        return new zzxa(zzxe, str, Boolean.valueOf(z));
    }

    private static <V> V zza(zzxd<V> zzxd) {
        long clearCallingIdentity;
        try {
            return zzxd.zzsl();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzsl = zzxd.zzsl();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzsl;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    static boolean zzd(String str, boolean z) {
        try {
            if (zzsj()) {
                return ((Boolean) zza(new zzwx(str, false))).booleanValue();
            }
            return false;
        } catch (SecurityException e) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e);
            return false;
        }
    }

    @TargetApi(24)
    @Nullable
    private final T zzsh() {
        if (zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String valueOf = String.valueOf(this.zzbns);
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
            return null;
        } else if (this.zzbnr.zzbod != null) {
            if (this.zzbnw == null) {
                this.zzbnw = zzwr.zza(zzqx.getContentResolver(), this.zzbnr.zzbod);
            }
            String str = (String) zza(new zzwv(this, this.zzbnw));
            if (str != null) {
                return zzex(str);
            }
            return null;
        } else {
            zzxe zzxe = this.zzbnr;
            return null;
        }
    }

    @Nullable
    private final T zzsi() {
        zzxe zzxe = this.zzbnr;
        if (!zzsj()) {
            return null;
        }
        try {
            String str = (String) zza(new zzww(this));
            if (str != null) {
                return zzex(str);
            }
            return null;
        } catch (SecurityException e) {
            String valueOf = String.valueOf(this.zzbns);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Unable to read GServices for flag: ".concat(valueOf) : new String("Unable to read GServices for flag: "), e);
            return null;
        }
    }

    private static boolean zzsj() {
        if (zzbnq == null) {
            boolean z = false;
            if (zzqx == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(zzqx, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzbnq = Boolean.valueOf(z);
        }
        return zzbnq.booleanValue();
    }

    public final T get() {
        if (zzqx == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        zzxe zzxe = this.zzbnr;
        T zzsh = zzsh();
        if (zzsh != null) {
            return zzsh;
        }
        T zzsi = zzsi();
        return zzsi != null ? zzsi : this.zzbnu;
    }

    /* access modifiers changed from: protected */
    public abstract T zzex(String str);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzsk() {
        return zzwp.zza(zzqx.getContentResolver(), this.zzbnt, (String) null);
    }
}
