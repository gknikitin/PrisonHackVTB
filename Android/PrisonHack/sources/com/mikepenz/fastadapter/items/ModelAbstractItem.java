package com.mikepenz.fastadapter.items;

import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IModelItem;
import com.mikepenz.fastadapter.items.ModelAbstractItem;

public abstract class ModelAbstractItem<Model, Item extends ModelAbstractItem<?, ?, ?>, VH extends RecyclerView.ViewHolder> extends AbstractItem<Item, VH> implements IModelItem<Model, Item, VH> {
    private Model mModel;

    public ModelAbstractItem(Model model) {
        this.mModel = model;
    }

    public Model getModel() {
        return this.mModel;
    }

    public ModelAbstractItem<?, ?, ?> withModel(Model model) {
        this.mModel = model;
        return this;
    }
}
