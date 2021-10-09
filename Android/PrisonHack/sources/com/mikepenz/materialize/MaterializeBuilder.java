package com.mikepenz.materialize;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.materialize.view.IScrimInsetsLayout;
import com.mikepenz.materialize.view.ScrimInsetsFrameLayout;

public class MaterializeBuilder {
    protected Activity mActivity;
    protected ViewGroup mContainer = null;
    protected ViewGroup.LayoutParams mContainerLayoutParams = null;
    protected ViewGroup mContentRoot;
    protected boolean mFullscreen = false;
    protected boolean mNavigationBarPadding = false;
    protected ViewGroup mRootView;
    protected IScrimInsetsLayout mScrimInsetsLayout;
    protected int mStatusBarColor = 0;
    protected int mStatusBarColorRes = -1;
    protected boolean mStatusBarPadding = false;
    protected boolean mSystemUIHidden = false;
    protected boolean mTintNavigationBar = false;
    protected boolean mTintStatusBar = true;
    protected boolean mTranslucentNavigationBarProgrammatically = false;
    protected boolean mTranslucentStatusBarProgrammatically = false;
    protected boolean mTransparentNavigationBar = false;
    protected boolean mTransparentStatusBar = false;
    protected boolean mUseScrimInsetsLayout = true;

    public MaterializeBuilder() {
    }

    public MaterializeBuilder(Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
    }

    public MaterializeBuilder withActivity(Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
        return this;
    }

    public MaterializeBuilder withRootView(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        return this;
    }

    public MaterializeBuilder withRootView(@IdRes int i) {
        if (this.mActivity != null) {
            return withRootView((ViewGroup) this.mActivity.findViewById(i));
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public MaterializeBuilder withUseScrimInsetsLayout(boolean z) {
        this.mUseScrimInsetsLayout = z;
        return this;
    }

    public MaterializeBuilder withStatusBarColor(@ColorInt int i) {
        this.mStatusBarColor = i;
        return this;
    }

    public MaterializeBuilder withStatusBarColorRes(@ColorRes int i) {
        this.mStatusBarColorRes = i;
        return this;
    }

    public MaterializeBuilder withTransparentStatusBar(boolean z) {
        this.mTransparentStatusBar = z;
        return this;
    }

    public MaterializeBuilder withTranslucentStatusBarProgrammatically(boolean z) {
        this.mTranslucentStatusBarProgrammatically = z;
        return this;
    }

    public MaterializeBuilder withStatusBarPadding(boolean z) {
        this.mStatusBarPadding = z;
        return this;
    }

    public MaterializeBuilder withTintedStatusBar(boolean z) {
        this.mTintStatusBar = z;
        return this;
    }

    public MaterializeBuilder withTranslucentNavigationBarProgrammatically(boolean z) {
        this.mTranslucentNavigationBarProgrammatically = z;
        return this;
    }

    public MaterializeBuilder withTransparentNavigationBar(boolean z) {
        this.mTransparentNavigationBar = z;
        return this;
    }

    public MaterializeBuilder withNavigationBarPadding(boolean z) {
        this.mNavigationBarPadding = z;
        return this;
    }

    public MaterializeBuilder withTintedNavigationBar(boolean z) {
        this.mTintNavigationBar = z;
        if (z) {
            withTranslucentNavigationBarProgrammatically(true);
        }
        return this;
    }

    public MaterializeBuilder withFullscreen(boolean z) {
        this.mFullscreen = z;
        if (z) {
            withTranslucentNavigationBarProgrammatically(true);
            withTintedStatusBar(false);
            withTintedNavigationBar(false);
        }
        return this;
    }

    public MaterializeBuilder withSystemUIHidden(boolean z) {
        this.mSystemUIHidden = z;
        if (z) {
            withFullscreen(z);
        }
        return this;
    }

    public MaterializeBuilder withContainer(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
        return this;
    }

    public MaterializeBuilder withContainerLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mContainerLayoutParams = layoutParams;
        return this;
    }

    public MaterializeBuilder withContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mContainer = viewGroup;
        this.mContainerLayoutParams = layoutParams;
        return this;
    }

