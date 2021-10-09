package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzey;
import java.lang.reflect.InvocationTargetException;

public final class zzeg extends zzhh {
    @NonNull
    private zzei zzaeu = zzeh.zzaev;
    private Boolean zzxz;

    zzeg(zzgm zzgm) {
        super(zzgm);
    }

    static String zzhi() {
        return zzey.zzagp.get();
    }

    public static long zzhl() {
        return zzey.zzahs.get().longValue();
    }

    public static long zzhm() {
        return zzey.zzags.get().longValue();
    }

    public static boolean zzho() {
        return zzey.zzago.get().booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzey.zza<Long> zza) {
        if (str != null) {
            String zze = this.zzaeu.zze(str, zza.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zza.get(Long.valueOf(Long.parseLong(zze))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zza.get().longValue();
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzei zzei) {
        this.zzaeu = zzei;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    @WorkerThread
    public final int zzaq(@Size(min = 1) String str) {
        return zzb(str, zzey.zzahd);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public final Boolean zzar(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzgf().zzis().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzgf().zzis().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzgf().zzis().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzgf().zzis().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzas(String str) {
        return "1".equals(this.zzaeu.zze(str, "gaia_collection_enabled"));
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzaeu.zze(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzau(String str) {
        return zzd(str, zzey.zzaib);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzav(String str) {
        return zzd(str, zzey.zzaid);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzaw(String str) {
        return zzd(str, zzey.zzaie);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzax(String str) {
        return zzd(str, zzey.zzaif);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzay(String str) {
        return zzd(str, zzey.zzaig);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzaz(String str) {
        return zzd(str, zzey.zzaij);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzey.zza<Integer> zza) {
        if (str != null) {
            String zze = this.zzaeu.zze(str, zza.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zza.get(Integer.valueOf(Integer.parseInt(zze))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zza.get().intValue();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzey.zza<Double> zza) {
        if (str != null) {
            String zze = this.zzaeu.zze(str, zza.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zza.get(Double.valueOf(Double.parseDouble(zze))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zza.get().doubleValue();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.measurement.zzey$zza, com.google.android.gms.internal.measurement.zzey$zza<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.String r3, @android.support.annotation.NonNull com.google.android.gms.internal.measurement.zzey.zza<java.lang.Boolean> r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000d
        L_0x0002:
            java.lang.Object r3 = r4.get()
        L_0x0006:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        L_0x000d:
            com.google.android.gms.internal.measurement.zzei r0 = r2.zzaeu
            java.lang.String r1 = r4.getKey()
            java.lang.String r3 = r0.zze(r3, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x001e
            goto L_0x0002
        L_0x001e:
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.Object r3 = r4.get(r3)
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeg.zzd(java.lang.String, com.google.android.gms.internal.measurement.zzey$zza):boolean");
    }

    public final boolean zzds() {
        if (this.zzxz == null) {
            synchronized (this) {
                if (this.zzxz == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzxz = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzxz == null) {
                        this.zzxz = Boolean.TRUE;
                        zzgf().zzis().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzxz.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ void zzft() {
        super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzdu zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzhl zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzeq zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzij zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzig zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfd zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzff zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzkc zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzji zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzgh zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfh zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzfs zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzeg zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzec zzgi() {
        return super.zzgi();
    }

    public final boolean zzhj() {
        zzgi();
        Boolean zzar = zzar("firebase_analytics_collection_deactivated");
        return zzar != null && zzar.booleanValue();
    }

    public final Boolean zzhk() {
        zzgi();
        return zzar("firebase_analytics_collection_enabled");
    }

    public final String zzhn() {
        String str;
        zzfj zzfj;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            e = e;
            zzfj = zzgf().zzis();
            str = "Could not find SystemProperties class";
            zzfj.zzg(str, e);
            return "";
        } catch (NoSuchMethodException e2) {
            e = e2;
            zzfj = zzgf().zzis();
            str = "Could not find SystemProperties.get() method";
            zzfj.zzg(str, e);
            return "";
        } catch (IllegalAccessException e3) {
            e = e3;
            zzfj = zzgf().zzis();
            str = "Could not access SystemProperties.get()";
            zzfj.zzg(str, e);
            return "";
        } catch (InvocationTargetException e4) {
            e = e4;
            zzfj = zzgf().zzis();
            str = "SystemProperties.get() threw an exception";
            zzfj.zzg(str, e);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzhp() {
        return zzd(zzfw().zzah(), zzey.zzahw);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzhq() {
        String zzah = zzfw().zzah();
        zzey.zza zza = zzey.zzahx;
        return (String) (zzah == null ? zza.get() : zza.get(this.zzaeu.zze(zzah, zza.getKey())));
    }
}
