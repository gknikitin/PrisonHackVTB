package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

@zzadh
public final class zzakb extends zzane {
    /* renamed from: v */
    public static void m39v(String str) {
        if (zzqp()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzqp() {
        if (!isLoggable(2)) {
            return false;
        }
        return ((Boolean) zzkb.zzik().zzd(zznk.zzazr)).booleanValue();
    }
}
