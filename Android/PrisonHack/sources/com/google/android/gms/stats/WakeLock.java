package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock {
    private static ScheduledExecutorService zzaeg;
    private static Configuration zzaeh = new zza();
    private final PowerManager.WakeLock zzadv;
    private WorkSource zzadw;
    private String zzadx;
    private final int zzady;
    private final String zzadz;
    private final String zzaea;
    private final String zzaeb;
    private boolean zzaec;
    private final Map<String, Integer[]> zzaed;
    private int zzaee;
    private AtomicInteger zzaef;
    private final Context zzjp;

    public interface Configuration {
        long getMaximumTimeout(String str, String str2);

        boolean isWorkChainsEnabled();
    }

    public class HeldLock {
        private boolean zzaek;
        /* access modifiers changed from: private */
        public Future zzael;
        private final String zzaem;

        private HeldLock(String str) {
            this.zzaek = true;
            this.zzaem = str;
        }

        /* synthetic */ HeldLock(WakeLock wakeLock, String str, zza zza) {
            this(str);
        }

        public void finalize() {
            if (this.zzaek) {
                String valueOf = String.valueOf(this.zzaem);
                Log.e("WakeLock", valueOf.length() != 0 ? "HeldLock finalized while still holding the WakeLock! Reason: ".concat(valueOf) : new String("HeldLock finalized while still holding the WakeLock! Reason: "));
                release(0);
            }
        }

        public void release() {
            release(0);
        }

        public synchronized void release(int i) {
            if (this.zzaek) {
                this.zzaek = false;
                if (this.zzael != null) {
                    this.zzael.cancel(false);
                    this.zzael = null;
                }
                WakeLock.this.zzc(this.zzaem, i);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, @Nonnull String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2) {
        this(context, i, str, str2, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3) {
        this(context, i, str, str2, str3, (String) null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nullable String str4) {
        WorkSource workSource;
        this.zzaec = true;
        this.zzaed = new HashMap();
        this.zzaef = new AtomicInteger(0);
        Preconditions.checkNotEmpty(str, "Wake lock name can NOT be empty");
        this.zzady = i;
        this.zzaea = str2;
        this.zzaeb = str4;
        this.zzjp = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.zzadz = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzadz = str;
        }
        this.zzadv = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            str3 = Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3;
            if (!zzaeh.isWorkChainsEnabled() || str3 == null || str4 == null) {
                workSource = WorkSourceUtil.fromPackage(context, str3);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 42 + String.valueOf(str4).length());
                sb.append("Using experimental Pi WorkSource chains: ");
                sb.append(str3);
                sb.append(",");
                sb.append(str4);
                Log.d("WakeLock", sb.toString());
                this.zzadx = str3;
                workSource = WorkSourceUtil.fromPackageAndModuleExperimentalPi(context, str3, str4);
            }
            this.zzadw = workSource;
            addWorkSource(this.zzadw);
        }
        if (zzaeg == null) {
            zzaeg = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    public static void setConfiguration(Configuration configuration) {
        zzaeh = configuration;
    }

    private final void zza(WorkSource workSource) {
        try {
            this.zzadv.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Log.wtf("WakeLock", e.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r0 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r12.zzaee == 0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.zzadv, r5), 7, r12.zzadz, r5, r12.zzaeb, r12.zzady, zzdo(), r14);
        r12.zzaee++;
     */
    @android.annotation.SuppressLint({"WakelockTimeout"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.lang.String r13, long r14) {
        /*
            r12 = this;
            java.lang.String r5 = r12.zzn((java.lang.String) r13)
            monitor-enter(r12)
            java.util.Map<java.lang.String, java.lang.Integer[]> r13 = r12.zzaed     // Catch:{ all -> 0x00b7 }
            boolean r13 = r13.isEmpty()     // Catch:{ all -> 0x00b7 }
            r0 = 0
            if (r13 == 0) goto L_0x0012
            int r13 = r12.zzaee     // Catch:{ all -> 0x00b7 }
            if (r13 <= 0) goto L_0x0021
        L_0x0012:
            android.os.PowerManager$WakeLock r13 = r12.zzadv     // Catch:{ all -> 0x00b7 }
            boolean r13 = r13.isHeld()     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x0021
            java.util.Map<java.lang.String, java.lang.Integer[]> r13 = r12.zzaed     // Catch:{ all -> 0x00b7 }
            r13.clear()     // Catch:{ all -> 0x00b7 }
            r12.zzaee = r0     // Catch:{ all -> 0x00b7 }
        L_0x0021:
            boolean r13 = r12.zzaec     // Catch:{ all -> 0x00b7 }
            r11 = 1
            if (r13 == 0) goto L_0x004e
            java.util.Map<java.lang.String, java.lang.Integer[]> r13 = r12.zzaed     // Catch:{ all -> 0x00b7 }
            java.lang.Object r13 = r13.get(r5)     // Catch:{ all -> 0x00b7 }
            java.lang.Integer[] r13 = (java.lang.Integer[]) r13     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x003f
            java.util.Map<java.lang.String, java.lang.Integer[]> r13 = r12.zzaed     // Catch:{ all -> 0x00b7 }
            java.lang.Integer[] r1 = new java.lang.Integer[r11]     // Catch:{ all -> 0x00b7 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00b7 }
            r1[r0] = r2     // Catch:{ all -> 0x00b7 }
            r13.put(r5, r1)     // Catch:{ all -> 0x00b7 }
            r0 = 1
            goto L_0x004c
        L_0x003f:
            r1 = r13[r0]     // Catch:{ all -> 0x00b7 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00b7 }
            int r1 = r1 + r11
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00b7 }
            r13[r0] = r1     // Catch:{ all -> 0x00b7 }
        L_0x004c:
            if (r0 != 0) goto L_0x0056
        L_0x004e:
            boolean r13 = r12.zzaec     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x0076
            int r13 = r12.zzaee     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x0076
        L_0x0056:
            com.google.android.gms.common.stats.WakeLockTracker r0 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x00b7 }
            android.content.Context r1 = r12.zzjp     // Catch:{ all -> 0x00b7 }
            android.os.PowerManager$WakeLock r13 = r12.zzadv     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = com.google.android.gms.common.stats.StatsUtils.getEventKey((android.os.PowerManager.WakeLock) r13, (java.lang.String) r5)     // Catch:{ all -> 0x00b7 }
            r3 = 7
            java.lang.String r4 = r12.zzadz     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = r12.zzaeb     // Catch:{ all -> 0x00b7 }
            int r7 = r12.zzady     // Catch:{ all -> 0x00b7 }
            java.util.List r8 = r12.zzdo()     // Catch:{ all -> 0x00b7 }
            r9 = r14
            r0.registerEvent(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00b7 }
            int r13 = r12.zzaee     // Catch:{ all -> 0x00b7 }
            int r13 = r13 + r11
            r12.zzaee = r13     // Catch:{ all -> 0x00b7 }
        L_0x0076:
            monitor-exit(r12)     // Catch:{ all -> 0x00b7 }
            android.os.PowerManager$WakeLock r13 = r12.zzadv
            r13.acquire()
            r0 = 0
            int r13 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x00b6
            java.util.concurrent.ScheduledExecutorService r13 = zzaeg
            com.google.android.gms.stats.zzb r0 = new com.google.android.gms.stats.zzb
            r0.<init>(r12)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r13.schedule(r0, r14, r1)
            boolean r13 = com.google.android.gms.common.util.PlatformVersion.isAtLeastIceCreamSandwich()
            if (r13 != 0) goto L_0x00b6
            boolean r13 = r12.zzaec
            if (r13 == 0) goto L_0x00b6
            java.lang.String r13 = "WakeLock"
            java.lang.String r14 = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: "
            java.lang.String r15 = r12.zzadz
            java.lang.String r15 = java.lang.String.valueOf(r15)
            int r0 = r15.length()
            if (r0 == 0) goto L_0x00ad
            java.lang.String r14 = r14.concat(r15)
            goto L_0x00b3
        L_0x00ad:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r14)
            r14 = r15
        L_0x00b3:
            android.util.Log.wtf(r13, r14)
        L_0x00b6:
            return
        L_0x00b7:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b7 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zza(java.lang.String, long):void");
    }

    private final void zzb(String str, int i) {
        if (this.zzaef.decrementAndGet() < 0) {
            Log.e("WakeLock", "release without a matched acquire!");
        }
        zzc(str, i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r0 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r10.zzaee == 1) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r10.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r10.zzadv, r5), 8, r10.zzadz, r5, r10.zzaeb, r10.zzady, zzdo());
        r10.zzaee--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(java.lang.String r11, int r12) {
        /*
            r10 = this;
            java.lang.String r5 = r10.zzn((java.lang.String) r11)
            monitor-enter(r10)
            boolean r11 = r10.zzaec     // Catch:{ all -> 0x0061 }
            r9 = 1
            if (r11 == 0) goto L_0x0034
            java.util.Map<java.lang.String, java.lang.Integer[]> r11 = r10.zzaed     // Catch:{ all -> 0x0061 }
            java.lang.Object r11 = r11.get(r5)     // Catch:{ all -> 0x0061 }
            java.lang.Integer[] r11 = (java.lang.Integer[]) r11     // Catch:{ all -> 0x0061 }
            r0 = 0
            if (r11 != 0) goto L_0x0016
            goto L_0x0032
        L_0x0016:
            r1 = r11[r0]     // Catch:{ all -> 0x0061 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0061 }
            if (r1 != r9) goto L_0x0025
            java.util.Map<java.lang.String, java.lang.Integer[]> r11 = r10.zzaed     // Catch:{ all -> 0x0061 }
            r11.remove(r5)     // Catch:{ all -> 0x0061 }
            r0 = 1
            goto L_0x0032
        L_0x0025:
            r1 = r11[r0]     // Catch:{ all -> 0x0061 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0061 }
            int r1 = r1 - r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0061 }
            r11[r0] = r1     // Catch:{ all -> 0x0061 }
        L_0x0032:
            if (r0 != 0) goto L_0x003c
        L_0x0034:
            boolean r11 = r10.zzaec     // Catch:{ all -> 0x0061 }
            if (r11 != 0) goto L_0x005c
            int r11 = r10.zzaee     // Catch:{ all -> 0x0061 }
            if (r11 != r9) goto L_0x005c
        L_0x003c:
            com.google.android.gms.common.stats.WakeLockTracker r0 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0061 }
            android.content.Context r1 = r10.zzjp     // Catch:{ all -> 0x0061 }
            android.os.PowerManager$WakeLock r11 = r10.zzadv     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = com.google.android.gms.common.stats.StatsUtils.getEventKey((android.os.PowerManager.WakeLock) r11, (java.lang.String) r5)     // Catch:{ all -> 0x0061 }
            r3 = 8
            java.lang.String r4 = r10.zzadz     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r10.zzaeb     // Catch:{ all -> 0x0061 }
            int r7 = r10.zzady     // Catch:{ all -> 0x0061 }
            java.util.List r8 = r10.zzdo()     // Catch:{ all -> 0x0061 }
            r0.registerEvent(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0061 }
            int r11 = r10.zzaee     // Catch:{ all -> 0x0061 }
            int r11 = r11 - r9
            r10.zzaee = r11     // Catch:{ all -> 0x0061 }
        L_0x005c:
            monitor-exit(r10)     // Catch:{ all -> 0x0061 }
            r10.zzn((int) r12)
            return
        L_0x0061:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0061 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zzc(java.lang.String, int):void");
    }

    private final List<String> zzdo() {
        List<String> names = WorkSourceUtil.getNames(this.zzadw);
        if (this.zzadx == null) {
            return names;
        }
        ArrayList arrayList = new ArrayList(names);
        arrayList.add(this.zzadx);
        return arrayList;
    }

    private final String zzn(String str) {
        return this.zzaec ? !TextUtils.isEmpty(str) ? str : this.zzaea : this.zzaea;
    }

    /* access modifiers changed from: private */
    public final void zzn(int i) {
        if (this.zzadv.isHeld()) {
            try {
                if (Build.VERSION.SDK_INT < 21 || i <= 0) {
                    this.zzadv.release();
                } else {
                    this.zzadv.release(i);
                }
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.zzadz).concat(" was already released!"), e);
                    return;
                }
                throw e;
            }
        }
    }

    public void acquire() {
        this.zzaef.incrementAndGet();
        zza((String) null, 0);
    }

    public void acquire(long j) {
        this.zzaef.incrementAndGet();
        zza((String) null, j);
    }

    public void acquire(String str) {
        this.zzaef.incrementAndGet();
        zza(str, 0);
    }

    public void acquire(String str, long j) {
        this.zzaef.incrementAndGet();
        zza(str, j);
    }

    public HeldLock acquireLock(long j, String str) {
        long min = Math.min(j, zzaeh.getMaximumTimeout(this.zzadz, str));
        HeldLock heldLock = new HeldLock(this, str, (zza) null);
        zza(str, 0);
        Future unused = heldLock.zzael = zzaeg.schedule(new zzc(new WeakReference(heldLock)), min, TimeUnit.MILLISECONDS);
        return heldLock;
    }

    public void addWorkSource(WorkSource workSource) {
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            if (this.zzadw != null) {
                this.zzadw.add(workSource);
            } else {
                this.zzadw = workSource;
            }
            zza(this.zzadw);
        }
    }

    public PowerManager.WakeLock getWakeLock() {
        return this.zzadv;
    }

    public boolean isHeld() {
        return this.zzadv.isHeld();
    }

    public void release() {
        zzb((String) null, 0);
    }

    public void release(int i) {
        zzb((String) null, i);
    }

    public void release(String str) {
        zzb(str, 0);
    }

    public void release(String str, int i) {
        zzb(str, i);
    }

    public void removeWorkSource(WorkSource workSource) {
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            try {
                if (this.zzadw != null) {
                    this.zzadw.remove(workSource);
                }
                zza(this.zzadw);
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.e("WakeLock", e.toString());
            }
        }
    }

    public void setReferenceCounted(boolean z) {
        this.zzadv.setReferenceCounted(z);
        this.zzaec = z;
    }

    public void setWorkSource(WorkSource workSource) {
        if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            zza(workSource);
            this.zzadw = workSource;
            this.zzadx = null;
        }
    }
}
