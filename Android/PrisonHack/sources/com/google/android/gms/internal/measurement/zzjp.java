package com.google.android.gms.internal.measurement;

final class zzjp extends zzeo {
    private final /* synthetic */ zzjs zzaqc;
    private final /* synthetic */ zzjo zzaqi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjp(zzjo zzjo, zzhj zzhj, zzjs zzjs) {
        super(zzhj);
        this.zzaqi = zzjo;
        this.zzaqc = zzjs;
    }

    public final void run() {
        this.zzaqi.cancel();
        this.zzaqi.zzgf().zziz().log("Starting upload from DelayedRunnable");
        this.zzaqc.zzlb();
    }
}
