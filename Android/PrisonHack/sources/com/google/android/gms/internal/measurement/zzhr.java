package com.google.android.gms.internal.measurement;

final class zzhr implements Runnable {
    private final /* synthetic */ zzhl zzaog;
    private final /* synthetic */ long zzaok;

    zzhr(zzhl zzhl, long j) {
        this.zzaog = zzhl;
        this.zzaok = j;
    }

    public final void run() {
        zzhl zzhl = this.zzaog;
        long j = this.zzaok;
        zzhl.zzab();
        zzhl.zzfs();
        zzhl.zzch();
        zzhl.zzgf().zziy().log("Resetting analytics data (FE)");
        zzhl.zzgd().zzks();
        if (zzhl.zzgh().zzaz(zzhl.zzfw().zzah())) {
            zzhl.zzgg().zzaki.set(j);
        }
        boolean isEnabled = zzhl.zzacw.isEnabled();
        if (!zzhl.zzgh().zzhj()) {
            zzhl.zzgg().zzh(!isEnabled);
        }
        zzhl.zzfy().resetAnalyticsData();
        zzhl.zzaoe = !isEnabled;
    }
}
