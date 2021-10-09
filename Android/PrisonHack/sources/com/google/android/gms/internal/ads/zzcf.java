package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;

public abstract class zzcf implements zzce {
    protected static volatile zzcz zzps;
    protected MotionEvent zzpy;
    protected LinkedList<MotionEvent> zzpz = new LinkedList<>();
    protected long zzqa = 0;
    protected long zzqb = 0;
    protected long zzqc = 0;
    protected long zzqd = 0;
    protected long zzqe = 0;
    protected long zzqf = 0;
    protected long zzqg = 0;
    protected double zzqh;
    private double zzqi;
    private double zzqj;
    protected float zzqk;
    protected float zzql;
    protected float zzqm;
    protected float zzqn;
    private boolean zzqo = false;
    protected boolean zzqp = false;
    protected DisplayMetrics zzqq;

    protected zzcf(Context context) {
        try {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbay)).booleanValue()) {
                zzbk.zzv();
            } else {
                zzde.zzb(zzps);
            }
            this.zzqq = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final String zza(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        zzba zzba;
        int i;
        if (z) {
            try {
                zzba = zza(context, view, activity);
                this.zzqo = true;
            } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
                i = 7;
                return Integer.toString(i);
            } catch (Throwable unused2) {
                i = 3;
                return Integer.toString(i);
            }
        } else {
            zzba = zza(context, (zzax) null);
        }
        if (zzba != null) {
            if (zzba.zzacw() != 0) {
                return zzbk.zza(zzba, str);
            }
        }
        return Integer.toString(5);
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzcw;

    /* access modifiers changed from: protected */
    public abstract zzba zza(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzba zza(Context context, zzax zzax);

    public final String zza(Context context) {
        if (zzdg.isMainThread()) {
            if (((Boolean) zzkb.zzik().zzd(zznk.zzbba)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, (String) null, false, (View) null, (Activity) null, (byte[]) null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, true, view, activity, (byte[]) null);
    }

    public final void zza(int i, int i2, int i3) {
        MotionEvent motionEvent;
        if (this.zzpy != null) {
            this.zzpy.recycle();
        }
        if (this.zzqq != null) {
            motionEvent = MotionEvent.obtain(0, (long) i3, 1, this.zzqq.density * ((float) i), this.zzqq.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            motionEvent = null;
        }
        this.zzpy = motionEvent;
        this.zzqp = false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.view.MotionEvent r13) {
        /*
            r12 = this;
            boolean r0 = r12.zzqo
            r1 = 0
            if (r0 == 0) goto L_0x0035
            r2 = 0
            r12.zzqd = r2
            r12.zzqc = r2
            r12.zzqb = r2
            r12.zzqa = r2
            r12.zzqe = r2
            r12.zzqg = r2
            r12.zzqf = r2
            java.util.LinkedList<android.view.MotionEvent> r0 = r12.zzpz
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r0.next()
            android.view.MotionEvent r2 = (android.view.MotionEvent) r2
            r2.recycle()
            goto L_0x001b
        L_0x002b:
            java.util.LinkedList<android.view.MotionEvent> r0 = r12.zzpz
            r0.clear()
            r0 = 0
            r12.zzpy = r0
            r12.zzqo = r1
        L_0x0035:
            int r0 = r13.getAction()
            switch(r0) {
                case 0: goto L_0x0062;
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0074
        L_0x003d:
            float r0 = r13.getRawX()
            double r2 = (double) r0
            float r0 = r13.getRawY()
            double r4 = (double) r0
            double r6 = r12.zzqi
            double r6 = r2 - r6
            double r8 = r12.zzqj
            double r8 = r4 - r8
            double r10 = r12.zzqh
            double r6 = r6 * r6
            double r8 = r8 * r8
            double r6 = r6 + r8
            double r6 = java.lang.Math.sqrt(r6)
            double r10 = r10 + r6
            r12.zzqh = r10
            r12.zzqi = r2
            r12.zzqj = r4
            goto L_0x0074
        L_0x0062:
            r2 = 0
            r12.zzqh = r2
            float r0 = r13.getRawX()
            double r2 = (double) r0
            r12.zzqi = r2
            float r0 = r13.getRawY()
            double r2 = (double) r0
            r12.zzqj = r2
        L_0x0074:
            int r0 = r13.getAction()
            r2 = 1
            r4 = 1
            switch(r0) {
                case 0: goto L_0x011a;
                case 1: goto L_0x00e3;
                case 2: goto L_0x0088;
                case 3: goto L_0x0080;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0138
        L_0x0080:
            long r0 = r12.zzqd
            long r5 = r0 + r2
            r12.zzqd = r5
            goto L_0x0138
        L_0x0088:
            long r2 = r12.zzqb
            int r0 = r13.getHistorySize()
            int r0 = r0 + r4
            long r5 = (long) r0
            long r7 = r2 + r5
            r12.zzqb = r7
            com.google.android.gms.internal.ads.zzdf r13 = r12.zzb((android.view.MotionEvent) r13)     // Catch:{ zzcw -> 0x0138 }
            if (r13 == 0) goto L_0x00a4
            java.lang.Long r0 = r13.zzfr     // Catch:{ zzcw -> 0x0138 }
            if (r0 == 0) goto L_0x00a4
            java.lang.Long r0 = r13.zzst     // Catch:{ zzcw -> 0x0138 }
            if (r0 == 0) goto L_0x00a4
            r0 = 1
            goto L_0x00a5
        L_0x00a4:
            r0 = 0
        L_0x00a5:
            if (r0 == 0) goto L_0x00bc
            long r2 = r12.zzqf     // Catch:{ zzcw -> 0x0138 }
            java.lang.Long r0 = r13.zzfr     // Catch:{ zzcw -> 0x0138 }
            long r5 = r0.longValue()     // Catch:{ zzcw -> 0x0138 }
            java.lang.Long r0 = r13.zzst     // Catch:{ zzcw -> 0x0138 }
            long r7 = r0.longValue()     // Catch:{ zzcw -> 0x0138 }
            r0 = 0
            long r9 = r5 + r7
            long r5 = r2 + r9
            r12.zzqf = r5     // Catch:{ zzcw -> 0x0138 }
        L_0x00bc:
            android.util.DisplayMetrics r0 = r12.zzqq     // Catch:{ zzcw -> 0x0138 }
            if (r0 == 0) goto L_0x00cb
            if (r13 == 0) goto L_0x00cb
            java.lang.Long r0 = r13.zzfp     // Catch:{ zzcw -> 0x0138 }
            if (r0 == 0) goto L_0x00cb
            java.lang.Long r0 = r13.zzsu     // Catch:{ zzcw -> 0x0138 }
            if (r0 == 0) goto L_0x00cb
            r1 = 1
        L_0x00cb:
            if (r1 == 0) goto L_0x0138
            long r0 = r12.zzqg     // Catch:{ zzcw -> 0x0138 }
            java.lang.Long r2 = r13.zzfp     // Catch:{ zzcw -> 0x0138 }
            long r2 = r2.longValue()     // Catch:{ zzcw -> 0x0138 }
            java.lang.Long r13 = r13.zzsu     // Catch:{ zzcw -> 0x0138 }
            long r5 = r13.longValue()     // Catch:{ zzcw -> 0x0138 }
            r13 = 0
            long r7 = r2 + r5
            long r2 = r0 + r7
            r12.zzqg = r2     // Catch:{ zzcw -> 0x0138 }
            goto L_0x0138
        L_0x00e3:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r13)
            r12.zzpy = r13
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzpz
            android.view.MotionEvent r0 = r12.zzpy
            r13.add(r0)
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzpz
            int r13 = r13.size()
            r0 = 6
            if (r13 <= r0) goto L_0x0104
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzpz
            java.lang.Object r13 = r13.remove()
            android.view.MotionEvent r13 = (android.view.MotionEvent) r13
            r13.recycle()
        L_0x0104:
            long r0 = r12.zzqc
            long r5 = r0 + r2
            r12.zzqc = r5
            java.lang.Throwable r13 = new java.lang.Throwable     // Catch:{ zzcw -> 0x0138 }
            r13.<init>()     // Catch:{ zzcw -> 0x0138 }
            java.lang.StackTraceElement[] r13 = r13.getStackTrace()     // Catch:{ zzcw -> 0x0138 }
            long r0 = r12.zza((java.lang.StackTraceElement[]) r13)     // Catch:{ zzcw -> 0x0138 }
            r12.zzqe = r0     // Catch:{ zzcw -> 0x0138 }
            goto L_0x0138
        L_0x011a:
            float r0 = r13.getX()
            r12.zzqk = r0
            float r0 = r13.getY()
            r12.zzql = r0
            float r0 = r13.getRawX()
            r12.zzqm = r0
            float r13 = r13.getRawY()
            r12.zzqn = r13
            long r0 = r12.zzqa
            long r5 = r0 + r2
            r12.zzqa = r5
        L_0x0138:
            r12.zzqp = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcf.zza(android.view.MotionEvent):void");
    }

    /* access modifiers changed from: protected */
    public abstract zzdf zzb(MotionEvent motionEvent) throws zzcw;

    public void zzb(View view) {
    }
}
