package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzea extends zzei {
    private final StackTraceElement[] zztv;

    public zzea(zzcz zzcz, String str, String str2, zzba zzba, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzcz, str, str2, zzba, i, 45);
        this.zztv = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzar() throws IllegalAccessException, InvocationTargetException {
        if (this.zztv != null) {
            zzcx zzcx = new zzcx((String) this.zztz.invoke((Object) null, new Object[]{this.zztv}));
            synchronized (this.zztq) {
                this.zztq.zzek = zzcx.zzro;
                if (zzcx.zzrp.booleanValue()) {
                    this.zztq.zzes = Integer.valueOf(zzcx.zzrq.booleanValue() ^ true ? 1 : 0);
                }
            }
        }
    }
}
