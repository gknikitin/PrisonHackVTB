package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.RestrictTo;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p000v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private float[] f15mX;

    /* renamed from: mY */
    private float[] f16mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData == null) {
                throw new InflateException("The path is null, which is created from " + namedString);
            }
            initPath(createPathFromPathData);
        } else if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
            if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!hasAttribute) {
                initQuad(namedFloat, namedFloat2);
            } else {
                initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        }
    }

    private void initQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        initPath(path);
    }

    private void initCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(MAX_NUM_POINTS, ((int) (length / PRECISION)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f15mX = new float[min];
        this.f16mY = new float[min];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, (float[]) null);
            this.f15mX[i2] = fArr[0];
            this.f16mY[i2] = fArr[1];
        }
        if (((double) Math.abs(this.f15mX[0])) <= 1.0E-5d && ((double) Math.abs(this.f16mY[0])) <= 1.0E-5d) {
            int i3 = min - 1;
            if (((double) Math.abs(this.f15mX[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f16mY[i3] - 1.0f)) <= 1.0E-5d) {
                int i4 = 0;
                float f = 0.0f;
                while (i < min) {
                    int i5 = i4 + 1;
                    float f2 = this.f15mX[i4];
                    if (f2 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    this.f15mX[i] = f2;
                    i++;
                    f = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f15mX[0]);
        sb.append(",");
        sb.append(this.f16mY[0]);
        sb.append(" end:");
        int i6 = min - 1;
        sb.append(this.f15mX[i6]);
        sb.append(",");
        sb.append(this.f16mY[i6]);
        throw new IllegalArgumentException(sb.toString());
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f15mX.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f15mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f15mX[length] - this.f15mX[i];
        if (f2 == 0.0f) {
            return this.f16mY[i];
        }
        float f3 = this.f16mY[i];
        return f3 + (((f - this.f15mX[i]) / f2) * (this.f16mY[length] - f3));
    }
}