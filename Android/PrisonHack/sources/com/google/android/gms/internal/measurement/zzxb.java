package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzxb extends zzwu<Double> {
    zzxb(zzxe zzxe, String str, Double d) {
        super(zzxe, str, d, (zzwy) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfa */
    public final Double zzex(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            String str2 = this.zzbns;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid double value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
