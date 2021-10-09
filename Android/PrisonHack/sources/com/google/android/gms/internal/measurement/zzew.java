package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzew extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzew> CREATOR = new zzex();
    @SafeParcelable.Field(mo13061id = 2)
    public final String name;
    @SafeParcelable.Field(mo13061id = 4)
    public final String origin;
    @SafeParcelable.Field(mo13061id = 3)
    public final zzet zzafr;
    @SafeParcelable.Field(mo13061id = 5)
    public final long zzagc;

    zzew(zzew zzew, long j) {
        Preconditions.checkNotNull(zzew);
        this.name = zzew.name;
        this.zzafr = zzew.zzafr;
        this.origin = zzew.origin;
        this.zzagc = j;
    }

    @SafeParcelable.Constructor
    public zzew(@SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) zzet zzet, @SafeParcelable.Param(mo13064id = 4) String str2, @SafeParcelable.Param(mo13064id = 5) long j) {
        this.name = str;
        this.zzafr = zzet;
        this.origin = str2;
        this.zzagc = j;
    }

    public final String toString() {
        String str = this.origin;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafr);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzafr, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzagc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
