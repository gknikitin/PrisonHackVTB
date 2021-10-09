package com.google.android.gms.internal.ads;

final class zzbeq extends zzben {
    zzbeq() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzbem.zzda(i);
            case 1:
                return zzbem.zzz(i, zzbek.zza(bArr, j));
            case 2:
                return zzbem.zzf(i, (int) zzbek.zza(bArr, j), (int) zzbek.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ac, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r12 = r14 | r15
            int r0 = r13.length
            int r0 = r0 - r15
            r12 = r12 | r0
            r0 = 2
            r1 = 3
            r2 = 0
            if (r12 >= 0) goto L_0x002c
            java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r3 = "Array length=%d, index=%d, limit=%d"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r13 = r13.length
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1[r2] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            r14 = 1
            r1[r14] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r1[r0] = r13
            java.lang.String r13 = java.lang.String.format(r3, r1)
            r12.<init>(r13)
            throw r12
        L_0x002c:
            long r3 = (long) r14
            long r14 = (long) r15
            long r5 = r14 - r3
            int r12 = (int) r5
            r14 = 16
            r5 = 1
            if (r12 >= r14) goto L_0x0039
            r14 = 0
            goto L_0x004b
        L_0x0039:
            r7 = r3
            r14 = 0
        L_0x003b:
            if (r14 >= r12) goto L_0x004a
            long r9 = r7 + r5
            byte r15 = com.google.android.gms.internal.ads.zzbek.zza(r13, r7)
            if (r15 >= 0) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            int r14 = r14 + 1
            r7 = r9
            goto L_0x003b
        L_0x004a:
            r14 = r12
        L_0x004b:
            int r12 = r12 - r14
            long r14 = (long) r14
            long r7 = r3 + r14
        L_0x004f:
            r14 = 0
        L_0x0050:
            if (r12 <= 0) goto L_0x0061
            long r14 = r7 + r5
            byte r3 = com.google.android.gms.internal.ads.zzbek.zza(r13, r7)
            if (r3 < 0) goto L_0x005f
            int r12 = r12 + -1
            r7 = r14
            r14 = r3
            goto L_0x0050
        L_0x005f:
            r7 = r14
            r14 = r3
        L_0x0061:
            if (r12 != 0) goto L_0x0064
            return r2
        L_0x0064:
            int r12 = r12 + -1
            r15 = -32
            r3 = -65
            r4 = -1
            if (r14 >= r15) goto L_0x0082
            if (r12 != 0) goto L_0x0070
            return r14
        L_0x0070:
            int r12 = r12 + -1
            r15 = -62
            if (r14 < r15) goto L_0x0081
            long r14 = r7 + r5
            byte r7 = com.google.android.gms.internal.ads.zzbek.zza(r13, r7)
            if (r7 <= r3) goto L_0x007f
            return r4
        L_0x007f:
            r7 = r14
            goto L_0x004f
        L_0x0081:
            return r4
        L_0x0082:
            r9 = -16
            if (r14 >= r9) goto L_0x00ad
            if (r12 >= r0) goto L_0x008d
            int r12 = zza(r13, r14, r7, r12)
            return r12
        L_0x008d:
            int r12 = r12 + -2
            long r9 = r7 + r5
            byte r7 = com.google.android.gms.internal.ads.zzbek.zza(r13, r7)
            if (r7 > r3) goto L_0x00ac
            r8 = -96
            if (r14 != r15) goto L_0x009d
            if (r7 < r8) goto L_0x00ac
        L_0x009d:
            r15 = -19
            if (r14 != r15) goto L_0x00a3
            if (r7 >= r8) goto L_0x00ac
        L_0x00a3:
            r14 = 0
            long r7 = r9 + r5
            byte r14 = com.google.android.gms.internal.ads.zzbek.zza(r13, r9)
            if (r14 <= r3) goto L_0x004f
        L_0x00ac:
            return r4
        L_0x00ad:
            if (r12 >= r1) goto L_0x00b4
            int r12 = zza(r13, r14, r7, r12)
            return r12
        L_0x00b4:
            int r12 = r12 + -3
            long r9 = r7 + r5
            byte r15 = com.google.android.gms.internal.ads.zzbek.zza(r13, r7)
            if (r15 > r3) goto L_0x00d7
            int r14 = r14 << 28
            int r15 = r15 + 112
            int r14 = r14 + r15
            int r14 = r14 >> 30
            if (r14 != 0) goto L_0x00d7
            long r14 = r9 + r5
            byte r7 = com.google.android.gms.internal.ads.zzbek.zza(r13, r9)
            if (r7 > r3) goto L_0x00d7
            long r7 = r14 + r5
            byte r14 = com.google.android.gms.internal.ads.zzbek.zza(r13, r14)
            if (r14 <= r3) goto L_0x004f
        L_0x00d7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbeq.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        long j2;
        char charAt;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        long j3 = (long) i4;
        long j4 = j3 + ((long) i5);
        int length = charSequence.length();
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt2 = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (i6 < length && (charAt = charSequence2.charAt(i6)) < 128) {
            zzbek.zza(bArr2, j, (byte) charAt);
            i6++;
            j3 = j + 1;
        }
        if (i6 == length) {
            return (int) j;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < 128 && j < j4) {
                j2 = j + 1;
            } else if (charAt3 < 2048 && j <= j4 - 2) {
                long j5 = j + 1;
                zzbek.zza(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j5 + 1;
                zzbek.zza(bArr2, j5, (byte) ((charAt3 & '?') | 128));
                i6++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j4 - 3) {
                long j6 = j + 1;
                zzbek.zza(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                j = j6 + 1;
                zzbek.zza(bArr2, j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                j2 = j + 1;
                charAt3 = (charAt3 & '?') | 128;
            } else if (j <= j4 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j7 = j + 1;
                        zzbek.zza(bArr2, j, (byte) ((codePoint >>> 18) | 240));
                        long j8 = j7 + 1;
                        zzbek.zza(bArr2, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j9 = j8 + 1;
                        zzbek.zza(bArr2, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j9 + 1;
                        zzbek.zza(bArr2, j9, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                    }
                } else {
                    i7 = i6;
                }
                throw new zzbep(i7 - 1, length);
            } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i6 + 1) != length && Character.isSurrogatePair(charAt3, charSequence2.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzbep(i6, length);
            }
            zzbek.zza(bArr2, j, (byte) charAt3);
            j = j2;
            i6++;
        }
        return (int) j;
    }
}
