package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzbv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class zzajj {
    private final Object mLock;
    private final zzajv zzacn;
    @GuardedBy("mLock")
    private boolean zzcif;
    @GuardedBy("mLock")
    private final LinkedList<zzajk> zzcot;
    private final String zzcou;
    private final String zzcov;
    @GuardedBy("mLock")
    private long zzcow;
    @GuardedBy("mLock")
    private long zzcox;
    @GuardedBy("mLock")
    private long zzcoy;
    @GuardedBy("mLock")
    private long zzcoz;
    @GuardedBy("mLock")
    private long zzcpa;
    @GuardedBy("mLock")
    private long zzcpb;

    private zzajj(zzajv zzajv, String str, String str2) {
        this.mLock = new Object();
        this.zzcow = -1;
        this.zzcox = -1;
        this.zzcif = false;
        this.zzcoy = -1;
        this.zzcoz = 0;
        this.zzcpa = -1;
        this.zzcpb = -1;
        this.zzacn = zzajv;
        this.zzcou = str;
        this.zzcov = str2;
        this.zzcot = new LinkedList<>();
    }

    public zzajj(String str, String str2) {
        this(zzbv.zzep(), str, str2);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzcou);
            bundle.putString("slotid", this.zzcov);
            bundle.putBoolean("ismediation", this.zzcif);
            bundle.putLong("treq", this.zzcpa);
            bundle.putLong("tresponse", this.zzcpb);
            bundle.putLong("timp", this.zzcox);
            bundle.putLong("tload", this.zzcoy);
            bundle.putLong("pcc", this.zzcoz);
            bundle.putLong("tfetch", this.zzcow);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzcot.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzajk) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzh(long j) {
        synchronized (this.mLock) {
            this.zzcpb = j;
            if (this.zzcpb != -1) {
                this.zzacn.zza(this);
            }
        }
    }

    public final void zzi(long j) {
        synchronized (this.mLock) {
            if (this.zzcpb != -1) {
                this.zzcow = j;
                this.zzacn.zza(this);
            }
        }
    }

    public final void zzn(zzjj zzjj) {
        synchronized (this.mLock) {
            this.zzcpa = SystemClock.elapsedRealtime();
            this.zzacn.zzb(zzjj, this.zzcpa);
        }
    }

    public final void zzpm() {
        synchronized (this.mLock) {
            if (this.zzcpb != -1 && this.zzcox == -1) {
                this.zzcox = SystemClock.elapsedRealtime();
                this.zzacn.zza(this);
            }
            this.zzacn.zzpm();
        }
    }

    public final void zzpn() {
        synchronized (this.mLock) {
            if (this.zzcpb != -1) {
                zzajk zzajk = new zzajk();
                zzajk.zzpr();
                this.zzcot.add(zzajk);
                this.zzcoz++;
                this.zzacn.zzpn();
                this.zzacn.zza(this);
            }
        }
    }

    public final void zzpo() {
        synchronized (this.mLock) {
            if (this.zzcpb != -1 && !this.zzcot.isEmpty()) {
                zzajk last = this.zzcot.getLast();
                if (last.zzpp() == -1) {
                    last.zzpq();
                    this.zzacn.zza(this);
                }
            }
        }
    }

    public final void zzy(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcpb != -1) {
                this.zzcoy = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzcox = this.zzcoy;
                    this.zzacn.zza(this);
                }
            }
        }
    }

    public final void zzz(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcpb != -1) {
                this.zzcif = z;
                this.zzacn.zza(this);
            }
        }
    }
}
