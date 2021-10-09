package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwz extends zzwu<Integer> {
    zzwz(zzxe zzxe, String str, Integer num) {
        super(zzxe, str, num, (zzwy) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzez */
    public final Integer zzex(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbns;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
            sb.append("Invalid integer value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
