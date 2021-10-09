package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaca;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzacb<M extends zzaca<M>, T> {
    public final int tag;
    private final int type;
    protected final Class<T> zzbxh;
    protected final boolean zzbxi;
    private final zzzs<?, ?> zzbxj;

    private zzacb(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, (zzzs<?, ?>) null, 810, false);
    }

    private zzacb(int i, Class<T> cls, zzzs<?, ?> zzzs, int i2, boolean z) {
        this.type = i;
        this.zzbxh = cls;
        this.tag = i2;
        this.zzbxi = false;
        this.zzbxj = null;
    }

    public static <M extends zzaca<M>, T extends zzacg> zzacb<M, T> zza(int i, Class<T> cls, long j) {
        return new zzacb<>(11, cls, 810, false);
    }

    private final Object zzf(zzabx zzabx) {
        Class componentType = this.zzbxi ? this.zzbxh.getComponentType() : this.zzbxh;
        try {
            switch (this.type) {
                case 10:
                    zzacg zzacg = (zzacg) componentType.newInstance();
                    zzabx.zza(zzacg, this.tag >>> 3);
                    return zzacg;
                case 11:
                    zzacg zzacg2 = (zzacg) componentType.newInstance();
                    zzabx.zza(zzacg2);
                    return zzacg2;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzacb)) {
            return false;
        }
        zzacb zzacb = (zzacb) obj;
        return this.type == zzacb.type && this.zzbxh == zzacb.zzbxh && this.tag == zzacb.tag && this.zzbxi == zzacb.zzbxi;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzbxh.hashCode()) * 31) + this.tag) * 31) + (this.zzbxi ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzaby zzaby) {
        try {
            zzaby.zzar(this.tag);
            switch (this.type) {
                case 10:
                    ((zzacg) obj).zza(zzaby);
                    zzaby.zzg(this.tag >>> 3, 4);
                    return;
                case 11:
                    zzaby.zzb((zzacg) obj);
                    return;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final T zzi(List<zzaci> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbxi) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                zzaci zzaci = list.get(i);
                if (zzaci.zzbrm.length != 0) {
                    arrayList.add(zzf(zzabx.zzi(zzaci.zzbrm)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.zzbxh.cast(Array.newInstance(this.zzbxh.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzbxh.cast(zzf(zzabx.zzi(list.get(list.size() - 1).zzbrm)));
        }
    }

    /* access modifiers changed from: protected */
    public final int zzv(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzaby.zzaq(i) << 1) + ((zzacg) obj).zzvv();
            case 11:
                return zzaby.zzb(i, (zzacg) obj);
            default:
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
        }
    }
}
