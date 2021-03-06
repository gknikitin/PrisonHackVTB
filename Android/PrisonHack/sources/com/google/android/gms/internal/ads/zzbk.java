package com.google.android.gms.internal.ads;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzbk {
    private static boolean zzhy = false;
    /* access modifiers changed from: private */
    public static MessageDigest zzhz;
    private static final Object zzia = new Object();
    private static final Object zzib = new Object();
    static CountDownLatch zzic = new CountDownLatch(1);

    static String zza(zzba zzba, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] zzb = zzbfi.zzb(zzba);
        if (((Boolean) zzkb.zzik().zzd(zznk.zzbay)).booleanValue()) {
            Vector<byte[]> zza = zza(zzb, 255);
            if (zza == null || zza.size() == 0) {
                bArr = zza(zzbfi.zzb(zzc(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str, true);
            } else {
                zzbg zzbg = new zzbg();
                zzbg.zzgv = new byte[zza.size()][];
                Iterator<byte[]> it = zza.iterator();
                int i = 0;
                while (it.hasNext()) {
                    zzbg.zzgv[i] = zza(it.next(), str, false);
                    i++;
                }
                zzbg.zzgq = zzb(zzb);
                bArr = zzbfi.zzb(zzbg);
            }
        } else if (zzde.zzso == null) {
            throw new GeneralSecurityException();
        } else {
            byte[] zzc = zzde.zzso.zzc(zzb, str != null ? str.getBytes() : new byte[0]);
            zzbg zzbg2 = new zzbg();
            zzbg2.zzgv = new byte[][]{zzc};
            zzbg2.zzfe = 2;
            bArr = zzbfi.zzb(zzbg2);
        }
        return zzbi.zza(bArr, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ByteBuffer put;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zzbfi.zzb(zzc(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        byte[] array = put.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzbp zza : new zzbn().zzpq) {
            zza.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzazx(str.getBytes(Key.STRING_CHARSET_NAME)).zzn(bArr3);
        }
        return bArr3;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzia) {
            MessageDigest zzw = zzw();
            if (zzw == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzw.reset();
            zzw.update(bArr);
            digest = zzhz.digest();
        }
        return digest;
    }

    private static zzba zzc(long j) {
        zzba zzba = new zzba();
        zzba.zzdu = Long.valueOf(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return zzba;
    }

    static void zzv() {
        synchronized (zzib) {
            if (!zzhy) {
                zzhy = true;
                new Thread(new zzbm()).start();
            }
        }
    }

    private static MessageDigest zzw() {
        boolean z;
        zzv();
        try {
            z = zzic.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && zzhz != null) {
            return zzhz;
        }
        return null;
    }
}
