package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

@zzadh
public final class zzzc {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (zzzd.zzbvg[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest zza(zzjj zzjj, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzjj.zzapy != null ? new HashSet(zzjj.zzapy) : null;
        Date date = new Date(zzjj.zzapw);
        switch (zzjj.zzapx) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzjj.zzaqe);
    }
}
