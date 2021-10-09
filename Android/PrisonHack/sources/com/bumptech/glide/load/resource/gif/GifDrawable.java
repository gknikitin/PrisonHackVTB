package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.VisibleForTesting;
import android.view.Gravity;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final GifState state;

    public int getOpacity() {
        return -2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifDrawable(android.content.Context r10, com.bumptech.glide.gifdecoder.GifDecoder r11, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r12, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r13, int r14, int r15, android.graphics.Bitmap r16) {
        /*
            r9 = this;
            com.bumptech.glide.load.resource.gif.GifDrawable$GifState r0 = new com.bumptech.glide.load.resource.gif.GifDrawable$GifState
            com.bumptech.glide.load.resource.gif.GifFrameLoader r8 = new com.bumptech.glide.load.resource.gif.GifFrameLoader
            com.bumptech.glide.Glide r2 = com.bumptech.glide.Glide.get(r10)
            r1 = r8
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r13
            r7 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1 = r12
            r0.<init>(r1, r8)
            r1 = r9
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifDrawable.<init>(android.content.Context, com.bumptech.glide.gifdecoder.GifDecoder, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, com.bumptech.glide.load.Transformation, int, int, android.graphics.Bitmap):void");
    }

    GifDrawable(GifState gifState) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (GifState) Preconditions.checkNotNull(gifState);
    }

    @VisibleForTesting
    GifDrawable(GifFrameLoader gifFrameLoader, BitmapPool bitmapPool, Paint paint2) {
        this(new GifState(bitmapPool, gifFrameLoader));
        this.paint = paint2;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.state.frameLoader.setFrameTransformation(transformation, bitmap);
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.state.frameLoader.subscribe(this);
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    /* access modifiers changed from: package-private */
    public void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    public void draw(Canvas canvas) {
        if (!this.isRecycled) {
            if (this.applyGravity) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
                this.applyGravity = false;
            }
            canvas.drawBitmap(this.state.frameLoader.getCurrentFrame(), (Rect) null, getDestRect(), getPaint());
        }
    }

    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    private Rect getDestRect() {
        if (this.destRect == null) {
            this.destRect = new Rect();
        }
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    public void onFrameReady() {
        if (getCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.loopCount++;
        }
        if (this.maxLoopCount != -1 && this.loopCount >= this.maxLoopCount) {
            stop();
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean isRecycled() {
        return this.isRecycled;
    }

    public void setLoopCount(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            int loopCount2 = this.state.frameLoader.getLoopCount();
            if (loopCount2 == 0) {
                loopCount2 = -1;
            }
            this.maxLoopCount = loopCount2;
        } else {
            this.maxLoopCount = i;
        }
    }

    static class GifState extends Drawable.ConstantState {
        static final int GRAVITY = 119;
        final BitmapPool bitmapPool;
        final GifFrameLoader frameLoader;

        public int getChangingConfigurations() {
            return 0;
        }

        public GifState(BitmapPool bitmapPool2, GifFrameLoader gifFrameLoader) {
            this.bitmapPool = bitmapPool2;
            this.frameLoader = gifFrameLoader;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }
}
