package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class DefaultItemListImpl<Item extends IItem> extends DefaultItemList<Item> {
    protected List<Item> mItems;

    public DefaultItemListImpl() {
        this(new ArrayList());
    }

    public DefaultItemListImpl(List<Item> list) {
        this.mItems = list;
    }

    public Item get(int i) {
        return (IItem) this.mItems.get(i);
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public int getAdapterPosition(long j) {
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            if (((IItem) this.mItems.get(i)).getIdentifier() == j) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int i, int i2) {
        this.mItems.remove(i - i2);
        getFastAdapter().notifyAdapterItemRemoved(i);
    }

    public void removeRange(int i, int i2, int i3) {
        int min = Math.min(i2, (this.mItems.size() - i) + i3);
        for (int i4 = 0; i4 < min; i4++) {
            this.mItems.remove(i - i3);
        }
        getFastAdapter().notifyAdapterItemRangeRemoved(i, min);
    }

    public void move(int i, int i2, int i3) {
        int i4 = i - i3;
        this.mItems.remove(i4);
        this.mItems.add(i2 - i3, (IItem) this.mItems.get(i4));
        getFastAdapter().notifyAdapterItemMoved(i, i2);
    }

    public int size() {
        return this.mItems.size();
    }

    public void clear(int i) {
        int size = this.mItems.size();
        this.mItems.clear();
        getFastAdapter().notifyAdapterItemRangeRemoved(i, size);
    }

    public boolean isEmpty() {
        return this.mItems.isEmpty();
    }

    public void set(int i, Item item, int i2) {
        this.mItems.set(i - i2, item);
        getFastAdapter().notifyAdapterItemChanged(i);
    }

    public void addAll(List<Item> list, int i) {
        int size = this.mItems.size();
        this.mItems.addAll(list);
        getFastAdapter().notifyAdapterItemRangeInserted(i + size, list.size());
    }

    public void addAll(int i, List<Item> list, int i2) {
        this.mItems.addAll(i - i2, list);
        getFastAdapter().notifyAdapterItemRangeInserted(i, list.size());
    }

    public void set(List<Item> list, int i, @Nullable IAdapterNotifier iAdapterNotifier) {
        int size = list.size();
        int size2 = this.mItems.size();
        if (list != this.mItems) {
            if (!this.mItems.isEmpty()) {
                this.mItems.clear();
            }
            this.mItems.addAll(list);
        }
        if (iAdapterNotifier == null) {
            iAdapterNotifier = IAdapterNotifier.DEFAULT;
        }
        iAdapterNotifier.notify(getFastAdapter(), size, size2, i);
    }

    public void setNewList(List<Item> list, boolean z) {
        this.mItems = new ArrayList(list);
        if (z) {
            getFastAdapter().notifyAdapterDataSetChanged();
        }
    }
}
