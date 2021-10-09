package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BubbleChartRenderer extends DataRenderer {
    private float[] _hsvBuffer = new float[3];
    protected BubbleDataProvider mChart;
    private float[] pointBuffer = new float[2];
    private float[] sizeBuffer = new float[4];

    public void drawExtras(Canvas canvas) {
    }

    public void initBuffers() {
    }

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = bubbleDataProvider;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    public void drawData(Canvas canvas) {
        for (IBubbleDataSet iBubbleDataSet : this.mChart.getBubbleData().getDataSets()) {
            if (iBubbleDataSet.isVisible() && iBubbleDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iBubbleDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getShapeSize(float f, float f2, float f3) {
        return f3 * (f2 == 0.0f ? 1.0f : (float) Math.sqrt((double) (f / f2)));
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        int max = Math.max(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX)), 0);
        int min = Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount());
        this.sizeBuffer[0] = 0.0f;
        this.sizeBuffer[2] = 1.0f;
        transformer.pointValuesToPixel(this.sizeBuffer);
        float min2 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(this.sizeBuffer[2] - this.sizeBuffer[0]));
        for (int i = max; i < min; i++) {
            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i);
            this.pointBuffer[0] = (((float) (bubbleEntry.getXIndex() - max)) * phaseX) + ((float) max);
            this.pointBuffer[1] = bubbleEntry.getVal() * phaseY;
            transformer.pointValuesToPixel(this.pointBuffer);
            float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min2) / 2.0f;
            if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                    this.mRenderPaint.setColor(iBubbleDataSet.getColor(bubbleEntry.getXIndex()));
                    canvas.drawCircle(this.pointBuffer[0], this.pointBuffer[1], shapeSize, this.mRenderPaint);
                } else {
                    return;
                }
            }
        }
    }

    public void drawValues(Canvas canvas) {
        int i;
        float[] fArr;
        BubbleData bubbleData = this.mChart.getBubbleData();
        if (bubbleData != null && bubbleData.getYValCount() < ((int) Math.ceil((double) (((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX())))) {
            List dataSets = bubbleData.getDataSets();
            float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, "1");
            for (int i2 = 0; i2 < dataSets.size(); i2++) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) dataSets.get(i2);
                if (iBubbleDataSet.isDrawValuesEnabled() && iBubbleDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iBubbleDataSet);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    int entryIndex = iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX));
                    float[] generateTransformedValuesBubble = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency()).generateTransformedValuesBubble(iBubbleDataSet, phaseX, phaseY, entryIndex, Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount()));
                    float f = phaseX == 1.0f ? phaseY : phaseX;
                    int i3 = 0;
                    while (i3 < generateTransformedValuesBubble.length) {
                        int i4 = (i3 / 2) + entryIndex;
                        int valueTextColor = iBubbleDataSet.getValueTextColor(i4);
                        int argb = Color.argb(Math.round(255.0f * f), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor));
                        float f2 = generateTransformedValuesBubble[i3];
                        float f3 = generateTransformedValuesBubble[i3 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f2)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f2) || !this.mViewPortHandler.isInBoundsY(f3)) {
                            i = i3;
                            fArr = generateTransformedValuesBubble;
                        } else {
                            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i4);
                            i = i3;
                            float f4 = f3 + (0.5f * calcTextHeight);
                            fArr = generateTransformedValuesBubble;
                            drawValue(canvas, iBubbleDataSet.getValueFormatter(), bubbleEntry.getSize(), bubbleEntry, i2, f2, f4, argb);
                        }
                        i3 = i + 2;
                        generateTransformedValuesBubble = fArr;
                    }
                }
            }
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        Highlight[] highlightArr2 = highlightArr;
        BubbleData bubbleData = this.mChart.getBubbleData();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        int length = highlightArr2.length;
        char c = 0;
        int i = 0;
        while (i < length) {
            Highlight highlight = highlightArr2[i];
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBubbleDataSet != null && iBubbleDataSet.isHighlightEnabled()) {
                int entryIndex = iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX));
                int min = Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount());
                BubbleEntry bubbleEntry = (BubbleEntry) bubbleData.getEntryForHighlight(highlight);
                if (bubbleEntry != null && bubbleEntry.getXIndex() == highlight.getXIndex()) {
                    Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
                    this.sizeBuffer[c] = 0.0f;
                    this.sizeBuffer[2] = 1.0f;
                    transformer.pointValuesToPixel(this.sizeBuffer);
                    float min2 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(this.sizeBuffer[2] - this.sizeBuffer[c]));
                    this.pointBuffer[0] = (((float) (bubbleEntry.getXIndex() - entryIndex)) * phaseX) + ((float) entryIndex);
                    this.pointBuffer[1] = bubbleEntry.getVal() * phaseY;
                    transformer.pointValuesToPixel(this.pointBuffer);
                    float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min2) / 2.0f;
                    if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                        if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                            if (highlight.getXIndex() >= entryIndex && highlight.getXIndex() < min) {
                                int color = iBubbleDataSet.getColor(bubbleEntry.getXIndex());
                                Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), this._hsvBuffer);
                                float[] fArr = this._hsvBuffer;
                                fArr[2] = fArr[2] * 0.5f;
                                this.mHighlightPaint.setColor(Color.HSVToColor(Color.alpha(color), this._hsvBuffer));
                                this.mHighlightPaint.setStrokeWidth(iBubbleDataSet.getHighlightCircleWidth());
                                canvas.drawCircle(this.pointBuffer[0], this.pointBuffer[1], shapeSize, this.mHighlightPaint);
                                i++;
                                highlightArr2 = highlightArr;
                                c = 0;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            Canvas canvas2 = canvas;
            i++;
            highlightArr2 = highlightArr;
            c = 0;
        }
    }
}
