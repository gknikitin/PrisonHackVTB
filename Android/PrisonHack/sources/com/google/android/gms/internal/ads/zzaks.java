package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;

@TargetApi(9)
public class zzaks extends zzakq {
    public zzaks() {
        super();
    }

    public boolean zza(DownloadManager.Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    public final int zzrl() {
        return 6;
    }

    public final int zzrm() {
        return 7;
    }
}
