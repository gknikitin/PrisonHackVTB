package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import javax.annotation.Nullable;

public abstract class AbstractAdapter<Item extends IItem> implements IAdapter<Item> {
    protected FastAdapter<Item> mFastAdapter;
    protected int mOrder = -1;

    public AbstractAdapter<Item> withFastAdapter(FastAdapter<Item> fastAdapter) {
        this.mFastAdapter = fastAdapter;
        return this;
    }

    public FastAdapter<Item> getFastAdapter() {
        return this.mFastAdapter;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int i) {
        this.mOrder = i;
    }

    public void mapPossibleTypes(@Nullable Iterable<Item> iterable) {
        if (iterable != null) {
            for (Item registerTypeInstance : iterable) {
                this.mFastAdapter.registerTypeInstance(registerTypeInstance);
            }
        }
    }
}
