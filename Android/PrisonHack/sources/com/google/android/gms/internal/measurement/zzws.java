package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzws extends ContentObserver {
    private final /* synthetic */ zzwr zzbnn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzws(zzwr zzwr, Handler handler) {
        super((Handler) null);
        this.zzbnn = zzwr;
    }

    public final void onChange(boolean z) {
        this.zzbnn.zzsd();
        this.zzbnn.zzsf();
    }
}
