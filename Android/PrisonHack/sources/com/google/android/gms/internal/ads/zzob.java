package com.google.android.gms.internal.ads;

public abstract class zzob extends zzek implements zzoa {
    public zzob() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r3.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r3.writeNoException();
        r3.writeString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0021;
                case 2: goto L_0x001c;
                case 3: goto L_0x000d;
                case 4: goto L_0x0009;
                case 5: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            r0.recordImpression()
            goto L_0x0018
        L_0x0009:
            r0.recordClick()
            goto L_0x0018
        L_0x000d:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzg(r1)
        L_0x0018:
            r3.writeNoException()
            goto L_0x002b
        L_0x001c:
            java.lang.String r1 = r0.getContent()
            goto L_0x0025
        L_0x0021:
            java.lang.String r1 = r0.zzjn()
        L_0x0025:
            r3.writeNoException()
            r3.writeString(r1)
        L_0x002b:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzob.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
