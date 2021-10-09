package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zze {

    static class zza {
        private final Component<?> zza;
        private final Set<zza> zzb = new HashSet();
        private final Set<zza> zzc = new HashSet();

        zza(Component<?> component) {
            this.zza = component;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zza zza2) {
            this.zzb.add(zza2);
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zza zza2) {
            this.zzc.add(zza2);
        }

        /* access modifiers changed from: package-private */
        public final Set<zza> zza() {
            return this.zzb;
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zza zza2) {
            this.zzc.remove(zza2);
        }

        /* access modifiers changed from: package-private */
        public final Component<?> zzb() {
            return this.zza;
        }

        /* access modifiers changed from: package-private */
        public final boolean zzc() {
            return this.zzc.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public final boolean zzd() {
            return this.zzb.isEmpty();
        }
    }

    private static Set<zza> zza(Set<zza> set) {
        HashSet hashSet = new HashSet();
        for (zza next : set) {
            if (next.zzc()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    static List<Component<?>> zza(List<Component<?>> list) {
        zza zza2;
        HashMap hashMap = new HashMap(list.size());
        for (Component next : list) {
            zza zza3 = new zza(next);
            Iterator it = next.zza().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    if (hashMap.put(cls, zza3) != null) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (zza zza4 : hashMap.values()) {
            for (Dependency next2 : zza4.zzb().zzb()) {
                if (next2.zzc() && (zza2 = (zza) hashMap.get(next2.zza())) != null) {
                    zza4.zza(zza2);
                    zza2.zzb(zza4);
                }
            }
        }
        HashSet<zza> hashSet = new HashSet<>(hashMap.values());
        Set<zza> zza5 = zza((Set<zza>) hashSet);
        ArrayList arrayList = new ArrayList();
        while (!zza5.isEmpty()) {
            zza next3 = zza5.iterator().next();
            zza5.remove(next3);
            arrayList.add(next3.zzb());
            for (zza next4 : next3.zza()) {
                next4.zzc(next3);
                if (next4.zzc()) {
                    zza5.add(next4);
                }
            }
        }
        if (arrayList.size() == list.size()) {
            Collections.reverse(arrayList);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (zza zza6 : hashSet) {
            if (!zza6.zzc() && !zza6.zzd()) {
                arrayList2.add(zza6.zzb());
            }
        }
        throw new DependencyCycleException(arrayList2);
    }
}
