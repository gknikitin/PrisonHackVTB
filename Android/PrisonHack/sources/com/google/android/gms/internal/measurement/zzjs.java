package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjs implements zzed {
    private static volatile zzjs zzaqj;
    private final zzgm zzacw;
    private zzgg zzaqk;
    private zzfl zzaql;
    private zzej zzaqm;
    private zzfq zzaqn;
    private zzjo zzaqo;
    private zzeb zzaqp;
    private final zzjy zzaqq;
    private boolean zzaqr;
    @VisibleForTesting
    private long zzaqs;
    private List<Runnable> zzaqt;
    private int zzaqu;
    private int zzaqv;
    private boolean zzaqw;
    private boolean zzaqx;
    private boolean zzaqy;
    private FileLock zzaqz;
    private FileChannel zzara;
    private List<Long> zzarb;
    private List<Long> zzarc;
    private long zzard;
    private boolean zzvo;

    class zza implements zzel {
        zzks zzarh;
        List<Long> zzari;
        List<zzkp> zzarj;
        private long zzark;

        private zza() {
        }

        /* synthetic */ zza(zzjs zzjs, zzjt zzjt) {
            this();
        }

        private static long zza(zzkp zzkp) {
            return ((zzkp.zzatn.longValue() / 1000) / 60) / 60;
        }

        public final boolean zza(long j, zzkp zzkp) {
            Preconditions.checkNotNull(zzkp);
            if (this.zzarj == null) {
                this.zzarj = new ArrayList();
            }
            if (this.zzari == null) {
                this.zzari = new ArrayList();
            }
            if (this.zzarj.size() > 0 && zza(this.zzarj.get(0)) != zza(zzkp)) {
                return false;
            }
            long zzvv = this.zzark + ((long) zzkp.zzvv());
            if (zzvv >= ((long) Math.max(0, zzey.zzagx.get().intValue()))) {
                return false;
            }
            this.zzark = zzvv;
            this.zzarj.add(zzkp);
            this.zzari.add(Long.valueOf(j));
            return this.zzarj.size() < Math.max(1, zzey.zzagy.get().intValue());
        }

        public final void zzb(zzks zzks) {
            Preconditions.checkNotNull(zzks);
            this.zzarh = zzks;
        }
    }

    private zzjs(zzjx zzjx) {
        this(zzjx, (zzgm) null);
    }

    private zzjs(zzjx zzjx, zzgm zzgm) {
        this.zzvo = false;
        Preconditions.checkNotNull(zzjx);
        this.zzacw = zzgm.zza(zzjx.zzqx, (String) null, (String) null);
        this.zzard = -1;
        zzjy zzjy = new zzjy(this);
        zzjy.zzm();
        this.zzaqq = zzjy;
        zzfl zzfl = new zzfl(this);
        zzfl.zzm();
        this.zzaql = zzfl;
        zzgg zzgg = new zzgg(this);
        zzgg.zzm();
        this.zzaqk = zzgg;
        this.zzacw.zzge().zzc((Runnable) new zzjt(this, zzjx));
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzacw.zzgf().zzis().log("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzacw.zzgf().zziv().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzacw.zzgf().zzis().zzg("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[Catch:{ NameNotFoundException -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzdz zza(android.content.Context r26, java.lang.String r27, java.lang.String r28, boolean r29, boolean r30, boolean r31, long r32) {
        /*
            r25 = this;
            r0 = r25
            r2 = r27
            java.lang.String r1 = "Unknown"
            java.lang.String r3 = "Unknown"
            java.lang.String r4 = "Unknown"
            android.content.pm.PackageManager r5 = r26.getPackageManager()
            r6 = 0
            if (r5 != 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zzis()
            java.lang.String r2 = "PackageManager is null, can not log app install information"
            r1.log(r2)
            return r6
        L_0x0021:
            java.lang.String r5 = r5.getInstallerPackageName(r2)     // Catch:{ IllegalArgumentException -> 0x0026 }
            goto L_0x003a
        L_0x0026:
            com.google.android.gms.internal.measurement.zzgm r5 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()
            java.lang.String r7 = "Error retrieving installer package name. appId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r27)
            r5.zzg(r7, r8)
            r5 = r1
        L_0x003a:
            if (r5 != 0) goto L_0x0040
            java.lang.String r1 = "manual_install"
        L_0x003e:
            r7 = r1
            goto L_0x004c
        L_0x0040:
            java.lang.String r1 = "com.android.vending"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x004b
            java.lang.String r1 = ""
            goto L_0x003e
        L_0x004b:
            r7 = r5
        L_0x004c:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r26)     // Catch:{ NameNotFoundException -> 0x00b3 }
            r5 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r5)     // Catch:{ NameNotFoundException -> 0x00b3 }
            if (r1 == 0) goto L_0x006f
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r26)     // Catch:{ NameNotFoundException -> 0x00b3 }
            java.lang.CharSequence r3 = r3.getApplicationLabel(r2)     // Catch:{ NameNotFoundException -> 0x00b3 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ NameNotFoundException -> 0x00b3 }
            if (r5 != 0) goto L_0x006a
            java.lang.String r3 = r3.toString()     // Catch:{ NameNotFoundException -> 0x00b3 }
            r4 = r3
        L_0x006a:
            java.lang.String r3 = r1.versionName     // Catch:{ NameNotFoundException -> 0x00b3 }
            int r1 = r1.versionCode     // Catch:{ NameNotFoundException -> 0x00b3 }
            goto L_0x0071
        L_0x006f:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0071:
            r4 = r3
            r16 = 0
            com.google.android.gms.internal.measurement.zzgm r3 = r0.zzacw
            r3.zzgi()
            r5 = 0
            com.google.android.gms.internal.measurement.zzgm r3 = r0.zzacw
            com.google.android.gms.internal.measurement.zzeg r3 = r3.zzgh()
            boolean r3 = r3.zzaz(r2)
            if (r3 == 0) goto L_0x008a
            r18 = r32
            goto L_0x008c
        L_0x008a:
            r18 = r5
        L_0x008c:
            com.google.android.gms.internal.measurement.zzdz r24 = new com.google.android.gms.internal.measurement.zzdz
            long r5 = (long) r1
            r8 = 12451(0x30a3, double:6.1516E-320)
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzkc r1 = r1.zzgc()
            r3 = r26
            long r10 = r1.zzd((android.content.Context) r3, (java.lang.String) r2)
            r12 = 0
            r14 = 0
            java.lang.String r15 = ""
            r20 = 0
            r23 = 0
            r1 = r24
            r3 = r28
            r13 = r29
            r21 = r30
            r22 = r31
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (long) r5, (java.lang.String) r7, (long) r8, (long) r10, (java.lang.String) r12, (boolean) r13, (boolean) r14, (java.lang.String) r15, (long) r16, (long) r18, (int) r20, (boolean) r21, (boolean) r22, (boolean) r23)
            return r24
        L_0x00b3:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zzis()
            java.lang.String r3 = "Error retrieving newly installed package info. appId, appName"
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzfh.zzbl(r27)
            r1.zze(r3, r2, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zza(android.content.Context, java.lang.String, java.lang.String, boolean, boolean, boolean, long):com.google.android.gms.internal.measurement.zzdz");
    }

    private static void zza(zzjr zzjr) {
        if (zzjr == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjr.isInitialized()) {
            String valueOf = String.valueOf(zzjr.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzjx zzjx) {
        this.zzacw.zzge().zzab();
        zzej zzej = new zzej(this);
        zzej.zzm();
        this.zzaqm = zzej;
        this.zzacw.zzgh().zza(this.zzaqk);
        zzeb zzeb = new zzeb(this);
        zzeb.zzm();
        this.zzaqp = zzeb;
        zzjo zzjo = new zzjo(this);
        zzjo.zzm();
        this.zzaqo = zzjo;
        this.zzaqn = new zzfq(this);
        if (this.zzaqu != this.zzaqv) {
            this.zzacw.zzgf().zzis().zze("Not all upload components initialized", Integer.valueOf(this.zzaqu), Integer.valueOf(this.zzaqv));
        }
        this.zzvo = true;
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzacw.zzgf().zzis().log("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzacw.zzgf().zzis().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzacw.zzgf().zzis().zzg("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(String str, zzew zzew) {
        long j;
        zzkb zzkb;
        String string = zzew.zzafr.getString(FirebaseAnalytics.Param.CURRENCY);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzew.name)) {
            double doubleValue = zzew.zzafr.zzbg(FirebaseAnalytics.Param.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzew.zzafr.getLong(FirebaseAnalytics.Param.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                this.zzacw.zzgf().zziv().zze("Data lost. Currency value is too big. appId", zzfh.zzbl(str), Double.valueOf(doubleValue));
                return false;
            }
            j = Math.round(doubleValue);
        } else {
            j = zzew.zzafr.getLong(FirebaseAnalytics.Param.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                String valueOf2 = String.valueOf(upperCase);
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                zzkb zzh = zzje().zzh(str, concat);
                if (zzh == null || !(zzh.value instanceof Long)) {
                    zzej zzje = zzje();
                    int zzb = this.zzacw.zzgh().zzb(str, zzey.zzaht) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzje.zzab();
                    zzje.zzch();
                    try {
                        zzje.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzje.zzgf().zzis().zze("Error pruning currencies. appId", zzfh.zzbl(str), e);
                    }
                    zzkb = new zzkb(str, zzew.origin, concat, this.zzacw.zzbt().currentTimeMillis(), Long.valueOf(j));
                } else {
                    zzkb = new zzkb(str, zzew.origin, concat, this.zzacw.zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + j));
                }
                if (!zzje().zza(zzkb)) {
                    this.zzacw.zzgf().zzis().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfh.zzbl(str), this.zzacw.zzgb().zzbk(zzkb.name), zzkb.value);
                    this.zzacw.zzgc().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    private final zzko[] zza(String str, zzku[] zzkuArr, zzkp[] zzkpArr) {
        Preconditions.checkNotEmpty(str);
        return zzjd().zza(str, zzkpArr, zzkuArr);
    }

    @WorkerThread
    private final void zzab() {
        this.zzacw.zzge().zzab();
    }

    @WorkerThread
    private final void zzb(zzdy zzdy) {
        ArrayMap arrayMap;
        zzab();
        if (TextUtils.isEmpty(zzdy.getGmpAppId())) {
            zzb(zzdy.zzah(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String gmpAppId = zzdy.getGmpAppId();
        String appInstanceId = zzdy.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzey.zzagt.get()).encodedAuthority(zzey.zzagu.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            this.zzacw.zzgf().zziz().zzg("Fetching remote configuration", zzdy.zzah());
            zzkm zzbt = zzkv().zzbt(zzdy.zzah());
            String zzbu = zzkv().zzbu(zzdy.zzah());
            if (zzbt == null || TextUtils.isEmpty(zzbu)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzbu);
                arrayMap = arrayMap2;
            }
            this.zzaqw = true;
            zzfl zzkw = zzkw();
            String zzah = zzdy.zzah();
            zzjv zzjv = new zzjv(this);
            zzkw.zzab();
            zzkw.zzch();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjv);
            zzkw.zzge().zzd((Runnable) new zzfp(zzkw, zzah, url, (byte[]) null, arrayMap, zzjv));
        } catch (MalformedURLException unused) {
            this.zzacw.zzgf().zzis().zze("Failed to parse config URL. Not fetching. appId", zzfh.zzbl(zzdy.zzah()), uri);
        }
    }

    @WorkerThread
    private final Boolean zzc(zzdy zzdy) {
        try {
            if (zzdy.zzgo() != -2147483648L) {
                if (zzdy.zzgo() == ((long) Wrappers.packageManager(this.zzacw.getContext()).getPackageInfo(zzdy.zzah(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzacw.getContext()).getPackageInfo(zzdy.zzah(), 0).versionName;
                if (zzdy.zzag() != null && zzdy.zzag().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x05cb A[Catch:{ IOException -> 0x05ce, all -> 0x063f }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x05f9 A[Catch:{ IOException -> 0x05ce, all -> 0x063f }] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.internal.measurement.zzew r32, com.google.android.gms.internal.measurement.zzdz r33) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            r3 = r33
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r33)
            java.lang.String r4 = r3.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            long r4 = java.lang.System.nanoTime()
            r31.zzab()
            r31.zzkz()
            java.lang.String r15 = r3.packageName
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()
            boolean r6 = r6.zzd((com.google.android.gms.internal.measurement.zzew) r2, (com.google.android.gms.internal.measurement.zzdz) r3)
            if (r6 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r6 = r3.zzadw
            if (r6 != 0) goto L_0x002f
            r1.zzg((com.google.android.gms.internal.measurement.zzdz) r3)
            return
        L_0x002f:
            com.google.android.gms.internal.measurement.zzgg r6 = r31.zzkv()
            java.lang.String r7 = r2.name
            boolean r6 = r6.zzn(r15, r7)
            r14 = 0
            r13 = 1
            if (r6 == 0) goto L_0x00da
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r4 = "Dropping blacklisted event. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfh.zzbl(r15)
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw
            com.google.android.gms.internal.measurement.zzff r6 = r6.zzgb()
            java.lang.String r7 = r2.name
            java.lang.String r6 = r6.zzbi(r7)
            r3.zze(r4, r5, r6)
            com.google.android.gms.internal.measurement.zzgg r3 = r31.zzkv()
            boolean r3 = r3.zzbx(r15)
            if (r3 != 0) goto L_0x0072
            com.google.android.gms.internal.measurement.zzgg r3 = r31.zzkv()
            boolean r3 = r3.zzby(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r13 = 0
        L_0x0072:
            if (r13 != 0) goto L_0x008f
            java.lang.String r3 = "_err"
            java.lang.String r4 = r2.name
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x008f
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzkc r6 = r3.zzgc()
            r8 = 11
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.name
            r11 = 0
            r7 = r15
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)
        L_0x008f:
            if (r13 == 0) goto L_0x00d9
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            com.google.android.gms.internal.measurement.zzdy r2 = r2.zzbb(r15)
            if (r2 == 0) goto L_0x00d9
            long r3 = r2.zzgu()
            long r5 = r2.zzgt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw
            com.google.android.gms.common.util.Clock r5 = r5.zzbt()
            long r5 = r5.currentTimeMillis()
            long r7 = r5 - r3
            long r3 = java.lang.Math.abs(r7)
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r5 = com.google.android.gms.internal.measurement.zzey.zzaho
            java.lang.Object r5 = r5.get()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d9
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziy()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.log(r4)
            r1.zzb((com.google.android.gms.internal.measurement.zzdy) r2)
        L_0x00d9:
            return
        L_0x00da:
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r6 = r6.zzgf()
            r12 = 2
            boolean r6 = r6.isLoggable(r12)
            if (r6 == 0) goto L_0x0100
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r6 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zziz()
            java.lang.String r7 = "Logging event"
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw
            com.google.android.gms.internal.measurement.zzff r8 = r8.zzgb()
            java.lang.String r8 = r8.zzb((com.google.android.gms.internal.measurement.zzew) r2)
            r6.zzg(r7, r8)
        L_0x0100:
            com.google.android.gms.internal.measurement.zzej r6 = r31.zzje()
            r6.beginTransaction()
            r1.zzg((com.google.android.gms.internal.measurement.zzdz) r3)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = "_iap"
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x063f }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x063f }
            if (r6 != 0) goto L_0x011e
            java.lang.String r6 = "ecommerce_purchase"
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x063f }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x0133
        L_0x011e:
            boolean r6 = r1.zza((java.lang.String) r15, (com.google.android.gms.internal.measurement.zzew) r2)     // Catch:{ all -> 0x063f }
            if (r6 != 0) goto L_0x0133
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            return
        L_0x0133:
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x063f }
            boolean r16 = com.google.android.gms.internal.measurement.zzkc.zzcb(r6)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = "_err"
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x063f }
            boolean r17 = r6.equals(r7)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r6 = r31.zzje()     // Catch:{ all -> 0x063f }
            long r7 = r31.zzla()     // Catch:{ all -> 0x063f }
            r10 = 1
            r18 = 0
            r19 = 0
            r9 = r15
            r11 = r16
            r12 = r18
            r13 = r17
            r20 = r4
            r4 = 0
            r14 = r19
            com.google.android.gms.internal.measurement.zzek r5 = r6.zza(r7, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x063f }
            long r6 = r5.zzaff     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r8 = com.google.android.gms.internal.measurement.zzey.zzagz     // Catch:{ all -> 0x063f }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x063f }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x063f }
            int r8 = r8.intValue()     // Catch:{ all -> 0x063f }
            long r8 = (long) r8     // Catch:{ all -> 0x063f }
            long r10 = r6 - r8
            r13 = 0
            int r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            r7 = 1000(0x3e8, double:4.94E-321)
            r13 = 1
            if (r6 <= 0) goto L_0x01a6
            long r10 = r10 % r7
            int r2 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0197
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()     // Catch:{ all -> 0x063f }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfh.zzbl(r15)     // Catch:{ all -> 0x063f }
            long r5 = r5.zzaff     // Catch:{ all -> 0x063f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x063f }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x063f }
        L_0x0197:
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            return
        L_0x01a6:
            if (r16 == 0) goto L_0x01fe
            long r9 = r5.zzafe     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r6 = com.google.android.gms.internal.measurement.zzey.zzahb     // Catch:{ all -> 0x063f }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x063f }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x063f }
            int r6 = r6.intValue()     // Catch:{ all -> 0x063f }
            long r11 = (long) r6     // Catch:{ all -> 0x063f }
            long r18 = r9 - r11
            r9 = 0
            int r6 = (r18 > r9 ? 1 : (r18 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x01fe
            long r18 = r18 % r7
            int r3 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x01de
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zzis()     // Catch:{ all -> 0x063f }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfh.zzbl(r15)     // Catch:{ all -> 0x063f }
            long r7 = r5.zzafe     // Catch:{ all -> 0x063f }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x063f }
            r3.zze(r4, r6, r5)     // Catch:{ all -> 0x063f }
        L_0x01de:
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r3.zzgc()     // Catch:{ all -> 0x063f }
            r8 = 16
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x063f }
            r11 = 0
            r7 = r15
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            return
        L_0x01fe:
            if (r17 == 0) goto L_0x0250
            long r6 = r5.zzafh     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeg r8 = r8.zzgh()     // Catch:{ all -> 0x063f }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r10 = com.google.android.gms.internal.measurement.zzey.zzaha     // Catch:{ all -> 0x063f }
            int r8 = r8.zzb(r9, r10)     // Catch:{ all -> 0x063f }
            r9 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r9, r8)     // Catch:{ all -> 0x063f }
            int r8 = java.lang.Math.max(r4, r8)     // Catch:{ all -> 0x063f }
            long r8 = (long) r8     // Catch:{ all -> 0x063f }
            long r10 = r6 - r8
            r6 = 0
            int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0250
            int r2 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0241
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()     // Catch:{ all -> 0x063f }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfh.zzbl(r15)     // Catch:{ all -> 0x063f }
            long r5 = r5.zzafh     // Catch:{ all -> 0x063f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x063f }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x063f }
        L_0x0241:
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            return
        L_0x0250:
            com.google.android.gms.internal.measurement.zzet r5 = r2.zzafr     // Catch:{ all -> 0x063f }
            android.os.Bundle r5 = r5.zzij()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = "_o"
            java.lang.String r8 = r2.origin     // Catch:{ all -> 0x063f }
            r6.zza((android.os.Bundle) r5, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()     // Catch:{ all -> 0x063f }
            boolean r6 = r6.zzci(r15)     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x028d
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = "_dbg"
            java.lang.Long r8 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x063f }
            r6.zza((android.os.Bundle) r5, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = "_r"
            java.lang.Long r8 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x063f }
            r6.zza((android.os.Bundle) r5, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x063f }
        L_0x028d:
            com.google.android.gms.internal.measurement.zzej r6 = r31.zzje()     // Catch:{ all -> 0x063f }
            long r6 = r6.zzbc(r15)     // Catch:{ all -> 0x063f }
            r13 = 0
            int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x02b2
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziv()     // Catch:{ all -> 0x063f }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfh.zzbl(r15)     // Catch:{ all -> 0x063f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x063f }
            r8.zze(r9, r10, r6)     // Catch:{ all -> 0x063f }
        L_0x02b2:
            com.google.android.gms.internal.measurement.zzer r11 = new com.google.android.gms.internal.measurement.zzer     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r7 = r1.zzacw     // Catch:{ all -> 0x063f }
            java.lang.String r8 = r2.origin     // Catch:{ all -> 0x063f }
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x063f }
            long r13 = r2.zzagc     // Catch:{ all -> 0x063f }
            r17 = 0
            r6 = r11
            r9 = r15
            r2 = r11
            r11 = r13
            r13 = r17
            r4 = r15
            r15 = r5
            r6.<init>((com.google.android.gms.internal.measurement.zzgm) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (long) r11, (long) r13, (android.os.Bundle) r15)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r5 = r31.zzje()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzes r5 = r5.zzf(r4, r6)     // Catch:{ all -> 0x063f }
            if (r5 != 0) goto L_0x033a
            com.google.android.gms.internal.measurement.zzej r5 = r31.zzje()     // Catch:{ all -> 0x063f }
            long r5 = r5.zzbf(r4)     // Catch:{ all -> 0x063f }
            r7 = 500(0x1f4, double:2.47E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x0321
            if (r16 == 0) goto L_0x0321
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zzis()     // Catch:{ all -> 0x063f }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfh.zzbl(r4)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r7 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzff r7 = r7.zzgb()     // Catch:{ all -> 0x063f }
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x063f }
            java.lang.String r2 = r7.zzbi(r2)     // Catch:{ all -> 0x063f }
            r7 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x063f }
            r3.zzd(r5, r6, r2, r7)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkc r6 = r2.zzgc()     // Catch:{ all -> 0x063f }
            r8 = 8
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r4
            r6.zza((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            return
        L_0x0321:
            com.google.android.gms.internal.measurement.zzes r5 = new com.google.android.gms.internal.measurement.zzes     // Catch:{ all -> 0x063f }
            java.lang.String r8 = r2.name     // Catch:{ all -> 0x063f }
            r9 = 0
            r11 = 0
            long r13 = r2.timestamp     // Catch:{ all -> 0x063f }
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = r5
            r7 = r4
            r6.<init>(r7, r8, r9, r11, r13, r15, r17, r18, r19)     // Catch:{ all -> 0x063f }
            r11 = r2
            goto L_0x0348
        L_0x033a:
            com.google.android.gms.internal.measurement.zzgm r4 = r1.zzacw     // Catch:{ all -> 0x063f }
            long r6 = r5.zzafu     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzer r11 = r2.zza(r4, r6)     // Catch:{ all -> 0x063f }
            long r6 = r11.timestamp     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzes r5 = r5.zzac(r6)     // Catch:{ all -> 0x063f }
        L_0x0348:
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.zza((com.google.android.gms.internal.measurement.zzes) r5)     // Catch:{ all -> 0x063f }
            r31.zzab()     // Catch:{ all -> 0x063f }
            r31.zzkz()     // Catch:{ all -> 0x063f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x063f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r33)     // Catch:{ all -> 0x063f }
            java.lang.String r2 = r11.zzti     // Catch:{ all -> 0x063f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x063f }
            java.lang.String r2 = r11.zzti     // Catch:{ all -> 0x063f }
            java.lang.String r4 = r3.packageName     // Catch:{ all -> 0x063f }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x063f }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzks r2 = new com.google.android.gms.internal.measurement.zzks     // Catch:{ all -> 0x063f }
            r2.<init>()     // Catch:{ all -> 0x063f }
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x063f }
            r2.zzatt = r5     // Catch:{ all -> 0x063f }
            java.lang.String r5 = "android"
            r2.zzaub = r5     // Catch:{ all -> 0x063f }
            java.lang.String r5 = r3.packageName     // Catch:{ all -> 0x063f }
            r2.zzti = r5     // Catch:{ all -> 0x063f }
            java.lang.String r5 = r3.zzadt     // Catch:{ all -> 0x063f }
            r2.zzadt = r5     // Catch:{ all -> 0x063f }
            java.lang.String r5 = r3.zzth     // Catch:{ all -> 0x063f }
            r2.zzth = r5     // Catch:{ all -> 0x063f }
            long r5 = r3.zzads     // Catch:{ all -> 0x063f }
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r5 = 0
            if (r9 != 0) goto L_0x0393
            r6 = r5
            goto L_0x039a
        L_0x0393:
            long r6 = r3.zzads     // Catch:{ all -> 0x063f }
            int r6 = (int) r6     // Catch:{ all -> 0x063f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x063f }
        L_0x039a:
            r2.zzaun = r6     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadu     // Catch:{ all -> 0x063f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x063f }
            r2.zzauf = r6     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.zzadm     // Catch:{ all -> 0x063f }
            r2.zzadm = r6     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadv     // Catch:{ all -> 0x063f }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x03b2
            r6 = r5
            goto L_0x03b8
        L_0x03b2:
            long r6 = r3.zzadv     // Catch:{ all -> 0x063f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x063f }
        L_0x03b8:
            r2.zzauj = r6     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfs r6 = r6.zzgg()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x063f }
            android.util.Pair r6 = r6.zzbn(r7)     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x03e3
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x063f }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x063f }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x063f }
            if (r7 != 0) goto L_0x03e3
            boolean r7 = r3.zzady     // Catch:{ all -> 0x063f }
            if (r7 == 0) goto L_0x0440
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x063f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x063f }
            r2.zzauh = r7     // Catch:{ all -> 0x063f }
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x063f }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x063f }
            r2.zzaui = r6     // Catch:{ all -> 0x063f }
            goto L_0x0440
        L_0x03e3:
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzfx()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r7 = r1.zzacw     // Catch:{ all -> 0x063f }
            android.content.Context r7 = r7.getContext()     // Catch:{ all -> 0x063f }
            boolean r6 = r6.zzf(r7)     // Catch:{ all -> 0x063f }
            if (r6 != 0) goto L_0x0440
            boolean r6 = r3.zzadz     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x0440
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x063f }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x063f }
            if (r6 != 0) goto L_0x0423
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r6 = r6.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zziv()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.zzti     // Catch:{ all -> 0x063f }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfh.zzbl(r10)     // Catch:{ all -> 0x063f }
            r6.zzg(r7, r10)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = "null"
            goto L_0x043e
        L_0x0423:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x063f }
            if (r7 == 0) goto L_0x043e
            com.google.android.gms.internal.measurement.zzgm r7 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r7 = r7.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zziv()     // Catch:{ all -> 0x063f }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r12 = r2.zzti     // Catch:{ all -> 0x063f }
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzfh.zzbl(r12)     // Catch:{ all -> 0x063f }
            r7.zzg(r10, r12)     // Catch:{ all -> 0x063f }
        L_0x043e:
            r2.zzauq = r6     // Catch:{ all -> 0x063f }
        L_0x0440:
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzfx()     // Catch:{ all -> 0x063f }
            r6.zzch()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x063f }
            r2.zzaud = r6     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzfx()     // Catch:{ all -> 0x063f }
            r6.zzch()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x063f }
            r2.zzauc = r6     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzfx()     // Catch:{ all -> 0x063f }
            long r6 = r6.zzig()     // Catch:{ all -> 0x063f }
            int r6 = (int) r6     // Catch:{ all -> 0x063f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x063f }
            r2.zzaue = r6     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzfx()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r6.zzih()     // Catch:{ all -> 0x063f }
            r2.zzafo = r6     // Catch:{ all -> 0x063f }
            r2.zzaug = r5     // Catch:{ all -> 0x063f }
            r2.zzatw = r5     // Catch:{ all -> 0x063f }
            r2.zzatx = r5     // Catch:{ all -> 0x063f }
            r2.zzaty = r5     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadx     // Catch:{ all -> 0x063f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x063f }
            r2.zzaus = r6     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            boolean r6 = r6.isEnabled()     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x0497
            boolean r6 = com.google.android.gms.internal.measurement.zzeg.zzho()     // Catch:{ all -> 0x063f }
            if (r6 == 0) goto L_0x0497
            r2.zzaut = r5     // Catch:{ all -> 0x063f }
        L_0x0497:
            com.google.android.gms.internal.measurement.zzej r5 = r31.zzje()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzdy r5 = r5.zzbb(r6)     // Catch:{ all -> 0x063f }
            if (r5 != 0) goto L_0x0505
            com.google.android.gms.internal.measurement.zzdy r5 = new com.google.android.gms.internal.measurement.zzdy     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x063f }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfc r6 = r6.zzfw()     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r6.zzio()     // Catch:{ all -> 0x063f }
            r5.zzak(r6)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.zzado     // Catch:{ all -> 0x063f }
            r5.zzan(r6)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.zzadm     // Catch:{ all -> 0x063f }
            r5.zzal(r6)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfs r6 = r6.zzgg()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r6.zzbo(r7)     // Catch:{ all -> 0x063f }
            r5.zzam(r6)     // Catch:{ all -> 0x063f }
            r5.zzr(r8)     // Catch:{ all -> 0x063f }
            r5.zzm(r8)     // Catch:{ all -> 0x063f }
            r5.zzn(r8)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.zzth     // Catch:{ all -> 0x063f }
            r5.setAppVersion(r6)     // Catch:{ all -> 0x063f }
            long r6 = r3.zzads     // Catch:{ all -> 0x063f }
            r5.zzo(r6)     // Catch:{ all -> 0x063f }
            java.lang.String r6 = r3.zzadt     // Catch:{ all -> 0x063f }
            r5.zzao(r6)     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadu     // Catch:{ all -> 0x063f }
            r5.zzp(r6)     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadv     // Catch:{ all -> 0x063f }
            r5.zzq(r6)     // Catch:{ all -> 0x063f }
            boolean r6 = r3.zzadw     // Catch:{ all -> 0x063f }
            r5.setMeasurementEnabled(r6)     // Catch:{ all -> 0x063f }
            long r6 = r3.zzadx     // Catch:{ all -> 0x063f }
            r5.zzaa(r6)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r6 = r31.zzje()     // Catch:{ all -> 0x063f }
            r6.zza((com.google.android.gms.internal.measurement.zzdy) r5)     // Catch:{ all -> 0x063f }
        L_0x0505:
            java.lang.String r6 = r5.getAppInstanceId()     // Catch:{ all -> 0x063f }
            r2.zzadl = r6     // Catch:{ all -> 0x063f }
            java.lang.String r5 = r5.zzgl()     // Catch:{ all -> 0x063f }
            r2.zzado = r5     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r5 = r31.zzje()     // Catch:{ all -> 0x063f }
            java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x063f }
            java.util.List r3 = r5.zzba(r3)     // Catch:{ all -> 0x063f }
            int r5 = r3.size()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzku[] r5 = new com.google.android.gms.internal.measurement.zzku[r5]     // Catch:{ all -> 0x063f }
            r2.zzatv = r5     // Catch:{ all -> 0x063f }
            r5 = 0
        L_0x0524:
            int r6 = r3.size()     // Catch:{ all -> 0x063f }
            if (r5 >= r6) goto L_0x055d
            com.google.android.gms.internal.measurement.zzku r6 = new com.google.android.gms.internal.measurement.zzku     // Catch:{ all -> 0x063f }
            r6.<init>()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzku[] r7 = r2.zzatv     // Catch:{ all -> 0x063f }
            r7[r5] = r6     // Catch:{ all -> 0x063f }
            java.lang.Object r7 = r3.get(r5)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkb r7 = (com.google.android.gms.internal.measurement.zzkb) r7     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x063f }
            r6.name = r7     // Catch:{ all -> 0x063f }
            java.lang.Object r7 = r3.get(r5)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkb r7 = (com.google.android.gms.internal.measurement.zzkb) r7     // Catch:{ all -> 0x063f }
            long r12 = r7.zzarl     // Catch:{ all -> 0x063f }
            java.lang.Long r7 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x063f }
            r6.zzauz = r7     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzjy r7 = r31.zzjc()     // Catch:{ all -> 0x063f }
            java.lang.Object r10 = r3.get(r5)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzkb r10 = (com.google.android.gms.internal.measurement.zzkb) r10     // Catch:{ all -> 0x063f }
            java.lang.Object r10 = r10.value     // Catch:{ all -> 0x063f }
            r7.zza((com.google.android.gms.internal.measurement.zzku) r6, (java.lang.Object) r10)     // Catch:{ all -> 0x063f }
            int r5 = r5 + 1
            goto L_0x0524
        L_0x055d:
            com.google.android.gms.internal.measurement.zzej r3 = r31.zzje()     // Catch:{ IOException -> 0x05ce }
            long r5 = r3.zza((com.google.android.gms.internal.measurement.zzks) r2)     // Catch:{ IOException -> 0x05ce }
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzet r3 = r11.zzafr     // Catch:{ all -> 0x063f }
            if (r3 == 0) goto L_0x05c4
            com.google.android.gms.internal.measurement.zzet r3 = r11.zzafr     // Catch:{ all -> 0x063f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x063f }
        L_0x0573:
            boolean r7 = r3.hasNext()     // Catch:{ all -> 0x063f }
            if (r7 == 0) goto L_0x0588
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x063f }
            java.lang.String r10 = "_r"
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x063f }
            if (r7 == 0) goto L_0x0573
            goto L_0x05c5
        L_0x0588:
            com.google.android.gms.internal.measurement.zzgg r3 = r31.zzkv()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r11.zzti     // Catch:{ all -> 0x063f }
            java.lang.String r10 = r11.name     // Catch:{ all -> 0x063f }
            boolean r3 = r3.zzo(r7, r10)     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzej r22 = r31.zzje()     // Catch:{ all -> 0x063f }
            long r23 = r31.zzla()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r11.zzti     // Catch:{ all -> 0x063f }
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r25 = r7
            com.google.android.gms.internal.measurement.zzek r7 = r22.zza(r23, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x063f }
            if (r3 == 0) goto L_0x05c4
            long r12 = r7.zzafi     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzeg r3 = r3.zzgh()     // Catch:{ all -> 0x063f }
            java.lang.String r7 = r11.zzti     // Catch:{ all -> 0x063f }
            int r3 = r3.zzaq(r7)     // Catch:{ all -> 0x063f }
            long r14 = (long) r3     // Catch:{ all -> 0x063f }
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x05c4
            goto L_0x05c5
        L_0x05c4:
            r4 = 0
        L_0x05c5:
            boolean r2 = r2.zza((com.google.android.gms.internal.measurement.zzer) r11, (long) r5, (boolean) r4)     // Catch:{ all -> 0x063f }
            if (r2 == 0) goto L_0x05e5
            r1.zzaqs = r8     // Catch:{ all -> 0x063f }
            goto L_0x05e5
        L_0x05ce:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r4 = r4.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zzis()     // Catch:{ all -> 0x063f }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzti     // Catch:{ all -> 0x063f }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzfh.zzbl(r2)     // Catch:{ all -> 0x063f }
            r4.zze(r5, r2, r3)     // Catch:{ all -> 0x063f }
        L_0x05e5:
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()     // Catch:{ all -> 0x063f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x063f }
            r3 = 2
            boolean r2 = r2.isLoggable(r3)     // Catch:{ all -> 0x063f }
            if (r2 == 0) goto L_0x0612
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()     // Catch:{ all -> 0x063f }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.internal.measurement.zzgm r4 = r1.zzacw     // Catch:{ all -> 0x063f }
            com.google.android.gms.internal.measurement.zzff r4 = r4.zzgb()     // Catch:{ all -> 0x063f }
            java.lang.String r4 = r4.zza(r11)     // Catch:{ all -> 0x063f }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x063f }
        L_0x0612:
            com.google.android.gms.internal.measurement.zzej r2 = r31.zzje()
            r2.endTransaction()
            r31.zzld()
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()
            java.lang.String r3 = "Background event processing time, ms"
            long r4 = java.lang.System.nanoTime()
            long r6 = r4 - r20
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r8 = r6 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 / r4
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r2.zzg(r3, r4)
            return
        L_0x063f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.measurement.zzej r3 = r31.zzje()
            r3.endTransaction()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzc(com.google.android.gms.internal.measurement.zzew, com.google.android.gms.internal.measurement.zzdz):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0223, code lost:
        if (r5 != null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0246, code lost:
        if (r6 == null) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r2 = r0;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0263, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0264, code lost:
        r6 = r3;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0282, code lost:
        if (r6 != null) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r6 = null;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
        if (r3 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d5, code lost:
        if (r5 != null) goto L_0x01d7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (r0v20 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 
      PHI: (r3v48 android.database.Cursor) = (r3v42 android.database.Cursor), (r3v51 android.database.Cursor), (r3v51 android.database.Cursor), (r3v51 android.database.Cursor), (r3v51 android.database.Cursor), (r3v1 android.database.Cursor), (r3v1 android.database.Cursor) binds: [B:47:0x00e3, B:24:0x0080, B:30:0x008d, B:32:0x0091, B:33:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0289 A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0297 A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0572 A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x065b A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0675 A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0695 A[Catch:{ SQLiteException -> 0x0b26, all -> 0x0b61 }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0b49 A[SYNTHETIC, Splitter:B:433:0x0b49] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0b5d A[SYNTHETIC, Splitter:B:440:0x0b5d] */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x0672 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0123 A[SYNTHETIC, Splitter:B:60:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0145 A[SYNTHETIC, Splitter:B:69:0x0145] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:145:0x0285=Splitter:B:145:0x0285, B:98:0x01d7=Splitter:B:98:0x01d7, B:28:0x0088=Splitter:B:28:0x0088, B:124:0x0248=Splitter:B:124:0x0248} */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r60, long r61) {
        /*
            r59 = this;
            r1 = r59
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()
            r2.beginTransaction()
            com.google.android.gms.internal.measurement.zzjs$zza r2 = new com.google.android.gms.internal.measurement.zzjs$zza     // Catch:{ all -> 0x0b61 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r4 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            long r5 = r1.zzard     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0b61 }
            r4.zzab()     // Catch:{ all -> 0x0b61 }
            r4.zzch()     // Catch:{ all -> 0x0b61 }
            r7 = -1
            r9 = 2
            r10 = 0
            r11 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            if (r12 == 0) goto L_0x00a1
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x004b
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r13 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r12[r10] = r13     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r13 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r12[r11] = r13     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            goto L_0x0053
        L_0x0040:
            r0 = move-exception
            r2 = r0
            r6 = r3
            goto L_0x0b5b
        L_0x0045:
            r0 = move-exception
            r6 = r3
            r12 = r6
        L_0x0048:
            r3 = r0
            goto L_0x0271
        L_0x004b:
            java.lang.String[] r12 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r13 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r12[r10] = r13     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
        L_0x0053:
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x005a
            java.lang.String r13 = "rowid <= ? and "
            goto L_0x005c
        L_0x005a:
            java.lang.String r13 = ""
        L_0x005c:
            java.lang.String r14 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            int r14 = r14.length()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            int r14 = r14 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r3.<init>(r14)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r14 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r14)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r3.append(r13)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r13 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r13)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            android.database.Cursor r3 = r15.rawQuery(r3, r12)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            boolean r12 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0263, all -> 0x0040 }
            if (r12 != 0) goto L_0x008d
            if (r3 == 0) goto L_0x0285
        L_0x0088:
            r3.close()     // Catch:{ all -> 0x0b61 }
            goto L_0x0285
        L_0x008d:
            java.lang.String r12 = r3.getString(r10)     // Catch:{ SQLiteException -> 0x0263, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x009e, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x009e, all -> 0x0040 }
            r22 = r3
            r3 = r12
            r21 = r13
            goto L_0x00f8
        L_0x009e:
            r0 = move-exception
            r6 = r3
            goto L_0x0048
        L_0x00a1:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x00b1
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r12 = 0
            r3[r10] = r12     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r3[r11] = r12     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            goto L_0x00b6
        L_0x00b1:
            java.lang.String[] r3 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r12 = 0
            r3[r10] = r12     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
        L_0x00b6:
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00bd
            java.lang.String r12 = " and rowid <= ?"
            goto L_0x00bf
        L_0x00bd:
            java.lang.String r12 = ""
        L_0x00bf:
            java.lang.String r13 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            int r13 = r13.length()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            int r13 = r13 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r13 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r13)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            r14.append(r12)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r12 = " order by rowid limit 1;"
            r14.append(r12)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            java.lang.String r12 = r14.toString()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            android.database.Cursor r3 = r15.rawQuery(r12, r3)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0268 }
            boolean r12 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0263, all -> 0x0040 }
            if (r12 != 0) goto L_0x00ec
            if (r3 == 0) goto L_0x0285
            goto L_0x0088
        L_0x00ec:
            java.lang.String r13 = r3.getString(r10)     // Catch:{ SQLiteException -> 0x0263, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0263, all -> 0x0040 }
            r22 = r3
            r21 = r13
            r3 = 0
        L_0x00f8:
            java.lang.String r13 = "raw_events_metadata"
            java.lang.String[] r14 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            java.lang.String r12 = "metadata"
            r14[r10] = r12     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            java.lang.String r16 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r12[r10] = r3     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r12[r11] = r21     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "2"
            r23 = r12
            r12 = r15
            r24 = r15
            r15 = r16
            r16 = r23
            android.database.Cursor r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            boolean r12 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            if (r12 != 0) goto L_0x0145
            com.google.android.gms.internal.measurement.zzfh r5 = r4.zzgf()     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r5.zzg(r6, r12)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            if (r15 == 0) goto L_0x0285
            r15.close()     // Catch:{ all -> 0x0b61 }
            goto L_0x0285
        L_0x013b:
            r0 = move-exception
            r2 = r0
            r6 = r15
            goto L_0x0b5b
        L_0x0140:
            r0 = move-exception
            r12 = r3
            r6 = r15
            goto L_0x0048
        L_0x0145:
            byte[] r12 = r15.getBlob(r10)     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            int r13 = r12.length     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            com.google.android.gms.internal.measurement.zzabx r12 = com.google.android.gms.internal.measurement.zzabx.zza(r12, r10, r13)     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            com.google.android.gms.internal.measurement.zzks r13 = new com.google.android.gms.internal.measurement.zzks     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r13.<init>()     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r13.zzb(r12)     // Catch:{ IOException -> 0x0233 }
            boolean r12 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            if (r12 == 0) goto L_0x016d
            com.google.android.gms.internal.measurement.zzfh r12 = r4.zzgf()     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            com.google.android.gms.internal.measurement.zzfj r12 = r12.zziv()     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r12.zzg(r14, r9)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
        L_0x016d:
            r15.close()     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r2.zzb(r13)     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r14 = 3
            if (r9 == 0) goto L_0x018b
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r12[r10] = r3     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r12[r11] = r21     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r6 = 2
            r12[r6] = r5     // Catch:{ SQLiteException -> 0x0140, all -> 0x013b }
            r5 = r9
            r16 = r12
            goto L_0x0196
        L_0x018b:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r9[r10] = r3     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r9[r11] = r21     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r16 = r9
        L_0x0196:
            java.lang.String r13 = "raw_events"
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            java.lang.String r9 = "rowid"
            r6[r10] = r9     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            java.lang.String r9 = "name"
            r6[r11] = r9     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            java.lang.String r9 = "timestamp"
            r12 = 2
            r6[r12] = r9     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            java.lang.String r9 = "data"
            r6[r14] = r9     // Catch:{ SQLiteException -> 0x0252, all -> 0x024e }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            r20 = 0
            r12 = r24
            r9 = 3
            r14 = r6
            r6 = r15
            r15 = r5
            android.database.Cursor r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x024c }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x01dc
            com.google.android.gms.internal.measurement.zzfh r6 = r4.zzgf()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zziv()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            java.lang.String r9 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r6.zzg(r9, r12)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r5 == 0) goto L_0x0285
        L_0x01d7:
            r5.close()     // Catch:{ all -> 0x0b61 }
            goto L_0x0285
        L_0x01dc:
            long r12 = r5.getLong(r10)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            byte[] r6 = r5.getBlob(r9)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            int r14 = r6.length     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.zzabx r6 = com.google.android.gms.internal.measurement.zzabx.zza(r6, r10, r14)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.zzkp r14 = new com.google.android.gms.internal.measurement.zzkp     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r14.<init>()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r14.zzb(r6)     // Catch:{ IOException -> 0x020b }
            java.lang.String r6 = r5.getString(r11)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r14.name = r6     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r6 = 2
            long r7 = r5.getLong(r6)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r14.zzatn = r6     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            boolean r6 = r2.zza(r12, r14)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x021d
            if (r5 == 0) goto L_0x0285
            goto L_0x01d7
        L_0x020b:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfh r6 = r4.zzgf()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zzis()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            java.lang.String r7 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r6.zze(r7, r8, r0)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
        L_0x021d:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x0226
            if (r5 == 0) goto L_0x0285
            goto L_0x01d7
        L_0x0226:
            r7 = -1
            goto L_0x01dc
        L_0x0229:
            r0 = move-exception
            r2 = r0
            r6 = r5
            goto L_0x0b5b
        L_0x022e:
            r0 = move-exception
            r12 = r3
            r6 = r5
            goto L_0x0048
        L_0x0233:
            r0 = move-exception
            r6 = r15
            com.google.android.gms.internal.measurement.zzfh r5 = r4.zzgf()     // Catch:{ SQLiteException -> 0x024c }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ SQLiteException -> 0x024c }
            java.lang.String r7 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)     // Catch:{ SQLiteException -> 0x024c }
            r5.zze(r7, r8, r0)     // Catch:{ SQLiteException -> 0x024c }
            if (r6 == 0) goto L_0x0285
        L_0x0248:
            r6.close()     // Catch:{ all -> 0x0b61 }
            goto L_0x0285
        L_0x024c:
            r0 = move-exception
            goto L_0x0254
        L_0x024e:
            r0 = move-exception
            r6 = r15
            goto L_0x0b5a
        L_0x0252:
            r0 = move-exception
            r6 = r15
        L_0x0254:
            r12 = r3
            goto L_0x0048
        L_0x0257:
            r0 = move-exception
            r2 = r0
            r6 = r22
            goto L_0x0b5b
        L_0x025d:
            r0 = move-exception
            r12 = r3
            r6 = r22
            goto L_0x0048
        L_0x0263:
            r0 = move-exception
            r6 = r3
            r12 = 0
            goto L_0x0048
        L_0x0268:
            r0 = move-exception
            r2 = r0
            r6 = 0
            goto L_0x0b5b
        L_0x026d:
            r0 = move-exception
            r3 = r0
            r6 = 0
            r12 = 0
        L_0x0271:
            com.google.android.gms.internal.measurement.zzfh r4 = r4.zzgf()     // Catch:{ all -> 0x0b59 }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zzis()     // Catch:{ all -> 0x0b59 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r12)     // Catch:{ all -> 0x0b59 }
            r4.zze(r5, r7, r3)     // Catch:{ all -> 0x0b59 }
            if (r6 == 0) goto L_0x0285
            goto L_0x0248
        L_0x0285:
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r3 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            if (r3 == 0) goto L_0x0294
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r3 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0b61 }
            if (r3 == 0) goto L_0x0292
            goto L_0x0294
        L_0x0292:
            r3 = 0
            goto L_0x0295
        L_0x0294:
            r3 = 1
        L_0x0295:
            if (r3 != 0) goto L_0x0b49
            com.google.android.gms.internal.measurement.zzks r3 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r4 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            int r4 = r4.size()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r4 = new com.google.android.gms.internal.measurement.zzkp[r4]     // Catch:{ all -> 0x0b61 }
            r3.zzatu = r4     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r4 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzeg r4 = r4.zzgh()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r3.zzti     // Catch:{ all -> 0x0b61 }
            boolean r4 = r4.zzau(r5)     // Catch:{ all -> 0x0b61 }
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 0
        L_0x02b4:
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r14 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            int r14 = r14.size()     // Catch:{ all -> 0x0b61 }
            if (r7 >= r14) goto L_0x05c9
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r14 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            java.lang.Object r14 = r14.get(r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp r14 = (com.google.android.gms.internal.measurement.zzkp) r14     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgg r15 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r11 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r11 = r11.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r15.zzn(r11, r5)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0340
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzks r11 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r11 = r11.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r11 = com.google.android.gms.internal.measurement.zzfh.zzbl(r11)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r15 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzff r15 = r15.zzgb()     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r14.name     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r15.zzbi(r10)     // Catch:{ all -> 0x0b61 }
            r5.zze(r6, r11, r10)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgg r5 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r6 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.zzbx(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x0316
            com.google.android.gms.internal.measurement.zzgg r5 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r6 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.zzby(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0314
            goto L_0x0316
        L_0x0314:
            r5 = 0
            goto L_0x0317
        L_0x0316:
            r5 = 1
        L_0x0317:
            if (r5 != 0) goto L_0x033c
            java.lang.String r5 = "_err"
            java.lang.String r6 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x033c
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkc r15 = r5.zzgc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r5 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r5.zzti     // Catch:{ all -> 0x0b61 }
            r17 = 11
            java.lang.String r18 = "_ev"
            java.lang.String r6 = r14.name     // Catch:{ all -> 0x0b61 }
            r20 = 0
            r16 = r5
            r19 = r6
            r15.zza((java.lang.String) r16, (int) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20)     // Catch:{ all -> 0x0b61 }
        L_0x033c:
            r28 = r7
            goto L_0x05c3
        L_0x0340:
            com.google.android.gms.internal.measurement.zzgg r5 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r6 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.zzo(r6, r10)     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x0362
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            r6.zzgc()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r6 = com.google.android.gms.internal.measurement.zzkc.zzck(r6)     // Catch:{ all -> 0x0b61 }
            if (r6 == 0) goto L_0x035e
            goto L_0x0362
        L_0x035e:
            r28 = r7
            goto L_0x0562
        L_0x0362:
            com.google.android.gms.internal.measurement.zzkq[] r6 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            if (r6 != 0) goto L_0x036b
            r6 = 0
            com.google.android.gms.internal.measurement.zzkq[] r10 = new com.google.android.gms.internal.measurement.zzkq[r6]     // Catch:{ all -> 0x0b61 }
            r14.zzatm = r10     // Catch:{ all -> 0x0b61 }
        L_0x036b:
            com.google.android.gms.internal.measurement.zzkq[] r6 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r10 = r6.length     // Catch:{ all -> 0x0b61 }
            r11 = 0
            r15 = 0
            r16 = 0
        L_0x0372:
            if (r11 >= r10) goto L_0x03b3
            r25 = r10
            r10 = r6[r11]     // Catch:{ all -> 0x0b61 }
            r26 = r6
            java.lang.String r6 = "_c"
            r27 = r8
            java.lang.String r8 = r10.name     // Catch:{ all -> 0x0b61 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0b61 }
            if (r6 == 0) goto L_0x0392
            r28 = r7
            r6 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r10.zzatq = r8     // Catch:{ all -> 0x0b61 }
            r15 = 1
            goto L_0x03a8
        L_0x0392:
            r28 = r7
            java.lang.String r6 = "_r"
            java.lang.String r7 = r10.name     // Catch:{ all -> 0x0b61 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0b61 }
            if (r6 == 0) goto L_0x03a8
            r6 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r10.zzatq = r8     // Catch:{ all -> 0x0b61 }
            r16 = 1
        L_0x03a8:
            int r11 = r11 + 1
            r10 = r25
            r6 = r26
            r8 = r27
            r7 = r28
            goto L_0x0372
        L_0x03b3:
            r28 = r7
            r27 = r8
            if (r15 != 0) goto L_0x03fb
            if (r5 == 0) goto L_0x03fb
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r6 = r6.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zziz()     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = "Marking event as conversion"
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzff r8 = r8.zzgb()     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r14.name     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = r8.zzbi(r10)     // Catch:{ all -> 0x0b61 }
            r6.zzg(r7, r8)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r6 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r7 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            r8 = 1
            int r7 = r7 + r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r6 = (com.google.android.gms.internal.measurement.zzkq[]) r6     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq r7 = new com.google.android.gms.internal.measurement.zzkq     // Catch:{ all -> 0x0b61 }
            r7.<init>()     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = "_c"
            r7.name = r8     // Catch:{ all -> 0x0b61 }
            r10 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0b61 }
            r7.zzatq = r8     // Catch:{ all -> 0x0b61 }
            int r8 = r6.length     // Catch:{ all -> 0x0b61 }
            r10 = 1
            int r8 = r8 - r10
            r6[r8] = r7     // Catch:{ all -> 0x0b61 }
            r14.zzatm = r6     // Catch:{ all -> 0x0b61 }
        L_0x03fb:
            if (r16 != 0) goto L_0x043d
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r6 = r6.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zziz()     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = "Marking event as real-time"
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzff r8 = r8.zzgb()     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r14.name     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = r8.zzbi(r10)     // Catch:{ all -> 0x0b61 }
            r6.zzg(r7, r8)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r6 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r7 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            r8 = 1
            int r7 = r7 + r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r6 = (com.google.android.gms.internal.measurement.zzkq[]) r6     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq r7 = new com.google.android.gms.internal.measurement.zzkq     // Catch:{ all -> 0x0b61 }
            r7.<init>()     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = "_r"
            r7.name = r8     // Catch:{ all -> 0x0b61 }
            r10 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0b61 }
            r7.zzatq = r8     // Catch:{ all -> 0x0b61 }
            int r8 = r6.length     // Catch:{ all -> 0x0b61 }
            r10 = 1
            int r8 = r8 - r10
            r6[r8] = r7     // Catch:{ all -> 0x0b61 }
            r14.zzatm = r6     // Catch:{ all -> 0x0b61 }
        L_0x043d:
            com.google.android.gms.internal.measurement.zzej r29 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            long r30 = r59.zzla()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r6 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x0b61 }
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 1
            r32 = r6
            com.google.android.gms.internal.measurement.zzek r6 = r29.zza(r30, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0b61 }
            long r6 = r6.zzafi     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzeg r8 = r8.zzgh()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r10 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r10.zzti     // Catch:{ all -> 0x0b61 }
            int r8 = r8.zzaq(r10)     // Catch:{ all -> 0x0b61 }
            long r10 = (long) r8     // Catch:{ all -> 0x0b61 }
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x04a6
            r6 = 0
        L_0x046f:
            com.google.android.gms.internal.measurement.zzkq[] r7 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            if (r6 >= r7) goto L_0x04a3
            java.lang.String r7 = "_r"
            com.google.android.gms.internal.measurement.zzkq[] r8 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            r8 = r8[r6]     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x0b61 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x04a0
            com.google.android.gms.internal.measurement.zzkq[] r7 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            r8 = 1
            int r7 = r7 - r8
            com.google.android.gms.internal.measurement.zzkq[] r7 = new com.google.android.gms.internal.measurement.zzkq[r7]     // Catch:{ all -> 0x0b61 }
            if (r6 <= 0) goto L_0x0491
            com.google.android.gms.internal.measurement.zzkq[] r8 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            r10 = 0
            java.lang.System.arraycopy(r8, r10, r7, r10, r6)     // Catch:{ all -> 0x0b61 }
        L_0x0491:
            int r8 = r7.length     // Catch:{ all -> 0x0b61 }
            if (r6 >= r8) goto L_0x049d
            com.google.android.gms.internal.measurement.zzkq[] r8 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r10 = r6 + 1
            int r11 = r7.length     // Catch:{ all -> 0x0b61 }
            int r11 = r11 - r6
            java.lang.System.arraycopy(r8, r10, r7, r6, r11)     // Catch:{ all -> 0x0b61 }
        L_0x049d:
            r14.zzatm = r7     // Catch:{ all -> 0x0b61 }
            goto L_0x04a3
        L_0x04a0:
            int r6 = r6 + 1
            goto L_0x046f
        L_0x04a3:
            r8 = r27
            goto L_0x04a7
        L_0x04a6:
            r8 = 1
        L_0x04a7:
            java.lang.String r6 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r6 = com.google.android.gms.internal.measurement.zzkc.zzcb(r6)     // Catch:{ all -> 0x0b61 }
            if (r6 == 0) goto L_0x0562
            if (r5 == 0) goto L_0x0562
            com.google.android.gms.internal.measurement.zzej r29 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            long r30 = r59.zzla()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r5 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r5.zzti     // Catch:{ all -> 0x0b61 }
            r33 = 0
            r34 = 0
            r35 = 1
            r36 = 0
            r37 = 0
            r32 = r5
            com.google.android.gms.internal.measurement.zzek r5 = r29.zza(r30, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0b61 }
            long r5 = r5.zzafg     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r7 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzeg r7 = r7.zzgh()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r10 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r10.zzti     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r11 = com.google.android.gms.internal.measurement.zzey.zzahc     // Catch:{ all -> 0x0b61 }
            int r7 = r7.zzb(r10, r11)     // Catch:{ all -> 0x0b61 }
            long r10 = (long) r7     // Catch:{ all -> 0x0b61 }
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x0562
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
            r5.zzg(r6, r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r5 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r6 = r5.length     // Catch:{ all -> 0x0b61 }
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x0501:
            if (r7 >= r6) goto L_0x0527
            r15 = r5[r7]     // Catch:{ all -> 0x0b61 }
            r38 = r5
            java.lang.String r5 = "_c"
            r39 = r6
            java.lang.String r6 = r15.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0515
            r11 = r15
            goto L_0x0520
        L_0x0515:
            java.lang.String r5 = "_err"
            java.lang.String r6 = r15.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0520
            r10 = 1
        L_0x0520:
            int r7 = r7 + 1
            r5 = r38
            r6 = r39
            goto L_0x0501
        L_0x0527:
            if (r10 == 0) goto L_0x053c
            if (r11 == 0) goto L_0x053c
            com.google.android.gms.internal.measurement.zzkq[] r5 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzkq[] r7 = new com.google.android.gms.internal.measurement.zzkq[r6]     // Catch:{ all -> 0x0b61 }
            r6 = 0
            r7[r6] = r11     // Catch:{ all -> 0x0b61 }
            java.lang.Object[] r5 = com.google.android.gms.common.util.ArrayUtils.removeAll((T[]) r5, (T[]) r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r5 = (com.google.android.gms.internal.measurement.zzkq[]) r5     // Catch:{ all -> 0x0b61 }
            r14.zzatm = r5     // Catch:{ all -> 0x0b61 }
            goto L_0x0562
        L_0x053c:
            if (r11 == 0) goto L_0x054b
            java.lang.String r5 = "_err"
            r11.name = r5     // Catch:{ all -> 0x0b61 }
            r5 = 10
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b61 }
            r11.zzatq = r5     // Catch:{ all -> 0x0b61 }
            goto L_0x0562
        L_0x054b:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
            r5.zzg(r6, r7)     // Catch:{ all -> 0x0b61 }
        L_0x0562:
            if (r4 == 0) goto L_0x05ba
            java.lang.String r5 = "_e"
            java.lang.String r6 = r14.name     // Catch:{ all -> 0x0b61 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x05ba
            com.google.android.gms.internal.measurement.zzkq[] r5 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x05a5
            com.google.android.gms.internal.measurement.zzkq[] r5 = r14.zzatm     // Catch:{ all -> 0x0b61 }
            int r5 = r5.length     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x0578
            goto L_0x05a5
        L_0x0578:
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = "_et"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzjy.zzb(r14, r5)     // Catch:{ all -> 0x0b61 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x059d
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
        L_0x0599:
            r5.zzg(r6, r7)     // Catch:{ all -> 0x0b61 }
            goto L_0x05ba
        L_0x059d:
            long r5 = r5.longValue()     // Catch:{ all -> 0x0b61 }
            r7 = 0
            long r10 = r12 + r5
            goto L_0x05bb
        L_0x05a5:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
            goto L_0x0599
        L_0x05ba:
            r10 = r12
        L_0x05bb:
            com.google.android.gms.internal.measurement.zzkp[] r5 = r3.zzatu     // Catch:{ all -> 0x0b61 }
            int r6 = r9 + 1
            r5[r9] = r14     // Catch:{ all -> 0x0b61 }
            r9 = r6
            r12 = r10
        L_0x05c3:
            int r7 = r28 + 1
            r10 = 0
            r11 = 1
            goto L_0x02b4
        L_0x05c9:
            r27 = r8
            java.util.List<com.google.android.gms.internal.measurement.zzkp> r5 = r2.zzarj     // Catch:{ all -> 0x0b61 }
            int r5 = r5.size()     // Catch:{ all -> 0x0b61 }
            if (r9 >= r5) goto L_0x05dd
            com.google.android.gms.internal.measurement.zzkp[] r5 = r3.zzatu     // Catch:{ all -> 0x0b61 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r9)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r5 = (com.google.android.gms.internal.measurement.zzkp[]) r5     // Catch:{ all -> 0x0b61 }
            r3.zzatu = r5     // Catch:{ all -> 0x0b61 }
        L_0x05dd:
            if (r4 == 0) goto L_0x06ad
            com.google.android.gms.internal.measurement.zzej r4 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r3.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "_lte"
            com.google.android.gms.internal.measurement.zzkb r4 = r4.zzh(r5, r6)     // Catch:{ all -> 0x0b61 }
            if (r4 == 0) goto L_0x0619
            java.lang.Object r5 = r4.value     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x05f2
            goto L_0x0619
        L_0x05f2:
            com.google.android.gms.internal.measurement.zzkb r5 = new com.google.android.gms.internal.measurement.zzkb     // Catch:{ all -> 0x0b61 }
            java.lang.String r15 = r3.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r16 = "auto"
            java.lang.String r17 = "_lte"
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbt()     // Catch:{ all -> 0x0b61 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x0b61 }
            java.lang.Object r4 = r4.value     // Catch:{ all -> 0x0b61 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0b61 }
            long r6 = r4.longValue()     // Catch:{ all -> 0x0b61 }
            r4 = 0
            long r8 = r6 + r12
            java.lang.Long r20 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0b61 }
            r14 = r5
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ all -> 0x0b61 }
            r4 = r5
            goto L_0x0636
        L_0x0619:
            com.google.android.gms.internal.measurement.zzkb r4 = new com.google.android.gms.internal.measurement.zzkb     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r3.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r30 = "auto"
            java.lang.String r31 = "_lte"
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbt()     // Catch:{ all -> 0x0b61 }
            long r32 = r6.currentTimeMillis()     // Catch:{ all -> 0x0b61 }
            java.lang.Long r34 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0b61 }
            r28 = r4
            r29 = r5
            r28.<init>(r29, r30, r31, r32, r34)     // Catch:{ all -> 0x0b61 }
        L_0x0636:
            com.google.android.gms.internal.measurement.zzku r5 = new com.google.android.gms.internal.measurement.zzku     // Catch:{ all -> 0x0b61 }
            r5.<init>()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "_lte"
            r5.name = r6     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbt()     // Catch:{ all -> 0x0b61 }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r5.zzauz = r6     // Catch:{ all -> 0x0b61 }
            java.lang.Object r6 = r4.value     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0b61 }
            r5.zzatq = r6     // Catch:{ all -> 0x0b61 }
            r6 = 0
        L_0x0656:
            com.google.android.gms.internal.measurement.zzku[] r7 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            if (r6 >= r7) goto L_0x0672
            java.lang.String r7 = "_lte"
            com.google.android.gms.internal.measurement.zzku[] r8 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            r8 = r8[r6]     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x0b61 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x066f
            com.google.android.gms.internal.measurement.zzku[] r7 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            r7[r6] = r5     // Catch:{ all -> 0x0b61 }
            r6 = 1
            goto L_0x0673
        L_0x066f:
            int r6 = r6 + 1
            goto L_0x0656
        L_0x0672:
            r6 = 0
        L_0x0673:
            if (r6 != 0) goto L_0x068f
            com.google.android.gms.internal.measurement.zzku[] r6 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzku[] r7 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            r8 = 1
            int r7 = r7 + r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzku[] r6 = (com.google.android.gms.internal.measurement.zzku[]) r6     // Catch:{ all -> 0x0b61 }
            r3.zzatv = r6     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzku[] r6 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r7 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzku[] r7 = r7.zzatv     // Catch:{ all -> 0x0b61 }
            int r7 = r7.length     // Catch:{ all -> 0x0b61 }
            r8 = 1
            int r7 = r7 - r8
            r6[r7] = r5     // Catch:{ all -> 0x0b61 }
        L_0x068f:
            r5 = 0
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x06ad
            com.google.android.gms.internal.measurement.zzej r5 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            r5.zza((com.google.android.gms.internal.measurement.zzkb) r4)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziy()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Updated lifetime engagement user property with value. Value"
            java.lang.Object r4 = r4.value     // Catch:{ all -> 0x0b61 }
            r5.zzg(r6, r4)     // Catch:{ all -> 0x0b61 }
        L_0x06ad:
            java.lang.String r4 = r3.zzti     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzku[] r5 = r3.zzatv     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r6 = r3.zzatu     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzko[] r4 = r1.zza(r4, r5, r6)     // Catch:{ all -> 0x0b61 }
            r3.zzaum = r4     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r4 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzeg r4 = r4.zzgh()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r5 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r5.zzti     // Catch:{ all -> 0x0b61 }
            boolean r4 = r4.zzat(r5)     // Catch:{ all -> 0x0b61 }
            if (r4 == 0) goto L_0x0986
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0b61 }
            r4.<init>()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r5 = r3.zzatu     // Catch:{ all -> 0x0b61 }
            int r5 = r5.length     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r5 = new com.google.android.gms.internal.measurement.zzkp[r5]     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgm r6 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkc r6 = r6.zzgc()     // Catch:{ all -> 0x0b61 }
            java.security.SecureRandom r6 = r6.zzll()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r7 = r3.zzatu     // Catch:{ all -> 0x0b61 }
            int r8 = r7.length     // Catch:{ all -> 0x0b61 }
            r9 = 0
            r10 = 0
        L_0x06e2:
            if (r9 >= r8) goto L_0x0954
            r11 = r7[r9]     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = r11.name     // Catch:{ all -> 0x0b61 }
            java.lang.String r13 = "_ep"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0b61 }
            if (r12 == 0) goto L_0x076f
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = "_en"
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzjy.zzb(r11, r12)     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0b61 }
            java.lang.Object r13 = r4.get(r12)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r13 = (com.google.android.gms.internal.measurement.zzes) r13     // Catch:{ all -> 0x0b61 }
            if (r13 != 0) goto L_0x0712
            com.google.android.gms.internal.measurement.zzej r13 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r14 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r14 = r14.zzti     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r13 = r13.zzf(r14, r12)     // Catch:{ all -> 0x0b61 }
            r4.put(r12, r13)     // Catch:{ all -> 0x0b61 }
        L_0x0712:
            java.lang.Long r12 = r13.zzafw     // Catch:{ all -> 0x0b61 }
            if (r12 != 0) goto L_0x0766
            java.lang.Long r12 = r13.zzafx     // Catch:{ all -> 0x0b61 }
            long r14 = r12.longValue()     // Catch:{ all -> 0x0b61 }
            r16 = 1
            int r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r12 <= 0) goto L_0x0731
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r12 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            java.lang.String r14 = "_sr"
            java.lang.Long r15 = r13.zzafx     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r12 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkq[]) r12, (java.lang.String) r14, (java.lang.Object) r15)     // Catch:{ all -> 0x0b61 }
            r11.zzatm = r12     // Catch:{ all -> 0x0b61 }
        L_0x0731:
            java.lang.Boolean r12 = r13.zzafy     // Catch:{ all -> 0x0b61 }
            if (r12 == 0) goto L_0x0753
            java.lang.Boolean r12 = r13.zzafy     // Catch:{ all -> 0x0b61 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0b61 }
            if (r12 == 0) goto L_0x0753
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r12 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            java.lang.String r13 = "_efs"
            r40 = r7
            r14 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r7 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkq[]) r12, (java.lang.String) r13, (java.lang.Object) r7)     // Catch:{ all -> 0x0b61 }
            r11.zzatm = r7     // Catch:{ all -> 0x0b61 }
            goto L_0x0755
        L_0x0753:
            r40 = r7
        L_0x0755:
            int r7 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0b61 }
            r57 = r2
            r58 = r3
            r56 = r6
            r10 = r7
        L_0x0760:
            r41 = r8
        L_0x0762:
            r14 = 1
            goto L_0x0946
        L_0x0766:
            r40 = r7
            r57 = r2
            r58 = r3
            r56 = r6
            goto L_0x0760
        L_0x076f:
            r40 = r7
            java.lang.String r7 = "_dbg"
            r12 = 1
            java.lang.Long r14 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0b61 }
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0b61 }
            if (r12 != 0) goto L_0x07c3
            if (r14 != 0) goto L_0x0782
            goto L_0x07c3
        L_0x0782:
            com.google.android.gms.internal.measurement.zzkq[] r12 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            int r13 = r12.length     // Catch:{ all -> 0x0b61 }
            r15 = 0
        L_0x0786:
            if (r15 >= r13) goto L_0x07c3
            r41 = r8
            r8 = r12[r15]     // Catch:{ all -> 0x0b61 }
            r42 = r12
            java.lang.String r12 = r8.name     // Catch:{ all -> 0x0b61 }
            boolean r12 = r7.equals(r12)     // Catch:{ all -> 0x0b61 }
            if (r12 == 0) goto L_0x07bc
            boolean r7 = r14 instanceof java.lang.Long     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x07a2
            java.lang.Long r7 = r8.zzatq     // Catch:{ all -> 0x0b61 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0b61 }
            if (r7 != 0) goto L_0x07ba
        L_0x07a2:
            boolean r7 = r14 instanceof java.lang.String     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x07ae
            java.lang.String r7 = r8.zzajo     // Catch:{ all -> 0x0b61 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0b61 }
            if (r7 != 0) goto L_0x07ba
        L_0x07ae:
            boolean r7 = r14 instanceof java.lang.Double     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x07c5
            java.lang.Double r7 = r8.zzaro     // Catch:{ all -> 0x0b61 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0b61 }
            if (r7 == 0) goto L_0x07c5
        L_0x07ba:
            r7 = 1
            goto L_0x07c6
        L_0x07bc:
            int r15 = r15 + 1
            r8 = r41
            r12 = r42
            goto L_0x0786
        L_0x07c3:
            r41 = r8
        L_0x07c5:
            r7 = 0
        L_0x07c6:
            if (r7 != 0) goto L_0x07d7
            com.google.android.gms.internal.measurement.zzgg r7 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r8 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r8 = r8.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = r11.name     // Catch:{ all -> 0x0b61 }
            int r7 = r7.zzp(r8, r12)     // Catch:{ all -> 0x0b61 }
            goto L_0x07d8
        L_0x07d7:
            r7 = 1
        L_0x07d8:
            if (r7 > 0) goto L_0x07fc
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = "Sample rate must be positive. event, rate"
            java.lang.String r13 = r11.name     // Catch:{ all -> 0x0b61 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0b61 }
            r8.zze(r12, r13, r7)     // Catch:{ all -> 0x0b61 }
            int r7 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0b61 }
        L_0x07f3:
            r57 = r2
            r58 = r3
            r56 = r6
            r10 = r7
            goto L_0x0762
        L_0x07fc:
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0b61 }
            java.lang.Object r8 = r4.get(r8)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r8 = (com.google.android.gms.internal.measurement.zzes) r8     // Catch:{ all -> 0x0b61 }
            if (r8 != 0) goto L_0x084e
            com.google.android.gms.internal.measurement.zzej r8 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r12 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = r12.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r13 = r11.name     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r8 = r8.zzf(r12, r13)     // Catch:{ all -> 0x0b61 }
            if (r8 != 0) goto L_0x084e
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzks r13 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r13 = r13.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r14 = r11.name     // Catch:{ all -> 0x0b61 }
            r8.zze(r12, r13, r14)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r8 = new com.google.android.gms.internal.measurement.zzes     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r12 = r2.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = r12.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.String r13 = r11.name     // Catch:{ all -> 0x0b61 }
            r45 = 1
            r47 = 1
            java.lang.Long r14 = r11.zzatn     // Catch:{ all -> 0x0b61 }
            long r49 = r14.longValue()     // Catch:{ all -> 0x0b61 }
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r42 = r8
            r43 = r12
            r44 = r13
            r42.<init>(r43, r44, r45, r47, r49, r51, r53, r54, r55)     // Catch:{ all -> 0x0b61 }
        L_0x084e:
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            java.lang.String r12 = "_eid"
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzjy.zzb(r11, r12)     // Catch:{ all -> 0x0b61 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0b61 }
            if (r12 == 0) goto L_0x085d
            r13 = 1
            goto L_0x085e
        L_0x085d:
            r13 = 0
        L_0x085e:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0b61 }
            r14 = 1
            if (r7 != r14) goto L_0x0887
            int r7 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0b61 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0b61 }
            if (r10 == 0) goto L_0x07f3
            java.lang.Long r10 = r8.zzafw     // Catch:{ all -> 0x0b61 }
            if (r10 != 0) goto L_0x087b
            java.lang.Long r10 = r8.zzafx     // Catch:{ all -> 0x0b61 }
            if (r10 != 0) goto L_0x087b
            java.lang.Boolean r10 = r8.zzafy     // Catch:{ all -> 0x0b61 }
            if (r10 == 0) goto L_0x07f3
        L_0x087b:
            r10 = 0
            com.google.android.gms.internal.measurement.zzes r8 = r8.zza(r10, r10, r10)     // Catch:{ all -> 0x0b61 }
            java.lang.String r10 = r11.name     // Catch:{ all -> 0x0b61 }
            r4.put(r10, r8)     // Catch:{ all -> 0x0b61 }
            goto L_0x07f3
        L_0x0887:
            int r14 = r6.nextInt(r7)     // Catch:{ all -> 0x0b61 }
            if (r14 != 0) goto L_0x08ca
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r12 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            java.lang.String r14 = "_sr"
            r56 = r6
            long r6 = (long) r7     // Catch:{ all -> 0x0b61 }
            java.lang.Long r15 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r12 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkq[]) r12, (java.lang.String) r14, (java.lang.Object) r15)     // Catch:{ all -> 0x0b61 }
            r11.zzatm = r12     // Catch:{ all -> 0x0b61 }
            int r12 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0b61 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0b61 }
            if (r10 == 0) goto L_0x08b4
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r7 = 0
            com.google.android.gms.internal.measurement.zzes r8 = r8.zza(r7, r6, r7)     // Catch:{ all -> 0x0b61 }
        L_0x08b4:
            java.lang.String r6 = r11.name     // Catch:{ all -> 0x0b61 }
            java.lang.Long r7 = r11.zzatn     // Catch:{ all -> 0x0b61 }
            long r10 = r7.longValue()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r7 = r8.zzad(r10)     // Catch:{ all -> 0x0b61 }
            r4.put(r6, r7)     // Catch:{ all -> 0x0b61 }
            r57 = r2
            r58 = r3
            r10 = r12
            goto L_0x0762
        L_0x08ca:
            r56 = r6
            long r14 = r8.zzafv     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = r11.zzatn     // Catch:{ all -> 0x0b61 }
            long r16 = r6.longValue()     // Catch:{ all -> 0x0b61 }
            r6 = 0
            r57 = r2
            r58 = r3
            long r2 = r16 - r14
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0b61 }
            r14 = 86400000(0x5265c00, double:4.2687272E-316)
            int r6 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r6 < 0) goto L_0x0934
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r2 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            java.lang.String r3 = "_efs"
            r14 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r2 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkq[]) r2, (java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x0b61 }
            r11.zzatm = r2     // Catch:{ all -> 0x0b61 }
            r59.zzjc()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r2 = r11.zzatm     // Catch:{ all -> 0x0b61 }
            java.lang.String r3 = "_sr"
            long r6 = (long) r7     // Catch:{ all -> 0x0b61 }
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkq[] r2 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkq[]) r2, (java.lang.String) r3, (java.lang.Object) r12)     // Catch:{ all -> 0x0b61 }
            r11.zzatm = r2     // Catch:{ all -> 0x0b61 }
            int r2 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0b61 }
            boolean r3 = r13.booleanValue()     // Catch:{ all -> 0x0b61 }
            if (r3 == 0) goto L_0x0923
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r6 = 0
            com.google.android.gms.internal.measurement.zzes r8 = r8.zza(r6, r3, r7)     // Catch:{ all -> 0x0b61 }
        L_0x0923:
            java.lang.String r3 = r11.name     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = r11.zzatn     // Catch:{ all -> 0x0b61 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r6 = r8.zzad(r6)     // Catch:{ all -> 0x0b61 }
            r4.put(r3, r6)     // Catch:{ all -> 0x0b61 }
            r10 = r2
            goto L_0x0946
        L_0x0934:
            r14 = 1
            boolean r2 = r13.booleanValue()     // Catch:{ all -> 0x0b61 }
            if (r2 == 0) goto L_0x0946
            java.lang.String r2 = r11.name     // Catch:{ all -> 0x0b61 }
            r3 = 0
            com.google.android.gms.internal.measurement.zzes r6 = r8.zza(r12, r3, r3)     // Catch:{ all -> 0x0b61 }
            r4.put(r2, r6)     // Catch:{ all -> 0x0b61 }
        L_0x0946:
            int r9 = r9 + 1
            r7 = r40
            r8 = r41
            r6 = r56
            r2 = r57
            r3 = r58
            goto L_0x06e2
        L_0x0954:
            r57 = r2
            r2 = r3
            com.google.android.gms.internal.measurement.zzkp[] r3 = r2.zzatu     // Catch:{ all -> 0x0b61 }
            int r3 = r3.length     // Catch:{ all -> 0x0b61 }
            if (r10 >= r3) goto L_0x0964
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r5, r10)     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkp[] r3 = (com.google.android.gms.internal.measurement.zzkp[]) r3     // Catch:{ all -> 0x0b61 }
            r2.zzatu = r3     // Catch:{ all -> 0x0b61 }
        L_0x0964:
            java.util.Set r3 = r4.entrySet()     // Catch:{ all -> 0x0b61 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0b61 }
        L_0x096c:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0b61 }
            if (r4 == 0) goto L_0x0989
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0b61 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r5 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzes r4 = (com.google.android.gms.internal.measurement.zzes) r4     // Catch:{ all -> 0x0b61 }
            r5.zza((com.google.android.gms.internal.measurement.zzes) r4)     // Catch:{ all -> 0x0b61 }
            goto L_0x096c
        L_0x0986:
            r57 = r2
            r2 = r3
        L_0x0989:
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0b61 }
            r2.zzatx = r3     // Catch:{ all -> 0x0b61 }
            r3 = -9223372036854775808
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0b61 }
            r2.zzaty = r3     // Catch:{ all -> 0x0b61 }
            r3 = 0
        L_0x099d:
            com.google.android.gms.internal.measurement.zzkp[] r4 = r2.zzatu     // Catch:{ all -> 0x0b61 }
            int r4 = r4.length     // Catch:{ all -> 0x0b61 }
            if (r3 >= r4) goto L_0x09d1
            com.google.android.gms.internal.measurement.zzkp[] r4 = r2.zzatu     // Catch:{ all -> 0x0b61 }
            r4 = r4[r3]     // Catch:{ all -> 0x0b61 }
            java.lang.Long r5 = r4.zzatn     // Catch:{ all -> 0x0b61 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0b61 }
            java.lang.Long r7 = r2.zzatx     // Catch:{ all -> 0x0b61 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0b61 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x09ba
            java.lang.Long r5 = r4.zzatn     // Catch:{ all -> 0x0b61 }
            r2.zzatx = r5     // Catch:{ all -> 0x0b61 }
        L_0x09ba:
            java.lang.Long r5 = r4.zzatn     // Catch:{ all -> 0x0b61 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0b61 }
            java.lang.Long r7 = r2.zzaty     // Catch:{ all -> 0x0b61 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0b61 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x09ce
            java.lang.Long r4 = r4.zzatn     // Catch:{ all -> 0x0b61 }
            r2.zzaty = r4     // Catch:{ all -> 0x0b61 }
        L_0x09ce:
            int r3 = r3 + 1
            goto L_0x099d
        L_0x09d1:
            r3 = r57
            com.google.android.gms.internal.measurement.zzks r4 = r3.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r5 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzdy r5 = r5.zzbb(r4)     // Catch:{ all -> 0x0b61 }
            if (r5 != 0) goto L_0x09f9
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r3.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
            r5.zzg(r6, r7)     // Catch:{ all -> 0x0b61 }
            goto L_0x0a55
        L_0x09f9:
            com.google.android.gms.internal.measurement.zzkp[] r6 = r2.zzatu     // Catch:{ all -> 0x0b61 }
            int r6 = r6.length     // Catch:{ all -> 0x0b61 }
            if (r6 <= 0) goto L_0x0a55
            long r6 = r5.zzgn()     // Catch:{ all -> 0x0b61 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a0d
            java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            goto L_0x0a0e
        L_0x0a0d:
            r8 = 0
        L_0x0a0e:
            r2.zzaua = r8     // Catch:{ all -> 0x0b61 }
            long r8 = r5.zzgm()     // Catch:{ all -> 0x0b61 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0a1b
            goto L_0x0a1c
        L_0x0a1b:
            r6 = r8
        L_0x0a1c:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0a25
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            goto L_0x0a26
        L_0x0a25:
            r6 = 0
        L_0x0a26:
            r2.zzatz = r6     // Catch:{ all -> 0x0b61 }
            r5.zzgv()     // Catch:{ all -> 0x0b61 }
            long r6 = r5.zzgs()     // Catch:{ all -> 0x0b61 }
            int r6 = (int) r6     // Catch:{ all -> 0x0b61 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b61 }
            r2.zzauk = r6     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = r2.zzatx     // Catch:{ all -> 0x0b61 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0b61 }
            r5.zzm(r6)     // Catch:{ all -> 0x0b61 }
            java.lang.Long r6 = r2.zzaty     // Catch:{ all -> 0x0b61 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0b61 }
            r5.zzn(r6)     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r5.zzhd()     // Catch:{ all -> 0x0b61 }
            r2.zzaek = r6     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r6 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            r6.zza((com.google.android.gms.internal.measurement.zzdy) r5)     // Catch:{ all -> 0x0b61 }
        L_0x0a55:
            com.google.android.gms.internal.measurement.zzkp[] r5 = r2.zzatu     // Catch:{ all -> 0x0b61 }
            int r5 = r5.length     // Catch:{ all -> 0x0b61 }
            if (r5 <= 0) goto L_0x0aa8
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            r5.zzgi()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzgg r5 = r59.zzkv()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzks r6 = r3.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzkm r5 = r5.zzbt(r6)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0a77
            java.lang.Long r6 = r5.zzatb     // Catch:{ all -> 0x0b61 }
            if (r6 != 0) goto L_0x0a72
            goto L_0x0a77
        L_0x0a72:
            java.lang.Long r5 = r5.zzatb     // Catch:{ all -> 0x0b61 }
        L_0x0a74:
            r2.zzaur = r5     // Catch:{ all -> 0x0b61 }
            goto L_0x0a9f
        L_0x0a77:
            com.google.android.gms.internal.measurement.zzks r5 = r3.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = r5.zzadm     // Catch:{ all -> 0x0b61 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0b61 }
            if (r5 == 0) goto L_0x0a88
            r5 = -1
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b61 }
            goto L_0x0a74
        L_0x0a88:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzks r7 = r3.zzarh     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = r7.zzti     // Catch:{ all -> 0x0b61 }
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x0b61 }
            r5.zzg(r6, r7)     // Catch:{ all -> 0x0b61 }
        L_0x0a9f:
            com.google.android.gms.internal.measurement.zzej r5 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            r10 = r27
            r5.zza((com.google.android.gms.internal.measurement.zzks) r2, (boolean) r10)     // Catch:{ all -> 0x0b61 }
        L_0x0aa8:
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            java.util.List<java.lang.Long> r3 = r3.zzari     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0b61 }
            r2.zzab()     // Catch:{ all -> 0x0b61 }
            r2.zzch()     // Catch:{ all -> 0x0b61 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0b61 }
            r6 = 0
        L_0x0abf:
            int r7 = r3.size()     // Catch:{ all -> 0x0b61 }
            if (r6 >= r7) goto L_0x0adc
            if (r6 == 0) goto L_0x0acc
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0b61 }
        L_0x0acc:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0b61 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0b61 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0b61 }
            r5.append(r7)     // Catch:{ all -> 0x0b61 }
            int r6 = r6 + 1
            goto L_0x0abf
        L_0x0adc:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0b61 }
            android.database.sqlite.SQLiteDatabase r6 = r2.getWritableDatabase()     // Catch:{ all -> 0x0b61 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0b61 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0b61 }
            int r6 = r3.size()     // Catch:{ all -> 0x0b61 }
            if (r5 == r6) goto L_0x0b0f
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()     // Catch:{ all -> 0x0b61 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0b61 }
            int r3 = r3.size()     // Catch:{ all -> 0x0b61 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0b61 }
            r2.zze(r6, r5, r3)     // Catch:{ all -> 0x0b61 }
        L_0x0b0f:
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0b26 }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0b26 }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0b26 }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0b26 }
            goto L_0x0b39
        L_0x0b26:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfh.zzbl(r4)     // Catch:{ all -> 0x0b61 }
            r2.zze(r5, r4, r3)     // Catch:{ all -> 0x0b61 }
        L_0x0b39:
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()
            r2.endTransaction()
            r2 = 1
            return r2
        L_0x0b49:
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()     // Catch:{ all -> 0x0b61 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.internal.measurement.zzej r2 = r59.zzje()
            r2.endTransaction()
            r2 = 0
            return r2
        L_0x0b59:
            r0 = move-exception
        L_0x0b5a:
            r2 = r0
        L_0x0b5b:
            if (r6 == 0) goto L_0x0b60
            r6.close()     // Catch:{ all -> 0x0b61 }
        L_0x0b60:
            throw r2     // Catch:{ all -> 0x0b61 }
        L_0x0b61:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.measurement.zzej r3 = r59.zzje()
            r3.endTransaction()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzd(java.lang.String, long):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0150  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzdy zzg(com.google.android.gms.internal.measurement.zzdz r9) {
        /*
            r8 = this;
            r8.zzab()
            r8.zzkz()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            java.lang.String r0 = r9.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.internal.measurement.zzej r0 = r8.zzje()
            java.lang.String r1 = r9.packageName
            com.google.android.gms.internal.measurement.zzdy r0 = r0.zzbb(r1)
            com.google.android.gms.internal.measurement.zzgm r1 = r8.zzacw
            com.google.android.gms.internal.measurement.zzfs r1 = r1.zzgg()
            java.lang.String r2 = r9.packageName
            java.lang.String r1 = r1.zzbo(r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.internal.measurement.zzdy r0 = new com.google.android.gms.internal.measurement.zzdy
            com.google.android.gms.internal.measurement.zzgm r3 = r8.zzacw
            java.lang.String r4 = r9.packageName
            r0.<init>(r3, r4)
            com.google.android.gms.internal.measurement.zzgm r3 = r8.zzacw
            com.google.android.gms.internal.measurement.zzfc r3 = r3.zzfw()
            java.lang.String r3 = r3.zzio()
            r0.zzak(r3)
            r0.zzam(r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzgk()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzam(r1)
            com.google.android.gms.internal.measurement.zzgm r1 = r8.zzacw
            com.google.android.gms.internal.measurement.zzfc r1 = r1.zzfw()
            java.lang.String r1 = r1.zzio()
            r0.zzak(r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r9.zzadm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0078
            java.lang.String r3 = r9.zzadm
            java.lang.String r4 = r0.getGmpAppId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0078
            java.lang.String r1 = r9.zzadm
            r0.zzal(r1)
            r1 = 1
        L_0x0078:
            java.lang.String r3 = r9.zzado
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0092
            java.lang.String r3 = r9.zzado
            java.lang.String r4 = r0.zzgl()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0092
            java.lang.String r1 = r9.zzado
            r0.zzan(r1)
            r1 = 1
        L_0x0092:
            long r3 = r9.zzadu
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00aa
            long r3 = r9.zzadu
            long r5 = r0.zzgq()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00aa
            long r3 = r9.zzadu
            r0.zzp(r3)
            r1 = 1
        L_0x00aa:
            java.lang.String r3 = r9.zzth
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00c4
            java.lang.String r3 = r9.zzth
            java.lang.String r4 = r0.zzag()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00c4
            java.lang.String r1 = r9.zzth
            r0.setAppVersion(r1)
            r1 = 1
        L_0x00c4:
            long r3 = r9.zzads
            long r5 = r0.zzgo()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00d4
            long r3 = r9.zzads
            r0.zzo(r3)
            r1 = 1
        L_0x00d4:
            java.lang.String r3 = r9.zzadt
            if (r3 == 0) goto L_0x00ea
            java.lang.String r3 = r9.zzadt
            java.lang.String r4 = r0.zzgp()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ea
            java.lang.String r1 = r9.zzadt
            r0.zzao(r1)
            r1 = 1
        L_0x00ea:
            long r3 = r9.zzadv
            long r5 = r0.zzgr()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00fa
            long r3 = r9.zzadv
            r0.zzq(r3)
            r1 = 1
        L_0x00fa:
            boolean r3 = r9.zzadw
            boolean r4 = r0.isMeasurementEnabled()
            if (r3 == r4) goto L_0x0108
            boolean r1 = r9.zzadw
            r0.setMeasurementEnabled(r1)
            r1 = 1
        L_0x0108:
            java.lang.String r3 = r9.zzaek
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0122
            java.lang.String r3 = r9.zzaek
            java.lang.String r4 = r0.zzhc()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0122
            java.lang.String r1 = r9.zzaek
            r0.zzap(r1)
            r1 = 1
        L_0x0122:
            long r3 = r9.zzadx
            long r5 = r0.zzhe()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0132
            long r3 = r9.zzadx
            r0.zzaa(r3)
            r1 = 1
        L_0x0132:
            boolean r3 = r9.zzady
            boolean r4 = r0.zzhf()
            if (r3 == r4) goto L_0x0140
            boolean r1 = r9.zzady
            r0.zzd(r1)
            r1 = 1
        L_0x0140:
            boolean r3 = r9.zzadz
            boolean r4 = r0.zzhg()
            if (r3 == r4) goto L_0x014e
            boolean r9 = r9.zzadz
            r0.zze(r9)
            r1 = 1
        L_0x014e:
            if (r1 == 0) goto L_0x0157
            com.google.android.gms.internal.measurement.zzej r9 = r8.zzje()
            r9.zza((com.google.android.gms.internal.measurement.zzdy) r0)
        L_0x0157:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzg(com.google.android.gms.internal.measurement.zzdz):com.google.android.gms.internal.measurement.zzdy");
    }

    public static zzjs zzg(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzaqj == null) {
            synchronized (zzjs.class) {
                if (zzaqj == null) {
                    zzaqj = new zzjs(new zzjx(context));
                }
            }
        }
        return zzaqj;
    }

    private final zzgg zzkv() {
        zza((zzjr) this.zzaqk);
        return this.zzaqk;
    }

    private final zzfq zzkx() {
        if (this.zzaqn != null) {
            return this.zzaqn;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjo zzky() {
        zza((zzjr) this.zzaqo);
        return this.zzaqo;
    }

    private final long zzla() {
        long currentTimeMillis = this.zzacw.zzbt().currentTimeMillis();
        zzfs zzgg = this.zzacw.zzgg();
        zzgg.zzch();
        zzgg.zzab();
        long j = zzgg.zzakh.get();
        if (j == 0) {
            long nextInt = ((long) zzgg.zzgc().zzll().nextInt(86400000)) + 1;
            zzgg.zzakh.set(nextInt);
            j = nextInt;
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzlc() {
        zzab();
        zzkz();
        return zzje().zzhw() || !TextUtils.isEmpty(zzje().zzhr());
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a0  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzld() {
        /*
            r20 = this;
            r0 = r20
            r20.zzab()
            r20.zzkz()
            boolean r1 = r20.zzlh()
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            long r1 = r0.zzaqs
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0056
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.common.util.Clock r1 = r1.zzbt()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzaqs
            long r9 = r1 - r7
            long r1 = java.lang.Math.abs(r9)
            long r7 = r5 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0054
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.zzg(r2, r3)
            com.google.android.gms.internal.measurement.zzfq r1 = r20.zzkx()
            r1.unregister()
            com.google.android.gms.internal.measurement.zzjo r1 = r20.zzky()
            r1.cancel()
            return
        L_0x0054:
            r0.zzaqs = r3
        L_0x0056:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            boolean r1 = r1.zzkd()
            if (r1 == 0) goto L_0x024d
            boolean r1 = r20.zzlc()
            if (r1 != 0) goto L_0x0066
            goto L_0x024d
        L_0x0066:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.common.util.Clock r1 = r1.zzbt()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r5 = com.google.android.gms.internal.measurement.zzey.zzahp
            java.lang.Object r5 = r5.get()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.internal.measurement.zzej r7 = r20.zzje()
            boolean r7 = r7.zzhx()
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.internal.measurement.zzej r7 = r20.zzje()
            boolean r7 = r7.zzhs()
            if (r7 == 0) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            r7 = 0
            goto L_0x0098
        L_0x0097:
            r7 = 1
        L_0x0098:
            if (r7 == 0) goto L_0x00b8
            com.google.android.gms.internal.measurement.zzgm r9 = r0.zzacw
            com.google.android.gms.internal.measurement.zzeg r9 = r9.zzgh()
            java.lang.String r9 = r9.zzhn()
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 != 0) goto L_0x00b5
            java.lang.String r10 = ".none."
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00b5
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r9 = com.google.android.gms.internal.measurement.zzey.zzahk
            goto L_0x00ba
        L_0x00b5:
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r9 = com.google.android.gms.internal.measurement.zzey.zzahj
            goto L_0x00ba
        L_0x00b8:
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r9 = com.google.android.gms.internal.measurement.zzey.zzahi
        L_0x00ba:
            java.lang.Object r9 = r9.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = java.lang.Math.max(r3, r9)
            com.google.android.gms.internal.measurement.zzgm r11 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfs r11 = r11.zzgg()
            com.google.android.gms.internal.measurement.zzfv r11 = r11.zzakd
            long r11 = r11.get()
            com.google.android.gms.internal.measurement.zzgm r13 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfs r13 = r13.zzgg()
            com.google.android.gms.internal.measurement.zzfv r13 = r13.zzake
            long r13 = r13.get()
            com.google.android.gms.internal.measurement.zzej r15 = r20.zzje()
            r16 = r9
            long r8 = r15.zzhu()
            com.google.android.gms.internal.measurement.zzej r10 = r20.zzje()
            r18 = r5
            long r5 = r10.zzhv()
            long r5 = java.lang.Math.max(r8, r5)
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00ff
        L_0x00fc:
            r5 = r3
            goto L_0x017e
        L_0x00ff:
            r8 = 0
            long r8 = r5 - r1
            long r5 = java.lang.Math.abs(r8)
            long r8 = r1 - r5
            long r5 = r11 - r1
            long r5 = java.lang.Math.abs(r5)
            long r10 = r1 - r5
            long r5 = r13 - r1
            long r5 = java.lang.Math.abs(r5)
            long r12 = r1 - r5
            long r1 = java.lang.Math.max(r10, r12)
            long r5 = r8 + r18
            if (r7 == 0) goto L_0x012b
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x012b
            long r5 = java.lang.Math.min(r8, r1)
            long r10 = r5 + r16
            r5 = r10
        L_0x012b:
            com.google.android.gms.internal.measurement.zzgm r7 = r0.zzacw
            com.google.android.gms.internal.measurement.zzkc r7 = r7.zzgc()
            r10 = r16
            boolean r7 = r7.zza((long) r1, (long) r10)
            if (r7 != 0) goto L_0x013b
            long r5 = r1 + r10
        L_0x013b:
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x017e
            int r1 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x017e
            r1 = 0
        L_0x0144:
            r2 = 20
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r7 = com.google.android.gms.internal.measurement.zzey.zzahr
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)
            int r2 = java.lang.Math.min(r2, r7)
            if (r1 >= r2) goto L_0x00fc
            r9 = 1
            long r9 = r9 << r1
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r2 = com.google.android.gms.internal.measurement.zzey.zzahq
            java.lang.Object r2 = r2.get()
            java.lang.Long r2 = (java.lang.Long) r2
            long r14 = r2.longValue()
            long r14 = java.lang.Math.max(r3, r14)
            long r14 = r14 * r9
            long r9 = r5 + r14
            int r2 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r2 <= 0) goto L_0x017a
            r5 = r9
            goto L_0x017e
        L_0x017a:
            int r1 = r1 + 1
            r5 = r9
            goto L_0x0144
        L_0x017e:
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01a0
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()
            java.lang.String r2 = "Next upload time is 0"
            r1.log(r2)
            com.google.android.gms.internal.measurement.zzfq r1 = r20.zzkx()
            r1.unregister()
            com.google.android.gms.internal.measurement.zzjo r1 = r20.zzky()
            r1.cancel()
            return
        L_0x01a0:
            com.google.android.gms.internal.measurement.zzfl r1 = r20.zzkw()
            boolean r1 = r1.zzex()
            if (r1 != 0) goto L_0x01c8
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()
            java.lang.String r2 = "No network"
            r1.log(r2)
            com.google.android.gms.internal.measurement.zzfq r1 = r20.zzkx()
            r1.zzeu()
            com.google.android.gms.internal.measurement.zzjo r1 = r20.zzky()
            r1.cancel()
            return
        L_0x01c8:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfs r1 = r1.zzgg()
            com.google.android.gms.internal.measurement.zzfv r1 = r1.zzakf
            long r1 = r1.get()
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r7 = com.google.android.gms.internal.measurement.zzey.zzahg
            java.lang.Object r7 = r7.get()
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.internal.measurement.zzgm r9 = r0.zzacw
            com.google.android.gms.internal.measurement.zzkc r9 = r9.zzgc()
            boolean r9 = r9.zza((long) r1, (long) r7)
            if (r9 != 0) goto L_0x01f6
            long r9 = r1 + r7
            long r5 = java.lang.Math.max(r5, r9)
        L_0x01f6:
            com.google.android.gms.internal.measurement.zzfq r1 = r20.zzkx()
            r1.unregister()
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.common.util.Clock r1 = r1.zzbt()
            long r1 = r1.currentTimeMillis()
            long r7 = r5 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0232
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Long> r1 = com.google.android.gms.internal.measurement.zzey.zzahl
            java.lang.Object r1 = r1.get()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfs r1 = r1.zzgg()
            com.google.android.gms.internal.measurement.zzfv r1 = r1.zzakd
            com.google.android.gms.internal.measurement.zzgm r2 = r0.zzacw
            com.google.android.gms.common.util.Clock r2 = r2.zzbt()
            long r2 = r2.currentTimeMillis()
            r1.set(r2)
        L_0x0232:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.zzg(r2, r3)
            com.google.android.gms.internal.measurement.zzjo r1 = r20.zzky()
            r1.zzh(r7)
            return
        L_0x024d:
            com.google.android.gms.internal.measurement.zzgm r1 = r0.zzacw
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.log(r2)
            com.google.android.gms.internal.measurement.zzfq r1 = r20.zzkx()
            r1.unregister()
            com.google.android.gms.internal.measurement.zzjo r1 = r20.zzky()
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzld():void");
    }

    @WorkerThread
    private final void zzle() {
        zzab();
        if (this.zzaqw || this.zzaqx || this.zzaqy) {
            this.zzacw.zzgf().zziz().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaqw), Boolean.valueOf(this.zzaqx), Boolean.valueOf(this.zzaqy));
            return;
        }
        this.zzacw.zzgf().zziz().log("Stopping uploading service(s)");
        if (this.zzaqt != null) {
            for (Runnable run : this.zzaqt) {
                run.run();
            }
            this.zzaqt.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzlf() {
        String str;
        zzfj zzfj;
        zzab();
        try {
            this.zzara = new RandomAccessFile(new File(this.zzacw.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqz = this.zzara.tryLock();
            if (this.zzaqz != null) {
                this.zzacw.zzgf().zziz().log("Storage concurrent access okay");
                return true;
            }
            this.zzacw.zzgf().zzis().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            e = e;
            zzfj = this.zzacw.zzgf().zzis();
            str = "Failed to acquire storage lock";
            zzfj.zzg(str, e);
            return false;
        } catch (IOException e2) {
            e = e2;
            zzfj = this.zzacw.zzgf().zzis();
            str = "Failed to access storage lock file";
            zzfj.zzg(str, e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zzlh() {
        zzab();
        zzkz();
        return this.zzaqr;
    }

    public final Context getContext() {
        return this.zzacw.getContext();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        this.zzacw.zzge().zzab();
        zzje().zzht();
        if (this.zzacw.zzgg().zzakd.get() == 0) {
            this.zzacw.zzgg().zzakd.set(this.zzacw.zzbt().currentTimeMillis());
        }
        zzld();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzej zzje;
        zzab();
        zzkz();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqx = false;
                zzle();
                throw th2;
            }
        }
        List<Long> list = this.zzarb;
        this.zzarb = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzacw.zzgg().zzakd.set(this.zzacw.zzbt().currentTimeMillis());
                this.zzacw.zzgg().zzake.set(0);
                zzld();
                this.zzacw.zzgf().zziz().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzje().beginTransaction();
                try {
                    for (Long next : list) {
                        try {
                            zzje = zzje();
                            long longValue = next.longValue();
                            zzje.zzab();
                            zzje.zzch();
                            if (zzje.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzje.zzgf().zzis().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzarc == null || !this.zzarc.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zzje().setTransactionSuccessful();
                    zzje().endTransaction();
                    this.zzarc = null;
                    if (!zzkw().zzex() || !zzlc()) {
                        this.zzard = -1;
                        zzld();
                    } else {
                        zzlb();
                    }
                    this.zzaqs = 0;
                } catch (Throwable th3) {
                    zzje().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzacw.zzgf().zzis().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzaqs = this.zzacw.zzbt().elapsedRealtime();
                this.zzacw.zzgf().zziz().zzg("Disable upload, time", Long.valueOf(this.zzaqs));
            }
        } else {
            this.zzacw.zzgf().zziz().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzacw.zzgg().zzake.set(this.zzacw.zzbt().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzacw.zzgg().zzakf.set(this.zzacw.zzbt().currentTimeMillis());
            }
            if (this.zzacw.zzgh().zzaw(str)) {
                zzje().zzc(list);
            }
            zzld();
        }
        this.zzaqx = false;
        zzle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: java.lang.Long} */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(@android.support.annotation.NonNull com.google.android.gms.internal.measurement.zzew r33, @android.support.annotation.Size(min = 1) java.lang.String r34) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            r15 = r34
            r32.zzkz()
            r32.zzab()
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            r3.zzfr()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r33)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            com.google.android.gms.internal.measurement.zzkr r14 = new com.google.android.gms.internal.measurement.zzkr
            r14.<init>()
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()
            r3.beginTransaction()
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzdy r12 = r3.zzbb(r15)     // Catch:{ all -> 0x04f1 }
            r13 = 0
            if (r12 != 0) goto L_0x0047
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziy()     // Catch:{ all -> 0x04f1 }
            java.lang.String r3 = "Log and bundle not available. package_name"
            r2.zzg(r3, r15)     // Catch:{ all -> 0x04f1 }
        L_0x003d:
            byte[] r2 = new byte[r13]     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()
            r3.endTransaction()
            return r2
        L_0x0047:
            boolean r3 = r12.isMeasurementEnabled()     // Catch:{ all -> 0x04f1 }
            if (r3 != 0) goto L_0x005d
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziy()     // Catch:{ all -> 0x04f1 }
            java.lang.String r3 = "Log and bundle disabled. package_name"
            r2.zzg(r3, r15)     // Catch:{ all -> 0x04f1 }
            goto L_0x003d
        L_0x005d:
            java.lang.String r3 = "_iap"
            java.lang.String r4 = r2.name     // Catch:{ all -> 0x04f1 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04f1 }
            if (r3 != 0) goto L_0x0071
            java.lang.String r3 = "ecommerce_purchase"
            java.lang.String r4 = r2.name     // Catch:{ all -> 0x04f1 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04f1 }
            if (r3 == 0) goto L_0x008a
        L_0x0071:
            boolean r3 = r1.zza((java.lang.String) r15, (com.google.android.gms.internal.measurement.zzew) r2)     // Catch:{ all -> 0x04f1 }
            if (r3 != 0) goto L_0x008a
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()     // Catch:{ all -> 0x04f1 }
            java.lang.String r4 = "Failed to handle purchase event at single event bundle creation. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfh.zzbl(r34)     // Catch:{ all -> 0x04f1 }
            r3.zzg(r4, r5)     // Catch:{ all -> 0x04f1 }
        L_0x008a:
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeg r3 = r3.zzgh()     // Catch:{ all -> 0x04f1 }
            boolean r3 = r3.zzau(r15)     // Catch:{ all -> 0x04f1 }
            r10 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x04f1 }
            if (r3 == 0) goto L_0x00eb
            java.lang.String r5 = "_e"
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x04f1 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x04f1 }
            if (r5 == 0) goto L_0x00eb
            com.google.android.gms.internal.measurement.zzet r5 = r2.zzafr     // Catch:{ all -> 0x04f1 }
            if (r5 == 0) goto L_0x00da
            com.google.android.gms.internal.measurement.zzet r5 = r2.zzafr     // Catch:{ all -> 0x04f1 }
            int r5 = r5.size()     // Catch:{ all -> 0x04f1 }
            if (r5 != 0) goto L_0x00b3
            goto L_0x00da
        L_0x00b3:
            com.google.android.gms.internal.measurement.zzet r5 = r2.zzafr     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "_et"
            java.lang.Long r5 = r5.getLong(r6)     // Catch:{ all -> 0x04f1 }
            if (r5 != 0) goto L_0x00d1
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "The engagement event does not include duration. appId"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r34)     // Catch:{ all -> 0x04f1 }
        L_0x00cd:
            r5.zzg(r6, r7)     // Catch:{ all -> 0x04f1 }
            goto L_0x00eb
        L_0x00d1:
            com.google.android.gms.internal.measurement.zzet r4 = r2.zzafr     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = "_et"
            java.lang.Long r4 = r4.getLong(r5)     // Catch:{ all -> 0x04f1 }
            goto L_0x00eb
        L_0x00da:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziv()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "The engagement event does not contain any parameters. appId"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r34)     // Catch:{ all -> 0x04f1 }
            goto L_0x00cd
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzks r8 = new com.google.android.gms.internal.measurement.zzks     // Catch:{ all -> 0x04f1 }
            r8.<init>()     // Catch:{ all -> 0x04f1 }
            r9 = 1
            com.google.android.gms.internal.measurement.zzks[] r5 = new com.google.android.gms.internal.measurement.zzks[r9]     // Catch:{ all -> 0x04f1 }
            r5[r13] = r8     // Catch:{ all -> 0x04f1 }
            r14.zzatr = r5     // Catch:{ all -> 0x04f1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x04f1 }
            r8.zzatt = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = "android"
            r8.zzaub = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.zzah()     // Catch:{ all -> 0x04f1 }
            r8.zzti = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.zzgp()     // Catch:{ all -> 0x04f1 }
            r8.zzadt = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.zzag()     // Catch:{ all -> 0x04f1 }
            r8.zzth = r5     // Catch:{ all -> 0x04f1 }
            long r5 = r12.zzgo()     // Catch:{ all -> 0x04f1 }
            r16 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            r23 = r14
            r14 = 0
            if (r7 != 0) goto L_0x0123
            r5 = r14
            goto L_0x0128
        L_0x0123:
            int r5 = (int) r5     // Catch:{ all -> 0x04f1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04f1 }
        L_0x0128:
            r8.zzaun = r5     // Catch:{ all -> 0x04f1 }
            long r5 = r12.zzgq()     // Catch:{ all -> 0x04f1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x04f1 }
            r8.zzauf = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.getGmpAppId()     // Catch:{ all -> 0x04f1 }
            r8.zzadm = r5     // Catch:{ all -> 0x04f1 }
            long r5 = r12.zzgr()     // Catch:{ all -> 0x04f1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x04f1 }
            r8.zzauj = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            boolean r5 = r5.isEnabled()     // Catch:{ all -> 0x04f1 }
            if (r5 == 0) goto L_0x0162
            boolean r5 = com.google.android.gms.internal.measurement.zzeg.zzho()     // Catch:{ all -> 0x04f1 }
            if (r5 == 0) goto L_0x0162
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeg r5 = r5.zzgh()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = r8.zzti     // Catch:{ all -> 0x04f1 }
            boolean r5 = r5.zzas(r6)     // Catch:{ all -> 0x04f1 }
            if (r5 == 0) goto L_0x0162
            r8.zzaut = r14     // Catch:{ all -> 0x04f1 }
        L_0x0162:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfs r5 = r5.zzgg()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = r12.zzah()     // Catch:{ all -> 0x04f1 }
            android.util.Pair r5 = r5.zzbn(r6)     // Catch:{ all -> 0x04f1 }
            boolean r6 = r12.zzhf()     // Catch:{ all -> 0x04f1 }
            if (r6 == 0) goto L_0x018e
            if (r5 == 0) goto L_0x018e
            java.lang.Object r6 = r5.first     // Catch:{ all -> 0x04f1 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x04f1 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x04f1 }
            if (r6 != 0) goto L_0x018e
            java.lang.Object r6 = r5.first     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x04f1 }
            r8.zzauh = r6     // Catch:{ all -> 0x04f1 }
            java.lang.Object r5 = r5.second     // Catch:{ all -> 0x04f1 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x04f1 }
            r8.zzaui = r5     // Catch:{ all -> 0x04f1 }
        L_0x018e:
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzfx()     // Catch:{ all -> 0x04f1 }
            r5.zzch()     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x04f1 }
            r8.zzaud = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzfx()     // Catch:{ all -> 0x04f1 }
            r5.zzch()     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x04f1 }
            r8.zzauc = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzfx()     // Catch:{ all -> 0x04f1 }
            long r5 = r5.zzig()     // Catch:{ all -> 0x04f1 }
            int r5 = (int) r5     // Catch:{ all -> 0x04f1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04f1 }
            r8.zzaue = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzeq r5 = r5.zzfx()     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r5.zzih()     // Catch:{ all -> 0x04f1 }
            r8.zzafo = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.getAppInstanceId()     // Catch:{ all -> 0x04f1 }
            r8.zzadl = r5     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r12.zzgl()     // Catch:{ all -> 0x04f1 }
            r8.zzado = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r5 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = r12.zzah()     // Catch:{ all -> 0x04f1 }
            java.util.List r5 = r5.zzba(r6)     // Catch:{ all -> 0x04f1 }
            int r6 = r5.size()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r6 = new com.google.android.gms.internal.measurement.zzku[r6]     // Catch:{ all -> 0x04f1 }
            r8.zzatv = r6     // Catch:{ all -> 0x04f1 }
            if (r3 == 0) goto L_0x024c
            com.google.android.gms.internal.measurement.zzej r6 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            java.lang.String r7 = r8.zzti     // Catch:{ all -> 0x04f1 }
            java.lang.String r13 = "_lte"
            com.google.android.gms.internal.measurement.zzkb r6 = r6.zzh(r7, r13)     // Catch:{ all -> 0x04f1 }
            if (r6 == 0) goto L_0x0230
            java.lang.Object r7 = r6.value     // Catch:{ all -> 0x04f1 }
            if (r7 != 0) goto L_0x01fa
            goto L_0x0230
        L_0x01fa:
            long r16 = r4.longValue()     // Catch:{ all -> 0x04f1 }
            int r7 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x024d
            com.google.android.gms.internal.measurement.zzkb r7 = new com.google.android.gms.internal.measurement.zzkb     // Catch:{ all -> 0x04f1 }
            java.lang.String r13 = r8.zzti     // Catch:{ all -> 0x04f1 }
            java.lang.String r18 = "auto"
            java.lang.String r19 = "_lte"
            com.google.android.gms.internal.measurement.zzgm r14 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.common.util.Clock r14 = r14.zzbt()     // Catch:{ all -> 0x04f1 }
            long r20 = r14.currentTimeMillis()     // Catch:{ all -> 0x04f1 }
            java.lang.Object r6 = r6.value     // Catch:{ all -> 0x04f1 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x04f1 }
            long r16 = r6.longValue()     // Catch:{ all -> 0x04f1 }
            long r24 = r4.longValue()     // Catch:{ all -> 0x04f1 }
            r6 = 0
            long r10 = r16 + r24
            java.lang.Long r22 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x04f1 }
            r16 = r7
            r17 = r13
            r16.<init>(r17, r18, r19, r20, r22)     // Catch:{ all -> 0x04f1 }
            r6 = r7
            goto L_0x024d
        L_0x0230:
            com.google.android.gms.internal.measurement.zzkb r6 = new com.google.android.gms.internal.measurement.zzkb     // Catch:{ all -> 0x04f1 }
            java.lang.String r7 = r8.zzti     // Catch:{ all -> 0x04f1 }
            java.lang.String r18 = "auto"
            java.lang.String r19 = "_lte"
            com.google.android.gms.internal.measurement.zzgm r10 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.common.util.Clock r10 = r10.zzbt()     // Catch:{ all -> 0x04f1 }
            long r20 = r10.currentTimeMillis()     // Catch:{ all -> 0x04f1 }
            r16 = r6
            r17 = r7
            r22 = r4
            r16.<init>(r17, r18, r19, r20, r22)     // Catch:{ all -> 0x04f1 }
            goto L_0x024d
        L_0x024c:
            r6 = 0
        L_0x024d:
            r7 = 0
            r10 = 0
        L_0x024f:
            int r11 = r5.size()     // Catch:{ all -> 0x04f1 }
            if (r7 >= r11) goto L_0x02ab
            com.google.android.gms.internal.measurement.zzku r11 = new com.google.android.gms.internal.measurement.zzku     // Catch:{ all -> 0x04f1 }
            r11.<init>()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r13 = r8.zzatv     // Catch:{ all -> 0x04f1 }
            r13[r7] = r11     // Catch:{ all -> 0x04f1 }
            java.lang.Object r13 = r5.get(r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkb r13 = (com.google.android.gms.internal.measurement.zzkb) r13     // Catch:{ all -> 0x04f1 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x04f1 }
            r11.name = r13     // Catch:{ all -> 0x04f1 }
            java.lang.Object r13 = r5.get(r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkb r13 = (com.google.android.gms.internal.measurement.zzkb) r13     // Catch:{ all -> 0x04f1 }
            long r13 = r13.zzarl     // Catch:{ all -> 0x04f1 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04f1 }
            r11.zzauz = r13     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzjy r13 = r32.zzjc()     // Catch:{ all -> 0x04f1 }
            java.lang.Object r14 = r5.get(r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkb r14 = (com.google.android.gms.internal.measurement.zzkb) r14     // Catch:{ all -> 0x04f1 }
            java.lang.Object r14 = r14.value     // Catch:{ all -> 0x04f1 }
            r13.zza((com.google.android.gms.internal.measurement.zzku) r11, (java.lang.Object) r14)     // Catch:{ all -> 0x04f1 }
            if (r3 == 0) goto L_0x02a8
            java.lang.String r13 = "_lte"
            java.lang.String r14 = r11.name     // Catch:{ all -> 0x04f1 }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x04f1 }
            if (r13 == 0) goto L_0x02a8
            java.lang.Object r10 = r6.value     // Catch:{ all -> 0x04f1 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x04f1 }
            r11.zzatq = r10     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r10 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.common.util.Clock r10 = r10.zzbt()     // Catch:{ all -> 0x04f1 }
            long r13 = r10.currentTimeMillis()     // Catch:{ all -> 0x04f1 }
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04f1 }
            r11.zzauz = r10     // Catch:{ all -> 0x04f1 }
            r10 = r11
        L_0x02a8:
            int r7 = r7 + 1
            goto L_0x024f
        L_0x02ab:
            if (r3 == 0) goto L_0x02e4
            if (r10 != 0) goto L_0x02e4
            com.google.android.gms.internal.measurement.zzku r3 = new com.google.android.gms.internal.measurement.zzku     // Catch:{ all -> 0x04f1 }
            r3.<init>()     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = "_lte"
            r3.name = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.common.util.Clock r5 = r5.zzbt()     // Catch:{ all -> 0x04f1 }
            long r10 = r5.currentTimeMillis()     // Catch:{ all -> 0x04f1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x04f1 }
            r3.zzauz = r5     // Catch:{ all -> 0x04f1 }
            java.lang.Object r5 = r6.value     // Catch:{ all -> 0x04f1 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x04f1 }
            r3.zzatq = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r5 = r8.zzatv     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r7 = r8.zzatv     // Catch:{ all -> 0x04f1 }
            int r7 = r7.length     // Catch:{ all -> 0x04f1 }
            int r7 = r7 + r9
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r5 = (com.google.android.gms.internal.measurement.zzku[]) r5     // Catch:{ all -> 0x04f1 }
            r8.zzatv = r5     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r5 = r8.zzatv     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r7 = r8.zzatv     // Catch:{ all -> 0x04f1 }
            int r7 = r7.length     // Catch:{ all -> 0x04f1 }
            int r7 = r7 - r9
            r5[r7] = r3     // Catch:{ all -> 0x04f1 }
        L_0x02e4:
            long r3 = r4.longValue()     // Catch:{ all -> 0x04f1 }
            r10 = 0
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x02f5
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            r3.zza((com.google.android.gms.internal.measurement.zzkb) r6)     // Catch:{ all -> 0x04f1 }
        L_0x02f5:
            com.google.android.gms.internal.measurement.zzet r3 = r2.zzafr     // Catch:{ all -> 0x04f1 }
            android.os.Bundle r14 = r3.zzij()     // Catch:{ all -> 0x04f1 }
            java.lang.String r3 = "_iap"
            java.lang.String r4 = r2.name     // Catch:{ all -> 0x04f1 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04f1 }
            r4 = 1
            if (r3 == 0) goto L_0x0320
            java.lang.String r3 = "_c"
            r14.putLong(r3, r4)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziy()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "Marking in-app purchase as real-time"
            r3.log(r6)     // Catch:{ all -> 0x04f1 }
            java.lang.String r3 = "_r"
            r14.putLong(r3, r4)     // Catch:{ all -> 0x04f1 }
        L_0x0320:
            java.lang.String r3 = "_o"
            java.lang.String r6 = r2.origin     // Catch:{ all -> 0x04f1 }
            r14.putString(r3, r6)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkc r3 = r3.zzgc()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = r8.zzti     // Catch:{ all -> 0x04f1 }
            boolean r3 = r3.zzci(r6)     // Catch:{ all -> 0x04f1 }
            if (r3 == 0) goto L_0x0353
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkc r3 = r3.zzgc()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "_dbg"
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x04f1 }
            r3.zza((android.os.Bundle) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkc r3 = r3.zzgc()     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = "_r"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x04f1 }
            r3.zza((android.os.Bundle) r14, (java.lang.String) r6, (java.lang.Object) r4)     // Catch:{ all -> 0x04f1 }
        L_0x0353:
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            java.lang.String r4 = r2.name     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzes r3 = r3.zzf(r15, r4)     // Catch:{ all -> 0x04f1 }
            if (r3 != 0) goto L_0x039e
            com.google.android.gms.internal.measurement.zzes r13 = new com.google.android.gms.internal.measurement.zzes     // Catch:{ all -> 0x04f1 }
            java.lang.String r5 = r2.name     // Catch:{ all -> 0x04f1 }
            r6 = 1
            r16 = 0
            long r3 = r2.zzagc     // Catch:{ all -> 0x04f1 }
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = r3
            r3 = r13
            r4 = r15
            r28 = r8
            r8 = r16
            r26 = r10
            r10 = r24
            r29 = r12
            r30 = r13
            r12 = r18
            r17 = r14
            r31 = r23
            r18 = 0
            r14 = r20
            r15 = r21
            r16 = r22
            r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            r4 = r30
            r3.zza((com.google.android.gms.internal.measurement.zzes) r4)     // Catch:{ all -> 0x04f1 }
            r9 = r26
            goto L_0x03be
        L_0x039e:
            r28 = r8
            r26 = r10
            r29 = r12
            r17 = r14
            r31 = r23
            r18 = 0
            long r4 = r3.zzafu     // Catch:{ all -> 0x04f1 }
            long r6 = r2.zzagc     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzes r3 = r3.zzac(r6)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzes r3 = r3.zzii()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r6 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            r6.zza((com.google.android.gms.internal.measurement.zzes) r3)     // Catch:{ all -> 0x04f1 }
            r9 = r4
        L_0x03be:
            com.google.android.gms.internal.measurement.zzer r12 = new com.google.android.gms.internal.measurement.zzer     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            java.lang.String r4 = r2.origin     // Catch:{ all -> 0x04f1 }
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x04f1 }
            long r7 = r2.zzagc     // Catch:{ all -> 0x04f1 }
            r2 = r12
            r5 = r34
            r11 = r17
            r2.<init>((com.google.android.gms.internal.measurement.zzgm) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkp r2 = new com.google.android.gms.internal.measurement.zzkp     // Catch:{ all -> 0x04f1 }
            r2.<init>()     // Catch:{ all -> 0x04f1 }
            r3 = 1
            com.google.android.gms.internal.measurement.zzkp[] r3 = new com.google.android.gms.internal.measurement.zzkp[r3]     // Catch:{ all -> 0x04f1 }
            r4 = 0
            r3[r4] = r2     // Catch:{ all -> 0x04f1 }
            r5 = r28
            r5.zzatu = r3     // Catch:{ all -> 0x04f1 }
            long r6 = r12.timestamp     // Catch:{ all -> 0x04f1 }
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            r2.zzatn = r3     // Catch:{ all -> 0x04f1 }
            java.lang.String r3 = r12.name     // Catch:{ all -> 0x04f1 }
            r2.name = r3     // Catch:{ all -> 0x04f1 }
            long r6 = r12.zzafq     // Catch:{ all -> 0x04f1 }
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            r2.zzato = r3     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzet r3 = r12.zzafr     // Catch:{ all -> 0x04f1 }
            int r3 = r3.size()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkq[] r3 = new com.google.android.gms.internal.measurement.zzkq[r3]     // Catch:{ all -> 0x04f1 }
            r2.zzatm = r3     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzet r3 = r12.zzafr     // Catch:{ all -> 0x04f1 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x04f1 }
            r6 = 0
        L_0x0404:
            boolean r7 = r3.hasNext()     // Catch:{ all -> 0x04f1 }
            if (r7 == 0) goto L_0x042c
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x04f1 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkq r8 = new com.google.android.gms.internal.measurement.zzkq     // Catch:{ all -> 0x04f1 }
            r8.<init>()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkq[] r9 = r2.zzatm     // Catch:{ all -> 0x04f1 }
            int r10 = r6 + 1
            r9[r6] = r8     // Catch:{ all -> 0x04f1 }
            r8.name = r7     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzet r6 = r12.zzafr     // Catch:{ all -> 0x04f1 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzjy r7 = r32.zzjc()     // Catch:{ all -> 0x04f1 }
            r7.zza((com.google.android.gms.internal.measurement.zzkq) r8, (java.lang.Object) r6)     // Catch:{ all -> 0x04f1 }
            r6 = r10
            goto L_0x0404
        L_0x042c:
            r3 = r29
            java.lang.String r6 = r3.zzah()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzku[] r7 = r5.zzatv     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzkp[] r8 = r5.zzatu     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzko[] r6 = r1.zza(r6, r7, r8)     // Catch:{ all -> 0x04f1 }
            r5.zzaum = r6     // Catch:{ all -> 0x04f1 }
            java.lang.Long r6 = r2.zzatn     // Catch:{ all -> 0x04f1 }
            r5.zzatx = r6     // Catch:{ all -> 0x04f1 }
            java.lang.Long r2 = r2.zzatn     // Catch:{ all -> 0x04f1 }
            r5.zzaty = r2     // Catch:{ all -> 0x04f1 }
            long r6 = r3.zzgn()     // Catch:{ all -> 0x04f1 }
            int r2 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1))
            if (r2 == 0) goto L_0x0451
            java.lang.Long r14 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            goto L_0x0453
        L_0x0451:
            r14 = r18
        L_0x0453:
            r5.zzaua = r14     // Catch:{ all -> 0x04f1 }
            long r8 = r3.zzgm()     // Catch:{ all -> 0x04f1 }
            int r2 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1))
            if (r2 != 0) goto L_0x045e
            goto L_0x045f
        L_0x045e:
            r6 = r8
        L_0x045f:
            int r2 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1))
            if (r2 == 0) goto L_0x0468
            java.lang.Long r14 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            goto L_0x046a
        L_0x0468:
            r14 = r18
        L_0x046a:
            r5.zzatz = r14     // Catch:{ all -> 0x04f1 }
            r3.zzgv()     // Catch:{ all -> 0x04f1 }
            long r6 = r3.zzgs()     // Catch:{ all -> 0x04f1 }
            int r2 = (int) r6     // Catch:{ all -> 0x04f1 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x04f1 }
            r5.zzauk = r2     // Catch:{ all -> 0x04f1 }
            r6 = 12451(0x30a3, double:6.1516E-320)
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            r5.zzaug = r2     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.common.util.Clock r2 = r2.zzbt()     // Catch:{ all -> 0x04f1 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x04f1 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x04f1 }
            r5.zzatw = r2     // Catch:{ all -> 0x04f1 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x04f1 }
            r5.zzaul = r2     // Catch:{ all -> 0x04f1 }
            java.lang.Long r2 = r5.zzatx     // Catch:{ all -> 0x04f1 }
            long r6 = r2.longValue()     // Catch:{ all -> 0x04f1 }
            r3.zzm(r6)     // Catch:{ all -> 0x04f1 }
            java.lang.Long r2 = r5.zzaty     // Catch:{ all -> 0x04f1 }
            long r5 = r2.longValue()     // Catch:{ all -> 0x04f1 }
            r3.zzn(r5)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r2 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            r2.zza((com.google.android.gms.internal.measurement.zzdy) r3)     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r2 = r32.zzje()     // Catch:{ all -> 0x04f1 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x04f1 }
            com.google.android.gms.internal.measurement.zzej r2 = r32.zzje()
            r2.endTransaction()
            r2 = r31
            int r3 = r2.zzvv()     // Catch:{ IOException -> 0x04db }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x04db }
            int r5 = r3.length     // Catch:{ IOException -> 0x04db }
            com.google.android.gms.internal.measurement.zzaby r4 = com.google.android.gms.internal.measurement.zzaby.zzb(r3, r4, r5)     // Catch:{ IOException -> 0x04db }
            r2.zza(r4)     // Catch:{ IOException -> 0x04db }
            r4.zzvn()     // Catch:{ IOException -> 0x04db }
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw     // Catch:{ IOException -> 0x04db }
            com.google.android.gms.internal.measurement.zzkc r2 = r2.zzgc()     // Catch:{ IOException -> 0x04db }
            byte[] r2 = r2.zza((byte[]) r3)     // Catch:{ IOException -> 0x04db }
            return r2
        L_0x04db:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zzis()
            java.lang.String r4 = "Data loss. Failed to bundle and serialize. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfh.zzbl(r34)
            r3.zze(r4, r5, r2)
            return r18
        L_0x04f1:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.measurement.zzej r3 = r32.zzje()
            r3.endTransaction()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zza(com.google.android.gms.internal.measurement.zzew, java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzee zzee, zzdz zzdz) {
        zzfj zzis;
        String str;
        Object zzbl;
        String zzbk;
        Object value;
        zzfj zzis2;
        String str2;
        Object zzbl2;
        String zzbk2;
        Object obj;
        Preconditions.checkNotNull(zzee);
        Preconditions.checkNotEmpty(zzee.packageName);
        Preconditions.checkNotNull(zzee.origin);
        Preconditions.checkNotNull(zzee.zzaeq);
        Preconditions.checkNotEmpty(zzee.zzaeq.name);
        zzab();
        zzkz();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzee zzee2 = new zzee(zzee);
            boolean z = false;
            zzee2.active = false;
            zzje().beginTransaction();
            try {
                zzee zzi = zzje().zzi(zzee2.packageName, zzee2.zzaeq.name);
                if (zzi != null && !zzi.origin.equals(zzee2.origin)) {
                    this.zzacw.zzgf().zziv().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzacw.zzgb().zzbk(zzee2.zzaeq.name), zzee2.origin, zzi.origin);
                }
                if (zzi != null && zzi.active) {
                    zzee2.origin = zzi.origin;
                    zzee2.creationTimestamp = zzi.creationTimestamp;
                    zzee2.triggerTimeout = zzi.triggerTimeout;
                    zzee2.triggerEventName = zzi.triggerEventName;
                    zzee2.zzaes = zzi.zzaes;
                    zzee2.active = zzi.active;
                    zzee2.zzaeq = new zzjz(zzee2.zzaeq.name, zzi.zzaeq.zzarl, zzee2.zzaeq.getValue(), zzi.zzaeq.origin);
                } else if (TextUtils.isEmpty(zzee2.triggerEventName)) {
                    zzee2.zzaeq = new zzjz(zzee2.zzaeq.name, zzee2.creationTimestamp, zzee2.zzaeq.getValue(), zzee2.zzaeq.origin);
                    zzee2.active = true;
                    z = true;
                }
                if (zzee2.active) {
                    zzjz zzjz = zzee2.zzaeq;
                    zzkb zzkb = new zzkb(zzee2.packageName, zzee2.origin, zzjz.name, zzjz.zzarl, zzjz.getValue());
                    if (zzje().zza(zzkb)) {
                        zzis2 = this.zzacw.zzgf().zziy();
                        str2 = "User property updated immediately";
                        zzbl2 = zzee2.packageName;
                        zzbk2 = this.zzacw.zzgb().zzbk(zzkb.name);
                        obj = zzkb.value;
                    } else {
                        zzis2 = this.zzacw.zzgf().zzis();
                        str2 = "(2)Too many active user properties, ignoring";
                        zzbl2 = zzfh.zzbl(zzee2.packageName);
                        zzbk2 = this.zzacw.zzgb().zzbk(zzkb.name);
                        obj = zzkb.value;
                    }
                    zzis2.zzd(str2, zzbl2, zzbk2, obj);
                    if (z && zzee2.zzaes != null) {
                        zzc(new zzew(zzee2.zzaes, zzee2.creationTimestamp), zzdz);
                    }
                }
                if (zzje().zza(zzee2)) {
                    zzis = this.zzacw.zzgf().zziy();
                    str = "Conditional property added";
                    zzbl = zzee2.packageName;
                    zzbk = this.zzacw.zzgb().zzbk(zzee2.zzaeq.name);
                    value = zzee2.zzaeq.getValue();
                } else {
                    zzis = this.zzacw.zzgf().zzis();
                    str = "Too many conditional properties, ignoring";
                    zzbl = zzfh.zzbl(zzee2.packageName);
                    zzbk = this.zzacw.zzgb().zzbk(zzee2.zzaeq.name);
                    value = zzee2.zzaeq.getValue();
                }
                zzis.zzd(str, zzbl, zzbk, value);
                zzje().setTransactionSuccessful();
            } finally {
                zzje().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzew zzew, zzdz zzdz) {
        List<zzee> list;
        List<zzee> list2;
        List<zzee> list3;
        zzfj zzis;
        String str;
        Object zzbl;
        String zzbk;
        Object obj;
        zzew zzew2 = zzew;
        zzdz zzdz2 = zzdz;
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz2.packageName);
        zzab();
        zzkz();
        String str2 = zzdz2.packageName;
        long j = zzew2.zzagc;
        if (this.zzacw.zzgc().zzd(zzew2, zzdz2)) {
            if (!zzdz2.zzadw) {
                zzg(zzdz2);
                return;
            }
            zzje().beginTransaction();
            try {
                zzej zzje = zzje();
                Preconditions.checkNotEmpty(str2);
                zzje.zzab();
                zzje.zzch();
                if (j < 0) {
                    zzje.zzgf().zziv().zze("Invalid time querying timed out conditional properties", zzfh.zzbl(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzje.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzee next : list) {
                    if (next != null) {
                        this.zzacw.zzgf().zziy().zzd("User property timed out", next.packageName, this.zzacw.zzgb().zzbk(next.zzaeq.name), next.zzaeq.getValue());
                        if (next.zzaer != null) {
                            zzc(new zzew(next.zzaer, j), zzdz2);
                        }
                        zzje().zzj(str2, next.zzaeq.name);
                    }
                }
                zzej zzje2 = zzje();
                Preconditions.checkNotEmpty(str2);
                zzje2.zzab();
                zzje2.zzch();
                if (j < 0) {
                    zzje2.zzgf().zziv().zze("Invalid time querying expired conditional properties", zzfh.zzbl(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzje2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzee next2 : list2) {
                    if (next2 != null) {
                        this.zzacw.zzgf().zziy().zzd("User property expired", next2.packageName, this.zzacw.zzgb().zzbk(next2.zzaeq.name), next2.zzaeq.getValue());
                        zzje().zzg(str2, next2.zzaeq.name);
                        if (next2.zzaet != null) {
                            arrayList.add(next2.zzaet);
                        }
                        zzje().zzj(str2, next2.zzaeq.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    zzc(new zzew((zzew) obj2, j), zzdz2);
                }
                zzej zzje3 = zzje();
                String str3 = zzew2.name;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzje3.zzab();
                zzje3.zzch();
                if (j < 0) {
                    zzje3.zzgf().zziv().zzd("Invalid time querying triggered conditional properties", zzfh.zzbl(str2), zzje3.zzgb().zzbi(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzje3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                Iterator<zzee> it = list3.iterator();
                while (it.hasNext()) {
                    zzee next3 = it.next();
                    if (next3 != null) {
                        zzjz zzjz = next3.zzaeq;
                        zzkb zzkb = r5;
                        Iterator<zzee> it2 = it;
                        zzee zzee = next3;
                        zzkb zzkb2 = new zzkb(next3.packageName, next3.origin, zzjz.name, j, zzjz.getValue());
                        if (zzje().zza(zzkb)) {
                            zzis = this.zzacw.zzgf().zziy();
                            str = "User property triggered";
                            zzbl = zzee.packageName;
                            zzbk = this.zzacw.zzgb().zzbk(zzkb.name);
                            obj = zzkb.value;
                        } else {
                            zzis = this.zzacw.zzgf().zzis();
                            str = "Too many active user properties, ignoring";
                            zzbl = zzfh.zzbl(zzee.packageName);
                            zzbk = this.zzacw.zzgb().zzbk(zzkb.name);
                            obj = zzkb.value;
                        }
                        zzis.zzd(str, zzbl, zzbk, obj);
                        if (zzee.zzaes != null) {
                            arrayList3.add(zzee.zzaes);
                        }
                        zzee.zzaeq = new zzjz(zzkb);
                        zzee.active = true;
                        zzje().zza(zzee);
                        it = it2;
                    }
                }
                zzc(zzew, zzdz);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzew((zzew) obj3, j), zzdz2);
                }
                zzje().setTransactionSuccessful();
                zzje().endTransaction();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzje().endTransaction();
                throw th2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjr zzjr) {
        this.zzaqu++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzjz zzjz, zzdz zzdz) {
        zzab();
        zzkz();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            int zzce = this.zzacw.zzgc().zzce(zzjz.name);
            if (zzce != 0) {
                this.zzacw.zzgc();
                this.zzacw.zzgc().zza(zzdz.packageName, zzce, "_ev", zzkc.zza(zzjz.name, 24, true), zzjz.name != null ? zzjz.name.length() : 0);
                return;
            }
            int zzi = this.zzacw.zzgc().zzi(zzjz.name, zzjz.getValue());
            if (zzi != 0) {
                this.zzacw.zzgc();
                String zza2 = zzkc.zza(zzjz.name, 24, true);
                Object value = zzjz.getValue();
                this.zzacw.zzgc().zza(zzdz.packageName, zzi, "_ev", zza2, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
                return;
            }
            Object zzj = this.zzacw.zzgc().zzj(zzjz.name, zzjz.getValue());
            if (zzj != null) {
                zzkb zzkb = new zzkb(zzdz.packageName, zzjz.origin, zzjz.name, zzjz.zzarl, zzj);
                this.zzacw.zzgf().zziy().zze("Setting user property", this.zzacw.zzgb().zzbk(zzkb.name), zzj);
                zzje().beginTransaction();
                try {
                    zzg(zzdz);
                    boolean zza3 = zzje().zza(zzkb);
                    zzje().setTransactionSuccessful();
                    if (zza3) {
                        this.zzacw.zzgf().zziy().zze("User property set", this.zzacw.zzgb().zzbk(zzkb.name), zzkb.value);
                    } else {
                        this.zzacw.zzgf().zzis().zze("Too many unique user properties are set. Ignoring user property", this.zzacw.zzgb().zzbk(zzkb.name), zzkb.value);
                        this.zzacw.zzgc().zza(zzdz.packageName, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzje().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0136 A[Catch:{ all -> 0x017d, all -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146 A[Catch:{ all -> 0x017d, all -> 0x000f }] */
    @android.support.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzab()
            r6.zzkz()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x000f }
            goto L_0x0012
        L_0x000f:
            r7 = move-exception
            goto L_0x0186
        L_0x0012:
            com.google.android.gms.internal.measurement.zzgm r1 = r6.zzacw     // Catch:{ all -> 0x000f }
            com.google.android.gms.internal.measurement.zzfh r1 = r1.zzgf()     // Catch:{ all -> 0x000f }
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zziz()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x000f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x000f }
            r1.zzg(r2, r3)     // Catch:{ all -> 0x000f }
            com.google.android.gms.internal.measurement.zzej r1 = r6.zzje()     // Catch:{ all -> 0x000f }
            r1.beginTransaction()     // Catch:{ all -> 0x000f }
            com.google.android.gms.internal.measurement.zzej r1 = r6.zzje()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzdy r1 = r1.zzbb(r7)     // Catch:{ all -> 0x017d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 1
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r2) goto L_0x0042
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x0042
            if (r8 != r4) goto L_0x0046
        L_0x0042:
            if (r9 != 0) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            if (r1 != 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzgm r8 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziv()     // Catch:{ all -> 0x017d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r7)     // Catch:{ all -> 0x017d }
            r8.zzg(r9, r7)     // Catch:{ all -> 0x017d }
            goto L_0x0171
        L_0x005e:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ce
            if (r8 != r5) goto L_0x0065
            goto L_0x00ce
        L_0x0065:
            com.google.android.gms.internal.measurement.zzgm r10 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.common.util.Clock r10 = r10.zzbt()     // Catch:{ all -> 0x017d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x017d }
            r1.zzt(r10)     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzej r10 = r6.zzje()     // Catch:{ all -> 0x017d }
            r10.zza((com.google.android.gms.internal.measurement.zzdy) r1)     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzgm r10 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfh r10 = r10.zzgf()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfj r10 = r10.zziz()     // Catch:{ all -> 0x017d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x017d }
            r10.zze(r11, r1, r9)     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzgg r9 = r6.zzkv()     // Catch:{ all -> 0x017d }
            r9.zzbv(r7)     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzgm r7 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfs r7 = r7.zzgg()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfv r7 = r7.zzake     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzgm r9 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.common.util.Clock r9 = r9.zzbt()     // Catch:{ all -> 0x017d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x017d }
            r7.set(r9)     // Catch:{ all -> 0x017d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b2
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r3 = 0
        L_0x00b2:
            if (r3 == 0) goto L_0x00c9
            com.google.android.gms.internal.measurement.zzgm r7 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfs r7 = r7.zzgg()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfv r7 = r7.zzakf     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzgm r8 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.common.util.Clock r8 = r8.zzbt()     // Catch:{ all -> 0x017d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x017d }
            r7.set(r8)     // Catch:{ all -> 0x017d }
        L_0x00c9:
            r6.zzld()     // Catch:{ all -> 0x017d }
            goto L_0x0171
        L_0x00ce:
            r9 = 0
            if (r11 == 0) goto L_0x00da
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x017d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x017d }
            goto L_0x00db
        L_0x00da:
            r11 = r9
        L_0x00db:
            if (r11 == 0) goto L_0x00ea
            int r2 = r11.size()     // Catch:{ all -> 0x017d }
            if (r2 <= 0) goto L_0x00ea
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x017d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x017d }
            goto L_0x00eb
        L_0x00ea:
            r11 = r9
        L_0x00eb:
            if (r8 == r5) goto L_0x0107
            if (r8 != r4) goto L_0x00f0
            goto L_0x0107
        L_0x00f0:
            com.google.android.gms.internal.measurement.zzgg r9 = r6.zzkv()     // Catch:{ all -> 0x017d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x017d }
            if (r9 != 0) goto L_0x0120
            com.google.android.gms.internal.measurement.zzej r7 = r6.zzje()     // Catch:{ all -> 0x000f }
        L_0x00fe:
            r7.endTransaction()     // Catch:{ all -> 0x000f }
            r6.zzaqw = r0
            r6.zzle()
            return
        L_0x0107:
            com.google.android.gms.internal.measurement.zzgg r11 = r6.zzkv()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzkm r11 = r11.zzbt(r7)     // Catch:{ all -> 0x017d }
            if (r11 != 0) goto L_0x0120
            com.google.android.gms.internal.measurement.zzgg r11 = r6.zzkv()     // Catch:{ all -> 0x017d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x017d }
            if (r9 != 0) goto L_0x0120
            com.google.android.gms.internal.measurement.zzej r7 = r6.zzje()     // Catch:{ all -> 0x000f }
            goto L_0x00fe
        L_0x0120:
            com.google.android.gms.internal.measurement.zzgm r9 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.common.util.Clock r9 = r9.zzbt()     // Catch:{ all -> 0x017d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x017d }
            r1.zzs(r2)     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzej r9 = r6.zzje()     // Catch:{ all -> 0x017d }
            r9.zza((com.google.android.gms.internal.measurement.zzdy) r1)     // Catch:{ all -> 0x017d }
            if (r8 != r5) goto L_0x0146
            com.google.android.gms.internal.measurement.zzgm r8 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziw()     // Catch:{ all -> 0x017d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzg(r9, r7)     // Catch:{ all -> 0x017d }
            goto L_0x015e
        L_0x0146:
            com.google.android.gms.internal.measurement.zzgm r7 = r6.zzacw     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfh r7 = r7.zzgf()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zziz()     // Catch:{ all -> 0x017d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x017d }
            int r10 = r10.length     // Catch:{ all -> 0x017d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x017d }
            r7.zze(r9, r8, r10)     // Catch:{ all -> 0x017d }
        L_0x015e:
            com.google.android.gms.internal.measurement.zzfl r7 = r6.zzkw()     // Catch:{ all -> 0x017d }
            boolean r7 = r7.zzex()     // Catch:{ all -> 0x017d }
            if (r7 == 0) goto L_0x00c9
            boolean r7 = r6.zzlc()     // Catch:{ all -> 0x017d }
            if (r7 == 0) goto L_0x00c9
            r6.zzlb()     // Catch:{ all -> 0x017d }
        L_0x0171:
            com.google.android.gms.internal.measurement.zzej r7 = r6.zzje()     // Catch:{ all -> 0x017d }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x017d }
            com.google.android.gms.internal.measurement.zzej r7 = r6.zzje()     // Catch:{ all -> 0x000f }
            goto L_0x00fe
        L_0x017d:
            r7 = move-exception
            com.google.android.gms.internal.measurement.zzej r8 = r6.zzje()     // Catch:{ all -> 0x000f }
            r8.endTransaction()     // Catch:{ all -> 0x000f }
            throw r7     // Catch:{ all -> 0x000f }
        L_0x0186:
            r6.zzaqw = r0
            r6.zzle()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final Clock zzbt() {
        return this.zzacw.zzbt();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzee zzee, zzdz zzdz) {
        Preconditions.checkNotNull(zzee);
        Preconditions.checkNotEmpty(zzee.packageName);
        Preconditions.checkNotNull(zzee.zzaeq);
        Preconditions.checkNotEmpty(zzee.zzaeq.name);
        zzab();
        zzkz();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzje().beginTransaction();
            try {
                zzg(zzdz);
                zzee zzi = zzje().zzi(zzee.packageName, zzee.zzaeq.name);
                if (zzi != null) {
                    this.zzacw.zzgf().zziy().zze("Removing conditional user property", zzee.packageName, this.zzacw.zzgb().zzbk(zzee.zzaeq.name));
                    zzje().zzj(zzee.packageName, zzee.zzaeq.name);
                    if (zzi.active) {
                        zzje().zzg(zzee.packageName, zzee.zzaeq.name);
                    }
                    if (zzee.zzaet != null) {
                        Bundle bundle = null;
                        if (zzee.zzaet.zzafr != null) {
                            bundle = zzee.zzaet.zzafr.zzij();
                        }
                        Bundle bundle2 = bundle;
                        zzc(this.zzacw.zzgc().zza(zzee.zzaet.name, bundle2, zzi.origin, zzee.zzaet.zzagc, true, false), zzdz);
                    }
                } else {
                    this.zzacw.zzgf().zziv().zze("Conditional user property doesn't exist", zzfh.zzbl(zzee.packageName), this.zzacw.zzgb().zzbk(zzee.zzaeq.name));
                }
                zzje().setTransactionSuccessful();
            } finally {
                zzje().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzew zzew, String str) {
        zzew zzew2 = zzew;
        String str2 = str;
        zzdy zzbb = zzje().zzbb(str2);
        if (zzbb == null || TextUtils.isEmpty(zzbb.zzag())) {
            this.zzacw.zzgf().zziy().zzg("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzbb);
        if (zzc == null) {
            if (!"_ui".equals(zzew2.name)) {
                this.zzacw.zzgf().zziv().zzg("Could not find package. appId", zzfh.zzbl(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzacw.zzgf().zzis().zzg("App version does not match; dropping event. appId", zzfh.zzbl(str));
            return;
        }
        zzdz zzdz = r2;
        zzdz zzdz2 = new zzdz(str2, zzbb.getGmpAppId(), zzbb.zzag(), zzbb.zzgo(), zzbb.zzgp(), zzbb.zzgq(), zzbb.zzgr(), (String) null, zzbb.isMeasurementEnabled(), false, zzbb.zzgl(), zzbb.zzhe(), 0, 0, zzbb.zzhf(), zzbb.zzhg(), false);
        zzb(zzew2, zzdz);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzjz zzjz, zzdz zzdz) {
        zzab();
        zzkz();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            this.zzacw.zzgf().zziy().zzg("Removing user property", this.zzacw.zzgb().zzbk(zzjz.name));
            zzje().beginTransaction();
            try {
                zzg(zzdz);
                zzje().zzg(zzdz.packageName, zzjz.name);
                zzje().setTransactionSuccessful();
                this.zzacw.zzgf().zziy().zzg("User property removed", this.zzacw.zzgb().zzbk(zzjz.name));
            } finally {
                zzje().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzdz zzca(String str) {
        zzfj zziy;
        String str2;
        Object obj;
        String str3 = str;
        zzdy zzbb = zzje().zzbb(str3);
        if (zzbb == null || TextUtils.isEmpty(zzbb.zzag())) {
            zziy = this.zzacw.zzgf().zziy();
            str2 = "No app data available; dropping";
            obj = str3;
        } else {
            Boolean zzc = zzc(zzbb);
            if (zzc == null || zzc.booleanValue()) {
                return new zzdz(str3, zzbb.getGmpAppId(), zzbb.zzag(), zzbb.zzgo(), zzbb.zzgp(), zzbb.zzgq(), zzbb.zzgr(), (String) null, zzbb.isMeasurementEnabled(), false, zzbb.zzgl(), zzbb.zzhe(), 0, 0, zzbb.zzhf(), zzbb.zzhg(), false);
            }
            zziy = this.zzacw.zzgf().zzis();
            str2 = "App version does not match; dropping. appId";
            obj = zzfh.zzbl(str);
        }
        zziy.zzg(str2, obj);
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzd(zzdz zzdz) {
        if (this.zzarb != null) {
            this.zzarc = new ArrayList();
            this.zzarc.addAll(this.zzarb);
        }
        zzej zzje = zzje();
        String str = zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzje.zzab();
        zzje.zzch();
        try {
            SQLiteDatabase writableDatabase = zzje.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzje.zzgf().zziz().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzje.zzgf().zzis().zze("Error resetting analytics data. appId, error", zzfh.zzbl(str), e);
        }
        zzdz zza2 = zza(this.zzacw.getContext(), zzdz.packageName, zzdz.zzadm, zzdz.zzadw, zzdz.zzady, zzdz.zzadz, zzdz.zzaem);
        if (!this.zzacw.zzgh().zzay(zzdz.packageName) || zzdz.zzadw) {
            zzf(zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzdz zzdz) {
        zzab();
        zzkz();
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzg(zzdz);
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x03b6 A[Catch:{ SQLiteException -> 0x0144, all -> 0x03df }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ea A[Catch:{ SQLiteException -> 0x0144, all -> 0x03df }] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.internal.measurement.zzdz r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r20.zzab()
            r20.zzkz()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r21)
            java.lang.String r3 = r2.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            java.lang.String r3 = r2.zzadm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x001b
            return
        L_0x001b:
            com.google.android.gms.internal.measurement.zzej r3 = r20.zzje()
            java.lang.String r4 = r2.packageName
            com.google.android.gms.internal.measurement.zzdy r3 = r3.zzbb(r4)
            r4 = 0
            if (r3 == 0) goto L_0x004e
            java.lang.String r6 = r3.getGmpAppId()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x004e
            java.lang.String r6 = r2.zzadm
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004e
            r3.zzs(r4)
            com.google.android.gms.internal.measurement.zzej r6 = r20.zzje()
            r6.zza((com.google.android.gms.internal.measurement.zzdy) r3)
            com.google.android.gms.internal.measurement.zzgg r3 = r20.zzkv()
            java.lang.String r6 = r2.packageName
            r3.zzbw(r6)
        L_0x004e:
            boolean r3 = r2.zzadw
            if (r3 != 0) goto L_0x0056
            r20.zzg((com.google.android.gms.internal.measurement.zzdz) r21)
            return
        L_0x0056:
            long r6 = r2.zzaem
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0066
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.common.util.Clock r3 = r3.zzbt()
            long r6 = r3.currentTimeMillis()
        L_0x0066:
            int r3 = r2.zzaen
            r14 = 0
            r15 = 1
            if (r3 == 0) goto L_0x0088
            if (r3 == r15) goto L_0x0088
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziv()
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            java.lang.String r10 = r2.packageName
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfh.zzbl(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r8.zze(r9, r10, r3)
            r3 = 0
        L_0x0088:
            com.google.android.gms.internal.measurement.zzej r8 = r20.zzje()
            r8.beginTransaction()
            com.google.android.gms.internal.measurement.zzej r8 = r20.zzje()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzdy r8 = r8.zzbb(r9)     // Catch:{ all -> 0x03df }
            r16 = 0
            if (r8 == 0) goto L_0x0159
            java.lang.String r9 = r8.getGmpAppId()     // Catch:{ all -> 0x03df }
            if (r9 == 0) goto L_0x0159
            java.lang.String r9 = r8.getGmpAppId()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = r2.zzadm     // Catch:{ all -> 0x03df }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x03df }
            if (r9 != 0) goto L_0x0159
            com.google.android.gms.internal.measurement.zzgm r9 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfh r9 = r9.zzgf()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zziv()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r11 = r8.zzah()     // Catch:{ all -> 0x03df }
            java.lang.Object r11 = com.google.android.gms.internal.measurement.zzfh.zzbl(r11)     // Catch:{ all -> 0x03df }
            r9.zzg(r10, r11)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzej r9 = r20.zzje()     // Catch:{ all -> 0x03df }
            java.lang.String r8 = r8.zzah()     // Catch:{ all -> 0x03df }
            r9.zzch()     // Catch:{ all -> 0x03df }
            r9.zzab()     // Catch:{ all -> 0x03df }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x03df }
            android.database.sqlite.SQLiteDatabase r10 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0144 }
            java.lang.String[] r11 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0144 }
            r11[r14] = r8     // Catch:{ SQLiteException -> 0x0144 }
            java.lang.String r12 = "events"
            java.lang.String r13 = "app_id=?"
            int r12 = r10.delete(r12, r13, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r14
            java.lang.String r13 = "user_attributes"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "conditional_properties"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "apps"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "raw_events"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "raw_events_metadata"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "event_filters"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "property_filters"
            java.lang.String r14 = "app_id=?"
            int r13 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r13
            java.lang.String r13 = "audience_filter_values"
            java.lang.String r14 = "app_id=?"
            int r10 = r10.delete(r13, r14, r11)     // Catch:{ SQLiteException -> 0x0144 }
            int r12 = r12 + r10
            if (r12 <= 0) goto L_0x0157
            com.google.android.gms.internal.measurement.zzfh r10 = r9.zzgf()     // Catch:{ SQLiteException -> 0x0144 }
            com.google.android.gms.internal.measurement.zzfj r10 = r10.zziz()     // Catch:{ SQLiteException -> 0x0144 }
            java.lang.String r11 = "Deleted application data. app, records"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ SQLiteException -> 0x0144 }
            r10.zze(r11, r8, r12)     // Catch:{ SQLiteException -> 0x0144 }
            goto L_0x0157
        L_0x0144:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.internal.measurement.zzfh r9 = r9.zzgf()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zzis()     // Catch:{ all -> 0x03df }
            java.lang.String r11 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r8)     // Catch:{ all -> 0x03df }
            r9.zze(r11, r8, r10)     // Catch:{ all -> 0x03df }
        L_0x0157:
            r8 = r16
        L_0x0159:
            if (r8 == 0) goto L_0x01c9
            long r9 = r8.zzgo()     // Catch:{ all -> 0x03df }
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0195
            long r9 = r8.zzgo()     // Catch:{ all -> 0x03df }
            long r11 = r2.zzads     // Catch:{ all -> 0x03df }
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x01c9
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r9.<init>()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_pv"
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x03df }
            r9.putString(r10, r8)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzew r14 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_au"
            com.google.android.gms.internal.measurement.zzet r11 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r11.<init>(r9)     // Catch:{ all -> 0x03df }
            java.lang.String r12 = "auto"
            r8 = r14
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
        L_0x0191:
            r1.zzb((com.google.android.gms.internal.measurement.zzew) r14, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
            goto L_0x01c9
        L_0x0195:
            java.lang.String r9 = r8.zzag()     // Catch:{ all -> 0x03df }
            if (r9 == 0) goto L_0x01c9
            java.lang.String r9 = r8.zzag()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = r2.zzth     // Catch:{ all -> 0x03df }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x03df }
            if (r9 != 0) goto L_0x01c9
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r9.<init>()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_pv"
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x03df }
            r9.putString(r10, r8)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzew r14 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_au"
            com.google.android.gms.internal.measurement.zzet r11 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r11.<init>(r9)     // Catch:{ all -> 0x03df }
            java.lang.String r12 = "auto"
            r8 = r14
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
            goto L_0x0191
        L_0x01c9:
            r20.zzg((com.google.android.gms.internal.measurement.zzdz) r21)     // Catch:{ all -> 0x03df }
            if (r3 != 0) goto L_0x01db
            com.google.android.gms.internal.measurement.zzej r8 = r20.zzje()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_f"
        L_0x01d6:
            com.google.android.gms.internal.measurement.zzes r8 = r8.zzf(r9, r10)     // Catch:{ all -> 0x03df }
            goto L_0x01e8
        L_0x01db:
            if (r3 != r15) goto L_0x01e6
            com.google.android.gms.internal.measurement.zzej r8 = r20.zzje()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_v"
            goto L_0x01d6
        L_0x01e6:
            r8 = r16
        L_0x01e8:
            if (r8 != 0) goto L_0x03b6
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            long r10 = r6 / r8
            r13 = 1
            long r17 = r10 + r13
            long r8 = r8 * r17
            if (r3 != 0) goto L_0x0345
            com.google.android.gms.internal.measurement.zzjz r3 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_fot"
            java.lang.Long r12 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x03df }
            java.lang.String r17 = "auto"
            r8 = r3
            r9 = r10
            r10 = r6
            r4 = r13
            r13 = r17
            r8.<init>(r9, r10, r12, r13)     // Catch:{ all -> 0x03df }
            r1.zzb((com.google.android.gms.internal.measurement.zzjz) r3, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
            r20.zzab()     // Catch:{ all -> 0x03df }
            r20.zzkz()     // Catch:{ all -> 0x03df }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r3.<init>()     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_c"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_r"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_uwa"
            r9 = 0
            r3.putLong(r8, r9)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_pfo"
            r3.putLong(r8, r9)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_sys"
            r3.putLong(r8, r9)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_sysu"
            r3.putLong(r8, r9)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzeg r8 = r8.zzgh()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            boolean r8 = r8.zzay(r9)     // Catch:{ all -> 0x03df }
            if (r8 == 0) goto L_0x024f
            boolean r8 = r2.zzaeo     // Catch:{ all -> 0x03df }
            if (r8 == 0) goto L_0x024f
            java.lang.String r8 = "_dac"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
        L_0x024f:
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x03df }
            android.content.Context r8 = r8.getContext()     // Catch:{ all -> 0x03df }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ all -> 0x03df }
            if (r8 != 0) goto L_0x0272
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zzis()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r10 = r2.packageName     // Catch:{ all -> 0x03df }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfh.zzbl(r10)     // Catch:{ all -> 0x03df }
            r8.zzg(r9, r10)     // Catch:{ all -> 0x03df }
            goto L_0x0311
        L_0x0272:
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ NameNotFoundException -> 0x0284 }
            android.content.Context r8 = r8.getContext()     // Catch:{ NameNotFoundException -> 0x0284 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r8 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)     // Catch:{ NameNotFoundException -> 0x0284 }
            java.lang.String r9 = r2.packageName     // Catch:{ NameNotFoundException -> 0x0284 }
            r10 = 0
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x0284 }
            goto L_0x029d
        L_0x0284:
            r0 = move-exception
            r8 = r0
            com.google.android.gms.internal.measurement.zzgm r9 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfh r9 = r9.zzgf()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zzis()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x03df }
            java.lang.Object r11 = com.google.android.gms.internal.measurement.zzfh.zzbl(r11)     // Catch:{ all -> 0x03df }
            r9.zze(r10, r11, r8)     // Catch:{ all -> 0x03df }
            r8 = r16
        L_0x029d:
            if (r8 == 0) goto L_0x02cf
            long r9 = r8.firstInstallTime     // Catch:{ all -> 0x03df }
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x02cf
            long r9 = r8.firstInstallTime     // Catch:{ all -> 0x03df }
            long r11 = r8.lastUpdateTime     // Catch:{ all -> 0x03df }
            int r8 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r8 == 0) goto L_0x02b6
            java.lang.String r8 = "_uwa"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            r8 = 0
            goto L_0x02b7
        L_0x02b6:
            r8 = 1
        L_0x02b7:
            com.google.android.gms.internal.measurement.zzjz r14 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "_fi"
            if (r8 == 0) goto L_0x02bf
            r10 = r4
            goto L_0x02c1
        L_0x02bf:
            r10 = 0
        L_0x02c1:
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x03df }
            java.lang.String r13 = "auto"
            r8 = r14
            r10 = r6
            r8.<init>(r9, r10, r12, r13)     // Catch:{ all -> 0x03df }
            r1.zzb((com.google.android.gms.internal.measurement.zzjz) r14, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ NameNotFoundException -> 0x02e1 }
            android.content.Context r8 = r8.getContext()     // Catch:{ NameNotFoundException -> 0x02e1 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r8 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)     // Catch:{ NameNotFoundException -> 0x02e1 }
            java.lang.String r9 = r2.packageName     // Catch:{ NameNotFoundException -> 0x02e1 }
            r10 = 0
            android.content.pm.ApplicationInfo r8 = r8.getApplicationInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x02e1 }
            goto L_0x02fa
        L_0x02e1:
            r0 = move-exception
            r8 = r0
            com.google.android.gms.internal.measurement.zzgm r9 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfh r9 = r9.zzgf()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zzis()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x03df }
            java.lang.Object r11 = com.google.android.gms.internal.measurement.zzfh.zzbl(r11)     // Catch:{ all -> 0x03df }
            r9.zze(r10, r11, r8)     // Catch:{ all -> 0x03df }
            r8 = r16
        L_0x02fa:
            if (r8 == 0) goto L_0x0311
            int r9 = r8.flags     // Catch:{ all -> 0x03df }
            r9 = r9 & r15
            if (r9 == 0) goto L_0x0306
            java.lang.String r9 = "_sys"
            r3.putLong(r9, r4)     // Catch:{ all -> 0x03df }
        L_0x0306:
            int r8 = r8.flags     // Catch:{ all -> 0x03df }
            r8 = r8 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0311
            java.lang.String r8 = "_sysu"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
        L_0x0311:
            com.google.android.gms.internal.measurement.zzej r8 = r20.zzje()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x03df }
            r8.zzab()     // Catch:{ all -> 0x03df }
            r8.zzch()     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "first_open_count"
            long r8 = r8.zzm(r9, r10)     // Catch:{ all -> 0x03df }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0331
            java.lang.String r10 = "_pfo"
            r3.putLong(r10, r8)     // Catch:{ all -> 0x03df }
        L_0x0331:
            com.google.android.gms.internal.measurement.zzew r14 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "_f"
            com.google.android.gms.internal.measurement.zzet r10 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r10.<init>(r3)     // Catch:{ all -> 0x03df }
            java.lang.String r11 = "auto"
            r8 = r14
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
        L_0x0341:
            r1.zzb((com.google.android.gms.internal.measurement.zzew) r14, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
            goto L_0x0398
        L_0x0345:
            r4 = r13
            if (r3 != r15) goto L_0x0398
            com.google.android.gms.internal.measurement.zzjz r3 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ all -> 0x03df }
            java.lang.String r10 = "_fvt"
            java.lang.Long r12 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x03df }
            java.lang.String r13 = "auto"
            r8 = r3
            r9 = r10
            r10 = r6
            r8.<init>(r9, r10, r12, r13)     // Catch:{ all -> 0x03df }
            r1.zzb((com.google.android.gms.internal.measurement.zzjz) r3, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
            r20.zzab()     // Catch:{ all -> 0x03df }
            r20.zzkz()     // Catch:{ all -> 0x03df }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r3.<init>()     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_c"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_r"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzgm r8 = r1.zzacw     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzeg r8 = r8.zzgh()     // Catch:{ all -> 0x03df }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x03df }
            boolean r8 = r8.zzay(r9)     // Catch:{ all -> 0x03df }
            if (r8 == 0) goto L_0x0387
            boolean r8 = r2.zzaeo     // Catch:{ all -> 0x03df }
            if (r8 == 0) goto L_0x0387
            java.lang.String r8 = "_dac"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
        L_0x0387:
            com.google.android.gms.internal.measurement.zzew r14 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "_v"
            com.google.android.gms.internal.measurement.zzet r10 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r10.<init>(r3)     // Catch:{ all -> 0x03df }
            java.lang.String r11 = "auto"
            r8 = r14
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
            goto L_0x0341
        L_0x0398:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r3.<init>()     // Catch:{ all -> 0x03df }
            java.lang.String r8 = "_et"
            r3.putLong(r8, r4)     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzew r4 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "_e"
            com.google.android.gms.internal.measurement.zzet r10 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r10.<init>(r3)     // Catch:{ all -> 0x03df }
            java.lang.String r11 = "auto"
            r8 = r4
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
        L_0x03b2:
            r1.zzb((com.google.android.gms.internal.measurement.zzew) r4, (com.google.android.gms.internal.measurement.zzdz) r2)     // Catch:{ all -> 0x03df }
            goto L_0x03d0
        L_0x03b6:
            boolean r3 = r2.zzael     // Catch:{ all -> 0x03df }
            if (r3 == 0) goto L_0x03d0
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x03df }
            r3.<init>()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzew r4 = new com.google.android.gms.internal.measurement.zzew     // Catch:{ all -> 0x03df }
            java.lang.String r9 = "_cd"
            com.google.android.gms.internal.measurement.zzet r10 = new com.google.android.gms.internal.measurement.zzet     // Catch:{ all -> 0x03df }
            r10.<init>(r3)     // Catch:{ all -> 0x03df }
            java.lang.String r11 = "auto"
            r8 = r4
            r12 = r6
            r8.<init>(r9, r10, r11, r12)     // Catch:{ all -> 0x03df }
            goto L_0x03b2
        L_0x03d0:
            com.google.android.gms.internal.measurement.zzej r2 = r20.zzje()     // Catch:{ all -> 0x03df }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x03df }
            com.google.android.gms.internal.measurement.zzej r2 = r20.zzje()
            r2.endTransaction()
            return
        L_0x03df:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.measurement.zzej r3 = r20.zzje()
            r3.endTransaction()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzf(com.google.android.gms.internal.measurement.zzdz):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzg(Runnable runnable) {
        zzab();
        if (this.zzaqt == null) {
            this.zzaqt = new ArrayList();
        }
        this.zzaqt.add(runnable);
    }

    public final zzff zzgb() {
        return this.zzacw.zzgb();
    }

    public final zzkc zzgc() {
        return this.zzacw.zzgc();
    }

    public final zzgh zzge() {
        return this.zzacw.zzge();
    }

    public final zzfh zzgf() {
        return this.zzacw.zzgf();
    }

    public final zzeg zzgh() {
        return this.zzacw.zzgh();
    }

    public final zzec zzgi() {
        return this.zzacw.zzgi();
    }

    public final String zzh(zzdz zzdz) {
        try {
            return (String) this.zzacw.zzge().zzb(new zzjw(this, zzdz)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzacw.zzgf().zzis().zze("Failed to get app instance id. appId", zzfh.zzbl(zzdz.packageName), e);
            return null;
        }
    }

    public final zzjy zzjc() {
        zza((zzjr) this.zzaqq);
        return this.zzaqq;
    }

    public final zzeb zzjd() {
        zza((zzjr) this.zzaqp);
        return this.zzaqp;
    }

    public final zzej zzje() {
        zza((zzjr) this.zzaqm);
        return this.zzaqm;
    }

    public final zzfl zzkw() {
        zza((zzjr) this.zzaql);
        return this.zzaql;
    }

    /* access modifiers changed from: package-private */
    public final void zzkz() {
        if (!this.zzvo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:77|78) */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r14.zzacw.zzgf().zzis().zze("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.internal.measurement.zzfh.zzbl(r4), r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0276 */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzlb() {
        /*
            r14 = this;
            r14.zzab()
            r14.zzkz()
            r0 = 1
            r14.zzaqy = r0
            r1 = 0
            com.google.android.gms.internal.measurement.zzgm r2 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            r2.zzgi()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzgm r2 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzij r2 = r2.zzfy()     // Catch:{ all -> 0x02b1 }
            java.lang.Boolean r2 = r2.zzko()     // Catch:{ all -> 0x02b1 }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.internal.measurement.zzgm r0 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r0 = r0.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziv()     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
        L_0x0027:
            r0.log(r2)     // Catch:{ all -> 0x02b1 }
        L_0x002a:
            r14.zzaqy = r1
            r14.zzle()
            return
        L_0x0030:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02b1 }
            if (r2 == 0) goto L_0x0043
            com.google.android.gms.internal.measurement.zzgm r0 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r0 = r0.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zzis()     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            goto L_0x0027
        L_0x0043:
            long r2 = r14.zzaqs     // Catch:{ all -> 0x02b1 }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x004f
        L_0x004b:
            r14.zzld()     // Catch:{ all -> 0x02b1 }
            goto L_0x002a
        L_0x004f:
            r14.zzab()     // Catch:{ all -> 0x02b1 }
            java.util.List<java.lang.Long> r2 = r14.zzarb     // Catch:{ all -> 0x02b1 }
            if (r2 == 0) goto L_0x0058
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            if (r2 == 0) goto L_0x0068
            com.google.android.gms.internal.measurement.zzgm r0 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r0 = r0.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = "Uploading requested multiple times"
            goto L_0x0027
        L_0x0068:
            com.google.android.gms.internal.measurement.zzfl r2 = r14.zzkw()     // Catch:{ all -> 0x02b1 }
            boolean r2 = r2.zzex()     // Catch:{ all -> 0x02b1 }
            if (r2 != 0) goto L_0x0082
            com.google.android.gms.internal.measurement.zzgm r0 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r0 = r0.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.log(r2)     // Catch:{ all -> 0x02b1 }
            goto L_0x004b
        L_0x0082:
            com.google.android.gms.internal.measurement.zzgm r2 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.common.util.Clock r2 = r2.zzbt()     // Catch:{ all -> 0x02b1 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x02b1 }
            long r6 = com.google.android.gms.internal.measurement.zzeg.zzhm()     // Catch:{ all -> 0x02b1 }
            r8 = 0
            long r8 = r2 - r6
            r6 = 0
            r14.zzd(r6, r8)     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzgm r7 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfs r7 = r7.zzgg()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfv r7 = r7.zzakd     // Catch:{ all -> 0x02b1 }
            long r7 = r7.get()     // Catch:{ all -> 0x02b1 }
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00c1
            com.google.android.gms.internal.measurement.zzgm r4 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r4 = r4.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziy()     // Catch:{ all -> 0x02b1 }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            r9 = 0
            long r9 = r2 - r7
            long r7 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x02b1 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x02b1 }
            r4.zzg(r5, r7)     // Catch:{ all -> 0x02b1 }
        L_0x00c1:
            com.google.android.gms.internal.measurement.zzej r4 = r14.zzje()     // Catch:{ all -> 0x02b1 }
            java.lang.String r4 = r4.zzhr()     // Catch:{ all -> 0x02b1 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x02b1 }
            r7 = -1
            if (r5 != 0) goto L_0x028b
            long r9 = r14.zzard     // Catch:{ all -> 0x02b1 }
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x00e1
            com.google.android.gms.internal.measurement.zzej r5 = r14.zzje()     // Catch:{ all -> 0x02b1 }
            long r7 = r5.zzhy()     // Catch:{ all -> 0x02b1 }
            r14.zzard = r7     // Catch:{ all -> 0x02b1 }
        L_0x00e1:
            com.google.android.gms.internal.measurement.zzgm r5 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzeg r5 = r5.zzgh()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r7 = com.google.android.gms.internal.measurement.zzey.zzagv     // Catch:{ all -> 0x02b1 }
            int r5 = r5.zzb(r4, r7)     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzgm r7 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzeg r7 = r7.zzgh()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Integer> r8 = com.google.android.gms.internal.measurement.zzey.zzagw     // Catch:{ all -> 0x02b1 }
            int r7 = r7.zzb(r4, r8)     // Catch:{ all -> 0x02b1 }
            int r7 = java.lang.Math.max(r1, r7)     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzej r8 = r14.zzje()     // Catch:{ all -> 0x02b1 }
            java.util.List r5 = r8.zzb((java.lang.String) r4, (int) r5, (int) r7)     // Catch:{ all -> 0x02b1 }
            boolean r7 = r5.isEmpty()     // Catch:{ all -> 0x02b1 }
            if (r7 != 0) goto L_0x002a
            java.util.Iterator r7 = r5.iterator()     // Catch:{ all -> 0x02b1 }
        L_0x010f:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x02b1 }
            if (r8 == 0) goto L_0x012a
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x02b1 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x02b1 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks r8 = (com.google.android.gms.internal.measurement.zzks) r8     // Catch:{ all -> 0x02b1 }
            java.lang.String r9 = r8.zzauh     // Catch:{ all -> 0x02b1 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02b1 }
            if (r9 != 0) goto L_0x010f
            java.lang.String r7 = r8.zzauh     // Catch:{ all -> 0x02b1 }
            goto L_0x012b
        L_0x012a:
            r7 = r6
        L_0x012b:
            if (r7 == 0) goto L_0x0156
            r8 = 0
        L_0x012e:
            int r9 = r5.size()     // Catch:{ all -> 0x02b1 }
            if (r8 >= r9) goto L_0x0156
            java.lang.Object r9 = r5.get(r8)     // Catch:{ all -> 0x02b1 }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x02b1 }
            java.lang.Object r9 = r9.first     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks r9 = (com.google.android.gms.internal.measurement.zzks) r9     // Catch:{ all -> 0x02b1 }
            java.lang.String r10 = r9.zzauh     // Catch:{ all -> 0x02b1 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02b1 }
            if (r10 != 0) goto L_0x0153
            java.lang.String r9 = r9.zzauh     // Catch:{ all -> 0x02b1 }
            boolean r9 = r9.equals(r7)     // Catch:{ all -> 0x02b1 }
            if (r9 != 0) goto L_0x0153
            java.util.List r5 = r5.subList(r1, r8)     // Catch:{ all -> 0x02b1 }
            goto L_0x0156
        L_0x0153:
            int r8 = r8 + 1
            goto L_0x012e
        L_0x0156:
            com.google.android.gms.internal.measurement.zzkr r7 = new com.google.android.gms.internal.measurement.zzkr     // Catch:{ all -> 0x02b1 }
            r7.<init>()     // Catch:{ all -> 0x02b1 }
            int r8 = r5.size()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks[] r8 = new com.google.android.gms.internal.measurement.zzks[r8]     // Catch:{ all -> 0x02b1 }
            r7.zzatr = r8     // Catch:{ all -> 0x02b1 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x02b1 }
            int r9 = r5.size()     // Catch:{ all -> 0x02b1 }
            r8.<init>(r9)     // Catch:{ all -> 0x02b1 }
            boolean r9 = com.google.android.gms.internal.measurement.zzeg.zzho()     // Catch:{ all -> 0x02b1 }
            if (r9 == 0) goto L_0x0180
            com.google.android.gms.internal.measurement.zzgm r9 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzeg r9 = r9.zzgh()     // Catch:{ all -> 0x02b1 }
            boolean r9 = r9.zzas(r4)     // Catch:{ all -> 0x02b1 }
            if (r9 == 0) goto L_0x0180
            r9 = 1
            goto L_0x0181
        L_0x0180:
            r9 = 0
        L_0x0181:
            r10 = 0
        L_0x0182:
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            int r11 = r11.length     // Catch:{ all -> 0x02b1 }
            if (r10 >= r11) goto L_0x01d2
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            java.lang.Object r12 = r5.get(r10)     // Catch:{ all -> 0x02b1 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x02b1 }
            java.lang.Object r12 = r12.first     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks r12 = (com.google.android.gms.internal.measurement.zzks) r12     // Catch:{ all -> 0x02b1 }
            r11[r10] = r12     // Catch:{ all -> 0x02b1 }
            java.lang.Object r11 = r5.get(r10)     // Catch:{ all -> 0x02b1 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x02b1 }
            java.lang.Object r11 = r11.second     // Catch:{ all -> 0x02b1 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x02b1 }
            r8.add(r11)     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            r11 = r11[r10]     // Catch:{ all -> 0x02b1 }
            r12 = 12451(0x30a3, double:6.1516E-320)
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x02b1 }
            r11.zzaug = r12     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            r11 = r11[r10]     // Catch:{ all -> 0x02b1 }
            java.lang.Long r12 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x02b1 }
            r11.zzatw = r12     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            r11 = r11[r10]     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzgm r12 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            r12.zzgi()     // Catch:{ all -> 0x02b1 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x02b1 }
            r11.zzaul = r12     // Catch:{ all -> 0x02b1 }
            if (r9 != 0) goto L_0x01cf
            com.google.android.gms.internal.measurement.zzks[] r11 = r7.zzatr     // Catch:{ all -> 0x02b1 }
            r11 = r11[r10]     // Catch:{ all -> 0x02b1 }
            r11.zzaut = r6     // Catch:{ all -> 0x02b1 }
        L_0x01cf:
            int r10 = r10 + 1
            goto L_0x0182
        L_0x01d2:
            com.google.android.gms.internal.measurement.zzgm r5 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x02b1 }
            r9 = 2
            boolean r5 = r5.isLoggable(r9)     // Catch:{ all -> 0x02b1 }
            if (r5 == 0) goto L_0x01e7
            com.google.android.gms.internal.measurement.zzjy r5 = r14.zzjc()     // Catch:{ all -> 0x02b1 }
            java.lang.String r6 = r5.zzb(r7)     // Catch:{ all -> 0x02b1 }
        L_0x01e7:
            com.google.android.gms.internal.measurement.zzjy r5 = r14.zzjc()     // Catch:{ all -> 0x02b1 }
            byte[] r11 = r5.zza((com.google.android.gms.internal.measurement.zzkr) r7)     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.String> r5 = com.google.android.gms.internal.measurement.zzey.zzahf     // Catch:{ all -> 0x02b1 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x02b1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02b1 }
            java.net.URL r10 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0276 }
            r10.<init>(r5)     // Catch:{ MalformedURLException -> 0x0276 }
            boolean r9 = r8.isEmpty()     // Catch:{ MalformedURLException -> 0x0276 }
            r9 = r9 ^ r0
            com.google.android.gms.common.internal.Preconditions.checkArgument(r9)     // Catch:{ MalformedURLException -> 0x0276 }
            java.util.List<java.lang.Long> r9 = r14.zzarb     // Catch:{ MalformedURLException -> 0x0276 }
            if (r9 == 0) goto L_0x0218
            com.google.android.gms.internal.measurement.zzgm r8 = r14.zzacw     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfh r8 = r8.zzgf()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zzis()     // Catch:{ MalformedURLException -> 0x0276 }
            java.lang.String r9 = "Set uploading progress before finishing the previous upload"
            r8.log(r9)     // Catch:{ MalformedURLException -> 0x0276 }
            goto L_0x021f
        L_0x0218:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0276 }
            r9.<init>(r8)     // Catch:{ MalformedURLException -> 0x0276 }
            r14.zzarb = r9     // Catch:{ MalformedURLException -> 0x0276 }
        L_0x021f:
            com.google.android.gms.internal.measurement.zzgm r8 = r14.zzacw     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfs r8 = r8.zzgg()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfv r8 = r8.zzake     // Catch:{ MalformedURLException -> 0x0276 }
            r8.set(r2)     // Catch:{ MalformedURLException -> 0x0276 }
            java.lang.String r2 = "?"
            com.google.android.gms.internal.measurement.zzks[] r3 = r7.zzatr     // Catch:{ MalformedURLException -> 0x0276 }
            int r3 = r3.length     // Catch:{ MalformedURLException -> 0x0276 }
            if (r3 <= 0) goto L_0x0237
            com.google.android.gms.internal.measurement.zzks[] r2 = r7.zzatr     // Catch:{ MalformedURLException -> 0x0276 }
            r2 = r2[r1]     // Catch:{ MalformedURLException -> 0x0276 }
            java.lang.String r2 = r2.zzti     // Catch:{ MalformedURLException -> 0x0276 }
        L_0x0237:
            com.google.android.gms.internal.measurement.zzgm r3 = r14.zzacw     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfh r3 = r3.zzgf()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziz()     // Catch:{ MalformedURLException -> 0x0276 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r11.length     // Catch:{ MalformedURLException -> 0x0276 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x0276 }
            r3.zzd(r7, r2, r8, r6)     // Catch:{ MalformedURLException -> 0x0276 }
            r14.zzaqx = r0     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfl r8 = r14.zzkw()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzju r13 = new com.google.android.gms.internal.measurement.zzju     // Catch:{ MalformedURLException -> 0x0276 }
            r13.<init>(r14, r4)     // Catch:{ MalformedURLException -> 0x0276 }
            r8.zzab()     // Catch:{ MalformedURLException -> 0x0276 }
            r8.zzch()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzgh r0 = r8.zzge()     // Catch:{ MalformedURLException -> 0x0276 }
            com.google.android.gms.internal.measurement.zzfp r2 = new com.google.android.gms.internal.measurement.zzfp     // Catch:{ MalformedURLException -> 0x0276 }
            r12 = 0
            r7 = r2
            r9 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ MalformedURLException -> 0x0276 }
            r0.zzd((java.lang.Runnable) r2)     // Catch:{ MalformedURLException -> 0x0276 }
            goto L_0x002a
        L_0x0276:
            com.google.android.gms.internal.measurement.zzgm r0 = r14.zzacw     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfh r0 = r0.zzgf()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zzis()     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfh.zzbl(r4)     // Catch:{ all -> 0x02b1 }
            r0.zze(r2, r3, r5)     // Catch:{ all -> 0x02b1 }
            goto L_0x002a
        L_0x028b:
            r14.zzard = r7     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzej r0 = r14.zzje()     // Catch:{ all -> 0x02b1 }
            long r4 = com.google.android.gms.internal.measurement.zzeg.zzhm()     // Catch:{ all -> 0x02b1 }
            r6 = 0
            long r6 = r2 - r4
            java.lang.String r0 = r0.zzab(r6)     // Catch:{ all -> 0x02b1 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02b1 }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.measurement.zzej r2 = r14.zzje()     // Catch:{ all -> 0x02b1 }
            com.google.android.gms.internal.measurement.zzdy r0 = r2.zzbb(r0)     // Catch:{ all -> 0x02b1 }
            if (r0 == 0) goto L_0x002a
            r14.zzb((com.google.android.gms.internal.measurement.zzdy) r0)     // Catch:{ all -> 0x02b1 }
            goto L_0x002a
        L_0x02b1:
            r0 = move-exception
            r14.zzaqy = r1
            r14.zzle()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjs.zzlb():void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzlg() {
        zzfj zzis;
        String str;
        zzab();
        zzkz();
        if (!this.zzaqr) {
            this.zzacw.zzgf().zzix().log("This instance being marked as an uploader");
            zzab();
            zzkz();
            if (zzlh() && zzlf()) {
                int zza2 = zza(this.zzara);
                int zzip = this.zzacw.zzfw().zzip();
                zzab();
                if (zza2 > zzip) {
                    zzis = this.zzacw.zzgf().zzis();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza2 < zzip) {
                    if (zza(zzip, this.zzara)) {
                        zzis = this.zzacw.zzgf().zziz();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzis = this.zzacw.zzgf().zzis();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzis.zze(str, Integer.valueOf(zza2), Integer.valueOf(zzip));
            }
            this.zzaqr = true;
            zzld();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzli() {
        this.zzaqv++;
    }

    /* access modifiers changed from: package-private */
    public final zzgm zzlj() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        zzld();
    }
}
