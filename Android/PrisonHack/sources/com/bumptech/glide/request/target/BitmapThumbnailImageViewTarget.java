package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    public BitmapThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public BitmapThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* access modifiers changed from: protected */
    public Drawable getDrawable(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.view).getResources(), bitmap);
    }
}
