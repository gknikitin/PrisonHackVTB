package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

final class zzas implements Runnable {
    private final zzah zzao;
    private final zzau zzar;
    private final long zzdb;
    private final PowerManager.WakeLock zzdc = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzdd;

    @VisibleForTesting
    zzas(FirebaseInstanceId firebaseInstanceId, zzah zzah, zzau zzau, long j) {
        this.zzdd = firebaseInstanceId;
        this.zzao = zzah;
        this.zzar = zzau;
        this.zzdb = j;
        this.zzdc.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean zzag() {
        zzar zzg = this.zzdd.zzg();
        if (zzg != null && !zzg.zzj(this.zzao.zzx())) {
            return true;
        }
        try {
            String zzh = this.zzdd.zzh();
            if (zzh == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzg == null || (zzg != null && !zzh.equals(zzg.zzcz))) {
                Context context = getContext();
                Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                intent2.setClass(context, FirebaseInstanceIdReceiver.class);
                intent2.putExtra("wrapped_intent", intent);
                context.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException | SecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzdd.zze().getApplicationContext();
    }

    public final void run() {
        FirebaseInstanceId firebaseInstanceId;
        this.zzdc.acquire();
        try {
            boolean z = true;
            this.zzdd.zza(true);
            if (this.zzao.zzw() == 0) {
                z = false;
            }
            if (!z) {
                firebaseInstanceId = this.zzdd;
            } else {
                if (!zzah()) {
                    new zzat(this).zzai();
                } else if (!zzag() || !this.zzar.zza(this.zzdd)) {
                    this.zzdd.zza(this.zzdb);
                } else {
                    firebaseInstanceId = this.zzdd;
                }
            }
            firebaseInstanceId.zza(false);
        } finally {
            this.zzdc.release();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzah() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
