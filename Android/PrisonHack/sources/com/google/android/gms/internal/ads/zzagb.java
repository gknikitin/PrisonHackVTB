package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

public final class zzagb {
    private float zzagu;
    private int zzcde;
    private int zzcdf;
    private int zzcjk;
    private boolean zzcjl;
    private boolean zzcjm;
    private String zzcjn;
    private String zzcjo;
    private boolean zzcjp;
    private boolean zzcjq;
    private boolean zzcjr;
    private boolean zzcjs;
    private String zzcjt;
    private String zzcju;
    private String zzcjv;
    private int zzcjw;
    private int zzcjx;
    private int zzcjy;
    private int zzcjz;
    private int zzcka;
    private int zzckb;
    private double zzckc;
    private boolean zzckd;
    private boolean zzcke;
    private int zzckf;
    private String zzckg;
    private String zzckh;
    private boolean zzcki;

    public zzagb(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzn(context);
        zzo(context);
        zzp(context);
        Locale locale = Locale.getDefault();
        boolean z = false;
        this.zzcjl = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzcjm = zza(packageManager, "http://www.google.com") != null ? true : z;
        this.zzcjo = locale.getCountry();
        zzkb.zzif();
        this.zzcjp = zzamu.zzsg();
        this.zzcjq = DeviceProperties.isSidewinder(context);
        this.zzcjt = locale.getLanguage();
        this.zzcju = zzb(context, packageManager);
        this.zzcjv = zza(context, packageManager);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzagu = displayMetrics.density;
            this.zzcde = displayMetrics.widthPixels;
            this.zzcdf = displayMetrics.heightPixels;
        }
    }

    public zzagb(Context context, zzaga zzaga) {
        context.getPackageManager();
        zzn(context);
        zzo(context);
        zzp(context);
        this.zzckg = Build.FINGERPRINT;
        this.zzckh = Build.DEVICE;
        this.zzcki = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzoh.zzh(context);
        this.zzcjl = zzaga.zzcjl;
        this.zzcjm = zzaga.zzcjm;
        this.zzcjo = zzaga.zzcjo;
        this.zzcjp = zzaga.zzcjp;
        this.zzcjq = zzaga.zzcjq;
        this.zzcjt = zzaga.zzcjt;
        this.zzcju = zzaga.zzcju;
        this.zzcjv = zzaga.zzcjv;
        this.zzagu = zzaga.zzagu;
        this.zzcde = zzaga.zzcde;
        this.zzcdf = zzaga.zzcdf;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzbv.zzeo().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String zzb(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final void zzn(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzcjk = audioManager.getMode();
                this.zzcjr = audioManager.isMusicActive();
                this.zzcjs = audioManager.isSpeakerphoneOn();
                this.zzcjw = audioManager.getStreamVolume(3);
                this.zzcka = audioManager.getRingerMode();
                this.zzckb = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzbv.zzeo().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzcjk = -2;
        this.zzcjr = false;
        this.zzcjs = false;
        this.zzcjw = 0;
        this.zzcka = 0;
        this.zzckb = 0;
    }

    @TargetApi(16)
    private final void zzo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzcjn = telephonyManager.getNetworkOperator();
        this.zzcjy = telephonyManager.getNetworkType();
        this.zzcjz = telephonyManager.getPhoneType();
        this.zzcjx = -2;
        this.zzcke = false;
        this.zzckf = -1;
        zzbv.zzek();
        if (zzakk.zzl(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzcjx = activeNetworkInfo.getType();
                this.zzckf = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzcjx = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzcke = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzp(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            this.zzckc = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzckd = z;
            return;
        }
        this.zzckc = -1.0d;
        this.zzckd = false;
    }

    public final zzaga zzoo() {
        int i = this.zzcjk;
        boolean z = this.zzcjl;
        boolean z2 = this.zzcjm;
        String str = this.zzcjn;
        String str2 = this.zzcjo;
        boolean z3 = this.zzcjp;
        boolean z4 = this.zzcjq;
        boolean z5 = this.zzcjr;
        boolean z6 = this.zzcjs;
        String str3 = this.zzcjt;
        String str4 = this.zzcju;
        String str5 = this.zzcjv;
        int i2 = this.zzcjw;
        int i3 = this.zzcjx;
        int i4 = this.zzcjy;
        int i5 = i3;
        int i6 = this.zzcjz;
        int i7 = this.zzcka;
        int i8 = this.zzckb;
        float f = this.zzagu;
        int i9 = this.zzcde;
        int i10 = i2;
        int i11 = this.zzcdf;
        double d = this.zzckc;
        boolean z7 = this.zzckd;
        boolean z8 = this.zzcke;
        boolean z9 = z7;
        boolean z10 = z8;
        return new zzaga(i, z, z2, str, str2, z3, z4, z5, z6, str3, str4, str5, i10, i5, i4, i6, i7, i8, f, i9, i11, d, z9, z10, this.zzckf, this.zzckg, this.zzcki, this.zzckh);
    }
}
