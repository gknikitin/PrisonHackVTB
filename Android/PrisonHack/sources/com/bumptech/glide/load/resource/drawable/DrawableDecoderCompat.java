package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p000v4.content.res.ResourcesCompat;
import android.support.p003v7.content.res.AppCompatResources;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i) {
        return getDrawable(context, i, (Resources.Theme) null);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context, i);
            }
        } catch (NoClassDefFoundError unused) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context.getTheme();
        }
        return loadDrawableV4(context, i, theme);
    }

    private static Drawable loadDrawableV7(Context context, @DrawableRes int i) {
        return AppCompatResources.getDrawable(context, i);
    }

    private static Drawable loadDrawableV4(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
