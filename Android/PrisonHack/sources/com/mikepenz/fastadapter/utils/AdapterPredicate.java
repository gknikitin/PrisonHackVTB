package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;

public interface AdapterPredicate<Item extends IItem> {
    boolean apply(IAdapter<Item> iAdapter, int i, Item item, int i2);
}
