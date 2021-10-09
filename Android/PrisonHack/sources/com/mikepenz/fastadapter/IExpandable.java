package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ISubItem;
import java.util.List;

public interface IExpandable<T, Item extends IItem & ISubItem> {
    List<Item> getSubItems();

    boolean isAutoExpanding();

    boolean isExpanded();

    T withIsExpanded(boolean z);

    T withSubItems(List<Item> list);
}
