package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzboq;
    private final AppMeasurement zzbop;
    @VisibleForTesting
    private final Map<String, Object> zzbor = new ConcurrentHashMap();

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzbop = appMeasurement;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector getInstance(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzboq == null) {
            synchronized (AnalyticsConnector.class) {
                if (zzboq == null) {
                    zzboq = new AnalyticsConnectorImpl(AppMeasurement.getInstance(context));
                }
            }
        }
        return zzboq;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str2 == null || zzb.zza(str2, bundle)) {
            this.zzbop.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @WorkerThread
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty zzd : this.zzbop.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzb.zzd(zzd));
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzbop.getMaxUserProperties(str);
    }

    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzbop.getUserProperties(z);
    }

    @WorkerThread
    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzb.zzfb(str) && zzb.zza(str2, bundle) && zzb.zzb(str, str2, bundle)) {
            this.zzbop.logEventInternal(str, str2, bundle);
        }
    }

    @WorkerThread
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzb.zzfb(str)) {
            return null;
        }
        if (!str.isEmpty() && this.zzbor.containsKey(str) && this.zzbor.get(str) != null) {
        }
        return null;
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzb.zza(conditionalUserProperty)) {
            this.zzbop.setConditionalUserProperty(zzb.zzb(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
        if (!zzb.zzfb(str) || !zzb.zzfc(str2)) {
            return;
        }
        if ((!str2.equals("_ce1") && !str2.equals("_ce2")) || str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            this.zzbop.setUserPropertyInternal(str, str2, obj);
        }
    }
}
