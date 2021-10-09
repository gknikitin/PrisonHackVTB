package com.google.android.gms.internal.ads;

import android.support.p000v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzaqi implements Runnable {
    private final /* synthetic */ String zzcce;
    private final /* synthetic */ String zzdba;
    private final /* synthetic */ int zzdbb;
    private final /* synthetic */ int zzdbc;
    private final /* synthetic */ boolean zzdbd = false;
    private final /* synthetic */ zzaqh zzdbe;

    zzaqi(zzaqh zzaqh, String str, String str2, int i, int i2, boolean z) {
        this.zzdbe = zzaqh;
        this.zzcce = str;
        this.zzdba = str2;
        this.zzdbb = i;
        this.zzdbc = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzcce);
        hashMap.put("cachedSrc", this.zzdba);
        hashMap.put("bytesLoaded", Integer.toString(this.zzdbb));
        hashMap.put("totalBytes", Integer.toString(this.zzdbc));
        hashMap.put("cacheReady", this.zzdbd ? "1" : "0");
        this.zzdbe.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
