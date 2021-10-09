package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzao extends Handler {
    private final /* synthetic */ zzan zzcp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzan zzan, Looper looper) {
        super(looper);
        this.zzcp = zzan;
    }

    public final void handleMessage(Message message) {
        this.zzcp.zzb(message);
    }
}
