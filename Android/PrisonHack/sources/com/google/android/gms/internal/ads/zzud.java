package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
final class zzud {
    private static final zzua zzbpe = zzua.zzlk();
    private static final float zzbpf = ((Float) zzkb.zzik().zzd(zznk.zzazk)).floatValue();
    private static final long zzbpg = ((Long) zzkb.zzik().zzd(zznk.zzazi)).longValue();
    private static final float zzbph = ((Float) zzkb.zzik().zzd(zznk.zzazl)).floatValue();
    private static final long zzbpi = ((Long) zzkb.zzik().zzd(zznk.zzazj)).longValue();

    @VisibleForTesting
    private static int zzb(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }

    static boolean zzlv() {
        int zzlr = zzbpe.zzlr();
        int zzls = zzbpe.zzls();
        int zzlq = zzbpe.zzlq() + zzbpe.zzlp();
        int i = Integer.MAX_VALUE;
        if (zzls > ((zzlr >= 16 || zzbpi == 0) ? zzbph != 0.0f ? ((int) (zzbph * ((float) zzlr))) + 1 : Integer.MAX_VALUE : zzb(zzbpi, zzlr))) {
            return false;
        }
        if (zzlr < 16 && zzbpg != 0) {
            i = zzb(zzbpg, zzlr);
        } else if (zzbpf != 0.0f) {
            i = (int) (zzbpf * ((float) zzlr));
        }
        return zzlq <= i;
    }
}
