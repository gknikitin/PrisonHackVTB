package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private int mCircleColorHole;
    private List<Integer> mCircleColors;
    private float mCircleRadius;
    private float mCubicIntensity;
    private DashPathEffect mDashPathEffect;
    private boolean mDrawCircleHole;
    private boolean mDrawCircles;
    private boolean mDrawCubic;
    private boolean mDrawStepped;
    private FillFormatter mFillFormatter;

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mCircleColors = null;
        this.mCircleColorHole = -1;
        this.mCircleRadius = 8.0f;
        this.mCubicIntensity = 0.2f;
        this.mDashPathEffect = null;
        this.mFillFormatter = new DefaultFillFormatter();
        this.mDrawCircles = true;
        this.mDrawCubic = false;
        this.mDrawStepped = false;
        this.mDrawCircleHole = true;
        this.mCircleColors = new ArrayList();
        this.mCircleColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        lineDataSet.mColors = this.mColors;
        lineDataSet.mCircleRadius = this.mCircleRadius;
        lineDataSet.mCircleColors = this.mCircleColors;
        lineDataSet.mDashPathEffect = this.mDashPathEffect;
        lineDataSet.mDrawCircles = this.mDrawCircles;
        lineDataSet.mDrawCubic = this.mDrawCubic;
        lineDataSet.mHighLightColor = this.mHighLightColor;
        return lineDataSet;
    }

    public void setCubicIntensity(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.05f) {
            f = 0.05f;
        }
        this.mCubicIntensity = f;
    }

    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    public void setCircleRadius(float f) {
        this.mCircleRadius = Utils.convertDpToPixel(f);
    }

    public float getCircleRadius() {
        return this.mCircleRadius;
    }

    @Deprecated
    public void setCircleSize(float f) {
        setCircleRadius(f);
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public void setDrawCircles(boolean z) {
        this.mDrawCircles = z;
    }

    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    public void setDrawCubic(boolean z) {
        this.mDrawCubic = z;
    }

    public boolean isDrawCubicEnabled() {
        return this.mDrawCubic;
    }

    public void setDrawStepped(boolean z) {
        this.mDrawStepped = z;
    }

    public boolean isDrawSteppedEnabled() {
        return this.mDrawStepped;
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    public int getCircleColor(int i) {
        return this.mCircleColors.get(i % this.mCircleColors.size()).intValue();
    }

    public void setCircleColors(List<Integer> list) {
        this.mCircleColors = list;
    }

    public void setCircleColors(int[] iArr) {
        this.mCircleColors = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.mCircleColors = arrayList;
    }

    public void setCircleColor(int i) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(i));
    }

    public void resetCircleColors() {
        this.mCircleColors = new ArrayList();
    }

    public void setCircleColorHole(int i) {
        this.mCircleColorHole = i;
    }

    public int getCircleHoleColor() {
        return this.mCircleColorHole;
    }

    public void setDrawCircleHole(boolean z) {
        this.mDrawCircleHole = z;
    }

    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }

    public void setFillFormatter(FillFormatter fillFormatter) {
        if (fillFormatter == null) {
            this.mFillFormatter = new DefaultFillFormatter();
        } else {
            this.mFillFormatter = fillFormatter;
        }
    }

    public FillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }
}
