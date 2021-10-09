package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.support.annotation.WorkerThread;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
public final class zzey {
    static zzec zzagd;
    static List<zza<Integer>> zzage = new ArrayList();
    static List<zza<Long>> zzagf = new ArrayList();
    static List<zza<Boolean>> zzagg = new ArrayList();
    static List<zza<String>> zzagh = new ArrayList();
    static List<zza<Double>> zzagi = new ArrayList();
    /* access modifiers changed from: private */
    public static final zzxe zzagj;
    private static zza<Boolean> zzagk = zza.zzb("measurement.log_third_party_store_events_enabled", false, false);
    private static zza<Boolean> zzagl = zza.zzb("measurement.log_installs_enabled", false, false);
    private static zza<Boolean> zzagm = zza.zzb("measurement.log_upgrades_enabled", false, false);
    public static zza<Boolean> zzagn = zza.zzb("measurement.log_androidId_enabled", false, false);
    public static zza<Boolean> zzago = zza.zzb("measurement.upload_dsid_enabled", false, false);
    public static zza<String> zzagp = zza.zzd("measurement.log_tag", "FA", "FA-SVC");
    public static zza<Long> zzagq = zza.zzb("measurement.ad_id_cache_time", 10000, 10000);
    public static zza<Long> zzagr = zza.zzb("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static zza<Long> zzags = zza.zzb("measurement.config.cache_time", 86400000, 3600000);
    public static zza<String> zzagt = zza.zzd("measurement.config.url_scheme", "https", "https");
    public static zza<String> zzagu = zza.zzd("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
    public static zza<Integer> zzagv = zza.zzc("measurement.upload.max_bundles", 100, 100);
    public static zza<Integer> zzagw = zza.zzc("measurement.upload.max_batch_size", 65536, 65536);
    public static zza<Integer> zzagx = zza.zzc("measurement.upload.max_bundle_size", 65536, 65536);
    public static zza<Integer> zzagy = zza.zzc("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zza<Integer> zzagz = zza.zzc("measurement.upload.max_events_per_day", 100000, 100000);
    public static zza<Integer> zzaha = zza.zzc("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zza<Integer> zzahb = zza.zzc("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static zza<Integer> zzahc = zza.zzc("measurement.upload.max_conversions_per_day", 500, 500);
    public static zza<Integer> zzahd = zza.zzc("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zza<Integer> zzahe = zza.zzc("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static zza<String> zzahf = zza.zzd("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
    public static zza<Long> zzahg = zza.zzb("measurement.upload.backoff_period", 43200000, 43200000);
    public static zza<Long> zzahh = zza.zzb("measurement.upload.window_interval", 3600000, 3600000);
    public static zza<Long> zzahi = zza.zzb("measurement.upload.interval", 3600000, 3600000);
    public static zza<Long> zzahj = zza.zzb("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static zza<Long> zzahk = zza.zzb("measurement.upload.debug_upload_interval", 1000, 1000);
    public static zza<Long> zzahl = zza.zzb("measurement.upload.minimum_delay", 500, 500);
    public static zza<Long> zzahm = zza.zzb("measurement.alarm_manager.minimum_interval", 60000, 60000);
    public static zza<Long> zzahn = zza.zzb("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static zza<Long> zzaho = zza.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static zza<Long> zzahp = zza.zzb("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static zza<Long> zzahq = zza.zzb("measurement.upload.retry_time", 1800000, 1800000);
    public static zza<Integer> zzahr = zza.zzc("measurement.upload.retry_count", 6, 6);
    public static zza<Long> zzahs = zza.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zza<Integer> zzaht = zza.zzc("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zza<Integer> zzahu = zza.zzc("measurement.audience.filter_result_max_count", ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    public static zza<Long> zzahv = zza.zzb("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    public static zza<Boolean> zzahw = zza.zzb("measurement.test.boolean_flag", false, false);
    public static zza<String> zzahx = zza.zzd("measurement.test.string_flag", "---", "---");
    public static zza<Long> zzahy = zza.zzb("measurement.test.long_flag", -1, -1);
    public static zza<Integer> zzahz = zza.zzc("measurement.test.int_flag", -2, -2);
    public static zza<Double> zzaia = zza.zza("measurement.test.double_flag", -3.0d, -3.0d);
    public static zza<Boolean> zzaib = zza.zzb("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
    public static zza<Boolean> zzaic = zza.zzb("measurement.audience.complex_param_evaluation", false, false);
    public static zza<Boolean> zzaid = zza.zzb("measurement.validation.internal_limits_internal_event_params", false, false);
    public static zza<Boolean> zzaie = zza.zzb("measurement.quality.unsuccessful_update_retry_counter", false, false);
    public static zza<Boolean> zzaif = zza.zzb("measurement.iid.disable_on_collection_disabled", true, true);
    public static zza<Boolean> zzaig = zza.zzb("measurement.app_launch.call_only_when_enabled", true, true);
    public static zza<Boolean> zzaih = zza.zzb("measurement.run_on_worker_inline", true, false);
    private static zza<Boolean> zzaii = zza.zzb("measurement.audience.dynamic_filters", false, false);
    public static zza<Boolean> zzaij = zza.zzb("measurement.reset_analytics.persist_time", false, false);

    @VisibleForTesting
    public static final class zza<V> {
        private final V zzaab;
        private zzwu<V> zzaik;
        private final V zzail;
        private volatile V zzaim;
        private final String zzny;

        private zza(String str, V v, V v2) {
            this.zzny = str;
            this.zzaab = v;
            this.zzail = v2;
        }

        static zza<Double> zza(String str, double d, double d2) {
            zza<Double> zza = new zza<>(str, Double.valueOf(-3.0d), Double.valueOf(-3.0d));
            zzey.zzagi.add(zza);
            return zza;
        }

        static zza<Long> zzb(String str, long j, long j2) {
            zza<Long> zza = new zza<>(str, Long.valueOf(j), Long.valueOf(j2));
            zzey.zzagf.add(zza);
            return zza;
        }

        static zza<Boolean> zzb(String str, boolean z, boolean z2) {
            zza<Boolean> zza = new zza<>(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            zzey.zzagg.add(zza);
            return zza;
        }

        static zza<Integer> zzc(String str, int i, int i2) {
            zza<Integer> zza = new zza<>(str, Integer.valueOf(i), Integer.valueOf(i2));
            zzey.zzage.add(zza);
            return zza;
        }

        static zza<String> zzd(String str, String str2, String str3) {
            zza<String> zza = new zza<>(str, str2, str3);
            zzey.zzagh.add(zza);
            return zza;
        }

        @WorkerThread
        private static void zzil() {
            synchronized (zza.class) {
                if (!zzec.isMainThread()) {
                    zzec zzec = zzey.zzagd;
                    for (zza next : zzey.zzagg) {
                        next.zzaim = next.zzaik.get();
                    }
                    for (zza next2 : zzey.zzagh) {
                        next2.zzaim = next2.zzaik.get();
                    }
                    for (zza next3 : zzey.zzagf) {
                        next3.zzaim = next3.zzaik.get();
                    }
                    for (zza next4 : zzey.zzage) {
                        next4.zzaim = next4.zzaik.get();
                    }
                    for (zza next5 : zzey.zzagi) {
                        next5.zzaim = next5.zzaik.get();
                    }
                } else {
                    throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
                }
            }
        }

        /* access modifiers changed from: private */
        public static void zzm() {
            synchronized (zza.class) {
                for (zza next : zzey.zzagg) {
                    zzxe zzik = zzey.zzagj;
                    String str = next.zzny;
                    zzec zzec = zzey.zzagd;
                    next.zzaik = zzik.zzf(str, ((Boolean) next.zzaab).booleanValue());
                }
                for (zza next2 : zzey.zzagh) {
                    zzxe zzik2 = zzey.zzagj;
                    String str2 = next2.zzny;
                    zzec zzec2 = zzey.zzagd;
                    next2.zzaik = zzik2.zzv(str2, (String) next2.zzaab);
                }
                for (zza next3 : zzey.zzagf) {
                    zzxe zzik3 = zzey.zzagj;
                    String str3 = next3.zzny;
                    zzec zzec3 = zzey.zzagd;
                    next3.zzaik = zzik3.zze(str3, ((Long) next3.zzaab).longValue());
                }
                for (zza next4 : zzey.zzage) {
                    zzxe zzik4 = zzey.zzagj;
                    String str4 = next4.zzny;
                    zzec zzec4 = zzey.zzagd;
                    next4.zzaik = zzik4.zzd(str4, ((Integer) next4.zzaab).intValue());
                }
                for (zza next5 : zzey.zzagi) {
                    zzxe zzik5 = zzey.zzagj;
                    String str5 = next5.zzny;
                    zzec zzec5 = zzey.zzagd;
                    next5.zzaik = zzik5.zzb(str5, ((Double) next5.zzaab).doubleValue());
                }
            }
        }

        public final V get() {
            if (zzey.zzagd == null) {
                return this.zzaab;
            }
            zzec zzec = zzey.zzagd;
            if (zzec.isMainThread()) {
                return this.zzaim == null ? this.zzaab : this.zzaim;
            }
            zzil();
            return this.zzaik.get();
        }

        public final V get(V v) {
            if (v != null) {
                return v;
            }
            if (zzey.zzagd == null) {
                return this.zzaab;
            }
            zzec zzec = zzey.zzagd;
            if (zzec.isMainThread()) {
                return this.zzaim == null ? this.zzaab : this.zzaim;
            }
            zzil();
            return this.zzaik.get();
        }

        public final String getKey() {
            return this.zzny;
        }
    }

    static {
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        zzagj = new zzxe(Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/")));
    }

    static void zza(zzec zzec) {
        zzagd = zzec;
        zza.zzm();
    }
}
