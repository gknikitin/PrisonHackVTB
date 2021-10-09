package com.google.firebase.iid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

final class zzr implements Continuation<Bundle, String> {
    private final /* synthetic */ zzo zzbj;

    zzr(zzo zzo) {
        this.zzbj = zzo;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return zzo.zza((Bundle) task.getResult(IOException.class));
    }
}
