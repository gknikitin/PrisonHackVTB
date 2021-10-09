package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzzo<FieldDescriptorType extends zzzq<FieldDescriptorType>> {
    private static final zzzo zzbse = new zzzo(true);
    private boolean zzbme;
    private final zzaba<FieldDescriptorType, Object> zzbsc = zzaba.zzag(16);
    private boolean zzbsd = false;

    private zzzo() {
    }

    private zzzo(boolean z) {
        if (!this.zzbme) {
            this.zzbsc.zzrp();
            this.zzbme = true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzzw) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzzu) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzabr r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzzt.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzzp.zzbsf
            com.google.android.gms.internal.measurement.zzabw r2 = r2.zzve()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzaan
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzzw
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzzu
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzyy
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 != 0) goto L_0x004d
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzzo.zza(com.google.android.gms.internal.measurement.zzabr, java.lang.Object):void");
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zztt()) {
            zza(fielddescriptortype.zzts(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzts(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzzw) {
            this.zzbsd = true;
        }
        this.zzbsc.put(fielddescriptortype, obj);
    }

    public static <T extends zzzq<T>> zzzo<T> zztr() {
        return zzbse;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzo zzzo = new zzzo();
        for (int i = 0; i < this.zzbsc.zzus(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzah = this.zzbsc.zzah(i);
            zzzo.zza((zzzq) zzah.getKey(), zzah.getValue());
        }
        for (Map.Entry next : this.zzbsc.zzut()) {
            zzzo.zza((zzzq) next.getKey(), next.getValue());
        }
        zzzo.zzbsd = this.zzbsd;
        return zzzo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzo)) {
            return false;
        }
        return this.zzbsc.equals(((zzzo) obj).zzbsc);
    }

    public final int hashCode() {
        return this.zzbsc.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzbsd ? new zzzz(this.zzbsc.entrySet().iterator()) : this.zzbsc.entrySet().iterator();
    }
}
