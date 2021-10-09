package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzbv;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class zzafn extends zzaeo {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static zzafn zzchh;
    private final Context mContext;
    private final zzafm zzchi;
    private final ScheduledExecutorService zzchj = Executors.newSingleThreadScheduledExecutor();

    private zzafn(Context context, zzafm zzafm) {
        this.mContext = context;
        this.zzchi = zzafm;
    }

    private static zzaej zza(Context context, zzafm zzafm, zzaef zzaef, ScheduledExecutorService scheduledExecutorService) {
        char c;
        String string;
        Context context2 = context;
        zzafm zzafm2 = zzafm;
        zzaef zzaef2 = zzaef;
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
        zzakb.zzck("Starting ad request from service using: google.afma.request.getAdDictionary");
        zznx zznx = new zznx(((Boolean) zzkb.zzik().zzd(zznk.zzawh)).booleanValue(), "load_ad", zzaef2.zzacv.zzarb);
        if (zzaef2.versionCode > 10 && zzaef2.zzcdl != -1) {
            zznx.zza(zznx.zzd(zzaef2.zzcdl), "cts");
        }
        zznv zzjj = zznx.zzjj();
        zzanz<V> zza = zzano.zza(zzafm2.zzche.zzk(context2), ((Long) zzkb.zzik().zzd(zznk.zzbdf)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService2);
        zzanz<V> zza2 = zzano.zza(zzafm2.zzchd.zzr(context2), ((Long) zzkb.zzik().zzd(zznk.zzbah)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService2);
        zzanz<String> zzcl = zzafm2.zzcgy.zzcl(zzaef2.zzccw.packageName);
        zzanz<String> zzcm = zzafm2.zzcgy.zzcm(zzaef2.zzccw.packageName);
        zzanz<String> zza3 = zzafm2.zzchf.zza(zzaef2.zzccx, zzaef2.zzccw);
        Future<zzaga> zzq = zzbv.zzev().zzq(context2);
        zzanz zzi = zzano.zzi(null);
        Bundle bundle = zzaef2.zzccv.extras;
        boolean z = (bundle == null || bundle.getString("_ad") == null) ? false : true;
        if (zzaef2.zzcdr && !z) {
            zzi = zzafm2.zzchb.zza(zzaef2.applicationInfo);
        }
        zznx zznx2 = zznx;
        zzanz zza4 = zzano.zza(zzi, ((Long) zzkb.zzik().zzd(zznk.zzbco)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService2);
        zzanz<V> zzi2 = zzano.zzi(null);
        if (((Boolean) zzkb.zzik().zzd(zznk.zzayj)).booleanValue()) {
            zzi2 = zzano.zza(zzafm2.zzchf.zzae(context2), ((Long) zzkb.zzik().zzd(zznk.zzayk)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService2);
        }
        Bundle bundle2 = (zzaef2.versionCode < 4 || zzaef2.zzcdc == null) ? null : zzaef2.zzcdc;
        ((Boolean) zzkb.zzik().zzd(zznk.zzawx)).booleanValue();
        zzbv.zzek();
        if (zzakk.zzl(context2, "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzakb.zzck("Device is offline.");
        }
        String uuid = zzaef2.versionCode >= 7 ? zzaef2.zzcdi : UUID.randomUUID().toString();
        new zzaft(context2, uuid, zzaef2.applicationInfo.packageName);
        if (zzaef2.zzccv.extras != null && (string = zzaef2.zzccv.extras.getString("_ad")) != null) {
            return zzafs.zza(context2, zzaef2, string);
        }
        List<String> zzf = zzafm2.zzcgz.zzf(zzaef2.zzcdj);
        zznv zznv = zzjj;
        String str = uuid;
        Bundle bundle3 = (Bundle) zzano.zza(zza, null, ((Long) zzkb.zzik().zzd(zznk.zzbdf)).longValue(), TimeUnit.MILLISECONDS);
        zzagk zzagk = (zzagk) zzano.zza(zza2, null);
        Location location = (Location) zzano.zza(zza4, null);
        AdvertisingIdClient.Info info2 = (AdvertisingIdClient.Info) zzano.zza(zzi2, null);
        String str2 = (String) zzano.zza(zza3, null);
        String str3 = (String) zzano.zza(zzcl, null);
        String str4 = (String) zzano.zza(zzcm, null);
        zzaga zzaga = (zzaga) zzano.zza(zzq, null);
        if (zzaga == null) {
            zzakb.zzdk("Error fetching device info. This is not recoverable.");
            return new zzaej(0);
        }
        zzafl zzafl = new zzafl();
        zzafl.zzcgs = zzaef2;
        zzafl.zzcgt = zzaga;
        zzafl.zzcgo = zzagk;
        zzafl.zzaqe = location;
        zzafl.zzcgn = bundle3;
        zzafl.zzccx = str2;
        zzafl.zzcgr = info2;
        if (zzf == null) {
            zzafl.zzcdj.clear();
        }
        zzafl.zzcdj = zzf;
        zzafl.zzcdc = bundle2;
        zzafl.zzcgp = str3;
        zzafl.zzcgq = str4;
        Context context3 = context;
        zzafl.zzcgu = zzafm2.zzcgx.zze(context3);
        zzafl.zzcgv = zzafm2.zzcgv;
        JSONObject zza5 = zzafs.zza(context3, zzafl);
        if (zza5 == null) {
            return new zzaej(0);
        }
        if (zzaef2.versionCode < 7) {
            try {
                zza5.put("request_id", str);
            } catch (JSONException unused) {
            }
        }
        zznx zznx3 = zznx2;
        zznv zznv2 = zznv;
        zznx3.zza(zznv2, "arc");
        zznx3.zzjj();
        ScheduledExecutorService scheduledExecutorService3 = scheduledExecutorService;
        zzanz<V> zza6 = zzano.zza(zzano.zza(zzafm2.zzchg.zzof().zzf(zza5), zzafo.zzxn, (Executor) scheduledExecutorService3), 10, TimeUnit.SECONDS, scheduledExecutorService3);
        zzanz<Void> zzop = zzafm2.zzcha.zzop();
        if (zzop != null) {
            zzanm.zza(zzop, "AdRequestServiceImpl.loadAd.flags");
        }
        zzafz zzafz = (zzafz) zzano.zza(zza6, null);
        if (zzafz == null) {
            return new zzaej(0);
        }
        if (zzafz.getErrorCode() != -2) {
            return new zzaej(zzafz.getErrorCode());
        }
        zznx3.zzjm();
        zzaej zza7 = !TextUtils.isEmpty(zzafz.zzom()) ? zzafs.zza(context3, zzaef2, zzafz.zzom()) : null;
        if (zza7 == null && !TextUtils.isEmpty(zzafz.getUrl())) {
            zza7 = zza(zzaef2, context3, zzaef2.zzacr.zzcw, zzafz.getUrl(), str3, str4, zzafz, zznx3, zzafm2);
        }
        if (zza7 == null) {
            c = 0;
            zza7 = new zzaej(0);
        } else {
            c = 0;
        }
        String[] strArr = new String[1];
        strArr[c] = "tts";
        zznx3.zza(zznv2, strArr);
        zza7.zzcfd = zznx3.zzjk();
        return zza7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e8, code lost:
        r1 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r7 = new java.io.InputStreamReader(r12.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        com.google.android.gms.ads.internal.zzbv.zzek();
        r11 = com.google.android.gms.internal.ads.zzakk.zza(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7);
        r10.zzdg(r11);
        zza(r1, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r14, r11, r4);
        r6.zza(r1, r14, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0108, code lost:
        if (r2 == null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010a, code lost:
        r2.zza(r5, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0115, code lost:
        r1 = r6.zza(r8, r24.zzon());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0120, code lost:
        if (r3 == null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0122, code lost:
        r3.zzchc.zzor();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0128, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0129, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r1 = r0;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0131, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014c, code lost:
        com.google.android.gms.internal.ads.zzakb.zzdk("No location header to follow redirect.");
        r1 = new com.google.android.gms.internal.ads.zzaej(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015a, code lost:
        if (r3 == null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x015c, code lost:
        r3.zzchc.zzor();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0161, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017b, code lost:
        com.google.android.gms.internal.ads.zzakb.zzdk("Too many redirects.");
        r1 = new com.google.android.gms.internal.ads.zzaej(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0189, code lost:
        if (r3 == null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018b, code lost:
        r3.zzchc.zzor();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0190, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[Catch:{ all -> 0x00c0, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0 A[Catch:{ all -> 0x00c0, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ca A[Catch:{ all -> 0x00c0, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0140 A[Catch:{ all -> 0x00c0, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01a4 A[EDGE_INSN: B:121:0x01a4->B:98:0x01a4 ?: BREAK  
    EDGE_INSN: B:122:0x01a4->B:98:0x01a4 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaej zza(com.google.android.gms.internal.ads.zzaef r18, android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.google.android.gms.internal.ads.zzafz r24, com.google.android.gms.internal.ads.zznx r25, com.google.android.gms.internal.ads.zzafm r26) {
        /*
            r1 = r18
            r2 = r25
            r3 = r26
            if (r2 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zznv r5 = r25.zzjj()
            goto L_0x000e
        L_0x000d:
            r5 = 0
        L_0x000e:
            com.google.android.gms.internal.ads.zzafx r6 = new com.google.android.gms.internal.ads.zzafx     // Catch:{ IOException -> 0x01d8 }
            java.lang.String r7 = r24.zzoi()     // Catch:{ IOException -> 0x01d8 }
            r6.<init>(r1, r7)     // Catch:{ IOException -> 0x01d8 }
            java.lang.String r7 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r8 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x01d8 }
            int r9 = r8.length()     // Catch:{ IOException -> 0x01d8 }
            if (r9 == 0) goto L_0x0028
            java.lang.String r7 = r7.concat(r8)     // Catch:{ IOException -> 0x01d8 }
            goto L_0x002e
        L_0x0028:
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x01d8 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x01d8 }
            r7 = r8
        L_0x002e:
            com.google.android.gms.internal.ads.zzakb.zzck(r7)     // Catch:{ IOException -> 0x01d8 }
            java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x01d8 }
            r8 = r21
            r7.<init>(r8)     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.common.util.Clock r8 = com.google.android.gms.ads.internal.zzbv.zzer()     // Catch:{ IOException -> 0x01d8 }
            long r8 = r8.elapsedRealtime()     // Catch:{ IOException -> 0x01d8 }
            r10 = 0
            r11 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzagi r12 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r12.zzoq()     // Catch:{ IOException -> 0x01d8 }
        L_0x0049:
            java.net.URLConnection r12 = r7.openConnection()     // Catch:{ IOException -> 0x01d8 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.ads.zzakk r13 = com.google.android.gms.ads.internal.zzbv.zzek()     // Catch:{ all -> 0x01cb }
            r14 = r19
            r15 = r20
            r13.zza((android.content.Context) r14, (java.lang.String) r15, (boolean) r10, (java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x01cb }
            boolean r13 = r24.zzok()     // Catch:{ all -> 0x01cb }
            if (r13 == 0) goto L_0x007e
            boolean r13 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x01cb }
            if (r13 != 0) goto L_0x006e
            java.lang.String r13 = "x-afma-drt-cookie"
            r4 = r22
            r12.addRequestProperty(r13, r4)     // Catch:{ all -> 0x01cb }
            goto L_0x0070
        L_0x006e:
            r4 = r22
        L_0x0070:
            boolean r13 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x01cb }
            if (r13 != 0) goto L_0x0080
            java.lang.String r13 = "x-afma-drt-v2-cookie"
            r10 = r23
            r12.addRequestProperty(r13, r10)     // Catch:{ all -> 0x01cb }
            goto L_0x0082
        L_0x007e:
            r4 = r22
        L_0x0080:
            r10 = r23
        L_0x0082:
            java.lang.String r13 = r1.zzcds     // Catch:{ all -> 0x01cb }
            boolean r16 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x01cb }
            if (r16 != 0) goto L_0x0094
            java.lang.String r4 = "Sending webview cookie in ad request header."
            com.google.android.gms.internal.ads.zzakb.zzck(r4)     // Catch:{ all -> 0x01cb }
            java.lang.String r4 = "Cookie"
            r12.addRequestProperty(r4, r13)     // Catch:{ all -> 0x01cb }
        L_0x0094:
            if (r24 == 0) goto L_0x00ca
            java.lang.String r4 = r24.zzoj()     // Catch:{ all -> 0x01cb }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01cb }
            if (r4 != 0) goto L_0x00ca
            r4 = 1
            r12.setDoOutput(r4)     // Catch:{ all -> 0x01cb }
            java.lang.String r4 = r24.zzoj()     // Catch:{ all -> 0x01cb }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x01cb }
            int r10 = r4.length     // Catch:{ all -> 0x01cb }
            r12.setFixedLengthStreamingMode(r10)     // Catch:{ all -> 0x01cb }
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00c3 }
            java.io.OutputStream r14 = r12.getOutputStream()     // Catch:{ all -> 0x00c3 }
            r10.<init>(r14)     // Catch:{ all -> 0x00c3 }
            r10.write(r4)     // Catch:{ all -> 0x00c0 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r10)     // Catch:{ all -> 0x01cb }
            goto L_0x00cb
        L_0x00c0:
            r0 = move-exception
            r1 = r0
            goto L_0x00c6
        L_0x00c3:
            r0 = move-exception
            r1 = r0
            r10 = 0
        L_0x00c6:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r10)     // Catch:{ all -> 0x01cb }
            throw r1     // Catch:{ all -> 0x01cb }
        L_0x00ca:
            r4 = 0
        L_0x00cb:
            com.google.android.gms.internal.ads.zzamy r10 = new com.google.android.gms.internal.ads.zzamy     // Catch:{ all -> 0x01cb }
            java.lang.String r14 = r1.zzcdi     // Catch:{ all -> 0x01cb }
            r10.<init>(r14)     // Catch:{ all -> 0x01cb }
            r10.zza((java.net.HttpURLConnection) r12, (byte[]) r4)     // Catch:{ all -> 0x01cb }
            int r4 = r12.getResponseCode()     // Catch:{ all -> 0x01cb }
            java.util.Map r14 = r12.getHeaderFields()     // Catch:{ all -> 0x01cb }
            r10.zza((java.net.HttpURLConnection) r12, (int) r4)     // Catch:{ all -> 0x01cb }
            r1 = 200(0xc8, float:2.8E-43)
            r15 = 300(0x12c, float:4.2E-43)
            if (r4 < r1) goto L_0x0132
            if (r4 >= r15) goto L_0x0132
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x01cb }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x012b }
            java.io.InputStream r11 = r12.getInputStream()     // Catch:{ all -> 0x012b }
            r7.<init>(r11)     // Catch:{ all -> 0x012b }
            com.google.android.gms.ads.internal.zzbv.zzek()     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = com.google.android.gms.internal.ads.zzakk.zza((java.io.InputStreamReader) r7)     // Catch:{ all -> 0x0128 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ all -> 0x01cb }
            r10.zzdg(r11)     // Catch:{ all -> 0x01cb }
            zza((java.lang.String) r1, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r14, (java.lang.String) r11, (int) r4)     // Catch:{ all -> 0x01cb }
            r6.zza(r1, r14, r11)     // Catch:{ all -> 0x01cb }
            if (r2 == 0) goto L_0x0115
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x01cb }
            java.lang.String r4 = "ufe"
            r7 = 0
            r1[r7] = r4     // Catch:{ all -> 0x01cb }
            r2.zza(r5, r1)     // Catch:{ all -> 0x01cb }
        L_0x0115:
            boolean r1 = r24.zzon()     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzaej r1 = r6.zza((long) r8, (boolean) r1)     // Catch:{ all -> 0x01cb }
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x0127
            com.google.android.gms.internal.ads.zzagi r2 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r2.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x0127:
            return r1
        L_0x0128:
            r0 = move-exception
            r1 = r0
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            r1 = r0
            r7 = 0
        L_0x012e:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ all -> 0x01cb }
            throw r1     // Catch:{ all -> 0x01cb }
        L_0x0132:
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x01cb }
            r7 = 0
            zza((java.lang.String) r1, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r14, (java.lang.String) r7, (int) r4)     // Catch:{ all -> 0x01cb }
            if (r4 < r15) goto L_0x01a4
            r1 = 400(0x190, float:5.6E-43)
            if (r4 >= r1) goto L_0x01a4
            java.lang.String r1 = "Location"
            java.lang.String r1 = r12.getHeaderField(r1)     // Catch:{ all -> 0x01cb }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01cb }
            if (r4 == 0) goto L_0x0162
            java.lang.String r1 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej     // Catch:{ all -> 0x01cb }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x01cb }
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x0161
            com.google.android.gms.internal.ads.zzagi r2 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r2.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x0161:
            return r1
        L_0x0162:
            java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x01cb }
            r4.<init>(r1)     // Catch:{ all -> 0x01cb }
            r1 = 1
            int r11 = r11 + r1
            com.google.android.gms.internal.ads.zzna<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zznk.zzbes     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzni r10 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x01cb }
            java.lang.Object r1 = r10.zzd(r1)     // Catch:{ all -> 0x01cb }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x01cb }
            int r1 = r1.intValue()     // Catch:{ all -> 0x01cb }
            if (r11 <= r1) goto L_0x0191
            java.lang.String r1 = "Too many redirects."
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej     // Catch:{ all -> 0x01cb }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x01cb }
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x0190
            com.google.android.gms.internal.ads.zzagi r2 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r2.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x0190:
            return r1
        L_0x0191:
            r6.zzl(r14)     // Catch:{ all -> 0x01cb }
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x019e
            com.google.android.gms.internal.ads.zzagi r1 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r1.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x019e:
            r7 = r4
            r1 = r18
            r10 = 0
            goto L_0x0042
        L_0x01a4:
            r1 = 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r2.<init>(r1)     // Catch:{ all -> 0x01cb }
            java.lang.String r1 = "Received error HTTP response code: "
            r2.append(r1)     // Catch:{ all -> 0x01cb }
            r2.append(r4)     // Catch:{ all -> 0x01cb }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej     // Catch:{ all -> 0x01cb }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x01cb }
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x01ca
            com.google.android.gms.internal.ads.zzagi r2 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r2.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x01ca:
            return r1
        L_0x01cb:
            r0 = move-exception
            r1 = r0
            r12.disconnect()     // Catch:{ IOException -> 0x01d8 }
            if (r3 == 0) goto L_0x01d7
            com.google.android.gms.internal.ads.zzagi r2 = r3.zzchc     // Catch:{ IOException -> 0x01d8 }
            r2.zzor()     // Catch:{ IOException -> 0x01d8 }
        L_0x01d7:
            throw r1     // Catch:{ IOException -> 0x01d8 }
        L_0x01d8:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x01ef
            java.lang.String r1 = r2.concat(r1)
            goto L_0x01f4
        L_0x01ef:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x01f4:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej
            r2 = 2
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafn.zza(com.google.android.gms.internal.ads.zzaef, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzafz, com.google.android.gms.internal.ads.zznx, com.google.android.gms.internal.ads.zzafm):com.google.android.gms.internal.ads.zzaej");
    }

    public static zzafn zza(Context context, zzafm zzafm) {
        zzafn zzafn;
        synchronized (sLock) {
            if (zzchh == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zznk.initialize(context);
                zzchh = new zzafn(context, zzafm);
                if (context.getApplicationContext() != null) {
                    zzbv.zzek().zzal(context);
                }
                zzajz.zzai(context);
            }
            zzafn = zzchh;
        }
        return zzafn;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzakb.isLoggable(2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Http Response: {\n  URL:\n    ");
            sb.append(str);
            sb.append("\n  Headers:");
            zzakb.m39v(sb.toString());
            if (map != null) {
                for (String next : map.keySet()) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(next).length() + 5);
                    sb2.append("    ");
                    sb2.append(next);
                    sb2.append(":");
                    zzakb.m39v(sb2.toString());
                    for (String valueOf : map.get(next)) {
                        String valueOf2 = String.valueOf(valueOf);
                        zzakb.m39v(valueOf2.length() != 0 ? "      ".concat(valueOf2) : new String("      "));
                    }
                }
            }
            zzakb.m39v("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    zzakb.m39v(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                zzakb.m39v("    null");
            }
            StringBuilder sb3 = new StringBuilder(34);
            sb3.append("  Response Code:\n    ");
            sb3.append(i);
            sb3.append("\n}");
            zzakb.m39v(sb3.toString());
        }
    }

    public final void zza(zzaef zzaef, zzaeq zzaeq) {
        zzbv.zzeo().zzd(this.mContext, zzaef.zzacr);
        zzanz<?> zzb = zzaki.zzb(new zzafp(this, zzaef, zzaeq));
        zzbv.zzez().zzsa();
        zzbv.zzez().getHandler().postDelayed(new zzafq(this, zzb), 60000);
    }

    public final void zza(zzaey zzaey, zzaet zzaet) {
        zzakb.m39v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    public final zzaej zzb(zzaef zzaef) {
        return zza(this.mContext, this.zzchi, zzaef, this.zzchj);
    }

    public final void zzb(zzaey zzaey, zzaet zzaet) {
        zzakb.m39v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }
}
