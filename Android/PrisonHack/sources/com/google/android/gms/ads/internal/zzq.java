package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzaig;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzaji;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzakk;
import com.google.android.gms.internal.ads.zzane;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzhs;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzoj;
import com.google.android.gms.internal.ads.zzoo;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzoy;
import com.google.android.gms.internal.ads.zzoz;
import com.google.android.gms.internal.ads.zzpa;
import com.google.android.gms.internal.ads.zzpb;
import com.google.android.gms.internal.ads.zzpw;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzwy;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyf;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class zzq extends zzd implements zzpa {
    private boolean zzvm;
    /* access modifiers changed from: private */
    public zzajh zzwr;
    private boolean zzws = false;

    public zzq(Context context, zzw zzw, zzjn zzjn, String str, zzxn zzxn, zzang zzang) {
        super(context, zzjn, str, zzxn, zzang, zzw);
    }

    private static zzajh zza(zzaji zzaji, int i) {
        zzaji zzaji2 = zzaji;
        zzjj zzjj = zzaji2.zzcgs.zzccv;
        List<String> list = zzaji2.zzcos.zzbsn;
        List<String> list2 = zzaji2.zzcos.zzbso;
        List<String> list3 = zzaji2.zzcos.zzces;
        int i2 = zzaji2.zzcos.orientation;
        long j = zzaji2.zzcos.zzbsu;
        String str = zzaji2.zzcgs.zzccy;
        boolean z = zzaji2.zzcos.zzceq;
        zzwy zzwy = zzaji2.zzcod;
        long j2 = zzaji2.zzcos.zzcer;
        zzjn zzjn = zzaji2.zzacv;
        long j3 = j2;
        zzwy zzwy2 = zzwy;
        long j4 = zzaji2.zzcos.zzcep;
        long j5 = zzaji2.zzcoh;
        long j6 = zzaji2.zzcoi;
        String str2 = zzaji2.zzcos.zzcev;
        JSONObject jSONObject = zzaji2.zzcob;
        zzaig zzaig = zzaji2.zzcos.zzcfe;
        List<String> list4 = zzaji2.zzcos.zzcff;
        List<String> list5 = zzaji2.zzcos.zzcff;
        boolean z2 = zzaji2.zzcos.zzcfh;
        zzael zzael = zzaji2.zzcos.zzcfi;
        List<String> list6 = zzaji2.zzcos.zzbsr;
        String str3 = zzaji2.zzcos.zzcfl;
        long j7 = j6;
        zzhs zzhs = zzaji2.zzcoq;
        boolean z3 = zzaji2.zzcos.zzzl;
        zzhs zzhs2 = zzhs;
        boolean z4 = zzaji2.zzcor;
        String str4 = str3;
        boolean z5 = zzaji2.zzcos.zzcfp;
        List<String> list7 = zzaji2.zzcos.zzbsp;
        JSONObject jSONObject2 = jSONObject;
        boolean z6 = z3;
        return new zzajh(zzjj, (zzaqw) null, list, i, list2, list3, i2, j, str, z, (zzwx) null, (zzxq) null, (String) null, zzwy2, (zzxa) null, j3, zzjn, j4, j5, j7, str2, jSONObject2, (zzpb) null, zzaig, list4, list5, z2, zzael, (String) null, list6, str4, zzhs2, z6, z4, z5, list7, zzaji2.zzcos.zzzm, zzaji2.zzcos.zzcfq);
    }

    private final void zza(zzov zzov) {
        zzakk.zzcrm.post(new zzs(this, zzov));
    }

    private final boolean zzb(zzajh zzajh, zzajh zzajh2) {
        Handler handler;
        Runnable zzu;
        zzov zzov;
        zzajh zzajh3 = zzajh2;
        View view = null;
        zzd((List<String>) null);
        if (!this.zzvw.zzfo()) {
            zzakb.zzdk("Native ad does not have custom rendering mode.");
        } else {
            try {
                zzyf zzmu = zzajh3.zzbtx != null ? zzajh3.zzbtx.zzmu() : null;
                zzxz zzmo = zzajh3.zzbtx != null ? zzajh3.zzbtx.zzmo() : null;
                zzyc zzmp = zzajh3.zzbtx != null ? zzajh3.zzbtx.zzmp() : null;
                zzqs zzmt = zzajh3.zzbtx != null ? zzajh3.zzbtx.zzmt() : null;
                String zzc = zzc(zzajh2);
                if (zzmu != null && this.zzvw.zzadg != null) {
                    String headline = zzmu.getHeadline();
                    List images = zzmu.getImages();
                    String body = zzmu.getBody();
                    zzpw zzjz = zzmu.zzjz() != null ? zzmu.zzjz() : null;
                    String callToAction = zzmu.getCallToAction();
                    String advertiser = zzmu.getAdvertiser();
                    double starRating = zzmu.getStarRating();
                    String store = zzmu.getStore();
                    String price = zzmu.getPrice();
                    zzlo videoController = zzmu.getVideoController();
                    if (zzmu.zzmw() != null) {
                        view = (View) ObjectWrapper.unwrap(zzmu.zzmw());
                    }
                    zzov = new zzov(headline, images, body, zzjz, callToAction, advertiser, starRating, store, price, (zzoj) null, videoController, view, zzmu.zzke(), zzc, zzmu.getExtras());
                    zzov.zzb((zzoz) new zzoy(this.zzvw.zzrt, (zzpa) this, this.zzvw.zzacq, zzmu, (zzpb) zzov));
                } else if (zzmo == null || this.zzvw.zzadg == null) {
                    if (zzmo != null && this.zzvw.zzade != null) {
                        String headline2 = zzmo.getHeadline();
                        List images2 = zzmo.getImages();
                        String body2 = zzmo.getBody();
                        zzpw zzjz2 = zzmo.zzjz() != null ? zzmo.zzjz() : null;
                        String callToAction2 = zzmo.getCallToAction();
                        double starRating2 = zzmo.getStarRating();
                        String store2 = zzmo.getStore();
                        String price2 = zzmo.getPrice();
                        Bundle extras = zzmo.getExtras();
                        zzlo videoController2 = zzmo.getVideoController();
                        if (zzmo.zzmw() != null) {
                            view = (View) ObjectWrapper.unwrap(zzmo.zzmw());
                        }
                        zzoo zzoo = new zzoo(headline2, images2, body2, zzjz2, callToAction2, starRating2, store2, price2, (zzoj) null, extras, videoController2, view, zzmo.zzke(), zzc);
                        zzoo.zzb((zzoz) new zzoy(this.zzvw.zzrt, (zzpa) this, this.zzvw.zzacq, zzmo, (zzpb) zzoo));
                        handler = zzakk.zzcrm;
                        zzu = new zzt(this, zzoo);
                    } else if (zzmp != null && this.zzvw.zzadg != null) {
                        String headline3 = zzmp.getHeadline();
                        List images3 = zzmp.getImages();
                        String body3 = zzmp.getBody();
                        zzpw zzkg = zzmp.zzkg() != null ? zzmp.zzkg() : null;
                        String callToAction3 = zzmp.getCallToAction();
                        String advertiser2 = zzmp.getAdvertiser();
                        zzlo videoController3 = zzmp.getVideoController();
                        if (zzmp.zzmw() != null) {
                            view = (View) ObjectWrapper.unwrap(zzmp.zzmw());
                        }
                        zzov zzov2 = new zzov(headline3, images3, body3, zzkg, callToAction3, advertiser2, -1.0d, (String) null, (String) null, (zzoj) null, videoController3, view, zzmp.zzke(), zzc, zzmp.getExtras());
                        zzyc zzyc = zzmp;
                        zzov = zzov2;
                        zzov.zzb((zzoz) new zzoy(this.zzvw.zzrt, (zzpa) this, this.zzvw.zzacq, zzyc, (zzpb) zzov2));
                    } else if (zzmp != null && this.zzvw.zzadf != null) {
                        String headline4 = zzmp.getHeadline();
                        List images4 = zzmp.getImages();
                        String body4 = zzmp.getBody();
                        zzpw zzkg2 = zzmp.zzkg() != null ? zzmp.zzkg() : null;
                        String callToAction4 = zzmp.getCallToAction();
                        String advertiser3 = zzmp.getAdvertiser();
                        Bundle extras2 = zzmp.getExtras();
                        zzlo videoController4 = zzmp.getVideoController();
                        if (zzmp.zzmw() != null) {
                            view = (View) ObjectWrapper.unwrap(zzmp.zzmw());
                        }
                        zzoq zzoq = new zzoq(headline4, images4, body4, zzkg2, callToAction4, advertiser3, (zzoj) null, extras2, videoController4, view, zzmp.zzke(), zzc);
                        zzyc zzyc2 = zzmp;
                        zzoq zzoq2 = zzoq;
                        zzoq2.zzb((zzoz) new zzoy(this.zzvw.zzrt, (zzpa) this, this.zzvw.zzacq, zzyc2, (zzpb) zzoq));
                        handler = zzakk.zzcrm;
                        zzu = new zzu(this, zzoq2);
                    } else if (zzmt == null || this.zzvw.zzadi == null || this.zzvw.zzadi.get(zzmt.getCustomTemplateId()) == null) {
                        zzakb.zzdk("No matching mapper/listener for retrieved native ad template.");
                        zzi(0);
                        return false;
                    } else {
                        zzakk.zzcrm.post(new zzv(this, zzmt));
                        return super.zza(zzajh, zzajh2);
                    }
                    handler.post(zzu);
                    return super.zza(zzajh, zzajh2);
                } else {
                    String headline5 = zzmo.getHeadline();
                    List images5 = zzmo.getImages();
                    String body5 = zzmo.getBody();
                    zzpw zzjz3 = zzmo.zzjz() != null ? zzmo.zzjz() : null;
                    String callToAction5 = zzmo.getCallToAction();
                    double starRating3 = zzmo.getStarRating();
                    String store3 = zzmo.getStore();
                    String price3 = zzmo.getPrice();
                    zzlo videoController5 = zzmo.getVideoController();
                    if (zzmo.zzmw() != null) {
                        view = (View) ObjectWrapper.unwrap(zzmo.zzmw());
                    }
                    zzov = new zzov(headline5, images5, body5, zzjz3, callToAction5, (String) null, starRating3, store3, price3, (zzoj) null, videoController5, view, zzmo.zzke(), zzc, zzmo.getExtras());
                    zzov.zzb((zzoz) new zzoy(this.zzvw.zzrt, (zzpa) this, this.zzvw.zzacq, zzmo, (zzpb) zzov));
                }
                zza(zzov);
                return super.zza(zzajh, zzajh2);
            } catch (RemoteException e) {
                zzakb.zzd("#007 Could not call remote method.", e);
            }
        }
        zzi(0);
        return false;
    }

    private final boolean zzc(zzajh zzajh, zzajh zzajh2) {
        View zze = zzas.zze(zzajh2);
        if (zze == null) {
            return false;
        }
        View nextView = this.zzvw.zzacs.getNextView();
        if (nextView != null) {
            if (nextView instanceof zzaqw) {
                ((zzaqw) nextView).destroy();
            }
            this.zzvw.zzacs.removeView(nextView);
        }
        if (!zzas.zzf(zzajh2)) {
            try {
                zzg(zze);
            } catch (Throwable th) {
                zzbv.zzeo().zza(th, "AdLoaderManager.swapBannerViews");
                zzakb.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzvw.zzacs.getChildCount() > 1) {
            this.zzvw.zzacs.showNext();
        }
        if (zzajh != null) {
            View nextView2 = this.zzvw.zzacs.getNextView();
            if (nextView2 != null) {
                this.zzvw.zzacs.removeView(nextView2);
            }
            this.zzvw.zzfn();
        }
        this.zzvw.zzacs.setMinimumWidth(zzbk().widthPixels);
        this.zzvw.zzacs.setMinimumHeight(zzbk().heightPixels);
        this.zzvw.zzacs.requestLayout();
        this.zzvw.zzacs.setVisibility(0);
        return true;
    }

    @Nullable
    private final zzwy zzcw() {
        if (this.zzvw.zzacw == null || !this.zzvw.zzacw.zzceq) {
            return null;
        }
        return this.zzvw.zzacw.zzcod;
    }

    @Nullable
    public final zzlo getVideoController() {
        return null;
    }

    public final void pause() {
        if (!this.zzws) {
            throw new IllegalStateException("Native Ad does not support pause().");
        }
        super.pause();
    }

    public final void resume() {
        if (!this.zzws) {
            throw new IllegalStateException("Native Ad does not support resume().");
        }
        super.resume();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzvm = z;
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzaji r11, com.google.android.gms.internal.ads.zznx r12) {
        /*
            r10 = this;
            r0 = 0
            r10.zzwr = r0
            int r0 = r11.errorCode
            r1 = 0
            r2 = -2
            if (r0 == r2) goto L_0x0012
            int r0 = r11.errorCode
            com.google.android.gms.internal.ads.zzajh r0 = zza((com.google.android.gms.internal.ads.zzaji) r11, (int) r0)
        L_0x000f:
            r10.zzwr = r0
            goto L_0x0022
        L_0x0012:
            com.google.android.gms.internal.ads.zzaej r0 = r11.zzcos
            boolean r0 = r0.zzceq
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "partialAdState is not mediation"
            com.google.android.gms.internal.ads.zzakb.zzdk(r0)
            com.google.android.gms.internal.ads.zzajh r0 = zza((com.google.android.gms.internal.ads.zzaji) r11, (int) r1)
            goto L_0x000f
        L_0x0022:
            com.google.android.gms.internal.ads.zzajh r0 = r10.zzwr
            if (r0 == 0) goto L_0x0031
            android.os.Handler r11 = com.google.android.gms.internal.ads.zzakk.zzcrm
            com.google.android.gms.ads.internal.zzr r12 = new com.google.android.gms.ads.internal.zzr
            r12.<init>(r10)
            r11.post(r12)
            return
        L_0x0031:
            com.google.android.gms.internal.ads.zzjn r0 = r11.zzacv
            if (r0 == 0) goto L_0x003b
            com.google.android.gms.ads.internal.zzbw r0 = r10.zzvw
            com.google.android.gms.internal.ads.zzjn r2 = r11.zzacv
            r0.zzacv = r2
        L_0x003b:
            com.google.android.gms.ads.internal.zzbw r0 = r10.zzvw
            r0.zzadv = r1
            com.google.android.gms.ads.internal.zzbw r0 = r10.zzvw
            com.google.android.gms.ads.internal.zzbv.zzej()
            com.google.android.gms.ads.internal.zzbw r1 = r10.zzvw
            android.content.Context r2 = r1.zzrt
            com.google.android.gms.ads.internal.zzbw r1 = r10.zzvw
            com.google.android.gms.internal.ads.zzci r5 = r1.zzacq
            r6 = 0
            com.google.android.gms.internal.ads.zzxn r7 = r10.zzwh
            r3 = r10
            r4 = r11
            r8 = r10
            r9 = r12
            com.google.android.gms.internal.ads.zzalc r11 = com.google.android.gms.internal.ads.zzabl.zza(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.zzacu = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzq.zza(com.google.android.gms.internal.ads.zzaji, com.google.android.gms.internal.ads.zznx):void");
    }

    public final void zza(zzod zzod) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    public final void zza(zzox zzox) {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    public final void zza(zzoz zzoz) {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@android.support.annotation.Nullable com.google.android.gms.internal.ads.zzajh r5, com.google.android.gms.internal.ads.zzajh r6) {
        /*
            r4 = this;
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzvw
            boolean r0 = r0.zzfo()
            if (r0 != 0) goto L_0x0010
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "AdLoader API does not support custom rendering."
            r5.<init>(r6)
            throw r5
        L_0x0010:
            boolean r0 = r6.zzceq
            r1 = 0
            if (r0 != 0) goto L_0x001e
            r4.zzi(r1)
            java.lang.String r5 = "newState is not mediation."
        L_0x001a:
            com.google.android.gms.internal.ads.zzakb.zzdk(r5)
            return r1
        L_0x001e:
            com.google.android.gms.internal.ads.zzwx r0 = r6.zzbtw
            r2 = 1
            if (r0 == 0) goto L_0x0072
            com.google.android.gms.internal.ads.zzwx r0 = r6.zzbtw
            boolean r0 = r0.zzmf()
            if (r0 == 0) goto L_0x0072
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzvw
            boolean r0 = r0.zzfo()
            if (r0 == 0) goto L_0x0046
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzvw
            com.google.android.gms.ads.internal.zzbx r0 = r0.zzacs
            if (r0 == 0) goto L_0x0046
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzvw
            com.google.android.gms.ads.internal.zzbx r0 = r0.zzacs
            com.google.android.gms.internal.ads.zzald r0 = r0.zzfr()
            java.lang.String r3 = r6.zzcev
            r0.zzdb(r3)
        L_0x0046:
            boolean r0 = super.zza((com.google.android.gms.internal.ads.zzajh) r5, (com.google.android.gms.internal.ads.zzajh) r6)
            if (r0 != 0) goto L_0x004e
        L_0x004c:
            r5 = 0
            goto L_0x006c
        L_0x004e:
            com.google.android.gms.ads.internal.zzbw r0 = r4.zzvw
            boolean r0 = r0.zzfo()
            if (r0 == 0) goto L_0x0060
            boolean r5 = r4.zzc(r5, r6)
            if (r5 != 0) goto L_0x0060
            r4.zzi(r1)
            goto L_0x004c
        L_0x0060:
            com.google.android.gms.ads.internal.zzbw r5 = r4.zzvw
            boolean r5 = r5.zzfp()
            if (r5 != 0) goto L_0x006b
            super.zza((com.google.android.gms.internal.ads.zzajh) r6, (boolean) r1)
        L_0x006b:
            r5 = 1
        L_0x006c:
            if (r5 != 0) goto L_0x006f
            return r1
        L_0x006f:
            r4.zzws = r2
            goto L_0x0085
        L_0x0072:
            com.google.android.gms.internal.ads.zzwx r0 = r6.zzbtw
            if (r0 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzwx r0 = r6.zzbtw
            boolean r0 = r0.zzmg()
            if (r0 == 0) goto L_0x009b
            boolean r5 = r4.zzb(r5, r6)
            if (r5 != 0) goto L_0x0085
            return r1
        L_0x0085:
            java.util.ArrayList r5 = new java.util.ArrayList
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r1] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            r5.<init>(r6)
            r4.zze(r5)
            return r2
        L_0x009b:
            r4.zzi(r1)
            java.lang.String r5 = "Response is neither banner nor native."
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzq.zza(com.google.android.gms.internal.ads.zzajh, com.google.android.gms.internal.ads.zzajh):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzjj zzjj, zzajh zzajh, boolean z) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzb(@Nullable IObjectWrapper iObjectWrapper) {
        Object unwrap = iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null;
        if (unwrap instanceof zzoz) {
            ((zzoz) unwrap).zzkl();
        }
        super.zzb(this.zzvw.zzacw, false);
    }

    public final boolean zzb(zzjj zzjj) {
        zzq zzq = this;
        zzjj zzjj2 = zzjj;
        if (zzq.zzvw.zzadn != null && zzq.zzvw.zzadn.size() == 1 && zzq.zzvw.zzadn.get(0).intValue() == 2) {
            zzakb.m40e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzq.zzi(0);
            return false;
        } else if (zzq.zzvw.zzadm == null) {
            return super.zzb(zzjj);
        } else {
            if (zzjj2.zzaqb != zzq.zzvm) {
                int i = zzjj2.versionCode;
                long j = zzjj2.zzapw;
                Bundle bundle = zzjj2.extras;
                int i2 = zzjj2.zzapx;
                List<String> list = zzjj2.zzapy;
                boolean z = zzjj2.zzapz;
                int i3 = zzjj2.zzaqa;
                boolean z2 = zzjj2.zzaqb || zzq.zzvm;
                zzjj2 = new zzjj(i, j, bundle, i2, list, z, i3, z2, zzjj2.zzaqc, zzjj2.zzaqd, zzjj2.zzaqe, zzjj2.zzaqf, zzjj2.zzaqg, zzjj2.zzaqh, zzjj2.zzaqi, zzjj2.zzaqj, zzjj2.zzaqk, zzjj2.zzaql);
                zzq = this;
            }
            return super.zzb(zzjj2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbq() {
        super.zzbq();
        zzajh zzajh = this.zzvw.zzacw;
        if (zzajh != null && zzajh.zzbtw != null && zzajh.zzbtw.zzmf() && this.zzvw.zzadm != null) {
            try {
                this.zzvw.zzadm.zza(this, ObjectWrapper.wrap(this.zzvw.zzrt));
                super.zzb(this.zzvw.zzacw, false);
            } catch (RemoteException e) {
                zzakb.zzd("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzce() {
        if (this.zzvw.zzacw == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzvw.zzacw.zzbty) || this.zzvw.zzacw.zzbtw == null || !this.zzvw.zzacw.zzbtw.zzmg()) {
            super.zzce();
        } else {
            zzbs();
        }
    }

    public final void zzcj() {
        if (this.zzvw.zzacw == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzvw.zzacw.zzbty) || this.zzvw.zzacw.zzbtw == null || !this.zzvw.zzacw.zzbtw.zzmg()) {
            super.zzcj();
        } else {
            zzbr();
        }
    }

    public final void zzcr() {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    public final void zzcs() {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    public final void zzct() {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    public final boolean zzcu() {
        if (zzcw() != null) {
            return zzcw().zzbta;
        }
        return false;
    }

    public final boolean zzcv() {
        if (zzcw() != null) {
            return zzcw().zzbtb;
        }
        return false;
    }

    public final void zzd(@Nullable List<String> list) {
        Preconditions.checkMainThread("setNativeTemplates must be called on the main UI thread.");
        this.zzvw.zzads = list;
    }

    public final void zze(List<Integer> list) {
        Preconditions.checkMainThread("setAllowedAdTypes must be called on the main UI thread.");
        this.zzvw.zzadn = list;
    }

    public final void zzi(View view) {
        zzane.zzd("#005 Unexpected call to an abstract (unimplemented) method.", (Throwable) null);
    }

    @Nullable
    public final zzrc zzr(String str) {
        Preconditions.checkMainThread("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzvw.zzadh.get(str);
    }
}
