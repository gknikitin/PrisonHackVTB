package com.google.android.gms.internal.measurement;

final class zzyx {
    private static final Class<?> zzbrf = zzff("libcore.io.Memory");
    private static final boolean zzbrg = (zzff("org.robolectric.Robolectric") != null);

    private static <T> Class<T> zzff(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzte() {
        return zzbrf != null && !zzbrg;
    }

    static Class<?> zztf() {
        return zzbrf;
    }
}
