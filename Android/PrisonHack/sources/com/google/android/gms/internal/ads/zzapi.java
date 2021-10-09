package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzapi extends FrameLayout implements zzapf {
    private final zzapw zzcxm;
    private final FrameLayout zzcxn;
    private final zznx zzcxo;
    private final zzapy zzcxp;
    private final long zzcxq;
    @Nullable
    private zzapg zzcxr;
    private boolean zzcxs;
    private boolean zzcxt;
    private boolean zzcxu;
    private boolean zzcxv;
    private long zzcxw;
    private long zzcxx;
    private String zzcxy;
    private Bitmap zzcxz;
    private ImageView zzcya;
    private boolean zzcyb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzapi(android.content.Context r11, com.google.android.gms.internal.ads.zzapw r12, int r13, boolean r14, com.google.android.gms.internal.ads.zznx r15, com.google.android.gms.internal.ads.zzapv r16) {
        /*
            r10 = this;
            r0 = r10
            r8 = r11
            r0.<init>(r8)
            r3 = r12
            r0.zzcxm = r3
            r6 = r15
            r0.zzcxo = r6
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r8)
            r0.zzcxn = r1
            android.widget.FrameLayout r1 = r0.zzcxn
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r9 = -1
            r2.<init>(r9, r9)
            r0.addView(r1, r2)
            com.google.android.gms.ads.internal.zzw r1 = r3.zzbi()
            com.google.android.gms.common.internal.Asserts.checkNotNull(r1)
            com.google.android.gms.ads.internal.zzw r1 = r3.zzbi()
            com.google.android.gms.internal.ads.zzaph r1 = r1.zzwz
            r2 = r8
            r4 = r13
            r5 = r14
            r7 = r16
            com.google.android.gms.internal.ads.zzapg r1 = r1.zza(r2, r3, r4, r5, r6, r7)
            r0.zzcxr = r1
            com.google.android.gms.internal.ads.zzapg r1 = r0.zzcxr
            if (r1 == 0) goto L_0x005c
            android.widget.FrameLayout r1 = r0.zzcxn
            com.google.android.gms.internal.ads.zzapg r2 = r0.zzcxr
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = 17
            r3.<init>(r9, r9, r4)
            r1.addView(r2, r3)
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzavg
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x005c
            r0.zztd()
        L_0x005c:
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r8)
            r0.zzcya = r1
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r1 = com.google.android.gms.internal.ads.zznk.zzavk
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.zzcxq = r1
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzavi
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.zzcxv = r1
            com.google.android.gms.internal.ads.zznx r1 = r0.zzcxo
            if (r1 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zznx r1 = r0.zzcxo
            java.lang.String r2 = "spinner_used"
            boolean r3 = r0.zzcxv
            if (r3 == 0) goto L_0x0096
            java.lang.String r3 = "1"
            goto L_0x0098
        L_0x0096:
            java.lang.String r3 = "0"
        L_0x0098:
            r1.zze(r2, r3)
        L_0x009b:
            com.google.android.gms.internal.ads.zzapy r1 = new com.google.android.gms.internal.ads.zzapy
            r1.<init>(r0)
            r0.zzcxp = r1
            com.google.android.gms.internal.ads.zzapg r1 = r0.zzcxr
            if (r1 == 0) goto L_0x00ab
            com.google.android.gms.internal.ads.zzapg r1 = r0.zzcxr
            r1.zza(r0)
        L_0x00ab:
            com.google.android.gms.internal.ads.zzapg r1 = r0.zzcxr
            if (r1 != 0) goto L_0x00b6
            java.lang.String r1 = "AdVideoUnderlay Error"
            java.lang.String r2 = "Allocating player failed."
            r0.zzg(r1, r2)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapi.<init>(android.content.Context, com.google.android.gms.internal.ads.zzapw, int, boolean, com.google.android.gms.internal.ads.zznx, com.google.android.gms.internal.ads.zzapv):void");
    }

    public static void zza(zzapw zzapw) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzapw.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzapw zzapw, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzapw.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzapw zzapw, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzapw.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzcxm.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    private final boolean zztf() {
        return this.zzcya.getParent() != null;
    }

    private final void zztg() {
        if (this.zzcxm.zzto() != null && this.zzcxt && !this.zzcxu) {
            this.zzcxm.zzto().getWindow().clearFlags(128);
            this.zzcxt = false;
        }
    }

    public final void destroy() {
        this.zzcxp.pause();
        if (this.zzcxr != null) {
            this.zzcxr.stop();
        }
        zztg();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzcxp.pause();
            if (this.zzcxr != null) {
                zzapg zzapg = this.zzcxr;
                Executor executor = zzaoe.zzcvy;
                zzapg.getClass();
                executor.execute(zzapj.zza(zzapg));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onPaused() {
        zza("pause", new String[0]);
        zztg();
        this.zzcxs = false;
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        if (i == 0) {
            this.zzcxp.resume();
            z = true;
        } else {
            this.zzcxp.pause();
            this.zzcxx = this.zzcxw;
            z = false;
        }
        zzakk.zzcrm.post(new zzapm(this, z));
    }

    public final void pause() {
        if (this.zzcxr != null) {
            this.zzcxr.pause();
        }
    }

    public final void play() {
        if (this.zzcxr != null) {
            this.zzcxr.play();
        }
    }

    public final void seekTo(int i) {
        if (this.zzcxr != null) {
            this.zzcxr.seekTo(i);
        }
    }

    public final void setVolume(float f) {
        if (this.zzcxr != null) {
            zzapg zzapg = this.zzcxr;
            zzapg.zzcxl.setVolume(f);
            zzapg.zzst();
        }
    }

    public final void zza(float f, float f2) {
        if (this.zzcxr != null) {
            this.zzcxr.zza(f, f2);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzcxn.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzdn(String str) {
        this.zzcxy = str;
    }

    public final void zzf(int i, int i2) {
        if (this.zzcxv) {
            int max = Math.max(i / ((Integer) zzkb.zzik().zzd(zznk.zzavj)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzkb.zzik().zzd(zznk.zzavj)).intValue(), 1);
            if (this.zzcxz == null || this.zzcxz.getWidth() != max || this.zzcxz.getHeight() != max2) {
                this.zzcxz = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzcyb = false;
            }
        }
    }

    @TargetApi(14)
    public final void zzf(MotionEvent motionEvent) {
        if (this.zzcxr != null) {
            this.zzcxr.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzg(String str, @Nullable String str2) {
        zza("error", "what", str, "extra", str2);
    }

    public final void zzsu() {
        this.zzcxp.resume();
        zzakk.zzcrm.post(new zzapk(this));
    }

    public final void zzsv() {
        if (this.zzcxr != null && this.zzcxx == 0) {
            zza("canplaythrough", "duration", String.valueOf(((float) this.zzcxr.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzcxr.getVideoWidth()), "videoHeight", String.valueOf(this.zzcxr.getVideoHeight()));
        }
    }

    public final void zzsw() {
        if (this.zzcxm.zzto() != null && !this.zzcxt) {
            this.zzcxu = (this.zzcxm.zzto().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzcxu) {
                this.zzcxm.zzto().getWindow().addFlags(128);
                this.zzcxt = true;
            }
        }
        this.zzcxs = true;
    }

    public final void zzsx() {
        zza("ended", new String[0]);
        zztg();
    }

    public final void zzsy() {
        if (this.zzcyb && this.zzcxz != null && !zztf()) {
            this.zzcya.setImageBitmap(this.zzcxz);
            this.zzcya.invalidate();
            this.zzcxn.addView(this.zzcya, new FrameLayout.LayoutParams(-1, -1));
            this.zzcxn.bringChildToFront(this.zzcya);
        }
        this.zzcxp.pause();
        this.zzcxx = this.zzcxw;
        zzakk.zzcrm.post(new zzapl(this));
    }

    public final void zzsz() {
        if (this.zzcxs && zztf()) {
            this.zzcxn.removeView(this.zzcya);
        }
        if (this.zzcxz != null) {
            long elapsedRealtime = zzbv.zzer().elapsedRealtime();
            if (this.zzcxr.getBitmap(this.zzcxz) != null) {
                this.zzcyb = true;
            }
            long elapsedRealtime2 = zzbv.zzer().elapsedRealtime() - elapsedRealtime;
            if (zzakb.zzqp()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzakb.m39v(sb.toString());
            }
            if (elapsedRealtime2 > this.zzcxq) {
                zzakb.zzdk("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzcxv = false;
                this.zzcxz = null;
                if (this.zzcxo != null) {
                    this.zzcxo.zze("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzta() {
        if (this.zzcxr != null) {
            if (!TextUtils.isEmpty(this.zzcxy)) {
                this.zzcxr.setVideoPath(this.zzcxy);
            } else {
                zza("no_src", new String[0]);
            }
        }
    }

    public final void zztb() {
        if (this.zzcxr != null) {
            zzapg zzapg = this.zzcxr;
            zzapg.zzcxl.setMuted(true);
            zzapg.zzst();
        }
    }

    public final void zztc() {
        if (this.zzcxr != null) {
            zzapg zzapg = this.zzcxr;
            zzapg.zzcxl.setMuted(false);
            zzapg.zzst();
        }
    }

    @TargetApi(14)
    public final void zztd() {
        if (this.zzcxr != null) {
            TextView textView = new TextView(this.zzcxr.getContext());
            String valueOf = String.valueOf(this.zzcxr.zzsp());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzcxn.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzcxn.bringChildToFront(textView);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzte() {
        if (this.zzcxr != null) {
            long currentPosition = (long) this.zzcxr.getCurrentPosition();
            if (this.zzcxw != currentPosition && currentPosition > 0) {
                zza("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzcxw = currentPosition;
            }
        }
    }
}
