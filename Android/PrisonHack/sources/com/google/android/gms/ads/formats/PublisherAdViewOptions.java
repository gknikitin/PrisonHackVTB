package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzjp;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlb;

@zzadh
@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo13061id = 1)
    private final boolean zzvm;
    @Nullable
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo13061id = 2, type = "android.os.IBinder")
    private final zzla zzvn;
    @Nullable
    private AppEventListener zzvo;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzvm = false;
        /* access modifiers changed from: private */
        public AppEventListener zzvo;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzvo = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzvm = z;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzvm = builder.zzvm;
        this.zzvo = builder.zzvo;
        this.zzvn = this.zzvo != null ? new zzjp(this.zzvo) : null;
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(mo13064id = 1) boolean z, @Nullable @SafeParcelable.Param(mo13064id = 2) IBinder iBinder) {
        this.zzvm = z;
        this.zzvn = iBinder != null ? zzlb.zzd(iBinder) : null;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzvo;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzvm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzvn == null ? null : this.zzvn.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzla zzbg() {
        return this.zzvn;
    }
}
