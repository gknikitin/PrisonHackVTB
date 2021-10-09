package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new WakeLockEventCreator();
    @SafeParcelable.Field(getter = "getTimeout", mo13061id = 16)
    private final long mTimeout;
    @SafeParcelable.VersionField(mo13067id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getTimeMillis", mo13061id = 2)
    private final long zzxv;
    @SafeParcelable.Field(getter = "getEventType", mo13061id = 11)
    private int zzxw;
    @SafeParcelable.Field(getter = "getElapsedRealtime", mo13061id = 8)
    private final long zzyd;
    private long zzyf;
    @SafeParcelable.Field(getter = "getWakeLockName", mo13061id = 4)
    private final String zzyq;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", mo13061id = 10)
    private final String zzyr;
    @SafeParcelable.Field(getter = "getCodePackage", mo13061id = 17)
    private final String zzys;
    @SafeParcelable.Field(getter = "getWakeLockType", mo13061id = 5)
    private final int zzyt;
    @SafeParcelable.Field(getter = "getCallingPackages", mo13061id = 6)
    private final List<String> zzyu;
    @SafeParcelable.Field(getter = "getEventKey", mo13061id = 12)
    private final String zzyv;
    @SafeParcelable.Field(getter = "getDeviceState", mo13061id = 14)
    private int zzyw;
    @SafeParcelable.Field(getter = "getHostPackage", mo13061id = 13)
    private final String zzyx;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", mo13061id = 15)
    private final float zzyy;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) long j, @SafeParcelable.Param(mo13064id = 11) int i2, @SafeParcelable.Param(mo13064id = 4) String str, @SafeParcelable.Param(mo13064id = 5) int i3, @SafeParcelable.Param(mo13064id = 6) List<String> list, @SafeParcelable.Param(mo13064id = 12) String str2, @SafeParcelable.Param(mo13064id = 8) long j2, @SafeParcelable.Param(mo13064id = 14) int i4, @SafeParcelable.Param(mo13064id = 10) String str3, @SafeParcelable.Param(mo13064id = 13) String str4, @SafeParcelable.Param(mo13064id = 15) float f, @SafeParcelable.Param(mo13064id = 16) long j3, @SafeParcelable.Param(mo13064id = 17) String str5) {
        this.zzal = i;
        this.zzxv = j;
        this.zzxw = i2;
        this.zzyq = str;
        this.zzyr = str3;
        this.zzys = str5;
        this.zzyt = i3;
        this.zzyf = -1;
        this.zzyu = list;
        this.zzyv = str2;
        this.zzyd = j2;
        this.zzyw = i4;
        this.zzyx = str4;
        this.zzyy = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public WakeLockEvent(WakeLockEvent wakeLockEvent) {
        this(wakeLockEvent.zzal, wakeLockEvent.getTimeMillis(), wakeLockEvent.getEventType(), wakeLockEvent.getWakeLockName(), wakeLockEvent.getWakeLockType(), wakeLockEvent.getCallingPackages(), wakeLockEvent.getEventKey(), wakeLockEvent.getElapsedRealtime(), wakeLockEvent.getDeviceState(), wakeLockEvent.getSecondaryWakeLockName(), wakeLockEvent.getHostPackage(), wakeLockEvent.getBeginPowerPercentage(), wakeLockEvent.getTimeout(), wakeLockEvent.getCodePackage());
    }

    public static boolean checkEventType(StatsEvent statsEvent) {
        return 7 == statsEvent.getEventType() || 8 == statsEvent.getEventType() || 9 == statsEvent.getEventType() || 10 == statsEvent.getEventType() || 11 == statsEvent.getEventType() || 12 == statsEvent.getEventType();
    }

    public final StatsEvent ReconstructCloseEvent(StatsEvent statsEvent) {
        if (!(statsEvent instanceof WakeLockEvent)) {
            return statsEvent;
        }
        WakeLockEvent wakeLockEvent = (WakeLockEvent) statsEvent;
        return new WakeLockEvent(wakeLockEvent).setEventType(getEventType()).setDurationMillis(getElapsedRealtime() - wakeLockEvent.getElapsedRealtime());
    }

    public final float getBeginPowerPercentage() {
        return this.zzyy;
    }

    @Nullable
    public final List<String> getCallingPackages() {
        return this.zzyu;
    }

    public final String getCodePackage() {
        return this.zzys;
    }

    public final int getDeviceState() {
        return this.zzyw;
    }

    public final long getDurationMillis() {
        return this.zzyf;
    }

    public final long getElapsedRealtime() {
        return this.zzyd;
    }

    public final String getEventKey() {
        return this.zzyv;
    }

    public final int getEventType() {
        return this.zzxw;
    }

    public final String getHostPackage() {
        return this.zzyx;
    }

    public final String getSecondaryWakeLockName() {
        return this.zzyr;
    }

    public final String getSpecificString() {
        String wakeLockName = getWakeLockName();
        int wakeLockType = getWakeLockType();
        String join = getCallingPackages() == null ? "" : TextUtils.join(",", getCallingPackages());
        int deviceState = getDeviceState();
        String secondaryWakeLockName = getSecondaryWakeLockName() == null ? "" : getSecondaryWakeLockName();
        String hostPackage = getHostPackage() == null ? "" : getHostPackage();
        float beginPowerPercentage = getBeginPowerPercentage();
        String codePackage = getCodePackage() == null ? "" : getCodePackage();
        StringBuilder sb = new StringBuilder(String.valueOf(wakeLockName).length() + 45 + String.valueOf(join).length() + String.valueOf(secondaryWakeLockName).length() + String.valueOf(hostPackage).length() + String.valueOf(codePackage).length());
        sb.append("\t");
        sb.append(wakeLockName);
        sb.append("\t");
        sb.append(wakeLockType);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(deviceState);
        sb.append("\t");
        sb.append(secondaryWakeLockName);
        sb.append("\t");
        sb.append(hostPackage);
        sb.append("\t");
        sb.append(beginPowerPercentage);
        sb.append("\t");
        sb.append(codePackage);
        return sb.toString();
    }

    public final long getTimeMillis() {
        return this.zzxv;
    }

    public final long getTimeout() {
        return this.mTimeout;
    }

    public final String getWakeLockName() {
        return this.zzyq;
    }

    public final int getWakeLockType() {
        return this.zzyt;
    }

    public final WakeLockEvent markTimeOut() {
        int i;
        if (this.mTimeout != 0) {
            this.zzyf = this.mTimeout;
        }
        if (7 == this.zzxw) {
            i = 9;
        } else if (10 != this.zzxw) {
            return this;
        } else {
            i = 12;
        }
        this.zzxw = i;
        return this;
    }

    public final StatsEvent setDurationMillis(long j) {
        this.zzyf = j;
        return this;
    }

    public final StatsEvent setEventType(int i) {
        this.zzxw = i;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, getWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 5, getWakeLockType());
        SafeParcelWriter.writeStringList(parcel, 6, getCallingPackages(), false);
        SafeParcelWriter.writeLong(parcel, 8, getElapsedRealtime());
        SafeParcelWriter.writeString(parcel, 10, getSecondaryWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, getEventKey(), false);
        SafeParcelWriter.writeString(parcel, 13, getHostPackage(), false);
        SafeParcelWriter.writeInt(parcel, 14, getDeviceState());
        SafeParcelWriter.writeFloat(parcel, 15, getBeginPowerPercentage());
        SafeParcelWriter.writeLong(parcel, 16, getTimeout());
        SafeParcelWriter.writeString(parcel, 17, getCodePackage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
