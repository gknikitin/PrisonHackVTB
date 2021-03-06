package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzayi implements zzatz {
    private final SecretKeySpec zzdmu;
    private final byte[] zzdmx;
    private final byte[] zzdmy;
    private final int zzdmz;

    public zzayi(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzdmz = i;
            this.zzdmu = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.zzdmu);
            this.zzdmx = zzl(instance.doFinal(new byte[16]));
            this.zzdmy = zzl(this.zzdmx);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] zzd;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            zzd = zzd(bArr3, this.zzdmx);
        } else {
            byte[] doFinal = cipher.doFinal(bArr3);
            byte[] bArr4 = doFinal;
            int i4 = 0;
            while (i3 - i4 > 16) {
                for (int i5 = 0; i5 < 16; i5++) {
                    bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
                }
                bArr4 = cipher.doFinal(bArr4);
                i4 += 16;
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
            if (copyOfRange.length == 16) {
                bArr2 = zzd(copyOfRange, this.zzdmx);
            } else {
                byte[] copyOf = Arrays.copyOf(this.zzdmy, 16);
                for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                    copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
                }
                copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
                bArr2 = copyOf;
            }
            zzd = zzd(bArr4, bArr2);
        }
        return cipher.doFinal(zzd);
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzl(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        if (bArr3.length > (Integer.MAX_VALUE - this.zzdmz) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[(this.zzdmz + bArr3.length + 16)];
        byte[] zzbh = zzazl.zzbh(this.zzdmz);
        System.arraycopy(zzbh, 0, bArr4, 0, this.zzdmz);
        Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
        instance.init(1, this.zzdmu);
        byte[] zza = zza(instance, 0, zzbh, 0, zzbh.length);
        byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
        byte[] zza2 = zza(instance, 1, bArr5, 0, bArr5.length);
        Cipher instance2 = Cipher.getInstance("AES/CTR/NOPADDING");
        instance2.init(1, this.zzdmu, new IvParameterSpec(zza));
        instance2.doFinal(bArr3, 0, bArr3.length, bArr4, this.zzdmz);
        byte[] zza3 = zza(instance, 2, bArr4, this.zzdmz, bArr3.length);
        int length = bArr3.length + this.zzdmz;
        for (int i = 0; i < 16; i++) {
            bArr4[length + i] = (byte) ((zza2[i] ^ zza[i]) ^ zza3[i]);
        }
        return bArr4;
    }
}
