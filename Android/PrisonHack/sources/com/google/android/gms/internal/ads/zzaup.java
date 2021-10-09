package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxr;
import com.google.android.gms.internal.ads.zzaxt;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class zzaup {
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);

    public static zzaxt zzb(zzaxr zzaxr) {
        zzaxt.zza zzbb = zzaxt.zzzu().zzbb(zzaxr.zzzk());
        for (zzaxr.zzb next : zzaxr.zzzl()) {
            zzbb.zzb((zzaxt.zzb) zzaxt.zzb.zzzw().zzeh(next.zzzp().zzyw()).zzb(next.zzzq()).zzb(next.zzzs()).zzbd(next.zzzr()).zzadi());
        }
        return (zzaxt) zzbb.zzadi();
    }

    public static void zzc(zzaxr zzaxr) throws GeneralSecurityException {
        if (zzaxr.zzzm() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int zzzk = zzaxr.zzzk();
        boolean z = false;
        boolean z2 = true;
        for (zzaxr.zzb next : zzaxr.zzzl()) {
            if (!next.zzzo()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzzr())}));
            } else if (next.zzzs() == zzayd.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzzr())}));
            } else if (next.zzzq() == zzaxl.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzzr())}));
            } else {
                if (next.zzzq() == zzaxl.ENABLED && next.zzzr() == zzzk) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (next.zzzp().zzyy() != zzaxi.zzb.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
            }
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
