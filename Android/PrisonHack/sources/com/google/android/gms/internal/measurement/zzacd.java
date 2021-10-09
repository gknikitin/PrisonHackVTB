package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzacd implements Cloneable {
    private Object value;
    private zzacb<?, ?> zzbxo;
    private List<zzaci> zzbxp = new ArrayList();

    zzacd() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zza()];
        zza(zzaby.zzj(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzvp */
    public final zzacd clone() {
        Object clone;
        zzacd zzacd = new zzacd();
        try {
            zzacd.zzbxo = this.zzbxo;
            if (this.zzbxp == null) {
                zzacd.zzbxp = null;
            } else {
                zzacd.zzbxp.addAll(this.zzbxp);
            }
            if (this.value != null) {
                if (this.value instanceof zzacg) {
                    clone = (zzacg) ((zzacg) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzacd.value = bArr2;
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
                    } else if (this.value instanceof zzacg[]) {
                        zzacg[] zzacgArr = (zzacg[]) this.value;
                        zzacg[] zzacgArr2 = new zzacg[zzacgArr.length];
                        zzacd.value = zzacgArr2;
                        while (i < zzacgArr.length) {
                            zzacgArr2[i] = (zzacg) zzacgArr[i].clone();
                            i++;
                        }
                    }
                }
                zzacd.value = clone;
                return zzacd;
            }
            return zzacd;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacd)) {
            return false;
        }
        zzacd zzacd = (zzacd) obj;
        if (this.value == null || zzacd.value == null) {
            if (this.zzbxp != null && zzacd.zzbxp != null) {
                return this.zzbxp.equals(zzacd.zzbxp);
            }
            try {
                return Arrays.equals(toByteArray(), zzacd.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzbxo != zzacd.zzbxo) {
            return false;
        } else {
            return !this.zzbxo.zzbxh.isArray() ? this.value.equals(zzacd.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzacd.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzacd.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzacd.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzacd.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzacd.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzacd.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzacd.value);
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
    public final int zza() {
        int i;
        if (this.value != null) {
            zzacb<?, ?> zzacb = this.zzbxo;
            Object obj = this.value;
            if (!zzacb.zzbxi) {
                return zzacb.zzv(obj);
            }
            int length = Array.getLength(obj);
            i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += zzacb.zzv(Array.get(obj, i2));
                }
            }
        } else {
            i = 0;
            for (zzaci next : this.zzbxp) {
                i += zzaby.zzas(next.tag) + 0 + next.zzbrm.length;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaby zzaby) throws IOException {
        if (this.value != null) {
            zzacb<?, ?> zzacb = this.zzbxo;
            Object obj = this.value;
            if (zzacb.zzbxi) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzacb.zza(obj2, zzaby);
                    }
                }
                return;
            }
            zzacb.zza(obj, zzaby);
            return;
        }
        for (zzaci next : this.zzbxp) {
            zzaby.zzar(next.tag);
            zzaby.zzk(next.zzbrm);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaci zzaci) throws IOException {
        Object obj;
        if (this.zzbxp != null) {
            this.zzbxp.add(zzaci);
            return;
        }
        if (this.value instanceof zzacg) {
            byte[] bArr = zzaci.zzbrm;
            zzabx zza = zzabx.zza(bArr, 0, bArr.length);
            int zzvh = zza.zzvh();
            if (zzvh != bArr.length - zzaby.zzao(zzvh)) {
                throw zzacf.zzvq();
            }
            obj = ((zzacg) this.value).zzb(zza);
        } else if (this.value instanceof zzacg[]) {
            zzacg[] zzacgArr = (zzacg[]) this.zzbxo.zzi(Collections.singletonList(zzaci));
            zzacg[] zzacgArr2 = (zzacg[]) this.value;
            zzacg[] zzacgArr3 = (zzacg[]) Arrays.copyOf(zzacgArr2, zzacgArr2.length + zzacgArr.length);
            System.arraycopy(zzacgArr, 0, zzacgArr3, zzacgArr2.length, zzacgArr.length);
            obj = zzacgArr3;
        } else {
            obj = this.zzbxo.zzi(Collections.singletonList(zzaci));
        }
        this.zzbxo = this.zzbxo;
        this.value = obj;
        this.zzbxp = null;
    }

    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzacb<?, T> zzacb) {
        if (this.value == null) {
            this.zzbxo = zzacb;
            this.value = zzacb.zzi(this.zzbxp);
            this.zzbxp = null;
        } else if (!this.zzbxo.equals(zzacb)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }
}
