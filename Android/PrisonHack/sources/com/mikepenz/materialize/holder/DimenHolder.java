package com.mikepenz.materialize.holder;

import android.content.Context;
import android.support.annotation.DimenRes;
import com.mikepenz.materialize.util.UIUtils;

public class DimenHolder {
    private int mDp = Integer.MIN_VALUE;
    private int mPixel = Integer.MIN_VALUE;
    private int mResource = Integer.MIN_VALUE;

    public int getPixel() {
        return this.mPixel;
    }

    public void setPixel(int i) {
        this.mPixel = i;
    }

    public int getDp() {
        return this.mDp;
    }

    public void setDp(int i) {
        this.mDp = i;
    }

    public int getResource() {
        return this.mResource;
    }

    public void setResource(int i) {
        this.mResource = i;
    }

    public static DimenHolder fromPixel(int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mPixel = i;
        return dimenHolder;
    }

    public static DimenHolder fromDp(int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mDp = i;
        return dimenHolder;
    }

    public static DimenHolder fromResource(@DimenRes int i) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mResource = i;
        return dimenHolder;
    }

    public int asPixel(Context context) {
        if (this.mPixel != Integer.MIN_VALUE) {
            return this.mPixel;
        }
        if (this.mDp != Integer.MIN_VALUE) {
            return (int) UIUtils.convertDpToPixel((float) this.mDp, context);
        }
        if (this.mResource != Integer.MIN_VALUE) {
            return context.getResources().getDimensionPixelSize(this.mResource);
        }
        return 0;
    }
}
