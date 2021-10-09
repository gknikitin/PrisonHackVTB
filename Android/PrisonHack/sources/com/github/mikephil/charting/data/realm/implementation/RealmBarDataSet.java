package com.github.mikephil.charting.data.realm.implementation;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.realm.base.RealmBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import io.realm.DynamicRealmObject;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;

public class RealmBarDataSet<T extends RealmObject> extends RealmBarLineScatterCandleBubbleDataSet<T, BarEntry> implements IBarDataSet {
    private int mBarShadowColor = Color.rgb(215, 215, 215);
    private float mBarSpace = 0.15f;
    private int mHighLightAlpha = 120;
    private String[] mStackLabels = {"Stack"};
    private int mStackSize = 1;
    private String mStackValueFieldName;

    public RealmBarDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
        this.mHighLightColor = Color.rgb(0, 0, 0);
        build(this.results);
        calcMinMax(0, realmResults.size());
    }

    public RealmBarDataSet(RealmResults<T> realmResults, String str, String str2, String str3) {
        super(realmResults, str, str2);
        this.mStackValueFieldName = str3;
        this.mHighLightColor = Color.rgb(0, 0, 0);
        build(this.results);
        calcMinMax(0, realmResults.size());
    }

    public void build(RealmResults<T> realmResults) {
        Iterator it = realmResults.iterator();
        while (it.hasNext()) {
            DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it.next());
            try {
                this.mValues.add(new BarEntry(dynamicRealmObject.getFloat(this.mValuesField), dynamicRealmObject.getInt(this.mIndexField)));
            } catch (IllegalArgumentException unused) {
                RealmList list = dynamicRealmObject.getList(this.mValuesField);
                float[] fArr = new float[list.size()];
                int i = 0;
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    fArr[i] = ((DynamicRealmObject) it2.next()).getFloat(this.mStackValueFieldName);
                    i++;
                }
                this.mValues.add(new BarEntry(fArr, dynamicRealmObject.getInt(this.mIndexField)));
            }
        }
        calcStackSize();
    }

    public void calcMinMax(int i, int i2) {
        int size;
        if (this.mValues != null && (size = this.mValues.size()) != 0) {
            if (i2 == 0 || i2 >= size) {
                i2 = size - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i <= i2) {
                BarEntry barEntry = (BarEntry) this.mValues.get(i);
                if (barEntry != null && !Float.isNaN(barEntry.getVal())) {
                    if (barEntry.getVals() == null) {
                        if (barEntry.getVal() < this.mYMin) {
                            this.mYMin = barEntry.getVal();
                        }
                        if (barEntry.getVal() > this.mYMax) {
                            this.mYMax = barEntry.getVal();
                        }
                    } else {
                        if ((-barEntry.getNegativeSum()) < this.mYMin) {
                            this.mYMin = -barEntry.getNegativeSum();
                        }
                        if (barEntry.getPositiveSum() > this.mYMax) {
                            this.mYMax = barEntry.getPositiveSum();
                        }
                    }
                }
                i++;
            }
            if (this.mYMin == Float.MAX_VALUE) {
                this.mYMin = 0.0f;
                this.mYMax = 0.0f;
            }
        }
    }

    private void calcStackSize() {
        for (int i = 0; i < this.mValues.size(); i++) {
            float[] vals = ((BarEntry) this.mValues.get(i)).getVals();
            if (vals != null && vals.length > this.mStackSize) {
                this.mStackSize = vals.length;
            }
        }
    }

    public int getStackSize() {
        return this.mStackSize;
    }

    public boolean isStacked() {
        return this.mStackSize > 1;
    }

    public float getBarSpacePercent() {
        return this.mBarSpace * 100.0f;
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public void setBarSpacePercent(float f) {
        this.mBarSpace = f / 100.0f;
    }

    public void setBarShadowColor(int i) {
        this.mBarShadowColor = i;
    }

    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public void setHighLightAlpha(int i) {
        this.mHighLightAlpha = i;
    }

    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    public void setStackLabels(String[] strArr) {
        this.mStackLabels = strArr;
    }

    public String[] getStackLabels() {
        return this.mStackLabels;
    }
}
