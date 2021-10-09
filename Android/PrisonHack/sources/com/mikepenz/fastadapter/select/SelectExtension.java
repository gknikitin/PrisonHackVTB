package com.mikepenz.fastadapter.select;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.util.ArraySet;
import android.view.MotionEvent;
import android.view.View;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class SelectExtension<Item extends IItem> implements IAdapterExtension<Item> {
    protected static final String BUNDLE_SELECTIONS = "bundle_selections";
    private boolean mAllowDeselection = true;
    private FastAdapter<Item> mFastAdapter;
    private boolean mMultiSelect = false;
    private boolean mSelectOnLongClick = false;
    private boolean mSelectWithItemUpdate = false;
    private boolean mSelectable = false;
    private ISelectionListener<Item> mSelectionListener;

    public void notifyAdapterDataSetChanged() {
    }

    public void notifyAdapterItemMoved(int i, int i2) {
    }

    public void notifyAdapterItemRangeChanged(int i, int i2, @Nullable Object obj) {
    }

    public void notifyAdapterItemRangeInserted(int i, int i2) {
    }

    public void notifyAdapterItemRangeRemoved(int i, int i2) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent, int i, FastAdapter<Item> fastAdapter, Item item) {
        return false;
    }

    public void performFiltering(CharSequence charSequence) {
    }

    public void set(List<Item> list, boolean z) {
    }

    public SelectExtension<Item> withSelectWithItemUpdate(boolean z) {
        this.mSelectWithItemUpdate = z;
        return this;
    }

    public SelectExtension<Item> withMultiSelect(boolean z) {
        this.mMultiSelect = z;
        return this;
    }

    public SelectExtension<Item> withSelectOnLongClick(boolean z) {
        this.mSelectOnLongClick = z;
        return this;
    }

    public SelectExtension<Item> withAllowDeselection(boolean z) {
        this.mAllowDeselection = z;
        return this;
    }

    public SelectExtension<Item> withSelectable(boolean z) {
        this.mSelectable = z;
        return this;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public SelectExtension<Item> withSelectionListener(ISelectionListener<Item> iSelectionListener) {
        this.mSelectionListener = iSelectionListener;
        return this;
    }

    public IAdapterExtension<Item> init(FastAdapter<Item> fastAdapter) {
        this.mFastAdapter = fastAdapter;
        return null;
    }

    public void withSavedInstanceState(@Nullable Bundle bundle, String str) {
        if (bundle != null) {
            long[] longArray = bundle.getLongArray(BUNDLE_SELECTIONS + str);
            if (longArray != null) {
                for (long selectByIdentifier : longArray) {
                    selectByIdentifier(selectByIdentifier, false, true);
                }
            }
        }
    }

    public void saveInstanceState(@Nullable Bundle bundle, String str) {
        if (bundle != null) {
            Set<Item> selectedItems = this.mFastAdapter.getSelectedItems();
            long[] jArr = new long[selectedItems.size()];
            int i = 0;
            for (Item identifier : selectedItems) {
                jArr[i] = identifier.getIdentifier();
                i++;
            }
            bundle.putLongArray(BUNDLE_SELECTIONS + str, jArr);
        }
    }

    public boolean onClick(View view, int i, FastAdapter<Item> fastAdapter, Item item) {
        if (this.mSelectOnLongClick || !this.mSelectable) {
            return false;
        }
        handleSelection(view, item, i);
        return false;
    }

    public boolean onLongClick(View view, int i, FastAdapter<Item> fastAdapter, Item item) {
        if (!this.mSelectOnLongClick || !this.mSelectable) {
            return false;
        }
        handleSelection(view, item, i);
        return false;
    }

    public Set<Integer> getSelections() {
        ArraySet arraySet = new ArraySet();
        int itemCount = this.mFastAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (this.mFastAdapter.getItem(i).isSelected()) {
                arraySet.add(Integer.valueOf(i));
            }
        }
        return arraySet;
    }

    public Set<Item> getSelectedItems() {
        final ArraySet arraySet = new ArraySet();
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (!item.isSelected()) {
                    return false;
                }
                arraySet.add(item);
                return false;
            }
        }, false);
        return arraySet;
    }

    public void toggleSelection(int i) {
        if (this.mFastAdapter.getItem(i).isSelected()) {
            deselect(i);
        } else {
            select(i);
        }
    }

    private void handleSelection(@Nullable View view, Item item, int i) {
        if (item.isSelectable()) {
            if (!item.isSelected() || this.mAllowDeselection) {
                boolean isSelected = item.isSelected();
                if (this.mSelectWithItemUpdate || view == null) {
                    if (!this.mMultiSelect) {
                        deselect();
                    }
                    if (isSelected) {
                        deselect(i);
                    } else {
                        select(i);
                    }
                } else {
                    if (!this.mMultiSelect) {
                        Set selectedItems = getSelectedItems();
                        selectedItems.remove(item);
                        deselectByItems(selectedItems);
                    }
                    item.withSetSelected(!isSelected);
                    view.setSelected(!isSelected);
                    if (this.mSelectionListener != null) {
                        this.mSelectionListener.onSelectionChanged(item, !isSelected);
                    }
                }
            }
        }
    }

    public void select() {
        select(false);
    }

    public void select(final boolean z) {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                SelectExtension.this.select(iAdapter, item, -1, false, z);
                return false;
            }
        }, false);
        this.mFastAdapter.notifyDataSetChanged();
    }

    public void select(Item item, boolean z) {
        if (!z || item.isSelectable()) {
            item.withSetSelected(true);
            if (this.mSelectionListener != null) {
                this.mSelectionListener.onSelectionChanged(item, true);
            }
        }
    }

    public void select(Iterable<Integer> iterable) {
        for (Integer intValue : iterable) {
            select(intValue.intValue());
        }
    }

    public void select(int i) {
        select(i, false);
    }

    public void select(int i, boolean z) {
        select(i, z, false);
    }

    public void select(int i, boolean z, boolean z2) {
        FastAdapter.RelativeInfo<Item> relativeInfo = this.mFastAdapter.getRelativeInfo(i);
        if (relativeInfo != null && relativeInfo.item != null) {
            select(relativeInfo.adapter, relativeInfo.item, i, z, z2);
        }
    }

    public void select(IAdapter<Item> iAdapter, Item item, int i, boolean z, boolean z2) {
        if (!z2 || item.isSelectable()) {
            item.withSetSelected(true);
            this.mFastAdapter.notifyItemChanged(i);
            if (this.mSelectionListener != null) {
                this.mSelectionListener.onSelectionChanged(item, true);
            }
            if (this.mFastAdapter.getOnClickListener() != null && z) {
                this.mFastAdapter.getOnClickListener().onClick((View) null, iAdapter, item, i);
            }
        }
    }

    public void selectByIdentifier(long j, boolean z, boolean z2) {
        final long j2 = j;
        final boolean z3 = z;
        final boolean z4 = z2;
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (item.getIdentifier() != j2) {
                    return false;
                }
                SelectExtension.this.select(iAdapter, item, i2, z3, z4);
                return true;
            }
        }, true);
    }

    public void selectByIdentifiers(final Set<Long> set, final boolean z, final boolean z2) {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (!set.contains(Long.valueOf(item.getIdentifier()))) {
                    return false;
                }
                SelectExtension.this.select(iAdapter, item, i2, z, z2);
                return false;
            }
        }, false);
    }

    public void deselect() {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                SelectExtension.this.deselect(item);
                return false;
            }
        }, false);
        this.mFastAdapter.notifyDataSetChanged();
    }

    public void deselect(Item item) {
        deselect(item, -1, (Iterator<Integer>) null);
    }

    public void deselect(Iterable<Integer> iterable) {
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            deselect(it.next().intValue(), it);
        }
    }

    public void deselect(int i) {
        deselect(i, (Iterator<Integer>) null);
    }

    public void deselect(int i, @Nullable Iterator<Integer> it) {
        Item item = this.mFastAdapter.getItem(i);
        if (item != null) {
            deselect(item, i, it);
        }
    }

    public void deselect(Item item, int i, @Nullable Iterator<Integer> it) {
        item.withSetSelected(false);
        if (it != null) {
            it.remove();
        }
        if (i >= 0) {
            this.mFastAdapter.notifyItemChanged(i);
        }
        if (this.mSelectionListener != null) {
            this.mSelectionListener.onSelectionChanged(item, false);
        }
    }

    public void deselectByIdentifier(final long j) {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (item.getIdentifier() != j) {
                    return false;
                }
                SelectExtension.this.deselect(item, i2, (Iterator<Integer>) null);
                return true;
            }
        }, true);
    }

    public void deselectByIdentifiers(final Set<Long> set) {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (!set.contains(Long.valueOf(item.getIdentifier()))) {
                    return false;
                }
                SelectExtension.this.deselect(item, i2, (Iterator<Integer>) null);
                return false;
            }
        }, false);
    }

    public void deselectByItems(final Set<Item> set) {
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                if (!set.contains(item)) {
                    return false;
                }
                SelectExtension.this.deselect(item, i2, (Iterator<Integer>) null);
                return false;
            }
        }, false);
    }

    public List<Item> deleteAllSelectedItems() {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        this.mFastAdapter.recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                IExpandable iExpandable;
                if (!item.isSelected()) {
                    return false;
                }
                if ((item instanceof ISubItem) && (iExpandable = (IExpandable) ((ISubItem) item).getParent()) != null) {
                    iExpandable.getSubItems().remove(item);
                }
                if (i2 == -1) {
                    return false;
                }
                arrayList2.add(Integer.valueOf(i2));
                return false;
            }
        }, false);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            FastAdapter.RelativeInfo<Item> relativeInfo = this.mFastAdapter.getRelativeInfo(((Integer) arrayList2.get(size)).intValue());
            if (relativeInfo.item != null && relativeInfo.item.isSelected() && relativeInfo.adapter != null && (relativeInfo.adapter instanceof IItemAdapter)) {
                ((IItemAdapter) relativeInfo.adapter).remove(((Integer) arrayList2.get(size)).intValue());
            }
        }
        return arrayList;
    }
}
