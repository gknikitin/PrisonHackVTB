package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzaaq;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzakk;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzkb;
import com.google.android.gms.internal.ads.zznk;
import java.util.Collections;
import java.util.Map;

@zzadh
public class zzd extends zzaaq implements zzw {
    @VisibleForTesting
    private static final int zzbxm = Color.argb(0, 0, 0, 0);
    protected final Activity mActivity;
    @VisibleForTesting
    zzaqw zzbnd;
    @VisibleForTesting
    AdOverlayInfoParcel zzbxn;
    @VisibleForTesting
    private zzi zzbxo;
    @VisibleForTesting
    private zzo zzbxp;
    @VisibleForTesting
    private boolean zzbxq = false;
    @VisibleForTesting
    private FrameLayout zzbxr;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzbxs;
    @VisibleForTesting
    private boolean zzbxt = false;
    @VisibleForTesting
    private boolean zzbxu = false;
    @VisibleForTesting
    private zzh zzbxv;
    @VisibleForTesting
    private boolean zzbxw = false;
    @VisibleForTesting
    int zzbxx = 0;
    private final Object zzbxy = new Object();
    private Runnable zzbxz;
    private boolean zzbya;
    private boolean zzbyb;
    private boolean zzbyc = false;
    private boolean zzbyd = false;
    private boolean zzbye = true;

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    private final void zznl() {
        if (this.mActivity.isFinishing() && !this.zzbyc) {
            this.zzbyc = true;
            if (this.zzbnd != null) {
                this.zzbnd.zzai(this.zzbxx);
                synchronized (this.zzbxy) {
                    if (!this.zzbya && this.zzbnd.zzun()) {
                        this.zzbxz = new zzf(this);
                        zzakk.zzcrm.postDelayed(this.zzbxz, ((Long) zzkb.zzik().zzd(zznk.zzayq)).longValue());
                        return;
                    }
                }
            }
            zznm();
        }
    }

    private final void zzno() {
        this.zzbnd.zzno();
    }

