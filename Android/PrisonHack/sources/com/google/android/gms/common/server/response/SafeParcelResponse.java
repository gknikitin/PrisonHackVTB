package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new SafeParcelResponseCreator();
    private final String mClassName;
    @SafeParcelable.VersionField(getter = "getVersionCode", mo13067id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", mo13061id = 3)
    private final FieldMappingDictionary zzwn;
    @SafeParcelable.Field(getter = "getParcel", mo13061id = 2)
    private final Parcel zzxq;
    private final int zzxr;
    private int zzxs;
    private int zzxt;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) Parcel parcel, @SafeParcelable.Param(mo13064id = 3) FieldMappingDictionary fieldMappingDictionary) {
        this.zzal = i;
        this.zzxq = (Parcel) Preconditions.checkNotNull(parcel);
        this.zzxr = 2;
        this.zzwn = fieldMappingDictionary;
        this.mClassName = this.zzwn == null ? null : this.zzwn.getRootClassName();
        this.zzxs = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzxq, 0);
        this.zzxr = 1;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 2;
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary) {
        this(fieldMappingDictionary, fieldMappingDictionary.getRootClassName());
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary, String str) {
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        this.zzxr = 0;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 0;
    }

    public static HashMap<String, String> convertBundleToStringMap(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public static Bundle convertStringMapToBundle(HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        for (String next : hashMap.keySet()) {
            bundle.putString(next, hashMap.get(next));
        }
        return bundle;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zza(t), canonicalName);
    }

    public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> cls) {
        try {
            return zza((FastJsonResponse) cls.newInstance());
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(cls.getCanonicalName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(cls.getCanonicalName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
        }
    }

    private static FieldMappingDictionary zza(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.copyInternalFieldMappings();
        fieldMappingDictionary.linkFields();
        return fieldMappingDictionary;
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.hasFieldMappingForClass(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            fieldMappingDictionary.put(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> concreteType = field.getConcreteType();
                if (concreteType != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) concreteType.newInstance());
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(field.getConcreteType().getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
                    } catch (IllegalAccessException e2) {
                        String valueOf2 = String.valueOf(field.getConcreteType().getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
                    }
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0160, code lost:
        com.google.android.gms.common.util.ArrayUtils.writeArray(r10, (T[]) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x016b, code lost:
        r3 = "]";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x020b, code lost:
        r10.append(r3);
        r3 = "\"";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x023d, code lost:
        r10.append(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.lang.StringBuilder r10, java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>> r11, android.os.Parcel r12) {
        /*
            r9 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x000d:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r11.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.getSafeParcelableFieldId()
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0027:
            r11 = 123(0x7b, float:1.72E-43)
            r10.append(r11)
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 1
            r2 = 0
            r3 = 0
        L_0x0033:
            int r4 = r12.dataPosition()
            if (r4 >= r11) goto L_0x024b
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r4)
            java.lang.Object r5 = r0.get(r5)
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r5 == 0) goto L_0x0033
            if (r3 == 0) goto L_0x0050
            java.lang.String r3 = ","
            r10.append(r3)
        L_0x0050:
            java.lang.Object r3 = r5.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r5.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r5 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r5
            java.lang.String r6 = "\""
            r10.append(r6)
            r10.append(r3)
            java.lang.String r3 = "\":"
            r10.append(r3)
            boolean r3 = r5.hasConverter()
            if (r3 == 0) goto L_0x00ed
            int r3 = r5.getTypeOut()
            switch(r3) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00d7;
                case 2: goto L_0x00ce;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00ae;
                case 7: goto L_0x00a9;
                case 8: goto L_0x00a4;
                case 9: goto L_0x00a4;
                case 10: goto L_0x009b;
                case 11: goto L_0x0093;
                default: goto L_0x0076;
            }
        L_0x0076:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            int r11 = r5.getTypeOut()
            r12 = 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "Unknown field out type = "
            r0.append(r12)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.<init>(r11)
            throw r10
        L_0x0093:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Method does not accept concrete type."
            r10.<init>(r11)
            throw r10
        L_0x009b:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r12, r4)
            java.util.HashMap r3 = convertBundleToStringMap(r3)
            goto L_0x00e4
        L_0x00a4:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r4)
            goto L_0x00e4
        L_0x00a9:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r4)
            goto L_0x00e4
        L_0x00ae:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r12, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x00e4
        L_0x00b7:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r12, r4)
            goto L_0x00e4
        L_0x00bc:
            double r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r12, r4)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            goto L_0x00e4
        L_0x00c5:
            float r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r12, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00e4
        L_0x00ce:
            long r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r4)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            goto L_0x00e4
        L_0x00d7:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r12, r4)
            goto L_0x00e4
        L_0x00dc:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x00e4:
            java.lang.Object r3 = r9.getOriginalValue(r5, r3)
            r9.zzb(r10, r5, r3)
            goto L_0x0248
        L_0x00ed:
            boolean r3 = r5.isTypeOutArray()
            if (r3 == 0) goto L_0x016f
            java.lang.String r3 = "["
            r10.append(r3)
            int r3 = r5.getTypeOut()
            switch(r3) {
                case 0: goto L_0x0164;
                case 1: goto L_0x015c;
                case 2: goto L_0x0154;
                case 3: goto L_0x014c;
                case 4: goto L_0x0144;
                case 5: goto L_0x013f;
                case 6: goto L_0x0137;
                case 7: goto L_0x012f;
                case 8: goto L_0x0127;
                case 9: goto L_0x0127;
                case 10: goto L_0x0127;
                case 11: goto L_0x0107;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Unknown field type out."
            r10.<init>(r11)
            throw r10
        L_0x0107:
            android.os.Parcel[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelArray(r12, r4)
            int r4 = r3.length
            r6 = 0
        L_0x010d:
            if (r6 >= r4) goto L_0x016b
            if (r6 <= 0) goto L_0x0116
            java.lang.String r7 = ","
            r10.append(r7)
        L_0x0116:
            r7 = r3[r6]
            r7.setDataPosition(r2)
            java.util.Map r7 = r5.getConcreteTypeFieldMappingFromDictionary()
            r8 = r3[r6]
            r9.zza((java.lang.StringBuilder) r10, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r7, (android.os.Parcel) r8)
            int r6 = r6 + 1
            goto L_0x010d
        L_0x0127:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.String r11 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r10.<init>(r11)
            throw r10
        L_0x012f:
            java.lang.String[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeStringArray(r10, r3)
            goto L_0x016b
        L_0x0137:
            boolean[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBooleanArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (boolean[]) r3)
            goto L_0x016b
        L_0x013f:
            java.math.BigDecimal[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimalArray(r12, r4)
            goto L_0x0160
        L_0x0144:
            double[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createDoubleArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (double[]) r3)
            goto L_0x016b
        L_0x014c:
            float[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createFloatArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (float[]) r3)
            goto L_0x016b
        L_0x0154:
            long[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createLongArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (long[]) r3)
            goto L_0x016b
        L_0x015c:
            java.math.BigInteger[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigIntegerArray(r12, r4)
        L_0x0160:
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (T[]) r3)
            goto L_0x016b
        L_0x0164:
            int[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r12, r4)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (int[]) r3)
        L_0x016b:
            java.lang.String r3 = "]"
            goto L_0x0210
        L_0x016f:
            int r3 = r5.getTypeOut()
            switch(r3) {
                case 0: goto L_0x0241;
                case 1: goto L_0x0239;
                case 2: goto L_0x0231;
                case 3: goto L_0x0229;
                case 4: goto L_0x0221;
                case 5: goto L_0x021c;
                case 6: goto L_0x0214;
                case 7: goto L_0x01fe;
                case 8: goto L_0x01f0;
                case 9: goto L_0x01e2;
                case 10: goto L_0x018e;
                case 11: goto L_0x017e;
                default: goto L_0x0176;
            }
        L_0x0176:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Unknown field type out"
            r10.<init>(r11)
            throw r10
        L_0x017e:
            android.os.Parcel r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcel(r12, r4)
            r3.setDataPosition(r2)
            java.util.Map r4 = r5.getConcreteTypeFieldMappingFromDictionary()
            r9.zza((java.lang.StringBuilder) r10, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r4, (android.os.Parcel) r3)
            goto L_0x0248
        L_0x018e:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r12, r4)
            java.util.Set r4 = r3.keySet()
            r4.size()
            java.lang.String r5 = "{"
            r10.append(r5)
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x01a3:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x01df
            java.lang.Object r6 = r4.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r5 != 0) goto L_0x01b6
            java.lang.String r5 = ","
            r10.append(r5)
        L_0x01b6:
            java.lang.String r5 = "\""
            r10.append(r5)
            r10.append(r6)
            java.lang.String r5 = "\""
            r10.append(r5)
            java.lang.String r5 = ":"
            r10.append(r5)
            java.lang.String r5 = "\""
            r10.append(r5)
            java.lang.String r5 = r3.getString(r6)
            java.lang.String r5 = com.google.android.gms.common.util.JsonUtils.escapeString(r5)
            r10.append(r5)
            java.lang.String r5 = "\""
            r10.append(r5)
            r5 = 0
            goto L_0x01a3
        L_0x01df:
            java.lang.String r3 = "}"
            goto L_0x0210
        L_0x01e2:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r4)
            java.lang.String r4 = "\""
            r10.append(r4)
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafe(r3)
            goto L_0x020b
        L_0x01f0:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r4)
            java.lang.String r4 = "\""
            r10.append(r4)
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encode(r3)
            goto L_0x020b
        L_0x01fe:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r4)
            java.lang.String r4 = "\""
            r10.append(r4)
            java.lang.String r3 = com.google.android.gms.common.util.JsonUtils.escapeString(r3)
        L_0x020b:
            r10.append(r3)
            java.lang.String r3 = "\""
        L_0x0210:
            r10.append(r3)
            goto L_0x0248
        L_0x0214:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r12, r4)
            r10.append(r3)
            goto L_0x0248
        L_0x021c:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r12, r4)
            goto L_0x023d
        L_0x0221:
            double r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r12, r4)
            r10.append(r3)
            goto L_0x0248
        L_0x0229:
            float r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r12, r4)
            r10.append(r3)
            goto L_0x0248
        L_0x0231:
            long r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r4)
            r10.append(r3)
            goto L_0x0248
        L_0x0239:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r12, r4)
        L_0x023d:
            r10.append(r3)
            goto L_0x0248
        L_0x0241:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r4)
            r10.append(r3)
        L_0x0248:
            r3 = 1
            goto L_0x0033
        L_0x024b:
            int r0 = r12.dataPosition()
            if (r0 == r11) goto L_0x026a
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r10 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            r0 = 37
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Overread allowed size end="
            r1.append(r0)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r10.<init>(r11, r12)
            throw r10
        L_0x026a:
            r11 = 125(0x7d, float:1.75E-43)
            r10.append(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zza(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    private final void zzb(FastJsonResponse.Field<?, ?> field) {
        if (!field.isValidSafeParcelableFieldId()) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        } else if (this.zzxq == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        } else {
            switch (this.zzxs) {
                case 0:
                    this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
                    this.zzxs = 1;
                    return;
                case 1:
                    return;
                case 2:
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                default:
                    throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
            }
        }
    }

    private final void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.isTypeInArray()) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                zza(sb, field.getTypeIn(), arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        zza(sb, field.getTypeIn(), obj);
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zzb(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) obj)).getParcel());
        }
        SafeParcelWriter.writeParcelList(this.zzxq, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zzb(field);
        SafeParcelWriter.writeParcel(this.zzxq, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).getParcel(), true);
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        if (this.zzwn == null) {
            return null;
        }
        return this.zzwn.getFieldMapping(this.mClassName);
    }

    public Parcel getParcel() {
        switch (this.zzxs) {
            case 0:
                this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
                break;
            case 1:
                break;
        }
        SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
        this.zzxs = 2;
        return this.zzxq;
    }

    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int getVersionCode() {
        return this.zzal;
    }

    public <T extends SafeParcelable> T inflate(Parcelable.Creator<T> creator) {
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        return (SafeParcelable) creator.createFromParcel(parcel);
    }

    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalInternal(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zzb(field);
        SafeParcelWriter.writeBigDecimal(this.zzxq, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zzb(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zzxq, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    /* access modifiers changed from: protected */
    public void setBigIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zzb(field);
        SafeParcelWriter.writeBigInteger(this.zzxq, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    /* access modifiers changed from: protected */
    public void setBigIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zzb(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zzxq, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    /* access modifiers changed from: protected */
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zzb(field);
        SafeParcelWriter.writeBoolean(this.zzxq, field.getSafeParcelableFieldId(), z);
    }

    /* access modifiers changed from: protected */
    public void setBooleansInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zzb(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zzxq, field.getSafeParcelableFieldId(), zArr, true);
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zzb(field);
        SafeParcelWriter.writeByteArray(this.zzxq, field.getSafeParcelableFieldId(), bArr, true);
    }

    /* access modifiers changed from: protected */
    public void setDoubleInternal(FastJsonResponse.Field<?, ?> field, String str, double d) {
        zzb(field);
        SafeParcelWriter.writeDouble(this.zzxq, field.getSafeParcelableFieldId(), d);
    }

    /* access modifiers changed from: protected */
    public void setDoublesInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zzb(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zzxq, field.getSafeParcelableFieldId(), dArr, true);
    }

    /* access modifiers changed from: protected */
    public void setFloatInternal(FastJsonResponse.Field<?, ?> field, String str, float f) {
        zzb(field);
        SafeParcelWriter.writeFloat(this.zzxq, field.getSafeParcelableFieldId(), f);
    }

    /* access modifiers changed from: protected */
    public void setFloatsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zzb(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zzxq, field.getSafeParcelableFieldId(), fArr, true);
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zzb(field);
        SafeParcelWriter.writeInt(this.zzxq, field.getSafeParcelableFieldId(), i);
    }

    /* access modifiers changed from: protected */
    public void setIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zzb(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zzxq, field.getSafeParcelableFieldId(), iArr, true);
    }

    /* access modifiers changed from: protected */
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zzb(field);
        SafeParcelWriter.writeLong(this.zzxq, field.getSafeParcelableFieldId(), j);
    }

    /* access modifiers changed from: protected */
    public void setLongsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zzb(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zzxq, field.getSafeParcelableFieldId(), jArr, true);
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zzb(field);
        SafeParcelWriter.writeString(this.zzxq, field.getSafeParcelableFieldId(), str2, true);
    }

    /* access modifiers changed from: protected */
    public void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zzb(field);
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        SafeParcelWriter.writeBundle(this.zzxq, field.getSafeParcelableFieldId(), bundle, true);
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zzb(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zzxq, field.getSafeParcelableFieldId(), strArr, true);
    }

    public String toString() {
        Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzwn.getFieldMapping(this.mClassName), parcel);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        FieldMappingDictionary fieldMappingDictionary;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeParcel(parcel, 2, getParcel(), false);
        switch (this.zzxr) {
            case 0:
                fieldMappingDictionary = null;
                break;
            case 1:
            case 2:
                fieldMappingDictionary = this.zzwn;
                break;
            default:
                int i2 = this.zzxr;
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.writeParcelable(parcel, 3, fieldMappingDictionary, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
