package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzaba<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbme;
    private final int zzbuh;
    /* access modifiers changed from: private */
    public List<zzabf> zzbui;
    /* access modifiers changed from: private */
    public Map<K, V> zzbuj;
    private volatile zzabh zzbuk;
    private Map<K, V> zzbul;

    private zzaba(int i) {
        this.zzbuh = i;
        this.zzbui = Collections.emptyList();
        this.zzbuj = Collections.emptyMap();
        this.zzbul = Collections.emptyMap();
    }

    /* synthetic */ zzaba(int i, zzabb zzabb) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzbui.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzbui.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzbui.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    static <FieldDescriptorType extends zzzq<FieldDescriptorType>> zzaba<FieldDescriptorType, Object> zzag(int i) {
        return new zzabb(i);
    }

    /* access modifiers changed from: private */
    public final V zzai(int i) {
        zzuu();
        V value = this.zzbui.remove(i).getValue();
        if (!this.zzbuj.isEmpty()) {
            Iterator it = zzuv().entrySet().iterator();
            this.zzbui.add(new zzabf(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzuu() {
        if (this.zzbme) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzuv() {
        zzuu();
        if (this.zzbuj.isEmpty() && !(this.zzbuj instanceof TreeMap)) {
            this.zzbuj = new TreeMap();
            this.zzbul = ((TreeMap) this.zzbuj).descendingMap();
        }
        return (SortedMap) this.zzbuj;
    }

    public void clear() {
        zzuu();
        if (!this.zzbui.isEmpty()) {
            this.zzbui.clear();
        }
        if (!this.zzbuj.isEmpty()) {
            this.zzbuj.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzbuj.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzbuk == null) {
            this.zzbuk = new zzabh(this, (zzabb) null);
        }
        return this.zzbuk;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaba)) {
            return super.equals(obj);
        }
        zzaba zzaba = (zzaba) obj;
        int size = size();
        if (size != zzaba.size()) {
            return false;
        }
        int zzus = zzus();
        if (zzus != zzaba.zzus()) {
            return entrySet().equals(zzaba.entrySet());
        }
        for (int i = 0; i < zzus; i++) {
            if (!zzah(i).equals(zzaba.zzah(i))) {
                return false;
            }
        }
        if (zzus != size) {
            return this.zzbuj.equals(zzaba.zzbuj);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzbui.get(zza).getValue() : this.zzbuj.get(comparable);
    }

    public int hashCode() {
        int zzus = zzus();
        int i = 0;
        for (int i2 = 0; i2 < zzus; i2++) {
            i += this.zzbui.get(i2).hashCode();
        }
        return this.zzbuj.size() > 0 ? i + this.zzbuj.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzbme;
    }

    public V remove(Object obj) {
        zzuu();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzai(zza);
        }
        if (this.zzbuj.isEmpty()) {
            return null;
        }
        return this.zzbuj.remove(comparable);
    }

    public int size() {
        return this.zzbui.size() + this.zzbuj.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzuu();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzbui.get(zza).setValue(v);
        }
        zzuu();
        if (this.zzbui.isEmpty() && !(this.zzbui instanceof ArrayList)) {
            this.zzbui = new ArrayList(this.zzbuh);
        }
        int i = -(zza + 1);
        if (i >= this.zzbuh) {
            return zzuv().put(k, v);
        }
        if (this.zzbui.size() == this.zzbuh) {
            zzabf remove = this.zzbui.remove(this.zzbuh - 1);
            zzuv().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzbui.add(i, new zzabf(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzah(int i) {
        return this.zzbui.get(i);
    }

    public void zzrp() {
        if (!this.zzbme) {
            this.zzbuj = this.zzbuj.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbuj);
            this.zzbul = this.zzbul.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbul);
            this.zzbme = true;
        }
    }

    public final int zzus() {
        return this.zzbui.size();
    }

    public final Iterable<Map.Entry<K, V>> zzut() {
        return this.zzbuj.isEmpty() ? zzabc.zzuw() : this.zzbuj.entrySet();
    }
}
