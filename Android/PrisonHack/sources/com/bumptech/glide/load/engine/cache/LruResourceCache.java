package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put(key, resource);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove(key);
    }

    public LruResourceCache(int i) {
        super(i);
    }

    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(Key key, Resource<?> resource) {
        if (this.listener != null) {
            this.listener.onResourceRemoved(resource);
        }
    }

    /* access modifiers changed from: protected */
    public int getSize(Resource<?> resource) {
        return resource.getSize();
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20) {
            trimToSize(getCurrentSize() / 2);
        }
    }
}
