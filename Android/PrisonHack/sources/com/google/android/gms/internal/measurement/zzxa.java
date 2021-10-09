package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzxa extends zzwu<Boolean> {
    zzxa(zzxe zzxe, String str, Boolean bool) {
        super(zzxe, str, bool, (zzwy) null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzex(String str) {
        if (zzwp.zzbmu.matcher(str).matches()) {
            return true;
        }
        if (zzwp.zzbmv.matcher(str).matches()) {
            return false;
        }
        String str2 = this.zzbns;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
