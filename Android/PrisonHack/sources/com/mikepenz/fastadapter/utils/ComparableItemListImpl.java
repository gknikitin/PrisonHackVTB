package com.mikepenz.fastadapter.utils;

import android.support.annotation.Nullable;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableItemListImpl<Item extends IItem> extends DefaultItemListImpl<Item> {
    private Comparator<Item> mComparator;

    public ComparableItemListImpl(@Nullable Comparator<Item> comparator) {
        this.mItems = new ArrayList();
        this.mComparator = comparator;
    }

    public ComparableItemListImpl(@Nullable Comparator<Item> comparator, List<Item> list) {
        this.mItems = list;
        this.mComparator = comparator;
    }

    public Comparator<Item> getComparator() {
        return this.mComparator;
    }

    public ComparableItemListImpl<Item> withComparator(@Nullable Comparator<Item> comparator) {
        return withComparator(comparator, true);
    }

    public ComparableItemListImpl<Item> withComparator(@Nullable Comparator<Item> comparator, boolean z) {
        this.mComparator = comparator;
        if (!(this.mItems == null || this.mComparator == null || !z)) {
            Collections.sort(this.mItems, this.mComparator);
            getFastAdapter().notifyAdapterDataSetChanged();
        }
        return this;
    }

    public void move(int i, int i2, int i3) {
        int i4 = i - i3;
        this.mItems.remove(i4);
        this.mItems.add(i2 - i3, (IItem) this.mItems.get(i4));
        if (this.mComparator != null) {
            Collections.sort(this.mItems, this.mComparator);
        }
        getFastAdapter().notifyAdapterDataSetChanged();
    }

    public void addAll(List<Item> list, int i) {
        this.mItems.addAll(list);
        if (this.mComparator != null) {
            Collections.sort(this.mItems, this.mComparator);
        }
        getFastAdapter().notifyAdapterDataSetChanged();
    }

    public void addAll(int i, List<Item> list, int i2) {
        this.mItems.addAll(i - i2, list);
        if (this.mComparator != null) {
            Collections.sort(this.mItems, this.mComparator);
        }
        getFastAdapter().notifyAdapterDataSetChanged();
    }

    public void setNewList(List<Item> list, boolean z) {
        this.mItems = new ArrayList(list);
        if (this.mComparator != null) {
            Collections.sort(this.mItems, this.mComparator);
        }
        if (z) {
            getFastAdapter().notifyAdapterDataSetChanged();
        }
    }
}
