package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;

@zzadh
public final class zznq {
    public static boolean zza(@Nullable zznx zznx, @Nullable zznv zznv, String... strArr) {
        if (zznx == null || zznv == null) {
            return false;
        }
        return zznx.zza(zznv, strArr);
    }

    @Nullable
    public static zznv zzb(@Nullable zznx zznx) {
        if (zznx == null) {
            return null;
        }
        return zznx.zzjj();
    }
}
