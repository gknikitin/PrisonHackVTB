package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzw implements zzbp {
    private final Looper zzcn;
    private final GoogleApiManager zzcq;
    /* access modifiers changed from: private */
    public final Lock zzga;
    private final ClientSettings zzgf;
    /* access modifiers changed from: private */
    public final Map<Api.AnyClientKey<?>, zzv<?>> zzgg = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Api.AnyClientKey<?>, zzv<?>> zzgh = new HashMap();
    private final Map<Api<?>, Boolean> zzgi;
    /* access modifiers changed from: private */
    public final zzav zzgj;
    private final GoogleApiAvailabilityLight zzgk;
    /* access modifiers changed from: private */
    public final Condition zzgl;
    private final boolean zzgm;
    /* access modifiers changed from: private */
    public final boolean zzgn;
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean zzgp;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public Map<zzh<?>, ConnectionResult> zzgq;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public Map<zzh<?>, ConnectionResult> zzgr;
    @GuardedBy("mLock")
    private zzz zzgs;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public ConnectionResult zzgt;

    public zzw(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzav zzav, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.zzga = lock;
        Looper looper2 = looper;
        this.zzcn = looper2;
        this.zzgl = lock.newCondition();
        this.zzgk = googleApiAvailabilityLight;
        this.zzgj = zzav;
        this.zzgi = map2;
        ClientSettings clientSettings2 = clientSettings;
        this.zzgf = clientSettings2;
        this.zzgm = z;
        HashMap hashMap = new HashMap();
        for (Api next : map2.keySet()) {
            hashMap.put(next.getClientKey(), next);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzp zzp = (zzp) obj;
            hashMap2.put(zzp.mApi, zzp);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry next2 : map.entrySet()) {
            Api api = (Api) hashMap.get(next2.getKey());
            Api.Client client = (Api.Client) next2.getValue();
            if (client.requiresGooglePlayServices()) {
                if (!this.zzgi.get(api).booleanValue()) {
                    z3 = z6;
                    z4 = true;
                } else {
                    z3 = z6;
                    z4 = z7;
                }
                z2 = true;
            } else {
                z2 = z5;
                z4 = z7;
                z3 = false;
            }
            zzv zzv = r1;
            Api.Client client2 = client;
            Map.Entry entry = next2;
            zzv zzv2 = new zzv(context, api, looper2, client, (zzp) hashMap2.get(api), clientSettings2, abstractClientBuilder);
            this.zzgg.put((Api.AnyClientKey) entry.getKey(), zzv);
            if (client2.requiresSignIn()) {
                this.zzgh.put((Api.AnyClientKey) entry.getKey(), zzv);
            }
            z7 = z4;
            z6 = z3;
            z5 = z2;
            looper2 = looper;
        }
        this.zzgn = z5 && !z6 && !z7;
        this.zzcq = GoogleApiManager.zzbf();
    }

    @Nullable
    private final ConnectionResult zza(@NonNull Api.AnyClientKey<?> anyClientKey) {
        this.zzga.lock();
        try {
            zzv zzv = this.zzgg.get(anyClientKey);
            if (this.zzgq != null && zzv != null) {
                return this.zzgq.get(zzv.zzm());
            }
            this.zzga.unlock();
            return null;
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(zzv<?> zzv, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.zzgi.get(zzv.getApi()).booleanValue() && zzv.zzae().requiresGooglePlayServices() && this.zzgk.isUserResolvableError(connectionResult.getErrorCode());
    }

    private final boolean zzaf() {
        this.zzga.lock();
        try {
            if (this.zzgp) {
                if (this.zzgm) {
                    for (Api.AnyClientKey<?> zza : this.zzgh.keySet()) {
                        ConnectionResult zza2 = zza(zza);
                        if (zza2 != null) {
                            if (!zza2.isSuccess()) {
                            }
                        }
                    }
                    this.zzga.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zzag() {
        if (this.zzgf == null) {
            this.zzgj.zzim = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api next : optionalApiSettings.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(next);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(optionalApiSettings.get(next).mScopes);
            }
        }
        this.zzgj.zzim = hashSet;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zzah() {
        while (!this.zzgo.isEmpty()) {
            execute(this.zzgo.remove());
        }
        this.zzgj.zzb((Bundle) null);
    }

    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult zzai() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zzv next : this.zzgg.values()) {
            Api api = next.getApi();
            ConnectionResult connectionResult3 = this.zzgq.get(next.zzm());
            if (!connectionResult3.isSuccess() && (!this.zzgi.get(api).booleanValue() || connectionResult3.hasResolution() || this.zzgk.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() != 4 || !this.zzgm) {
                    int priority = api.zzj().getPriority();
                    if (connectionResult == null || i > priority) {
                        connectionResult = connectionResult3;
                        i = priority;
                    }
                } else {
                    int priority2 = api.zzj().getPriority();
                    if (connectionResult2 == null || i2 > priority2) {
                        connectionResult2 = connectionResult3;
                        i2 = priority2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zzb(@NonNull T t) {
        Api.AnyClientKey clientKey = t.getClientKey();
        ConnectionResult zza = zza((Api.AnyClientKey<?>) clientKey);
        if (zza == null || zza.getErrorCode() != 4) {
            return false;
        }
        t.setFailedResult(new Status(4, (String) null, this.zzcq.zza((zzh<?>) this.zzgg.get(clientKey).zzm(), System.identityHashCode(this.zzgj))));
        return true;
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzgl.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        return isConnected() ? ConnectionResult.RESULT_SUCCESS : this.zzgt != null ? this.zzgt : new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zzgl.awaitNanos(nanos);
            }
        }
        return isConnected() ? ConnectionResult.RESULT_SUCCESS : this.zzgt != null ? this.zzgt : new ConnectionResult(13, (PendingIntent) null);
    }

    public final void connect() {
        this.zzga.lock();
        try {
            if (!this.zzgp) {
                this.zzgp = true;
                this.zzgq = null;
                this.zzgr = null;
                this.zzgs = null;
                this.zzgt = null;
                this.zzcq.zzr();
                this.zzcq.zza((Iterable<? extends GoogleApi<?>>) this.zzgg.values()).addOnCompleteListener((Executor) new HandlerExecutor(this.zzcn), new zzy(this));
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public final void disconnect() {
        this.zzga.lock();
        try {
            this.zzgp = false;
            this.zzgq = null;
            this.zzgr = null;
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            this.zzgt = null;
            while (!this.zzgo.isEmpty()) {
                BaseImplementation.ApiMethodImpl remove = this.zzgo.remove();
                remove.zza((zzcn) null);
                remove.cancel();
            }
            this.zzgl.signalAll();
        } finally {
            this.zzga.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        if (this.zzgm && zzb(t)) {
            return t;
        }
        if (!isConnected()) {
            this.zzgo.add(t);
            return t;
        }
        this.zzgj.zzir.zzb(t);
        return this.zzgg.get(t.getClientKey()).doRead(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        Api.AnyClientKey clientKey = t.getClientKey();
        if (this.zzgm && zzb(t)) {
            return t;
        }
        this.zzgj.zzir.zzb(t);
        return this.zzgg.get(clientKey).doWrite(t);
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return zza(api.getClientKey());
    }

    public final boolean isConnected() {
        this.zzga.lock();
        try {
            return this.zzgq != null && this.zzgt == null;
        } finally {
            this.zzga.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzga.lock();
        try {
            return this.zzgq == null && this.zzgp;
        } finally {
            this.zzga.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zzga.lock();
        try {
            if (!this.zzgp || zzaf()) {
                this.zzga.unlock();
                return false;
            }
            this.zzcq.zzr();
            this.zzgs = new zzz(this, signInConnectionListener);
            this.zzcq.zza((Iterable<? extends GoogleApi<?>>) this.zzgh.values()).addOnCompleteListener((Executor) new HandlerExecutor(this.zzcn), this.zzgs);
            this.zzga.unlock();
            return true;
        } catch (Throwable th) {
            this.zzga.unlock();
            throw th;
        }
    }

    public final void maybeSignOut() {
        this.zzga.lock();
        try {
            this.zzcq.maybeSignOut();
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            if (this.zzgr == null) {
                this.zzgr = new ArrayMap(this.zzgh.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzv<?> zzm : this.zzgh.values()) {
                this.zzgr.put(zzm.zzm(), connectionResult);
            }
            if (this.zzgq != null) {
                this.zzgq.putAll(this.zzgr);
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public final void zzz() {
    }
}
