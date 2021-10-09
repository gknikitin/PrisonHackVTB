package com.mikepenz.fastadapter.utils;

import android.support.annotation.Nullable;

public class Triple<T, U, V> {
    public final T first;
    @Nullable
    public final U second;
    @Nullable
    public final V third;

    public Triple(T t, @Nullable U u, @Nullable V v) {
        this.first = t;
        this.second = u;
        this.third = v;
    }
}
