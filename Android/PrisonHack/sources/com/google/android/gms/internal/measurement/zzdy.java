package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

final class zzdy {
    private final zzgm zzacw;
    private String zzadl;
    private String zzadm;
    private String zzadn;
    private String zzado;
    private long zzadp;
    private long zzadq;
    private long zzadr;
    private long zzads;
    private String zzadt;
    private long zzadu;
    private long zzadv;
    private boolean zzadw;
    private long zzadx;
    private boolean zzady;
    private boolean zzadz;
    private long zzaea;
    private long zzaeb;
    private long zzaec;
    private long zzaed;
    private long zzaee;
    private long zzaef;
    private String zzaeg;
    private boolean zzaeh;
    private long zzaei;
    private long zzaej;
    private String zzth;
    private final String zzti;

    @WorkerThread
    zzdy(zzgm zzgm, String str) {
        Preconditions.checkNotNull(zzgm);
        Preconditions.checkNotEmpty(str);
        this.zzacw = zzgm;
        this.zzti = str;
        this.zzacw.zzge().zzab();
    }

    @WorkerThread
    public final String getAppInstanceId() {
        this.zzacw.zzge().zzab();
        return this.zzadl;
    }

    @WorkerThread
    public final String getGmpAppId() {
        this.zzacw.zzge().zzab();
        return this.zzadm;
    }

    @WorkerThread
    public final boolean isMeasurementEnabled() {
        this.zzacw.zzge().zzab();
        return this.zzadw;
    }

