package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043 A[SYNTHETIC, Splitter:B:24:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(java.io.InputStream r4, java.io.File r5, com.bumptech.glide.load.Options r6) {
        /*
            r3 = this;
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r3.byteArrayPool
            java.lang.Class<byte[]> r0 = byte[].class
            r1 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r6 = r6.get(r1, r0)
            byte[] r6 = (byte[]) r6
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0030 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0030 }
        L_0x0013:
            int r5 = r4.read(r6)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r1 = -1
            if (r5 == r1) goto L_0x001e
            r2.write(r6, r0, r5)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            goto L_0x0013
        L_0x001e:
            r2.close()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r0 = 1
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0046
        L_0x0028:
            r4 = move-exception
            r1 = r2
            goto L_0x004e
        L_0x002b:
            r4 = move-exception
            r1 = r2
            goto L_0x0031
        L_0x002e:
            r4 = move-exception
            goto L_0x004e
        L_0x0030:
            r4 = move-exception
        L_0x0031:
            java.lang.String r5 = "StreamEncoder"
            r2 = 3
            boolean r5 = android.util.Log.isLoggable(r5, r2)     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x0041
            java.lang.String r5 = "StreamEncoder"
            java.lang.String r2 = "Failed to encode data onto the OutputStream"
            android.util.Log.d(r5, r2, r4)     // Catch:{ all -> 0x002e }
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r3.byteArrayPool
            java.lang.Class<byte[]> r5 = byte[].class
            r4.put(r6, r5)
            return r0
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r3.byteArrayPool
            java.lang.Class<byte[]> r0 = byte[].class
            r5.put(r6, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.encode(java.io.InputStream, java.io.File, com.bumptech.glide.load.Options):boolean");
    }
}
