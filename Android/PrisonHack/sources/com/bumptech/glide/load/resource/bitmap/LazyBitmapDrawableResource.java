package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;
    private final Resources resources;

    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap2) {
        return obtain(context.getResources(), Glide.get(context).getBitmapPool(), bitmap2);
    }

    public static LazyBitmapDrawableResource obtain(Resources resources2, BitmapPool bitmapPool2, Bitmap bitmap2) {
        return new LazyBitmapDrawableResource(resources2, bitmapPool2, bitmap2);
    }

    LazyBitmapDrawableResource(Resources resources2, BitmapPool bitmapPool2, Bitmap bitmap2) {
        this.resources = (Resources) Preconditions.checkNotNull(resources2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.bitmap = (Bitmap) Preconditions.checkNotNull(bitmap2);
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmap);
    }

    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    public void initialize() {
        this.bitmap.prepareToDraw();
    }
}
