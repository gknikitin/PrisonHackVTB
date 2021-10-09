package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;

final class zzjk extends zzeo {
    private final /* synthetic */ zzji zzaqg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjk(zzji zzji, zzhj zzhj) {
        super(zzhj);
        this.zzaqg = zzji;
    }

    @WorkerThread
    public final void run() {
        this.zzaqg.zzkt();
    }
}
