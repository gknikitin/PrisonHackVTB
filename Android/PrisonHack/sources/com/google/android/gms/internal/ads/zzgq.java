package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public abstract class zzgq {
    @Nullable
    private static MessageDigest zzaix;
    protected Object mLock = new Object();

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzhg() {
        synchronized (this.mLock) {
            if (zzaix != null) {
                MessageDigest messageDigest = zzaix;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzaix = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzaix;
            return messageDigest2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zzx(String str);
}
