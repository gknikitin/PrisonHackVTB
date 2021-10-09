package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class zzap {
    public static zzc zzb(zzp zzp) {
        boolean z;
        long j;
        boolean z2;
        long j2;
        long j3;
        long j4;
        zzp zzp2 = zzp;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzp2.zzab;
        String str = map.get("Date");
        long zzf = str != null ? zzf(str) : 0;
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            j2 = 0;
            z2 = false;
            j = 0;
            for (String trim : split) {
                String trim2 = trim.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim2.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim2.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim2.substring(23));
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    z2 = true;
                }
            }
            z = true;
        } else {
            j2 = 0;
            z2 = false;
            j = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long zzf2 = str3 != null ? zzf(str3) : 0;
        String str4 = map.get("Last-Modified");
        long zzf3 = str4 != null ? zzf(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            long j5 = currentTimeMillis + (j2 * 1000);
            j4 = z2 ? j5 : j5 + (j * 1000);
            j3 = j5;
        } else if (zzf <= 0 || zzf2 < zzf) {
            j4 = 0;
            j3 = 0;
        } else {
            j3 = currentTimeMillis + (zzf2 - zzf);
            j4 = j3;
        }
        zzc zzc = new zzc();
        zzc.data = zzp2.data;
        zzc.zza = str5;
        zzc.zze = j3;
        zzc.zzd = j4;
        zzc.zzb = zzf;
        zzc.zzc = zzf3;
        zzc.zzf = map;
        zzc.zzg = zzp2.allHeaders;
        return zzc;
    }

    static String zzb(long j) {
        return zzp().format(new Date(j));
    }

    private static long zzf(String str) {
        try {
            return zzp().parse(str).getTime();
        } catch (ParseException e) {
            zzaf.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    private static SimpleDateFormat zzp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
