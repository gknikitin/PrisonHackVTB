package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class zzfc extends zzhi {
    private String zzadm;
    private String zzadt;
    private long zzadx;
    private int zzaen;
    private int zzain;
    private long zzaio;
    private String zztg;
    private String zzth;
    private String zzti;

    zzfc(zzgm zzgm) {
        super(zzgm);
    }

    @WorkerThread
    private final String zzgl() {
        zzab();
        zzfs();
        if (zzgh().zzax(this.zzti) && !this.zzacw.isEnabled()) {
            return null;
        }
        try {
            return FirebaseInstanceId.getInstance().getId();
        } catch (IllegalStateException unused) {
            zzgf().zziv().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        zzch();
        return this.zzadm;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: package-private */
    public final String zzah() {
        zzch();
        return this.zzti;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzdz zzbh(String str) {
        zzab();
        zzfs();
        String zzah = zzah();
        String gmpAppId = getGmpAppId();
        zzch();
        String str2 = this.zzth;
        long zzip = (long) zzip();
        zzch();
        String str3 = this.zzadt;
        zzch();
        zzab();
        if (this.zzaio == 0) {
            this.zzaio = this.zzacw.zzgc().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzaio;
        boolean isEnabled = this.zzacw.isEnabled();
        boolean z = !zzgg().zzakw;
        String zzgl = zzgl();
        zzch();
        long j2 = this.zzadx;
        long zzkb = this.zzacw.zzkb();
        int zziq = zziq();
        zzeg zzgh = zzgh();
        zzgh.zzfs();
        Boolean zzar = zzgh.zzar("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(zzar == null || zzar.booleanValue()).booleanValue();
        zzeg zzgh2 = zzgh();
        zzgh2.zzfs();
        Boolean zzar2 = zzgh2.zzar("google_analytics_ssaid_collection_enabled");
        return new zzdz(zzah, gmpAppId, str2, zzip, str3, 12451, j, str, isEnabled, z, zzgl, j2, zzkb, zziq, booleanValue, Boolean.valueOf(zzar2 == null || zzar2.booleanValue()).booleanValue(), zzgg().zzjl());
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ void zzft() {
        super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzdu zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzhl zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzeq zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzij zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzig zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfd zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzff zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzkc zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzji zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzgh zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfh zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzfs zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzeg zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzec zzgi() {
        return super.zzgi();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014c A[SYNTHETIC, Splitter:B:55:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0191  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzin() {
        /*
            r10 = this;
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "Unknown"
            java.lang.String r2 = "Unknown"
            android.content.Context r3 = r10.getContext()
            java.lang.String r3 = r3.getPackageName()
            android.content.Context r4 = r10.getContext()
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzfh r4 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zzis()
            java.lang.String r7 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)
            r4.zzg(r7, r8)
            goto L_0x008b
        L_0x002d:
            java.lang.String r7 = r4.getInstallerPackageName(r3)     // Catch:{ IllegalArgumentException -> 0x0033 }
            r0 = r7
            goto L_0x0044
        L_0x0033:
            com.google.android.gms.internal.measurement.zzfh r7 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zzis()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)
            r7.zzg(r8, r9)
        L_0x0044:
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "manual_install"
            goto L_0x0053
        L_0x0049:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            java.lang.String r0 = ""
        L_0x0053:
            android.content.Context r7 = r10.getContext()     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x007a }
            android.content.pm.PackageInfo r7 = r4.getPackageInfo(r7, r5)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r7 == 0) goto L_0x008b
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.CharSequence r4 = r4.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r8 != 0) goto L_0x0072
            java.lang.String r4 = r4.toString()     // Catch:{ NameNotFoundException -> 0x007a }
            r2 = r4
        L_0x0072:
            java.lang.String r4 = r7.versionName     // Catch:{ NameNotFoundException -> 0x007a }
            int r1 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0079 }
            r6 = r1
            r1 = r4
            goto L_0x008b
        L_0x0079:
            r1 = r4
        L_0x007a:
            com.google.android.gms.internal.measurement.zzfh r4 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zzis()
            java.lang.String r7 = "Error retrieving package info. appId, appName"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)
            r4.zze(r7, r8, r2)
        L_0x008b:
            r10.zzti = r3
            r10.zzadt = r0
            r10.zzth = r1
            r10.zzain = r6
            r10.zztg = r2
            r0 = 0
            r10.zzaio = r0
            r10.zzgi()
            android.content.Context r2 = r10.getContext()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r4 = 1
            if (r2 == 0) goto L_0x00af
            boolean r6 = r2.isSuccess()
            if (r6 == 0) goto L_0x00af
            r6 = 1
            goto L_0x00b0
        L_0x00af:
            r6 = 0
        L_0x00b0:
            if (r6 != 0) goto L_0x00db
            if (r2 != 0) goto L_0x00c2
            com.google.android.gms.internal.measurement.zzfh r2 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()
            java.lang.String r7 = "GoogleService failed to initialize (no status)"
            r2.log(r7)
            goto L_0x00db
        L_0x00c2:
            com.google.android.gms.internal.measurement.zzfh r7 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zzis()
            java.lang.String r8 = "GoogleService failed to initialize, status"
            int r9 = r2.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.getStatusMessage()
            r7.zze(r8, r9, r2)
        L_0x00db:
            if (r6 == 0) goto L_0x0131
            com.google.android.gms.internal.measurement.zzeg r2 = r10.zzgh()
            java.lang.Boolean r2 = r2.zzhk()
            com.google.android.gms.internal.measurement.zzeg r6 = r10.zzgh()
            boolean r6 = r6.zzhj()
            if (r6 == 0) goto L_0x00fd
            com.google.android.gms.internal.measurement.zzfh r2 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzix()
            java.lang.String r4 = "Collection disabled with firebase_analytics_collection_deactivated=1"
        L_0x00f9:
            r2.log(r4)
            goto L_0x0131
        L_0x00fd:
            if (r2 == 0) goto L_0x0110
            boolean r6 = r2.booleanValue()
            if (r6 != 0) goto L_0x0110
            com.google.android.gms.internal.measurement.zzfh r2 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzix()
            java.lang.String r4 = "Collection disabled with firebase_analytics_collection_enabled=0"
            goto L_0x00f9
        L_0x0110:
            if (r2 != 0) goto L_0x0123
            boolean r2 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled()
            if (r2 == 0) goto L_0x0123
            com.google.android.gms.internal.measurement.zzfh r2 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzix()
            java.lang.String r4 = "Collection disabled with google_app_measurement_enable=0"
            goto L_0x00f9
        L_0x0123:
            com.google.android.gms.internal.measurement.zzfh r2 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()
            java.lang.String r6 = "Collection enabled"
            r2.log(r6)
            goto L_0x0132
        L_0x0131:
            r4 = 0
        L_0x0132:
            java.lang.String r2 = ""
            r10.zzadm = r2
            r10.zzadx = r0
            r10.zzgi()
            com.google.android.gms.internal.measurement.zzgm r0 = r10.zzacw
            java.lang.String r0 = r0.zzka()
            if (r0 == 0) goto L_0x014c
            com.google.android.gms.internal.measurement.zzgm r0 = r10.zzacw
            java.lang.String r0 = r0.zzka()
            r10.zzadm = r0
            goto L_0x0180
        L_0x014c:
            java.lang.String r0 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x016e }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x016e }
            if (r1 == 0) goto L_0x0158
            java.lang.String r0 = ""
        L_0x0158:
            r10.zzadm = r0     // Catch:{ IllegalStateException -> 0x016e }
            if (r4 == 0) goto L_0x0180
            com.google.android.gms.internal.measurement.zzfh r0 = r10.zzgf()     // Catch:{ IllegalStateException -> 0x016e }
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()     // Catch:{ IllegalStateException -> 0x016e }
            java.lang.String r1 = "App package, google app id"
            java.lang.String r2 = r10.zzti     // Catch:{ IllegalStateException -> 0x016e }
            java.lang.String r4 = r10.zzadm     // Catch:{ IllegalStateException -> 0x016e }
            r0.zze(r1, r2, r4)     // Catch:{ IllegalStateException -> 0x016e }
            goto L_0x0180
        L_0x016e:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfh r1 = r10.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zzis()
            java.lang.String r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfh.zzbl(r3)
            r1.zze(r2, r3, r0)
        L_0x0180:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x0191
            android.content.Context r0 = r10.getContext()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r10.zzaen = r0
            return
        L_0x0191:
            r10.zzaen = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zzin():void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzio() {
        byte[] bArr = new byte[16];
        zzgc().zzll().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final int zzip() {
        zzch();
        return this.zzain;
    }

    /* access modifiers changed from: package-private */
    public final int zziq() {
        zzch();
        return this.zzaen;
    }
}
