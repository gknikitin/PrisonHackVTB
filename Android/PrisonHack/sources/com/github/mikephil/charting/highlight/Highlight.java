package com.github.mikephil.charting.highlight;

public class Highlight {
    private int mDataSetIndex;
    private Range mRange;
    private int mStackIndex;
    private int mXIndex;

    public Highlight(int i, int i2) {
        this.mStackIndex = -1;
        this.mXIndex = i;
        this.mDataSetIndex = i2;
    }

    public Highlight(int i, int i2, int i3) {
        this(i, i2);
        this.mStackIndex = i3;
    }

    public Highlight(int i, int i2, int i3, Range range) {
        this(i, i2, i3);
        this.mRange = range;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public int getXIndex() {
        return this.mXIndex;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public Range getRange() {
        return this.mRange;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mXIndex == highlight.mXIndex && this.mStackIndex == highlight.mStackIndex;
    }

    public String toString() {
        return "Highlight, xIndex: " + this.mXIndex + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }
}
