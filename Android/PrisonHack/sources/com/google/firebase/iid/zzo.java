package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.Executor;

final class zzo implements IRpc {
    private final FirebaseApp zzan;
    private final zzah zzao;
    @VisibleForTesting
    private final zzan zzbe;
    private final Executor zzbf;

    zzo(FirebaseApp firebaseApp, zzah zzah, Executor executor) {
        this(firebaseApp, zzah, executor, new zzan(firebaseApp.getApplicationContext(), zzah));
    }

    @VisibleForTesting
    private zzo(FirebaseApp firebaseApp, zzah zzah, Executor executor, zzan zzan2) {
        this.zzan = firebaseApp;
        this.zzao = zzah;
        this.zzbe = zzan2;
        this.zzbf = executor;
    }

    private final Task<Bundle> zza(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.zzan.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.zzao.zzz()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.zzao.zzx());
        bundle.putString("app_ver_name", this.zzao.zzy());
        bundle.putString("cliv", "fiid-12451000");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzbf.execute(new zzp(this, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static String zza(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        } else if (string3 != null) {
            throw new IOException(string3);
        } else {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Unexpected response: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final <T> Task<Void> zzb(Task<T> task) {
        return task.continueWith(this.zzbf, new zzq(this));
    }

    private final Task<String> zzc(Task<Bundle> task) {
        return task.continueWith(this.zzbf, new zzr(this));
    }

    public final Task<Void> ackMessage(String str) {
        return null;
    }

    public final Task<String> buildChannel(String str) {
        return Tasks.forResult("");
    }

    public final Task<Void> deleteInstanceId(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", "delete");
        bundle.putString("delete", "1");
        return zzb(zzc(zza(str, "*", "*", bundle)));
    }

    public final Task<Void> deleteToken(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return zzb(zzc(zza(str, str2, str3, bundle)));
    }

    public final Task<String> getToken(String str, String str2, String str3) {
        return zzc(zza(str, str2, str3, new Bundle()));
    }

    public final Task<Void> subscribeToTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return zzb(zzc(zza(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    public final Task<Void> unsubscribeFromTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return zzb(zzc(zza(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(this.zzbe.zzc(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }
}
