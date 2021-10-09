package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import java.util.List;

public interface IAdapter<Item extends IItem> {
    Item getAdapterItem(int i);

    int getAdapterItemCount();

    List<Item> getAdapterItems();

    int getAdapterPosition(long j);

    int getAdapterPosition(Item item);

    FastAdapter<Item> getFastAdapter();

    int getGlobalPosition(int i);

    int getOrder();

    void setOrder(int i);

    IAdapter<Item> withFastAdapter(FastAdapter<Item> fastAdapter);
}
