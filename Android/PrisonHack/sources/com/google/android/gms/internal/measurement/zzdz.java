package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1})
public final class zzdz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdz> CREATOR = new zzea();
    @SafeParcelable.Field(mo13061id = 2)
    public final String packageName;
    @SafeParcelable.Field(mo13061id = 3)
    public final String zzadm;
    @SafeParcelable.Field(mo13061id = 12)
    public final String zzado;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", mo13061id = 11)
    public final long zzads;
    @SafeParcelable.Field(mo13061id = 5)
    public final String zzadt;
    @SafeParcelable.Field(mo13061id = 6)
    public final long zzadu;
    @SafeParcelable.Field(mo13061id = 7)
    public final long zzadv;
    @SafeParcelable.Field(defaultValue = "true", mo13061id = 9)
    public final boolean zzadw;
    @SafeParcelable.Field(mo13061id = 13)
    public final long zzadx;
    @SafeParcelable.Field(defaultValue = "true", mo13061id = 16)
    public final boolean zzady;
    @SafeParcelable.Field(defaultValue = "true", mo13061id = 17)
    public final boolean zzadz;
    @SafeParcelable.Field(mo13061id = 8)
    public final String zzaek;
    @SafeParcelable.Field(mo13061id = 10)
    public final boolean zzael;
    @SafeParcelable.Field(mo13061id = 14)
    public final long zzaem;
    @SafeParcelable.Field(mo13061id = 15)
    public final int zzaen;
    @SafeParcelable.Field(mo13061id = 18)
    public final boolean zzaeo;
    @SafeParcelable.Field(mo13061id = 4)
    public final String zzth;

    zzdz(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        this.packageName = str;
        this.zzadm = TextUtils.isEmpty(str2) ? null : str2;
        this.zzth = str3;
        this.zzads = j;
        this.zzadt = str4;
        this.zzadu = j2;
        this.zzadv = j3;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j4;
        this.zzaem = j5;
        this.zzaen = i;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
    }

    @SafeParcelable.Constructor
    zzdz(@SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) String str2, @SafeParcelable.Param(mo13064id = 4) String str3, @SafeParcelable.Param(mo13064id = 5) String str4, @SafeParcelable.Param(mo13064id = 6) long j, @SafeParcelable.Param(mo13064id = 7) long j2, @SafeParcelable.Param(mo13064id = 8) String str5, @SafeParcelable.Param(mo13064id = 9) boolean z, @SafeParcelable.Param(mo13064id = 10) boolean z2, @SafeParcelable.Param(mo13064id = 11) long j3, @SafeParcelable.Param(mo13064id = 12) String str6, @SafeParcelable.Param(mo13064id = 13) long j4, @SafeParcelable.Param(mo13064id = 14) long j5, @SafeParcelable.Param(mo13064id = 15) int i, @SafeParcelable.Param(mo13064id = 16) boolean z3, @SafeParcelable.Param(mo13064id = 17) boolean z4, @SafeParcelable.Param(mo13064id = 18) boolean z5) {
        this.packageName = str;
        this.zzadm = str2;
        this.zzth = str3;
        this.zzads = j3;
        this.zzadt = str4;
        this.zzadu = j;
        this.zzadv = j2;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j4;
        this.zzaem = j5;
        this.zzaen = i;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzadm, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzth, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzadt, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzadu);
        SafeParcelWriter.writeLong(parcel, 7, this.zzadv);
        SafeParcelWriter.writeString(parcel, 8, this.zzaek, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzadw);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzael);
        SafeParcelWriter.writeLong(parcel, 11, this.zzads);
        SafeParcelWriter.writeString(parcel, 12, this.zzado, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzadx);
        SafeParcelWriter.writeLong(parcel, 14, this.zzaem);
        SafeParcelWriter.writeInt(parcel, 15, this.zzaen);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzady);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzadz);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzaeo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
