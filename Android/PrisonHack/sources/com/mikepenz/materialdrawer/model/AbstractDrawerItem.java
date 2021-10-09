package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.OnPostBindViewListener;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDrawerItem<T, VH extends RecyclerView.ViewHolder> implements IDrawerItem<T, VH>, Selectable<T>, Tagable<T> {
    protected boolean mEnabled = true;
    private boolean mExpanded = false;
    protected long mIdentifier = -1;
    public Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener = null;
    protected OnPostBindViewListener mOnPostBindViewListener = null;
    private IDrawerItem mParent;
    protected boolean mSelectable = true;
    protected boolean mSelected = false;
    protected boolean mSelectedBackgroundAnimated = true;
    protected List<IDrawerItem> mSubItems;
    protected Object mTag;

    public void attachToWindow(VH vh) {
    }

    public void detachFromWindow(VH vh) {
    }

    public boolean failedToRecycle(VH vh) {
        return false;
    }

    public abstract VH getViewHolder(View view);

    public boolean isAutoExpanding() {
        return true;
    }

    public void unbindView(VH vh) {
    }

    public T withIdentifier(long j) {
        this.mIdentifier = j;
        return this;
    }

    public long getIdentifier() {
        return this.mIdentifier;
    }

    public T withTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public Object getTag() {
        return this.mTag;
    }

    public T withEnabled(boolean z) {
        this.mEnabled = z;
        return this;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public T withSetSelected(boolean z) {
        this.mSelected = z;
        return this;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public T withSelectable(boolean z) {
        this.mSelectable = z;
        return this;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public T withSelectedBackgroundAnimated(boolean z) {
        this.mSelectedBackgroundAnimated = z;
        return this;
    }

    public boolean isSelectedBackgroundAnimated() {
        return this.mSelectedBackgroundAnimated;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.mOnDrawerItemClickListener;
    }

    public T withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public OnPostBindViewListener getOnPostBindViewListener() {
        return this.mOnPostBindViewListener;
    }

    public T withPostOnBindViewListener(OnPostBindViewListener onPostBindViewListener) {
        this.mOnPostBindViewListener = onPostBindViewListener;
        return this;
    }

    public void onPostBindView(IDrawerItem iDrawerItem, View view) {
        if (this.mOnPostBindViewListener != null) {
            this.mOnPostBindViewListener.onBindView(iDrawerItem, view);
        }
    }

    public IDrawerItem getParent() {
        return this.mParent;
    }

    public IDrawerItem withParent(IDrawerItem iDrawerItem) {
        this.mParent = iDrawerItem;
        return this;
    }

    public T withSubItems(List<IDrawerItem> list) {
        this.mSubItems = list;
        return this;
    }

    public T withSubItems(IDrawerItem... iDrawerItemArr) {
        if (this.mSubItems == null) {
            this.mSubItems = new ArrayList();
        }
        Collections.addAll(this.mSubItems, iDrawerItemArr);
        return this;
    }

    public List<IDrawerItem> getSubItems() {
        return this.mSubItems;
    }

    public T withIsExpanded(boolean z) {
        this.mExpanded = z;
        return this;
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public View generateView(Context context) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(LayoutInflater.from(context).inflate(getLayoutRes(), (ViewGroup) null, false));
        bindView(viewHolder, Collections.emptyList());
        return viewHolder.itemView;
    }

    public View generateView(Context context, ViewGroup viewGroup) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(LayoutInflater.from(context).inflate(getLayoutRes(), viewGroup, false));
        bindView(viewHolder, Collections.emptyList());
        return viewHolder.itemView;
    }

    @CallSuper
    public void bindView(VH vh, List<Object> list) {
        vh.itemView.setTag(this);
    }

    public VH getViewHolder(ViewGroup viewGroup) {
        return getViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutRes(), viewGroup, false));
    }

    public boolean equals(long j) {
        return j == this.mIdentifier;
    }

    public boolean equals(int i) {
        return ((long) i) == this.mIdentifier;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.mIdentifier == ((AbstractDrawerItem) obj).mIdentifier) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf(this.mIdentifier).hashCode();
    }
}
