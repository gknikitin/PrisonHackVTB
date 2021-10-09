package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzjd;
import com.google.android.gms.internal.measurement.zzjh;

public final class AppMeasurementService extends Service implements zzjh {
    private zzjd<AppMeasurementService> zzade;

    private final zzjd<AppMeasurementService> zzfq() {
        if (this.zzade == null) {
            this.zzade = new zzjd<>(this);
        }
        return this.zzade;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zzfq().onBind(intent);
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zzfq().onCreate();
    }

    @MainThread
    public final void onDestroy() {
        zzfq().onDestroy();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zzfq().onRebind(intent);
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzfq().onStartCommand(intent, i, i2);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zzfq().onUnbind(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzb(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
