package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;

final class zzvb implements Runnable {
    private final /* synthetic */ String zzbpt;
    private final /* synthetic */ zzuw zzbpu;

    zzvb(zzuw zzuw, String str) {
        this.zzbpu = zzuw;
        this.zzbpt = str;
    }

    public final void run() {
        this.zzbpu.zzbnd.loadData(this.zzbpt, "text/html", Key.STRING_CHARSET_NAME);
    }
}
