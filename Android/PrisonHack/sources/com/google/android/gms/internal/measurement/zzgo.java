package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzgo extends zzfa {
    /* access modifiers changed from: private */
    public final zzjs zzajy;
    private Boolean zzanm;
    @Nullable
    private String zzann;

    public zzgo(zzjs zzjs) {
        this(zzjs, (String) null);
    }

    private zzgo(zzjs zzjs, @Nullable String str) {
        Preconditions.checkNotNull(zzjs);
        this.zzajy = zzjs;
        this.zzann = null;
    }

    @BinderThread
    private final void zzb(zzdz zzdz, boolean z) {
        Preconditions.checkNotNull(zzdz);
        zzc(zzdz.packageName, false);
        this.zzajy.zzgc().zzcf(zzdz.zzadm);
    }

    @BinderThread
    private final void zzc(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.zzajy.zzgf().zzis().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzanm == null) {
                    if (!"com.google.android.gms".equals(this.zzann) && !UidVerifier.isGooglePlayServicesUid(this.zzajy.getContext(), Binder.getCallingUid())) {
                        if (!GoogleSignatureVerifier.getInstance(this.zzajy.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z2 = false;
                            this.zzanm = Boolean.valueOf(z2);
                        }
                    }
                    z2 = true;
                    this.zzanm = Boolean.valueOf(z2);
                }
                if (this.zzanm.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzajy.zzgf().zzis().zzg("Measurement Service called with invalid calling package. appId", zzfh.zzbl(str));
                throw e;
            }
        }
        if (this.zzann == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zzajy.getContext(), Binder.getCallingUid(), str)) {
            this.zzann = str;
        }
        if (!str.equals(this.zzann)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (!zzey.zzaih.get().booleanValue() || !this.zzajy.zzge().zzjr()) {
            this.zzajy.zzge().zzc(runnable);
        } else {
            runnable.run();
        }
    }

    @BinderThread
    public final List<zzjz> zza(zzdz zzdz, boolean z) {
        zzb(zzdz, false);
        try {
            List<zzkb> list = (List) this.zzajy.zzge().zzb(new zzhe(this, zzdz)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkb zzkb : list) {
                if (z || !zzkc.zzch(zzkb.name)) {
                    arrayList.add(new zzjz(zzkb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zze("Failed to get user attributes. appId", zzfh.zzbl(zzdz.packageName), e);
            return null;
        }
    }

    @BinderThread
    public final List<zzee> zza(String str, String str2, zzdz zzdz) {
        zzb(zzdz, false);
        try {
            return (List) this.zzajy.zzge().zzb(new zzgw(this, zzdz, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzjz> zza(String str, String str2, String str3, boolean z) {
        zzc(str, true);
        try {
            List<zzkb> list = (List) this.zzajy.zzge().zzb(new zzgv(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkb zzkb : list) {
                if (z || !zzkc.zzch(zzkb.name)) {
                    arrayList.add(new zzjz(zzkb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zze("Failed to get user attributes. appId", zzfh.zzbl(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzjz> zza(String str, String str2, boolean z, zzdz zzdz) {
        zzb(zzdz, false);
        try {
            List<zzkb> list = (List) this.zzajy.zzge().zzb(new zzgu(this, zzdz, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkb zzkb : list) {
                if (z || !zzkc.zzch(zzkb.name)) {
                    arrayList.add(new zzjz(zzkb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zze("Failed to get user attributes. appId", zzfh.zzbl(zzdz.packageName), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zze(new zzhg(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(zzdz zzdz) {
        zzb(zzdz, false);
        zze(new zzhf(this, zzdz));
    }

    @BinderThread
    public final void zza(zzee zzee, zzdz zzdz) {
        Preconditions.checkNotNull(zzee);
        Preconditions.checkNotNull(zzee.zzaeq);
        zzb(zzdz, false);
        zzee zzee2 = new zzee(zzee);
        zzee2.packageName = zzdz.packageName;
        zze(zzee.zzaeq.getValue() == null ? new zzgq(this, zzee2, zzdz) : new zzgr(this, zzee2, zzdz));
    }

    @BinderThread
    public final void zza(zzew zzew, zzdz zzdz) {
        Preconditions.checkNotNull(zzew);
        zzb(zzdz, false);
        zze(new zzgz(this, zzew, zzdz));
    }

    @BinderThread
    public final void zza(zzew zzew, String str, String str2) {
        Preconditions.checkNotNull(zzew);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzha(this, zzew, str));
    }

    @BinderThread
    public final void zza(zzjz zzjz, zzdz zzdz) {
        Preconditions.checkNotNull(zzjz);
        zzb(zzdz, false);
        zze(zzjz.getValue() == null ? new zzhc(this, zzjz, zzdz) : new zzhd(this, zzjz, zzdz));
    }

    @BinderThread
    public final byte[] zza(zzew zzew, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzew);
        zzc(str, true);
        this.zzajy.zzgf().zziy().zzg("Log and bundle. event", this.zzajy.zzgb().zzbi(zzew.name));
        long nanoTime = this.zzajy.zzbt().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzajy.zzge().zzc(new zzhb(this, zzew, str)).get();
            if (bArr == null) {
                this.zzajy.zzgf().zzis().zzg("Log and bundle returned null. appId", zzfh.zzbl(str));
                bArr = new byte[0];
            }
            this.zzajy.zzgf().zziy().zzd("Log and bundle processed. event, size, time_ms", this.zzajy.zzgb().zzbi(zzew.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzajy.zzbt().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zzd("Failed to log and bundle. appId, event, error", zzfh.zzbl(str), this.zzajy.zzgb().zzbi(zzew.name), e);
            return null;
        }
    }

    @BinderThread
    public final void zzb(zzdz zzdz) {
        zzb(zzdz, false);
        zze(new zzgp(this, zzdz));
    }

    @BinderThread
    public final void zzb(zzee zzee) {
        Preconditions.checkNotNull(zzee);
        Preconditions.checkNotNull(zzee.zzaeq);
        zzc(zzee.packageName, true);
        zzee zzee2 = new zzee(zzee);
        zze(zzee.zzaeq.getValue() == null ? new zzgs(this, zzee2) : new zzgt(this, zzee2));
    }

    @BinderThread
    public final String zzc(zzdz zzdz) {
        zzb(zzdz, false);
        return this.zzajy.zzh(zzdz);
    }

    @BinderThread
    public final void zzd(zzdz zzdz) {
        zzc(zzdz.packageName, false);
        zze(new zzgy(this, zzdz));
    }

    @BinderThread
    public final List<zzee> zze(String str, String str2, String str3) {
        zzc(str, true);
        try {
            return (List) this.zzajy.zzge().zzb(new zzgx(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzajy.zzgf().zzis().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }
}
