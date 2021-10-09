package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaha extends zzek implements zzagz {
    public zzaha() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzagz zzy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzagz ? (zzagz) queryLocalInterface : new zzahb(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [com.google.android.gms.internal.ads.zzahe] */
    /* JADX WARNING: type inference failed for: r4v8, types: [com.google.android.gms.internal.ads.zzagx] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 34
            if (r1 == r4) goto L_0x00c6
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b3;
                case 3: goto L_0x0095;
                default: goto L_0x0008;
            }
        L_0x0008:
            switch(r1) {
                case 5: goto L_0x008a;
                case 6: goto L_0x0086;
                case 7: goto L_0x0082;
                case 8: goto L_0x007e;
                case 9: goto L_0x0072;
                case 10: goto L_0x0066;
                case 11: goto L_0x005a;
                case 12: goto L_0x004e;
                case 13: goto L_0x0045;
                case 14: goto L_0x0038;
                case 15: goto L_0x002c;
                case 16: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            r1 = 0
            return r1
        L_0x000d:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0014
            goto L_0x0027
        L_0x0014:
            java.lang.String r2 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzagx
            if (r4 == 0) goto L_0x0022
            r4 = r2
            com.google.android.gms.internal.ads.zzagx r4 = (com.google.android.gms.internal.ads.zzagx) r4
            goto L_0x0027
        L_0x0022:
            com.google.android.gms.internal.ads.zzagy r4 = new com.google.android.gms.internal.ads.zzagy
            r4.<init>(r1)
        L_0x0027:
            r0.zza((com.google.android.gms.internal.ads.zzagx) r4)
            goto L_0x00c2
        L_0x002c:
            android.os.Bundle r1 = r0.zzba()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzel.zzb(r3, r1)
            goto L_0x00ce
        L_0x0038:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzkx r1 = com.google.android.gms.internal.ads.zzky.zzc(r1)
            r0.zza((com.google.android.gms.internal.ads.zzkx) r1)
            goto L_0x00c2
        L_0x0045:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            goto L_0x00c2
        L_0x004e:
            java.lang.String r1 = r0.getMediationAdapterClassName()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x00ce
        L_0x005a:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzf(r1)
            goto L_0x00c2
        L_0x0066:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zze(r1)
            goto L_0x00c2
        L_0x0072:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzd(r1)
            goto L_0x00c2
        L_0x007e:
            r0.destroy()
            goto L_0x00c2
        L_0x0082:
            r0.resume()
            goto L_0x00c2
        L_0x0086:
            r0.pause()
            goto L_0x00c2
        L_0x008a:
            boolean r1 = r0.isLoaded()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r3, (boolean) r1)
            goto L_0x00ce
        L_0x0095:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x009c
            goto L_0x00af
        L_0x009c:
            java.lang.String r2 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzahe
            if (r4 == 0) goto L_0x00aa
            r4 = r2
            com.google.android.gms.internal.ads.zzahe r4 = (com.google.android.gms.internal.ads.zzahe) r4
            goto L_0x00af
        L_0x00aa:
            com.google.android.gms.internal.ads.zzahg r4 = new com.google.android.gms.internal.ads.zzahg
            r4.<init>(r1)
        L_0x00af:
            r0.zza((com.google.android.gms.internal.ads.zzahe) r4)
            goto L_0x00c2
        L_0x00b3:
            r0.show()
            goto L_0x00c2
        L_0x00b7:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzahk> r1 = com.google.android.gms.internal.ads.zzahk.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzel.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzahk r1 = (com.google.android.gms.internal.ads.zzahk) r1
            r0.zza((com.google.android.gms.internal.ads.zzahk) r1)
        L_0x00c2:
            r3.writeNoException()
            goto L_0x00ce
        L_0x00c6:
            boolean r1 = com.google.android.gms.internal.ads.zzel.zza(r2)
            r0.setImmersiveMode(r1)
            goto L_0x00c2
        L_0x00ce:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaha.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
