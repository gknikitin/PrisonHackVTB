package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.List;

public class AdapterUtil {
    public static <Item extends IItem> void restoreSubItemSelectionStatesForAlternativeStateManagement(Item item, List<String> list) {
        if (item instanceof IExpandable) {
            IExpandable iExpandable = (IExpandable) item;
            if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null) {
                List subItems = iExpandable.getSubItems();
                int size = subItems.size();
                for (int i = 0; i < size; i++) {
                    IItem iItem = (IItem) subItems.get(i);
                    String valueOf = String.valueOf(iItem.getIdentifier());
                    if (list != null && list.contains(valueOf)) {
                        iItem.withSetSelected(true);
                    }
                    restoreSubItemSelectionStatesForAlternativeStateManagement(iItem, list);
                }
            }
        }
    }

    public static <Item extends IItem> void findSubItemSelections(Item item, List<String> list) {
        if (item instanceof IExpandable) {
            IExpandable iExpandable = (IExpandable) item;
            if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null) {
                List subItems = iExpandable.getSubItems();
                int size = subItems.size();
                for (int i = 0; i < size; i++) {
                    IItem iItem = (IItem) subItems.get(i);
                    String valueOf = String.valueOf(iItem.getIdentifier());
                    if (iItem.isSelected()) {
                        list.add(valueOf);
                    }
                    findSubItemSelections(iItem, list);
                }
            }
        }
    }

    public static <Item extends IItem> List<Item> getAllItems(FastAdapter<Item> fastAdapter) {
        int itemCount = fastAdapter.getItemCount();
        ArrayList arrayList = new ArrayList(itemCount);
        for (int i = 0; i < itemCount; i++) {
            Item item = fastAdapter.getItem(i);
            arrayList.add(item);
            addAllSubItems(item, arrayList);
        }
        return arrayList;
    }

    public static <Item extends IItem> void addAllSubItems(Item item, List<Item> list) {
        if (item instanceof IExpandable) {
            IExpandable iExpandable = (IExpandable) item;
            if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null) {
                List subItems = iExpandable.getSubItems();
                int size = subItems.size();
                for (int i = 0; i < size; i++) {
                    IItem iItem = (IItem) subItems.get(i);
                    list.add(iItem);
                    addAllSubItems(iItem, list);
                }
            }
        }
    }
}
