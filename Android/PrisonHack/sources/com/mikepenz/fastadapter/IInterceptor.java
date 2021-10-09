package com.mikepenz.fastadapter;

import javax.annotation.Nullable;

public interface IInterceptor<Element, Item> {
    public static final IInterceptor<IItem, IItem> DEFAULT = new IInterceptor<IItem, IItem>() {
        public IItem intercept(IItem iItem) {
            return iItem;
        }
    };

    @Nullable
    Item intercept(Element element);
}
