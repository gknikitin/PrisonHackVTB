package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;

public class ExpandableBadgeDrawerItem extends BaseDescribeableDrawerItem<ExpandableBadgeDrawerItem, ViewHolder> implements ColorfulBadgeable<ExpandableBadgeDrawerItem> {
    protected ColorHolder arrowColor;
    protected int arrowRotationAngleEnd = 180;
    protected int arrowRotationAngleStart = 0;
    protected StringHolder mBadge;
    protected BadgeStyle mBadgeStyle = new BadgeStyle();
    private Drawer.OnDrawerItemClickListener mOnArrowDrawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
            if ((iDrawerItem instanceof AbstractDrawerItem) && iDrawerItem.isEnabled()) {
                AbstractDrawerItem abstractDrawerItem = (AbstractDrawerItem) iDrawerItem;
                if (abstractDrawerItem.getSubItems() != null) {
                    if (abstractDrawerItem.isExpanded()) {
                        ViewCompat.animate(view.findViewById(C0658R.C0661id.material_drawer_arrow)).rotation((float) ExpandableBadgeDrawerItem.this.arrowRotationAngleEnd).start();
                    } else {
                        ViewCompat.animate(view.findViewById(C0658R.C0661id.material_drawer_arrow)).rotation((float) ExpandableBadgeDrawerItem.this.arrowRotationAngleStart).start();
                    }
                }
            }
            return ExpandableBadgeDrawerItem.this.mOnDrawerItemClickListener != null && ExpandableBadgeDrawerItem.this.mOnDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
        }
    };
    /* access modifiers changed from: private */
    public Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;

    public int getType() {
        return C0658R.C0661id.material_drawer_item_expandable_badge;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_expandable_badge;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        bindViewHelper(viewHolder);
        StringHolder.applyToOrHide(this.mBadge, viewHolder.badge);
        this.mBadgeStyle.style(viewHolder.badge, getTextColorStateList(getColor(context), getSelectedTextColor(context)));
        viewHolder.badgeContainer.setVisibility(0);
        if (getTypeface() != null) {
            viewHolder.badge.setTypeface(getTypeface());
        }
        if (viewHolder.arrow.getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) viewHolder.arrow.getDrawable()).color(this.arrowColor != null ? this.arrowColor.color(context) : getIconColor(context));
        }
        viewHolder.arrow.clearAnimation();
        if (!isExpanded()) {
            viewHolder.arrow.setRotation((float) this.arrowRotationAngleStart);
        } else {
            viewHolder.arrow.setRotation((float) this.arrowRotationAngleEnd);
        }
        onPostBindView(this, viewHolder.itemView);
    }

    public ExpandableBadgeDrawerItem withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.mOnArrowDrawerItemClickListener;
    }

    public ExpandableBadgeDrawerItem withBadge(StringHolder stringHolder) {
        this.mBadge = stringHolder;
        return this;
    }

    public ExpandableBadgeDrawerItem withBadge(String str) {
        this.mBadge = new StringHolder((CharSequence) str);
        return this;
    }

    public ExpandableBadgeDrawerItem withBadge(@StringRes int i) {
        this.mBadge = new StringHolder(i);
        return this;
    }

    public ExpandableBadgeDrawerItem withBadgeStyle(BadgeStyle badgeStyle) {
        this.mBadgeStyle = badgeStyle;
        return this;
    }

    public StringHolder getBadge() {
        return this.mBadge;
    }

    public BadgeStyle getBadgeStyle() {
        return this.mBadgeStyle;
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends BaseViewHolder {
        public ImageView arrow;
        public TextView badge;
        public View badgeContainer;

        public ViewHolder(View view) {
            super(view);
            this.badgeContainer = view.findViewById(C0658R.C0661id.material_drawer_badge_container);
            this.badge = (TextView) view.findViewById(C0658R.C0661id.material_drawer_badge);
            this.arrow = (ImageView) view.findViewById(C0658R.C0661id.material_drawer_arrow);
            this.arrow.setImageDrawable(new IconicsDrawable(view.getContext(), (IIcon) MaterialDrawerFont.Icon.mdf_expand_more).sizeDp(16).paddingDp(2).color((int) ViewCompat.MEASURED_STATE_MASK));
        }
    }
}
