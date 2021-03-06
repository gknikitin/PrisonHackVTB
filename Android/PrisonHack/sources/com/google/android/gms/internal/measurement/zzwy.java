package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwy extends zzwu<Long> {
    zzwy(zzxe zzxe, String str, Long l) {
        super(zzxe, str, l, (zzwy) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzey */
    public final Long zzex(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbns;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length());
            sb.append("Invalid long value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
