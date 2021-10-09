package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzgz extends zzgq {
    private MessageDigest zzaje;
    private final int zzajh;
    private final int zzaji;

    public zzgz(int i) {
        int i2 = i / 8;
        this.zzajh = i % 8 > 0 ? i2 + 1 : i2;
        this.zzaji = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzx(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.mLock
            monitor-enter(r0)
            java.security.MessageDigest r1 = r10.zzhg()     // Catch:{ all -> 0x006f }
            r10.zzaje = r1     // Catch:{ all -> 0x006f }
            java.security.MessageDigest r1 = r10.zzaje     // Catch:{ all -> 0x006f }
            r2 = 0
            if (r1 != 0) goto L_0x0012
            byte[] r11 = new byte[r2]     // Catch:{ all -> 0x006f }
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return r11
        L_0x0012:
            java.security.MessageDigest r1 = r10.zzaje     // Catch:{ all -> 0x006f }
            r1.reset()     // Catch:{ all -> 0x006f }
            java.security.MessageDigest r1 = r10.zzaje     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x006f }
            byte[] r11 = r11.getBytes(r3)     // Catch:{ all -> 0x006f }
            r1.update(r11)     // Catch:{ all -> 0x006f }
            java.security.MessageDigest r11 = r10.zzaje     // Catch:{ all -> 0x006f }
            byte[] r11 = r11.digest()     // Catch:{ all -> 0x006f }
            int r1 = r11.length     // Catch:{ all -> 0x006f }
            int r3 = r10.zzajh     // Catch:{ all -> 0x006f }
            if (r1 <= r3) goto L_0x0034
            int r1 = r10.zzajh     // Catch:{ all -> 0x006f }
            goto L_0x0035
        L_0x0034:
            int r1 = r11.length     // Catch:{ all -> 0x006f }
        L_0x0035:
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x006f }
            int r3 = r1.length     // Catch:{ all -> 0x006f }
            java.lang.System.arraycopy(r11, r2, r1, r2, r3)     // Catch:{ all -> 0x006f }
            int r11 = r10.zzaji     // Catch:{ all -> 0x006f }
            r3 = 8
            int r11 = r11 % r3
            if (r11 <= 0) goto L_0x006d
            r4 = 0
        L_0x0044:
            int r11 = r1.length     // Catch:{ all -> 0x006f }
            if (r2 >= r11) goto L_0x0055
            if (r2 <= 0) goto L_0x004a
            long r4 = r4 << r3
        L_0x004a:
            byte r11 = r1[r2]     // Catch:{ all -> 0x006f }
            r11 = r11 & 255(0xff, float:3.57E-43)
            long r6 = (long) r11     // Catch:{ all -> 0x006f }
            long r8 = r4 + r6
            int r2 = r2 + 1
            r4 = r8
            goto L_0x0044
        L_0x0055:
            int r11 = r10.zzaji     // Catch:{ all -> 0x006f }
            int r11 = r11 % r3
            int r11 = 8 - r11
            long r4 = r4 >>> r11
            int r11 = r10.zzajh     // Catch:{ all -> 0x006f }
            int r11 = r11 + -1
        L_0x005f:
            if (r11 < 0) goto L_0x006d
            r6 = 255(0xff, double:1.26E-321)
            long r8 = r4 & r6
            int r2 = (int) r8     // Catch:{ all -> 0x006f }
            byte r2 = (byte) r2     // Catch:{ all -> 0x006f }
            r1[r11] = r2     // Catch:{ all -> 0x006f }
            long r4 = r4 >>> r3
            int r11 = r11 + -1
            goto L_0x005f
        L_0x006d:
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return r1
        L_0x006f:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgz.zzx(java.lang.String):byte[]");
    }
}
