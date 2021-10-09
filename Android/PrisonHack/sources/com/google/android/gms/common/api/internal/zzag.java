package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public final class zzag implements zzbc {
    /* access modifiers changed from: private */
    public final zzbd zzhf;
    private boolean zzhg = false;

    public zzag(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    public final void begin() {
    }

    public final void connect() {
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zza((zzbe) new zzai(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.zzhg) {
            return false;
        }
        if (this.zzhf.zzfq.zzba()) {
            this.zzhg = true;
            for (zzch zzcc : this.zzhf.zzfq.zziq) {
                zzcc.zzcc();
            }
            return false;
        }
        this.zzhf.zzf((ConnectionResult) null);
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return execute(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.zzhf.zzfq.zzir.zzb(t);
            zzav zzav = this.zzhf.zzfq;
            Api.Client client = zzav.zzil.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zzhf.zzjb.containsKey(t.getClientKey())) {
                boolean z = client instanceof SimpleClientAdapter;
                Api.AnyClient anyClient = client;
                if (z) {
                    anyClient = ((SimpleClientAdapter) client).getClient();
                }
                t.run(anyClient);
                return t;
            }
            t.setFailedResult(new Status(17));
            return t;
        } catch (DeadObjectException unused) {
            this.zzhf.zza((zzbe) new zzah(this, this));
            return t;
        }
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        this.zzhf.zzf((ConnectionResult) null);
        this.zzhf.zzjf.zzb(i, this.zzhg);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final void zzap() {
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zzfq.zzir.release();
            disconnect();
        }
    }
}
