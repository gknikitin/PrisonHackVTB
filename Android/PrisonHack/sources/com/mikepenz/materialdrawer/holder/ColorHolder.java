package com.mikepenz.materialdrawer.holder;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

public class ColorHolder extends com.mikepenz.materialize.holder.ColorHolder {
    public static ColorHolder fromColorRes(@ColorRes int i) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.setColorRes(i);
        return colorHolder;
    }

    public static ColorHolder fromColor(@ColorInt int i) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.setColorInt(i);
        return colorHolder;
    }
}
