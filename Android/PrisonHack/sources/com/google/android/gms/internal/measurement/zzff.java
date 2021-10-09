package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicReference;

public final class zzff extends zzhi {
    private static final AtomicReference<String[]> zzais = new AtomicReference<>();
    private static final AtomicReference<String[]> zzait = new AtomicReference<>();
    private static final AtomicReference<String[]> zzaiu = new AtomicReference<>();

    zzff(zzgm zzgm) {
        super(zzgm);
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkc.zzs(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Nullable
    private final String zzb(zzet zzet) {
        if (zzet == null) {
            return null;
        }
        return !zzir() ? zzet.toString() : zzb(zzet.zzij());
    }

    private final boolean zzir() {
        return this.zzacw.zzgf().isLoggable(3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzer zzer) {
        if (zzer == null) {
            return null;
        }
        if (!zzir()) {
            return zzer.toString();
        }
        return "Event{appId='" + zzer.zzti + "', name='" + zzbi(zzer.name) + "', params=" + zzb(zzer.zzafr) + "}";
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzir()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(sb.length() != 0 ? ", " : "Bundle[{");
            sb.append(zzbj(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(zzew zzew) {
        if (zzew == null) {
            return null;
        }
        if (!zzir()) {
            return zzew.toString();
        }
        return "origin=" + zzew.origin + ",name=" + zzbi(zzew.name) + ",params=" + zzb(zzew.zzafr);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbi(String str) {
        if (str == null) {
            return null;
        }
        return !zzir() ? str : zza(str, AppMeasurement.Event.zzacy, AppMeasurement.Event.zzacx, zzais);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbj(String str) {
        if (str == null) {
            return null;
        }
        return !zzir() ? str : zza(str, AppMeasurement.Param.zzada, AppMeasurement.Param.zzacz, zzait);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbk(String str) {
        if (str == null) {
            return null;
        }
        if (!zzir()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, AppMeasurement.UserProperty.zzadc, AppMeasurement.UserProperty.zzadb, zzaiu);
        }
        return "experiment_id" + "(" + str + ")";
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
}
