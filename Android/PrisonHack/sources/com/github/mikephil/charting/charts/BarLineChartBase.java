package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    private long drawCycles = 0;
    private Integer mAutoScaleLastHighestVisibleXIndex = null;
    private Integer mAutoScaleLastLowestVisibleXIndex = null;
    private boolean mAutoScaleMinMaxEnabled = false;
    protected YAxis mAxisLeft;
    protected YAxisRenderer mAxisRendererLeft;
    protected YAxisRenderer mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    private boolean mCustomViewPortEnabled = false;
    protected boolean mDoubleTapToZoomEnabled = true;
    private boolean mDragEnabled = true;
    protected boolean mDrawBorders = false;
    protected boolean mDrawGridBackground = false;
    protected OnDrawListener mDrawListener;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled = true;
    protected boolean mKeepPositionOnRotation = false;
    protected Transformer mLeftAxisTransformer;
    protected int mMaxVisibleCount = 100;
    protected float mMinOffset = 15.0f;
    protected boolean mPinchZoomEnabled = false;
    protected Transformer mRightAxisTransformer;
    private boolean mScaleXEnabled = true;
    private boolean mScaleYEnabled = true;
    protected XAxisRenderer mXAxisRenderer;
    private long totalTime = 0;

    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarLineChartBase(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        setHighlighter(new ChartHighlighter(this));
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.getMatrixTouch());
        this.mGridBackgroundPaint = new Paint();
        this.mGridBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            long currentTimeMillis = System.currentTimeMillis();
            calcModulus();
            this.mXAxisRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
            this.mRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
            drawGridBackground(canvas);
            if (this.mAxisLeft.isEnabled()) {
                this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum);
            }
            if (this.mAxisRight.isEnabled()) {
                this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum);
            }
            this.mXAxisRenderer.renderAxisLine(canvas);
            this.mAxisRendererLeft.renderAxisLine(canvas);
            this.mAxisRendererRight.renderAxisLine(canvas);
            if (this.mAutoScaleMinMaxEnabled) {
                int lowestVisibleXIndex = getLowestVisibleXIndex();
                int highestVisibleXIndex = getHighestVisibleXIndex();
                if (this.mAutoScaleLastLowestVisibleXIndex == null || this.mAutoScaleLastLowestVisibleXIndex.intValue() != lowestVisibleXIndex || this.mAutoScaleLastHighestVisibleXIndex == null || this.mAutoScaleLastHighestVisibleXIndex.intValue() != highestVisibleXIndex) {
                    calcMinMax();
                    calculateOffsets();
                    this.mAutoScaleLastLowestVisibleXIndex = Integer.valueOf(lowestVisibleXIndex);
                    this.mAutoScaleLastHighestVisibleXIndex = Integer.valueOf(highestVisibleXIndex);
                }
            }
            int save = canvas.save();
            canvas.clipRect(this.mViewPortHandler.getContentRect());
            this.mXAxisRenderer.renderGridLines(canvas);
            this.mAxisRendererLeft.renderGridLines(canvas);
            this.mAxisRendererRight.renderGridLines(canvas);
            if (this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
                this.mXAxisRenderer.renderLimitLines(canvas);
            }
            if (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererLeft.renderLimitLines(canvas);
            }
            if (this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererRight.renderLimitLines(canvas);
            }
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            canvas.restoreToCount(save);
            this.mRenderer.drawExtras(canvas);
            if (!this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
                this.mXAxisRenderer.renderLimitLines(canvas);
            }
            if (!this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererLeft.renderLimitLines(canvas);
            }
            if (!this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererRight.renderLimitLines(canvas);
            }
            this.mXAxisRenderer.renderAxisLabels(canvas);
            this.mAxisRendererLeft.renderAxisLabels(canvas);
            this.mAxisRendererRight.renderAxisLabels(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawMarkers(canvas);
            drawDescription(canvas);
            if (this.mLogEnabled) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.totalTime += currentTimeMillis2;
                this.drawCycles++;
                Log.i(Chart.LOG_TAG, "Drawtime: " + currentTimeMillis2 + " ms, average: " + (this.totalTime / this.drawCycles) + " ms, cycles: " + this.drawCycles);
            }
        }
    }

    public void resetTracking() {
        this.totalTime = 0;
        this.drawCycles = 0;
    }

    /* access modifiers changed from: protected */
    public void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing Value-Px Matrix, xmin: " + this.mXAxis.mAxisMinimum + ", xmax: " + this.mXAxis.mAxisMaximum + ", xdelta: " + this.mXAxis.mAxisRange);
        }
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisRange, this.mAxisRight.mAxisRange, this.mAxisRight.mAxisMinimum);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisRange, this.mAxisLeft.mAxisRange, this.mAxisLeft.mAxisMinimum);
    }

    /* access modifiers changed from: protected */
    public void prepareOffsetMatrix() {
        this.mRightAxisTransformer.prepareMatrixOffset(this.mAxisRight.isInverted());
        this.mLeftAxisTransformer.prepareMatrixOffset(this.mAxisLeft.isInverted());
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "Preparing...");
            }
            if (this.mRenderer != null) {
                this.mRenderer.initBuffers();
            }
            calcMinMax();
            this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum);
            this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum);
            this.mXAxisRenderer.computeAxis(((BarLineScatterCandleBubbleData) this.mData).getXValMaximumLength(), ((BarLineScatterCandleBubbleData) this.mData).getXVals());
            if (this.mLegend != null) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        } else if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        if (this.mAutoScaleMinMaxEnabled) {
            ((BarLineScatterCandleBubbleData) this.mData).calcMinMax(getLowestVisibleXIndex(), getHighestVisibleXIndex());
        }
        this.mXAxis.mAxisMaximum = (float) (((BarLineScatterCandleBubbleData) this.mData).getXVals().size() - 1);
        this.mXAxis.mAxisRange = Math.abs(this.mXAxis.mAxisMaximum - this.mXAxis.mAxisMinimum);
        this.mAxisLeft.calcMinMax(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
        this.mAxisRight.calcMinMax(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.RIGHT));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateOffsets() {
        /*
            r9 = this;
            boolean r0 = r9.mCustomViewPortEnabled
            if (r0 != 0) goto L_0x01ec
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            r1 = 0
            if (r0 == 0) goto L_0x00fe
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x00fe
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x00dd
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x0029
            goto L_0x00dd
        L_0x0029:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r0 == r2) goto L_0x00bb
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x003f
            goto L_0x00bb
        L_0x003f:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r0 == r2) goto L_0x009c
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r0 == r2) goto L_0x009c
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r0 != r2) goto L_0x005e
            goto L_0x009c
        L_0x005e:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r0 == r2) goto L_0x007c
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r0 == r2) goto L_0x007c
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r0 != r2) goto L_0x00fe
        L_0x007c:
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
            r3 = r0
            r0 = 0
            r2 = 0
            goto L_0x0101
        L_0x009c:
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
            r2 = r0
            r0 = 0
            goto L_0x0100
        L_0x00bb:
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
            r1 = r0
            goto L_0x00fe
        L_0x00dd:
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
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            r2 = 0
        L_0x0100:
            r3 = 0
        L_0x0101:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0116
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererLeft
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredWidthSpace(r5)
            float r1 = r1 + r4
        L_0x0116:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x012b
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererRight
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredWidthSpace(r5)
            float r0 = r0 + r4
        L_0x012b:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x016b
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            boolean r4 = r4.isDrawLabelsEnabled()
            if (r4 == 0) goto L_0x016b
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            int r4 = r4.mLabelRotatedHeight
            float r4 = (float) r4
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            float r5 = r5.getYOffset()
            float r4 = r4 + r5
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
            if (r5 != r6) goto L_0x0153
            float r2 = r2 + r4
            goto L_0x016b
        L_0x0153:
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.TOP
            if (r5 != r6) goto L_0x015f
            float r3 = r3 + r4
            goto L_0x016b
        L_0x015f:
            com.github.mikephil.charting.components.XAxis r5 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r5 = r5.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTH_SIDED
            if (r5 != r6) goto L_0x016b
            float r2 = r2 + r4
            float r3 = r3 + r4
        L_0x016b:
            float r4 = r9.getExtraTopOffset()
            float r3 = r3 + r4
            float r4 = r9.getExtraRightOffset()
            float r0 = r0 + r4
            float r4 = r9.getExtraBottomOffset()
            float r2 = r2 + r4
            float r4 = r9.getExtraLeftOffset()
            float r1 = r1 + r4
            float r4 = r9.mMinOffset
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            com.github.mikephil.charting.utils.ViewPortHandler r5 = r9.mViewPortHandler
            float r6 = java.lang.Math.max(r4, r1)
            float r7 = java.lang.Math.max(r4, r3)
            float r8 = java.lang.Math.max(r4, r0)
            float r4 = java.lang.Math.max(r4, r2)
            r5.restrainViewPort(r6, r7, r8, r4)
            boolean r4 = r9.mLogEnabled
            if (r4 == 0) goto L_0x01ec
            java.lang.String r4 = "MPAndroidChart"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "offsetLeft: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = ", offsetTop: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = ", offsetRight: "
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r5.append(r0)
            r5.append(r2)
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
        L_0x01ec:
            r9.prepareOffsetMatrix()
            r9.prepareValuePxMatrix()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.calculateOffsets():void");
    }

    /* access modifiers changed from: protected */
    public void calcModulus() {
        if (this.mXAxis != null && this.mXAxis.isEnabled()) {
            if (!this.mXAxis.isAxisModulusCustom()) {
                float[] fArr = new float[9];
                this.mViewPortHandler.getMatrixTouch().getValues(fArr);
                this.mXAxis.mAxisLabelModulus = (int) Math.ceil((double) (((float) (((BarLineScatterCandleBubbleData) this.mData).getXValCount() * this.mXAxis.mLabelRotatedWidth)) / (this.mViewPortHandler.contentWidth() * fArr[0])));
            }
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "X-Axis modulus: " + this.mXAxis.mAxisLabelModulus + ", x-axis label width: " + this.mXAxis.mLabelWidth + ", x-axis label rotated width: " + this.mXAxis.mLabelRotatedWidth + ", content width: " + this.mViewPortHandler.contentWidth());
            }
            if (this.mXAxis.mAxisLabelModulus < 1) {
                this.mXAxis.mAxisLabelModulus = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public float[] getMarkerPosition(Entry entry, Highlight highlight) {
        float f;
        float f2;
        float f3;
        int dataSetIndex = highlight.getDataSetIndex();
        float xIndex = (float) entry.getXIndex();
        float val = entry.getVal();
        if (this instanceof BarChart) {
            float groupSpace = ((BarData) this.mData).getGroupSpace();
            int dataSetCount = ((BarLineScatterCandleBubbleData) this.mData).getDataSetCount();
            int xIndex2 = entry.getXIndex();
            if (this instanceof HorizontalBarChart) {
                float f4 = ((float) (((dataSetCount - 1) * xIndex2) + xIndex2 + dataSetIndex)) + (((float) xIndex2) * groupSpace) + (groupSpace / 2.0f);
                if (((BarEntry) entry).getVals() != null) {
                    f3 = highlight.getRange().f59to;
                } else {
                    f3 = entry.getVal();
                }
                xIndex = f3 * this.mAnimator.getPhaseY();
                f = f4;
            } else {
                float f5 = ((float) (((dataSetCount - 1) * xIndex2) + xIndex2 + dataSetIndex)) + (((float) xIndex2) * groupSpace) + (groupSpace / 2.0f);
                if (((BarEntry) entry).getVals() != null) {
                    f2 = highlight.getRange().f59to;
                } else {
                    f2 = entry.getVal();
                }
                f = f2 * this.mAnimator.getPhaseY();
                xIndex = f5;
            }
        } else {
            f = this.mAnimator.getPhaseY() * val;
        }
        float[] fArr = {xIndex, f};
        getTransformer(((IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).getDataSetByIndex(dataSetIndex)).getAxisDependency()).pointValuesToPixel(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public void drawGridBackground(Canvas canvas) {
        if (this.mDrawGridBackground) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
        }
    }

    public Transformer getTransformer(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisTransformer;
        }
        return this.mRightAxisTransformer;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.mChartTouchListener == null || this.mData == null || !this.mTouchEnabled) {
            return false;
        }
        return this.mChartTouchListener.onTouch(this, motionEvent);
    }

    public void computeScroll() {
        if (this.mChartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) this.mChartTouchListener).computeScroll();
        }
    }

    public void zoomIn() {
        PointF contentCenter = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomIn(contentCenter.x, -contentCenter.y), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomOut() {
        PointF contentCenter = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomOut(contentCenter.x, -contentCenter.y), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float f, float f2, float f3, float f4) {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoom(f, f2, f3, f4), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency) {
        addViewportJob(new ZoomJob(this.mViewPortHandler, f, f2, f3, f4, getTransformer(axisDependency), axisDependency, this));
    }

    @TargetApi(11)
    public void zoomAndCenterAnimated(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        if (Build.VERSION.SDK_INT >= 11) {
            PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency2);
            AnimatedZoomJob animatedZoomJob = r0;
            AnimatedZoomJob animatedZoomJob2 = new AnimatedZoomJob(this.mViewPortHandler, this, getTransformer(axisDependency2), getAxis(axisDependency2), (float) this.mXAxis.getValues().size(), f, f2, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), f3, f4, (float) valuesByTouchPoint.f67x, (float) valuesByTouchPoint.f68y, j);
            addViewportJob(animatedZoomJob);
            return;
        }
        Log.e(Chart.LOG_TAG, "Unable to execute zoomAndCenterAnimated(...) on API level < 11");
    }

    public void fitScreen() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.fitScreen(), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void setScaleMinima(float f, float f2) {
        this.mViewPortHandler.setMinimumScaleX(f);
        this.mViewPortHandler.setMinimumScaleY(f2);
    }

    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.setMinimumScaleX(this.mXAxis.mAxisRange / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.setMaximumScaleX(this.mXAxis.mAxisRange / f);
    }

    public void setVisibleXRange(float f, float f2) {
        float f3 = this.mXAxis.mAxisRange / f;
        this.mViewPortHandler.setMinMaxScaleX(this.mXAxis.mAxisRange / f2, f3);
    }

    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMinimumScaleY(getDeltaY(axisDependency) / f);
    }

    public void moveViewToX(float f) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this));
    }

    public void moveViewToY(float f, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, 0.0f, f + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    public void moveViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f, f2 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void moveViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        if (Build.VERSION.SDK_INT >= 11) {
            PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency2);
            float deltaY = getDeltaY(axisDependency2) / this.mViewPortHandler.getScaleY();
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            float f3 = f2 + (deltaY / 2.0f);
            addViewportJob(new AnimatedMoveViewJob(viewPortHandler, f, f3, getTransformer(axisDependency2), this, (float) valuesByTouchPoint.f67x, (float) valuesByTouchPoint.f68y, j));
            return;
        }
        Log.e(Chart.LOG_TAG, "Unable to execute moveViewToAnimated(...) on API level < 11");
    }

    public void centerViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f - ((((float) getXAxis().getValues().size()) / this.mViewPortHandler.getScaleX()) / 2.0f), f2 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void centerViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        if (Build.VERSION.SDK_INT >= 11) {
            PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency2);
            float deltaY = getDeltaY(axisDependency2) / this.mViewPortHandler.getScaleY();
            float size = ((float) getXAxis().getValues().size()) / this.mViewPortHandler.getScaleX();
            addViewportJob(new AnimatedMoveViewJob(this.mViewPortHandler, f - (size / 2.0f), f2 + (deltaY / 2.0f), getTransformer(axisDependency2), this, (float) valuesByTouchPoint.f67x, (float) valuesByTouchPoint.f68y, j));
            return;
        }
        Log.e(Chart.LOG_TAG, "Unable to execute centerViewToAnimated(...) on API level < 11");
    }

    public void setViewPortOffsets(float f, float f2, float f3, float f4) {
        this.mCustomViewPortEnabled = true;
        final float f5 = f;
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        post(new Runnable() {
            public void run() {
                BarLineChartBase.this.mViewPortHandler.restrainViewPort(f5, f6, f7, f8);
                BarLineChartBase.this.prepareOffsetMatrix();
                BarLineChartBase.this.prepareValuePxMatrix();
            }
        });
    }

    public void resetViewPortOffsets() {
        this.mCustomViewPortEnabled = false;
        calculateOffsets();
    }

    public float getDeltaY(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft.mAxisRange;
        }
        return this.mAxisRight.mAxisRange;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {(float) entry.getXIndex(), entry.getVal()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public void setMaxVisibleValueCount(int i) {
        this.mMaxVisibleCount = i;
    }

    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.mHighlightPerDragEnabled = z;
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    public void setGridBackgroundColor(int i) {
        this.mGridBackgroundPaint.setColor(i);
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void setScaleEnabled(boolean z) {
        this.mScaleXEnabled = z;
        this.mScaleYEnabled = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.mScaleXEnabled = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.mScaleYEnabled = z;
    }

    public boolean isScaleXEnabled() {
        return this.mScaleXEnabled;
    }

    public boolean isScaleYEnabled() {
        return this.mScaleYEnabled;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.mDoubleTapToZoomEnabled = z;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public void setDrawGridBackground(boolean z) {
        this.mDrawGridBackground = z;
    }

    public void setDrawBorders(boolean z) {
        this.mDrawBorders = z;
    }

    public void setBorderWidth(float f) {
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(f));
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public boolean isKeepPositionOnRotation() {
        return this.mKeepPositionOnRotation;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.mKeepPositionOnRotation = z;
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData != null) {
            return getHighlighter().getHighlight(f, f2);
        }
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public PointD getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        float[] fArr = {f, f2};
        getTransformer(axisDependency).pixelsToValue(fArr);
        return new PointD((double) fArr[0], (double) fArr[1]);
    }

    public PointD getPixelsForValues(float f, float f2, YAxis.AxisDependency axisDependency) {
        float[] fArr = {f, f2};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointD((double) fArr[0], (double) fArr[1]);
    }

    public float getYValueByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        return (float) getValuesByTouchPoint(f, f2, axisDependency).f68y;
    }

    public Entry getEntryByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return ((BarLineScatterCandleBubbleData) this.mData).getEntryForHighlight(highlightByTouchPoint);
        }
        return null;
    }

    public IBarLineScatterCandleBubbleDataSet getDataSetByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).getDataSetByIndex(highlightByTouchPoint.getDataSetIndex());
        }
        return null;
    }

    public int getLowestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[0] <= 0.0f) {
            return 0;
        }
        return (int) (fArr[0] + 1.0f);
    }

    public int getHighestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return fArr[0] >= ((float) ((BarLineScatterCandleBubbleData) this.mData).getXValCount()) ? ((BarLineScatterCandleBubbleData) this.mData).getXValCount() - 1 : (int) fArr[0];
    }

    public float getScaleX() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.getScaleX();
    }

    public float getScaleY() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.getScaleY();
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.isFullyZoomedOut();
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public YAxis getAxis(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft;
        }
        return this.mAxisRight;
    }

    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        return getAxis(axisDependency).isInverted();
    }

    public void setPinchZoom(boolean z) {
        this.mPinchZoomEnabled = z;
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public void setDragOffsetX(float f) {
        this.mViewPortHandler.setDragOffsetX(f);
    }

    public void setDragOffsetY(float f) {
        this.mViewPortHandler.setDragOffsetY(f);
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.hasNoDragOffset();
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.mXAxisRenderer = xAxisRenderer;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererLeft = yAxisRenderer;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererRight = yAxisRenderer;
    }

    public float getYChartMax() {
        return Math.max(this.mAxisLeft.mAxisMaximum, this.mAxisRight.mAxisMaximum);
    }

    public float getYChartMin() {
        return Math.min(this.mAxisLeft.mAxisMinimum, this.mAxisRight.mAxisMinimum);
    }

    public boolean isAnyAxisInverted() {
        if (!this.mAxisLeft.isInverted() && !this.mAxisRight.isInverted()) {
            return false;
        }
        return true;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.mAutoScaleMinMaxEnabled = z;
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    public void setPaint(Paint paint, int i) {
        super.setPaint(paint, i);
        if (i == 4) {
            this.mGridBackgroundPaint = paint;
        }
    }

    public Paint getPaint(int i) {
        Paint paint = super.getPaint(i);
        if (paint != null) {
            return paint;
        }
        if (i != 4) {
            return null;
        }
        return this.mGridBackgroundPaint;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = new float[2];
        if (this.mKeepPositionOnRotation) {
            fArr[0] = this.mViewPortHandler.contentLeft();
            fArr[1] = this.mViewPortHandler.contentTop();
            getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mKeepPositionOnRotation) {
            getTransformer(YAxis.AxisDependency.LEFT).pointValuesToPixel(fArr);
            this.mViewPortHandler.centerViewPort(fArr, this);
            return;
        }
        this.mViewPortHandler.refresh(this.mViewPortHandler.getMatrixTouch(), this, true);
    }
}
