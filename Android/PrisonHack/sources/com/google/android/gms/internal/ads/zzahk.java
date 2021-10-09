package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzadh
@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzahk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahk> CREATOR = new zzahl();
    @SafeParcelable.Field(mo13061id = 3)
    public final String zzacp;
    @SafeParcelable.Field(mo13061id = 2)
    public final zzjj zzccv;

    @SafeParcelable.Constructor
    public zzahk(@SafeParcelable.Param(mo13064id = 2) zzjj zzjj, @SafeParcelable.Param(mo13064id = 3) String str) {
        this.zzccv = zzjj;
        this.zzacp = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzccv, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzacp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
