package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzadh
public final class zzqn extends NativeAppInstallAd {
    private final VideoController zzasv = new VideoController();
    private final zzqk zzbkn;
    private final List<NativeAd.Image> zzbko = new ArrayList();
    private final zzpz zzbkp;
    private final NativeAd.AdChoicesInfo zzbkq;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[Catch:{ RemoteException -> 0x0087 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzqn(com.google.android.gms.internal.ads.zzqk r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzbko = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzasv = r0
            r4.zzbkn = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzqk r0 = r4.zzbkn     // Catch:{ RemoteException -> 0x0055 }
            java.util.List r0 = r0.getImages()     // Catch:{ RemoteException -> 0x0055 }
            if (r0 == 0) goto L_0x005b
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x0055 }
        L_0x0020:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x0055 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0055 }
            if (r2 == 0) goto L_0x0047
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x0047
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x0055 }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzpw     // Catch:{ RemoteException -> 0x0055 }
            if (r3 == 0) goto L_0x0040
            r1 = r2
            com.google.android.gms.internal.ads.zzpw r1 = (com.google.android.gms.internal.ads.zzpw) r1     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0048
        L_0x0040:
            com.google.android.gms.internal.ads.zzpy r2 = new com.google.android.gms.internal.ads.zzpy     // Catch:{ RemoteException -> 0x0055 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r1 = r2
            goto L_0x0048
        L_0x0047:
            r1 = r5
        L_0x0048:
            if (r1 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.zzbko     // Catch:{ RemoteException -> 0x0055 }
            com.google.android.gms.internal.ads.zzpz r3 = new com.google.android.gms.internal.ads.zzpz     // Catch:{ RemoteException -> 0x0055 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0020
        L_0x0055:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzane.zzb(r1, r0)
        L_0x005b:
            com.google.android.gms.internal.ads.zzqk r0 = r4.zzbkn     // Catch:{ RemoteException -> 0x0069 }
            com.google.android.gms.internal.ads.zzpw r0 = r0.zzjz()     // Catch:{ RemoteException -> 0x0069 }
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzpz r1 = new com.google.android.gms.internal.ads.zzpz     // Catch:{ RemoteException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ RemoteException -> 0x0069 }
            goto L_0x0070
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzane.zzb(r1, r0)
        L_0x006f:
            r1 = r5
        L_0x0070:
            r4.zzbkp = r1
            com.google.android.gms.internal.ads.zzqk r0 = r4.zzbkn     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzps r0 = r0.zzkf()     // Catch:{ RemoteException -> 0x0087 }
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzpv r0 = new com.google.android.gms.internal.ads.zzpv     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzqk r1 = r4.zzbkn     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzps r1 = r1.zzkf()     // Catch:{ RemoteException -> 0x0087 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x0087 }
            r5 = r0
            goto L_0x008d
        L_0x0087:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzane.zzb(r1, r0)
        L_0x008d:
            r4.zzbkq = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqn.<init>(com.google.android.gms.internal.ads.zzqk):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzka */
    public final IObjectWrapper zzbe() {
        try {
            return this.zzbkn.zzka();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzbkn.destroy();
        } catch (RemoteException e) {
            zzane.zzb("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzbkq;
    }

    public final CharSequence getBody() {
        try {
            return this.zzbkn.getBody();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzbkn.getCallToAction();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzbkn.getExtras();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzbkn.getHeadline();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzbkp;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbko;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzbkn.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final CharSequence getPrice() {
        try {
            return this.zzbkn.getPrice();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzbkn.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final CharSequence getStore() {
        try {
            return this.zzbkn.getStore();
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzbkn.getVideoController() != null) {
                this.zzasv.zza(this.zzbkn.getVideoController());
            }
        } catch (RemoteException e) {
            zzane.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzasv;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzbkn.performClick(bundle);
        } catch (RemoteException e) {
            zzane.zzb("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzbkn.recordImpression(bundle);
        } catch (RemoteException e) {
            zzane.zzb("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzbkn.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzane.zzb("", e);
        }
    }
}
