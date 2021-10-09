package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class ContainerDrawerItem extends AbstractDrawerItem<ContainerDrawerItem, ViewHolder> {
    private boolean mDivider = true;
    private DimenHolder mHeight;
    private View mView;
    private Position mViewPosition = Position.TOP;

    public enum Position {
        TOP,
        BOTTOM,
        NONE
    }

    public ContainerDrawerItem withHeight(DimenHolder dimenHolder) {
        this.mHeight = dimenHolder;
        return this;
    }

    public DimenHolder getHeight() {
        return this.mHeight;
    }

    public ContainerDrawerItem withView(View view) {
        this.mView = view;
        return this;
    }

    public View getView() {
        return this.mView;
    }

    public ContainerDrawerItem withViewPosition(Position position) {
        this.mViewPosition = position;
        return this;
    }

    public ContainerDrawerItem withDivider(boolean z) {
        this.mDivider = z;
        return this;
    }

    public Position getViewPosition() {
        return this.mViewPosition;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_container;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_container;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        viewHolder.itemView.setId(hashCode());
        viewHolder.view.setEnabled(false);
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        int i = -2;
        if (this.mHeight != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.view.getLayoutParams();
            int asPixel = this.mHeight.asPixel(context);
            layoutParams.height = asPixel;
            viewHolder.view.setLayoutParams(layoutParams);
            i = asPixel;
        }
        ((ViewGroup) viewHolder.view).removeAllViews();
        boolean z = this.mDivider;
        View view = new View(context);
        view.setMinimumHeight(z ? 1 : 0);
        view.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(context, C0658R.attr.material_drawer_divider, C0658R.C0659color.material_drawer_divider));
        float f = z ? 1.0f : 0.0f;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) UIUtils.convertDpToPixel(f, context));
        if (this.mHeight != null) {
            i -= (int) UIUtils.convertDpToPixel(f, context);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, i);
        if (this.mViewPosition == Position.TOP) {
            ((ViewGroup) viewHolder.view).addView(this.mView, layoutParams3);
            layoutParams2.bottomMargin = context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_padding);
            ((ViewGroup) viewHolder.view).addView(view, layoutParams2);
        } else if (this.mViewPosition == Position.BOTTOM) {
            layoutParams2.topMargin = context.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_padding);
            ((ViewGroup) viewHolder.view).addView(view, layoutParams2);
            ((ViewGroup) viewHolder.view).addView(this.mView, layoutParams3);
        } else {
            ((ViewGroup) viewHolder.view).addView(this.mView, layoutParams3);
        }
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View view;

        private ViewHolder(View view2) {
            super(view2);
            this.view = view2;
        }
    }
}
