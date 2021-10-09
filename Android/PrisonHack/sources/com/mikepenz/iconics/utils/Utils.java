package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.StyleableRes;
import android.util.TypedValue;

public class Utils {
    public static int convertDpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static String getString(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        if (typedArray.hasValue(i)) {
            return typedArray.getString(i);
        }
        return typedArray.getString(i2);
    }

    public static StateListDrawable getCheckableIconStateList(Context context, Drawable drawable, Drawable drawable2) {
        return getCheckableIconStateList(context, drawable, drawable2, true);
    }

    public static StateListDrawable getCheckableIconStateList(Context context, Drawable drawable, Drawable drawable2, boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, drawable2);
        stateListDrawable.addState(new int[]{-16842912}, drawable);
        if (z) {
            int integer = context.getResources().getInteger(17694720);
            stateListDrawable.setEnterFadeDuration(integer);
            stateListDrawable.setExitFadeDuration(integer);
        }
        return stateListDrawable;
    }
}
