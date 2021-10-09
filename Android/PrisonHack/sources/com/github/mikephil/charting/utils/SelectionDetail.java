package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public class SelectionDetail {
    public IDataSet dataSet;
    public int dataSetIndex;
    public float val;

    public SelectionDetail(float f, int i, IDataSet iDataSet) {
        this.val = f;
        this.dataSetIndex = i;
        this.dataSet = iDataSet;
    }
}
