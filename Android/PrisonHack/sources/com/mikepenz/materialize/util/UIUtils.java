package com.mikepenz.materialize.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.content.res.ResourcesCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.mikepenz.materialize.C0676R;

@SuppressLint({"InlinedApi"})
public class UIUtils {
    public static int adjustAlpha(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }

    public static int getThemeColor(Context context, @AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    public static int getThemeColorFromAttrOrRes(Context context, @AttrRes int i, @ColorRes int i2) {
        int themeColor = getThemeColor(context, i);
        return themeColor == 0 ? ResourcesCompat.getColor(context.getResources(), i2, context.getTheme()) : themeColor;
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public static void setBackground(View view, Drawable drawable) {
        ViewCompat.setBackground(view, drawable);
    }

    public static void setBackground(View view, @DrawableRes int i) {
        ViewCompat.setBackground(view, ContextCompat.getDrawable(view.getContext(), i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getThemeAttributeDimensionSize(android.content.Context r3, @android.support.annotation.AttrRes int r4) {
        /*
            r0 = 0
            android.content.res.Resources$Theme r3 = r3.getTheme()     // Catch:{ all -> 0x001c }
            r1 = 1
            int[] r1 = new int[r1]     // Catch:{ all -> 0x001c }
            r2 = 0
            r1[r2] = r4     // Catch:{ all -> 0x001c }
            android.content.res.TypedArray r3 = r3.obtainStyledAttributes(r1)     // Catch:{ all -> 0x001c }
            int r4 = r3.getDimensionPixelSize(r2, r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0018
            r3.recycle()
        L_0x0018:
            return r4
        L_0x0019:
            r4 = move-exception
            r0 = r3
            goto L_0x001d
        L_0x001c:
            r4 = move-exception
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.recycle()
        L_0x0022:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialize.util.UIUtils.getThemeAttributeDimensionSize(android.content.Context, int):int");
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getActionBarHeight(Context context) {
        int themeAttributeDimensionSize = getThemeAttributeDimensionSize(context, C0676R.attr.actionBarSize);
        return themeAttributeDimensionSize == 0 ? context.getResources().getDimensionPixelSize(C0676R.dimen.abc_action_bar_default_height_material) : themeAttributeDimensionSize;
    }

    public static int getStatusBarHeight(Context context) {
        return getStatusBarHeight(context, false);
    }

    public static int getStatusBarHeight(Context context, boolean z) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0676R.dimen.tool_bar_top_padding);
        if (dimensionPixelSize2 != 0 || z) {
            return dimensionPixelSize == 0 ? dimensionPixelSize2 : dimensionPixelSize;
        }
        return 0;
    }

    public static float convertDpToPixel(float f, Context context) {
        return f * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static float convertPixelsToDp(float f, Context context) {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static void setTranslucentStatusFlag(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            setFlag(activity, 67108864, z);
        }
    }

    public static void setTranslucentNavigationFlag(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            setFlag(activity, 134217728, z);
        }
    }

    public static void setFlag(Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags = i | attributes.flags;
        } else {
            attributes.flags = (i ^ -1) & attributes.flags;
        }
        window.setAttributes(attributes);
    }

    public static StateListDrawable getIconStateList(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static StateListDrawable getSelectableBackground(Context context, int i, boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable(i);
        stateListDrawable.addState(new int[]{16842913}, colorDrawable);
        stateListDrawable.addState(new int[0], getSelectableBackground(context));
        if (z) {
            int integer = context.getResources().getInteger(17694720);
            stateListDrawable.setEnterFadeDuration(integer);
            stateListDrawable.setExitFadeDuration(integer);
        }
        return stateListDrawable;
    }

    public static StateListDrawable getSelectablePressedBackground(Context context, int i, int i2, boolean z) {
        StateListDrawable selectableBackground = getSelectableBackground(context, i, z);
        ColorDrawable colorDrawable = new ColorDrawable(adjustAlpha(i, i2));
        selectableBackground.addState(new int[]{16842919}, colorDrawable);
        return selectableBackground;
    }

    public static int getSelectableBackgroundRes(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0676R.attr.selectableItemBackground, typedValue, true);
        return typedValue.resourceId;
    }

    public static Drawable getSelectableBackground(Context context) {
        return ContextCompat.getDrawable(context, getSelectableBackgroundRes(context));
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
