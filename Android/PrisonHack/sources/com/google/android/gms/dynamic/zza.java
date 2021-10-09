package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

final class zza implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zza(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(T t) {
        LifecycleDelegate unused = this.zzabg.zzabc = t;
        Iterator it = this.zzabg.zzabe.iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zza) it.next()).zza(this.zzabg.zzabc);
        }
        this.zzabg.zzabe.clear();
        Bundle unused2 = this.zzabg.zzabd = null;
    }
}
