package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzzs<MessageType extends zzzs<MessageType, BuilderType>, BuilderType> extends zzyw<MessageType, BuilderType> {
    private static Map<Object, zzzs<?, ?>> zzbsk = new ConcurrentHashMap();
    protected zzabm zzbsi = zzabm.zzuz();
    private int zzbsj = -1;

    public static abstract class zza<MessageType extends zza<MessageType, BuilderType>, BuilderType> extends zzzs<MessageType, BuilderType> implements zzaao {
        protected zzzo<Object> zzbsl = zzzo.zztr();
    }

    /* 'enum' modifier removed */
    public static final class zzb {
        private static final int zzbsm = 1;
        private static final int zzbsn = 2;
        public static final int zzbso = 3;
        private static final int zzbsp = 4;
        private static final int zzbsq = 5;
        public static final int zzbsr = 6;
        public static final int zzbss = 7;
        private static final /* synthetic */ int[] zzbst = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzbsu = 1;
        private static final int zzbsv = 2;
        private static final /* synthetic */ int[] zzbsw = {1, 2};
        private static final int zzbsx = 1;
        private static final int zzbsy = 2;
        private static final /* synthetic */ int[] zzbsz = {1, 2};
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    static <T extends zzzs<?, ?>> T zzf(Class<T> cls) {
        T t = (zzzs) zzbsk.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzzs) zzbsk.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzzs) zza(6, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzaav.zzum().zzt(this).equals(this, (zzzs) obj);
    }

    public int hashCode() {
        if (this.zzbrd != 0) {
            return this.zzbrd;
        }
        this.zzbrd = zzaav.zzum().zzt(this).hashCode(this);
        return this.zzbrd;
    }

    public String toString() {
        return zzaap.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);
}
