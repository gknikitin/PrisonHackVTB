package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzzz<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbtf;

    public zzzz(Iterator<Map.Entry<K, Object>> it) {
        this.zzbtf = it;
    }

    public final boolean hasNext() {
        return this.zzbtf.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzbtf.next();
        return next.getValue() instanceof zzzw ? new zzzy(next) : next;
    }

    public final void remove() {
        this.zzbtf.remove();
    }
}