    @WorkerThread
    public final void setAppVersion(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzth, str);
        this.zzth = str;
    }

    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadw != z;
        this.zzadw = z;
    }

    @WorkerThread
    public final void zzaa(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadx != j;
        this.zzadx = j;
    }

    @WorkerThread
    public final String zzag() {
        this.zzacw.zzge().zzab();
        return this.zzth;
    }

    @WorkerThread
    public final String zzah() {
        this.zzacw.zzge().zzab();
        return this.zzti;
    }

    @WorkerThread
    public final void zzak(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzadl, str);
        this.zzadl = str;
    }

    @WorkerThread
    public final void zzal(String str) {
        this.zzacw.zzge().zzab();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaeh |= !zzkc.zzs(this.zzadm, str);
        this.zzadm = str;
    }

    @WorkerThread
    public final void zzam(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzadn, str);
        this.zzadn = str;
    }

    @WorkerThread
    public final void zzan(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzado, str);
        this.zzado = str;
    }

    @WorkerThread
    public final void zzao(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzadt, str);
        this.zzadt = str;
    }

    @WorkerThread
    public final void zzap(String str) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= !zzkc.zzs(this.zzaeg, str);
        this.zzaeg = str;
    }

    @WorkerThread
    public final void zzd(boolean z) {
        this.zzacw.zzge().zzab();
        this.zzaeh = this.zzady != z;
        this.zzady = z;
    }

    @WorkerThread
    public final void zze(boolean z) {
        this.zzacw.zzge().zzab();
        this.zzaeh = this.zzadz != z;
        this.zzadz = z;
    }

    @WorkerThread
    public final void zzgj() {
        this.zzacw.zzge().zzab();
        this.zzaeh = false;
    }

    @WorkerThread
    public final String zzgk() {
        this.zzacw.zzge().zzab();
        return this.zzadn;
    }

    @WorkerThread
    public final String zzgl() {
        this.zzacw.zzge().zzab();
        return this.zzado;
    }

    @WorkerThread
    public final long zzgm() {
        this.zzacw.zzge().zzab();
        return this.zzadq;
    }

    @WorkerThread
    public final long zzgn() {
        this.zzacw.zzge().zzab();
        return this.zzadr;
    }

    @WorkerThread
    public final long zzgo() {
        this.zzacw.zzge().zzab();
        return this.zzads;
    }

    @WorkerThread
    public final String zzgp() {
        this.zzacw.zzge().zzab();
        return this.zzadt;
    }

    @WorkerThread
    public final long zzgq() {
        this.zzacw.zzge().zzab();
        return this.zzadu;
    }

    @WorkerThread
    public final long zzgr() {
        this.zzacw.zzge().zzab();
        return this.zzadv;
    }

    @WorkerThread
    public final long zzgs() {
        this.zzacw.zzge().zzab();
        return this.zzadp;
    }

    @WorkerThread
    public final long zzgt() {
        this.zzacw.zzge().zzab();
        return this.zzaei;
    }

    @WorkerThread
    public final long zzgu() {
        this.zzacw.zzge().zzab();
        return this.zzaej;
    }

    @WorkerThread
    public final void zzgv() {
        this.zzacw.zzge().zzab();
        long j = this.zzadp + 1;
        if (j > 2147483647L) {
            this.zzacw.zzgf().zziv().zzg("Bundle index overflow. appId", zzfh.zzbl(this.zzti));
            j = 0;
        }
        this.zzaeh = true;
        this.zzadp = j;
    }

    @WorkerThread
    public final long zzgw() {
        this.zzacw.zzge().zzab();
        return this.zzaea;
    }

    @WorkerThread
    public final long zzgx() {
        this.zzacw.zzge().zzab();
        return this.zzaeb;
    }

    @WorkerThread
    public final long zzgy() {
        this.zzacw.zzge().zzab();
        return this.zzaec;
    }

    @WorkerThread
    public final long zzgz() {
        this.zzacw.zzge().zzab();
        return this.zzaed;
    }

    @WorkerThread
    public final long zzha() {
        this.zzacw.zzge().zzab();
        return this.zzaef;
    }

    @WorkerThread
    public final long zzhb() {
        this.zzacw.zzge().zzab();
        return this.zzaee;
    }

    @WorkerThread
    public final String zzhc() {
        this.zzacw.zzge().zzab();
        return this.zzaeg;
    }

    @WorkerThread
    public final String zzhd() {
        this.zzacw.zzge().zzab();
        String str = this.zzaeg;
        zzap((String) null);
        return str;
    }

    @WorkerThread
    public final long zzhe() {
        this.zzacw.zzge().zzab();
        return this.zzadx;
    }

    @WorkerThread
    public final boolean zzhf() {
        this.zzacw.zzge().zzab();
        return this.zzady;
    }

    @WorkerThread
    public final boolean zzhg() {
        this.zzacw.zzge().zzab();
        return this.zzadz;
    }

    @WorkerThread
    public final void zzm(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadq != j;
        this.zzadq = j;
    }

    @WorkerThread
    public final void zzn(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadr != j;
        this.zzadr = j;
    }

    @WorkerThread
    public final void zzo(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzads != j;
        this.zzads = j;
    }

    @WorkerThread
    public final void zzp(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadu != j;
        this.zzadu = j;
    }

    @WorkerThread
    public final void zzq(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzadv != j;
        this.zzadv = j;
    }

    @WorkerThread
    public final void zzr(long j) {
        boolean z = false;
        Preconditions.checkArgument(j >= 0);
        this.zzacw.zzge().zzab();
        boolean z2 = this.zzaeh;
        if (this.zzadp != j) {
            z = true;
        }
        this.zzaeh = z | z2;
        this.zzadp = j;
    }

    @WorkerThread
    public final void zzs(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaei != j;
        this.zzaei = j;
    }

    @WorkerThread
    public final void zzt(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaej != j;
        this.zzaej = j;
    }

    @WorkerThread
    public final void zzu(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaea != j;
        this.zzaea = j;
    }

    @WorkerThread
    public final void zzv(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaeb != j;
        this.zzaeb = j;
    }

    @WorkerThread
    public final void zzw(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaec != j;
        this.zzaec = j;
    }

    @WorkerThread
    public final void zzx(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaed != j;
        this.zzaed = j;
    }

    @WorkerThread
    public final void zzy(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaef != j;
        this.zzaef = j;
    }

    @WorkerThread
    public final void zzz(long j) {
        this.zzacw.zzge().zzab();
        this.zzaeh |= this.zzaee != j;
        this.zzaee = j;
    }
}
