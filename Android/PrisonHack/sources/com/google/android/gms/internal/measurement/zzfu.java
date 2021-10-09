package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfu {
    private boolean value;
    private final boolean zzakx = true;
    private boolean zzaky;
    private final /* synthetic */ zzfs zzakz;
    private final String zzny;

    public zzfu(zzfs zzfs, String str, boolean z) {
        this.zzakz = zzfs;
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
    }

    @WorkerThread
    public final boolean get() {
        if (!this.zzaky) {
            this.zzaky = true;
            this.value = this.zzakz.zzjf().getBoolean(this.zzny, this.zzakx);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(boolean z) {
        SharedPreferences.Editor edit = this.zzakz.zzjf().edit();
        edit.putBoolean(this.zzny, z);
        edit.apply();
        this.value = z;
    }
}
