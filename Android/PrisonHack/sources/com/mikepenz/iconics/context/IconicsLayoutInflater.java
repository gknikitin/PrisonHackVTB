package com.mikepenz.iconics.context;

import android.content.Context;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p003v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

public class IconicsLayoutInflater implements LayoutInflaterFactory {
    private AppCompatDelegate appCompatDelegate;
    private final IconicsFactory mIconicsFactory = new IconicsFactory();

    public IconicsLayoutInflater(AppCompatDelegate appCompatDelegate2) {
        this.appCompatDelegate = appCompatDelegate2;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mIconicsFactory.onViewCreated(this.appCompatDelegate.createView(view, str, context, attributeSet), context, attributeSet);
    }
}
