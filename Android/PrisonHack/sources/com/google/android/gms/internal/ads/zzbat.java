package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

final class zzbat implements zzbdl {
    private int tag;
    private final zzbaq zzdqi;
    private int zzdqj;
    private int zzdqk = 0;

    private zzbat(zzbaq zzbaq) {
        this.zzdqi = (zzbaq) zzbbq.zza(zzbaq, "input");
        this.zzdqi.zzdqa = this;
    }

    public static zzbat zza(zzbaq zzbaq) {
        return zzbaq.zzdqa != null ? zzbaq.zzdqa : new zzbat(zzbaq);
    }

    private final Object zza(zzbes zzbes, Class<?> cls, zzbbb zzbbb) throws IOException {
        switch (zzbau.zzdql[zzbes.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzabq());
            case 2:
                return zzabs();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzabu());
            case 5:
                return Integer.valueOf(zzabp());
            case 6:
                return Long.valueOf(zzabo());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzabn());
            case 9:
                return Long.valueOf(zzabm());
            case 10:
                zzbv(2);
                return zzc(zzbdg.zzaeo().zze(cls), zzbbb);
            case 11:
                return Integer.valueOf(zzabv());
            case 12:
                return Long.valueOf(zzabw());
            case 13:
                return Integer.valueOf(zzabx());
            case 14:
                return Long.valueOf(zzaby());
            case 15:
                return zzabr();
            case 16:
                return Integer.valueOf(zzabt());
            case 17:
                return Long.valueOf(zzabl());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzabk;
        int zzabk2;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        } else if (!(list instanceof zzbcd) || z) {
            do {
                list.add(z ? zzabr() : readString());
                if (!this.zzdqi.zzaca()) {
                    zzabk = this.zzdqi.zzabk();
                } else {
                    return;
                }
            } while (zzabk == this.tag);
            this.zzdqk = zzabk;
        } else {
            zzbcd zzbcd = (zzbcd) list;
            do {
                zzbcd.zzap(zzabs());
                if (!this.zzdqi.zzaca()) {
                    zzabk2 = this.zzdqi.zzabk();
                } else {
                    return;
                }
            } while (zzabk2 == this.tag);
            this.zzdqk = zzabk2;
        }
    }

    private final void zzbv(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzbbu.zzadq();
        }
    }

    private static void zzbw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzbbu.zzadr();
        }
    }

    private static void zzbx(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzbbu.zzadr();
        }
    }

    private final void zzby(int i) throws IOException {
        if (this.zzdqi.zzacb() != i) {
            throw zzbbu.zzadl();
        }
    }

    private final <T> T zzc(zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        int zzabt = this.zzdqi.zzabt();
        if (this.zzdqi.zzdpx >= this.zzdqi.zzdpy) {
            throw new zzbbu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzbr = this.zzdqi.zzbr(zzabt);
        T newInstance = zzbdm.newInstance();
        this.zzdqi.zzdpx++;
        zzbdm.zza(newInstance, this, zzbbb);
        zzbdm.zzo(newInstance);
        this.zzdqi.zzbp(0);
        zzbaq zzbaq = this.zzdqi;
        zzbaq.zzdpx--;
        this.zzdqi.zzbs(zzbr);
        return newInstance;
    }

    private final <T> T zzd(zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        int i = this.zzdqj;
        this.zzdqj = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzbdm.newInstance();
            zzbdm.zza(newInstance, this, zzbbb);
            zzbdm.zzo(newInstance);
            if (this.tag == this.zzdqj) {
                return newInstance;
            }
            throw zzbbu.zzadr();
        } finally {
            this.zzdqj = i;
        }
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() throws IOException {
        zzbv(1);
        return this.zzdqi.readDouble();
    }

    public final float readFloat() throws IOException {
        zzbv(5);
        return this.zzdqi.readFloat();
    }

    public final String readString() throws IOException {
        zzbv(2);
        return this.zzdqi.readString();
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final <T> T zza(zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        zzbv(2);
        return zzc(zzbdm, zzbbb);
    }

    public final <T> void zza(List<T> list, zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        int zzabk;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        }
        int i = this.tag;
        do {
            list.add(zzc(zzbdm, zzbbb));
            if (!this.zzdqi.zzaca() && this.zzdqk == 0) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == i);
        this.zzdqk = zzabk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (zzacj() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        throw new com.google.android.gms.internal.ads.zzbbu("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.ads.zzbcn<K, V> r7, com.google.android.gms.internal.ads.zzbbb r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            r5.zzbv(r0)
            com.google.android.gms.internal.ads.zzbaq r0 = r5.zzdqi
            int r0 = r0.zzabt()
            com.google.android.gms.internal.ads.zzbaq r1 = r5.zzdqi
            int r0 = r1.zzbr(r0)
            K r1 = r7.zzdvz
            V r2 = r7.zzdwb
        L_0x0014:
            int r3 = r5.zzaci()     // Catch:{ all -> 0x0065 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005c
            com.google.android.gms.internal.ads.zzbaq r4 = r5.zzdqi     // Catch:{ all -> 0x0065 }
            boolean r4 = r4.zzaca()     // Catch:{ all -> 0x0065 }
            if (r4 != 0) goto L_0x005c
            switch(r3) {
                case 1: goto L_0x003b;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzacj()     // Catch:{ zzbbv -> 0x004e }
            goto L_0x0044
        L_0x002d:
            com.google.android.gms.internal.ads.zzbes r3 = r7.zzdwa     // Catch:{ zzbbv -> 0x004e }
            V r4 = r7.zzdwb     // Catch:{ zzbbv -> 0x004e }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzbbv -> 0x004e }
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.ads.zzbes) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzbbb) r8)     // Catch:{ zzbbv -> 0x004e }
            r2 = r3
            goto L_0x0014
        L_0x003b:
            com.google.android.gms.internal.ads.zzbes r3 = r7.zzdvy     // Catch:{ zzbbv -> 0x004e }
            r4 = 0
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.ads.zzbes) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzbbb) r4)     // Catch:{ zzbbv -> 0x004e }
            r1 = r3
            goto L_0x0014
        L_0x0044:
            if (r3 != 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzbbu r3 = new com.google.android.gms.internal.ads.zzbbu     // Catch:{ zzbbv -> 0x004e }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzbbv -> 0x004e }
            throw r3     // Catch:{ zzbbv -> 0x004e }
        L_0x004e:
            boolean r3 = r5.zzacj()     // Catch:{ all -> 0x0065 }
            if (r3 != 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzbbu r6 = new com.google.android.gms.internal.ads.zzbbu     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r6.put(r1, r2)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.ads.zzbaq r6 = r5.zzdqi
            r6.zzbs(r0)
            return
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbaq r7 = r5.zzdqi
            r7.zzbs(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbat.zza(java.util.Map, com.google.android.gms.internal.ads.zzbcn, com.google.android.gms.internal.ads.zzbbb):void");
    }

    public final void zzaa(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbbp.zzco(this.zzdqi.zzabu());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbbp.zzco(this.zzdqi.zzabu());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabu()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabu()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzab(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzabt = this.zzdqi.zzabt();
                zzbx(zzabt);
                int zzacb = this.zzdqi.zzacb() + zzabt;
                do {
                    zzbbp.zzco(this.zzdqi.zzabv());
                } while (this.zzdqi.zzacb() < zzacb);
            } else if (i != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    zzbbp.zzco(this.zzdqi.zzabv());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzabt2 = this.zzdqi.zzabt();
                zzbx(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabv()));
                } while (this.zzdqi.zzacb() < zzacb2);
            } else if (i2 != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabv()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            }
        }
    }

    public final long zzabl() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabl();
    }

    public final long zzabm() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabm();
    }

    public final int zzabn() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabn();
    }

    public final long zzabo() throws IOException {
        zzbv(1);
        return this.zzdqi.zzabo();
    }

    public final int zzabp() throws IOException {
        zzbv(5);
        return this.zzdqi.zzabp();
    }

    public final boolean zzabq() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabq();
    }

    public final String zzabr() throws IOException {
        zzbv(2);
        return this.zzdqi.zzabr();
    }

    public final zzbah zzabs() throws IOException {
        zzbv(2);
        return this.zzdqi.zzabs();
    }

    public final int zzabt() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabt();
    }

    public final int zzabu() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabu();
    }

    public final int zzabv() throws IOException {
        zzbv(5);
        return this.zzdqi.zzabv();
    }

    public final long zzabw() throws IOException {
        zzbv(1);
        return this.zzdqi.zzabw();
    }

    public final int zzabx() throws IOException {
        zzbv(0);
        return this.zzdqi.zzabx();
    }

    public final long zzaby() throws IOException {
        zzbv(0);
        return this.zzdqi.zzaby();
    }

    public final void zzac(List<Long> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbci) {
            zzbci zzbci = (zzbci) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzabt = this.zzdqi.zzabt();
                    zzbw(zzabt);
                    int zzacb = this.zzdqi.zzacb() + zzabt;
                    do {
                        zzbci.zzw(this.zzdqi.zzabw());
                    } while (this.zzdqi.zzacb() < zzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                zzbci.zzw(this.zzdqi.zzabw());
                if (!this.zzdqi.zzaca()) {
                    zzabk2 = this.zzdqi.zzabk();
                } else {
                    return;
                }
            } while (zzabk2 == this.tag);
            this.zzdqk = zzabk2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzabt2 = this.zzdqi.zzabt();
                zzbw(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabw()));
                } while (this.zzdqi.zzacb() < zzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            list.add(Long.valueOf(this.zzdqi.zzabw()));
            if (!this.zzdqi.zzaca()) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == this.tag);
        this.zzdqk = zzabk;
    }

    public final int zzaci() throws IOException {
        if (this.zzdqk != 0) {
            this.tag = this.zzdqk;
            this.zzdqk = 0;
        } else {
            this.tag = this.zzdqi.zzabk();
        }
        if (this.tag == 0 || this.tag == this.zzdqj) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    public final boolean zzacj() throws IOException {
        if (this.zzdqi.zzaca() || this.tag == this.zzdqj) {
            return false;
        }
        return this.zzdqi.zzbq(this.tag);
    }

    public final void zzad(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbbp.zzco(this.zzdqi.zzabx());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbbp.zzco(this.zzdqi.zzabx());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabx()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabx()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzae(List<Long> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbci) {
            zzbci zzbci = (zzbci) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbci.zzw(this.zzdqi.zzaby());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbci.zzw(this.zzdqi.zzaby());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzdqi.zzaby()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Long.valueOf(this.zzdqi.zzaby()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final <T> T zzb(zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        zzbv(3);
        return zzd(zzbdm, zzbbb);
    }

    public final <T> void zzb(List<T> list, zzbdm<T> zzbdm, zzbbb zzbbb) throws IOException {
        int zzabk;
        if ((this.tag & 7) != 3) {
            throw zzbbu.zzadq();
        }
        int i = this.tag;
        do {
            list.add(zzd(zzbdm, zzbbb));
            if (!this.zzdqi.zzaca() && this.zzdqk == 0) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == i);
        this.zzdqk = zzabk;
    }

    public final void zzp(List<Double> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbay) {
            zzbay zzbay = (zzbay) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzabt = this.zzdqi.zzabt();
                    zzbw(zzabt);
                    int zzacb = this.zzdqi.zzacb() + zzabt;
                    do {
                        zzbay.zzd(this.zzdqi.readDouble());
                    } while (this.zzdqi.zzacb() < zzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                zzbay.zzd(this.zzdqi.readDouble());
                if (!this.zzdqi.zzaca()) {
                    zzabk2 = this.zzdqi.zzabk();
                } else {
                    return;
                }
            } while (zzabk2 == this.tag);
            this.zzdqk = zzabk2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzabt2 = this.zzdqi.zzabt();
                zzbw(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Double.valueOf(this.zzdqi.readDouble()));
                } while (this.zzdqi.zzacb() < zzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            list.add(Double.valueOf(this.zzdqi.readDouble()));
            if (!this.zzdqi.zzaca()) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == this.tag);
        this.zzdqk = zzabk;
    }

    public final void zzq(List<Float> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbm) {
            zzbbm zzbbm = (zzbbm) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzabt = this.zzdqi.zzabt();
                zzbx(zzabt);
                int zzacb = this.zzdqi.zzacb() + zzabt;
                do {
                    zzbbm.zzd(this.zzdqi.readFloat());
                } while (this.zzdqi.zzacb() < zzacb);
            } else if (i != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    zzbbm.zzd(this.zzdqi.readFloat());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzabt2 = this.zzdqi.zzabt();
                zzbx(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Float.valueOf(this.zzdqi.readFloat()));
                } while (this.zzdqi.zzacb() < zzacb2);
            } else if (i2 != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    list.add(Float.valueOf(this.zzdqi.readFloat()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            }
        }
    }

    public final void zzr(List<Long> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbci) {
            zzbci zzbci = (zzbci) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbci.zzw(this.zzdqi.zzabl());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbci.zzw(this.zzdqi.zzabl());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabl()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabl()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzs(List<Long> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbci) {
            zzbci zzbci = (zzbci) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbci.zzw(this.zzdqi.zzabm());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbci.zzw(this.zzdqi.zzabm());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabm()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabm()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzt(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbbp.zzco(this.zzdqi.zzabn());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbbp.zzco(this.zzdqi.zzabn());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabn()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabn()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzu(List<Long> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbci) {
            zzbci zzbci = (zzbci) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzabt = this.zzdqi.zzabt();
                    zzbw(zzabt);
                    int zzacb = this.zzdqi.zzacb() + zzabt;
                    do {
                        zzbci.zzw(this.zzdqi.zzabo());
                    } while (this.zzdqi.zzacb() < zzacb);
                    return;
                default:
                    throw zzbbu.zzadq();
            }
            do {
                zzbci.zzw(this.zzdqi.zzabo());
                if (!this.zzdqi.zzaca()) {
                    zzabk2 = this.zzdqi.zzabk();
                } else {
                    return;
                }
            } while (zzabk2 == this.tag);
            this.zzdqk = zzabk2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzabt2 = this.zzdqi.zzabt();
                zzbw(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Long.valueOf(this.zzdqi.zzabo()));
                } while (this.zzdqi.zzacb() < zzacb2);
                return;
            default:
                throw zzbbu.zzadq();
        }
        do {
            list.add(Long.valueOf(this.zzdqi.zzabo()));
            if (!this.zzdqi.zzaca()) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == this.tag);
        this.zzdqk = zzabk;
    }

    public final void zzv(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzabt = this.zzdqi.zzabt();
                zzbx(zzabt);
                int zzacb = this.zzdqi.zzacb() + zzabt;
                do {
                    zzbbp.zzco(this.zzdqi.zzabp());
                } while (this.zzdqi.zzacb() < zzacb);
            } else if (i != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    zzbbp.zzco(this.zzdqi.zzabp());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzabt2 = this.zzdqi.zzabt();
                zzbx(zzabt2);
                int zzacb2 = this.zzdqi.zzacb() + zzabt2;
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabp()));
                } while (this.zzdqi.zzacb() < zzacb2);
            } else if (i2 != 5) {
                throw zzbbu.zzadq();
            } else {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabp()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            }
        }
    }

    public final void zzw(List<Boolean> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbaf) {
            zzbaf zzbaf = (zzbaf) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbaf.addBoolean(this.zzdqi.zzabq());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbaf.addBoolean(this.zzdqi.zzabq());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzdqi.zzabq()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Boolean.valueOf(this.zzdqi.zzabq()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }

    public final void zzx(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzy(List<zzbah> list) throws IOException {
        int zzabk;
        if ((this.tag & 7) != 2) {
            throw zzbbu.zzadq();
        }
        do {
            list.add(zzabs());
            if (!this.zzdqi.zzaca()) {
                zzabk = this.zzdqi.zzabk();
            } else {
                return;
            }
        } while (zzabk == this.tag);
        this.zzdqk = zzabk;
    }

    public final void zzz(List<Integer> list) throws IOException {
        int zzabk;
        int zzabk2;
        if (list instanceof zzbbp) {
            zzbbp zzbbp = (zzbbp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbbp.zzco(this.zzdqi.zzabt());
                    if (!this.zzdqi.zzaca()) {
                        zzabk2 = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk2 == this.tag);
                this.zzdqk = zzabk2;
            } else if (i != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    zzbbp.zzco(this.zzdqi.zzabt());
                } while (this.zzdqi.zzacb() < zzacb);
                zzby(zzacb);
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabt()));
                    if (!this.zzdqi.zzaca()) {
                        zzabk = this.zzdqi.zzabk();
                    } else {
                        return;
                    }
                } while (zzabk == this.tag);
                this.zzdqk = zzabk;
            } else if (i2 != 2) {
                throw zzbbu.zzadq();
            } else {
                int zzacb2 = this.zzdqi.zzacb() + this.zzdqi.zzabt();
                do {
                    list.add(Integer.valueOf(this.zzdqi.zzabt()));
                } while (this.zzdqi.zzacb() < zzacb2);
                zzby(zzacb2);
            }
        }
    }
}
