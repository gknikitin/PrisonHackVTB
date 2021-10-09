package com.mikepenz.iconics;

import android.graphics.Typeface;
import android.util.Pair;
import com.mikepenz.iconics.typeface.IIcon;
import java.util.ArrayList;

public class IconicsArrayBuilder {
    private IconicsDrawable mIconBase;
    private ArrayList<Pair<Object, Typeface>> mIcons = new ArrayList<>();

    public IconicsArrayBuilder(IconicsDrawable iconicsDrawable) {
        this.mIconBase = iconicsDrawable;
    }

    public IconicsArrayBuilder add(IIcon iIcon) {
        this.mIcons.add(Pair.create(iIcon, (Typeface) null));
        return this;
    }

    public IconicsArrayBuilder add(String str) {
        return add(str, Typeface.DEFAULT);
    }

    public IconicsArrayBuilder add(Character ch) {
        return add(ch, Typeface.DEFAULT);
    }

    public IconicsArrayBuilder add(String str, Typeface typeface) {
        this.mIcons.add(Pair.create(str, typeface));
        return this;
    }

    public IconicsArrayBuilder add(Character ch, Typeface typeface) {
        this.mIcons.add(Pair.create(ch, typeface));
        return this;
    }

    public IconicsDrawable[] build() {
        IconicsDrawable[] iconicsDrawableArr = new IconicsDrawable[this.mIcons.size()];
        for (int i = 0; i < this.mIcons.size(); i++) {
            Pair pair = this.mIcons.get(i);
            if (pair.first instanceof IIcon) {
                iconicsDrawableArr[i] = this.mIconBase.clone().icon((IIcon) pair.first);
            } else if (pair.first instanceof Character) {
                iconicsDrawableArr[i] = this.mIconBase.clone().icon((Character) pair.first, (Typeface) pair.second);
            } else if (pair.first instanceof String) {
                iconicsDrawableArr[i] = this.mIconBase.clone().iconText((String) pair.first, (Typeface) pair.second);
            }
        }
        return iconicsDrawableArr;
    }
}
