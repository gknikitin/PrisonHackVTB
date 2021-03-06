package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzbbj {
    DOUBLE(0, zzbbl.SCALAR, zzbbw.DOUBLE),
    FLOAT(1, zzbbl.SCALAR, zzbbw.FLOAT),
    INT64(2, zzbbl.SCALAR, zzbbw.LONG),
    UINT64(3, zzbbl.SCALAR, zzbbw.LONG),
    INT32(4, zzbbl.SCALAR, zzbbw.INT),
    FIXED64(5, zzbbl.SCALAR, zzbbw.LONG),
    FIXED32(6, zzbbl.SCALAR, zzbbw.INT),
    BOOL(7, zzbbl.SCALAR, zzbbw.BOOLEAN),
    STRING(8, zzbbl.SCALAR, zzbbw.STRING),
    MESSAGE(9, zzbbl.SCALAR, zzbbw.MESSAGE),
    BYTES(10, zzbbl.SCALAR, zzbbw.BYTE_STRING),
    UINT32(11, zzbbl.SCALAR, zzbbw.INT),
    ENUM(12, zzbbl.SCALAR, zzbbw.ENUM),
    SFIXED32(13, zzbbl.SCALAR, zzbbw.INT),
    SFIXED64(14, zzbbl.SCALAR, zzbbw.LONG),
    SINT32(15, zzbbl.SCALAR, zzbbw.INT),
    SINT64(16, zzbbl.SCALAR, zzbbw.LONG),
    GROUP(17, zzbbl.SCALAR, zzbbw.MESSAGE),
    DOUBLE_LIST(18, zzbbl.VECTOR, zzbbw.DOUBLE),
    FLOAT_LIST(19, zzbbl.VECTOR, zzbbw.FLOAT),
    INT64_LIST(20, zzbbl.VECTOR, zzbbw.LONG),
    UINT64_LIST(21, zzbbl.VECTOR, zzbbw.LONG),
    INT32_LIST(22, zzbbl.VECTOR, zzbbw.INT),
    FIXED64_LIST(23, zzbbl.VECTOR, zzbbw.LONG),
    FIXED32_LIST(24, zzbbl.VECTOR, zzbbw.INT),
    BOOL_LIST(25, zzbbl.VECTOR, zzbbw.BOOLEAN),
    STRING_LIST(26, zzbbl.VECTOR, zzbbw.STRING),
    MESSAGE_LIST(27, zzbbl.VECTOR, zzbbw.MESSAGE),
    BYTES_LIST(28, zzbbl.VECTOR, zzbbw.BYTE_STRING),
    UINT32_LIST(29, zzbbl.VECTOR, zzbbw.INT),
    ENUM_LIST(30, zzbbl.VECTOR, zzbbw.ENUM),
    SFIXED32_LIST(31, zzbbl.VECTOR, zzbbw.INT),
    SFIXED64_LIST(32, zzbbl.VECTOR, zzbbw.LONG),
    SINT32_LIST(33, zzbbl.VECTOR, zzbbw.INT),
    SINT64_LIST(34, zzbbl.VECTOR, zzbbw.LONG),
    DOUBLE_LIST_PACKED(35, zzbbl.PACKED_VECTOR, zzbbw.DOUBLE),
    FLOAT_LIST_PACKED(36, zzbbl.PACKED_VECTOR, zzbbw.FLOAT),
    INT64_LIST_PACKED(37, zzbbl.PACKED_VECTOR, zzbbw.LONG),
    UINT64_LIST_PACKED(38, zzbbl.PACKED_VECTOR, zzbbw.LONG),
    INT32_LIST_PACKED(39, zzbbl.PACKED_VECTOR, zzbbw.INT),
    FIXED64_LIST_PACKED(40, zzbbl.PACKED_VECTOR, zzbbw.LONG),
    FIXED32_LIST_PACKED(41, zzbbl.PACKED_VECTOR, zzbbw.INT),
    BOOL_LIST_PACKED(42, zzbbl.PACKED_VECTOR, zzbbw.BOOLEAN),
    UINT32_LIST_PACKED(43, zzbbl.PACKED_VECTOR, zzbbw.INT),
    ENUM_LIST_PACKED(44, zzbbl.PACKED_VECTOR, zzbbw.ENUM),
    SFIXED32_LIST_PACKED(45, zzbbl.PACKED_VECTOR, zzbbw.INT),
    SFIXED64_LIST_PACKED(46, zzbbl.PACKED_VECTOR, zzbbw.LONG),
    SINT32_LIST_PACKED(47, zzbbl.PACKED_VECTOR, zzbbw.INT),
    SINT64_LIST_PACKED(48, zzbbl.PACKED_VECTOR, zzbbw.LONG),
    GROUP_LIST(49, zzbbl.VECTOR, zzbbw.MESSAGE),
    MAP(50, zzbbl.MAP, zzbbw.VOID);
    
    private static final zzbbj[] zzdtf = null;
    private static final Type[] zzdtg = null;

    /* renamed from: id */
    private final int f76id;
    private final zzbbw zzdtb;
    private final zzbbl zzdtc;
    private final Class<?> zzdtd;
    private final boolean zzdte;

    static {
        int i;
        zzdtg = new Type[0];
        zzbbj[] values = values();
        zzdtf = new zzbbj[values.length];
        for (zzbbj zzbbj : values) {
            zzdtf[zzbbj.f76id] = zzbbj;
        }
    }

    private zzbbj(int i, zzbbl zzbbl, zzbbw zzbbw) {
        Class<?> zzadt;
        this.f76id = i;
        this.zzdtc = zzbbl;
        this.zzdtb = zzbbw;
        switch (zzbbl) {
            case MAP:
            case VECTOR:
                zzadt = zzbbw.zzadt();
                break;
            default:
                zzadt = null;
                break;
        }
        this.zzdtd = zzadt;
        boolean z = false;
        if (zzbbl == zzbbl.SCALAR) {
            switch (zzbbw) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzdte = z;
    }

    /* renamed from: id */
    public final int mo14866id() {
        return this.f76id;
    }
}
