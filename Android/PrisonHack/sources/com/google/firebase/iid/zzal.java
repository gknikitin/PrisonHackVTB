package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzal implements Continuation {
    private final zzak zzci;
    private final Pair zzcj;

    zzal(zzak zzak, Pair pair) {
        this.zzci = zzak;
        this.zzcj = pair;
    }

    public final Object then(Task task) {
        return this.zzci.zza(this.zzcj, task);
    }
}
