package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzkc extends zzhi {
    private static final String[] zzarp = {"firebase_", "google_", "ga_"};
    private SecureRandom zzarq;
    private final AtomicLong zzarr = new AtomicLong(0);
    private int zzars;
    private Integer zzart = null;

    zzkc(zzgm zzgm) {
        super(zzgm);
    }

    static MessageDigest getMessageDigest(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzs(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void zza(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    public static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzc(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    private static boolean zza(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzgf().zziv().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
            return true;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            if ((obj instanceof Parcelable[]) && z) {
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (!(parcelable instanceof Bundle)) {
                        zzgf().zziv().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzgf().zziv().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            i += 8;
            length--;
            j += (((long) bArr[length]) & 255) << i;
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r3 = r1.getServiceInfo(new android.content.ComponentName(r3, r4), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0019 }
            r2.<init>(r3, r4)     // Catch:{ NameNotFoundException -> 0x0019 }
            android.content.pm.ServiceInfo r3 = r1.getServiceInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.enabled     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            r3 = 1
            return r3
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkc.zzc(android.content.Context, java.lang.String):boolean");
    }

    static boolean zzcb(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private static int zzcg(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        return "_id".equals(str) ? 256 : 36;
    }

    public static boolean zzch(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzcj(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A[RETURN] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzck(java.lang.String r4) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            int r0 = r4.hashCode()
            r1 = 94660(0x171c4, float:1.32647E-40)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x002d
            r1 = 95025(0x17331, float:1.33158E-40)
            if (r0 == r1) goto L_0x0023
            r1 = 95027(0x17333, float:1.33161E-40)
            if (r0 == r1) goto L_0x0019
            goto L_0x0037
        L_0x0019:
            java.lang.String r0 = "_ui"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0037
            r4 = 1
            goto L_0x0038
        L_0x0023:
            java.lang.String r0 = "_ug"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0037
            r4 = 2
            goto L_0x0038
        L_0x002d:
            java.lang.String r0 = "_in"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0037
            r4 = 0
            goto L_0x0038
        L_0x0037:
            r4 = -1
        L_0x0038:
            switch(r4) {
                case 0: goto L_0x003c;
                case 1: goto L_0x003c;
                case 2: goto L_0x003c;
                default: goto L_0x003b;
            }
        L_0x003b:
            return r2
        L_0x003c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkc.zzck(java.lang.String):boolean");
    }

    public static boolean zzd(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        zzfj zzfj;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            e = e;
            zzfj = zzgf().zzis();
            str2 = "Error obtaining certificate";
            zzfj.zzg(str2, e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            zzfj = zzgf().zzis();
            str2 = "Package name not found";
            zzfj.zzg(str2, e);
            return true;
        }
    }

    public static Bundle[] zze(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ IOException | ClassNotFoundException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[Catch:{ IOException | ClassNotFoundException -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zzf(java.lang.Object r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0032 }
            r2.<init>(r1)     // Catch:{ all -> 0x0032 }
            r2.writeObject(r4)     // Catch:{ all -> 0x002f }
            r2.flush()     // Catch:{ all -> 0x002f }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ all -> 0x002f }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002f }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x002f }
            r3.<init>(r1)     // Catch:{ all -> 0x002f }
            r4.<init>(r3)     // Catch:{ all -> 0x002f }
            java.lang.Object r1 = r4.readObject()     // Catch:{ all -> 0x002d }
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0040 }
            r4.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0040 }
            return r1
        L_0x002d:
            r1 = move-exception
            goto L_0x0035
        L_0x002f:
            r1 = move-exception
            r4 = r0
            goto L_0x0035
        L_0x0032:
            r1 = move-exception
            r4 = r0
            r2 = r4
        L_0x0035:
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0040 }
        L_0x003a:
            if (r4 == 0) goto L_0x003f
            r4.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0040 }
        L_0x003f:
            throw r1     // Catch:{ IOException | ClassNotFoundException -> 0x0040 }
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkc.zzf(java.lang.Object):java.lang.Object");
    }

    private final boolean zzr(String str, String str2) {
        if (str2 == null) {
            zzgf().zzis().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgf().zzis().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzgf().zzis().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzgf().zzis().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzs(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzgf().zziv().zzg("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zza("event param", 40, r14) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (zza("event param", 40, r14) == false) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r18, android.os.Bundle r19, @android.support.annotation.Nullable java.util.List<java.lang.String> r20, boolean r21, boolean r22) {
        /*
            r17 = this;
            r6 = r17
            r7 = r19
            r8 = r20
            r9 = 0
            if (r7 == 0) goto L_0x016c
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>(r7)
            java.util.Set r0 = r19.keySet()
            java.util.Iterator r11 = r0.iterator()
            r12 = 0
            r13 = 0
        L_0x0018:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x016d
            java.lang.Object r0 = r11.next()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            r15 = 40
            r0 = 3
            if (r8 == 0) goto L_0x0033
            boolean r1 = r8.contains(r14)
            if (r1 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r1 = 0
            goto L_0x0075
        L_0x0033:
            r1 = 14
            if (r21 == 0) goto L_0x0055
            java.lang.String r2 = "event param"
            boolean r2 = r6.zzq(r2, r14)
            if (r2 != 0) goto L_0x0041
        L_0x003f:
            r2 = 3
            goto L_0x0056
        L_0x0041:
            java.lang.String r2 = "event param"
            boolean r2 = r6.zza((java.lang.String) r2, (java.lang.String[]) r9, (java.lang.String) r14)
            if (r2 != 0) goto L_0x004c
            r2 = 14
            goto L_0x0056
        L_0x004c:
            java.lang.String r2 = "event param"
            boolean r2 = r6.zza((java.lang.String) r2, (int) r15, (java.lang.String) r14)
            if (r2 != 0) goto L_0x0055
            goto L_0x003f
        L_0x0055:
            r2 = 0
        L_0x0056:
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = "event param"
            boolean r2 = r6.zzr(r2, r14)
            if (r2 != 0) goto L_0x0062
        L_0x0060:
            r1 = 3
            goto L_0x0075
        L_0x0062:
            java.lang.String r2 = "event param"
            boolean r2 = r6.zza((java.lang.String) r2, (java.lang.String[]) r9, (java.lang.String) r14)
            if (r2 != 0) goto L_0x006b
            goto L_0x0075
        L_0x006b:
            java.lang.String r1 = "event param"
            boolean r1 = r6.zza((java.lang.String) r1, (int) r15, (java.lang.String) r14)
            if (r1 != 0) goto L_0x0031
            goto L_0x0060
        L_0x0074:
            r1 = r2
        L_0x0075:
            r5 = 1
            if (r1 == 0) goto L_0x008e
            boolean r2 = zza((android.os.Bundle) r10, (int) r1)
            if (r2 == 0) goto L_0x0165
            java.lang.String r2 = zza((java.lang.String) r14, (int) r15, (boolean) r5)
            java.lang.String r3 = "_ev"
            r10.putString(r3, r2)
            if (r1 != r0) goto L_0x0165
            zza((android.os.Bundle) r10, (java.lang.Object) r14)
            goto L_0x0165
        L_0x008e:
            java.lang.Object r4 = r7.get(r14)
            r17.zzab()
            if (r22 == 0) goto L_0x00cb
            java.lang.String r0 = "param"
            boolean r1 = r4 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x00a2
            r1 = r4
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1
            int r1 = r1.length
            goto L_0x00ad
        L_0x00a2:
            boolean r1 = r4 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x00c4
            r1 = r4
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r1 = r1.size()
        L_0x00ad:
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 <= r2) goto L_0x00c4
            com.google.android.gms.internal.measurement.zzfh r2 = r17.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Parameter array is too long; discarded. Value kind, name, array length"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.zzd(r3, r0, r14, r1)
            r0 = 0
            goto L_0x00c5
        L_0x00c4:
            r0 = 1
        L_0x00c5:
            if (r0 != 0) goto L_0x00cb
            r0 = 17
            r9 = 1
            goto L_0x0104
        L_0x00cb:
            com.google.android.gms.internal.measurement.zzeg r0 = r17.zzgh()
            com.google.android.gms.internal.measurement.zzfc r1 = r17.zzfw()
            java.lang.String r1 = r1.zzah()
            boolean r0 = r0.zzav(r1)
            if (r0 == 0) goto L_0x00e3
            boolean r0 = zzch(r18)
            if (r0 != 0) goto L_0x00e9
        L_0x00e3:
            boolean r0 = zzch(r14)
            if (r0 == 0) goto L_0x00f7
        L_0x00e9:
            java.lang.String r1 = "param"
            r3 = 256(0x100, float:3.59E-43)
            r0 = r6
            r2 = r14
            r9 = 1
        L_0x00f0:
            r5 = r22
            boolean r0 = r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r4, (boolean) r5)
            goto L_0x00ff
        L_0x00f7:
            r9 = 1
            java.lang.String r1 = "param"
            r3 = 100
            r0 = r6
            r2 = r14
            goto L_0x00f0
        L_0x00ff:
            if (r0 == 0) goto L_0x0103
            r0 = 0
            goto L_0x0104
        L_0x0103:
            r0 = 4
        L_0x0104:
            if (r0 == 0) goto L_0x0128
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x0128
            boolean r0 = zza((android.os.Bundle) r10, (int) r0)
            if (r0 == 0) goto L_0x0165
            java.lang.String r0 = zza((java.lang.String) r14, (int) r15, (boolean) r9)
            java.lang.String r1 = "_ev"
            r10.putString(r1, r0)
            java.lang.Object r0 = r7.get(r14)
            zza((android.os.Bundle) r10, (java.lang.Object) r0)
            goto L_0x0165
        L_0x0125:
            r9 = 0
            goto L_0x0018
        L_0x0128:
            boolean r0 = zzcb(r14)
            if (r0 == 0) goto L_0x0169
            int r13 = r13 + 1
            r0 = 25
            if (r13 <= r0) goto L_0x0169
            r0 = 48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Event can't contain more than 25 params"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.measurement.zzfh r1 = r17.zzgf()
            com.google.android.gms.internal.measurement.zzfj r1 = r1.zzis()
            com.google.android.gms.internal.measurement.zzff r2 = r17.zzgb()
            r3 = r18
            java.lang.String r2 = r2.zzbi(r3)
            com.google.android.gms.internal.measurement.zzff r4 = r17.zzgb()
            java.lang.String r4 = r4.zzb((android.os.Bundle) r7)
            r1.zze(r0, r2, r4)
            r0 = 5
            zza((android.os.Bundle) r10, (int) r0)
        L_0x0165:
            r10.remove(r14)
            goto L_0x0125
        L_0x0169:
            r3 = r18
            goto L_0x0125
        L_0x016c:
            r10 = 0
        L_0x016d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkc.zza(java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzgf().zzis().log("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.internal.measurement.zzfh r5 = r4.zzgf()     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.log(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkc.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final zzew zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzcc(str) != 0) {
            zzgf().zzis().zzg("Invalid conditional property event name", zzgb().zzbk(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        String str3 = str;
        return new zzew(str3, new zzet(zzd(zza(str3, bundle2, (List<String>) CollectionUtils.listOf("_o"), false, false))), str2, j);
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzgf().zziw().zze("Not putting event parameter. Invalid value type. name, type", zzgb().zzbj(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzacw.zzgi();
        this.zzacw.zzfv().logEvent("auto", "_err", bundle);
    }

    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzbt().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzgf().zzis().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzgf().zzis().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzgf().zzis().zzg("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        int i = 0;
        while (true) {
            if (i >= zzarp.length) {
                z = false;
                break;
            } else if (str2.startsWith(zzarp[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzgf().zzis().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z2 = false;
                    break;
                } else if (zzs(str2, strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                zzgf().zzis().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final byte[] zza(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzgf().zzis().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzgf().zzis().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final int zzcc(String str) {
        if (!zzr(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zza(NotificationCompat.CATEGORY_EVENT, AppMeasurement.Event.zzacx, str)) {
            return 13;
        }
        return !zza(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    public final int zzcd(String str) {
        if (!zzq("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            return 15;
        }
        return !zza("user property", 24, str) ? 6 : 0;
    }

    public final int zzce(String str) {
        if (!zzr("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            return 15;
        }
        return !zza("user property", 24, str) ? 6 : 0;
    }

    public final boolean zzcf(String str) {
        if (TextUtils.isEmpty(str)) {
            zzgf().zzis().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        zzgf().zzis().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzci(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzhn = zzgh().zzhn();
        zzgi();
        return zzhn.equals(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zzd(Context context, String str) {
        zzab();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest("MD5");
        if (messageDigest == null) {
            zzgf().zzis().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zze(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzgf().zziv().log("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzgf().zzis().zzg("Package name not found", e);
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzgf().zziv().zzg("Param value can't be null", zzgb().zzbj(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzd(zzew zzew, zzdz zzdz) {
        Preconditions.checkNotNull(zzew);
        Preconditions.checkNotNull(zzdz);
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            return true;
        }
        zzgi();
        return false;
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

    public final Object zzh(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!zzch(str)) {
                i = 100;
            }
            z = false;
        }
        return zza(i, obj, z);
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return true;
    }

    public final int zzi(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzcg(str), obj, false) : zza("user property", str, zzcg(str), obj, false) ? 0 : 7;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzin() {
        zzab();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzgf().zziv().log("Utils falling back to Random for random id");
            }
        }
        this.zzarr.set(nextLong);
    }

    public final Object zzj(String str, Object obj) {
        int zzcg;
        boolean z;
        if ("_ldl".equals(str)) {
            zzcg = zzcg(str);
            z = true;
        } else {
            zzcg = zzcg(str);
            z = false;
        }
        return zza(zzcg, obj, z);
    }

    public final long zzlk() {
        long andIncrement;
        long j;
        if (this.zzarr.get() == 0) {
            synchronized (this.zzarr) {
                long nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                int i = this.zzars + 1;
                this.zzars = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzarr) {
            this.zzarr.compareAndSet(-1, 1);
            andIncrement = this.zzarr.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final SecureRandom zzll() {
        zzab();
        if (this.zzarq == null) {
            this.zzarq = new SecureRandom();
        }
        return this.zzarq;
    }

    public final int zzlm() {
        if (this.zzart == null) {
            this.zzart = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.zzart.intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq(String str, String str2) {
        if (str2 == null) {
            zzgf().zzis().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgf().zzis().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzgf().zzis().zze("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzgf().zzis().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    @WorkerThread
    public final boolean zzw(String str) {
        zzab();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzgf().zziy().zzg("Permission not granted", str);
        return false;
    }
}
