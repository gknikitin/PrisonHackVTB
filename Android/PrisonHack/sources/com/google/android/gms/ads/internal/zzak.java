package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzkk;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzrl;
import com.google.android.gms.internal.ads.zzxn;

@zzadh
public final class zzak extends zzko {
    private final Context mContext;
    private final zzw zzwc;
    private final zzxn zzwh;
    private zzkh zzxs;
    private zzjn zzxx;
    private PublisherAdViewOptions zzxy;
    private zzpl zzyb;
    private zzlg zzyd;
    private final String zzye;
    private final zzang zzyf;
    private zzqw zzyk;
    private zzrl zzyl;
    private zzqz zzym;
    private SimpleArrayMap<String, zzrc> zzyn = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzrf> zzyo = new SimpleArrayMap<>();
    private zzri zzyp;

    public zzak(Context context, String str, zzxn zzxn, zzang zzang, zzw zzw) {
        this.mContext = context;
        this.zzye = str;
        this.zzwh = zzxn;
        this.zzyf = zzang;
        this.zzwc = zzw;
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzxy = publisherAdViewOptions;
    }

    public final void zza(zzpl zzpl) {
        this.zzyb = zzpl;
    }

    public final void zza(zzqw zzqw) {
        this.zzyk = zzqw;
    }

    public final void zza(zzqz zzqz) {
        this.zzym = zzqz;
    }

    public final void zza(zzri zzri, zzjn zzjn) {
        this.zzyp = zzri;
        this.zzxx = zzjn;
    }

    public final void zza(zzrl zzrl) {
        this.zzyl = zzrl;
    }

    public final void zza(String str, zzrf zzrf, zzrc zzrc) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzyo.put(str, zzrf);
        this.zzyn.put(str, zzrc);
    }

    public final void zzb(zzkh zzkh) {
        this.zzxs = zzkh;
    }

    public final void zzb(zzlg zzlg) {
        this.zzyd = zzlg;
    }

    public final zzkk zzdh() {
        Context context = this.mContext;
        String str = this.zzye;
        zzxn zzxn = this.zzwh;
        zzang zzang = this.zzyf;
        zzkh zzkh = this.zzxs;
        zzqw zzqw = this.zzyk;
        zzrl zzrl = this.zzyl;
        zzqz zzqz = this.zzym;
        SimpleArrayMap<String, zzrf> simpleArrayMap = this.zzyo;
        SimpleArrayMap<String, zzrc> simpleArrayMap2 = this.zzyn;
        zzpl zzpl = this.zzyb;
        zzlg zzlg = this.zzyd;
        zzw zzw = this.zzwc;
        zzri zzri = this.zzyp;
        return new zzah(context, str, zzxn, zzang, zzkh, zzqw, zzrl, zzqz, simpleArrayMap, simpleArrayMap2, zzpl, zzlg, zzw, zzri, this.zzxx, this.zzxy);
    }
}
