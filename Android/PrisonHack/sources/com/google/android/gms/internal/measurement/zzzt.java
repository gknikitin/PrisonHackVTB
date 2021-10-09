package com.google.android.gms.internal.measurement;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzzt {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final byte[] zzbta;
    private static final ByteBuffer zzbtb;
    private static final zzzg zzbtc;

    static {
        byte[] bArr = new byte[0];
        zzbta = bArr;
        zzbtb = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzbta;
        zzbtc = zzzg.zza(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
