package com.mikepenz.fastadapter.items;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.IClickable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import java.util.Collections;
import java.util.List;

public abstract class AbstractItem<Item extends IItem & IClickable, VH extends RecyclerView.ViewHolder> implements IItem<Item, VH>, IClickable<Item> {
    protected boolean mEnabled = true;
    protected long mIdentifier = -1;
    protected OnClickListener<Item> mOnItemClickListener;
    protected OnClickListener<Item> mOnItemPreClickListener;
    protected boolean mSelectable = true;
    protected boolean mSelected = false;
    protected Object mTag;

    public void attachToWindow(VH vh) {
    }

    public void detachFromWindow(VH vh) {
    }

    public boolean failedToRecycle(VH vh) {
        return false;
    }

    @NonNull
    public abstract VH getViewHolder(View view);

    public void unbindView(VH vh) {
    }

    public Item withIdentifier(long j) {
        this.mIdentifier = j;
        return this;
    }

    public long getIdentifier() {
        return this.mIdentifier;
    }

    public Item withTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public Object getTag() {
        return this.mTag;
    }

    public Item withEnabled(boolean z) {
        this.mEnabled = z;
        return this;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public Item withSetSelected(boolean z) {
        this.mSelected = z;
        return this;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public Item withSelectable(boolean z) {
        this.mSelectable = z;
        return this;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public Item withOnItemPreClickListener(OnClickListener<Item> onClickListener) {
        this.mOnItemPreClickListener = onClickListener;
        return this;
    }

    public OnClickListener<Item> getOnPreItemClickListener() {
        return this.mOnItemPreClickListener;
    }

    public Item withOnItemClickListener(OnClickListener<Item> onClickListener) {
        this.mOnItemClickListener = onClickListener;
        return this;
    }

    public OnClickListener<Item> getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    @CallSuper
    public void bindView(VH vh, List<Object> list) {
        vh.itemView.setSelected(isSelected());
    }

    public View createView(Context context, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(getLayoutRes(), viewGroup, false);
    }

    public View generateView(Context context) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(createView(context, (ViewGroup) null));
        bindView(viewHolder, Collections.EMPTY_LIST);
        return viewHolder.itemView;
    }

    public View generateView(Context context, ViewGroup viewGroup) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(createView(context, viewGroup));
        bindView(viewHolder, Collections.EMPTY_LIST);
        return viewHolder.itemView;
    }

    public VH getViewHolder(ViewGroup viewGroup) {
        return getViewHolder(createView(viewGroup.getContext(), viewGroup));
    }

    public boolean equals(int i) {
        return ((long) i) == getIdentifier();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && getIdentifier() == ((AbstractItem) obj).getIdentifier()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf(getIdentifier()).hashCode();
    }
}
