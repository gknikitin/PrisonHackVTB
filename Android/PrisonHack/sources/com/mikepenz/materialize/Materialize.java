package com.mikepenz.materialize;

import android.app.Activity;
import android.view.ViewGroup;
import com.mikepenz.materialize.util.KeyboardUtil;
import com.mikepenz.materialize.view.IScrimInsetsLayout;

public class Materialize {
    private final MaterializeBuilder mBuilder;
    private KeyboardUtil mKeyboardUtil = null;

    protected Materialize(MaterializeBuilder materializeBuilder) {
        this.mBuilder = materializeBuilder;
    }

    public void setFullscreen(boolean z) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintStatusBar(!z);
            this.mBuilder.mScrimInsetsLayout.setTintNavigationBar(!z);
        }
    }

    public void setTintStatusBar(boolean z) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintStatusBar(z);
        }
    }

    public void setTintNavigationBar(boolean z) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintNavigationBar(z);
        }
    }

    public void setStatusBarColor(int i) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setInsetForeground(i);
            this.mBuilder.mScrimInsetsLayout.getView().invalidate();
        }
    }

    public IScrimInsetsLayout getScrimInsetsFrameLayout() {
        return this.mBuilder.mScrimInsetsLayout;
    }

    public ViewGroup getContent() {
        return this.mBuilder.mContentRoot;
    }

    public void keyboardSupportEnabled(Activity activity, boolean z) {
        if (getContent() != null && getContent().getChildCount() > 0) {
            if (this.mKeyboardUtil == null) {
                this.mKeyboardUtil = new KeyboardUtil(activity, getContent().getChildAt(0));
                this.mKeyboardUtil.disable();
            }
            if (z) {
                this.mKeyboardUtil.enable();
            } else {
                this.mKeyboardUtil.disable();
            }
        }
    }
}
