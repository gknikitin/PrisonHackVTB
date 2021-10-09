package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzbda<T> implements zzbdm<T> {
    private final zzbcu zzdwl;
    private final boolean zzdwm;
    private final zzbee<?, ?> zzdwv;
    private final zzbbd<?> zzdww;

    private zzbda(zzbee<?, ?> zzbee, zzbbd<?> zzbbd, zzbcu zzbcu) {
        this.zzdwv = zzbee;
        this.zzdwm = zzbbd.zzh(zzbcu);
        this.zzdww = zzbbd;
        this.zzdwl = zzbcu;
    }

    static <T> zzbda<T> zza(zzbee<?, ?> zzbee, zzbbd<?> zzbbd, zzbcu zzbcu) {
        return new zzbda<>(zzbee, zzbbd, zzbcu);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzdwv.zzac(t).equals(this.zzdwv.zzac(t2))) {
            return false;
        }
        if (this.zzdwm) {
            return this.zzdww.zzm(t).equals(this.zzdww.zzm(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzdwv.zzac(t).hashCode();
        return this.zzdwm ? (hashCode * 53) + this.zzdww.zzm(t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzdwl.zzadf().zzadj();
    }

    public final void zza(T t, zzbdl zzbdl, zzbbb zzbbb) throws IOException {
        boolean z;
        zzbee<?, ?> zzbee = this.zzdwv;
        zzbbd<?> zzbbd = this.zzdww;
        Object zzad = zzbee.zzad(t);
        zzbbg<?> zzn = zzbbd.zzn(t);
        do {
            try {
                if (zzbdl.zzaci() == Integer.MAX_VALUE) {
                    zzbee.zzf(t, zzad);
                    return;
                }
                int tag = zzbdl.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzbah zzbah = null;
                    int i = 0;
                    while (zzbdl.zzaci() != Integer.MAX_VALUE) {
                        int tag2 = zzbdl.getTag();
                        if (tag2 == 16) {
                            i = zzbdl.zzabt();
                            obj = zzbbd.zza(zzbbb, this.zzdwl, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzbbd.zza(zzbdl, obj, zzbbb, zzn);
                            } else {
                                zzbah = zzbdl.zzabs();
                            }
                        } else if (!zzbdl.zzacj()) {
                            break;
                        }
                    }
                    if (zzbdl.getTag() != 12) {
                        throw zzbbu.zzadp();
                    } else if (zzbah != null) {
                        if (obj != null) {
                            zzbbd.zza(zzbah, obj, zzbbb, zzn);
                        } else {
                            zzbee.zza(zzad, i, zzbah);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzbbd.zza(zzbbb, this.zzdwl, tag >>> 3);
                    if (zza != null) {
                        zzbbd.zza(zzbdl, zza, zzbbb, zzn);
                    } else {
                        z = zzbee.zza(zzad, zzbdl);
                        continue;
                    }
                } else {
                    z = zzbdl.zzacj();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzbee.zzf(t, zzad);
            }
        } while (z);
    }

    public final void zza(T t, zzbey zzbey) throws IOException {
        int zzhq;
        Object value;
        Iterator<Map.Entry<?, Object>> it = this.zzdww.zzm(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzbbi zzbbi = (zzbbi) next.getKey();
            if (zzbbi.zzacz() != zzbex.MESSAGE || zzbbi.zzada() || zzbbi.zzadb()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzbbz) {
                zzhq = zzbbi.zzhq();
                value = ((zzbbz) next).zzadv().zzaav();
            } else {
                zzhq = zzbbi.zzhq();
                value = next.getValue();
            }
            zzbey.zza(zzhq, value);
        }
        zzbee<?, ?> zzbee = this.zzdwv;
        zzbee.zzc(zzbee.zzac(t), zzbey);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzbae r11) throws java.io.IOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbbo r7 = (com.google.android.gms.internal.ads.zzbbo) r7
            com.google.android.gms.internal.ads.zzbef r0 = r7.zzdtt
            com.google.android.gms.internal.ads.zzbef r1 = com.google.android.gms.internal.ads.zzbef.zzagc()
            if (r0 != r1) goto L_0x0010
            com.google.android.gms.internal.ads.zzbef r0 = com.google.android.gms.internal.ads.zzbef.zzagd()
            r7.zzdtt = r0
        L_0x0010:
            r7 = r0
        L_0x0011:
            if (r9 >= r10) goto L_0x0069
            int r2 = com.google.android.gms.internal.ads.zzbad.zza(r8, r9, r11)
            int r0 = r11.zzdpl
            r9 = 11
            r1 = 2
            if (r0 == r9) goto L_0x0030
            r9 = r0 & 7
            if (r9 != r1) goto L_0x002b
            r1 = r8
            r3 = r10
            r4 = r7
            r5 = r11
            int r9 = com.google.android.gms.internal.ads.zzbad.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzbef) r4, (com.google.android.gms.internal.ads.zzbae) r5)
            goto L_0x0011
        L_0x002b:
            int r9 = com.google.android.gms.internal.ads.zzbad.zza(r0, r8, r2, r10, r11)
            goto L_0x0011
        L_0x0030:
            r9 = 0
            r0 = 0
        L_0x0032:
            if (r2 >= r10) goto L_0x005f
            int r2 = com.google.android.gms.internal.ads.zzbad.zza(r8, r2, r11)
            int r3 = r11.zzdpl
            int r4 = r3 >>> 3
            r5 = r3 & 7
            switch(r4) {
                case 2: goto L_0x004d;
                case 3: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0056
        L_0x0042:
            if (r5 != r1) goto L_0x0056
            int r2 = com.google.android.gms.internal.ads.zzbad.zze(r8, r2, r11)
            java.lang.Object r0 = r11.zzdpn
            com.google.android.gms.internal.ads.zzbah r0 = (com.google.android.gms.internal.ads.zzbah) r0
            goto L_0x0032
        L_0x004d:
            if (r5 != 0) goto L_0x0056
            int r2 = com.google.android.gms.internal.ads.zzbad.zza(r8, r2, r11)
            int r9 = r11.zzdpl
            goto L_0x0032
        L_0x0056:
            r4 = 12
            if (r3 == r4) goto L_0x005f
            int r2 = com.google.android.gms.internal.ads.zzbad.zza(r3, r8, r2, r10, r11)
            goto L_0x0032
        L_0x005f:
            if (r0 == 0) goto L_0x0067
            int r9 = r9 << 3
            r9 = r9 | r1
            r7.zzb(r9, r0)
        L_0x0067:
            r9 = r2
            goto L_0x0011
        L_0x0069:
            if (r9 == r10) goto L_0x0070
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.internal.ads.zzbbu.zzadr()
            throw r7
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbda.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzbae):void");
    }

    public final boolean zzaa(T t) {
        return this.zzdww.zzm(t).isInitialized();
    }

    public final void zzc(T t, T t2) {
        zzbdo.zza(this.zzdwv, t, t2);
        if (this.zzdwm) {
            zzbdo.zza(this.zzdww, t, t2);
        }
    }

    public final void zzo(T t) {
        this.zzdwv.zzo(t);
        this.zzdww.zzo(t);
    }

    public final int zzy(T t) {
        zzbee<?, ?> zzbee = this.zzdwv;
        int zzae = zzbee.zzae(zzbee.zzac(t)) + 0;
        return this.zzdwm ? zzae + this.zzdww.zzm(t).zzacx() : zzae;
    }
}
