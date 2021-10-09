package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.p003v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class ProfileDrawerItem extends AbstractDrawerItem<ProfileDrawerItem, ViewHolder> implements IProfile<ProfileDrawerItem>, Tagable<ProfileDrawerItem>, Typefaceable<ProfileDrawerItem> {
    protected Pair<Integer, ColorStateList> colorStateList;
    protected ColorHolder disabledTextColor;
    protected StringHolder email;
    protected ImageHolder icon;
    protected StringHolder name;
    protected boolean nameShown = false;
    protected ColorHolder selectedColor;
    protected ColorHolder selectedTextColor;
    protected ColorHolder textColor;
    protected Typeface typeface = null;

    public ProfileDrawerItem withIcon(Drawable drawable) {
        this.icon = new ImageHolder(drawable);
        return this;
    }

    public ProfileDrawerItem withIcon(@DrawableRes int i) {
        this.icon = new ImageHolder(i);
        return this;
    }

    public ProfileDrawerItem withIcon(Bitmap bitmap) {
        this.icon = new ImageHolder(bitmap);
        return this;
    }

    public ProfileDrawerItem withIcon(IIcon iIcon) {
        this.icon = new ImageHolder(iIcon);
        return this;
    }

    public ProfileDrawerItem withIcon(String str) {
        this.icon = new ImageHolder(str);
        return this;
    }

    public ProfileDrawerItem withIcon(Uri uri) {
        this.icon = new ImageHolder(uri);
        return this;
    }

    public ProfileDrawerItem withName(String str) {
        this.name = new StringHolder((CharSequence) str);
        return this;
    }

    public ProfileDrawerItem withName(@StringRes int i) {
        this.name = new StringHolder(i);
        return this;
    }

    public ProfileDrawerItem withEmail(String str) {
        this.email = new StringHolder((CharSequence) str);
        return this;
    }

    public ProfileDrawerItem withEmail(@StringRes int i) {
        this.email = new StringHolder(i);
        return this;
    }

    public ProfileDrawerItem withNameShown(boolean z) {
        this.nameShown = z;
        return this;
    }

    public ProfileDrawerItem withSelectedColor(@ColorInt int i) {
        this.selectedColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileDrawerItem withSelectedColorRes(@ColorRes int i) {
        this.selectedColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileDrawerItem withTextColor(@ColorInt int i) {
        this.textColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileDrawerItem withTextColorRes(@ColorRes int i) {
        this.textColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileDrawerItem withSelectedTextColor(@ColorInt int i) {
        this.selectedTextColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileDrawerItem withSelectedTextColorRes(@ColorRes int i) {
        this.selectedTextColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileDrawerItem withDisabledTextColor(@ColorInt int i) {
        this.disabledTextColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileDrawerItem withDisabledTextColorRes(@ColorRes int i) {
        this.disabledTextColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileDrawerItem withTypeface(Typeface typeface2) {
        this.typeface = typeface2;
        return this;
    }

    public boolean isNameShown() {
        return this.nameShown;
    }

    public ColorHolder getSelectedColor() {
        return this.selectedColor;
    }

    public ColorHolder getTextColor() {
        return this.textColor;
    }

    public ColorHolder getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public ColorHolder getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public ImageHolder getIcon() {
        return this.icon;
    }

    public StringHolder getName() {
        return this.name;
    }

    public StringHolder getEmail() {
        return this.email;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_profile;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_profile;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        viewHolder.itemView.setId(hashCode());
        viewHolder.itemView.setEnabled(isEnabled());
        viewHolder.itemView.setSelected(isSelected());
        int color = ColorHolder.color(getSelectedColor(), context, C0658R.attr.material_drawer_selected, C0658R.C0659color.material_drawer_selected);
        int color2 = getColor(context);
        int selectedTextColor2 = getSelectedTextColor(context);
        UIUtils.setBackground(viewHolder.view, (Drawable) UIUtils.getSelectableBackground(context, color, isSelectedBackgroundAnimated()));
        if (this.nameShown) {
            viewHolder.name.setVisibility(0);
            StringHolder.applyTo(getName(), viewHolder.name);
        } else {
            viewHolder.name.setVisibility(8);
        }
        if (this.nameShown || getEmail() != null || getName() == null) {
            StringHolder.applyTo(getEmail(), viewHolder.email);
        } else {
            StringHolder.applyTo(getName(), viewHolder.email);
        }
        if (getTypeface() != null) {
            viewHolder.name.setTypeface(getTypeface());
            viewHolder.email.setTypeface(getTypeface());
        }
        if (this.nameShown) {
            viewHolder.name.setTextColor(getTextColorStateList(color2, selectedTextColor2));
        }
        viewHolder.email.setTextColor(getTextColorStateList(color2, selectedTextColor2));
        DrawerImageLoader.getInstance().cancelImage(viewHolder.profileIcon);
        ImageHolder.applyToOrSetInvisible(getIcon(), viewHolder.profileIcon, DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name());
        DrawerUIUtils.setDrawerVerticalPadding(viewHolder.view);
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView email;
        /* access modifiers changed from: private */
        public TextView name;
        /* access modifiers changed from: private */
        public ImageView profileIcon;
        /* access modifiers changed from: private */
        public View view;

        private ViewHolder(View view2) {
            super(view2);
            this.view = view2;
            this.profileIcon = (ImageView) view2.findViewById(C0658R.C0661id.material_drawer_profileIcon);
            this.name = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_name);
            this.email = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_email);
        }
    }

    /* access modifiers changed from: protected */
    public int getColor(Context context) {
        if (isEnabled()) {
            return ColorHolder.color(getTextColor(), context, C0658R.attr.material_drawer_primary_text, C0658R.C0659color.material_drawer_primary_text);
        }
        return ColorHolder.color(getDisabledTextColor(), context, C0658R.attr.material_drawer_hint_text, C0658R.C0659color.material_drawer_hint_text);
    }

    /* access modifiers changed from: protected */
    public int getSelectedTextColor(Context context) {
        return ColorHolder.color(getSelectedTextColor(), context, C0658R.attr.material_drawer_selected_text, C0658R.C0659color.material_drawer_selected_text);
    }

    /* access modifiers changed from: protected */
    public ColorStateList getTextColorStateList(@ColorInt int i, @ColorInt int i2) {
        if (this.colorStateList == null || i + i2 != ((Integer) this.colorStateList.first).intValue()) {
            this.colorStateList = new Pair<>(Integer.valueOf(i + i2), DrawerUIUtils.getTextColorStateList(i, i2));
        }
        return (ColorStateList) this.colorStateList.second;
    }
}
