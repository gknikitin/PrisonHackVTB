package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzadd implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzadb zzccb;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzccc;

    zzadd(zzadb zzadb, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzccb = zzadb;
        this.zzccc = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzccb.zza(thread, th);
            if (this.zzccc == null) {
                return;
            }
        } catch (Throwable th2) {
            if (this.zzccc != null) {
                this.zzccc.uncaughtException(thread, th);
            }
            throw th2;
        }
        this.zzccc.uncaughtException(thread, th);
    }
}
