package com.mikepenz.materialdrawer.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialize.util.UIUtils;

@SuppressLint({"InlinedApi"})
public class DrawerUIUtils {
    public static ColorStateList getTextColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{i2, i});
    }

    public static StateListDrawable getIconStateList(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static StateListDrawable getDrawerItemBackground(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, colorDrawable);
        return stateListDrawable;
    }

    public static int getOptimalDrawerWidth(Context context) {
        return Math.min(UIUtils.getScreenWidth(context) - UIUtils.getActionBarHeight(context), context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_width));
    }

    public static Drawable getPlaceHolder(Context context) {
        return new IconicsDrawable(context, (IIcon) MaterialDrawerFont.Icon.mdf_person).colorRes(C0658R.C0659color.accent).backgroundColorRes(C0658R.C0659color.primary).sizeDp(56).paddingDp(16);
    }

    public static void setDrawerVerticalPadding(View view) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_vertical_padding);
        view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public static void setDrawerVerticalPadding(View view, int i) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_vertical_padding);
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i * dimensionPixelSize, 0, dimensionPixelSize, 0);
        } else {
            view.setPadding(i * dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    public static boolean isSystemBarOnBottom(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (!(displayMetrics.widthPixels != displayMetrics.heightPixels && context.getResources().getConfiguration().smallestScreenWidthDp < 600) || displayMetrics.widthPixels < displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
