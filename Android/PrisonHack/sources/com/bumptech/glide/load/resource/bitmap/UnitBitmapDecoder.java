package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.io.IOException;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    private static final BitmapPoolAdapter BITMAP_POOL = new BitmapPoolAdapter();

    public boolean handles(Bitmap bitmap, Options options) throws IOException {
        return true;
    }

    @Nullable
    public Resource<Bitmap> decode(Bitmap bitmap, int i, int i2, Options options) throws IOException {
        return new BitmapResource(bitmap, BITMAP_POOL);
    }
}
