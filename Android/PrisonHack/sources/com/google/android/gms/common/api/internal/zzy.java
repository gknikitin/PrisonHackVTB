package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzy implements OnCompleteListener<Map<zzh<?>, String>> {
    private final /* synthetic */ zzw zzgu;

    private zzy(zzw zzw) {
        this.zzgu = zzw;
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        zzw zzw;
        ConnectionResult connectionResult;
        Map zzd;
        this.zzgu.zzga.lock();
        try {
            if (this.zzgu.zzgp) {
                if (task.isSuccessful()) {
                    Map unused = this.zzgu.zzgq = new ArrayMap(this.zzgu.zzgg.size());
                    for (zzv zzm : this.zzgu.zzgg.values()) {
                        this.zzgu.zzgq.put(zzm.zzm(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else {
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        if (this.zzgu.zzgn) {
                            Map unused2 = this.zzgu.zzgq = new ArrayMap(this.zzgu.zzgg.size());
                            for (zzv zzv : this.zzgu.zzgg.values()) {
                                zzh zzm2 = zzv.zzm();
                                ConnectionResult connectionResult2 = availabilityException.getConnectionResult(zzv);
                                if (this.zzgu.zza((zzv<?>) zzv, connectionResult2)) {
                                    zzd = this.zzgu.zzgq;
                                    connectionResult2 = new ConnectionResult(16);
                                } else {
                                    zzd = this.zzgu.zzgq;
                                }
                                zzd.put(zzm2, connectionResult2);
                            }
                        } else {
                            Map unused3 = this.zzgu.zzgq = availabilityException.zzl();
                        }
                        zzw = this.zzgu;
                        connectionResult = this.zzgu.zzai();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        Map unused4 = this.zzgu.zzgq = Collections.emptyMap();
                        zzw = this.zzgu;
                        connectionResult = new ConnectionResult(8);
                    }
                    ConnectionResult unused5 = zzw.zzgt = connectionResult;
                }
                if (this.zzgu.zzgr != null) {
                    this.zzgu.zzgq.putAll(this.zzgu.zzgr);
                    ConnectionResult unused6 = this.zzgu.zzgt = this.zzgu.zzai();
                }
                if (this.zzgu.zzgt == null) {
                    this.zzgu.zzag();
                    this.zzgu.zzah();
                } else {
                    boolean unused7 = this.zzgu.zzgp = false;
                    this.zzgu.zzgj.zzc(this.zzgu.zzgt);
                }
                this.zzgu.zzgl.signalAll();
            }
        } finally {
            this.zzgu.zzga.unlock();
        }
    }
}
