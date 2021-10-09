package com.mikepenz.materialdrawer.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import java.util.List;

public class MiniProfileDrawerItem extends AbstractDrawerItem<MiniProfileDrawerItem, ViewHolder> implements IProfile<MiniProfileDrawerItem> {
    protected DimenHolder customHeight;
    protected ImageHolder icon;

    public StringHolder getEmail() {
        return null;
    }

    public StringHolder getName() {
        return null;
    }

    public MiniProfileDrawerItem withEmail(String str) {
        return null;
    }

    public MiniProfileDrawerItem withName(String str) {
        return null;
    }

    public MiniProfileDrawerItem() {
        withSelectable(false);
    }

    public MiniProfileDrawerItem(ProfileDrawerItem profileDrawerItem) {
        this.icon = profileDrawerItem.icon;
        this.mEnabled = profileDrawerItem.mEnabled;
        withSelectable(false);
    }

    public MiniProfileDrawerItem withIcon(Drawable drawable) {
        this.icon = new ImageHolder(drawable);
        return this;
    }

    public MiniProfileDrawerItem withIcon(@DrawableRes int i) {
        this.icon = new ImageHolder(i);
        return this;
    }

    public MiniProfileDrawerItem withIcon(Bitmap bitmap) {
        this.icon = new ImageHolder(bitmap);
        return this;
    }

    public MiniProfileDrawerItem withIcon(String str) {
        this.icon = new ImageHolder(str);
        return this;
    }

    public MiniProfileDrawerItem withIcon(Uri uri) {
        this.icon = new ImageHolder(uri);
        return this;
    }

    public MiniProfileDrawerItem withIcon(IIcon iIcon) {
        this.icon = new ImageHolder(iIcon);
        return this;
    }

    public MiniProfileDrawerItem withCustomHeightRes(@DimenRes int i) {
        this.customHeight = DimenHolder.fromResource(i);
        return this;
    }

    public MiniProfileDrawerItem withCustomHeightDp(int i) {
        this.customHeight = DimenHolder.fromDp(i);
        return this;
    }

    public MiniProfileDrawerItem withCustomHeightPx(int i) {
        this.customHeight = DimenHolder.fromPixel(i);
        return this;
    }

    public MiniProfileDrawerItem withCustomHeight(DimenHolder dimenHolder) {
        this.customHeight = dimenHolder;
        return this;
    }

    public ImageHolder getIcon() {
        return this.icon;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_mini_profile;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_mini_profile;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        if (this.customHeight != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.height = this.customHeight.asPixel(viewHolder.itemView.getContext());
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
        viewHolder.itemView.setId(hashCode());
        viewHolder.itemView.setEnabled(isEnabled());
        ImageHolder.applyToOrSetInvisible(getIcon(), viewHolder.icon);
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView icon;

        public ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(C0658R.C0661id.material_drawer_icon);
        }
    }
}
