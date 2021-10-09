package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] mBodyBuffers = new float[4];
    protected CandleDataProvider mChart;
    private float[] mCloseBuffers = new float[4];
    private float[] mOpenBuffers = new float[4];
    private float[] mRangeBuffers = new float[4];
    private float[] mShadowBuffers = new float[8];

    public void drawExtras(Canvas canvas) {
    }

    public void initBuffers() {
    }

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = candleDataProvider;
    }

    public void drawData(Canvas canvas) {
        for (ICandleDataSet iCandleDataSet : this.mChart.getCandleData().getDataSets()) {
            if (iCandleDataSet.isVisible() && iCandleDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iCandleDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ICandleDataSet iCandleDataSet) {
        int i;
        ICandleDataSet iCandleDataSet2 = iCandleDataSet;
        Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float barSpace = iCandleDataSet.getBarSpace();
        boolean showCandleBar = iCandleDataSet.getShowCandleBar();
        char c = 0;
        int max = Math.max(this.mMinX, 0);
        int min = Math.min(this.mMaxX + 1, iCandleDataSet.getEntryCount());
        this.mRenderPaint.setStrokeWidth(iCandleDataSet.getShadowWidth());
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
        int i2 = max;
        while (i2 < ceil) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet2.getEntryForIndex(i2);
            int xIndex = candleEntry.getXIndex();
            if (xIndex >= max && xIndex < min) {
                float open = candleEntry.getOpen();
                float close = candleEntry.getClose();
                float high = candleEntry.getHigh();
                float low = candleEntry.getLow();
                if (showCandleBar) {
                    float f = (float) xIndex;
                    this.mShadowBuffers[c] = f;
                    this.mShadowBuffers[2] = f;
                    this.mShadowBuffers[4] = f;
                    this.mShadowBuffers[6] = f;
                    if (open > close) {
                        this.mShadowBuffers[1] = high * phaseY;
                        this.mShadowBuffers[3] = open * phaseY;
                        this.mShadowBuffers[5] = low * phaseY;
                        this.mShadowBuffers[7] = close * phaseY;
                    } else if (open < close) {
                        this.mShadowBuffers[1] = high * phaseY;
                        this.mShadowBuffers[3] = close * phaseY;
                        this.mShadowBuffers[5] = low * phaseY;
                        this.mShadowBuffers[7] = open * phaseY;
                    } else {
                        this.mShadowBuffers[1] = high * phaseY;
                        this.mShadowBuffers[3] = open * phaseY;
                        this.mShadowBuffers[5] = low * phaseY;
                        this.mShadowBuffers[7] = this.mShadowBuffers[3];
                    }
                    transformer.pointValuesToPixel(this.mShadowBuffers);
                    if (!iCandleDataSet.getShadowColorSameAsCandle()) {
                        this.mRenderPaint.setColor(iCandleDataSet.getShadowColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getShadowColor());
                    } else if (open > close) {
                        this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getDecreasingColor());
                    } else if (open < close) {
                        this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getIncreasingColor());
                    } else {
                        this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getNeutralColor());
                    }
                    this.mRenderPaint.setStyle(Paint.Style.STROKE);
                    Canvas canvas2 = canvas;
                    canvas2.drawLines(this.mShadowBuffers, this.mRenderPaint);
                    this.mBodyBuffers[0] = (f - 0.5f) + barSpace;
                    this.mBodyBuffers[1] = close * phaseY;
                    this.mBodyBuffers[2] = (f + 0.5f) - barSpace;
                    this.mBodyBuffers[3] = open * phaseY;
                    transformer.pointValuesToPixel(this.mBodyBuffers);
                    if (open > close) {
                        if (iCandleDataSet.getDecreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i2));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getDecreasingPaintStyle());
                        canvas2.drawRect(this.mBodyBuffers[0], this.mBodyBuffers[3], this.mBodyBuffers[2], this.mBodyBuffers[1], this.mRenderPaint);
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i2));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getIncreasingPaintStyle());
                        canvas2.drawRect(this.mBodyBuffers[0], this.mBodyBuffers[1], this.mBodyBuffers[2], this.mBodyBuffers[3], this.mRenderPaint);
                    } else {
                        if (iCandleDataSet.getNeutralColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i2));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor());
                        }
                        canvas2.drawLine(this.mBodyBuffers[0], this.mBodyBuffers[1], this.mBodyBuffers[2], this.mBodyBuffers[3], this.mRenderPaint);
                    }
                } else {
                    float f2 = (float) xIndex;
                    this.mRangeBuffers[0] = f2;
                    this.mRangeBuffers[1] = high * phaseY;
                    this.mRangeBuffers[2] = f2;
                    this.mRangeBuffers[3] = low * phaseY;
                    this.mOpenBuffers[0] = (f2 - 0.5f) + barSpace;
                    float f3 = open * phaseY;
                    this.mOpenBuffers[1] = f3;
                    this.mOpenBuffers[2] = f2;
                    this.mOpenBuffers[3] = f3;
                    this.mCloseBuffers[0] = (f2 + 0.5f) - barSpace;
                    float f4 = close * phaseY;
                    this.mCloseBuffers[1] = f4;
                    this.mCloseBuffers[2] = f2;
                    this.mCloseBuffers[3] = f4;
                    transformer.pointValuesToPixel(this.mRangeBuffers);
                    transformer.pointValuesToPixel(this.mOpenBuffers);
                    transformer.pointValuesToPixel(this.mCloseBuffers);
                    if (open > close) {
                        i = iCandleDataSet.getDecreasingColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getDecreasingColor();
                    } else if (open < close) {
                        i = iCandleDataSet.getIncreasingColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getIncreasingColor();
                    } else {
                        i = iCandleDataSet.getNeutralColor() == 1122867 ? iCandleDataSet2.getColor(i2) : iCandleDataSet.getNeutralColor();
                    }
                    this.mRenderPaint.setColor(i);
                    Canvas canvas3 = canvas;
                    canvas3.drawLine(this.mRangeBuffers[0], this.mRangeBuffers[1], this.mRangeBuffers[2], this.mRangeBuffers[3], this.mRenderPaint);
                    canvas3.drawLine(this.mOpenBuffers[0], this.mOpenBuffers[1], this.mOpenBuffers[2], this.mOpenBuffers[3], this.mRenderPaint);
                    canvas3.drawLine(this.mCloseBuffers[0], this.mCloseBuffers[1], this.mCloseBuffers[2], this.mCloseBuffers[3], this.mRenderPaint);
                    i2++;
                    c = 0;
                }
            }
            i2++;
            c = 0;
        }
    }

    public void drawValues(Canvas canvas) {
        int i;
        if (((float) this.mChart.getCandleData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getCandleData().getDataSets();
            for (int i2 = 0; i2 < dataSets.size(); i2++) {
                ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSets.get(i2);
                if (iCandleDataSet.isDrawValuesEnabled() && iCandleDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iCandleDataSet);
                    Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
                    int max = Math.max(this.mMinX, 0);
                    ICandleDataSet iCandleDataSet2 = iCandleDataSet;
                    float[] generateTransformedValuesCandle = transformer.generateTransformedValuesCandle(iCandleDataSet2, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), max, Math.min(this.mMaxX + 1, iCandleDataSet.getEntryCount()));
                    float convertDpToPixel = Utils.convertDpToPixel(5.0f);
                    int i3 = 0;
                    while (i3 < generateTransformedValuesCandle.length) {
                        float f = generateTransformedValuesCandle[i3];
                        float f2 = generateTransformedValuesCandle[i3 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f) || !this.mViewPortHandler.isInBoundsY(f2)) {
                            i = i3;
                        } else {
                            int i4 = i3 / 2;
                            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex(i4 + max);
                            i = i3;
                            drawValue(canvas, iCandleDataSet.getValueFormatter(), candleEntry.getHigh(), candleEntry, i2, f, f2 - convertDpToPixel, iCandleDataSet.getValueTextColor(i4));
                        }
                        i3 = i + 2;
                    }
                }
            }
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        CandleEntry candleEntry;
        for (int i = 0; i < highlightArr.length; i++) {
            int xIndex = highlightArr[i].getXIndex();
            ICandleDataSet iCandleDataSet = (ICandleDataSet) this.mChart.getCandleData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (iCandleDataSet != null && iCandleDataSet.isHighlightEnabled() && (candleEntry = (CandleEntry) iCandleDataSet.getEntryForXIndex(xIndex)) != null && candleEntry.getXIndex() == xIndex) {
                this.mChart.getYChartMin();
                this.mChart.getYChartMax();
                float[] fArr = {(float) xIndex, ((candleEntry.getLow() * this.mAnimator.getPhaseY()) + (candleEntry.getHigh() * this.mAnimator.getPhaseY())) / 2.0f};
                this.mChart.getTransformer(iCandleDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                drawHighlightLines(canvas, fArr, iCandleDataSet);
            }
        }
    }
}
