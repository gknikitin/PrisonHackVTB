package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;

public interface ISubItem<T, S extends IItem & IExpandable> {
    S getParent();

    T withParent(S s);
}
