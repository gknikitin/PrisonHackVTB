package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    private static final int WORK_BUFFER_SIZE = 16384;
    @ColorInt
    private int[] act;
    @NonNull
    private Bitmap.Config bitmapConfig;
    private GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;
    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    @Nullable
    private byte[] workBuffer;
    private int workBufferPosition;
    private int workBufferSize;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider2, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider2);
        setData(gifHeader, byteBuffer, i);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider2) {
        this.pct = new int[256];
        this.workBufferSize = 0;
        this.workBufferPosition = 0;
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getStatus() {
        return this.status;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public int getDelay(int i) {
        if (i < 0 || i >= this.header.frameCount) {
            return -1;
        }
        return this.header.frames.get(i).delay;
    }

    public int getNextDelay() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            return 0;
        }
        return getDelay(this.framePointer);
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        return this.header.loopCount;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount == 0) {
            return 0;
        }
        return this.header.loopCount + 1;
    }

    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00db, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r7.header     // Catch:{ all -> 0x00dc }
            int r0 = r0.frameCount     // Catch:{ all -> 0x00dc }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.framePointer     // Catch:{ all -> 0x00dc }
            if (r0 >= 0) goto L_0x003b
        L_0x000d:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r3.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r7.header     // Catch:{ all -> 0x00dc }
            int r4 = r4.frameCount     // Catch:{ all -> 0x00dc }
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            int r4 = r7.framePointer     // Catch:{ all -> 0x00dc }
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x0039:
            r7.status = r2     // Catch:{ all -> 0x00dc }
        L_0x003b:
            int r0 = r7.status     // Catch:{ all -> 0x00dc }
            r3 = 0
            if (r0 == r2) goto L_0x00ba
            int r0 = r7.status     // Catch:{ all -> 0x00dc }
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00ba
        L_0x0047:
            r0 = 0
            r7.status = r0     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r7.header     // Catch:{ all -> 0x00dc }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r4 = r4.frames     // Catch:{ all -> 0x00dc }
            int r5 = r7.framePointer     // Catch:{ all -> 0x00dc }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.gifdecoder.GifFrame r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4     // Catch:{ all -> 0x00dc }
            int r5 = r7.framePointer     // Catch:{ all -> 0x00dc }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x0066
            com.bumptech.glide.gifdecoder.GifHeader r6 = r7.header     // Catch:{ all -> 0x00dc }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r6 = r6.frames     // Catch:{ all -> 0x00dc }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00dc }
            goto L_0x0067
        L_0x0066:
            r5 = r3
        L_0x0067:
            int[] r6 = r4.lct     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x006e
            int[] r6 = r4.lct     // Catch:{ all -> 0x00dc }
            goto L_0x0072
        L_0x006e:
            com.bumptech.glide.gifdecoder.GifHeader r6 = r7.header     // Catch:{ all -> 0x00dc }
            int[] r6 = r6.gct     // Catch:{ all -> 0x00dc }
        L_0x0072:
            r7.act = r6     // Catch:{ all -> 0x00dc }
            int[] r6 = r7.act     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r1.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00dc }
            int r4 = r7.framePointer     // Catch:{ all -> 0x00dc }
            r1.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00dc }
        L_0x0098:
            r7.status = r2     // Catch:{ all -> 0x00dc }
            monitor-exit(r7)
            return r3
        L_0x009c:
            boolean r1 = r4.transparency     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x00b4
            int[] r1 = r7.act     // Catch:{ all -> 0x00dc }
            int[] r2 = r7.pct     // Catch:{ all -> 0x00dc }
            int[] r3 = r7.act     // Catch:{ all -> 0x00dc }
            int r3 = r3.length     // Catch:{ all -> 0x00dc }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00dc }
            int[] r1 = r7.pct     // Catch:{ all -> 0x00dc }
            r7.act = r1     // Catch:{ all -> 0x00dc }
            int[] r1 = r7.act     // Catch:{ all -> 0x00dc }
            int r2 = r4.transIndex     // Catch:{ all -> 0x00dc }
            r1[r2] = r0     // Catch:{ all -> 0x00dc }
        L_0x00b4:
            android.graphics.Bitmap r0 = r7.setPixels(r4, r5)     // Catch:{ all -> 0x00dc }
            monitor-exit(r7)
            return r0
        L_0x00ba:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00da
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r1.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            int r2 = r7.status     // Catch:{ all -> 0x00dc }
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00dc }
        L_0x00da:
            monitor-exit(r7)
            return r3
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    public void clear() {
        this.header = null;
        if (this.mainPixels != null) {
            this.bitmapProvider.release(this.mainPixels);
        }
        if (this.mainScratch != null) {
            this.bitmapProvider.release(this.mainScratch);
        }
        if (this.previousImage != null) {
            this.bitmapProvider.release(this.previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = false;
        if (this.block != null) {
            this.bitmapProvider.release(this.block);
        }
        if (this.workBuffer != null) {
            this.bitmapProvider.release(this.workBuffer);
        }
    }

    public synchronized void setData(GifHeader gifHeader, byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public synchronized void setData(GifHeader gifHeader, ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public synchronized void setData(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            try {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            int highestOneBit = Integer.highestOneBit(i);
            this.status = 0;
            this.header = gifHeader;
            this.isFirstFrameTransparent = false;
            this.framePointer = -1;
            this.rawData = byteBuffer.asReadOnlyBuffer();
            this.rawData.position(0);
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.sampleSize = highestOneBit;
            this.downsampledWidth = gifHeader.width / highestOneBit;
            this.downsampledHeight = gifHeader.height / highestOneBit;
            this.mainPixels = this.bitmapProvider.obtainByteArray(gifHeader.width * gifHeader.height);
            this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    public synchronized int read(byte[] bArr) {
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            setData(this.header, bArr);
        }
        return this.status;
    }

    public void setDefaultBitmapConfig(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r0.header.bgIndex == r1.transIndex) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap setPixels(com.bumptech.glide.gifdecoder.GifFrame r19, com.bumptech.glide.gifdecoder.GifFrame r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int[] r10 = r0.mainScratch
            r11 = 0
            if (r2 != 0) goto L_0x001c
            android.graphics.Bitmap r3 = r0.previousImage
            if (r3 == 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r3 = r0.bitmapProvider
            android.graphics.Bitmap r4 = r0.previousImage
            r3.release((android.graphics.Bitmap) r4)
        L_0x0016:
            r3 = 0
            r0.previousImage = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001c:
            r3 = 3
            if (r2 == 0) goto L_0x002a
            int r4 = r2.dispose
            if (r4 != r3) goto L_0x002a
            android.graphics.Bitmap r4 = r0.previousImage
            if (r4 != 0) goto L_0x002a
            java.util.Arrays.fill(r10, r11)
        L_0x002a:
            r12 = 2
            r13 = 1
            if (r2 == 0) goto L_0x0097
            int r4 = r2.dispose
            if (r4 <= 0) goto L_0x0097
            int r4 = r2.dispose
            if (r4 != r12) goto L_0x0080
            boolean r3 = r1.transparency
            if (r3 != 0) goto L_0x004b
            com.bumptech.glide.gifdecoder.GifHeader r3 = r0.header
            int r3 = r3.bgColor
            int[] r4 = r1.lct
            if (r4 == 0) goto L_0x0052
            com.bumptech.glide.gifdecoder.GifHeader r4 = r0.header
            int r4 = r4.bgIndex
            int r5 = r1.transIndex
            if (r4 != r5) goto L_0x0052
            goto L_0x0051
        L_0x004b:
            int r3 = r0.framePointer
            if (r3 != 0) goto L_0x0051
            r0.isFirstFrameTransparent = r13
        L_0x0051:
            r3 = 0
        L_0x0052:
            int r4 = r2.f41ih
            int r5 = r0.sampleSize
            int r4 = r4 / r5
            int r5 = r2.f44iy
            int r6 = r0.sampleSize
            int r5 = r5 / r6
            int r6 = r2.f42iw
            int r7 = r0.sampleSize
            int r6 = r6 / r7
            int r2 = r2.f43ix
            int r7 = r0.sampleSize
            int r2 = r2 / r7
            int r7 = r0.downsampledWidth
            int r5 = r5 * r7
            int r5 = r5 + r2
            int r2 = r0.downsampledWidth
            int r4 = r4 * r2
            int r4 = r4 + r5
        L_0x0070:
            if (r5 >= r4) goto L_0x0097
            int r2 = r5 + r6
            r7 = r5
        L_0x0075:
            if (r7 >= r2) goto L_0x007c
            r10[r7] = r3
            int r7 = r7 + 1
            goto L_0x0075
        L_0x007c:
            int r2 = r0.downsampledWidth
            int r5 = r5 + r2
            goto L_0x0070
        L_0x0080:
            int r2 = r2.dispose
            if (r2 != r3) goto L_0x0097
            android.graphics.Bitmap r2 = r0.previousImage
            if (r2 == 0) goto L_0x0097
            android.graphics.Bitmap r2 = r0.previousImage
            r4 = 0
            int r5 = r0.downsampledWidth
            r6 = 0
            r7 = 0
            int r8 = r0.downsampledWidth
            int r9 = r0.downsampledHeight
            r3 = r10
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x0097:
            r18.decodeBitmapData(r19)
            int r2 = r1.f41ih
            int r3 = r0.sampleSize
            int r2 = r2 / r3
            int r3 = r1.f44iy
            int r4 = r0.sampleSize
            int r3 = r3 / r4
            int r4 = r1.f42iw
            int r5 = r0.sampleSize
            int r4 = r4 / r5
            int r5 = r1.f43ix
            int r6 = r0.sampleSize
            int r5 = r5 / r6
            r6 = 8
            int r7 = r0.framePointer
            if (r7 != 0) goto L_0x00b6
            r7 = 1
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            r6 = 0
            r8 = 1
            r9 = 8
        L_0x00bb:
            if (r11 >= r2) goto L_0x013a
            boolean r14 = r1.interlace
            if (r14 == 0) goto L_0x00d4
            r14 = 4
            if (r6 < r2) goto L_0x00d1
            int r8 = r8 + 1
            switch(r8) {
                case 2: goto L_0x00d0;
                case 3: goto L_0x00cd;
                case 4: goto L_0x00ca;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            goto L_0x00d1
        L_0x00ca:
            r6 = 1
            r9 = 2
            goto L_0x00d1
        L_0x00cd:
            r6 = 2
            r9 = 4
            goto L_0x00d1
        L_0x00d0:
            r6 = 4
        L_0x00d1:
            int r14 = r6 + r9
            goto L_0x00d6
        L_0x00d4:
            r14 = r6
            r6 = r11
        L_0x00d6:
            int r6 = r6 + r3
            int r15 = r0.downsampledHeight
            if (r6 >= r15) goto L_0x012c
            int r15 = r0.downsampledWidth
            int r6 = r6 * r15
            int r15 = r6 + r5
            int r12 = r15 + r4
            int r13 = r0.downsampledWidth
            int r13 = r13 + r6
            if (r13 >= r12) goto L_0x00eb
            int r12 = r0.downsampledWidth
            int r12 = r12 + r6
        L_0x00eb:
            int r6 = r0.sampleSize
            int r6 = r6 * r11
            int r13 = r1.f42iw
            int r6 = r6 * r13
            int r13 = r12 - r15
            r16 = r2
            int r2 = r0.sampleSize
            int r13 = r13 * r2
            int r13 = r13 + r6
        L_0x00fc:
            if (r15 >= r12) goto L_0x012e
            int r2 = r0.sampleSize
            r17 = r3
            r3 = 1
            if (r2 != r3) goto L_0x0110
            byte[] r2 = r0.mainPixels
            byte r2 = r2[r6]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int[] r3 = r0.act
            r2 = r3[r2]
            goto L_0x0116
        L_0x0110:
            int r2 = r1.f42iw
            int r2 = r0.averageColorsNear(r6, r13, r2)
        L_0x0116:
            if (r2 == 0) goto L_0x011b
            r10[r15] = r2
            goto L_0x0124
        L_0x011b:
            boolean r2 = r0.isFirstFrameTransparent
            if (r2 != 0) goto L_0x0124
            if (r7 == 0) goto L_0x0124
            r2 = 1
            r0.isFirstFrameTransparent = r2
        L_0x0124:
            int r2 = r0.sampleSize
            int r6 = r6 + r2
            int r15 = r15 + 1
            r3 = r17
            goto L_0x00fc
        L_0x012c:
            r16 = r2
        L_0x012e:
            r17 = r3
            int r11 = r11 + 1
            r6 = r14
            r2 = r16
            r3 = r17
            r12 = 2
            r13 = 1
            goto L_0x00bb
        L_0x013a:
            boolean r2 = r0.savePrevious
            if (r2 == 0) goto L_0x0160
            int r2 = r1.dispose
            if (r2 == 0) goto L_0x0147
            int r1 = r1.dispose
            r2 = 1
            if (r1 != r2) goto L_0x0160
        L_0x0147:
            android.graphics.Bitmap r1 = r0.previousImage
            if (r1 != 0) goto L_0x0151
            android.graphics.Bitmap r1 = r18.getNextBitmap()
            r0.previousImage = r1
        L_0x0151:
            android.graphics.Bitmap r1 = r0.previousImage
            r3 = 0
            int r4 = r0.downsampledWidth
            r5 = 0
            r6 = 0
            int r7 = r0.downsampledWidth
            int r8 = r0.downsampledHeight
            r2 = r10
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0160:
            android.graphics.Bitmap r9 = r18.getNextBitmap()
            r3 = 0
            int r4 = r0.downsampledWidth
            r5 = 0
            r6 = 0
            int r7 = r0.downsampledWidth
            int r8 = r0.downsampledHeight
            r1 = r9
            r2 = r10
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.setPixels(com.bumptech.glide.gifdecoder.GifFrame, com.bumptech.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    @ColorInt
    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i4 < this.sampleSize + i && i4 < this.mainPixels.length && i4 < i2) {
            int i10 = this.act[this.mainPixels[i4] & 255];
            if (i10 != 0) {
                i5 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i7 += (i10 >> 8) & 255;
                i8 += i10 & 255;
                i9++;
            }
            i4++;
        }
        int i11 = i + i3;
        int i12 = i11;
        while (i12 < this.sampleSize + i11 && i12 < this.mainPixels.length && i12 < i2) {
            int i13 = this.act[this.mainPixels[i12] & 255];
            if (i13 != 0) {
                i5 += (i13 >> 24) & 255;
                i6 += (i13 >> 16) & 255;
                i7 += (i13 >> 8) & 255;
                i8 += i13 & 255;
                i9++;
            }
            i12++;
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r2v11, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = 0
            r0.workBufferSize = r2
            r0.workBufferPosition = r2
            if (r1 == 0) goto L_0x0012
            java.nio.ByteBuffer r3 = r0.rawData
            int r4 = r1.bufferFrameStart
            r3.position(r4)
        L_0x0012:
            if (r1 != 0) goto L_0x001f
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.header
            int r1 = r1.width
            com.bumptech.glide.gifdecoder.GifHeader r3 = r0.header
            int r3 = r3.height
            int r1 = r1 * r3
            goto L_0x0025
        L_0x001f:
            int r3 = r1.f42iw
            int r1 = r1.f41ih
            int r1 = r1 * r3
        L_0x0025:
            byte[] r3 = r0.mainPixels
            if (r3 == 0) goto L_0x002e
            byte[] r3 = r0.mainPixels
            int r3 = r3.length
            if (r3 >= r1) goto L_0x0036
        L_0x002e:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r3 = r0.bitmapProvider
            byte[] r3 = r3.obtainByteArray(r1)
            r0.mainPixels = r3
        L_0x0036:
            short[] r3 = r0.prefix
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0040
            short[] r3 = new short[r4]
            r0.prefix = r3
        L_0x0040:
            byte[] r3 = r0.suffix
            if (r3 != 0) goto L_0x0048
            byte[] r3 = new byte[r4]
            r0.suffix = r3
        L_0x0048:
            byte[] r3 = r0.pixelStack
            if (r3 != 0) goto L_0x0052
            r3 = 4097(0x1001, float:5.741E-42)
            byte[] r3 = new byte[r3]
            r0.pixelStack = r3
        L_0x0052:
            int r3 = r28.readByte()
            r5 = 1
            int r6 = r5 << r3
            int r7 = r6 + 1
            int r8 = r6 + 2
            int r3 = r3 + r5
            int r9 = r5 << r3
            int r9 = r9 - r5
            r10 = 0
        L_0x0062:
            if (r10 >= r6) goto L_0x0070
            short[] r11 = r0.prefix
            r11[r10] = r2
            byte[] r11 = r0.suffix
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x0062
        L_0x0070:
            r10 = -1
            r21 = r3
            r19 = r8
            r20 = r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r22 = -1
        L_0x0084:
            if (r11 >= r1) goto L_0x017f
            r2 = 3
            if (r12 != 0) goto L_0x0094
            int r12 = r28.readBlock()
            if (r12 > 0) goto L_0x0093
            r0.status = r2
            goto L_0x017f
        L_0x0093:
            r15 = 0
        L_0x0094:
            byte[] r4 = r0.block
            byte r4 = r4[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r16
            int r14 = r14 + r4
            int r16 = r16 + 8
            int r15 = r15 + r5
            int r12 = r12 + r10
            r4 = r16
            r23 = r17
            r5 = r22
            r16 = r11
            r17 = r13
            r13 = r19
            r11 = r21
        L_0x00af:
            if (r4 < r11) goto L_0x0165
            r10 = r14 & r20
            int r14 = r14 >> r11
            int r4 = r4 - r11
            if (r10 != r6) goto L_0x00be
            r11 = r3
            r13 = r8
            r20 = r9
            r5 = -1
        L_0x00bc:
            r10 = -1
            goto L_0x00af
        L_0x00be:
            if (r10 <= r13) goto L_0x00c3
            r0.status = r2
            goto L_0x00c5
        L_0x00c3:
            if (r10 != r7) goto L_0x00d8
        L_0x00c5:
            r22 = r5
            r21 = r11
            r19 = r13
            r11 = r16
            r13 = r17
            r17 = r23
            r2 = 0
            r5 = 1
            r10 = -1
            r16 = r4
            goto L_0x017b
        L_0x00d8:
            r2 = -1
            if (r5 != r2) goto L_0x00ec
            byte[] r5 = r0.pixelStack
            int r19 = r18 + 1
            byte[] r2 = r0.suffix
            byte r2 = r2[r10]
            r5[r18] = r2
            r5 = r10
            r23 = r5
            r18 = r19
        L_0x00ea:
            r2 = 3
            goto L_0x00bc
        L_0x00ec:
            if (r10 < r13) goto L_0x00fd
            byte[] r2 = r0.pixelStack
            int r19 = r18 + 1
            r24 = r3
            r3 = r23
            byte r3 = (byte) r3
            r2[r18] = r3
            r2 = r5
            r18 = r19
            goto L_0x0100
        L_0x00fd:
            r24 = r3
            r2 = r10
        L_0x0100:
            if (r2 < r6) goto L_0x0117
            byte[] r3 = r0.pixelStack
            int r19 = r18 + 1
            r25 = r4
            byte[] r4 = r0.suffix
            byte r4 = r4[r2]
            r3[r18] = r4
            short[] r3 = r0.prefix
            short r2 = r3[r2]
            r18 = r19
            r4 = r25
            goto L_0x0100
        L_0x0117:
            r25 = r4
            byte[] r3 = r0.suffix
            byte r2 = r3[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r3 = r0.pixelStack
            int r4 = r18 + 1
            r26 = r4
            byte r4 = (byte) r2
            r3[r18] = r4
            r3 = 4096(0x1000, float:5.74E-42)
            if (r13 >= r3) goto L_0x0146
            short[] r3 = r0.prefix
            short r5 = (short) r5
            r3[r13] = r5
            byte[] r3 = r0.suffix
            r3[r13] = r4
            int r13 = r13 + 1
            r3 = r13 & r20
            if (r3 != 0) goto L_0x0144
            r3 = 4096(0x1000, float:5.74E-42)
            if (r13 >= r3) goto L_0x0146
            int r11 = r11 + 1
            int r20 = r20 + r13
            goto L_0x0146
        L_0x0144:
            r3 = 4096(0x1000, float:5.74E-42)
        L_0x0146:
            r18 = r26
        L_0x0148:
            if (r18 <= 0) goto L_0x015d
            byte[] r4 = r0.mainPixels
            int r5 = r17 + 1
            byte[] r3 = r0.pixelStack
            int r18 = r18 + -1
            byte r3 = r3[r18]
            r4[r17] = r3
            int r16 = r16 + 1
            r17 = r5
            r3 = 4096(0x1000, float:5.74E-42)
            goto L_0x0148
        L_0x015d:
            r23 = r2
            r5 = r10
            r3 = r24
            r4 = r25
            goto L_0x00ea
        L_0x0165:
            r24 = r3
            r3 = r23
            r22 = r5
            r21 = r11
            r19 = r13
            r11 = r16
            r13 = r17
            r2 = 0
            r5 = 1
            r17 = r3
            r16 = r4
            r3 = r24
        L_0x017b:
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x0084
        L_0x017f:
            if (r13 >= r1) goto L_0x0189
            byte[] r2 = r0.mainPixels
            r3 = 0
            r2[r13] = r3
            int r13 = r13 + 1
            goto L_0x017f
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    private void readChunkIfNeeded() {
        if (this.workBufferSize <= this.workBufferPosition) {
            if (this.workBuffer == null) {
                this.workBuffer = this.bitmapProvider.obtainByteArray(16384);
            }
            this.workBufferPosition = 0;
            this.workBufferSize = Math.min(this.rawData.remaining(), 16384);
            this.rawData.get(this.workBuffer, 0, this.workBufferSize);
        }
    }

    private int readByte() {
        try {
            readChunkIfNeeded();
            byte[] bArr = this.workBuffer;
            int i = this.workBufferPosition;
            this.workBufferPosition = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte > 0) {
            try {
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                int i = this.workBufferSize - this.workBufferPosition;
                if (i >= readByte) {
                    System.arraycopy(this.workBuffer, this.workBufferPosition, this.block, 0, readByte);
                    this.workBufferPosition += readByte;
                } else if (this.rawData.remaining() + i >= readByte) {
                    System.arraycopy(this.workBuffer, this.workBufferPosition, this.block, 0, i);
                    this.workBufferPosition = this.workBufferSize;
                    readChunkIfNeeded();
                    int i2 = readByte - i;
                    System.arraycopy(this.workBuffer, 0, this.block, i, i2);
                    this.workBufferPosition += i2;
                } else {
                    this.status = 1;
                }
            } catch (Exception e) {
                Log.w(TAG, "Error Reading Block", e);
                this.status = 1;
            }
        }
        return readByte;
    }

    private Bitmap getNextBitmap() {
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, this.isFirstFrameTransparent ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }
}
