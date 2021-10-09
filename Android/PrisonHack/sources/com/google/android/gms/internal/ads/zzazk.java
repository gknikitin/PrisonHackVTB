package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzazk {
    private static long zza(byte[] bArr, int i, int i2) {
        return (zzd(bArr, i) >> i2) & 67108863;
    }

    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (j & 255));
            i2++;
            j >>= 8;
        }
    }

    private static long zzd(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    static byte[] zze(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long zza = zza(bArr3, 0, 0) & 67108863;
        int i = 2;
        int i2 = 3;
        long zza2 = zza(bArr3, 3, 2) & 67108611;
        long zza3 = zza(bArr3, 6, 4) & 67092735;
        long zza4 = zza(bArr3, 9, 6) & 66076671;
        long zza5 = zza(bArr3, 12, 8) & 1048575;
        long j = zza2 * 5;
        long j2 = zza3 * 5;
        long j3 = zza4 * 5;
        long j4 = zza5 * 5;
        byte[] bArr5 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i3 = 0;
        while (i3 < bArr4.length) {
            int min = Math.min(16, bArr4.length - i3);
            System.arraycopy(bArr4, i3, bArr5, 0, min);
            bArr5[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr5, min + 1, 17, (byte) 0);
            }
            long zza6 = j9 + zza(bArr5, 0, 0);
            long zza7 = j5 + zza(bArr5, i2, i);
            long zza8 = j6 + zza(bArr5, 6, 4);
            long zza9 = j7 + zza(bArr5, 9, 6);
            long zza10 = j8 + (zza(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
            long j10 = (zza6 * zza) + (zza7 * j4) + (zza8 * j3) + (zza9 * j2) + (zza10 * j);
            long j11 = (zza6 * zza2) + (zza7 * zza) + (zza8 * j4) + (zza9 * j3) + (zza10 * j2);
            long j12 = (zza6 * zza3) + (zza7 * zza2) + (zza8 * zza) + (zza9 * j4) + (zza10 * j3);
            long j13 = (zza6 * zza4) + (zza7 * zza3) + (zza8 * zza2) + (zza9 * zza) + (zza10 * j4);
            long j14 = (zza6 * zza5) + (zza7 * zza4) + (zza8 * zza3) + (zza9 * zza2) + (zza10 * zza);
            long j15 = j10 & 67108863;
            long j16 = j11 + (j10 >> 26);
            long j17 = j16 & 67108863;
            long j18 = j12 + (j16 >> 26);
            long j19 = j18 & 67108863;
            long j20 = j13 + (j18 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j14 + (j20 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j15 + ((j22 >> 26) * 5);
            long j25 = j24 & 67108863;
            long j26 = j17 + (j24 >> 26);
            i3 += 16;
            j8 = j23;
            j6 = j19;
            i = 2;
            i2 = 3;
            j9 = j25;
            j5 = j26;
            j7 = j21;
        }
        long j27 = j6 + (j5 >> 26);
        long j28 = j27 & 67108863;
        long j29 = j7 + (j27 >> 26);
        long j30 = j29 & 67108863;
        long j31 = j8 + (j29 >> 26);
        long j32 = j31 & 67108863;
        long j33 = j9 + ((j31 >> 26) * 5);
        long j34 = j33 & 67108863;
        long j35 = (j5 & 67108863) + (j33 >> 26);
        long j36 = j34 + 5;
        long j37 = j36 & 67108863;
        long j38 = j35 + (j36 >> 26);
        long j39 = j38 & 67108863;
        long j40 = j28 + (j38 >> 26);
        long j41 = j40 & 67108863;
        long j42 = j30 + (j40 >> 26);
        long j43 = j42 & 67108863;
        long j44 = (j32 + (j42 >> 26)) - 67108864;
        long j45 = j44 >> 63;
        long j46 = j34 & j45;
        long j47 = j35 & j45;
        long j48 = j28 & j45;
        long j49 = j30 & j45;
        long j50 = j32 & j45;
        long j51 = j45 ^ -1;
        long j52 = j46 | (j37 & j51);
        long j53 = j47 | (j39 & j51);
        long j54 = j48 | (j41 & j51);
        long j55 = j49 | (j43 & j51);
        long j56 = j50 | (j44 & j51);
        long j57 = (j52 | (j53 << 26)) & 4294967295L;
        long j58 = ((j53 >> 6) | (j54 << 20)) & 4294967295L;
        long j59 = ((j54 >> 12) | (j55 << 14)) & 4294967295L;
        long zzd = j57 + zzd(bArr3, 16);
        long zzd2 = j58 + zzd(bArr3, 20) + (zzd >> 32);
        long zzd3 = j59 + zzd(bArr3, 24) + (zzd2 >> 32);
        byte[] bArr6 = new byte[16];
        zza(bArr6, zzd & 4294967295L, 0);
        zza(bArr6, zzd2 & 4294967295L, 4);
        zza(bArr6, zzd3 & 4294967295L, 8);
        zza(bArr6, ((((j55 >> 18) | (j56 << 8)) & 4294967295L) + zzd(bArr3, 28) + (zzd3 >> 32)) & 4294967295L, 12);
        return bArr6;
    }
}
