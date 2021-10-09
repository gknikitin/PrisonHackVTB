package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.zzc;
import com.google.firebase.components.zzd;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    @GuardedBy("LOCK")
    static final Map<String, FirebaseApp> zza = new ArrayMap();
    private static final List<String> zzb = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzc = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzd = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zze = Arrays.asList(new String[0]);
    private static final Set<String> zzf = Collections.emptySet();
    /* access modifiers changed from: private */
    public static final Object zzg = new Object();
    private static final Executor zzh = new zza((byte) 0);
    private final Context zzi;
    private final String zzj;
    private final FirebaseOptions zzk;
    private final zzd zzl;
    private final SharedPreferences zzm;
    private final Publisher zzn;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final AtomicBoolean zzq;
    private final List<IdTokenListener> zzr = new CopyOnWriteArrayList();
    private final List<BackgroundStateChangeListener> zzs = new CopyOnWriteArrayList();
    private final List<zza> zzt = new CopyOnWriteArrayList();
    private InternalTokenProvider zzu;
    private IdTokenListenersCountChangedListener zzv;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull InternalTokenResult internalTokenResult);
    }

    @KeepForSdk
    public interface IdTokenListenersCountChangedListener {
        void onListenerCountChanged(int i);
    }

    @NonNull
    public Context getApplicationContext() {
        zzc();
        return this.zzi;
    }

    @NonNull
    public String getName() {
        zzc();
        return this.zzj;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzc();
        return this.zzk;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.zzj.equals(((FirebaseApp) obj).getName());
    }

    public int hashCode() {
        return this.zzj.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zzj).add("options", this.zzk).toString();
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        synchronized (zzg) {
            arrayList = new ArrayList(zza.values());
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (zzg) {
            firebaseApp = zza.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (zzg) {
            firebaseApp = zza.get(str.trim());
            if (firebaseApp == null) {
                List<String> zzd2 = zzd();
                if (zzd2.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", zzd2);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(Context context) {
        synchronized (zzg) {
            if (zza.containsKey(DEFAULT_APP_NAME)) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            FirebaseApp initializeApp = initializeApp(context, fromResource);
            return initializeApp;
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static void onBackgroundStateChanged(boolean z) {
        synchronized (zzg) {
            Iterator it = new ArrayList(zza.values()).iterator();
            while (it.hasNext()) {
                FirebaseApp firebaseApp = (FirebaseApp) it.next();
                if (firebaseApp.zzo.get()) {
                    firebaseApp.zza(z);
                }
            }
        }
    }

    public void setTokenProvider(@NonNull InternalTokenProvider internalTokenProvider) {
        this.zzu = (InternalTokenProvider) Preconditions.checkNotNull(internalTokenProvider);
    }

    public void setIdTokenListenersCountChangedListener(@NonNull IdTokenListenersCountChangedListener idTokenListenersCountChangedListener) {
        this.zzv = (IdTokenListenersCountChangedListener) Preconditions.checkNotNull(idTokenListenersCountChangedListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    public Task<GetTokenResult> getToken(boolean z) {
        zzc();
        if (this.zzu == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode."));
        }
        return this.zzu.getAccessToken(z);
    }

    @Nullable
    public String getUid() throws FirebaseApiNotAvailableException {
        zzc();
        if (this.zzu != null) {
            return this.zzu.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    public void delete() {
        if (this.zzp.compareAndSet(false, true)) {
            synchronized (zzg) {
                zza.remove(this.zzj);
            }
            Iterator<zza> it = this.zzt.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public <T> T get(Class<T> cls) {
        zzc();
        return this.zzl.get(cls);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        zzc();
        if (this.zzo.compareAndSet(!z, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                zza(true);
            } else if (!z && isInBackground) {
                zza(false);
            }
        }
    }

    public boolean isAutomaticDataCollectionEnabled() {
        zzc();
        return this.zzq.get();
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        zzc();
        if (this.zzq.compareAndSet(!z, z)) {
            this.zzm.edit().putBoolean("firebase_automatic_data_collection_enabled", z).commit();
            this.zzn.publish(new Event(AutomaticDataCollectionChange.class, new AutomaticDataCollectionChange(z)));
        }
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zzi = (Context) Preconditions.checkNotNull(context);
        this.zzj = Preconditions.checkNotEmpty(str);
        this.zzk = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        this.zzv = new com.google.firebase.internal.zza();
        this.zzm = context.getSharedPreferences("com.google.firebase.common.prefs", 0);
        this.zzq = new AtomicBoolean(zzb());
        List<ComponentRegistrar> zza2 = new zzc(context).zza();
        this.zzl = new zzd(zzh, zza2, Component.m44of(context, Context.class, new Class[0]), Component.m44of(this, FirebaseApp.class, new Class[0]), Component.m44of(firebaseOptions, FirebaseOptions.class, new Class[0]));
        this.zzn = (Publisher) this.zzl.get(Publisher.class);
    }

    private boolean zzb() {
        ApplicationInfo applicationInfo;
        if (this.zzm.contains("firebase_automatic_data_collection_enabled")) {
            return this.zzm.getBoolean("firebase_automatic_data_collection_enabled", true);
        }
        try {
            PackageManager packageManager = this.zzi.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.zzi.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_automatic_data_collection_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_automatic_data_collection_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    private void zzc() {
        Preconditions.checkState(!this.zzp.get(), "FirebaseApp was deleted");
    }

    public List<IdTokenListener> getListeners() {
        zzc();
        return this.zzr;
    }

    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @UiThread
    public void notifyIdTokenListeners(@NonNull InternalTokenResult internalTokenResult) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (IdTokenListener onIdTokenChanged : this.zzr) {
            onIdTokenChanged.onIdTokenChanged(internalTokenResult);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    private void zza(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.zzs) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        zzc();
        Preconditions.checkNotNull(idTokenListener);
        this.zzr.add(idTokenListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        zzc();
        Preconditions.checkNotNull(idTokenListener);
        this.zzr.remove(idTokenListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zzc();
        if (this.zzo.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.zzs.add(backgroundStateChangeListener);
    }

    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zzc();
        this.zzs.remove(backgroundStateChangeListener);
    }

    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes()) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes());
    }

    public void addLifecycleEventListener(@NonNull zza zza2) {
        zzc();
        Preconditions.checkNotNull(zza2);
        this.zzt.add(zza2);
    }

    public void removeLifecycleEventListener(@NonNull zza zza2) {
        zzc();
        Preconditions.checkNotNull(zza2);
        this.zzt.remove(zza2);
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (zzg) {
            zza.clear();
        }
    }

    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes()) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes());
    }

    private static List<String> zzd() {
        ArrayList arrayList = new ArrayList();
        synchronized (zzg) {
            for (FirebaseApp name : zza.values()) {
                arrayList.add(name.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void zze() {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.zzi);
        if (isDeviceProtectedStorage) {
            zzb.zza(this.zzi);
        } else {
            this.zzl.zza(isDefaultApp());
        }
        zza(FirebaseApp.class, this, zzb, isDeviceProtectedStorage);
        if (isDefaultApp()) {
            zza(FirebaseApp.class, this, zzc, isDeviceProtectedStorage);
            zza(Context.class, this.zzi, zzd, isDeviceProtectedStorage);
        }
    }

    private static <T> void zza(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String next : iterable) {
            if (z) {
                try {
                    if (zze.contains(next)) {
                    }
                } catch (ClassNotFoundException unused) {
                    if (zzf.contains(next)) {
                        throw new IllegalStateException(next + " is missing, but is required. Check if it has been removed by Proguard.");
                    }
                    Log.d("FirebaseApp", next + " is not linked. Skipping initialization.");
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(next + "#getInstance has been removed by Proguard. Add keep rule to prevent it.");
                } catch (InvocationTargetException e) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e);
                } catch (IllegalAccessException e2) {
                    Log.wtf("FirebaseApp", "Failed to initialize " + next, e2);
                }
            }
            Method method = Class.forName(next).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke((Object) null, new Object[]{t});
            }
        }
    }

    @TargetApi(24)
    static class zzb extends BroadcastReceiver {
        private static AtomicReference<zzb> zza = new AtomicReference<>();
        private final Context zzb;

        private zzb(Context context) {
            this.zzb = context;
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.zzg) {
                for (FirebaseApp zza2 : FirebaseApp.zza.values()) {
                    zza2.zze();
                }
            }
            this.zzb.unregisterReceiver(this);
        }

        static /* synthetic */ void zza(Context context) {
            if (zza.get() == null) {
                zzb zzb2 = new zzb(context);
                if (zza.compareAndSet((Object) null, zzb2)) {
                    context.registerReceiver(zzb2, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
    }

    static class zza implements Executor {
        private static final Handler zza = new Handler(Looper.getMainLooper());

        private zza() {
        }

        /* synthetic */ zza(byte b) {
            this();
        }

        public final void execute(@NonNull Runnable runnable) {
            zza.post(runnable);
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            BackgroundDetector.initialize((Application) context.getApplicationContext());
            BackgroundDetector.getInstance().addListener(new BackgroundDetector.BackgroundStateChangeListener() {
                public final void onBackgroundStateChanged(boolean z) {
                    FirebaseApp.onBackgroundStateChanged(z);
                }
            });
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (zzg) {
            Preconditions.checkState(!zza.containsKey(trim), "FirebaseApp name " + trim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            zza.put(trim, firebaseApp);
        }
        firebaseApp.zze();
        return firebaseApp;
    }
}
