package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzabo {
    private static final Logger logger = Logger.getLogger(zzabo.class.getName());
    private static final Class<?> zzbrf = zzyx.zztf();
    private static final Unsafe zzbtt = zzva();
    private static final boolean zzbux = zzk(Long.TYPE);
    private static final boolean zzbuy = zzk(Integer.TYPE);
    private static final zzd zzbuz;
    private static final boolean zzbva = zzvc();
    private static final boolean zzbvb = zzvb();
    private static final long zzbvc = ((long) zzi(byte[].class));
    private static final long zzbvd = ((long) zzi(boolean[].class));
    private static final long zzbve = ((long) zzj(boolean[].class));
    private static final long zzbvf = ((long) zzi(int[].class));
    private static final long zzbvg = ((long) zzj(int[].class));
    private static final long zzbvh = ((long) zzi(long[].class));
    private static final long zzbvi = ((long) zzj(long[].class));
    private static final long zzbvj = ((long) zzi(float[].class));
    private static final long zzbvk = ((long) zzj(float[].class));
    private static final long zzbvl = ((long) zzi(double[].class));
    private static final long zzbvm = ((long) zzj(double[].class));
    private static final long zzbvn = ((long) zzi(Object[].class));
    private static final long zzbvo = ((long) zzj(Object[].class));
    private static final long zzbvp = zza(zzvd());
    private static final long zzbvq;
    private static final boolean zzbvr = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static abstract class zzd {
        Unsafe zzbvs;

        zzd(Unsafe unsafe) {
            this.zzbvs = unsafe;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzabo> r0 = com.google.android.gms.internal.measurement.zzabo.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzva()
            zzbtt = r0
            java.lang.Class r0 = com.google.android.gms.internal.measurement.zzyx.zztf()
            zzbrf = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzk(r0)
            zzbux = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzk(r0)
            zzbuy = r0
            sun.misc.Unsafe r0 = zzbtt
            r1 = 0
            if (r0 != 0) goto L_0x002f
        L_0x002d:
            r0 = r1
            goto L_0x0054
        L_0x002f:
            boolean r0 = com.google.android.gms.internal.measurement.zzyx.zzte()
            if (r0 == 0) goto L_0x004d
            boolean r0 = zzbux
            if (r0 == 0) goto L_0x0041
            com.google.android.gms.internal.measurement.zzabo$zzb r0 = new com.google.android.gms.internal.measurement.zzabo$zzb
            sun.misc.Unsafe r2 = zzbtt
            r0.<init>(r2)
            goto L_0x0054
        L_0x0041:
            boolean r0 = zzbuy
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzabo$zza r0 = new com.google.android.gms.internal.measurement.zzabo$zza
            sun.misc.Unsafe r2 = zzbtt
            r0.<init>(r2)
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.measurement.zzabo$zzc r0 = new com.google.android.gms.internal.measurement.zzabo$zzc
            sun.misc.Unsafe r2 = zzbtt
            r0.<init>(r2)
        L_0x0054:
            zzbuz = r0
            boolean r0 = zzvc()
            zzbva = r0
            boolean r0 = zzvb()
            zzbvb = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvc = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvd = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbve = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvf = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbvg = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvh = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbvi = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvj = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbvk = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvl = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbvm = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r2 = (long) r0
            zzbvn = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzj(r0)
            long r2 = (long) r0
            zzbvo = r2
            java.lang.reflect.Field r0 = zzvd()
            long r2 = zza(r0)
            zzbvp = r2
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r2 = "value"
            java.lang.reflect.Field r0 = zza(r0, r2)
            if (r0 == 0) goto L_0x00f4
            java.lang.Class r2 = r0.getType()
            java.lang.Class<char[]> r3 = char[].class
            if (r2 != r3) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r0 = r1
        L_0x00f5:
            long r0 = zza(r0)
            zzbvq = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0105
            r0 = 1
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            zzbvr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzabo.<clinit>():void");
    }

    private zzabo() {
    }

    private static long zza(Field field) {
        if (field == null || zzbuz == null) {
            return -1;
        }
        return zzbuz.zzbvs.objectFieldOffset(field);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzbvb) {
            return zzbuz.zzbvs.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzbvb) {
            return zzbuz.zzbvs.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzyx.zzte()) {
            return false;
        }
        try {
            Class<?> cls2 = zzbrf;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Unsafe zzva() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzabp());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzvb() {
        if (zzbtt == null) {
            return false;
        }
        try {
            Class<?> cls = zzbtt.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzyx.zzte()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzvc() {
        if (zzbtt == null) {
            return false;
        }
        try {
            Class<?> cls = zzbtt.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzvd() == null) {
                return false;
            }
            if (zzyx.zzte()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzvd() {
        Field zza2;
        if (zzyx.zzte() && (zza2 = zza(Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }
}
