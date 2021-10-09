package com.bumptech.glide.load;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(T t, int i, int i2, Options options) throws IOException;

    boolean handles(T t, Options options) throws IOException;
}
