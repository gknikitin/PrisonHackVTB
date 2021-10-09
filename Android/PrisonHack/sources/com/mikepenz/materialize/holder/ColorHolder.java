package com.mikepenz.materialize.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialize.util.UIUtils;

public class ColorHolder {
    private int mColorInt = 0;
    private int mColorRes = -1;

    public int getColorInt() {
        return this.mColorInt;
    }

    public void setColorInt(int i) {
        this.mColorInt = i;
    }

    public int getColorRes() {
        return this.mColorRes;
    }

    public void setColorRes(int i) {
        this.mColorRes = i;
    }

    public static ColorHolder fromColorRes(@ColorRes int i) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorRes = i;
        return colorHolder;
    }

    public static ColorHolder fromColor(@ColorInt int i) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorInt = i;
        return colorHolder;
    }

    public void applyTo(Context context, GradientDrawable gradientDrawable) {
        if (this.mColorInt != 0) {
            gradientDrawable.setColor(this.mColorInt);
        } else if (this.mColorRes != -1) {
            gradientDrawable.setColor(ContextCompat.getColor(context, this.mColorRes));
        }
    }

    public void applyToBackground(View view) {
        if (this.mColorInt != 0) {
            view.setBackgroundColor(this.mColorInt);
        } else if (this.mColorRes != -1) {
            view.setBackgroundResource(this.mColorRes);
        }
    }

    public void applyToOr(TextView textView, ColorStateList colorStateList) {
        if (this.mColorInt != 0) {
            textView.setTextColor(this.mColorInt);
        } else if (this.mColorRes != -1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), this.mColorRes));
        } else if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public int color(Context context, @AttrRes int i, @ColorRes int i2) {
        int color = color(context);
        return color == 0 ? UIUtils.getThemeColorFromAttrOrRes(context, i, i2) : color;
    }

    public int color(Context context) {
        if (this.mColorInt == 0 && this.mColorRes != -1) {
            this.mColorInt = ContextCompat.getColor(context, this.mColorRes);
        }
        return this.mColorInt;
    }

    public static int color(ColorHolder colorHolder, Context context, @AttrRes int i, @ColorRes int i2) {
        if (colorHolder == null) {
            return UIUtils.getThemeColorFromAttrOrRes(context, i, i2);
        }
        return colorHolder.color(context, i, i2);
    }

    public static int color(ColorHolder colorHolder, Context context) {
        if (colorHolder == null) {
            return 0;
        }
        return colorHolder.color(context);
    }

    public static void applyToOr(ColorHolder colorHolder, TextView textView, ColorStateList colorStateList) {
        if (colorHolder != null && textView != null) {
            colorHolder.applyToOr(textView, colorStateList);
        } else if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static void applyToOrTransparent(ColorHolder colorHolder, Context context, GradientDrawable gradientDrawable) {
        if (colorHolder != null && gradientDrawable != null) {
            colorHolder.applyTo(context, gradientDrawable);
        } else if (gradientDrawable != null) {
            gradientDrawable.setColor(0);
        }
    }
}
