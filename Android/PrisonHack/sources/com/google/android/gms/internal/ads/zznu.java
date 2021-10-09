package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.text.TextUtils;

final class zznu extends zznr {
    zznu() {
    }

    @Nullable
    private static String zzam(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public final String zzd(@Nullable String str, String str2) {
        String zzam = zzam(str);
        String zzam2 = zzam(str2);
        if (TextUtils.isEmpty(zzam)) {
            return zzam2;
        }
        if (TextUtils.isEmpty(zzam2)) {
            return zzam;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzam).length() + 1 + String.valueOf(zzam2).length());
        sb.append(zzam);
        sb.append(",");
        sb.append(zzam2);
        return sb.toString();
    }
}
