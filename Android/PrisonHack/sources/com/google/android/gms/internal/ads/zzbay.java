package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbay extends zzbab<Double> implements zzbbt<Double>, RandomAccess {
    private static final zzbay zzdqo;
    private int size;
    private double[] zzdqp;

    static {
        zzbay zzbay = new zzbay();
        zzdqo = zzbay;
        zzbay.zzaaz();
    }

    zzbay() {
        this(new double[10], 0);
    }

    private zzbay(double[] dArr, int i) {
        this.zzdqp = dArr;
        this.size = i;
    }

    private final void zzbk(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
    }

    private final String zzbl(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    private final void zzc(int i, double d) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdqp.length) {
            System.arraycopy(this.zzdqp, i, this.zzdqp, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzdqp, 0, dArr, 0, i);
            System.arraycopy(this.zzdqp, i, dArr, i + 1, this.size - i);
            this.zzdqp = dArr;
        }
        this.zzdqp[i] = d;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbay)) {
            return super.addAll(collection);
        }
        zzbay zzbay = (zzbay) collection;
        if (zzbay.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbay.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbay.size;
        if (i > this.zzdqp.length) {
            this.zzdqp = Arrays.copyOf(this.zzdqp, i);
        }
        System.arraycopy(zzbay.zzdqp, 0, this.zzdqp, this.size, zzbay.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbay)) {
            return super.equals(obj);
        }
        zzbay zzbay = (zzbay) obj;
        if (this.size != zzbay.size) {
            return false;
        }
        double[] dArr = zzbay.zzdqp;
        for (int i = 0; i < this.size; i++) {
            if (this.zzdqp[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzbk(i);
        return Double.valueOf(this.zzdqp[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzbbq.zzv(Double.doubleToLongBits(this.zzdqp[i2]));
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        double d = this.zzdqp[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdqp, i + 1, this.zzdqp, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzdqp[i]))) {
                System.arraycopy(this.zzdqp, i + 1, this.zzdqp, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzaba();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzdqp, i2, this.zzdqp, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzaba();
        zzbk(i);
        double d = this.zzdqp[i];
        this.zzdqp[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.size) {
            return new zzbay(Arrays.copyOf(this.zzdqp, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }
}
