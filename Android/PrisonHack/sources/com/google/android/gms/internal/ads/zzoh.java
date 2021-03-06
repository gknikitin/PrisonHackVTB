package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzoh implements zzbfy {
    @Nullable
    private CustomTabsSession zzbgw;
    @Nullable
    private CustomTabsClient zzbgx;
    @Nullable
    private CustomTabsServiceConnection zzbgy;
    @Nullable
    private zzoi zzbgz;

    public static boolean zzh(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzbfw.zzbn(context));
                }
            }
        }
        return false;
    }

    public final boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.zzbgx == null) {
            return false;
        }
        if (this.zzbgx == null) {
            this.zzbgw = null;
        } else if (this.zzbgw == null) {
            this.zzbgw = this.zzbgx.newSession((CustomTabsCallback) null);
        }
        CustomTabsSession customTabsSession = this.zzbgw;
        if (customTabsSession == null) {
            return false;
        }
        return customTabsSession.mayLaunchUrl(uri, (Bundle) null, (List<Bundle>) null);
    }

    public final void zza(CustomTabsClient customTabsClient) {
        this.zzbgx = customTabsClient;
        this.zzbgx.warmup(0);
        if (this.zzbgz != null) {
            this.zzbgz.zzjp();
        }
    }

    public final void zza(zzoi zzoi) {
        this.zzbgz = zzoi;
    }

    public final void zzc(Activity activity) {
        if (this.zzbgy != null) {
            activity.unbindService(this.zzbgy);
            this.zzbgx = null;
            this.zzbgw = null;
            this.zzbgy = null;
        }
    }

    public final void zzd(Activity activity) {
        String zzbn;
        if (this.zzbgx == null && (zzbn = zzbfw.zzbn(activity)) != null) {
            this.zzbgy = new zzbfx(this);
            CustomTabsClient.bindCustomTabsService(activity, zzbn, this.zzbgy);
        }
    }

    public final void zzjo() {
        this.zzbgx = null;
        this.zzbgw = null;
        if (this.zzbgz != null) {
            this.zzbgz.zzjq();
        }
    }
}
