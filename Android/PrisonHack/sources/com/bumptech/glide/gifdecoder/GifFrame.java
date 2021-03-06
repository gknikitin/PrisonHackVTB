package com.bumptech.glide.gifdecoder;

import android.support.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class GifFrame {
    public static final int DISPOSAL_BACKGROUND = 2;
    public static final int DISPOSAL_NONE = 1;
    public static final int DISPOSAL_PREVIOUS = 3;
    public static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* renamed from: ih */
    int f41ih;
    boolean interlace;

    /* renamed from: iw */
    int f42iw;

    /* renamed from: ix */
    int f43ix;

    /* renamed from: iy */
    int f44iy;
    @ColorInt
    int[] lct;
    int transIndex;
    boolean transparency;

    @Retention(RetentionPolicy.SOURCE)
    @interface GifDisposalMethod {
    }

    GifFrame() {
    }
}
