package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzabg implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzaba zzbup;
    private boolean zzbuq;
    private Iterator<Map.Entry<K, V>> zzbur;

    private zzabg(zzaba zzaba) {
        this.zzbup = zzaba;
        this.pos = -1;
    }

    /* synthetic */ zzabg(zzaba zzaba, zzabb zzabb) {
        this(zzaba);
    }

    private final Iterator<Map.Entry<K, V>> zzuy() {
        if (this.zzbur == null) {
            this.zzbur = this.zzbup.zzbuj.entrySet().iterator();
        }
        return this.zzbur;
    }

    public final boolean hasNext() {
        if (this.pos + 1 >= this.zzbup.zzbui.size()) {
            return !this.zzbup.zzbuj.isEmpty() && zzuy().hasNext();
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        this.zzbuq = true;
        int i = this.pos + 1;
        this.pos = i;
        return (Map.Entry) (i < this.zzbup.zzbui.size() ? this.zzbup.zzbui.get(this.pos) : zzuy().next());
    }

    public final void remove() {
        if (!this.zzbuq) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzbuq = false;
        this.zzbup.zzuu();
        if (this.pos < this.zzbup.zzbui.size()) {
            zzaba zzaba = this.zzbup;
            int i = this.pos;
            this.pos = i - 1;
            Object unused = zzaba.zzai(i);
            return;
        }
        zzuy().remove();
    }
}
