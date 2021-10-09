package com.bumptech.glide.load;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    private static final int MARK_POSITION = 5242880;

    private ImageHeaderParserUtils() {
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, @Nullable InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_POSITION);
        for (ImageHeaderParser type : list) {
            try {
                ImageHeaderParser.ImageType type2 = type.getType(inputStream);
                if (type2 != ImageHeaderParser.ImageType.UNKNOWN) {
                    inputStream.reset();
                    return type2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        for (ImageHeaderParser type : list) {
            ImageHeaderParser.ImageType type2 = type.getType(byteBuffer);
            if (type2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return type2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(List<ImageHeaderParser> list, @Nullable InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_POSITION);
        for (ImageHeaderParser orientation : list) {
            try {
                int orientation2 = orientation.getOrientation(inputStream, arrayPool);
                if (orientation2 != -1) {
                    inputStream.reset();
                    return orientation2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }
}
