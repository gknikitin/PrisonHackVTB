package com.google.android.gms.common.images.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.base.C0580R;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageRequest;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.PlatformVersion;

public final class LoadingImageView extends ImageView {
    public static final int ASPECT_RATIO_ADJUST_HEIGHT = 2;
    public static final int ASPECT_RATIO_ADJUST_NONE = 0;
    public static final int ASPECT_RATIO_ADJUST_WIDTH = 1;
    private static ImageManager zzqm;
    private ImageManager.OnImageLoadedListener mOnImageLoadedListener;
    private int mPostProcessingFlags;
    private boolean zzpl;
    private boolean zzpm;
    private Uri zzqn;
    private int zzqo;
    private boolean zzqp;
    private int zzqq;
    private ClipPathProvider zzqr;
    private int zzqs;
    private float zzqt;

    public interface ClipPathProvider {
        Path getClipPath(int i, int i2);
    }

    public LoadingImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzqo = 0;
        this.zzpl = true;
        this.zzpm = false;
        this.zzqp = false;
        this.zzqq = 0;
        this.mPostProcessingFlags = 0;
        this.zzqs = 0;
        this.zzqt = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0580R.styleable.LoadingImageView);
        this.zzqs = obtainStyledAttributes.getInt(C0580R.styleable.LoadingImageView_imageAspectRatioAdjust, 0);
        this.zzqt = obtainStyledAttributes.getFloat(C0580R.styleable.LoadingImageView_imageAspectRatio, 1.0f);
        setCircleCropEnabled(obtainStyledAttributes.getBoolean(C0580R.styleable.LoadingImageView_circleCrop, false));
        obtainStyledAttributes.recycle();
    }

    private final void zzc(boolean z) {
        if (this.mOnImageLoadedListener != null) {
            this.mOnImageLoadedListener.onImageLoaded(this.zzqn, (Drawable) null, z);
        }
    }

    public final void clearAspectRatioAdjust() {
        if (this.zzqs != 0) {
            this.zzqs = 0;
            requestLayout();
        }
    }

    public final void clearImage() {
        loadUri((Uri) null);
        this.zzqp = true;
    }

    public final int getLoadedNoDataPlaceholderResId() {
        return this.zzqo;
    }

    public final Uri getLoadedUri() {
        return this.zzqn;
    }

    public final void loadUri(Uri uri) {
        loadUri(uri, 0, true, false);
    }

    public final void loadUri(Uri uri, int i) {
        loadUri(uri, i, true, false);
    }

    public final void loadUri(Uri uri, int i, boolean z) {
        loadUri(uri, i, z, false);
    }

    public final void loadUri(Uri uri, int i, boolean z, boolean z2) {
        boolean z3 = true;
        if (uri != null ? uri.equals(this.zzqn) : this.zzqn == null) {
            if (this.zzqn != null) {
                zzc(true);
                return;
            } else if (this.zzqo == i) {
                zzc(false);
                return;
            }
        }
        if (zzqm == null) {
            zzqm = ImageManager.create(getContext(), getContext().getApplicationContext().getPackageName().equals(GooglePlayServicesUtilLight.GOOGLE_PLAY_GAMES_PACKAGE));
        }
        if (!this.zzpm && !this.zzqp) {
            z3 = false;
        }
        this.zzqp = false;
        ImageRequest.ImageViewImageRequest imageViewImageRequest = new ImageRequest.ImageViewImageRequest((ImageView) this, uri);
        imageViewImageRequest.setNoDataPlaceholder(i);
        imageViewImageRequest.setCrossFadeEnabled(this.zzpl);
        imageViewImageRequest.setCrossFadeAlwaysEnabled(z3);
        imageViewImageRequest.setLoadingPlaceholderEnabled(z);
        imageViewImageRequest.setPostProcessingFlags(this.mPostProcessingFlags);
        imageViewImageRequest.setOnImageLoadedListener(this.mOnImageLoadedListener);
        imageViewImageRequest.setUseNewDrawable(z2);
        zzqm.loadImage(imageViewImageRequest);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (this.zzqr != null) {
            canvas.clipPath(this.zzqr.getClipPath(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzqq != 0) {
            canvas.drawColor(this.zzqq);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        switch (this.zzqs) {
            case 1:
                i3 = getMeasuredHeight();
                i4 = (int) (((float) i3) * this.zzqt);
                break;
            case 2:
                i4 = getMeasuredWidth();
                i3 = (int) (((float) i4) / this.zzqt);
                break;
            default:
                return;
        }
        setMeasuredDimension(i4, i3);
    }

    public final void setCircleCropEnabled(boolean z) {
        this.mPostProcessingFlags = z ? this.mPostProcessingFlags | 1 : this.mPostProcessingFlags & -2;
    }

    public final void setClipPathProvider(ClipPathProvider clipPathProvider) {
        this.zzqr = clipPathProvider;
        if (!PlatformVersion.isAtLeastJellyBean()) {
            setLayerType(1, (Paint) null);
        }
    }

    public final void setCrossFadeAlwaysEnabled(boolean z) {
        this.zzpm = z;
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void setImageAspectRatioAdjust(int i, float f) {
        boolean z = false;
        Asserts.checkState(i == 0 || i == 1 || i == 2);
        if (f > 0.0f) {
            z = true;
        }
        Asserts.checkState(z);
        this.zzqs = i;
        this.zzqt = f;
        requestLayout();
    }

    public final void setLoadedNoDataPlaceholderResId(int i) {
        this.zzqo = i;
    }

    public final void setLoadedUri(Uri uri) {
        this.zzqn = uri;
    }

    public final void setOnImageLoadedListener(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        this.mOnImageLoadedListener = onImageLoadedListener;
    }

    public final void setTintColor(int i) {
        this.zzqq = i;
        setColorFilter(this.zzqq != 0 ? ColorFilters.COLOR_FILTER_BW : null);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTintColorId(int r2) {
        /*
            r1 = this;
            if (r2 <= 0) goto L_0x000d
            android.content.res.Resources r0 = r1.getResources()
            if (r0 == 0) goto L_0x000d
            int r2 = r0.getColor(r2)
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            r1.setTintColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.internal.LoadingImageView.setTintColorId(int):void");
    }
}
