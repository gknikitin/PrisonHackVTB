package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzxh {
    private final ConcurrentHashMap<zzxi, List<Throwable>> zzbol = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzbom = new ReferenceQueue<>();

    zzxh() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        while (true) {
            Reference<? extends Throwable> poll = this.zzbom.poll();
            if (poll != null) {
                this.zzbol.remove(poll);
            } else {
                return this.zzbol.get(new zzxi(th, (ReferenceQueue<Throwable>) null));
            }
        }
    }
}
