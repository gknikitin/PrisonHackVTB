package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzix implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzij zzapn;
    /* access modifiers changed from: private */
    public volatile boolean zzapt;
    private volatile zzfg zzapu;

    protected zzix(zzij zzij) {
        this.zzapn = zzij;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
    @android.support.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(@android.support.annotation.Nullable android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            com.google.android.gms.internal.measurement.zzfg r0 = r3.zzapu     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            android.os.IInterface r0 = r0.getService()     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            com.google.android.gms.internal.measurement.zzez r0 = (com.google.android.gms.internal.measurement.zzez) r0     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            r3.zzapu = r4     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            com.google.android.gms.internal.measurement.zzij r1 = r3.zzapn     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            com.google.android.gms.internal.measurement.zzgh r1 = r1.zzge()     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            com.google.android.gms.internal.measurement.zzja r2 = new com.google.android.gms.internal.measurement.zzja     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            r2.<init>(r3, r0)     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            r1.zzc((java.lang.Runnable) r2)     // Catch:{ DeadObjectException | IllegalStateException -> 0x0022 }
            goto L_0x0027
        L_0x0020:
            r4 = move-exception
            goto L_0x0029
        L_0x0022:
            r3.zzapu = r4     // Catch:{ all -> 0x0020 }
            r4 = 0
            r3.zzapt = r4     // Catch:{ all -> 0x0020 }
        L_0x0027:
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            return
        L_0x0029:
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzix.onConnected(android.os.Bundle):void");
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfh zzjv = this.zzapn.zzacw.zzjv();
        if (zzjv != null) {
            zzjv.zziv().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzapt = false;
            this.zzapu = null;
        }
        this.zzapn.zzge().zzc((Runnable) new zzjc(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzapn.zzgf().zziy().log("Service connection suspended");
        this.zzapn.zzge().zzc((Runnable) new zzjb(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.zzapn.zzgf().zzis().log("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0063 */
    @android.support.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzapt = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzij r4 = r3.zzapn     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzfh r4 = r4.zzgf()     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzfj r4 = r4.zzis()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.log(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x009a
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0063 }
            if (r2 == 0) goto L_0x0053
            if (r5 != 0) goto L_0x002f
            goto L_0x0043
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0063 }
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzez     // Catch:{ RemoteException -> 0x0063 }
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.internal.measurement.zzez r1 = (com.google.android.gms.internal.measurement.zzez) r1     // Catch:{ RemoteException -> 0x0063 }
        L_0x003b:
            r0 = r1
            goto L_0x0043
        L_0x003d:
            com.google.android.gms.internal.measurement.zzfb r1 = new com.google.android.gms.internal.measurement.zzfb     // Catch:{ RemoteException -> 0x0063 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x003b
        L_0x0043:
            com.google.android.gms.internal.measurement.zzij r5 = r3.zzapn     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zziz()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.log(r1)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x0072
        L_0x0053:
            com.google.android.gms.internal.measurement.zzij r5 = r3.zzapn     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzg(r2, r1)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x0072
        L_0x0063:
            com.google.android.gms.internal.measurement.zzij r5 = r3.zzapn     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzfh r5 = r5.zzgf()     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzfj r5 = r5.zzis()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.log(r1)     // Catch:{ all -> 0x001c }
        L_0x0072:
            if (r0 != 0) goto L_0x008a
            r3.zzapt = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzij r5 = r3.zzapn     // Catch:{ IllegalArgumentException -> 0x0098 }
            android.content.Context r5 = r5.getContext()     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzij r0 = r3.zzapn     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzix r0 = r0.zzapg     // Catch:{ IllegalArgumentException -> 0x0098 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0098 }
            goto L_0x0098
        L_0x008a:
            com.google.android.gms.internal.measurement.zzij r4 = r3.zzapn     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zzgh r4 = r4.zzge()     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.measurement.zziy r5 = new com.google.android.gms.internal.measurement.zziy     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zzc((java.lang.Runnable) r5)     // Catch:{ all -> 0x001c }
        L_0x0098:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x009a:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzix.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzapn.zzgf().zziy().log("Service disconnected");
        this.zzapn.zzge().zzc((Runnable) new zziz(this, componentName));
    }

    @WorkerThread
    public final void zzc(Intent intent) {
        this.zzapn.zzab();
        Context context = this.zzapn.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzapt) {
                this.zzapn.zzgf().zziz().log("Connection attempt already in progress");
                return;
            }
            this.zzapn.zzgf().zziz().log("Using local app measurement service");
            this.zzapt = true;
            instance.bindService(context, intent, this.zzapn.zzapg, GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        }
    }

    @WorkerThread
    public final void zzkq() {
        this.zzapn.zzab();
        Context context = this.zzapn.getContext();
        synchronized (this) {
            if (this.zzapt) {
                this.zzapn.zzgf().zziz().log("Connection attempt already in progress");
            } else if (this.zzapu != null) {
                this.zzapn.zzgf().zziz().log("Already awaiting connection attempt");
            } else {
                this.zzapu = new zzfg(context, Looper.getMainLooper(), this, this);
                this.zzapn.zzgf().zziz().log("Connecting to remote service");
                this.zzapt = true;
                this.zzapu.checkAvailabilityAndConnect();
            }
        }
    }
}
