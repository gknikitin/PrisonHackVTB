package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaef> CREATOR = new zzaeh();
    @SafeParcelable.Field(mo13061id = 6)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo13061id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo13061id = 28)
    public final String zzaco;
    @SafeParcelable.Field(mo13061id = 5)
    public final String zzacp;
    @SafeParcelable.Field(mo13061id = 11)
    public final zzang zzacr;
    @SafeParcelable.Field(mo13061id = 4)
    public final zzjn zzacv;
    @SafeParcelable.Field(mo13061id = 29)
    public final zzpl zzadj;
    @Nullable
    @SafeParcelable.Field(mo13061id = 46)
    public final zzlu zzadl;
    @SafeParcelable.Field(mo13061id = 53)
    public final List<Integer> zzadn;
    @SafeParcelable.Field(mo13061id = 14)
    public final List<String> zzads;
    @SafeParcelable.Field(mo13061id = 20)
    public final float zzagu;
    @SafeParcelable.Field(mo13061id = 42)
    public final boolean zzbss;
    @Nullable
    @SafeParcelable.Field(mo13061id = 2)
    public final Bundle zzccu;
    @SafeParcelable.Field(mo13061id = 3)
    public final zzjj zzccv;
    @Nullable
    @SafeParcelable.Field(mo13061id = 7)
    public final PackageInfo zzccw;
    @SafeParcelable.Field(mo13061id = 8)
    public final String zzccx;
    @SafeParcelable.Field(mo13061id = 9)
    public final String zzccy;
    @SafeParcelable.Field(mo13061id = 10)
    public final String zzccz;
    @SafeParcelable.Field(mo13061id = 12)
    public final Bundle zzcda;
    @SafeParcelable.Field(mo13061id = 13)
    public final int zzcdb;
    @SafeParcelable.Field(mo13061id = 15)
    public final Bundle zzcdc;
    @SafeParcelable.Field(mo13061id = 16)
    public final boolean zzcdd;
    @SafeParcelable.Field(mo13061id = 18)
    public final int zzcde;
    @SafeParcelable.Field(mo13061id = 19)
    public final int zzcdf;
    @SafeParcelable.Field(mo13061id = 21)
    public final String zzcdg;
    @SafeParcelable.Field(mo13061id = 25)
    public final long zzcdh;
    @SafeParcelable.Field(mo13061id = 26)
    public final String zzcdi;
    @Nullable
    @SafeParcelable.Field(mo13061id = 27)
    public final List<String> zzcdj;
    @SafeParcelable.Field(mo13061id = 30)
    public final List<String> zzcdk;
    @SafeParcelable.Field(mo13061id = 31)
    public final long zzcdl;
    @SafeParcelable.Field(mo13061id = 33)
    public final String zzcdm;
    @SafeParcelable.Field(mo13061id = 34)
    public final float zzcdn;
    @SafeParcelable.Field(mo13061id = 35)
    public final int zzcdo;
    @SafeParcelable.Field(mo13061id = 36)
    public final int zzcdp;
    @SafeParcelable.Field(mo13061id = 37)
    public final boolean zzcdq;
    @SafeParcelable.Field(mo13061id = 38)
    public final boolean zzcdr;
    @SafeParcelable.Field(mo13061id = 39)
    public final String zzcds;
    @SafeParcelable.Field(mo13061id = 40)
    public final boolean zzcdt;
    @SafeParcelable.Field(mo13061id = 41)
    public final String zzcdu;
    @SafeParcelable.Field(mo13061id = 43)
    public final int zzcdv;
    @SafeParcelable.Field(mo13061id = 44)
    public final Bundle zzcdw;
    @SafeParcelable.Field(mo13061id = 45)
    public final String zzcdx;
    @SafeParcelable.Field(mo13061id = 47)
    public final boolean zzcdy;
    @SafeParcelable.Field(mo13061id = 48)
    public final Bundle zzcdz;
    @Nullable
    @SafeParcelable.Field(mo13061id = 49)
    public final String zzcea;
    @Nullable
    @SafeParcelable.Field(mo13061id = 50)
    public final String zzceb;
    @Nullable
    @SafeParcelable.Field(mo13061id = 51)
    public final String zzcec;
    @SafeParcelable.Field(mo13061id = 52)
    public final boolean zzced;
    @SafeParcelable.Field(mo13061id = 54)
    public final String zzcee;
    @SafeParcelable.Field(mo13061id = 55)
    public final List<String> zzcef;
    @SafeParcelable.Field(mo13061id = 56)
    public final int zzceg;
    @SafeParcelable.Field(mo13061id = 57)
    public final boolean zzceh;
    @SafeParcelable.Field(mo13061id = 58)
    public final boolean zzcei;
    @SafeParcelable.Field(mo13061id = 59)
    public final boolean zzcej;
    @SafeParcelable.Field(mo13061id = 60)
    public final ArrayList<String> zzcek;

    @SafeParcelable.Constructor
    zzaef(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) Bundle bundle, @SafeParcelable.Param(mo13064id = 3) zzjj zzjj, @SafeParcelable.Param(mo13064id = 4) zzjn zzjn, @SafeParcelable.Param(mo13064id = 5) String str, @SafeParcelable.Param(mo13064id = 6) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo13064id = 7) PackageInfo packageInfo, @SafeParcelable.Param(mo13064id = 8) String str2, @SafeParcelable.Param(mo13064id = 9) String str3, @SafeParcelable.Param(mo13064id = 10) String str4, @SafeParcelable.Param(mo13064id = 11) zzang zzang, @SafeParcelable.Param(mo13064id = 12) Bundle bundle2, @SafeParcelable.Param(mo13064id = 13) int i2, @SafeParcelable.Param(mo13064id = 14) List<String> list, @SafeParcelable.Param(mo13064id = 15) Bundle bundle3, @SafeParcelable.Param(mo13064id = 16) boolean z, @SafeParcelable.Param(mo13064id = 18) int i3, @SafeParcelable.Param(mo13064id = 19) int i4, @SafeParcelable.Param(mo13064id = 20) float f, @SafeParcelable.Param(mo13064id = 21) String str5, @SafeParcelable.Param(mo13064id = 25) long j, @SafeParcelable.Param(mo13064id = 26) String str6, @SafeParcelable.Param(mo13064id = 27) List<String> list2, @SafeParcelable.Param(mo13064id = 28) String str7, @SafeParcelable.Param(mo13064id = 29) zzpl zzpl, @SafeParcelable.Param(mo13064id = 30) List<String> list3, @SafeParcelable.Param(mo13064id = 31) long j2, @SafeParcelable.Param(mo13064id = 33) String str8, @SafeParcelable.Param(mo13064id = 34) float f2, @SafeParcelable.Param(mo13064id = 40) boolean z2, @SafeParcelable.Param(mo13064id = 35) int i5, @SafeParcelable.Param(mo13064id = 36) int i6, @SafeParcelable.Param(mo13064id = 37) boolean z3, @SafeParcelable.Param(mo13064id = 38) boolean z4, @SafeParcelable.Param(mo13064id = 39) String str9, @SafeParcelable.Param(mo13064id = 41) String str10, @SafeParcelable.Param(mo13064id = 42) boolean z5, @SafeParcelable.Param(mo13064id = 43) int i7, @SafeParcelable.Param(mo13064id = 44) Bundle bundle4, @SafeParcelable.Param(mo13064id = 45) String str11, @SafeParcelable.Param(mo13064id = 46) zzlu zzlu, @SafeParcelable.Param(mo13064id = 47) boolean z6, @SafeParcelable.Param(mo13064id = 48) Bundle bundle5, @SafeParcelable.Param(mo13064id = 49) String str12, @SafeParcelable.Param(mo13064id = 50) String str13, @SafeParcelable.Param(mo13064id = 51) String str14, @SafeParcelable.Param(mo13064id = 52) boolean z7, @SafeParcelable.Param(mo13064id = 53) List<Integer> list4, @SafeParcelable.Param(mo13064id = 54) String str15, @SafeParcelable.Param(mo13064id = 55) List<String> list5, @SafeParcelable.Param(mo13064id = 56) int i8, @SafeParcelable.Param(mo13064id = 57) boolean z8, @SafeParcelable.Param(mo13064id = 58) boolean z9, @SafeParcelable.Param(mo13064id = 59) boolean z10, @SafeParcelable.Param(mo13064id = 60) ArrayList<String> arrayList) {
        this.versionCode = i;
        this.zzccu = bundle;
        this.zzccv = zzjj;
        this.zzacv = zzjn;
        this.zzacp = str;
        this.applicationInfo = applicationInfo2;
        this.zzccw = packageInfo;
        this.zzccx = str2;
        this.zzccy = str3;
        this.zzccz = str4;
        this.zzacr = zzang;
        this.zzcda = bundle2;
        this.zzcdb = i2;
        this.zzads = list;
        this.zzcdk = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzcdc = bundle3;
        this.zzcdd = z;
        this.zzcde = i3;
        this.zzcdf = i4;
        this.zzagu = f;
        this.zzcdg = str5;
        this.zzcdh = j;
        this.zzcdi = str6;
        this.zzcdj = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaco = str7;
        this.zzadj = zzpl;
        this.zzcdl = j2;
        this.zzcdm = str8;
        this.zzcdn = f2;
        this.zzcdt = z2;
        this.zzcdo = i5;
        this.zzcdp = i6;
        this.zzcdq = z3;
        this.zzcdr = z4;
        this.zzcds = str9;
        this.zzcdu = str10;
        this.zzbss = z5;
        this.zzcdv = i7;
        this.zzcdw = bundle4;
        this.zzcdx = str11;
        this.zzadl = zzlu;
        this.zzcdy = z6;
        this.zzcdz = bundle5;
        this.zzcea = str12;
        this.zzceb = str13;
        this.zzcec = str14;
        this.zzced = z7;
        this.zzadn = list4;
        this.zzcee = str15;
        this.zzcef = list5;
        this.zzceg = i8;
        this.zzceh = z8;
        this.zzcei = z9;
        this.zzcej = z10;
        this.zzcek = arrayList;
    }

    private zzaef(@Nullable Bundle bundle, zzjj zzjj, zzjn zzjn, String str, ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzang zzang, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzpl zzpl, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzlu zzlu, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList) {
        this(24, bundle, zzjj, zzjn, str, applicationInfo2, packageInfo, str2, str3, str4, zzang, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzpl, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzlu, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaef(com.google.android.gms.internal.ads.zzaeg r92, long r93, java.lang.String r95, java.lang.String r96, java.lang.String r97) {
        /*
            r91 = this;
            r0 = r92
            android.os.Bundle r1 = r0.zzccu
            com.google.android.gms.internal.ads.zzjj r2 = r0.zzccv
            com.google.android.gms.internal.ads.zzjn r3 = r0.zzacv
            java.lang.String r4 = r0.zzacp
            android.content.pm.ApplicationInfo r5 = r0.applicationInfo
            android.content.pm.PackageInfo r6 = r0.zzccw
            java.util.concurrent.Future<java.lang.String> r7 = r0.zzcem
            java.lang.String r8 = ""
            java.lang.Object r7 = com.google.android.gms.internal.ads.zzano.zza(r7, r8)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = r0.zzccy
            java.lang.String r9 = r0.zzccz
            com.google.android.gms.internal.ads.zzang r10 = r0.zzacr
            android.os.Bundle r11 = r0.zzcda
            int r12 = r0.zzcdb
            java.util.List<java.lang.String> r13 = r0.zzads
            java.util.List<java.lang.String> r14 = r0.zzcdk
            android.os.Bundle r15 = r0.zzcdc
            r57 = r15
            boolean r15 = r0.zzcdd
            r58 = r15
            int r15 = r0.zzcde
            r59 = r15
            int r15 = r0.zzcdf
            r60 = r15
            float r15 = r0.zzagu
            r61 = r15
            java.lang.String r15 = r0.zzcdg
            r62 = r14
            r63 = r15
            long r14 = r0.zzcdh
            r64 = r14
            java.lang.String r15 = r0.zzcdi
            java.util.List<java.lang.String> r14 = r0.zzcdj
            r66 = r15
            java.lang.String r15 = r0.zzaco
            r67 = r15
            com.google.android.gms.internal.ads.zzpl r15 = r0.zzadj
            r68 = r15
            java.lang.String r15 = r0.zzcdm
            r69 = r15
            float r15 = r0.zzcdn
            r70 = r15
            boolean r15 = r0.zzcdt
            r71 = r15
            int r15 = r0.zzcdo
            r72 = r15
            int r15 = r0.zzcdp
            r73 = r15
            boolean r15 = r0.zzcdq
            r74 = r15
            boolean r15 = r0.zzcdr
            r75 = r14
            java.util.concurrent.Future<java.lang.String> r14 = r0.zzcel
            r76 = r15
            java.lang.String r15 = ""
            r77 = r13
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.SECONDS
            r78 = r11
            r79 = r12
            r11 = 1
            java.lang.Object r11 = com.google.android.gms.internal.ads.zzano.zza(r14, r15, (long) r11, (java.util.concurrent.TimeUnit) r13)
            r36 = r11
            java.lang.String r36 = (java.lang.String) r36
            java.lang.String r15 = r0.zzcdu
            boolean r14 = r0.zzbss
            int r13 = r0.zzcdv
            android.os.Bundle r12 = r0.zzcdw
            java.lang.String r11 = r0.zzcdx
            r80 = r15
            com.google.android.gms.internal.ads.zzlu r15 = r0.zzadl
            r81 = r15
            boolean r15 = r0.zzcdy
            r82 = r15
            android.os.Bundle r15 = r0.zzcdz
            r83 = r15
            boolean r15 = r0.zzced
            r84 = r15
            java.util.List<java.lang.Integer> r15 = r0.zzadn
            r85 = r15
            java.lang.String r15 = r0.zzcee
            r86 = r15
            java.util.List<java.lang.String> r15 = r0.zzcef
            r87 = r15
            int r15 = r0.zzceg
            r88 = r15
            boolean r15 = r0.zzceh
            r89 = r15
            boolean r15 = r0.zzcei
            r90 = r15
            boolean r15 = r0.zzcej
            java.util.ArrayList<java.lang.String> r0 = r0.zzcek
            r56 = r0
            r0 = r91
            r41 = r11
            r11 = r78
            r40 = r12
            r12 = r79
            r39 = r13
            r13 = r77
            r38 = r14
            r21 = r64
            r24 = r75
            r14 = r62
            r55 = r15
            r16 = r58
            r17 = r59
            r18 = r60
            r19 = r61
            r20 = r63
            r23 = r66
            r25 = r67
            r26 = r68
            r29 = r69
            r30 = r70
            r31 = r71
            r32 = r72
            r33 = r73
            r34 = r74
            r35 = r76
            r37 = r80
            r42 = r81
            r43 = r82
            r44 = r83
            r48 = r84
            r49 = r85
            r50 = r86
            r51 = r87
            r52 = r88
            r53 = r89
            r54 = r90
            r15 = r57
            r27 = r93
            r45 = r95
            r46 = r96
            r47 = r97
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaef.<init>(com.google.android.gms.internal.ads.zzaeg, long, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzccu, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzccv, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzacv, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzacp, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzccw, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzccx, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzccy, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzccz, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzacr, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzcda, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzcdb);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzads, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzcdc, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzcdd);
        SafeParcelWriter.writeInt(parcel, 18, this.zzcde);
        SafeParcelWriter.writeInt(parcel, 19, this.zzcdf);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzagu);
        SafeParcelWriter.writeString(parcel, 21, this.zzcdg, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzcdh);
        SafeParcelWriter.writeString(parcel, 26, this.zzcdi, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzcdj, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzaco, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzadj, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzcdk, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzcdl);
        SafeParcelWriter.writeString(parcel, 33, this.zzcdm, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzcdn);
        SafeParcelWriter.writeInt(parcel, 35, this.zzcdo);
        SafeParcelWriter.writeInt(parcel, 36, this.zzcdp);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzcdq);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzcdr);
        SafeParcelWriter.writeString(parcel, 39, this.zzcds, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzcdt);
        SafeParcelWriter.writeString(parcel, 41, this.zzcdu, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzbss);
        SafeParcelWriter.writeInt(parcel, 43, this.zzcdv);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzcdw, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzcdx, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzadl, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzcdy);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzcdz, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzcea, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzceb, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzcec, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzced);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzadn, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzcee, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzcef, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzceg);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzceh);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzcei);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzcej);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzcek, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
