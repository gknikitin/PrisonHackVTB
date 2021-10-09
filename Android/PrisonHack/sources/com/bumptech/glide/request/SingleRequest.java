package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p000v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.simple(150, new FactoryPools.Factory<SingleRequest<?>>() {
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    @Nullable
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<R> requestListener;
    private RequestOptions requestOptions;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private Status status;
    private final String tag = String.valueOf(super.hashCode());
    private Target<R> target;
    @Nullable
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Class<R> cls, RequestOptions requestOptions2, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener2, RequestListener<R> requestListener3, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<R> acquire = POOL.acquire();
        if (acquire == null) {
            acquire = new SingleRequest<>();
        }
        acquire.init(context2, glideContext2, obj, cls, requestOptions2, i, i2, priority2, target2, requestListener2, requestListener3, requestCoordinator2, engine2, transitionFactory);
        return acquire;
    }

    SingleRequest() {
    }

    private void init(Context context2, GlideContext glideContext2, Object obj, Class<R> cls, RequestOptions requestOptions2, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener2, RequestListener<R> requestListener3, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory) {
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj;
        this.transcodeClass = cls;
        this.requestOptions = requestOptions2;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener2;
        this.requestListener = requestListener3;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.status = Status.PENDING;
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public void recycle() {
        assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListener = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        POOL.release(this);
    }

    public void begin() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
        } else if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.status == Status.COMPLETE) {
            onResourceReady(this.resource, DataSource.MEMORY_CACHE);
        } else {
            this.status = Status.WAITING_FOR_SIZE;
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (Log.isLoggable(TAG, 2)) {
                logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        this.status = Status.CANCELLED;
        if (this.loadStatus != null) {
            this.loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public void clear() {
        Util.assertMainThread();
        assertNotCallingCallbacks();
        if (this.status != Status.CLEARED) {
            cancel();
            if (this.resource != null) {
                releaseResource(this.resource);
            }
            if (canNotifyStatusChanged()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    public boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    private void releaseResource(Resource<?> resource2) {
        this.engine.release(resource2);
        this.resource = null;
    }

    public boolean isRunning() {
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public boolean isResourceSet() {
        return isComplete();
    }

    public boolean isCancelled() {
        return this.status == Status.CANCELLED || this.status == Status.CLEARED;
    }

    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            this.errorDrawable = this.requestOptions.getErrorPlaceholder();
            if (this.errorDrawable == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            this.placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            if (this.placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            this.fallbackDrawable = this.requestOptions.getFallbackDrawable();
            if (this.fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(@DrawableRes int i) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable drawable = null;
            if (this.model == null) {
                drawable = getFallbackDrawable();
            }
            if (drawable == null) {
                drawable = getErrorDrawable();
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(drawable);
        }
    }

    public void onSizeReady(int i, int i2) {
        this.stateVerifier.throwIfRecycled();
        if (Log.isLoggable(TAG, 2)) {
            logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
        }
        if (this.status == Status.WAITING_FOR_SIZE) {
            this.status = Status.RUNNING;
            float sizeMultiplier = this.requestOptions.getSizeMultiplier();
            this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
            this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
            if (Log.isLoggable(TAG, 2)) {
                logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
            }
            Engine.LoadStatus load = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this);
            this.loadStatus = load;
            if (Log.isLoggable(TAG, 2)) {
                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    private boolean canSetResource() {
        return this.requestCoordinator == null || this.requestCoordinator.canSetImage(this);
    }

    private boolean canNotifyStatusChanged() {
        return this.requestCoordinator == null || this.requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        return this.requestCoordinator == null || !this.requestCoordinator.isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.onRequestFailed(this);
        }
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        this.loadStatus = null;
        if (resource2 == null) {
            onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
            return;
        }
        Object obj = resource2.get();
        if (obj == null || !this.transcodeClass.isAssignableFrom(obj.getClass())) {
            releaseResource(resource2);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.transcodeClass);
            sb.append(" but instead got ");
            sb.append(obj != null ? obj.getClass() : "");
            sb.append("{");
            sb.append(obj);
            sb.append("} inside Resource{");
            sb.append(resource2);
            sb.append("}.");
            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
            onLoadFailed(new GlideException(sb.toString()));
        } else if (!canSetResource()) {
            releaseResource(resource2);
            this.status = Status.COMPLETE;
        } else {
            onResourceReady(resource2, obj, dataSource);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r7.targetListener.onResourceReady(r9, r7.model, r7.target, r10, r6) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007f, code lost:
        if (r7.requestListener.onResourceReady(r9, r7.model, r7.target, r10, r6) == false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r8, R r9, com.bumptech.glide.load.DataSource r10) {
        /*
            r7 = this;
            boolean r6 = r7.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r7.status = r0
            r7.resource = r8
            com.bumptech.glide.GlideContext r8 = r7.glideContext
            int r8 = r8.getLogLevel()
            r0 = 3
            if (r8 > r0) goto L_0x006a
            java.lang.String r8 = "Glide"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Finished loading "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " from "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.Object r1 = r7.model
            r0.append(r1)
            java.lang.String r1 = " with size ["
            r0.append(r1)
            int r1 = r7.width
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = r7.height
            r0.append(r1)
            java.lang.String r1 = "] in "
            r0.append(r1)
            long r1 = r7.startTime
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r8, r0)
        L_0x006a:
            r8 = 1
            r7.isCallingCallbacks = r8
            r8 = 0
            com.bumptech.glide.request.RequestListener<R> r0 = r7.requestListener     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0081
            com.bumptech.glide.request.RequestListener<R> r0 = r7.requestListener     // Catch:{ all -> 0x00a5 }
            java.lang.Object r2 = r7.model     // Catch:{ all -> 0x00a5 }
            com.bumptech.glide.request.target.Target<R> r3 = r7.target     // Catch:{ all -> 0x00a5 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x009f
        L_0x0081:
            com.bumptech.glide.request.RequestListener<R> r0 = r7.targetListener     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0094
            com.bumptech.glide.request.RequestListener<R> r0 = r7.targetListener     // Catch:{ all -> 0x00a5 }
            java.lang.Object r2 = r7.model     // Catch:{ all -> 0x00a5 }
            com.bumptech.glide.request.target.Target<R> r3 = r7.target     // Catch:{ all -> 0x00a5 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x009f
        L_0x0094:
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r0 = r7.animationFactory     // Catch:{ all -> 0x00a5 }
            com.bumptech.glide.request.transition.Transition r10 = r0.build(r10, r6)     // Catch:{ all -> 0x00a5 }
            com.bumptech.glide.request.target.Target<R> r0 = r7.target     // Catch:{ all -> 0x00a5 }
            r0.onResourceReady(r9, r10)     // Catch:{ all -> 0x00a5 }
        L_0x009f:
            r7.isCallingCallbacks = r8
            r7.notifyLoadSuccess()
            return
        L_0x00a5:
            r9 = move-exception
            r7.isCallingCallbacks = r8
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException glideException, int i) {
        this.stateVerifier.throwIfRecycled();
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= i) {
            Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
            if (logLevel <= 4) {
                glideException.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
        this.isCallingCallbacks = true;
        try {
            if ((this.requestListener == null || !this.requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) && (this.targetListener == null || !this.targetListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource()))) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.SingleRequest
            r1 = 0
            if (r0 == 0) goto L_0x0046
            com.bumptech.glide.request.SingleRequest r4 = (com.bumptech.glide.request.SingleRequest) r4
            int r0 = r3.overrideWidth
            int r2 = r4.overrideWidth
            if (r0 != r2) goto L_0x0045
            int r0 = r3.overrideHeight
            int r2 = r4.overrideHeight
            if (r0 != r2) goto L_0x0045
            java.lang.Object r0 = r3.model
            java.lang.Object r2 = r4.model
            boolean r0 = com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(r0, r2)
            if (r0 == 0) goto L_0x0045
            java.lang.Class<R> r0 = r3.transcodeClass
            java.lang.Class<R> r2 = r4.transcodeClass
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0045
            com.bumptech.glide.request.RequestOptions r0 = r3.requestOptions
            com.bumptech.glide.request.RequestOptions r2 = r4.requestOptions
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0045
            com.bumptech.glide.Priority r0 = r3.priority
            com.bumptech.glide.Priority r2 = r4.priority
            if (r0 != r2) goto L_0x0045
            com.bumptech.glide.request.RequestListener<R> r0 = r3.requestListener
            if (r0 == 0) goto L_0x0040
            com.bumptech.glide.request.RequestListener<R> r4 = r4.requestListener
            if (r4 == 0) goto L_0x0045
            goto L_0x0044
        L_0x0040:
            com.bumptech.glide.request.RequestListener<R> r4 = r4.requestListener
            if (r4 != 0) goto L_0x0045
        L_0x0044:
            r1 = 1
        L_0x0045:
            return r1
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }
}
