package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbo;

final class zzbcj implements zzbdn {
    private static final zzbct zzdvw = new zzbck();
    private final zzbct zzdvv;

    public zzbcj() {
        this(new zzbcl(zzbbn.zzadc(), zzaea()));
    }

    private zzbcj(zzbct zzbct) {
        this.zzdvv = (zzbct) zzbbq.zza(zzbct, "messageInfoFactory");
    }

    private static boolean zza(zzbcs zzbcs) {
        return zzbcs.zzaeh() == zzbbo.zze.zzdui;
    }

    private static zzbct zzaea() {
        try {
            return (zzbct) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzdvw;
        }
    }

    public final <T> zzbdm<T> zzd(Class<T> cls) {
        zzbdo.zzf(cls);
        zzbcs zzb = this.zzdvv.zzb(cls);
        if (zzb.zzaei()) {
            return zzbbo.class.isAssignableFrom(cls) ? zzbda.zza(zzbdo.zzafp(), zzbbf.zzact(), zzb.zzaej()) : zzbda.zza(zzbdo.zzafn(), zzbbf.zzacu(), zzb.zzaej());
        }
        if (zzbbo.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzbcy.zza(cls, zzb, zzbde.zzaem(), zzbce.zzadz(), zzbdo.zzafp(), zzbbf.zzact(), zzbcr.zzaef());
            }
            return zzbcy.zza(cls, zzb, zzbde.zzaem(), zzbce.zzadz(), zzbdo.zzafp(), (zzbbd<?>) null, zzbcr.zzaef());
        } else if (zza(zzb)) {
            return zzbcy.zza(cls, zzb, zzbde.zzael(), zzbce.zzady(), zzbdo.zzafn(), zzbbf.zzacu(), zzbcr.zzaee());
        } else {
            return zzbcy.zza(cls, zzb, zzbde.zzael(), zzbce.zzady(), zzbdo.zzafo(), (zzbbd<?>) null, zzbcr.zzaee());
        }
    }
}
