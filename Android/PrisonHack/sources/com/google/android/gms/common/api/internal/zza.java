package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zza extends ActivityLifecycleObserver {
    private final WeakReference<C0716zza> zzds;

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zza$zza  reason: collision with other inner class name */
    static class C0716zza extends LifecycleCallback {
        private List<Runnable> zzdt = new ArrayList();

        private C0716zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public static C0716zza zza(Activity activity) {
            C0716zza zza;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zza = (C0716zza) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0716zza.class);
                if (zza == null) {
                    zza = new C0716zza(fragment);
                }
            }
            return zza;
        }

        /* access modifiers changed from: private */
        public final synchronized void zza(Runnable runnable) {
            this.zzdt.add(runnable);
        }

        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zzdt;
                this.zzdt = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public zza(Activity activity) {
        this(C0716zza.zza(activity));
    }

    @VisibleForTesting(otherwise = 2)
    private zza(C0716zza zza) {
        this.zzds = new WeakReference<>(zza);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0716zza zza = (C0716zza) this.zzds.get();
        if (zza == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        zza.zza(runnable);
        return this;
    }
}
