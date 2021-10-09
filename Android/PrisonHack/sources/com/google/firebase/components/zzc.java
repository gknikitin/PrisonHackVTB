package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzc {
    private final Context zza;
    private final zzb zzb;

    @VisibleForTesting
    interface zzb {
        List<String> zza(Context context);
    }

    public zzc(Context context) {
        this(context, new zza((byte) 0));
    }

    @VisibleForTesting
    private zzc(Context context, zzb zzb2) {
        this.zza = context;
        this.zzb = zzb2;
    }

    public final List<ComponentRegistrar> zza() {
        return zza(this.zzb.zza(this.zza));
    }

    private static List<ComponentRegistrar> zza(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!ComponentRegistrar.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((ComponentRegistrar) cls.newInstance());
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{next}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e3);
            }
        }
        return arrayList;
    }

    static class zza implements zzb {
        private zza() {
        }

        /* synthetic */ zza(byte b) {
            this();
        }

        public final List<String> zza(Context context) {
            Bundle zzb = zzb(context);
            if (zzb == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : zzb.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(zzb.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private static Bundle zzb(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }
    }
}
