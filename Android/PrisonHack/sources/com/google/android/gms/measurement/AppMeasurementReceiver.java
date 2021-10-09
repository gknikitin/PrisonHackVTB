package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.p000v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzgf {
    private zzgc zzadd;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @MainThread
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.zzadd == null) {
            this.zzadd = new zzgc(this);
        }
        this.zzadd.onReceive(context, intent);
    }
}
