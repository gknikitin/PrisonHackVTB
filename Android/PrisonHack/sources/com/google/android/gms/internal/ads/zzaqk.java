package com.google.android.gms.internal.ads;

import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import info.fandroid.quiz.data.constant.AppConstant;
import java.util.HashMap;
import java.util.Map;

final class zzaqk implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzcce;
    private final /* synthetic */ String zzdba;
    private final /* synthetic */ zzaqh zzdbe;
    private final /* synthetic */ String zzdbf;

    zzaqk(zzaqh zzaqh, String str, String str2, String str3, String str4) {
        this.zzdbe = zzaqh;
        this.zzcce = str;
        this.zzdba = str2;
        this.zzdbf = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzcce);
        if (!TextUtils.isEmpty(this.zzdba)) {
            hashMap.put("cachedSrc", this.zzdba);
        }
        hashMap.put("type", zzaqh.zzdq(this.zzdbf));
        hashMap.put("reason", this.zzdbf);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put(AppConstant.BUNDLE_KEY_MESSAGE, this.val$message);
        }
        this.zzdbe.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
