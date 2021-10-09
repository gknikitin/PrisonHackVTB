package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

final class zzt {
    private final KeyPair zzbk;
    /* access modifiers changed from: private */
    public final long zzbl;

    @VisibleForTesting
    zzt(KeyPair keyPair, long j) {
        this.zzbk = keyPair;
        this.zzbl = j;
    }

    /* access modifiers changed from: private */
    public final String zzp() {
        return Base64.encodeToString(this.zzbk.getPublic().getEncoded(), 11);
    }

    /* access modifiers changed from: private */
    public final String zzq() {
        return Base64.encodeToString(this.zzbk.getPrivate().getEncoded(), 11);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        return this.zzbl == zzt.zzbl && this.zzbk.getPublic().equals(zzt.zzbk.getPublic()) && this.zzbk.getPrivate().equals(zzt.zzbk.getPrivate());
    }

    /* access modifiers changed from: package-private */
    public final long getCreationTime() {
        return this.zzbl;
    }

    /* access modifiers changed from: package-private */
    public final KeyPair getKeyPair() {
        return this.zzbk;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbk.getPublic(), this.zzbk.getPrivate(), Long.valueOf(this.zzbl));
    }
}
