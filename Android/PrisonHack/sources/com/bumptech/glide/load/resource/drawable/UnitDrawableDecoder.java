package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    public boolean handles(Drawable drawable, Options options) throws IOException {
        return true;
    }

    @Nullable
    public Resource<Drawable> decode(Drawable drawable, int i, int i2, Options options) throws IOException {
        return NonOwnedDrawableResource.newInstance(drawable);
    }
}