    public Materialize build() {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity");
        }
        if (this.mUseScrimInsetsLayout) {
            this.mScrimInsetsLayout = (ScrimInsetsFrameLayout) this.mActivity.getLayoutInflater().inflate(C0676R.layout.materialize, this.mRootView, false);
            if (this.mRootView == null || this.mRootView.getChildCount() == 0) {
                throw new RuntimeException("You have to set your layout for this activity with setContentView() first. Or you build the drawer on your own with .buildView()");
            }
            View childAt = this.mRootView.getChildAt(0);
            boolean z = childAt.getId() == C0676R.C0679id.materialize_root;
            if (this.mStatusBarColor == 0 && this.mStatusBarColorRes != -1) {
                this.mStatusBarColor = ContextCompat.getColor(this.mActivity, this.mStatusBarColorRes);
            } else if (this.mStatusBarColor == 0) {
                this.mStatusBarColor = UIUtils.getThemeColorFromAttrOrRes(this.mActivity, C0676R.attr.colorPrimaryDark, C0676R.C0677color.materialize_primary_dark);
            }
            this.mScrimInsetsLayout.setInsetForeground(this.mStatusBarColor);
            this.mScrimInsetsLayout.setTintStatusBar(this.mTintStatusBar);
            this.mScrimInsetsLayout.setTintNavigationBar(this.mTintNavigationBar);
            this.mScrimInsetsLayout.setSystemUIVisible(!this.mFullscreen && !this.mSystemUIHidden);
            if (!z) {
                this.mRootView.removeView(childAt);
            } else {
                this.mRootView.removeAllViews();
            }
            this.mScrimInsetsLayout.getView().addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            this.mContentRoot = this.mScrimInsetsLayout.getView();
            if (this.mContainer != null) {
                this.mContentRoot = this.mContainer;
                this.mContentRoot.addView(this.mScrimInsetsLayout.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.mContentRoot.setId(C0676R.C0679id.materialize_root);
            if (this.mContainerLayoutParams == null) {
                this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            this.mRootView.addView(this.mContentRoot, this.mContainerLayoutParams);
        } else if (this.mContainer == null) {
            throw new RuntimeException("please pass a container");
        } else {
            View childAt2 = this.mRootView.getChildAt(0);
            this.mRootView.removeView(childAt2);
            this.mContainer.addView(childAt2, new FrameLayout.LayoutParams(-1, -1));
            if (this.mContainerLayoutParams == null) {
                this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            this.mRootView.addView(this.mContainer, this.mContainerLayoutParams);
        }
        if (this.mSystemUIHidden && Build.VERSION.SDK_INT >= 16) {
            this.mActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        if (this.mTranslucentStatusBarProgrammatically && Build.VERSION.SDK_INT >= 21) {
            UIUtils.setTranslucentStatusFlag(this.mActivity, false);
        }
        if (this.mTranslucentNavigationBarProgrammatically && Build.VERSION.SDK_INT >= 21) {
            UIUtils.setTranslucentNavigationFlag(this.mActivity, true);
        }
        if ((this.mTransparentStatusBar || this.mTransparentNavigationBar) && Build.VERSION.SDK_INT >= 21) {
            this.mActivity.getWindow().addFlags(Integer.MIN_VALUE);
        }
        if (this.mTransparentStatusBar && Build.VERSION.SDK_INT >= 21) {
            UIUtils.setTranslucentStatusFlag(this.mActivity, false);
            this.mActivity.getWindow().setStatusBarColor(0);
        }
        if (this.mTransparentNavigationBar && Build.VERSION.SDK_INT >= 21) {
            UIUtils.setTranslucentNavigationFlag(this.mActivity, true);
            this.mActivity.getWindow().setNavigationBarColor(0);
        }
        int statusBarHeight = (!this.mStatusBarPadding || Build.VERSION.SDK_INT < 21) ? 0 : UIUtils.getStatusBarHeight(this.mActivity);
        int navigationBarHeight = (!this.mNavigationBarPadding || Build.VERSION.SDK_INT < 21) ? 0 : UIUtils.getNavigationBarHeight(this.mActivity);
        if (this.mStatusBarPadding || (this.mNavigationBarPadding && Build.VERSION.SDK_INT >= 21)) {
            this.mScrimInsetsLayout.getView().setPadding(0, statusBarHeight, 0, navigationBarHeight);
        }
        this.mActivity = null;
        return new Materialize(this);
    }
}
