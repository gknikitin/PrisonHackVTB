package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzatv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatv> CREATOR = new zzatw();
    @SafeParcelable.VersionField(mo13067id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", mo13061id = 2, type = "byte[]")
    private zzba zzdhe = null;
    private byte[] zzdhf;

    @SafeParcelable.Constructor
    zzatv(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzdhf = bArr;
        zzwf();
    }

    private final void zzwf() {
        if (this.zzdhe == null && this.zzdhf != null) {
            return;
        }
        if (this.zzdhe != null && this.zzdhf == null) {
            return;
        }
        if (this.zzdhe != null && this.zzdhf != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzdhe == null && this.zzdhf == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzdhf != null ? this.zzdhf : zzbfi.zzb(this.zzdhe), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzba zzwe() {
        if (!(this.zzdhe != null)) {
            try {
                this.zzdhe = (zzba) zzbfi.zza(new zzba(), this.zzdhf);
                this.zzdhf = null;
            } catch (zzbfh e) {
                throw new IllegalStateException(e);
            }
        }
        zzwf();
        return this.zzdhe;
    }
}
