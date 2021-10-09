package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable
    private Animatable animatable;

    /* access modifiers changed from: protected */
    public abstract void setResource(@Nullable Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onResourceReady(Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z, this)) {
            setResourceInternal(z);
        } else {
            maybeUpdateAnimatable(z);
        }
    }

    public void onStart() {
        if (this.animatable != null) {
            this.animatable.start();
        }
    }

    public void onStop() {
        if (this.animatable != null) {
            this.animatable.stop();
        }
    }

    private void setResourceInternal(@Nullable Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    private void maybeUpdateAnimatable(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.animatable = (Animatable) z;
            this.animatable.start();
            return;
        }
        this.animatable = null;
    }
}
