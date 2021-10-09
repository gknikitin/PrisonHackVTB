package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzbek {
    private static final Logger logger = Logger.getLogger(zzbek.class.getName());
    private static final Class<?> zzdpj = zzbac.zzabc();
    private static final boolean zzdqm = zzagi();
    private static final Unsafe zzdwf = zzagh();
    private static final boolean zzdze = zzi(Long.TYPE);
    private static final boolean zzdzf = zzi(Integer.TYPE);
    private static final zzd zzdzg;
    private static final boolean zzdzh = zzagj();
    private static final long zzdzi = ((long) zzg(byte[].class));
    private static final long zzdzj = ((long) zzg(boolean[].class));
    private static final long zzdzk = ((long) zzh(boolean[].class));
    private static final long zzdzl = ((long) zzg(int[].class));
    private static final long zzdzm = ((long) zzh(int[].class));
    private static final long zzdzn = ((long) zzg(long[].class));
    private static final long zzdzo = ((long) zzh(long[].class));
    private static final long zzdzp = ((long) zzg(float[].class));
    private static final long zzdzq = ((long) zzh(float[].class));
    private static final long zzdzr = ((long) zzg(double[].class));
    private static final long zzdzs = ((long) zzh(double[].class));
    private static final long zzdzt = ((long) zzg(Object[].class));
    private static final long zzdzu = ((long) zzh(Object[].class));
    private static final long zzdzv = zzb(zzagk());
    private static final long zzdzw;
    /* access modifiers changed from: private */
    public static final boolean zzdzx = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzbek.zzdzx) {
                zzbek.zzb(obj, j, z);
            } else {
                zzbek.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzbek.zzdzx) {
                zzbek.zza(obj, j, b);
            } else {
                zzbek.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzbek.zzdzx ? zzbek.zzs(obj, j) : zzbek.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzbek.zzdzx ? zzbek.zzq(obj, j) : zzbek.zzr(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzbek.zzdzx) {
                zzbek.zzb(obj, j, z);
            } else {
                zzbek.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzbek.zzdzx) {
                zzbek.zza(obj, j, b);
            } else {
                zzbek.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzbek.zzdzx ? zzbek.zzs(obj, j) : zzbek.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzbek.zzdzx ? zzbek.zzq(obj, j) : zzbek.zzr(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzdzy.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzdzy.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzdzy.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzdzy.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzdzy.getBoolean(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return this.zzdzy.getFloat(obj, j);
        }

        public final double zzo(Object obj, long j) {
            return this.zzdzy.getDouble(obj, j);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzdzy.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzdzy;

        zzd(Unsafe unsafe) {
            this.zzdzy = unsafe;
        }

        public final long zza(Field field) {
            return this.zzdzy.objectFieldOffset(field);
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzdzy.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzdzy.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzdzy.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzdzy.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzbek> r0 = com.google.android.gms.internal.ads.zzbek.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzagh()
            zzdwf = r0
            java.lang.Class r0 = com.google.android.gms.internal.ads.zzbac.zzabc()
            zzdpj = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzi(r0)
            zzdze = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzi(r0)
            zzdzf = r0
            sun.misc.Unsafe r0 = zzdwf
            r1 = 0
            if (r0 != 0) goto L_0x002f
        L_0x002d:
            r0 = r1
            goto L_0x0054
        L_0x002f:
            boolean r0 = com.google.android.gms.internal.ads.zzbac.zzabb()
            if (r0 == 0) goto L_0x004d
            boolean r0 = zzdze
            if (r0 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzbek$zzb r0 = new com.google.android.gms.internal.ads.zzbek$zzb
            sun.misc.Unsafe r2 = zzdwf
            r0.<init>(r2)
            goto L_0x0054
        L_0x0041:
            boolean r0 = zzdzf
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzbek$zza r0 = new com.google.android.gms.internal.ads.zzbek$zza
            sun.misc.Unsafe r2 = zzdwf
            r0.<init>(r2)
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.ads.zzbek$zzc r0 = new com.google.android.gms.internal.ads.zzbek$zzc
            sun.misc.Unsafe r2 = zzdwf
            r0.<init>(r2)
        L_0x0054:
            zzdzg = r0
            boolean r0 = zzagj()
            zzdzh = r0
            boolean r0 = zzagi()
            zzdqm = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzi = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzj = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzk = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzl = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzm = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzn = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzo = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzp = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzq = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzr = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzs = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzdzt = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzdzu = r2
            java.lang.reflect.Field r0 = zzagk()
            long r2 = zzb(r0)
            zzdzv = r2
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r2 = "value"
            java.lang.reflect.Field r0 = zzb(r0, r2)
            if (r0 == 0) goto L_0x00f4
            java.lang.Class r2 = r0.getType()
            java.lang.Class<char[]> r3 = char[].class
            if (r2 != r3) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r0 = r1
        L_0x00f5:
            long r0 = zzb(r0)
            zzdzw = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0105
            r0 = 1
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            zzdzx = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.<clinit>():void");
    }

    private zzbek() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzdzg.zzy(bArr, zzdzi + j);
    }

    static long zza(Field field) {
        return zzdzg.zza(field);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zza(Object obj, long j, double d) {
        zzdzg.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzdzg.zza(obj, j, f);
    }

    static void zza(Object obj, long j, long j2) {
        zzdzg.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzdzg.zzdzy.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzdzg.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzdzg.zze(bArr, zzdzi + j, b);
    }

    static boolean zzagf() {
        return zzdqm;
    }

    static boolean zzagg() {
        return zzdzh;
    }

    static Unsafe zzagh() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzbel());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzagi() {
        if (zzdwf == null) {
            return false;
        }
        try {
            Class<?> cls = zzdwf.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzbac.zzabb()) {
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

    private static boolean zzagj() {
        if (zzdwf == null) {
            return false;
        }
        try {
            Class<?> cls = zzdwf.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzagk() == null) {
                return false;
            }
            if (zzbac.zzabb()) {
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

    private static Field zzagk() {
        Field zzb2;
        if (zzbac.zzabb() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static long zzb(Field field) {
        if (field == null || zzdzg == null) {
            return -1;
        }
        return zzdzg.zza(field);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zzb(Object obj, long j, int i) {
        zzdzg.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    private static int zzg(Class<?> cls) {
        if (zzdqm) {
            return zzdzg.zzdzy.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzdqm) {
            return zzdzg.zzdzy.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        if (!zzbac.zzabb()) {
            return false;
        }
        try {
            Class<?> cls2 = zzdpj;
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

    static int zzk(Object obj, long j) {
        return zzdzg.zzk(obj, j);
    }

    static long zzl(Object obj, long j) {
        return zzdzg.zzl(obj, j);
    }

    static boolean zzm(Object obj, long j) {
        return zzdzg.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zzdzg.zzn(obj, j);
    }

    static double zzo(Object obj, long j) {
        return zzdzg.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zzdzg.zzdzy.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, j & -4) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, j & -4) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }
}
