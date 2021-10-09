package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzfs extends zzhi {
    @VisibleForTesting
    static final Pair<String, Long> zzakb = new Pair<>("", 0L);
    private SharedPreferences zzabf;
    public zzfw zzakc;
    public final zzfv zzakd = new zzfv(this, "last_upload", 0);
    public final zzfv zzake = new zzfv(this, "last_upload_attempt", 0);
    public final zzfv zzakf = new zzfv(this, "backoff", 0);
    public final zzfv zzakg = new zzfv(this, "last_delete_stale", 0);
    public final zzfv zzakh = new zzfv(this, "midnight_offset", 0);
    public final zzfv zzaki = new zzfv(this, "first_open_time", 0);
    public final zzfv zzakj = new zzfv(this, "app_install_time", 0);
    public final zzfx zzakk = new zzfx(this, "app_instance_id", (String) null);
    private String zzakl;
    private boolean zzakm;
    private long zzakn;
    private String zzako;
    private long zzakp;
    private final Object zzakq = new Object();
    public final zzfv zzakr = new zzfv(this, "time_before_start", 10000);
    public final zzfv zzaks = new zzfv(this, "session_timeout", 1800000);
    public final zzfu zzakt = new zzfu(this, "start_new_session", true);
    public final zzfv zzaku = new zzfv(this, "last_pause_time", 0);
    public final zzfv zzakv = new zzfv(this, "time_active", 0);
    public boolean zzakw;

    zzfs(zzgm zzgm) {
        super(zzgm);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzjf() {
        zzab();
        zzch();
        return this.zzabf;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        zzab();
        zzgf().zziz().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzjf().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zzbn(String str) {
        zzab();
        long elapsedRealtime = zzbt().elapsedRealtime();
        if (this.zzakl != null && elapsedRealtime < this.zzakn) {
            return new Pair<>(this.zzakl, Boolean.valueOf(this.zzakm));
        }
        this.zzakn = elapsedRealtime + zzgh().zza(str, zzey.zzagq);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzakl = advertisingIdInfo.getId();
                this.zzakm = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzakl == null) {
                this.zzakl = "";
            }
        } catch (Exception e) {
            zzgf().zziy().zzg("Unable to get advertising id", e);
            this.zzakl = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzakl, Boolean.valueOf(this.zzakm));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzbo(String str) {
        zzab();
        String str2 = (String) zzbn(str).first;
        MessageDigest messageDigest = zzkc.getMessageDigest("MD5");
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, messageDigest.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzbp(String str) {
        zzab();
        SharedPreferences.Editor edit = zzjf().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzbq(String str) {
        synchronized (this.zzakq) {
            this.zzako = str;
            this.zzakp = zzbt().elapsedRealtime();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzf(boolean z) {
        zzab();
        zzgf().zziz().zzg("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzjf().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzg(boolean z) {
        zzab();
        return zzjf().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzh(boolean z) {
        zzab();
        zzgf().zziz().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzjf().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhh() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzin() {
        this.zzabf = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzakw = this.zzabf.getBoolean("has_been_opened", false);
        if (!this.zzakw) {
            SharedPreferences.Editor edit = this.zzabf.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzakc = new zzfw(this, "health_monitor", Math.max(0, zzey.zzagr.get().longValue()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzjg() {
        zzab();
        return zzjf().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final String zzjh() {
        synchronized (this.zzakq) {
            if (Math.abs(zzbt().elapsedRealtime() - this.zzakp) >= 1000) {
                return null;
            }
            String str = this.zzako;
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzji() {
        zzab();
        if (!zzjf().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzjf().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzjj() {
        zzab();
        zzgf().zziz().log("Clearing collection preferences.");
        boolean contains = zzjf().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzg(true);
        }
        SharedPreferences.Editor edit = zzjf().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzjk() {
        zzab();
        String string = zzjf().getString("previous_os_version", (String) null);
        zzfx().zzch();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzjf().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzjl() {
        zzab();
        return zzjf().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzjm() {
        return this.zzabf.contains("deferred_analytics_collection");
    }
}
