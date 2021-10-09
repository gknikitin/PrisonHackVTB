package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzzy<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzzw> zzbte;

    private zzzy(Map.Entry<K, zzzw> entry) {
        this.zzbte = entry;
    }

    public final K getKey() {
        return this.zzbte.getKey();
    }

    public final Object getValue() {
        if (this.zzbte.getValue() == null) {
            return null;
        }
        return zzzw.zztx();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzaan) {
            return this.zzbte.getValue().zzc((zzaan) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
