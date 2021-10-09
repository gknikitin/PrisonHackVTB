package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

public final class zzdo extends zzei {
    private static final Object zztn = new Object();
    private static volatile zzbj zzto;
    private zzax zztp = null;

    public zzdo(zzcz zzcz, String str, String str2, zzba zzba, int i, int i2, zzax zzax) {
        super(zzcz, str, str2, zzba, i, 27);
        this.zztp = zzax;
    }

    private final String zzas() {
        try {
            if (this.zzps.zzak() != null) {
                this.zzps.zzak().get();
            }
            zzba zzaj = this.zzps.zzaj();
            if (zzaj == null || zzaj.zzcx == null) {
                return null;
            }
            return zzaj.zzcx;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzar() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzbj r0 = zzto
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbj r0 = zzto
            java.lang.String r0 = r0.zzcx
            boolean r0 = com.google.android.gms.internal.ads.zzdg.zzo(r0)
            if (r0 != 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbj r0 = zzto
            java.lang.String r0 = r0.zzcx
            java.lang.String r3 = "E"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbj r0 = zzto
            java.lang.String r0 = r0.zzcx
            java.lang.String r3 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r0 = 0
            goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = zztn
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzax r3 = r9.zztp     // Catch:{ all -> 0x00de }
            r3 = 0
            boolean r4 = com.google.android.gms.internal.ads.zzdg.zzo(r3)     // Catch:{ all -> 0x00de }
            r5 = 3
            r6 = 2
            if (r4 != 0) goto L_0x003e
            r4 = 4
            goto L_0x0081
        L_0x003e:
            com.google.android.gms.internal.ads.zzax r4 = r9.zztp     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzdg.zzo(r3)     // Catch:{ all -> 0x00de }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00de }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00de }
            if (r4 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzcz r4 = r9.zzps     // Catch:{ all -> 0x00de }
            boolean r4 = r4.zzah()     // Catch:{ all -> 0x00de }
            if (r4 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zznk.zzbbb     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzni r7 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x00de }
            java.lang.Object r4 = r7.zzd(r4)     // Catch:{ all -> 0x00de }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00de }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00de }
            if (r4 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zznk.zzbbc     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzni r7 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x00de }
            java.lang.Object r4 = r7.zzd(r4)     // Catch:{ all -> 0x00de }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00de }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00de }
            if (r4 == 0) goto L_0x007b
            r4 = 1
            goto L_0x007c
        L_0x007b:
            r4 = 0
        L_0x007c:
            if (r4 == 0) goto L_0x0080
            r4 = 3
            goto L_0x0081
        L_0x0080:
            r4 = 2
        L_0x0081:
            java.lang.reflect.Method r7 = r9.zztz     // Catch:{ all -> 0x00de }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzcz r8 = r9.zzps     // Catch:{ all -> 0x00de }
            android.content.Context r8 = r8.getContext()     // Catch:{ all -> 0x00de }
            r5[r2] = r8     // Catch:{ all -> 0x00de }
            if (r4 != r6) goto L_0x0090
            r2 = 1
        L_0x0090:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00de }
            r5[r1] = r2     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzna<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zznk.zzbav     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x00de }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x00de }
            r5[r6] = r1     // Catch:{ all -> 0x00de }
            java.lang.Object r1 = r7.invoke(r3, r5)     // Catch:{ all -> 0x00de }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzbj r2 = new com.google.android.gms.internal.ads.zzbj     // Catch:{ all -> 0x00de }
            r2.<init>(r1)     // Catch:{ all -> 0x00de }
            zzto = r2     // Catch:{ all -> 0x00de }
            java.lang.String r1 = r2.zzcx     // Catch:{ all -> 0x00de }
            boolean r1 = com.google.android.gms.internal.ads.zzdg.zzo(r1)     // Catch:{ all -> 0x00de }
            if (r1 != 0) goto L_0x00c3
            com.google.android.gms.internal.ads.zzbj r1 = zzto     // Catch:{ all -> 0x00de }
            java.lang.String r1 = r1.zzcx     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "E"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x00dc
        L_0x00c3:
            switch(r4) {
                case 3: goto L_0x00ce;
                case 4: goto L_0x00c7;
                default: goto L_0x00c6;
            }     // Catch:{ all -> 0x00de }
        L_0x00c6:
            goto L_0x00dc
        L_0x00c7:
            com.google.android.gms.internal.ads.zzbj r1 = zzto     // Catch:{ all -> 0x00de }
            java.lang.String r2 = r3.zzcx     // Catch:{ all -> 0x00de }
            r1.zzcx = r2     // Catch:{ all -> 0x00de }
            goto L_0x00dc
        L_0x00ce:
            java.lang.String r1 = r9.zzas()     // Catch:{ all -> 0x00de }
            boolean r2 = com.google.android.gms.internal.ads.zzdg.zzo(r1)     // Catch:{ all -> 0x00de }
            if (r2 != 0) goto L_0x00dc
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x00de }
            r2.zzcx = r1     // Catch:{ all -> 0x00de }
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            goto L_0x00e1
        L_0x00de:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            throw r1
        L_0x00e1:
            com.google.android.gms.internal.ads.zzba r0 = r9.zztq
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbj r1 = zzto     // Catch:{ all -> 0x0116 }
            if (r1 == 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzba r1 = r9.zztq     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x0116 }
            java.lang.String r2 = r2.zzcx     // Catch:{ all -> 0x0116 }
            r1.zzcx = r2     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzba r1 = r9.zztq     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x0116 }
            long r2 = r2.zzhx     // Catch:{ all -> 0x0116 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0116 }
            r1.zzeb = r2     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzba r1 = r9.zztq     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x0116 }
            java.lang.String r2 = r2.zzcz     // Catch:{ all -> 0x0116 }
            r1.zzcz = r2     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzba r1 = r9.zztq     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x0116 }
            java.lang.String r2 = r2.zzda     // Catch:{ all -> 0x0116 }
            r1.zzda = r2     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzba r1 = r9.zztq     // Catch:{ all -> 0x0116 }
            com.google.android.gms.internal.ads.zzbj r2 = zzto     // Catch:{ all -> 0x0116 }
            java.lang.String r2 = r2.zzdb     // Catch:{ all -> 0x0116 }
            r1.zzdb = r2     // Catch:{ all -> 0x0116 }
        L_0x0114:
            monitor-exit(r0)     // Catch:{ all -> 0x0116 }
            return
        L_0x0116:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0116 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdo.zzar():void");
    }
}
