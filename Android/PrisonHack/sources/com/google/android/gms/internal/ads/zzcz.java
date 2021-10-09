package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzcz {
    private static final String TAG = "zzcz";
    private volatile boolean zzqt = false;
    protected Context zzrt;
    private ExecutorService zzru;
    private DexClassLoader zzrv;
    private zzck zzrw;
    private byte[] zzrx;
    private volatile AdvertisingIdClient zzry = null;
    private Future zzrz = null;
    private boolean zzsa;
    /* access modifiers changed from: private */
    public volatile zzba zzsb = null;
    private Future zzsc = null;
    private zzcc zzsd;
    private boolean zzse = false;
    private boolean zzsf = false;
    private Map<Pair<String, String>, zzeg> zzsg;
    private boolean zzsh = false;
    /* access modifiers changed from: private */
    public boolean zzsi;
    private boolean zzsj;

    final class zza extends BroadcastReceiver {
        private zza() {
        }

        /* synthetic */ zza(zzcz zzcz, zzda zzda) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                boolean unused = zzcz.this.zzsi = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = zzcz.this.zzsi = false;
            }
        }
    }

    private zzcz(Context context) {
        boolean z = true;
        this.zzsi = true;
        this.zzsj = false;
        Context applicationContext = context.getApplicationContext();
        this.zzsa = applicationContext == null ? false : z;
        this.zzrt = this.zzsa ? applicationContext : context;
        this.zzsg = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(2:22|23))|24|25|26|(3:27|28|(12:34|(1:36)|37|38|39|40|41|42|43|(1:45)|46|47)(2:32|33))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ zzcl -> 0x0150, zzcw -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090 A[Catch:{ all -> 0x011d, FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096 A[Catch:{ all -> 0x011d, FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }, PHI: r9 
      PHI: (r9v9 java.io.File) = (r9v8 java.io.File), (r9v14 java.io.File) binds: [B:29:0x0084, B:31:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzcz zza(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            com.google.android.gms.internal.ads.zzcz r0 = new com.google.android.gms.internal.ads.zzcz
            r0.<init>(r8)
            com.google.android.gms.internal.ads.zzda r8 = new com.google.android.gms.internal.ads.zzda     // Catch:{ zzcw -> 0x0157 }
            r8.<init>()     // Catch:{ zzcw -> 0x0157 }
            java.util.concurrent.ExecutorService r8 = java.util.concurrent.Executors.newCachedThreadPool(r8)     // Catch:{ zzcw -> 0x0157 }
            r0.zzru = r8     // Catch:{ zzcw -> 0x0157 }
            r0.zzqt = r11     // Catch:{ zzcw -> 0x0157 }
            if (r11 == 0) goto L_0x0021
            java.util.concurrent.ExecutorService r8 = r0.zzru     // Catch:{ zzcw -> 0x0157 }
            com.google.android.gms.internal.ads.zzdb r11 = new com.google.android.gms.internal.ads.zzdb     // Catch:{ zzcw -> 0x0157 }
            r11.<init>(r0)     // Catch:{ zzcw -> 0x0157 }
            java.util.concurrent.Future r8 = r8.submit(r11)     // Catch:{ zzcw -> 0x0157 }
            r0.zzrz = r8     // Catch:{ zzcw -> 0x0157 }
        L_0x0021:
            java.util.concurrent.ExecutorService r8 = r0.zzru     // Catch:{ zzcw -> 0x0157 }
            com.google.android.gms.internal.ads.zzdd r11 = new com.google.android.gms.internal.ads.zzdd     // Catch:{ zzcw -> 0x0157 }
            r11.<init>(r0)     // Catch:{ zzcw -> 0x0157 }
            r8.execute(r11)     // Catch:{ zzcw -> 0x0157 }
            r8 = 0
            r11 = 1
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.zzrt     // Catch:{ Throwable -> 0x004b }
            int r2 = r1.getApkVersion(r2)     // Catch:{ Throwable -> 0x004b }
            if (r2 <= 0) goto L_0x003b
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            r0.zzse = r2     // Catch:{ Throwable -> 0x004b }
            android.content.Context r2 = r0.zzrt     // Catch:{ Throwable -> 0x004b }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ Throwable -> 0x004b }
            if (r1 != 0) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            r0.zzsf = r1     // Catch:{ Throwable -> 0x004b }
        L_0x004b:
            r0.zza((int) r8, (boolean) r11)     // Catch:{ zzcw -> 0x0157 }
            boolean r1 = com.google.android.gms.internal.ads.zzdg.isMainThread()     // Catch:{ zzcw -> 0x0157 }
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzbaz     // Catch:{ zzcw -> 0x0157 }
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ zzcw -> 0x0157 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ zzcw -> 0x0157 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzcw -> 0x0157 }
            boolean r1 = r1.booleanValue()     // Catch:{ zzcw -> 0x0157 }
            if (r1 == 0) goto L_0x006e
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ zzcw -> 0x0157 }
            java.lang.String r9 = "Task Context initialization must not be called from the UI thread."
            r8.<init>(r9)     // Catch:{ zzcw -> 0x0157 }
            throw r8     // Catch:{ zzcw -> 0x0157 }
        L_0x006e:
            com.google.android.gms.internal.ads.zzck r1 = new com.google.android.gms.internal.ads.zzck     // Catch:{ zzcw -> 0x0157 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzcw -> 0x0157 }
            r0.zzrw = r1     // Catch:{ zzcw -> 0x0157 }
            com.google.android.gms.internal.ads.zzck r1 = r0.zzrw     // Catch:{ zzcl -> 0x0150 }
            byte[] r9 = r1.zzl(r9)     // Catch:{ zzcl -> 0x0150 }
            r0.zzrx = r9     // Catch:{ zzcl -> 0x0150 }
            android.content.Context r9 = r0.zzrt     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.io.File r9 = r9.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            if (r9 != 0) goto L_0x0096
            android.content.Context r9 = r0.zzrt     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r1 = "dex"
            java.io.File r9 = r9.getDir(r1, r8)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            if (r9 != 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzcw r8 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            throw r8     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
        L_0x0096:
            java.lang.String r1 = "1521499837408"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r4 = "%s/%s.jar"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r6[r8] = r9     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r6[r11] = r1     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r4 = java.lang.String.format(r4, r6)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            boolean r4 = r3.exists()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            if (r4 != 0) goto L_0x00c7
            com.google.android.gms.internal.ads.zzck r4 = r0.zzrw     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            byte[] r6 = r0.zzrx     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            byte[] r10 = r4.zza(r6, r10)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            int r6 = r10.length     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r4.write(r10, r8, r6)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
        L_0x00c7:
            r0.zzb((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            dalvik.system.DexClassLoader r10 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ all -> 0x011d }
            java.lang.String r6 = r9.getAbsolutePath()     // Catch:{ all -> 0x011d }
            android.content.Context r7 = r0.zzrt     // Catch:{ all -> 0x011d }
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch:{ all -> 0x011d }
            r10.<init>(r4, r6, r2, r7)     // Catch:{ all -> 0x011d }
            r0.zzrv = r10     // Catch:{ all -> 0x011d }
            zzb(r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r10 = "%s/%s.dex"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3[r8] = r9     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3[r11] = r1     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r8 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            zzm(r8)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            boolean r8 = r0.zzsj     // Catch:{ zzcw -> 0x0157 }
            if (r8 != 0) goto L_0x0113
            android.content.IntentFilter r8 = new android.content.IntentFilter     // Catch:{ zzcw -> 0x0157 }
            r8.<init>()     // Catch:{ zzcw -> 0x0157 }
            java.lang.String r9 = "android.intent.action.USER_PRESENT"
            r8.addAction(r9)     // Catch:{ zzcw -> 0x0157 }
            java.lang.String r9 = "android.intent.action.SCREEN_OFF"
            r8.addAction(r9)     // Catch:{ zzcw -> 0x0157 }
            android.content.Context r9 = r0.zzrt     // Catch:{ zzcw -> 0x0157 }
            com.google.android.gms.internal.ads.zzcz$zza r10 = new com.google.android.gms.internal.ads.zzcz$zza     // Catch:{ zzcw -> 0x0157 }
            r10.<init>(r0, r2)     // Catch:{ zzcw -> 0x0157 }
            r9.registerReceiver(r10, r8)     // Catch:{ zzcw -> 0x0157 }
            r0.zzsj = r11     // Catch:{ zzcw -> 0x0157 }
        L_0x0113:
            com.google.android.gms.internal.ads.zzcc r8 = new com.google.android.gms.internal.ads.zzcc     // Catch:{ zzcw -> 0x0157 }
            r8.<init>(r0)     // Catch:{ zzcw -> 0x0157 }
            r0.zzsd = r8     // Catch:{ zzcw -> 0x0157 }
            r0.zzsh = r11     // Catch:{ zzcw -> 0x0157 }
            return r0
        L_0x011d:
            r10 = move-exception
            zzb(r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r0.zza((java.io.File) r9, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r2 = "%s/%s.dex"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3[r8] = r9     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            r3[r11] = r1     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            zzm(r8)     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
            throw r10     // Catch:{ FileNotFoundException -> 0x0149, IOException -> 0x0142, zzcl -> 0x013b, NullPointerException -> 0x0134 }
        L_0x0134:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzcw r9 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ zzcw -> 0x0157 }
            r9.<init>(r8)     // Catch:{ zzcw -> 0x0157 }
            throw r9     // Catch:{ zzcw -> 0x0157 }
        L_0x013b:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzcw r9 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ zzcw -> 0x0157 }
            r9.<init>(r8)     // Catch:{ zzcw -> 0x0157 }
            throw r9     // Catch:{ zzcw -> 0x0157 }
        L_0x0142:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzcw r9 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ zzcw -> 0x0157 }
            r9.<init>(r8)     // Catch:{ zzcw -> 0x0157 }
            throw r9     // Catch:{ zzcw -> 0x0157 }
        L_0x0149:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzcw r9 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ zzcw -> 0x0157 }
            r9.<init>(r8)     // Catch:{ zzcw -> 0x0157 }
            throw r9     // Catch:{ zzcw -> 0x0157 }
        L_0x0150:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzcw r9 = new com.google.android.gms.internal.ads.zzcw     // Catch:{ zzcw -> 0x0157 }
            r9.<init>(r8)     // Catch:{ zzcw -> 0x0157 }
            throw r9     // Catch:{ zzcw -> 0x0157 }
        L_0x0157:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcz.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzcz");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0091 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3 A[SYNTHETIC, Splitter:B:39:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8 A[SYNTHETIC, Splitter:B:43:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2 A[SYNTHETIC, Splitter:B:52:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7 A[SYNTHETIC, Splitter:B:56:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r8
            r5 = 1
            r3[r5] = r9
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r8
            r2[r5] = r9
            java.lang.String r8 = java.lang.String.format(r3, r2)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x0033
            return
        L_0x0033:
            long r2 = r1.length()
            r5 = 0
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x003e
            return
        L_0x003e:
            int r8 = (int) r2
            byte[] r8 = new byte[r8]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00af, all -> 0x009f }
            r3.<init>(r1)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00af, all -> 0x009f }
            int r5 = r3.read(r8)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            if (r5 > 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            zzb(r1)
            return
        L_0x0054:
            com.google.android.gms.internal.ads.zzbe r5 = new com.google.android.gms.internal.ads.zzbe     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r5.<init>()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r6 = r6.getBytes()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r5.zzgs = r6     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r9 = r9.getBytes()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r5.zzgr = r9     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            com.google.android.gms.internal.ads.zzck r9 = r7.zzrw     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r6 = r7.zzrx     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            java.lang.String r8 = r9.zzb(r6, r8)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r8 = r8.getBytes()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r5.data = r8     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r8 = com.google.android.gms.internal.ads.zzbk.zzb(r8)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r5.zzgq = r8     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r0.createNewFile()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            r8.<init>(r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b0, all -> 0x009d }
            byte[] r9 = com.google.android.gms.internal.ads.zzbfi.zzb(r5)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x009b, all -> 0x0098 }
            int r0 = r9.length     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x009b, all -> 0x0098 }
            r8.write(r9, r4, r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x009b, all -> 0x0098 }
            r8.close()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x009b, all -> 0x0098 }
            r3.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            r8.close()     // Catch:{ IOException -> 0x0094 }
        L_0x0094:
            zzb(r1)
            return
        L_0x0098:
            r9 = move-exception
            r2 = r8
            goto L_0x00a1
        L_0x009b:
            r2 = r8
            goto L_0x00b0
        L_0x009d:
            r9 = move-exception
            goto L_0x00a1
        L_0x009f:
            r9 = move-exception
            r3 = r2
        L_0x00a1:
            if (r3 == 0) goto L_0x00a6
            r3.close()     // Catch:{ IOException -> 0x00a6 }
        L_0x00a6:
            if (r2 == 0) goto L_0x00ab
            r2.close()     // Catch:{ IOException -> 0x00ab }
        L_0x00ab:
            zzb(r1)
            throw r9
        L_0x00af:
            r3 = r2
        L_0x00b0:
            if (r3 == 0) goto L_0x00b5
            r3.close()     // Catch:{ IOException -> 0x00b5 }
        L_0x00b5:
            if (r2 == 0) goto L_0x00ba
            r2.close()     // Catch:{ IOException -> 0x00ba }
        L_0x00ba:
            zzb(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcz.zza(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzba zzba) {
        if (i >= 4) {
            return false;
        }
        if (zzba == null) {
            return true;
        }
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbbc)).booleanValue() && (zzba.zzcx == null || zzba.zzcx.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
            return true;
        }
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbbd)).booleanValue()) {
            return zzba.zzfn == null || zzba.zzfn.zzgl == null || zzba.zzfn.zzgl.longValue() == -2;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        try {
            if (this.zzry == null && this.zzsa) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzrt);
                advertisingIdClient.start();
                this.zzry = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzry = null;
        }
    }

    @VisibleForTesting
    private final zzba zzam() {
        try {
            return zzatq.zzl(this.zzrt, this.zzrt.getPackageName(), Integer.toString(this.zzrt.getPackageManager().getPackageInfo(this.zzrt.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:29|30|31|32|33|34|35|36) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00b1 */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c7 A[SYNTHETIC, Splitter:B:52:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc A[SYNTHETIC, Splitter:B:56:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d3 A[SYNTHETIC, Splitter:B:64:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8 A[SYNTHETIC, Splitter:B:68:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "%s/%s.tmp"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x001b
            return r4
        L_0x001b:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = java.lang.String.format(r3, r2)
            r1.<init>(r10)
            boolean r10 = r1.exists()
            if (r10 == 0) goto L_0x0033
            return r4
        L_0x0033:
            r10 = 0
            long r2 = r0.length()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0042
            zzb(r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            return r4
        L_0x0042:
            int r2 = (int) r2     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            byte[] r2 = new byte[r2]     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            r3.<init>(r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d0, all -> 0x00c3 }
            int r6 = r3.read(r2)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = TAG     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            zzb(r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r3.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r4
        L_0x005e:
            com.google.android.gms.internal.ads.zzbe r6 = new com.google.android.gms.internal.ads.zzbe     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r6.<init>()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            com.google.android.gms.internal.ads.zzbfi r2 = com.google.android.gms.internal.ads.zzbfi.zza(r6, r2)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            com.google.android.gms.internal.ads.zzbe r2 = (com.google.android.gms.internal.ads.zzbe) r2     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r7 = r2.zzgr     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r6.<init>(r7)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            boolean r11 = r11.equals(r6)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            if (r11 == 0) goto L_0x00ba
            byte[] r11 = r2.zzgq     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r6 = r2.data     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r6 = com.google.android.gms.internal.ads.zzbk.zzb(r6)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            if (r11 == 0) goto L_0x00ba
            byte[] r11 = r2.zzgs     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            if (r11 != 0) goto L_0x0093
            goto L_0x00ba
        L_0x0093:
            com.google.android.gms.internal.ads.zzck r11 = r9.zzrw     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r0 = r9.zzrx     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r2 = r2.data     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r6.<init>(r2)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r1.createNewFile()     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r0.<init>(r1)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            int r10 = r11.length     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b8, all -> 0x00b5 }
            r0.write(r11, r4, r10)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00b8, all -> 0x00b5 }
            r3.close()     // Catch:{ IOException -> 0x00b1 }
        L_0x00b1:
            r0.close()     // Catch:{ IOException -> 0x00b4 }
        L_0x00b4:
            return r5
        L_0x00b5:
            r11 = move-exception
            r10 = r0
            goto L_0x00c5
        L_0x00b8:
            r10 = r0
            goto L_0x00d1
        L_0x00ba:
            zzb(r0)     // Catch:{ zzcl | IOException | NoSuchAlgorithmException -> 0x00d1, all -> 0x00c1 }
            r3.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            return r4
        L_0x00c1:
            r11 = move-exception
            goto L_0x00c5
        L_0x00c3:
            r11 = move-exception
            r3 = r10
        L_0x00c5:
            if (r3 == 0) goto L_0x00ca
            r3.close()     // Catch:{ IOException -> 0x00ca }
        L_0x00ca:
            if (r10 == 0) goto L_0x00cf
            r10.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            throw r11
        L_0x00d0:
            r3 = r10
        L_0x00d1:
            if (r3 == 0) goto L_0x00d6
            r3.close()     // Catch:{ IOException -> 0x00d6 }
        L_0x00d6:
            if (r10 == 0) goto L_0x00db
            r10.close()     // Catch:{ IOException -> 0x00db }
        L_0x00db:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcz.zzb(java.io.File, java.lang.String):boolean");
    }

    private static void zzm(String str) {
        zzb(new File(str));
    }

    public final Context getContext() {
        return this.zzrt;
    }

    public final boolean isInitialized() {
        return this.zzsh;
    }

    public final Method zza(String str, String str2) {
        zzeg zzeg = this.zzsg.get(new Pair(str, str2));
        if (zzeg == null) {
            return null;
        }
        return zzeg.zzaw();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzsf) {
            Future<?> submit = this.zzru.submit(new zzdc(this, i, z));
            if (i == 0) {
                this.zzsc = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzsg.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzsg.put(new Pair(str, str2), new zzeg(this, str, str2, clsArr));
        return true;
    }

    public final ExecutorService zzab() {
        return this.zzru;
    }

    public final DexClassLoader zzac() {
        return this.zzrv;
    }

    public final zzck zzad() {
        return this.zzrw;
    }

    public final byte[] zzae() {
        return this.zzrx;
    }

    public final boolean zzaf() {
        return this.zzse;
    }

    public final zzcc zzag() {
        return this.zzsd;
    }

    public final boolean zzah() {
        return this.zzsf;
    }

    public final boolean zzai() {
        return this.zzsi;
    }

    public final zzba zzaj() {
        return this.zzsb;
    }

    public final Future zzak() {
        return this.zzsc;
    }

    public final AdvertisingIdClient zzan() {
        if (!this.zzqt) {
            return null;
        }
        if (this.zzry != null) {
            return this.zzry;
        }
        if (this.zzrz != null) {
            try {
                this.zzrz.get(2000, TimeUnit.MILLISECONDS);
                this.zzrz = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzrz.cancel(true);
            }
        }
        return this.zzry;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzba zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzam();
    }

    public final int zzx() {
        if (this.zzsd != null) {
            return zzcc.zzx();
        }
        return Integer.MIN_VALUE;
    }
}
