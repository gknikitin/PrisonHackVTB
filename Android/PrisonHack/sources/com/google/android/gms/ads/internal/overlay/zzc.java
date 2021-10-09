package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@SafeParcelable.Class(creator = "AdLauncherIntentInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    @SafeParcelable.Field(mo13061id = 9)
    public final Intent intent;
    @SafeParcelable.Field(mo13061id = 4)
    public final String mimeType;
    @SafeParcelable.Field(mo13061id = 5)
    public final String packageName;
    @SafeParcelable.Field(mo13061id = 3)
    public final String url;
    @SafeParcelable.Field(mo13061id = 2)
    private final String zzbxi;
    @SafeParcelable.Field(mo13061id = 6)
    public final String zzbxj;
    @SafeParcelable.Field(mo13061id = 7)
    public final String zzbxk;
    @SafeParcelable.Field(mo13061id = 8)
    private final String zzbxl;

    public zzc(Intent intent2) {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intent2);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, (Intent) null);
    }

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) String str2, @SafeParcelable.Param(mo13064id = 4) String str3, @SafeParcelable.Param(mo13064id = 5) String str4, @SafeParcelable.Param(mo13064id = 6) String str5, @SafeParcelable.Param(mo13064id = 7) String str6, @SafeParcelable.Param(mo13064id = 8) String str7, @SafeParcelable.Param(mo13064id = 9) Intent intent2) {
        this.zzbxi = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzbxj = str5;
        this.zzbxk = str6;
        this.zzbxl = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbxi, false);
        SafeParcelWriter.writeString(parcel, 3, this.url, false);
        SafeParcelWriter.writeString(parcel, 4, this.mimeType, false);
        SafeParcelWriter.writeString(parcel, 5, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbxj, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbxk, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbxl, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.intent, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
