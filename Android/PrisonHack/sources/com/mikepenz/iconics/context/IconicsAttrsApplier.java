package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.AttributeSet;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.C0634R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class IconicsAttrsApplier {
    @Nullable
    public static IconicsDrawable getIconicsDrawable(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0634R.styleable.Iconics);
        try {
            return new IconicsAttrsExtractor(context, obtainStyledAttributes).iconId(C0634R.styleable.Iconics_ico_icon).colorsId(C0634R.styleable.Iconics_ico_color).sizeId(C0634R.styleable.Iconics_ico_size).paddingId(C0634R.styleable.Iconics_ico_padding).contourColorId(C0634R.styleable.Iconics_ico_contour_color).contourWidthId(C0634R.styleable.Iconics_ico_contour_width).backgroundColorId(C0634R.styleable.Iconics_ico_background_color).cornerRadiusId(C0634R.styleable.Iconics_ico_corner_radius).backgroundContourColorId(C0634R.styleable.Iconics_ico_background_contour_color).backgroundContourWidthId(C0634R.styleable.Iconics_ico_background_contour_width).offsetXId(C0634R.styleable.Iconics_ico_offset_x).offsetYId(C0634R.styleable.Iconics_ico_offset_y).extractWithOffsets();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
