package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzamp implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzcub;

    zzamp(zzamn zzamn, Context context, Context context2) {
        this.zzcub = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzcub != null) {
            zzakb.m39v("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzcub.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzakb.m39v("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzakb.m39v("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzakb.m39v("Persisting user agent.");
            }
        }
        return string;
    }
}
