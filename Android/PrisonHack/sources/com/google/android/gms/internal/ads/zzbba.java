package com.google.android.gms.internal.ads;

final class zzbba {
    private static final Class<?> zzdqq = zzaco();

    private static Class<?> zzaco() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzbbb zzacp() {
        if (zzdqq != null) {
            try {
                return (zzbbb) zzdqq.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzbbb.zzdqt;
    }
}
