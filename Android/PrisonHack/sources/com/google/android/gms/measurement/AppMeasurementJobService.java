package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzjd;
import com.google.android.gms.internal.measurement.zzjh;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjh {
    private zzjd<AppMeasurementJobService> zzade;

    private final zzjd<AppMeasurementJobService> zzfq() {
        if (this.zzade == null) {
            this.zzade = new zzjd<>(this);
        }
        return this.zzade;
    }

    public final boolean callServiceStopSelfResult(int i) {
        throw new UnsupportedOperationException();
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

    public final boolean onStartJob(JobParameters jobParameters) {
        return zzfq().onStartJob(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zzfq().onUnbind(intent);
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzb(Intent intent) {
    }
}
