package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfx {
    private String value;
    private boolean zzaky;
    private final /* synthetic */ zzfs zzakz;
    private final String zzale = null;
    private final String zzny;

    public zzfx(zzfs zzfs, String str, String str2) {
        this.zzakz = zzfs;
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
    }

    @WorkerThread
    public final void zzbr(String str) {
        if (!zzkc.zzs(str, this.value)) {
            SharedPreferences.Editor edit = this.zzakz.zzjf().edit();
            edit.putString(this.zzny, str);
            edit.apply();
            this.value = str;
        }
    }

    @WorkerThread
    public final String zzjn() {
        if (!this.zzaky) {
            this.zzaky = true;
            this.value = this.zzakz.zzjf().getString(this.zzny, (String) null);
        }
        return this.value;
    }
}
