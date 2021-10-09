package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class zzdi implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzsy = new Handler(Looper.getMainLooper());
    private final zzcz zzps;
    private Application zzrk;
    private final Context zzsz;
    private final PowerManager zzta;
    private final KeyguardManager zztb;
    private BroadcastReceiver zztc;
    private WeakReference<ViewTreeObserver> zztd;
    private WeakReference<View> zzte;
    private zzcn zztf;
    private boolean zztg = false;
    private int zzth = -1;
    private long zzti = -3;

    public zzdi(zzcz zzcz, View view) {
        this.zzps = zzcz;
        this.zzsz = zzcz.zzrt;
        this.zzta = (PowerManager) this.zzsz.getSystemService("power");
        this.zztb = (KeyguardManager) this.zzsz.getSystemService("keyguard");
        if (this.zzsz instanceof Application) {
            this.zzrk = (Application) this.zzsz;
            this.zztf = new zzcn((Application) this.zzsz, this);
        }
        zzd(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzte != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzte.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzth = i;
            }
        }
    }

    private final void zzao() {
        zzsy.post(new zzdj(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        if (r4 == false) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaq() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzte
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzte
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 != 0) goto L_0x0017
            r2 = -3
            r9.zzti = r2
            r9.zztg = r1
            return
        L_0x0017:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            boolean r2 = r0.getGlobalVisibleRect(r2)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r3 = r0.getLocalVisibleRect(r3)
            com.google.android.gms.internal.ads.zzcz r4 = r9.zzps
            boolean r4 = r4.zzai()
            r5 = 1
            if (r4 != 0) goto L_0x005d
            android.app.KeyguardManager r4 = r9.zztb
            boolean r4 = r4.inKeyguardRestrictedInputMode()
            if (r4 == 0) goto L_0x005b
            android.app.Activity r4 = com.google.android.gms.internal.ads.zzdg.zzc(r0)
            if (r4 == 0) goto L_0x0057
            android.view.Window r4 = r4.getWindow()
            if (r4 != 0) goto L_0x0048
            r4 = 0
            goto L_0x004c
        L_0x0048:
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
        L_0x004c:
            if (r4 == 0) goto L_0x0057
            int r4 = r4.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0057
            r4 = 1
            goto L_0x0058
        L_0x0057:
            r4 = 0
        L_0x0058:
            if (r4 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r4 = 0
            goto L_0x005e
        L_0x005d:
            r4 = 1
        L_0x005e:
            int r6 = r0.getWindowVisibility()
            int r7 = r9.zzth
            r8 = -1
            if (r7 == r8) goto L_0x0069
            int r6 = r9.zzth
        L_0x0069:
            int r7 = r0.getVisibility()
            if (r7 != 0) goto L_0x0086
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L_0x0086
            android.os.PowerManager r0 = r9.zzta
            boolean r0 = r0.isScreenOn()
            if (r0 == 0) goto L_0x0086
            if (r4 == 0) goto L_0x0086
            if (r3 == 0) goto L_0x0086
            if (r2 == 0) goto L_0x0086
            if (r6 != 0) goto L_0x0086
            r1 = 1
        L_0x0086:
            boolean r0 = r9.zztg
            if (r0 == r1) goto L_0x0097
            if (r1 == 0) goto L_0x0091
            long r2 = android.os.SystemClock.elapsedRealtime()
            goto L_0x0093
        L_0x0091:
            r2 = -2
        L_0x0093:
            r9.zzti = r2
            r9.zztg = r1
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdi.zzaq():void");
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zztd = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zztc == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zztc = new zzdk(this);
            this.zzsz.registerReceiver(this.zztc, intentFilter);
        }
        if (this.zzrk != null) {
            try {
                this.zzrk.registerActivityLifecycleCallbacks(this.zztf);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC, Splitter:B:17:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzf(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r3.zztd     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x001d
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r3.zztd     // Catch:{ Exception -> 0x001d }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x001d }
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x001b
            boolean r2 = r1.isAlive()     // Catch:{ Exception -> 0x001d }
            if (r2 == 0) goto L_0x001b
            r1.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x001d }
            r1.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x001d }
        L_0x001b:
            r3.zztd = r0     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()     // Catch:{ Exception -> 0x002d }
            boolean r1 = r4.isAlive()     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x002d
            r4.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x002d }
            r4.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            android.content.BroadcastReceiver r4 = r3.zztc
            if (r4 == 0) goto L_0x003a
            android.content.Context r4 = r3.zzsz     // Catch:{ Exception -> 0x0038 }
            android.content.BroadcastReceiver r1 = r3.zztc     // Catch:{ Exception -> 0x0038 }
            r4.unregisterReceiver(r1)     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r3.zztc = r0
        L_0x003a:
            android.app.Application r4 = r3.zzrk
            if (r4 == 0) goto L_0x0045
            android.app.Application r4 = r3.zzrk     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.internal.ads.zzcn r0 = r3.zztf     // Catch:{ Exception -> 0x0045 }
            r4.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdi.zzf(android.view.View):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzaq();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzaq();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzaq();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzaq();
        zzao();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzaq();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzaq();
    }

    public final void onActivityStopped(Activity activity) {
        zzaq();
    }

    public final void onGlobalLayout() {
        zzaq();
    }

    public final void onScrollChanged() {
        zzaq();
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzth = -1;
        zze(view);
        zzaq();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzth = -1;
        zzaq();
        zzao();
        zzf(view);
    }

    public final long zzap() {
        if (this.zzti == -2 && this.zzte.get() == null) {
            this.zzti = -3;
        }
        return this.zzti;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        long j;
        View view2 = this.zzte != null ? (View) this.zzte.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzte = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.zzti = j;
    }
}
