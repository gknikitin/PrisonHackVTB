package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

public class InstantApps {
    private static Context zzaay;
    private static Boolean zzaaz;

    public static synchronized boolean isInstantApp(Context context) {
        boolean z;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzaay == null || zzaaz == null || zzaay != applicationContext) {
                zzaaz = null;
                if (PlatformVersion.isAtLeastO()) {
                    z = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzaaz = true;
                    } catch (ClassNotFoundException unused) {
                        z = false;
                    }
                    zzaay = applicationContext;
                    boolean booleanValue = zzaaz.booleanValue();
                    return booleanValue;
                }
                zzaaz = z;
                zzaay = applicationContext;
                boolean booleanValue2 = zzaaz.booleanValue();
                return booleanValue2;
            }
            boolean booleanValue3 = zzaaz.booleanValue();
            return booleanValue3;
        }
    }
}
