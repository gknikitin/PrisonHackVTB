package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzfe extends SQLiteOpenHelper {
    private final /* synthetic */ zzfd zzair;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfe(zzfd zzfd, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzair = zzfd;
    }

    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            this.zzair.zzgf().zzis().log("Opening the local database failed, dropping and recreating it");
            if (!this.zzair.getContext().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zzair.zzgf().zzis().zzg("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                this.zzair.zzgf().zzis().zzg("Failed to open local database. Events will bypass local storage", e2);
                return null;
            }
        }
    }

    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzen.zza(this.zzair.zzgf(), sQLiteDatabase);
    }

    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 15
            if (r0 >= r1) goto L_0x0020
            r0 = 0
            java.lang.String r1 = "PRAGMA journal_mode=memory"
            android.database.Cursor r1 = r8.rawQuery(r1, r0)     // Catch:{ all -> 0x0019 }
            r1.moveToFirst()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0020
            r1.close()
            goto L_0x0020
        L_0x0016:
            r8 = move-exception
            r0 = r1
            goto L_0x001a
        L_0x0019:
            r8 = move-exception
        L_0x001a:
            if (r0 == 0) goto L_0x001f
            r0.close()
        L_0x001f:
            throw r8
        L_0x0020:
            com.google.android.gms.internal.measurement.zzfd r0 = r7.zzair
            com.google.android.gms.internal.measurement.zzfh r1 = r0.zzgf()
            java.lang.String r3 = "messages"
            java.lang.String r4 = "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)"
            java.lang.String r5 = "type,entry"
            r6 = 0
            r2 = r8
            com.google.android.gms.internal.measurement.zzen.zza(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfe.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
