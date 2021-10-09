package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import java.util.List;

public abstract class AbstractBadgeableDrawerItem<Item extends AbstractBadgeableDrawerItem> extends BaseDescribeableDrawerItem<Item, ViewHolder> implements ColorfulBadgeable<Item> {
    protected StringHolder mBadge;
    protected BadgeStyle mBadgeStyle = new BadgeStyle();

    public Item withBadge(StringHolder stringHolder) {
        this.mBadge = stringHolder;
        return this;
    }

    public Item withBadge(String str) {
        this.mBadge = new StringHolder((CharSequence) str);
        return this;
    }

    public Item withBadge(@StringRes int i) {
        this.mBadge = new StringHolder(i);
        return this;
    }

    public Item withBadgeStyle(BadgeStyle badgeStyle) {
        this.mBadgeStyle = badgeStyle;
        return this;
    }

    public StringHolder getBadge() {
        return this.mBadge;
    }

    public BadgeStyle getBadgeStyle() {
        return this.mBadgeStyle;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_primary;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_primary;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        bindViewHelper(viewHolder);
        if (StringHolder.applyToOrHide(this.mBadge, viewHolder.badge)) {
            this.mBadgeStyle.style(viewHolder.badge, getTextColorStateList(getColor(context), getSelectedTextColor(context)));
            viewHolder.badgeContainer.setVisibility(0);
        } else {
            viewHolder.badgeContainer.setVisibility(8);
        }
        if (getTypeface() != null) {
            viewHolder.badge.setTypeface(getTypeface());
        }
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends BaseViewHolder {
        /* access modifiers changed from: private */
        public TextView badge;
        /* access modifiers changed from: private */
        public View badgeContainer;

        public ViewHolder(View view) {
            super(view);
            this.badgeContainer = view.findViewById(C0658R.C0661id.material_drawer_badge_container);
            this.badge = (TextView) view.findViewById(C0658R.C0661id.material_drawer_badge);
        }
    }
}
