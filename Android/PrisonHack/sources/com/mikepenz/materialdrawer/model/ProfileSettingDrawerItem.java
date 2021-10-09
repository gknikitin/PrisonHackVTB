package com.mikepenz.materialdrawer.model;

import android.content.Context;
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
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class ProfileSettingDrawerItem extends AbstractDrawerItem<ProfileSettingDrawerItem, ViewHolder> implements IProfile<ProfileSettingDrawerItem>, Tagable<ProfileSettingDrawerItem>, Typefaceable<ProfileSettingDrawerItem> {
    private StringHolder description;
    private ColorHolder descriptionTextColor;
    private ImageHolder icon;
    private ColorHolder iconColor;
    private boolean iconTinted = false;
    private StringHolder name;
    private boolean selectable = false;
    private ColorHolder selectedColor;
    private ColorHolder textColor;
    private Typeface typeface = null;

    public ProfileSettingDrawerItem withIcon(Drawable drawable) {
        this.icon = new ImageHolder(drawable);
        return this;
    }

    public ProfileSettingDrawerItem withIcon(@DrawableRes int i) {
        this.icon = new ImageHolder(i);
        return this;
    }

    public ProfileSettingDrawerItem withIcon(Bitmap bitmap) {
        this.icon = new ImageHolder(bitmap);
        return this;
    }

    public ProfileSettingDrawerItem withIcon(IIcon iIcon) {
        this.icon = new ImageHolder(iIcon);
        return this;
    }

    public ProfileSettingDrawerItem withIcon(String str) {
        this.icon = new ImageHolder(str);
        return this;
    }

    public ProfileSettingDrawerItem withIcon(Uri uri) {
        this.icon = new ImageHolder(uri);
        return this;
    }

    public ProfileSettingDrawerItem withName(String str) {
        this.name = new StringHolder((CharSequence) str);
        return this;
    }

    public ProfileSettingDrawerItem withName(@StringRes int i) {
        this.name = new StringHolder(i);
        return this;
    }

    public ProfileSettingDrawerItem withDescription(String str) {
        this.description = new StringHolder((CharSequence) str);
        return this;
    }

    public ProfileSettingDrawerItem withDescription(@StringRes int i) {
        this.description = new StringHolder(i);
        return this;
    }

    public ProfileSettingDrawerItem withEmail(String str) {
        this.description = new StringHolder((CharSequence) str);
        return this;
    }

    public ProfileSettingDrawerItem withSelectedColor(@ColorInt int i) {
        this.selectedColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileSettingDrawerItem withSelectedColorRes(@ColorRes int i) {
        this.selectedColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileSettingDrawerItem withTextColor(@ColorInt int i) {
        this.textColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileSettingDrawerItem withTextColorRes(@ColorRes int i) {
        this.textColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileSettingDrawerItem withDescriptionTextColor(@ColorInt int i) {
        this.descriptionTextColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileSettingDrawerItem withDescriptionTextColorRes(@ColorRes int i) {
        this.descriptionTextColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileSettingDrawerItem withIconColor(@ColorInt int i) {
        this.iconColor = ColorHolder.fromColor(i);
        return this;
    }

    public ProfileSettingDrawerItem withIconColorRes(@ColorRes int i) {
        this.iconColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public ProfileSettingDrawerItem withTypeface(Typeface typeface2) {
        this.typeface = typeface2;
        return this;
    }

    public ProfileSettingDrawerItem withIconTinted(boolean z) {
        this.iconTinted = z;
        return this;
    }

    public ColorHolder getSelectedColor() {
        return this.selectedColor;
    }

    public ColorHolder getTextColor() {
        return this.textColor;
    }

    public ColorHolder getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    public ColorHolder getIconColor() {
        return this.iconColor;
    }

    public ImageHolder getIcon() {
        return this.icon;
    }

    public boolean isIconTinted() {
        return this.iconTinted;
    }

    public void setIconTinted(boolean z) {
        this.iconTinted = z;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public StringHolder getName() {
        return this.name;
    }

    public StringHolder getEmail() {
        return this.description;
    }

    public StringHolder getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = new StringHolder((CharSequence) str);
    }

    public boolean isSelectable() {
        return this.selectable;
    }

    public ProfileSettingDrawerItem withSelectable(boolean z) {
        this.selectable = z;
        return this;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_profile_setting;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_profile_setting;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        viewHolder.itemView.setId(hashCode());
        viewHolder.itemView.setEnabled(isEnabled());
        viewHolder.itemView.setSelected(isSelected());
        int color = ColorHolder.color(getSelectedColor(), context, C0658R.attr.material_drawer_selected, C0658R.C0659color.material_drawer_selected);
        int color2 = ColorHolder.color(getTextColor(), context, C0658R.attr.material_drawer_primary_text, C0658R.C0659color.material_drawer_primary_text);
        int color3 = ColorHolder.color(getIconColor(), context, C0658R.attr.material_drawer_primary_icon, C0658R.C0659color.material_drawer_primary_icon);
        int color4 = ColorHolder.color(getDescriptionTextColor(), context, C0658R.attr.material_drawer_primary_text, C0658R.C0659color.material_drawer_primary_text);
        UIUtils.setBackground(viewHolder.view, (Drawable) UIUtils.getSelectableBackground(context, color, isSelectedBackgroundAnimated()));
        StringHolder.applyTo(getName(), viewHolder.name);
        viewHolder.name.setTextColor(color2);
        StringHolder.applyToOrHide(getDescription(), viewHolder.description);
        viewHolder.description.setTextColor(color4);
        if (getTypeface() != null) {
            viewHolder.name.setTypeface(getTypeface());
        }
        ImageHolder.applyDecidedIconOrSetGone(this.icon, viewHolder.icon, color3, isIconTinted(), 2);
        DrawerUIUtils.setDrawerVerticalPadding(viewHolder.view);
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView description;
        /* access modifiers changed from: private */
        public ImageView icon;
        /* access modifiers changed from: private */
        public TextView name;
        /* access modifiers changed from: private */
        public View view;

        private ViewHolder(View view2) {
            super(view2);
            this.view = view2;
            this.icon = (ImageView) view2.findViewById(C0658R.C0661id.material_drawer_icon);
            this.name = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_name);
            this.description = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_description);
        }
    }
}
