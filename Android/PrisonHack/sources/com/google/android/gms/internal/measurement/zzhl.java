package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhl extends zzhi {
    @VisibleForTesting
    protected zzie zzanz;
    private AppMeasurement.EventInterceptor zzaoa;
    private final Set<AppMeasurement.OnEventListener> zzaob = new CopyOnWriteArraySet();
    private boolean zzaoc;
    private final AtomicReference<String> zzaod = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzaoe = true;

    protected zzhl(zzgm zzgm) {
        super(zzgm);
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgc().zzce(str) != 0) {
            zzgf().zzis().zzg("Invalid conditional user property name", zzgb().zzbk(str));
        } else if (zzgc().zzi(str, obj) != 0) {
            zzgf().zzis().zze("Invalid conditional user property value", zzgb().zzbk(str), obj);
        } else {
            Object zzj = zzgc().zzj(str, obj);
            if (zzj == null) {
                zzgf().zzis().zze("Unable to normalize conditional user property value", zzgb().zzbk(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzgf().zzis().zze("Invalid conditional user property time to live", zzgb().zzbk(str), Long.valueOf(j2));
                } else {
                    zzge().zzc((Runnable) new zzhs(this, conditionalUserProperty));
                }
            } else {
                zzgf().zzis().zze("Invalid conditional user property timeout", zzgb().zzbk(str), Long.valueOf(j));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            r27 = this;
            r1 = r27
            r8 = r28
            r9 = r29
            r10 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            r27.zzab()
            r27.zzch()
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            boolean r3 = r3.isEnabled()
            if (r3 != 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzfh r2 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziy()
            java.lang.String r3 = "Event not sent since app measurement is disabled"
            r2.log(r3)
            return
        L_0x002d:
            boolean r3 = r1.zzaoc
            r11 = 0
            r12 = 0
            r13 = 1
            if (r3 != 0) goto L_0x0071
            r1.zzaoc = r13
            java.lang.String r3 = "com.google.android.gms.tagmanager.TagManagerService"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0064 }
            java.lang.String r4 = "initialize"
            java.lang.Class[] r5 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x0054 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r12] = r6     // Catch:{ Exception -> 0x0054 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0054 }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0054 }
            android.content.Context r5 = r27.getContext()     // Catch:{ Exception -> 0x0054 }
            r4[r12] = r5     // Catch:{ Exception -> 0x0054 }
            r3.invoke(r11, r4)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0071
        L_0x0054:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.internal.measurement.zzfh r4 = r27.zzgf()     // Catch:{ ClassNotFoundException -> 0x0064 }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziv()     // Catch:{ ClassNotFoundException -> 0x0064 }
            java.lang.String r5 = "Failed to invoke Tag Manager's initialize() method"
            r4.zzg(r5, r3)     // Catch:{ ClassNotFoundException -> 0x0064 }
            goto L_0x0071
        L_0x0064:
            com.google.android.gms.internal.measurement.zzfh r3 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zzix()
            java.lang.String r4 = "Tag Manager is not found and thus will not be used"
            r3.log(r4)
        L_0x0071:
            r3 = 40
            r4 = 2
            if (r35 == 0) goto L_0x00da
            r27.zzgi()
            java.lang.String r5 = "_iap"
            boolean r5 = r5.equals(r9)
            if (r5 != 0) goto L_0x00da
            com.google.android.gms.internal.measurement.zzgm r5 = r1.zzacw
            com.google.android.gms.internal.measurement.zzkc r5 = r5.zzgc()
            java.lang.String r6 = "event"
            boolean r6 = r5.zzq(r6, r9)
            if (r6 != 0) goto L_0x0091
        L_0x008f:
            r5 = 2
            goto L_0x00a8
        L_0x0091:
            java.lang.String r6 = "event"
            java.lang.String[] r7 = com.google.android.gms.measurement.AppMeasurement.Event.zzacx
            boolean r6 = r5.zza((java.lang.String) r6, (java.lang.String[]) r7, (java.lang.String) r9)
            if (r6 != 0) goto L_0x009e
            r5 = 13
            goto L_0x00a8
        L_0x009e:
            java.lang.String r6 = "event"
            boolean r5 = r5.zza((java.lang.String) r6, (int) r3, (java.lang.String) r9)
            if (r5 != 0) goto L_0x00a7
            goto L_0x008f
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            if (r5 == 0) goto L_0x00da
            com.google.android.gms.internal.measurement.zzfh r2 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziu()
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            com.google.android.gms.internal.measurement.zzff r6 = r27.zzgb()
            java.lang.String r6 = r6.zzbi(r9)
            r2.zzg(r4, r6)
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw
            r2.zzgc()
            java.lang.String r2 = com.google.android.gms.internal.measurement.zzkc.zza((java.lang.String) r9, (int) r3, (boolean) r13)
            if (r9 == 0) goto L_0x00ce
            int r12 = r29.length()
        L_0x00ce:
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzkc r3 = r3.zzgc()
            java.lang.String r4 = "_ev"
            r3.zza(r5, r4, r2, r12)
            return
        L_0x00da:
            r27.zzgi()
            com.google.android.gms.internal.measurement.zzig r5 = r27.zzfz()
            com.google.android.gms.internal.measurement.zzif r14 = r5.zzkk()
            if (r14 == 0) goto L_0x00f1
            java.lang.String r5 = "_sc"
            boolean r5 = r10.containsKey(r5)
            if (r5 != 0) goto L_0x00f1
            r14.zzaou = r13
        L_0x00f1:
            if (r33 == 0) goto L_0x00f7
            if (r35 == 0) goto L_0x00f7
            r5 = 1
            goto L_0x00f8
        L_0x00f7:
            r5 = 0
        L_0x00f8:
            com.google.android.gms.internal.measurement.zzig.zza((com.google.android.gms.internal.measurement.zzif) r14, (android.os.Bundle) r10, (boolean) r5)
            java.lang.String r5 = "am"
            boolean r15 = r5.equals(r8)
            boolean r5 = com.google.android.gms.internal.measurement.zzkc.zzch(r29)
            if (r33 == 0) goto L_0x0137
            com.google.android.gms.measurement.AppMeasurement$EventInterceptor r2 = r1.zzaoa
            if (r2 == 0) goto L_0x0137
            if (r5 != 0) goto L_0x0137
            if (r15 != 0) goto L_0x0137
            com.google.android.gms.internal.measurement.zzfh r2 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziy()
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            com.google.android.gms.internal.measurement.zzff r4 = r27.zzgb()
            java.lang.String r4 = r4.zzbi(r9)
            com.google.android.gms.internal.measurement.zzff r5 = r27.zzgb()
            java.lang.String r5 = r5.zzb((android.os.Bundle) r10)
            r2.zze(r3, r4, r5)
            com.google.android.gms.measurement.AppMeasurement$EventInterceptor r2 = r1.zzaoa
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r30
            r2.interceptEvent(r3, r4, r5, r6)
            return
        L_0x0137:
            com.google.android.gms.internal.measurement.zzgm r2 = r1.zzacw
            boolean r2 = r2.zzkd()
            if (r2 != 0) goto L_0x0140
            return
        L_0x0140:
            com.google.android.gms.internal.measurement.zzkc r2 = r27.zzgc()
            int r7 = r2.zzcc(r9)
            if (r7 == 0) goto L_0x017e
            com.google.android.gms.internal.measurement.zzfh r2 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziu()
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            com.google.android.gms.internal.measurement.zzff r5 = r27.zzgb()
            java.lang.String r5 = r5.zzbi(r9)
            r2.zzg(r4, r5)
            r27.zzgc()
            java.lang.String r2 = com.google.android.gms.internal.measurement.zzkc.zza((java.lang.String) r9, (int) r3, (boolean) r13)
            if (r9 == 0) goto L_0x016e
            int r12 = r29.length()
            r10 = r12
            goto L_0x016f
        L_0x016e:
            r10 = 0
        L_0x016f:
            com.google.android.gms.internal.measurement.zzgm r3 = r1.zzacw
            com.google.android.gms.internal.measurement.zzkc r5 = r3.zzgc()
            java.lang.String r8 = "_ev"
            r6 = r36
            r9 = r2
            r5.zza((java.lang.String) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9, (int) r10)
            return
        L_0x017e:
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "_o"
            r2[r12] = r3
            java.lang.String r3 = "_sn"
            r2[r13] = r3
            java.lang.String r3 = "_sc"
            r2[r4] = r3
            r3 = 3
            java.lang.String r4 = "_si"
            r2[r3] = r4
            java.util.List r16 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r2)
            com.google.android.gms.internal.measurement.zzkc r2 = r27.zzgc()
            r7 = 1
            r3 = r9
            r4 = r10
            r5 = r16
            r6 = r35
            android.os.Bundle r7 = r2.zza((java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6, (boolean) r7)
            if (r7 == 0) goto L_0x01d7
            java.lang.String r2 = "_sc"
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x01d7
            java.lang.String r2 = "_si"
            boolean r2 = r7.containsKey(r2)
            if (r2 != 0) goto L_0x01b8
            goto L_0x01d7
        L_0x01b8:
            java.lang.String r2 = "_sn"
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r3 = "_sc"
            java.lang.String r3 = r7.getString(r3)
            java.lang.String r4 = "_si"
            long r4 = r7.getLong(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            com.google.android.gms.internal.measurement.zzif r11 = new com.google.android.gms.internal.measurement.zzif
            long r4 = r4.longValue()
            r11.<init>(r2, r3, r4)
        L_0x01d7:
            if (r11 != 0) goto L_0x01da
            r11 = r14
        L_0x01da:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r7)
            com.google.android.gms.internal.measurement.zzkc r2 = r27.zzgc()
            java.security.SecureRandom r2 = r2.zzll()
            long r5 = r2.nextLong()
            java.util.Set r2 = r7.keySet()
            int r3 = r32.size()
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.Object[] r2 = r2.toArray(r3)
            r10 = r2
            java.lang.String[] r10 = (java.lang.String[]) r10
            java.util.Arrays.sort(r10)
            int r4 = r10.length
            r2 = 0
            r3 = 0
        L_0x0205:
            if (r3 >= r4) goto L_0x02a1
            r12 = r10[r3]
            java.lang.Object r13 = r7.get(r12)
            r27.zzgc()
            android.os.Bundle[] r13 = com.google.android.gms.internal.measurement.zzkc.zze(r13)
            if (r13 == 0) goto L_0x028c
            r17 = r2
            int r2 = r13.length
            r7.putInt(r12, r2)
            r18 = r3
            r2 = 0
        L_0x021f:
            int r3 = r13.length
            if (r2 >= r3) goto L_0x027d
            r3 = r13[r2]
            r19 = r2
            r2 = 1
            com.google.android.gms.internal.measurement.zzig.zza((com.google.android.gms.internal.measurement.zzif) r11, (android.os.Bundle) r3, (boolean) r2)
            com.google.android.gms.internal.measurement.zzkc r2 = r27.zzgc()
            java.lang.String r20 = "_ep"
            r21 = 0
            r22 = r17
            r23 = r19
            r17 = r18
            r18 = r3
            r3 = r20
            r19 = r4
            r4 = r18
            r24 = r5
            r5 = r16
            r6 = r35
            r26 = r10
            r10 = r7
            r7 = r21
            android.os.Bundle r2 = r2.zza((java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6, (boolean) r7)
            java.lang.String r3 = "_en"
            r2.putString(r3, r9)
            java.lang.String r3 = "_eid"
            r4 = r24
            r2.putLong(r3, r4)
            java.lang.String r3 = "_gn"
            r2.putString(r3, r12)
            java.lang.String r3 = "_ll"
            int r6 = r13.length
            r2.putInt(r3, r6)
            java.lang.String r3 = "_i"
            r6 = r23
            r2.putInt(r3, r6)
            r14.add(r2)
            int r2 = r6 + 1
            r5 = r4
            r7 = r10
            r18 = r17
            r4 = r19
            r17 = r22
            r10 = r26
            goto L_0x021f
        L_0x027d:
            r19 = r4
            r4 = r5
            r26 = r10
            r22 = r17
            r17 = r18
            r10 = r7
            int r2 = r13.length
            r12 = r22
            int r2 = r2 + r12
            goto L_0x0295
        L_0x028c:
            r12 = r2
            r17 = r3
            r19 = r4
            r4 = r5
            r26 = r10
            r10 = r7
        L_0x0295:
            int r3 = r17 + 1
            r5 = r4
            r7 = r10
            r4 = r19
            r10 = r26
            r12 = 0
            r13 = 1
            goto L_0x0205
        L_0x02a1:
            r12 = r2
            r4 = r5
            r10 = r7
            if (r12 == 0) goto L_0x02b0
            java.lang.String r2 = "_eid"
            r10.putLong(r2, r4)
            java.lang.String r2 = "_epc"
            r10.putInt(r2, r12)
        L_0x02b0:
            r10 = 0
        L_0x02b1:
            int r2 = r14.size()
            if (r10 >= r2) goto L_0x0330
            java.lang.Object r2 = r14.get(r10)
            android.os.Bundle r2 = (android.os.Bundle) r2
            if (r10 == 0) goto L_0x02c1
            r3 = 1
            goto L_0x02c2
        L_0x02c1:
            r3 = 0
        L_0x02c2:
            if (r3 == 0) goto L_0x02c7
            java.lang.String r3 = "_ep"
            goto L_0x02c8
        L_0x02c7:
            r3 = r9
        L_0x02c8:
            java.lang.String r4 = "_o"
            r2.putString(r4, r8)
            if (r34 == 0) goto L_0x02d7
            com.google.android.gms.internal.measurement.zzkc r4 = r27.zzgc()
            android.os.Bundle r2 = r4.zzd((android.os.Bundle) r2)
        L_0x02d7:
            r11 = r2
            com.google.android.gms.internal.measurement.zzfh r2 = r27.zzgf()
            com.google.android.gms.internal.measurement.zzfj r2 = r2.zziy()
            java.lang.String r4 = "Logging event (FE)"
            com.google.android.gms.internal.measurement.zzff r5 = r27.zzgb()
            java.lang.String r5 = r5.zzbi(r9)
            com.google.android.gms.internal.measurement.zzff r6 = r27.zzgb()
            java.lang.String r6 = r6.zzb((android.os.Bundle) r11)
            r2.zze(r4, r5, r6)
            com.google.android.gms.internal.measurement.zzew r12 = new com.google.android.gms.internal.measurement.zzew
            com.google.android.gms.internal.measurement.zzet r4 = new com.google.android.gms.internal.measurement.zzet
            r4.<init>(r11)
            r2 = r12
            r5 = r8
            r6 = r30
            r2.<init>(r3, r4, r5, r6)
            com.google.android.gms.internal.measurement.zzij r2 = r27.zzfy()
            r13 = r36
            r2.zzb(r12, r13)
            if (r15 != 0) goto L_0x032d
            java.util.Set<com.google.android.gms.measurement.AppMeasurement$OnEventListener> r2 = r1.zzaob
            java.util.Iterator r12 = r2.iterator()
        L_0x0314:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x032d
            java.lang.Object r2 = r12.next()
            com.google.android.gms.measurement.AppMeasurement$OnEventListener r2 = (com.google.android.gms.measurement.AppMeasurement.OnEventListener) r2
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>(r11)
            r3 = r8
            r4 = r9
            r6 = r30
            r2.onEvent(r3, r4, r5, r6)
            goto L_0x0314
        L_0x032d:
            int r10 = r10 + 1
            goto L_0x02b1
        L_0x0330:
            r27.zzgi()
            com.google.android.gms.internal.measurement.zzig r2 = r27.zzfz()
            com.google.android.gms.internal.measurement.zzif r2 = r2.zzkk()
            if (r2 == 0) goto L_0x034d
            java.lang.String r2 = "_ae"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x034d
            com.google.android.gms.internal.measurement.zzji r2 = r27.zzgd()
            r3 = 1
            r2.zzl(r3)
        L_0x034d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhl.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzge().zzc((Runnable) new zzhn(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzb(str, str2, zzbt().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzfs();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzgf().zziy().log("User property not set since app measurement is disabled");
        } else if (this.zzacw.zzkd()) {
            zzgf().zziy().zze("Setting user property (FE)", zzgb().zzbi(str2), obj);
            zzfy().zzb(new zzjz(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzge().zzc((Runnable) new zzht(this, conditionalUserProperty));
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzfj zziv;
        String str4;
        if (zzge().zzjr()) {
            zziv = zzgf().zzis();
            str4 = "Cannot get user properties from analytics worker thread";
        } else if (zzec.isMainThread()) {
            zziv = zzgf().zzis();
            str4 = "Cannot get user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzacw.zzge().zzc((Runnable) new zzhv(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgf().zziv().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjz> list = (List) atomicReference.get();
            if (list == null) {
                zziv = zzgf().zziv();
                str4 = "Timed out waiting for get user properties";
            } else {
                ArrayMap arrayMap = new ArrayMap(list.size());
                for (zzjz zzjz : list) {
                    arrayMap.put(zzjz.name, zzjz.getValue());
                }
                return arrayMap;
            }
        }
        zziv.log(str4);
        return Collections.emptyMap();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty2.mValue);
        if (!this.zzacw.isEnabled()) {
            zzgf().zziy().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzjz zzjz = new zzjz(conditionalUserProperty2.mName, conditionalUserProperty2.mTriggeredTimestamp, conditionalUserProperty2.mValue, conditionalUserProperty2.mOrigin);
        try {
            zzew zza = zzgc().zza(conditionalUserProperty2.mTriggeredEventName, conditionalUserProperty2.mTriggeredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzew zza2 = zzgc().zza(conditionalUserProperty2.mTimedOutEventName, conditionalUserProperty2.mTimedOutEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzew zza3 = zzgc().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            String str = conditionalUserProperty2.mAppId;
            String str2 = conditionalUserProperty2.mOrigin;
            long j = conditionalUserProperty2.mCreationTimestamp;
            String str3 = conditionalUserProperty2.mTriggerEventName;
            long j2 = conditionalUserProperty2.mTriggerTimeout;
            zzee zzee = r3;
            zzee zzee2 = new zzee(str, str2, zzjz, j, false, str3, zza2, j2, zza, conditionalUserProperty2.mTimeToLive, zza3);
            zzfy().zzd(zzee);
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str4 : bundle4.keySet()) {
                Object obj = bundle4.get(str4);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        zzge().zzc((Runnable) new zzid(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        if (!this.zzacw.isEnabled()) {
            zzgf().zziy().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        zzjz zzjz = new zzjz(conditionalUserProperty2.mName, 0, (Object) null, (String) null);
        try {
            zzew zza = zzgc().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, conditionalUserProperty2.mCreationTimestamp, true, false);
            zzee zzee = r3;
            zzee zzee2 = new zzee(conditionalUserProperty2.mAppId, conditionalUserProperty2.mOrigin, zzjz, conditionalUserProperty2.mCreationTimestamp, conditionalUserProperty2.mActive, conditionalUserProperty2.mTriggerEventName, (zzew) null, conditionalUserProperty2.mTriggerTimeout, (zzew) null, conditionalUserProperty2.mTimeToLive, zza);
            zzfy().zzd(zzee);
        } catch (IllegalArgumentException unused) {
        }
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        zzfj zzis;
        String str4;
        if (zzge().zzjr()) {
            zzis = zzgf().zzis();
            str4 = "Cannot get conditional user properties from analytics worker thread";
        } else if (zzec.isMainThread()) {
            zzis = zzgf().zzis();
            str4 = "Cannot get conditional user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzacw.zzge().zzc((Runnable) new zzhu(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgf().zziv().zze("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List<zzee> list = (List) atomicReference.get();
            if (list == null) {
                zzgf().zziv().zzg("Timed out waiting for get conditional user properties", str);
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (zzee zzee : list) {
                AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
                conditionalUserProperty.mAppId = zzee.packageName;
                conditionalUserProperty.mOrigin = zzee.origin;
                conditionalUserProperty.mCreationTimestamp = zzee.creationTimestamp;
                conditionalUserProperty.mName = zzee.zzaeq.name;
                conditionalUserProperty.mValue = zzee.zzaeq.getValue();
                conditionalUserProperty.mActive = zzee.active;
                conditionalUserProperty.mTriggerEventName = zzee.triggerEventName;
                if (zzee.zzaer != null) {
                    conditionalUserProperty.mTimedOutEventName = zzee.zzaer.name;
                    if (zzee.zzaer.zzafr != null) {
                        conditionalUserProperty.mTimedOutEventParams = zzee.zzaer.zzafr.zzij();
                    }
                }
                conditionalUserProperty.mTriggerTimeout = zzee.triggerTimeout;
                if (zzee.zzaes != null) {
                    conditionalUserProperty.mTriggeredEventName = zzee.zzaes.name;
                    if (zzee.zzaes.zzafr != null) {
                        conditionalUserProperty.mTriggeredEventParams = zzee.zzaes.zzafr.zzij();
                    }
                }
                conditionalUserProperty.mTriggeredTimestamp = zzee.zzaeq.zzarl;
                conditionalUserProperty.mTimeToLive = zzee.timeToLive;
                if (zzee.zzaet != null) {
                    conditionalUserProperty.mExpiredEventName = zzee.zzaet.name;
                    if (zzee.zzaet.zzafr != null) {
                        conditionalUserProperty.mExpiredEventParams = zzee.zzaet.zzafr.zzij();
                    }
                }
                arrayList.add(conditionalUserProperty);
            }
            return arrayList;
        }
        zzis.log(str4);
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzi(boolean z) {
        zzab();
        zzfs();
        zzch();
        zzgf().zziy().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgg().setMeasurementEnabled(z);
        if (!zzgh().zzay(zzfw().zzah())) {
            zzfy().zzkm();
        } else if (!this.zzacw.isEnabled() || !this.zzaoe) {
            zzfy().zzkm();
        } else {
            zzgf().zziy().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkj();
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzfs();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzjh = zzgg().zzjh();
            return zzjh != null ? Tasks.forResult(zzjh) : Tasks.call(zzge().zzjs(), new zzhp(this));
        } catch (Exception e) {
            zzgf().zziv().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzfs();
        return zzf((String) null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzf(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzfs();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzb(str, str2, str3, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        zzfs();
        zza(str, str2, bundle, true, this.zzaoa == null || zzkc.zzch(str2), false, (String) null);
    }

    public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzfs();
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzaob.add(onEventListener)) {
            zzgf().zziv().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzge().zzc((Runnable) new zzhr(this, zzbt().currentTimeMillis()));
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzfs();
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzgf().zziv().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(AppMeasurement.EventInterceptor eventInterceptor) {
        zzab();
        zzfs();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == this.zzaoa)) {
            Preconditions.checkState(this.zzaoa == null, "EventInterceptor already set.");
        }
        this.zzaoa = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzch();
        zzfs();
        zzge().zzc((Runnable) new zzia(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzfs();
        zzge().zzc((Runnable) new zzib(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzfs();
        zzge().zzc((Runnable) new zzic(this, j));
    }

    public final void setUserProperty(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzce = zzgc().zzce(str2);
        int i = 0;
        if (zzce != 0) {
            zzgc();
            String zza = zzkc.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzacw.zzgc().zza(zzce, "_ev", zza, i);
        } else if (obj != null) {
            int zzi = zzgc().zzi(str2, obj);
            if (zzi != 0) {
                zzgc();
                String zza2 = zzkc.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzacw.zzgc().zza(zzi, "_ev", zza2, i);
                return;
            }
            Object zzj = zzgc().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzfs();
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzaob.remove(onEventListener)) {
            zzgf().zziv().log("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzfs();
        zzab();
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, this.zzaoa == null || zzkc.zzch(str2), false, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zzfs();
        zzb(str, str2, j, bundle, false, true, true, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zzfs();
        zza(str, str2, bundle, true, this.zzaoa == null || zzkc.zzch(str2), true, (String) null);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzgf().zziv().log("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzae(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzgh r1 = r3.zzge()     // Catch:{ all -> 0x002d }
            com.google.android.gms.internal.measurement.zzhq r2 = new com.google.android.gms.internal.measurement.zzhq     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zzc((java.lang.Runnable) r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.internal.measurement.zzfh r4 = r3.zzgf()     // Catch:{ all -> 0x002d }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zziv()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.log(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhl.zzae(long):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final void zzbq(@Nullable String str) {
        this.zzaod.set(str);
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
        return false;
    }

    public final String zzhq() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzge().zza(atomicReference, 15000, "String test flag value", new zzhw(this, atomicReference));
    }

    public final List<zzjz> zzj(boolean z) {
        zzfj zziv;
        String str;
        zzfs();
        zzch();
        zzgf().zziy().log("Fetching user attributes (FE)");
        if (zzge().zzjr()) {
            zziv = zzgf().zzis();
            str = "Cannot get all user properties from analytics worker thread";
        } else if (zzec.isMainThread()) {
            zziv = zzgf().zzis();
            str = "Cannot get all user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzacw.zzge().zzc((Runnable) new zzho(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgf().zziv().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjz> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zziv = zzgf().zziv();
            str = "Timed out waiting for get user properties";
        }
        zziv.log(str);
        return Collections.emptyList();
    }

    @Nullable
    public final String zzjh() {
        zzfs();
        return this.zzaod.get();
    }

    public final Boolean zzkf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzge().zza(atomicReference, 15000, "boolean test flag value", new zzhm(this, atomicReference));
    }

    public final Long zzkg() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzge().zza(atomicReference, 15000, "long test flag value", new zzhx(this, atomicReference));
    }

    public final Integer zzkh() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzge().zza(atomicReference, 15000, "int test flag value", new zzhy(this, atomicReference));
    }

    public final Double zzki() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzge().zza(atomicReference, 15000, "double test flag value", new zzhz(this, atomicReference));
    }

    @WorkerThread
    public final void zzkj() {
        zzab();
        zzfs();
        zzch();
        if (this.zzacw.zzkd()) {
            zzfy().zzkj();
            this.zzaoe = false;
            String zzjk = zzgg().zzjk();
            if (!TextUtils.isEmpty(zzjk)) {
                zzfx().zzch();
                if (!zzjk.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjk);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }
}
