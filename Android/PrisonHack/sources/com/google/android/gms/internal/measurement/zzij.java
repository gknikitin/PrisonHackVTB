package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzij extends zzhi {
    /* access modifiers changed from: private */
    public final zzix zzapg;
    /* access modifiers changed from: private */
    public zzez zzaph;
    private volatile Boolean zzapi;
    private final zzeo zzapj;
    private final zzjn zzapk;
    private final List<Runnable> zzapl = new ArrayList();
    private final zzeo zzapm;

    protected zzij(zzgm zzgm) {
        super(zzgm);
        this.zzapk = new zzjn(zzgm.zzbt());
        this.zzapg = new zzix(this);
        this.zzapj = new zzik(this, zzgm);
        this.zzapm = new zzip(this, zzgm);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzab();
        if (this.zzaph != null) {
            this.zzaph = null;
            zzgf().zziz().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcu() {
        zzab();
        this.zzapk.start();
        this.zzapj.zzh(zzey.zzahv.get().longValue());
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcv() {
        zzab();
        if (isConnected()) {
            zzgf().zziz().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzab();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzapl.size()) >= 1000) {
            zzgf().zzis().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzapl.add(runnable);
            this.zzapm.zzh(60000);
            zzdf();
        }
    }

    @Nullable
    @WorkerThread
    private final zzdz zzk(boolean z) {
        zzgi();
        return zzfw().zzbh(z ? zzgf().zzjb() : null);
    }

    private final boolean zzkn() {
        zzgi();
        return true;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzkp() {
        zzab();
        zzgf().zziz().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapl.size()));
        for (Runnable run : this.zzapl) {
            try {
                run.run();
            } catch (Exception e) {
                zzgf().zzis().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzapl.clear();
        this.zzapm.cancel();
    }

    @WorkerThread
    public final void disconnect() {
        zzab();
        zzch();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzapg);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzaph = null;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzab();
        zzch();
        return this.zzaph != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void resetAnalyticsData() {
        zzab();
        zzfs();
        zzch();
        zzdz zzk = zzk(false);
        if (zzkn()) {
            zzga().resetAnalyticsData();
        }
        zzf(new zzil(this, zzk));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzez zzez) {
        zzab();
        Preconditions.checkNotNull(zzez);
        this.zzaph = zzez;
        zzcu();
        zzkp();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzez zzez, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        int i;
        zzfj zzis;
        String str;
        List<AbstractSafeParcelable> zzp;
        zzab();
        zzfs();
        zzch();
        boolean zzkn = zzkn();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzkn || (zzp = zzga().zzp(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zzp);
                i = zzp.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzew) {
                    try {
                        zzez.zza((zzew) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e) {
                        e = e;
                        zzis = zzgf().zzis();
                        str = "Failed to send event to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzjz) {
                    try {
                        zzez.zza((zzjz) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        e = e2;
                        zzis = zzgf().zzis();
                        str = "Failed to send attribute to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzee) {
                    try {
                        zzez.zza((zzee) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e3) {
                        e = e3;
                        zzis = zzgf().zzis();
                        str = "Failed to send conditional property to the service";
                    }
                } else {
                    zzgf().zzis().log("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
        return;
        zzis.zzg(str, e);
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzab();
        zzch();
        zzf(new zzim(this, atomicReference, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzee>> atomicReference, String str, String str2, String str3) {
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjz>> atomicReference, String str, String str2, String str3, boolean z) {
        zzab();
        zzch();
        zzf(new zziu(this, atomicReference, str, str2, str3, z, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjz>> atomicReference, boolean z) {
        zzab();
        zzch();
        zzf(new zziw(this, atomicReference, zzk(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzew zzew, String str) {
        Preconditions.checkNotNull(zzew);
        zzab();
        zzch();
        boolean zzkn = zzkn();
        zzf(new zzir(this, zzkn, zzkn && zzga().zza(zzew), zzew, zzk(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzif zzif) {
        zzab();
        zzch();
        zzf(new zzio(this, zzif));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzjz zzjz) {
        zzab();
        zzch();
        zzf(new zziv(this, zzkn() && zzga().zza(zzjz), zzjz, zzk(true)));
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzd(zzee zzee) {
        Preconditions.checkNotNull(zzee);
        zzab();
        zzch();
        zzgi();
        zzf(new zzis(this, true, zzga().zzc(zzee), new zzee(zzee), zzk(true), zzee));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c9, code lost:
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f2  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdf() {
        /*
            r6 = this;
            r6.zzab()
            r6.zzch()
            boolean r0 = r6.isConnected()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Boolean r0 = r6.zzapi
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x00ff
            r6.zzab()
            r6.zzch()
            com.google.android.gms.internal.measurement.zzfs r0 = r6.zzgg()
            java.lang.Boolean r0 = r0.zzji()
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            r3 = 1
            goto L_0x00f9
        L_0x002c:
            r6.zzgi()
            com.google.android.gms.internal.measurement.zzfc r0 = r6.zzfw()
            int r0 = r0.zziq()
            if (r0 != r2) goto L_0x003d
        L_0x0039:
            r0 = 1
            r3 = 1
            goto L_0x00f0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()
            java.lang.String r3 = "Checking service availability"
            r0.log(r3)
            com.google.android.gms.internal.measurement.zzkc r0 = r6.zzgc()
            com.google.android.gms.common.GoogleApiAvailabilityLight r3 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()
            android.content.Context r0 = r0.getContext()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r0 = r3.isGooglePlayServicesAvailable(r0, r4)
            r3 = 9
            if (r0 == r3) goto L_0x00e5
            r3 = 18
            if (r0 == r3) goto L_0x00da
            switch(r0) {
                case 0: goto L_0x00cb;
                case 1: goto L_0x00bc;
                case 2: goto L_0x008b;
                case 3: goto L_0x007d;
                default: goto L_0x0068;
            }
        L_0x0068:
            com.google.android.gms.internal.measurement.zzfh r3 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r3 = r3.zziv()
            java.lang.String r4 = "Unexpected service status"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.zzg(r4, r0)
        L_0x0079:
            r0 = 0
        L_0x007a:
            r3 = 0
            goto L_0x00f0
        L_0x007d:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziv()
            java.lang.String r3 = "Service disabled"
        L_0x0087:
            r0.log(r3)
            goto L_0x0079
        L_0x008b:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziy()
            java.lang.String r3 = "Service container out of date"
            r0.log(r3)
            com.google.android.gms.internal.measurement.zzkc r0 = r6.zzgc()
            int r0 = r0.zzlm()
            r3 = 12600(0x3138, float:1.7656E-41)
            if (r0 >= r3) goto L_0x00a5
            goto L_0x00c9
        L_0x00a5:
            com.google.android.gms.internal.measurement.zzfs r0 = r6.zzgg()
            java.lang.Boolean r0 = r0.zzji()
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r0 = 0
            goto L_0x00b9
        L_0x00b8:
            r0 = 1
        L_0x00b9:
            r3 = r0
            r0 = 0
            goto L_0x00f0
        L_0x00bc:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()
            java.lang.String r3 = "Service missing"
            r0.log(r3)
        L_0x00c9:
            r0 = 1
            goto L_0x007a
        L_0x00cb:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziz()
            java.lang.String r3 = "Service available"
        L_0x00d5:
            r0.log(r3)
            goto L_0x0039
        L_0x00da:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziv()
            java.lang.String r3 = "Service updating"
            goto L_0x00d5
        L_0x00e5:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zziv()
            java.lang.String r3 = "Service invalid"
            goto L_0x0087
        L_0x00f0:
            if (r0 == 0) goto L_0x00f9
            com.google.android.gms.internal.measurement.zzfs r0 = r6.zzgg()
            r0.zzf(r3)
        L_0x00f9:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            r6.zzapi = r0
        L_0x00ff:
            java.lang.Boolean r0 = r6.zzapi
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.internal.measurement.zzix r0 = r6.zzapg
            r0.zzkq()
            return
        L_0x010d:
            r6.zzgi()
            android.content.Context r0 = r6.getContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.Context r4 = r6.getContext()
            java.lang.String r5 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r3 = r3.setClassName(r4, r5)
            r4 = 65536(0x10000, float:9.18355E-41)
            java.util.List r0 = r0.queryIntentServices(r3, r4)
            if (r0 == 0) goto L_0x0136
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0136
            r1 = 1
        L_0x0136:
            if (r1 == 0) goto L_0x0156
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.measurement.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r2 = r6.getContext()
            r6.zzgi()
            java.lang.String r3 = "com.google.android.gms.measurement.AppMeasurementService"
            r1.<init>(r2, r3)
            r0.setComponent(r1)
            com.google.android.gms.internal.measurement.zzix r1 = r6.zzapg
            r1.zzc(r0)
            return
        L_0x0156:
            com.google.android.gms.internal.measurement.zzfh r0 = r6.zzgf()
            com.google.android.gms.internal.measurement.zzfj r0 = r0.zzis()
            java.lang.String r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest"
            r0.log(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzij.zzdf():void");
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

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzkj() {
        zzab();
        zzch();
        zzf(new zzin(this, zzk(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzkm() {
        zzab();
        zzch();
        zzf(new zziq(this, zzk(true)));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzko() {
        return this.zzapi;
    }
}
