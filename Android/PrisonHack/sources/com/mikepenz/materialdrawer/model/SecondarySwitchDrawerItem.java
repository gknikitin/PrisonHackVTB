package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.holder.ColorHolder;

public class SecondarySwitchDrawerItem extends AbstractSwitchableDrawerItem<SecondarySwitchDrawerItem> {
    public int getType() {
        return C0658R.C0661id.material_drawer_item_secondary_switch;
    }

    @LayoutRes
    public int getLayoutRes() {
        return C0658R.layout.material_drawer_item_secondary_switch;
    }

    /* access modifiers changed from: protected */
    public int getColor(Context context) {
        if (isEnabled()) {
            return ColorHolder.color(getTextColor(), context, C0658R.attr.material_drawer_secondary_text, C0658R.C0659color.material_drawer_secondary_text);
        }
        return ColorHolder.color(getDisabledTextColor(), context, C0658R.attr.material_drawer_hint_text, C0658R.C0659color.material_drawer_hint_text);
    }
}
