package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.view.SupportMenuInflater;
import android.support.p003v7.view.menu.MenuBuilder;
import android.support.p003v7.widget.DefaultItemAnimator;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import com.mikepenz.fastadapter.expandable.ExpandableExtension;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.utils.DefaultIdDistributor;
import com.mikepenz.fastadapter.utils.DefaultIdDistributorImpl;
import com.mikepenz.iconics.utils.Utils;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.Materialize;
import com.mikepenz.materialize.MaterializeBuilder;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DrawerBuilder {
    public final DefaultIdDistributor idDistributor = new DefaultIdDistributorImpl();
    protected AccountHeader mAccountHeader;
    protected boolean mAccountHeaderSticky = false;
    protected ActionBarDrawerToggle mActionBarDrawerToggle;
    protected boolean mActionBarDrawerToggleEnabled = true;
    protected Activity mActivity;
    protected FastAdapter<IDrawerItem> mAdapter;
    protected RecyclerView.Adapter mAdapterWrapper;
    protected boolean mAnimateActionBarDrawerToggle = false;
    protected boolean mAppended = false;
    protected boolean mCloseOnClick = true;
    protected int mCurrentStickyFooterSelection = -1;
    protected View mCustomView;
    protected int mDelayDrawerClickEvent = 0;
    protected int mDelayOnDrawerClose = 50;
    protected Boolean mDisplayBelowStatusBar;
    protected Integer mDrawerGravity = Integer.valueOf(GravityCompat.START);
    protected DrawerLayout mDrawerLayout;
    protected int mDrawerWidth = -1;
    protected ExpandableExtension<IDrawerItem> mExpandableExtension = new ExpandableExtension<>();
    protected boolean mFireInitialOnClick = false;
    protected ModelAdapter<IDrawerItem, IDrawerItem> mFooterAdapter = new ItemAdapter().withIdDistributor(this.idDistributor);
    protected boolean mFooterClickable = false;
    protected boolean mFooterDivider = true;
    protected View mFooterView;
    protected boolean mFullscreen = false;
    protected boolean mGenerateMiniDrawer = false;
    protected boolean mHasStableIds = false;
    protected ModelAdapter<IDrawerItem, IDrawerItem> mHeaderAdapter = new ItemAdapter().withIdDistributor(this.idDistributor);
    protected boolean mHeaderDivider = true;
    protected boolean mHeaderPadding = true;
    protected View mHeaderView;
    protected DimenHolder mHeiderHeight = null;
    private boolean mInnerShadow = false;
    protected ModelAdapter<IDrawerItem, IDrawerItem> mItemAdapter = new ItemAdapter().withIdDistributor(this.idDistributor);
    protected RecyclerView.ItemAnimator mItemAnimator = new DefaultItemAnimator();
    protected boolean mKeepStickyItemsVisible = false;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected Materialize mMaterialize;
    protected MiniDrawer mMiniDrawer = null;
    protected boolean mMultiSelect = false;
    protected Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;
    protected Drawer.OnDrawerItemLongClickListener mOnDrawerItemLongClickListener;
    protected Drawer.OnDrawerListener mOnDrawerListener;
    protected Drawer.OnDrawerNavigationListener mOnDrawerNavigationListener;
    protected RecyclerView mRecyclerView;
    protected ViewGroup mRootView;
    protected Bundle mSavedInstance;
    protected boolean mScrollToTopAfterClick = false;
    protected long mSelectedItemIdentifier = 0;
    protected int mSelectedItemPosition = 0;
    protected SharedPreferences mSharedPreferences;
    protected boolean mShowDrawerOnFirstLaunch = false;
    protected boolean mShowDrawerUntilDraggedOpened = false;
    protected int mSliderBackgroundColor = 0;
    protected int mSliderBackgroundColorRes = -1;
    protected Drawable mSliderBackgroundDrawable = null;
    protected int mSliderBackgroundDrawableRes = -1;
    protected ScrimInsetsRelativeLayout mSliderLayout;
    protected List<IDrawerItem> mStickyDrawerItems = new ArrayList();
    protected boolean mStickyFooterDivider = false;
    protected boolean mStickyFooterShadow = true;
    protected View mStickyFooterShadowView;
    protected ViewGroup mStickyFooterView;
    protected boolean mStickyHeaderShadow = true;
    protected View mStickyHeaderView;
    protected boolean mSystemUIHidden = false;
    protected Toolbar mToolbar;
    protected boolean mTranslucentNavigationBar = false;
    protected boolean mTranslucentNavigationBarProgrammatically = false;
    protected boolean mTranslucentStatusBar = true;
    protected boolean mUsed = false;

    public DrawerBuilder() {
        getAdapter();
    }

    public DrawerBuilder(@NonNull Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
        this.mLayoutManager = new LinearLayoutManager(this.mActivity);
        getAdapter();
    }

    public DrawerBuilder withActivity(@NonNull Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
        this.mLayoutManager = new LinearLayoutManager(this.mActivity);
        return this;
    }

    public DrawerBuilder withRootView(@NonNull ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        withTranslucentStatusBar(false);
        return this;
    }

    public DrawerBuilder withRootView(@IdRes int i) {
        if (this.mActivity != null) {
            return withRootView((ViewGroup) this.mActivity.findViewById(i));
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public DrawerBuilder withTranslucentStatusBar(boolean z) {
        this.mTranslucentStatusBar = z;
        return this;
    }

    public DrawerBuilder withDisplayBelowStatusBar(boolean z) {
        this.mDisplayBelowStatusBar = Boolean.valueOf(z);
        return this;
    }

    public DrawerBuilder withInnerShadow(boolean z) {
        this.mInnerShadow = z;
        return this;
    }

    public DrawerBuilder withToolbar(@NonNull Toolbar toolbar) {
        this.mToolbar = toolbar;
        return this;
    }

    public DrawerBuilder withTranslucentNavigationBar(boolean z) {
        this.mTranslucentNavigationBar = z;
        if (!z) {
            this.mTranslucentNavigationBarProgrammatically = false;
        }
        return this;
    }

    public DrawerBuilder withTranslucentNavigationBarProgrammatically(boolean z) {
        this.mTranslucentNavigationBarProgrammatically = z;
        if (z) {
            this.mTranslucentNavigationBar = true;
        }
        return this;
    }

    public DrawerBuilder withFullscreen(boolean z) {
        this.mFullscreen = z;
        if (z) {
            withTranslucentStatusBar(true);
            withTranslucentNavigationBar(false);
        }
        return this;
    }

    public DrawerBuilder withSystemUIHidden(boolean z) {
        this.mSystemUIHidden = z;
        if (z) {
            withFullscreen(z);
        }
        return this;
    }

    public DrawerBuilder withCustomView(@NonNull View view) {
        this.mCustomView = view;
        return this;
    }

    public DrawerBuilder withDrawerLayout(@NonNull DrawerLayout drawerLayout) {
        this.mDrawerLayout = drawerLayout;
        return this;
    }

    public DrawerBuilder withDrawerLayout(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mDrawerLayout = (DrawerLayout) this.mActivity.getLayoutInflater().inflate(i, this.mRootView, false);
        } else if (Build.VERSION.SDK_INT < 21) {
            this.mDrawerLayout = (DrawerLayout) this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer_fits_not, this.mRootView, false);
        } else {
            this.mDrawerLayout = (DrawerLayout) this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer, this.mRootView, false);
        }
        return this;
    }

    public DrawerBuilder withSliderBackgroundColor(@ColorInt int i) {
        this.mSliderBackgroundColor = i;
        return this;
    }

    public DrawerBuilder withSliderBackgroundColorRes(@ColorRes int i) {
        this.mSliderBackgroundColorRes = i;
        return this;
    }

    public DrawerBuilder withSliderBackgroundDrawable(@NonNull Drawable drawable) {
        this.mSliderBackgroundDrawable = drawable;
        return this;
    }

    public DrawerBuilder withSliderBackgroundDrawableRes(@DrawableRes int i) {
        this.mSliderBackgroundDrawableRes = i;
        return this;
    }

    public DrawerBuilder withDrawerWidthPx(int i) {
        this.mDrawerWidth = i;
        return this;
    }

    public DrawerBuilder withDrawerWidthDp(int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        this.mDrawerWidth = Utils.convertDpToPx(this.mActivity, (float) i);
        return this;
    }

    public DrawerBuilder withDrawerWidthRes(@DimenRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        this.mDrawerWidth = this.mActivity.getResources().getDimensionPixelSize(i);
        return this;
    }

    public DrawerBuilder withDrawerGravity(int i) {
        this.mDrawerGravity = Integer.valueOf(i);
        return this;
    }

    public DrawerBuilder withAccountHeader(@NonNull AccountHeader accountHeader) {
        return withAccountHeader(accountHeader, false);
    }

    public DrawerBuilder withAccountHeader(@NonNull AccountHeader accountHeader, boolean z) {
        this.mAccountHeader = accountHeader;
        this.mAccountHeaderSticky = z;
        return this;
    }

    public DrawerBuilder withActionBarDrawerToggleAnimated(boolean z) {
        this.mAnimateActionBarDrawerToggle = z;
        return this;
    }

    public DrawerBuilder withActionBarDrawerToggle(boolean z) {
        this.mActionBarDrawerToggleEnabled = z;
        return this;
    }

    public DrawerBuilder withActionBarDrawerToggle(@NonNull ActionBarDrawerToggle actionBarDrawerToggle) {
        this.mActionBarDrawerToggleEnabled = true;
        this.mActionBarDrawerToggle = actionBarDrawerToggle;
        return this;
    }

    public DrawerBuilder withScrollToTopAfterClick(boolean z) {
        this.mScrollToTopAfterClick = z;
        return this;
    }

    public DrawerBuilder withHeader(@NonNull View view) {
        this.mHeaderView = view;
        return this;
    }

    public DrawerBuilder withHeader(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mHeaderView = this.mActivity.getLayoutInflater().inflate(i, (ViewGroup) null, false);
        }
        return this;
    }

    public DrawerBuilder withHeaderDivider(boolean z) {
        this.mHeaderDivider = z;
        return this;
    }

    public DrawerBuilder withHeaderPadding(boolean z) {
        this.mHeaderPadding = z;
        return this;
    }

    public DrawerBuilder withHeaderHeight(DimenHolder dimenHolder) {
        this.mHeiderHeight = dimenHolder;
        return this;
    }

    public DrawerBuilder withStickyHeader(@NonNull View view) {
        this.mStickyHeaderView = view;
        return this;
    }

    public DrawerBuilder withStickyHeader(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mStickyHeaderView = this.mActivity.getLayoutInflater().inflate(i, (ViewGroup) null, false);
        }
        return this;
    }

    public DrawerBuilder withStickyHeaderShadow(boolean z) {
        this.mStickyHeaderShadow = z;
        return this;
    }

    public DrawerBuilder withFooter(@NonNull View view) {
        this.mFooterView = view;
        return this;
    }

    public DrawerBuilder withFooter(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mFooterView = this.mActivity.getLayoutInflater().inflate(i, (ViewGroup) null, false);
        }
        return this;
    }

    public DrawerBuilder withFooterClickable(boolean z) {
        this.mFooterClickable = z;
        return this;
    }

    public DrawerBuilder withFooterDivider(boolean z) {
        this.mFooterDivider = z;
        return this;
    }

    public DrawerBuilder withStickyFooter(@NonNull ViewGroup viewGroup) {
        this.mStickyFooterView = viewGroup;
        return this;
    }

    public DrawerBuilder withStickyFooter(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mStickyFooterView = (ViewGroup) this.mActivity.getLayoutInflater().inflate(i, (ViewGroup) null, false);
        }
        return this;
    }

    public DrawerBuilder withStickyFooterDivider(boolean z) {
        this.mStickyFooterDivider = z;
        return this;
    }

    public DrawerBuilder withStickyFooterShadow(boolean z) {
        this.mStickyFooterShadow = z;
        return this;
    }

    public DrawerBuilder withFireOnInitialOnClick(boolean z) {
        this.mFireInitialOnClick = z;
        return this;
    }

    public DrawerBuilder withMultiSelect(boolean z) {
        this.mMultiSelect = z;
        return this;
    }

    public DrawerBuilder withSelectedItemByPosition(int i) {
        this.mSelectedItemPosition = i;
        return this;
    }

    public DrawerBuilder withSelectedItem(long j) {
        this.mSelectedItemIdentifier = j;
        return this;
    }

    public DrawerBuilder withRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        return this;
    }

    public DrawerBuilder withHasStableIds(boolean z) {
        this.mHasStableIds = z;
        if (this.mAdapter != null) {
            this.mAdapter.setHasStableIds(z);
        }
        return this;
    }

    public DrawerBuilder withAdapter(@NonNull FastAdapter<IDrawerItem> fastAdapter) {
        this.mAdapter = fastAdapter;
        fastAdapter.addAdapter(0, this.mHeaderAdapter);
        fastAdapter.addAdapter(1, this.mItemAdapter);
        fastAdapter.addAdapter(2, this.mFooterAdapter);
        fastAdapter.addExtension(this.mExpandableExtension);
        return this;
    }

    /* access modifiers changed from: protected */
    public FastAdapter<IDrawerItem> getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = FastAdapter.with(Arrays.asList(new ModelAdapter[]{this.mHeaderAdapter, this.mItemAdapter, this.mFooterAdapter}), Arrays.asList(new IAdapterExtension[]{this.mExpandableExtension}));
            this.mAdapter.withSelectable(true);
            this.mAdapter.withMultiSelect(false);
            this.mAdapter.withAllowDeselection(false);
            this.mAdapter.setHasStableIds(this.mHasStableIds);
        }
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public IItemAdapter<IDrawerItem, IDrawerItem> getItemAdapter() {
        return this.mItemAdapter;
    }

    /* access modifiers changed from: protected */
    public IItemAdapter<IDrawerItem, IDrawerItem> getHeaderAdapter() {
        return this.mHeaderAdapter;
    }

    /* access modifiers changed from: protected */
    public IItemAdapter<IDrawerItem, IDrawerItem> getFooterAdapter() {
        return this.mFooterAdapter;
    }

    public DrawerBuilder withAdapterWrapper(@NonNull RecyclerView.Adapter adapter) {
        if (this.mAdapter == null) {
            throw new RuntimeException("this adapter has to be set in conjunction to a normal adapter which is used inside this wrapper adapter");
        }
        this.mAdapterWrapper = adapter;
        return this;
    }

    public DrawerBuilder withItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        this.mItemAnimator = itemAnimator;
        return this;
    }

    public DrawerBuilder withDrawerItems(@NonNull List<IDrawerItem> list) {
        getItemAdapter().set(list);
        return this;
    }

    public DrawerBuilder addDrawerItems(@NonNull IDrawerItem... iDrawerItemArr) {
        getItemAdapter().add((Model[]) iDrawerItemArr);
        return this;
    }

    public DrawerBuilder withKeepStickyItemsVisible(boolean z) {
        this.mKeepStickyItemsVisible = z;
        return this;
    }

    public DrawerBuilder withStickyDrawerItems(@NonNull List<IDrawerItem> list) {
        this.mStickyDrawerItems = list;
        return this;
    }

    public DrawerBuilder addStickyDrawerItems(@NonNull IDrawerItem... iDrawerItemArr) {
        if (this.mStickyDrawerItems == null) {
            this.mStickyDrawerItems = new ArrayList();
        }
        Collections.addAll(this.mStickyDrawerItems, iDrawerItemArr);
        return this;
    }

    public DrawerBuilder inflateMenu(@MenuRes int i) {
        SupportMenuInflater supportMenuInflater = new SupportMenuInflater(this.mActivity);
        MenuBuilder menuBuilder = new MenuBuilder(this.mActivity);
        supportMenuInflater.inflate(i, menuBuilder);
        addMenuItems(menuBuilder, false);
        return this;
    }

    private void addMenuItems(Menu menu, boolean z) {
        int i = C0658R.C0661id.material_drawer_menu_default_group;
        for (int i2 = 0; i2 < menu.size(); i2++) {
            MenuItem item = menu.getItem(i2);
            if (!(z || item.getGroupId() == i || item.getGroupId() == 0)) {
                i = item.getGroupId();
                DividerDrawerItem dividerDrawerItem = new DividerDrawerItem();
                getItemAdapter().add((Model[]) new IDrawerItem[]{dividerDrawerItem});
            }
            if (item.hasSubMenu()) {
                getItemAdapter().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withName(item.getTitle().toString())).withIcon(item.getIcon())).withIdentifier((long) item.getItemId())).withEnabled(item.isEnabled())).withSelectable(false)});
                addMenuItems(item.getSubMenu(), true);
            } else if (item.getGroupId() != 0 || z) {
                getItemAdapter().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName(item.getTitle().toString())).withIcon(item.getIcon())).withIdentifier((long) item.getItemId())).withEnabled(item.isEnabled())});
            } else {
                getItemAdapter().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withName(item.getTitle().toString())).withIcon(item.getIcon())).withIdentifier((long) item.getItemId())).withEnabled(item.isEnabled())});
            }
        }
    }

    public DrawerBuilder withCloseOnClick(boolean z) {
        this.mCloseOnClick = z;
        return this;
    }

    public DrawerBuilder withDelayOnDrawerClose(int i) {
        this.mDelayOnDrawerClose = i;
        return this;
    }

    public DrawerBuilder withDelayDrawerClickEvent(int i) {
        this.mDelayDrawerClickEvent = i;
        return this;
    }

    public DrawerBuilder withOnDrawerListener(@NonNull Drawer.OnDrawerListener onDrawerListener) {
        this.mOnDrawerListener = onDrawerListener;
        return this;
    }

    public DrawerBuilder withOnDrawerItemClickListener(@NonNull Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public DrawerBuilder withOnDrawerItemLongClickListener(@NonNull Drawer.OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        this.mOnDrawerItemLongClickListener = onDrawerItemLongClickListener;
        return this;
    }

    public DrawerBuilder withOnDrawerNavigationListener(@NonNull Drawer.OnDrawerNavigationListener onDrawerNavigationListener) {
        this.mOnDrawerNavigationListener = onDrawerNavigationListener;
        return this;
    }

    public DrawerBuilder withShowDrawerOnFirstLaunch(boolean z) {
        this.mShowDrawerOnFirstLaunch = z;
        return this;
    }

    public DrawerBuilder withShowDrawerUntilDraggedOpened(boolean z) {
        this.mShowDrawerUntilDraggedOpened = z;
        return this;
    }

    public DrawerBuilder withGenerateMiniDrawer(boolean z) {
        this.mGenerateMiniDrawer = z;
        return this;
    }

    public DrawerBuilder withSavedInstance(Bundle bundle) {
        this.mSavedInstance = bundle;
        return this;
    }

    public DrawerBuilder withSavedInstance(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
        return this;
    }

    private void handleShowOnLaunch() {
        if (this.mActivity != null && this.mDrawerLayout != null) {
            if (this.mShowDrawerOnFirstLaunch || this.mShowDrawerUntilDraggedOpened) {
                final SharedPreferences defaultSharedPreferences = this.mSharedPreferences != null ? this.mSharedPreferences : PreferenceManager.getDefaultSharedPreferences(this.mActivity);
                if (this.mShowDrawerOnFirstLaunch && !defaultSharedPreferences.getBoolean("navigation_drawer_learned", false)) {
                    this.mDrawerLayout.openDrawer((View) this.mSliderLayout);
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("navigation_drawer_learned", true);
                    edit.apply();
                } else if (this.mShowDrawerUntilDraggedOpened && !defaultSharedPreferences.getBoolean("navigation_drawer_dragged_open", false)) {
                    this.mDrawerLayout.openDrawer((View) this.mSliderLayout);
                    this.mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                        boolean hasBeenDragged = false;

                        public void onDrawerStateChanged(int i) {
                            if (i == 1) {
                                this.hasBeenDragged = true;
                            } else if (i != 0) {
                            } else {
                                if (!this.hasBeenDragged || !DrawerBuilder.this.mDrawerLayout.isDrawerOpen(DrawerBuilder.this.mDrawerGravity.intValue())) {
                                    this.hasBeenDragged = false;
                                    return;
                                }
                                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                                edit.putBoolean("navigation_drawer_dragged_open", true);
                                edit.apply();
                            }
                        }
                    });
                }
            }
        }
    }

    public Drawer build() {
        if (this.mUsed) {
            throw new RuntimeException("you must not reuse a DrawerBuilder builder");
        } else if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity");
        } else {
            this.mUsed = true;
            if (this.mDrawerLayout == null) {
                withDrawerLayout(-1);
            }
            this.mMaterialize = new MaterializeBuilder().withActivity(this.mActivity).withRootView(this.mRootView).withFullscreen(this.mFullscreen).withSystemUIHidden(this.mSystemUIHidden).withUseScrimInsetsLayout(false).withTransparentStatusBar(this.mTranslucentStatusBar).withTranslucentNavigationBarProgrammatically(this.mTranslucentNavigationBarProgrammatically).withContainer(this.mDrawerLayout).build();
            handleDrawerNavigation(this.mActivity, false);
            Drawer buildView = buildView();
            this.mSliderLayout.setId(C0658R.C0661id.material_drawer_slider_layout);
            this.mDrawerLayout.addView(this.mSliderLayout, 1);
            return buildView;
        }
    }

    public Drawer buildForFragment() {
        if (this.mUsed) {
            throw new RuntimeException("you must not reuse a DrawerBuilder builder");
        } else if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity");
        } else if (this.mRootView == null) {
            throw new RuntimeException("please pass the view which should host the DrawerLayout");
        } else {
            this.mUsed = true;
            if (this.mDrawerLayout == null) {
                withDrawerLayout(-1);
            }
            View childAt = this.mRootView.getChildAt(0);
            if (!(childAt.getId() == C0658R.C0661id.materialize_root)) {
                this.mRootView.removeView(childAt);
            } else {
                this.mRootView.removeAllViews();
            }
            this.mRootView.addView(this.mDrawerLayout, new FrameLayout.LayoutParams(-1, -1));
            this.mDrawerLayout.setId(C0658R.C0661id.materialize_root);
            handleDrawerNavigation(this.mActivity, false);
            Drawer buildView = buildView();
            this.mDrawerLayout.addView(childAt, 0);
            this.mSliderLayout.setId(C0658R.C0661id.material_drawer_slider_layout);
            this.mDrawerLayout.addView(this.mSliderLayout, 1);
            return buildView;
        }
    }

    /* access modifiers changed from: protected */
    public void handleDrawerNavigation(Activity activity, boolean z) {
        C06472 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                if ((DrawerBuilder.this.mOnDrawerNavigationListener == null || DrawerBuilder.this.mActionBarDrawerToggle == null || DrawerBuilder.this.mActionBarDrawerToggle.isDrawerIndicatorEnabled()) ? false : DrawerBuilder.this.mOnDrawerNavigationListener.onNavigationClickListener(view)) {
                    return;
                }
                if (DrawerBuilder.this.mDrawerLayout.isDrawerOpen(DrawerBuilder.this.mDrawerGravity.intValue())) {
                    DrawerBuilder.this.mDrawerLayout.closeDrawer(DrawerBuilder.this.mDrawerGravity.intValue());
                } else {
                    DrawerBuilder.this.mDrawerLayout.openDrawer(DrawerBuilder.this.mDrawerGravity.intValue());
                }
            }
        };
        if (z) {
            this.mActionBarDrawerToggle = null;
        }
        if (this.mActionBarDrawerToggleEnabled && this.mActionBarDrawerToggle == null && this.mToolbar != null) {
            this.mActionBarDrawerToggle = new ActionBarDrawerToggle(activity, this.mDrawerLayout, this.mToolbar, C0658R.string.material_drawer_open, C0658R.string.material_drawer_close) {
                public void onDrawerOpened(View view) {
                    if (DrawerBuilder.this.mOnDrawerListener != null) {
                        DrawerBuilder.this.mOnDrawerListener.onDrawerOpened(view);
                    }
                    super.onDrawerOpened(view);
                }

                public void onDrawerClosed(View view) {
                    if (DrawerBuilder.this.mOnDrawerListener != null) {
                        DrawerBuilder.this.mOnDrawerListener.onDrawerClosed(view);
                    }
                    super.onDrawerClosed(view);
                }

                public void onDrawerSlide(View view, float f) {
                    if (DrawerBuilder.this.mOnDrawerListener != null) {
                        DrawerBuilder.this.mOnDrawerListener.onDrawerSlide(view, f);
                    }
                    if (!DrawerBuilder.this.mAnimateActionBarDrawerToggle) {
                        super.onDrawerSlide(view, 0.0f);
                    } else {
                        super.onDrawerSlide(view, f);
                    }
                }
            };
            this.mActionBarDrawerToggle.syncState();
        }
        if (this.mToolbar != null) {
            this.mToolbar.setNavigationOnClickListener(r0);
        }
        if (this.mActionBarDrawerToggle != null) {
            this.mActionBarDrawerToggle.setToolbarNavigationClickListener(r0);
            this.mDrawerLayout.addDrawerListener(this.mActionBarDrawerToggle);
            return;
        }
        this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            public void onDrawerStateChanged(int i) {
            }

            public void onDrawerSlide(View view, float f) {
                if (DrawerBuilder.this.mOnDrawerListener != null) {
                    DrawerBuilder.this.mOnDrawerListener.onDrawerSlide(view, f);
                }
            }

            public void onDrawerOpened(View view) {
                if (DrawerBuilder.this.mOnDrawerListener != null) {
                    DrawerBuilder.this.mOnDrawerListener.onDrawerOpened(view);
                }
            }

            public void onDrawerClosed(View view) {
                if (DrawerBuilder.this.mOnDrawerListener != null) {
                    DrawerBuilder.this.mOnDrawerListener.onDrawerClosed(view);
                }
            }
        });
    }

    public Drawer buildView() {
        this.mSliderLayout = (ScrimInsetsRelativeLayout) this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer_slider, this.mDrawerLayout, false);
        this.mSliderLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this.mActivity, C0658R.attr.material_drawer_background, C0658R.C0659color.material_drawer_background));
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) this.mSliderLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.gravity = this.mDrawerGravity.intValue();
            this.mSliderLayout.setLayoutParams(DrawerUtils.processDrawerLayoutParams(this, layoutParams));
        }
        createContent();
        Drawer drawer = new Drawer(this);
        if (this.mAccountHeader != null) {
            this.mAccountHeader.setDrawer(drawer);
        }
        if (this.mSavedInstance != null && this.mSavedInstance.getBoolean("bundle_drawer_content_switched", false)) {
            this.mAccountHeader.toggleSelectionList(this.mActivity);
        }
        handleShowOnLaunch();
        if (!this.mAppended && this.mGenerateMiniDrawer) {
            this.mMiniDrawer = new MiniDrawer().withDrawer(drawer).withAccountHeader(this.mAccountHeader);
        }
        this.mActivity = null;
        return drawer;
    }

    public Drawer append(@NonNull Drawer drawer) {
        if (this.mUsed) {
            throw new RuntimeException("you must not reuse a DrawerBuilder builder");
        } else if (this.mDrawerGravity == null) {
            throw new RuntimeException("please set the gravity for the drawer");
        } else {
            this.mUsed = true;
            this.mAppended = true;
            this.mDrawerLayout = drawer.getDrawerLayout();
            this.mSliderLayout = (ScrimInsetsRelativeLayout) this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer_slider, this.mDrawerLayout, false);
            this.mSliderLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this.mActivity, C0658R.attr.material_drawer_background, C0658R.C0659color.material_drawer_background));
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) this.mSliderLayout.getLayoutParams();
            layoutParams.gravity = this.mDrawerGravity.intValue();
            this.mSliderLayout.setLayoutParams(DrawerUtils.processDrawerLayoutParams(this, layoutParams));
            this.mSliderLayout.setId(C0658R.C0661id.material_drawer_slider_layout);
            this.mDrawerLayout.addView(this.mSliderLayout, 1);
            createContent();
            Drawer drawer2 = new Drawer(this);
            if (this.mSavedInstance != null && this.mSavedInstance.getBoolean("bundle_drawer_content_switched_appended", false)) {
                this.mAccountHeader.toggleSelectionList(this.mActivity);
            }
            this.mActivity = null;
            return drawer2;
        }
    }

    private void createContent() {
        View view;
        int i = -1;
        if (this.mCustomView != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.mSliderLayout.addView(this.mCustomView, layoutParams);
            return;
        }
        if (Build.VERSION.SDK_INT < 21 && this.mDrawerLayout != null) {
            if (ViewCompat.getLayoutDirection(this.mRootView) == 0) {
                this.mDrawerLayout.setDrawerShadow(this.mDrawerGravity.intValue() == 8388611 ? C0658R.C0660drawable.material_drawer_shadow_right : C0658R.C0660drawable.material_drawer_shadow_left, this.mDrawerGravity.intValue());
            } else {
                this.mDrawerLayout.setDrawerShadow(this.mDrawerGravity.intValue() == 8388611 ? C0658R.C0660drawable.material_drawer_shadow_left : C0658R.C0660drawable.material_drawer_shadow_right, this.mDrawerGravity.intValue());
            }
        }
        if (this.mRecyclerView == null) {
            view = LayoutInflater.from(this.mActivity).inflate(C0658R.layout.material_drawer_recycler_view, this.mSliderLayout, false);
            this.mRecyclerView = (RecyclerView) view.findViewById(C0658R.C0661id.material_drawer_recycler_view);
            this.mRecyclerView.setItemAnimator(this.mItemAnimator);
            this.mRecyclerView.setFadingEdgeLength(0);
            this.mRecyclerView.setClipToPadding(false);
            this.mRecyclerView.setLayoutManager(this.mLayoutManager);
            int statusBarHeight = ((this.mDisplayBelowStatusBar == null || this.mDisplayBelowStatusBar.booleanValue()) && !this.mSystemUIHidden) ? UIUtils.getStatusBarHeight(this.mActivity) : 0;
            int i2 = this.mActivity.getResources().getConfiguration().orientation;
            this.mRecyclerView.setPadding(0, statusBarHeight, 0, ((this.mTranslucentNavigationBar || this.mFullscreen) && Build.VERSION.SDK_INT >= 21 && !this.mSystemUIHidden && (i2 == 1 || (i2 == 2 && DrawerUIUtils.isSystemBarOnBottom(this.mActivity)))) ? UIUtils.getNavigationBarHeight(this.mActivity) : 0);
        } else {
            view = this.mRecyclerView;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.mSliderLayout.addView(view, layoutParams2);
        if (this.mInnerShadow) {
            View findViewById = this.mSliderLayout.findViewById(C0658R.C0661id.material_drawer_inner_shadow);
            findViewById.setVisibility(0);
            findViewById.bringToFront();
            if (this.mDrawerGravity.intValue() == 8388611) {
                findViewById.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_left);
            } else {
                findViewById.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_right);
            }
        }
        if (this.mSliderBackgroundColor != 0) {
            this.mSliderLayout.setBackgroundColor(this.mSliderBackgroundColor);
        } else if (this.mSliderBackgroundColorRes != -1) {
            this.mSliderLayout.setBackgroundColor(ContextCompat.getColor(this.mActivity, this.mSliderBackgroundColorRes));
        } else if (this.mSliderBackgroundDrawable != null) {
            UIUtils.setBackground((View) this.mSliderLayout, this.mSliderBackgroundDrawable);
        } else if (this.mSliderBackgroundDrawableRes != -1) {
            UIUtils.setBackground((View) this.mSliderLayout, this.mSliderBackgroundDrawableRes);
        }
        DrawerUtils.handleHeaderView(this);
        DrawerUtils.handleFooterView(this, new View.OnClickListener() {
            public void onClick(View view) {
                DrawerUtils.onFooterDrawerItemClick(DrawerBuilder.this, (IDrawerItem) view.getTag(), view, true);
            }
        });
        this.mAdapter.withMultiSelect(this.mMultiSelect);
        if (this.mMultiSelect) {
            this.mAdapter.withSelectOnLongClick(false);
            this.mAdapter.withAllowDeselection(true);
        }
        if (this.mAdapterWrapper == null) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        } else {
            this.mRecyclerView.setAdapter(this.mAdapterWrapper);
        }
        if (this.mSelectedItemPosition == 0 && this.mSelectedItemIdentifier != 0) {
            this.mSelectedItemPosition = DrawerUtils.getPositionByIdentifier(this, this.mSelectedItemIdentifier);
        }
        if (this.mHeaderView != null && this.mSelectedItemPosition == 0) {
            this.mSelectedItemPosition = 1;
        }
        this.mAdapter.deselect();
        this.mAdapter.select(this.mSelectedItemPosition);
        this.mAdapter.withOnClickListener(new OnClickListener<IDrawerItem>() {
            public boolean onClick(final View view, IAdapter<IDrawerItem> iAdapter, final IDrawerItem iDrawerItem, final int i) {
                if (iDrawerItem == null || !(iDrawerItem instanceof Selectable) || iDrawerItem.isSelectable()) {
                    DrawerBuilder.this.resetStickyFooterSelection();
                    DrawerBuilder.this.mCurrentStickyFooterSelection = -1;
                }
                boolean z = false;
                if (iDrawerItem instanceof AbstractDrawerItem) {
                    AbstractDrawerItem abstractDrawerItem = (AbstractDrawerItem) iDrawerItem;
                    if (abstractDrawerItem.getOnDrawerItemClickListener() != null) {
                        z = abstractDrawerItem.getOnDrawerItemClickListener().onItemClick(view, i, iDrawerItem);
                    }
                }
                if (DrawerBuilder.this.mOnDrawerItemClickListener != null) {
                    if (DrawerBuilder.this.mDelayDrawerClickEvent > 0) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                DrawerBuilder.this.mOnDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
                            }
                        }, (long) DrawerBuilder.this.mDelayDrawerClickEvent);
                    } else {
                        z = DrawerBuilder.this.mOnDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
                    }
                }
                if (!z && DrawerBuilder.this.mMiniDrawer != null) {
                    z = DrawerBuilder.this.mMiniDrawer.onItemClick(iDrawerItem);
                }
                if ((iDrawerItem instanceof IExpandable) && iDrawerItem.getSubItems() != null) {
                    return true;
                }
                if (!z) {
                    DrawerBuilder.this.closeDrawerDelayed();
                }
                return z;
            }
        });
        this.mAdapter.withOnLongClickListener(new OnLongClickListener<IDrawerItem>() {
            public boolean onLongClick(View view, IAdapter<IDrawerItem> iAdapter, IDrawerItem iDrawerItem, int i) {
                if (DrawerBuilder.this.mOnDrawerItemLongClickListener != null) {
                    return DrawerBuilder.this.mOnDrawerItemLongClickListener.onItemLongClick(view, i, DrawerBuilder.this.getDrawerItem(i));
                }
                return false;
            }
        });
        if (this.mRecyclerView != null) {
            this.mRecyclerView.scrollToPosition(0);
        }
        if (this.mSavedInstance != null) {
            if (!this.mAppended) {
                this.mAdapter.deselect();
                this.mAdapter.withSavedInstanceState(this.mSavedInstance, "_selection");
                DrawerUtils.setStickyFooterSelection(this, this.mSavedInstance.getInt("bundle_sticky_footer_selection", -1), (Boolean) null);
            } else {
                this.mAdapter.deselect();
                this.mAdapter.withSavedInstanceState(this.mSavedInstance, "_selection_appended");
                DrawerUtils.setStickyFooterSelection(this, this.mSavedInstance.getInt("bundle_sticky_footer_selection_appended", -1), (Boolean) null);
            }
        }
        if (this.mFireInitialOnClick && this.mOnDrawerItemClickListener != null) {
            if (this.mAdapter.getSelections().size() != 0) {
                i = this.mAdapter.getSelections().iterator().next().intValue();
            }
            this.mOnDrawerItemClickListener.onItemClick((View) null, i, getDrawerItem(i));
        }
    }

    /* access modifiers changed from: protected */
    public void closeDrawerDelayed() {
        if (this.mCloseOnClick && this.mDrawerLayout != null) {
            if (this.mDelayOnDrawerClose > -1) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        DrawerBuilder.this.mDrawerLayout.closeDrawers();
                        if (DrawerBuilder.this.mScrollToTopAfterClick) {
                            DrawerBuilder.this.mRecyclerView.smoothScrollToPosition(0);
                        }
                    }
                }, (long) this.mDelayOnDrawerClose);
            } else {
                this.mDrawerLayout.closeDrawers();
            }
        }
    }

    /* access modifiers changed from: protected */
    public IDrawerItem getDrawerItem(int i) {
        return getAdapter().getItem(i);
    }

    /* access modifiers changed from: protected */
    public boolean checkDrawerItem(int i, boolean z) {
        return getAdapter().getItem(i) != null;
    }

    /* access modifiers changed from: protected */
    public void resetStickyFooterSelection() {
        if (this.mStickyFooterView instanceof LinearLayout) {
            for (int i = 0; i < this.mStickyFooterView.getChildCount(); i++) {
                this.mStickyFooterView.getChildAt(i).setActivated(false);
                this.mStickyFooterView.getChildAt(i).setSelected(false);
            }
        }
    }
}
