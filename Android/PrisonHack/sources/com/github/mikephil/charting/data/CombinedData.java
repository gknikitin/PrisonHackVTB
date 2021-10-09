package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<?>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    public CombinedData() {
    }

    public CombinedData(List<String> list) {
        super(list);
    }

    public CombinedData(String[] strArr) {
        super(strArr);
    }

    public void setData(LineData lineData) {
        this.mLineData = lineData;
        this.mDataSets.addAll(lineData.getDataSets());
        init();
    }

    public void setData(BarData barData) {
        this.mBarData = barData;
        this.mDataSets.addAll(barData.getDataSets());
        init();
    }

    public void setData(ScatterData scatterData) {
        this.mScatterData = scatterData;
        this.mDataSets.addAll(scatterData.getDataSets());
        init();
    }

    public void setData(CandleData candleData) {
        this.mCandleData = candleData;
        this.mDataSets.addAll(candleData.getDataSets());
        init();
    }

    public void setData(BubbleData bubbleData) {
        this.mBubbleData = bubbleData;
        this.mDataSets.addAll(bubbleData.getDataSets());
        init();
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    public List<ChartData> getAllData() {
        ArrayList arrayList = new ArrayList();
        if (this.mLineData != null) {
            arrayList.add(this.mLineData);
        }
        if (this.mBarData != null) {
            arrayList.add(this.mBarData);
        }
        if (this.mScatterData != null) {
            arrayList.add(this.mScatterData);
        }
        if (this.mCandleData != null) {
            arrayList.add(this.mCandleData);
        }
        if (this.mBubbleData != null) {
            arrayList.add(this.mBubbleData);
        }
        return arrayList;
    }

    public void notifyDataChanged() {
        if (this.mLineData != null) {
            this.mLineData.notifyDataChanged();
        }
        if (this.mBarData != null) {
            this.mBarData.notifyDataChanged();
        }
        if (this.mCandleData != null) {
            this.mCandleData.notifyDataChanged();
        }
        if (this.mScatterData != null) {
            this.mScatterData.notifyDataChanged();
        }
        if (this.mBubbleData != null) {
            this.mBubbleData.notifyDataChanged();
        }
        init();
    }
}
