package com.mikepenz.fastadapter.listeners;

import android.support.p003v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import javax.annotation.Nullable;

public abstract class TouchEventHook<Item extends IItem> implements EventHook<Item> {
    @Nullable
    public View onBind(RecyclerView.ViewHolder viewHolder) {
        return null;
    }

    @Nullable
    public List<View> onBindMany(RecyclerView.ViewHolder viewHolder) {
        return null;
    }

    public abstract boolean onTouch(View view, MotionEvent motionEvent, int i, FastAdapter<Item> fastAdapter, Item item);
}
