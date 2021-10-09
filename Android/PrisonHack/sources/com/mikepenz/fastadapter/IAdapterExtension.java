package com.mikepenz.fastadapter;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import javax.annotation.Nullable;

public interface IAdapterExtension<Item extends IItem> {
    IAdapterExtension<Item> init(FastAdapter<Item> fastAdapter);

    void notifyAdapterDataSetChanged();

    void notifyAdapterItemMoved(int i, int i2);

    void notifyAdapterItemRangeChanged(int i, int i2, @Nullable Object obj);

    void notifyAdapterItemRangeInserted(int i, int i2);

    void notifyAdapterItemRangeRemoved(int i, int i2);

    boolean onClick(View view, int i, FastAdapter<Item> fastAdapter, Item item);

    boolean onLongClick(View view, int i, FastAdapter<Item> fastAdapter, Item item);

    boolean onTouch(View view, MotionEvent motionEvent, int i, FastAdapter<Item> fastAdapter, Item item);

    void performFiltering(@Nullable CharSequence charSequence);

    void saveInstanceState(@Nullable Bundle bundle, String str);

    void set(List<Item> list, boolean z);

    void withSavedInstanceState(@Nullable Bundle bundle, String str);
}
