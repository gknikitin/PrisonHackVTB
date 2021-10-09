package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@zzadh
@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaig> CREATOR = new zzaih();
    @SafeParcelable.Field(mo13061id = 2)
    public final String type;
    @SafeParcelable.Field(mo13061id = 3)
    public final int zzcmk;

    public zzaig(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @SafeParcelable.Constructor
    public zzaig(@SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) int i) {
        this.type = str;
        this.zzcmk = i;
    }

    @Nullable
    public static zzaig zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzaig(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Nullable
    public static zzaig zzce(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaig)) {
            return false;
        }
        zzaig zzaig = (zzaig) obj;
        return Objects.equal(this.type, zzaig.type) && Objects.equal(Integer.valueOf(this.zzcmk), Integer.valueOf(zzaig.zzcmk));
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzcmk));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcmk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
