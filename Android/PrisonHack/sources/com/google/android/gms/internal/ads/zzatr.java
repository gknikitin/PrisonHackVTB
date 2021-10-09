package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzatr implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    @VisibleForTesting
    private zzats zzdgz;
    private final String zzdha;
    private final LinkedBlockingQueue<zzba> zzdhb;
    private final HandlerThread zzdhc = new HandlerThread("GassClient");

    public zzatr(Context context, String str, String str2) {
        this.packageName = str;
        this.zzdha = str2;
        this.zzdhc.start();
        this.zzdgz = new zzats(context, this.zzdhc.getLooper(), this, this);
        this.zzdhb = new LinkedBlockingQueue<>();
        this.zzdgz.checkAvailabilityAndConnect();
    }

    private final void zznz() {
        if (this.zzdgz == null) {
            return;
        }
        if (this.zzdgz.isConnected() || this.zzdgz.isConnecting()) {
            this.zzdgz.disconnect();
        }
    }

    private final zzatx zzwb() {
        try {
            return this.zzdgz.zzwd();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzba zzwc() {
        zzba zzba = new zzba();
        zzba.zzdu = Long.valueOf(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return zzba;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        zznz();
        r3.zzdhc.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A[ExcHandler: all (r4v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzatx r4 = r3.zzwb()
            if (r4 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzatt r0 = new com.google.android.gms.internal.ads.zzatt     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r2 = r3.zzdha     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzatv r4 = r4.zza(r0)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzba r4 = r4.zzwe()     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzba> r0 = r3.zzdhb     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.put(r4)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        L_0x001c:
            r3.zznz()
            android.os.HandlerThread r4 = r3.zzdhc
            r4.quit()
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0031
        L_0x0027:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzba> r4 = r3.zzdhb     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzba r0 = zzwc()     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            goto L_0x001c
        L_0x0031:
            r3.zznz()
            android.os.HandlerThread r0 = r3.zzdhc
            r0.quit()
            throw r4
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatr.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzdhb.put(zzwc());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzdhb.put(zzwc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzba zzak(int i) {
        zzba zzba;
        try {
            zzba = this.zzdhb.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzba = null;
        }
        return zzba == null ? zzwc() : zzba;
    }
}
