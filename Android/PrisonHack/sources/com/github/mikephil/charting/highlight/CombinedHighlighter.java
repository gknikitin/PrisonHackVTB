package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import java.util.ArrayList;
import java.util.List;

public class CombinedHighlighter extends ChartHighlighter<BarLineScatterCandleBubbleDataProvider> {
    public CombinedHighlighter(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider) {
        super(barLineScatterCandleBubbleDataProvider);
    }

    /* access modifiers changed from: protected */
    public List<SelectionDetail> getSelectionDetailsAtIndex(int i) {
        List<ChartData> allData = ((CombinedData) this.mChart.getData()).getAllData();
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < allData.size(); i2++) {
            for (int i3 = 0; i3 < allData.get(i2).getDataSetCount(); i3++) {
                IDataSet dataSetByIndex = allData.get(i2).getDataSetByIndex(i3);
                if (dataSetByIndex.isHighlightEnabled()) {
                    float yValForXIndex = dataSetByIndex.getYValForXIndex(i);
                    if (yValForXIndex != Float.NaN) {
                        fArr[1] = yValForXIndex;
                        this.mChart.getTransformer(dataSetByIndex.getAxisDependency()).pointValuesToPixel(fArr);
                        if (!Float.isNaN(fArr[1])) {
                            arrayList.add(new SelectionDetail(fArr[1], i3, dataSetByIndex));
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
