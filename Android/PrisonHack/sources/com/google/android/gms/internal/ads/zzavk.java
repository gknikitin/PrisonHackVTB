package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzavk implements zzaug<zzauk> {
    zzavk() {
    }

    private static void zza(zzaxg zzaxg) throws GeneralSecurityException {
        if (zzaxg.zzyt() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzavl.zzdhz[zzaxg.zzys().ordinal()]) {
            case 1:
                if (zzaxg.zzyt() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 2:
                if (zzaxg.zzyt() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 3:
                if (zzaxg.zzyt() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzh */
    public final zzauk zza(zzbah zzbah) throws GeneralSecurityException {
        zzazj zzazj;
        try {
            zzaxc zzae = zzaxc.zzae(zzbah);
            if (!(zzae instanceof zzaxc)) {
                throw new GeneralSecurityException("expected HmacKey proto");
            }
            zzaxc zzaxc = zzae;
            zzazq.zzj(zzaxc.getVersion(), 0);
            if (zzaxc.zzwv().size() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            zza(zzaxc.zzym());
            zzaxa zzys = zzaxc.zzym().zzys();
            SecretKeySpec secretKeySpec = new SecretKeySpec(zzaxc.zzwv().toByteArray(), "HMAC");
            int zzyt = zzaxc.zzym().zzyt();
            switch (zzavl.zzdhz[zzys.ordinal()]) {
                case 1:
                    zzazj = new zzazj("HMACSHA1", secretKeySpec, zzyt);
                    break;
                case 2:
                    zzazj = new zzazj("HMACSHA256", secretKeySpec, zzyt);
                    break;
                case 3:
                    zzazj = new zzazj("HMACSHA512", secretKeySpec, zzyt);
                    break;
                default:
                    throw new GeneralSecurityException("unknown hash");
            }
            return zzazj;
        } catch (zzbbu e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final /* synthetic */ Object zza(zzbcu zzbcu) throws GeneralSecurityException {
        if (!(zzbcu instanceof zzaxc)) {
            throw new GeneralSecurityException("expected HmacKey proto");
        }
        zzaxc zzaxc = (zzaxc) zzbcu;
        zzazq.zzj(zzaxc.getVersion(), 0);
        if (zzaxc.zzwv().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzaxc.zzym());
        zzaxa zzys = zzaxc.zzym().zzys();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzaxc.zzwv().toByteArray(), "HMAC");
        int zzyt = zzaxc.zzym().zzyt();
        switch (zzavl.zzdhz[zzys.ordinal()]) {
            case 1:
                return new zzazj("HMACSHA1", secretKeySpec, zzyt);
            case 2:
                return new zzazj("HMACSHA256", secretKeySpec, zzyt);
            case 3:
                return new zzazj("HMACSHA512", secretKeySpec, zzyt);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }

    public final zzbcu zzb(zzbah zzbah) throws GeneralSecurityException {
        try {
            return zzb((zzbcu) zzaxe.zzag(zzbah));
        } catch (zzbbu e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) throws GeneralSecurityException {
        if (!(zzbcu instanceof zzaxe)) {
            throw new GeneralSecurityException("expected HmacKeyFormat proto");
        }
        zzaxe zzaxe = (zzaxe) zzbcu;
        if (zzaxe.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzaxe.zzym());
        return zzaxc.zzyn().zzav(0).zzc(zzaxe.zzym()).zzaf(zzbah.zzo(zzazl.zzbh(zzaxe.getKeySize()))).zzadi();
    }

    public final zzaxi zzc(zzbah zzbah) throws GeneralSecurityException {
        return (zzaxi) zzaxi.zzyz().zzeb("type.googleapis.com/google.crypto.tink.HmacKey").zzai(((zzaxc) zzb(zzbah)).zzaav()).zzb(zzaxi.zzb.SYMMETRIC).zzadi();
    }
}
