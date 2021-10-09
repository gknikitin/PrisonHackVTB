package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzl implements zzam {
    private final FirebaseInstanceId zzau;
    private final String zzav;
    private final String zzaw;
    private final String zzaz;

    zzl(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.zzau = firebaseInstanceId;
        this.zzav = str;
        this.zzaw = str2;
        this.zzaz = str3;
    }

    public final Task zzo() {
        return this.zzau.zza(this.zzav, this.zzaw, this.zzaz);
    }
}
