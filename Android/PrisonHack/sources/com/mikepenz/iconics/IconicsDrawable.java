package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.Utils;

public class IconicsDrawable extends Drawable {
    @Dimension(unit = 0)
    public static final int TOOLBAR_ICON_PADDING = 1;
    @Dimension(unit = 0)
    public static final int TOOLBAR_ICON_SIZE = 24;
    private int mAlpha = 255;
    private int mBackgroundColor;
    private int mBackgroundContourColor;
    private Paint mBackgroundContourPaint;
    private int mBackgroundContourWidth;
    private Paint mBackgroundPaint;
    private ColorFilter mColorFilter;
    private Context mContext;
    private int mContourColor;
    private Paint mContourPaint;
    private int mContourWidth;
    private boolean mDrawBackgroundContour;
    private boolean mDrawContour;
    private IIcon mIcon;
    private ColorStateList mIconColor;
    private int mIconOffsetX = 0;
    private int mIconOffsetY = 0;
    private int mIconPadding;
    private Paint mIconPaint;
    private Rect mPaddingBounds;
    private Path mPath;
    private RectF mPathBounds;
    private String mPlainIcon;
    private boolean mRespectFontBounds = false;
    private int mRoundedCornerRx = -1;
    private int mRoundedCornerRy = -1;
    private int mShadowColor = 0;
    private float mShadowDx = 0.0f;
    private float mShadowDy = 0.0f;
    private float mShadowRadius = 0.0f;
    private int mSizeX = -1;
    private int mSizeY = -1;
    private ColorStateList mTint;
    private ColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;

    public boolean isStateful() {
        return true;
    }

    public IconicsDrawable(Context context) {
        this.mContext = context.getApplicationContext();
        prepare();
        icon((Character) ' ');
    }

    public IconicsDrawable(Context context, Character ch) {
        this.mContext = context.getApplicationContext();
        prepare();
        icon(ch);
    }

    public IconicsDrawable(Context context, String str) {
        this.mContext = context.getApplicationContext();
        prepare();
        try {
            ITypeface findFont = Iconics.findFont(context, str.substring(0, 3));
            String replace = str.replace("-", "_");
            try {
                icon(findFont.getIcon(replace));
            } catch (Exception unused) {
                str = replace;
            }
        } catch (Exception unused2) {
            String str2 = Iconics.TAG;
            Log.e(str2, "Wrong icon name: " + str);
        }
    }

    public IconicsDrawable(Context context, IIcon iIcon) {
        this.mContext = context.getApplicationContext();
        prepare();
        icon(iIcon);
    }

    protected IconicsDrawable(Context context, ITypeface iTypeface, IIcon iIcon) {
        this.mContext = context.getApplicationContext();
        prepare();
        icon(iTypeface, iIcon);
    }

    public int getColor() {
        return this.mIconColor.getDefaultColor();
    }

    public ColorStateList getColorList() {
        return this.mIconColor;
    }

