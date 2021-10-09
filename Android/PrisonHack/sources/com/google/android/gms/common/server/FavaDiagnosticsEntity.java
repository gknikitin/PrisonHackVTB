package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new FavaDiagnosticsEntityCreator();
    public static final String EXTRA_NAMESPACE = "namespace";
    public static final String EXTRA_TYPE_NUM = "typeNum";
    @SafeParcelable.Field(mo13061id = 2)
    public final String namespace;
    @SafeParcelable.Field(mo13061id = 3)
    public final int typeNum;
    @SafeParcelable.VersionField(mo13067id = 1)
    private final int zzal;

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) int i2) {
        this.zzal = i;
        this.namespace = str;
        this.typeNum = i2;
    }

    public FavaDiagnosticsEntity(String str, int i) {
        this.zzal = 1;
        this.namespace = str;
        this.typeNum = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, this.namespace, false);
        SafeParcelWriter.writeInt(parcel, 3, this.typeNum);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
