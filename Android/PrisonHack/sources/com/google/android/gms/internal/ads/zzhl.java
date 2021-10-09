package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzadh
@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzhl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhl> CREATOR = new zzhm();
    @Nullable
    @SafeParcelable.Field(mo13061id = 2)
    public final String url;
    @SafeParcelable.Field(mo13061id = 3)
    private final long zzajv;
    @SafeParcelable.Field(mo13061id = 4)
    private final String zzajw;
    @SafeParcelable.Field(mo13061id = 5)
    private final String zzajx;
    @SafeParcelable.Field(mo13061id = 6)
    private final String zzajy;
    @SafeParcelable.Field(mo13061id = 7)
    private final Bundle zzajz;
    @SafeParcelable.Field(mo13061id = 8)
    private final boolean zzaka;
    @SafeParcelable.Field(mo13061id = 9)
    private long zzakb;

    @SafeParcelable.Constructor
    zzhl(@Nullable @SafeParcelable.Param(mo13064id = 2) String str, @SafeParcelable.Param(mo13064id = 3) long j, @SafeParcelable.Param(mo13064id = 4) String str2, @SafeParcelable.Param(mo13064id = 5) String str3, @SafeParcelable.Param(mo13064id = 6) String str4, @SafeParcelable.Param(mo13064id = 7) Bundle bundle, @SafeParcelable.Param(mo13064id = 8) boolean z, @SafeParcelable.Param(mo13064id = 9) long j2) {
        this.url = str;
        this.zzajv = j;
        this.zzajw = str2 == null ? "" : str2;
        this.zzajx = str3 == null ? "" : str3;
        this.zzajy = str4 == null ? "" : str4;
        this.zzajz = bundle == null ? new Bundle() : bundle;
        this.zzaka = z;
        this.zzakb = j2;
    }

    @Nullable
    public static zzhl zzaa(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzhl zzd(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzakb.zzdk(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String next : zzbv.zzem().zzh(uri)) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri.getQueryParameter(next));
                }
            }
            return new zzhl(queryParameter, parseLong, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzakb.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzajv);
        SafeParcelWriter.writeString(parcel, 4, this.zzajw, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzajx, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajy, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzajz, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzaka);
        SafeParcelWriter.writeLong(parcel, 9, this.zzakb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
