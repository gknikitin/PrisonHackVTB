package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

public final class zzjy extends zzjr {
    zzjy(zzjs zzjs) {
        super(zzjs);
    }

    public static zzkq zza(zzkp zzkp, String str) {
        for (zzkq zzkq : zzkp.zzatm) {
            if (zzkq.name.equals(str)) {
                return zzkq;
            }
        }
        return null;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzkh zzkh) {
        if (zzkh != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzkh.zzasj);
            zza(sb, i, "param_name", (Object) zzgb().zzbj(zzkh.zzask));
            int i2 = i + 1;
            zzkk zzkk = zzkh.zzash;
            if (zzkk != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzkk.zzast != null) {
                    String str = "UNKNOWN_MATCH_TYPE";
                    switch (zzkk.zzast.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                    }
                    zza(sb, i2, "match_type", (Object) str);
                }
                zza(sb, i2, "expression", (Object) zzkk.zzasu);
                zza(sb, i2, "case_sensitive", (Object) zzkk.zzasv);
                if (zzkk.zzasw.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String append : zzkk.zzasw) {
                        zza(sb, i2 + 2);
                        sb.append(append);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i2, "number_filter", zzkh.zzasi);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzki zzki) {
        if (zzki != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzki.zzasl != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzki.zzasl.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzki.zzasm);
            zza(sb, i, "comparison_value", (Object) zzki.zzasn);
            zza(sb, i, "min_comparison_value", (Object) zzki.zzaso);
            zza(sb, i, "max_comparison_value", (Object) zzki.zzasp);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzkt zzkt) {
        if (zzkt != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            int i2 = 0;
            if (zzkt.zzaux != null) {
                zza(sb, 4);
                sb.append("results: ");
                long[] jArr = zzkt.zzaux;
                int length = jArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i3++;
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzkt.zzauw != null) {
                zza(sb, 4);
                sb.append("status: ");
                long[] jArr2 = zzkt.zzauw;
                int length2 = jArr2.length;
                int i6 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i6 = i7;
                }
                sb.append(10);
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    static zzkq[] zza(zzkq[] zzkqArr, String str, Object obj) {
        int length = zzkqArr.length;
        int i = 0;
        while (i < length) {
            zzkq zzkq = zzkqArr[i];
            if (str.equals(zzkq.name)) {
                zzkq.zzatq = null;
                zzkq.zzajo = null;
                zzkq.zzaro = null;
                if (obj instanceof Long) {
                    zzkq.zzatq = (Long) obj;
                    return zzkqArr;
                } else if (obj instanceof String) {
                    zzkq.zzajo = (String) obj;
                    return zzkqArr;
                } else {
                    if (obj instanceof Double) {
                        zzkq.zzaro = (Double) obj;
                    }
                    return zzkqArr;
                }
            } else {
                i++;
            }
        }
        zzkq[] zzkqArr2 = new zzkq[(zzkqArr.length + 1)];
        System.arraycopy(zzkqArr, 0, zzkqArr2, 0, zzkqArr.length);
        zzkq zzkq2 = new zzkq();
        zzkq2.name = str;
        if (obj instanceof Long) {
            zzkq2.zzatq = (Long) obj;
        } else if (obj instanceof String) {
            zzkq2.zzajo = (String) obj;
        } else if (obj instanceof Double) {
            zzkq2.zzaro = (Double) obj;
        }
        zzkqArr2[zzkqArr.length] = zzkq2;
        return zzkqArr2;
    }

    public static Object zzb(zzkp zzkp, String str) {
        zzkq zza = zza(zzkp, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzajo != null) {
            return zza.zzajo;
        }
        if (zza.zzatq != null) {
            return zza.zzatq;
        }
        if (zza.zzaro != null) {
            return zza.zzaro;
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkg zzkg) {
        if (zzkg == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzkg.zzasb);
        zza(sb, 0, "event_name", (Object) zzgb().zzbi(zzkg.zzasc));
        zza(sb, 1, "event_count_filter", zzkg.zzasf);
        sb.append("  filters {\n");
        for (zzkh zza : zzkg.zzasd) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkj zzkj) {
        if (zzkj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzkj.zzasb);
        zza(sb, 0, "property_name", (Object) zzgb().zzbk(zzkj.zzasr));
        zza(sb, 1, zzkj.zzass);
        sb.append("}\n");
        return sb.toString();
    }

    public final void zza(zzkq zzkq, Object obj) {
        Preconditions.checkNotNull(obj);
        zzkq.zzajo = null;
        zzkq.zzatq = null;
        zzkq.zzaro = null;
        if (obj instanceof String) {
            zzkq.zzajo = (String) obj;
        } else if (obj instanceof Long) {
            zzkq.zzatq = (Long) obj;
        } else if (obj instanceof Double) {
            zzkq.zzaro = (Double) obj;
        } else {
            zzgf().zzis().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzku zzku, Object obj) {
        Preconditions.checkNotNull(obj);
        zzku.zzajo = null;
        zzku.zzatq = null;
        zzku.zzaro = null;
        if (obj instanceof String) {
            zzku.zzajo = (String) obj;
        } else if (obj instanceof Long) {
            zzku.zzatq = (Long) obj;
        } else if (obj instanceof Double) {
            zzku.zzaro = (Double) obj;
        } else {
            zzgf().zzis().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final byte[] zza(zzkr zzkr) {
        try {
            byte[] bArr = new byte[zzkr.zzvv()];
            zzaby zzb = zzaby.zzb(bArr, 0, bArr.length);
            zzkr.zza(zzb);
            zzb.zzvn();
            return bArr;
        } catch (IOException e) {
            zzgf().zzis().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    public final String zzb(zzkr zzkr) {
        zzkr zzkr2 = zzkr;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzkr2.zzatr != null) {
            for (zzks zzks : zzkr2.zzatr) {
                if (!(zzks == null || zzks == null)) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", (Object) zzks.zzatt);
                    zza(sb, 1, "platform", (Object) zzks.zzaub);
                    zza(sb, 1, "gmp_version", (Object) zzks.zzauf);
                    zza(sb, 1, "uploading_gmp_version", (Object) zzks.zzaug);
                    zza(sb, 1, "config_version", (Object) zzks.zzaur);
                    zza(sb, 1, "gmp_app_id", (Object) zzks.zzadm);
                    zza(sb, 1, "app_id", (Object) zzks.zzti);
                    zza(sb, 1, "app_version", (Object) zzks.zzth);
                    zza(sb, 1, "app_version_major", (Object) zzks.zzaun);
                    zza(sb, 1, "firebase_instance_id", (Object) zzks.zzado);
                    zza(sb, 1, "dev_cert_hash", (Object) zzks.zzauj);
                    zza(sb, 1, "app_store", (Object) zzks.zzadt);
                    zza(sb, 1, "upload_timestamp_millis", (Object) zzks.zzatw);
                    zza(sb, 1, "start_timestamp_millis", (Object) zzks.zzatx);
                    zza(sb, 1, "end_timestamp_millis", (Object) zzks.zzaty);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) zzks.zzatz);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) zzks.zzaua);
                    zza(sb, 1, "app_instance_id", (Object) zzks.zzadl);
                    zza(sb, 1, "resettable_device_id", (Object) zzks.zzauh);
                    zza(sb, 1, "device_id", (Object) zzks.zzauq);
                    zza(sb, 1, "ds_id", (Object) zzks.zzaut);
                    zza(sb, 1, "limited_ad_tracking", (Object) zzks.zzaui);
                    zza(sb, 1, "os_version", (Object) zzks.zzauc);
                    zza(sb, 1, "device_model", (Object) zzks.zzaud);
                    zza(sb, 1, "user_default_language", (Object) zzks.zzafo);
                    zza(sb, 1, "time_zone_offset_minutes", (Object) zzks.zzaue);
                    zza(sb, 1, "bundle_sequential_index", (Object) zzks.zzauk);
                    zza(sb, 1, "service_upload", (Object) zzks.zzaul);
                    zza(sb, 1, "health_monitor", (Object) zzks.zzaek);
                    if (!(zzks.zzaus == null || zzks.zzaus.longValue() == 0)) {
                        zza(sb, 1, "android_id", (Object) zzks.zzaus);
                    }
                    if (zzks.zzauv != null) {
                        zza(sb, 1, "retry_counter", (Object) zzks.zzauv);
                    }
                    zzku[] zzkuArr = zzks.zzatv;
                    if (zzkuArr != null) {
                        for (zzku zzku : zzkuArr) {
                            if (zzku != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zza(sb, 2, "set_timestamp_millis", (Object) zzku.zzauz);
                                zza(sb, 2, "name", (Object) zzgb().zzbk(zzku.name));
                                zza(sb, 2, "string_value", (Object) zzku.zzajo);
                                zza(sb, 2, "int_value", (Object) zzku.zzatq);
                                zza(sb, 2, "double_value", (Object) zzku.zzaro);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzko[] zzkoArr = zzks.zzaum;
                    if (zzkoArr != null) {
                        for (zzko zzko : zzkoArr) {
                            if (zzko != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", (Object) zzko.zzarx);
                                zza(sb, 2, "new_audience", (Object) zzko.zzatk);
                                zza(sb, 2, "current_data", zzko.zzati);
                                zza(sb, 2, "previous_data", zzko.zzatj);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzkp[] zzkpArr = zzks.zzatu;
                    if (zzkpArr != null) {
                        for (zzkp zzkp : zzkpArr) {
                            if (zzkp != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, "name", (Object) zzgb().zzbi(zzkp.name));
                                zza(sb, 2, "timestamp_millis", (Object) zzkp.zzatn);
                                zza(sb, 2, "previous_timestamp_millis", (Object) zzkp.zzato);
                                zza(sb, 2, "count", (Object) zzkp.count);
                                zzkq[] zzkqArr = zzkp.zzatm;
                                if (zzkqArr != null) {
                                    for (zzkq zzkq : zzkqArr) {
                                        if (zzkq != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zza(sb, 3, "name", (Object) zzgb().zzbj(zzkq.name));
                                            zza(sb, 3, "string_value", (Object) zzkq.zzajo);
                                            zza(sb, 3, "int_value", (Object) zzkq.zzatq);
                                            zza(sb, 3, "double_value", (Object) zzkq.zzaro);
                                            zza(sb, 3);
                                            sb.append("}\n");
                                        }
                                    }
                                }
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
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

    public final /* bridge */ /* synthetic */ zzjy zzjc() {
        return super.zzjc();
    }

    public final /* bridge */ /* synthetic */ zzeb zzjd() {
        return super.zzjd();
    }

    public final /* bridge */ /* synthetic */ zzej zzje() {
        return super.zzje();
    }
}
