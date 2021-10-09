package com.google.android.gms.internal.ads;

import android.location.Location;
import android.support.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

@zzadh
public final class zzafs {
    private static final SimpleDateFormat zzcho = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b4 A[Catch:{ JSONException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d9 A[Catch:{ JSONException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1 A[Catch:{ JSONException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7 A[Catch:{ JSONException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0161 A[Catch:{ JSONException -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016a A[Catch:{ JSONException -> 0x0270 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaej zza(android.content.Context r57, com.google.android.gms.internal.ads.zzaef r58, java.lang.String r59) {
        /*
            r10 = r58
            r15 = 0
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0270 }
            r1 = r59
            r11.<init>(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "ad_base_url"
            r12 = 0
            java.lang.String r1 = r11.optString(r1, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r2 = "ad_url"
            java.lang.String r4 = r11.optString(r2, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r2 = "ad_size"
            java.lang.String r13 = r11.optString(r2, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r2 = "ad_slot_size"
            java.lang.String r40 = r11.optString(r2, r13)     // Catch:{ JSONException -> 0x0270 }
            if (r10 == 0) goto L_0x002c
            int r2 = r10.zzcdb     // Catch:{ JSONException -> 0x0270 }
            if (r2 == 0) goto L_0x002c
            r24 = 1
            goto L_0x002e
        L_0x002c:
            r24 = 0
        L_0x002e:
            java.lang.String r2 = "ad_json"
            java.lang.String r2 = r11.optString(r2, r12)     // Catch:{ JSONException -> 0x0270 }
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = "ad_html"
            java.lang.String r2 = r11.optString(r2, r12)     // Catch:{ JSONException -> 0x0270 }
        L_0x003c:
            if (r2 != 0) goto L_0x0044
            java.lang.String r2 = "body"
            java.lang.String r2 = r11.optString(r2, r12)     // Catch:{ JSONException -> 0x0270 }
        L_0x0044:
            if (r2 != 0) goto L_0x0052
            java.lang.String r3 = "ads"
            boolean r3 = r11.has(r3)     // Catch:{ JSONException -> 0x0270 }
            if (r3 == 0) goto L_0x0052
            java.lang.String r2 = r11.toString()     // Catch:{ JSONException -> 0x0270 }
        L_0x0052:
            java.lang.String r3 = "debug_dialog"
            java.lang.String r19 = r11.optString(r3, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r3 = "debug_signals"
            java.lang.String r42 = r11.optString(r3, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r3 = "interstitial_timeout"
            boolean r3 = r11.has(r3)     // Catch:{ JSONException -> 0x0270 }
            r8 = -1
            if (r3 == 0) goto L_0x0079
            java.lang.String r3 = "interstitial_timeout"
            double r5 = r11.getDouble(r3)     // Catch:{ JSONException -> 0x0270 }
            r16 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = r5 * r16
            long r5 = (long) r5     // Catch:{ JSONException -> 0x0270 }
            r16 = r5
            goto L_0x007b
        L_0x0079:
            r16 = r8
        L_0x007b:
            java.lang.String r3 = "orientation"
            java.lang.String r3 = r11.optString(r3, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r5 = "portrait"
            boolean r5 = r5.equals(r3)     // Catch:{ JSONException -> 0x0270 }
            r7 = -1
            if (r5 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzakq r3 = com.google.android.gms.ads.internal.zzbv.zzem()     // Catch:{ JSONException -> 0x0270 }
            int r3 = r3.zzrm()     // Catch:{ JSONException -> 0x0270 }
        L_0x0092:
            r18 = r3
            goto L_0x00a8
        L_0x0095:
            java.lang.String r5 = "landscape"
            boolean r3 = r5.equals(r3)     // Catch:{ JSONException -> 0x0270 }
            if (r3 == 0) goto L_0x00a6
            com.google.android.gms.internal.ads.zzakq r3 = com.google.android.gms.ads.internal.zzbv.zzem()     // Catch:{ JSONException -> 0x0270 }
            int r3 = r3.zzrl()     // Catch:{ JSONException -> 0x0270 }
            goto L_0x0092
        L_0x00a6:
            r18 = -1
        L_0x00a8:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0270 }
            if (r3 == 0) goto L_0x00d9
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0270 }
            if (r3 != 0) goto L_0x00d9
            com.google.android.gms.internal.ads.zzang r1 = r10.zzacr     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r3 = r1.zzcw     // Catch:{ JSONException -> 0x0270 }
            r5 = 0
            r6 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r1 = r10
            r2 = r57
            r14 = -1
            r7 = r20
            r8 = r21
            r9 = r22
            com.google.android.gms.internal.ads.zzaej r1 = com.google.android.gms.internal.ads.zzafn.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r2 = r1.zzbyq     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r3 = r1.zzceo     // Catch:{ JSONException -> 0x0270 }
            long r4 = r1.zzceu     // Catch:{ JSONException -> 0x0270 }
            r20 = r4
            r4 = r3
            r3 = r2
            goto L_0x00df
        L_0x00d9:
            r14 = -1
            r3 = r1
            r4 = r2
            r1 = r12
            r20 = -1
        L_0x00df:
            if (r4 != 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej     // Catch:{ JSONException -> 0x0270 }
            r1.<init>(r15)     // Catch:{ JSONException -> 0x0270 }
            return r1
        L_0x00e7:
            java.lang.String r2 = "click_urls"
            org.json.JSONArray r2 = r11.optJSONArray(r2)     // Catch:{ JSONException -> 0x0270 }
            if (r1 != 0) goto L_0x00f1
            r5 = r12
            goto L_0x00f3
        L_0x00f1:
            java.util.List<java.lang.String> r5 = r1.zzbsn     // Catch:{ JSONException -> 0x0270 }
        L_0x00f3:
            if (r2 == 0) goto L_0x00fa
            java.util.List r2 = zza((org.json.JSONArray) r2, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x0270 }
            r5 = r2
        L_0x00fa:
            java.lang.String r2 = "impression_urls"
            org.json.JSONArray r2 = r11.optJSONArray(r2)     // Catch:{ JSONException -> 0x0270 }
            if (r1 != 0) goto L_0x0104
            r6 = r12
            goto L_0x0106
        L_0x0104:
            java.util.List<java.lang.String> r6 = r1.zzbso     // Catch:{ JSONException -> 0x0270 }
        L_0x0106:
            if (r2 == 0) goto L_0x010d
            java.util.List r2 = zza((org.json.JSONArray) r2, (java.util.List<java.lang.String>) r6)     // Catch:{ JSONException -> 0x0270 }
            r6 = r2
        L_0x010d:
            java.lang.String r2 = "downloaded_impression_urls"
            org.json.JSONArray r2 = r11.optJSONArray(r2)     // Catch:{ JSONException -> 0x0270 }
            if (r1 != 0) goto L_0x0117
            r7 = r12
            goto L_0x0119
        L_0x0117:
            java.util.List<java.lang.String> r7 = r1.zzbsp     // Catch:{ JSONException -> 0x0270 }
        L_0x0119:
            if (r2 == 0) goto L_0x0122
            java.util.List r2 = zza((org.json.JSONArray) r2, (java.util.List<java.lang.String>) r7)     // Catch:{ JSONException -> 0x0270 }
            r48 = r2
            goto L_0x0124
        L_0x0122:
            r48 = r7
        L_0x0124:
            java.lang.String r2 = "manual_impression_urls"
            org.json.JSONArray r2 = r11.optJSONArray(r2)     // Catch:{ JSONException -> 0x0270 }
            if (r1 != 0) goto L_0x012e
            r7 = r12
            goto L_0x0130
        L_0x012e:
            java.util.List<java.lang.String> r7 = r1.zzces     // Catch:{ JSONException -> 0x0270 }
        L_0x0130:
            if (r2 == 0) goto L_0x0139
            java.util.List r2 = zza((org.json.JSONArray) r2, (java.util.List<java.lang.String>) r7)     // Catch:{ JSONException -> 0x0270 }
            r22 = r2
            goto L_0x013b
        L_0x0139:
            r22 = r7
        L_0x013b:
            if (r1 == 0) goto L_0x0151
            int r2 = r1.orientation     // Catch:{ JSONException -> 0x0270 }
            if (r2 == r14) goto L_0x0145
            int r2 = r1.orientation     // Catch:{ JSONException -> 0x0270 }
            r18 = r2
        L_0x0145:
            long r7 = r1.zzcep     // Catch:{ JSONException -> 0x0270 }
            r25 = 0
            int r2 = (r7 > r25 ? 1 : (r7 == r25 ? 0 : -1))
            if (r2 <= 0) goto L_0x0151
            long r1 = r1.zzcep     // Catch:{ JSONException -> 0x0270 }
            r7 = r1
            goto L_0x0153
        L_0x0151:
            r7 = r16
        L_0x0153:
            java.lang.String r1 = "active_view"
            java.lang.String r23 = r11.optString(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "ad_is_javascript"
            boolean r25 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            if (r25 == 0) goto L_0x016a
            java.lang.String r1 = "ad_passback_url"
            java.lang.String r1 = r11.optString(r1, r12)     // Catch:{ JSONException -> 0x0270 }
            r26 = r1
            goto L_0x016c
        L_0x016a:
            r26 = r12
        L_0x016c:
            java.lang.String r1 = "mediation"
            boolean r9 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "custom_render_allowed"
            boolean r27 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "content_url_opted_out"
            r2 = 1
            boolean r28 = r11.optBoolean(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "content_vertical_opted_out"
            boolean r43 = r11.optBoolean(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "prefetch"
            boolean r29 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "refresh_interval_milliseconds"
            r55 = r13
            r12 = -1
            long r16 = r11.optLong(r1, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "mediation_config_cache_time_milliseconds"
            long r12 = r11.optLong(r1, r12)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "gws_query_id"
            java.lang.String r2 = ""
            java.lang.String r30 = r11.optString(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "height"
            java.lang.String r2 = "fluid"
            java.lang.String r14 = ""
            java.lang.String r2 = r11.optString(r2, r14)     // Catch:{ JSONException -> 0x0270 }
            boolean r31 = r1.equals(r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "native_express"
            boolean r32 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "video_start_urls"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ JSONException -> 0x0270 }
            r2 = 0
            java.util.List r33 = zza((org.json.JSONArray) r1, (java.util.List<java.lang.String>) r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "video_complete_urls"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ JSONException -> 0x0270 }
            java.util.List r34 = zza((org.json.JSONArray) r1, (java.util.List<java.lang.String>) r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "rewards"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ JSONException -> 0x0270 }
            com.google.android.gms.internal.ads.zzaig r35 = com.google.android.gms.internal.ads.zzaig.zza(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "use_displayed_impression"
            boolean r36 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "auto_protection_configuration"
            org.json.JSONObject r1 = r11.optJSONObject(r1)     // Catch:{ JSONException -> 0x0270 }
            com.google.android.gms.internal.ads.zzael r37 = com.google.android.gms.internal.ads.zzael.zzl(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "set_cookie"
            java.lang.String r2 = ""
            java.lang.String r38 = r11.optString(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "remote_ping_urls"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ JSONException -> 0x0270 }
            r2 = 0
            java.util.List r39 = zza((org.json.JSONArray) r1, (java.util.List<java.lang.String>) r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "safe_browsing"
            org.json.JSONObject r1 = r11.optJSONObject(r1)     // Catch:{ JSONException -> 0x0270 }
            com.google.android.gms.internal.ads.zzaiq r41 = com.google.android.gms.internal.ads.zzaiq.zzo(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "render_in_browser"
            boolean r2 = r10.zzbss     // Catch:{ JSONException -> 0x0270 }
            boolean r44 = r11.optBoolean(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "custom_close_blocked"
            boolean r45 = r11.optBoolean(r1)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "enable_omid"
            boolean r47 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "omid_settings"
            r2 = 0
            java.lang.String r50 = r11.optString(r1, r2)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r1 = "disable_closable_area"
            boolean r49 = r11.optBoolean(r1, r15)     // Catch:{ JSONException -> 0x0270 }
            com.google.android.gms.internal.ads.zzaej r51 = new com.google.android.gms.internal.ads.zzaej     // Catch:{ JSONException -> 0x0270 }
            boolean r14 = r10.zzcdd     // Catch:{ JSONException -> 0x0270 }
            boolean r11 = r10.zzcdr     // Catch:{ JSONException -> 0x0270 }
            boolean r2 = r10.zzced     // Catch:{ JSONException -> 0x0270 }
            r46 = 0
            r1 = r51
            r52 = r2
            r2 = r10
            r53 = r11
            r10 = r12
            r12 = r22
            r54 = r14
            r22 = r55
            r13 = r16
            r15 = r18
            r16 = r22
            r17 = r20
            r20 = r25
            r21 = r26
            r22 = r23
            r23 = r27
            r25 = r54
            r26 = r28
            r27 = r29
            r28 = r30
            r29 = r31
            r30 = r32
            r31 = r35
            r32 = r33
            r33 = r34
            r34 = r36
            r35 = r37
            r36 = r53
            r37 = r38
            r38 = r39
            r39 = r44
            r44 = r52
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r12, r13, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)     // Catch:{ JSONException -> 0x0270 }
            return r51
        L_0x0270:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "Could not parse the inline ad response: "
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x0287
            java.lang.String r1 = r2.concat(r1)
            goto L_0x028c
        L_0x0287:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x028c:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)
            com.google.android.gms.internal.ads.zzaej r1 = new com.google.android.gms.internal.ads.zzaej
            r2 = 0
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafs.zza(android.content.Context, com.google.android.gms.internal.ads.zzaef, java.lang.String):com.google.android.gms.internal.ads.zzaej");
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:304:0x081d A[Catch:{ JSONException -> 0x0934 }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0820 A[Catch:{ JSONException -> 0x0934 }] */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zza(android.content.Context r25, com.google.android.gms.internal.ads.zzafl r26) {
        /*
            r1 = r26
            com.google.android.gms.internal.ads.zzaef r2 = r1.zzcgs
            android.location.Location r3 = r1.zzaqe
            com.google.android.gms.internal.ads.zzaga r4 = r1.zzcgt
            android.os.Bundle r5 = r1.zzcdc
            org.json.JSONObject r6 = r1.zzcgu
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ JSONException -> 0x0934 }
            r8.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "extra_caps"
            com.google.android.gms.internal.ads.zzna<java.lang.String> r10 = com.google.android.gms.internal.ads.zznk.zzbbk     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r11 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r10 = r11.zzd(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r9, r10)     // Catch:{ JSONException -> 0x0934 }
            java.util.List<java.lang.String> r9 = r1.zzcdj     // Catch:{ JSONException -> 0x0934 }
            int r9 = r9.size()     // Catch:{ JSONException -> 0x0934 }
            if (r9 <= 0) goto L_0x0035
            java.lang.String r9 = "eid"
            java.lang.String r10 = ","
            java.util.List<java.lang.String> r11 = r1.zzcdj     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = android.text.TextUtils.join(r10, r11)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r9, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0035:
            android.os.Bundle r9 = r2.zzccu     // Catch:{ JSONException -> 0x0934 }
            if (r9 == 0) goto L_0x0040
            java.lang.String r9 = "ad_pos"
            android.os.Bundle r10 = r2.zzccu     // Catch:{ JSONException -> 0x0934 }
            r8.put(r9, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0040:
            com.google.android.gms.internal.ads.zzjj r9 = r2.zzccv     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = com.google.android.gms.internal.ads.zzajw.zzqn()     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x004d
            java.lang.String r11 = "abf"
            r8.put(r11, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x004d:
            long r10 = r9.zzapw     // Catch:{ JSONException -> 0x0934 }
            r12 = -1
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0067
            java.lang.String r10 = "cust_age"
            java.text.SimpleDateFormat r11 = zzcho     // Catch:{ JSONException -> 0x0934 }
            java.util.Date r14 = new java.util.Date     // Catch:{ JSONException -> 0x0934 }
            long r12 = r9.zzapw     // Catch:{ JSONException -> 0x0934 }
            r14.<init>(r12)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r11 = r11.format(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r11)     // Catch:{ JSONException -> 0x0934 }
        L_0x0067:
            android.os.Bundle r10 = r9.extras     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x0072
            java.lang.String r10 = "extras"
            android.os.Bundle r11 = r9.extras     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r11)     // Catch:{ JSONException -> 0x0934 }
        L_0x0072:
            int r10 = r9.zzapx     // Catch:{ JSONException -> 0x0934 }
            r11 = -1
            if (r10 == r11) goto L_0x0082
            java.lang.String r10 = "cust_gender"
            int r12 = r9.zzapx     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r12)     // Catch:{ JSONException -> 0x0934 }
        L_0x0082:
            java.util.List<java.lang.String> r10 = r9.zzapy     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x008d
            java.lang.String r10 = "kw"
            java.util.List<java.lang.String> r12 = r9.zzapy     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r12)     // Catch:{ JSONException -> 0x0934 }
        L_0x008d:
            int r10 = r9.zzaqa     // Catch:{ JSONException -> 0x0934 }
            if (r10 == r11) goto L_0x009c
            java.lang.String r10 = "tag_for_child_directed_treatment"
            int r12 = r9.zzaqa     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r12)     // Catch:{ JSONException -> 0x0934 }
        L_0x009c:
            boolean r10 = r9.zzapz     // Catch:{ JSONException -> 0x0934 }
            r12 = 1
            if (r10 == 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r10 = com.google.android.gms.internal.ads.zznk.zzbfp     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r13 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r10 = r13.zzd(r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ JSONException -> 0x0934 }
            boolean r10 = r10.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x00bd
            java.lang.String r10 = "test_request"
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)     // Catch:{ JSONException -> 0x0934 }
        L_0x00b9:
            r8.put(r10, r13)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r10 = "adtest"
            java.lang.String r13 = "on"
            goto L_0x00b9
        L_0x00c2:
            int r10 = r9.versionCode     // Catch:{ JSONException -> 0x0934 }
            r13 = 2
            if (r10 < r13) goto L_0x00e3
            boolean r10 = r9.zzaqb     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x00d4
            java.lang.String r10 = "d_imp_hdr"
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x00d4:
            java.lang.String r10 = r9.zzaqc     // Catch:{ JSONException -> 0x0934 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x0934 }
            if (r10 != 0) goto L_0x00e3
            java.lang.String r10 = "ppid"
            java.lang.String r14 = r9.zzaqc     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x00e3:
            int r10 = r9.versionCode     // Catch:{ JSONException -> 0x0934 }
            r14 = 3
            if (r10 < r14) goto L_0x00f3
            java.lang.String r10 = r9.zzaqf     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x00f3
            java.lang.String r10 = "url"
            java.lang.String r14 = r9.zzaqf     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x00f3:
            int r10 = r9.versionCode     // Catch:{ JSONException -> 0x0934 }
            r14 = 5
            if (r10 < r14) goto L_0x0119
            android.os.Bundle r10 = r9.zzaqh     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x0103
            java.lang.String r10 = "custom_targeting"
            android.os.Bundle r15 = r9.zzaqh     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r15)     // Catch:{ JSONException -> 0x0934 }
        L_0x0103:
            java.util.List<java.lang.String> r10 = r9.zzaqi     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x010e
            java.lang.String r10 = "category_exclusions"
            java.util.List<java.lang.String> r15 = r9.zzaqi     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r15)     // Catch:{ JSONException -> 0x0934 }
        L_0x010e:
            java.lang.String r10 = r9.zzaqj     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x0119
            java.lang.String r10 = "request_agent"
            java.lang.String r15 = r9.zzaqj     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r15)     // Catch:{ JSONException -> 0x0934 }
        L_0x0119:
            int r10 = r9.versionCode     // Catch:{ JSONException -> 0x0934 }
            r15 = 6
            if (r10 < r15) goto L_0x0129
            java.lang.String r10 = r9.zzaqk     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x0129
            java.lang.String r10 = "request_pkg"
            java.lang.String r7 = r9.zzaqk     // Catch:{ JSONException -> 0x0934 }
            r8.put(r10, r7)     // Catch:{ JSONException -> 0x0934 }
        L_0x0129:
            int r7 = r9.versionCode     // Catch:{ JSONException -> 0x0934 }
            r10 = 7
            if (r7 < r10) goto L_0x0139
            java.lang.String r7 = "is_designed_for_families"
            boolean r9 = r9.zzaql     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r9)     // Catch:{ JSONException -> 0x0934 }
        L_0x0139:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn[] r7 = r7.zzard     // Catch:{ JSONException -> 0x0934 }
            if (r7 != 0) goto L_0x0156
            java.lang.String r7 = "format"
            com.google.android.gms.internal.ads.zzjn r10 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = r10.zzarb     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            boolean r7 = r7.zzarf     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x018c
            java.lang.String r7 = "fluid"
            java.lang.String r10 = "height"
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x018c
        L_0x0156:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn[] r7 = r7.zzard     // Catch:{ JSONException -> 0x0934 }
            int r10 = r7.length     // Catch:{ JSONException -> 0x0934 }
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0160:
            if (r15 >= r10) goto L_0x018c
            r14 = r7[r15]     // Catch:{ JSONException -> 0x0934 }
            boolean r12 = r14.zzarf     // Catch:{ JSONException -> 0x0934 }
            if (r12 != 0) goto L_0x0173
            if (r16 != 0) goto L_0x0173
            java.lang.String r12 = "format"
            java.lang.String r13 = r14.zzarb     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            r16 = 1
        L_0x0173:
            boolean r12 = r14.zzarf     // Catch:{ JSONException -> 0x0934 }
            if (r12 == 0) goto L_0x0182
            if (r17 != 0) goto L_0x0182
            java.lang.String r12 = "fluid"
            java.lang.String r13 = "height"
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            r17 = 1
        L_0x0182:
            if (r16 == 0) goto L_0x0186
            if (r17 != 0) goto L_0x018c
        L_0x0186:
            int r15 = r15 + 1
            r12 = 1
            r13 = 2
            r14 = 5
            goto L_0x0160
        L_0x018c:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            int r7 = r7.width     // Catch:{ JSONException -> 0x0934 }
            if (r7 != r11) goto L_0x0199
            java.lang.String r7 = "smart_w"
            java.lang.String r10 = "full"
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0199:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            int r7 = r7.height     // Catch:{ JSONException -> 0x0934 }
            r10 = -2
            if (r7 != r10) goto L_0x01a7
            java.lang.String r7 = "smart_h"
            java.lang.String r12 = "auto"
            r8.put(r7, r12)     // Catch:{ JSONException -> 0x0934 }
        L_0x01a7:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn[] r7 = r7.zzard     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x0215
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0934 }
            r7.<init>()     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn r12 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzjn[] r12 = r12.zzard     // Catch:{ JSONException -> 0x0934 }
            int r13 = r12.length     // Catch:{ JSONException -> 0x0934 }
            r14 = 0
            r15 = 0
        L_0x01b9:
            if (r14 >= r13) goto L_0x01fb
            r9 = r12[r14]     // Catch:{ JSONException -> 0x0934 }
            boolean r10 = r9.zzarf     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x01c3
            r15 = 1
            goto L_0x01f6
        L_0x01c3:
            int r10 = r7.length()     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x01ce
            java.lang.String r10 = "|"
            r7.append(r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x01ce:
            int r10 = r9.width     // Catch:{ JSONException -> 0x0934 }
            if (r10 != r11) goto L_0x01da
            int r10 = r9.widthPixels     // Catch:{ JSONException -> 0x0934 }
            float r10 = (float) r10     // Catch:{ JSONException -> 0x0934 }
            float r11 = r4.zzagu     // Catch:{ JSONException -> 0x0934 }
            float r10 = r10 / r11
            int r10 = (int) r10     // Catch:{ JSONException -> 0x0934 }
            goto L_0x01dc
        L_0x01da:
            int r10 = r9.width     // Catch:{ JSONException -> 0x0934 }
        L_0x01dc:
            r7.append(r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = "x"
            r7.append(r10)     // Catch:{ JSONException -> 0x0934 }
            int r10 = r9.height     // Catch:{ JSONException -> 0x0934 }
            r11 = -2
            if (r10 != r11) goto L_0x01f1
            int r9 = r9.heightPixels     // Catch:{ JSONException -> 0x0934 }
            float r9 = (float) r9     // Catch:{ JSONException -> 0x0934 }
            float r10 = r4.zzagu     // Catch:{ JSONException -> 0x0934 }
            float r9 = r9 / r10
            int r9 = (int) r9     // Catch:{ JSONException -> 0x0934 }
            goto L_0x01f3
        L_0x01f1:
            int r9 = r9.height     // Catch:{ JSONException -> 0x0934 }
        L_0x01f3:
            r7.append(r9)     // Catch:{ JSONException -> 0x0934 }
        L_0x01f6:
            int r14 = r14 + 1
            r10 = -2
            r11 = -1
            goto L_0x01b9
        L_0x01fb:
            if (r15 == 0) goto L_0x0210
            int r9 = r7.length()     // Catch:{ JSONException -> 0x0934 }
            if (r9 == 0) goto L_0x020a
            java.lang.String r9 = "|"
            r10 = 0
            r7.insert(r10, r9)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x020b
        L_0x020a:
            r10 = 0
        L_0x020b:
            java.lang.String r9 = "320x50"
            r7.insert(r10, r9)     // Catch:{ JSONException -> 0x0934 }
        L_0x0210:
            java.lang.String r9 = "sz"
            r8.put(r9, r7)     // Catch:{ JSONException -> 0x0934 }
        L_0x0215:
            int r7 = r2.zzcdb     // Catch:{ JSONException -> 0x0934 }
            r9 = 24
            if (r7 == 0) goto L_0x0280
            java.lang.String r7 = "native_version"
            int r10 = r2.zzcdb     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "native_templates"
            java.util.List<java.lang.String> r10 = r2.zzads     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "native_image_orientation"
            com.google.android.gms.internal.ads.zzpl r10 = r2.zzadj     // Catch:{ JSONException -> 0x0934 }
            if (r10 != 0) goto L_0x0236
        L_0x0233:
            java.lang.String r10 = "any"
            goto L_0x0243
        L_0x0236:
            int r10 = r10.zzbjo     // Catch:{ JSONException -> 0x0934 }
            switch(r10) {
                case 0: goto L_0x0233;
                case 1: goto L_0x0241;
                case 2: goto L_0x023e;
                default: goto L_0x023b;
            }     // Catch:{ JSONException -> 0x0934 }
        L_0x023b:
            java.lang.String r10 = "not_set"
            goto L_0x0243
        L_0x023e:
            java.lang.String r10 = "landscape"
            goto L_0x0243
        L_0x0241:
            java.lang.String r10 = "portrait"
        L_0x0243:
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.util.List<java.lang.String> r7 = r2.zzcdk     // Catch:{ JSONException -> 0x0934 }
            boolean r7 = r7.isEmpty()     // Catch:{ JSONException -> 0x0934 }
            if (r7 != 0) goto L_0x0255
            java.lang.String r7 = "native_custom_templates"
            java.util.List<java.lang.String> r10 = r2.zzcdk     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0255:
            int r7 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            if (r7 < r9) goto L_0x0264
            java.lang.String r7 = "max_num_ads"
            int r10 = r2.zzceg     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0264:
            java.lang.String r7 = r2.zzcee     // Catch:{ JSONException -> 0x0934 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0934 }
            if (r7 != 0) goto L_0x0280
            java.lang.String r7 = "native_advanced_settings"
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0279 }
            java.lang.String r11 = r2.zzcee     // Catch:{ JSONException -> 0x0279 }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x0279 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0279 }
            goto L_0x0280
        L_0x0279:
            r0 = move-exception
            r7 = r0
            java.lang.String r10 = "Problem creating json from native advanced settings"
            com.google.android.gms.internal.ads.zzakb.zzc(r10, r7)     // Catch:{ JSONException -> 0x0934 }
        L_0x0280:
            java.util.List<java.lang.Integer> r7 = r2.zzadn     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x02be
            java.util.List<java.lang.Integer> r7 = r2.zzadn     // Catch:{ JSONException -> 0x0934 }
            int r7 = r7.size()     // Catch:{ JSONException -> 0x0934 }
            if (r7 <= 0) goto L_0x02be
            java.util.List<java.lang.Integer> r7 = r2.zzadn     // Catch:{ JSONException -> 0x0934 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ JSONException -> 0x0934 }
        L_0x0292:
            boolean r10 = r7.hasNext()     // Catch:{ JSONException -> 0x0934 }
            if (r10 == 0) goto L_0x02be
            java.lang.Object r10 = r7.next()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ JSONException -> 0x0934 }
            int r11 = r10.intValue()     // Catch:{ JSONException -> 0x0934 }
            r12 = 2
            if (r11 != r12) goto L_0x02b0
            java.lang.String r10 = "iba"
            r11 = 1
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r11)     // Catch:{ JSONException -> 0x0934 }
        L_0x02ac:
            r8.put(r10, r12)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x0292
        L_0x02b0:
            int r10 = r10.intValue()     // Catch:{ JSONException -> 0x0934 }
            r11 = 1
            if (r10 != r11) goto L_0x0292
            java.lang.String r10 = "ina"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r11)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x02ac
        L_0x02be:
            com.google.android.gms.internal.ads.zzjn r7 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            boolean r7 = r7.zzarg     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x02ce
            java.lang.String r7 = "ene"
            r10 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r11)     // Catch:{ JSONException -> 0x0934 }
        L_0x02ce:
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zznk.zzaxv     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r10 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r7 = r10.zzd(r7)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ JSONException -> 0x0934 }
            boolean r7 = r7.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x02ea
            java.lang.String r7 = "xsrve"
            r10 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r11)     // Catch:{ JSONException -> 0x0934 }
        L_0x02ea:
            com.google.android.gms.internal.ads.zzlu r7 = r2.zzadl     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x0305
            java.lang.String r7 = "is_icon_ad"
            r10 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r11)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "icon_ad_expansion_behavior"
            com.google.android.gms.internal.ads.zzlu r10 = r2.zzadl     // Catch:{ JSONException -> 0x0934 }
            int r10 = r10.zzasj     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0305:
            java.lang.String r7 = "slotname"
            java.lang.String r10 = r2.zzacp     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "pn"
            android.content.pm.ApplicationInfo r10 = r2.applicationInfo     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = r10.packageName     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            android.content.pm.PackageInfo r7 = r2.zzccw     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x0326
            java.lang.String r7 = "vc"
            android.content.pm.PackageInfo r10 = r2.zzccw     // Catch:{ JSONException -> 0x0934 }
            int r10 = r10.versionCode     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0326:
            java.lang.String r7 = "ms"
            java.lang.String r10 = r1.zzccx     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "seq_num"
            java.lang.String r10 = r2.zzccy     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "session_id"
            java.lang.String r10 = r2.zzccz     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "js"
            com.google.android.gms.internal.ads.zzang r10 = r2.zzacr     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = r10.zzcw     // Catch:{ JSONException -> 0x0934 }
            r8.put(r7, r10)     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzagk r7 = r1.zzcgo     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r10 = r2.zzcdw     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r11 = r1.zzcgn     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "am"
            int r13 = r4.zzcjk     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "cog"
            boolean r13 = r4.zzcjl     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r13 = zzv(r13)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "coh"
            boolean r13 = r4.zzcjm     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r13 = zzv(r13)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = r4.zzcjn     // Catch:{ JSONException -> 0x0934 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0934 }
            if (r12 != 0) goto L_0x037a
            java.lang.String r12 = "carrier"
            java.lang.String r13 = r4.zzcjn     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
        L_0x037a:
            java.lang.String r12 = "gl"
            java.lang.String r13 = r4.zzcjo     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r13)     // Catch:{ JSONException -> 0x0934 }
            boolean r12 = r4.zzcjp     // Catch:{ JSONException -> 0x0934 }
            if (r12 == 0) goto L_0x038f
            java.lang.String r12 = "simulator"
            r13 = 1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x038f:
            boolean r12 = r4.zzcjq     // Catch:{ JSONException -> 0x0934 }
            if (r12 == 0) goto L_0x039e
            java.lang.String r12 = "is_sidewinder"
            r13 = 1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x039f
        L_0x039e:
            r13 = 1
        L_0x039f:
            java.lang.String r12 = "ma"
            boolean r14 = r4.zzcjr     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = zzv(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "sp"
            boolean r14 = r4.zzcjs     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = zzv(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "hl"
            java.lang.String r14 = r4.zzcjt     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = r4.zzcju     // Catch:{ JSONException -> 0x0934 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0934 }
            if (r12 != 0) goto L_0x03cb
            java.lang.String r12 = "mv"
            java.lang.String r14 = r4.zzcju     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x03cb:
            java.lang.String r12 = "muv"
            int r14 = r4.zzcjw     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            int r12 = r4.zzcjx     // Catch:{ JSONException -> 0x0934 }
            r14 = -2
            if (r12 == r14) goto L_0x03e6
            java.lang.String r12 = "cnt"
            int r14 = r4.zzcjx     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
        L_0x03e6:
            java.lang.String r12 = "gnt"
            int r14 = r4.zzcjy     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "pt"
            int r14 = r4.zzcjz     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "rm"
            int r14 = r4.zzcka     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r12 = "riv"
            int r14 = r4.zzckb     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r12.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r14 = "build_build"
            java.lang.String r15 = r4.zzckg     // Catch:{ JSONException -> 0x0934 }
            r12.putString(r14, r15)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r14 = "build_device"
            java.lang.String r15 = r4.zzckh     // Catch:{ JSONException -> 0x0934 }
            r12.putString(r14, r15)     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r14 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r14.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r15 = "is_charging"
            boolean r13 = r4.zzckd     // Catch:{ JSONException -> 0x0934 }
            r14.putBoolean(r15, r13)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r13 = "battery_level"
            r19 = r10
            double r9 = r4.zzckc     // Catch:{ JSONException -> 0x0934 }
            r14.putDouble(r13, r9)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "battery"
            r12.putBundle(r9, r14)     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r9.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = "active_network_state"
            int r13 = r4.zzckf     // Catch:{ JSONException -> 0x0934 }
            r9.putInt(r10, r13)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = "active_network_metered"
            boolean r13 = r4.zzcke     // Catch:{ JSONException -> 0x0934 }
            r9.putBoolean(r10, r13)     // Catch:{ JSONException -> 0x0934 }
            if (r7 == 0) goto L_0x0473
            android.os.Bundle r10 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r10.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r13 = "predicted_latency_micros"
            int r14 = r7.zzckq     // Catch:{ JSONException -> 0x0934 }
            r10.putInt(r13, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r13 = "predicted_down_throughput_bps"
            long r14 = r7.zzckr     // Catch:{ JSONException -> 0x0934 }
            r10.putLong(r13, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r13 = "predicted_up_throughput_bps"
            long r14 = r7.zzcks     // Catch:{ JSONException -> 0x0934 }
            r10.putLong(r13, r14)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "predictions"
            r9.putBundle(r7, r10)     // Catch:{ JSONException -> 0x0934 }
        L_0x0473:
            java.lang.String r7 = "network"
            r12.putBundle(r7, r9)     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r7.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "is_browser_custom_tabs_capable"
            boolean r10 = r4.zzcki     // Catch:{ JSONException -> 0x0934 }
            r7.putBoolean(r9, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "browser"
            r12.putBundle(r9, r7)     // Catch:{ JSONException -> 0x0934 }
            if (r19 == 0) goto L_0x054e
            java.lang.String r7 = "android_mem_info"
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r9.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r10 = "runtime_free"
            java.lang.String r13 = "runtime_free_memory"
            r22 = r2
            r23 = r3
            r20 = r5
            r21 = r6
            r14 = r19
            r5 = -1
            long r2 = r14.getLong(r13, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = java.lang.Long.toString(r2)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r10, r2)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "runtime_max"
            java.lang.String r3 = "runtime_max_memory"
            r24 = r4
            long r3 = r14.getLong(r3, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r2, r3)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "runtime_total"
            java.lang.String r3 = "runtime_total_memory"
            long r3 = r14.getLong(r3, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r2, r3)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "web_view_count"
            java.lang.String r3 = "web_view_count"
            r10 = 0
            int r3 = r14.getInt(r3, r10)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r2, r3)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "debug_memory_info"
            android.os.Parcelable r2 = r14.getParcelable(r2)     // Catch:{ JSONException -> 0x0934 }
            android.os.Debug$MemoryInfo r2 = (android.os.Debug.MemoryInfo) r2     // Catch:{ JSONException -> 0x0934 }
            if (r2 == 0) goto L_0x054a
            java.lang.String r3 = "debug_info_dalvik_private_dirty"
            int r4 = r2.dalvikPrivateDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_dalvik_pss"
            int r4 = r2.dalvikPss     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_dalvik_shared_dirty"
            int r4 = r2.dalvikSharedDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_native_private_dirty"
            int r4 = r2.nativePrivateDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_native_pss"
            int r4 = r2.nativePss     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_native_shared_dirty"
            int r4 = r2.nativeSharedDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_other_private_dirty"
            int r4 = r2.otherPrivateDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_other_pss"
            int r4 = r2.otherPss     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "debug_info_other_shared_dirty"
            int r2 = r2.otherSharedDirty     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ JSONException -> 0x0934 }
            r9.putString(r3, r2)     // Catch:{ JSONException -> 0x0934 }
        L_0x054a:
            r12.putBundle(r7, r9)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x0559
        L_0x054e:
            r22 = r2
            r23 = r3
            r24 = r4
            r20 = r5
            r21 = r6
            r10 = 0
        L_0x0559:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r2.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "parental_controls"
            r2.putBundle(r3, r11)     // Catch:{ JSONException -> 0x0934 }
            r3 = r24
            java.lang.String r4 = r3.zzcjv     // Catch:{ JSONException -> 0x0934 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0934 }
            if (r4 != 0) goto L_0x0574
            java.lang.String r4 = "package_version"
            java.lang.String r5 = r3.zzcjv     // Catch:{ JSONException -> 0x0934 }
            r2.putString(r4, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x0574:
            java.lang.String r4 = "play_store"
            r12.putBundle(r4, r2)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "device"
            r8.put(r2, r12)     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r2.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "doritos"
            java.lang.String r5 = r1.zzcgp     // Catch:{ JSONException -> 0x0934 }
            r2.putString(r4, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "doritos_v2"
            java.lang.String r5 = r1.zzcgq     // Catch:{ JSONException -> 0x0934 }
            r2.putString(r4, r5)     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zznk.zzayj     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r5 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ JSONException -> 0x0934 }
            boolean r4 = r4.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            if (r4 == 0) goto L_0x05df
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = r1.zzcgr     // Catch:{ JSONException -> 0x0934 }
            if (r4 == 0) goto L_0x05b4
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = r1.zzcgr     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = r4.getId()     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = r1.zzcgr     // Catch:{ JSONException -> 0x0934 }
            boolean r9 = r4.isLimitAdTrackingEnabled()     // Catch:{ JSONException -> 0x0934 }
            goto L_0x05b6
        L_0x05b4:
            r7 = 0
            r9 = 0
        L_0x05b6:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0934 }
            if (r4 != 0) goto L_0x05ce
            java.lang.String r4 = "rdid"
            r2.putString(r4, r7)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "is_lat"
            r2.putBoolean(r4, r9)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "idtype"
            java.lang.String r5 = "adid"
        L_0x05ca:
            r2.putString(r4, r5)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x05df
        L_0x05ce:
            com.google.android.gms.internal.ads.zzkb.zzif()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = com.google.android.gms.internal.ads.zzamu.zzbd(r25)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r5 = "pdid"
            r2.putString(r5, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "pdidtype"
            java.lang.String r5 = "ssaid"
            goto L_0x05ca
        L_0x05df:
            java.lang.String r4 = "pii"
            r8.put(r4, r2)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "platform"
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x0934 }
            r8.put(r2, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "submodel"
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0934 }
            r8.put(r2, r4)     // Catch:{ JSONException -> 0x0934 }
            if (r23 == 0) goto L_0x05fc
            r2 = r23
            zza((java.util.HashMap<java.lang.String, java.lang.Object>) r8, (android.location.Location) r2)     // Catch:{ JSONException -> 0x0934 }
            r2 = r22
            goto L_0x0612
        L_0x05fc:
            r2 = r22
            com.google.android.gms.internal.ads.zzjj r4 = r2.zzccv     // Catch:{ JSONException -> 0x0934 }
            int r4 = r4.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 2
            if (r4 < r5) goto L_0x0612
            com.google.android.gms.internal.ads.zzjj r4 = r2.zzccv     // Catch:{ JSONException -> 0x0934 }
            android.location.Location r4 = r4.zzaqe     // Catch:{ JSONException -> 0x0934 }
            if (r4 == 0) goto L_0x0612
            com.google.android.gms.internal.ads.zzjj r4 = r2.zzccv     // Catch:{ JSONException -> 0x0934 }
            android.location.Location r4 = r4.zzaqe     // Catch:{ JSONException -> 0x0934 }
            zza((java.util.HashMap<java.lang.String, java.lang.Object>) r8, (android.location.Location) r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x0612:
            int r4 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 2
            if (r4 < r5) goto L_0x061e
            java.lang.String r4 = "quality_signals"
            android.os.Bundle r5 = r2.zzcda     // Catch:{ JSONException -> 0x0934 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x061e:
            int r4 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 4
            if (r4 < r5) goto L_0x0632
            boolean r4 = r2.zzcdd     // Catch:{ JSONException -> 0x0934 }
            if (r4 == 0) goto L_0x0632
            java.lang.String r4 = "forceHttps"
            boolean r5 = r2.zzcdd     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x0632:
            if (r20 == 0) goto L_0x063b
            java.lang.String r4 = "content_info"
            r5 = r20
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x063b:
            int r4 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 5
            if (r4 < r5) goto L_0x0662
            java.lang.String r3 = "u_sd"
            float r4 = r2.zzagu     // Catch:{ JSONException -> 0x0934 }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "sh"
            int r4 = r2.zzcdf     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "sw"
            int r4 = r2.zzcde     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x0683
        L_0x0662:
            java.lang.String r4 = "u_sd"
            float r5 = r3.zzagu     // Catch:{ JSONException -> 0x0934 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "sh"
            int r5 = r3.zzcdf     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "sw"
            int r3 = r3.zzcde     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r4, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x0683:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r4 = 6
            if (r3 < r4) goto L_0x06af
            java.lang.String r3 = r2.zzcdg     // Catch:{ JSONException -> 0x0934 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r3 != 0) goto L_0x06a4
            java.lang.String r3 = "view_hierarchy"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x069d }
            java.lang.String r5 = r2.zzcdg     // Catch:{ JSONException -> 0x069d }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x069d }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x069d }
            goto L_0x06a4
        L_0x069d:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = "Problem serializing view hierarchy to JSON"
            com.google.android.gms.internal.ads.zzakb.zzc(r4, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x06a4:
            java.lang.String r3 = "correlation_id"
            long r4 = r2.zzcdh     // Catch:{ JSONException -> 0x0934 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x06af:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r4 = 7
            if (r3 < r4) goto L_0x06bb
            java.lang.String r3 = "request_id"
            java.lang.String r4 = r2.zzcdi     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x06bb:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r4 = 12
            if (r3 < r4) goto L_0x06d0
            java.lang.String r3 = r2.zzcdm     // Catch:{ JSONException -> 0x0934 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r3 != 0) goto L_0x06d0
            java.lang.String r3 = "anchor"
            java.lang.String r4 = r2.zzcdm     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x06d0:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r4 = 13
            if (r3 < r4) goto L_0x06e1
            java.lang.String r3 = "android_app_volume"
            float r4 = r2.zzcdn     // Catch:{ JSONException -> 0x0934 }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x06e1:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r4 = 18
            if (r3 < r4) goto L_0x06f2
            java.lang.String r3 = "android_app_muted"
            boolean r5 = r2.zzcdt     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x06f2:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 14
            if (r3 < r5) goto L_0x0707
            int r3 = r2.zzcdo     // Catch:{ JSONException -> 0x0934 }
            if (r3 <= 0) goto L_0x0707
            java.lang.String r3 = "target_api"
            int r5 = r2.zzcdo     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x0707:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 15
            if (r3 < r5) goto L_0x071f
            java.lang.String r3 = "scroll_index"
            int r5 = r2.zzcdp     // Catch:{ JSONException -> 0x0934 }
            r6 = -1
            if (r5 != r6) goto L_0x0715
            goto L_0x0718
        L_0x0715:
            int r11 = r2.zzcdp     // Catch:{ JSONException -> 0x0934 }
            r6 = r11
        L_0x0718:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x071f:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r5 = 16
            if (r3 < r5) goto L_0x0730
            java.lang.String r3 = "_activity_context"
            boolean r5 = r2.zzcdq     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x0730:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            if (r3 < r4) goto L_0x075b
            java.lang.String r3 = r2.zzcdu     // Catch:{ JSONException -> 0x0934 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r3 != 0) goto L_0x0750
            java.lang.String r3 = "app_settings"
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0749 }
            java.lang.String r6 = r2.zzcdu     // Catch:{ JSONException -> 0x0749 }
            r5.<init>(r6)     // Catch:{ JSONException -> 0x0749 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0749 }
            goto L_0x0750
        L_0x0749:
            r0 = move-exception
            r3 = r0
            java.lang.String r5 = "Problem creating json from app settings"
            com.google.android.gms.internal.ads.zzakb.zzc(r5, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x0750:
            java.lang.String r3 = "render_in_browser"
            boolean r5 = r2.zzbss     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r5)     // Catch:{ JSONException -> 0x0934 }
        L_0x075b:
            int r3 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            if (r3 < r4) goto L_0x076a
            java.lang.String r3 = "android_num_video_cache_tasks"
            int r4 = r2.zzcdv     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0934 }
        L_0x076a:
            com.google.android.gms.internal.ads.zzang r3 = r2.zzacr     // Catch:{ JSONException -> 0x0934 }
            boolean r4 = r2.zzceh     // Catch:{ JSONException -> 0x0934 }
            boolean r1 = r1.zzcgv     // Catch:{ JSONException -> 0x0934 }
            boolean r5 = r2.zzcej     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r6.<init>()     // Catch:{ JSONException -> 0x0934 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r7.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "cl"
            java.lang.String r11 = "193400285"
            r7.putString(r9, r11)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "rapid_rc"
            java.lang.String r11 = "dev"
            r7.putString(r9, r11)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "rapid_rollup"
            java.lang.String r11 = "HEAD"
            r7.putString(r9, r11)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = "build_meta"
            r6.putBundle(r9, r7)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "mf"
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zznk.zzbbm     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r11 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r9 = r11.zzd(r9)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ JSONException -> 0x0934 }
            boolean r9 = r9.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r9 = java.lang.Boolean.toString(r9)     // Catch:{ JSONException -> 0x0934 }
            r6.putString(r7, r9)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r7 = "instant_app"
            r6.putBoolean(r7, r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "lite"
            boolean r3 = r3.zzcvh     // Catch:{ JSONException -> 0x0934 }
            r6.putBoolean(r4, r3)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "local_service"
            r6.putBoolean(r3, r1)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = "is_privileged_process"
            r6.putBoolean(r1, r5)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = "sdk_env"
            r8.put(r1, r6)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = "cache_state"
            r3 = r21
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
            int r1 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r3 = 19
            if (r1 < r3) goto L_0x07de
            java.lang.String r1 = "gct"
            java.lang.String r3 = r2.zzcdx     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x07de:
            int r1 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r3 = 21
            if (r1 < r3) goto L_0x07ef
            boolean r1 = r2.zzcdy     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x07ef
            java.lang.String r1 = "de"
            java.lang.String r3 = "1"
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x07ef:
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzayy     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r3 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r1 = r3.zzd(r1)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ JSONException -> 0x0934 }
            boolean r1 = r1.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x0835
            com.google.android.gms.internal.ads.zzjn r1 = r2.zzacv     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = r1.zzarb     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "interstitial_mb"
            boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r3 != 0) goto L_0x0818
            java.lang.String r3 = "reward_mb"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x0816
            goto L_0x0818
        L_0x0816:
            r1 = 0
            goto L_0x0819
        L_0x0818:
            r1 = 1
        L_0x0819:
            android.os.Bundle r3 = r2.zzcdz     // Catch:{ JSONException -> 0x0934 }
            if (r3 == 0) goto L_0x0820
            r18 = 1
            goto L_0x0822
        L_0x0820:
            r18 = 0
        L_0x0822:
            if (r1 == 0) goto L_0x0835
            if (r18 == 0) goto L_0x0835
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ JSONException -> 0x0934 }
            r1.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = "interstitial_pool"
            r1.putBundle(r4, r3)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r3 = "counters"
            r8.put(r3, r1)     // Catch:{ JSONException -> 0x0934 }
        L_0x0835:
            java.lang.String r1 = r2.zzcea     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x0840
            java.lang.String r1 = "gmp_app_id"
            java.lang.String r3 = r2.zzcea     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x0840:
            java.lang.String r1 = r2.zzceb     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x0863
            java.lang.String r1 = "TIME_OUT"
            java.lang.String r3 = r2.zzceb     // Catch:{ JSONException -> 0x0934 }
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x085e
            java.lang.String r1 = "sai_timeout"
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r3 = com.google.android.gms.internal.ads.zznk.zzaxt     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r4 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x085a:
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x0868
        L_0x085e:
            java.lang.String r1 = "fbs_aiid"
            java.lang.String r3 = r2.zzceb     // Catch:{ JSONException -> 0x0934 }
            goto L_0x085a
        L_0x0863:
            java.lang.String r1 = "fbs_aiid"
            java.lang.String r3 = ""
            goto L_0x085a
        L_0x0868:
            java.lang.String r1 = r2.zzcec     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x0873
            java.lang.String r1 = "fbs_aeid"
            java.lang.String r3 = r2.zzcec     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x0873:
            int r1 = r2.versionCode     // Catch:{ JSONException -> 0x0934 }
            r3 = 24
            if (r1 < r3) goto L_0x0884
            java.lang.String r1 = "disable_ml"
            boolean r3 = r2.zzcei     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x0884:
            com.google.android.gms.internal.ads.zzna<java.lang.String> r1 = com.google.android.gms.internal.ads.zznk.zzavo     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r3 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r1 = r3.zzd(r1)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x08cb
            boolean r3 = r1.isEmpty()     // Catch:{ JSONException -> 0x0934 }
            if (r3 != 0) goto L_0x08cb
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzna<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zznk.zzavp     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r5 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ JSONException -> 0x0934 }
            int r4 = r4.intValue()     // Catch:{ JSONException -> 0x0934 }
            if (r3 < r4) goto L_0x08cb
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ JSONException -> 0x0934 }
            r3.<init>()     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r4 = ","
            java.lang.String[] r1 = r1.split(r4)     // Catch:{ JSONException -> 0x0934 }
            int r4 = r1.length     // Catch:{ JSONException -> 0x0934 }
        L_0x08b8:
            if (r10 >= r4) goto L_0x08c6
            r5 = r1[r10]     // Catch:{ JSONException -> 0x0934 }
            java.util.List r6 = com.google.android.gms.internal.ads.zzams.zzdd(r5)     // Catch:{ JSONException -> 0x0934 }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x0934 }
            int r10 = r10 + 1
            goto L_0x08b8
        L_0x08c6:
            java.lang.String r1 = "video_decoders"
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x08cb:
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzbet     // Catch:{ JSONException -> 0x0934 }
            com.google.android.gms.internal.ads.zzni r3 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ JSONException -> 0x0934 }
            java.lang.Object r1 = r3.zzd(r1)     // Catch:{ JSONException -> 0x0934 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ JSONException -> 0x0934 }
            boolean r1 = r1.booleanValue()     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x08ec
            java.lang.String r1 = "omid_v"
            com.google.android.gms.internal.ads.zzaan r3 = com.google.android.gms.ads.internal.zzbv.zzfa()     // Catch:{ JSONException -> 0x0934 }
            r4 = r25
            java.lang.String r3 = r3.getVersion(r4)     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0934 }
        L_0x08ec:
            java.util.ArrayList<java.lang.String> r1 = r2.zzcek     // Catch:{ JSONException -> 0x0934 }
            if (r1 == 0) goto L_0x08ff
            java.util.ArrayList<java.lang.String> r1 = r2.zzcek     // Catch:{ JSONException -> 0x0934 }
            boolean r1 = r1.isEmpty()     // Catch:{ JSONException -> 0x0934 }
            if (r1 != 0) goto L_0x08ff
            java.lang.String r1 = "android_permissions"
            java.util.ArrayList<java.lang.String> r2 = r2.zzcek     // Catch:{ JSONException -> 0x0934 }
            r8.put(r1, r2)     // Catch:{ JSONException -> 0x0934 }
        L_0x08ff:
            r1 = 2
            boolean r2 = com.google.android.gms.internal.ads.zzakb.isLoggable(r1)     // Catch:{ JSONException -> 0x0934 }
            if (r2 == 0) goto L_0x092b
            com.google.android.gms.internal.ads.zzakk r2 = com.google.android.gms.ads.internal.zzbv.zzek()     // Catch:{ JSONException -> 0x0934 }
            org.json.JSONObject r2 = r2.zzn(r8)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r1 = r2.toString(r1)     // Catch:{ JSONException -> 0x0934 }
            java.lang.String r2 = "Ad Request JSON: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x0934 }
            int r3 = r1.length()     // Catch:{ JSONException -> 0x0934 }
            if (r3 == 0) goto L_0x0923
            java.lang.String r1 = r2.concat(r1)     // Catch:{ JSONException -> 0x0934 }
            goto L_0x0928
        L_0x0923:
            java.lang.String r1 = new java.lang.String     // Catch:{ JSONException -> 0x0934 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0934 }
        L_0x0928:
            com.google.android.gms.internal.ads.zzakb.m39v(r1)     // Catch:{ JSONException -> 0x0934 }
        L_0x092b:
            com.google.android.gms.internal.ads.zzakk r1 = com.google.android.gms.ads.internal.zzbv.zzek()     // Catch:{ JSONException -> 0x0934 }
            org.json.JSONObject r1 = r1.zzn(r8)     // Catch:{ JSONException -> 0x0934 }
            return r1
        L_0x0934:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "Problem serializing ad request to JSON: "
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x094b
            java.lang.String r1 = r2.concat(r1)
            goto L_0x0950
        L_0x094b:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x0950:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafs.zza(android.content.Context, com.google.android.gms.internal.ads.zzafl):org.json.JSONObject");
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzb(com.google.android.gms.internal.ads.zzaej r9) throws org.json.JSONException {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r9.zzbyq
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = "ad_base_url"
            java.lang.String r2 = r9.zzbyq
            r0.put(r1, r2)
        L_0x0010:
            java.lang.String r1 = r9.zzcet
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = "ad_size"
            java.lang.String r2 = r9.zzcet
            r0.put(r1, r2)
        L_0x001b:
            java.lang.String r1 = "native"
            boolean r2 = r9.zzare
            r0.put(r1, r2)
            boolean r1 = r9.zzare
            if (r1 == 0) goto L_0x002e
            java.lang.String r1 = "ad_json"
        L_0x0028:
            java.lang.String r2 = r9.zzceo
            r0.put(r1, r2)
            goto L_0x0031
        L_0x002e:
            java.lang.String r1 = "ad_html"
            goto L_0x0028
        L_0x0031:
            java.lang.String r1 = r9.zzcev
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = "debug_dialog"
            java.lang.String r2 = r9.zzcev
            r0.put(r1, r2)
        L_0x003c:
            java.lang.String r1 = r9.zzcfl
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "debug_signals"
            java.lang.String r2 = r9.zzcfl
            r0.put(r1, r2)
        L_0x0047:
            long r1 = r9.zzcep
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x005d
            java.lang.String r1 = "interstitial_timeout"
            long r5 = r9.zzcep
            double r5 = (double) r5
            r7 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = r5 / r7
            r0.put(r1, r5)
        L_0x005d:
            int r1 = r9.orientation
            com.google.android.gms.internal.ads.zzakq r2 = com.google.android.gms.ads.internal.zzbv.zzem()
            int r2 = r2.zzrm()
            if (r1 != r2) goto L_0x0071
            java.lang.String r1 = "orientation"
            java.lang.String r2 = "portrait"
        L_0x006d:
            r0.put(r1, r2)
            goto L_0x0082
        L_0x0071:
            int r1 = r9.orientation
            com.google.android.gms.internal.ads.zzakq r2 = com.google.android.gms.ads.internal.zzbv.zzem()
            int r2 = r2.zzrl()
            if (r1 != r2) goto L_0x0082
            java.lang.String r1 = "orientation"
            java.lang.String r2 = "landscape"
            goto L_0x006d
        L_0x0082:
            java.util.List<java.lang.String> r1 = r9.zzbsn
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = "click_urls"
            java.util.List<java.lang.String> r2 = r9.zzbsn
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x0091:
            java.util.List<java.lang.String> r1 = r9.zzbso
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = "impression_urls"
            java.util.List<java.lang.String> r2 = r9.zzbso
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x00a0:
            java.util.List<java.lang.String> r1 = r9.zzbsp
            if (r1 == 0) goto L_0x00af
            java.lang.String r1 = "downloaded_impression_urls"
            java.util.List<java.lang.String> r2 = r9.zzbsp
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x00af:
            java.util.List<java.lang.String> r1 = r9.zzces
            if (r1 == 0) goto L_0x00be
            java.lang.String r1 = "manual_impression_urls"
            java.util.List<java.lang.String> r2 = r9.zzces
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x00be:
            java.lang.String r1 = r9.zzcey
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = "active_view"
            java.lang.String r2 = r9.zzcey
            r0.put(r1, r2)
        L_0x00c9:
            java.lang.String r1 = "ad_is_javascript"
            boolean r2 = r9.zzcew
            r0.put(r1, r2)
            java.lang.String r1 = r9.zzcex
            if (r1 == 0) goto L_0x00db
            java.lang.String r1 = "ad_passback_url"
            java.lang.String r2 = r9.zzcex
            r0.put(r1, r2)
        L_0x00db:
            java.lang.String r1 = "mediation"
            boolean r2 = r9.zzceq
            r0.put(r1, r2)
            java.lang.String r1 = "custom_render_allowed"
            boolean r2 = r9.zzcez
            r0.put(r1, r2)
            java.lang.String r1 = "content_url_opted_out"
            boolean r2 = r9.zzcfa
            r0.put(r1, r2)
            java.lang.String r1 = "content_vertical_opted_out"
            boolean r2 = r9.zzcfm
            r0.put(r1, r2)
            java.lang.String r1 = "prefetch"
            boolean r2 = r9.zzcfb
            r0.put(r1, r2)
            long r1 = r9.zzbsu
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x010b
            java.lang.String r1 = "refresh_interval_milliseconds"
            long r5 = r9.zzbsu
            r0.put(r1, r5)
        L_0x010b:
            long r1 = r9.zzcer
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0118
            java.lang.String r1 = "mediation_config_cache_time_milliseconds"
            long r2 = r9.zzcer
            r0.put(r1, r2)
        L_0x0118:
            java.lang.String r1 = r9.zzamj
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0127
            java.lang.String r1 = "gws_query_id"
            java.lang.String r2 = r9.zzamj
            r0.put(r1, r2)
        L_0x0127:
            java.lang.String r1 = "fluid"
            boolean r2 = r9.zzarf
            if (r2 == 0) goto L_0x0130
            java.lang.String r2 = "height"
            goto L_0x0132
        L_0x0130:
            java.lang.String r2 = ""
        L_0x0132:
            r0.put(r1, r2)
            java.lang.String r1 = "native_express"
            boolean r2 = r9.zzarg
            r0.put(r1, r2)
            java.util.List<java.lang.String> r1 = r9.zzcff
            if (r1 == 0) goto L_0x014b
            java.lang.String r1 = "video_start_urls"
            java.util.List<java.lang.String> r2 = r9.zzcff
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x014b:
            java.util.List<java.lang.String> r1 = r9.zzcfg
            if (r1 == 0) goto L_0x015a
            java.lang.String r1 = "video_complete_urls"
            java.util.List<java.lang.String> r2 = r9.zzcfg
            org.json.JSONArray r2 = zzm(r2)
            r0.put(r1, r2)
        L_0x015a:
            com.google.android.gms.internal.ads.zzaig r1 = r9.zzcfe
            if (r1 == 0) goto L_0x0180
            java.lang.String r1 = "rewards"
            com.google.android.gms.internal.ads.zzaig r2 = r9.zzcfe
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "rb_type"
            java.lang.String r5 = r2.type
            r3.put(r4, r5)
            java.lang.String r4 = "rb_amount"
            int r2 = r2.zzcmk
            r3.put(r4, r2)
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            r2.put(r3)
            r0.put(r1, r2)
        L_0x0180:
            java.lang.String r1 = "use_displayed_impression"
            boolean r2 = r9.zzcfh
            r0.put(r1, r2)
            java.lang.String r1 = "auto_protection_configuration"
            com.google.android.gms.internal.ads.zzael r2 = r9.zzcfi
            r0.put(r1, r2)
            java.lang.String r1 = "render_in_browser"
            boolean r2 = r9.zzbss
            r0.put(r1, r2)
            java.lang.String r1 = "disable_closable_area"
            boolean r9 = r9.zzzm
            r0.put(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafs.zzb(com.google.android.gms.internal.ads.zzaej):org.json.JSONObject");
    }

    @Nullable
    private static JSONArray zzm(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private static Integer zzv(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
