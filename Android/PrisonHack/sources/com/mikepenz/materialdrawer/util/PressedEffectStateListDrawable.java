package com.mikepenz.materialdrawer.util;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

@SuppressLint({"InlinedApi"})
public class PressedEffectStateListDrawable extends StateListDrawable {
    private int color;
    private int selectionColor;

    public boolean isStateful() {
        return true;
    }

    public PressedEffectStateListDrawable(Drawable drawable, int i, int i2) {
        Drawable mutate = drawable.mutate();
        addState(new int[]{16842913}, mutate);
        addState(new int[0], mutate);
        this.color = i;
        this.selectionColor = i2;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i : iArr) {
            if (i == 16842913) {
                z = true;
            }
        }
        if (z) {
            super.setColorFilter(this.selectionColor, PorterDuff.Mode.SRC_IN);
        } else {
            super.setColorFilter(this.color, PorterDuff.Mode.SRC_IN);
        }
        return super.onStateChange(iArr);
    }
}
