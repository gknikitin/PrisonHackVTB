package com.mikepenz.fastadapter;

import java.util.List;
import javax.annotation.Nullable;

public interface IItemList<Item> {
    void addAll(int i, List<Item> list, int i2);

    void addAll(List<Item> list, int i);

    void clear(int i);

    Item get(int i);

    int getAdapterPosition(long j);

    List<Item> getItems();

    boolean isEmpty();

    void move(int i, int i2, int i3);

    void remove(int i, int i2);

    void removeRange(int i, int i2, int i3);

    void set(int i, Item item, int i2);

    void set(List<Item> list, int i, @Nullable IAdapterNotifier iAdapterNotifier);

    void setNewList(List<Item> list, boolean z);

    int size();
}
