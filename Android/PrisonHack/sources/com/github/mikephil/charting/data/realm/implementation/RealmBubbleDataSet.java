package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.realm.base.RealmBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;

public class RealmBubbleDataSet<T extends RealmObject> extends RealmBarLineScatterCandleBubbleDataSet<T, BubbleEntry> implements IBubbleDataSet {
    private float mHighlightCircleWidth = 2.5f;
    protected float mMaxSize;
    private String mSizeField;
    protected float mXMax;
    protected float mXMin;

    public RealmBubbleDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str);
        this.mSizeField = str2;
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public RealmBubbleDataSet(RealmResults<T> realmResults, String str, String str2, String str3) {
        super(realmResults, str, str2);
        this.mSizeField = str3;
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public void build(RealmResults<T> realmResults) {
        if (this.mIndexField == null) {
            int i = 0;
            Iterator it = realmResults.iterator();
            while (it.hasNext()) {
                DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it.next());
                this.mValues.add(new BubbleEntry(i, dynamicRealmObject.getFloat(this.mValuesField), dynamicRealmObject.getFloat(this.mSizeField)));
                i++;
            }
            return;
        }
        Iterator it2 = realmResults.iterator();
        while (it2.hasNext()) {
            DynamicRealmObject dynamicRealmObject2 = new DynamicRealmObject((RealmObject) it2.next());
            this.mValues.add(new BubbleEntry(dynamicRealmObject2.getInt(this.mIndexField), dynamicRealmObject2.getFloat(this.mValuesField), dynamicRealmObject2.getFloat(this.mSizeField)));
        }
    }

    public void calcMinMax(int i, int i2) {
        if (this.mValues != null && this.mValues.size() != 0) {
            if (i2 == 0 || i2 >= this.mValues.size()) {
                i2 = this.mValues.size() - 1;
            }
            this.mYMin = yMin((BubbleEntry) this.mValues.get(i));
            this.mYMax = yMax((BubbleEntry) this.mValues.get(i));
            while (i < i2) {
                BubbleEntry bubbleEntry = (BubbleEntry) this.mValues.get(i);
                float yMin = yMin(bubbleEntry);
                float yMax = yMax(bubbleEntry);
                if (yMin < this.mYMin) {
                    this.mYMin = yMin;
                }
                if (yMax > this.mYMax) {
                    this.mYMax = yMax;
                }
                float xMin = xMin(bubbleEntry);
                float xMax = xMax(bubbleEntry);
                if (xMin < this.mXMin) {
                    this.mXMin = xMin;
                }
                if (xMax > this.mXMax) {
                    this.mXMax = xMax;
                }
                float largestSize = largestSize(bubbleEntry);
                if (largestSize > this.mMaxSize) {
                    this.mMaxSize = largestSize;
                }
                i++;
            }
        }
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getMaxSize() {
        return this.mMaxSize;
    }

    private float yMin(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float yMax(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float xMin(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float xMax(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float largestSize(BubbleEntry bubbleEntry) {
        return bubbleEntry.getSize();
    }

    public void setHighlightCircleWidth(float f) {
        this.mHighlightCircleWidth = Utils.convertDpToPixel(f);
    }

    public float getHighlightCircleWidth() {
        return this.mHighlightCircleWidth;
    }

    public void setSizeField(String str) {
        this.mSizeField = str;
    }

    public String getSizeField() {
        return this.mSizeField;
    }
}
