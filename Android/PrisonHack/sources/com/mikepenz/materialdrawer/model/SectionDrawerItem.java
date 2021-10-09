package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;

public class SectionDrawerItem extends AbstractDrawerItem<SectionDrawerItem, ViewHolder> implements Nameable<SectionDrawerItem>, Typefaceable<SectionDrawerItem> {
    private boolean divider = true;
    private StringHolder name;
    private ColorHolder textColor;
    private Typeface typeface = null;

    public boolean isEnabled() {
        return false;
    }

    public boolean isSelected() {
        return false;
    }

    public SectionDrawerItem withName(StringHolder stringHolder) {
        this.name = stringHolder;
        return this;
    }

    public SectionDrawerItem withName(String str) {
        this.name = new StringHolder((CharSequence) str);
        return this;
    }

    public SectionDrawerItem withName(@StringRes int i) {
        this.name = new StringHolder(i);
        return this;
    }

    public SectionDrawerItem withDivider(boolean z) {
        this.divider = z;
        return this;
    }

    public SectionDrawerItem withTextColor(int i) {
        this.textColor = ColorHolder.fromColor(i);
        return this;
    }

    public SectionDrawerItem withTextColorRes(int i) {
        this.textColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public SectionDrawerItem withTypeface(Typeface typeface2) {
        this.typeface = typeface2;
        return this;
    }

    public boolean hasDivider() {
        return this.divider;
    }

    public ColorHolder getTextColor() {
        return this.textColor;
    }

    public StringHolder getName() {
        return this.name;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_section;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_section;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void bindView(ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        Context context = viewHolder.itemView.getContext();
        viewHolder.itemView.setId(hashCode());
        viewHolder.view.setClickable(false);
        viewHolder.view.setEnabled(false);
        viewHolder.name.setTextColor(ColorHolder.color(getTextColor(), context, C0658R.attr.material_drawer_secondary_text, C0658R.C0659color.material_drawer_secondary_text));
        StringHolder.applyTo(getName(), viewHolder.name);
        if (getTypeface() != null) {
            viewHolder.name.setTypeface(getTypeface());
        }
        if (hasDivider()) {
            viewHolder.divider.setVisibility(0);
        } else {
            viewHolder.divider.setVisibility(8);
        }
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
        public TextView name;
        /* access modifiers changed from: private */
        public View view;

        private ViewHolder(View view2) {
            super(view2);
            this.view = view2;
            this.divider = view2.findViewById(C0658R.C0661id.material_drawer_divider);
            this.name = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_name);
        }
    }
}
