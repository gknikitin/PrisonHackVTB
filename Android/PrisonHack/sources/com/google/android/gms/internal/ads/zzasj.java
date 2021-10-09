package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.gmsg.zza;
import com.google.android.gms.ads.internal.gmsg.zzab;
import com.google.android.gms.ads.internal.gmsg.zzac;
import com.google.android.gms.ads.internal.gmsg.zzad;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzf;
import com.google.android.gms.ads.internal.gmsg.zzy;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzx;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
@VisibleForTesting
public final class zzasj extends zzus<zzaqw> implements zzasc, zzasx, zzasz, zzata, zzatb {
    private final Object mLock;
    private boolean zzaek;
    private zzjd zzapt;
    private zzb zzbll;
    private zzd zzblm;
    private zzz zzbmu;
    private zzx zzbmw;
    private zzaab zzbmx;
    private zzaam zzbmy;
    private zzt zzbnb;
    private zzn zzbnc;
    private zzaqw zzbnd;
    private zzasd zzdbr;
    private zzase zzdbs;
    private zzasf zzdbt;
    private boolean zzdbu;
    private boolean zzdbv;
    private ViewTreeObserver.OnGlobalLayoutListener zzdbw;
    private ViewTreeObserver.OnScrollChangedListener zzdbx;
    private boolean zzdby;
    private final zzaak zzdbz;
    private zzasg zzdca;
    private boolean zzdcb;
    private boolean zzdcc;
    private int zzdcd;
    private View.OnAttachStateChangeListener zzdce;
    @Nullable
    private zzait zzxd;

    public zzasj(zzaqw zzaqw, boolean z) {
        this(zzaqw, z, new zzaak(zzaqw, zzaqw.zzua(), new zzmw(zzaqw.getContext())), (zzaab) null);
    }

    @VisibleForTesting
    private zzasj(zzaqw zzaqw, boolean z, zzaak zzaak, zzaab zzaab) {
        this.mLock = new Object();
        this.zzdbu = false;
        this.zzbnd = zzaqw;
        this.zzaek = z;
        this.zzdbz = zzaak;
        this.zzbmx = null;
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzait zzait, int i) {
        if (zzait.zzph() && i > 0) {
            zzait.zzr(view);
            if (zzait.zzph()) {
                zzakk.zzcrm.postDelayed(new zzasl(this, view, zzait, i), 100);
            }
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zznf = this.zzbmx != null ? this.zzbmx.zznf() : false;
        zzbv.zzei();
        Context context = this.zzbnd.getContext();
        if (!zznf) {
            z = true;
        }
        zzl.zza(context, adOverlayInfoParcel, z);
        if (this.zzxd != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzbyl != null) {
                str = adOverlayInfoParcel.zzbyl.url;
            }
            this.zzxd.zzcf(str);
        }
    }

