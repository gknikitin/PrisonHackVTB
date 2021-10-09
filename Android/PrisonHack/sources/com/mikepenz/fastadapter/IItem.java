package com.mikepenz.fastadapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public interface IItem<T, VH extends RecyclerView.ViewHolder> extends IIdentifyable<T> {
    void attachToWindow(VH vh);

    void bindView(VH vh, List<Object> list);

    void detachFromWindow(VH vh);

    boolean equals(int i);

    boolean failedToRecycle(VH vh);

    View generateView(Context context);

    View generateView(Context context, ViewGroup viewGroup);

    @LayoutRes
    int getLayoutRes();

    Object getTag();

    @IdRes
    int getType();

    VH getViewHolder(ViewGroup viewGroup);

    boolean isEnabled();

    boolean isSelectable();

    boolean isSelected();

    void unbindView(VH vh);

    T withEnabled(boolean z);

    T withSelectable(boolean z);

    T withSetSelected(boolean z);

    T withTag(Object obj);
}
