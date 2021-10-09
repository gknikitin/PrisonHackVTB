package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzp implements Runnable {
    private final zzo zzbg;
    private final Bundle zzbh;
    private final TaskCompletionSource zzbi;

    zzp(zzo zzo, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.zzbg = zzo;
        this.zzbh = bundle;
        this.zzbi = taskCompletionSource;
    }

    public final void run() {
        this.zzbg.zza(this.zzbh, this.zzbi);
    }
}
