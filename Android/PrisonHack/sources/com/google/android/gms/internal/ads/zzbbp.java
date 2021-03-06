package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbbp extends zzbab<Integer> implements zzbbt<Integer>, RandomAccess {
    private static final zzbbp zzduo;
    private int size;
    private int[] zzdup;

    static {
        zzbbp zzbbp = new zzbbp();
        zzduo = zzbbp;
        zzbbp.zzaaz();
    }

    zzbbp() {
        this(new int[10], 0);
    }

    private zzbbp(int[] iArr, int i) {
        this.zzdup = iArr;
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

    private final void zzy(int i, int i2) {
        zzaba();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzbl(i));
        }
        if (this.size < this.zzdup.length) {
            System.arraycopy(this.zzdup, i, this.zzdup, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzdup, 0, iArr, 0, i);
            System.arraycopy(this.zzdup, i, iArr, i + 1, this.size - i);
            this.zzdup = iArr;
        }
        this.zzdup[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzy(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzaba();
        zzbbq.checkNotNull(collection);
        if (!(collection instanceof zzbbp)) {
            return super.addAll(collection);
        }
        zzbbp zzbbp = (zzbbp) collection;
        if (zzbbp.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbbp.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbbp.size;
        if (i > this.zzdup.length) {
            this.zzdup = Arrays.copyOf(this.zzdup, i);
        }
        System.arraycopy(zzbbp.zzdup, 0, this.zzdup, this.size, zzbbp.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbbp)) {
            return super.equals(obj);
        }
        zzbbp zzbbp = (zzbbp) obj;
        if (this.size != zzbbp.size) {
            return false;
        }
        int[] iArr = zzbbp.zzdup;
        for (int i = 0; i < this.size; i++) {
            if (this.zzdup[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzbk(i);
        return this.zzdup[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzdup[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzaba();
        zzbk(i);
        int i2 = this.zzdup[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzdup, i + 1, this.zzdup, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzaba();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzdup[i]))) {
                System.arraycopy(this.zzdup, i + 1, this.zzdup, i, this.size - i);
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
        System.arraycopy(this.zzdup, i2, this.zzdup, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzaba();
        zzbk(i);
        int i2 = this.zzdup[i];
        this.zzdup[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.size) {
            return new zzbbp(Arrays.copyOf(this.zzdup, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzco(int i) {
        zzy(this.size, i);
    }
}
