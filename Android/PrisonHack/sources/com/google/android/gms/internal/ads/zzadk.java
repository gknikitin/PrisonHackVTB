package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzhu;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzadh
public final class zzadk extends zzajx implements zzadx {
    private final Context mContext;
    @VisibleForTesting
    private zzwy zzbtj;
    @VisibleForTesting
    private zzaef zzbuc;
    @VisibleForTesting
    private zzaej zzbzf;
    /* access modifiers changed from: private */
    public Runnable zzbzg;
    /* access modifiers changed from: private */
    public final Object zzbzh = new Object();
    private final zzadj zzccf;
    /* access modifiers changed from: private */
    public final zzaeg zzccg;
    private final zzhs zzcch;
    private final zzhx zzcci;
    @GuardedBy("mCancelLock")
    @VisibleForTesting
    zzalc zzccj;

    public zzadk(Context context, zzaeg zzaeg, zzadj zzadj, zzhx zzhx) {
        zzhs zzhs;
        zzht zzht;
        this.zzccf = zzadj;
        this.mContext = context;
        this.zzccg = zzaeg;
        this.zzcci = zzhx;
        this.zzcch = new zzhs(this.zzcci);
        this.zzcch.zza((zzht) new zzadl(this));
        zzit zzit = new zzit();
        zzit.zzaot = Integer.valueOf(this.zzccg.zzacr.zzcve);
        zzit.zzaou = Integer.valueOf(this.zzccg.zzacr.zzcvf);
        zzit.zzaov = Integer.valueOf(this.zzccg.zzacr.zzcvg ? 0 : 2);
        this.zzcch.zza((zzht) new zzadm(zzit));
        if (this.zzccg.zzccw != null) {
            this.zzcch.zza((zzht) new zzadn(this));
        }
        zzjn zzjn = this.zzccg.zzacv;
        if (zzjn.zzarc && "interstitial_mb".equals(zzjn.zzarb)) {
            zzhs = this.zzcch;
            zzht = zzado.zzccm;
        } else if (zzjn.zzarc && "reward_mb".equals(zzjn.zzarb)) {
            zzhs = this.zzcch;
            zzht = zzadp.zzccm;
        } else if (zzjn.zzare || zzjn.zzarc) {
            zzhs = this.zzcch;
            zzht = zzadr.zzccm;
        } else {
            zzhs = this.zzcch;
            zzht = zzadq.zzccm;
        }
        zzhs.zza(zzht);
        this.zzcch.zza(zzhu.zza.zzb.AD_REQUEST);
    }

