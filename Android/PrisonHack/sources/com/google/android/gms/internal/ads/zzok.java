package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.ads.internal.zzbv;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class zzok implements View.OnClickListener {
    private final zzacm zzaad;
    /* access modifiers changed from: private */
    @Nullable
    public zzro zzbhm;
    @Nullable
    private zzv zzbhn;
    @Nullable
    @VisibleForTesting
    String zzbho;
    @Nullable
    @VisibleForTesting
    Long zzbhp;
    @Nullable
    @VisibleForTesting
    WeakReference<View> zzbhq;

    public zzok(zzacm zzacm) {
        this.zzaad = zzacm;
    }

    private final void zzjx() {
        this.zzbho = null;
        this.zzbhp = null;
        if (this.zzbhq != null) {
            View view = (View) this.zzbhq.get();
            this.zzbhq = null;
            if (view != null) {
                view.setClickable(false);
                view.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzbhm != null && this.zzbhp != null) {
            zzjx();
            try {
                this.zzbhm.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzane.zzd("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        if (this.zzbhq != null && this.zzbhq.get() == view) {
            if (!(this.zzbho == null || this.zzbhp == null)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.zzbho);
                    jSONObject.put("time_interval", zzbv.zzer().currentTimeMillis() - this.zzbhp.longValue());
                    jSONObject.put("messageType", "onePointFiveClick");
                    this.zzaad.zza("sendMessageToNativeJs", jSONObject);
                } catch (JSONException e) {
                    zzakb.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
            zzjx();
        }
    }

    public final void zza(zzro zzro) {
        this.zzbhm = zzro;
        if (this.zzbhn != null) {
            this.zzaad.zzb("/unconfirmedClick", this.zzbhn);
        }
        this.zzbhn = new zzol(this);
        this.zzaad.zza("/unconfirmedClick", this.zzbhn);
    }

    @Nullable
    public final zzro zzjw() {
        return this.zzbhm;
    }
}
