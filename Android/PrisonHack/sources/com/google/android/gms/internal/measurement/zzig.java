package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class zzig extends zzhi {
    @VisibleForTesting
    protected zzif zzaov;
    private volatile zzif zzaow;
    private zzif zzaox;
    private final Map<Activity, zzif> zzaoy = new ArrayMap();
    private zzif zzaoz;
    private String zzapa;

    public zzig(zzgm zzgm) {
        super(zzgm);
    }

    @MainThread
    private final void zza(Activity activity, zzif zzif, boolean z) {
        zzif zzif2 = this.zzaow == null ? this.zzaox : this.zzaow;
        if (zzif.zzaos == null) {
            zzif = new zzif(zzif.zzul, zzbz(activity.getClass().getCanonicalName()), zzif.zzaot);
        }
        this.zzaox = this.zzaow;
        this.zzaow = zzif;
        zzge().zzc((Runnable) new zzih(this, z, zzif2, zzif));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@NonNull zzif zzif) {
        zzfu().zzk(zzbt().elapsedRealtime());
        if (zzgd().zzl(zzif.zzaou)) {
            zzif.zzaou = false;
        }
    }

    public static void zza(zzif zzif, Bundle bundle, boolean z) {
        if (bundle != null && zzif != null && (!bundle.containsKey("_sc") || z)) {
            if (zzif.zzul != null) {
                bundle.putString("_sn", zzif.zzul);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzif.zzaos);
            bundle.putLong("_si", zzif.zzaot);
        } else if (bundle != null && zzif == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @VisibleForTesting
    private static String zzbz(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final zzif zze(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzif zzif = this.zzaoy.get(activity);
        if (zzif != null) {
            return zzif;
        }
        zzif zzif2 = new zzif((String) null, zzbz(activity.getClass().getCanonicalName()), zzgc().zzlk());
        this.zzaoy.put(activity, zzif2);
        return zzif2;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @MainThread
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) != null) {
            this.zzaoy.put(activity, new zzif(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void onActivityDestroyed(Activity activity) {
        this.zzaoy.remove(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        zzif zze = zze(activity);
        this.zzaox = this.zzaow;
        this.zzaow = null;
        zzge().zzc((Runnable) new zzii(this, zze));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        zza(activity, zze(activity), false);
        zzdu zzfu = zzfu();
        zzfu.zzge().zzc((Runnable) new zzdx(zzfu, zzfu.zzbt().elapsedRealtime()));
    }

    @MainThread
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzif zzif;
        if (bundle != null && (zzif = this.zzaoy.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzif.zzaot);
            bundle2.putString("name", zzif.zzul);
            bundle2.putString("referrer_name", zzif.zzaos);
            bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        }
    }

    @MainThread
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        if (!zzec.isMainThread()) {
            zzgf().zziv().log("setCurrentScreen must be called from the main thread");
        } else if (this.zzaow == null) {
            zzgf().zziv().log("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzaoy.get(activity) == null) {
            zzgf().zziv().log("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzbz(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzaow.zzaos.equals(str2);
            boolean zzs = zzkc.zzs(this.zzaow.zzul, str);
            if (equals && zzs) {
                zzgf().zziw().log("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzgf().zziv().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzgf().zziz().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzif zzif = new zzif(str, str2, zzgc().zzlk());
                this.zzaoy.put(activity, zzif);
                zza(activity, zzif, true);
            } else {
                zzgf().zziv().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @WorkerThread
    public final void zza(String str, zzif zzif) {
        zzab();
        synchronized (this) {
            if (this.zzapa == null || this.zzapa.equals(str) || zzif != null) {
                this.zzapa = str;
                this.zzaoz = zzif;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
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

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return false;
    }

    @WorkerThread
    public final zzif zzkk() {
        zzch();
        zzab();
        return this.zzaov;
    }

    public final zzif zzkl() {
        zzfs();
        return this.zzaow;
    }
}
