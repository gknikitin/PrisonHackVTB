package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;

public interface ITypeInstanceCache<Item extends IItem> {
    void clear();

    Item get(int i);

    boolean register(Item item);
}
