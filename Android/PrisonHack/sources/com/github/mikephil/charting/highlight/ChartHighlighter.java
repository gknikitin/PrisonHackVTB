package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> {
    protected T mChart;

    public ChartHighlighter(T t) {
        this.mChart = t;
    }

    public Highlight getHighlight(float f, float f2) {
        int dataSetIndex;
        int xIndex = getXIndex(f);
        if (xIndex == -2147483647 || (dataSetIndex = getDataSetIndex(xIndex, f, f2)) == -2147483647) {
            return null;
        }
        return new Highlight(xIndex, dataSetIndex);
    }

    /* access modifiers changed from: protected */
    public int getXIndex(float f) {
        float[] fArr = new float[2];
        fArr[0] = f;
        this.mChart.getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return Math.round(fArr[0]);
    }

    /* access modifiers changed from: protected */
    public int getDataSetIndex(int i, float f, float f2) {
        List<SelectionDetail> selectionDetailsAtIndex = getSelectionDetailsAtIndex(i);
        return Utils.getClosestDataSetIndex(selectionDetailsAtIndex, f2, Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.LEFT) < Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.RIGHT) ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT);
    }

    /* access modifiers changed from: protected */
    public List<SelectionDetail> getSelectionDetailsAtIndex(int i) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < this.mChart.getData().getDataSetCount(); i2++) {
            IDataSet dataSetByIndex = this.mChart.getData().getDataSetByIndex(i2);
            if (dataSetByIndex.isHighlightEnabled()) {
                float yValForXIndex = dataSetByIndex.getYValForXIndex(i);
                if (yValForXIndex != Float.NaN) {
                    fArr[1] = yValForXIndex;
                    this.mChart.getTransformer(dataSetByIndex.getAxisDependency()).pointValuesToPixel(fArr);
                    if (!Float.isNaN(fArr[1])) {
                        arrayList.add(new SelectionDetail(fArr[1], i2, dataSetByIndex));
                    }
                }
            }
        }
        return arrayList;
    }
}
