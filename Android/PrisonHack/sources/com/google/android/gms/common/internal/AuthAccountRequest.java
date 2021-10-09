package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "AuthAccountRequestCreator")
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new AuthAccountRequestCreator();
    @SafeParcelable.VersionField(mo13067id = 1)
    private final int zzal;
    @SafeParcelable.Field(mo13061id = 2)
    @Deprecated
    private final IBinder zzqv;
    @SafeParcelable.Field(mo13061id = 3)
    private final Scope[] zzqw;
    @SafeParcelable.Field(mo13061id = 4)
    private Integer zzqx;
    @SafeParcelable.Field(mo13061id = 5)
    private Integer zzqy;
    @SafeParcelable.Field(mo13061id = 6, type = "android.accounts.Account")
    private Account zzs;

    @SafeParcelable.Constructor
    AuthAccountRequest(@SafeParcelable.Param(mo13064id = 1) int i, @SafeParcelable.Param(mo13064id = 2) IBinder iBinder, @SafeParcelable.Param(mo13064id = 3) Scope[] scopeArr, @SafeParcelable.Param(mo13064id = 4) Integer num, @SafeParcelable.Param(mo13064id = 5) Integer num2, @SafeParcelable.Param(mo13064id = 6) Account account) {
        this.zzal = i;
        this.zzqv = iBinder;
        this.zzqw = scopeArr;
        this.zzqx = num;
        this.zzqy = num2;
        this.zzs = account;
    }

    public AuthAccountRequest(Account account, Set<Scope> set) {
        this(3, (IBinder) null, (Scope[]) set.toArray(new Scope[set.size()]), (Integer) null, (Integer) null, (Account) Preconditions.checkNotNull(account));
    }

    @Deprecated
    public AuthAccountRequest(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        this(3, iAccountAccessor.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]), (Integer) null, (Integer) null, (Account) null);
    }

    public Account getAccount() {
        if (this.zzs != null) {
            return this.zzs;
        }
        if (this.zzqv != null) {
            return AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(this.zzqv));
        }
        return null;
    }

    @Nullable
    public Integer getOauthPolicy() {
        return this.zzqx;
    }

    @Nullable
    public Integer getPolicyAction() {
        return this.zzqy;
    }

    public Set<Scope> getScopes() {
        return new HashSet(Arrays.asList(this.zzqw));
    }

    public AuthAccountRequest setOauthPolicy(@Nullable Integer num) {
        this.zzqx = num;
        return this;
    }

    public AuthAccountRequest setPolicyAction(@Nullable Integer num) {
        this.zzqy = num;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzqv, false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzqw, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 4, this.zzqx, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.zzqy, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzs, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
