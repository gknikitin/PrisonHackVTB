package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zzap extends zzat {
    private final /* synthetic */ zzaj zzhv;
    private final ArrayList<Api.Client> zzib;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(zzaj zzaj, ArrayList<Api.Client> arrayList) {
        super(zzaj, (zzak) null);
        this.zzhv = zzaj;
        this.zzib = arrayList;
    }

    @WorkerThread
    public final void zzaq() {
        this.zzhv.zzhf.zzfq.zzim = this.zzhv.zzaw();
        ArrayList arrayList = this.zzib;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Api.Client) obj).getRemoteService(this.zzhv.zzhr, this.zzhv.zzhf.zzfq.zzim);
        }
    }
}
