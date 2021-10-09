package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.GuardedBy;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzwr {
    private static final ConcurrentHashMap<Uri, zzwr> zzbnf = new ConcurrentHashMap<>();
    private static final String[] zzbnm = {"key", FirebaseAnalytics.Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzbng;
    private final ContentObserver zzbnh;
    private final Object zzbni = new Object();
    private volatile Map<String, String> zzbnj;
    private final Object zzbnk = new Object();
    @GuardedBy("listenersLock")
    private final List<zzwt> zzbnl = new ArrayList();

    private zzwr(ContentResolver contentResolver, Uri uri2) {
        this.zzbng = contentResolver;
        this.uri = uri2;
        this.zzbnh = new zzws(this, (Handler) null);
    }

    public static zzwr zza(ContentResolver contentResolver, Uri uri2) {
        zzwr zzwr = zzbnf.get(uri2);
        if (zzwr != null) {
            return zzwr;
        }
        zzwr zzwr2 = new zzwr(contentResolver, uri2);
        zzwr putIfAbsent = zzbnf.putIfAbsent(uri2, zzwr2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        zzwr2.zzbng.registerContentObserver(zzwr2.uri, false, zzwr2.zzbnh);
        return zzwr2;
    }

    private final Map<String, String> zzse() {
        Cursor query;
        try {
            HashMap hashMap = new HashMap();
            query = this.zzbng.query(this.uri, zzbnm, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return hashMap;
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            query.close();
            return hashMap;
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void zzsf() {
        synchronized (this.zzbnk) {
            for (zzwt zzsg : this.zzbnl) {
                zzsg.zzsg();
            }
        }
    }

    public final Map<String, String> zzsc() {
        Map<String, String> zzse = zzwu.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzse() : this.zzbnj;
        if (zzse == null) {
            synchronized (this.zzbni) {
                Map<String, String> map = this.zzbnj;
                if (map == null) {
                    map = zzse();
                    this.zzbnj = map;
                }
            }
        }
        return zzse != null ? zzse : Collections.emptyMap();
    }

    public final void zzsd() {
        synchronized (this.zzbni) {
            this.zzbnj = null;
        }
    }
}
