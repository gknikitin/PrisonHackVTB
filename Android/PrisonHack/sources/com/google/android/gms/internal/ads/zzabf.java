package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzadh
public abstract class zzabf implements zzalc<Void>, zzasd {
    protected final Context mContext;
    protected final zzaqw zzbnd;
    private final zzabm zzbzd;
    private final zzaji zzbze;
    protected zzaej zzbzf;
    private Runnable zzbzg;
    private final Object zzbzh = new Object();
    /* access modifiers changed from: private */
    public AtomicBoolean zzbzi = new AtomicBoolean(true);

    protected zzabf(Context context, zzaji zzaji, zzaqw zzaqw, zzabm zzabm) {
        this.mContext = context;
        this.zzbze = zzaji;
        this.zzbzf = this.zzbze.zzcos;
        this.zzbnd = zzaqw;
        this.zzbzd = zzabm;
    }

    public void cancel() {
        if (this.zzbzi.getAndSet(false)) {
            this.zzbnd.stopLoading();
            zzbv.zzem();
            zzakq.zzi(this.zzbnd);
            zzz(-1);
            zzakk.zzcrm.removeCallbacks(this.zzbzg);
        }
    }

    public final void zze(boolean z) {
        zzakb.zzck("WebView finished loading.");
        int i = 0;
        if (this.zzbzi.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            zzz(i);
            zzakk.zzcrm.removeCallbacks(this.zzbzg);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzns();

    public final /* synthetic */ Object zznt() {
        Preconditions.checkMainThread("Webview render task needs to be called on UI thread.");
        this.zzbzg = new zzabg(this);
        zzakk.zzcrm.postDelayed(this.zzbzg, ((Long) zzkb.zzik().zzd(zznk.zzbao)).longValue());
        zzns();
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzz(int i) {
        zzajh zzajh;
        int i2 = i;
        if (i2 != -2) {
            this.zzbzf = new zzaej(i2, this.zzbzf.zzbsu);
        }
        this.zzbnd.zztz();
        zzabm zzabm = this.zzbzd;
        zzaef zzaef = this.zzbze.zzcgs;
        zzjj zzjj = zzaef.zzccv;
        zzaqw zzaqw = this.zzbnd;
        List<String> list = this.zzbzf.zzbsn;
        List<String> list2 = this.zzbzf.zzbso;
        List<String> list3 = this.zzbzf.zzces;
        int i3 = this.zzbzf.orientation;
        long j = this.zzbzf.zzbsu;
        String str = zzaef.zzccy;
        boolean z = this.zzbzf.zzceq;
        long j2 = this.zzbzf.zzcer;
        zzjn zzjn = this.zzbze.zzacv;
        long j3 = j2;
        long j4 = this.zzbzf.zzcep;
        long j5 = this.zzbze.zzcoh;
        long j6 = this.zzbzf.zzceu;
        String str2 = this.zzbzf.zzcev;
        JSONObject jSONObject = this.zzbze.zzcob;
        zzaig zzaig = this.zzbzf.zzcfe;
        List<String> list4 = this.zzbzf.zzcff;
        List<String> list5 = this.zzbzf.zzcfg;
        boolean z2 = this.zzbzf.zzcfh;
        zzael zzael = this.zzbzf.zzcfi;
        List<String> list6 = this.zzbzf.zzbsr;
        String str3 = this.zzbzf.zzcfl;
        zzhs zzhs = this.zzbze.zzcoq;
        boolean z3 = this.zzbze.zzcos.zzzl;
        boolean z4 = this.zzbze.zzcor;
        boolean z5 = this.zzbze.zzcos.zzcfp;
        List<String> list7 = this.zzbzf.zzbsp;
        String str4 = str2;
        long j7 = j3;
        long j8 = j4;
        long j9 = j5;
        long j10 = j6;
        new zzajh(zzjj, zzaqw, list, i2, list2, list3, i3, j, str, z, (zzwx) null, (zzxq) null, (String) null, (zzwy) null, (zzxa) null, j7, zzjn, j8, j9, j10, str4, jSONObject, (zzpb) null, zzaig, list4, list5, z2, zzael, (String) null, list6, str3, zzhs, z3, z4, z5, list7, this.zzbze.zzcos.zzzm, this.zzbze.zzcos.zzcfq);
        zzabm.zzb(zzajh);
    }
}
