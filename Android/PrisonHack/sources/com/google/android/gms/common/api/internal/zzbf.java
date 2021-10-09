package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzbf extends Handler {
    private final /* synthetic */ zzbd zzjh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzbd zzbd, Looper looper) {
        super(looper);
        this.zzjh = zzbd;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((zzbe) message.obj).zzc(this.zzjh);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                int i = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GACStateManager", sb.toString());
                return;
        }
    }
}
