package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.ScatterBuffer;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    protected ScatterBuffer[] mScatterBuffers;

    public void drawExtras(Canvas canvas) {
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
    }

    public void initBuffers() {
        ScatterData scatterData = this.mChart.getScatterData();
        this.mScatterBuffers = new ScatterBuffer[scatterData.getDataSetCount()];
        for (int i = 0; i < this.mScatterBuffers.length; i++) {
            this.mScatterBuffers[i] = new ScatterBuffer(((IScatterDataSet) scatterData.getDataSetByIndex(i)).getEntryCount() * 2);
        }
    }

    public void drawData(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.mChart.getScatterData().getDataSets()) {
            if (iScatterDataSet.isVisible()) {
                drawDataSet(canvas, iScatterDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        int i;
        Canvas canvas2 = canvas;
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
        float f = convertDpToPixel / 2.0f;
        float convertDpToPixel2 = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius());
        float f2 = convertDpToPixel2 * 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        float f3 = (convertDpToPixel - f2) / 2.0f;
        float f4 = f3 / 2.0f;
        ScatterChart.ScatterShape scatterShape = iScatterDataSet.getScatterShape();
        ScatterBuffer scatterBuffer = this.mScatterBuffers[this.mChart.getScatterData().getIndexOfDataSet(iScatterDataSet2)];
        scatterBuffer.setPhases(phaseX, phaseY);
        scatterBuffer.feed(iScatterDataSet2);
        transformer.pointValuesToPixel(scatterBuffer.buffer);
        int i2 = 0;
        switch (scatterShape) {
            case SQUARE:
                int i3 = 0;
                while (i3 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i3])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i3])) {
                        int i4 = i3 + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i4])) {
                            this.mRenderPaint.setColor(iScatterDataSet2.getColor(i3 / 2));
                            if (((double) f2) > 0.0d) {
                                this.mRenderPaint.setStyle(Paint.Style.STROKE);
                                this.mRenderPaint.setStrokeWidth(f3);
                                i = i3;
                                canvas2.drawRect((scatterBuffer.buffer[i3] - convertDpToPixel2) - f4, (scatterBuffer.buffer[i4] - convertDpToPixel2) - f4, scatterBuffer.buffer[i3] + convertDpToPixel2 + f4, scatterBuffer.buffer[i4] + convertDpToPixel2 + f4, this.mRenderPaint);
                                if (scatterShapeHoleColor != 1122867) {
                                    this.mRenderPaint.setStyle(Paint.Style.FILL);
                                    this.mRenderPaint.setColor(scatterShapeHoleColor);
                                    canvas2.drawRect(scatterBuffer.buffer[i] - convertDpToPixel2, scatterBuffer.buffer[i4] - convertDpToPixel2, scatterBuffer.buffer[i] + convertDpToPixel2, scatterBuffer.buffer[i4] + convertDpToPixel2, this.mRenderPaint);
                                }
                            } else {
                                i = i3;
                                this.mRenderPaint.setStyle(Paint.Style.FILL);
                                canvas2.drawRect(scatterBuffer.buffer[i] - f, scatterBuffer.buffer[i4] - f, scatterBuffer.buffer[i] + f, scatterBuffer.buffer[i4] + f, this.mRenderPaint);
                            }
                            i3 = i + 2;
                            iScatterDataSet2 = iScatterDataSet;
                        }
                    }
                    i = i3;
                    i3 = i + 2;
                    iScatterDataSet2 = iScatterDataSet;
                }
                return;
            case CIRCLE:
                break;
            case TRIANGLE:
                this.mRenderPaint.setStyle(Paint.Style.FILL);
                Path path = new Path();
                while (i2 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i2])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i2])) {
                        int i5 = i2 + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i5])) {
                            this.mRenderPaint.setColor(iScatterDataSet2.getColor(i2 / 2));
                            path.moveTo(scatterBuffer.buffer[i2], scatterBuffer.buffer[i5] - f);
                            path.lineTo(scatterBuffer.buffer[i2] + f, scatterBuffer.buffer[i5] + f);
                            path.lineTo(scatterBuffer.buffer[i2] - f, scatterBuffer.buffer[i5] + f);
                            double d = (double) f2;
                            if (d > 0.0d) {
                                path.lineTo(scatterBuffer.buffer[i2], scatterBuffer.buffer[i5] - f);
                                path.moveTo((scatterBuffer.buffer[i2] - f) + f3, (scatterBuffer.buffer[i5] + f) - f3);
                                path.lineTo((scatterBuffer.buffer[i2] + f) - f3, (scatterBuffer.buffer[i5] + f) - f3);
                                path.lineTo(scatterBuffer.buffer[i2], (scatterBuffer.buffer[i5] - f) + f3);
                                path.lineTo((scatterBuffer.buffer[i2] - f) + f3, (scatterBuffer.buffer[i5] + f) - f3);
                            }
                            path.close();
                            Canvas canvas3 = canvas;
                            canvas3.drawPath(path, this.mRenderPaint);
                            path.reset();
                            if (d > 0.0d && scatterShapeHoleColor != 1122867) {
                                this.mRenderPaint.setColor(scatterShapeHoleColor);
                                path.moveTo(scatterBuffer.buffer[i2], (scatterBuffer.buffer[i5] - f) + f3);
                                path.lineTo((scatterBuffer.buffer[i2] + f) - f3, (scatterBuffer.buffer[i5] + f) - f3);
                                path.lineTo((scatterBuffer.buffer[i2] - f) + f3, (scatterBuffer.buffer[i5] + f) - f3);
                                path.close();
                                canvas3.drawPath(path, this.mRenderPaint);
                                path.reset();
                            }
                        }
                    }
                    i2 += 2;
                }
                return;
            case CROSS:
                this.mRenderPaint.setStyle(Paint.Style.STROKE);
                this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
                int i6 = 0;
                while (i6 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i6])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i6])) {
                        int i7 = i6 + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i7])) {
                            this.mRenderPaint.setColor(iScatterDataSet2.getColor(i6 / 2));
                            canvas2.drawLine(scatterBuffer.buffer[i6] - f, scatterBuffer.buffer[i7], scatterBuffer.buffer[i6] + f, scatterBuffer.buffer[i7], this.mRenderPaint);
                            canvas2.drawLine(scatterBuffer.buffer[i6], scatterBuffer.buffer[i7] - f, scatterBuffer.buffer[i6], scatterBuffer.buffer[i7] + f, this.mRenderPaint);
                        }
                    }
                    i6 += 2;
                }
                return;
            case X:
                this.mRenderPaint.setStyle(Paint.Style.STROKE);
                this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
                int i8 = 0;
                while (i8 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i8])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i8])) {
                        int i9 = i8 + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i9])) {
                            this.mRenderPaint.setColor(iScatterDataSet2.getColor(i8 / 2));
                            canvas2.drawLine(scatterBuffer.buffer[i8] - f, scatterBuffer.buffer[i9] - f, scatterBuffer.buffer[i8] + f, scatterBuffer.buffer[i9] + f, this.mRenderPaint);
                            canvas2.drawLine(scatterBuffer.buffer[i8] + f, scatterBuffer.buffer[i9] - f, scatterBuffer.buffer[i8] - f, scatterBuffer.buffer[i9] + f, this.mRenderPaint);
                        }
                    }
                    i8 += 2;
                }
                return;
            default:
                return;
        }
        while (i2 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i2])) {
            if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i2])) {
                int i10 = i2 + 1;
                if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i10])) {
                    this.mRenderPaint.setColor(iScatterDataSet2.getColor(i2 / 2));
                    if (((double) f2) > 0.0d) {
                        this.mRenderPaint.setStyle(Paint.Style.STROKE);
                        this.mRenderPaint.setStrokeWidth(f3);
                        canvas2.drawCircle(scatterBuffer.buffer[i2], scatterBuffer.buffer[i10], convertDpToPixel2 + f4, this.mRenderPaint);
                        if (scatterShapeHoleColor != 1122867) {
                            this.mRenderPaint.setStyle(Paint.Style.FILL);
                            this.mRenderPaint.setColor(scatterShapeHoleColor);
                            canvas2.drawCircle(scatterBuffer.buffer[i2], scatterBuffer.buffer[i10], convertDpToPixel2, this.mRenderPaint);
                        }
                    } else {
                        this.mRenderPaint.setStyle(Paint.Style.FILL);
                        canvas2.drawCircle(scatterBuffer.buffer[i2], scatterBuffer.buffer[i10], f, this.mRenderPaint);
                    }
                    i2 += 2;
                }
            }
            i2 += 2;
        }
    }

    public void drawValues(Canvas canvas) {
        int i;
        if (((float) this.mChart.getScatterData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getScatterData().getDataSets();
            for (int i2 = 0; i2 < this.mChart.getScatterData().getDataSetCount(); i2++) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i2);
                if (iScatterDataSet.isDrawValuesEnabled() && iScatterDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iScatterDataSet);
                    float[] generateTransformedValuesScatter = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).generateTransformedValuesScatter(iScatterDataSet, this.mAnimator.getPhaseY());
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    int i3 = 0;
                    while (((float) i3) < ((float) generateTransformedValuesScatter.length) * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i3])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i3])) {
                            int i4 = i3 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i4])) {
                                int i5 = i3 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(i5);
                                i = i3;
                                drawValue(canvas, iScatterDataSet.getValueFormatter(), entryForIndex.getVal(), entryForIndex, i2, generateTransformedValuesScatter[i3], generateTransformedValuesScatter[i4] - convertDpToPixel, iScatterDataSet.getValueTextColor(i5));
                                i3 = i + 2;
                            }
                        }
                        i = i3;
                        i3 = i + 2;
                    }
                }
            }
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i = 0; i < highlightArr.length; i++) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) this.mChart.getScatterData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                int xIndex = highlightArr[i].getXIndex();
                float f = (float) xIndex;
                if (f <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yValForXIndex = iScatterDataSet.getYValForXIndex(xIndex);
                    if (yValForXIndex != Float.NaN) {
                        float[] fArr = {f, yValForXIndex * this.mAnimator.getPhaseY()};
                        this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                        drawHighlightLines(canvas, fArr, iScatterDataSet);
                    }
                }
            }
        }
    }
}
