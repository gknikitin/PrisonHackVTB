package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;

public class HorizontalBarChart extends BarChart {
    public HorizontalBarChart(Context context) {
        super(context);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateOffsets() {
        /*
            r9 = this;
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            r1 = 0
            if (r0 == 0) goto L_0x00fc
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x00fc
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x00d8
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x0025
            goto L_0x00d8
        L_0x0025:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r0 == r2) goto L_0x00b5
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x003b
            goto L_0x00b5
        L_0x003b:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r0 == r2) goto L_0x0098
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r0 == r2) goto L_0x0098
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r0 != r2) goto L_0x005a
            goto L_0x0098
        L_0x005a:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r0 == r2) goto L_0x0078
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r0 == r2) goto L_0x0078
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r0 != r2) goto L_0x00fc
        L_0x0078:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mTextHeightMax
            float r0 = r0 * r3
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.mNeededHeight
            float r2 = r2 + r0
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r9.mViewPortHandler
            float r0 = r0.getChartHeight()
            com.github.mikephil.charting.components.Legend r3 = r9.mLegend
            float r3 = r3.getMaxSizePercent()
            float r0 = r0 * r3
            float r0 = java.lang.Math.min(r2, r0)
            float r0 = r0 + r1
            r1 = r0
            goto L_0x00fc
        L_0x0098:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mTextHeightMax
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.mNeededHeight
            float r2 = r2 + r0
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r9.mViewPortHandler
            float r0 = r0.getChartHeight()
            com.github.mikephil.charting.components.Legend r3 = r9.mLegend
            float r3 = r3.getMaxSizePercent()
            float r0 = r0 * r3
            float r0 = java.lang.Math.min(r2, r0)
            float r0 = r0 + r1
            goto L_0x00fd
        L_0x00b5:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mNeededWidth
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartWidth()
            com.github.mikephil.charting.components.Legend r4 = r9.mLegend
            float r4 = r4.getMaxSizePercent()
            float r2 = r2 * r4
            float r0 = java.lang.Math.min(r0, r2)
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.getXOffset()
            float r2 = r2 * r3
            float r0 = r0 + r2
            float r0 = r0 + r1
            r2 = r0
            r0 = 0
            goto L_0x00fe
        L_0x00d8:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mNeededWidth
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartWidth()
            com.github.mikephil.charting.components.Legend r4 = r9.mLegend
            float r4 = r4.getMaxSizePercent()
            float r2 = r2 * r4
            float r0 = java.lang.Math.min(r0, r2)
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.getXOffset()
            float r2 = r2 * r3
            float r0 = r0 + r2
            float r0 = r0 + r1
            r3 = r0
            r0 = 0
            r2 = 0
            goto L_0x00ff
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            r2 = 0
        L_0x00fe:
            r3 = 0
        L_0x00ff:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0114
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererLeft
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredHeightSpace(r5)
            float r1 = r1 + r4
        L_0x0114:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0129
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererRight
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredHeightSpace(r5)
            float r0 = r0 + r4
        L_0x0129:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            int r4 = r4.mLabelRotatedWidth
            float r4 = (float) r4
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            boolean r5 = r5.isEnabled()
            if (r5 == 0) goto L_0x015a
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
            if (r5 != r6) goto L_0x0142
            float r2 = r2 + r4
            goto L_0x015a
        L_0x0142:
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.TOP
            if (r5 != r6) goto L_0x014e
            float r3 = r3 + r4
            goto L_0x015a
        L_0x014e:
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTH_SIDED
            if (r5 != r6) goto L_0x015a
            float r2 = r2 + r4
            float r3 = r3 + r4
        L_0x015a:
            float r4 = r9.getExtraTopOffset()
            float r1 = r1 + r4
            float r4 = r9.getExtraRightOffset()
            float r3 = r3 + r4
            float r4 = r9.getExtraBottomOffset()
            float r0 = r0 + r4
            float r4 = r9.getExtraLeftOffset()
            float r2 = r2 + r4
            float r4 = r9.mMinOffset
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            com.github.mikephil.charting.utils.ViewPortHandler r5 = r9.mViewPortHandler
            float r6 = java.lang.Math.max(r4, r2)
            float r7 = java.lang.Math.max(r4, r1)
            float r8 = java.lang.Math.max(r4, r3)
            float r4 = java.lang.Math.max(r4, r0)
            r5.restrainViewPort(r6, r7, r8, r4)
            boolean r4 = r9.mLogEnabled
            if (r4 == 0) goto L_0x01db
            java.lang.String r4 = "MPAndroidChart"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "offsetLeft: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = ", offsetTop: "
            r5.append(r2)
            r5.append(r1)
            java.lang.String r1 = ", offsetRight: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = ", offsetBottom: "
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.util.Log.i(r4, r0)
            java.lang.String r0 = "MPAndroidChart"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Content: "
            r1.append(r2)
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            android.graphics.RectF r2 = r2.getContentRect()
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
        L_0x01db:
            r9.prepareOffsetMatrix()
            r9.prepareValuePxMatrix()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.HorizontalBarChart.calculateOffsets():void");
    }

    /* access modifiers changed from: protected */
    public void prepareValuePxMatrix() {
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisRange, this.mXAxis.mAxisRange, this.mXAxis.mAxisMinimum);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisRange, this.mXAxis.mAxisRange, this.mXAxis.mAxisMinimum);
    }

    /* access modifiers changed from: protected */
    public void calcModulus() {
        float[] fArr = new float[9];
        this.mViewPortHandler.getMatrixTouch().getValues(fArr);
        this.mXAxis.mAxisLabelModulus = (int) Math.ceil((double) (((float) (((BarData) this.mData).getXValCount() * this.mXAxis.mLabelRotatedHeight)) / (this.mViewPortHandler.contentHeight() * fArr[4])));
        if (this.mXAxis.mAxisLabelModulus < 1) {
            this.mXAxis.mAxisLabelModulus = 1;
        }
    }

    public RectF getBarBounds(BarEntry barEntry) {
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarData) this.mData).getDataSetForEntry(barEntry);
        if (iBarDataSet == null) {
            return null;
        }
        float barSpace = iBarDataSet.getBarSpace();
        float val = barEntry.getVal();
        float xIndex = (float) barEntry.getXIndex();
        float f = barSpace / 2.0f;
        float f2 = (xIndex - 0.5f) + f;
        float f3 = (xIndex + 0.5f) - f;
        float f4 = 0.0f;
        float f5 = val >= 0.0f ? val : 0.0f;
        if (val <= 0.0f) {
            f4 = val;
        }
        RectF rectF = new RectF(f5, f2, f4, f3);
        getTransformer(iBarDataSet.getAxisDependency()).rectValueToPixel(rectF);
        return rectF;
    }

    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {entry.getVal(), (float) entry.getXIndex()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData != null) {
            return getHighlighter().getHighlight(f2, f);
        }
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public int getLowestVisibleXIndex() {
        float f;
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        if (dataSetCount <= 1.0f) {
            f = 1.0f;
        } else {
            f = dataSetCount + ((BarData) this.mData).getGroupSpace();
        }
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f2 = 0.0f;
        if (fArr[1] > 0.0f) {
            f2 = fArr[1] / f;
        }
        return (int) (f2 + 1.0f);
    }

    public int getHighestVisibleXIndex() {
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        float f = 1.0f;
        if (dataSetCount > 1.0f) {
            f = ((BarData) this.mData).getGroupSpace() + dataSetCount;
        }
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return (int) ((fArr[1] >= getXChartMax() ? getXChartMax() : fArr[1]) / f);
    }
}
