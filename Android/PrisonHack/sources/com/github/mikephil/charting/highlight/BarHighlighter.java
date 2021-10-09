package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    public Highlight getHighlight(float f, float f2) {
        Highlight highlight = super.getHighlight(f, f2);
        if (highlight == null) {
            return highlight;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(highlight.getDataSetIndex());
        if (!iBarDataSet.isStacked()) {
            return highlight;
        }
        float[] fArr = new float[2];
        fArr[1] = f2;
        ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).pixelsToValue(fArr);
        return getStackedHighlight(highlight, iBarDataSet, highlight.getXIndex(), highlight.getDataSetIndex(), (double) fArr[1]);
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            return super.getXIndex(f);
        }
        int base = ((int) getBase(f)) / ((BarDataProvider) this.mChart).getBarData().getDataSetCount();
        int xValCount = ((BarDataProvider) this.mChart).getData().getXValCount();
        if (base < 0) {
            return 0;
        }
        return base >= xValCount ? xValCount - 1 : base;
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndex(int i, float f, float f2) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            return 0;
        }
        float base = getBase(f);
        int dataSetCount = ((BarDataProvider) this.mChart).getBarData().getDataSetCount();
        int i2 = ((int) base) % dataSetCount;
        if (i2 < 0) {
            return 0;
        }
        return i2 >= dataSetCount ? dataSetCount - 1 : i2;
    }

    /* access modifiers changed from: protected */
    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, int i, int i2, double d) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXIndex(i);
        if (barEntry == null || barEntry.getVals() == null) {
            return highlight;
        }
        Range[] ranges = getRanges(barEntry);
        int closestStackIndex = getClosestStackIndex(ranges, (float) d);
        if (ranges.length > 0) {
            return new Highlight(i, i2, closestStackIndex, ranges[closestStackIndex]);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getClosestStackIndex(Range[] rangeArr, float f) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (Range contains : rangeArr) {
            if (contains.contains(f)) {
                return i;
            }
            i++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f > rangeArr[max].f59to) {
            return max;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getBase(float f) {
        float[] fArr = new float[2];
        fArr[0] = f;
        ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f2 = fArr[0];
        return f2 - (((BarDataProvider) this.mChart).getBarData().getGroupSpace() * ((float) ((int) (f2 / (((float) ((BarDataProvider) this.mChart).getBarData().getDataSetCount()) + ((BarDataProvider) this.mChart).getBarData().getGroupSpace())))));
    }

    /* access modifiers changed from: protected */
    public Range[] getRanges(BarEntry barEntry) {
        float[] vals = barEntry.getVals();
        if (vals == null || vals.length == 0) {
            return new Range[0];
        }
        Range[] rangeArr = new Range[vals.length];
        float f = -barEntry.getNegativeSum();
        float f2 = 0.0f;
        for (int i = 0; i < rangeArr.length; i++) {
            float f3 = vals[i];
            if (f3 < 0.0f) {
                rangeArr[i] = new Range(f, Math.abs(f3) + f);
                f += Math.abs(f3);
            } else {
                float f4 = f3 + f2;
                rangeArr[i] = new Range(f2, f4);
                f2 = f4;
            }
        }
        return rangeArr;
    }
}
