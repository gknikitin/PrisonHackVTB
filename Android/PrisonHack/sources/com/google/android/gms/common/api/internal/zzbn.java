package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Collections;

final class zzbn implements Runnable {
    private final /* synthetic */ ConnectionResult zzkl;
    private final /* synthetic */ GoogleApiManager.zzc zzkr;

    zzbn(GoogleApiManager.zzc zzc, ConnectionResult connectionResult) {
        this.zzkr = zzc;
        this.zzkl = connectionResult;
    }

    public final void run() {
        if (this.zzkl.isSuccess()) {
            boolean unused = this.zzkr.zzkq = true;
            if (this.zzkr.zzka.requiresSignIn()) {
                this.zzkr.zzbu();
            } else {
                this.zzkr.zzka.getRemoteService((IAccountAccessor) null, Collections.emptySet());
            }
        } else {
            ((GoogleApiManager.zza) GoogleApiManager.this.zzju.get(this.zzkr.zzhc)).onConnectionFailed(this.zzkl);
        }
    }
}
