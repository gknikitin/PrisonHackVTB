package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import javax.annotation.Nullable;

public interface ISelectionListener<Item extends IItem> {
    void onSelectionChanged(@Nullable Item item, boolean z);
}
