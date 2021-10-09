package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzbbg<FieldDescriptorType extends zzbbi<FieldDescriptorType>> {
    private static final zzbbg zzdra = new zzbbg(true);
    private final zzbdp<FieldDescriptorType, Object> zzdqx = zzbdp.zzcx(16);
    private boolean zzdqy;
    private boolean zzdqz = false;

    private zzbbg() {
    }

    private zzbbg(boolean z) {
        zzaaz();
    }

    static int zza(zzbes zzbes, int i, Object obj) {
        int zzcd = zzbav.zzcd(i);
        if (zzbes == zzbes.GROUP) {
            zzbbq.zzi((zzbcu) obj);
            zzcd <<= 1;
        }
        return zzcd + zzb(zzbes, obj);
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzdqx.get(fielddescriptortype);
        return obj instanceof zzbbx ? zzbbx.zzadu() : obj;
    }

    static void zza(zzbav zzbav, zzbes zzbes, int i, Object obj) throws IOException {
        if (zzbes == zzbes.GROUP) {
            zzbcu zzbcu = (zzbcu) obj;
            zzbbq.zzi(zzbcu);
            zzbav.zzl(i, 3);
            zzbcu.zzb(zzbav);
            zzbav.zzl(i, 4);
            return;
        }
        zzbav.zzl(i, zzbes.zzagm());
        switch (zzbbh.zzdql[zzbes.ordinal()]) {
            case 1:
                zzbav.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzbav.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzbav.zzm(((Long) obj).longValue());
                return;
            case 4:
                zzbav.zzm(((Long) obj).longValue());
                return;
            case 5:
                zzbav.zzbz(((Integer) obj).intValue());
                return;
            case 6:
                zzbav.zzo(((Long) obj).longValue());
                return;
            case 7:
                zzbav.zzcc(((Integer) obj).intValue());
                return;
            case 8:
                zzbav.zzap(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzbcu) obj).zzb(zzbav);
                return;
            case 10:
                zzbav.zze((zzbcu) obj);
                return;
            case 11:
                if (obj instanceof zzbah) {
                    zzbav.zzan((zzbah) obj);
                    return;
                } else {
                    zzbav.zzen((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbah) {
                    zzbav.zzan((zzbah) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzbav.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzbav.zzca(((Integer) obj).intValue());
                return;
            case 14:
                zzbav.zzcc(((Integer) obj).intValue());
                return;
            case 15:
                zzbav.zzo(((Long) obj).longValue());
                return;
            case 16:
                zzbav.zzcb(((Integer) obj).intValue());
                return;
            case 17:
                zzbav.zzn(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbbr) {
                    zzbav.zzbz(((zzbbr) obj).zzhq());
                    return;
                } else {
                    zzbav.zzbz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzada()) {
            zza(fielddescriptortype.zzacy(), obj);
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
                zza(fielddescriptortype.zzacy(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzbbx) {
            this.zzdqz = true;
        }
        this.zzdqx.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzbbx) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzbbr) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzbes r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzbbq.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzbbh.zzdrb
            com.google.android.gms.internal.ads.zzbex r2 = r2.zzagl()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbcu
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbbx
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbbr
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbah
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbg.zza(com.google.android.gms.internal.ads.zzbes, java.lang.Object):void");
    }

    public static <T extends zzbbi<T>> zzbbg<T> zzacv() {
        return zzdra;
    }

    private static int zzb(zzbbi<?> zzbbi, Object obj) {
        zzbes zzacy = zzbbi.zzacy();
        int zzhq = zzbbi.zzhq();
        if (!zzbbi.zzada()) {
            return zza(zzacy, zzhq, obj);
        }
        int i = 0;
        if (zzbbi.zzadb()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzacy, zzb);
            }
            return zzbav.zzcd(zzhq) + i + zzbav.zzcl(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzacy, zzhq, zza);
        }
        return i;
    }

    private static int zzb(zzbes zzbes, Object obj) {
        switch (zzbbh.zzdql[zzbes.ordinal()]) {
            case 1:
                return zzbav.zzc(((Double) obj).doubleValue());
            case 2:
                return zzbav.zzc(((Float) obj).floatValue());
            case 3:
                return zzbav.zzp(((Long) obj).longValue());
            case 4:
                return zzbav.zzq(((Long) obj).longValue());
            case 5:
                return zzbav.zzce(((Integer) obj).intValue());
            case 6:
                return zzbav.zzs(((Long) obj).longValue());
            case 7:
                return zzbav.zzch(((Integer) obj).intValue());
            case 8:
                return zzbav.zzaq(((Boolean) obj).booleanValue());
            case 9:
                return zzbav.zzg((zzbcu) obj);
            case 10:
                return obj instanceof zzbbx ? zzbav.zza((zzbcb) (zzbbx) obj) : zzbav.zzf((zzbcu) obj);
            case 11:
                return obj instanceof zzbah ? zzbav.zzao((zzbah) obj) : zzbav.zzeo((String) obj);
            case 12:
                return obj instanceof zzbah ? zzbav.zzao((zzbah) obj) : zzbav.zzr((byte[]) obj);
            case 13:
                return zzbav.zzcf(((Integer) obj).intValue());
            case 14:
                return zzbav.zzci(((Integer) obj).intValue());
            case 15:
                return zzbav.zzt(((Long) obj).longValue());
            case 16:
                return zzbav.zzcg(((Integer) obj).intValue());
            case 17:
                return zzbav.zzr(((Long) obj).longValue());
            case 18:
                return obj instanceof zzbbr ? zzbav.zzcj(((zzbbr) obj).zzhq()) : zzbav.zzcj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzbbi zzbbi = (zzbbi) entry.getKey();
        if (zzbbi.zzacz() == zzbex.MESSAGE) {
            if (zzbbi.zzada()) {
                for (zzbcu isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzbcu) {
                    if (!((zzbcu) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzbbx) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzbbi zzbbi = (zzbbi) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzbbx) {
            value = zzbbx.zzadu();
        }
        if (zzbbi.zzada()) {
            Object zza = zza(zzbbi);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzp : (List) value) {
                ((List) zza).add(zzp(zzp));
            }
            this.zzdqx.put(zzbbi, zza);
        } else if (zzbbi.zzacz() == zzbex.MESSAGE) {
            Object zza2 = zza(zzbbi);
            if (zza2 == null) {
                this.zzdqx.put(zzbbi, zzp(value));
            } else {
                this.zzdqx.put(zzbbi, zza2 instanceof zzbdb ? zzbbi.zza((zzbdb) zza2, (zzbdb) value) : zzbbi.zza(((zzbcu) zza2).zzade(), (zzbcu) value).zzadk());
            }
        } else {
            this.zzdqx.put(zzbbi, zzp(value));
        }
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzbbi zzbbi = (zzbbi) entry.getKey();
        Object value = entry.getValue();
        return (zzbbi.zzacz() != zzbex.MESSAGE || zzbbi.zzada() || zzbbi.zzadb()) ? zzb((zzbbi<?>) zzbbi, value) : value instanceof zzbbx ? zzbav.zzb(((zzbbi) entry.getKey()).zzhq(), (zzbcb) (zzbbx) value) : zzbav.zzb(((zzbbi) entry.getKey()).zzhq(), (zzbcu) value);
    }

    private static Object zzp(Object obj) {
        if (obj instanceof zzbdb) {
            return ((zzbdb) obj).zzaek();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbbg zzbbg = new zzbbg();
        for (int i = 0; i < this.zzdqx.zzafs(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzcy = this.zzdqx.zzcy(i);
            zzbbg.zza((zzbbi) zzcy.getKey(), zzcy.getValue());
        }
        for (Map.Entry next : this.zzdqx.zzaft()) {
            zzbbg.zza((zzbbi) next.getKey(), next.getValue());
        }
        zzbbg.zzdqz = this.zzdqz;
        return zzbbg;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzdqz ? new zzbca(this.zzdqx.zzafu().iterator()) : this.zzdqx.zzafu().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbbg)) {
            return false;
        }
        return this.zzdqx.equals(((zzbbg) obj).zzdqx);
    }

    public final int hashCode() {
        return this.zzdqx.hashCode();
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zzdqx.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzdqy;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzdqx.zzafs(); i++) {
            if (!zzb(this.zzdqx.zzcy(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzdqx.zzaft()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzdqz ? new zzbca(this.zzdqx.entrySet().iterator()) : this.zzdqx.entrySet().iterator();
    }

    public final void zza(zzbbg<FieldDescriptorType> zzbbg) {
        for (int i = 0; i < zzbbg.zzdqx.zzafs(); i++) {
            zzc(zzbbg.zzdqx.zzcy(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzbbg.zzdqx.zzaft()) {
            zzc(zzc);
        }
    }

    public final void zzaaz() {
        if (!this.zzdqy) {
            this.zzdqx.zzaaz();
            this.zzdqy = true;
        }
    }

    public final int zzacw() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzdqx.zzafs(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzcy = this.zzdqx.zzcy(i2);
            i += zzb((zzbbi<?>) (zzbbi) zzcy.getKey(), zzcy.getValue());
        }
        for (Map.Entry next : this.zzdqx.zzaft()) {
            i += zzb((zzbbi<?>) (zzbbi) next.getKey(), next.getValue());
        }
        return i;
    }

    public final int zzacx() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzdqx.zzafs(); i2++) {
            i += zzd(this.zzdqx.zzcy(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzdqx.zzaft()) {
            i += zzd(zzd);
        }
        return i;
    }
}
