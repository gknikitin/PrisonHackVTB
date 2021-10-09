package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class zzes {
    final String name;
    final long zzafs;
    final long zzaft;
    final long zzafu;
    final long zzafv;
    final Long zzafw;
    final Long zzafx;
    final Boolean zzafy;
    final String zzti;

    zzes(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = false;
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        Preconditions.checkArgument(j7 >= 0 ? true : z);
        this.zzti = str;
        this.name = str2;
        this.zzafs = j5;
        this.zzaft = j6;
        this.zzafu = j3;
        this.zzafv = j7;
        this.zzafw = l;
        this.zzafx = l2;
        this.zzafy = bool;
    }

    /* access modifiers changed from: package-private */
    public final zzes zza(Long l, Long l2, Boolean bool) {
        return new zzes(this.zzti, this.name, this.zzafs, this.zzaft, this.zzafu, this.zzafv, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* access modifiers changed from: package-private */
    public final zzes zzac(long j) {
        return new zzes(this.zzti, this.name, this.zzafs, this.zzaft, j, this.zzafv, this.zzafw, this.zzafx, this.zzafy);
    }

    /* access modifiers changed from: package-private */
    public final zzes zzad(long j) {
        return new zzes(this.zzti, this.name, this.zzafs, this.zzaft, this.zzafu, j, this.zzafw, this.zzafx, this.zzafy);
    }

    /* access modifiers changed from: package-private */
    public final zzes zzii() {
        String str = this.zzti;
        String str2 = this.name;
        long j = this.zzafs + 1;
        long j2 = this.zzaft + 1;
        long j3 = this.zzafu;
        long j4 = this.zzafv;
        return new zzes(str, str2, j, j2, j3, j4, this.zzafw, this.zzafx, this.zzafy);
    }
}
