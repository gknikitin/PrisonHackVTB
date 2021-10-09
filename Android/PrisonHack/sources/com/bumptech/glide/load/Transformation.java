package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

public interface Transformation<T> extends Key {
    boolean equals(Object obj);

    int hashCode();

    Resource<T> transform(Context context, Resource<T> resource, int i, int i2);
}
