package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzadc implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzcca;
    private final /* synthetic */ zzadb zzccb;

    zzadc(zzadb zzadb, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzccb = zzadb;
        this.zzcca = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzccb.zza(thread, th);
            if (this.zzcca == null) {
                return;
            }
        } catch (Throwable th2) {
            if (this.zzcca != null) {
                this.zzcca.uncaughtException(thread, th);
            }
            throw th2;
        }
        this.zzcca.uncaughtException(thread, th);
    }
}
