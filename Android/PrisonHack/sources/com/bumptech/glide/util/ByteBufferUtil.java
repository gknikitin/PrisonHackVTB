package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = new AtomicReference<>();
    private static final int BUFFER_SIZE = 16384;

    private ByteBufferUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0055 A[SYNTHETIC, Splitter:B:34:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer fromFile(java.io.File r9) throws java.io.IOException {
        /*
            r0 = 0
            long r5 = r9.length()     // Catch:{ all -> 0x004c }
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0014
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "File too large to map into memory"
            r9.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r9     // Catch:{ all -> 0x004c }
        L_0x0014:
            r1 = 0
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0022
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "File unsuitable for memory mapping"
            r9.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r9     // Catch:{ all -> 0x004c }
        L_0x0022:
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "r"
            r7.<init>(r9, r1)     // Catch:{ all -> 0x004c }
            java.nio.channels.FileChannel r9 = r7.getChannel()     // Catch:{ all -> 0x004a }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0045 }
            r3 = 0
            r1 = r9
            java.nio.MappedByteBuffer r0 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0045 }
            java.nio.MappedByteBuffer r0 = r0.load()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x003f
            r9.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            if (r7 == 0) goto L_0x0044
            r7.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            return r0
        L_0x0045:
            r0 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x004e
        L_0x004a:
            r9 = move-exception
            goto L_0x004e
        L_0x004c:
            r9 = move-exception
            r7 = r0
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            if (r7 == 0) goto L_0x0058
            r7.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.fromFile(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A[SYNTHETIC, Splitter:B:21:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0036 A[SYNTHETIC, Splitter:B:25:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void toFile(java.nio.ByteBuffer r4, java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
            r4.position(r0)
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x002c }
            java.nio.channels.FileChannel r5 = r2.getChannel()     // Catch:{ all -> 0x0029 }
            r5.write(r4)     // Catch:{ all -> 0x0027 }
            r5.force(r0)     // Catch:{ all -> 0x0027 }
            r5.close()     // Catch:{ all -> 0x0027 }
            r2.close()     // Catch:{ all -> 0x0027 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            r2.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            return
        L_0x0027:
            r4 = move-exception
            goto L_0x002f
        L_0x0029:
            r4 = move-exception
            r5 = r1
            goto L_0x002f
        L_0x002c:
            r4 = move-exception
            r5 = r1
            r2 = r5
        L_0x002f:
            if (r5 == 0) goto L_0x0034
            r5.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.toFile(java.nio.ByteBuffer, java.io.File):void");
    }

    public static void toStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null) {
            outputStream.write(safeArray.data, safeArray.offset, safeArray.offset + safeArray.limit);
            return;
        }
        byte[] andSet = BUFFER_REF.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        BUFFER_REF.set(andSet);
    }

    public static byte[] toBytes(ByteBuffer byteBuffer) {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static ByteBuffer fromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = BUFFER_REF.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                BUFFER_REF.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    private static SafeArray getSafeArray(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        public SafeArray(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    private static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos = -1;

        public boolean markSupported() {
            return true;
        }

        public ByteBufferStream(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
        }

        public int available() throws IOException {
            return this.byteBuffer.remaining();
        }

        public int read() throws IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            return this.byteBuffer.get();
        }

        public synchronized void mark(int i) {
            this.markPos = this.byteBuffer.position();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.byteBuffer.get(bArr, i, min);
            return min;
        }

        public synchronized void reset() throws IOException {
            if (this.markPos == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.byteBuffer.position(this.markPos);
        }

        public long skip(long j) throws IOException {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long) available());
            this.byteBuffer.position((int) (((long) this.byteBuffer.position()) + min));
            return min;
        }
    }
}
