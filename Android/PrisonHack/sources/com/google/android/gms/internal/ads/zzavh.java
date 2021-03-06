package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzavh {
    public static zzayv zza(zzawy zzawy) throws GeneralSecurityException {
        switch (zzavi.zzdia[zzawy.ordinal()]) {
            case 1:
                return zzayv.NIST_P256;
            case 2:
                return zzayv.NIST_P384;
            case 3:
                return zzayv.NIST_P521;
            default:
                String valueOf = String.valueOf(zzawy);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static zzayw zza(zzawk zzawk) throws GeneralSecurityException {
        switch (zzavi.zzdib[zzawk.ordinal()]) {
            case 1:
                return zzayw.UNCOMPRESSED;
            case 2:
                return zzayw.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzawk);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static String zza(zzaxa zzaxa) throws NoSuchAlgorithmException {
        switch (zzavi.zzdhz[zzaxa.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzaxa);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static void zza(zzawq zzawq) throws GeneralSecurityException {
        zzayt.zza(zza(zzawq.zzxu().zzyh()));
        zza(zzawq.zzxu().zzyi());
        if (zzawq.zzxw() == zzawk.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzauo.zza(zzawq.zzxv().zzxp());
    }
}
