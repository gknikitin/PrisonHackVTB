package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleableRes;
import android.text.TextUtils;
import com.mikepenz.iconics.IconicsDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class IconicsAttrsExtractor {
    private static final int DEF_COLOR = Integer.MIN_VALUE;
    private static final int DEF_SIZE = -1;
    @StyleableRes
    private int mBackgroundColorId;
    @StyleableRes
    private int mBackgroundContourColorId;
    @StyleableRes
    private int mBackgroundContourWidthId;
    @StyleableRes
    private int mColorsId;
    @NonNull
    private final Context mContext;
    @StyleableRes
    private int mContourColorId;
    @StyleableRes
    private int mContourWidthId;
    @StyleableRes
    private int mCornerRadiusId;
    @StyleableRes
    private int mIconId;
    @StyleableRes
    private int mOffsetXId;
    @StyleableRes
    private int mOffsetYId;
    @StyleableRes
    private int mPaddingId;
    @StyleableRes
    private int mSizeId;
    @NonNull
    private final TypedArray mTypedArray;

    public IconicsAttrsExtractor(@NonNull Context context, @NonNull TypedArray typedArray) {
        this.mContext = context;
        this.mTypedArray = typedArray;
    }

    public IconicsAttrsExtractor iconId(@StyleableRes int i) {
        this.mIconId = i;
        return this;
    }

    public IconicsAttrsExtractor sizeId(@StyleableRes int i) {
        this.mSizeId = i;
        return this;
    }

    public IconicsAttrsExtractor colorsId(@StyleableRes int i) {
        this.mColorsId = i;
        return this;
    }

    public IconicsAttrsExtractor paddingId(@StyleableRes int i) {
        this.mPaddingId = i;
        return this;
    }

    public IconicsAttrsExtractor contourColorId(@StyleableRes int i) {
        this.mContourColorId = i;
        return this;
    }

    public IconicsAttrsExtractor contourWidthId(@StyleableRes int i) {
        this.mContourWidthId = i;
        return this;
    }

    public IconicsAttrsExtractor backgroundColorId(@StyleableRes int i) {
        this.mBackgroundColorId = i;
        return this;
    }

    public IconicsAttrsExtractor cornerRadiusId(@StyleableRes int i) {
        this.mCornerRadiusId = i;
        return this;
    }

    public IconicsAttrsExtractor backgroundContourColorId(@StyleableRes int i) {
        this.mBackgroundContourColorId = i;
        return this;
    }

    public IconicsAttrsExtractor backgroundContourWidthId(@StyleableRes int i) {
        this.mBackgroundContourWidthId = i;
        return this;
    }

    public IconicsAttrsExtractor offsetXId(@StyleableRes int i) {
        this.mOffsetXId = i;
        return this;
    }

    public IconicsAttrsExtractor offsetYId(@StyleableRes int i) {
        this.mOffsetYId = i;
        return this;
    }

    @NonNull
    public IconicsDrawable extractNonNull() {
        return extract((IconicsDrawable) null, false, true);
    }

    @Nullable
    public IconicsDrawable extract(@Nullable IconicsDrawable iconicsDrawable) {
        return extract(iconicsDrawable, false, false);
    }

    @Nullable
    public IconicsDrawable extract() {
        return extract((IconicsDrawable) null, false, false);
    }

    @Nullable
    public IconicsDrawable extractWithOffsets() {
        return extract((IconicsDrawable) null, true, false);
    }

    private IconicsDrawable extract(@Nullable IconicsDrawable iconicsDrawable, boolean z, boolean z2) {
        IconicsDrawable copyIfCan = copyIfCan(iconicsDrawable);
        String string = this.mTypedArray.getString(this.mIconId);
        if (!TextUtils.isEmpty(string)) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).icon(string);
        }
        ColorStateList colorStateList = this.mTypedArray.getColorStateList(this.mColorsId);
        if (colorStateList != null) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).color(colorStateList);
        }
        int dimensionPixelSize = this.mTypedArray.getDimensionPixelSize(this.mSizeId, -1);
        if (dimensionPixelSize != -1) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).sizePx(dimensionPixelSize);
        }
        int dimensionPixelSize2 = this.mTypedArray.getDimensionPixelSize(this.mPaddingId, -1);
        if (dimensionPixelSize2 != -1) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).paddingPx(dimensionPixelSize2);
        }
        int color = this.mTypedArray.getColor(this.mContourColorId, Integer.MIN_VALUE);
        if (color != Integer.MIN_VALUE) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).contourColor(color);
        }
        int dimensionPixelSize3 = this.mTypedArray.getDimensionPixelSize(this.mContourWidthId, -1);
        if (dimensionPixelSize3 != -1) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).contourWidthPx(dimensionPixelSize3);
        }
        int color2 = this.mTypedArray.getColor(this.mBackgroundColorId, Integer.MIN_VALUE);
        if (color2 != Integer.MIN_VALUE) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).backgroundColor(color2);
        }
        int dimensionPixelSize4 = this.mTypedArray.getDimensionPixelSize(this.mCornerRadiusId, -1);
        if (dimensionPixelSize4 != -1) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).roundedCornersPx(dimensionPixelSize4);
        }
        int color3 = this.mTypedArray.getColor(this.mBackgroundContourColorId, Integer.MIN_VALUE);
        if (color3 != Integer.MIN_VALUE) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).backgroundContourColor(color3);
        }
        int dimensionPixelSize5 = this.mTypedArray.getDimensionPixelSize(this.mBackgroundContourWidthId, -1);
        if (dimensionPixelSize5 != -1) {
            copyIfCan = createIfNeeds(copyIfCan, this.mContext).backgroundContourWidthPx(dimensionPixelSize5);
        }
        if (z) {
            int dimensionPixelSize6 = this.mTypedArray.getDimensionPixelSize(this.mOffsetYId, -1);
            if (dimensionPixelSize6 != -1) {
                copyIfCan = createIfNeeds(copyIfCan, this.mContext).iconOffsetYPx(dimensionPixelSize6);
            }
            int dimensionPixelSize7 = this.mTypedArray.getDimensionPixelSize(this.mOffsetXId, -1);
            if (dimensionPixelSize7 != -1) {
                copyIfCan = createIfNeeds(copyIfCan, this.mContext).iconOffsetXPx(dimensionPixelSize7);
            }
        }
        return z2 ? createIfNeeds(copyIfCan, this.mContext) : copyIfCan;
    }

    @Nullable
    private static IconicsDrawable copyIfCan(@Nullable IconicsDrawable iconicsDrawable) {
        if (iconicsDrawable != null) {
            return iconicsDrawable.clone();
        }
        return null;
    }

    @NonNull
    private static IconicsDrawable createIfNeeds(@Nullable IconicsDrawable iconicsDrawable, Context context) {
        return iconicsDrawable == null ? new IconicsDrawable(context) : iconicsDrawable;
    }
}
