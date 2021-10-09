package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class zzy implements Handler.Callback {
    private final zzx zzbv;

    zzy(zzx zzx) {
        this.zzbv = zzx;
    }

    public final boolean handleMessage(Message message) {
        return this.zzbv.zza(message);
    }
}
