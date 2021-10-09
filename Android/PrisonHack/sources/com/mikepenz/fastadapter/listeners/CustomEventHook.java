package com.mikepenz.fastadapter.listeners;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.mikepenz.fastadapter.C0611R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import javax.annotation.Nullable;

public abstract class CustomEventHook<Item extends IItem> implements EventHook<Item> {
    public abstract void attachEvent(View view, RecyclerView.ViewHolder viewHolder);

    @Nullable
    public View onBind(RecyclerView.ViewHolder viewHolder) {
        return null;
    }

    @Nullable
    public List<View> onBindMany(RecyclerView.ViewHolder viewHolder) {
        return null;
    }

    @Nullable
    public FastAdapter<Item> getFastAdapter(RecyclerView.ViewHolder viewHolder) {
        Object tag = viewHolder.itemView.getTag(C0611R.C0614id.fastadapter_item_adapter);
        if (tag instanceof FastAdapter) {
            return (FastAdapter) tag;
        }
        return null;
    }

    @Nullable
    public Item getItem(RecyclerView.ViewHolder viewHolder) {
        int holderAdapterPosition;
        FastAdapter fastAdapter = getFastAdapter(viewHolder);
        if (fastAdapter == null || (holderAdapterPosition = fastAdapter.getHolderAdapterPosition(viewHolder)) == -1) {
            return null;
        }
        return fastAdapter.getItem(holderAdapterPosition);
    }
}
