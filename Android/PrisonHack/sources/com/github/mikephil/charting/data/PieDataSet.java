package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<Entry> implements IPieDataSet {
    private float mShift = 18.0f;
    private float mSliceSpace = 0.0f;

    public PieDataSet(List<Entry> list, String str) {
        super(list, str);
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        pieDataSet.mColors = this.mColors;
        pieDataSet.mSliceSpace = this.mSliceSpace;
        pieDataSet.mShift = this.mShift;
        return pieDataSet;
    }

    public void setSliceSpace(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mSliceSpace = Utils.convertDpToPixel(f);
    }

    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    public void setSelectionShift(float f) {
        this.mShift = Utils.convertDpToPixel(f);
    }

    public float getSelectionShift() {
        return this.mShift;
    }
}
