package com.google.android.gms.internal.measurement;

final class zzaar<T> implements zzaax<T> {
    private final zzaan zzbtu;
    private final zzabl<?, ?> zzbtv;
    private final boolean zzbtw;
    private final zzzl<?> zzbtx;

    private zzaar(zzabl<?, ?> zzabl, zzzl<?> zzzl, zzaan zzaan) {
        this.zzbtv = zzabl;
        this.zzbtw = zzzl.zza(zzaan);
        this.zzbtx = zzzl;
        this.zzbtu = zzaan;
    }

    static <T> zzaar<T> zza(zzabl<?, ?> zzabl, zzzl<?> zzzl, zzaan zzaan) {
        return new zzaar<>(zzabl, zzzl, zzaan);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzbtv.zzu(t).equals(this.zzbtv.zzu(t2))) {
            return false;
        }
        if (this.zzbtw) {
            return this.zzbtx.zzs(t).equals(this.zzbtx.zzs(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzbtv.zzu(t).hashCode();
        return this.zzbtw ? (hashCode * 53) + this.zzbtx.zzs(t).hashCode() : hashCode;
    }
}
