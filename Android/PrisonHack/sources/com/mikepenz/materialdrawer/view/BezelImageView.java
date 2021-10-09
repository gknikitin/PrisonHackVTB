package com.mikepenz.materialdrawer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;

public class BezelImageView extends ImageView {
    private boolean isPressed;
    private boolean isSelected;
    private Paint mBlackPaint;
    private Rect mBounds;
    private RectF mBoundsF;
    private Bitmap mCacheBitmap;
    private boolean mCacheValid;
    private int mCachedHeight;
    private int mCachedWidth;
    private ColorMatrixColorFilter mDesaturateColorFilter;
    private boolean mDrawCircularShadow;
    private Drawable mMaskDrawable;
    private Paint mMaskedPaint;
    private int mSelectorAlpha;
    private int mSelectorColor;
    private ColorFilter mSelectorFilter;
    private ColorMatrixColorFilter mTempDesaturateColorFilter;
    private ColorFilter mTempSelectorFilter;

    public BezelImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawCircularShadow = true;
        this.mSelectorAlpha = 150;
        this.mCacheValid = false;
        this.isPressed = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0658R.styleable.BezelImageView, i, C0658R.style.BezelImageView);
        this.mMaskDrawable = obtainStyledAttributes.getDrawable(C0658R.styleable.BezelImageView_biv_maskDrawable);
        if (this.mMaskDrawable != null) {
            this.mMaskDrawable.setCallback(this);
        }
        this.mDrawCircularShadow = obtainStyledAttributes.getBoolean(C0658R.styleable.BezelImageView_biv_drawCircularShadow, true);
        this.mSelectorColor = obtainStyledAttributes.getColor(C0658R.styleable.BezelImageView_biv_selectorOnPress, 0);
        obtainStyledAttributes.recycle();
        this.mBlackPaint = new Paint();
        this.mBlackPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mMaskedPaint = new Paint();
        this.mMaskedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.mCacheBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.mDesaturateColorFilter = new ColorMatrixColorFilter(colorMatrix);
        if (this.mSelectorColor != 0) {
            this.mSelectorFilter = new PorterDuffColorFilter(Color.argb(this.mSelectorAlpha, Color.red(this.mSelectorColor), Color.green(this.mSelectorColor), Color.blue(this.mSelectorColor)), PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21 && this.mDrawCircularShadow) {
            setOutlineProvider(new CustomOutline(i, i2));
        }
    }

    @TargetApi(21)
    private class CustomOutline extends ViewOutlineProvider {
        int height;
        int width;

        CustomOutline(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, this.width, this.height);
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.mBounds = new Rect(0, 0, i3 - i, i4 - i2);
        this.mBoundsF = new RectF(this.mBounds);
        if (this.mMaskDrawable != null) {
            this.mMaskDrawable.setBounds(this.mBounds);
        }
        if (frame) {
            this.mCacheValid = false;
        }
        return frame;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mBounds != null) {
            int width = this.mBounds.width();
            int height = this.mBounds.height();
            if (width != 0 && height != 0) {
                if (!(this.mCacheValid && width == this.mCachedWidth && height == this.mCachedHeight && this.isSelected == this.isPressed)) {
                    if (width == this.mCachedWidth && height == this.mCachedHeight) {
                        this.mCacheBitmap.eraseColor(0);
                    } else {
                        this.mCacheBitmap.recycle();
                        this.mCacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        this.mCachedWidth = width;
                        this.mCachedHeight = height;
                    }
                    Canvas canvas2 = new Canvas(this.mCacheBitmap);
                    if (this.mMaskDrawable != null) {
                        int save = canvas2.save();
                        this.mMaskDrawable.draw(canvas2);
                        if (!this.isSelected) {
                            this.mMaskedPaint.setColorFilter((ColorFilter) null);
                        } else if (this.mSelectorFilter != null) {
                            this.mMaskedPaint.setColorFilter(this.mSelectorFilter);
                        } else {
                            this.mMaskedPaint.setColorFilter(this.mDesaturateColorFilter);
                        }
                        canvas2.saveLayer(this.mBoundsF, this.mMaskedPaint, 12);
                        super.onDraw(canvas2);
                        canvas2.restoreToCount(save);
                    } else if (this.isSelected) {
                        int save2 = canvas2.save();
                        canvas2.drawRect(0.0f, 0.0f, (float) this.mCachedWidth, (float) this.mCachedHeight, this.mBlackPaint);
                        if (this.mSelectorFilter != null) {
                            this.mMaskedPaint.setColorFilter(this.mSelectorFilter);
                        } else {
                            this.mMaskedPaint.setColorFilter(this.mDesaturateColorFilter);
                        }
                        canvas2.saveLayer(this.mBoundsF, this.mMaskedPaint, 12);
                        super.onDraw(canvas2);
                        canvas2.restoreToCount(save2);
                    } else {
                        super.onDraw(canvas2);
                    }
                }
                canvas.drawBitmap(this.mCacheBitmap, (float) this.mBounds.left, (float) this.mBounds.top, (Paint) null);
                this.isPressed = isPressed();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            this.isSelected = false;
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.isSelected = true;
                break;
            case 1:
            case 3:
            case 4:
            case 8:
                this.isSelected = false;
                break;
        }
        invalidate();
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mMaskDrawable != null && this.mMaskDrawable.isStateful()) {
            this.mMaskDrawable.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mMaskDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mMaskDrawable || super.verifyDrawable(drawable);
    }

    public void setSelectorColor(int i) {
        this.mSelectorColor = i;
        this.mSelectorFilter = new PorterDuffColorFilter(Color.argb(this.mSelectorAlpha, Color.red(this.mSelectorColor), Color.green(this.mSelectorColor), Color.blue(this.mSelectorColor)), PorterDuff.Mode.SRC_ATOP);
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageURI(Uri uri) {
        if ("http".equals(uri.getScheme()) || "https".equals(uri.getScheme())) {
            DrawerImageLoader.getInstance().setImage(this, uri, (String) null);
        } else {
            super.setImageURI(uri);
        }
    }

    public void disableTouchFeedback(boolean z) {
        if (z) {
            this.mTempDesaturateColorFilter = this.mDesaturateColorFilter;
            this.mTempSelectorFilter = this.mSelectorFilter;
            this.mSelectorFilter = null;
            this.mDesaturateColorFilter = null;
            return;
        }
        if (this.mTempDesaturateColorFilter != null) {
            this.mDesaturateColorFilter = this.mTempDesaturateColorFilter;
        }
        if (this.mTempSelectorFilter != null) {
            this.mSelectorFilter = this.mTempSelectorFilter;
        }
    }
}