    public int getContourColor() {
        return this.mContourColor;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundContourColor() {
        return this.mBackgroundContourColor;
    }

    public IIcon getIcon() {
        return this.mIcon;
    }

    public String getPlainIcon() {
        return this.mPlainIcon;
    }

    public int getCompatAlpha() {
        return this.mAlpha;
    }

    public Bitmap toBitmap() {
        if (this.mSizeX == -1 || this.mSizeY == -1) {
            actionBar();
        }
        Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        style(Paint.Style.FILL);
        Canvas canvas = new Canvas(createBitmap);
        setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        draw(canvas);
        return createBitmap;
    }

    public IconicsDrawable clone() {
        IconicsDrawable typeface = new IconicsDrawable(this.mContext).paddingPx(this.mIconPadding).roundedCornersRxPx(this.mRoundedCornerRx).roundedCornersRyPx(this.mRoundedCornerRy).sizePxX(this.mSizeX).sizePxY(this.mSizeY).iconOffsetXPx(this.mIconOffsetX).iconOffsetYPx(this.mIconOffsetY).contourColor(this.mContourColor).contourWidthPx(this.mContourWidth).shadowPx(this.mShadowRadius, this.mShadowDx, this.mShadowDy, this.mShadowColor).backgroundColor(this.mBackgroundColor).backgroundContourColor(this.mBackgroundContourColor).backgroundContourWidthPx(this.mBackgroundContourWidth).color(this.mIconColor).alpha(this.mAlpha).drawContour(this.mDrawContour).drawBackgroundContour(this.mDrawBackgroundContour).typeface(this.mIconPaint.getTypeface());
        if (this.mIcon != null) {
            typeface.icon(this.mIcon);
        } else if (this.mPlainIcon != null) {
            typeface.iconText(this.mPlainIcon);
        }
        return typeface;
    }

    public IconicsDrawable icon(String str) {
        try {
            ITypeface findFont = Iconics.findFont(this.mContext, str.substring(0, 3));
            String replace = str.replace("-", "_");
            try {
                icon(findFont.getIcon(replace));
            } catch (Exception unused) {
                str = replace;
            }
        } catch (Exception unused2) {
            String str2 = Iconics.TAG;
            Log.e(str2, "Wrong icon name: " + str);
            return this;
        }
        return this;
    }

    public IconicsDrawable icon(Character ch) {
        return iconText(ch.toString(), (Typeface) null);
    }

    public IconicsDrawable icon(Character ch, @Nullable Typeface typeface) {
        return iconText(ch.toString(), typeface);
    }

    public IconicsDrawable iconText(String str) {
        return iconText(str, (Typeface) null);
    }

    public IconicsDrawable iconText(String str, @Nullable Typeface typeface) {
        this.mPlainIcon = str;
        this.mIcon = null;
        Paint paint = this.mIconPaint;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        paint.setTypeface(typeface);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable icon(IIcon iIcon) {
        this.mIcon = iIcon;
        this.mPlainIcon = null;
        this.mIconPaint.setTypeface(iIcon.getTypeface().getTypeface(this.mContext));
        invalidateSelf();
        return this;
    }

    /* access modifiers changed from: protected */
    public IconicsDrawable icon(ITypeface iTypeface, IIcon iIcon) {
        this.mIcon = iIcon;
        this.mIconPaint.setTypeface(iTypeface.getTypeface(this.mContext));
        invalidateSelf();
        return this;
    }

    public IconicsDrawable respectFontBounds(boolean z) {
        this.mRespectFontBounds = z;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable color(@ColorInt int i) {
        this.mIconColor = ColorStateList.valueOf(i);
        updateIconColor();
        return this;
    }

    public IconicsDrawable colorRes(@ColorRes int i) {
        return color(ContextCompat.getColor(this.mContext, i));
    }

    public IconicsDrawable colorListRes(@ColorRes int i) {
        return color(ContextCompat.getColorStateList(this.mContext, i));
    }

    public IconicsDrawable color(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mIconColor = colorStateList;
            updateIconColor();
        }
        return this;
    }

    public IconicsDrawable iconOffsetXRes(@DimenRes int i) {
        return iconOffsetXPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable iconOffsetXDp(@Dimension(unit = 0) int i) {
        return iconOffsetXPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable iconOffsetXPx(@Dimension(unit = 1) int i) {
        this.mIconOffsetX = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable iconOffsetYRes(@DimenRes int i) {
        return iconOffsetYPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable iconOffsetYDp(@Dimension(unit = 0) int i) {
        return iconOffsetYPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable iconOffsetYPx(@Dimension(unit = 1) int i) {
        this.mIconOffsetY = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable paddingRes(@DimenRes int i) {
        return paddingPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable paddingDp(@Dimension(unit = 0) int i) {
        return paddingPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable paddingPx(@Dimension(unit = 1) int i) {
        if (this.mIconPadding != i) {
            this.mIconPadding = i;
            if (this.mDrawContour) {
                this.mIconPadding += this.mContourWidth;
            }
            if (this.mDrawBackgroundContour) {
                this.mIconPadding += this.mBackgroundContourWidth;
            }
            invalidateSelf();
        }
        return this;
    }

    public IconicsDrawable actionBar() {
        sizeDp(24);
        paddingDp(1);
        return this;
    }

    public IconicsDrawable sizeRes(@DimenRes int i) {
        return sizePx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable sizeDp(@Dimension(unit = 0) int i) {
        return sizePx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable sizePx(@Dimension(unit = 1) int i) {
        this.mSizeY = i;
        this.mSizeX = i;
        setBounds(0, 0, this.mSizeX, this.mSizeY);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable sizeResX(@DimenRes int i) {
        return sizePxX(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable sizeDpX(@Dimension(unit = 0) int i) {
        return sizePxX(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable sizePxX(@Dimension(unit = 1) int i) {
        this.mSizeX = i;
        setBounds(0, 0, this.mSizeX, this.mSizeY);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable sizeResY(@DimenRes int i) {
        return sizePxY(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable sizeDpY(@Dimension(unit = 0) int i) {
        return sizePxY(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable sizePxY(@Dimension(unit = 1) int i) {
        this.mSizeY = i;
        setBounds(0, 0, this.mSizeX, this.mSizeY);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable backgroundContourColorRes(@ColorRes int i) {
        return backgroundContourColor(ContextCompat.getColor(this.mContext, i));
    }

    public IconicsDrawable backgroundContourColor(@ColorInt int i) {
        this.mBackgroundContourPaint.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.mBackgroundContourPaint.setAlpha(Color.alpha(i));
        this.mBackgroundContourColor = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable contourColorRes(@ColorRes int i) {
        return contourColor(ContextCompat.getColor(this.mContext, i));
    }

    public IconicsDrawable contourColor(@ColorInt int i) {
        this.mContourPaint.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.mContourPaint.setAlpha(Color.alpha(i));
        this.mContourColor = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable backgroundColorRes(@ColorRes int i) {
        return backgroundColor(ContextCompat.getColor(this.mContext, i));
    }

    public IconicsDrawable backgroundColor(@ColorInt int i) {
        this.mBackgroundPaint.setColor(i);
        this.mBackgroundColor = i;
        if (this.mRoundedCornerRx == -1) {
            this.mRoundedCornerRx = 0;
        }
        if (this.mRoundedCornerRy == -1) {
            this.mRoundedCornerRy = 0;
        }
        invalidateSelf();
        return this;
    }

    public IconicsDrawable roundedCornersRxRes(@DimenRes int i) {
        return roundedCornersRxPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable roundedCornersRxDp(@Dimension(unit = 0) int i) {
        return roundedCornersRxPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable roundedCornersRxPx(@Dimension(unit = 1) int i) {
        this.mRoundedCornerRx = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable roundedCornersRyRes(@DimenRes int i) {
        return roundedCornersRyPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable roundedCornersRyDp(@Dimension(unit = 0) int i) {
        return roundedCornersRyPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable roundedCornersRyPx(@Dimension(unit = 1) int i) {
        this.mRoundedCornerRy = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable roundedCornersRes(@DimenRes int i) {
        return roundedCornersPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable roundedCornersDp(@Dimension(unit = 0) int i) {
        return roundedCornersPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable roundedCornersPx(@Dimension(unit = 1) int i) {
        this.mRoundedCornerRy = i;
        this.mRoundedCornerRx = i;
        invalidateSelf();
        return this;
    }

    public IconicsDrawable contourWidthRes(@DimenRes int i) {
        return contourWidthPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable contourWidthDp(@Dimension(unit = 0) int i) {
        return contourWidthPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable contourWidthPx(@Dimension(unit = 1) int i) {
        this.mContourWidth = i;
        this.mContourPaint.setStrokeWidth((float) this.mContourWidth);
        drawContour(true);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable enableShadowSupport(View view) {
        view.setLayerType(1, (Paint) null);
        return this;
    }

    public IconicsDrawable shadowRes(@DimenRes int i, @DimenRes int i2, @DimenRes int i3, @ColorRes int i4) {
        return shadowPx((float) this.mContext.getResources().getDimensionPixelSize(i), (float) this.mContext.getResources().getDimensionPixelSize(i2), (float) this.mContext.getResources().getDimensionPixelSize(i3), ContextCompat.getColor(this.mContext, i4));
    }

    public IconicsDrawable shadowDp(@Dimension(unit = 0) float f, @Dimension(unit = 0) float f2, @Dimension(unit = 0) float f3, @ColorInt int i) {
        return shadowPx((float) Utils.convertDpToPx(this.mContext, f), (float) Utils.convertDpToPx(this.mContext, f2), (float) Utils.convertDpToPx(this.mContext, f3), i);
    }

    public IconicsDrawable shadowPx(@Dimension(unit = 1) float f, @Dimension(unit = 1) float f2, @Dimension(unit = 1) float f3, @ColorInt int i) {
        this.mShadowRadius = f;
        this.mShadowDx = f2;
        this.mShadowDy = f3;
        this.mShadowColor = i;
        this.mIconPaint.setShadowLayer(f, f2, f3, i);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable backgroundContourWidthRes(@DimenRes int i) {
        return backgroundContourWidthPx(this.mContext.getResources().getDimensionPixelSize(i));
    }

    public IconicsDrawable backgroundContourWidthDp(@Dimension(unit = 0) int i) {
        return backgroundContourWidthPx(Utils.convertDpToPx(this.mContext, (float) i));
    }

    public IconicsDrawable backgroundContourWidthPx(@Dimension(unit = 1) int i) {
        this.mBackgroundContourWidth = i;
        this.mBackgroundContourPaint.setStrokeWidth((float) this.mBackgroundContourWidth);
        drawBackgroundContour(true);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable drawContour(boolean z) {
        if (this.mDrawContour != z) {
            this.mDrawContour = z;
            this.mIconPadding += (this.mDrawContour ? 1 : -1) * this.mContourWidth;
            invalidateSelf();
        }
        return this;
    }

    public IconicsDrawable drawBackgroundContour(boolean z) {
        if (this.mDrawBackgroundContour != z) {
            this.mDrawBackgroundContour = z;
            this.mIconPadding += (this.mDrawBackgroundContour ? 1 : -1) * this.mBackgroundContourWidth * 2;
            invalidateSelf();
        }
        return this;
    }

    public IconicsDrawable colorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return this;
    }

    public IconicsDrawable alpha(int i) {
        setAlpha(i);
        return this;
    }

    public IconicsDrawable style(Paint.Style style) {
        this.mIconPaint.setStyle(style);
        invalidateSelf();
        return this;
    }

    public IconicsDrawable typeface(Typeface typeface) {
        this.mIconPaint.setTypeface(typeface);
        invalidateSelf();
        return this;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.mIcon != null || this.mPlainIcon != null) {
            Rect bounds = getBounds();
            updatePaddingBounds(bounds);
            updateTextSize(bounds);
            offsetIcon(bounds);
            if (this.mBackgroundPaint != null && this.mRoundedCornerRy > -1 && this.mRoundedCornerRx > -1) {
                if (!this.mDrawBackgroundContour || this.mBackgroundContourPaint == null) {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height()), (float) this.mRoundedCornerRx, (float) this.mRoundedCornerRy, this.mBackgroundPaint);
                } else {
                    float f = (float) (this.mBackgroundContourWidth / 2);
                    RectF rectF = new RectF(f, f, ((float) bounds.width()) - f, ((float) bounds.height()) - f);
                    canvas.drawRoundRect(rectF, (float) this.mRoundedCornerRx, (float) this.mRoundedCornerRy, this.mBackgroundPaint);
                    canvas.drawRoundRect(rectF, (float) this.mRoundedCornerRx, (float) this.mRoundedCornerRy, this.mBackgroundContourPaint);
                }
            }
            try {
                this.mPath.close();
            } catch (Exception unused) {
            }
            if (this.mDrawContour) {
                canvas.drawPath(this.mPath, this.mContourPaint);
            }
            this.mIconPaint.setAlpha(this.mAlpha);
            this.mIconPaint.setColorFilter(this.mColorFilter == null ? this.mTintFilter : this.mColorFilter);
            canvas.drawPath(this.mPath, this.mIconPaint);
        }
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTint, mode);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        offsetIcon(rect);
        try {
            this.mPath.close();
        } catch (Exception unused) {
        }
        super.onBoundsChange(rect);
    }

    public boolean setState(@NonNull int[] iArr) {
        return super.setState(iArr) || !((this.mIconColor == null || !this.mIconColor.isStateful()) && this.mColorFilter == null && this.mTintFilter == null);
    }

    public int getOpacity() {
        if (this.mTintFilter != null || this.mIconPaint.getColorFilter() != null) {
            return -3;
        }
        int alpha = getAlpha();
        if (alpha == 0) {
            return -2;
        }
        if (alpha != 255) {
            return -3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z;
        if (this.mIconColor == null || !this.mIconColor.isStateful()) {
            z = false;
        } else {
            updateIconColor();
            z = true;
        }
        if (this.mTint == null || this.mTintMode == null) {
            return z;
        }
        this.mTintFilter = updateTintFilter(this.mTint, this.mTintMode);
        invalidateSelf();
        return true;
    }

    public int getIntrinsicWidth() {
        return this.mSizeX;
    }

    public int getIntrinsicHeight() {
        return this.mSizeY;
    }

    public void setAlpha(int i) {
        this.mIconPaint.setAlpha(i);
        this.mAlpha = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    public void clearColorFilter() {
        this.mColorFilter = null;
        invalidateSelf();
    }

    private void prepare() {
        this.mIconPaint = new TextPaint(1);
        this.mIconPaint.setStyle(Paint.Style.FILL);
        this.mIconPaint.setTextAlign(Paint.Align.CENTER);
        this.mIconPaint.setUnderlineText(false);
        this.mIconPaint.setAntiAlias(true);
        this.mBackgroundPaint = new Paint(1);
        this.mContourPaint = new Paint(1);
        this.mContourPaint.setStyle(Paint.Style.STROKE);
        this.mBackgroundContourPaint = new Paint(1);
        this.mBackgroundContourPaint.setStyle(Paint.Style.STROKE);
        this.mPath = new Path();
        this.mPathBounds = new RectF();
        this.mPaddingBounds = new Rect();
    }

    private void updatePaddingBounds(Rect rect) {
        if (this.mIconPadding >= 0 && this.mIconPadding * 2 <= rect.width() && this.mIconPadding * 2 <= rect.height()) {
            this.mPaddingBounds.set(rect.left + this.mIconPadding, rect.top + this.mIconPadding, rect.right - this.mIconPadding, rect.bottom - this.mIconPadding);
        }
    }

    private void updateTextSize(Rect rect) {
        float height = ((float) rect.height()) * ((float) (this.mRespectFontBounds ? 1 : 2));
        this.mIconPaint.setTextSize(height);
        String valueOf = this.mIcon != null ? String.valueOf(this.mIcon.getCharacter()) : String.valueOf(this.mPlainIcon);
        this.mIconPaint.getTextPath(valueOf, 0, valueOf.length(), 0.0f, (float) rect.height(), this.mPath);
        this.mPath.computeBounds(this.mPathBounds, true);
        if (!this.mRespectFontBounds) {
            float width = ((float) this.mPaddingBounds.width()) / this.mPathBounds.width();
            float height2 = ((float) this.mPaddingBounds.height()) / this.mPathBounds.height();
            if (width >= height2) {
                width = height2;
            }
            this.mIconPaint.setTextSize(height * width);
            this.mIconPaint.getTextPath(valueOf, 0, valueOf.length(), 0.0f, (float) rect.height(), this.mPath);
            this.mPath.computeBounds(this.mPathBounds, true);
        }
    }

    private void offsetIcon(Rect rect) {
        this.mPath.offset(((((float) rect.centerX()) - (this.mPathBounds.width() / 2.0f)) - this.mPathBounds.left) + ((float) this.mIconOffsetX), ((((float) rect.centerY()) - (this.mPathBounds.height() / 2.0f)) - this.mPathBounds.top) + ((float) this.mIconOffsetY));
    }

    private void updateIconColor() {
        boolean z;
        int colorForState = this.mIconColor.getColorForState(getState(), this.mIconColor.getDefaultColor());
        int rgb = Color.rgb(Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState));
        if (rgb != this.mIconPaint.getColor()) {
            this.mIconPaint.setColor(rgb);
            z = true;
        } else {
            z = false;
        }
        int alpha = Color.alpha(colorForState);
        if (alpha != 255 && alpha != this.mAlpha) {
            setAlpha(alpha);
        } else if (z) {
            invalidateSelf();
        }
    }

    private PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