    private final WebResourceResponse zze(zzasu zzasu) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzasu.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : zzasu.zzab.entrySet()) {
                    openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                if (!(openConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                httpURLConnection = (HttpURLConnection) openConnection;
                zzbv.zzek().zza(this.zzbnd.getContext(), this.zzbnd.zztq().zzcw, false, httpURLConnection);
                zzamy zzamy = new zzamy();
                zzamy.zza(httpURLConnection, (byte[]) null);
                int responseCode = httpURLConnection.getResponseCode();
                zzamy.zza(httpURLConnection, responseCode);
                if (responseCode < 300 || responseCode >= 400) {
                    zzbv.zzek();
                } else {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    String protocol = url2.getProtocol();
                    if (protocol == null) {
                        zzakb.zzdk("Protocol is null");
                        return null;
                    } else if (protocol.equals("http") || protocol.equals("https")) {
                        String valueOf = String.valueOf(headerField);
                        zzakb.zzck(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                        httpURLConnection.disconnect();
                        url = url2;
                    } else {
                        String valueOf2 = String.valueOf(protocol);
                        zzakb.zzdk(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                        return null;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzbv.zzek();
        return zzakk.zzb(httpURLConnection);
    }

    private final void zzuy() {
        if (this.zzdce != null) {
            this.zzbnd.getView().removeOnAttachStateChangeListener(this.zzdce);
        }
    }

    private final void zzvd() {
        if (this.zzdbr != null && ((this.zzdcb && this.zzdcd <= 0) || this.zzdcc)) {
            this.zzdbr.zze(!this.zzdcc);
            this.zzdbr = null;
        }
        this.zzbnd.zzup();
    }

    public final /* synthetic */ Object getReference() {
        return this.zzbnd;
    }

    public final void reset() {
        if (this.zzxd != null) {
            this.zzxd.zzpj();
            this.zzxd = null;
        }
        zzuy();
        super.reset();
        synchronized (this.mLock) {
            this.zzapt = null;
            this.zzbnc = null;
            this.zzdbr = null;
            this.zzdbs = null;
            this.zzbll = null;
            this.zzblm = null;
            this.zzdbu = false;
            this.zzaek = false;
            this.zzdbv = false;
            this.zzdby = false;
            this.zzbnb = null;
            this.zzdbt = null;
            if (this.zzbmx != null) {
                this.zzbmx.zzm(true);
                this.zzbmx = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzdbz.zzc(i, i2);
        if (this.zzbmx != null) {
            this.zzbmx.zza(i, i2, z);
        }
    }

    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzdbv = true;
            this.zzbnd.zzuo();
            this.zzdbw = onGlobalLayoutListener;
            this.zzdbx = onScrollChangedListener;
        }
    }

    public final void zza(zzc zzc) {
        boolean zzuj = this.zzbnd.zzuj();
        zza(new AdOverlayInfoParcel(zzc, (!zzuj || this.zzbnd.zzud().zzvs()) ? this.zzapt : null, zzuj ? null : this.zzbnc, this.zzbnb, this.zzbnd.zztq()));
    }

    public final void zza(zzasd zzasd) {
        this.zzdbr = zzasd;
    }

    public final void zza(zzase zzase) {
        this.zzdbs = zzase;
    }

    public final void zza(zzasf zzasf) {
        this.zzdbt = zzasf;
    }

    public final void zza(zzasg zzasg) {
        this.zzdca = zzasg;
    }

    public final void zza(zzjd zzjd, zzb zzb, zzn zzn, zzd zzd, zzt zzt, boolean z, @Nullable zzz zzz, zzx zzx, zzaam zzaam, @Nullable zzait zzait) {
        zzb zzb2 = zzb;
        zzd zzd2 = zzd;
        zzz zzz2 = zzz;
        zzaam zzaam2 = zzaam;
        zzait zzait2 = zzait;
        zzx zzx2 = zzx == null ? new zzx(this.zzbnd.getContext(), zzait2, (zzael) null) : zzx;
        this.zzbmx = new zzaab(this.zzbnd, zzaam2);
        this.zzxd = zzait2;
        if (((Boolean) zzkb.zzik().zzd(zznk.zzayf)).booleanValue()) {
            zza("/adMetadata", new zza(zzb2));
        }
        zza("/appEvent", new com.google.android.gms.ads.internal.gmsg.zzc(zzd2));
        zza("/backButton", zzf.zzblx);
        zza("/refresh", zzf.zzbly);
        zza("/canOpenURLs", zzf.zzblo);
        zza("/canOpenIntents", zzf.zzblp);
        zza("/click", zzf.zzblq);
        zza("/close", zzf.zzblr);
        zza("/customClose", zzf.zzbls);
        zza("/instrument", zzf.zzbmb);
        zza("/delayPageLoaded", zzf.zzbmd);
        zza("/delayPageClosed", zzf.zzbme);
        zza("/getLocationInfo", zzf.zzbmf);
        zza("/httpTrack", zzf.zzblt);
        zza("/log", zzf.zzblu);
        zza("/mraid", new zzac(zzx2, this.zzbmx, zzaam2));
        zza("/mraidLoaded", this.zzdbz);
        zzad zzad = r1;
        zzx zzx3 = zzx2;
        zzad zzad2 = new zzad(this.zzbnd.getContext(), this.zzbnd.zztq(), this.zzbnd.zzui(), zzt, zzjd, zzb2, zzd2, zzn, zzx2, this.zzbmx);
        zza("/open", zzad);
        zza("/precache", new zzaql());
        zza("/touch", zzf.zzblw);
        zza("/video", zzf.zzblz);
        zza("/videoMeta", zzf.zzbma);
        if (zzbv.zzfh().zzs(this.zzbnd.getContext())) {
            zza("/logScionEvent", new zzab(this.zzbnd.getContext()));
        }
        if (zzz2 != null) {
            zza("/setInterstitialProperties", new zzy(zzz2));
        }
        this.zzapt = zzjd;
        this.zzbnc = zzn;
        this.zzbll = zzb2;
        this.zzblm = zzd;
        this.zzbnb = zzt;
        this.zzbmw = zzx3;
        this.zzbmy = zzaam;
        this.zzbmu = zzz2;
        this.zzdbu = z;
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzbnd.zzuj() || this.zzbnd.zzud().zzvs()) ? this.zzapt : null, this.zzbnc, this.zzbnb, this.zzbnd, z, i, this.zzbnd.zztq()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzuj = this.zzbnd.zzuj();
        zza(new AdOverlayInfoParcel((!zzuj || this.zzbnd.zzud().zzvs()) ? this.zzapt : null, zzuj ? null : new zzasn(this.zzbnd, this.zzbnc), this.zzbll, this.zzblm, this.zzbnb, this.zzbnd, z, i, str, this.zzbnd.zztq()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzuj = this.zzbnd.zzuj();
        zza(new AdOverlayInfoParcel((!zzuj || this.zzbnd.zzud().zzvs()) ? this.zzapt : null, zzuj ? null : new zzasn(this.zzbnd, this.zzbnc), this.zzbll, this.zzblm, this.zzbnb, this.zzbnd, z, i, str, str2, this.zzbnd.zztq()));
    }

    public final boolean zza(zzasu zzasu) {
        String valueOf = String.valueOf(zzasu.url);
        zzakb.m39v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzasu.uri;
        if (zzf(uri)) {
            return true;
        }
        if (this.zzdbu) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                if (this.zzapt != null) {
                    if (((Boolean) zzkb.zzik().zzd(zznk.zzaxf)).booleanValue()) {
                        this.zzapt.onAdClicked();
                        if (this.zzxd != null) {
                            this.zzxd.zzcf(zzasu.url);
                        }
                        this.zzapt = null;
                    }
                }
                return false;
            }
        }
        if (!this.zzbnd.getWebView().willNotDraw()) {
            try {
                zzci zzui = this.zzbnd.zzui();
                if (zzui != null && zzui.zzb(uri)) {
                    uri = zzui.zza(uri, this.zzbnd.getContext(), this.zzbnd.getView(), this.zzbnd.zzto());
                }
            } catch (zzcj unused) {
                String valueOf2 = String.valueOf(zzasu.url);
                zzakb.zzdk(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            if (this.zzbmw == null || this.zzbmw.zzcy()) {
                zza(new zzc("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                return true;
            }
            this.zzbmw.zzs(zzasu.url);
            return true;
        }
        String valueOf3 = String.valueOf(zzasu.url);
        zzakb.zzdk(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        return true;
    }

    public final void zzah(boolean z) {
        this.zzdbu = z;
    }

    public final void zzb(int i, int i2) {
        if (this.zzbmx != null) {
            this.zzbmx.zzb(i, i2);
        }
    }

    public final void zzb(zzasu zzasu) {
        zzf(zzasu.uri);
    }

    public final void zzc(zzasu zzasu) {
        this.zzdcb = true;
        if (this.zzdbs != null) {
            this.zzdbs.zzly();
            this.zzdbs = null;
        }
        zzvd();
    }

    @Nullable
    public final WebResourceResponse zzd(zzasu zzasu) {
        WebResourceResponse webResourceResponse;
        zzhi zza;
        if (this.zzxd != null) {
            this.zzxd.zza(zzasu.url, zzasu.zzab, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzasu.url).getName())) {
            webResourceResponse = null;
        } else {
            zznk();
            String str = (String) zzkb.zzik().zzd(this.zzbnd.zzud().zzvs() ? zznk.zzawe : this.zzbnd.zzuj() ? zznk.zzawd : zznk.zzawc);
            zzbv.zzek();
            webResourceResponse = zzakk.zzf(this.zzbnd.getContext(), this.zzbnd.zztq().zzcw, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzajb.zzb(zzasu.url, this.zzbnd.getContext()).equals(zzasu.url)) {
                return zze(zzasu);
            }
            zzhl zzaa = zzhl.zzaa(zzasu.url);
            if (zzaa != null && (zza = zzbv.zzeq().zza(zzaa)) != null && zza.zzhi()) {
                return new WebResourceResponse("", "", zza.zzhj());
            }
            if (zzamy.isEnabled()) {
                if (((Boolean) zzkb.zzik().zzd(zznk.zzazn)).booleanValue()) {
                    return zze(zzasu);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzbv.zzeo().zza(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    public final boolean zzfz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaek;
        }
        return z;
    }

    public final void zznk() {
        synchronized (this.mLock) {
            this.zzdbu = false;
            this.zzaek = true;
            zzaoe.zzcvy.execute(new zzask(this));
        }
    }

    public final zzx zzut() {
        return this.zzbmw;
    }

    public final boolean zzuu() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdbv;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzuv() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzdbw;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzuw() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzdbx;
        }
        return onScrollChangedListener;
    }

    public final boolean zzux() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdby;
        }
        return z;
    }

    public final void zzuz() {
        zzait zzait = this.zzxd;
        if (zzait != null) {
            WebView webView = this.zzbnd.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzait, 10);
                return;
            }
            zzuy();
            this.zzdce = new zzasm(this, zzait);
            this.zzbnd.getView().addOnAttachStateChangeListener(this.zzdce);
        }
    }

    public final void zzva() {
        synchronized (this.mLock) {
            this.zzdby = true;
        }
        this.zzdcd++;
        zzvd();
    }

    public final void zzvb() {
        this.zzdcd--;
        zzvd();
    }

    public final void zzvc() {
        this.zzdcc = true;
        zzvd();
    }

    public final zzasg zzve() {
        return this.zzdca;
    }

    public final zzait zzvf() {
        return this.zzxd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzvg() {
        this.zzbnd.zzuo();
        com.google.android.gms.ads.internal.overlay.zzd zzub = this.zzbnd.zzub();
        if (zzub != null) {
            zzub.zznk();
        }
        if (this.zzdbt != null) {
            this.zzdbt.zzdb();
            this.zzdbt = null;
        }
    }
}
