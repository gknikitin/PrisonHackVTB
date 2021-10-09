package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzafa;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzajl;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzakk;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaoe;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzgk;
import com.google.android.gms.internal.ads.zzhu;
import com.google.android.gms.internal.ads.zzhx;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzkb;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxn;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public abstract class zzd extends zza implements zzn, zzbo, zzwz {
    protected final zzxn zzwh;
    private transient boolean zzwi;

    public zzd(Context context, zzjn zzjn, String str, zzxn zzxn, zzang zzang, zzw zzw) {
        this(new zzbw(context, zzjn, str, zzang), zzxn, (zzbl) null, zzw);
    }

    @VisibleForTesting
    private zzd(zzbw zzbw, zzxn zzxn, @Nullable zzbl zzbl, zzw zzw) {
        super(zzbw, (zzbl) null, zzw);
        this.zzwh = zzxn;
        this.zzwi = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzaeg zza(com.google.android.gms.internal.ads.zzjj r65, android.os.Bundle r66, com.google.android.gms.internal.ads.zzajl r67, int r68) {
        /*
            r64 = this;
            r0 = r64
            com.google.android.gms.ads.internal.zzbw r1 = r0.zzvw
            android.content.Context r1 = r1.zzrt
            android.content.pm.ApplicationInfo r7 = r1.getApplicationInfo()
            r2 = 0
            com.google.android.gms.ads.internal.zzbw r3 = r0.zzvw     // Catch:{ NameNotFoundException -> 0x001b }
            android.content.Context r3 = r3.zzrt     // Catch:{ NameNotFoundException -> 0x001b }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x001b }
            java.lang.String r4 = r7.packageName     // Catch:{ NameNotFoundException -> 0x001b }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r2)     // Catch:{ NameNotFoundException -> 0x001b }
            r8 = r3
            goto L_0x001c
        L_0x001b:
            r8 = 0
        L_0x001c:
            com.google.android.gms.ads.internal.zzbw r3 = r0.zzvw
            android.content.Context r3 = r3.zzrt
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r4 = r4.zzacs
            if (r4 == 0) goto L_0x0093
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r4 = r4.zzacs
            android.view.ViewParent r4 = r4.getParent()
            if (r4 == 0) goto L_0x0093
            r4 = 2
            int[] r4 = new int[r4]
            com.google.android.gms.ads.internal.zzbw r5 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r5 = r5.zzacs
            r5.getLocationOnScreen(r4)
            r5 = r4[r2]
            r6 = 1
            r4 = r4[r6]
            com.google.android.gms.ads.internal.zzbw r9 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r9 = r9.zzacs
            int r9 = r9.getWidth()
            com.google.android.gms.ads.internal.zzbw r10 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r10 = r10.zzacs
            int r10 = r10.getHeight()
            com.google.android.gms.ads.internal.zzbw r11 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r11 = r11.zzacs
            boolean r11 = r11.isShown()
            if (r11 == 0) goto L_0x0072
            int r11 = r5 + r9
            if (r11 <= 0) goto L_0x0072
            int r11 = r4 + r10
            if (r11 <= 0) goto L_0x0072
            int r11 = r3.widthPixels
            if (r5 > r11) goto L_0x0072
            int r11 = r3.heightPixels
            if (r4 > r11) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r6 = 0
        L_0x0073:
            android.os.Bundle r11 = new android.os.Bundle
            r12 = 5
            r11.<init>(r12)
            java.lang.String r12 = "x"
            r11.putInt(r12, r5)
            java.lang.String r5 = "y"
            r11.putInt(r5, r4)
            java.lang.String r4 = "width"
            r11.putInt(r4, r9)
            java.lang.String r4 = "height"
            r11.putInt(r4, r10)
            java.lang.String r4 = "visible"
            r11.putInt(r4, r6)
            goto L_0x0094
        L_0x0093:
            r11 = 0
        L_0x0094:
            com.google.android.gms.internal.ads.zzajm r4 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzajt r4 = r4.zzpx()
            java.lang.String r9 = r4.zzql()
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            com.google.android.gms.internal.ads.zzajj r5 = new com.google.android.gms.internal.ads.zzajj
            com.google.android.gms.ads.internal.zzbw r6 = r0.zzvw
            java.lang.String r6 = r6.zzacp
            r5.<init>(r9, r6)
            r4.zzacy = r5
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            com.google.android.gms.internal.ads.zzajj r4 = r4.zzacy
            r5 = r65
            r4.zzn(r5)
            com.google.android.gms.ads.internal.zzbv.zzek()
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            android.content.Context r4 = r4.zzrt
            com.google.android.gms.ads.internal.zzbw r6 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r6 = r6.zzacs
            com.google.android.gms.ads.internal.zzbw r10 = r0.zzvw
            com.google.android.gms.internal.ads.zzjn r10 = r10.zzacv
            java.lang.String r20 = com.google.android.gms.internal.ads.zzakk.zza((android.content.Context) r4, (android.view.View) r6, (com.google.android.gms.internal.ads.zzjn) r10)
            r12 = 0
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            com.google.android.gms.internal.ads.zzlg r4 = r4.zzadd
            if (r4 == 0) goto L_0x00e1
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw     // Catch:{ RemoteException -> 0x00dc }
            com.google.android.gms.internal.ads.zzlg r4 = r4.zzadd     // Catch:{ RemoteException -> 0x00dc }
            long r14 = r4.getValue()     // Catch:{ RemoteException -> 0x00dc }
            r21 = r14
            goto L_0x00e3
        L_0x00dc:
            java.lang.String r4 = "Cannot get correlation id, default to 0."
            com.google.android.gms.internal.ads.zzakb.zzdk(r4)
        L_0x00e1:
            r21 = r12
        L_0x00e3:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r23 = r4.toString()
            com.google.android.gms.internal.ads.zzajv r4 = com.google.android.gms.ads.internal.zzbv.zzep()
            com.google.android.gms.ads.internal.zzbw r6 = r0.zzvw
            android.content.Context r6 = r6.zzrt
            android.os.Bundle r12 = r4.zza(r6, r0, r9)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r4 = 0
        L_0x0102:
            com.google.android.gms.ads.internal.zzbw r6 = r0.zzvw
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.internal.ads.zzrf> r6 = r6.zzadi
            int r6 = r6.size()
            if (r4 >= r6) goto L_0x0133
            com.google.android.gms.ads.internal.zzbw r6 = r0.zzvw
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.internal.ads.zzrf> r6 = r6.zzadi
            java.lang.Object r6 = r6.keyAt(r4)
            java.lang.String r6 = (java.lang.String) r6
            r14.add(r6)
            com.google.android.gms.ads.internal.zzbw r10 = r0.zzvw
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.internal.ads.zzrc> r10 = r10.zzadh
            boolean r10 = r10.containsKey(r6)
            if (r10 == 0) goto L_0x0130
            com.google.android.gms.ads.internal.zzbw r10 = r0.zzvw
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.internal.ads.zzrc> r10 = r10.zzadh
            java.lang.Object r10 = r10.get(r6)
            if (r10 == 0) goto L_0x0130
            r15.add(r6)
        L_0x0130:
            int r4 = r4 + 1
            goto L_0x0102
        L_0x0133:
            com.google.android.gms.ads.internal.zzg r4 = new com.google.android.gms.ads.internal.zzg
            r4.<init>(r0)
            com.google.android.gms.internal.ads.zzanz r34 = com.google.android.gms.internal.ads.zzaki.zza(r4)
            com.google.android.gms.ads.internal.zzh r4 = new com.google.android.gms.ads.internal.zzh
            r4.<init>(r0)
            com.google.android.gms.internal.ads.zzanz r44 = com.google.android.gms.internal.ads.zzaki.zza(r4)
            if (r67 == 0) goto L_0x014e
            java.lang.String r4 = r67.zzpu()
            r35 = r4
            goto L_0x0150
        L_0x014e:
            r35 = 0
        L_0x0150:
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            java.util.List<java.lang.String> r4 = r4.zzads
            if (r4 == 0) goto L_0x01a8
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            java.util.List<java.lang.String> r4 = r4.zzads
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x01a8
            if (r8 == 0) goto L_0x0164
            int r2 = r8.versionCode
        L_0x0164:
            com.google.android.gms.internal.ads.zzajm r4 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r4 = r4.zzqh()
            int r4 = r4.zzqz()
            if (r2 <= r4) goto L_0x0189
            com.google.android.gms.internal.ads.zzajm r4 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r4 = r4.zzqh()
            r4.zzrf()
            com.google.android.gms.internal.ads.zzajm r4 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r4 = r4.zzqh()
            r4.zzae((int) r2)
            goto L_0x01a8
        L_0x0189:
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r2 = r2.zzqh()
            org.json.JSONObject r2 = r2.zzre()
            if (r2 == 0) goto L_0x01a8
            com.google.android.gms.ads.internal.zzbw r4 = r0.zzvw
            java.lang.String r4 = r4.zzacp
            org.json.JSONArray r2 = r2.optJSONArray(r4)
            if (r2 == 0) goto L_0x01a8
            java.lang.String r2 = r2.toString()
            r46 = r2
            goto L_0x01aa
        L_0x01a8:
            r46 = 0
        L_0x01aa:
            com.google.android.gms.internal.ads.zzaeg r53 = new com.google.android.gms.internal.ads.zzaeg
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            com.google.android.gms.internal.ads.zzjn r6 = r2.zzacv
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            java.lang.String r10 = r2.zzacp
            java.lang.String r13 = com.google.android.gms.internal.ads.zzkb.zzih()
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            com.google.android.gms.internal.ads.zzang r4 = r2.zzacr
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            java.util.List<java.lang.String> r2 = r2.zzads
            com.google.android.gms.internal.ads.zzajm r1 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r1 = r1.zzqh()
            boolean r16 = r1.zzqt()
            int r1 = r3.widthPixels
            r54 = r1
            int r1 = r3.heightPixels
            float r3 = r3.density
            java.util.List r24 = com.google.android.gms.internal.ads.zznk.zzjb()
            r55 = r2
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            java.lang.String r2 = r2.zzaco
            r56 = r2
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            com.google.android.gms.internal.ads.zzpl r2 = r2.zzadj
            r57 = r2
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            java.lang.String r27 = r2.zzfq()
            com.google.android.gms.internal.ads.zzalb r2 = com.google.android.gms.ads.internal.zzbv.zzfj()
            float r28 = r2.zzdo()
            com.google.android.gms.internal.ads.zzalb r2 = com.google.android.gms.ads.internal.zzbv.zzfj()
            boolean r29 = r2.zzdp()
            com.google.android.gms.ads.internal.zzbv.zzek()
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            android.content.Context r2 = r2.zzrt
            int r30 = com.google.android.gms.internal.ads.zzakk.zzas(r2)
            com.google.android.gms.ads.internal.zzbv.zzek()
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            com.google.android.gms.ads.internal.zzbx r2 = r2.zzacs
            int r31 = com.google.android.gms.internal.ads.zzakk.zzx(r2)
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            android.content.Context r2 = r2.zzrt
            boolean r2 = r2 instanceof android.app.Activity
            r58 = r2
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r2 = r2.zzqh()
            boolean r33 = r2.zzqy()
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            boolean r36 = r2.zzqa()
            com.google.android.gms.internal.ads.zzaqg r2 = com.google.android.gms.ads.internal.zzbv.zzff()
            int r37 = r2.zztx()
            com.google.android.gms.ads.internal.zzbv.zzek()
            android.os.Bundle r38 = com.google.android.gms.internal.ads.zzakk.zzrk()
            com.google.android.gms.internal.ads.zzalk r2 = com.google.android.gms.ads.internal.zzbv.zzeu()
            java.lang.String r39 = r2.zzrw()
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            com.google.android.gms.internal.ads.zzlu r2 = r2.zzadl
            r59 = r2
            com.google.android.gms.internal.ads.zzalk r2 = com.google.android.gms.ads.internal.zzbv.zzeu()
            boolean r41 = r2.zzrx()
            com.google.android.gms.internal.ads.zzua r2 = com.google.android.gms.internal.ads.zzua.zzlk()
            android.os.Bundle r42 = r2.zzlt()
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r2 = r2.zzqh()
            r60 = r3
            com.google.android.gms.ads.internal.zzbw r3 = r0.zzvw
            java.lang.String r3 = r3.zzacp
            boolean r43 = r2.zzcr(r3)
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            java.util.List<java.lang.Integer> r3 = r2.zzadn
            com.google.android.gms.ads.internal.zzbw r2 = r0.zzvw
            android.content.Context r2 = r2.zzrt
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2)
            boolean r49 = r2.isCallerInstantApp()
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            boolean r50 = r2.zzqb()
            com.google.android.gms.ads.internal.zzbv.zzem()
            boolean r51 = com.google.android.gms.internal.ads.zzakq.zzrp()
            com.google.android.gms.internal.ads.zzajm r2 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzanz r2 = r2.zzqi()
            r62 = r3
            r61 = r4
            r3 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            r63 = r15
            r15 = 0
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzano.zza(r2, r15, (long) r3, (java.util.concurrent.TimeUnit) r0)
            r52 = r0
            java.util.ArrayList r52 = (java.util.ArrayList) r52
            r0 = r55
            r25 = r56
            r26 = r57
            r32 = r58
            r40 = r59
            r2 = r53
            r19 = r60
            r45 = r62
            r3 = r11
            r11 = r61
            r4 = r5
            r5 = r6
            r6 = r10
            r10 = r13
            r13 = r0
            r0 = r63
            r15 = r66
            r17 = r54
            r18 = r1
            r47 = r0
            r48 = r68
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            return r53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.zza(com.google.android.gms.internal.ads.zzjj, android.os.Bundle, com.google.android.gms.internal.ads.zzajl, int):com.google.android.gms.internal.ads.zzaeg");
    }

    @Nullable
    static String zzc(zzajh zzajh) {
        if (zzajh == null) {
            return null;
        }
        String str = zzajh.zzbty;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzajh.zzbtw != null) {
            try {
                return new JSONObject(zzajh.zzbtw.zzbsb).getString("class_name");
            } catch (NullPointerException | JSONException unused) {
            }
        }
        return str;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        if (this.zzvw.zzacw == null) {
            return null;
        }
        return this.zzvw.zzacw.zzbty;
    }

    public void onAdClicked() {
        if (this.zzvw.zzacw == null) {
            zzakb.zzdk("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzvw.zzacw.zzcod == null || this.zzvw.zzacw.zzcod.zzbsn == null)) {
            zzbv.zzfd();
            zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, this.zzvw.zzacw, this.zzvw.zzacp, false, zzc(this.zzvw.zzacw.zzcod.zzbsn));
        }
        if (!(this.zzvw.zzacw.zzbtw == null || this.zzvw.zzacw.zzbtw.zzbrw == null)) {
            zzbv.zzfd();
            zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, this.zzvw.zzacw, this.zzvw.zzacp, false, this.zzvw.zzacw.zzbtw.zzbrw);
        }
        super.onAdClicked();
    }

    public final void onPause() {
        this.zzvy.zzj(this.zzvw.zzacw);
    }

    public final void onResume() {
        this.zzvy.zzk(this.zzvw.zzacw);
    }

    public void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (!(this.zzvw.zzacw == null || this.zzvw.zzacw.zzbyo == null || !this.zzvw.zzfo())) {
            zzbv.zzem();
            zzakq.zzi(this.zzvw.zzacw.zzbyo);
        }
        if (!(this.zzvw.zzacw == null || this.zzvw.zzacw.zzbtx == null)) {
            try {
                this.zzvw.zzacw.zzbtx.pause();
            } catch (RemoteException unused) {
                zzakb.zzdk("Could not pause mediation adapter.");
            }
        }
        this.zzvy.zzj(this.zzvw.zzacw);
        this.zzvv.pause();
    }

    public final void recordImpression() {
        zza(this.zzvw.zzacw, false);
    }

    public void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzaqw zzaqw = (this.zzvw.zzacw == null || this.zzvw.zzacw.zzbyo == null) ? null : this.zzvw.zzacw.zzbyo;
        if (zzaqw != null && this.zzvw.zzfo()) {
            zzbv.zzem();
            zzakq.zzj(this.zzvw.zzacw.zzbyo);
        }
        if (!(this.zzvw.zzacw == null || this.zzvw.zzacw.zzbtx == null)) {
            try {
                this.zzvw.zzacw.zzbtx.resume();
            } catch (RemoteException unused) {
                zzakb.zzdk("Could not resume mediation adapter.");
            }
        }
        if (zzaqw == null || !zzaqw.zzum()) {
            this.zzvv.resume();
        }
        this.zzvy.zzk(this.zzvw.zzacw);
    }

    public void showInterstitial() {
        zzakb.zzdk("showInterstitial is not supported for current ad type");
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable zzajh zzajh, boolean z) {
        if (zzajh == null) {
            zzakb.zzdk("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzajh == null) {
            zzakb.zzdk("Ad state was null when trying to ping impression URLs.");
        } else {
            zzakb.zzck("Pinging Impression URLs.");
            if (this.zzvw.zzacy != null) {
                this.zzvw.zzacy.zzpm();
            }
            zzajh.zzcoq.zza(zzhu.zza.zzb.AD_IMPRESSION);
            if (zzajh.zzbso != null && !zzajh.zzcok) {
                zzbv.zzek();
                zzakk.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzc(zzajh.zzbso));
                zzajh.zzcok = true;
            }
        }
        if (!zzajh.zzcom || z) {
            if (!(zzajh.zzcod == null || zzajh.zzcod.zzbso == null)) {
                zzbv.zzfd();
                zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, z, zzc(zzajh.zzcod.zzbso));
            }
            if (!(zzajh.zzbtw == null || zzajh.zzbtw.zzbrx == null)) {
                zzbv.zzfd();
                zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, z, zzajh.zzbtw.zzbrx);
            }
            zzajh.zzcom = true;
        }
    }

    public final void zza(zzqs zzqs, String str) {
        String str2;
        zzrc zzrc = null;
        if (zzqs != null) {
            try {
                str2 = zzqs.getCustomTemplateId();
            } catch (RemoteException e) {
                zzakb.zzc("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            str2 = null;
        }
        if (!(this.zzvw.zzadh == null || str2 == null)) {
            zzrc = this.zzvw.zzadh.get(str2);
        }
        if (zzrc == null) {
            zzakb.zzdk("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzrc.zzb(zzqs, str);
        }
    }

    public final boolean zza(zzaeg zzaeg, zznx zznx) {
        this.zzvr = zznx;
        zznx.zze("seq_num", zzaeg.zzccy);
        zznx.zze("request_id", zzaeg.zzcdi);
        zznx.zze("session_id", zzaeg.zzccz);
        if (zzaeg.zzccw != null) {
            zznx.zze("app_version", String.valueOf(zzaeg.zzccw.versionCode));
        }
        zzbw zzbw = this.zzvw;
        zzbv.zzeg();
        Context context = this.zzvw.zzrt;
        zzhx zzhx = this.zzwc.zzxb;
        zzajx zzafa = zzaeg.zzccv.extras.getBundle("sdk_less_server_data") != null ? new zzafa(context, zzaeg, this, zzhx) : new zzadk(context, zzaeg, this, zzhx);
        zzafa.zzqo();
        zzbw.zzact = zzafa;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzajh zzajh) {
        zzjj zzjj;
        boolean z = false;
        if (this.zzvx != null) {
            zzjj = this.zzvx;
            this.zzvx = null;
        } else {
            zzjj = zzajh.zzccv;
            if (zzjj.extras != null) {
                z = zzjj.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzjj, zzajh, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(@Nullable zzajh zzajh, zzajh zzajh2) {
        int i;
        if (!(zzajh == null || zzajh.zzbtz == null)) {
            zzajh.zzbtz.zza((zzwz) null);
        }
        if (zzajh2.zzbtz != null) {
            zzajh2.zzbtz.zza((zzwz) this);
        }
        int i2 = 0;
        if (zzajh2.zzcod != null) {
            i2 = zzajh2.zzcod.zzbtc;
            i = zzajh2.zzcod.zzbtd;
        } else {
            i = 0;
        }
        this.zzvw.zzadt.zze(i2, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzjj zzjj, zzajh zzajh, boolean z) {
        zzbl zzbl;
        long j;
        if (!z && this.zzvw.zzfo()) {
            if (zzajh.zzbsu > 0) {
                zzbl = this.zzvv;
                j = zzajh.zzbsu;
            } else if (zzajh.zzcod != null && zzajh.zzcod.zzbsu > 0) {
                zzbl = this.zzvv;
                j = zzajh.zzcod.zzbsu;
            } else if (!zzajh.zzceq && zzajh.errorCode == 2) {
                this.zzvv.zzg(zzjj);
            }
            zzbl.zza(zzjj, j);
        }
        return this.zzvv.zzdz();
    }

    public boolean zza(zzjj zzjj, zznx zznx) {
        return zza(zzjj, zznx, 1);
    }

    public final boolean zza(zzjj zzjj, zznx zznx, int i) {
        zzajl zzajl;
        if (!zzca()) {
            return false;
        }
        zzbv.zzek();
        zzgk zzaf = zzbv.zzeo().zzaf(this.zzvw.zzrt);
        String str = null;
        Bundle zza = zzaf == null ? null : zzakk.zza(zzaf);
        this.zzvv.cancel();
        this.zzvw.zzadv = 0;
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbcs)).booleanValue()) {
            zzajl = zzbv.zzeo().zzqh().zzra();
            zzad zzes = zzbv.zzes();
            Context context = this.zzvw.zzrt;
            zzang zzang = this.zzvw.zzacr;
            String str2 = this.zzvw.zzacp;
            if (zzajl != null) {
                str = zzajl.zzpv();
            }
            zzes.zza(context, zzang, false, zzajl, str, str2, (Runnable) null);
        } else {
            zzajl = null;
        }
        return zza(zza(zzjj, zza, zzajl, i), zznx);
    }

    public final void zzb(zzajh zzajh) {
        super.zzb(zzajh);
        if (zzajh.zzbtw != null) {
            zzakb.zzck("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzvw.zzacs != null) {
                this.zzvw.zzacs.zzfu();
            }
            zzakb.zzck("Pinging network fill URLs.");
            zzbv.zzfd();
            zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, false, zzajh.zzbtw.zzbsa);
            if (!(zzajh.zzcod == null || zzajh.zzcod.zzbsr == null || zzajh.zzcod.zzbsr.size() <= 0)) {
                zzakb.zzck("Pinging urls remotely");
                zzbv.zzek().zza(this.zzvw.zzrt, zzajh.zzcod.zzbsr);
            }
        } else {
            zzakb.zzck("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzvw.zzacs != null) {
                this.zzvw.zzacs.zzft();
            }
        }
        if (zzajh.errorCode == 3 && zzajh.zzcod != null && zzajh.zzcod.zzbsq != null) {
            zzakb.zzck("Pinging no fill URLs.");
            zzbv.zzfd();
            zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, false, zzajh.zzcod.zzbsq);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(@Nullable zzajh zzajh, boolean z) {
        if (zzajh != null) {
            if (!(zzajh == null || zzajh.zzbsp == null || zzajh.zzcol)) {
                zzbv.zzek();
                zzakk.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzb(zzajh.zzbsp));
                zzajh.zzcol = true;
            }
            if (!zzajh.zzcon || z) {
                if (!(zzajh.zzcod == null || zzajh.zzcod.zzbsp == null)) {
                    zzbv.zzfd();
                    zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, z, zzb(zzajh.zzcod.zzbsp));
                }
                if (!(zzajh.zzbtw == null || zzajh.zzbtw.zzbry == null)) {
                    zzbv.zzfd();
                    zzxg.zza(this.zzvw.zzrt, this.zzvw.zzacr.zzcw, zzajh, this.zzvw.zzacp, z, zzajh.zzbtw.zzbry);
                }
                zzajh.zzcon = true;
            }
        }
    }

    public final void zzb(String str, String str2) {
        onAppEvent(str, str2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzc(zzjj zzjj) {
        return super.zzc(zzjj) && !this.zzwi;
    }

    /* access modifiers changed from: protected */
    public boolean zzca() {
        zzbv.zzek();
        if (!zzakk.zzl(this.zzvw.zzrt, "android.permission.INTERNET")) {
            return false;
        }
        zzbv.zzek();
        return zzakk.zzaj(this.zzvw.zzrt);
    }

    public void zzcb() {
        this.zzwi = false;
        zzbn();
        this.zzvw.zzacy.zzpo();
    }

    public void zzcc() {
        this.zzwi = true;
        zzbp();
    }

    public void zzcd() {
        zzakb.zzdk("Mediated ad does not support onVideoEnd callback");
    }

    public void zzce() {
        onAdClicked();
    }

    public final void zzcf() {
        zzcb();
    }

    public final void zzcg() {
        zzbo();
    }

    public final void zzch() {
        zzcc();
    }

    public final void zzci() {
        if (this.zzvw.zzacw != null) {
            String str = this.zzvw.zzacw.zzbty;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Mediation adapter ");
            sb.append(str);
            sb.append(" refreshed, but mediation adapters should never refresh.");
            zzakb.zzdk(sb.toString());
        }
        zza(this.zzvw.zzacw, true);
        zzb(this.zzvw.zzacw, true);
        zzbq();
    }

    public void zzcj() {
        recordImpression();
    }

    @Nullable
    public final String zzck() {
        if (this.zzvw.zzacw == null) {
            return null;
        }
        return zzc(this.zzvw.zzacw);
    }

    public final void zzcl() {
        Executor executor = zzaoe.zzcvy;
        zzbl zzbl = this.zzvv;
        zzbl.getClass();
        executor.execute(zze.zza(zzbl));
    }

    public final void zzcm() {
        Executor executor = zzaoe.zzcvy;
        zzbl zzbl = this.zzvv;
        zzbl.getClass();
        executor.execute(zzf.zza(zzbl));
    }
}
