package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzadh
final class zzasy {
    @GuardedBy("InvokeJavascriptWorkaround.class")
    @VisibleForTesting
    private static Boolean zzdfk;

    private zzasy() {
    }

    @TargetApi(19)
    static void zza(WebView webView, String str) {
        if (!PlatformVersion.isAtLeastKitKat() || !zzb(webView)) {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        webView.evaluateJavascript(str, (ValueCallback) null);
    }

    @TargetApi(19)
    private static boolean zzb(WebView webView) {
        boolean booleanValue;
        synchronized (zzasy.class) {
            if (zzdfk == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", (ValueCallback) null);
                    zzdfk = true;
                } catch (IllegalStateException unused) {
                    zzdfk = false;
                }
            }
            booleanValue = zzdfk.booleanValue();
        }
        return booleanValue;
    }
}
