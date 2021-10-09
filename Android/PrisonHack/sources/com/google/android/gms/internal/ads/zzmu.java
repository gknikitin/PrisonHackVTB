package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzadh
@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzmu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmu> CREATOR = new zzmv();
    @SafeParcelable.Field(mo13061id = 2)
    public final boolean zzato;
    @SafeParcelable.Field(mo13061id = 3)
    public final boolean zzatp;
    @SafeParcelable.Field(mo13061id = 4)
    public final boolean zzatq;

    public zzmu(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @SafeParcelable.Constructor
    public zzmu(@SafeParcelable.Param(mo13064id = 2) boolean z, @SafeParcelable.Param(mo13064id = 3) boolean z2, @SafeParcelable.Param(mo13064id = 4) boolean z3) {
        this.zzato = z;
        this.zzatp = z2;
        this.zzatq = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzato);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzatp);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzatq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
