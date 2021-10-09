package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    @SafeParcelable.Field(mo13061id = 2)
    public final boolean zzze;
    @SafeParcelable.Field(mo13061id = 3)
    public final boolean zzzf;
    @SafeParcelable.Field(mo13061id = 4)
    private final String zzzg;
    @SafeParcelable.Field(mo13061id = 5)
    public final boolean zzzh;
    @SafeParcelable.Field(mo13061id = 6)
    public final float zzzi;
    @SafeParcelable.Field(mo13061id = 7)
    public final int zzzj;
    @SafeParcelable.Field(mo13061id = 8)
    public final boolean zzzk;
    @SafeParcelable.Field(mo13061id = 9)
    public final boolean zzzl;
    @SafeParcelable.Field(mo13061id = 10)
    public final boolean zzzm;

    @SafeParcelable.Constructor
    zzaq(@SafeParcelable.Param(mo13064id = 2) boolean z, @SafeParcelable.Param(mo13064id = 3) boolean z2, @SafeParcelable.Param(mo13064id = 4) String str, @SafeParcelable.Param(mo13064id = 5) boolean z3, @SafeParcelable.Param(mo13064id = 6) float f, @SafeParcelable.Param(mo13064id = 7) int i, @SafeParcelable.Param(mo13064id = 8) boolean z4, @SafeParcelable.Param(mo13064id = 9) boolean z5, @SafeParcelable.Param(mo13064id = 10) boolean z6) {
        this.zzze = z;
        this.zzzf = z2;
        this.zzzg = str;
        this.zzzh = z3;
        this.zzzi = f;
        this.zzzj = i;
        this.zzzk = z4;
        this.zzzl = z5;
        this.zzzm = z6;
    }

    public zzaq(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, (String) null, z3, f, i, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzze);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzzf);
        SafeParcelWriter.writeString(parcel, 4, this.zzzg, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzzh);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzzi);
        SafeParcelWriter.writeInt(parcel, 7, this.zzzj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzzk);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzzl);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzzm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
