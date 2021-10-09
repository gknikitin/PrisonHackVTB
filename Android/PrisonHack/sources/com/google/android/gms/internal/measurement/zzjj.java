package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.support.annotation.WorkerThread;

final class zzjj extends zzeo {
    private final /* synthetic */ zzji zzaqg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjj(zzji zzji, zzhj zzhj) {
        super(zzhj);
        this.zzaqg = zzji;
    }

    @WorkerThread
    public final void run() {
        zzji zzji = this.zzaqg;
        zzji.zzab();
        zzji.zzgf().zziz().zzg("Session started, time", Long.valueOf(zzji.zzbt().elapsedRealtime()));
        zzji.zzgg().zzakt.set(false);
        zzji.zzfv().zza("auto", "_s", new Bundle());
        zzji.zzgg().zzaku.set(zzji.zzbt().currentTimeMillis());
    }
}
