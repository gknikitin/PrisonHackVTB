package com.mikepenz.fastadapter.listeners;

import android.support.p003v7.widget.RecyclerView;
import java.util.List;

public interface OnBindViewHolderListener {
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list);

    boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder, int i);

    void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, int i);

    void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder, int i);

    void unBindViewHolder(RecyclerView.ViewHolder viewHolder, int i);
}
