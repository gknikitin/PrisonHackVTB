package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzbff implements Cloneable {
    private Object value;
    private zzbfd<?, ?> zzebq;
    private List<zzbfk> zzebr = new ArrayList();

    zzbff() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzr()];
        zza(zzbfa.zzu(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzagp */
    public final zzbff clone() {
        Object clone;
        zzbff zzbff = new zzbff();
        try {
            zzbff.zzebq = this.zzebq;
            if (this.zzebr == null) {
                zzbff.zzebr = null;
            } else {
                zzbff.zzebr.addAll(this.zzebr);
            }
            if (this.value != null) {
                if (this.value instanceof zzbfi) {
                    clone = (zzbfi) ((zzbfi) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzbff.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzbfi[]) {
                        zzbfi[] zzbfiArr = (zzbfi[]) this.value;
                        zzbfi[] zzbfiArr2 = new zzbfi[zzbfiArr.length];
                        zzbff.value = zzbfiArr2;
                        while (i < zzbfiArr.length) {
                            zzbfiArr2[i] = (zzbfi) zzbfiArr[i].clone();
                            i++;
                        }
                    }
                }
                zzbff.value = clone;
                return zzbff;
            }
            return zzbff;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbff)) {
            return false;
        }
        zzbff zzbff = (zzbff) obj;
        if (this.value == null || zzbff.value == null) {
            if (this.zzebr != null && zzbff.zzebr != null) {
                return this.zzebr.equals(zzbff.zzebr);
            }
            try {
                return Arrays.equals(toByteArray(), zzbff.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzebq != zzbff.zzebq) {
            return false;
        } else {
            return !this.zzebq.zzebl.isArray() ? this.value.equals(zzbff.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzbff.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzbff.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzbff.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzbff.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzbff.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzbff.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzbff.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        for (zzbfk next : this.zzebr) {
            zzbfa.zzde(next.tag);
            zzbfa.zzw(next.zzdpw);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbfk zzbfk) throws IOException {
        if (this.zzebr != null) {
            this.zzebr.add(zzbfk);
        } else if (this.value instanceof zzbfi) {
            byte[] bArr = zzbfk.zzdpw;
            zzbez zzi = zzbez.zzi(bArr, 0, bArr.length);
            int zzacc = zzi.zzacc();
            if (zzacc != bArr.length - zzbfa.zzce(zzacc)) {
                throw zzbfh.zzagq();
            }
            zzbfi zza = ((zzbfi) this.value).zza(zzi);
            this.zzebq = this.zzebq;
            this.value = zza;
            this.zzebr = null;
        } else if (this.value instanceof zzbfi[]) {
            Collections.singletonList(zzbfk);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(zzbfk);
            throw new NoSuchMethodError();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzr() {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        int i = 0;
        for (zzbfk next : this.zzebr) {
            i += zzbfa.zzcl(next.tag) + 0 + next.zzdpw.length;
        }
        return i;
    }
}
