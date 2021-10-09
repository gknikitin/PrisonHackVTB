package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements ComponentRegistrar {

    private static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zzcg;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zzcg = firebaseInstanceId;
        }

        public final String getId() {
            return this.zzcg.getId();
        }

        public final String getToken() {
            return this.zzcg.getToken();
        }
    }

    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).factory(zzai.zzcf).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzaj.zzcf).build()});
    }
}
