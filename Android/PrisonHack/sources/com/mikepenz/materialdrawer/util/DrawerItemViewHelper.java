package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.mikepenz.materialdrawer.C0658R;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialize.util.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DrawerItemViewHelper {
    private Context mContext;
    private boolean mDivider = true;
    private ArrayList<IDrawerItem> mDrawerItems = new ArrayList<>();
    /* access modifiers changed from: private */
    public OnDrawerItemClickListener mOnDrawerItemClickListener = null;

    public interface OnDrawerItemClickListener {
        void onItemClick(View view, IDrawerItem iDrawerItem);
    }

    public DrawerItemViewHelper(Context context) {
        this.mContext = context;
    }

    public DrawerItemViewHelper withDrawerItems(ArrayList<IDrawerItem> arrayList) {
        this.mDrawerItems = arrayList;
        return this;
    }

    public DrawerItemViewHelper withDrawerItems(IDrawerItem... iDrawerItemArr) {
        Collections.addAll(this.mDrawerItems, iDrawerItemArr);
        return this;
    }

    public DrawerItemViewHelper withDivider(boolean z) {
        this.mDivider = z;
        return this;
    }

    public DrawerItemViewHelper withOnDrawerItemClickListener(OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public View build() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        if (this.mDivider) {
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.setMinimumHeight((int) UIUtils.convertDpToPixel(1.0f, this.mContext));
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this.mContext, C0658R.attr.material_drawer_divider, C0658R.C0659color.material_drawer_divider));
            linearLayout.addView(linearLayout2);
        }
        Iterator<IDrawerItem> it = this.mDrawerItems.iterator();
        while (it.hasNext()) {
            IDrawerItem next = it.next();
            View generateView = next.generateView(this.mContext);
            generateView.setTag(next);
            if (next.isEnabled()) {
                generateView.setBackgroundResource(UIUtils.getSelectableBackgroundRes(this.mContext));
                generateView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (DrawerItemViewHelper.this.mOnDrawerItemClickListener != null) {
                            DrawerItemViewHelper.this.mOnDrawerItemClickListener.onItemClick(view, (IDrawerItem) view.getTag());
                        }
                    }
                });
            }
            linearLayout.addView(generateView);
        }
        return linearLayout;
    }
}
