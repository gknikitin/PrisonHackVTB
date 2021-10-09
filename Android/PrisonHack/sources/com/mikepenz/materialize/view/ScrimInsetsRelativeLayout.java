package com.mikepenz.materialize.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.p000v4.view.OnApplyWindowInsetsListener;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mikepenz.materialize.C0676R;

public class ScrimInsetsRelativeLayout extends RelativeLayout implements IScrimInsetsLayout {
    /* access modifiers changed from: private */
    public Drawable mInsetForeground;
    /* access modifiers changed from: private */
    public Rect mInsets;
    /* access modifiers changed from: private */
    public OnInsetsCallback mOnInsetsCallback;
    private boolean mSystemUIVisible;
    private Rect mTempRect;
    private boolean mTintNavigationBar;
    private boolean mTintStatusBar;

    public ViewGroup getView() {
        return this;
    }

    public ScrimInsetsRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        this.mTintStatusBar = true;
        this.mTintNavigationBar = true;
        this.mSystemUIVisible = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0676R.styleable.ScrimInsetsRelativeLayout, i, C0676R.style.Widget_Materialize_ScrimInsetsRelativeLayout);
        this.mInsetForeground = obtainStyledAttributes.getDrawable(C0676R.styleable.ScrimInsetsRelativeLayout_sirl_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsRelativeLayout.this.mInsets == null) {
                    Rect unused = ScrimInsetsRelativeLayout.this.mInsets = new Rect();
                }
                ScrimInsetsRelativeLayout.this.mInsets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsRelativeLayout.this.setWillNotDraw(ScrimInsetsRelativeLayout.this.mInsetForeground == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsRelativeLayout.this);
                if (ScrimInsetsRelativeLayout.this.mOnInsetsCallback != null) {
                    ScrimInsetsRelativeLayout.this.mOnInsetsCallback.onInsetsChanged(windowInsetsCompat);
                }
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mInsets != null && this.mInsetForeground != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (!this.mSystemUIVisible) {
                this.mInsets.top = 0;
                this.mInsets.right = 0;
                this.mInsets.bottom = 0;
                this.mInsets.left = 0;
            }
            if (this.mTintStatusBar) {
                this.mTempRect.set(0, 0, width, this.mInsets.top);
                this.mInsetForeground.setBounds(this.mTempRect);
                this.mInsetForeground.draw(canvas);
            }
            if (this.mTintNavigationBar) {
                this.mTempRect.set(0, height - this.mInsets.bottom, width, height);
                this.mInsetForeground.setBounds(this.mTempRect);
                this.mInsetForeground.draw(canvas);
            }
            this.mTempRect.set(0, this.mInsets.top, this.mInsets.left, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            this.mTempRect.set(width - this.mInsets.right, this.mInsets.top, width, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mInsetForeground != null) {
            this.mInsetForeground.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mInsetForeground != null) {
            this.mInsetForeground.setCallback((Drawable.Callback) null);
        }
    }

    public Drawable getInsetForeground() {
        return this.mInsetForeground;
    }

    public void setInsetForeground(Drawable drawable) {
        this.mInsetForeground = drawable;
    }

    public void setInsetForeground(int i) {
        this.mInsetForeground = new ColorDrawable(i);
    }

    public boolean isTintStatusBar() {
        return this.mTintStatusBar;
    }

    public void setTintStatusBar(boolean z) {
        this.mTintStatusBar = z;
    }

    public boolean isTintNavigationBar() {
        return this.mTintNavigationBar;
    }

    public void setTintNavigationBar(boolean z) {
        this.mTintNavigationBar = z;
    }

    public boolean isSystemUIVisible() {
        return this.mSystemUIVisible;
    }

    public void setSystemUIVisible(boolean z) {
        this.mSystemUIVisible = z;
    }

    public void setOnInsetsCallback(OnInsetsCallback onInsetsCallback) {
        this.mOnInsetsCallback = onInsetsCallback;
    }

    public OnInsetsCallback getOnInsetsCallback() {
        return this.mOnInsetsCallback;
    }
}
