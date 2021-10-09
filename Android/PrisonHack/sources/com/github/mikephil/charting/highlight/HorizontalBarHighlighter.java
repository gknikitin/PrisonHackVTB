package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
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
        fArr[0] = f2;
        ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).pixelsToValue(fArr);
        return getStackedHighlight(highlight, iBarDataSet, highlight.getXIndex(), highlight.getDataSetIndex(), (double) fArr[0]);
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f) {
        if (!((BarDataProvider) this.mChart).getBarData().isGrouped()) {
            float[] fArr = new float[2];
            fArr[1] = f;
            ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
            return Math.round(fArr[1]);
        }
        int base = ((int) getBase(f)) / ((BarDataProvider) this.mChart).getBarData().getDataSetCount();
        int xValCount = ((BarDataProvider) this.mChart).getData().getXValCount();
        if (base < 0) {
            return 0;
        }
        return base >= xValCount ? xValCount - 1 : base;
    }

    /* access modifiers changed from: protected */
    public float getBase(float f) {
        float[] fArr = new float[2];
        fArr[1] = f;
        ((BarDataProvider) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f2 = fArr[1];
        return f2 - (((BarDataProvider) this.mChart).getBarData().getGroupSpace() * ((float) ((int) (f2 / (((float) ((BarDataProvider) this.mChart).getBarData().getDataSetCount()) + ((BarDataProvider) this.mChart).getBarData().getGroupSpace())))));
    }
}
