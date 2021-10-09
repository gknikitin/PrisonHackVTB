package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzadh
@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
public final class zzsi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsi> CREATOR = new zzsj();
    @SafeParcelable.Field(mo13061id = 4)
    public final byte[] data;
    @SafeParcelable.Field(mo13061id = 3)
    public final int statusCode;
    @SafeParcelable.Field(mo13061id = 7)
    public final boolean zzac;
    @SafeParcelable.Field(mo13061id = 8)
    public final long zzad;
    @SafeParcelable.Field(mo13061id = 5)
    public final String[] zzbnh;
    @SafeParcelable.Field(mo13061id = 6)
    public final String[] zzbni;
    @SafeParcelable.Field(mo13061id = 1)
    public final boolean zzbnj;
    @SafeParcelable.Field(mo13061id = 2)
    public final String zzbnk;

    @SafeParcelable.Constructor
    zzsi(@SafeParcelable.Param(mo13064id = 1) boolean z, @SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) int i, @SafeParcelable.Param(mo13064id = 4) byte[] bArr, @SafeParcelable.Param(mo13064id = 5) String[] strArr, @SafeParcelable.Param(mo13064id = 6) String[] strArr2, @SafeParcelable.Param(mo13064id = 7) boolean z2, @SafeParcelable.Param(mo13064id = 8) long j) {
        this.zzbnj = z;
        this.zzbnk = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzbnh = strArr;
        this.zzbni = strArr2;
        this.zzac = z2;
        this.zzad = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzbnj);
        SafeParcelWriter.writeString(parcel, 2, this.zzbnk, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzbnh, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzbni, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzac);
        SafeParcelWriter.writeLong(parcel, 8, this.zzad);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
