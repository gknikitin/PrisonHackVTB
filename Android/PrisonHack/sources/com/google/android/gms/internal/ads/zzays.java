package com.google.android.gms.internal.ads;

public final class zzays {
    private final zzazh zzdnk;
    private final zzazh zzdnl;

    public zzays(byte[] bArr, byte[] bArr2) {
        this.zzdnk = zzazh.zzm(bArr);
        this.zzdnl = zzazh.zzm(bArr2);
    }

    public final byte[] zzaap() {
        if (this.zzdnk == null) {
            return null;
        }
        return this.zzdnk.getBytes();
    }

    public final byte[] zzaaq() {
        if (this.zzdnl == null) {
            return null;
        }
        return this.zzdnl.getBytes();
    }
}
