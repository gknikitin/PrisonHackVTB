package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzjz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjz> CREATOR = new zzka();
    @SafeParcelable.Field(mo13061id = 2)
    public final String name;
    @SafeParcelable.Field(mo13061id = 7)
    public final String origin;
    @SafeParcelable.Field(mo13061id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo13061id = 6)
    private final String zzajo;
    @SafeParcelable.Field(mo13061id = 3)
    public final long zzarl;
    @SafeParcelable.Field(mo13061id = 4)
    private final Long zzarm;
    @SafeParcelable.Field(mo13061id = 5)
    private final Float zzarn;
    @SafeParcelable.Field(mo13061id = 8)
    private final Double zzaro;

    @SafeParcelable.Constructor
    zzjz(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) long j, @SafeParcelable.Param(mo13064id = 4) Long l, @SafeParcelable.Param(mo13064id = 5) Float f, @SafeParcelable.Param(mo13064id = 6) String str2, @SafeParcelable.Param(mo13064id = 7) String str3, @SafeParcelable.Param(mo13064id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzarl = j;
        this.zzarm = l;
        Double d2 = null;
        this.zzarn = null;
        if (i == 1) {
            this.zzaro = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzaro = d;
        }
        this.zzajo = str2;
        this.origin = str3;
    }

    zzjz(zzkb zzkb) {
        this(zzkb.name, zzkb.zzarl, zzkb.value, zzkb.origin);
    }

    zzjz(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzarl = j;
        this.origin = str2;
        if (obj == null) {
            this.zzarm = null;
            this.zzarn = null;
            this.zzaro = null;
            this.zzajo = null;
        } else if (obj instanceof Long) {
            this.zzarm = (Long) obj;
            this.zzarn = null;
            this.zzaro = null;
            this.zzajo = null;
        } else if (obj instanceof String) {
            this.zzarm = null;
            this.zzarn = null;
            this.zzaro = null;
            this.zzajo = (String) obj;
        } else if (obj instanceof Double) {
            this.zzarm = null;
            this.zzarn = null;
            this.zzaro = (Double) obj;
            this.zzajo = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        if (this.zzarm != null) {
            return this.zzarm;
        }
        if (this.zzaro != null) {
            return this.zzaro;
        }
        if (this.zzajo != null) {
            return this.zzajo;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzarl);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzarm, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajo, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzaro, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
