package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = new LruCache<>(50);
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    public ResourceCacheKey(Key key, Key key2, int i, int i2, Transformation<?> transformation2, Class<?> cls, Options options2) {
        this.sourceKey = key;
        this.signature = key2;
        this.width = i;
        this.height = i2;
        this.transformation = transformation2;
        this.decodedResourceClass = cls;
        this.options = options2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.height != resourceCacheKey.height || this.width != resourceCacheKey.width || !Util.bothNullOrEqual(this.transformation, resourceCacheKey.transformation) || !this.decodedResourceClass.equals(resourceCacheKey.decodedResourceClass) || !this.sourceKey.equals(resourceCacheKey.sourceKey) || !this.signature.equals(resourceCacheKey.signature) || !this.options.equals(resourceCacheKey.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        if (this.transformation != null) {
            hashCode = (hashCode * 31) + this.transformation.hashCode();
        }
        return (((hashCode * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(array);
        if (this.transformation != null) {
            this.transformation.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(getResourceClassBytes());
    }

    private byte[] getResourceClassBytes() {
        byte[] bArr = RESOURCE_CLASS_BYTES.get(this.decodedResourceClass);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.decodedResourceClass.getName().getBytes(CHARSET);
        RESOURCE_CLASS_BYTES.put(this.decodedResourceClass, bytes);
        return bytes;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + '\'' + ", options=" + this.options + '}';
    }
}
