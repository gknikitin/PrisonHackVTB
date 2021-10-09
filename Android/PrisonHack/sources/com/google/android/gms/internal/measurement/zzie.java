package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;

@TargetApi(14)
@MainThread
final class zzie implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhl zzaog;

    private zzie(zzhl zzhl) {
        this.zzaog = zzhl;
    }

    /* synthetic */ zzie(zzhl zzhl, zzhm zzhm) {
        this(zzhl);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            this.zzaog.zzgf().zziz().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (!(intent == null || (data = intent.getData()) == null || !data.isHierarchical())) {
                if (bundle == null) {
                    Bundle zza = this.zzaog.zzgc().zza(data);
                    this.zzaog.zzgc();
                    String str = zzkc.zzd(intent) ? "gs" : "auto";
                    if (zza != null) {
                        this.zzaog.logEvent(str, "_cmp", zza);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                        this.zzaog.zzgf().zziy().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                        return;
                    }
                    this.zzaog.zzgf().zziy().zzg("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.zzaog.setUserProperty("auto", "_ldl", queryParameter);
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            this.zzaog.zzgf().zzis().zzg("Throwable caught in onActivityCreated", e);
        }
        this.zzaog.zzfz().onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzaog.zzfz().onActivityDestroyed(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zzaog.zzfz().onActivityPaused(activity);
        zzji zzgd = this.zzaog.zzgd();
        zzgd.zzge().zzc((Runnable) new zzjm(zzgd, zzgd.zzbt().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.zzaog.zzfz().onActivityResumed(activity);
        zzji zzgd = this.zzaog.zzgd();
        zzgd.zzge().zzc((Runnable) new zzjl(zzgd, zzgd.zzbt().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzaog.zzfz().onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
