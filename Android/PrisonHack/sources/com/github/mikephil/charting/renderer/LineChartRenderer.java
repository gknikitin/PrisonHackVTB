package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath = new Path();
    protected Path cubicPath = new Path();
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    protected LineDataProvider mChart;
    protected Paint mCirclePaintInner;
    protected WeakReference<Bitmap> mDrawBitmap;
    private float[] mLineBuffer = new float[4];

    public void initBuffers() {
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = lineDataProvider;
        this.mCirclePaintInner = new Paint(1);
        this.mCirclePaintInner.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        if (!(this.mDrawBitmap != null && ((Bitmap) this.mDrawBitmap.get()).getWidth() == chartWidth && ((Bitmap) this.mDrawBitmap.get()).getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, this.mBitmapConfig));
                this.mBitmapCanvas = new Canvas((Bitmap) this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.mDrawBitmap.get()).eraseColor(0);
        for (ILineDataSet iLineDataSet : this.mChart.getLineData().getDataSets()) {
            if (iLineDataSet.isVisible() && iLineDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap((Bitmap) this.mDrawBitmap.get(), 0.0f, 0.0f, this.mRenderPaint);
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.getEntryCount() >= 1) {
            this.mRenderPaint.setStrokeWidth(iLineDataSet.getLineWidth());
            this.mRenderPaint.setPathEffect(iLineDataSet.getDashPathEffect());
            if (iLineDataSet.isDrawCubicEnabled()) {
                drawCubic(canvas, iLineDataSet);
            } else {
                drawLinear(canvas, iLineDataSet);
            }
            this.mRenderPaint.setPathEffect((PathEffect) null);
        }
    }

    /* access modifiers changed from: protected */
    public void drawCubic(Canvas canvas, ILineDataSet iLineDataSet) {
        ILineDataSet iLineDataSet2 = iLineDataSet;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        int entryCount = iLineDataSet.getEntryCount();
        Entry entryForXIndex = iLineDataSet2.getEntryForXIndex(this.mMinX < 0 ? 0 : this.mMinX, DataSet.Rounding.DOWN);
        Entry entryForXIndex2 = iLineDataSet2.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
        int i = 1;
        int max = Math.max(iLineDataSet2.getEntryIndex(entryForXIndex) - (entryForXIndex == entryForXIndex2 ? 1 : 0), 0);
        int min = Math.min(Math.max(max + 2, iLineDataSet2.getEntryIndex(entryForXIndex2) + 1), entryCount);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float cubicIntensity = iLineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
        if (ceil - max >= 2) {
            Entry entryForIndex = iLineDataSet2.getEntryForIndex(max);
            int i2 = max + 1;
            iLineDataSet2.getEntryForIndex(i2);
            this.cubicPath.moveTo((float) entryForIndex.getXIndex(), entryForIndex.getVal() * phaseY);
            int i3 = entryCount - 1;
            int min2 = Math.min(ceil, i3);
            while (i2 < min2) {
                Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(i2 == i ? 0 : i2 - 2);
                Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(i2 - 1);
                Entry entryForIndex4 = iLineDataSet2.getEntryForIndex(i2);
                int i4 = i2 + 1;
                Entry entryForIndex5 = iLineDataSet2.getEntryForIndex(i4);
                this.cubicPath.cubicTo(((float) entryForIndex3.getXIndex()) + (((float) (entryForIndex4.getXIndex() - entryForIndex2.getXIndex())) * cubicIntensity), (entryForIndex3.getVal() + ((entryForIndex4.getVal() - entryForIndex2.getVal()) * cubicIntensity)) * phaseY, ((float) entryForIndex4.getXIndex()) - (((float) (entryForIndex5.getXIndex() - entryForIndex3.getXIndex())) * cubicIntensity), (entryForIndex4.getVal() - ((entryForIndex5.getVal() - entryForIndex3.getVal()) * cubicIntensity)) * phaseY, (float) entryForIndex4.getXIndex(), entryForIndex4.getVal() * phaseY);
                i2 = i4;
                min2 = min2;
                i = 1;
            }
            if (ceil > i3) {
                Entry entryForIndex6 = iLineDataSet2.getEntryForIndex(entryCount >= 3 ? entryCount - 3 : entryCount - 2);
                Entry entryForIndex7 = iLineDataSet2.getEntryForIndex(entryCount - 2);
                Entry entryForIndex8 = iLineDataSet2.getEntryForIndex(i3);
                this.cubicPath.cubicTo(((float) entryForIndex7.getXIndex()) + (((float) (entryForIndex8.getXIndex() - entryForIndex6.getXIndex())) * cubicIntensity), (entryForIndex7.getVal() + ((entryForIndex8.getVal() - entryForIndex6.getVal()) * cubicIntensity)) * phaseY, ((float) entryForIndex8.getXIndex()) - (((float) (entryForIndex8.getXIndex() - entryForIndex7.getXIndex())) * cubicIntensity), (entryForIndex8.getVal() - ((entryForIndex8.getVal() - entryForIndex7.getVal()) * cubicIntensity)) * phaseY, (float) entryForIndex8.getXIndex(), entryForIndex8.getVal() * phaseY);
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet2, this.cubicFillPath, transformer, max, ceil);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void drawCubicFill(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, int i, int i2) {
        float f;
        if (i2 - i > 1) {
            float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
            Entry entryForIndex = iLineDataSet.getEntryForIndex(i2 - 1);
            Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i);
            float f2 = 0.0f;
            if (entryForIndex == null) {
                f = 0.0f;
            } else {
                f = (float) entryForIndex.getXIndex();
            }
            if (entryForIndex2 != null) {
                f2 = (float) entryForIndex2.getXIndex();
            }
            path.lineTo(f, fillLinePosition);
            path.lineTo(f2, fillLinePosition);
            path.close();
            transformer.pathValueToPixel(path);
            Drawable fillDrawable = iLineDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawLinear(Canvas canvas, ILineDataSet iLineDataSet) {
        boolean z;
        char c;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        int entryCount = iLineDataSet.getEntryCount();
        boolean isDrawSteppedEnabled = iLineDataSet.isDrawSteppedEnabled();
        int i = isDrawSteppedEnabled ? 4 : 2;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.isDashedLineEnabled() ? this.mBitmapCanvas : canvas;
        Entry entryForXIndex = iLineDataSet2.getEntryForXIndex(this.mMinX < 0 ? 0 : this.mMinX, DataSet.Rounding.DOWN);
        Entry entryForXIndex2 = iLineDataSet2.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
        int i2 = 1;
        int max = Math.max(iLineDataSet2.getEntryIndex(entryForXIndex) - (entryForXIndex == entryForXIndex2 ? 1 : 0), 0);
        int min = Math.min(Math.max(max + 2, iLineDataSet2.getEntryIndex(entryForXIndex2) + 1), entryCount);
        int i3 = min;
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
        if (iLineDataSet.getColors().size() > 1) {
            int i4 = i * 2;
            if (this.mLineBuffer.length != i4) {
                this.mLineBuffer = new float[i4];
            }
            int i5 = max;
            while (i5 < ceil && (ceil <= i2 || i5 != ceil - 1)) {
                Entry entryForIndex = iLineDataSet2.getEntryForIndex(i5);
                if (entryForIndex != null) {
                    this.mLineBuffer[0] = (float) entryForIndex.getXIndex();
                    this.mLineBuffer[i2] = entryForIndex.getVal() * phaseY;
                    int i6 = i5 + 1;
                    if (i6 < ceil) {
                        Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(i6);
                        if (entryForIndex2 == null) {
                            break;
                        }
                        if (isDrawSteppedEnabled) {
                            this.mLineBuffer[2] = (float) entryForIndex2.getXIndex();
                            this.mLineBuffer[3] = this.mLineBuffer[i2];
                            this.mLineBuffer[4] = this.mLineBuffer[2];
                            this.mLineBuffer[5] = this.mLineBuffer[3];
                            this.mLineBuffer[6] = (float) entryForIndex2.getXIndex();
                            this.mLineBuffer[7] = entryForIndex2.getVal() * phaseY;
                        } else {
                            this.mLineBuffer[2] = (float) entryForIndex2.getXIndex();
                            this.mLineBuffer[3] = entryForIndex2.getVal() * phaseY;
                        }
                        c = 0;
                    } else {
                        c = 0;
                        this.mLineBuffer[2] = this.mLineBuffer[0];
                        this.mLineBuffer[3] = this.mLineBuffer[1];
                    }
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mLineBuffer[c])) {
                        break;
                    } else if (this.mViewPortHandler.isInBoundsLeft(this.mLineBuffer[2]) && ((this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1]) || this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3])) && (this.mViewPortHandler.isInBoundsTop(this.mLineBuffer[1]) || this.mViewPortHandler.isInBoundsBottom(this.mLineBuffer[3])))) {
                        this.mRenderPaint.setColor(iLineDataSet2.getColor(i5));
                        canvas2.drawLines(this.mLineBuffer, 0, i4, this.mRenderPaint);
                    }
                }
                i5++;
                i2 = 1;
            }
        } else {
            int i7 = (entryCount - 1) * i;
            if (this.mLineBuffer.length != Math.max(i7, i) * 2) {
                this.mLineBuffer = new float[(Math.max(i7, i) * 2)];
            }
            if (iLineDataSet2.getEntryForIndex(max) != null) {
                int i8 = ceil > 1 ? max + 1 : max;
                int i9 = 0;
                while (i8 < ceil) {
                    Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(i8 == 0 ? 0 : i8 - 1);
                    Entry entryForIndex4 = iLineDataSet2.getEntryForIndex(i8);
                    if (entryForIndex3 == null || entryForIndex4 == null) {
                        z = isDrawSteppedEnabled;
                    } else {
                        int i10 = i9 + 1;
                        this.mLineBuffer[i9] = (float) entryForIndex3.getXIndex();
                        int i11 = i10 + 1;
                        this.mLineBuffer[i10] = entryForIndex3.getVal() * phaseY;
                        if (isDrawSteppedEnabled) {
                            int i12 = i11 + 1;
                            z = isDrawSteppedEnabled;
                            this.mLineBuffer[i11] = (float) entryForIndex4.getXIndex();
                            int i13 = i12 + 1;
                            this.mLineBuffer[i12] = entryForIndex3.getVal() * phaseY;
                            int i14 = i13 + 1;
                            this.mLineBuffer[i13] = (float) entryForIndex4.getXIndex();
                            this.mLineBuffer[i14] = entryForIndex3.getVal() * phaseY;
                            i11 = i14 + 1;
                        } else {
                            z = isDrawSteppedEnabled;
                        }
                        int i15 = i11 + 1;
                        this.mLineBuffer[i11] = (float) entryForIndex4.getXIndex();
                        i9 = i15 + 1;
                        this.mLineBuffer[i15] = entryForIndex4.getVal() * phaseY;
                    }
                    i8++;
                    isDrawSteppedEnabled = z;
                }
                transformer.pointValuesToPixel(this.mLineBuffer);
                this.mRenderPaint.setColor(iLineDataSet.getColor());
                canvas2.drawLines(this.mLineBuffer, 0, Math.max(((ceil - max) - 1) * i, i) * 2, this.mRenderPaint);
            }
        }
        this.mRenderPaint.setPathEffect((PathEffect) null);
        if (iLineDataSet.isDrawFilledEnabled() && entryCount > 0) {
            drawLinearFill(canvas, iLineDataSet2, max, i3, transformer);
        }
    }

    /* access modifiers changed from: protected */
    public void drawLinearFill(Canvas canvas, ILineDataSet iLineDataSet, int i, int i2, Transformer transformer) {
        Path generateFilledPath = generateFilledPath(iLineDataSet, i, i2);
        transformer.pathValueToPixel(generateFilledPath);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, generateFilledPath, fillDrawable);
        } else {
            drawFilledPath(canvas, generateFilledPath, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
        }
    }

    private Path generateFilledPath(ILineDataSet iLineDataSet, int i, int i2) {
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        boolean isDrawSteppedEnabled = iLineDataSet.isDrawSteppedEnabled();
        Path path = new Path();
        Entry entryForIndex = iLineDataSet.getEntryForIndex(i);
        path.moveTo((float) entryForIndex.getXIndex(), fillLinePosition);
        path.lineTo((float) entryForIndex.getXIndex(), entryForIndex.getVal() * phaseY);
        double d = (double) ((((float) (i2 - i)) * phaseX) + ((float) i));
        int ceil = (int) Math.ceil(d);
        for (int i3 = i + 1; i3 < ceil; i3++) {
            Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i3);
            if (isDrawSteppedEnabled) {
                Entry entryForIndex3 = iLineDataSet.getEntryForIndex(i3 - 1);
                if (entryForIndex3 == null) {
                } else {
                    path.lineTo((float) entryForIndex2.getXIndex(), entryForIndex3.getVal() * phaseY);
                }
            }
            path.lineTo((float) entryForIndex2.getXIndex(), entryForIndex2.getVal() * phaseY);
        }
        path.lineTo((float) iLineDataSet.getEntryForIndex(Math.max(Math.min(((int) Math.ceil(d)) - 1, iLineDataSet.getEntryCount() - 1), 0)).getXIndex(), fillLinePosition);
        path.close();
        return path;
    }

    public void drawValues(Canvas canvas) {
        int i;
        float[] fArr;
        if (((float) this.mChart.getLineData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getLineData().getDataSets();
            for (int i2 = 0; i2 < dataSets.size(); i2++) {
                ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i2);
                if (iLineDataSet.isDrawValuesEnabled() && iLineDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iLineDataSet);
                    Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                    int circleRadius = (int) (iLineDataSet.getCircleRadius() * 1.75f);
                    if (!iLineDataSet.isDrawCirclesEnabled()) {
                        circleRadius /= 2;
                    }
                    int i3 = circleRadius;
                    int entryCount = iLineDataSet.getEntryCount();
                    Entry entryForXIndex = iLineDataSet.getEntryForXIndex(this.mMinX < 0 ? 0 : this.mMinX, DataSet.Rounding.DOWN);
                    Entry entryForXIndex2 = iLineDataSet.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
                    int max = Math.max(iLineDataSet.getEntryIndex(entryForXIndex) - (entryForXIndex == entryForXIndex2 ? 1 : 0), 0);
                    float[] generateTransformedValuesLine = transformer.generateTransformedValuesLine(iLineDataSet, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), max, Math.min(Math.max(max + 2, iLineDataSet.getEntryIndex(entryForXIndex2) + 1), entryCount));
                    int i4 = 0;
                    while (i4 < generateTransformedValuesLine.length) {
                        float f = generateTransformedValuesLine[i4];
                        float f2 = generateTransformedValuesLine[i4 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f) || !this.mViewPortHandler.isInBoundsY(f2)) {
                            i = i4;
                            fArr = generateTransformedValuesLine;
                        } else {
                            int i5 = i4 / 2;
                            Entry entryForIndex = iLineDataSet.getEntryForIndex(i5 + max);
                            i = i4;
                            fArr = generateTransformedValuesLine;
                            drawValue(canvas, iLineDataSet.getValueFormatter(), entryForIndex.getVal(), entryForIndex, i2, f, f2 - ((float) i3), iLineDataSet.getValueTextColor(i5));
                        }
                        i4 = i + 2;
                        generateTransformedValuesLine = fArr;
                    }
                }
            }
        }
    }

    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawCircles(Canvas canvas) {
        float f;
        Canvas canvas2 = canvas;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float[] fArr = new float[2];
        List dataSets = this.mChart.getLineData().getDataSets();
        int i = 0;
        int i2 = 0;
        while (i2 < dataSets.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i2);
            if (iLineDataSet.isVisible() && iLineDataSet.isDrawCirclesEnabled() && iLineDataSet.getEntryCount() != 0) {
                this.mCirclePaintInner.setColor(iLineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                int entryCount = iLineDataSet.getEntryCount();
                Entry entryForXIndex = iLineDataSet.getEntryForXIndex(this.mMinX < 0 ? 0 : this.mMinX, DataSet.Rounding.DOWN);
                Entry entryForXIndex2 = iLineDataSet.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
                char c = 1;
                int max = Math.max(iLineDataSet.getEntryIndex(entryForXIndex) - (entryForXIndex == entryForXIndex2 ? 1 : 0), i);
                int min = Math.min(Math.max(max + 2, iLineDataSet.getEntryIndex(entryForXIndex2) + 1), entryCount);
                float circleRadius = iLineDataSet.getCircleRadius() / 2.0f;
                int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
                while (max < ceil) {
                    Entry entryForIndex = iLineDataSet.getEntryForIndex(max);
                    if (entryForIndex == null) {
                        break;
                    }
                    fArr[i] = (float) entryForIndex.getXIndex();
                    fArr[c] = entryForIndex.getVal() * phaseY;
                    transformer.pointValuesToPixel(fArr);
                    if (!this.mViewPortHandler.isInBoundsRight(fArr[i])) {
                        break;
                    }
                    if (!this.mViewPortHandler.isInBoundsLeft(fArr[i]) || !this.mViewPortHandler.isInBoundsY(fArr[c])) {
                        f = phaseX;
                    } else {
                        int circleColor = iLineDataSet.getCircleColor(max);
                        this.mRenderPaint.setColor(circleColor);
                        f = phaseX;
                        canvas2.drawCircle(fArr[i], fArr[c], iLineDataSet.getCircleRadius(), this.mRenderPaint);
                        if (!iLineDataSet.isDrawCircleHoleEnabled() || circleColor == this.mCirclePaintInner.getColor()) {
                            c = 1;
                        } else {
                            c = 1;
                            canvas2.drawCircle(fArr[0], fArr[1], circleRadius, this.mCirclePaintInner);
                        }
                    }
                    max++;
                    phaseX = f;
                    i = 0;
                }
            }
            i2++;
            phaseX = phaseX;
            i = 0;
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i = 0; i < highlightArr.length; i++) {
            ILineDataSet iLineDataSet = (ILineDataSet) this.mChart.getLineData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (iLineDataSet != null && iLineDataSet.isHighlightEnabled()) {
                int xIndex = highlightArr[i].getXIndex();
                float f = (float) xIndex;
                if (f <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yValForXIndex = iLineDataSet.getYValForXIndex(xIndex);
                    if (yValForXIndex != Float.NaN) {
                        float[] fArr = {f, yValForXIndex * this.mAnimator.getPhaseY()};
                        this.mChart.getTransformer(iLineDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                        drawHighlightLines(canvas, fArr, iLineDataSet);
                    }
                }
            }
        }
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        releaseBitmap();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public void releaseBitmap() {
        if (this.mDrawBitmap != null) {
            ((Bitmap) this.mDrawBitmap.get()).recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
