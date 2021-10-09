package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjd;

@zzadh
@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    @SafeParcelable.Field(mo13061id = 11)
    public final int orientation;
    @SafeParcelable.Field(mo13061id = 13)
    public final String url;
    @SafeParcelable.Field(mo13061id = 14)
    public final zzang zzacr;
    @SafeParcelable.Field(mo13061id = 2)
    public final zzc zzbyl;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", mo13061id = 3, type = "android.os.IBinder")
    public final zzjd zzbym;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", mo13061id = 4, type = "android.os.IBinder")
    public final zzn zzbyn;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", mo13061id = 5, type = "android.os.IBinder")
    public final zzaqw zzbyo;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", mo13061id = 6, type = "android.os.IBinder")
    public final zzd zzbyp;
    @SafeParcelable.Field(mo13061id = 7)
    public final String zzbyq;
    @SafeParcelable.Field(mo13061id = 8)
    public final boolean zzbyr;
    @SafeParcelable.Field(mo13061id = 9)
    public final String zzbys;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", mo13061id = 10, type = "android.os.IBinder")
    public final zzt zzbyt;
    @SafeParcelable.Field(mo13061id = 12)
    public final int zzbyu;
    @SafeParcelable.Field(mo13061id = 16)
    public final String zzbyv;
    @SafeParcelable.Field(mo13061id = 17)
    public final zzaq zzbyw;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", mo13061id = 18, type = "android.os.IBinder")
    public final zzb zzbyx;

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param(mo13064id = 2) zzc zzc, @SafeParcelable.Param(mo13064id = 3) IBinder iBinder, @SafeParcelable.Param(mo13064id = 4) IBinder iBinder2, @SafeParcelable.Param(mo13064id = 5) IBinder iBinder3, @SafeParcelable.Param(mo13064id = 6) IBinder iBinder4, @SafeParcelable.Param(mo13064id = 7) String str, @SafeParcelable.Param(mo13064id = 8) boolean z, @SafeParcelable.Param(mo13064id = 9) String str2, @SafeParcelable.Param(mo13064id = 10) IBinder iBinder5, @SafeParcelable.Param(mo13064id = 11) int i, @SafeParcelable.Param(mo13064id = 12) int i2, @SafeParcelable.Param(mo13064id = 13) String str3, @SafeParcelable.Param(mo13064id = 14) zzang zzang, @SafeParcelable.Param(mo13064id = 16) String str4, @SafeParcelable.Param(mo13064id = 17) zzaq zzaq, @SafeParcelable.Param(mo13064id = 18) IBinder iBinder6) {
        this.zzbyl = zzc;
        this.zzbym = (zzjd) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzbyn = (zzn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzbyo = (zzaqw) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzbyx = (zzb) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzbyp = (zzd) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzbyq = str;
        this.zzbyr = z;
        this.zzbys = str2;
        this.zzbyt = (zzt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzbyu = i2;
        this.url = str3;
        this.zzacr = zzang;
        this.zzbyv = str4;
        this.zzbyw = zzaq;
    }

    public AdOverlayInfoParcel(zzc zzc, zzjd zzjd, zzn zzn, zzt zzt, zzang zzang) {
        this.zzbyl = zzc;
        this.zzbym = zzjd;
        this.zzbyn = zzn;
        this.zzbyo = null;
        this.zzbyx = null;
        this.zzbyp = null;
        this.zzbyq = null;
        this.zzbyr = false;
        this.zzbys = null;
        this.zzbyt = zzt;
        this.orientation = -1;
        this.zzbyu = 4;
        this.url = null;
        this.zzacr = zzang;
        this.zzbyv = null;
        this.zzbyw = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzb zzb, zzd zzd, zzt zzt, zzaqw zzaqw, boolean z, int i, String str, zzang zzang) {
        this.zzbyl = null;
        this.zzbym = zzjd;
        this.zzbyn = zzn;
        this.zzbyo = zzaqw;
        this.zzbyx = zzb;
        this.zzbyp = zzd;
        this.zzbyq = null;
        this.zzbyr = z;
        this.zzbys = null;
        this.zzbyt = zzt;
        this.orientation = i;
        this.zzbyu = 3;
        this.url = str;
        this.zzacr = zzang;
        this.zzbyv = null;
        this.zzbyw = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzb zzb, zzd zzd, zzt zzt, zzaqw zzaqw, boolean z, int i, String str, String str2, zzang zzang) {
        this.zzbyl = null;
        this.zzbym = zzjd;
        this.zzbyn = zzn;
        this.zzbyo = zzaqw;
        this.zzbyx = zzb;
        this.zzbyp = zzd;
        this.zzbyq = str2;
        this.zzbyr = z;
        this.zzbys = str;
        this.zzbyt = zzt;
        this.orientation = i;
        this.zzbyu = 3;
        this.url = null;
        this.zzacr = zzang;
        this.zzbyv = null;
        this.zzbyw = null;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzt zzt, zzaqw zzaqw, int i, zzang zzang, String str, zzaq zzaq) {
        this.zzbyl = null;
        this.zzbym = zzjd;
        this.zzbyn = zzn;
        this.zzbyo = zzaqw;
        this.zzbyx = null;
        this.zzbyp = null;
        this.zzbyq = null;
        this.zzbyr = false;
        this.zzbys = null;
        this.zzbyt = zzt;
        this.orientation = i;
        this.zzbyu = 1;
        this.url = null;
        this.zzacr = zzang;
        this.zzbyv = str;
        this.zzbyw = zzaq;
    }

    public AdOverlayInfoParcel(zzjd zzjd, zzn zzn, zzt zzt, zzaqw zzaqw, boolean z, int i, zzang zzang) {
        this.zzbyl = null;
        this.zzbym = zzjd;
        this.zzbyn = zzn;
        this.zzbyo = zzaqw;
        this.zzbyx = null;
        this.zzbyp = null;
        this.zzbyq = null;
        this.zzbyr = z;
        this.zzbys = null;
        this.zzbyt = zzt;
        this.orientation = i;
        this.zzbyu = 2;
        this.url = null;
        this.zzacr = zzang;
        this.zzbyv = null;
        this.zzbyw = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzbyl, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzbym).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzbyn).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzbyo).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzbyp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbyq, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbyr);
        SafeParcelWriter.writeString(parcel, 9, this.zzbys, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzbyt).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzbyu);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzacr, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzbyv, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzbyw, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzbyx).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
