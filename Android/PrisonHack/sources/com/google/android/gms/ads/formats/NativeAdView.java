package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzane;
import com.google.android.gms.internal.ads.zzkb;
import com.google.android.gms.internal.ads.zzqa;

public class NativeAdView extends FrameLayout {
    private final FrameLayout zzvh;
    private final zzqa zzvi = zzbf();

    public NativeAdView(Context context) {
        super(context);
        this.zzvh = zzb(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzvh = zzb(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzvh = zzb(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzvh = zzb(context);
    }

    private final FrameLayout zzb(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzqa zzbf() {
        Preconditions.checkNotNull(this.zzvh, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzkb.zzig().zza(this.zzvh.getContext(), (FrameLayout) this, this.zzvh);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzvh);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzvh != view) {
            super.bringChildToFront(this.zzvh);
        }
    }

    public void destroy() {
        try {
            this.zzvi.destroy();
        } catch (RemoteException e) {
            zzane.zzb("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View zzp = zzp(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzp instanceof AdChoicesView) {
            return (AdChoicesView) zzp;
        }
        return null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.zzvi != null) {
            try {
                this.zzvi.zzb(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzane.zzb("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzvh);
    }

    public void removeView(View view) {
        if (this.zzvh != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzvi.zza((IObjectWrapper) nativeAd.zzbe());
        } catch (RemoteException e) {
            zzane.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzvi.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzane.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzp(String str) {
        try {
            IObjectWrapper zzak = this.zzvi.zzak(str);
            if (zzak != null) {
                return (View) ObjectWrapper.unwrap(zzak);
            }
            return null;
        } catch (RemoteException e) {
            zzane.zzb("Unable to call getAssetView on delegate", e);
            return null;
        }
    }
}
