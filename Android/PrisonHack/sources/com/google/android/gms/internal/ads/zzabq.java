package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@TargetApi(19)
public final class zzabq extends zzabn {
    private Object zzbzn = new Object();
    @GuardedBy("mPopupWindowLock")
    private PopupWindow zzbzo;
    @GuardedBy("mPopupWindowLock")
    private boolean zzbzp = false;

    zzabq(Context context, zzaji zzaji, zzaqw zzaqw, zzabm zzabm) {
        super(context, zzaji, zzaqw, zzabm);
    }

    private final void zznv() {
        synchronized (this.zzbzn) {
            this.zzbzp = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzbzo = null;
            }
            if (this.zzbzo != null) {
                if (this.zzbzo.isShowing()) {
                    this.zzbzo.dismiss();
                }
                this.zzbzo = null;
            }
        }
    }

    public final void cancel() {
        zznv();
        super.cancel();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zznu() {
        /*
            r8 = this;
            android.content.Context r0 = r8.mContext
            boolean r0 = r0 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L_0x0010
            android.content.Context r0 = r8.mContext
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0070
            android.view.View r2 = r0.getDecorView()
            if (r2 != 0) goto L_0x001a
            return
        L_0x001a:
            android.content.Context r2 = r8.mContext
            android.app.Activity r2 = (android.app.Activity) r2
            boolean r2 = r2.isDestroyed()
            if (r2 == 0) goto L_0x0025
            return
        L_0x0025:
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            android.content.Context r3 = r8.mContext
            r2.<init>(r3)
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r4 = -1
            r3.<init>(r4, r4)
            r2.setLayoutParams(r3)
            com.google.android.gms.internal.ads.zzaqw r3 = r8.zzbnd
            android.view.View r3 = r3.getView()
            r2.addView(r3, r4, r4)
            java.lang.Object r3 = r8.zzbzn
            monitor-enter(r3)
            boolean r5 = r8.zzbzp     // Catch:{ all -> 0x006d }
            if (r5 == 0) goto L_0x0047
            monitor-exit(r3)     // Catch:{ all -> 0x006d }
            return
        L_0x0047:
            android.widget.PopupWindow r5 = new android.widget.PopupWindow     // Catch:{ all -> 0x006d }
            r6 = 0
            r7 = 1
            r5.<init>(r2, r7, r7, r6)     // Catch:{ all -> 0x006d }
            r8.zzbzo = r5     // Catch:{ all -> 0x006d }
            android.widget.PopupWindow r2 = r8.zzbzo     // Catch:{ all -> 0x006d }
            r2.setOutsideTouchable(r7)     // Catch:{ all -> 0x006d }
            android.widget.PopupWindow r2 = r8.zzbzo     // Catch:{ all -> 0x006d }
            r2.setClippingEnabled(r6)     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "Displaying the 1x1 popup off the screen."
            com.google.android.gms.internal.ads.zzakb.zzck(r2)     // Catch:{ all -> 0x006d }
            android.widget.PopupWindow r2 = r8.zzbzo     // Catch:{ Exception -> 0x0069 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x0069 }
            r2.showAtLocation(r0, r6, r4, r4)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006b
        L_0x0069:
            r8.zzbzo = r1     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r3)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006d }
            throw r0
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabq.zznu():void");
    }

    /* access modifiers changed from: protected */
    public final void zzz(int i) {
        zznv();
        super.zzz(i);
    }
}
