package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzadh
@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzlu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlu> CREATOR = new zzlv();
    @SafeParcelable.Field(mo13061id = 2)
    public final int zzasj;

    @SafeParcelable.Constructor
    public zzlu(@SafeParcelable.Param(mo13064id = 2) int i) {
        this.zzasj = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzasj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
