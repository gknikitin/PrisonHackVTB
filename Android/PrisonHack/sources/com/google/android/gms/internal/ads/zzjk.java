package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class zzjk {
    private Bundle mExtras;
    private long zzaqm;
    private int zzaqn;
    private List<String> zzaqo;
    private boolean zzaqp;
    private int zzaqq;
    private String zzaqr;
    private zzmq zzaqs;
    private String zzaqt;
    private Bundle zzaqu;
    private Bundle zzaqv;
    private List<String> zzaqw;
    private String zzaqx;
    private String zzaqy;
    private boolean zzaqz;
    private Location zzhp;
    private boolean zzvm;

    public zzjk() {
        this.zzaqm = -1;
        this.mExtras = new Bundle();
        this.zzaqn = -1;
        this.zzaqo = new ArrayList();
        this.zzaqp = false;
        this.zzaqq = -1;
        this.zzvm = false;
        this.zzaqr = null;
        this.zzaqs = null;
        this.zzhp = null;
        this.zzaqt = null;
        this.zzaqu = new Bundle();
        this.zzaqv = new Bundle();
        this.zzaqw = new ArrayList();
        this.zzaqx = null;
        this.zzaqy = null;
        this.zzaqz = false;
    }

    public zzjk(zzjj zzjj) {
        this.zzaqm = zzjj.zzapw;
        this.mExtras = zzjj.extras;
        this.zzaqn = zzjj.zzapx;
        this.zzaqo = zzjj.zzapy;
        this.zzaqp = zzjj.zzapz;
        this.zzaqq = zzjj.zzaqa;
        this.zzvm = zzjj.zzaqb;
        this.zzaqr = zzjj.zzaqc;
        this.zzaqs = zzjj.zzaqd;
        this.zzhp = zzjj.zzaqe;
        this.zzaqt = zzjj.zzaqf;
        this.zzaqu = zzjj.zzaqg;
        this.zzaqv = zzjj.zzaqh;
        this.zzaqw = zzjj.zzaqi;
        this.zzaqx = zzjj.zzaqj;
        this.zzaqy = zzjj.zzaqk;
    }

    public final zzjk zza(@Nullable Location location) {
        this.zzhp = null;
        return this;
    }

    public final zzjj zzhw() {
        long j = this.zzaqm;
        Bundle bundle = this.mExtras;
        int i = this.zzaqn;
        List<String> list = this.zzaqo;
        boolean z = this.zzaqp;
        int i2 = this.zzaqq;
        boolean z2 = this.zzvm;
        String str = this.zzaqr;
        zzmq zzmq = this.zzaqs;
        Location location = this.zzhp;
        String str2 = this.zzaqt;
        Bundle bundle2 = this.zzaqu;
        Bundle bundle3 = this.zzaqv;
        return new zzjj(7, j, bundle, i, list, z, i2, z2, str, zzmq, location, str2, bundle2, bundle3, this.zzaqw, this.zzaqx, this.zzaqy, false);
    }
}
