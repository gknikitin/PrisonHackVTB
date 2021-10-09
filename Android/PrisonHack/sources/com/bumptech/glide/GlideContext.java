package com.bumptech.glide;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import java.util.Map;

@TargetApi(14)
public class GlideContext extends ContextWrapper {
    @VisibleForTesting
    static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    private final RequestOptions defaultRequestOptions;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final int logLevel;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Registry registry;

    public GlideContext(Context context, Registry registry2, ImageViewTargetFactory imageViewTargetFactory2, RequestOptions requestOptions, Map<Class<?>, TransitionOptions<?, ?>> map, Engine engine2, int i) {
        super(context.getApplicationContext());
        this.registry = registry2;
        this.imageViewTargetFactory = imageViewTargetFactory2;
        this.defaultRequestOptions = requestOptions;
        this.defaultTransitionOptions = map;
        this.engine = engine2;
        this.logLevel = i;
    }

    public RequestOptions getDefaultRequestOptions() {
        return this.defaultRequestOptions;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.defaultTransitionOptions.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry next : this.defaultTransitionOptions.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        return transitionOptions == null ? DEFAULT_TRANSITION_OPTIONS : transitionOptions;
    }

    public <X> Target<X> buildImageViewTarget(ImageView imageView, Class<X> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    public Handler getMainHandler() {
        return this.mainHandler;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public int getLogLevel() {
        return this.logLevel;
    }
}
