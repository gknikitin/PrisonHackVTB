package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class zzan {
    private static int zzby;
    private static PendingIntent zzck;
    private final zzah zzao;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcl = new SimpleArrayMap<>();
    private Messenger zzcm;
    private Messenger zzcn;
    private zzi zzco;
    private final Context zzz;

    public zzan(Context context, zzah zzah) {
        this.zzz = context;
        this.zzao = zzah;
        this.zzcm = new Messenger(new zzao(this, Looper.getMainLooper()));
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzan.class) {
            if (zzck == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzck = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzck);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcl) {
            TaskCompletionSource remove = this.zzcl.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static synchronized String zzab() {
        String num;
        synchronized (zzan.class) {
            int i = zzby;
            zzby = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* access modifiers changed from: private */
    public final void zzb(Message message) {
        String str;
        String str2;
        if (message == null || !(message.obj instanceof Intent)) {
            str = "FirebaseInstanceId";
            str2 = "Dropping invalid message";
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new zzi.zza());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzi) {
                    this.zzco = (zzi) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzcn = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf);
                        Log.w("FirebaseInstanceId", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf2 = String.valueOf(stringExtra2);
                        Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                    }
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length <= 2 || !"ID".equals(split[1])) {
                            str = "FirebaseInstanceId";
                            String valueOf3 = String.valueOf(stringExtra2);
                            str2 = valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response ");
                        } else {
                            String str3 = split[2];
                            String str4 = split[3];
                            if (str4.startsWith(":")) {
                                str4 = str4.substring(1);
                            }
                            zza(str3, intent2.putExtra("error", str4).getExtras());
                            return;
                        }
                    } else {
                        synchronized (this.zzcl) {
                            for (int i = 0; i < this.zzcl.size(); i++) {
                                zza(this.zzcl.keyAt(i), intent2.getExtras());
                            }
                        }
                        return;
                    }
                } else {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        zza(group, extras);
                        return;
                    } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf4 = String.valueOf(stringExtra);
                        Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
                        return;
                    } else {
                        return;
                    }
                }
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf5 = String.valueOf(action);
                Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
                return;
            } else {
                return;
            }
        }
        Log.w(str, str2);
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey("google.messenger")) {
            return zze2;
        }
        return null;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle zze(android.os.Bundle r9) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = zzab()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcl
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r8.zzcl     // Catch:{ all -> 0x0123 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0123 }
            monitor-exit(r2)     // Catch:{ all -> 0x0123 }
            com.google.firebase.iid.zzah r2 = r8.zzao
            int r2 = r2.zzw()
            if (r2 != 0) goto L_0x0022
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r9.<init>(r0)
            throw r9
        L_0x0022:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzah r3 = r8.zzao
            int r3 = r3.zzw()
            r4 = 2
            if (r3 != r4) goto L_0x003b
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
        L_0x0037:
            r2.setAction(r3)
            goto L_0x003e
        L_0x003b:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            goto L_0x0037
        L_0x003e:
            r2.putExtras(r9)
            android.content.Context r9 = r8.zzz
            zza((android.content.Context) r9, (android.content.Intent) r2)
            java.lang.String r9 = "kid"
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = "|ID|"
            r5.append(r3)
            r5.append(r0)
            java.lang.String r3 = "|"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.putExtra(r9, r3)
            java.lang.String r9 = "FirebaseInstanceId"
            r3 = 3
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x009c
            java.lang.String r9 = "FirebaseInstanceId"
            android.os.Bundle r5 = r2.getExtras()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = java.lang.String.valueOf(r5)
            int r6 = r6.length()
            int r6 = r6 + 8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Sending "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.d(r9, r5)
        L_0x009c:
            java.lang.String r9 = "google.messenger"
            android.os.Messenger r5 = r8.zzcm
            r2.putExtra(r9, r5)
            android.os.Messenger r9 = r8.zzcn
            if (r9 != 0) goto L_0x00ab
            com.google.firebase.iid.zzi r9 = r8.zzco
            if (r9 == 0) goto L_0x00d0
        L_0x00ab:
            android.os.Message r9 = android.os.Message.obtain()
            r9.obj = r2
            android.os.Messenger r5 = r8.zzcn     // Catch:{ RemoteException -> 0x00c1 }
            if (r5 == 0) goto L_0x00bb
            android.os.Messenger r5 = r8.zzcn     // Catch:{ RemoteException -> 0x00c1 }
            r5.send(r9)     // Catch:{ RemoteException -> 0x00c1 }
            goto L_0x00e3
        L_0x00bb:
            com.google.firebase.iid.zzi r5 = r8.zzco     // Catch:{ RemoteException -> 0x00c1 }
            r5.send(r9)     // Catch:{ RemoteException -> 0x00c1 }
            goto L_0x00e3
        L_0x00c1:
            java.lang.String r9 = "FirebaseInstanceId"
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x00d0
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r3 = "Messenger failed, fallback to startService"
            android.util.Log.d(r9, r3)
        L_0x00d0:
            com.google.firebase.iid.zzah r9 = r8.zzao
            int r9 = r9.zzw()
            if (r9 != r4) goto L_0x00de
            android.content.Context r9 = r8.zzz
            r9.sendBroadcast(r2)
            goto L_0x00e3
        L_0x00de:
            android.content.Context r9 = r8.zzz
            r9.startService(r2)
        L_0x00e3:
            com.google.android.gms.tasks.Task r9 = r1.getTask()     // Catch:{ InterruptedException | TimeoutException -> 0x0107, ExecutionException -> 0x0100 }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | TimeoutException -> 0x0107, ExecutionException -> 0x0100 }
            java.lang.Object r9 = com.google.android.gms.tasks.Tasks.await(r9, r1, r3)     // Catch:{ InterruptedException | TimeoutException -> 0x0107, ExecutionException -> 0x0100 }
            android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ InterruptedException | TimeoutException -> 0x0107, ExecutionException -> 0x0100 }
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r8.zzcl
            monitor-enter(r1)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcl     // Catch:{ all -> 0x00fb }
            r2.remove(r0)     // Catch:{ all -> 0x00fb }
            monitor-exit(r1)     // Catch:{ all -> 0x00fb }
            return r9
        L_0x00fb:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00fb }
            throw r9
        L_0x00fe:
            r9 = move-exception
            goto L_0x0116
        L_0x0100:
            r9 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00fe }
            r1.<init>(r9)     // Catch:{ all -> 0x00fe }
            throw r1     // Catch:{ all -> 0x00fe }
        L_0x0107:
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r9, r1)     // Catch:{ all -> 0x00fe }
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = "TIMEOUT"
            r9.<init>(r1)     // Catch:{ all -> 0x00fe }
            throw r9     // Catch:{ all -> 0x00fe }
        L_0x0116:
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r8.zzcl
            monitor-enter(r1)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcl     // Catch:{ all -> 0x0120 }
            r2.remove(r0)     // Catch:{ all -> 0x0120 }
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            throw r9
        L_0x0120:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            throw r9
        L_0x0123:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0123 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzan.zze(android.os.Bundle):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzao.zzz() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzv.zzc(this.zzz).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!(e.getCause() instanceof zzaf) || ((zzaf) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzd(bundle);
        }
    }
}
