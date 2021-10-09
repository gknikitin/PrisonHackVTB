package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    @Nullable
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;

    public interface FrameCallback {
        void onFrameReady();
    }

    @VisibleForTesting
    interface OnEveryFrameListener {
        void onFrameReady();
    }

    public GifFrameLoader(Glide glide, GifDecoder gifDecoder2, int i, int i2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder2, (Handler) null, getRequestBuilder(Glide.with(glide.getContext()), i, i2), transformation2, bitmap);
    }

    GifFrameLoader(BitmapPool bitmapPool2, RequestManager requestManager2, GifDecoder gifDecoder2, Handler handler2, RequestBuilder<Bitmap> requestBuilder2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.isRunning = false;
        this.isLoadPending = false;
        this.startFromFirstFrame = false;
        this.requestManager = requestManager2;
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler2;
        this.bitmapPool = bitmapPool2;
        this.handler = handler2;
        this.requestBuilder = requestBuilder2;
        this.gifDecoder = gifDecoder2;
        setFrameTransformation(transformation2, bitmap);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFrameTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2, android.graphics.Bitmap r3) {
        /*
            r1 = this;
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.checkNotNull(r2)
            com.bumptech.glide.load.Transformation r0 = (com.bumptech.glide.load.Transformation) r0
            r1.transformation = r0
            java.lang.Object r3 = com.bumptech.glide.util.Preconditions.checkNotNull(r3)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            r1.firstFrame = r3
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> r3 = r1.requestBuilder
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.RequestOptions r2 = r0.transform(r2)
            com.bumptech.glide.RequestBuilder r2 = r3.apply(r2)
            r1.requestBuilder = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifFrameLoader.setFrameTransformation(com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    /* access modifiers changed from: package-private */
    public void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        boolean isEmpty = this.callbacks.isEmpty();
        if (this.callbacks.contains(frameCallback)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        this.callbacks.add(frameCallback);
        if (isEmpty) {
            start();
        }
    }

    /* access modifiers changed from: package-private */
    public void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return getCurrentFrame().getWidth();
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return getCurrentFrame().getHeight();
    }

    /* access modifiers changed from: package-private */
    public int getSize() {
        return this.gifDecoder.getByteSize() + getFrameSize();
    }

    /* access modifiers changed from: package-private */
    public int getCurrentIndex() {
        if (this.current != null) {
            return this.current.index;
        }
        return -1;
    }

    private int getFrameSize() {
        return Util.getBitmapByteSize(getCurrentFrame().getWidth(), getCurrentFrame().getHeight(), getCurrentFrame().getConfig());
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    /* access modifiers changed from: package-private */
    public int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    private void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    private void stop() {
        this.isRunning = false;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        if (this.current != null) {
            this.requestManager.clear((Target<?>) this.current);
            this.current = null;
        }
        if (this.next != null) {
            this.requestManager.clear((Target<?>) this.next);
            this.next = null;
        }
        if (this.pendingTarget != null) {
            this.requestManager.clear((Target<?>) this.pendingTarget);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getCurrentFrame() {
        return this.current != null ? this.current.getResource() : this.firstFrame;
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.gifDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            if (this.pendingTarget != null) {
                DelayTarget delayTarget = this.pendingTarget;
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay());
            this.gifDecoder.advance();
            this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis);
            this.requestBuilder.apply(RequestOptions.signatureOf(getFrameSignature())).load((Object) this.gifDecoder).into(this.next);
        }
    }

    private void recycleFirstFrame() {
        if (this.firstFrame != null) {
            this.bitmapPool.put(this.firstFrame);
            this.firstFrame = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        if (this.pendingTarget != null) {
            this.requestManager.clear((Target<?>) this.pendingTarget);
            this.pendingTarget = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable OnEveryFrameListener onEveryFrameListener2) {
        this.onEveryFrameListener = onEveryFrameListener2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void onFrameReady(DelayTarget delayTarget) {
        if (this.onEveryFrameListener != null) {
            this.onEveryFrameListener.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.isRunning) {
            this.pendingTarget = delayTarget;
        } else {
            if (delayTarget.getResource() != null) {
                recycleFirstFrame();
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).onFrameReady();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            loadNextFrame();
        }
    }

    private class FrameLoaderCallback implements Handler.Callback {
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;

        FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                GifFrameLoader.this.requestManager.clear((Target<?>) (DelayTarget) message.obj);
                return false;
            }
        }
    }

    static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        DelayTarget(Handler handler2, int i, long j) {
            this.handler = handler2;
            this.index = i;
            this.targetTime = j;
        }

        /* access modifiers changed from: package-private */
        public Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager2, int i, int i2) {
        return requestManager2.asBitmap().apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }
}
