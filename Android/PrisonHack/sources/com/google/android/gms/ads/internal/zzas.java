package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzoo;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzpw;
import com.google.android.gms.internal.ads.zzpx;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class zzas {
    @VisibleForTesting
    static zzv<zzaqw> zza(@Nullable zzxz zzxz, @Nullable zzyc zzyc, zzac zzac) {
        return new zzax(zzxz, zzac, zzyc);
    }

    private static String zza(@Nullable Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzakb.zzdk("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @VisibleForTesting
    private static String zza(@Nullable zzpw zzpw) {
        if (zzpw == null) {
            zzakb.zzdk("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzpw.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException unused) {
            zzakb.zzdk("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzpw);
    }

    private static JSONObject zza(@Nullable Bundle bundle, String str) throws JSONException {
        String valueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        valueOf = zza((Bitmap) obj);
                    } else {
                        str2 = "Invalid type. An image type extra should return a bitmap";
                        zzakb.zzdk(str2);
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    str2 = "Invalid asset type. Bitmap should be returned only for image type";
                    zzakb.zzdk(str2);
                } else {
                    valueOf = String.valueOf(bundle.get(next));
                }
                jSONObject.put(next, valueOf);
            }
        }
        return jSONObject;
    }

    static final /* synthetic */ void zza(zzoo zzoo, String str, zzaqw zzaqw, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", zzoo.getHeadline());
            jSONObject.put("body", zzoo.getBody());
            jSONObject.put("call_to_action", zzoo.getCallToAction());
            jSONObject.put("price", zzoo.getPrice());
            jSONObject.put("star_rating", String.valueOf(zzoo.getStarRating()));
            jSONObject.put("store", zzoo.getStore());
            jSONObject.put("icon", zza(zzoo.zzjz()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = zzoo.getImages();
            if (images != null) {
                for (Object zzd : images) {
                    jSONArray.put(zza(zzd(zzd)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zza(zzoo.getExtras(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            zzaqw.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzakb.zzc("Exception occurred when loading assets", e);
        }
    }

    static final /* synthetic */ void zza(zzoq zzoq, String str, zzaqw zzaqw, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", zzoq.getHeadline());
            jSONObject.put("body", zzoq.getBody());
            jSONObject.put("call_to_action", zzoq.getCallToAction());
            jSONObject.put("advertiser", zzoq.getAdvertiser());
            jSONObject.put("logo", zza(zzoq.zzkg()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = zzoq.getImages();
            if (images != null) {
                for (Object zzd : images) {
                    jSONArray.put(zza(zzd(zzd)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zza(zzoq.getExtras(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            zzaqw.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzakb.zzc("Exception occurred when loading assets", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(com.google.android.gms.internal.ads.zzaqw r26, com.google.android.gms.internal.ads.zzxe r27, java.util.concurrent.CountDownLatch r28) {
        /*
            r1 = r26
            r2 = r27
            r7 = r28
            r8 = 0
            android.view.View r3 = r26.getView()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r3 != 0) goto L_0x0014
            java.lang.String r1 = "AdWebView is null"
        L_0x000f:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            goto L_0x0132
        L_0x0014:
            r4 = 4
            r3.setVisibility(r4)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzwx r3 = r2.zzbtw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.util.List<java.lang.String> r3 = r3.zzbsi     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r3 == 0) goto L_0x0121
            boolean r4 = r3.isEmpty()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r4 == 0) goto L_0x0026
            goto L_0x0121
        L_0x0026:
            java.lang.String r4 = "/nativeExpressAssetsLoaded"
            com.google.android.gms.ads.internal.zzav r5 = new com.google.android.gms.ads.internal.zzav     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r5.<init>(r7)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r1.zza((java.lang.String) r4, (com.google.android.gms.ads.internal.gmsg.zzv<? super com.google.android.gms.internal.ads.zzaqw>) r5)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r4 = "/nativeExpressAssetsLoadingFailed"
            com.google.android.gms.ads.internal.zzaw r5 = new com.google.android.gms.ads.internal.zzaw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r5.<init>(r7)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r1.zza((java.lang.String) r4, (com.google.android.gms.ads.internal.gmsg.zzv<? super com.google.android.gms.internal.ads.zzaqw>) r5)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzxq r4 = r2.zzbtx     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzxz r4 = r4.zzmo()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzxq r5 = r2.zzbtx     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzyc r5 = r5.zzmp()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r6 = "2"
            boolean r6 = r3.contains(r6)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r9 = 0
            if (r6 == 0) goto L_0x00a9
            if (r4 == 0) goto L_0x00a9
            com.google.android.gms.internal.ads.zzoo r3 = new com.google.android.gms.internal.ads.zzoo     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r11 = r4.getHeadline()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.util.List r12 = r4.getImages()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r13 = r4.getBody()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzpw r14 = r4.zzjz()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r15 = r4.getCallToAction()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            double r16 = r4.getStarRating()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r18 = r4.getStore()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r19 = r4.getPrice()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r20 = 0
            android.os.Bundle r21 = r4.getExtras()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r22 = 0
            com.google.android.gms.dynamic.IObjectWrapper r5 = r4.zzmw()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r5 == 0) goto L_0x008c
            com.google.android.gms.dynamic.IObjectWrapper r5 = r4.zzmw()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.Object r5 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r9 = r5
            android.view.View r9 = (android.view.View) r9     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
        L_0x008c:
            r23 = r9
            com.google.android.gms.dynamic.IObjectWrapper r24 = r4.zzke()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r25 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzwx r4 = r2.zzbtw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r4 = r4.zzbsh     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzasc r5 = r26.zzuf()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.ads.internal.zzat r6 = new com.google.android.gms.ads.internal.zzat     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r6.<init>(r3, r4, r1)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
        L_0x00a5:
            r5.zza((com.google.android.gms.internal.ads.zzasd) r6)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            goto L_0x0100
        L_0x00a9:
            java.lang.String r4 = "1"
            boolean r3 = r3.contains(r4)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r3 == 0) goto L_0x011d
            if (r5 == 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzoq r3 = new com.google.android.gms.internal.ads.zzoq     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r11 = r5.getHeadline()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.util.List r12 = r5.getImages()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r13 = r5.getBody()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzpw r14 = r5.zzkg()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r15 = r5.getCallToAction()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r16 = r5.getAdvertiser()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r17 = 0
            android.os.Bundle r18 = r5.getExtras()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r19 = 0
            com.google.android.gms.dynamic.IObjectWrapper r4 = r5.zzmw()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r4 == 0) goto L_0x00e6
            com.google.android.gms.dynamic.IObjectWrapper r4 = r5.zzmw()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r9 = r4
            android.view.View r9 = (android.view.View) r9     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
        L_0x00e6:
            r20 = r9
            com.google.android.gms.dynamic.IObjectWrapper r21 = r5.zzke()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r22 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzwx r4 = r2.zzbtw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r4 = r4.zzbsh     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzasc r5 = r26.zzuf()     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.ads.internal.zzau r6 = new com.google.android.gms.ads.internal.zzau     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            r6.<init>(r3, r4, r1)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            goto L_0x00a5
        L_0x0100:
            com.google.android.gms.internal.ads.zzwx r3 = r2.zzbtw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r3 = r3.zzbsf     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            com.google.android.gms.internal.ads.zzwx r2 = r2.zzbtw     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            java.lang.String r2 = r2.zzbsg     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            if (r2 == 0) goto L_0x0113
            java.lang.String r4 = "text/html"
            java.lang.String r5 = "UTF-8"
            r6 = 0
            r1.loadDataWithBaseURL(r2, r3, r4, r5, r6)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
            goto L_0x011a
        L_0x0113:
            java.lang.String r2 = "text/html"
            java.lang.String r4 = "UTF-8"
            r1.loadData(r3, r2, r4)     // Catch:{ RemoteException -> 0x012b, RuntimeException -> 0x0125 }
        L_0x011a:
            r1 = 1
            r8 = 1
            goto L_0x0132
        L_0x011d:
            java.lang.String r1 = "No matching template id and mapper"
            goto L_0x000f
        L_0x0121:
            java.lang.String r1 = "No template ids present in mediation response"
            goto L_0x000f
        L_0x0125:
            r0 = move-exception
            r1 = r0
            r28.countDown()
            throw r1
        L_0x012b:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "Unable to invoke load assets"
            com.google.android.gms.internal.ads.zzakb.zzc(r2, r1)
        L_0x0132:
            if (r8 != 0) goto L_0x0137
            r28.countDown()
        L_0x0137:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzas.zza(com.google.android.gms.internal.ads.zzaqw, com.google.android.gms.internal.ads.zzxe, java.util.concurrent.CountDownLatch):boolean");
    }

    private static String zzb(zzpw zzpw) {
        try {
            IObjectWrapper zzjy = zzpw.zzjy();
            if (zzjy == null) {
                zzakb.zzdk("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) ObjectWrapper.unwrap(zzjy);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzakb.zzdk("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException unused) {
            zzakb.zzdk("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    @Nullable
    private static zzpw zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzpx.zzh((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void zzd(zzaqw zzaqw) {
        View.OnClickListener onClickListener = zzaqw.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(zzaqw.getView());
        }
    }

    @Nullable
    public static View zze(@Nullable zzajh zzajh) {
        if (zzajh == null) {
            zzakb.m40e("AdState is null");
            return null;
        } else if (zzf(zzajh) && zzajh.zzbyo != null) {
            return zzajh.zzbyo.getView();
        } else {
            try {
                IObjectWrapper view = zzajh.zzbtx != null ? zzajh.zzbtx.getView() : null;
                if (view != null) {
                    return (View) ObjectWrapper.unwrap(view);
                }
                zzakb.zzdk("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzakb.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzf(@Nullable zzajh zzajh) {
        return (zzajh == null || !zzajh.zzceq || zzajh.zzbtw == null || zzajh.zzbtw.zzbsf == null) ? false : true;
    }
}
