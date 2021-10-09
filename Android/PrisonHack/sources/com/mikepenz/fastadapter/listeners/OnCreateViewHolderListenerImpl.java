package com.mikepenz.fastadapter.listeners;

import android.support.p003v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.utils.EventHookUtil;

public class OnCreateViewHolderListenerImpl<Item extends IItem> implements OnCreateViewHolderListener<Item> {
    public RecyclerView.ViewHolder onPreCreateViewHolder(FastAdapter<Item> fastAdapter, ViewGroup viewGroup, int i) {
        return fastAdapter.getTypeInstance(i).getViewHolder(viewGroup);
    }

    public RecyclerView.ViewHolder onPostCreateViewHolder(FastAdapter<Item> fastAdapter, RecyclerView.ViewHolder viewHolder) {
        EventHookUtil.bind(viewHolder, fastAdapter.getEventHooks());
        return viewHolder;
    }
}
