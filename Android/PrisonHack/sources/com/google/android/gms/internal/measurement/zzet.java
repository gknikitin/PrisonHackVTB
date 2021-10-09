package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzet extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzet> CREATOR = new zzev();
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "z", mo13061id = 2)
    public final Bundle zzafz;

    @SafeParcelable.Constructor
    zzet(@SafeParcelable.Param(mo13064id = 2) Bundle bundle) {
        this.zzafz = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object get(String str) {
        return this.zzafz.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Long getLong(String str) {
        return Long.valueOf(this.zzafz.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str) {
        return this.zzafz.getString(str);
    }

    public final Iterator<String> iterator() {
        return new zzeu(this);
    }

    public final int size() {
        return this.zzafz.size();
    }

    public final String toString() {
        return this.zzafz.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzij(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final Double zzbg(String str) {
        return Double.valueOf(this.zzafz.getDouble(str));
    }

    public final Bundle zzij() {
        return new Bundle(this.zzafz);
    }
}
