package com.mikepenz.fastadapter.expandable.items;

import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.items.ModelAbstractItem;
import java.util.List;

public abstract class ModelAbstractExpandableItem<Model, Parent extends ModelAbstractItem<Model, Parent, VH> & IExpandable & ISubItem, VH extends RecyclerView.ViewHolder, SubItem extends IItem & ISubItem> extends ModelAbstractItem<Model, Parent, VH> implements IExpandable<ModelAbstractExpandableItem, SubItem>, ISubItem<ModelAbstractExpandableItem, Parent> {
    private boolean mExpanded = false;
    private Parent mParent;
    private List<SubItem> mSubItems;

    public boolean isAutoExpanding() {
        return true;
    }

    public ModelAbstractExpandableItem(Model model) {
        super(model);
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public ModelAbstractExpandableItem<Model, Parent, VH, SubItem> withIsExpanded(boolean z) {
        this.mExpanded = z;
        return this;
    }

    public List<SubItem> getSubItems() {
        return this.mSubItems;
    }

    public ModelAbstractExpandableItem<Model, Parent, VH, SubItem> withSubItems(List<SubItem> list) {
        this.mSubItems = list;
        for (SubItem subitem : list) {
            ((ISubItem) subitem).withParent(this);
        }
        return this;
    }

    public Parent getParent() {
        return this.mParent;
    }

    public ModelAbstractExpandableItem<Model, Parent, VH, SubItem> withParent(Parent parent) {
        this.mParent = parent;
        return this;
    }

    public boolean isSelectable() {
        return getSubItems() == null;
    }
}
