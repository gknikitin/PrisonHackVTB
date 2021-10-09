package com.mikepenz.materialdrawer.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtil {
    /* access modifiers changed from: private */
    public View contentView;
    /* access modifiers changed from: private */
    public View decorView;
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            Rect rect = new Rect();
            KeyboardUtil.this.decorView.getWindowVisibleDisplayFrame(rect);
            int i = KeyboardUtil.this.decorView.getContext().getResources().getDisplayMetrics().heightPixels - rect.bottom;
            if (i != 0) {
                if (KeyboardUtil.this.contentView.getPaddingBottom() != i) {
                    KeyboardUtil.this.contentView.setPadding(0, 0, 0, i);
                }
            } else if (KeyboardUtil.this.contentView.getPaddingBottom() != 0) {
                KeyboardUtil.this.contentView.setPadding(0, 0, 0, 0);
            }
        }
    };

    public KeyboardUtil(Activity activity, View view) {
        this.decorView = activity.getWindow().getDecorView();
        this.contentView = view;
        if (Build.VERSION.SDK_INT >= 19) {
            this.decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    public void enable() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    public void disable() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
}
