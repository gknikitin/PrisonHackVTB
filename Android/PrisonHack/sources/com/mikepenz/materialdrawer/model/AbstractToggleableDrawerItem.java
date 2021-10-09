package com.mikepenz.materialdrawer.model;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.AbstractToggleableDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;

public class AbstractToggleableDrawerItem<Item extends AbstractToggleableDrawerItem> extends BaseDescribeableDrawerItem<Item, ViewHolder> {
    /* access modifiers changed from: private */
    public boolean checked = false;
    /* access modifiers changed from: private */
    public CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (AbstractToggleableDrawerItem.this.isEnabled()) {
                boolean unused = AbstractToggleableDrawerItem.this.checked = z;
                if (AbstractToggleableDrawerItem.this.getOnCheckedChangeListener() != null) {
                    AbstractToggleableDrawerItem.this.getOnCheckedChangeListener().onCheckedChanged(AbstractToggleableDrawerItem.this, compoundButton, z);
                    return;
                }
                return;
            }
            compoundButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(AbstractToggleableDrawerItem.this.checkedChangeListener);
        }
    };
    private OnCheckedChangeListener onCheckedChangeListener = null;
    private boolean toggleEnabled = true;

    public Item withChecked(boolean z) {
        this.checked = z;
        return this;
    }

    public Item withToggleEnabled(boolean z) {
        this.toggleEnabled = z;
        return this;
    }

    public Item withOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
        return this;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public boolean isToggleEnabled() {
        return this.toggleEnabled;
    }

    public void setToggleEnabled(boolean z) {
        this.toggleEnabled = z;
    }

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_primary_toggle;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_toggle;
    }

    public void bindView(final ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        bindViewHelper(viewHolder);
        viewHolder.toggle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        viewHolder.toggle.setChecked(this.checked);
        viewHolder.toggle.setOnCheckedChangeListener(this.checkedChangeListener);
        viewHolder.toggle.setEnabled(this.toggleEnabled);
        withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                if (AbstractToggleableDrawerItem.this.isSelectable()) {
                    return false;
                }
                boolean unused = AbstractToggleableDrawerItem.this.checked = !AbstractToggleableDrawerItem.this.checked;
                viewHolder.toggle.setChecked(AbstractToggleableDrawerItem.this.checked);
                return false;
            }
        });
        onPostBindView(this, viewHolder.itemView);
    }

    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends BaseViewHolder {
        /* access modifiers changed from: private */
        public ToggleButton toggle;

        private ViewHolder(View view) {
            super(view);
            this.toggle = (ToggleButton) view.findViewById(C0658R.C0661id.material_drawer_toggle);
        }
    }
}
