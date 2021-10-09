package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzadh
@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzjj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjj> CREATOR = new zzjl();
    @SafeParcelable.Field(mo13061id = 3)
    public final Bundle extras;
    @SafeParcelable.Field(mo13061id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo13061id = 2)
    public final long zzapw;
    @SafeParcelable.Field(mo13061id = 4)
    public final int zzapx;
    @SafeParcelable.Field(mo13061id = 5)
    public final List<String> zzapy;
    @SafeParcelable.Field(mo13061id = 6)
    public final boolean zzapz;
    @SafeParcelable.Field(mo13061id = 7)
    public final int zzaqa;
    @SafeParcelable.Field(mo13061id = 8)
    public final boolean zzaqb;
    @SafeParcelable.Field(mo13061id = 9)
    public final String zzaqc;
    @SafeParcelable.Field(mo13061id = 10)
    public final zzmq zzaqd;
    @SafeParcelable.Field(mo13061id = 11)
    public final Location zzaqe;
    @SafeParcelable.Field(mo13061id = 12)
    public final String zzaqf;
    @SafeParcelable.Field(mo13061id = 13)
    public final Bundle zzaqg;
    @SafeParcelable.Field(mo13061id = 14)
    public final Bundle zzaqh;
    @SafeParcelable.Field(mo13061id = 15)
    public final List<String> zzaqi;
    @SafeParcelable.Field(mo13061id = 16)
    public final String zzaqj;
    @SafeParcelable.Field(mo13061id = 17)
    public final String zzaqk;
    @SafeParcelable.Field(mo13061id = 18)
    public final boolean zzaql;

    @SafeParcelable.Constructor
    public zzjj(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) long j, @SafeParcelable.Param(mo13064id = 3) Bundle bundle, @SafeParcelable.Param(mo13064id = 4) int i2, @SafeParcelable.Param(mo13064id = 5) List<String> list, @SafeParcelable.Param(mo13064id = 6) boolean z, @SafeParcelable.Param(mo13064id = 7) int i3, @SafeParcelable.Param(mo13064id = 8) boolean z2, @SafeParcelable.Param(mo13064id = 9) String str, @SafeParcelable.Param(mo13064id = 10) zzmq zzmq, @SafeParcelable.Param(mo13064id = 11) Location location, @SafeParcelable.Param(mo13064id = 12) String str2, @SafeParcelable.Param(mo13064id = 13) Bundle bundle2, @SafeParcelable.Param(mo13064id = 14) Bundle bundle3, @SafeParcelable.Param(mo13064id = 15) List<String> list2, @SafeParcelable.Param(mo13064id = 16) String str3, @SafeParcelable.Param(mo13064id = 17) String str4, @SafeParcelable.Param(mo13064id = 18) boolean z3) {
        this.versionCode = i;
        this.zzapw = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzapx = i2;
        this.zzapy = list;
        this.zzapz = z;
        this.zzaqa = i3;
        this.zzaqb = z2;
        this.zzaqc = str;
        this.zzaqd = zzmq;
        this.zzaqe = location;
        this.zzaqf = str2;
        this.zzaqg = bundle2 == null ? new Bundle() : bundle2;
        this.zzaqh = bundle3;
        this.zzaqi = list2;
        this.zzaqj = str3;
        this.zzaqk = str4;
        this.zzaql = z3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj zzjj = (zzjj) obj;
        return this.versionCode == zzjj.versionCode && this.zzapw == zzjj.zzapw && Objects.equal(this.extras, zzjj.extras) && this.zzapx == zzjj.zzapx && Objects.equal(this.zzapy, zzjj.zzapy) && this.zzapz == zzjj.zzapz && this.zzaqa == zzjj.zzaqa && this.zzaqb == zzjj.zzaqb && Objects.equal(this.zzaqc, zzjj.zzaqc) && Objects.equal(this.zzaqd, zzjj.zzaqd) && Objects.equal(this.zzaqe, zzjj.zzaqe) && Objects.equal(this.zzaqf, zzjj.zzaqf) && Objects.equal(this.zzaqg, zzjj.zzaqg) && Objects.equal(this.zzaqh, zzjj.zzaqh) && Objects.equal(this.zzaqi, zzjj.zzaqi) && Objects.equal(this.zzaqj, zzjj.zzaqj) && Objects.equal(this.zzaqk, zzjj.zzaqk) && this.zzaql == zzjj.zzaql;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzapw), this.extras, Integer.valueOf(this.zzapx), this.zzapy, Boolean.valueOf(this.zzapz), Integer.valueOf(this.zzaqa), Boolean.valueOf(this.zzaqb), this.zzaqc, this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, this.zzaqh, this.zzaqi, this.zzaqj, this.zzaqk, Boolean.valueOf(this.zzaql));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzapw);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzapx);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzapy, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzapz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzaqa);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzaqb);
        SafeParcelWriter.writeString(parcel, 9, this.zzaqc, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzaqd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzaqe, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzaqf, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzaqg, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzaqh, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzaqi, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzaqj, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzaqk, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzaql);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjj zzhv() {
        Bundle bundle = this.zzaqg.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = this.extras;
            this.zzaqg.putBundle("com.google.ads.mediation.admob.AdMobAdapter", this.extras);
        }
        int i = this.versionCode;
        long j = this.zzapw;
        int i2 = this.zzapx;
        List<String> list = this.zzapy;
        boolean z = this.zzapz;
        int i3 = this.zzaqa;
        boolean z2 = this.zzaqb;
        String str = this.zzaqc;
        zzmq zzmq = this.zzaqd;
        Location location = this.zzaqe;
        String str2 = this.zzaqf;
        return new zzjj(i, j, bundle, i2, list, z, i3, z2, str, zzmq, location, str2, this.zzaqg, this.zzaqh, this.zzaqi, this.zzaqj, this.zzaqk, this.zzaql);
    }
}
