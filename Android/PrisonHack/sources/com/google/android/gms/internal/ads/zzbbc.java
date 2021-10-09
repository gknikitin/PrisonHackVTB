package com.google.android.gms.internal.ads;

import android.support.p000v4.internal.view.SupportMenu;

final class zzbbc {
    private final int number;
    private final Object object;

    zzbbc(Object obj, int i) {
        this.object = obj;
        this.number = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbbc)) {
            return false;
        }
        zzbbc zzbbc = (zzbbc) obj;
        return this.object == zzbbc.object && this.number == zzbbc.number;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
    }
}
