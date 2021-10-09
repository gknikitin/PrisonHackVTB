package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;

public final class zzbv {
    public final RegisterListenerMethod<Api.AnyClient, ?> zzlt;
    public final UnregisterListenerMethod<Api.AnyClient, ?> zzlu;

    public zzbv(@NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        this.zzlt = registerListenerMethod;
        this.zzlu = unregisterListenerMethod;
    }
}
