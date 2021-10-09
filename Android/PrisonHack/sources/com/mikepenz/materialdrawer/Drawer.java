package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.util.Pair;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import com.mikepenz.fastadapter.expandable.ExpandableExtension;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Iconable;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialize.Materialize;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class Drawer {
    protected static final String BUNDLE_DRAWER_CONTENT_SWITCHED = "bundle_drawer_content_switched";
    protected static final String BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED = "bundle_drawer_content_switched_appended";
    protected static final String BUNDLE_SELECTION = "_selection";
    protected static final String BUNDLE_SELECTION_APPENDED = "_selection_appended";
    protected static final String BUNDLE_STICKY_FOOTER_SELECTION = "bundle_sticky_footer_selection";
    protected static final String BUNDLE_STICKY_FOOTER_SELECTION_APPENDED = "bundle_sticky_footer_selection_appended";
    protected static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    protected static final String PREF_USER_OPENED_DRAWER_BY_DRAGGING = "navigation_drawer_dragged_open";
    private FrameLayout mContentView;
    protected final DrawerBuilder mDrawerBuilder;
    private List<IDrawerItem> originalDrawerItems;
    private Bundle originalDrawerState;
    private OnDrawerItemClickListener originalOnDrawerItemClickListener;
    private OnDrawerItemLongClickListener originalOnDrawerItemLongClickListener;

    public interface OnDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem iDrawerItem);
    }

    public interface OnDrawerItemLongClickListener {
        boolean onItemLongClick(View view, int i, IDrawerItem iDrawerItem);
    }

    public interface OnDrawerItemSelectedListener {
        void onItemSelected(AdapterView<?> adapterView, View view, int i, long j, IDrawerItem iDrawerItem);

        void onNothingSelected(AdapterView<?> adapterView);
    }

    public interface OnDrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);
    }

    public interface OnDrawerNavigationListener {
        boolean onNavigationClickListener(View view);
    }

    protected Drawer(DrawerBuilder drawerBuilder) {
        this.mDrawerBuilder = drawerBuilder;
    }

    /* access modifiers changed from: protected */
    public DrawerBuilder getDrawerBuilder() {
        return this.mDrawerBuilder;
    }

    public DrawerLayout getDrawerLayout() {
        return this.mDrawerBuilder.mDrawerLayout;
    }

    public void setToolbar(@NonNull Activity activity, @NonNull Toolbar toolbar) {
        setToolbar(activity, toolbar, false);
    }

    public void setToolbar(@NonNull Activity activity, @NonNull Toolbar toolbar, boolean z) {
        this.mDrawerBuilder.mToolbar = toolbar;
        this.mDrawerBuilder.handleDrawerNavigation(activity, z);
    }

    public void setActionBarDrawerToggle(@NonNull ActionBarDrawerToggle actionBarDrawerToggle) {
        this.mDrawerBuilder.mActionBarDrawerToggleEnabled = true;
        this.mDrawerBuilder.mActionBarDrawerToggle = actionBarDrawerToggle;
        this.mDrawerBuilder.handleDrawerNavigation((Activity) null, false);
    }

    public void openDrawer() {
        if (this.mDrawerBuilder.mDrawerLayout != null && this.mDrawerBuilder.mSliderLayout != null) {
            this.mDrawerBuilder.mDrawerLayout.openDrawer(this.mDrawerBuilder.mDrawerGravity.intValue());
        }
    }

    public void closeDrawer() {
        if (this.mDrawerBuilder.mDrawerLayout != null) {
            this.mDrawerBuilder.mDrawerLayout.closeDrawer(this.mDrawerBuilder.mDrawerGravity.intValue());
        }
    }

    public boolean isDrawerOpen() {
        if (this.mDrawerBuilder.mDrawerLayout == null || this.mDrawerBuilder.mSliderLayout == null) {
            return false;
        }
        return this.mDrawerBuilder.mDrawerLayout.isDrawerOpen(this.mDrawerBuilder.mDrawerGravity.intValue());
    }

    public void setFullscreen(boolean z) {
        if (this.mDrawerBuilder.mMaterialize != null) {
            this.mDrawerBuilder.mMaterialize.setFullscreen(z);
        }
    }

    public Materialize getMaterialize() {
        return this.mDrawerBuilder.mMaterialize;
    }

    public MiniDrawer getMiniDrawer() {
        if (this.mDrawerBuilder.mMiniDrawer == null) {
            this.mDrawerBuilder.mMiniDrawer = new MiniDrawer().withDrawer(this).withAccountHeader(this.mDrawerBuilder.mAccountHeader);
        }
        return this.mDrawerBuilder.mMiniDrawer;
    }

    public ScrimInsetsRelativeLayout getSlider() {
        return this.mDrawerBuilder.mSliderLayout;
    }

    public FrameLayout getContent() {
        if (this.mContentView == null && this.mDrawerBuilder.mDrawerLayout != null) {
            this.mContentView = (FrameLayout) this.mDrawerBuilder.mDrawerLayout.findViewById(C0658R.C0661id.content_layout);
        }
        return this.mContentView;
    }

    public RecyclerView getRecyclerView() {
        return this.mDrawerBuilder.mRecyclerView;
    }

    public FastAdapter<IDrawerItem> getAdapter() {
        return this.mDrawerBuilder.mAdapter;
    }

    public ModelAdapter<IDrawerItem, IDrawerItem> getHeaderAdapter() {
        return this.mDrawerBuilder.mHeaderAdapter;
    }

    public ModelAdapter<IDrawerItem, IDrawerItem> getItemAdapter() {
        return this.mDrawerBuilder.mItemAdapter;
    }

    public ModelAdapter<IDrawerItem, IDrawerItem> getFooterAdapter() {
        return this.mDrawerBuilder.mFooterAdapter;
    }

    public ExpandableExtension<IDrawerItem> getExpandableExtension() {
        return this.mDrawerBuilder.mExpandableExtension;
    }

    public List<IDrawerItem> getDrawerItems() {
        return this.mDrawerBuilder.getItemAdapter().getAdapterItems();
    }

    public View getHeader() {
        return this.mDrawerBuilder.mHeaderView;
    }

    public View getStickyHeader() {
        return this.mDrawerBuilder.mStickyHeaderView;
    }

    public void setHeader(@NonNull View view) {
        setHeader(view, true, true);
    }

    public void setHeader(@NonNull View view, boolean z) {
        setHeader(view, true, z);
    }

    public void setHeader(@NonNull View view, boolean z, boolean z2) {
        setHeader(view, z, z2, (DimenHolder) null);
    }

    public void setHeader(@NonNull View view, boolean z, boolean z2, DimenHolder dimenHolder) {
        this.mDrawerBuilder.getHeaderAdapter().clear();
        if (z) {
            this.mDrawerBuilder.getHeaderAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(view).withDivider(z2).withHeight(dimenHolder).withViewPosition(ContainerDrawerItem.Position.TOP)});
        } else {
            this.mDrawerBuilder.getHeaderAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(view).withDivider(z2).withHeight(dimenHolder).withViewPosition(ContainerDrawerItem.Position.NONE)});
        }
        this.mDrawerBuilder.mRecyclerView.setPadding(this.mDrawerBuilder.mRecyclerView.getPaddingLeft(), 0, this.mDrawerBuilder.mRecyclerView.getPaddingRight(), this.mDrawerBuilder.mRecyclerView.getPaddingBottom());
    }

    public void removeHeader() {
        this.mDrawerBuilder.getHeaderAdapter().clear();
    }

    public View getFooter() {
        return this.mDrawerBuilder.mFooterView;
    }

    public View getStickyFooter() {
        return this.mDrawerBuilder.mStickyFooterView;
    }

    private View getStickyFooterShadow() {
        return this.mDrawerBuilder.mStickyFooterShadowView;
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle() {
        return this.mDrawerBuilder.mActionBarDrawerToggle;
    }

    public void setGravity(int i) {
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) getSlider().getLayoutParams();
        layoutParams.gravity = i;
        getSlider().setLayoutParams(layoutParams);
        this.mDrawerBuilder.mDrawerGravity = Integer.valueOf(i);
    }

    public int getPosition(@NonNull IDrawerItem iDrawerItem) {
        return getPosition(iDrawerItem.getIdentifier());
    }

    public int getPosition(long j) {
        return DrawerUtils.getPositionByIdentifier(this.mDrawerBuilder, j);
    }

    public IDrawerItem getDrawerItem(long j) {
        Pair<IDrawerItem, Integer> itemById = getAdapter().getItemById(j);
        if (itemById != null) {
            return (IDrawerItem) itemById.first;
        }
        return null;
    }

    public IDrawerItem getDrawerItem(Object obj) {
        return DrawerUtils.getDrawerItem(getDrawerItems(), obj);
    }

    public int getStickyFooterPosition(@NonNull IDrawerItem iDrawerItem) {
        return getStickyFooterPosition(iDrawerItem.getIdentifier());
    }

    public int getStickyFooterPosition(long j) {
        return DrawerUtils.getStickyFooterPositionByIdentifier(this.mDrawerBuilder, j);
    }

    public int getCurrentSelectedPosition() {
        if (this.mDrawerBuilder.mAdapter.getSelections().size() == 0) {
            return -1;
        }
        return this.mDrawerBuilder.mAdapter.getSelections().iterator().next().intValue();
    }

    public long getCurrentSelection() {
        IDrawerItem drawerItem = this.mDrawerBuilder.getDrawerItem(getCurrentSelectedPosition());
        if (drawerItem != null) {
            return drawerItem.getIdentifier();
        }
        return -1;
    }

    public int getCurrentStickyFooterSelectedPosition() {
        return this.mDrawerBuilder.mCurrentStickyFooterSelection;
    }

    public void deselect() {
        getAdapter().deselect();
    }

    public void deselect(long j) {
        getAdapter().deselect(getPosition(j));
    }

    public void setSelection(long j) {
        setSelection(j, true);
    }

    public void setSelection(long j, boolean z) {
        SelectExtension selectExtension = (SelectExtension) getAdapter().getExtension(SelectExtension.class);
        if (selectExtension != null) {
            selectExtension.deselect();
            selectExtension.selectByIdentifier(j, false, true);
            Pair<IDrawerItem, Integer> itemById = getAdapter().getItemById(j);
            if (itemById != null) {
                Integer num = (Integer) itemById.second;
                notifySelect(num != null ? num.intValue() : -1, z);
            }
        }
    }

    public void setStickyFooterSelection(long j, boolean z) {
        setStickyFooterSelectionAtPosition(getStickyFooterPosition(j), z);
    }

    public void setSelection(@NonNull IDrawerItem iDrawerItem) {
        setSelection(iDrawerItem.getIdentifier(), true);
    }

    public void setSelection(@NonNull IDrawerItem iDrawerItem, boolean z) {
        setSelection(iDrawerItem.getIdentifier(), z);
    }

    public boolean setSelectionAtPosition(int i) {
        return setSelectionAtPosition(i, true);
    }

    public boolean setSelectionAtPosition(int i, boolean z) {
        SelectExtension selectExtension;
        if (!(this.mDrawerBuilder.mRecyclerView == null || (selectExtension = (SelectExtension) getAdapter().getExtension(SelectExtension.class)) == null)) {
            selectExtension.deselect();
            selectExtension.select(i, false);
            notifySelect(i, z);
        }
        return false;
    }

    private void notifySelect(int i, boolean z) {
        if (z && i >= 0) {
            IDrawerItem item = this.mDrawerBuilder.mAdapter.getItem(i);
            if (item instanceof AbstractDrawerItem) {
                AbstractDrawerItem abstractDrawerItem = (AbstractDrawerItem) item;
                if (abstractDrawerItem.getOnDrawerItemClickListener() != null) {
                    abstractDrawerItem.getOnDrawerItemClickListener().onItemClick((View) null, i, item);
                }
            }
            if (this.mDrawerBuilder.mOnDrawerItemClickListener != null) {
                this.mDrawerBuilder.mOnDrawerItemClickListener.onItemClick((View) null, i, item);
            }
        }
        this.mDrawerBuilder.resetStickyFooterSelection();
    }

    public void setStickyFooterSelectionAtPosition(int i) {
        setStickyFooterSelectionAtPosition(i, true);
    }

    public void setStickyFooterSelectionAtPosition(int i, boolean z) {
        DrawerUtils.setStickyFooterSelection(this.mDrawerBuilder, i, Boolean.valueOf(z));
    }

    public void updateItem(@NonNull IDrawerItem iDrawerItem) {
        updateItemAtPosition(iDrawerItem, getPosition(iDrawerItem));
    }

    public void updateBadge(long j, StringHolder stringHolder) {
        IDrawerItem drawerItem = getDrawerItem(j);
        if (drawerItem instanceof Badgeable) {
            Badgeable badgeable = (Badgeable) drawerItem;
            badgeable.withBadge(stringHolder);
            updateItem((IDrawerItem) badgeable);
        }
    }

    public void updateName(long j, StringHolder stringHolder) {
        IDrawerItem drawerItem = getDrawerItem(j);
        if (drawerItem instanceof Nameable) {
            Nameable nameable = (Nameable) drawerItem;
            nameable.withName(stringHolder);
            updateItem((IDrawerItem) nameable);
        }
    }

    public void updateIcon(long j, ImageHolder imageHolder) {
        IDrawerItem drawerItem = getDrawerItem(j);
        if (drawerItem instanceof Iconable) {
            Iconable iconable = (Iconable) drawerItem;
            iconable.withIcon(imageHolder);
            updateItem((IDrawerItem) iconable);
        }
    }

    public void updateItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        if (this.mDrawerBuilder.checkDrawerItem(i, false)) {
            this.mDrawerBuilder.getItemAdapter().set(i, iDrawerItem);
        }
    }

    public void addItem(@NonNull IDrawerItem iDrawerItem) {
        this.mDrawerBuilder.getItemAdapter().add((Model[]) new IDrawerItem[]{iDrawerItem});
    }

    public void addItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        this.mDrawerBuilder.getItemAdapter().add(i, (Model[]) new IDrawerItem[]{iDrawerItem});
    }

    public void setItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        this.mDrawerBuilder.getItemAdapter().add(i, (Model[]) new IDrawerItem[]{iDrawerItem});
    }

    public void removeItemByPosition(int i) {
        if (this.mDrawerBuilder.checkDrawerItem(i, false)) {
            this.mDrawerBuilder.getItemAdapter().remove(i);
        }
    }

    public void removeItem(long j) {
        getItemAdapter().removeByIdentifier(j);
    }

    public void removeItems(long... jArr) {
        if (jArr != null) {
            for (long removeItem : jArr) {
                removeItem(removeItem);
            }
        }
    }

    public void removeAllItems() {
        this.mDrawerBuilder.getItemAdapter().clear();
    }

    public void addItems(@NonNull IDrawerItem... iDrawerItemArr) {
        this.mDrawerBuilder.getItemAdapter().add((Model[]) iDrawerItemArr);
    }

    public void addItemsAtPosition(int i, @NonNull IDrawerItem... iDrawerItemArr) {
        this.mDrawerBuilder.getItemAdapter().add(i, (Model[]) iDrawerItemArr);
    }

    public void setItems(@NonNull List<IDrawerItem> list) {
        setItems(list, false);
    }

    private void setItems(@NonNull List<IDrawerItem> list, boolean z) {
        if (this.originalDrawerItems != null && !z) {
            this.originalDrawerItems = list;
        }
        this.mDrawerBuilder.getItemAdapter().setNewList(list);
    }

    public void updateStickyFooterItem(@NonNull IDrawerItem iDrawerItem) {
        updateStickyFooterItemAtPosition(iDrawerItem, getStickyFooterPosition(iDrawerItem));
    }

    public void updateStickyFooterItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        if (this.mDrawerBuilder.mStickyDrawerItems != null && this.mDrawerBuilder.mStickyDrawerItems.size() > i) {
            this.mDrawerBuilder.mStickyDrawerItems.set(i, iDrawerItem);
        }
        DrawerUtils.rebuildStickyFooterView(this.mDrawerBuilder);
    }

    public void addStickyFooterItem(@NonNull IDrawerItem iDrawerItem) {
        if (this.mDrawerBuilder.mStickyDrawerItems == null) {
            this.mDrawerBuilder.mStickyDrawerItems = new ArrayList();
        }
        this.mDrawerBuilder.mStickyDrawerItems.add(iDrawerItem);
        DrawerUtils.rebuildStickyFooterView(this.mDrawerBuilder);
    }

    public void addStickyFooterItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        if (this.mDrawerBuilder.mStickyDrawerItems == null) {
            this.mDrawerBuilder.mStickyDrawerItems = new ArrayList();
        }
        this.mDrawerBuilder.mStickyDrawerItems.add(i, iDrawerItem);
        DrawerUtils.rebuildStickyFooterView(this.mDrawerBuilder);
    }

    public void setStickyFooterItemAtPosition(@NonNull IDrawerItem iDrawerItem, int i) {
        if (this.mDrawerBuilder.mStickyDrawerItems != null && this.mDrawerBuilder.mStickyDrawerItems.size() > i) {
            this.mDrawerBuilder.mStickyDrawerItems.set(i, iDrawerItem);
        }
        DrawerUtils.rebuildStickyFooterView(this.mDrawerBuilder);
    }

    public void removeStickyFooterItemAtPosition(int i) {
        if (this.mDrawerBuilder.mStickyDrawerItems != null && this.mDrawerBuilder.mStickyDrawerItems.size() > i) {
            this.mDrawerBuilder.mStickyDrawerItems.remove(i);
        }
        DrawerUtils.rebuildStickyFooterView(this.mDrawerBuilder);
    }

    public void removeAllStickyFooterItems() {
        if (this.mDrawerBuilder.mStickyDrawerItems != null) {
            this.mDrawerBuilder.mStickyDrawerItems.clear();
        }
        if (this.mDrawerBuilder.mStickyFooterView != null) {
            this.mDrawerBuilder.mStickyFooterView.setVisibility(8);
        }
    }

    public void setOnDrawerItemClickListener(OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mDrawerBuilder.mOnDrawerItemClickListener = onDrawerItemClickListener;
    }

    public void setOnDrawerNavigationListener(OnDrawerNavigationListener onDrawerNavigationListener) {
        this.mDrawerBuilder.mOnDrawerNavigationListener = onDrawerNavigationListener;
    }

    public OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.mDrawerBuilder.mOnDrawerItemClickListener;
    }

    public OnDrawerNavigationListener getOnDrawerNavigationListener() {
        return this.mDrawerBuilder.mOnDrawerNavigationListener;
    }

    public void setOnDrawerItemLongClickListener(OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        this.mDrawerBuilder.mOnDrawerItemLongClickListener = onDrawerItemLongClickListener;
    }

    public OnDrawerItemLongClickListener getOnDrawerItemLongClickListener() {
        return this.mDrawerBuilder.mOnDrawerItemLongClickListener;
    }

    public boolean switchedDrawerContent() {
        return (this.originalOnDrawerItemClickListener == null && this.originalDrawerItems == null && this.originalDrawerState == null) ? false : true;
    }

    public List<IDrawerItem> getOriginalDrawerItems() {
        return this.originalDrawerItems;
    }

    public void switchDrawerContent(@NonNull OnDrawerItemClickListener onDrawerItemClickListener, OnDrawerItemLongClickListener onDrawerItemLongClickListener, @NonNull List<IDrawerItem> list, int i) {
        if (!switchedDrawerContent()) {
            this.originalOnDrawerItemClickListener = getOnDrawerItemClickListener();
            this.originalOnDrawerItemLongClickListener = getOnDrawerItemLongClickListener();
            this.originalDrawerState = getAdapter().saveInstanceState(new Bundle());
            this.mDrawerBuilder.mExpandableExtension.collapse(false);
            this.originalDrawerItems = getDrawerItems();
        }
        setOnDrawerItemClickListener(onDrawerItemClickListener);
        setOnDrawerItemLongClickListener(onDrawerItemLongClickListener);
        setItems(list, true);
        setSelectionAtPosition(i, false);
        if (!this.mDrawerBuilder.mKeepStickyItemsVisible) {
            if (getStickyFooter() != null) {
                getStickyFooter().setVisibility(8);
            }
            if (getStickyFooterShadow() != null) {
                getStickyFooterShadow().setVisibility(8);
            }
        }
    }

    public void resetDrawerContent() {
        if (switchedDrawerContent()) {
            setOnDrawerItemClickListener(this.originalOnDrawerItemClickListener);
            setOnDrawerItemLongClickListener(this.originalOnDrawerItemLongClickListener);
            setItems(this.originalDrawerItems, true);
            getAdapter().withSavedInstanceState(this.originalDrawerState);
            this.originalOnDrawerItemClickListener = null;
            this.originalOnDrawerItemLongClickListener = null;
            this.originalDrawerItems = null;
            this.originalDrawerState = null;
            this.mDrawerBuilder.mRecyclerView.smoothScrollToPosition(0);
            if (getStickyFooter() != null) {
                getStickyFooter().setVisibility(0);
            }
            if (getStickyFooterShadow() != null) {
                getStickyFooterShadow().setVisibility(0);
            }
            if (this.mDrawerBuilder.mAccountHeader != null && this.mDrawerBuilder.mAccountHeader.mAccountHeaderBuilder != null) {
                this.mDrawerBuilder.mAccountHeader.mAccountHeaderBuilder.mSelectionListShown = false;
            }
        }
    }

    public Bundle saveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return bundle;
        }
        if (!this.mDrawerBuilder.mAppended) {
            Bundle saveInstanceState = this.mDrawerBuilder.mAdapter.saveInstanceState(bundle, BUNDLE_SELECTION);
            saveInstanceState.putInt(BUNDLE_STICKY_FOOTER_SELECTION, this.mDrawerBuilder.mCurrentStickyFooterSelection);
            saveInstanceState.putBoolean(BUNDLE_DRAWER_CONTENT_SWITCHED, switchedDrawerContent());
            return saveInstanceState;
        }
        Bundle saveInstanceState2 = this.mDrawerBuilder.mAdapter.saveInstanceState(bundle, BUNDLE_SELECTION_APPENDED);
        saveInstanceState2.putInt(BUNDLE_STICKY_FOOTER_SELECTION_APPENDED, this.mDrawerBuilder.mCurrentStickyFooterSelection);
        saveInstanceState2.putBoolean(BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED, switchedDrawerContent());
        return saveInstanceState2;
    }
}
