package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzwp {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbmt = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbmu = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbmv = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzbmw = new AtomicBoolean();
    private static HashMap<String, String> zzbmx;
    private static final HashMap<String, Boolean> zzbmy = new HashMap<>();
    private static final HashMap<String, Integer> zzbmz = new HashMap<>();
    private static final HashMap<String, Long> zzbna = new HashMap<>();
    private static final HashMap<String, Float> zzbnb = new HashMap<>();
    private static Object zzbnc;
    private static boolean zzbnd;
    private static String[] zzbne = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzwp> r0 = com.google.android.gms.internal.measurement.zzwp.class
            monitor-enter(r0)
            boolean r1 = r2.containsKey(r3)     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0013
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r4
        L_0x0011:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r2 = 0
            return r2
        L_0x0016:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zza(java.util.HashMap, java.lang.String, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r13 = r13.query(CONTENT_URI, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r14}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r13 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r13 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0076, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007e, code lost:
        if (r13.moveToFirst() != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
        zza(r0, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r15 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
        if (r15 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
        if (r15.equals((java.lang.Object) null) == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0095, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0096, code lost:
        zza(r0, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0099, code lost:
        if (r15 == null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009c, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        if (r13 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
        if (r13 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a6, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a9, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzwp> r15 = com.google.android.gms.internal.measurement.zzwp.class
            monitor-enter(r15)
            zza(r13)     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = zzbnc     // Catch:{ all -> 0x00aa }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzbmx     // Catch:{ all -> 0x00aa }
            boolean r1 = r1.containsKey(r14)     // Catch:{ all -> 0x00aa }
            r2 = 0
            if (r1 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzbmx     // Catch:{ all -> 0x00aa }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x00aa }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00aa }
            if (r13 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r13 = r2
        L_0x001d:
            monitor-exit(r15)     // Catch:{ all -> 0x00aa }
            return r13
        L_0x001f:
            java.lang.String[] r1 = zzbne     // Catch:{ all -> 0x00aa }
            int r3 = r1.length     // Catch:{ all -> 0x00aa }
            r4 = 0
            r5 = 0
        L_0x0024:
            r6 = 1
            if (r5 >= r3) goto L_0x0063
            r7 = r1[r5]     // Catch:{ all -> 0x00aa }
            boolean r7 = r14.startsWith(r7)     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x0060
            boolean r0 = zzbnd     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x003b
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzbmx     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x005e
        L_0x003b:
            java.lang.String[] r0 = zzbne     // Catch:{ all -> 0x00aa }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzbmx     // Catch:{ all -> 0x00aa }
            java.util.Map r13 = zza(r13, r0)     // Catch:{ all -> 0x00aa }
            r1.putAll(r13)     // Catch:{ all -> 0x00aa }
            zzbnd = r6     // Catch:{ all -> 0x00aa }
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzbmx     // Catch:{ all -> 0x00aa }
            boolean r13 = r13.containsKey(r14)     // Catch:{ all -> 0x00aa }
            if (r13 == 0) goto L_0x005e
            java.util.HashMap<java.lang.String, java.lang.String> r13 = zzbmx     // Catch:{ all -> 0x00aa }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x00aa }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00aa }
            if (r13 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r13 = r2
        L_0x005c:
            monitor-exit(r15)     // Catch:{ all -> 0x00aa }
            return r13
        L_0x005e:
            monitor-exit(r15)     // Catch:{ all -> 0x00aa }
            return r2
        L_0x0060:
            int r5 = r5 + 1
            goto L_0x0024
        L_0x0063:
            monitor-exit(r15)     // Catch:{ all -> 0x00aa }
            android.net.Uri r8 = CONTENT_URI
            r9 = 0
            r10 = 0
            java.lang.String[] r11 = new java.lang.String[r6]
            r11[r4] = r14
            r12 = 0
            r7 = r13
            android.database.Cursor r13 = r7.query(r8, r9, r10, r11, r12)
            if (r13 != 0) goto L_0x007a
            if (r13 == 0) goto L_0x0079
            r13.close()
        L_0x0079:
            return r2
        L_0x007a:
            boolean r15 = r13.moveToFirst()     // Catch:{ all -> 0x00a3 }
            if (r15 != 0) goto L_0x0089
            zza((java.lang.Object) r0, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00a3 }
            if (r13 == 0) goto L_0x0088
            r13.close()
        L_0x0088:
            return r2
        L_0x0089:
            java.lang.String r15 = r13.getString(r6)     // Catch:{ all -> 0x00a3 }
            if (r15 == 0) goto L_0x0096
            boolean r1 = r15.equals(r2)     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0096
            r15 = r2
        L_0x0096:
            zza((java.lang.Object) r0, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00a3 }
            if (r15 == 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r15 = r2
        L_0x009d:
            if (r13 == 0) goto L_0x00a2
            r13.close()
        L_0x00a2:
            return r15
        L_0x00a3:
            r14 = move-exception
            if (r13 == 0) goto L_0x00a9
            r13.close()
        L_0x00a9:
            throw r14
        L_0x00aa:
            r13 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00aa }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbmt, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbmx == null) {
            zzbmw.set(false);
            zzbmx = new HashMap<>();
            zzbnc = new Object();
            zzbnd = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzwq((Handler) null));
        } else if (zzbmw.getAndSet(false)) {
            zzbmx.clear();
            zzbmy.clear();
            zzbmz.clear();
            zzbna.clear();
            zzbnb.clear();
            zzbnc = new Object();
            zzbnd = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzwp.class) {
            if (obj == zzbnc) {
                zzbmx.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzwp.class) {
            if (obj == zzbnc) {
                hashMap.put(str, t);
                zzbmx.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Boolean bool = (Boolean) zza(zzbmy, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzbmu.matcher(zza).matches()) {
                bool = true;
                z = true;
            } else if (zzbmv.matcher(zza).matches()) {
                bool = false;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        zza(zzb, zzbmy, str, bool);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzwp.class) {
            zza(contentResolver);
            obj = zzbnc;
        }
        return obj;
    }
}
