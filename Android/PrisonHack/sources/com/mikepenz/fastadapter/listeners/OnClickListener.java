package com.mikepenz.fastadapter.listeners;

import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import javax.annotation.Nullable;

public interface OnClickListener<Item extends IItem> {
    boolean onClick(@Nullable View view, IAdapter<Item> iAdapter, Item item, int i);
}
