package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        private static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            public final IBinder asBinder() {
                return this.zza;
            }

            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public static IGmsServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zza(iBinder) : (IGmsServiceBroker) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void getLegacyService(int i, IGmsCallbacks iGmsCallbacks, int i2, String str, String str2, String[] strArr, Bundle bundle, IBinder iBinder, String str3, String str4) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.String[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.common.internal.ValidateAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.common.internal.GetServiceRequest} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r8v0, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r8v17 */
        /* JADX WARNING: type inference failed for: r8v19 */
        /* JADX WARNING: type inference failed for: r8v20 */
        /* JADX WARNING: type inference failed for: r0v10 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
            r6 = r1;
            r8 = r8;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r12, android.os.Parcel r13, android.os.Parcel r14, int r15) throws android.os.RemoteException {
            /*
                r11 = this;
                r0 = 16777215(0xffffff, float:2.3509886E-38)
                if (r12 <= r0) goto L_0x000a
                boolean r12 = super.onTransact(r12, r13, r14, r15)
                return r12
            L_0x000a:
                java.lang.String r15 = "com.google.android.gms.common.internal.IGmsServiceBroker"
                r13.enforceInterface(r15)
                android.os.IBinder r15 = r13.readStrongBinder()
                com.google.android.gms.common.internal.IGmsCallbacks r2 = com.google.android.gms.common.internal.IGmsCallbacks.Stub.asInterface(r15)
                r15 = 46
                r0 = 0
                if (r12 != r15) goto L_0x0030
                int r12 = r13.readInt()
                if (r12 == 0) goto L_0x002b
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.GetServiceRequest> r12 = com.google.android.gms.common.internal.GetServiceRequest.CREATOR
                java.lang.Object r12 = r12.createFromParcel(r13)
                r0 = r12
                com.google.android.gms.common.internal.GetServiceRequest r0 = (com.google.android.gms.common.internal.GetServiceRequest) r0
            L_0x002b:
                r11.getService(r2, r0)
                goto L_0x0142
            L_0x0030:
                r15 = 47
                if (r12 != r15) goto L_0x0048
                int r12 = r13.readInt()
                if (r12 == 0) goto L_0x0043
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.ValidateAccountRequest> r12 = com.google.android.gms.common.internal.ValidateAccountRequest.CREATOR
                java.lang.Object r12 = r12.createFromParcel(r13)
                r0 = r12
                com.google.android.gms.common.internal.ValidateAccountRequest r0 = (com.google.android.gms.common.internal.ValidateAccountRequest) r0
            L_0x0043:
                r11.validateAccount(r2, r0)
                goto L_0x0142
            L_0x0048:
                int r3 = r13.readInt()
                r15 = 4
                if (r12 == r15) goto L_0x0055
                java.lang.String r15 = r13.readString()
                r4 = r15
                goto L_0x0056
            L_0x0055:
                r4 = r0
            L_0x0056:
                r15 = 23
                if (r12 == r15) goto L_0x0124
                r15 = 25
                if (r12 == r15) goto L_0x0124
                r15 = 27
                if (r12 == r15) goto L_0x0124
                r15 = 30
                if (r12 == r15) goto L_0x0103
                r15 = 34
                if (r12 == r15) goto L_0x00fc
                r15 = 41
                if (r12 == r15) goto L_0x0124
                r15 = 43
                if (r12 == r15) goto L_0x0124
                switch(r12) {
                    case 1: goto L_0x00d8;
                    case 2: goto L_0x0124;
                    default: goto L_0x0075;
                }
            L_0x0075:
                switch(r12) {
                    case 5: goto L_0x0124;
                    case 6: goto L_0x0124;
                    case 7: goto L_0x0124;
                    case 8: goto L_0x0124;
                    case 9: goto L_0x00aa;
                    case 10: goto L_0x009d;
                    case 11: goto L_0x0124;
                    case 12: goto L_0x0124;
                    case 13: goto L_0x0124;
                    case 14: goto L_0x0124;
                    case 15: goto L_0x0124;
                    case 16: goto L_0x0124;
                    case 17: goto L_0x0124;
                    case 18: goto L_0x0124;
                    case 19: goto L_0x007d;
                    case 20: goto L_0x0103;
                    default: goto L_0x0078;
                }
            L_0x0078:
                switch(r12) {
                    case 37: goto L_0x0124;
                    case 38: goto L_0x0124;
                    default: goto L_0x007b;
                }
            L_0x007b:
                goto L_0x0137
            L_0x007d:
                android.os.IBinder r15 = r13.readStrongBinder()
                int r1 = r13.readInt()
                if (r1 == 0) goto L_0x0096
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r1.createFromParcel(r13)
                android.os.Bundle r13 = (android.os.Bundle) r13
                r7 = r13
                r8 = r15
                r5 = r0
                r6 = r5
                r9 = r6
                goto L_0x013c
            L_0x0096:
                r8 = r15
                r5 = r0
                r6 = r5
                r7 = r6
                r9 = r7
                goto L_0x013c
            L_0x009d:
                java.lang.String r15 = r13.readString()
                java.lang.String[] r13 = r13.createStringArray()
                r6 = r13
                r5 = r15
                r7 = r0
                goto L_0x013a
            L_0x00aa:
                java.lang.String r15 = r13.readString()
                java.lang.String[] r1 = r13.createStringArray()
                java.lang.String r5 = r13.readString()
                android.os.IBinder r6 = r13.readStrongBinder()
                java.lang.String r7 = r13.readString()
                int r8 = r13.readInt()
                if (r8 == 0) goto L_0x00d2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r0.createFromParcel(r13)
                android.os.Bundle r13 = (android.os.Bundle) r13
                r9 = r5
                r8 = r6
                r10 = r7
                r7 = r13
                r5 = r15
                goto L_0x00fa
            L_0x00d2:
                r9 = r5
                r8 = r6
                r10 = r7
                r5 = r15
                r7 = r0
                goto L_0x00fa
            L_0x00d8:
                java.lang.String r15 = r13.readString()
                java.lang.String[] r1 = r13.createStringArray()
                java.lang.String r5 = r13.readString()
                int r6 = r13.readInt()
                if (r6 == 0) goto L_0x00f6
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r6.createFromParcel(r13)
                android.os.Bundle r13 = (android.os.Bundle) r13
                r7 = r13
                r9 = r15
                r8 = r0
                goto L_0x00f9
            L_0x00f6:
                r9 = r15
                r7 = r0
                r8 = r7
            L_0x00f9:
                r10 = r8
            L_0x00fa:
                r6 = r1
                goto L_0x013d
            L_0x00fc:
                java.lang.String r13 = r13.readString()
                r5 = r13
                r6 = r0
                goto L_0x0139
            L_0x0103:
                java.lang.String[] r15 = r13.createStringArray()
                java.lang.String r1 = r13.readString()
                int r5 = r13.readInt()
                if (r5 == 0) goto L_0x011d
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r5.createFromParcel(r13)
                android.os.Bundle r13 = (android.os.Bundle) r13
                r7 = r13
                r6 = r15
                r8 = r0
                goto L_0x0120
            L_0x011d:
                r6 = r15
                r7 = r0
                r8 = r7
            L_0x0120:
                r9 = r8
                r10 = r9
                r5 = r1
                goto L_0x013d
            L_0x0124:
                int r15 = r13.readInt()
                if (r15 == 0) goto L_0x0137
                android.os.Parcelable$Creator r15 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r15.createFromParcel(r13)
                android.os.Bundle r13 = (android.os.Bundle) r13
                r7 = r13
                r5 = r0
                r6 = r5
                r8 = r6
                goto L_0x013b
            L_0x0137:
                r5 = r0
                r6 = r5
            L_0x0139:
                r7 = r6
            L_0x013a:
                r8 = r7
            L_0x013b:
                r9 = r8
            L_0x013c:
                r10 = r9
            L_0x013d:
                r0 = r11
                r1 = r12
                r0.getLegacyService(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            L_0x0142:
                r14.writeNoException()
                r12 = 1
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.IGmsServiceBroker.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* access modifiers changed from: protected */
        public void validateAccount(IGmsCallbacks iGmsCallbacks, ValidateAccountRequest validateAccountRequest) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;
}
