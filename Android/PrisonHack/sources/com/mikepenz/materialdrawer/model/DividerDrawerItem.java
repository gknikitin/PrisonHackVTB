package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class DividerDrawerItem extends AbstractDrawerItem<DividerDrawerItem, ViewHolder> {
    public int getType() {
        return C0658R.C0661id.material_drawer_item_divider;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_divider;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        viewHolder.itemView.setId(hashCode());
        viewHolder.view.setClickable(false);
        viewHolder.view.setEnabled(false);
        viewHolder.view.setMinimumHeight(1);
        ViewCompat.setImportantForAccessibility(viewHolder.view, 2);
        viewHolder.divider.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(context, C0658R.attr.material_drawer_divider, C0658R.C0659color.material_drawer_divider));
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View divider;
        /* access modifiers changed from: private */
        public View view;

        private ViewHolder(View view2) {
            super(view2);
            this.view = view2;
            this.divider = view2.findViewById(C0658R.C0661id.material_drawer_divider);
        }
    }
}
