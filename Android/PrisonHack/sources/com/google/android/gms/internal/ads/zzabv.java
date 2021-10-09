package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.zzbc;
import com.google.android.gms.ads.internal.zzbo;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class zzabv implements Callable<zzajh> {
    @VisibleForTesting
    private static long zzbzx = 10;
    private final Context mContext;
    private int mErrorCode;
    private final Object mLock = new Object();
    private final zzacm zzaad;
    private final zzci zzbjc;
    private final zzaji zzbze;
    private final zzalt zzbzy;
    /* access modifiers changed from: private */
    public final zzbc zzbzz;
    private boolean zzcaa;
    private List<String> zzcab;
    private JSONObject zzcac;
    private String zzcad;
    @Nullable
    private String zzcae;
    private final zznx zzvr;

    public zzabv(Context context, zzbc zzbc, zzalt zzalt, zzci zzci, zzaji zzaji, zznx zznx) {
        this.mContext = context;
        this.zzbzz = zzbc;
        this.zzbzy = zzalt;
        this.zzbze = zzaji;
        this.zzbjc = zzci;
        this.zzvr = zznx;
        this.zzaad = zzbc.zzdr();
        this.zzcaa = false;
        this.mErrorCode = -2;
        this.zzcab = null;
        this.zzcad = null;
        this.zzcae = null;
    }

    /* JADX INFO: finally extract failed */
    private final zzajh zza(zzpb zzpb, boolean z) {
        int i;
        synchronized (this.mLock) {
            try {
                i = (zzpb == null && this.mErrorCode == -2) ? 0 : this.mErrorCode;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        zzpb zzpb2 = i != -2 ? null : zzpb;
        zzjj zzjj = this.zzbze.zzcgs.zzccv;
        List<String> list = this.zzbze.zzcos.zzbsn;
        List<String> list2 = this.zzbze.zzcos.zzbso;
        List<String> list3 = this.zzcab;
        int i2 = this.zzbze.zzcos.orientation;
        long j = this.zzbze.zzcos.zzbsu;
        String str = this.zzbze.zzcgs.zzccy;
        zzjn zzjn = this.zzbze.zzacv;
        long j2 = this.zzbze.zzcos.zzcep;
        List<String> list4 = list;
        long j3 = this.zzbze.zzcoh;
        return new zzajh(zzjj, (zzaqw) null, list4, i, list2, list3, i2, j, str, false, (zzwx) null, (zzxq) null, (String) null, (zzwy) null, (zzxa) null, 0, zzjn, j2, j3, this.zzbze.zzcoi, this.zzbze.zzcos.zzcev, this.zzcac, zzpb2, (zzaig) null, (List<String>) null, (List<String>) null, this.zzbze.zzcos.zzcfh, this.zzbze.zzcos.zzcfi, (String) null, this.zzbze.zzcos.zzbsr, this.zzcad, this.zzbze.zzcoq, this.zzbze.zzcos.zzzl, this.zzbze.zzcor, z, this.zzbze.zzcos.zzbsp, this.zzbze.zzcos.zzzm, this.zzcae);
    }

    private final zzanz<zzon> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? zzano.zzi(new zzon((Drawable) null, Uri.parse(string), optDouble)) : this.zzbzy.zza(string, new zzacb(this, z, optDouble, optBoolean, string));
        }
        zzd(0, z);
        return zzano.zzi(null);
    }

    private final void zzab(int i) {
        synchronized (this.mLock) {
            this.zzcaa = true;
            this.mErrorCode = i;
        }
    }

    private static zzaqw zzb(zzanz<zzaqw> zzanz) {
        try {
            return (zzaqw) zzanz.get((long) ((Integer) zzkb.zzik().zzd(zznk.zzbby)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzane.zzc("", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzane.zzc("", e2);
            return null;
        }
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    static zzaqw zzc(zzanz<zzaqw> zzanz) {
        try {
            return (zzaqw) zzanz.get((long) ((Integer) zzkb.zzik().zzd(zznk.zzbbx)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzakb.zzc("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzakb.zzc("Exception occurred while waiting for video to load", e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzqs zzqs, String str) {
        try {
            zzrc zzr = this.zzbzz.zzr(zzqs.getCustomTemplateId());
            if (zzr != null) {
                zzr.zzb(zzqs, str);
            }
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzakb.zzc(sb.toString(), e);
        }
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzk(List<zzanz<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzanz<V> zzanz : list) {
            Object obj = zzanz.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r3.length() != 0) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0157 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0158 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c2 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f1  */
    /* renamed from: zznw */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzajh call() {
        /*
            r15 = this;
            r0 = 0
            r1 = 0
            com.google.android.gms.ads.internal.zzbc r2 = r15.zzbzz     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r11 = r2.getUuid()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r2 = r15.zznx()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r2 != 0) goto L_0x006e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r3 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaej r3 = r3.zzcos     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r3 = r3.zzceo     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r2.<init>(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r4 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaej r4 = r4.zzcos     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r4 = r4.zzceo     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3.<init>(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            int r4 = r3.length()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = "ads"
            org.json.JSONArray r3 = r3.optJSONArray(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 == 0) goto L_0x0037
            org.json.JSONObject r3 = r3.optJSONObject(r0)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x0038
        L_0x0037:
            r3 = r1
        L_0x0038:
            if (r3 == 0) goto L_0x0040
            int r3 = r3.length()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 != 0) goto L_0x0044
        L_0x0040:
            r3 = 3
            r15.zzab(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        L_0x0044:
            com.google.android.gms.internal.ads.zzacm r3 = r15.zzaad     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzanz r2 = r3.zzh(r2)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            long r3 = zzbzx     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.Object r2 = r2.get(r3, r5)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r3 = "success"
            boolean r3 = r2.optBoolean(r3, r0)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 == 0) goto L_0x006e
            java.lang.String r3 = "json"
            org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r3 = "ads"
            org.json.JSONArray r2 = r2.optJSONArray(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            org.json.JSONObject r2 = r2.getJSONObject(r0)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r8 = r2
            goto L_0x006f
        L_0x006e:
            r8 = r1
        L_0x006f:
            java.lang.String r2 = "enable_omid"
            boolean r2 = r8.optBoolean(r2)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r2 != 0) goto L_0x007d
        L_0x0077:
            com.google.android.gms.internal.ads.zzany r3 = com.google.android.gms.internal.ads.zzano.zzi(r1)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r12 = r3
            goto L_0x00a3
        L_0x007d:
            java.lang.String r3 = "omid_settings"
            org.json.JSONObject r3 = r8.optJSONObject(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 != 0) goto L_0x0086
            goto L_0x0077
        L_0x0086:
            java.lang.String r4 = "omid_html"
            java.lang.String r3 = r3.optString(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r4 == 0) goto L_0x0093
            goto L_0x0077
        L_0x0093:
            com.google.android.gms.internal.ads.zzaoj r4 = new com.google.android.gms.internal.ads.zzaoj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r4.<init>()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.util.concurrent.Executor r5 = com.google.android.gms.internal.ads.zzaoe.zzcvy     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzabw r6 = new com.google.android.gms.internal.ads.zzabw     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r6.<init>(r15, r4, r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r5.execute(r6)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r12 = r4
        L_0x00a3:
            boolean r3 = r15.zznx()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 != 0) goto L_0x014c
            if (r8 != 0) goto L_0x00ad
            goto L_0x014c
        L_0x00ad:
            java.lang.String r3 = "template_id"
            java.lang.String r3 = r8.getString(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r4 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaef r4 = r4.zzcgs     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpl r4 = r4.zzadj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r4 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzaji r4 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaef r4 = r4.zzcgs     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpl r4 = r4.zzadj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r4 = r4.zzbjn     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x00c5
        L_0x00c4:
            r4 = 0
        L_0x00c5:
            com.google.android.gms.internal.ads.zzaji r5 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaef r5 = r5.zzcgs     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpl r5 = r5.zzadj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r5 == 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzaji r5 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaef r5 = r5.zzcgs     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpl r5 = r5.zzadj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r5 = r5.zzbjp     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x00d7
        L_0x00d6:
            r5 = 0
        L_0x00d7:
            java.lang.String r6 = "2"
            boolean r6 = r6.equals(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r6 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzacn r3 = new com.google.android.gms.internal.ads.zzacn     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r6 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r6 = r6.zzcor     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3.<init>(r4, r5, r6)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x014d
        L_0x00e9:
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r6 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzaco r3 = new com.google.android.gms.internal.ads.zzaco     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r6 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            boolean r6 = r6.zzcor     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3.<init>(r4, r5, r6)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x014d
        L_0x00fb:
            java.lang.String r5 = "3"
            boolean r3 = r5.equals(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 == 0) goto L_0x0149
            java.lang.String r3 = "custom_template_id"
            java.lang.String r3 = r8.getString(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaoj r5 = new com.google.android.gms.internal.ads.zzaoj     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r5.<init>()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            android.os.Handler r6 = com.google.android.gms.internal.ads.zzakk.zzcrm     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaby r7 = new com.google.android.gms.internal.ads.zzaby     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r7.<init>(r15, r5, r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r6.post(r7)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            long r6 = zzbzx     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.Object r3 = r5.get(r6, r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 == 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzacp r3 = new com.google.android.gms.internal.ads.zzacp     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3.<init>(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x014d
        L_0x0128:
            java.lang.String r3 = "No handler for custom template: "
            java.lang.String r4 = "custom_template_id"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            int r5 = r4.length()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r5 == 0) goto L_0x013f
            java.lang.String r3 = r3.concat(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x0145
        L_0x013f:
            java.lang.String r4 = new java.lang.String     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r4.<init>(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3 = r4
        L_0x0145:
            com.google.android.gms.internal.ads.zzakb.m40e(r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x014c
        L_0x0149:
            r15.zzab(r0)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        L_0x014c:
            r3 = r1
        L_0x014d:
            boolean r4 = r15.zznx()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r4 != 0) goto L_0x01bd
            if (r3 == 0) goto L_0x01bd
            if (r8 != 0) goto L_0x0158
            goto L_0x01bd
        L_0x0158:
            java.lang.String r4 = "tracking_urls_and_actions"
            org.json.JSONObject r4 = r8.getJSONObject(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r5 = "impression_tracking_urls"
            org.json.JSONArray r5 = r4.optJSONArray(r5)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r5 != 0) goto L_0x0168
            r6 = r1
            goto L_0x017e
        L_0x0168:
            int r6 = r5.length()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r7 = 0
        L_0x016f:
            int r9 = r5.length()     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r7 >= r9) goto L_0x017e
            java.lang.String r9 = r5.getString(r7)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r6[r7] = r9     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            int r7 = r7 + 1
            goto L_0x016f
        L_0x017e:
            if (r6 != 0) goto L_0x0182
            r5 = r1
            goto L_0x0186
        L_0x0182:
            java.util.List r5 = java.util.Arrays.asList(r6)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        L_0x0186:
            r15.zzcab = r5     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r5 = "active_view"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r15.zzcac = r4     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r4 = "debug_signals"
            java.lang.String r4 = r8.optString(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r15.zzcad = r4     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r4 = "omid_settings"
            java.lang.String r4 = r8.optString(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r15.zzcae = r4     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpb r13 = r3.zza(r15, r8)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzpd r14 = new com.google.android.gms.internal.ads.zzpd     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            android.content.Context r4 = r15.mContext     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.ads.internal.zzbc r5 = r15.zzbzz     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzacm r6 = r15.zzaad     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzci r7 = r15.zzbjc     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaji r3 = r15.zzbze     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaef r3 = r3.zzcgs     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzang r10 = r3.zzacr     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3 = r14
            r9 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r13.zzb(r14)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            goto L_0x01be
        L_0x01bd:
            r13 = r1
        L_0x01be:
            boolean r3 = r13 instanceof com.google.android.gms.internal.ads.zzos     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            if (r3 == 0) goto L_0x01d1
            r3 = r13
            com.google.android.gms.internal.ads.zzos r3 = (com.google.android.gms.internal.ads.zzos) r3     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzabz r4 = new com.google.android.gms.internal.ads.zzabz     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r4.<init>(r15, r3)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzacm r3 = r15.zzaad     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            java.lang.String r5 = "/nativeAdCustomClick"
            r3.zza((java.lang.String) r5, r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        L_0x01d1:
            com.google.android.gms.internal.ads.zzajh r2 = r15.zza((com.google.android.gms.internal.ads.zzpb) r13, (boolean) r2)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.ads.internal.zzbc r3 = r15.zzbzz     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            com.google.android.gms.internal.ads.zzaqw r4 = zzb(r12)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            r3.zzg(r4)     // Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
            return r2
        L_0x01df:
            r2 = move-exception
            java.lang.String r3 = "Error occured while doing native ads initialization."
            goto L_0x01ea
        L_0x01e3:
            r2 = move-exception
            java.lang.String r3 = "Timeout when loading native ad."
            goto L_0x01ea
        L_0x01e7:
            r2 = move-exception
            java.lang.String r3 = "Malformed native JSON response."
        L_0x01ea:
            com.google.android.gms.internal.ads.zzakb.zzc(r3, r2)
            boolean r2 = r15.zzcaa
            if (r2 != 0) goto L_0x01f4
            r15.zzab(r0)
        L_0x01f4:
            com.google.android.gms.internal.ads.zzajh r0 = r15.zza((com.google.android.gms.internal.ads.zzpb) r1, (boolean) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabv.call():com.google.android.gms.internal.ads.zzajh");
    }

    private final boolean zznx() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcaa;
        }
        return z;
    }

    public final zzanz<zzon> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzanz<zzon>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zzd(0, false);
            return arrayList;
        }
        int length = z3 ? optJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, false, z2));
        }
        return arrayList;
    }

    public final Future<zzon> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaoj zzaoj, String str) {
        try {
            zzbv.zzel();
            zzaqw zza = zzarc.zza(this.mContext, zzasi.zzvq(), "native-omid", false, false, this.zzbjc, this.zzbze.zzcgs.zzacr, this.zzvr, (zzbo) null, this.zzbzz.zzbi(), this.zzbze.zzcoq);
            zza.zzuf().zza((zzasd) new zzabx(zzaoj, zza));
            zza.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            zzaoj.set(null);
            zzane.zzc("", e);
        }
    }

    public final zzanz<zzaqw> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzano.zzi(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzakb.zzdk("Required field 'vast_xml' is missing");
            return zzano.zzi(null);
        }
        zzace zzace = new zzace(this.mContext, this.zzbjc, this.zzbze, this.zzvr, this.zzbzz);
        zzaoj zzaoj = new zzaoj();
        zzaoe.zzcvy.execute(new zzacf(zzace, optJSONObject, zzaoj));
        return zzaoj;
    }

    public final void zzd(int i, boolean z) {
        if (z) {
            zzab(i);
        }
    }

    public final zzanz<zzoj> zzg(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzano.zzi(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.zzbze.zzcgs.zzadj == null || this.zzbze.zzcgs.zzadj.versionCode < 2) ? 1 : this.zzbze.zzcgs.zzadj.zzbjq;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List<zzanz> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        zzaoj zzaoj = new zzaoj();
        int size = arrayList.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzanz zza : arrayList) {
            zza.zza(new zzacc(atomicInteger, size, zzaoj, arrayList), zzaki.zzcrj);
            arrayList = arrayList;
        }
        return zzano.zza(zzaoj, new zzaca(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), (Executor) zzaki.zzcrj);
    }
}
