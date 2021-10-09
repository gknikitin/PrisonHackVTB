package com.google.android.gms.internal.measurement;

public class zzaaa {
    private static final zzzk zzbtg = zzzk.zztn();
    private zzyy zzbth;
    private volatile zzaan zzbti;
    private volatile zzyy zzbtj;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzaan zzb(com.google.android.gms.internal.measurement.zzaan r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzaan r0 = r1.zzbti
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzaan r0 = r1.zzbti     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzbti = r2     // Catch:{ zzzv -> 0x0012 }
            com.google.android.gms.internal.measurement.zzyy r0 = com.google.android.gms.internal.measurement.zzyy.zzbrh     // Catch:{ zzzv -> 0x0012 }
            r1.zzbtj = r0     // Catch:{ zzzv -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzbti = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.measurement.zzyy r2 = com.google.android.gms.internal.measurement.zzyy.zzbrh     // Catch:{ all -> 0x0019 }
            r1.zzbtj = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.measurement.zzaan r2 = r1.zzbti
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaaa.zzb(com.google.android.gms.internal.measurement.zzaan):com.google.android.gms.internal.measurement.zzaan");
    }

    private final zzyy zzty() {
        if (this.zzbtj != null) {
            return this.zzbtj;
        }
        synchronized (this) {
            if (this.zzbtj != null) {
                zzyy zzyy = this.zzbtj;
                return zzyy;
            }
            this.zzbtj = this.zzbti == null ? zzyy.zzbrh : this.zzbti.zzty();
            zzyy zzyy2 = this.zzbtj;
            return zzyy2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaaa)) {
            return false;
        }
        zzaaa zzaaa = (zzaaa) obj;
        zzaan zzaan = this.zzbti;
        zzaan zzaan2 = zzaaa.zzbti;
        return (zzaan == null && zzaan2 == null) ? zzty().equals(zzaaa.zzty()) : (zzaan == null || zzaan2 == null) ? zzaan != null ? zzaan.equals(zzaaa.zzb(zzaan.zzui())) : zzb(zzaan2.zzui()).equals(zzaan2) : zzaan.equals(zzaan2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzaan zzc(zzaan zzaan) {
        zzaan zzaan2 = this.zzbti;
        this.zzbth = null;
        this.zzbtj = null;
        this.zzbti = zzaan;
        return zzaan2;
    }
}
