package com.mikepenz.materialdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.p003v7.widget.DefaultItemAnimator;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.MiniDrawerItem;
import com.mikepenz.materialdrawer.model.MiniProfileDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class MiniDrawer {
    public static final int ITEM = 2;
    public static final int PROFILE = 1;
    /* access modifiers changed from: private */
    public AccountHeader mAccountHeader;
    protected FastAdapter<IDrawerItem> mAdapter;
    private LinearLayout mContainer;
    /* access modifiers changed from: private */
    public ICrossfader mCrossFader;
    /* access modifiers changed from: private */
    public Drawer mDrawer;
    private boolean mEnableProfileClick = true;
    private boolean mEnableSelectedMiniDrawerItemBackground = false;
    private boolean mInRTL = false;
    private boolean mIncludeSecondaryDrawerItems = false;
    private boolean mInnerShadow = false;
    protected ItemAdapter<IDrawerItem> mItemAdapter;
    /* access modifiers changed from: private */
    public OnMiniDrawerItemClickListener mOnMiniDrawerItemClickListener;
    private OnLongClickListener<IDrawerItem> mOnMiniDrawerItemLongClickListener;
    private OnClickListener<IDrawerItem> mOnMiniDrawerItemOnClickListener;
    private RecyclerView mRecyclerView;

    public interface OnMiniDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem iDrawerItem, int i2);
    }

    public MiniDrawer withDrawer(@NonNull Drawer drawer) {
        this.mDrawer = drawer;
        return this;
    }

    public MiniDrawer withAccountHeader(@NonNull AccountHeader accountHeader) {
        this.mAccountHeader = accountHeader;
        return this;
    }

    public MiniDrawer withCrossFader(@NonNull ICrossfader iCrossfader) {
        this.mCrossFader = iCrossfader;
        return this;
    }

    public MiniDrawer withInnerShadow(boolean z) {
        this.mInnerShadow = z;
        return this;
    }

    public MiniDrawer withInRTL(boolean z) {
        this.mInRTL = z;
        return this;
    }

    public MiniDrawer withIncludeSecondaryDrawerItems(boolean z) {
        this.mIncludeSecondaryDrawerItems = z;
        return this;
    }

    public MiniDrawer withEnableSelectedMiniDrawerItemBackground(boolean z) {
        this.mEnableSelectedMiniDrawerItemBackground = z;
        return this;
    }

    public MiniDrawer withEnableProfileClick(boolean z) {
        this.mEnableProfileClick = z;
        return this;
    }

    public MiniDrawer withOnMiniDrawerItemClickListener(OnMiniDrawerItemClickListener onMiniDrawerItemClickListener) {
        this.mOnMiniDrawerItemClickListener = onMiniDrawerItemClickListener;
        return this;
    }

    public MiniDrawer withOnMiniDrawerItemOnClickListener(OnClickListener<IDrawerItem> onClickListener) {
        this.mOnMiniDrawerItemOnClickListener = onClickListener;
        return this;
    }

    public MiniDrawer withOnMiniDrawerItemLongClickListener(OnLongClickListener<IDrawerItem> onLongClickListener) {
        this.mOnMiniDrawerItemLongClickListener = onLongClickListener;
        return this;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public FastAdapter<IDrawerItem> getAdapter() {
        return this.mAdapter;
    }

    public ItemAdapter<IDrawerItem> getItemAdapter() {
        return this.mItemAdapter;
    }

    public Drawer getDrawer() {
        return this.mDrawer;
    }

    public AccountHeader getAccountHeader() {
        return this.mAccountHeader;
    }

    public ICrossfader getCrossFader() {
        return this.mCrossFader;
    }

    public OnClickListener getOnMiniDrawerItemOnClickListener() {
        return this.mOnMiniDrawerItemOnClickListener;
    }

    public OnLongClickListener getOnMiniDrawerItemLongClickListener() {
        return this.mOnMiniDrawerItemLongClickListener;
    }

    public IDrawerItem generateMiniDrawerItem(IDrawerItem iDrawerItem) {
        if (iDrawerItem instanceof SecondaryDrawerItem) {
            if (this.mIncludeSecondaryDrawerItems) {
                return (MiniDrawerItem) new MiniDrawerItem((SecondaryDrawerItem) iDrawerItem).withEnableSelectedBackground(this.mEnableSelectedMiniDrawerItemBackground).withSelectedBackgroundAnimated(false);
            }
            return null;
        } else if (iDrawerItem instanceof PrimaryDrawerItem) {
            return (IDrawerItem) new MiniDrawerItem((PrimaryDrawerItem) iDrawerItem).withEnableSelectedBackground(this.mEnableSelectedMiniDrawerItemBackground).withSelectedBackgroundAnimated(false);
        } else {
            if (!(iDrawerItem instanceof ProfileDrawerItem)) {
                return null;
            }
            MiniProfileDrawerItem miniProfileDrawerItem = new MiniProfileDrawerItem((ProfileDrawerItem) iDrawerItem);
            miniProfileDrawerItem.withEnabled(this.mEnableProfileClick);
            return miniProfileDrawerItem;
        }
    }

    public int getMiniDrawerType(IDrawerItem iDrawerItem) {
        if (iDrawerItem instanceof MiniProfileDrawerItem) {
            return 1;
        }
        return iDrawerItem instanceof MiniDrawerItem ? 2 : -1;
    }

    public View build(Context context) {
        this.mContainer = new LinearLayout(context);
        if (this.mInnerShadow) {
            if (!this.mInRTL) {
                this.mContainer.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_left);
            } else {
                this.mContainer.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_right);
            }
        }
        this.mRecyclerView = new RecyclerView(context);
        this.mContainer.addView(this.mRecyclerView, -1, -1);
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.setFadingEdgeLength(0);
        this.mRecyclerView.setClipToPadding(false);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.mItemAdapter = new ItemAdapter<>();
        this.mAdapter = FastAdapter.with(this.mItemAdapter);
        this.mAdapter.withSelectable(true);
        this.mAdapter.withAllowDeselection(false);
        this.mRecyclerView.setAdapter(this.mAdapter);
        if (!(this.mDrawer == null || this.mDrawer.mDrawerBuilder == null || (!this.mDrawer.mDrawerBuilder.mFullscreen && !this.mDrawer.mDrawerBuilder.mTranslucentStatusBar))) {
            this.mRecyclerView.setPadding(this.mRecyclerView.getPaddingLeft(), UIUtils.getStatusBarHeight(context), this.mRecyclerView.getPaddingRight(), this.mRecyclerView.getPaddingBottom());
        }
        if (!(this.mDrawer == null || this.mDrawer.mDrawerBuilder == null || ((!this.mDrawer.mDrawerBuilder.mFullscreen && !this.mDrawer.mDrawerBuilder.mTranslucentNavigationBar) || context.getResources().getConfiguration().orientation != 1))) {
            this.mRecyclerView.setPadding(this.mRecyclerView.getPaddingLeft(), this.mRecyclerView.getPaddingTop(), this.mRecyclerView.getPaddingRight(), UIUtils.getNavigationBarHeight(context));
        }
        createItems();
        return this.mContainer;
    }

    public void onProfileClick() {
        if (this.mCrossFader != null && this.mCrossFader.isCrossfaded()) {
            this.mCrossFader.crossfade();
        }
        if (this.mAccountHeader != null) {
            IProfile activeProfile = this.mAccountHeader.getActiveProfile();
            if (activeProfile instanceof IDrawerItem) {
                this.mItemAdapter.set(0, (Object) generateMiniDrawerItem((IDrawerItem) activeProfile));
            }
        }
    }

    public boolean onItemClick(IDrawerItem iDrawerItem) {
        if (!iDrawerItem.isSelectable()) {
            return true;
        }
        if (this.mCrossFader != null && this.mCrossFader.isCrossfaded()) {
            this.mCrossFader.crossfade();
        }
        setSelection(iDrawerItem.getIdentifier());
        return false;
    }

    public void setSelection(long j) {
        if (j == -1) {
            this.mAdapter.deselect();
        }
        int itemCount = this.mAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            IDrawerItem item = this.mAdapter.getItem(i);
            if (item.getIdentifier() == j && !item.isSelected()) {
                this.mAdapter.deselect();
                this.mAdapter.select(i);
            }
        }
    }

    public void updateItem(long j) {
        IDrawerItem generateMiniDrawerItem;
        if (this.mDrawer != null && this.mAdapter != null && this.mItemAdapter.getAdapterItems() != null && j != -1) {
            IDrawerItem drawerItem = DrawerUtils.getDrawerItem(getDrawerItems(), j);
            for (int i = 0; i < this.mItemAdapter.getAdapterItems().size(); i++) {
                if (this.mItemAdapter.getAdapterItems().get(i).getIdentifier() == drawerItem.getIdentifier() && (generateMiniDrawerItem = generateMiniDrawerItem(drawerItem)) != null) {
                    this.mItemAdapter.set(i, (Object) generateMiniDrawerItem);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createItems() {
        /*
            r10 = this;
            com.mikepenz.fastadapter.adapters.ItemAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r0 = r10.mItemAdapter
            r0.clear()
            com.mikepenz.materialdrawer.AccountHeader r0 = r10.mAccountHeader
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0030
            com.mikepenz.materialdrawer.AccountHeader r0 = r10.mAccountHeader
            com.mikepenz.materialdrawer.AccountHeaderBuilder r0 = r0.getAccountHeaderBuilder()
            boolean r0 = r0.mProfileImagesVisible
            if (r0 == 0) goto L_0x0030
            com.mikepenz.materialdrawer.AccountHeader r0 = r10.mAccountHeader
            com.mikepenz.materialdrawer.model.interfaces.IProfile r0 = r0.getActiveProfile()
            boolean r3 = r0 instanceof com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
            if (r3 == 0) goto L_0x0030
            com.mikepenz.fastadapter.adapters.ItemAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r3 = r10.mItemAdapter
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem[] r4 = new com.mikepenz.materialdrawer.model.interfaces.IDrawerItem[r1]
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r0 = (com.mikepenz.materialdrawer.model.interfaces.IDrawerItem) r0
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r0 = r10.generateMiniDrawerItem(r0)
            r4[r2] = r0
            r3.add((java.lang.Object[]) r4)
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            r3 = -1
            com.mikepenz.materialdrawer.Drawer r4 = r10.mDrawer
            if (r4 == 0) goto L_0x0076
            java.util.List r4 = r10.getDrawerItems()
            if (r4 == 0) goto L_0x0076
            java.util.List r4 = r10.getDrawerItems()
            int r4 = r4.size()
            r3 = 0
            r5 = -1
            r6 = 0
        L_0x0047:
            if (r3 >= r4) goto L_0x006e
            java.util.List r7 = r10.getDrawerItems()
            java.lang.Object r7 = r7.get(r3)
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r7 = (com.mikepenz.materialdrawer.model.interfaces.IDrawerItem) r7
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r7 = r10.generateMiniDrawerItem(r7)
            if (r7 == 0) goto L_0x006b
            boolean r8 = r7.isSelected()
            if (r8 == 0) goto L_0x0060
            r5 = r6
        L_0x0060:
            com.mikepenz.fastadapter.adapters.ItemAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r8 = r10.mItemAdapter
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem[] r9 = new com.mikepenz.materialdrawer.model.interfaces.IDrawerItem[r1]
            r9[r2] = r7
            r8.add((java.lang.Object[]) r9)
            int r6 = r6 + 1
        L_0x006b:
            int r3 = r3 + 1
            goto L_0x0047
        L_0x006e:
            if (r5 < 0) goto L_0x0076
            com.mikepenz.fastadapter.FastAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r1 = r10.mAdapter
            int r5 = r5 + r0
            r1.select((int) r5)
        L_0x0076:
            com.mikepenz.fastadapter.listeners.OnClickListener<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r0 = r10.mOnMiniDrawerItemOnClickListener
            if (r0 == 0) goto L_0x0082
            com.mikepenz.fastadapter.FastAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r0 = r10.mAdapter
            com.mikepenz.fastadapter.listeners.OnClickListener<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r1 = r10.mOnMiniDrawerItemOnClickListener
            r0.withOnClickListener(r1)
            goto L_0x008c
        L_0x0082:
            com.mikepenz.fastadapter.FastAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r0 = r10.mAdapter
            com.mikepenz.materialdrawer.MiniDrawer$1 r1 = new com.mikepenz.materialdrawer.MiniDrawer$1
            r1.<init>()
            r0.withOnClickListener(r1)
        L_0x008c:
            com.mikepenz.fastadapter.FastAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r0 = r10.mAdapter
            com.mikepenz.fastadapter.listeners.OnLongClickListener<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem> r1 = r10.mOnMiniDrawerItemLongClickListener
            r0.withOnLongClickListener(r1)
            android.support.v7.widget.RecyclerView r0 = r10.mRecyclerView
            r0.scrollToPosition(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.MiniDrawer.createItems():void");
    }

    /* access modifiers changed from: private */
    public List<IDrawerItem> getDrawerItems() {
        return this.mDrawer.getOriginalDrawerItems() != null ? this.mDrawer.getOriginalDrawerItems() : this.mDrawer.getDrawerItems();
    }
}
