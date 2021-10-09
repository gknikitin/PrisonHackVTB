package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;

public final class zzgy {
    final long value;
    final String zzajf;
    final int zzajg;

    zzgy(long j, String str, int i) {
        this.value = j;
        this.zzajf = str;
        this.zzajg = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof zzgy)) {
            return false;
        }
        zzgy zzgy = (zzgy) obj;
        return zzgy.value == this.value && zzgy.zzajg == this.zzajg;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
