package com.google.firebase.iid;

import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzk implements Runnable {
    private final FirebaseInstanceId zzau;
    private final String zzav;
    private final String zzaw;
    private final TaskCompletionSource zzax;
    private final String zzay;

    zzk(FirebaseInstanceId firebaseInstanceId, String str, String str2, TaskCompletionSource taskCompletionSource, String str3) {
        this.zzau = firebaseInstanceId;
        this.zzav = str;
        this.zzaw = str2;
        this.zzax = taskCompletionSource;
        this.zzay = str3;
    }

    public final void run() {
        this.zzau.zza(this.zzav, this.zzaw, this.zzax, this.zzay);
    }
}
