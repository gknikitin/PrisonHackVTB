package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbc;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@zzadh
public final class zzabt extends zzajx {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zzabm zzbzd;
    private final zzaji zzbze;
    private final zzaej zzbzf;
    private final zzabv zzbzu;
    private Future<zzajh> zzbzv;

    public zzabt(Context context, zzbc zzbc, zzaji zzaji, zzci zzci, zzabm zzabm, zznx zznx) {
        this(zzaji, zzabm, new zzabv(context, zzbc, new zzalt(context), zzci, zzaji, zznx));
    }

    private zzabt(zzaji zzaji, zzabm zzabm, zzabv zzabv) {
        this.mLock = new Object();
        this.zzbze = zzaji;
        this.zzbzf = zzaji.zzcos;
        this.zzbzd = zzabm;
        this.zzbzu = zzabv;
    }

    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzbzv != null) {
                this.zzbzv.cancel(true);
            }
        }
    }

    public final void zzdn() {
        int i;
        zzajh zzajh;
        zzajh zzajh2 = null;
        try {
            synchronized (this.mLock) {
                this.zzbzv = zzaki.zza(this.zzbzu);
            }
            zzajh2 = this.zzbzv.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException unused) {
            zzakb.zzdk("Timed out waiting for native ad.");
            this.zzbzv.cancel(true);
            i = 2;
        } catch (InterruptedException | CancellationException | ExecutionException unused2) {
            i = 0;
        } catch (Throwable th) {
            while (true) {
            }
            throw th;
        }
        if (zzajh2 != null) {
            zzajh = zzajh2;
        } else {
            zzjj zzjj = this.zzbze.zzcgs.zzccv;
            int i2 = this.zzbzf.orientation;
            long j = this.zzbzf.zzbsu;
            String str = this.zzbze.zzcgs.zzccy;
            long j2 = this.zzbzf.zzcer;
            zzjn zzjn = this.zzbze.zzacv;
            long j3 = this.zzbzf.zzcep;
            long j4 = this.zzbze.zzcoh;
            long j5 = this.zzbzf.zzceu;
            String str2 = this.zzbzf.zzcev;
            JSONObject jSONObject = this.zzbze.zzcob;
            boolean z = this.zzbze.zzcos.zzcfh;
            long j6 = j2;
            zzael zzael = this.zzbze.zzcos.zzcfi;
            String str3 = this.zzbzf.zzcfl;
            zzhs zzhs = this.zzbze.zzcoq;
            boolean z2 = this.zzbze.zzcos.zzzl;
            boolean z3 = this.zzbze.zzcos.zzcfp;
            boolean z4 = z;
            JSONObject jSONObject2 = jSONObject;
            String str4 = str2;
            long j7 = j5;
            long j8 = j3;
            long j9 = j4;
            int i3 = i2;
            zzjn zzjn2 = zzjn;
            zzael zzael2 = zzael;
            zzajh = new zzajh(zzjj, (zzaqw) null, (List<String>) null, i, (List<String>) null, (List<String>) null, i3, j, str, false, (zzwx) null, (zzxq) null, (String) null, (zzwy) null, (zzxa) null, j6, zzjn2, j8, j9, j7, str4, jSONObject2, (zzpb) null, (zzaig) null, (List<String>) null, (List<String>) null, z4, zzael2, (String) null, (List<String>) null, str3, zzhs, z2, false, z3, (List<String>) null, this.zzbze.zzcos.zzzm, this.zzbze.zzcos.zzcfq);
        }
        zzakk.zzcrm.post(new zzabu(this, zzajh));
    }
}
