package com.bumptech.glide.load.model.stream;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    @Nullable
    private final ModelCache<Model, GlideUrl> modelCache;

    /* access modifiers changed from: protected */
    public abstract String getUrl(Model model, int i, int i2, Options options);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache2) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache2;
    }

    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(Model model, int i, int i2, Options options) {
        GlideUrl glideUrl = this.modelCache != null ? this.modelCache.get(model, i, i2) : null;
        if (glideUrl == null) {
            String url = getUrl(model, i, i2, options);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(model, i, i2, options));
            if (this.modelCache != null) {
                this.modelCache.put(model, i, i2, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> alternateUrls = getAlternateUrls(model, i, i2, options);
        ModelLoader.LoadData<InputStream> buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i, i2, options);
        if (alternateUrls.isEmpty()) {
            return buildLoadData;
        }
        return new ModelLoader.LoadData<>(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
    }

    private static List<Key> getAlternateKeys(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String glideUrl : list) {
            arrayList.add(new GlideUrl(glideUrl));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<String> getAlternateUrls(Model model, int i, int i2, Options options) {
        return Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Headers getHeaders(Model model, int i, int i2, Options options) {
        return Headers.DEFAULT;
    }
}
