package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, int i) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            @Nullable
            private File getInternalCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            public File getCacheDirectory() {
                File externalCacheDir;
                File internalCacheDirectory = getInternalCacheDirectory();
                if ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null) {
                    return str != null ? new File(externalCacheDir, str) : externalCacheDir;
                }
                return internalCacheDirectory;
            }
        }, i);
    }
}
