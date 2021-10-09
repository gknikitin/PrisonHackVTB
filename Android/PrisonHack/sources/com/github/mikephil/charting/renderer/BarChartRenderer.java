package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends DataRenderer {
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect = new RectF();
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public void drawExtras(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = barDataProvider;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        this.mShadowPaint = new Paint(1);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
    }

    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getGroupSpace(), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible() && iBarDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setBarSpace(iBarDataSet.getBarSpace());
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        int i2 = 0;
        if (this.mChart.isDrawBarShadowEnabled()) {
            for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
                int i4 = i3 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                    if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                        break;
                    }
                    canvas.drawRect(barBuffer.buffer[i3], this.mViewPortHandler.contentTop(), barBuffer.buffer[i4], this.mViewPortHandler.contentBottom(), this.mShadowPaint);
                }
            }
        }
        if (iBarDataSet.getColors().size() > 1) {
            while (i2 < barBuffer.size()) {
                int i5 = i2 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i5])) {
                    if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i2])) {
                        this.mRenderPaint.setColor(iBarDataSet.getColor(i2 / 4));
                        canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], barBuffer.buffer[i5], barBuffer.buffer[i2 + 3], this.mRenderPaint);
                    } else {
                        return;
                    }
                }
                i2 += 4;
            }
            return;
        }
        this.mRenderPaint.setColor(iBarDataSet.getColor());
        while (i2 < barBuffer.size()) {
            int i6 = i2 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i6])) {
                if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i2])) {
                    canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], barBuffer.buffer[i6], barBuffer.buffer[i2 + 3], this.mRenderPaint);
                } else {
                    return;
                }
            }
            i2 += 4;
        }
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set((f - 0.5f) + f4, f2, (f + 0.5f) - f4, f3);
        transformer.rectValueToPixel(this.mBarRect, this.mAnimator.getPhaseY());
    }

    public void drawValues(Canvas canvas) {
        List list;
        int i;
        Transformer transformer;
        BarEntry barEntry;
        float[] fArr;
        float[] fArr2;
        int i2;
        float f;
        float f2;
        float f3;
        int i3;
        float[] fArr3;
        if (passesCheck()) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i4 = 0;
            while (i4 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i4);
                if (iBarDataSet.isDrawValuesEnabled() && iBarDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, "8");
                    float f4 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f5 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f4 = (-f4) - calcTextHeight;
                        f5 = (-f5) - calcTextHeight;
                    }
                    float f6 = f4;
                    float f7 = f5;
                    Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    float[] transformedValues = getTransformedValues(transformer2, iBarDataSet, i4);
                    if (!iBarDataSet.isStacked()) {
                        int i5 = 0;
                        while (((float) i5) < ((float) transformedValues.length) * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(transformedValues[i5])) {
                            int i6 = i5 + 1;
                            if (!this.mViewPortHandler.isInBoundsY(transformedValues[i6]) || !this.mViewPortHandler.isInBoundsLeft(transformedValues[i5])) {
                                fArr3 = transformedValues;
                                i3 = i5;
                            } else {
                                int i7 = i5 / 2;
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7);
                                float val = barEntry2.getVal();
                                fArr3 = transformedValues;
                                i3 = i5;
                                drawValue(canvas, iBarDataSet.getValueFormatter(), val, barEntry2, i4, transformedValues[i5], transformedValues[i6] + (val >= 0.0f ? f6 : f7), iBarDataSet.getValueTextColor(i7));
                            }
                            i5 = i3 + 2;
                            transformedValues = fArr3;
                        }
                    } else {
                        float[] fArr4 = transformedValues;
                        int i8 = 0;
                        while (((float) i8) < ((float) (fArr4.length - 1)) * this.mAnimator.getPhaseX()) {
                            int i9 = i8 / 2;
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i9);
                            float[] vals = barEntry3.getVals();
                            if (vals != null) {
                                i = i8;
                                list = dataSets;
                                transformer = transformer2;
                                int valueTextColor = iBarDataSet.getValueTextColor(i9);
                                float[] fArr5 = new float[(vals.length * 2)];
                                float f8 = -barEntry3.getNegativeSum();
                                int i10 = 0;
                                int i11 = 0;
                                float f9 = 0.0f;
                                while (i10 < fArr5.length) {
                                    float f10 = vals[i11];
                                    if (f10 >= 0.0f) {
                                        f3 = f9 + f10;
                                        f = f8;
                                        f2 = f3;
                                    } else {
                                        f = f8 - f10;
                                        float f11 = f8;
                                        f2 = f9;
                                        f3 = f11;
                                    }
                                    float f12 = f2;
                                    fArr5[i10 + 1] = f3 * this.mAnimator.getPhaseY();
                                    i10 += 2;
                                    i11++;
                                    f8 = f;
                                    f9 = f12;
                                }
                                transformer.pointValuesToPixel(fArr5);
                                int i12 = 0;
                                while (i12 < fArr5.length) {
                                    float f13 = fArr4[i];
                                    int i13 = i12 / 2;
                                    float f14 = fArr5[i12 + 1] + (vals[i13] >= 0.0f ? f6 : f7);
                                    if (!this.mViewPortHandler.isInBoundsRight(f13)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsY(f14) || !this.mViewPortHandler.isInBoundsLeft(f13)) {
                                        fArr = vals;
                                        barEntry = barEntry3;
                                        i2 = i12;
                                        fArr2 = fArr5;
                                    } else {
                                        fArr = vals;
                                        barEntry = barEntry3;
                                        i2 = i12;
                                        fArr2 = fArr5;
                                        drawValue(canvas, iBarDataSet.getValueFormatter(), vals[i13], barEntry3, i4, f13, f14, valueTextColor);
                                    }
                                    i12 = i2 + 2;
                                    fArr5 = fArr2;
                                    vals = fArr;
                                    barEntry3 = barEntry;
                                }
                            } else if (!this.mViewPortHandler.isInBoundsRight(fArr4[i8])) {
                                break;
                            } else {
                                int i14 = i8 + 1;
                                if (!this.mViewPortHandler.isInBoundsY(fArr4[i14]) || !this.mViewPortHandler.isInBoundsLeft(fArr4[i8])) {
                                    i = i8;
                                    list = dataSets;
                                    transformer = transformer2;
                                } else {
                                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                                    float val2 = barEntry3.getVal();
                                    float f15 = fArr4[i8];
                                    float f16 = fArr4[i14];
                                    float f17 = barEntry3.getVal() >= 0.0f ? f6 : f7;
                                    float f18 = f15;
                                    i = i8;
                                    list = dataSets;
                                    transformer = transformer2;
                                    drawValue(canvas, valueFormatter, val2, barEntry3, i4, f18, f16 + f17, iBarDataSet.getValueTextColor(i9));
                                }
                            }
                            i8 = i + 2;
                            transformer2 = transformer;
                            dataSets = list;
                        }
                    }
                }
                i4++;
                dataSets = dataSets;
            }
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        BarEntry barEntry;
        float f;
        float f2;
        Canvas canvas2 = canvas;
        Highlight[] highlightArr2 = highlightArr;
        int dataSetCount = this.mChart.getBarData().getDataSetCount();
        for (Highlight highlight : highlightArr2) {
            int xIndex = highlight.getXIndex();
            int dataSetIndex = highlight.getDataSetIndex();
            IBarDataSet iBarDataSet = (IBarDataSet) this.mChart.getBarData().getDataSetByIndex(dataSetIndex);
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                float barSpace = iBarDataSet.getBarSpace() / 2.0f;
                Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                if (xIndex >= 0) {
                    float f3 = (float) xIndex;
                    if (f3 < (this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) / ((float) dataSetCount) && (barEntry = (BarEntry) iBarDataSet.getEntryForXIndex(xIndex)) != null && barEntry.getXIndex() == xIndex) {
                        float groupSpace = this.mChart.getBarData().getGroupSpace();
                        float f4 = (groupSpace * f3) + ((float) ((xIndex * dataSetCount) + dataSetIndex)) + (groupSpace / 2.0f);
                        if (highlight.getStackIndex() >= 0) {
                            float f5 = highlight.getRange().from;
                            f2 = highlight.getRange().f59to;
                            f = f5;
                        } else {
                            f = barEntry.getVal();
                            f2 = 0.0f;
                        }
                        float f6 = f2;
                        prepareBarHighlight(f4, f, f2, barSpace, transformer);
                        canvas2.drawRect(this.mBarRect, this.mHighlightPaint);
                        if (this.mChart.isDrawHighlightArrowEnabled()) {
                            this.mHighlightPaint.setAlpha(255);
                            float[] fArr = new float[9];
                            transformer.getPixelToValueMatrix().getValues(fArr);
                            float abs = Math.abs(fArr[4] / fArr[0]);
                            float barSpace2 = iBarDataSet.getBarSpace() / 2.0f;
                            float f7 = abs * barSpace2;
                            int i = (f > (-f6) ? 1 : (f == (-f6) ? 0 : -1));
                            float phaseY = f * this.mAnimator.getPhaseY();
                            Path path = new Path();
                            float f8 = f4 + 0.4f;
                            float phaseY2 = phaseY + (this.mAnimator.getPhaseY() * 0.07f);
                            path.moveTo(f8, phaseY2);
                            float f9 = f8 + barSpace2;
                            path.lineTo(f9, phaseY2 - f7);
                            path.lineTo(f9, phaseY2 + f7);
                            transformer.pathValueToPixel(path);
                            canvas2.drawPath(path, this.mHighlightPaint);
                        }
                    }
                }
            }
        }
    }

    public float[] getTransformedValues(Transformer transformer, IBarDataSet iBarDataSet, int i) {
        return transformer.generateTransformedValuesBarChart(iBarDataSet, i, this.mChart.getBarData(), this.mAnimator.getPhaseY());
    }

    /* access modifiers changed from: protected */
    public boolean passesCheck() {
        return ((float) this.mChart.getBarData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX();
    }
}
