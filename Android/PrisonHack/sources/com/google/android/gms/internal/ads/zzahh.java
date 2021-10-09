package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzadh
public final class zzahh implements RewardItem {
    private final zzagu zzcli;

    public zzahh(zzagu zzagu) {
        this.zzcli = zzagu;
    }

    public final int getAmount() {
        if (this.zzcli == null) {
            return 0;
        }
        try {
            return this.zzcli.getAmount();
        } catch (RemoteException e) {
            zzane.zzc("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        if (this.zzcli == null) {
            return null;
        }
        try {
            return this.zzcli.getType();
        } catch (RemoteException e) {
            zzane.zzc("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
