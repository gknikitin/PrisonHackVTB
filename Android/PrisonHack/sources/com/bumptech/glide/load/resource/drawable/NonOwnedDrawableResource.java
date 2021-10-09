package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    public void recycle() {
    }

    public static Resource<Drawable> newInstance(Drawable drawable) {
        return new NonOwnedDrawableResource(drawable);
    }

    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }
}
