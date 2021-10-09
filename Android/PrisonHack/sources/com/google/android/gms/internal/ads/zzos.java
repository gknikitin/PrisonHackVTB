package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzadh
public final class zzos extends zzqt implements zzpb {
    private final Object mLock = new Object();
    private final zzoj zzbie;
    @Nullable
    private zzlo zzbif;
    @Nullable
    private View zzbig;
    /* access modifiers changed from: private */
    public zzoz zzbij;
    private final String zzbio;
    private final SimpleArrayMap<String, zzon> zzbip;
    private final SimpleArrayMap<String, String> zzbiq;

    public zzos(String str, SimpleArrayMap<String, zzon> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zzoj zzoj, zzlo zzlo, View view) {
        this.zzbio = str;
        this.zzbip = simpleArrayMap;
        this.zzbiq = simpleArrayMap2;
        this.zzbie = zzoj;
        this.zzbif = zzlo;
        this.zzbig = view;
    }

    public final void destroy() {
        zzakk.zzcrm.post(new zzou(this));
        this.zzbif = null;
        this.zzbig = null;
    }

    public final List<String> getAvailableAssetNames() {
        String[] strArr = new String[(this.zzbip.size() + this.zzbiq.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.zzbip.size()) {
            strArr[i3] = this.zzbip.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < this.zzbiq.size()) {
            strArr[i3] = this.zzbiq.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzbio;
    }

    public final zzlo getVideoController() {
        return this.zzbif;
    }

    public final void performClick(String str) {
        synchronized (this.mLock) {
            if (this.zzbij == null) {
                zzane.m40e("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.zzbij.zza((View) null, str, (Bundle) null, (Map<String, WeakReference<View>>) null, (View) null);
            }
        }
    }

    public final void recordImpression() {
        synchronized (this.mLock) {
            if (this.zzbij == null) {
                zzane.m40e("#002 Attempt to record impression before native ad initialized.");
            } else {
                this.zzbij.zza((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    public final String zzao(String str) {
        return this.zzbiq.get(str);
    }

    public final zzpw zzap(String str) {
        return this.zzbip.get(str);
    }

    public final void zzb(zzoz zzoz) {
        synchronized (this.mLock) {
            this.zzbij = zzoz;
        }
    }

    public final boolean zzh(IObjectWrapper iObjectWrapper) {
        if (this.zzbij == null) {
            zzane.m40e("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.zzbig == null) {
            return false;
        } else {
            zzot zzot = new zzot(this);
            this.zzbij.zza((View) (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (zzox) zzot);
            return true;
        }
    }

    public final IObjectWrapper zzka() {
        return ObjectWrapper.wrap(this.zzbij);
    }

    public final String zzkb() {
        return "3";
    }

    public final zzoj zzkc() {
        return this.zzbie;
    }

    public final View zzkd() {
        return this.zzbig;
    }

    public final IObjectWrapper zzkh() {
        return ObjectWrapper.wrap(this.zzbij.getContext().getApplicationContext());
    }
}