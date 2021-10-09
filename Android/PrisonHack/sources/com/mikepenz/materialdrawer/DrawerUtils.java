package com.mikepenz.materialdrawer;

import android.content.Context;
import android.os.Build;
import android.support.p000v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

class DrawerUtils {
    DrawerUtils() {
    }

    public static void onFooterDrawerItemClick(DrawerBuilder drawerBuilder, IDrawerItem iDrawerItem, View view, Boolean bool) {
        boolean z = false;
        if (iDrawerItem == null || !(iDrawerItem instanceof Selectable) || iDrawerItem.isSelectable()) {
            drawerBuilder.resetStickyFooterSelection();
            view.setActivated(true);
            view.setSelected(true);
            drawerBuilder.getAdapter().deselect();
            if (drawerBuilder.mStickyFooterView != null && (drawerBuilder.mStickyFooterView instanceof LinearLayout)) {
                LinearLayout linearLayout = (LinearLayout) drawerBuilder.mStickyFooterView;
                int i = 0;
                while (true) {
                    if (i >= linearLayout.getChildCount()) {
                        break;
                    } else if (linearLayout.getChildAt(i) == view) {
                        drawerBuilder.mCurrentStickyFooterSelection = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (bool != null) {
            if (bool.booleanValue()) {
                if (iDrawerItem instanceof AbstractDrawerItem) {
                    AbstractDrawerItem abstractDrawerItem = (AbstractDrawerItem) iDrawerItem;
                    if (abstractDrawerItem.getOnDrawerItemClickListener() != null) {
                        z = abstractDrawerItem.getOnDrawerItemClickListener().onItemClick(view, -1, iDrawerItem);
                    }
                }
                if (drawerBuilder.mOnDrawerItemClickListener != null) {
                    z = drawerBuilder.mOnDrawerItemClickListener.onItemClick(view, -1, iDrawerItem);
                }
            }
            if (!z) {
                drawerBuilder.closeDrawerDelayed();
            }
        }
    }

    public static void setStickyFooterSelection(DrawerBuilder drawerBuilder, int i, Boolean bool) {
        if (i > -1 && drawerBuilder.mStickyFooterView != null && (drawerBuilder.mStickyFooterView instanceof LinearLayout)) {
            LinearLayout linearLayout = (LinearLayout) drawerBuilder.mStickyFooterView;
            if (drawerBuilder.mStickyFooterDivider) {
                i++;
            }
            if (linearLayout.getChildCount() > i && i >= 0) {
                onFooterDrawerItemClick(drawerBuilder, (IDrawerItem) linearLayout.getChildAt(i).getTag(), linearLayout.getChildAt(i), bool);
            }
        }
    }

    public static int getPositionByIdentifier(DrawerBuilder drawerBuilder, long j) {
        if (j == -1) {
            return -1;
        }
        for (int i = 0; i < drawerBuilder.getAdapter().getItemCount(); i++) {
            if (drawerBuilder.getAdapter().getItem(i).getIdentifier() == j) {
                return i;
            }
        }
        return -1;
    }

    public static IDrawerItem getDrawerItem(List<IDrawerItem> list, long j) {
        if (j == -1) {
            return null;
        }
        for (IDrawerItem next : list) {
            if (next.getIdentifier() == j) {
                return next;
            }
        }
        return null;
    }

    public static IDrawerItem getDrawerItem(List<IDrawerItem> list, Object obj) {
        if (obj == null) {
            return null;
        }
        for (IDrawerItem next : list) {
            if (obj.equals(next.getTag())) {
                return next;
            }
        }
        return null;
    }

    public static int getStickyFooterPositionByIdentifier(DrawerBuilder drawerBuilder, long j) {
        if (j == -1 || drawerBuilder.mStickyFooterView == null || !(drawerBuilder.mStickyFooterView instanceof LinearLayout)) {
            return -1;
        }
        LinearLayout linearLayout = (LinearLayout) drawerBuilder.mStickyFooterView;
        int i = 0;
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            Object tag = linearLayout.getChildAt(i2).getTag();
            if (tag == null && drawerBuilder.mStickyFooterDivider) {
                i++;
            }
            if (tag != null && (tag instanceof IDrawerItem) && ((IDrawerItem) tag).getIdentifier() == j) {
                return i2 - i;
            }
        }
        return -1;
    }

    public static void handleHeaderView(DrawerBuilder drawerBuilder) {
        if (drawerBuilder.mAccountHeader != null) {
            if (drawerBuilder.mAccountHeaderSticky) {
                drawerBuilder.mStickyHeaderView = drawerBuilder.mAccountHeader.getView();
            } else {
                drawerBuilder.mHeaderView = drawerBuilder.mAccountHeader.getView();
                drawerBuilder.mHeaderDivider = drawerBuilder.mAccountHeader.mAccountHeaderBuilder.mDividerBelowHeader;
                drawerBuilder.mHeaderPadding = drawerBuilder.mAccountHeader.mAccountHeaderBuilder.mPaddingBelowHeader;
            }
        }
        if (drawerBuilder.mStickyHeaderView != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, 1);
            drawerBuilder.mStickyHeaderView.setId(C0658R.C0661id.material_drawer_sticky_header);
            drawerBuilder.mSliderLayout.addView(drawerBuilder.mStickyHeaderView, 0, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) drawerBuilder.mRecyclerView.getLayoutParams();
            layoutParams2.addRule(3, C0658R.C0661id.material_drawer_sticky_header);
            drawerBuilder.mRecyclerView.setLayoutParams(layoutParams2);
            drawerBuilder.mStickyHeaderView.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(drawerBuilder.mActivity, C0658R.attr.material_drawer_background, C0658R.C0659color.material_drawer_background));
            if (drawerBuilder.mStickyHeaderShadow) {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawerBuilder.mStickyHeaderView.setElevation(UIUtils.convertDpToPixel(4.0f, drawerBuilder.mActivity));
                } else {
                    View view = new View(drawerBuilder.mActivity);
                    view.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_bottom);
                    drawerBuilder.mSliderLayout.addView(view, -1, (int) UIUtils.convertDpToPixel(4.0f, drawerBuilder.mActivity));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams3.addRule(3, C0658R.C0661id.material_drawer_sticky_header);
                    view.setLayoutParams(layoutParams3);
                }
            }
            drawerBuilder.mRecyclerView.setPadding(0, 0, 0, 0);
        }
        if (drawerBuilder.mHeaderView == null) {
            return;
        }
        if (drawerBuilder.mRecyclerView == null) {
            throw new RuntimeException("can't use a headerView without a recyclerView");
        }
        if (drawerBuilder.mHeaderPadding) {
            drawerBuilder.getHeaderAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(drawerBuilder.mHeaderView).withHeight(drawerBuilder.mHeiderHeight).withDivider(drawerBuilder.mHeaderDivider).withViewPosition(ContainerDrawerItem.Position.TOP)});
        } else {
            drawerBuilder.getHeaderAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(drawerBuilder.mHeaderView).withHeight(drawerBuilder.mHeiderHeight).withDivider(drawerBuilder.mHeaderDivider).withViewPosition(ContainerDrawerItem.Position.NONE)});
        }
        drawerBuilder.mRecyclerView.setPadding(drawerBuilder.mRecyclerView.getPaddingLeft(), 0, drawerBuilder.mRecyclerView.getPaddingRight(), drawerBuilder.mRecyclerView.getPaddingBottom());
    }

    public static void rebuildStickyFooterView(final DrawerBuilder drawerBuilder) {
        if (drawerBuilder.mSliderLayout != null) {
            if (drawerBuilder.mStickyFooterView != null) {
                drawerBuilder.mStickyFooterView.removeAllViews();
                if (drawerBuilder.mStickyFooterDivider) {
                    addStickyFooterDivider(drawerBuilder.mStickyFooterView.getContext(), drawerBuilder.mStickyFooterView);
                }
                fillStickyDrawerItemFooter(drawerBuilder, drawerBuilder.mStickyFooterView, new View.OnClickListener() {
                    public void onClick(View view) {
                        DrawerUtils.onFooterDrawerItemClick(drawerBuilder, (IDrawerItem) view.getTag(), view, true);
                    }
                });
                drawerBuilder.mStickyFooterView.setVisibility(0);
            } else {
                handleFooterView(drawerBuilder, new View.OnClickListener() {
                    public void onClick(View view) {
                        DrawerUtils.onFooterDrawerItemClick(drawerBuilder, (IDrawerItem) view.getTag(), view, true);
                    }
                });
            }
            setStickyFooterSelection(drawerBuilder, drawerBuilder.mCurrentStickyFooterSelection, false);
        }
    }

    public static void handleFooterView(DrawerBuilder drawerBuilder, View.OnClickListener onClickListener) {
        Context context = drawerBuilder.mSliderLayout.getContext();
        if (drawerBuilder.mStickyDrawerItems != null && drawerBuilder.mStickyDrawerItems.size() > 0) {
            drawerBuilder.mStickyFooterView = buildStickyDrawerItemFooter(context, drawerBuilder, onClickListener);
        }
        if (drawerBuilder.mStickyFooterView != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, 1);
            drawerBuilder.mStickyFooterView.setId(C0658R.C0661id.material_drawer_sticky_footer);
            drawerBuilder.mSliderLayout.addView(drawerBuilder.mStickyFooterView, layoutParams);
            if ((drawerBuilder.mTranslucentNavigationBar || drawerBuilder.mFullscreen) && Build.VERSION.SDK_INT >= 19) {
                drawerBuilder.mStickyFooterView.setPadding(0, 0, 0, UIUtils.getNavigationBarHeight(context));
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) drawerBuilder.mRecyclerView.getLayoutParams();
            layoutParams2.addRule(2, C0658R.C0661id.material_drawer_sticky_footer);
            drawerBuilder.mRecyclerView.setLayoutParams(layoutParams2);
            if (drawerBuilder.mStickyFooterShadow) {
                drawerBuilder.mStickyFooterShadowView = new View(context);
                drawerBuilder.mStickyFooterShadowView.setBackgroundResource(C0658R.C0660drawable.material_drawer_shadow_top);
                drawerBuilder.mSliderLayout.addView(drawerBuilder.mStickyFooterShadowView, -1, context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_sticky_footer_elevation));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) drawerBuilder.mStickyFooterShadowView.getLayoutParams();
                layoutParams3.addRule(2, C0658R.C0661id.material_drawer_sticky_footer);
                drawerBuilder.mStickyFooterShadowView.setLayoutParams(layoutParams3);
            }
            drawerBuilder.mRecyclerView.setPadding(drawerBuilder.mRecyclerView.getPaddingLeft(), drawerBuilder.mRecyclerView.getPaddingTop(), drawerBuilder.mRecyclerView.getPaddingRight(), context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_padding));
        }
        if (drawerBuilder.mFooterView == null) {
            return;
        }
        if (drawerBuilder.mRecyclerView == null) {
            throw new RuntimeException("can't use a footerView without a recyclerView");
        } else if (drawerBuilder.mFooterDivider) {
            drawerBuilder.getFooterAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(drawerBuilder.mFooterView).withViewPosition(ContainerDrawerItem.Position.BOTTOM)});
        } else {
            drawerBuilder.getFooterAdapter().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(drawerBuilder.mFooterView).withViewPosition(ContainerDrawerItem.Position.NONE)});
        }
    }

    public static ViewGroup buildStickyDrawerItemFooter(Context context, DrawerBuilder drawerBuilder, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(context, C0658R.attr.material_drawer_background, C0658R.C0659color.material_drawer_background));
        if (drawerBuilder.mStickyFooterDivider) {
            addStickyFooterDivider(context, linearLayout);
        }
        fillStickyDrawerItemFooter(drawerBuilder, linearLayout, onClickListener);
        return linearLayout;
    }

    private static void addStickyFooterDivider(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setMinimumHeight((int) UIUtils.convertDpToPixel(1.0f, context));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(context, C0658R.attr.material_drawer_divider, C0658R.C0659color.material_drawer_divider));
        viewGroup.addView(linearLayout, layoutParams);
    }

    public static void fillStickyDrawerItemFooter(DrawerBuilder drawerBuilder, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        for (IDrawerItem next : drawerBuilder.mStickyDrawerItems) {
            View generateView = next.generateView(viewGroup.getContext(), viewGroup);
            generateView.setTag(next);
            if (next.isEnabled()) {
                generateView.setOnClickListener(onClickListener);
            }
            viewGroup.addView(generateView);
            DrawerUIUtils.setDrawerVerticalPadding(generateView);
        }
        viewGroup.setPadding(0, 0, 0, 0);
    }

    public static DrawerLayout.LayoutParams processDrawerLayoutParams(DrawerBuilder drawerBuilder, DrawerLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (drawerBuilder.mDrawerGravity != null && (drawerBuilder.mDrawerGravity.intValue() == 5 || drawerBuilder.mDrawerGravity.intValue() == 8388613)) {
                layoutParams.rightMargin = 0;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginEnd(0);
                }
                layoutParams.leftMargin = drawerBuilder.mActivity.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_margin);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginEnd(drawerBuilder.mActivity.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_margin));
                }
            }
            if (drawerBuilder.mDrawerWidth > -1) {
                layoutParams.width = drawerBuilder.mDrawerWidth;
            } else {
                layoutParams.width = DrawerUIUtils.getOptimalDrawerWidth(drawerBuilder.mActivity);
            }
        }
        return layoutParams;
    }
}
