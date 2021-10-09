package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool2) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool2;
    }

    public boolean handles(Uri uri, Options options) throws IOException {
        return "android.resource".equals(uri.getScheme());
    }

    @Nullable
    public Resource<Bitmap> decode(Uri uri, int i, int i2, Options options) throws IOException {
        return DrawableToBitmapConverter.convert(this.bitmapPool, this.drawableDecoder.decode(uri, i, i2, options).get(), i, i2);
    }
}
