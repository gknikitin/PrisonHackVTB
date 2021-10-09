package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset = 0.0f;
    private float mRawRotationAngle = 270.0f;
    protected boolean mRotateEnabled = true;
    private float mRotationAngle = 270.0f;

    public abstract int getIndexForAngle(float f);

    public abstract float getRadius();

    /* access modifiers changed from: protected */
    public abstract float getRequiredBaseOffset();

    /* access modifiers changed from: protected */
    public abstract float getRequiredLegendOffset();

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    public PieRadarChartBase(Context context) {
        super(context);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        this.mXAxis.mAxisRange = (float) (this.mData.getXVals().size() - 1);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchEnabled || this.mChartTouchListener == null) {
            return super.onTouchEvent(motionEvent);
        }
        return this.mChartTouchListener.onTouch(this, motionEvent);
    }

    public void computeScroll() {
        if (this.mChartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) this.mChartTouchListener).computeScroll();
        }
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            calcMinMax();
            if (this.mLegend != null) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    public void calculateOffsets() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float convertDpToPixel;
        float f6 = 0.0f;
        if (this.mLegend == null || !this.mLegend.isEnabled()) {
            f3 = 0.0f;
            f2 = 0.0f;
            f = 0.0f;
        } else {
            float min = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getFormSize() + this.mLegend.getFormToTextSpace();
            if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART_CENTER) {
                f5 = min + Utils.convertDpToPixel(13.0f);
            } else if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART) {
                f5 = min + Utils.convertDpToPixel(8.0f);
                float f7 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
                PointF center = getCenter();
                PointF pointF = new PointF((((float) getWidth()) - f5) + 15.0f, f7 + 15.0f);
                float distanceToCenter = distanceToCenter(pointF.x, pointF.y);
                PointF position = getPosition(center, getRadius(), getAngleForPoint(pointF.x, pointF.y));
                float distanceToCenter2 = distanceToCenter(position.x, position.y);
                float convertDpToPixel2 = distanceToCenter < distanceToCenter2 ? Utils.convertDpToPixel(5.0f) + (distanceToCenter2 - distanceToCenter) : 0.0f;
                if (pointF.y < center.y || ((float) getHeight()) - f5 <= ((float) getWidth())) {
                    f5 = convertDpToPixel2;
                }
            } else {
                if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART_CENTER) {
                    convertDpToPixel = min + Utils.convertDpToPixel(13.0f);
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART) {
                    convertDpToPixel = min + Utils.convertDpToPixel(8.0f);
                    float f8 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
                    PointF center2 = getCenter();
                    PointF pointF2 = new PointF(convertDpToPixel - 15.0f, f8 + 15.0f);
                    float distanceToCenter3 = distanceToCenter(pointF2.x, pointF2.y);
                    PointF position2 = getPosition(center2, getRadius(), getAngleForPoint(pointF2.x, pointF2.y));
                    float distanceToCenter4 = distanceToCenter(position2.x, position2.y);
                    float convertDpToPixel3 = distanceToCenter3 < distanceToCenter4 ? Utils.convertDpToPixel(5.0f) + (distanceToCenter4 - distanceToCenter3) : 0.0f;
                    if (pointF2.y < center2.y || ((float) getHeight()) - convertDpToPixel <= ((float) getWidth())) {
                        convertDpToPixel = convertDpToPixel3;
                    }
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_LEFT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_RIGHT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_CENTER) {
                    f = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                    f5 = 0.0f;
                    f4 = 0.0f;
                    f6 += getRequiredBaseOffset();
                    f3 = f5 + getRequiredBaseOffset();
                    f2 = f4 + getRequiredBaseOffset();
                } else {
                    if (this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_LEFT || this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_RIGHT || this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_CENTER) {
                        f4 = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                        f5 = 0.0f;
                        f = 0.0f;
                        f6 += getRequiredBaseOffset();
                        f3 = f5 + getRequiredBaseOffset();
                        f2 = f4 + getRequiredBaseOffset();
                    }
                    f5 = 0.0f;
                }
                f6 = convertDpToPixel;
                f5 = 0.0f;
            }
            f4 = 0.0f;
            f = 0.0f;
            f6 += getRequiredBaseOffset();
            f3 = f5 + getRequiredBaseOffset();
            f2 = f4 + getRequiredBaseOffset();
        }
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mMinOffset);
        if (this instanceof RadarChart) {
            XAxis xAxis = ((RadarChart) this).getXAxis();
            if (xAxis.isEnabled() && xAxis.isDrawLabelsEnabled()) {
                convertDpToPixel4 = Math.max(convertDpToPixel4, (float) xAxis.mLabelRotatedWidth);
            }
        }
        float extraTopOffset = f2 + getExtraTopOffset();
        float extraRightOffset = f3 + getExtraRightOffset();
        float extraBottomOffset = f + getExtraBottomOffset();
        float max = Math.max(convertDpToPixel4, f6 + getExtraLeftOffset());
        float max2 = Math.max(convertDpToPixel4, extraTopOffset);
        float max3 = Math.max(convertDpToPixel4, extraRightOffset);
        float max4 = Math.max(convertDpToPixel4, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.mViewPortHandler.restrainViewPort(max, max2, max3, max4);
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + max + ", offsetTop: " + max2 + ", offsetRight: " + max3 + ", offsetBottom: " + max4);
        }
    }

    public float getAngleForPoint(float f, float f2) {
        PointF centerOffsets = getCenterOffsets();
        double d = (double) (f - centerOffsets.x);
        double d2 = (double) (f2 - centerOffsets.y);
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        return f3 > 360.0f ? f3 - 360.0f : f3;
    }

    /* access modifiers changed from: protected */
    public PointF getPosition(PointF pointF, float f, float f2) {
        double d = (double) f;
        double d2 = (double) f2;
        return new PointF((float) (((double) pointF.x) + (Math.cos(Math.toRadians(d2)) * d)), (float) (((double) pointF.y) + (d * Math.sin(Math.toRadians(d2)))));
    }

    public float distanceToCenter(float f, float f2) {
        float f3;
        float f4;
        PointF centerOffsets = getCenterOffsets();
        if (f > centerOffsets.x) {
            f3 = f - centerOffsets.x;
        } else {
            f3 = centerOffsets.x - f;
        }
        if (f2 > centerOffsets.y) {
            f4 = f2 - centerOffsets.y;
        } else {
            f4 = centerOffsets.y - f2;
        }
        return (float) Math.sqrt(Math.pow((double) f3, 2.0d) + Math.pow((double) f4, 2.0d));
    }

    public void setRotationAngle(float f) {
        this.mRawRotationAngle = f;
        this.mRotationAngle = Utils.getNormalizedAngle(this.mRawRotationAngle);
    }

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationEnabled(boolean z) {
        this.mRotateEnabled = z;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width(), contentRect.height());
    }

    public List<SelectionDetail> getSelectionDetailsAtIndex(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mData.getDataSetCount(); i2++) {
            IDataSet dataSetByIndex = this.mData.getDataSetByIndex(i2);
            float yValForXIndex = dataSetByIndex.getYValForXIndex(i);
            if (yValForXIndex != Float.NaN) {
                arrayList.add(new SelectionDetail(yValForXIndex, i2, dataSetByIndex));
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public void spin(int i, float f, float f2, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT >= 11) {
            setRotationAngle(f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", new float[]{f, f2});
            ofFloat.setDuration((long) i);
            ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PieRadarChartBase.this.postInvalidate();
                }
            });
            ofFloat.start();
        }
    }
}
