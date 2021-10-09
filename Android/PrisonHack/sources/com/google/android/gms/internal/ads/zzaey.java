package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaey> CREATOR = new zzaez();
    @SafeParcelable.Field(mo13061id = 3)
    private final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo13061id = 4)
    private final String packageName;
    @SafeParcelable.Field(mo13061id = 6)
    @Nullable
    private final PackageInfo zzccw;
    @SafeParcelable.Field(mo13061id = 5)
    private final List<String> zzcdj;
    @SafeParcelable.Field(mo13061id = 7)
    private final String zzcds;
    @SafeParcelable.Field(mo13061id = 1)
    private final Bundle zzcfy;
    @SafeParcelable.Field(mo13061id = 2)
    private final zzang zzcfz;
    @SafeParcelable.Field(mo13061id = 8)
    private final boolean zzcga;
    @SafeParcelable.Field(mo13061id = 9)
    private final String zzcgb;

    @SafeParcelable.Constructor
    public zzaey(@SafeParcelable.Param(mo13064id = 1) Bundle bundle, @SafeParcelable.Param(mo13064id = 2) zzang zzang, @SafeParcelable.Param(mo13064id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo13064id = 4) String str, @SafeParcelable.Param(mo13064id = 5) List<String> list, @SafeParcelable.Param(mo13064id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(mo13064id = 7) String str2, @SafeParcelable.Param(mo13064id = 8) boolean z, @SafeParcelable.Param(mo13064id = 9) String str3) {
        this.zzcfy = bundle;
        this.zzcfz = zzang;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzcdj = list;
        this.zzccw = packageInfo;
        this.zzcds = str2;
        this.zzcga = z;
        this.zzcgb = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzcfy, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzcfz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcdj, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzccw, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcds, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzcga);
        SafeParcelWriter.writeString(parcel, 9, this.zzcgb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