    private final void zzs(boolean z) {
        int intValue = ((Integer) zzkb.zzik().zzd(zznk.zzben)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzbxp = new zzo(this.mActivity, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzbxn.zzbyr);
        this.zzbxv.addView(this.zzbxp, layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        if (r1.mActivity.getResources().getConfiguration().orientation == 1) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        if (r1.mActivity.getResources().getConfiguration().orientation == 2) goto L_0x00d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013c A[SYNTHETIC, Splitter:B:61:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(boolean r20) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r19 = this;
            r1 = r19
            boolean r3 = r1.zzbyb
            r4 = 1
            if (r3 != 0) goto L_0x000c
            android.app.Activity r3 = r1.mActivity
            r3.requestWindowFeature(r4)
        L_0x000c:
            android.app.Activity r3 = r1.mActivity
            android.view.Window r3 = r3.getWindow()
            if (r3 != 0) goto L_0x001c
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "Invalid activity, no window available."
            r2.<init>(r3)
            throw r2
        L_0x001c:
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastN()
            if (r5 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zznk.zzbel
            com.google.android.gms.internal.ads.zzni r6 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r5 = r6.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0048
            com.google.android.gms.ads.internal.zzbv.zzek()
            android.app.Activity r5 = r1.mActivity
            android.app.Activity r6 = r1.mActivity
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            boolean r5 = com.google.android.gms.internal.ads.zzakk.zza((android.app.Activity) r5, (android.content.res.Configuration) r6)
            goto L_0x0049
        L_0x0048:
            r5 = 1
        L_0x0049:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzbxn
            com.google.android.gms.ads.internal.zzaq r6 = r6.zzbyw
            r7 = 0
            if (r6 == 0) goto L_0x005a
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzbxn
            com.google.android.gms.ads.internal.zzaq r6 = r6.zzbyw
            boolean r6 = r6.zzzf
            if (r6 == 0) goto L_0x005a
            r6 = 1
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            boolean r8 = r1.zzbxu
            if (r8 == 0) goto L_0x0061
            if (r6 == 0) goto L_0x0097
        L_0x0061:
            if (r5 == 0) goto L_0x0097
            r5 = 1024(0x400, float:1.435E-42)
            r3.setFlags(r5, r5)
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zznk.zzayr
            com.google.android.gms.internal.ads.zzni r6 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r5 = r6.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0097
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastKitKat()
            if (r5 == 0) goto L_0x0097
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzbxn
            com.google.android.gms.ads.internal.zzaq r5 = r5.zzbyw
            if (r5 == 0) goto L_0x0097
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzbxn
            com.google.android.gms.ads.internal.zzaq r5 = r5.zzbyw
            boolean r5 = r5.zzzk
            if (r5 == 0) goto L_0x0097
            android.view.View r5 = r3.getDecorView()
            r6 = 4098(0x1002, float:5.743E-42)
            r5.setSystemUiVisibility(r6)
        L_0x0097:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r5 = r5.zzbyo
            r6 = 0
            if (r5 == 0) goto L_0x00a7
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r5 = r5.zzbyo
            com.google.android.gms.internal.ads.zzasc r5 = r5.zzuf()
            goto L_0x00a8
        L_0x00a7:
            r5 = r6
        L_0x00a8:
            if (r5 == 0) goto L_0x00af
            boolean r5 = r5.zzfz()
            goto L_0x00b0
        L_0x00af:
            r5 = 0
        L_0x00b0:
            r1.zzbxw = r7
            if (r5 == 0) goto L_0x00f2
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r1.zzbxn
            int r8 = r8.orientation
            com.google.android.gms.internal.ads.zzakq r9 = com.google.android.gms.ads.internal.zzbv.zzem()
            int r9 = r9.zzrl()
            if (r8 != r9) goto L_0x00d4
            android.app.Activity r8 = r1.mActivity
            android.content.res.Resources r8 = r8.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            int r8 = r8.orientation
            if (r8 != r4) goto L_0x00d1
        L_0x00d0:
            r7 = 1
        L_0x00d1:
            r1.zzbxw = r7
            goto L_0x00f2
        L_0x00d4:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r1.zzbxn
            int r8 = r8.orientation
            com.google.android.gms.internal.ads.zzakq r9 = com.google.android.gms.ads.internal.zzbv.zzem()
            int r9 = r9.zzrm()
            if (r8 != r9) goto L_0x00f2
            android.app.Activity r8 = r1.mActivity
            android.content.res.Resources r8 = r8.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            int r8 = r8.orientation
            r9 = 2
            if (r8 != r9) goto L_0x00d1
            goto L_0x00d0
        L_0x00f2:
            boolean r7 = r1.zzbxw
            r8 = 46
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = "Delay onShow to next orientation change: "
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            com.google.android.gms.internal.ads.zzakb.zzck(r7)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r7 = r1.zzbxn
            int r7 = r7.orientation
            r1.setRequestedOrientation(r7)
            com.google.android.gms.internal.ads.zzakq r7 = com.google.android.gms.ads.internal.zzbv.zzem()
            boolean r3 = r7.zza((android.view.Window) r3)
            if (r3 == 0) goto L_0x0120
            java.lang.String r3 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.internal.ads.zzakb.zzck(r3)
        L_0x0120:
            boolean r3 = r1.zzbxu
            if (r3 != 0) goto L_0x012c
            com.google.android.gms.ads.internal.overlay.zzh r3 = r1.zzbxv
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0128:
            r3.setBackgroundColor(r7)
            goto L_0x0131
        L_0x012c:
            com.google.android.gms.ads.internal.overlay.zzh r3 = r1.zzbxv
            int r7 = zzbxm
            goto L_0x0128
        L_0x0131:
            android.app.Activity r3 = r1.mActivity
            com.google.android.gms.ads.internal.overlay.zzh r7 = r1.zzbxv
            r3.setContentView(r7)
            r1.zzbyb = r4
            if (r20 == 0) goto L_0x0215
            com.google.android.gms.ads.internal.zzbv.zzel()     // Catch:{ Exception -> 0x0206 }
            android.app.Activity r8 = r1.mActivity     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            if (r3 == 0) goto L_0x0151
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzasi r3 = r3.zzud()     // Catch:{ Exception -> 0x0206 }
            r9 = r3
            goto L_0x0152
        L_0x0151:
            r9 = r6
        L_0x0152:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            if (r3 == 0) goto L_0x0162
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            java.lang.String r3 = r3.zzue()     // Catch:{ Exception -> 0x0206 }
            r10 = r3
            goto L_0x0163
        L_0x0162:
            r10 = r6
        L_0x0163:
            r11 = 1
            r13 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzang r14 = r3.zzacr     // Catch:{ Exception -> 0x0206 }
            r15 = 0
            r16 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            if (r3 == 0) goto L_0x017d
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.ads.internal.zzw r3 = r3.zzbi()     // Catch:{ Exception -> 0x0206 }
            r17 = r3
            goto L_0x017f
        L_0x017d:
            r17 = r6
        L_0x017f:
            com.google.android.gms.internal.ads.zzhs r18 = com.google.android.gms.internal.ads.zzhs.zzhm()     // Catch:{ Exception -> 0x0206 }
            r12 = r5
            com.google.android.gms.internal.ads.zzaqw r3 = com.google.android.gms.internal.ads.zzarc.zza(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0206 }
            r1.zzbnd = r3     // Catch:{ Exception -> 0x0206 }
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            com.google.android.gms.internal.ads.zzasc r7 = r3.zzuf()
            r8 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.ads.internal.gmsg.zzb r9 = r3.zzbyx
            r10 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.ads.internal.gmsg.zzd r11 = r3.zzbyp
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.ads.internal.overlay.zzt r12 = r3.zzbyt
            r13 = 1
            r14 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo
            if (r3 == 0) goto L_0x01b2
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo
            com.google.android.gms.internal.ads.zzasc r3 = r3.zzuf()
            com.google.android.gms.ads.internal.zzx r6 = r3.zzut()
        L_0x01b2:
            r15 = r6
            r16 = 0
            r17 = 0
            r7.zza(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            com.google.android.gms.internal.ads.zzasc r3 = r3.zzuf()
            com.google.android.gms.ads.internal.overlay.zze r6 = new com.google.android.gms.ads.internal.overlay.zze
            r6.<init>(r1)
            r3.zza((com.google.android.gms.internal.ads.zzasd) r6)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            java.lang.String r3 = r3.url
            if (r3 == 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzbxn
            java.lang.String r6 = r6.url
            r3.loadUrl(r6)
            goto L_0x01f0
        L_0x01d8:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            java.lang.String r3 = r3.zzbys
            if (r3 == 0) goto L_0x01fe
            com.google.android.gms.internal.ads.zzaqw r6 = r1.zzbnd
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            java.lang.String r7 = r3.zzbyq
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            java.lang.String r8 = r3.zzbys
            java.lang.String r9 = "text/html"
            java.lang.String r10 = "UTF-8"
            r11 = 0
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
        L_0x01f0:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo
            if (r3 == 0) goto L_0x0222
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo
            r3.zzb((com.google.android.gms.ads.internal.overlay.zzd) r1)
            goto L_0x0222
        L_0x01fe:
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "No URL or HTML to display in ad overlay."
            r2.<init>(r3)
            throw r2
        L_0x0206:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Error obtaining webview."
            com.google.android.gms.internal.ads.zzakb.zzb(r3, r2)
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "Could not obtain webview for the overlay."
            r2.<init>(r3)
            throw r2
        L_0x0215:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzbxn
            com.google.android.gms.internal.ads.zzaqw r3 = r3.zzbyo
            r1.zzbnd = r3
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            android.app.Activity r6 = r1.mActivity
            r3.zzbm(r6)
        L_0x0222:
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            r3.zza((com.google.android.gms.ads.internal.overlay.zzd) r1)
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            android.view.ViewParent r3 = r3.getParent()
            if (r3 == 0) goto L_0x023e
            boolean r6 = r3 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x023e
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            com.google.android.gms.internal.ads.zzaqw r6 = r1.zzbnd
            android.view.View r6 = r6.getView()
            r3.removeView(r6)
        L_0x023e:
            boolean r3 = r1.zzbxu
            if (r3 == 0) goto L_0x0247
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd
            r3.zzur()
        L_0x0247:
            com.google.android.gms.ads.internal.overlay.zzh r3 = r1.zzbxv
            com.google.android.gms.internal.ads.zzaqw r6 = r1.zzbnd
            android.view.View r6 = r6.getView()
            r7 = -1
            r3.addView(r6, r7, r7)
            if (r20 != 0) goto L_0x025c
            boolean r2 = r1.zzbxw
            if (r2 != 0) goto L_0x025c
            r19.zzno()
        L_0x025c:
            r1.zzs(r5)
            com.google.android.gms.internal.ads.zzaqw r2 = r1.zzbnd
            boolean r2 = r2.zzuh()
            if (r2 == 0) goto L_0x026a
            r1.zza((boolean) r5, (boolean) r4)
        L_0x026a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.zzt(boolean):void");
    }

    public final void close() {
        this.zzbxx = 2;
        this.mActivity.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzbxx = 0;
    }

    public void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzbxt = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzbxn = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
            if (this.zzbxn == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (this.zzbxn.zzacr.zzcvf > 7500000) {
                this.zzbxx = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzbye = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzbxn.zzbyw != null) {
                this.zzbxu = this.zzbxn.zzbyw.zzze;
            } else {
                this.zzbxu = false;
            }
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbbg)).booleanValue() && this.zzbxu && this.zzbxn.zzbyw.zzzj != -1) {
                new zzj(this, (zzf) null).zzqo();
            }
            if (bundle == null) {
                if (this.zzbxn.zzbyn != null && this.zzbye) {
                    this.zzbxn.zzbyn.zzcc();
                }
                if (!(this.zzbxn.zzbyu == 1 || this.zzbxn.zzbym == null)) {
                    this.zzbxn.zzbym.onAdClicked();
                }
            }
            this.zzbxv = new zzh(this.mActivity, this.zzbxn.zzbyv, this.zzbxn.zzacr.zzcw);
            this.zzbxv.setId(1000);
            switch (this.zzbxn.zzbyu) {
                case 1:
                    zzt(false);
                    return;
                case 2:
                    this.zzbxo = new zzi(this.zzbxn.zzbyo);
                    zzt(false);
                    return;
                case 3:
                    zzt(true);
                    return;
                default:
                    throw new zzg("Could not determine ad overlay type.");
            }
        } catch (zzg e) {
            zzakb.zzdk(e.getMessage());
            this.zzbxx = 3;
            this.mActivity.finish();
        }
    }

    public final void onDestroy() {
        if (this.zzbnd != null) {
            this.zzbxv.removeView(this.zzbnd.getView());
        }
        zznl();
    }

    public final void onPause() {
        zznh();
        if (this.zzbxn.zzbyn != null) {
            this.zzbxn.zzbyn.onPause();
        }
        if (!((Boolean) zzkb.zzik().zzd(zznk.zzbem)).booleanValue() && this.zzbnd != null && (!this.mActivity.isFinishing() || this.zzbxo == null)) {
            zzbv.zzem();
            zzakq.zzi(this.zzbnd);
        }
        zznl();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.zzbxn.zzbyn != null) {
            this.zzbxn.zzbyn.onResume();
        }
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbem)).booleanValue()) {
            return;
        }
        if (this.zzbnd == null || this.zzbnd.isDestroyed()) {
            zzakb.zzdk("The webview does not exist. Ignoring action.");
            return;
        }
        zzbv.zzem();
        zzakq.zzj(this.zzbnd);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzbxt);
    }

    public final void onStart() {
        if (!((Boolean) zzkb.zzik().zzd(zznk.zzbem)).booleanValue()) {
            return;
        }
        if (this.zzbnd == null || this.zzbnd.isDestroyed()) {
            zzakb.zzdk("The webview does not exist. Ignoring action.");
            return;
        }
        zzbv.zzem();
        zzakq.zzj(this.zzbnd);
    }

    public final void onStop() {
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbem)).booleanValue() && this.zzbnd != null && (!this.mActivity.isFinishing() || this.zzbxo == null)) {
            zzbv.zzem();
            zzakq.zzi(this.zzbnd);
        }
        zznl();
    }

    public final void setRequestedOrientation(int i) {
        if (this.mActivity.getApplicationInfo().targetSdkVersion >= ((Integer) zzkb.zzik().zzd(zznk.zzbfs)).intValue()) {
            if (this.mActivity.getApplicationInfo().targetSdkVersion <= ((Integer) zzkb.zzik().zzd(zznk.zzbft)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzkb.zzik().zzd(zznk.zzbfu)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzkb.zzik().zzd(zznk.zzbfv)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.mActivity.setRequestedOrientation(i);
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzbxr = new FrameLayout(this.mActivity);
        this.zzbxr.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzbxr.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzbxr);
        this.zzbyb = true;
        this.zzbxs = customViewCallback;
        this.zzbxq = true;
    }

    public final void zza(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = ((Boolean) zzkb.zzik().zzd(zznk.zzays)).booleanValue() && this.zzbxn != null && this.zzbxn.zzbyw != null && this.zzbxn.zzbyw.zzzl;
        boolean z5 = ((Boolean) zzkb.zzik().zzd(zznk.zzayt)).booleanValue() && this.zzbxn != null && this.zzbxn.zzbyw != null && this.zzbxn.zzbyw.zzzm;
        if (z && z2 && z4 && !z5) {
            new zzaal(this.zzbnd, "useCustomClose").zzbw("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.zzbxp != null) {
            zzo zzo = this.zzbxp;
            if (z5 || (z2 && !z4)) {
                z3 = true;
            }
            zzo.zzu(z3);
        }
    }

    public final void zzax() {
        this.zzbyb = true;
    }

    public final void zznh() {
        if (this.zzbxn != null && this.zzbxq) {
            setRequestedOrientation(this.zzbxn.orientation);
        }
        if (this.zzbxr != null) {
            this.mActivity.setContentView(this.zzbxv);
            this.zzbyb = true;
            this.zzbxr.removeAllViews();
            this.zzbxr = null;
        }
        if (this.zzbxs != null) {
            this.zzbxs.onCustomViewHidden();
            this.zzbxs = null;
        }
        this.zzbxq = false;
    }

    public final void zzni() {
        this.zzbxx = 1;
        this.mActivity.finish();
    }

    public final boolean zznj() {
        this.zzbxx = 0;
        if (this.zzbnd == null) {
            return true;
        }
        boolean zzul = this.zzbnd.zzul();
        if (!zzul) {
            this.zzbnd.zza("onbackblocked", (Map<String, ?>) Collections.emptyMap());
        }
        return zzul;
    }

    public final void zznk() {
        this.zzbxv.removeView(this.zzbxp);
        zzs(true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zznm() {
        if (!this.zzbyd) {
            this.zzbyd = true;
            if (this.zzbnd != null) {
                this.zzbxv.removeView(this.zzbnd.getView());
                if (this.zzbxo != null) {
                    this.zzbnd.zzbm(this.zzbxo.zzrt);
                    this.zzbnd.zzai(false);
                    this.zzbxo.parent.addView(this.zzbnd.getView(), this.zzbxo.index, this.zzbxo.zzbyi);
                    this.zzbxo = null;
                } else if (this.mActivity.getApplicationContext() != null) {
                    this.zzbnd.zzbm(this.mActivity.getApplicationContext());
                }
                this.zzbnd = null;
            }
            if (this.zzbxn != null && this.zzbxn.zzbyn != null) {
                this.zzbxn.zzbyn.zzcb();
            }
        }
    }

    public final void zznn() {
        if (this.zzbxw) {
            this.zzbxw = false;
            zzno();
        }
    }

    public final void zznp() {
        this.zzbxv.zzbyh = true;
    }

    public final void zznq() {
        synchronized (this.zzbxy) {
            this.zzbya = true;
            if (this.zzbxz != null) {
                zzakk.zzcrm.removeCallbacks(this.zzbxz);
                zzakk.zzcrm.post(this.zzbxz);
            }
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbel)).booleanValue() && PlatformVersion.isAtLeastN()) {
            zzbv.zzek();
            if (zzakk.zza(this.mActivity, (Configuration) ObjectWrapper.unwrap(iObjectWrapper))) {
                this.mActivity.getWindow().addFlags(1024);
                this.mActivity.getWindow().clearFlags(2048);
                return;
            }
            this.mActivity.getWindow().addFlags(2048);
            this.mActivity.getWindow().clearFlags(1024);
        }
    }
}
