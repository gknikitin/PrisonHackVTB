package com.google.android.gms.internal.measurement;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzgk<V> extends FutureTask<V> implements Comparable<zzgk> {
    private final String zzamh;
    private final /* synthetic */ zzgh zzami;
    private final long zzamj = zzgh.zzamg.getAndIncrement();
    final boolean zzamk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgk(zzgh zzgh, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzami = zzgh;
        Preconditions.checkNotNull(str);
        this.zzamh = str;
        this.zzamk = false;
        if (this.zzamj == Long.MAX_VALUE) {
            zzgh.zzgf().zzis().log("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgk(zzgh zzgh, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzami = zzgh;
        Preconditions.checkNotNull(str);
        this.zzamh = str;
        this.zzamk = z;
        if (this.zzamj == Long.MAX_VALUE) {
            zzgh.zzgf().zzis().log("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzgk zzgk = (zzgk) obj;
        if (this.zzamk != zzgk.zzamk) {
            return this.zzamk ? -1 : 1;
        }
        if (this.zzamj < zzgk.zzamj) {
            return -1;
        }
        if (this.zzamj > zzgk.zzamj) {
            return 1;
        }
        this.zzami.zzgf().zzit().zzg("Two tasks share the same index. index", Long.valueOf(this.zzamj));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzami.zzgf().zzis().zzg(this.zzamh, th);
        if (th instanceof zzgi) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
