package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzay implements GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ StatusPendingResult zziv;

    zzay(zzav zzav, StatusPendingResult statusPendingResult) {
        this.zziv = statusPendingResult;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zziv.setResult(new Status(8));
    }
}
