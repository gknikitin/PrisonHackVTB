package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
final class zzat extends BroadcastReceiver {
    @Nullable
    private zzas zzde;

    public zzat(zzas zzas) {
        this.zzde = zzas;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zzde != null && this.zzde.zzah()) {
            if (FirebaseInstanceId.zzi()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.zzde, 0);
            this.zzde.getContext().unregisterReceiver(this);
            this.zzde = null;
        }
    }

    public final void zzai() {
        if (FirebaseInstanceId.zzi()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zzde.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
