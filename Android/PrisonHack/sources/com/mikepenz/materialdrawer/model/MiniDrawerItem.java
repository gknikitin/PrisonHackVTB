package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.annotation.LayoutRes;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class MiniDrawerItem extends BaseDrawerItem<MiniDrawerItem, ViewHolder> {
    private StringHolder mBadge;
    private BadgeStyle mBadgeStyle = new BadgeStyle();
    protected DimenHolder mCustomHeight;
    private boolean mEnableSelectedBackground = false;

    public MiniDrawerItem() {
    }

    public MiniDrawerItem(PrimaryDrawerItem primaryDrawerItem) {
        this.mIdentifier = primaryDrawerItem.mIdentifier;
        this.mTag = primaryDrawerItem.mTag;
        this.mBadge = primaryDrawerItem.mBadge;
        this.mBadgeStyle = primaryDrawerItem.mBadgeStyle;
        this.mEnabled = primaryDrawerItem.mEnabled;
        this.mSelectable = primaryDrawerItem.mSelectable;
        this.mSelected = primaryDrawerItem.mSelected;
        this.icon = primaryDrawerItem.icon;
        this.selectedIcon = primaryDrawerItem.selectedIcon;
        this.iconTinted = primaryDrawerItem.iconTinted;
        this.selectedColor = primaryDrawerItem.selectedColor;
        this.iconColor = primaryDrawerItem.iconColor;
        this.selectedIconColor = primaryDrawerItem.selectedIconColor;
        this.disabledIconColor = primaryDrawerItem.disabledIconColor;
    }

    public MiniDrawerItem(SecondaryDrawerItem secondaryDrawerItem) {
        this.mIdentifier = secondaryDrawerItem.mIdentifier;
        this.mTag = secondaryDrawerItem.mTag;
        this.mBadge = secondaryDrawerItem.mBadge;
        this.mBadgeStyle = secondaryDrawerItem.mBadgeStyle;
        this.mEnabled = secondaryDrawerItem.mEnabled;
        this.mSelectable = secondaryDrawerItem.mSelectable;
        this.mSelected = secondaryDrawerItem.mSelected;
        this.icon = secondaryDrawerItem.icon;
        this.selectedIcon = secondaryDrawerItem.selectedIcon;
        this.iconTinted = secondaryDrawerItem.iconTinted;
        this.selectedColor = secondaryDrawerItem.selectedColor;
        this.iconColor = secondaryDrawerItem.iconColor;
        this.selectedIconColor = secondaryDrawerItem.selectedIconColor;
        this.disabledIconColor = secondaryDrawerItem.disabledIconColor;
    }

    public MiniDrawerItem withCustomHeightRes(@DimenRes int i) {
        this.mCustomHeight = DimenHolder.fromResource(i);
        return this;
    }

    public MiniDrawerItem withCustomHeightDp(int i) {
        this.mCustomHeight = DimenHolder.fromDp(i);
        return this;
    }

    public MiniDrawerItem withCustomHeightPx(int i) {
        this.mCustomHeight = DimenHolder.fromPixel(i);
        return this;
    }

    public MiniDrawerItem withCustomHeight(DimenHolder dimenHolder) {
        this.mCustomHeight = dimenHolder;
        return this;
    }

    public MiniDrawerItem withEnableSelectedBackground(boolean z) {
        this.mEnableSelectedBackground = z;
        return this;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_mini;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_mini;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        if (this.mCustomHeight != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.height = this.mCustomHeight.asPixel(context);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
        viewHolder.itemView.setId(hashCode());
        viewHolder.itemView.setEnabled(isEnabled());
        viewHolder.itemView.setSelected(isSelected());
        viewHolder.itemView.setTag(this);
        int iconColor = getIconColor(context);
        int selectedIconColor = getSelectedIconColor(context);
        if (this.mEnableSelectedBackground) {
            UIUtils.setBackground(viewHolder.view, (Drawable) UIUtils.getSelectableBackground(context, getSelectedColor(context), isSelectedBackgroundAnimated()));
        }
        if (StringHolder.applyToOrHide(this.mBadge, viewHolder.badge)) {
            this.mBadgeStyle.style(viewHolder.badge);
        }
        ImageHolder.applyMultiIconTo(ImageHolder.decideIcon(getIcon(), context, iconColor, isIconTinted(), 1), iconColor, ImageHolder.decideIcon(getSelectedIcon(), context, selectedIconColor, isIconTinted(), 1), selectedIconColor, isIconTinted(), viewHolder.icon);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_padding);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0658R.dimen.material_mini_drawer_item_padding);
        viewHolder.itemView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView badge;
        /* access modifiers changed from: private */
        public ImageView icon;
        /* access modifiers changed from: private */
        public View view;

        public ViewHolder(View view2) {
            super(view2);
            this.view = view2;
            this.icon = (ImageView) view2.findViewById(C0658R.C0661id.material_drawer_icon);
            this.badge = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_badge);
        }
    }
}
