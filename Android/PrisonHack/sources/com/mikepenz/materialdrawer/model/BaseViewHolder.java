package com.mikepenz.materialdrawer.model;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.materialdrawer.C0658R;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected TextView description;
    protected ImageView icon;
    protected TextView name;
    protected View view;

    public BaseViewHolder(View view2) {
        super(view2);
        this.view = view2;
        this.icon = (ImageView) view2.findViewById(C0658R.C0661id.material_drawer_icon);
        this.name = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_name);
        this.description = (TextView) view2.findViewById(C0658R.C0661id.material_drawer_description);
    }
}
