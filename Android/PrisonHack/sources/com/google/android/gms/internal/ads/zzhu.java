package com.google.android.gms.internal.ads;

import android.support.p000v4.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzbbo;

public final class zzhu {

    public static final class zza extends zzbbo<zza, C0717zza> implements zzbcw {
        /* access modifiers changed from: private */
        public static final zza zzakg = new zza();
        private static volatile zzbdf<zza> zzakh;

        /* renamed from: com.google.android.gms.internal.ads.zzhu$zza$zza  reason: collision with other inner class name */
        public static final class C0717zza extends zzbbo.zza<zza, C0717zza> implements zzbcw {
            private C0717zza() {
                super(zza.zzakg);
            }

            /* synthetic */ C0717zza(zzhv zzhv) {
                this();
            }
        }

        public enum zzb implements zzbbr {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_CONTEXT_MENU),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_HAND),
            REQUEST_FAILED_TO_BUILD_URL(PointerIconCompat.TYPE_HELP),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(PointerIconCompat.TYPE_CELL),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001);
            
            private static final zzbbs<zzb> zzall = null;
            private final int value;

            static {
                zzall = new zzhw();
            }

            private zzb(int i) {
                this.value = i;
            }

            public static zzb zzp(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_EVENT_TYPE;
                    case 1:
                        return AD_REQUEST;
                    case 2:
                        return AD_LOADED;
                    case 3:
                        return AD_FAILED_TO_LOAD;
                    case 4:
                        return AD_FAILED_TO_LOAD_NO_FILL;
                    case 5:
                        return AD_IMPRESSION;
                    case 6:
                        return AD_FIRST_CLICK;
                    case 7:
                        return AD_SUBSEQUENT_CLICK;
                    case 8:
                        return REQUEST_WILL_START;
                    case 9:
                        return REQUEST_DID_END;
                    case 10:
                        return REQUEST_WILL_UPDATE_SIGNALS;
                    case 11:
                        return REQUEST_DID_UPDATE_SIGNALS;
                    case 12:
                        return REQUEST_WILL_BUILD_URL;
                    case 13:
                        return REQUEST_DID_BUILD_URL;
                    case 14:
                        return REQUEST_WILL_MAKE_NETWORK_REQUEST;
                    case 15:
                        return REQUEST_DID_RECEIVE_NETWORK_RESPONSE;
                    case 16:
                        return REQUEST_WILL_PROCESS_RESPONSE;
                    case 17:
                        return REQUEST_DID_PROCESS_RESPONSE;
                    case 18:
                        return REQUEST_WILL_RENDER;
                    case 19:
                        return REQUEST_DID_RENDER;
                    default:
                        switch (i) {
                            case 1000:
                                return REQUEST_WILL_UPDATE_GMS_SIGNALS;
                            case PointerIconCompat.TYPE_CONTEXT_MENU:
                                return REQUEST_DID_UPDATE_GMS_SIGNALS;
                            case PointerIconCompat.TYPE_HAND:
                                return REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS;
                            case PointerIconCompat.TYPE_HELP:
                                return REQUEST_FAILED_TO_BUILD_URL;
                            case PointerIconCompat.TYPE_WAIT:
                                return REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST;
                            case 1005:
                                return REQUEST_FAILED_TO_PROCESS_RESPONSE;
                            case PointerIconCompat.TYPE_CELL:
                                return REQUEST_FAILED_TO_UPDATE_SIGNALS;
                            default:
                                switch (i) {
                                    case 10000:
                                        return BANNER_SIZE_INVALID;
                                    case 10001:
                                        return BANNER_SIZE_VALID;
                                    default:
                                        return null;
                                }
                        }
                }
            }

            public final int zzhq() {
                return this.value;
            }
        }

        static {
            zzbbo.zza(zza.class, zzakg);
        }

        private zza() {
        }

        /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.ads.zzbdf<com.google.android.gms.internal.ads.zzhu$zza>, com.google.android.gms.internal.ads.zzbbo$zzb] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzbdf<zza> zzbdf;
            switch (zzhv.zzakf[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0717zza((zzhv) null);
                case 3:
                    return zza((zzbcu) zzakg, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzakg;
                case 5:
                    zzbdf<zza> zzbdf2 = zzakh;
                    if (zzbdf2 != null) {
                        return zzbdf2;
                    }
                    synchronized (zza.class) {
                        zzbdf<zza> zzbdf3 = zzakh;
                        zzbdf = zzbdf3;
                        if (zzbdf3 == null) {
                            ? zzb2 = new zzbbo.zzb(zzakg);
                            zzakh = zzb2;
                            zzbdf = zzb2;
                        }
                    }
                    return zzbdf;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
