package com.mikepenz.materialdrawer.holder;

import android.support.annotation.StringRes;

public class StringHolder extends com.mikepenz.materialize.holder.StringHolder {
    public StringHolder(CharSequence charSequence) {
        super(charSequence);
    }

    public StringHolder(@StringRes int i) {
        super(i);
    }
}
