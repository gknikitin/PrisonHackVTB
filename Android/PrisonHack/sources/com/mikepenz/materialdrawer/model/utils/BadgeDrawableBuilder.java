package com.mikepenz.materialdrawer.model.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.p003v7.content.res.AppCompatResources;
import android.util.StateSet;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.ColorHolder;

public class BadgeDrawableBuilder {
    private BadgeStyle mStyle;

    public BadgeDrawableBuilder(BadgeStyle badgeStyle) {
        this.mStyle = badgeStyle;
    }

    public StateListDrawable build(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = (GradientDrawable) AppCompatResources.getDrawable(context, this.mStyle.getGradientDrawable());
        GradientDrawable gradientDrawable2 = (GradientDrawable) gradientDrawable.getConstantState().newDrawable().mutate();
        ColorHolder.applyToOrTransparent(this.mStyle.getColor(), context, gradientDrawable);
        if (this.mStyle.getColorPressed() == null) {
            ColorHolder.applyToOrTransparent(this.mStyle.getColor(), context, gradientDrawable2);
        } else {
            ColorHolder.applyToOrTransparent(this.mStyle.getColorPressed(), context, gradientDrawable2);
        }
        if (this.mStyle.getCorners() != null) {
            gradientDrawable.setCornerRadius((float) this.mStyle.getCorners().asPixel(context));
            gradientDrawable2.setCornerRadius((float) this.mStyle.getCorners().asPixel(context));
        }
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        return stateListDrawable;
    }
}
