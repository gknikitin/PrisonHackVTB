package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzayh implements zzazi {
    private final SecretKeySpec zzdmu;
    private final int zzdmv;
    private final int zzdmw = zzayy.zzdnz.zzek("AES/CTR/NoPadding").getBlockSize();

    public zzayh(byte[] bArr, int i) throws GeneralSecurityException {
        this.zzdmu = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzdmw) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzdmv = i;
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - this.zzdmv) {
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(Integer.MAX_VALUE - this.zzdmv);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[(this.zzdmv + bArr.length)];
        byte[] zzbh = zzazl.zzbh(this.zzdmv);
        System.arraycopy(zzbh, 0, bArr2, 0, this.zzdmv);
        int length = bArr.length;
        int i = this.zzdmv;
        Cipher zzek = zzayy.zzdnz.zzek("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.zzdmw];
        System.arraycopy(zzbh, 0, bArr3, 0, this.zzdmv);
        zzek.init(1, this.zzdmu, new IvParameterSpec(bArr3));
        if (zzek.doFinal(bArr, 0, length, bArr2, i) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
