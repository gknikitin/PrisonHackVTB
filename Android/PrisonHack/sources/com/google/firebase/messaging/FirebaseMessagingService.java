package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.firebase.iid.zzap;
import com.google.firebase.iid.zzb;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> zzdo = new ArrayDeque(10);

    static void zzj(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean zzk(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(String str) {
    }

    @WorkerThread
    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public final Intent zzb(Intent intent) {
        return zzap.zzac().zzad();
    }

    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzk(intent.getExtras())) {
            return true;
        }
        zzb.zzd(this, intent);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f3, code lost:
        if (r0.equals("send_event") == false) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Intent r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.getAction()
            if (r0 != 0) goto L_0x0008
            java.lang.String r0 = ""
        L_0x0008:
            int r1 = r0.hashCode()
            r2 = 75300319(0x47cfddf, float:2.973903E-36)
            r3 = -1
            r4 = 1
            r5 = 0
            if (r1 == r2) goto L_0x0024
            r2 = 366519424(0x15d8a480, float:8.750124E-26)
            if (r1 == r2) goto L_0x001a
            goto L_0x002e
        L_0x001a:
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            r0 = 0
            goto L_0x002f
        L_0x0024:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = -1
        L_0x002f:
            switch(r0) {
                case 0: goto L_0x0058;
                case 1: goto L_0x004a;
                default: goto L_0x0032;
            }
        L_0x0032:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "Unknown intent action: "
            java.lang.String r11 = r11.getAction()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r2 = r11.length()
            if (r2 == 0) goto L_0x01cc
            java.lang.String r11 = r1.concat(r11)
            goto L_0x01d1
        L_0x004a:
            android.os.Bundle r0 = r11.getExtras()
            boolean r0 = zzk(r0)
            if (r0 == 0) goto L_0x01d4
            com.google.firebase.messaging.zzb.zze(r10, r11)
            return
        L_0x0058:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 2
            if (r1 == 0) goto L_0x006b
            r1 = 0
            com.google.android.gms.tasks.Task r1 = com.google.android.gms.tasks.Tasks.forResult(r1)
            goto L_0x007d
        L_0x006b:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r6 = "google.message_id"
            r1.putString(r6, r0)
            com.google.firebase.iid.zzv r6 = com.google.firebase.iid.zzv.zzc(r10)
            com.google.android.gms.tasks.Task r1 = r6.zza(r2, r1)
        L_0x007d:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            r7 = 3
            if (r6 == 0) goto L_0x0086
        L_0x0084:
            r0 = 0
            goto L_0x00c8
        L_0x0086:
            java.util.Queue<java.lang.String> r6 = zzdo
            boolean r6 = r6.contains(r0)
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "FirebaseMessaging"
            boolean r6 = android.util.Log.isLoggable(r6, r7)
            if (r6 == 0) goto L_0x00b1
            java.lang.String r6 = "FirebaseMessaging"
            java.lang.String r8 = "Received duplicate message: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r9 = r0.length()
            if (r9 == 0) goto L_0x00a9
            java.lang.String r0 = r8.concat(r0)
            goto L_0x00ae
        L_0x00a9:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r8)
        L_0x00ae:
            android.util.Log.d(r6, r0)
        L_0x00b1:
            r0 = 1
            goto L_0x00c8
        L_0x00b3:
            java.util.Queue<java.lang.String> r6 = zzdo
            int r6 = r6.size()
            r8 = 10
            if (r6 < r8) goto L_0x00c2
            java.util.Queue<java.lang.String> r6 = zzdo
            r6.remove()
        L_0x00c2:
            java.util.Queue<java.lang.String> r6 = zzdo
            r6.add(r0)
            goto L_0x0084
        L_0x00c8:
            if (r0 != 0) goto L_0x019e
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = "gcm"
        L_0x00d4:
            int r6 = r0.hashCode()
            r8 = -2062414158(0xffffffff85120eb2, float:-6.867586E-36)
            if (r6 == r8) goto L_0x010a
            r4 = 102161(0x18f11, float:1.43158E-40)
            if (r6 == r4) goto L_0x0100
            r4 = 814694033(0x308f3e91, float:1.0422402E-9)
            if (r6 == r4) goto L_0x00f6
            r4 = 814800675(0x3090df23, float:1.0540798E-9)
            if (r6 == r4) goto L_0x00ed
            goto L_0x0114
        L_0x00ed:
            java.lang.String r4 = "send_event"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0114
            goto L_0x0115
        L_0x00f6:
            java.lang.String r2 = "send_error"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0114
            r2 = 3
            goto L_0x0115
        L_0x0100:
            java.lang.String r2 = "gcm"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0114
            r2 = 0
            goto L_0x0115
        L_0x010a:
            java.lang.String r2 = "deleted_messages"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0114
            r2 = 1
            goto L_0x0115
        L_0x0114:
            r2 = -1
        L_0x0115:
            switch(r2) {
                case 0: goto L_0x0157;
                case 1: goto L_0x0153;
                case 2: goto L_0x0149;
                case 3: goto L_0x012c;
                default: goto L_0x0118;
            }
        L_0x0118:
            java.lang.String r11 = "FirebaseMessaging"
            java.lang.String r2 = "Received message with unknown type: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x0196
            java.lang.String r0 = r2.concat(r0)
            goto L_0x019b
        L_0x012c:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 != 0) goto L_0x013a
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
        L_0x013a:
            com.google.firebase.messaging.SendException r2 = new com.google.firebase.messaging.SendException
            java.lang.String r3 = "error"
            java.lang.String r11 = r11.getStringExtra(r3)
            r2.<init>(r11)
            r10.onSendError(r0, r2)
            goto L_0x019e
        L_0x0149:
            java.lang.String r0 = "google.message_id"
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.onMessageSent(r11)
            goto L_0x019e
        L_0x0153:
            r10.onDeletedMessages()
            goto L_0x019e
        L_0x0157:
            android.os.Bundle r0 = r11.getExtras()
            boolean r0 = zzk(r0)
            if (r0 == 0) goto L_0x0164
            com.google.firebase.messaging.zzb.zzc(r10, r11)
        L_0x0164:
            android.os.Bundle r0 = r11.getExtras()
            if (r0 != 0) goto L_0x016f
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x016f:
            java.lang.String r2 = "android.support.content.wakelockid"
            r0.remove(r2)
            boolean r2 = com.google.firebase.messaging.zza.zzf(r0)
            if (r2 == 0) goto L_0x018d
            com.google.firebase.messaging.zza r2 = com.google.firebase.messaging.zza.zzd(r10)
            boolean r2 = r2.zzh(r0)
            if (r2 != 0) goto L_0x019e
            boolean r2 = zzk(r0)
            if (r2 == 0) goto L_0x018d
            com.google.firebase.messaging.zzb.zzf(r10, r11)
        L_0x018d:
            com.google.firebase.messaging.RemoteMessage r11 = new com.google.firebase.messaging.RemoteMessage
            r11.<init>(r0)
            r10.onMessageReceived(r11)
            goto L_0x019e
        L_0x0196:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x019b:
            android.util.Log.w(r11, r0)
        L_0x019e:
            r2 = 1
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x01a6 }
            com.google.android.gms.tasks.Tasks.await(r1, r2, r11)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x01a6 }
            return
        L_0x01a6:
            r11 = move-exception
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = java.lang.String.valueOf(r11)
            int r1 = r1.length()
            int r1 = r1 + 20
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Message ack failed: "
            r2.append(r1)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.w(r0, r11)
            return
        L_0x01cc:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r1)
        L_0x01d1:
            android.util.Log.d(r0, r11)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzd(android.content.Intent):void");
    }
}
