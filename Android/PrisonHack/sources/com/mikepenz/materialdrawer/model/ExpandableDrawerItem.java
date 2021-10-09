package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;

public class ExpandableDrawerItem extends BaseDescribeableDrawerItem<ExpandableDrawerItem, ViewHolder> {
    protected ColorHolder arrowColor;
    protected int arrowRotationAngleEnd = 180;
    protected int arrowRotationAngleStart = 0;
    private Drawer.OnDrawerItemClickListener mOnArrowDrawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
            if ((iDrawerItem instanceof AbstractDrawerItem) && iDrawerItem.isEnabled()) {
                AbstractDrawerItem abstractDrawerItem = (AbstractDrawerItem) iDrawerItem;
                if (abstractDrawerItem.getSubItems() != null) {
                    if (abstractDrawerItem.isExpanded()) {
                        ViewCompat.animate(view.findViewById(C0658R.C0661id.material_drawer_arrow)).rotation((float) ExpandableDrawerItem.this.arrowRotationAngleEnd).start();
                    } else {
                        ViewCompat.animate(view.findViewById(C0658R.C0661id.material_drawer_arrow)).rotation((float) ExpandableDrawerItem.this.arrowRotationAngleStart).start();
                    }
                }
            }
            return ExpandableDrawerItem.this.mOnDrawerItemClickListener != null && ExpandableDrawerItem.this.mOnDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
        }
    };
    /* access modifiers changed from: private */
    public Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;

    public ExpandableDrawerItem withArrowColor(@ColorInt int i) {
        this.arrowColor = ColorHolder.fromColor(i);
        return this;
    }

    public ExpandableDrawerItem withArrowColorRes(@ColorRes int i) {
        this.arrowColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ExpandableDrawerItem withArrowRotationAngleStart(int i) {
        this.arrowRotationAngleStart = i;
        return this;
    }

    public ExpandableDrawerItem withArrowRotationAngleEnd(int i) {
        this.arrowRotationAngleEnd = i;
        return this;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_expandable;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_expandable;
    }

    public ExpandableDrawerItem withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.mOnArrowDrawerItemClickListener;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        bindViewHelper(viewHolder);
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

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends BaseViewHolder {
        public ImageView arrow;

        public ViewHolder(View view) {
            super(view);
            this.arrow = (ImageView) view.findViewById(C0658R.C0661id.material_drawer_arrow);
            this.arrow.setImageDrawable(new IconicsDrawable(view.getContext(), (IIcon) MaterialDrawerFont.Icon.mdf_expand_more).sizeDp(16).paddingDp(2).color((int) ViewCompat.MEASURED_STATE_MASK));
        }
    }
}
