package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBufferSafeParcelable;

final class zzag extends zzae<Bundle> {
    zzag(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(DataBufferSafeParcelable.DATA_FIELD);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        finish(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzv() {
        return false;
    }
}
