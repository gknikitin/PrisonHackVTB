package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzbv;

@zzadh
public final class zzamt {
    private final View mView;
    private Activity zzcuj;
    private boolean zzcuk;
    private boolean zzcul;
    private boolean zzcum;
    private ViewTreeObserver.OnGlobalLayoutListener zzcun;
    private ViewTreeObserver.OnScrollChangedListener zzcuo;

    public zzamt(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzcuj = activity;
        this.mView = view;
        this.zzcun = onGlobalLayoutListener;
        this.zzcuo = onScrollChangedListener;
    }

    private static ViewTreeObserver zzj(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzse() {
        if (!this.zzcuk) {
            if (this.zzcun != null) {
                if (this.zzcuj != null) {
                    Activity activity = this.zzcuj;
                    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzcun;
                    ViewTreeObserver zzj = zzj(activity);
                    if (zzj != null) {
                        zzj.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                zzbv.zzfg();
                zzaor.zza(this.mView, this.zzcun);
            }
            if (this.zzcuo != null) {
                if (this.zzcuj != null) {
                    Activity activity2 = this.zzcuj;
                    ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzcuo;
                    ViewTreeObserver zzj2 = zzj(activity2);
                    if (zzj2 != null) {
                        zzj2.addOnScrollChangedListener(onScrollChangedListener);
                    }
                }
                zzbv.zzfg();
                zzaor.zza(this.mView, this.zzcuo);
            }
            this.zzcuk = true;
        }
    }

    private final void zzsf() {
        if (this.zzcuj != null && this.zzcuk) {
            if (this.zzcun != null) {
                Activity activity = this.zzcuj;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzcun;
                ViewTreeObserver zzj = zzj(activity);
                if (zzj != null) {
                    zzbv.zzem().zza(zzj, onGlobalLayoutListener);
                }
            }
            if (this.zzcuo != null) {
                Activity activity2 = this.zzcuj;
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzcuo;
                ViewTreeObserver zzj2 = zzj(activity2);
                if (zzj2 != null) {
                    zzj2.removeOnScrollChangedListener(onScrollChangedListener);
                }
            }
            this.zzcuk = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzcul = true;
        if (this.zzcum) {
            zzse();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzcul = false;
        zzsf();
    }

    public final void zzi(Activity activity) {
        this.zzcuj = activity;
    }

    public final void zzsc() {
        this.zzcum = true;
        if (this.zzcul) {
            zzse();
        }
    }

    public final void zzsd() {
        this.zzcum = false;
        zzsf();
    }
}
