package com.mikepenz.fastadapter.expandable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArraySet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import com.mikepenz.fastadapter.utils.AdapterUtil;
import java.util.ArrayList;
import java.util.List;

public class ExpandableExtension<Item extends IItem> implements IAdapterExtension<Item> {
    protected static final String BUNDLE_EXPANDED = "bundle_expanded";
    protected static final String BUNDLE_EXPANDED_SELECTIONS = "bundle_expanded_selections";
    private SparseIntArray mExpanded = new SparseIntArray();
    private FastAdapter<Item> mFastAdapter;
    private boolean mOnlyOneExpandedItem = false;

    public void notifyAdapterDataSetChanged() {
    }

    public void notifyAdapterItemRangeInserted(int i, int i2) {
    }

    public void notifyAdapterItemRangeRemoved(int i, int i2) {
    }

    public boolean onLongClick(View view, int i, FastAdapter<Item> fastAdapter, Item item) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent, int i, FastAdapter<Item> fastAdapter, Item item) {
        return false;
    }

    public ExpandableExtension<Item> init(FastAdapter<Item> fastAdapter) {
        this.mFastAdapter = fastAdapter;
        return this;
    }

    public ExpandableExtension<Item> withOnlyOneExpandedItem(boolean z) {
        this.mOnlyOneExpandedItem = z;
        return this;
    }

    public boolean isOnlyOneExpandedItem() {
        return this.mOnlyOneExpandedItem;
    }

    public void withSavedInstanceState(@Nullable Bundle bundle, String str) {
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(BUNDLE_EXPANDED + str);
            int itemCount = this.mFastAdapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                String valueOf = String.valueOf(this.mFastAdapter.getItem(i).getIdentifier());
                if (stringArrayList != null && stringArrayList.contains(valueOf)) {
                    expand(i);
                    itemCount = this.mFastAdapter.getItemCount();
                }
            }
        }
    }

    public void saveInstanceState(Bundle bundle, String str) {
        if (bundle != null) {
            ArrayList arrayList = new ArrayList();
            int itemCount = this.mFastAdapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                Item item = this.mFastAdapter.getItem(i);
                if ((item instanceof IExpandable) && ((IExpandable) item).isExpanded()) {
                    arrayList.add(String.valueOf(item.getIdentifier()));
                }
            }
            bundle.putStringArrayList(BUNDLE_EXPANDED + str, arrayList);
        }
    }

    public boolean onClick(@NonNull View view, int i, @NonNull FastAdapter<Item> fastAdapter, @NonNull Item item) {
        if (item instanceof IExpandable) {
            IExpandable iExpandable = (IExpandable) item;
            if (iExpandable.isAutoExpanding() && iExpandable.getSubItems() != null) {
                toggleExpandable(i);
            }
        }
        if (!this.mOnlyOneExpandedItem || !(item instanceof IExpandable)) {
            return false;
        }
        IExpandable iExpandable2 = (IExpandable) item;
        if (iExpandable2.getSubItems() == null || iExpandable2.getSubItems().size() <= 0) {
            return false;
        }
        int[] expandedItemsSameLevel = getExpandedItemsSameLevel(i);
        for (int length = expandedItemsSameLevel.length - 1; length >= 0; length--) {
            if (expandedItemsSameLevel[length] != i) {
                collapse(expandedItemsSameLevel[length], true);
            }
        }
        return false;
    }

    public void notifyAdapterItemMoved(int i, int i2) {
        collapse(i);
        collapse(i2);
    }

    public void notifyAdapterItemRangeChanged(int i, int i2, Object obj) {
        for (int i3 = i; i3 < i + i2; i3++) {
            Item item = this.mFastAdapter.getItem(i);
            if ((item instanceof IExpandable) && ((IExpandable) item).isExpanded()) {
                collapse(i);
            }
        }
    }

    public void set(List<Item> list, boolean z) {
        collapse(false);
    }

    public void performFiltering(CharSequence charSequence) {
        collapse(false);
    }

    public int notifyAdapterSubItemsChanged(int i, int i2) {
        Item item = this.mFastAdapter.getItem(i);
        if (item == null || !(item instanceof IExpandable)) {
            return 0;
        }
        IExpandable iExpandable = (IExpandable) item;
        IAdapter<Item> adapter = this.mFastAdapter.getAdapter(i);
        if (adapter != null && (adapter instanceof IItemAdapter)) {
            IItemAdapter iItemAdapter = (IItemAdapter) adapter;
            int i3 = i + 1;
            iItemAdapter.removeRange(i3, i2);
            iItemAdapter.add(i3, iExpandable.getSubItems());
        }
        return iExpandable.getSubItems().size();
    }

    public SparseIntArray getExpanded() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        int itemCount = this.mFastAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Item item = this.mFastAdapter.getItem(i);
            if (item instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) item;
                if (iExpandable.isExpanded()) {
                    sparseIntArray.put(i, iExpandable.getSubItems().size());
                }
            }
        }
        return sparseIntArray;
    }

    public int[] getExpandedItems() {
        ArrayList arrayList = new ArrayList();
        int itemCount = this.mFastAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Item item = this.mFastAdapter.getItem(i);
            if ((item instanceof IExpandable) && ((IExpandable) item).isExpanded()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    public int[] getExpandedItemsSameLevel(int i) {
        Item item = this.mFastAdapter.getItem(i);
        if (!(item instanceof ISubItem)) {
            return getExpandedItemsRootLevel(i);
        }
        IItem parent = ((ISubItem) item).getParent();
        if (!(parent instanceof IExpandable)) {
            return getExpandedItemsRootLevel(i);
        }
        ArrayList arrayList = new ArrayList();
        for (Item next : ((IExpandable) parent).getSubItems()) {
            if ((next instanceof IExpandable) && ((IExpandable) next).isExpanded() && next != item) {
                arrayList.add(Integer.valueOf(this.mFastAdapter.getPosition((IItem) next)));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    public int[] getExpandedItemsRootLevel(int i) {
        ArrayList arrayList = new ArrayList();
        Item item = this.mFastAdapter.getItem(i);
        int itemCount = this.mFastAdapter.getItemCount();
        int i2 = 0;
        while (i2 < itemCount) {
            Item item2 = this.mFastAdapter.getItem(i2);
            if (item2 instanceof ISubItem) {
                Item parent = ((ISubItem) item2).getParent();
                if (parent instanceof IExpandable) {
                    IExpandable iExpandable = (IExpandable) parent;
                    if (iExpandable.isExpanded()) {
                        i2 += iExpandable.getSubItems().size();
                        if (parent != item) {
                            arrayList.add(Integer.valueOf(this.mFastAdapter.getPosition(parent)));
                        }
                    }
                }
            }
            i2++;
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    public void toggleExpandable(int i) {
        Item item = this.mFastAdapter.getItem(i);
        if (!(item instanceof IExpandable) || !((IExpandable) item).isExpanded()) {
            expand(i);
        } else {
            collapse(i);
        }
    }

    public void collapse() {
        collapse(true);
    }

    public void collapse(boolean z) {
        int[] expandedItems = getExpandedItems();
        for (int length = expandedItems.length - 1; length >= 0; length--) {
            collapse(expandedItems[length], z);
        }
    }

    public void collapse(int i) {
        collapse(i, false);
    }

    public void collapse(int i, boolean z) {
        final int[] iArr = {0};
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            ArraySet<IItem> allowedParents = new ArraySet<>();

            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, @NonNull Item item, int i2) {
                IItem parent;
                if (i2 == -1) {
                    return false;
                }
                if (this.allowedParents.size() > 0 && (item instanceof ISubItem) && ((parent = ((ISubItem) item).getParent()) == null || !this.allowedParents.contains(parent))) {
                    return true;
                }
                if (item instanceof IExpandable) {
                    IExpandable iExpandable = (IExpandable) item;
                    if (iExpandable.isExpanded()) {
                        iExpandable.withIsExpanded(false);
                        if (iExpandable.getSubItems() != null) {
                            int[] iArr = iArr;
                            iArr[0] = iArr[0] + iExpandable.getSubItems().size();
                            this.allowedParents.add(item);
                        }
                    }
                }
                return false;
            }
        }, i, true);
        IAdapter<Item> adapter = this.mFastAdapter.getAdapter(i);
        if (adapter != null && (adapter instanceof IItemAdapter)) {
            ((IItemAdapter) adapter).removeRange(i + 1, iArr[0]);
        }
        if (z) {
            this.mFastAdapter.notifyItemChanged(i);
        }
    }

    public void expand() {
        expand(false);
    }

    public void expand(boolean z) {
        for (int itemCount = this.mFastAdapter.getItemCount() - 1; itemCount >= 0; itemCount--) {
            expand(itemCount, z);
        }
    }

    public void expand(int i) {
        expand(i, false);
    }

    public void expand(int i, boolean z) {
        Item item = this.mFastAdapter.getItem(i);
        if (item != null && (item instanceof IExpandable)) {
            IExpandable iExpandable = (IExpandable) item;
            if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null && iExpandable.getSubItems().size() > 0) {
                IAdapter<Item> adapter = this.mFastAdapter.getAdapter(i);
                if (adapter != null && (adapter instanceof IItemAdapter)) {
                    ((IItemAdapter) adapter).addInternal(i + 1, iExpandable.getSubItems());
                }
                iExpandable.withIsExpanded(true);
                if (z) {
                    this.mFastAdapter.notifyItemChanged(i);
                }
            }
        }
    }

    public int getExpandedItemsCount(int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            Item item = this.mFastAdapter.getItem(i);
            if (item instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) item;
                if (iExpandable.getSubItems() != null && iExpandable.isExpanded()) {
                    i3 += iExpandable.getSubItems().size();
                }
            }
            i++;
        }
        return i3;
    }

    public void deselect() {
        SelectExtension<Item> selectExtension = this.mFastAdapter.getSelectExtension();
        if (selectExtension != null) {
            for (Item deselect : AdapterUtil.getAllItems(this.mFastAdapter)) {
                selectExtension.deselect(deselect);
            }
            this.mFastAdapter.notifyDataSetChanged();
        }
    }

    public void select(boolean z) {
        SelectExtension<Item> selectExtension = this.mFastAdapter.getSelectExtension();
        if (selectExtension != null) {
            for (Item select : AdapterUtil.getAllItems(this.mFastAdapter)) {
                selectExtension.select(select, z);
            }
            this.mFastAdapter.notifyDataSetChanged();
        }
    }
}