    @VisibleForTesting
    private final zzjn zza(zzaef zzaef) throws zzadu {
        if (((this.zzbuc == null || this.zzbuc.zzadn == null || this.zzbuc.zzadn.size() <= 1) ? false : true) && this.zzbtj != null && !this.zzbtj.zzbte) {
            return null;
        }
        if (this.zzbzf.zzarf) {
            for (zzjn zzjn : zzaef.zzacv.zzard) {
                if (zzjn.zzarf) {
                    return new zzjn(zzjn, zzaef.zzacv.zzard);
                }
            }
        }
        if (this.zzbzf.zzcet == null) {
            throw new zzadu("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzbzf.zzcet.split("x");
        if (split.length != 2) {
            String valueOf = String.valueOf(this.zzbzf.zzcet);
            throw new zzadu(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzjn zzjn2 : zzaef.zzacv.zzard) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = zzjn2.width == -1 ? (int) (((float) zzjn2.widthPixels) / f) : zzjn2.width;
                int i2 = zzjn2.height == -2 ? (int) (((float) zzjn2.heightPixels) / f) : zzjn2.height;
                if (parseInt == i && parseInt2 == i2 && !zzjn2.zzarf) {
                    return new zzjn(zzjn2, zzaef.zzacv.zzard);
                }
            }
            String valueOf2 = String.valueOf(this.zzbzf.zzcet);
            throw new zzadu(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException unused) {
            String valueOf3 = String.valueOf(this.zzbzf.zzcet);
            throw new zzadu(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(int i, String str) {
        int i2 = i;
        if (i2 == 3 || i2 == -1) {
            zzakb.zzdj(str);
        } else {
            zzakb.zzdk(str);
        }
        this.zzbzf = this.zzbzf == null ? new zzaej(i2) : new zzaej(i2, this.zzbzf.zzbsu);
        this.zzccf.zza(new zzaji(this.zzbuc != null ? this.zzbuc : new zzaef(this.zzccg, -1, (String) null, (String) null, (String) null), this.zzbzf, this.zzbtj, (zzjn) null, i2, -1, this.zzbzf.zzceu, (JSONObject) null, this.zzcch, (Boolean) null));
    }

    public final void onStop() {
        synchronized (this.zzbzh) {
            if (this.zzccj != null) {
                this.zzccj.cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzalc zza(zzang zzang, zzaol<zzaef> zzaol) {
        Context context = this.mContext;
        if (new zzadw(context).zza(zzang)) {
            zzakb.zzck("Fetching ad response from local ad request service.");
            zzaec zzaec = new zzaec(context, zzaol, this);
            zzaec.zznt();
            return zzaec;
        }
        zzakb.zzck("Fetching ad response from remote ad request service.");
        zzkb.zzif();
        if (zzamu.zzbe(context)) {
            return new zzaed(context, zzang, zzaol, this);
        }
        zzakb.zzdk("Failed to connect to remote ad request service.");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(@android.support.annotation.NonNull com.google.android.gms.internal.ads.zzaej r14) {
        /*
            r13 = this;
            java.lang.String r0 = "Received ad response."
            com.google.android.gms.internal.ads.zzakb.zzck(r0)
            r13.zzbzf = r14
            com.google.android.gms.common.util.Clock r14 = com.google.android.gms.ads.internal.zzbv.zzer()
            long r6 = r14.elapsedRealtime()
            java.lang.Object r14 = r13.zzbzh
            monitor-enter(r14)
            r0 = 0
            r13.zzccj = r0     // Catch:{ all -> 0x0217 }
            monitor-exit(r14)     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()
            com.google.android.gms.internal.ads.zzaej r1 = r13.zzbzf
            boolean r1 = r1.zzcdr
            r14.zzae((boolean) r1)
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zznk.zzayy
            com.google.android.gms.internal.ads.zzni r1 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r14 = r1.zzd(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf
            boolean r14 = r14.zzced
            if (r14 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()
            com.google.android.gms.internal.ads.zzaef r1 = r13.zzbuc
            java.lang.String r1 = r1.zzacp
            r14.zzcp(r1)
            goto L_0x005c
        L_0x004d:
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()
            com.google.android.gms.internal.ads.zzaef r1 = r13.zzbuc
            java.lang.String r1 = r1.zzacp
            r14.zzcq(r1)
        L_0x005c:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            int r14 = r14.errorCode     // Catch:{ zzadu -> 0x020a }
            r1 = -2
            r2 = -3
            if (r14 == r1) goto L_0x008b
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            int r14 = r14.errorCode     // Catch:{ zzadu -> 0x020a }
            if (r14 == r2) goto L_0x008b
            com.google.android.gms.internal.ads.zzadu r14 = new com.google.android.gms.internal.ads.zzadu     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzaej r0 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            int r0 = r0.errorCode     // Catch:{ zzadu -> 0x020a }
            r1 = 66
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ zzadu -> 0x020a }
            r2.<init>(r1)     // Catch:{ zzadu -> 0x020a }
            java.lang.String r1 = "There was a problem getting an ad response. ErrorCode: "
            r2.append(r1)     // Catch:{ zzadu -> 0x020a }
            r2.append(r0)     // Catch:{ zzadu -> 0x020a }
            java.lang.String r0 = r2.toString()     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzaej r1 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            int r1 = r1.errorCode     // Catch:{ zzadu -> 0x020a }
            r14.<init>(r0, r1)     // Catch:{ zzadu -> 0x020a }
            throw r14     // Catch:{ zzadu -> 0x020a }
        L_0x008b:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            int r14 = r14.errorCode     // Catch:{ zzadu -> 0x020a }
            r1 = 0
            if (r14 == r2) goto L_0x0139
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            java.lang.String r14 = r14.zzceo     // Catch:{ zzadu -> 0x020a }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ zzadu -> 0x020a }
            if (r14 == 0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzadu r14 = new com.google.android.gms.internal.ads.zzadu     // Catch:{ zzadu -> 0x020a }
            java.lang.String r0 = "No fill from ad server."
            r1 = 3
            r14.<init>(r0, r1)     // Catch:{ zzadu -> 0x020a }
            throw r14     // Catch:{ zzadu -> 0x020a }
        L_0x00a5:
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            boolean r2 = r2.zzcdd     // Catch:{ zzadu -> 0x020a }
            r14.zzab(r2)     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            boolean r14 = r14.zzceq     // Catch:{ zzadu -> 0x020a }
            if (r14 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzwy r14 = new com.google.android.gms.internal.ads.zzwy     // Catch:{ JSONException -> 0x00d1 }
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf     // Catch:{ JSONException -> 0x00d1 }
            java.lang.String r2 = r2.zzceo     // Catch:{ JSONException -> 0x00d1 }
            r14.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x00d1 }
            r13.zzbtj = r14     // Catch:{ JSONException -> 0x00d1 }
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()     // Catch:{ JSONException -> 0x00d1 }
            com.google.android.gms.internal.ads.zzwy r2 = r13.zzbtj     // Catch:{ JSONException -> 0x00d1 }
            boolean r2 = r2.zzbss     // Catch:{ JSONException -> 0x00d1 }
            r14.zzaa(r2)     // Catch:{ JSONException -> 0x00d1 }
            goto L_0x0103
        L_0x00d1:
            r14 = move-exception
            java.lang.String r0 = "Could not parse mediation config."
            com.google.android.gms.internal.ads.zzakb.zzb(r0, r14)     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzadu r14 = new com.google.android.gms.internal.ads.zzadu     // Catch:{ zzadu -> 0x020a }
            java.lang.String r0 = "Could not parse mediation config: "
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            java.lang.String r2 = r2.zzceo     // Catch:{ zzadu -> 0x020a }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ zzadu -> 0x020a }
            int r3 = r2.length()     // Catch:{ zzadu -> 0x020a }
            if (r3 == 0) goto L_0x00ee
            java.lang.String r0 = r0.concat(r2)     // Catch:{ zzadu -> 0x020a }
            goto L_0x00f4
        L_0x00ee:
            java.lang.String r2 = new java.lang.String     // Catch:{ zzadu -> 0x020a }
            r2.<init>(r0)     // Catch:{ zzadu -> 0x020a }
            r0 = r2
        L_0x00f4:
            r14.<init>(r0, r1)     // Catch:{ zzadu -> 0x020a }
            throw r14     // Catch:{ zzadu -> 0x020a }
        L_0x00f8:
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            boolean r2 = r2.zzbss     // Catch:{ zzadu -> 0x020a }
            r14.zzaa(r2)     // Catch:{ zzadu -> 0x020a }
        L_0x0103:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            java.lang.String r14 = r14.zzcds     // Catch:{ zzadu -> 0x020a }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ zzadu -> 0x020a }
            if (r14 != 0) goto L_0x0139
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zznk.zzbdj     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ zzadu -> 0x020a }
            java.lang.Object r14 = r2.zzd(r14)     // Catch:{ zzadu -> 0x020a }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ zzadu -> 0x020a }
            boolean r14 = r14.booleanValue()     // Catch:{ zzadu -> 0x020a }
            if (r14 == 0) goto L_0x0139
            java.lang.String r14 = "Received cookie from server. Setting webview cookie in CookieManager."
            com.google.android.gms.internal.ads.zzakb.zzck(r14)     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzakq r14 = com.google.android.gms.ads.internal.zzbv.zzem()     // Catch:{ zzadu -> 0x020a }
            android.content.Context r2 = r13.mContext     // Catch:{ zzadu -> 0x020a }
            android.webkit.CookieManager r14 = r14.zzax(r2)     // Catch:{ zzadu -> 0x020a }
            if (r14 == 0) goto L_0x0139
            java.lang.String r2 = "googleads.g.doubleclick.net"
            com.google.android.gms.internal.ads.zzaej r3 = r13.zzbzf     // Catch:{ zzadu -> 0x020a }
            java.lang.String r3 = r3.zzcds     // Catch:{ zzadu -> 0x020a }
            r14.setCookie(r2, r3)     // Catch:{ zzadu -> 0x020a }
        L_0x0139:
            com.google.android.gms.internal.ads.zzaef r14 = r13.zzbuc     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzjn r14 = r14.zzacv     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzjn[] r14 = r14.zzard     // Catch:{ zzadu -> 0x020a }
            if (r14 == 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzaef r14 = r13.zzbuc     // Catch:{ zzadu -> 0x020a }
            com.google.android.gms.internal.ads.zzjn r14 = r13.zza((com.google.android.gms.internal.ads.zzaef) r14)     // Catch:{ zzadu -> 0x020a }
            r4 = r14
            goto L_0x014a
        L_0x0149:
            r4 = r0
        L_0x014a:
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf
            boolean r2 = r2.zzcfa
            r14.zzac(r2)
            com.google.android.gms.internal.ads.zzajm r14 = com.google.android.gms.ads.internal.zzbv.zzeo()
            com.google.android.gms.internal.ads.zzakd r14 = r14.zzqh()
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf
            boolean r2 = r2.zzcfm
            r14.zzad(r2)
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf
            java.lang.String r14 = r14.zzcey
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0183
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x017d }
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf     // Catch:{ Exception -> 0x017d }
            java.lang.String r2 = r2.zzcey     // Catch:{ Exception -> 0x017d }
            r14.<init>(r2)     // Catch:{ Exception -> 0x017d }
            r10 = r14
            goto L_0x0184
        L_0x017d:
            r14 = move-exception
            java.lang.String r2 = "Error parsing the JSON for Active View."
            com.google.android.gms.internal.ads.zzakb.zzb(r2, r14)
        L_0x0183:
            r10 = r0
        L_0x0184:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf
            int r14 = r14.zzcfo
            r2 = 2
            r3 = 1
            if (r14 != r2) goto L_0x01cb
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            com.google.android.gms.internal.ads.zzaef r14 = r13.zzbuc
            com.google.android.gms.internal.ads.zzjj r14 = r14.zzccv
            android.os.Bundle r2 = r14.zzaqg
            if (r2 == 0) goto L_0x019b
            android.os.Bundle r14 = r14.zzaqg
            goto L_0x01a0
        L_0x019b:
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>()
        L_0x01a0:
            java.lang.Class<com.google.ads.mediation.admob.AdMobAdapter> r2 = com.google.ads.mediation.admob.AdMobAdapter.class
            java.lang.String r2 = r2.getName()
            android.os.Bundle r2 = r14.getBundle(r2)
            if (r2 == 0) goto L_0x01b7
            java.lang.Class<com.google.ads.mediation.admob.AdMobAdapter> r2 = com.google.ads.mediation.admob.AdMobAdapter.class
            java.lang.String r2 = r2.getName()
            android.os.Bundle r14 = r14.getBundle(r2)
            goto L_0x01c6
        L_0x01b7:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.Class<com.google.ads.mediation.admob.AdMobAdapter> r5 = com.google.ads.mediation.admob.AdMobAdapter.class
            java.lang.String r5 = r5.getName()
            r14.putBundle(r5, r2)
            r14 = r2
        L_0x01c6:
            java.lang.String r2 = "render_test_label"
            r14.putBoolean(r2, r3)
        L_0x01cb:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf
            int r14 = r14.zzcfo
            if (r14 != r3) goto L_0x01d5
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
        L_0x01d5:
            com.google.android.gms.internal.ads.zzaej r14 = r13.zzbzf
            int r14 = r14.zzcfo
            if (r14 != 0) goto L_0x01e9
            com.google.android.gms.internal.ads.zzaef r14 = r13.zzbuc
            com.google.android.gms.internal.ads.zzjj r14 = r14.zzccv
            boolean r14 = com.google.android.gms.internal.ads.zzamm.zzo(r14)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            r12 = r14
            goto L_0x01ea
        L_0x01e9:
            r12 = r0
        L_0x01ea:
            com.google.android.gms.internal.ads.zzaji r14 = new com.google.android.gms.internal.ads.zzaji
            com.google.android.gms.internal.ads.zzaef r1 = r13.zzbuc
            com.google.android.gms.internal.ads.zzaej r2 = r13.zzbzf
            com.google.android.gms.internal.ads.zzwy r3 = r13.zzbtj
            r5 = -2
            com.google.android.gms.internal.ads.zzaej r0 = r13.zzbzf
            long r8 = r0.zzceu
            com.google.android.gms.internal.ads.zzhs r11 = r13.zzcch
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12)
            com.google.android.gms.internal.ads.zzadj r0 = r13.zzccf
            r0.zza(r14)
        L_0x0202:
            android.os.Handler r14 = com.google.android.gms.internal.ads.zzakk.zzcrm
            java.lang.Runnable r0 = r13.zzbzg
            r14.removeCallbacks(r0)
            return
        L_0x020a:
            r14 = move-exception
            int r0 = r14.getErrorCode()
            java.lang.String r14 = r14.getMessage()
            r13.zzc(r0, r14)
            goto L_0x0202
        L_0x0217:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0217 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadk.zza(com.google.android.gms.internal.ads.zzaej):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzii zzii) {
        zzii.zzanm.zzamu = this.zzccg.zzccw.packageName;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzii zzii) {
        zzii.zzanh = this.zzccg.zzcdi;
    }

    public final void zzdn() {
        String string;
        zzakb.zzck("AdLoaderBackgroundTask started.");
        this.zzbzg = new zzads(this);
        zzakk.zzcrm.postDelayed(this.zzbzg, ((Long) zzkb.zzik().zzd(zznk.zzban)).longValue());
        long elapsedRealtime = zzbv.zzer().elapsedRealtime();
        if (!((Boolean) zzkb.zzik().zzd(zznk.zzbak)).booleanValue() || this.zzccg.zzccv.extras == null || (string = this.zzccg.zzccv.extras.getString("_ad")) == null) {
            zzaop zzaop = new zzaop();
            zzaki.zzb(new zzadt(this, zzaop));
            String zzz = zzbv.zzfh().zzz(this.mContext);
            String zzaa = zzbv.zzfh().zzaa(this.mContext);
            String zzab = zzbv.zzfh().zzab(this.mContext);
            zzbv.zzfh().zzg(this.mContext, zzab);
            this.zzbuc = new zzaef(this.zzccg, elapsedRealtime, zzz, zzaa, zzab);
            zzaop.zzk(this.zzbuc);
            return;
        }
        this.zzbuc = new zzaef(this.zzccg, elapsedRealtime, (String) null, (String) null, (String) null);
        zza(zzafs.zza(this.mContext, this.zzbuc, string));
    }
}
