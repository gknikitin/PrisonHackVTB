package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zza {
    private static zza zzdh;
    private Bundle zzdi;
    private Method zzdj;
    private Method zzdk;
    private final AtomicInteger zzdl = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context zzz;

    private zza(Context context) {
        this.zzz = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification zza(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Notification.Builder smallIcon = new Notification.Builder(this.zzz).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.zzdj == null) {
                this.zzdj = zzl("setChannelId");
            }
            if (this.zzdj == null) {
                this.zzdj = zzl("setChannel");
            }
            if (this.zzdj == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    this.zzdj.invoke(smallIcon, new Object[]{str2});
                } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                }
            }
        }
        return smallIcon.build();
    }

    static String zza(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static void zza(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private final Bundle zzal() {
        if (this.zzdi != null) {
            return this.zzdi;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.zzz.getPackageManager().getApplicationInfo(this.zzz.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.zzdi = applicationInfo.metaData;
        return this.zzdi;
    }

    static String zzb(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return zza(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    @TargetApi(26)
    private final boolean zzb(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.zzz.getResources().getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    static Object[] zzc(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String zza = zza(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zza);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return objArr;
        } catch (JSONException unused) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_args");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(zza).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(zza);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    static synchronized zza zzd(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzdh == null) {
                zzdh = new zza(context);
            }
            zza = zzdh;
        }
        return zza;
    }

    private final String zzd(Bundle bundle, String str) {
        String zza = zza(bundle, str);
        if (!TextUtils.isEmpty(zza)) {
            return zza;
        }
        String zzb = zzb(bundle, str);
        if (TextUtils.isEmpty(zzb)) {
            return null;
        }
        Resources resources = this.zzz.getResources();
        int identifier = resources.getIdentifier(zzb, "string", this.zzz.getPackageName());
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            String substring = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzb).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(zzb);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] zzc = zzc(bundle, str);
        if (zzc == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzc);
        } catch (MissingFormatArgumentException e) {
            String arrays = Arrays.toString(zzc);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzb).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(zzb);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e);
            return null;
        }
    }

    static boolean zzf(Bundle bundle) {
        return "1".equals(zza(bundle, "gcm.n.e")) || zza(bundle, "gcm.n.icon") != null;
    }

    @Nullable
    static Uri zzg(@NonNull Bundle bundle) {
        String zza = zza(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(zza)) {
            zza = zza(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(zza)) {
            return Uri.parse(zza);
        }
        return null;
    }

    static String zzi(Bundle bundle) {
        String zza = zza(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zza) ? zza(bundle, "gcm.n.sound") : zza;
    }

    @TargetApi(26)
    private static Method zzl(String str) {
        try {
            return Notification.Builder.class.getMethod(str, new Class[]{String.class});
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private final Integer zzm(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = zzal().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(this.zzz, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    @TargetApi(26)
    private final String zzn(String str) {
        String str2;
        String str3;
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.zzz.getSystemService(NotificationManager.class);
        try {
            if (this.zzdk == null) {
                this.zzdk = notificationManager.getClass().getMethod("getNotificationChannel", new Class[]{String.class});
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.zzdk.invoke(notificationManager, new Object[]{str}) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = zzal().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(string)) {
                if (this.zzdk.invoke(notificationManager, new Object[]{string}) != null) {
                    return string;
                }
                str2 = "FirebaseMessaging";
                str3 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            } else {
                str2 = "FirebaseMessaging";
                str3 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            }
            Log.w(str2, str3);
            if (this.zzdk.invoke(notificationManager, new Object[]{"fcm_fallback_notification_channel"}) != null) {
                return "fcm_fallback_notification_channel";
            }
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Object newInstance = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{"fcm_fallback_notification_channel", this.zzz.getString(C0603R.string.fcm_fallback_notification_channel_label), 3});
            notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{cls}).invoke(notificationManager, new Object[]{newInstance});
            return "fcm_fallback_notification_channel";
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0275  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzh(android.os.Bundle r14) {
        /*
            r13 = this;
            java.lang.String r0 = "1"
            java.lang.String r1 = "gcm.n.noui"
            java.lang.String r1 = zza((android.os.Bundle) r14, (java.lang.String) r1)
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            android.content.Context r0 = r13.zzz
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 != 0) goto L_0x005c
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()
            if (r0 != 0) goto L_0x002c
            r3 = 10
            android.os.SystemClock.sleep(r3)
        L_0x002c:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r13.zzz
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L_0x005c
            java.util.Iterator r3 = r3.iterator()
        L_0x0044:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005c
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L_0x0044
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L_0x005c
            r0 = 1
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            if (r0 == 0) goto L_0x0060
            return r2
        L_0x0060:
            java.lang.String r0 = "gcm.n.title"
            java.lang.String r0 = r13.zzd(r14, r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x007c
            android.content.Context r0 = r13.zzz
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            android.content.Context r3 = r13.zzz
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            java.lang.CharSequence r0 = r0.loadLabel(r3)
        L_0x007c:
            r4 = r0
            java.lang.String r0 = "gcm.n.body"
            java.lang.String r5 = r13.zzd(r14, r0)
            java.lang.String r0 = "gcm.n.icon"
            java.lang.String r0 = zza((android.os.Bundle) r14, (java.lang.String) r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x00e5
            android.content.Context r3 = r13.zzz
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r6 = "drawable"
            android.content.Context r7 = r13.zzz
            java.lang.String r7 = r7.getPackageName()
            int r6 = r3.getIdentifier(r0, r6, r7)
            if (r6 == 0) goto L_0x00aa
            boolean r7 = r13.zzb(r6)
            if (r7 == 0) goto L_0x00aa
            goto L_0x010b
        L_0x00aa:
            java.lang.String r6 = "mipmap"
            android.content.Context r7 = r13.zzz
            java.lang.String r7 = r7.getPackageName()
            int r3 = r3.getIdentifier(r0, r6, r7)
            if (r3 == 0) goto L_0x00c0
            boolean r6 = r13.zzb(r3)
            if (r6 == 0) goto L_0x00c0
            r6 = r3
            goto L_0x010b
        L_0x00c0:
            java.lang.String r3 = "FirebaseMessaging"
            java.lang.String r6 = java.lang.String.valueOf(r0)
            int r6 = r6.length()
            int r6 = r6 + 61
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Icon resource "
            r7.append(r6)
            r7.append(r0)
            java.lang.String r0 = " not found. Notification will use default icon."
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            android.util.Log.w(r3, r0)
        L_0x00e5:
            android.os.Bundle r0 = r13.zzal()
            java.lang.String r3 = "com.google.firebase.messaging.default_notification_icon"
            int r0 = r0.getInt(r3, r2)
            if (r0 == 0) goto L_0x00f7
            boolean r3 = r13.zzb(r0)
            if (r3 != 0) goto L_0x00ff
        L_0x00f7:
            android.content.Context r0 = r13.zzz
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.icon
        L_0x00ff:
            if (r0 == 0) goto L_0x0107
            boolean r3 = r13.zzb(r0)
            if (r3 != 0) goto L_0x010a
        L_0x0107:
            r0 = 17301651(0x1080093, float:2.4979667E-38)
        L_0x010a:
            r6 = r0
        L_0x010b:
            java.lang.String r0 = "gcm.n.color"
            java.lang.String r0 = zza((android.os.Bundle) r14, (java.lang.String) r0)
            java.lang.Integer r7 = r13.zzm(r0)
            java.lang.String r0 = zzi(r14)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r8 = 0
            if (r3 == 0) goto L_0x0122
            r0 = r8
            goto L_0x017a
        L_0x0122:
            java.lang.String r3 = "default"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0175
            android.content.Context r3 = r13.zzz
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r9 = "raw"
            android.content.Context r10 = r13.zzz
            java.lang.String r10 = r10.getPackageName()
            int r3 = r3.getIdentifier(r0, r9, r10)
            if (r3 == 0) goto L_0x0175
            android.content.Context r3 = r13.zzz
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r9 = java.lang.String.valueOf(r3)
            int r9 = r9.length()
            int r9 = r9 + 24
            java.lang.String r10 = java.lang.String.valueOf(r0)
            int r10 = r10.length()
            int r9 = r9 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            java.lang.String r9 = "android.resource://"
            r10.append(r9)
            r10.append(r3)
            java.lang.String r3 = "/raw/"
            r10.append(r3)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x017a
        L_0x0175:
            r0 = 2
            android.net.Uri r0 = android.media.RingtoneManager.getDefaultUri(r0)
        L_0x017a:
            java.lang.String r3 = "gcm.n.click_action"
            java.lang.String r3 = zza((android.os.Bundle) r14, (java.lang.String) r3)
            boolean r9 = android.text.TextUtils.isEmpty(r3)
            if (r9 != 0) goto L_0x019a
            android.content.Intent r9 = new android.content.Intent
            r9.<init>(r3)
            android.content.Context r3 = r13.zzz
            java.lang.String r3 = r3.getPackageName()
            r9.setPackage(r3)
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r9.setFlags(r3)
            goto L_0x01cd
        L_0x019a:
            android.net.Uri r3 = zzg(r14)
            if (r3 == 0) goto L_0x01b4
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r10 = "android.intent.action.VIEW"
            r9.<init>(r10)
            android.content.Context r10 = r13.zzz
            java.lang.String r10 = r10.getPackageName()
            r9.setPackage(r10)
            r9.setData(r3)
            goto L_0x01cd
        L_0x01b4:
            android.content.Context r3 = r13.zzz
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            android.content.Context r9 = r13.zzz
            java.lang.String r9 = r9.getPackageName()
            android.content.Intent r9 = r3.getLaunchIntentForPackage(r9)
            if (r9 != 0) goto L_0x01cd
            java.lang.String r3 = "FirebaseMessaging"
            java.lang.String r10 = "No activity found to launch app"
            android.util.Log.w(r3, r10)
        L_0x01cd:
            r3 = 1073741824(0x40000000, float:2.0)
            if (r9 != 0) goto L_0x01d3
            r9 = r8
            goto L_0x0217
        L_0x01d3:
            r10 = 67108864(0x4000000, float:1.5046328E-36)
            r9.addFlags(r10)
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>(r14)
            com.google.firebase.messaging.FirebaseMessagingService.zzj(r10)
            r9.putExtras(r10)
            java.util.Set r10 = r10.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x01eb:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x020b
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "gcm.n."
            boolean r12 = r11.startsWith(r12)
            if (r12 != 0) goto L_0x0207
            java.lang.String r12 = "gcm.notification."
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x01eb
        L_0x0207:
            r9.removeExtra(r11)
            goto L_0x01eb
        L_0x020b:
            android.content.Context r10 = r13.zzz
            java.util.concurrent.atomic.AtomicInteger r11 = r13.zzdl
            int r11 = r11.incrementAndGet()
            android.app.PendingIntent r9 = android.app.PendingIntent.getActivity(r10, r11, r9, r3)
        L_0x0217:
            boolean r10 = com.google.firebase.messaging.FirebaseMessagingService.zzk(r14)
            if (r10 == 0) goto L_0x0251
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r10 = "com.google.firebase.messaging.NOTIFICATION_OPEN"
            r8.<init>(r10)
            zza((android.content.Intent) r8, (android.os.Bundle) r14)
            java.lang.String r10 = "pending_intent"
            r8.putExtra(r10, r9)
            android.content.Context r9 = r13.zzz
            java.util.concurrent.atomic.AtomicInteger r10 = r13.zzdl
            int r10 = r10.incrementAndGet()
            android.app.PendingIntent r8 = com.google.firebase.iid.zzap.zza(r9, r10, r8, r3)
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r10 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r9.<init>(r10)
            zza((android.content.Intent) r9, (android.os.Bundle) r14)
            android.content.Context r10 = r13.zzz
            java.util.concurrent.atomic.AtomicInteger r11 = r13.zzdl
            int r11 = r11.incrementAndGet()
            android.app.PendingIntent r3 = com.google.firebase.iid.zzap.zza(r10, r11, r9, r3)
            r10 = r3
            r9 = r8
            goto L_0x0252
        L_0x0251:
            r10 = r8
        L_0x0252:
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()
            if (r3 == 0) goto L_0x0275
            android.content.Context r3 = r13.zzz
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            r8 = 25
            if (r3 <= r8) goto L_0x0275
            java.lang.String r3 = "gcm.n.android_channel_id"
            java.lang.String r3 = zza((android.os.Bundle) r14, (java.lang.String) r3)
            java.lang.String r11 = r13.zzn(r3)
            r3 = r13
            r8 = r0
            android.app.Notification r0 = r3.zza(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x02be
        L_0x0275:
            android.support.v4.app.NotificationCompat$Builder r3 = new android.support.v4.app.NotificationCompat$Builder
            android.content.Context r8 = r13.zzz
            r3.<init>(r8)
            android.support.v4.app.NotificationCompat$Builder r3 = r3.setAutoCancel(r1)
            android.support.v4.app.NotificationCompat$Builder r3 = r3.setSmallIcon(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x028d
            r3.setContentTitle(r4)
        L_0x028d:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L_0x02a2
            r3.setContentText(r5)
            android.support.v4.app.NotificationCompat$BigTextStyle r4 = new android.support.v4.app.NotificationCompat$BigTextStyle
            r4.<init>()
            android.support.v4.app.NotificationCompat$BigTextStyle r4 = r4.bigText(r5)
            r3.setStyle(r4)
        L_0x02a2:
            if (r7 == 0) goto L_0x02ab
            int r4 = r7.intValue()
            r3.setColor(r4)
        L_0x02ab:
            if (r0 == 0) goto L_0x02b0
            r3.setSound(r0)
        L_0x02b0:
            if (r9 == 0) goto L_0x02b5
            r3.setContentIntent(r9)
        L_0x02b5:
            if (r10 == 0) goto L_0x02ba
            r3.setDeleteIntent(r10)
        L_0x02ba:
            android.app.Notification r0 = r3.build()
        L_0x02be:
            java.lang.String r3 = "gcm.n.tag"
            java.lang.String r14 = zza((android.os.Bundle) r14, (java.lang.String) r3)
            java.lang.String r3 = "FirebaseMessaging"
            r4 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r4)
            if (r3 == 0) goto L_0x02d4
            java.lang.String r3 = "FirebaseMessaging"
            java.lang.String r4 = "Showing notification"
            android.util.Log.d(r3, r4)
        L_0x02d4:
            android.content.Context r3 = r13.zzz
            java.lang.String r4 = "notification"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3
            boolean r4 = android.text.TextUtils.isEmpty(r14)
            if (r4 == 0) goto L_0x02fb
            long r4 = android.os.SystemClock.uptimeMillis()
            r14 = 37
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r14)
            java.lang.String r14 = "FCM-Notification:"
            r6.append(r14)
            r6.append(r4)
            java.lang.String r14 = r6.toString()
        L_0x02fb:
            r3.notify(r14, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.zzh(android.os.Bundle):boolean");
    }
}
