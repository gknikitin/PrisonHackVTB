package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicReference;

public class zzgm implements zzhj {
    private static volatile zzgm zzamn;
    private final long zzaem;
    private final zzec zzagd;
    private final String zzamo;
    private final zzeg zzamp;
    private final zzfs zzamq;
    private final zzfh zzamr;
    private final zzgh zzams;
    private final zzji zzamt;
    private final AppMeasurement zzamu;
    private final FirebaseAnalytics zzamv;
    private final zzkc zzamw;
    private final zzff zzamx;
    private final zzig zzamy;
    private final zzhl zzamz;
    private final zzdu zzana;
    private zzfd zzanb;
    private zzij zzanc;
    private zzeq zzand;
    private zzfc zzane;
    private zzfy zzanf;
    private Boolean zzang;
    private long zzanh;
    private int zzani;
    private int zzanj;
    private final Context zzqx;
    private final Clock zzro;
    private boolean zzvo = false;

    private zzgm(zzhk zzhk) {
        String str;
        zzfj zzfj;
        Preconditions.checkNotNull(zzhk);
        this.zzagd = new zzec(zzhk.zzqx);
        zzey.zza(this.zzagd);
        this.zzqx = zzhk.zzqx;
        this.zzamo = zzhk.zzamo;
        zzwu.init(this.zzqx);
        this.zzro = DefaultClock.getInstance();
        this.zzaem = this.zzro.currentTimeMillis();
        this.zzamp = new zzeg(this);
        zzfs zzfs = new zzfs(this);
        zzfs.zzm();
        this.zzamq = zzfs;
        zzfh zzfh = new zzfh(this);
        zzfh.zzm();
        this.zzamr = zzfh;
        zzkc zzkc = new zzkc(this);
        zzkc.zzm();
        this.zzamw = zzkc;
        zzff zzff = new zzff(this);
        zzff.zzm();
        this.zzamx = zzff;
        this.zzana = new zzdu(this);
        zzig zzig = new zzig(this);
        zzig.zzm();
        this.zzamy = zzig;
        zzhl zzhl = new zzhl(this);
        zzhl.zzm();
        this.zzamz = zzhl;
        this.zzamu = new AppMeasurement(this);
        this.zzamv = new FirebaseAnalytics(this);
        zzji zzji = new zzji(this);
        zzji.zzm();
        this.zzamt = zzji;
        zzgh zzgh = new zzgh(this);
        zzgh.zzm();
        this.zzams = zzgh;
        zzec zzec = this.zzagd;
        if (this.zzqx.getApplicationContext() instanceof Application) {
            zzhl zzfv = zzfv();
            if (zzfv.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzfv.getContext().getApplicationContext();
                if (zzfv.zzanz == null) {
                    zzfv.zzanz = new zzie(zzfv, (zzhm) null);
                }
                application.unregisterActivityLifecycleCallbacks(zzfv.zzanz);
                application.registerActivityLifecycleCallbacks(zzfv.zzanz);
                zzfj = zzfv.zzgf().zziz();
                str = "Registered activity lifecycle callback";
            }
            this.zzams.zzc((Runnable) new zzgn(this, zzhk));
        }
        zzfj = zzgf().zziv();
        str = "Application context is not an Application";
        zzfj.log(str);
        this.zzams.zzc((Runnable) new zzgn(this, zzhk));
    }

