package com.google.firebase.iid;

import android.os.Bundle;

final class zzad extends zzae<Void> {
    zzad(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            finish(null);
        } else {
            zza(new zzaf(4, "Invalid response to one way request"));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzv() {
        return true;
    }
}
