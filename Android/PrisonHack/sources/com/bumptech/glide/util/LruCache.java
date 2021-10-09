package com.bumptech.glide.util;

import android.support.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    /* access modifiers changed from: protected */
    public int getSize(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(T t, Y y) {
    }

    public LruCache(int i) {
        this.initialMaxSize = i;
        this.maxSize = i;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            try {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.maxSize = Math.round(((float) this.initialMaxSize) * f);
            evict();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized int getMaxSize() {
        return this.maxSize;
    }

    public synchronized int getCurrentSize() {
        return this.currentSize;
    }

    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    @Nullable
    public synchronized Y get(T t) {
        return this.cache.get(t);
    }

    public synchronized Y put(T t, Y y) {
        if (getSize(y) >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        Y put = this.cache.put(t, y);
        if (y != null) {
            this.currentSize += getSize(y);
        }
        if (put != null) {
            this.currentSize -= getSize(put);
        }
        evict();
        return put;
    }

    @Nullable
    public synchronized Y remove(T t) {
        Y remove;
        remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public void clearMemory() {
        trimToSize(0);
    }

    /* access modifiers changed from: protected */
    public synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            Map.Entry next = this.cache.entrySet().iterator().next();
            Object value = next.getValue();
            this.currentSize -= getSize(value);
            Object key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }
}
