package com.mikepenz.materialdrawer.holder;

import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;

public class DimenHolder extends com.mikepenz.materialize.holder.DimenHolder {
    public static DimenHolder fromPixel(@Dimension(unit = 1) int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.setPixel(i);
        return dimenHolder;
    }

    public static DimenHolder fromDp(@Dimension(unit = 0) int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.setDp(i);
        return dimenHolder;
    }

    public static DimenHolder fromResource(@DimenRes int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.setResource(i);
        return dimenHolder;
    }
}
