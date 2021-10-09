package com.google.android.gms.internal.ads;

import java.util.Random;

@zzadh
public final class zzkc extends zzlh {
    private Object mLock = new Object();
    private final Random zzasg = new Random();
    private long zzash;

    public zzkc() {
        zzil();
    }

    public final long getValue() {
        return this.zzash;
    }

    public final void zzil() {
        synchronized (this.mLock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                try {
                    long nextInt = ((long) this.zzasg.nextInt()) + 2147483648L;
                    if (nextInt != this.zzash && nextInt != 0) {
                        j = nextInt;
                        break;
                    }
                    j = nextInt;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zzash = j;
        }
    }
}
