package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zzr implements zzbp {
    private final Context mContext;
    private final Looper zzcn;
    private final zzav zzfq;
    /* access modifiers changed from: private */
    public final zzbd zzfr;
    /* access modifiers changed from: private */
    public final zzbd zzfs;
    private final Map<Api.AnyClientKey<?>, zzbd> zzft;
    private final Set<SignInConnectionListener> zzfu = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zzfv;
    private Bundle zzfw;
    /* access modifiers changed from: private */
    public ConnectionResult zzfx = null;
    /* access modifiers changed from: private */
    public ConnectionResult zzfy = null;
    /* access modifiers changed from: private */
    public boolean zzfz = false;
    /* access modifiers changed from: private */
    public final Lock zzga;
    @GuardedBy("mLock")
    private int zzgb = 0;

    private zzr(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zzp> arrayList, ArrayList<zzp> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        Context context2 = context;
        this.mContext = context2;
        this.zzfq = zzav;
        Lock lock2 = lock;
        this.zzga = lock2;
        Looper looper2 = looper;
        this.zzcn = looper2;
        this.zzfv = client;
        Context context3 = context2;
        Lock lock3 = lock2;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zzbd zzbd = r3;
        zzbd zzbd2 = new zzbd(context3, this.zzfq, lock3, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends SignInClient, SignInOptions>) null, arrayList2, new zzt(this, (zzs) null));
        this.zzfr = zzbd;
        this.zzfs = new zzbd(context3, this.zzfq, lock3, looper, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zzu(this, (zzs) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.zzfr);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zzfs);
        }
        this.zzft = Collections.unmodifiableMap(arrayMap);
    }

    public static zzr zza(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = next2.getClientKey();
            if (arrayMap.containsKey(clientKey)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(clientKey)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zzp zzp = (zzp) obj;
            if (arrayMap3.containsKey(zzp.mApi)) {
                arrayList2.add(zzp);
            } else if (arrayMap4.containsKey(zzp.mApi)) {
                arrayList3.add(zzp);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzr(context, zzav, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zza(int i, boolean z) {
        this.zzfq.zzb(i, z);
        this.zzfy = null;
        this.zzfx = null;
    }

    /* access modifiers changed from: private */
    public final void zza(Bundle bundle) {
        if (this.zzfw == null) {
            this.zzfw = bundle;
        } else if (bundle != null) {
            this.zzfw.putAll(bundle);
        }
    }

    @GuardedBy("mLock")
    private final void zza(ConnectionResult connectionResult) {
        switch (this.zzgb) {
            case 1:
                break;
            case 2:
                this.zzfq.zzc(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzab();
        this.zzgb = 0;
    }

    private final boolean zza(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zzft.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzft.get(clientKey).equals(this.zzfs);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zzaa() {
        if (zzb(this.zzfx)) {
            if (zzb(this.zzfy) || zzac()) {
                switch (this.zzgb) {
                    case 1:
                        break;
                    case 2:
                        this.zzfq.zzb(this.zzfw);
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                zzab();
                this.zzgb = 0;
            } else if (this.zzfy == null) {
            } else {
                if (this.zzgb == 1) {
                    zzab();
                    return;
                }
                zza(this.zzfy);
                this.zzfr.disconnect();
            }
        } else if (this.zzfx != null && zzb(this.zzfy)) {
            this.zzfs.disconnect();
            zza(this.zzfx);
        } else if (this.zzfx != null && this.zzfy != null) {
            ConnectionResult connectionResult = this.zzfx;
            if (this.zzfs.zzje < this.zzfr.zzje) {
                connectionResult = this.zzfy;
            }
            zza(connectionResult);
        }
    }

    @GuardedBy("mLock")
    private final void zzab() {
        for (SignInConnectionListener onComplete : this.zzfu) {
            onComplete.onComplete();
        }
        this.zzfu.clear();
    }

    @GuardedBy("mLock")
    private final boolean zzac() {
        return this.zzfy != null && this.zzfy.getErrorCode() == 4;
    }

    @Nullable
    private final PendingIntent zzad() {
        if (this.zzfv == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfq), this.zzfv.getSignInIntent(), 134217728);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @GuardedBy("mLock")
    public final void connect() {
        this.zzgb = 2;
        this.zzfz = false;
        this.zzfy = null;
        this.zzfx = null;
        this.zzfr.connect();
        this.zzfs.connect();
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        this.zzfy = null;
        this.zzfx = null;
        this.zzgb = 0;
        this.zzfr.disconnect();
        this.zzfs.disconnect();
        zzab();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zzfs.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zzfr.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        if (!zza((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zzfr.enqueue(t);
        }
        if (!zzac()) {
            return this.zzfs.enqueue(t);
        }
        t.setFailedResult(new Status(4, (String) null, zzad()));
        return t;
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        if (!zza((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zzfr.execute(t);
        }
        if (!zzac()) {
            return this.zzfs.execute(t);
        }
        t.setFailedResult(new Status(4, (String) null, zzad()));
        return t;
    }

    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return this.zzft.get(api.getClientKey()).equals(this.zzfs) ? zzac() ? new ConnectionResult(4, zzad()) : this.zzfs.getConnectionResult(api) : this.zzfr.getConnectionResult(api);
    }

    public final boolean isConnected() {
        this.zzga.lock();
        try {
            boolean z = true;
            if (!this.zzfr.isConnected() || (!this.zzfs.isConnected() && !zzac() && this.zzgb != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzga.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzga.lock();
        try {
            return this.zzgb == 2;
        } finally {
            this.zzga.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zzga.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zzfs.isConnected()) {
                this.zzfu.add(signInConnectionListener);
                if (this.zzgb == 0) {
                    this.zzgb = 1;
                }
                this.zzfy = null;
                this.zzfs.connect();
                return true;
            }
            this.zzga.unlock();
            return false;
        } finally {
            this.zzga.unlock();
        }
    }

    public final void maybeSignOut() {
        this.zzga.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfs.disconnect();
            this.zzfy = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzcn).post(new zzs(this));
            } else {
                zzab();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void zzz() {
        this.zzfr.zzz();
        this.zzfs.zzz();
    }
}
