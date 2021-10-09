package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzadh
@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzafj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzafj> CREATOR = new zzafk();
    @SafeParcelable.Field(mo13061id = 2)
    String zzbgu;

    @SafeParcelable.Constructor
    public zzafj(@SafeParcelable.Param(mo13064id = 2) String str) {
        this.zzbgu = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbgu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
