package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzm implements OnCompleteListener {
    private final FirebaseInstanceId zzau;
    private final String zzav;
    private final String zzaw;
    private final TaskCompletionSource zzax;

    zzm(FirebaseInstanceId firebaseInstanceId, String str, String str2, TaskCompletionSource taskCompletionSource) {
        this.zzau = firebaseInstanceId;
        this.zzav = str;
        this.zzaw = str2;
        this.zzax = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zzau.zza(this.zzav, this.zzaw, this.zzax, task);
    }
}
