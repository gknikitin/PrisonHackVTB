package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.ads.zzaxr;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzaum<P> {
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    private ConcurrentMap<String, List<zzaun<P>>> zzdhk = new ConcurrentHashMap();
    private zzaun<P> zzdhl;

    /* access modifiers changed from: protected */
    public final zzaun<P> zza(P p, zzaxr.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        byte b;
        ByteBuffer byteBuffer;
        switch (zzaud.zzdhh[zzb.zzzs().ordinal()]) {
            case 1:
            case 2:
                byteBuffer = ByteBuffer.allocate(5);
                b = 0;
                break;
            case 3:
                byteBuffer = ByteBuffer.allocate(5);
                b = 1;
                break;
            case 4:
                bArr = zzauc.zzdhg;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        bArr = byteBuffer.put(b).putInt(zzb.zzzr()).array();
        zzaun<P> zzaun = new zzaun<>(p, bArr, zzb.zzzq(), zzb.zzzs());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzaun);
        String str = new String(zzaun.zzwj(), UTF_8);
        List list = (List) this.zzdhk.put(str, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(zzaun);
            this.zzdhk.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzaun;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzaun<P> zzaun) {
        this.zzdhl = zzaun;
    }

    public final zzaun<P> zzwh() {
        return this.zzdhl;
    }
}
