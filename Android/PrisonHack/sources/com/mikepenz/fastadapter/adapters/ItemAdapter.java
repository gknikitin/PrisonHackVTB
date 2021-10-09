package com.mikepenz.fastadapter.adapters;

import com.mikepenz.fastadapter.IInterceptor;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemList;

public class ItemAdapter<Item extends IItem> extends ModelAdapter<Item, Item> {
    public ItemAdapter() {
        super(IInterceptor.DEFAULT);
    }

    public ItemAdapter(IItemList<Item> iItemList) {
        super(iItemList, IInterceptor.DEFAULT);
    }

    public static <Item extends IItem> ItemAdapter<Item> items() {
        return new ItemAdapter<>();
    }
}
