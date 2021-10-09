package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

public final class zzfy {
    /* access modifiers changed from: private */
    public final zzgm zzacw;
    @VisibleForTesting
    volatile zzr zzalf;
    @VisibleForTesting
    private ServiceConnection zzalg;

    zzfy(zzgm zzgm) {
        this.zzacw = zzgm;
    }

    @VisibleForTesting
    private final boolean zzjp() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zzacw.getContext());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zzacw.zzgf().zzix().log("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e) {
            this.zzacw.zzgf().zzix().zzg("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzc(Bundle bundle) {
        zzfj zzis;
        String str;
        this.zzacw.zzge().zzab();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzis = this.zzacw.zzgf().zzis();
                str = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzis = this.zzacw.zzgf().zzis();
                    str = "No referrer defined in install referrer response";
                } else {
                    this.zzacw.zzgf().zziz().zzg("InstallReferrer API result", string);
                    zzkc zzgc = this.zzacw.zzgc();
                    String valueOf = String.valueOf(string);
                    Bundle zza = zzgc.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza == null) {
                        zzis = this.zzacw.zzgf().zzis();
                        str = "No campaign params defined in install referrer result";
                    } else {
                        String string2 = zza.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzis = this.zzacw.zzgf().zzis();
                                str = "Install Referrer is missing click timestamp for ad campaign";
                            } else {
                                zza.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == this.zzacw.zzgg().zzakj.get()) {
                            zzis = this.zzacw.zzgf().zziz();
                            str = "Campaign has already been logged";
                        } else {
                            zza.putString("_cis", "referrer API");
                            this.zzacw.zzgg().zzakj.set(j);
                            this.zzacw.zzfv().logEvent("auto", "_cmp", zza);
                            if (this.zzalg != null) {
                                ConnectionTracker.getInstance().unbindService(this.zzacw.getContext(), this.zzalg);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            zzis.log(str);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzjo() {
        this.zzacw.zzgi();
        this.zzacw.zzge().zzab();
        if (!zzjp()) {
            this.zzacw.zzgf().zzix().log("Install Referrer Reporter is not available");
            this.zzalg = null;
            return;
        }
        this.zzalg = new zzga(this);
        this.zzacw.zzgf().zzix().log("Install Referrer Reporter is initializing");
        this.zzacw.zzge().zzab();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zzacw.getContext().getPackageManager();
        if (packageManager == null) {
            this.zzacw.zzgf().zziv().log("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zzacw.zzgf().zzix().log("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || this.zzalg == null || !"com.android.vending".equals(str) || !zzjp()) {
                this.zzacw.zzgf().zzix().log("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.zzacw.zzgf().zzix().zzg("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zzacw.getContext(), new Intent(intent), this.zzalg, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.zzacw.zzgf().zzis().zzg("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    @VisibleForTesting
    public final Bundle zzjq() {
        this.zzacw.zzge().zzab();
        if (this.zzalf == null) {
            this.zzacw.zzgf().zziv().log("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.zzacw.getContext().getPackageName());
        try {
            Bundle zza = this.zzalf.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.zzacw.zzgf().zzis().log("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zzacw.zzgf().zzis().zzg("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
