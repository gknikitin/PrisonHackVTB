package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.EventHook;
import java.util.List;

public interface IHookable<Item extends IItem> {
    List<EventHook<Item>> getEventHooks();
}
