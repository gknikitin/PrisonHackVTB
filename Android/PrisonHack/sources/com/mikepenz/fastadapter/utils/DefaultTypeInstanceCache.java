package com.mikepenz.fastadapter.utils;

import android.util.SparseArray;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ITypeInstanceCache;

public class DefaultTypeInstanceCache<Item extends IItem> implements ITypeInstanceCache<Item> {
    private final SparseArray<Item> mTypeInstances = new SparseArray<>();

    public boolean register(Item item) {
        if (this.mTypeInstances.indexOfKey(item.getType()) >= 0) {
            return false;
        }
        this.mTypeInstances.put(item.getType(), item);
        return true;
    }

    public Item get(int i) {
        return (IItem) this.mTypeInstances.get(i);
    }

    public void clear() {
        this.mTypeInstances.clear();
    }
}
