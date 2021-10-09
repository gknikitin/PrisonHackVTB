package com.google.android.gms.common.internal;

import android.support.p000v4.util.LruCache;

final class zze extends LruCache<K, V> {
    private final /* synthetic */ ExpirableLruCache zzss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(ExpirableLruCache expirableLruCache, int i) {
        super(i);
        this.zzss = expirableLruCache;
    }

    /* access modifiers changed from: protected */
    public final V create(K k) {
        return this.zzss.create(k);
    }

    /* access modifiers changed from: protected */
    public final void entryRemoved(boolean z, K k, V v, V v2) {
        this.zzss.entryRemoved(z, k, v, v2);
        synchronized (this.zzss.mLock) {
            if (v2 == null) {
                try {
                    if (this.zzss.zzct()) {
                        this.zzss.zzsq.remove(k);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v2 == null && this.zzss.zzcu()) {
                this.zzss.zzsr.remove(k);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int sizeOf(K k, V v) {
        return this.zzss.sizeOf(k, v);
    }
}
