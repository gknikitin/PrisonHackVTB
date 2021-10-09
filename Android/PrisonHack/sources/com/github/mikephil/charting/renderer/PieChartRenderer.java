package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds = new RectF();
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    private Path mHoleCirclePath = new Path();
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer = new RectF();
    private Path mPathBuffer = new Path();
    private RectF[] mRectBuffer = {new RectF(), new RectF(), new RectF()};
    protected Paint mTransparentCirclePaint;

    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = pieChart;
        this.mHolePaint = new Paint(1);
        this.mHolePaint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint = new Paint(1);
        this.mTransparentCirclePaint.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        this.mCenterTextPaint = new TextPaint(1);
        this.mCenterTextPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        if (!(this.mDrawBitmap != null && ((Bitmap) this.mDrawBitmap.get()).getWidth() == chartWidth && ((Bitmap) this.mDrawBitmap.get()).getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444));
                this.mBitmapCanvas = new Canvas((Bitmap) this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.mDrawBitmap.get()).eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float calculateMinimumRadiusForSpacedSlice(PointF pointF, float f, float f2, float f3, float f4, float f5, float f6) {
        PointF pointF2 = pointF;
        double d = (double) ((f5 + f6) * 0.017453292f);
        float cos = pointF2.x + (((float) Math.cos(d)) * f);
        float sin = pointF2.y + (((float) Math.sin(d)) * f);
        double d2 = (double) ((f5 + (f6 / 2.0f)) * 0.017453292f);
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow((double) (cos - f3), 2.0d) + Math.pow((double) (sin - f4), 2.0d)) / 2.0d) * Math.tan(0.017453292519943295d * ((180.0d - ((double) f2)) / 2.0d)))))) - Math.sqrt(Math.pow((double) ((pointF2.x + (((float) Math.cos(d2)) * f)) - ((cos + f3) / 2.0f)), 2.0d) + Math.pow((double) ((pointF2.y + (((float) Math.sin(d2)) * f)) - ((sin + f4) / 2.0f)), 2.0d)));
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f;
        float[] fArr;
        RectF rectF;
        float f2;
        float f3;
        float f4;
        int i;
        PointF pointF;
        float f5;
        int i2;
        int i3;
        int i4;
        int i5;
        float f6;
        float f7;
        float f8;
        int i6;
        PointF pointF2;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        int i7 = 0;
        for (int i8 = 0; i8 < entryCount; i8++) {
            if (((double) Math.abs(iPieDataSet2.getEntryForIndex(i8).getVal())) > 1.0E-6d) {
                i7++;
            }
        }
        if (i7 <= 1) {
            f = 0.0f;
        } else {
            f = iPieDataSet.getSliceSpace();
        }
        int i9 = 0;
        float f9 = 0.0f;
        while (i9 < entryCount) {
            float f10 = drawAngles[i9];
            Entry entryForIndex = iPieDataSet2.getEntryForIndex(i9);
            float f11 = radius;
            if (((double) Math.abs(entryForIndex.getVal())) <= 1.0E-6d || this.mChart.needsHighlight(entryForIndex.getXIndex(), ((PieData) this.mChart.getData()).getIndexOfDataSet(iPieDataSet2))) {
                f4 = rotationAngle;
                f3 = phaseX;
                f2 = phaseY;
                rectF = circleBox;
                i = entryCount;
                fArr = drawAngles;
                i3 = i9;
                i2 = i7;
                f5 = holeRadius;
                pointF = centerCircleBox;
            } else {
                boolean z2 = f > 0.0f && f10 <= 180.0f;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i9));
                float f12 = i7 == 1 ? 0.0f : f / (f11 * 0.017453292f);
                float f13 = ((f9 + (f12 / 2.0f)) * phaseY) + rotationAngle;
                float f14 = (f10 - f12) * phaseY;
                if (f14 < 0.0f) {
                    f14 = 0.0f;
                }
                this.mPathBuffer.reset();
                float f15 = f14 % 360.0f;
                if (f15 == 0.0f) {
                    i5 = i9;
                    i4 = i7;
                    i = entryCount;
                    f6 = f11;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f6, Path.Direction.CW);
                    f4 = rotationAngle;
                    f3 = phaseX;
                    f2 = phaseY;
                    f8 = 0.0f;
                    f7 = 0.0f;
                } else {
                    i5 = i9;
                    i4 = i7;
                    i = entryCount;
                    f6 = f11;
                    f4 = rotationAngle;
                    double d = (double) (f13 * 0.017453292f);
                    f3 = phaseX;
                    f2 = phaseY;
                    float cos = centerCircleBox.x + (((float) Math.cos(d)) * f6);
                    float sin = centerCircleBox.y + (((float) Math.sin(d)) * f6);
                    this.mPathBuffer.moveTo(cos, sin);
                    this.mPathBuffer.arcTo(circleBox, f13, f14);
                    f8 = cos;
                    f7 = sin;
                }
                this.mInnerRectBuffer.set(centerCircleBox.x - holeRadius, centerCircleBox.y - holeRadius, centerCircleBox.x + holeRadius, centerCircleBox.y + holeRadius);
                if (!z || (holeRadius <= 0.0f && !z2)) {
                    float f16 = f14;
                    rectF = circleBox;
                    f11 = f6;
                    fArr = drawAngles;
                    i3 = i5;
                    i2 = i4;
                    f5 = holeRadius;
                    pointF = centerCircleBox;
                    if (f15 != 0.0f) {
                        if (z2) {
                            float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(pointF, f11, f10 * f2, f8, f7, f13, f16);
                            double d2 = (double) ((f13 + (f16 / 2.0f)) * 0.017453292f);
                            this.mPathBuffer.lineTo(pointF.x + (((float) Math.cos(d2)) * calculateMinimumRadiusForSpacedSlice), pointF.y + (calculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d2))));
                        } else {
                            this.mPathBuffer.lineTo(pointF.x, pointF.y);
                        }
                    }
                } else {
                    if (z2) {
                        i3 = i5;
                        float f17 = f6;
                        i2 = i4;
                        rectF = circleBox;
                        f5 = holeRadius;
                        float f18 = f8;
                        float f19 = f6;
                        i6 = 1;
                        float f20 = f7;
                        f11 = f19;
                        pointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, f17, f10 * f2, f18, f20, f13, f14);
                        if (calculateMinimumRadiusForSpacedSlice2 < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice2 = -calculateMinimumRadiusForSpacedSlice2;
                        }
                        holeRadius = Math.max(f5, calculateMinimumRadiusForSpacedSlice2);
                    } else {
                        pointF2 = centerCircleBox;
                        rectF = circleBox;
                        f11 = f6;
                        i3 = i5;
                        i2 = i4;
                        i6 = 1;
                        f5 = holeRadius;
                    }
                    float f21 = (i2 == i6 || holeRadius == 0.0f) ? 0.0f : f / (holeRadius * 0.017453292f);
                    float f22 = f4 + ((f9 + (f21 / 2.0f)) * f2);
                    float f23 = (f10 - f21) * f2;
                    if (f23 < 0.0f) {
                        f23 = 0.0f;
                    }
                    float f24 = f22 + f23;
                    if (f15 == 0.0f) {
                        this.mPathBuffer.addCircle(pointF2.x, pointF2.y, holeRadius, Path.Direction.CCW);
                        fArr = drawAngles;
                    } else {
                        double d3 = (double) (f24 * 0.017453292f);
                        fArr = drawAngles;
                        this.mPathBuffer.lineTo(pointF2.x + (((float) Math.cos(d3)) * holeRadius), pointF2.y + (holeRadius * ((float) Math.sin(d3))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f24, -f23);
                    }
                    pointF = pointF2;
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            }
            f9 += f10 * f3;
            i9 = i3 + 1;
            i7 = i2;
            holeRadius = f5;
            centerCircleBox = pointF;
            radius = f11;
            entryCount = i;
            rotationAngle = f4;
            phaseX = f3;
            phaseY = f2;
            circleBox = rectF;
            drawAngles = fArr;
            iPieDataSet2 = iPieDataSet;
        }
    }

    public void drawValues(Canvas canvas) {
        float f;
        float[] fArr;
        float[] fArr2;
        float f2;
        float f3;
        List list;
        int i;
        PieData pieData;
        float f4;
        float f5;
        List list2;
        int i2;
        int i3;
        int i4;
        PieData pieData2;
        IPieDataSet iPieDataSet;
        Canvas canvas2 = canvas;
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float phaseX = this.mAnimator.getPhaseX();
        this.mAnimator.getPhaseY();
        float f6 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f6 = (radius - ((radius / 100.0f) * this.mChart.getHoleRadius())) / 2.0f;
        }
        float f7 = radius - f6;
        PieData pieData3 = (PieData) this.mChart.getData();
        List dataSets = pieData3.getDataSets();
        float yValueSum = pieData3.getYValueSum();
        boolean isDrawSliceTextEnabled = this.mChart.isDrawSliceTextEnabled();
        int i5 = 0;
        int i6 = 0;
        while (i6 < dataSets.size()) {
            IPieDataSet iPieDataSet2 = (IPieDataSet) dataSets.get(i6);
            if (iPieDataSet2.isDrawValuesEnabled() || isDrawSliceTextEnabled) {
                applyValueTextStyle(iPieDataSet2);
                float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "Q")) + Utils.convertDpToPixel(4.0f);
                int entryCount = iPieDataSet2.getEntryCount();
                int min = Math.min((int) Math.ceil((double) (((float) entryCount) * phaseX)), entryCount);
                int i7 = i5;
                int i8 = 0;
                while (i8 < min) {
                    Entry entryForIndex = iPieDataSet2.getEntryForIndex(i8);
                    if (i7 == 0) {
                        f4 = 0.0f;
                    } else {
                        f4 = absoluteAngles[i7 - 1] * phaseX;
                    }
                    int i9 = i6;
                    List list3 = dataSets;
                    double d = (double) f7;
                    PieData pieData4 = pieData3;
                    float f8 = f7;
                    double sliceSpace = (double) (f4 + ((drawAngles[i7] - ((iPieDataSet2.getSliceSpace() / (0.017453292f * f7)) / 2.0f)) / 2.0f) + rotationAngle);
                    float f9 = rotationAngle;
                    float[] fArr3 = drawAngles;
                    float[] fArr4 = absoluteAngles;
                    float f10 = phaseX;
                    float cos = (float) ((Math.cos(Math.toRadians(sliceSpace)) * d) + ((double) centerCircleBox.x));
                    float sin = (float) ((d * Math.sin(Math.toRadians(sliceSpace))) + ((double) centerCircleBox.y));
                    float val = this.mChart.isUsePercentValuesEnabled() ? (entryForIndex.getVal() / yValueSum) * 100.0f : entryForIndex.getVal();
                    ValueFormatter valueFormatter = iPieDataSet2.getValueFormatter();
                    boolean isDrawValuesEnabled = iPieDataSet2.isDrawValuesEnabled();
                    if (!isDrawSliceTextEnabled || !isDrawValuesEnabled) {
                        Entry entry = entryForIndex;
                        i4 = i8;
                        i3 = min;
                        IPieDataSet iPieDataSet3 = iPieDataSet2;
                        list2 = list3;
                        i2 = i9;
                        f5 = f8;
                        PieData pieData5 = pieData4;
                        if (isDrawSliceTextEnabled) {
                            if (i4 < pieData5.getXValCount()) {
                                this.mValuePaint.setColor(iPieDataSet3.getValueTextColor(i4));
                                canvas2.drawText(pieData5.getXVals().get(i4), cos, sin + (calcTextHeight / 2.0f), this.mValuePaint);
                            }
                        } else if (isDrawValuesEnabled) {
                            int valueTextColor = iPieDataSet3.getValueTextColor(i4);
                            float f11 = cos;
                            iPieDataSet = iPieDataSet3;
                            float f12 = sin + (calcTextHeight / 2.0f);
                            pieData2 = pieData5;
                            drawValue(canvas2, valueFormatter, val, entry, 0, f11, f12, valueTextColor);
                        }
                        iPieDataSet = iPieDataSet3;
                        pieData2 = pieData5;
                    } else {
                        int valueTextColor2 = iPieDataSet2.getValueTextColor(i8);
                        i4 = i8;
                        i3 = min;
                        IPieDataSet iPieDataSet4 = iPieDataSet2;
                        i2 = i9;
                        IPieDataSet iPieDataSet5 = iPieDataSet4;
                        list2 = list3;
                        f5 = f8;
                        drawValue(canvas2, valueFormatter, val, entryForIndex, 0, cos, sin, valueTextColor2);
                        PieData pieData6 = pieData4;
                        if (i4 < pieData6.getXValCount()) {
                            canvas2.drawText(pieData6.getXVals().get(i4), cos, sin + calcTextHeight, this.mValuePaint);
                        }
                        pieData2 = pieData6;
                        iPieDataSet = iPieDataSet5;
                    }
                    i7++;
                    i8 = i4 + 1;
                    iPieDataSet2 = iPieDataSet;
                    pieData3 = pieData2;
                    min = i3;
                    i6 = i2;
                    dataSets = list2;
                    f7 = f5;
                    rotationAngle = f9;
                    drawAngles = fArr3;
                    absoluteAngles = fArr4;
                    phaseX = f10;
                }
                i = i6;
                list = dataSets;
                f3 = f7;
                f2 = rotationAngle;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
                f = phaseX;
                pieData = pieData3;
                i5 = i7;
            } else {
                i = i6;
                list = dataSets;
                f3 = f7;
                f2 = rotationAngle;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
                f = phaseX;
                pieData = pieData3;
            }
            i6 = i + 1;
            pieData3 = pieData;
            dataSets = list;
            f7 = f3;
            rotationAngle = f2;
            drawAngles = fArr2;
            absoluteAngles = fArr;
            phaseX = f;
        }
    }

    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap((Bitmap) this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawHole(Canvas canvas) {
        if (this.mChart.isDrawHoleEnabled()) {
            float radius = this.mChart.getRadius();
            float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
            PointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (Color.alpha(this.mHolePaint.getColor()) > 0) {
                this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
            }
            if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
                int alpha = this.mTransparentCirclePaint.getAlpha();
                float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
                this.mTransparentCirclePaint.setAlpha((int) (((float) alpha) * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
                this.mHoleCirclePath.reset();
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
                this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
                this.mTransparentCirclePaint.setAlpha(alpha);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawCenterText(Canvas canvas) {
        CharSequence centerText = this.mChart.getCenterText();
        if (this.mChart.isDrawCenterTextEnabled() && centerText != null) {
            PointF centerCircleBox = this.mChart.getCenterCircleBox();
            float radius = (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) ? this.mChart.getRadius() : this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
            RectF rectF = this.mRectBuffer[0];
            rectF.left = centerCircleBox.x - radius;
            rectF.top = centerCircleBox.y - radius;
            rectF.right = centerCircleBox.x + radius;
            rectF.bottom = centerCircleBox.y + radius;
            RectF rectF2 = this.mRectBuffer[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
                this.mCenterTextLastBounds.set(rectF2);
                this.mCenterTextLastValue = centerText;
                this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil((double) this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            float height = (float) this.mCenterTextLayout.getHeight();
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                Path path = new Path();
                path.addOval(rectF, Path.Direction.CW);
                canvas.clipPath(path);
            }
            canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.mCenterTextLayout.draw(canvas);
            canvas.restore();
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float[] fArr;
        float[] fArr2;
        RectF rectF;
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        PointF pointF;
        IPieDataSet dataSetByIndex;
        float f5;
        int i2;
        float f6;
        int i3;
        float f7;
        int i4;
        int i5;
        float f8;
        float f9;
        Highlight[] highlightArr2 = highlightArr;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = new RectF();
        int i6 = 0;
        while (i6 < highlightArr2.length) {
            int xIndex = highlightArr2[i6].getXIndex();
            if (xIndex < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i6].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i7 = 0;
                int i8 = 0;
                while (i7 < entryCount) {
                    int i9 = entryCount;
                    float f10 = phaseY;
                    float f11 = rotationAngle;
                    if (((double) Math.abs(dataSetByIndex.getEntryForIndex(i7).getVal())) > 1.0E-6d) {
                        i8++;
                    }
                    i7++;
                    entryCount = i9;
                    phaseY = f10;
                    rotationAngle = f11;
                }
                f3 = phaseY;
                f2 = rotationAngle;
                if (xIndex == 0) {
                    i2 = 1;
                    f5 = 0.0f;
                } else {
                    f5 = absoluteAngles[xIndex - 1] * phaseX;
                    i2 = 1;
                }
                if (i8 <= i2) {
                    f6 = 0.0f;
                } else {
                    f6 = dataSetByIndex.getSliceSpace();
                }
                float f12 = drawAngles[xIndex];
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f13 = radius + selectionShift;
                int i10 = i6;
                rectF2.set(this.mChart.getCircleBox());
                float f14 = -selectionShift;
                rectF2.inset(f14, f14);
                boolean z2 = f6 > 0.0f && f12 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(xIndex));
                float f15 = i8 == 1 ? 0.0f : f6 / (radius * 0.017453292f);
                float f16 = i8 == 1 ? 0.0f : f6 / (f13 * 0.017453292f);
                float f17 = f2 + (((f15 / 2.0f) + f5) * f3);
                float f18 = (f12 - f15) * f3;
                float f19 = f18 < 0.0f ? 0.0f : f18;
                float f20 = f2 + (((f16 / 2.0f) + f5) * f3);
                float f21 = (f12 - f16) * f3;
                if (f21 < 0.0f) {
                    f21 = 0.0f;
                }
                this.mPathBuffer.reset();
                float f22 = f19 % 360.0f;
                if (f22 == 0.0f) {
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f13, Path.Direction.CW);
                    f7 = holeRadius;
                    i3 = i8;
                    f = phaseX;
                } else {
                    f7 = holeRadius;
                    i3 = i8;
                    double d = (double) (f20 * 0.017453292f);
                    f = phaseX;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d)) * f13), centerCircleBox.y + (f13 * ((float) Math.sin(d))));
                    this.mPathBuffer.arcTo(rectF2, f20, f21);
                }
                if (z2) {
                    double d2 = (double) (f17 * 0.017453292f);
                    i = i10;
                    rectF = rectF2;
                    f4 = f7;
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                    i5 = i3;
                    i4 = 1;
                    f8 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f12 * f3, (((float) Math.cos(d2)) * radius) + centerCircleBox.x, centerCircleBox.y + (((float) Math.sin(d2)) * radius), f17, f19);
                } else {
                    rectF = rectF2;
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                    i = i10;
                    f4 = f7;
                    i5 = i3;
                    i4 = 1;
                    f8 = 0.0f;
                }
                this.mInnerRectBuffer.set(centerCircleBox.x - f4, centerCircleBox.y - f4, centerCircleBox.x + f4, centerCircleBox.y + f4);
                if (!z || (f4 <= 0.0f && !z2)) {
                    pointF = centerCircleBox;
                    if (f22 != 0.0f) {
                        if (z2) {
                            double d3 = (double) ((f17 + (f19 / 2.0f)) * 0.017453292f);
                            this.mPathBuffer.lineTo(pointF.x + (((float) Math.cos(d3)) * f8), pointF.y + (f8 * ((float) Math.sin(d3))));
                        } else {
                            this.mPathBuffer.lineTo(pointF.x, pointF.y);
                        }
                    }
                } else {
                    if (z2) {
                        if (f8 < 0.0f) {
                            f8 = -f8;
                        }
                        f9 = Math.max(f4, f8);
                    } else {
                        f9 = f4;
                    }
                    float f23 = (i5 == i4 || f9 == 0.0f) ? 0.0f : f6 / (f9 * 0.017453292f);
                    float f24 = f2 + ((f5 + (f23 / 2.0f)) * f3);
                    float f25 = (f12 - f23) * f3;
                    if (f25 < 0.0f) {
                        f25 = 0.0f;
                    }
                    float f26 = f24 + f25;
                    if (f22 == 0.0f) {
                        this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f9, Path.Direction.CCW);
                        pointF = centerCircleBox;
                    } else {
                        double d4 = (double) (f26 * 0.017453292f);
                        pointF = centerCircleBox;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d4)) * f9), pointF.y + (f9 * ((float) Math.sin(d4))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f26, -f25);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i = i6;
                rectF = rectF2;
                f = phaseX;
                f3 = phaseY;
                f2 = rotationAngle;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
                pointF = centerCircleBox;
                f4 = holeRadius;
            }
            i6 = i + 1;
            centerCircleBox = pointF;
            holeRadius = f4;
            phaseY = f3;
            rotationAngle = f2;
            phaseX = f;
            rectF2 = rectF;
            drawAngles = fArr2;
            absoluteAngles = fArr;
            highlightArr2 = highlightArr;
        }
    }

    /* access modifiers changed from: protected */
    public void drawRoundedSlices(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float[] fArr;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                PointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f4 = drawAngles[i];
                    if (((double) Math.abs(dataSet.getEntryForIndex(i).getVal())) > 1.0E-6d) {
                        double d = (double) (radius - holeRadius);
                        double d2 = (double) ((rotationAngle + f4) * phaseY);
                        fArr = drawAngles;
                        f3 = rotationAngle;
                        f2 = phaseX;
                        f = phaseY;
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle((float) ((Math.cos(Math.toRadians(d2)) * d) + ((double) centerCircleBox.x)), (float) ((d * Math.sin(Math.toRadians(d2))) + ((double) centerCircleBox.y)), holeRadius, this.mRenderPaint);
                    } else {
                        f2 = phaseX;
                        f = phaseY;
                        fArr = drawAngles;
                        f3 = rotationAngle;
                    }
                    rotationAngle = f3 + (f4 * f2);
                    i++;
                    drawAngles = fArr;
                    phaseX = f2;
                    phaseY = f;
                }
            }
        }
    }

    public void releaseBitmap() {
        if (this.mDrawBitmap != null) {
            ((Bitmap) this.mDrawBitmap.get()).recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
