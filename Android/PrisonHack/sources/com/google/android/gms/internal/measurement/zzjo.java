package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.p000v4.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;

public final class zzjo extends zzjr {
    private final zzeo zzaqh;
    private final AlarmManager zzyi = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private Integer zzyj;

    protected zzjo(zzjs zzjs) {
        super(zzjs);
        this.zzaqh = new zzjp(this, zzjs.zzlj(), zzjs);
    }

    private final int getJobId() {
        if (this.zzyj == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzyj = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzyj.intValue();
    }

    private final PendingIntent zzek() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    @TargetApi(24)
    private final void zzku() {
        zzgf().zziz().zzg("Cancelling job. JobID", Integer.valueOf(getJobId()));
        ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(getJobId());
    }

    public final void cancel() {
        zzch();
        this.zzyi.cancel(zzek());
        this.zzaqh.cancel();
        if (Build.VERSION.SDK_INT >= 24) {
            zzku();
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
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

    public final void zzh(long j) {
        zzch();
        zzgi();
        if (!zzgc.zza(getContext())) {
            zzgf().zziy().log("Receiver not registered/enabled");
        }
        zzgi();
        if (!zzkc.zza(getContext(), false)) {
            zzgf().zziy().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzbt().elapsedRealtime() + j;
        if (j < Math.max(0, zzey.zzahm.get().longValue()) && !this.zzaqh.zzef()) {
            zzgf().zziz().log("Scheduling upload with DelayedRunnable");
            this.zzaqh.zzh(j);
        }
        zzgi();
        if (Build.VERSION.SDK_INT >= 24) {
            zzgf().zziz().log("Scheduling upload with JobScheduler");
            JobInfo.Builder builder = new JobInfo.Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzgf().zziz().zzg("Scheduling job. JobID", Integer.valueOf(getJobId()));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).schedule(build);
            return;
        }
        zzgf().zziz().log("Scheduling upload with AlarmManager");
        this.zzyi.setInexactRepeating(2, elapsedRealtime, Math.max(zzey.zzahh.get().longValue(), j), zzek());
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        this.zzyi.cancel(zzek());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzku();
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
