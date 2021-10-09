package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbv;
import java.util.concurrent.TimeUnit;

@zzadh
public final class zzapx {
    private final Context mContext;
    private final String zzchp;
    @Nullable
    private final zznx zzcxo;
    private boolean zzcxs;
    @Nullable
    private final zznv zzdad;
    private final zzalp zzdae = new zzals().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzrz();
    private final long[] zzdaf;
    private final String[] zzdag;
    private boolean zzdah;
    private boolean zzdai;
    private boolean zzdaj;
    private boolean zzdak;
    private zzapg zzdal;
    private boolean zzdam;
    private boolean zzdan;
    private long zzdao;
    private final zzang zzzw;

    public zzapx(Context context, zzang zzang, String str, @Nullable zznx zznx, @Nullable zznv zznv) {
        this.zzdah = false;
        this.zzdai = false;
        this.zzdaj = false;
        this.zzdak = false;
        this.zzdao = -1;
        this.mContext = context;
        this.zzzw = zzang;
        this.zzchp = str;
        this.zzcxo = zznx;
        this.zzdad = zznv;
        String str2 = (String) zzkb.zzik().zzd(zznk.zzave);
        if (str2 == null) {
            this.zzdag = new String[0];
            this.zzdaf = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzdag = new String[split.length];
        this.zzdaf = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzdaf[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzakb.zzc("Unable to parse frame hash target time number.", e);
                this.zzdaf[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (((Boolean) zzkb.zzik().zzd(zznk.zzavd)).booleanValue() && !this.zzdam) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzchp);
            bundle.putString("player", this.zzdal.zzsp());
            for (zzalr next : this.zzdae.zzry()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(next.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(next.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(next.zzctb));
            }
            for (int i = 0; i < this.zzdaf.length; i++) {
                String str = this.zzdag[i];
                if (str != null) {
                    String valueOf5 = String.valueOf(Long.valueOf(this.zzdaf[i]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf5);
                    bundle.putString(sb.toString(), str);
                }
            }
            zzbv.zzek().zza(this.mContext, this.zzzw.zzcw, "gmob-apps", bundle, true);
            this.zzdam = true;
        }
    }

    public final void zzb(zzapg zzapg) {
        zznq.zza(this.zzcxo, this.zzdad, "vpc2");
        this.zzdah = true;
        if (this.zzcxo != null) {
            this.zzcxo.zze("vpn", zzapg.zzsp());
        }
        this.zzdal = zzapg;
    }

    public final void zzc(zzapg zzapg) {
        if (this.zzdaj && !this.zzdak) {
            if (zzakb.zzqp() && !this.zzdak) {
                zzakb.m39v("VideoMetricsMixin first frame");
            }
            zznq.zza(this.zzcxo, this.zzdad, "vff2");
            this.zzdak = true;
        }
        long nanoTime = zzbv.zzer().nanoTime();
        if (this.zzcxs && this.zzdan && this.zzdao != -1) {
            this.zzdae.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzdao)));
        }
        this.zzdan = this.zzcxs;
        this.zzdao = nanoTime;
        long longValue = ((Long) zzkb.zzik().zzd(zznk.zzavf)).longValue();
        long currentPosition = (long) zzapg.getCurrentPosition();
        int i = 0;
        while (i < this.zzdag.length) {
            if (this.zzdag[i] != null || longValue <= Math.abs(currentPosition - this.zzdaf[i])) {
                zzapg zzapg2 = zzapg;
                i++;
            } else {
                String[] strArr = this.zzdag;
                int i2 = 8;
                Bitmap bitmap = zzapg.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        long j4 = j2 | (((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3));
                        i4++;
                        j3--;
                        j2 = j4;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzsv() {
        if (this.zzdah && !this.zzdai) {
            zznq.zza(this.zzcxo, this.zzdad, "vfr2");
            this.zzdai = true;
        }
    }

    public final void zztt() {
        this.zzcxs = true;
        if (this.zzdai && !this.zzdaj) {
            zznq.zza(this.zzcxo, this.zzdad, "vfp2");
            this.zzdaj = true;
        }
    }

    public final void zztu() {
        this.zzcxs = false;
    }
}
