package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzeb extends zzjr {
    zzeb(zzjs zzjs) {
        super(zzjs);
    }

    private final Boolean zza(double d, zzki zzki) {
        try {
            return zza(new BigDecimal(d), zzki, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(long j, zzki zzki) {
        try {
            return zza(new BigDecimal(j), zzki, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        boolean startsWith;
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzgf().zziv().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                startsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    private final Boolean zza(String str, zzki zzki) {
        if (!zzkc.zzcj(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzki, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzkk zzkk) {
        ArrayList arrayList;
        Preconditions.checkNotNull(zzkk);
        if (str == null || zzkk.zzast == null || zzkk.zzast.intValue() == 0) {
            return null;
        }
        if (zzkk.zzast.intValue() == 6) {
            if (zzkk.zzasw == null || zzkk.zzasw.length == 0) {
                return null;
            }
        } else if (zzkk.zzasu == null) {
            return null;
        }
        int intValue = zzkk.zzast.intValue();
        boolean z = zzkk.zzasv != null && zzkk.zzasv.booleanValue();
        String upperCase = (z || intValue == 1 || intValue == 6) ? zzkk.zzasu : zzkk.zzasu.toUpperCase(Locale.ENGLISH);
        if (zzkk.zzasw == null) {
            arrayList = null;
        } else {
            String[] strArr = zzkk.zzasw;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (String upperCase2 : strArr) {
                    arrayList2.add(upperCase2.toUpperCase(Locale.ENGLISH));
                }
                arrayList = arrayList2;
            }
        }
        return zza(str, intValue, z, upperCase, arrayList, intValue == 1 ? upperCase : null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r3 != null) goto L_0x0072;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzki r8, double r9) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.lang.Integer r0 = r8.zzasl
            r1 = 0
            if (r0 == 0) goto L_0x00ec
            java.lang.Integer r0 = r8.zzasl
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            java.lang.Integer r0 = r8.zzasl
            int r0 = r0.intValue()
            r2 = 4
            if (r0 != r2) goto L_0x0023
            java.lang.String r0 = r8.zzaso
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r8.zzasp
            if (r0 != 0) goto L_0x0028
        L_0x0022:
            return r1
        L_0x0023:
            java.lang.String r0 = r8.zzasn
            if (r0 != 0) goto L_0x0028
            return r1
        L_0x0028:
            java.lang.Integer r0 = r8.zzasl
            int r0 = r0.intValue()
            java.lang.Integer r3 = r8.zzasl
            int r3 = r3.intValue()
            if (r3 != r2) goto L_0x0059
            java.lang.String r3 = r8.zzaso
            boolean r3 = com.google.android.gms.internal.measurement.zzkc.zzcj(r3)
            if (r3 == 0) goto L_0x0058
            java.lang.String r3 = r8.zzasp
            boolean r3 = com.google.android.gms.internal.measurement.zzkc.zzcj(r3)
            if (r3 != 0) goto L_0x0047
            return r1
        L_0x0047:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r4 = r8.zzaso     // Catch:{ NumberFormatException -> 0x0058 }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x0058 }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r8 = r8.zzasp     // Catch:{ NumberFormatException -> 0x0058 }
            r4.<init>(r8)     // Catch:{ NumberFormatException -> 0x0058 }
            r8 = r3
            r3 = r1
            goto L_0x006b
        L_0x0058:
            return r1
        L_0x0059:
            java.lang.String r3 = r8.zzasn
            boolean r3 = com.google.android.gms.internal.measurement.zzkc.zzcj(r3)
            if (r3 != 0) goto L_0x0062
            return r1
        L_0x0062:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x00ec }
            java.lang.String r8 = r8.zzasn     // Catch:{ NumberFormatException -> 0x00ec }
            r3.<init>(r8)     // Catch:{ NumberFormatException -> 0x00ec }
            r8 = r1
            r4 = r8
        L_0x006b:
            if (r0 != r2) goto L_0x0070
            if (r8 != 0) goto L_0x0072
            return r1
        L_0x0070:
            if (r3 == 0) goto L_0x00ec
        L_0x0072:
            r2 = -1
            r5 = 0
            r6 = 1
            switch(r0) {
                case 1: goto L_0x00e0;
                case 2: goto L_0x00d4;
                case 3: goto L_0x008b;
                case 4: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            return r1
        L_0x0079:
            int r8 = r7.compareTo(r8)
            if (r8 == r2) goto L_0x0086
            int r7 = r7.compareTo(r4)
            if (r7 == r6) goto L_0x0086
            r5 = 1
        L_0x0086:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x008b:
            r0 = 0
            int r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x00c8
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r1 = 2
            r0.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r0)
            java.math.BigDecimal r8 = r3.subtract(r8)
            int r8 = r7.compareTo(r8)
            if (r8 != r6) goto L_0x00c3
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r9)
            java.math.BigDecimal r8 = r3.add(r8)
            int r7 = r7.compareTo(r8)
            if (r7 != r2) goto L_0x00c3
            r5 = 1
        L_0x00c3:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00c8:
            int r7 = r7.compareTo(r3)
            if (r7 != 0) goto L_0x00cf
            r5 = 1
        L_0x00cf:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00d4:
            int r7 = r7.compareTo(r3)
            if (r7 != r6) goto L_0x00db
            r5 = 1
        L_0x00db:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00e0:
            int r7 = r7.compareTo(r3)
            if (r7 != r2) goto L_0x00e7
            r5 = 1
        L_0x00e7:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00ec:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzki, double):java.lang.Boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: android.database.sqlite.SQLiteException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v115, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0695, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x06a4, code lost:
        r3 = java.lang.Boolean.valueOf(r2);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x06b4  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x06b7  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x06bd  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x06d6  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x098a  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x098d  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0993  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x099c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x029f  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzko[] zza(java.lang.String r61, com.google.android.gms.internal.measurement.zzkp[] r62, com.google.android.gms.internal.measurement.zzku[] r63) {
        /*
            r60 = this;
            r1 = r60
            r15 = r61
            r14 = r62
            r13 = r63
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r61)
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            android.support.v4.util.ArrayMap r12 = new android.support.v4.util.ArrayMap
            r12.<init>()
            android.support.v4.util.ArrayMap r9 = new android.support.v4.util.ArrayMap
            r9.<init>()
            android.support.v4.util.ArrayMap r10 = new android.support.v4.util.ArrayMap
            r10.<init>()
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            java.util.Map r2 = r2.zzbe(r15)
            if (r2 == 0) goto L_0x00fc
            java.util.Set r3 = r2.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0031:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00fc
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = r2.get(r5)
            com.google.android.gms.internal.measurement.zzkt r5 = (com.google.android.gms.internal.measurement.zzkt) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r9.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Object r7 = r10.get(r7)
            java.util.BitSet r7 = (java.util.BitSet) r7
            if (r6 != 0) goto L_0x0079
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r9.put(r7, r6)
            java.util.BitSet r7 = new java.util.BitSet
            r7.<init>()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r10.put(r8, r7)
        L_0x0079:
            r17 = r2
            r8 = 0
        L_0x007c:
            long[] r2 = r5.zzauw
            int r2 = r2.length
            int r2 = r2 << 6
            if (r8 >= r2) goto L_0x00c4
            long[] r2 = r5.zzauw
            boolean r2 = com.google.android.gms.internal.measurement.zzkc.zza((long[]) r2, (int) r8)
            if (r2 == 0) goto L_0x00b5
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()
            r18 = r3
            java.lang.String r3 = "Filter already evaluated. audience ID, filter ID"
            r19 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r20 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            r2.zze(r3, r9, r10)
            r7.set(r8)
            long[] r2 = r5.zzaux
            boolean r2 = com.google.android.gms.internal.measurement.zzkc.zza((long[]) r2, (int) r8)
            if (r2 == 0) goto L_0x00bb
            r6.set(r8)
            goto L_0x00bb
        L_0x00b5:
            r18 = r3
            r19 = r9
            r20 = r10
        L_0x00bb:
            int r8 = r8 + 1
            r3 = r18
            r9 = r19
            r10 = r20
            goto L_0x007c
        L_0x00c4:
            r18 = r3
            r19 = r9
            r20 = r10
            com.google.android.gms.internal.measurement.zzko r2 = new com.google.android.gms.internal.measurement.zzko
            r2.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r12.put(r3, r2)
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r2.zzatk = r4
            r2.zzatj = r5
            com.google.android.gms.internal.measurement.zzkt r3 = new com.google.android.gms.internal.measurement.zzkt
            r3.<init>()
            r2.zzati = r3
            com.google.android.gms.internal.measurement.zzkt r3 = r2.zzati
            long[] r4 = com.google.android.gms.internal.measurement.zzkc.zza((java.util.BitSet) r6)
            r3.zzaux = r4
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzati
            long[] r3 = com.google.android.gms.internal.measurement.zzkc.zza((java.util.BitSet) r7)
            r2.zzauw = r3
            r2 = r17
            r3 = r18
            goto L_0x0031
        L_0x00fc:
            r19 = r9
            r20 = r10
            if (r14 == 0) goto L_0x0750
            android.support.v4.util.ArrayMap r5 = new android.support.v4.util.ArrayMap
            r5.<init>()
            int r6 = r14.length
            r2 = 0
            r8 = 0
            r17 = 0
            r21 = 0
        L_0x010e:
            if (r2 >= r6) goto L_0x0750
            r9 = r14[r2]
            java.lang.String r10 = r9.name
            com.google.android.gms.internal.measurement.zzkq[] r7 = r9.zzatm
            com.google.android.gms.internal.measurement.zzeg r3 = r60.zzgh()
            com.google.android.gms.internal.measurement.zzey$zza<java.lang.Boolean> r4 = com.google.android.gms.internal.measurement.zzey.zzaic
            boolean r3 = r3.zzd(r15, r4)
            if (r3 == 0) goto L_0x02ed
            r60.zzjc()
            java.lang.String r3 = "_eid"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzjy.zzb(r9, r3)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0132
            r3 = 1
            goto L_0x0133
        L_0x0132:
            r3 = 0
        L_0x0133:
            if (r3 == 0) goto L_0x0141
            r26 = r2
            java.lang.String r2 = "_ep"
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0143
            r2 = 1
            goto L_0x0144
        L_0x0141:
            r26 = r2
        L_0x0143:
            r2 = 0
        L_0x0144:
            if (r2 == 0) goto L_0x029f
            r60.zzjc()
            java.lang.String r2 = "_en"
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzjy.zzb(r9, r2)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()
            java.lang.String r3 = "Extra parameter without an event name. eventId"
            r2.zzg(r3, r4)
            r31 = r5
            r23 = r6
            r18 = r26
            r16 = 0
            goto L_0x0292
        L_0x016f:
            if (r17 == 0) goto L_0x0187
            if (r8 == 0) goto L_0x0187
            long r2 = r4.longValue()
            long r27 = r8.longValue()
            int r18 = (r2 > r27 ? 1 : (r2 == r27 ? 0 : -1))
            if (r18 == 0) goto L_0x0180
            goto L_0x0187
        L_0x0180:
            r59 = r17
            r17 = r8
            r8 = r59
            goto L_0x01b1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            android.util.Pair r2 = r2.zza((java.lang.String) r15, (java.lang.Long) r4)
            if (r2 == 0) goto L_0x027d
            java.lang.Object r3 = r2.first
            if (r3 != 0) goto L_0x0197
            goto L_0x027d
        L_0x0197:
            java.lang.Object r3 = r2.first
            com.google.android.gms.internal.measurement.zzkp r3 = (com.google.android.gms.internal.measurement.zzkp) r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r21 = r2.longValue()
            r60.zzjc()
            java.lang.String r2 = "_eid"
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzjy.zzb(r3, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r17 = r2
            r8 = r3
        L_0x01b1:
            r2 = 1
            long r27 = r21 - r2
            r21 = 0
            int r2 = (r27 > r21 ? 1 : (r27 == r21 ? 0 : -1))
            if (r2 > 0) goto L_0x0208
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            r2.zzab()
            com.google.android.gms.internal.measurement.zzfh r3 = r2.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziz()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r3.zzg(r4, r15)
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x01e8 }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            r30 = r5
            r29 = r7
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x01e6 }
            r16 = 0
            r5[r16] = r15     // Catch:{ SQLiteException -> 0x01e4 }
            r3.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x01e4 }
            goto L_0x01fe
        L_0x01e4:
            r0 = move-exception
            goto L_0x01f0
        L_0x01e6:
            r0 = move-exception
            goto L_0x01ee
        L_0x01e8:
            r0 = move-exception
            r30 = r5
            r29 = r7
            r7 = 1
        L_0x01ee:
            r16 = 0
        L_0x01f0:
            r3 = r0
            com.google.android.gms.internal.measurement.zzfh r2 = r2.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()
            java.lang.String r4 = "Error clearing complex main event"
            r2.zzg(r4, r3)
        L_0x01fe:
            r23 = r6
            r18 = r26
            r13 = r29
            r31 = r30
            r14 = 1
            goto L_0x0225
        L_0x0208:
            r30 = r5
            r29 = r7
            r7 = 1
            r16 = 0
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            r18 = r26
            r13 = r21
            r3 = r15
            r23 = r6
            r31 = r30
            r5 = r27
            r13 = r29
            r14 = 1
            r7 = r8
            r2.zza(r3, r4, r5, r7)
        L_0x0225:
            com.google.android.gms.internal.measurement.zzkq[] r2 = r8.zzatm
            int r2 = r2.length
            int r3 = r13.length
            int r2 = r2 + r3
            com.google.android.gms.internal.measurement.zzkq[] r2 = new com.google.android.gms.internal.measurement.zzkq[r2]
            com.google.android.gms.internal.measurement.zzkq[] r3 = r8.zzatm
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x0231:
            if (r5 >= r4) goto L_0x0249
            r7 = r3[r5]
            r60.zzjc()
            java.lang.String r14 = r7.name
            com.google.android.gms.internal.measurement.zzkq r14 = com.google.android.gms.internal.measurement.zzjy.zza((com.google.android.gms.internal.measurement.zzkp) r9, (java.lang.String) r14)
            if (r14 != 0) goto L_0x0245
            int r14 = r6 + 1
            r2[r6] = r7
            r6 = r14
        L_0x0245:
            int r5 = r5 + 1
            r14 = 1
            goto L_0x0231
        L_0x0249:
            if (r6 <= 0) goto L_0x0267
            int r3 = r13.length
            r4 = 0
        L_0x024d:
            if (r4 >= r3) goto L_0x0259
            r5 = r13[r4]
            int r7 = r6 + 1
            r2[r6] = r5
            int r4 = r4 + 1
            r6 = r7
            goto L_0x024d
        L_0x0259:
            int r3 = r2.length
            if (r6 != r3) goto L_0x025e
        L_0x025c:
            r7 = r2
            goto L_0x0265
        L_0x025e:
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r6)
            com.google.android.gms.internal.measurement.zzkq[] r2 = (com.google.android.gms.internal.measurement.zzkq[]) r2
            goto L_0x025c
        L_0x0265:
            r13 = r7
            goto L_0x0274
        L_0x0267:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "No unique parameters in main event. eventName"
            r2.zzg(r3, r10)
        L_0x0274:
            r14 = r10
            r21 = r17
            r24 = 0
            r17 = r8
            goto L_0x02fd
        L_0x027d:
            r31 = r5
            r23 = r6
            r18 = r26
            r16 = 0
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zzis()
            java.lang.String r3 = "Extra parameter without existing main event. eventName, eventId"
            r2.zze(r3, r10, r4)
        L_0x0292:
            r46 = r12
            r4 = r15
            r45 = r19
            r44 = r20
            r40 = r31
            r19 = 0
            goto L_0x073d
        L_0x029f:
            r31 = r5
            r23 = r6
            r13 = r7
            r18 = r26
            r16 = 0
            if (r3 == 0) goto L_0x02f6
            r60.zzjc()
            java.lang.String r2 = "_epc"
            r7 = 0
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzjy.zzb(r9, r2)
            if (r2 != 0) goto L_0x02bc
            r2 = r3
        L_0x02bc:
            java.lang.Long r2 = (java.lang.Long) r2
            long r21 = r2.longValue()
            int r2 = (r21 > r7 ? 1 : (r21 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x02d7
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.zzg(r3, r10)
            r14 = r4
            r24 = r7
            goto L_0x02e5
        L_0x02d7:
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            r3 = r15
            r14 = r4
            r5 = r21
            r24 = r7
            r7 = r9
            r2.zza(r3, r4, r5, r7)
        L_0x02e5:
            r17 = r9
            r27 = r21
            r21 = r14
            r14 = r10
            goto L_0x02fd
        L_0x02ed:
            r18 = r2
            r31 = r5
            r23 = r6
            r13 = r7
            r16 = 0
        L_0x02f6:
            r24 = 0
            r14 = r10
            r27 = r21
            r21 = r8
        L_0x02fd:
            com.google.android.gms.internal.measurement.zzej r2 = r60.zzje()
            java.lang.String r3 = r9.name
            com.google.android.gms.internal.measurement.zzes r2 = r2.zzf(r15, r3)
            if (r2 != 0) goto L_0x0355
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Event aggregate wasn't created during raw event logging. appId, event"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfh.zzbl(r61)
            com.google.android.gms.internal.measurement.zzff r5 = r60.zzgb()
            java.lang.String r5 = r5.zzbi(r14)
            r2.zze(r3, r4, r5)
            com.google.android.gms.internal.measurement.zzes r22 = new com.google.android.gms.internal.measurement.zzes
            java.lang.String r4 = r9.name
            r5 = 1
            r7 = 1
            java.lang.Long r2 = r9.zzatn
            long r9 = r2.longValue()
            r29 = 0
            r26 = 0
            r32 = 0
            r33 = 0
            r2 = r22
            r3 = r15
            r34 = r19
            r35 = r20
            r36 = r11
            r37 = r12
            r11 = r29
            r38 = r13
            r19 = r24
            r13 = r26
            r39 = r14
            r14 = r32
            r15 = r33
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r14, r15)
            goto L_0x0369
        L_0x0355:
            r36 = r11
            r37 = r12
            r38 = r13
            r39 = r14
            r34 = r19
            r35 = r20
            r19 = r24
            com.google.android.gms.internal.measurement.zzes r22 = r2.zzii()
            r2 = r22
        L_0x0369:
            com.google.android.gms.internal.measurement.zzej r3 = r60.zzje()
            r3.zza((com.google.android.gms.internal.measurement.zzes) r2)
            long r2 = r2.zzafs
            r4 = r31
            r10 = r39
            java.lang.Object r5 = r4.get(r10)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x0393
            com.google.android.gms.internal.measurement.zzej r5 = r60.zzje()
            r6 = r61
            java.util.Map r5 = r5.zzk(r6, r10)
            if (r5 != 0) goto L_0x038f
            android.support.v4.util.ArrayMap r5 = new android.support.v4.util.ArrayMap
            r5.<init>()
        L_0x038f:
            r4.put(r10, r5)
            goto L_0x0395
        L_0x0393:
            r6 = r61
        L_0x0395:
            java.util.Set r7 = r5.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x039d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x072e
            java.lang.Object r8 = r7.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r11 = r36
            boolean r9 = r11.contains(r9)
            if (r9 == 0) goto L_0x03cd
            com.google.android.gms.internal.measurement.zzfh r9 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zziz()
            java.lang.String r12 = "Skipping failed audience ID"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.zzg(r12, r8)
            r36 = r11
            goto L_0x039d
        L_0x03cd:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r12 = r37
            java.lang.Object r9 = r12.get(r9)
            com.google.android.gms.internal.measurement.zzko r9 = (com.google.android.gms.internal.measurement.zzko) r9
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r14 = r34
            java.lang.Object r13 = r14.get(r13)
            java.util.BitSet r13 = (java.util.BitSet) r13
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            r40 = r4
            r4 = r35
            java.lang.Object r15 = r4.get(r15)
            java.util.BitSet r15 = (java.util.BitSet) r15
            if (r9 != 0) goto L_0x0421
            com.google.android.gms.internal.measurement.zzko r9 = new com.google.android.gms.internal.measurement.zzko
            r9.<init>()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r12.put(r13, r9)
            r13 = 1
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r13)
            r9.zzatk = r15
            java.util.BitSet r9 = new java.util.BitSet
            r9.<init>()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            r14.put(r15, r9)
            java.util.BitSet r15 = new java.util.BitSet
            r15.<init>()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r4.put(r13, r15)
            r13 = r9
        L_0x0421:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            java.lang.Object r9 = r5.get(r9)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x042f:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x071f
            java.lang.Object r16 = r9.next()
            r41 = r5
            r5 = r16
            com.google.android.gms.internal.measurement.zzkg r5 = (com.google.android.gms.internal.measurement.zzkg) r5
            r42 = r7
            com.google.android.gms.internal.measurement.zzfh r7 = r60.zzgf()
            r43 = r9
            r9 = 2
            boolean r7 = r7.isLoggable(r9)
            if (r7 == 0) goto L_0x0487
            com.google.android.gms.internal.measurement.zzfh r7 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zziz()
            java.lang.String r9 = "Evaluating filter. audience, filter, event"
            r44 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r45 = r14
            java.lang.Integer r14 = r5.zzasb
            r46 = r12
            com.google.android.gms.internal.measurement.zzff r12 = r60.zzgb()
            java.lang.String r6 = r5.zzasc
            java.lang.String r6 = r12.zzbi(r6)
            r7.zzd(r9, r4, r14, r6)
            com.google.android.gms.internal.measurement.zzfh r4 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziz()
            java.lang.String r6 = "Filter definition"
            com.google.android.gms.internal.measurement.zzjy r7 = r60.zzjc()
            java.lang.String r7 = r7.zza((com.google.android.gms.internal.measurement.zzkg) r5)
            r4.zzg(r6, r7)
            goto L_0x048d
        L_0x0487:
            r44 = r4
            r46 = r12
            r45 = r14
        L_0x048d:
            java.lang.Integer r4 = r5.zzasb
            if (r4 == 0) goto L_0x06ef
            java.lang.Integer r4 = r5.zzasb
            int r4 = r4.intValue()
            r6 = 256(0x100, float:3.59E-43)
            if (r4 <= r6) goto L_0x049d
            goto L_0x06ef
        L_0x049d:
            java.lang.Integer r4 = r5.zzasb
            int r4 = r4.intValue()
            boolean r4 = r13.get(r4)
            if (r4 == 0) goto L_0x04cc
            com.google.android.gms.internal.measurement.zzfh r4 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziz()
            java.lang.String r7 = "Event filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r5 = r5.zzasb
            r4.zze(r7, r9, r5)
            r5 = r41
            r7 = r42
            r9 = r43
            r4 = r44
            r14 = r45
            r12 = r46
        L_0x04c8:
            r6 = r61
            goto L_0x042f
        L_0x04cc:
            com.google.android.gms.internal.measurement.zzki r4 = r5.zzasf
            if (r4 == 0) goto L_0x04f1
            com.google.android.gms.internal.measurement.zzki r4 = r5.zzasf
            java.lang.Boolean r4 = r1.zza((long) r2, (com.google.android.gms.internal.measurement.zzki) r4)
            if (r4 != 0) goto L_0x04df
        L_0x04d8:
            r47 = r2
            r6 = r38
        L_0x04dc:
            r3 = 0
            goto L_0x06a8
        L_0x04df:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x04f1
            r4 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
            r47 = r2
            r3 = r7
            r6 = r38
            goto L_0x06a8
        L_0x04f1:
            r4 = 0
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            com.google.android.gms.internal.measurement.zzkh[] r9 = r5.zzasd
            int r12 = r9.length
            r14 = 0
        L_0x04fb:
            if (r14 >= r12) goto L_0x0528
            r6 = r9[r14]
            java.lang.String r4 = r6.zzask
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x051d
            com.google.android.gms.internal.measurement.zzfh r4 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziv()
            java.lang.String r6 = "null or empty param name in filter. event"
            com.google.android.gms.internal.measurement.zzff r7 = r60.zzgb()
            java.lang.String r7 = r7.zzbi(r10)
            r4.zzg(r6, r7)
            goto L_0x04d8
        L_0x051d:
            java.lang.String r4 = r6.zzask
            r7.add(r4)
            int r14 = r14 + 1
            r4 = 0
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x04fb
        L_0x0528:
            android.support.v4.util.ArrayMap r4 = new android.support.v4.util.ArrayMap
            r4.<init>()
            r6 = r38
            int r9 = r6.length
            r12 = 0
        L_0x0531:
            if (r12 >= r9) goto L_0x0583
            r14 = r6[r12]
            r47 = r2
            java.lang.String r2 = r14.name
            boolean r2 = r7.contains(r2)
            if (r2 == 0) goto L_0x057e
            java.lang.Long r2 = r14.zzatq
            if (r2 == 0) goto L_0x054b
            java.lang.String r2 = r14.name
            java.lang.Long r3 = r14.zzatq
        L_0x0547:
            r4.put(r2, r3)
            goto L_0x057e
        L_0x054b:
            java.lang.Double r2 = r14.zzaro
            if (r2 == 0) goto L_0x0554
            java.lang.String r2 = r14.name
            java.lang.Double r3 = r14.zzaro
            goto L_0x0547
        L_0x0554:
            java.lang.String r2 = r14.zzajo
            if (r2 == 0) goto L_0x055d
            java.lang.String r2 = r14.name
            java.lang.String r3 = r14.zzajo
            goto L_0x0547
        L_0x055d:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Unknown value for param. event, param"
            com.google.android.gms.internal.measurement.zzff r4 = r60.zzgb()
            java.lang.String r4 = r4.zzbi(r10)
            com.google.android.gms.internal.measurement.zzff r7 = r60.zzgb()
            java.lang.String r9 = r14.name
            java.lang.String r7 = r7.zzbj(r9)
        L_0x0579:
            r2.zze(r3, r4, r7)
            goto L_0x04dc
        L_0x057e:
            int r12 = r12 + 1
            r2 = r47
            goto L_0x0531
        L_0x0583:
            r47 = r2
            com.google.android.gms.internal.measurement.zzkh[] r2 = r5.zzasd
            int r3 = r2.length
            r7 = 0
        L_0x0589:
            if (r7 >= r3) goto L_0x06a3
            r9 = r2[r7]
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            java.lang.Boolean r14 = r9.zzasj
            boolean r12 = r12.equals(r14)
            java.lang.String r14 = r9.zzask
            boolean r16 = android.text.TextUtils.isEmpty(r14)
            if (r16 == 0) goto L_0x05b4
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Event has empty param name. event"
            com.google.android.gms.internal.measurement.zzff r4 = r60.zzgb()
            java.lang.String r4 = r4.zzbi(r10)
            r2.zzg(r3, r4)
            goto L_0x04dc
        L_0x05b4:
            r49 = r2
            java.lang.Object r2 = r4.get(r14)
            r50 = r3
            boolean r3 = r2 instanceof java.lang.Long
            if (r3 == 0) goto L_0x05fa
            com.google.android.gms.internal.measurement.zzki r3 = r9.zzasi
            if (r3 != 0) goto L_0x05df
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "No number filter for long param. event, param"
        L_0x05ce:
            com.google.android.gms.internal.measurement.zzff r4 = r60.zzgb()
            java.lang.String r4 = r4.zzbi(r10)
            com.google.android.gms.internal.measurement.zzff r7 = r60.zzgb()
            java.lang.String r7 = r7.zzbj(r14)
            goto L_0x0579
        L_0x05df:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            com.google.android.gms.internal.measurement.zzki r9 = r9.zzasi
            java.lang.Boolean r2 = r1.zza((long) r2, (com.google.android.gms.internal.measurement.zzki) r9)
            if (r2 != 0) goto L_0x05ef
        L_0x05ed:
            goto L_0x04dc
        L_0x05ef:
            boolean r2 = r2.booleanValue()
            r3 = 1
            r2 = r2 ^ r3
            r2 = r2 ^ r12
            if (r2 == 0) goto L_0x0656
        L_0x05f8:
            goto L_0x0695
        L_0x05fa:
            boolean r3 = r2 instanceof java.lang.Double
            if (r3 == 0) goto L_0x0626
            com.google.android.gms.internal.measurement.zzki r3 = r9.zzasi
            if (r3 != 0) goto L_0x060d
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "No number filter for double param. event, param"
            goto L_0x05ce
        L_0x060d:
            java.lang.Double r2 = (java.lang.Double) r2
            double r2 = r2.doubleValue()
            com.google.android.gms.internal.measurement.zzki r9 = r9.zzasi
            java.lang.Boolean r2 = r1.zza((double) r2, (com.google.android.gms.internal.measurement.zzki) r9)
            if (r2 != 0) goto L_0x061c
            goto L_0x05ed
        L_0x061c:
            boolean r2 = r2.booleanValue()
            r3 = 1
            r2 = r2 ^ r3
            r2 = r2 ^ r12
            if (r2 == 0) goto L_0x0656
            goto L_0x05f8
        L_0x0626:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0676
            com.google.android.gms.internal.measurement.zzkk r3 = r9.zzash
            if (r3 == 0) goto L_0x0637
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.measurement.zzkk r3 = r9.zzash
            java.lang.Boolean r2 = r1.zza((java.lang.String) r2, (com.google.android.gms.internal.measurement.zzkk) r3)
            goto L_0x0649
        L_0x0637:
            com.google.android.gms.internal.measurement.zzki r3 = r9.zzasi
            if (r3 == 0) goto L_0x066a
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = com.google.android.gms.internal.measurement.zzkc.zzcj(r2)
            if (r3 == 0) goto L_0x065e
            com.google.android.gms.internal.measurement.zzki r3 = r9.zzasi
            java.lang.Boolean r2 = r1.zza((java.lang.String) r2, (com.google.android.gms.internal.measurement.zzki) r3)
        L_0x0649:
            if (r2 != 0) goto L_0x064c
            goto L_0x05ed
        L_0x064c:
            boolean r2 = r2.booleanValue()
            r3 = 1
            r2 = r2 ^ r3
            r2 = r2 ^ r12
            if (r2 == 0) goto L_0x0656
            goto L_0x05f8
        L_0x0656:
            int r7 = r7 + 1
            r2 = r49
            r3 = r50
            goto L_0x0589
        L_0x065e:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Invalid param value for number filter. event, param"
            goto L_0x05ce
        L_0x066a:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "No filter for String param. event, param"
            goto L_0x05ce
        L_0x0676:
            if (r2 != 0) goto L_0x0697
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()
            java.lang.String r3 = "Missing param for filter. event, param"
            com.google.android.gms.internal.measurement.zzff r4 = r60.zzgb()
            java.lang.String r4 = r4.zzbi(r10)
            com.google.android.gms.internal.measurement.zzff r7 = r60.zzgb()
            java.lang.String r7 = r7.zzbj(r14)
            r2.zze(r3, r4, r7)
        L_0x0695:
            r2 = 0
            goto L_0x06a4
        L_0x0697:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Unknown param type. event, param"
            goto L_0x05ce
        L_0x06a3:
            r2 = 1
        L_0x06a4:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
        L_0x06a8:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziz()
            java.lang.String r4 = "Event filter result"
            if (r3 != 0) goto L_0x06b7
            java.lang.String r7 = "null"
            goto L_0x06b8
        L_0x06b7:
            r7 = r3
        L_0x06b8:
            r2.zzg(r4, r7)
            if (r3 != 0) goto L_0x06d6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r11.add(r2)
        L_0x06c4:
            r38 = r6
            r5 = r41
            r7 = r42
            r9 = r43
            r4 = r44
            r14 = r45
            r12 = r46
            r2 = r47
            goto L_0x04c8
        L_0x06d6:
            java.lang.Integer r2 = r5.zzasb
            int r2 = r2.intValue()
            r15.set(r2)
            boolean r2 = r3.booleanValue()
            if (r2 == 0) goto L_0x06c4
            java.lang.Integer r2 = r5.zzasb
            int r2 = r2.intValue()
            r13.set(r2)
            goto L_0x06c4
        L_0x06ef:
            r47 = r2
            r6 = r38
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Invalid event filter ID. appId, id"
            r4 = r61
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfh.zzbl(r61)
            java.lang.Integer r5 = r5.zzasb
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.zze(r3, r7, r5)
            r38 = r6
            r5 = r41
            r7 = r42
            r9 = r43
            r14 = r45
            r12 = r46
            r2 = r47
            r6 = r4
            r4 = r44
            goto L_0x042f
        L_0x071f:
            r44 = r4
            r4 = r6
            r36 = r11
            r37 = r12
            r34 = r14
            r4 = r40
            r35 = r44
            goto L_0x039d
        L_0x072e:
            r40 = r4
            r4 = r6
            r45 = r34
            r44 = r35
            r11 = r36
            r46 = r37
            r8 = r21
            r21 = r27
        L_0x073d:
            int r2 = r18 + 1
            r14 = r62
            r15 = r4
            r6 = r23
            r5 = r40
            r20 = r44
            r19 = r45
            r12 = r46
            r13 = r63
            goto L_0x010e
        L_0x0750:
            r46 = r12
            r4 = r15
            r45 = r19
            r44 = r20
            r2 = r13
            if (r2 == 0) goto L_0x0a05
            android.support.v4.util.ArrayMap r3 = new android.support.v4.util.ArrayMap
            r3.<init>()
            int r5 = r2.length
            r6 = 0
        L_0x0761:
            if (r6 >= r5) goto L_0x0a05
            r7 = r2[r6]
            java.lang.String r8 = r7.name
            java.lang.Object r8 = r3.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0785
            com.google.android.gms.internal.measurement.zzej r8 = r60.zzje()
            java.lang.String r9 = r7.name
            java.util.Map r8 = r8.zzl(r4, r9)
            if (r8 != 0) goto L_0x0780
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
        L_0x0780:
            java.lang.String r9 = r7.name
            r3.put(r9, r8)
        L_0x0785:
            java.util.Set r9 = r8.keySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x078d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x09f3
            java.lang.Object r10 = r9.next()
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            boolean r12 = r11.contains(r12)
            if (r12 == 0) goto L_0x07b9
            com.google.android.gms.internal.measurement.zzfh r12 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r12 = r12.zziz()
            java.lang.String r13 = "Skipping failed audience ID"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r12.zzg(r13, r10)
            goto L_0x078d
        L_0x07b9:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r13 = r46
            java.lang.Object r12 = r13.get(r12)
            com.google.android.gms.internal.measurement.zzko r12 = (com.google.android.gms.internal.measurement.zzko) r12
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            r15 = r45
            java.lang.Object r14 = r15.get(r14)
            java.util.BitSet r14 = (java.util.BitSet) r14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r51 = r3
            r3 = r44
            java.lang.Object r2 = r3.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            if (r12 != 0) goto L_0x080c
            com.google.android.gms.internal.measurement.zzko r2 = new com.google.android.gms.internal.measurement.zzko
            r2.<init>()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r13.put(r12, r2)
            r12 = 1
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r12)
            r2.zzatk = r14
            java.util.BitSet r14 = new java.util.BitSet
            r14.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r15.put(r2, r14)
            java.util.BitSet r2 = new java.util.BitSet
            r2.<init>()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r3.put(r12, r2)
        L_0x080c:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            java.lang.Object r12 = r8.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x081a:
            boolean r16 = r12.hasNext()
            if (r16 == 0) goto L_0x09e5
            java.lang.Object r16 = r12.next()
            r52 = r5
            r5 = r16
            com.google.android.gms.internal.measurement.zzkj r5 = (com.google.android.gms.internal.measurement.zzkj) r5
            r53 = r8
            com.google.android.gms.internal.measurement.zzfh r8 = r60.zzgf()
            r54 = r9
            r9 = 2
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x0874
            com.google.android.gms.internal.measurement.zzfh r8 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r8 = r8.zziz()
            java.lang.String r9 = "Evaluating filter. audience, filter, property"
            r55 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r56 = r3
            java.lang.Integer r3 = r5.zzasb
            r57 = r13
            com.google.android.gms.internal.measurement.zzff r13 = r60.zzgb()
            r58 = r15
            java.lang.String r15 = r5.zzasr
            java.lang.String r13 = r13.zzbk(r15)
            r8.zzd(r9, r12, r3, r13)
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziz()
            java.lang.String r8 = "Filter definition"
            com.google.android.gms.internal.measurement.zzjy r9 = r60.zzjc()
            java.lang.String r9 = r9.zza((com.google.android.gms.internal.measurement.zzkj) r5)
            r3.zzg(r8, r9)
            goto L_0x087c
        L_0x0874:
            r56 = r3
            r55 = r12
            r57 = r13
            r58 = r15
        L_0x087c:
            java.lang.Integer r3 = r5.zzasb
            if (r3 == 0) goto L_0x09b6
            java.lang.Integer r3 = r5.zzasb
            int r3 = r3.intValue()
            r8 = 256(0x100, float:3.59E-43)
            if (r3 <= r8) goto L_0x088c
            goto L_0x09b8
        L_0x088c:
            java.lang.Integer r3 = r5.zzasb
            int r3 = r3.intValue()
            boolean r3 = r14.get(r3)
            if (r3 == 0) goto L_0x08bb
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziz()
            java.lang.String r9 = "Property filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r5 = r5.zzasb
            r3.zze(r9, r12, r5)
        L_0x08ab:
            r5 = r52
            r8 = r53
            r9 = r54
            r12 = r55
            r3 = r56
            r13 = r57
            r15 = r58
            goto L_0x081a
        L_0x08bb:
            com.google.android.gms.internal.measurement.zzkh r3 = r5.zzass
            if (r3 != 0) goto L_0x08d9
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "Missing property filter. property"
        L_0x08c9:
            com.google.android.gms.internal.measurement.zzff r12 = r60.zzgb()
            java.lang.String r13 = r7.name
            java.lang.String r12 = r12.zzbk(r13)
            r3.zzg(r9, r12)
        L_0x08d6:
            r3 = 0
            goto L_0x097e
        L_0x08d9:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            java.lang.Boolean r12 = r3.zzasj
            boolean r9 = r9.equals(r12)
            java.lang.Long r12 = r7.zzatq
            if (r12 == 0) goto L_0x0906
            com.google.android.gms.internal.measurement.zzki r12 = r3.zzasi
            if (r12 != 0) goto L_0x08f4
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "No number filter for long property. property"
            goto L_0x08c9
        L_0x08f4:
            java.lang.Long r12 = r7.zzatq
            long r12 = r12.longValue()
            com.google.android.gms.internal.measurement.zzki r3 = r3.zzasi
            java.lang.Boolean r3 = r1.zza((long) r12, (com.google.android.gms.internal.measurement.zzki) r3)
        L_0x0900:
            java.lang.Boolean r3 = zza((java.lang.Boolean) r3, (boolean) r9)
            goto L_0x097e
        L_0x0906:
            java.lang.Double r12 = r7.zzaro
            if (r12 == 0) goto L_0x0926
            com.google.android.gms.internal.measurement.zzki r12 = r3.zzasi
            if (r12 != 0) goto L_0x0919
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "No number filter for double property. property"
            goto L_0x08c9
        L_0x0919:
            java.lang.Double r12 = r7.zzaro
            double r12 = r12.doubleValue()
            com.google.android.gms.internal.measurement.zzki r3 = r3.zzasi
            java.lang.Boolean r3 = r1.zza((double) r12, (com.google.android.gms.internal.measurement.zzki) r3)
            goto L_0x0900
        L_0x0926:
            java.lang.String r12 = r7.zzajo
            if (r12 == 0) goto L_0x0972
            com.google.android.gms.internal.measurement.zzkk r12 = r3.zzash
            if (r12 != 0) goto L_0x0969
            com.google.android.gms.internal.measurement.zzki r12 = r3.zzasi
            if (r12 != 0) goto L_0x093d
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "No string or number filter defined. property"
            goto L_0x08c9
        L_0x093d:
            java.lang.String r12 = r7.zzajo
            boolean r12 = com.google.android.gms.internal.measurement.zzkc.zzcj(r12)
            if (r12 == 0) goto L_0x094e
            java.lang.String r12 = r7.zzajo
            com.google.android.gms.internal.measurement.zzki r3 = r3.zzasi
            java.lang.Boolean r3 = r1.zza((java.lang.String) r12, (com.google.android.gms.internal.measurement.zzki) r3)
            goto L_0x0900
        L_0x094e:
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            com.google.android.gms.internal.measurement.zzff r12 = r60.zzgb()
            java.lang.String r13 = r7.name
            java.lang.String r12 = r12.zzbk(r13)
            java.lang.String r13 = r7.zzajo
            r3.zze(r9, r12, r13)
            goto L_0x08d6
        L_0x0969:
            java.lang.String r12 = r7.zzajo
            com.google.android.gms.internal.measurement.zzkk r3 = r3.zzash
            java.lang.Boolean r3 = r1.zza((java.lang.String) r12, (com.google.android.gms.internal.measurement.zzkk) r3)
            goto L_0x0900
        L_0x0972:
            com.google.android.gms.internal.measurement.zzfh r3 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r9 = "User property has no value, property"
            goto L_0x08c9
        L_0x097e:
            com.google.android.gms.internal.measurement.zzfh r9 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r9 = r9.zziz()
            java.lang.String r12 = "Property filter result"
            if (r3 != 0) goto L_0x098d
            java.lang.String r13 = "null"
            goto L_0x098e
        L_0x098d:
            r13 = r3
        L_0x098e:
            r9.zzg(r12, r13)
            if (r3 != 0) goto L_0x099c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r11.add(r3)
            goto L_0x08ab
        L_0x099c:
            java.lang.Integer r9 = r5.zzasb
            int r9 = r9.intValue()
            r2.set(r9)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x08ab
            java.lang.Integer r3 = r5.zzasb
            int r3 = r3.intValue()
            r14.set(r3)
            goto L_0x08ab
        L_0x09b6:
            r8 = 256(0x100, float:3.59E-43)
        L_0x09b8:
            com.google.android.gms.internal.measurement.zzfh r2 = r60.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziv()
            java.lang.String r3 = "Invalid property filter ID. appId, id"
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzfh.zzbl(r61)
            java.lang.Integer r5 = r5.zzasb
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.zze(r3, r9, r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r11.add(r2)
            r3 = r51
            r5 = r52
            r8 = r53
            r9 = r54
            r44 = r56
            r46 = r57
            r45 = r58
            goto L_0x09ef
        L_0x09e5:
            r53 = r8
            r44 = r3
            r46 = r13
            r45 = r15
            r3 = r51
        L_0x09ef:
            r2 = r63
            goto L_0x078d
        L_0x09f3:
            r51 = r3
            r52 = r5
            r56 = r44
            r58 = r45
            r57 = r46
            r8 = 256(0x100, float:3.59E-43)
            int r6 = r6 + 1
            r2 = r63
            goto L_0x0761
        L_0x0a05:
            r56 = r44
            r57 = r46
            r2 = r45
            int r3 = r2.size()
            com.google.android.gms.internal.measurement.zzko[] r3 = new com.google.android.gms.internal.measurement.zzko[r3]
            java.util.Set r5 = r2.keySet()
            java.util.Iterator r5 = r5.iterator()
            r8 = 0
        L_0x0a1a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0b09
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            boolean r7 = r11.contains(r7)
            if (r7 != 0) goto L_0x0a1a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r9 = r57
            java.lang.Object r7 = r9.get(r7)
            com.google.android.gms.internal.measurement.zzko r7 = (com.google.android.gms.internal.measurement.zzko) r7
            if (r7 != 0) goto L_0x0a47
            com.google.android.gms.internal.measurement.zzko r7 = new com.google.android.gms.internal.measurement.zzko
            r7.<init>()
        L_0x0a47:
            int r10 = r8 + 1
            r3[r8] = r7
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r7.zzarx = r8
            com.google.android.gms.internal.measurement.zzkt r8 = new com.google.android.gms.internal.measurement.zzkt
            r8.<init>()
            r7.zzati = r8
            com.google.android.gms.internal.measurement.zzkt r8 = r7.zzati
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            java.lang.Object r12 = r2.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            long[] r12 = com.google.android.gms.internal.measurement.zzkc.zza((java.util.BitSet) r12)
            r8.zzaux = r12
            com.google.android.gms.internal.measurement.zzkt r8 = r7.zzati
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r13 = r56
            java.lang.Object r12 = r13.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            long[] r12 = com.google.android.gms.internal.measurement.zzkc.zza((java.util.BitSet) r12)
            r8.zzauw = r12
            com.google.android.gms.internal.measurement.zzej r8 = r60.zzje()
            com.google.android.gms.internal.measurement.zzkt r7 = r7.zzati
            r8.zzch()
            r8.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r61)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            int r12 = r7.zzvv()     // Catch:{ IOException -> 0x0aee }
            byte[] r12 = new byte[r12]     // Catch:{ IOException -> 0x0aee }
            int r14 = r12.length     // Catch:{ IOException -> 0x0aee }
            r15 = 0
            com.google.android.gms.internal.measurement.zzaby r14 = com.google.android.gms.internal.measurement.zzaby.zzb(r12, r15, r14)     // Catch:{ IOException -> 0x0aee }
            r7.zza(r14)     // Catch:{ IOException -> 0x0aee }
            r14.zzvn()     // Catch:{ IOException -> 0x0aee }
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r14 = "app_id"
            r7.put(r14, r4)
            java.lang.String r14 = "audience_id"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.put(r14, r6)
            java.lang.String r6 = "current_results"
            r7.put(r6, r12)
            android.database.sqlite.SQLiteDatabase r6 = r8.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0ae0 }
            java.lang.String r12 = "audience_filter_values"
            r14 = 5
            r15 = 0
            long r6 = r6.insertWithOnConflict(r12, r15, r7, r14)     // Catch:{ SQLiteException -> 0x0ade }
            r16 = -1
            int r12 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0b02
            com.google.android.gms.internal.measurement.zzfh r6 = r8.zzgf()     // Catch:{ SQLiteException -> 0x0ade }
            com.google.android.gms.internal.measurement.zzfj r6 = r6.zzis()     // Catch:{ SQLiteException -> 0x0ade }
            java.lang.String r7 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzfh.zzbl(r61)     // Catch:{ SQLiteException -> 0x0ade }
            r6.zzg(r7, r12)     // Catch:{ SQLiteException -> 0x0ade }
            goto L_0x0b02
        L_0x0ade:
            r0 = move-exception
            goto L_0x0ae2
        L_0x0ae0:
            r0 = move-exception
            r15 = 0
        L_0x0ae2:
            r6 = r0
            com.google.android.gms.internal.measurement.zzfh r7 = r8.zzgf()
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zzis()
            java.lang.String r8 = "Error storing filter results. appId"
            goto L_0x0afb
        L_0x0aee:
            r0 = move-exception
            r15 = 0
            r6 = r0
            com.google.android.gms.internal.measurement.zzfh r7 = r8.zzgf()
            com.google.android.gms.internal.measurement.zzfj r7 = r7.zzis()
            java.lang.String r8 = "Configuration loss. Failed to serialize filter results. appId"
        L_0x0afb:
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzfh.zzbl(r61)
            r7.zze(r8, r12, r6)
        L_0x0b02:
            r57 = r9
            r8 = r10
            r56 = r13
            goto L_0x0a1a
        L_0x0b09:
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r8)
            com.google.android.gms.internal.measurement.zzko[] r2 = (com.google.android.gms.internal.measurement.zzko[]) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzkp[], com.google.android.gms.internal.measurement.zzku[]):com.google.android.gms.internal.measurement.zzko[]");
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return false;
    }
}
