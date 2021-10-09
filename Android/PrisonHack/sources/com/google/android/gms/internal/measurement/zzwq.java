package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzwq extends ContentObserver {
    zzwq(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzwp.zzbmw.set(true);
    }
}