    public static zzgm zza(Context context, String str, String str2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzamn == null) {
            synchronized (zzgm.class) {
                if (zzamn == null) {
                    zzamn = new zzgm(new zzhk(context, (String) null));
                }
            }
        }
        return zzamn;
    }

    private static void zza(zzhh zzhh) {
        if (zzhh == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzhi zzhi) {
        if (zzhi == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzhi.isInitialized()) {
            String valueOf = String.valueOf(zzhi.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzhk zzhk) {
        String str;
        zzfj zzfj;
        zzge().zzab();
        zzeg.zzhi();
        zzeq zzeq = new zzeq(this);
        zzeq.zzm();
        this.zzand = zzeq;
        zzfc zzfc = new zzfc(this);
        zzfc.zzm();
        this.zzane = zzfc;
        zzfd zzfd = new zzfd(this);
        zzfd.zzm();
        this.zzanb = zzfd;
        zzij zzij = new zzij(this);
        zzij.zzm();
        this.zzanc = zzij;
        this.zzamw.zzke();
        this.zzamq.zzke();
        this.zzanf = new zzfy(this);
        this.zzane.zzke();
        zzgf().zzix().zzg("App measurement is starting up, version", 12451L);
        zzec zzec = this.zzagd;
        zzgf().zzix().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzec zzec2 = this.zzagd;
        String zzah = zzfc.zzah();
        if (zzgc().zzci(zzah)) {
            zzfj = zzgf().zzix();
            str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzfj = zzgf().zzix();
            String valueOf = String.valueOf(zzah);
            str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        zzfj.log(str);
        zzgf().zziy().log("Debug-level message logging enabled");
        if (this.zzani != this.zzanj) {
            zzgf().zzis().zze("Not all components initialized", Integer.valueOf(this.zzani), Integer.valueOf(this.zzanj));
        }
        this.zzvo = true;
    }

    private final void zzch() {
        if (!this.zzvo) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    public final Context getContext() {
        return this.zzqx;
    }

    @WorkerThread
    public final boolean isEnabled() {
        zzge().zzab();
        zzch();
        boolean z = false;
        if (this.zzamp.zzhj()) {
            return false;
        }
        Boolean zzhk = this.zzamp.zzhk();
        if (zzhk != null) {
            z = zzhk.booleanValue();
        } else if (!GoogleServices.isMeasurementExplicitlyDisabled()) {
            z = true;
        }
        return zzgg().zzg(z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        zzge().zzab();
        if (zzgg().zzakd.get() == 0) {
            zzgg().zzakd.set(this.zzro.currentTimeMillis());
        }
        if (Long.valueOf(zzgg().zzaki.get()).longValue() == 0) {
            zzgf().zziz().zzg("Persisting first open", Long.valueOf(this.zzaem));
            zzgg().zzaki.set(this.zzaem);
        }
        if (zzkd()) {
            zzec zzec = this.zzagd;
            if (!TextUtils.isEmpty(zzfw().getGmpAppId())) {
                String zzjg = zzgg().zzjg();
                if (zzjg == null) {
                    zzgg().zzbp(zzfw().getGmpAppId());
                } else if (!zzjg.equals(zzfw().getGmpAppId())) {
                    zzgf().zzix().log("Rechecking which service to use due to a GMP App Id change");
                    zzgg().zzjj();
                    this.zzanc.disconnect();
                    this.zzanc.zzdf();
                    zzgg().zzbp(zzfw().getGmpAppId());
                    zzgg().zzaki.set(this.zzaem);
                    zzgg().zzakk.zzbr((String) null);
                }
            }
            zzfv().zzbq(zzgg().zzakk.zzjn());
            zzec zzec2 = this.zzagd;
            if (!TextUtils.isEmpty(zzfw().getGmpAppId())) {
                boolean isEnabled = isEnabled();
                if (!zzgg().zzjm() && !this.zzamp.zzhj()) {
                    zzgg().zzh(!isEnabled);
                }
                if (!this.zzamp.zzay(zzfw().zzah()) || isEnabled) {
                    zzfv().zzkj();
                }
                zzfy().zza((AtomicReference<String>) new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!zzgc().zzw("android.permission.INTERNET")) {
                zzgf().zzis().log("App is missing INTERNET permission");
            }
            if (!zzgc().zzw("android.permission.ACCESS_NETWORK_STATE")) {
                zzgf().zzis().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            zzec zzec3 = this.zzagd;
            if (!Wrappers.packageManager(this.zzqx).isCallerInstantApp()) {
                if (!zzgc.zza(this.zzqx)) {
                    zzgf().zzis().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkc.zza(this.zzqx, false)) {
                    zzgf().zzis().log("AppMeasurementService not registered/enabled");
                }
            }
            zzgf().zzis().log("Uploading is not possible. App measurement disabled");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzhi zzhi) {
        this.zzani++;
    }

    public final Clock zzbt() {
        return this.zzro;
    }

    /* access modifiers changed from: package-private */
    public final void zzfr() {
        zzec zzec = this.zzagd;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zzfs() {
        zzec zzec = this.zzagd;
    }

    public final zzdu zzfu() {
        zza((zzhh) this.zzana);
        return this.zzana;
    }

    public final zzhl zzfv() {
        zza((zzhi) this.zzamz);
        return this.zzamz;
    }

    public final zzfc zzfw() {
        zza((zzhi) this.zzane);
        return this.zzane;
    }

    public final zzeq zzfx() {
        zza((zzhi) this.zzand);
        return this.zzand;
    }

    public final zzij zzfy() {
        zza((zzhi) this.zzanc);
        return this.zzanc;
    }

    public final zzig zzfz() {
        zza((zzhi) this.zzamy);
        return this.zzamy;
    }

    public final zzfd zzga() {
        zza((zzhi) this.zzanb);
        return this.zzanb;
    }

    public final zzff zzgb() {
        zza((zzhh) this.zzamx);
        return this.zzamx;
    }

    public final zzkc zzgc() {
        zza((zzhh) this.zzamw);
        return this.zzamw;
    }

    public final zzji zzgd() {
        zza((zzhi) this.zzamt);
        return this.zzamt;
    }

    public final zzgh zzge() {
        zza((zzhi) this.zzams);
        return this.zzams;
    }

    public final zzfh zzgf() {
        zza((zzhi) this.zzamr);
        return this.zzamr;
    }

    public final zzfs zzgg() {
        zza((zzhh) this.zzamq);
        return this.zzamq;
    }

    public final zzeg zzgh() {
        return this.zzamp;
    }

    public final zzec zzgi() {
        return this.zzagd;
    }

    public final zzfh zzjv() {
        if (this.zzamr == null || !this.zzamr.isInitialized()) {
            return null;
        }
        return this.zzamr;
    }

    public final zzfy zzjw() {
        return this.zzanf;
    }

    /* access modifiers changed from: package-private */
    public final zzgh zzjx() {
        return this.zzams;
    }

    public final AppMeasurement zzjy() {
        return this.zzamu;
    }

    public final FirebaseAnalytics zzjz() {
        return this.zzamv;
    }

    public final String zzka() {
        return this.zzamo;
    }

    /* access modifiers changed from: package-private */
    public final long zzkb() {
        Long valueOf = Long.valueOf(zzgg().zzaki.get());
        return valueOf.longValue() == 0 ? this.zzaem : Math.min(this.zzaem, valueOf.longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzkc() {
        this.zzanj++;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzkd() {
        zzch();
        zzge().zzab();
        if (this.zzang == null || this.zzanh == 0 || (this.zzang != null && !this.zzang.booleanValue() && Math.abs(this.zzro.elapsedRealtime() - this.zzanh) > 1000)) {
            this.zzanh = this.zzro.elapsedRealtime();
            zzec zzec = this.zzagd;
            boolean z = false;
            if (zzgc().zzw("android.permission.INTERNET") && zzgc().zzw("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzqx).isCallerInstantApp() || (zzgc.zza(this.zzqx) && zzkc.zza(this.zzqx, false)))) {
                z = true;
            }
            this.zzang = Boolean.valueOf(z);
            if (this.zzang.booleanValue()) {
                this.zzang = Boolean.valueOf(zzgc().zzcf(zzfw().getGmpAppId()));
            }
        }
        return this.zzang.booleanValue();
    }
}
