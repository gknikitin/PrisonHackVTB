package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.GuardedBy;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzaq {
    private final SharedPreferences zzcv;
    private final zzs zzcw;
    @GuardedBy("this")
    private final Map<String, zzt> zzcx;
    private final Context zzz;

    public zzaq(Context context) {
        this(context, new zzs());
    }

    private zzaq(Context context, zzs zzs) {
        this.zzcx = new ArrayMap();
        this.zzz = context;
        this.zzcv = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzcw = zzs;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzz), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzaf();
                    FirebaseInstanceId.getInstance().zzj();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private final synchronized boolean isEmpty() {
        return this.zzcv.getAll().isEmpty();
    }

    static String zzb(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    private static String zzb(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza = zzar.zza(str4, str5, System.currentTimeMillis());
        if (zza != null) {
            SharedPreferences.Editor edit = this.zzcv.edit();
            edit.putString(zzb(str, str2, str3), zza);
            edit.commit();
        }
    }

    public final synchronized String zzae() {
        return this.zzcv.getString("topic_operaion_queue", "");
    }

    public final synchronized void zzaf() {
        this.zzcx.clear();
        zzs.zza(this.zzz);
        this.zzcv.edit().clear().commit();
    }

    public final synchronized zzar zzc(String str, String str2, String str3) {
        return zzar.zzi(this.zzcv.getString(zzb(str, str2, str3), (String) null));
    }

    public final synchronized void zzd(String str, String str2, String str3) {
        String zzb = zzb(str, str2, str3);
        SharedPreferences.Editor edit = this.zzcv.edit();
        edit.remove(zzb);
        edit.commit();
    }

    public final synchronized void zzf(String str) {
        this.zzcv.edit().putString("topic_operaion_queue", str).apply();
    }

    public final synchronized zzt zzg(String str) {
        zzt zzt;
        zzt zzt2 = this.zzcx.get(str);
        if (zzt2 != null) {
            return zzt2;
        }
        try {
            zzt = this.zzcw.zzb(this.zzz, str);
        } catch (zzu unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().zzj();
            zzt = this.zzcw.zzc(this.zzz, str);
        }
        this.zzcx.put(str, zzt);
        return zzt;
    }

    public final synchronized void zzh(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zzcv.edit();
        for (String next : this.zzcv.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
