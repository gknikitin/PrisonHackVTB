package com.google.android.gms.internal.measurement;

final class zzzj {
    private static final Class<?> zzbrv = zztk();

    private static final zzzk zzfh(String str) throws Exception {
        return (zzzk) zzbrv.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    private static Class<?> zztk() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzzk zztl() {
        if (zzbrv != null) {
            try {
                return zzfh("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzzk.zzbry;
    }
}
