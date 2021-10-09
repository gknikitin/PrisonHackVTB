package com.google.android.gms.internal.ads;

public abstract class zzaeo extends zzek implements zzaen {
    public zzaeo() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzaeq] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzaet] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzaet] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x0078;
                case 2: goto L_0x0050;
                case 3: goto L_0x0004;
                case 4: goto L_0x002b;
                case 5: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaey> r2 = com.google.android.gms.internal.ads.zzaey.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaey r2 = (com.google.android.gms.internal.ads.zzaey) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaet
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzaet r5 = (com.google.android.gms.internal.ads.zzaet) r5
            goto L_0x0027
        L_0x0022:
            com.google.android.gms.internal.ads.zzaeu r5 = new com.google.android.gms.internal.ads.zzaeu
            r5.<init>(r3)
        L_0x0027:
            r1.zzb(r2, r5)
            goto L_0x0074
        L_0x002b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaey> r2 = com.google.android.gms.internal.ads.zzaey.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaey r2 = (com.google.android.gms.internal.ads.zzaey) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x003a
            goto L_0x004c
        L_0x003a:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaet
            if (r0 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzaet r5 = (com.google.android.gms.internal.ads.zzaet) r5
            goto L_0x004c
        L_0x0047:
            com.google.android.gms.internal.ads.zzaeu r5 = new com.google.android.gms.internal.ads.zzaeu
            r5.<init>(r3)
        L_0x004c:
            r1.zza((com.google.android.gms.internal.ads.zzaey) r2, (com.google.android.gms.internal.ads.zzaet) r5)
            goto L_0x0074
        L_0x0050:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaef> r2 = com.google.android.gms.internal.ads.zzaef.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaef r2 = (com.google.android.gms.internal.ads.zzaef) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x005f
            goto L_0x0071
        L_0x005f:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaeq
            if (r0 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzaeq r5 = (com.google.android.gms.internal.ads.zzaeq) r5
            goto L_0x0071
        L_0x006c:
            com.google.android.gms.internal.ads.zzaes r5 = new com.google.android.gms.internal.ads.zzaes
            r5.<init>(r3)
        L_0x0071:
            r1.zza((com.google.android.gms.internal.ads.zzaef) r2, (com.google.android.gms.internal.ads.zzaeq) r5)
        L_0x0074:
            r4.writeNoException()
            goto L_0x008a
        L_0x0078:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaef> r2 = com.google.android.gms.internal.ads.zzaef.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaef r2 = (com.google.android.gms.internal.ads.zzaef) r2
            com.google.android.gms.internal.ads.zzaej r2 = r1.zzb(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzel.zzb(r4, r2)
        L_0x008a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeo.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
