package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

public class IconicsContextWrapper extends ContextWrapper {
    private LayoutInflater mInflater;

    private IconicsContextWrapper(Context context) {
        super(context);
    }

    public static ContextWrapper wrap(Context context) {
        return new IconicsContextWrapper(context);
    }

    public Resources getResources() {
        return super.getResources();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = new InternalLayoutInflater(LayoutInflater.from(getBaseContext()), this, false);
        }
        return this.mInflater;
    }
}
