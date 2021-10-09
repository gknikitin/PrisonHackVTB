package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int DESCRIPTOR_MASK_RESERVED = 24;
    private static final int DESCRIPTOR_MASK_SORT_FLAG = 32;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_RESERVED_BITS = 224;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int GCE_MASK_USER_INPUT_FLAG = 2;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_COLOR_RESOLUTION = 112;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int LSD_MASK_SORT_FLAG = 8;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    public static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser setData(ByteBuffer byteBuffer) {
        reset();
        this.rawData = byteBuffer.asReadOnlyBuffer();
        this.rawData.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (err()) {
            return this.header;
        } else {
            readHeader();
            if (!err()) {
                readContents();
                if (this.header.frameCount < 0) {
                    this.header.status = 1;
                }
            }
            return this.header;
        }
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 != LABEL_GRAPHIC_CONTROL_EXTENSION) {
                    switch (read2) {
                        case LABEL_COMMENT_EXTENSION /*254*/:
                            skip();
                            break;
                        case 255:
                            readBlock();
                            String str = "";
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.block[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                skip();
                                break;
                            } else {
                                readNetscapeExt();
                                break;
                            }
                        default:
                            skip();
                            break;
                    }
                } else {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                }
            } else if (read == 44) {
                if (this.header.currentFrame == null) {
                    this.header.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        this.header.currentFrame.dispose = (read & 28) >> 2;
        boolean z = true;
        if (this.header.currentFrame.dispose == 0) {
            this.header.currentFrame.dispose = 1;
        }
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 1) == 0) {
            z = false;
        }
        gifFrame.transparency = z;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        this.header.currentFrame.delay = readShort * 10;
        this.header.currentFrame.transIndex = read();
        read();
    }

    private void readBitmap() {
        this.header.currentFrame.f43ix = readShort();
        this.header.currentFrame.f44iy = readShort();
        this.header.currentFrame.f42iw = readShort();
        this.header.currentFrame.f41ih = readShort();
        int read = read();
        boolean z = false;
        boolean z2 = (read & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z = true;
        }
        gifFrame.interlace = z;
        if (z2) {
            this.header.currentFrame.lct = readColorTable(pow);
        } else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (!err()) {
            this.header.frameCount++;
            this.header.frames.add(this.header.currentFrame);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readNetscapeExt() {
        /*
            r3 = this;
        L_0x0000:
            r3.readBlock()
            byte[] r0 = r3.block
            r1 = 0
            byte r0 = r0[r1]
            r1 = 1
            if (r0 != r1) goto L_0x001f
            byte[] r0 = r3.block
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte[] r1 = r3.block
            r2 = 2
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.header
            int r1 = r1 << 8
            r0 = r0 | r1
            r2.loopCount = r0
        L_0x001f:
            int r0 = r3.blockSize
            if (r0 <= 0) goto L_0x0029
            boolean r0 = r3.err()
            if (r0 == 0) goto L_0x0000
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.readNetscapeExt():void");
    }

    private void readHeader() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (this.header.gctFlag && !err()) {
            this.header.gct = readColorTable(this.header.gctSize);
            this.header.bgColor = this.header.gct[this.header.bgIndex];
        }
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        this.header.gctFlag = (read & 128) != 0;
        this.header.gctSize = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] readColorTable(int r10) {
        /*
            r9 = this;
            int r0 = r10 * 3
            byte[] r0 = new byte[r0]
            r1 = 0
            java.nio.ByteBuffer r2 = r9.rawData     // Catch:{ BufferUnderflowException -> 0x0036 }
            r2.get(r0)     // Catch:{ BufferUnderflowException -> 0x0036 }
            r2 = 256(0x100, float:3.59E-43)
            int[] r2 = new int[r2]     // Catch:{ BufferUnderflowException -> 0x0036 }
            r1 = 0
            r3 = 0
        L_0x0010:
            if (r1 >= r10) goto L_0x004d
            int r4 = r3 + 1
            byte r3 = r0[r3]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r5 = r4 + 1
            byte r4 = r0[r4]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r6 = r5 + 1
            byte r5 = r0[r5]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r7 = r1 + 1
            r8 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r3 = r3 << 16
            r3 = r3 | r8
            int r4 = r4 << 8
            r3 = r3 | r4
            r3 = r3 | r5
            r2[r1] = r3     // Catch:{ BufferUnderflowException -> 0x0034 }
            r3 = r6
            r1 = r7
            goto L_0x0010
        L_0x0034:
            r10 = move-exception
            goto L_0x0038
        L_0x0036:
            r10 = move-exception
            r2 = r1
        L_0x0038:
            java.lang.String r0 = "GifHeaderParser"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = "GifHeaderParser"
            java.lang.String r1 = "Format Error Reading Color Table"
            android.util.Log.d(r0, r1, r10)
        L_0x0048:
            com.bumptech.glide.gifdecoder.GifHeader r10 = r9.header
            r0 = 1
            r10.status = r0
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.readColorTable(int):int[]");
    }

    private void skipImageData() {
        read();
        skip();
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private int readBlock() {
        this.blockSize = read();
        int i = 0;
        if (this.blockSize > 0) {
            int i2 = 0;
            while (i < this.blockSize) {
                try {
                    i2 = this.blockSize - i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.blockSize, e);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private boolean err() {
        return this.header.status != 0;
    }
}
