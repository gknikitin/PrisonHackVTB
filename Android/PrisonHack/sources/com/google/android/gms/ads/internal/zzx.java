package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzakk;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzx {
    private final Context mContext;
    private boolean zzxc;
    private zzait zzxd;
    private zzael zzxe;

    public zzx(Context context, zzait zzait, zzael zzael) {
        this.mContext = context;
        this.zzxd = zzait;
        this.zzxe = zzael;
        if (this.zzxe == null) {
            this.zzxe = new zzael();
        }
    }

    private final boolean zzcx() {
        return (this.zzxd != null && this.zzxd.zzpg().zzcni) || this.zzxe.zzcfr;
    }

    public final void recordClick() {
        this.zzxc = true;
    }

    public final boolean zzcy() {
        return !zzcx() || this.zzxc;
    }

    public final void zzs(@Nullable String str) {
        if (zzcx()) {
            if (str == null) {
                str = "";
            }
            if (this.zzxd != null) {
                this.zzxd.zza(str, (Map<String, String>) null, 3);
            } else if (this.zzxe.zzcfr && this.zzxe.zzcfs != null) {
                for (String next : this.zzxe.zzcfs) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzbv.zzek();
                        zzakk.zzd(this.mContext, "", replace);
                    }
                }
            }
        }
    }
}
