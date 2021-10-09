package com.mikepenz.materialdrawer.model;

import android.support.annotation.LayoutRes;
import android.support.p003v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;

public abstract class AbstractSwitchableDrawerItem<Item extends AbstractSwitchableDrawerItem> extends BaseDescribeableDrawerItem<Item, ViewHolder> {
    /* access modifiers changed from: private */
    public boolean checked = false;
    /* access modifiers changed from: private */
    public CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (AbstractSwitchableDrawerItem.this.isEnabled()) {
                boolean unused = AbstractSwitchableDrawerItem.this.checked = z;
                if (AbstractSwitchableDrawerItem.this.getOnCheckedChangeListener() != null) {
                    AbstractSwitchableDrawerItem.this.getOnCheckedChangeListener().onCheckedChanged(AbstractSwitchableDrawerItem.this, compoundButton, z);
                    return;
                }
                return;
            }
            compoundButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(AbstractSwitchableDrawerItem.this.checkedChangeListener);
        }
    };
    private OnCheckedChangeListener onCheckedChangeListener = null;
    private boolean switchEnabled = true;

    public Item withChecked(boolean z) {
        this.checked = z;
        return this;
    }

    public Item withSwitchEnabled(boolean z) {
        this.switchEnabled = z;
        return this;
    }

    public Item withOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
        return this;
    }

    public Item withCheckable(boolean z) {
        return (AbstractSwitchableDrawerItem) withSelectable(z);
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isSwitchEnabled() {
        return this.switchEnabled;
    }

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    public int getType() {
        return C0658R.C0661id.material_drawer_item_primary_switch;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_switch;
    }

    public void bindView(final ViewHolder viewHolder, List list) {
        super.bindView(viewHolder, list);
        bindViewHelper(viewHolder);
        viewHolder.switchView.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        viewHolder.switchView.setChecked(this.checked);
        viewHolder.switchView.setOnCheckedChangeListener(this.checkedChangeListener);
        viewHolder.switchView.setEnabled(this.switchEnabled);
        withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                if (AbstractSwitchableDrawerItem.this.isSelectable()) {
                    return false;
                }
                boolean unused = AbstractSwitchableDrawerItem.this.checked = !AbstractSwitchableDrawerItem.this.checked;
                viewHolder.switchView.setChecked(AbstractSwitchableDrawerItem.this.checked);
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
        public SwitchCompat switchView;

        private ViewHolder(View view) {
            super(view);
            this.switchView = (SwitchCompat) view.findViewById(C0658R.C0661id.material_drawer_switch);
        }
    }
}
