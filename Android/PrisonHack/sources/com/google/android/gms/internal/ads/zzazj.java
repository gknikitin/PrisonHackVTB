package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zzazj implements zzauk {
    private Mac zzdoj;
    private final int zzdok;
    private final String zzdol;
    private final Key zzdom;

    public zzazj(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1823053428) {
            if (hashCode != 392315118) {
                if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                    c = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c = 0;
        }
        switch (c) {
            case 0:
                if (i > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 1:
                if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 2:
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                String valueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
        }
        this.zzdol = str;
        this.zzdok = i;
        this.zzdom = key;
        this.zzdoj = zzayy.zzdoa.zzek(str);
        this.zzdoj.init(key);
    }

    public final byte[] zzg(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzdoj.clone();
        } catch (CloneNotSupportedException unused) {
            mac = zzayy.zzdoa.zzek(this.zzdol);
            mac.init(this.zzdom);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zzdok];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zzdok);
        return bArr2;
    }
}
