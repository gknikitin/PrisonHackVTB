package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemList;

public abstract class DefaultItemList<Item extends IItem> implements IItemList<Item> {
    private FastAdapter<Item> fastAdapter;

    public void setFastAdapter(FastAdapter<Item> fastAdapter2) {
        this.fastAdapter = fastAdapter2;
    }

    public FastAdapter<Item> getFastAdapter() {
        return this.fastAdapter;
    }
}
