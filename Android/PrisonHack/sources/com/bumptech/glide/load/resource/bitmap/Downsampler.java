package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", DownsampleStrategy.DEFAULT);
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final int MARK_POSITION = 10485760;
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        try {
            BitmapResource obtain = BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, (DownsampleStrategy) options2.get(DOWNSAMPLE_STRATEGY), decodeFormat, decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : options2.get(ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options2.get(ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr, byte[].class);
            return obtain;
        } catch (Throwable th) {
            Throwable th2 = th;
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr, byte[].class);
            throw th2;
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream2, options2, decodeCallbacks2, this.bitmapPool);
        boolean z3 = false;
        int i8 = dimensions[0];
        int i9 = dimensions[1];
        String str = options2.outMimeType;
        boolean z4 = (i8 == -1 || i9 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream2, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i10 = i;
        if (i10 == Integer.MIN_VALUE) {
            i4 = i2;
            i3 = i8;
        } else {
            i4 = i2;
            i3 = i10;
        }
        int i11 = i4 == Integer.MIN_VALUE ? i9 : i4;
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream2, this.byteArrayPool);
        ImageHeaderParser.ImageType imageType = type;
        calculateScaling(type, inputStream2, decodeCallbacks2, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i8, i9, i3, i11, options2);
        int i12 = orientation;
        String str2 = str;
        int i13 = i9;
        int i14 = i8;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        calculateConfig(inputStream2, decodeFormat, z4, isExifOrientationRequired, options2, i3, i11);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if ((options3.inSampleSize == 1 || z3) && shouldUsePool(imageType)) {
            if (i14 < 0 || i13 < 0 || !z2 || !z3) {
                float f = isScaling(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                int i15 = options3.inSampleSize;
                float f2 = (float) i15;
                i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f2)))) * f);
                i6 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f2)))) * f);
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Calculated target [" + i7 + "x" + i6 + "] for source [" + i14 + "x" + i13 + "], sampleSize: " + i15 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f);
                }
            } else {
                i7 = i3;
                i6 = i11;
            }
            if (i7 > 0 && i6 > 0) {
                setInBitmap(options3, this.bitmapPool, i7, i6);
            }
        }
        Bitmap decodeStream = decodeStream(inputStream, options3, decodeCallbacks3, this.bitmapPool);
        decodeCallbacks3.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(TAG, 2)) {
            i5 = i12;
            logDecode(i14, i13, str2, options3, decodeStream, i, i2, logTime);
        } else {
            i5 = i12;
        }
        Bitmap bitmap = null;
        if (decodeStream != null) {
            decodeStream.setDensity(this.displayMetrics.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i5);
            if (!decodeStream.equals(bitmap)) {
                this.bitmapPool.put(decodeStream);
            }
        }
        return bitmap;
    }

    static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        BitmapFactory.Options options2 = options;
        if (i11 > 0 && i12 > 0) {
            if (i10 == 90 || i10 == 270) {
                f = downsampleStrategy2.getScaleFactor(i12, i11, i13, i14);
            } else {
                f = downsampleStrategy2.getScaleFactor(i11, i12, i13, i14);
            }
            if (f <= 0.0f) {
                throw new IllegalArgumentException("Cannot scale with factor: " + f + " from: " + downsampleStrategy2 + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
            }
            DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i11, i12, i13, i14);
            if (sampleSizeRounding == null) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            float f2 = (float) i11;
            float f3 = (float) i12;
            int round = i11 / round((double) (f * f2));
            int round2 = i12 / round((double) (f * f3));
            if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                i6 = Math.max(round, round2);
            } else {
                i6 = Math.min(round, round2);
            }
            if (Build.VERSION.SDK_INT > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options2.outMimeType)) {
                int max = Math.max(1, Integer.highestOneBit(i6));
                i7 = (sampleSizeRounding != DownsampleStrategy.SampleSizeRounding.MEMORY || ((float) max) >= 1.0f / f) ? max : max << 1;
            } else {
                i7 = 1;
            }
            options2.inSampleSize = i7;
            if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                float min = (float) Math.min(i7, 8);
                i8 = (int) Math.ceil((double) (f2 / min));
                i9 = (int) Math.ceil((double) (f3 / min));
                int i15 = i7 / 8;
                if (i15 > 0) {
                    i8 /= i15;
                    i9 /= i15;
                }
            } else if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = (float) i7;
                i8 = (int) Math.floor((double) (f2 / f4));
                i9 = (int) Math.floor((double) (f3 / f4));
            } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f5 = (float) i7;
                    i8 = Math.round(f2 / f5);
                    i9 = Math.round(f3 / f5);
                } else {
                    float f6 = (float) i7;
                    i8 = (int) Math.floor((double) (f2 / f6));
                    i9 = (int) Math.floor((double) (f3 / f6));
                }
            } else if (i11 % i7 == 0 && i12 % i7 == 0) {
                i8 = i11 / i7;
                i9 = i12 / i7;
            } else {
                int[] dimensions = getDimensions(inputStream, options2, decodeCallbacks, bitmapPool2);
                i8 = dimensions[0];
                i9 = dimensions[1];
            }
            double scaleFactor = (double) downsampleStrategy2.getScaleFactor(i8, i9, i13, i14);
            if (Build.VERSION.SDK_INT >= 19) {
                options2.inTargetDensity = adjustTargetDensityForError(scaleFactor);
                options2.inDensity = getDensityMultiplier(scaleFactor);
            }
            if (isScaling(options)) {
                options2.inScaled = true;
            } else {
                options2.inTargetDensity = 0;
                options2.inDensity = 0;
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Calculate scaling, source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "], power of two scaled: [" + i8 + "x" + i9 + "], exact scale factor: " + f + ", power of 2 sample size: " + i7 + ", adjusted scale factor: " + scaleFactor + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity);
            }
        } else if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to determine dimensions for: " + imageType2 + " with target [" + i13 + "x" + i14 + "]");
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int round = round(((double) densityMultiplier) * d);
        return round((d / ((double) (((float) round) / ((float) densityMultiplier)))) * ((double) round));
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) throws IOException {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return TYPES_THAT_USE_POOL_PRE_KITKAT.contains(imageType);
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) throws IOException {
        boolean z3;
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, decodeFormat, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            try {
                z3 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                }
                z3 = false;
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565 || options.inPreferredConfig == Bitmap.Config.ARGB_4444 || options.inPreferredConfig == Bitmap.Config.ALPHA_8) {
                options.inDither = true;
            }
        }
    }

    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto L_0x000d
        L_0x000a:
            r7.onObtainBounds()
        L_0x000d:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ IllegalArgumentException -> 0x0030 }
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r7.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L_0x002d
            r5.reset()
        L_0x002d:
            return r4
        L_0x002e:
            r5 = move-exception
            goto L_0x0061
        L_0x0030:
            r4 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r4, r0, r1, r2, r6)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = "Downsampler"
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r1, r2, r0)     // Catch:{ all -> 0x002e }
        L_0x0045:
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0060
            r5.reset()     // Catch:{ IOException -> 0x005f }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ IOException -> 0x005f }
            r8.put(r1)     // Catch:{ IOException -> 0x005f }
            r6.inBitmap = r3     // Catch:{ IOException -> 0x005f }
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch:{ IOException -> 0x005f }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L_0x005f:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0060:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0061:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    @Nullable
    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = bitmapPool2.getDirty(i, i2, options.inPreferredConfig);
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            synchronized (OPTIONS_QUEUE) {
                poll = OPTIONS_QUEUE.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        synchronized (OPTIONS_QUEUE) {
            OPTIONS_QUEUE.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
