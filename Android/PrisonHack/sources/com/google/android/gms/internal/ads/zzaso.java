package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbo;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzw;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzaso {
    public static zzaqw zza(Context context, zzasi zzasi, String str, boolean z, boolean z2, @Nullable zzci zzci, zzang zzang, zznx zznx, zzbo zzbo, zzw zzw, zzhs zzhs) throws zzarg {
        try {
            return (zzaqw) zzaml.zzb(new zzasp(context, zzasi, str, z, z2, zzci, zzang, zznx, zzbo, zzw, zzhs));
        } catch (Throwable th) {
            Throwable th2 = th;
            zzbv.zzeo().zza(th2, "AdWebViewFactory.newAdWebView2");
            throw new zzarg("Webview initialization failed.", th2);
        }
    }
}
