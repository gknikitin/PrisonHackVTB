package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import java.util.List;
import javax.annotation.Nullable;

public interface IItemAdapter<Model, Item extends IItem> extends IAdapter<Item> {

    public interface Predicate<Item extends IItem> {
        boolean filter(Item item, @Nullable CharSequence charSequence);
    }

    IItemAdapter<Model, Item> add(int i, List<Model> list);

    IItemAdapter<Model, Item> add(int i, Model... modelArr);

    IItemAdapter<Model, Item> add(List<Model> list);

    IItemAdapter<Model, Item> add(Model... modelArr);

    IItemAdapter<Model, Item> addInternal(int i, List<Item> list);

    IItemAdapter<Model, Item> addInternal(List<Item> list);

    IItemAdapter<Model, Item> clear();

    IItemAdapter<Model, Item> remove(int i);

    IItemAdapter<Model, Item> removeRange(int i, int i2);

    IItemAdapter<Model, Item> set(int i, Model model);

    IItemAdapter<Model, Item> set(List<Model> list);

    IItemAdapter<Model, Item> setInternal(int i, Item item);

    IItemAdapter<Model, Item> setNewList(List<Model> list);
}
