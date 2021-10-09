package com.mikepenz.materialize.util;

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
    /* access modifiers changed from: private */
    public float initialDpDiff = -1.0f;
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            Rect rect = new Rect();
            KeyboardUtil.this.decorView.getWindowVisibleDisplayFrame(rect);
            float convertPixelsToDp = UIUtils.convertPixelsToDp((float) (KeyboardUtil.this.decorView.getRootView().getHeight() - (rect.bottom - rect.top)), KeyboardUtil.this.decorView.getContext());
            if (KeyboardUtil.this.initialDpDiff == -1.0f) {
                float unused = KeyboardUtil.this.initialDpDiff = convertPixelsToDp;
            }
            if (convertPixelsToDp - KeyboardUtil.this.initialDpDiff > 100.0f) {
                if (KeyboardUtil.this.contentView.getPaddingBottom() == 0) {
                    KeyboardUtil.this.contentView.setPadding(0, 0, 0, (int) UIUtils.convertDpToPixel(convertPixelsToDp - KeyboardUtil.this.initialDpDiff, KeyboardUtil.this.decorView.getContext()));
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
