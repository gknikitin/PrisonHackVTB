package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzabh extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzaba zzbup;

    private zzabh(zzaba zzaba) {
        this.zzbup = zzaba;
    }

    /* synthetic */ zzabh(zzaba zzaba, zzabb zzabb) {
        this(zzaba);
    }

    public final /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzbup.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zzbup.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzbup.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzabg(this.zzbup, (zzabb) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzbup.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zzbup.size();
    }
}
