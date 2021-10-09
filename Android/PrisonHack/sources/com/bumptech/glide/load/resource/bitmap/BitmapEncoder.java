package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|(2:35|36)|37|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d2 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A[SYNTHETIC, Splitter:B:24:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A[SYNTHETIC, Splitter:B:35:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, java.io.File r9, com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r0 = r7.getFormat(r8, r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encode: ["
            r1.append(r2)
            int r2 = r8.getWidth()
            r1.append(r2)
            java.lang.String r2 = "x"
            r1.append(r2)
            int r2 = r8.getHeight()
            r1.append(r2)
            java.lang.String r2 = "] "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.support.p000v4.p002os.TraceCompat.beginSection(r1)
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00d3 }
            com.bumptech.glide.load.Option<java.lang.Integer> r3 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00d3 }
            java.lang.Object r3 = r10.get(r3)     // Catch:{ all -> 0x00d3 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00d3 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00d3 }
            r4 = 0
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0062 }
            r8.compress(r0, r3, r6)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r6.close()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r4 = 1
            if (r6 == 0) goto L_0x0078
            r6.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0078
        L_0x005a:
            r8 = move-exception
            r5 = r6
            goto L_0x00cd
        L_0x005d:
            r9 = move-exception
            r5 = r6
            goto L_0x0063
        L_0x0060:
            r8 = move-exception
            goto L_0x00cd
        L_0x0062:
            r9 = move-exception
        L_0x0063:
            java.lang.String r3 = "BitmapEncoder"
            r6 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r6)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = "BitmapEncoder"
            java.lang.String r6 = "Failed to encode Bitmap"
            android.util.Log.d(r3, r6, r9)     // Catch:{ all -> 0x0060 }
        L_0x0073:
            if (r5 == 0) goto L_0x0078
            r5.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            java.lang.String r9 = "BitmapEncoder"
            r3 = 2
            boolean r9 = android.util.Log.isLoggable(r9, r3)     // Catch:{ all -> 0x00d3 }
            if (r9 == 0) goto L_0x00c9
            java.lang.String r9 = "BitmapEncoder"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r3.<init>()     // Catch:{ all -> 0x00d3 }
            java.lang.String r5 = "Compressed with type: "
            r3.append(r5)     // Catch:{ all -> 0x00d3 }
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = " of size "
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            int r0 = com.bumptech.glide.util.Util.getBitmapByteSize(r8)     // Catch:{ all -> 0x00d3 }
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = " in "
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x00d3 }
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = ", options format: "
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r0 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00d3 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x00d3 }
            r3.append(r10)     // Catch:{ all -> 0x00d3 }
            java.lang.String r10 = ", hasAlpha: "
            r3.append(r10)     // Catch:{ all -> 0x00d3 }
            boolean r8 = r8.hasAlpha()     // Catch:{ all -> 0x00d3 }
            r3.append(r8)     // Catch:{ all -> 0x00d3 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x00d3 }
            android.util.Log.v(r9, r8)     // Catch:{ all -> 0x00d3 }
        L_0x00c9:
            android.support.p000v4.p002os.TraceCompat.endSection()
            return r4
        L_0x00cd:
            if (r5 == 0) goto L_0x00d2
            r5.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00d2:
            throw r8     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r8 = move-exception
            android.support.p000v4.p002os.TraceCompat.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
