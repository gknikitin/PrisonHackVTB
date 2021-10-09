package com.mikepenz.iconics.context;

import android.content.Context;
import android.support.p003v7.view.menu.ActionMenuItemView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.C0634R;

class IconicsFactory {
    IconicsFactory() {
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) {
        if (!(view == null || view.getTag(C0634R.C0637id.iconics_tag_id) == Boolean.TRUE)) {
            onViewCreatedInternal(view, context, attributeSet);
            view.setTag(C0634R.C0637id.iconics_tag_id, Boolean.TRUE);
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public void onViewCreatedInternal(View view, final Context context, AttributeSet attributeSet) {
        IconicsDrawable iconicsDrawable;
        if (attributeSet != null) {
            if (view instanceof ActionMenuItemView) {
                IconicsDrawable iconicsDrawable2 = IconicsAttrsApplier.getIconicsDrawable(context, attributeSet);
                if (iconicsDrawable2 != null) {
                    ((ActionMenuItemView) view).setIcon(iconicsDrawable2);
                }
            } else if (view instanceof EditText) {
                new Iconics.IconicsBuilder().ctx(context).mo17752on((TextView) view).build();
            } else if (view instanceof TextView) {
                TextView textView = (TextView) view;
                new Iconics.IconicsBuilder().ctx(context).mo17752on(textView).build();
                textView.addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void afterTextChanged(Editable editable) {
                        Iconics.styleEditable(context, editable);
                    }
                });
            } else if ((view instanceof ImageView) && (iconicsDrawable = IconicsAttrsApplier.getIconicsDrawable(context, attributeSet)) != null) {
                ((ImageView) view).setImageDrawable(iconicsDrawable);
            }
        }
    }
}
