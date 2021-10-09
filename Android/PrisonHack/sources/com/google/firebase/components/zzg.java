package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

final /* synthetic */ class zzg implements Runnable {
    private final Map.Entry zza;
    private final Event zzb;

    zzg(Map.Entry entry, Event event) {
        this.zza = entry;
        this.zzb = event;
    }

    public final void run() {
        ((EventHandler) this.zza.getKey()).handle(this.zzb);
    }
}
