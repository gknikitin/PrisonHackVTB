package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;

public class RequestManager implements LifecycleListener {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private final Handler mainHandler;
    @NonNull
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    public RequestManager(Glide glide2, Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode, Context context2) {
        this(glide2, lifecycle2, requestManagerTreeNode, new RequestTracker(), glide2.getConnectivityMonitorFactory(), context2);
    }

    RequestManager(Glide glide2, Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker2, ConnectivityMonitorFactory connectivityMonitorFactory, Context context2) {
        this.targetTracker = new TargetTracker();
        this.addSelfToLifecycle = new Runnable() {
            public void run() {
                RequestManager.this.lifecycle.addListener(RequestManager.this);
            }
        };
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.glide = glide2;
        this.lifecycle = lifecycle2;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker2;
        this.context = context2;
        this.connectivityMonitor = connectivityMonitorFactory.build(context2.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker2));
        if (Util.isOnBackgroundThread()) {
            this.mainHandler.post(this.addSelfToLifecycle);
        } else {
            lifecycle2.addListener(this);
        }
        lifecycle2.addListener(this.connectivityMonitor);
        setRequestOptions(glide2.getGlideContext().getDefaultRequestOptions());
        glide2.registerRequestManager(this);
    }

    /* access modifiers changed from: protected */
    public void setRequestOptions(@NonNull RequestOptions requestOptions2) {
        this.requestOptions = requestOptions2.clone().autoClone();
    }

    private void updateRequestOptions(RequestOptions requestOptions2) {
        this.requestOptions = this.requestOptions.apply(requestOptions2);
    }

    public RequestManager applyDefaultRequestOptions(RequestOptions requestOptions2) {
        updateRequestOptions(requestOptions2);
        return this;
    }

    public RequestManager setDefaultRequestOptions(RequestOptions requestOptions2) {
        setRequestOptions(requestOptions2);
        return this;
    }

    @Deprecated
    public void onTrimMemory(int i) {
        this.glide.onTrimMemory(i);
    }

    @Deprecated
    public void onLowMemory() {
        this.glide.onLowMemory();
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        for (RequestManager pauseRequests : this.treeNode.getDescendants()) {
            pauseRequests.pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager resumeRequests : this.treeNode.getDescendants()) {
            resumeRequests.resumeRequests();
        }
    }

    public void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    public void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    public void onDestroy() {
        this.targetTracker.onDestroy();
        for (Target<?> clear : this.targetTracker.getAll()) {
            clear(clear);
        }
        this.targetTracker.clear();
        this.requestTracker.clearRequests();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return mo8868as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return mo8868as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return mo8868as(Drawable.class);
    }

    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }

    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return mo8868as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @CheckResult
    public RequestBuilder<File> asFile() {
        return mo8868as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @CheckResult
    /* renamed from: as */
    public <ResourceType> RequestBuilder<ResourceType> mo8868as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public void clear(View view) {
        clear((Target<?>) new ClearTarget(view));
    }

    public void clear(@Nullable final Target<?> target) {
        if (target != null) {
            if (Util.isOnMainThread()) {
                untrackOrDelegate(target);
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        RequestManager.this.clear((Target<?>) target);
                    }
                });
            }
        }
    }

    private void untrackOrDelegate(Target<?> target) {
        if (!untrack(target)) {
            this.glide.removeFromManagers(target);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean untrack(Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearRemoveAndRecycle(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest((Request) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void track(Target<?> target, Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    /* access modifiers changed from: package-private */
    public RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    private static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker2) {
            this.requestTracker = requestTracker2;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.requestTracker.restartRequests();
            }
        }
    }

    private static class ClearTarget extends ViewTarget<View, Object> {
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        public ClearTarget(View view) {
            super(view);
        }
    }
}
