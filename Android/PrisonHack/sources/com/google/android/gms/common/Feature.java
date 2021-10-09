package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamite.ProviderConstants;

@SafeParcelable.Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new FeatureCreator();
    @SafeParcelable.Field(getter = "getName", mo13061id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getOldVersion", mo13061id = 2)
    @Deprecated
    private final int zzaq;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", mo13061id = 3)
    private final long zzar;

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(mo13064id = 1) String str, @SafeParcelable.Param(mo13064id = 2) int i, @SafeParcelable.Param(mo13064id = 3) long j) {
        this.name = str;
        this.zzaq = i;
        this.zzar = j;
    }

    public Feature(String str, long j) {
        this.name = str;
        this.zzar = j;
        this.zzaq = -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return ((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion();
        }
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        return this.zzar == -1 ? (long) this.zzaq : this.zzar;
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add(ProviderConstants.API_COLNAME_FEATURE_VERSION, Long.valueOf(getVersion())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzaq);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
