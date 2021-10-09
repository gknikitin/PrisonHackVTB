package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;

final class zzht implements Runnable {
    private final /* synthetic */ zzhl zzaog;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaol;

    zzht(zzhl zzhl, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzaog = zzhl;
        this.zzaol = conditionalUserProperty;
    }

    public final void run() {
        this.zzaog.zzc(this.zzaol);
    }
}
