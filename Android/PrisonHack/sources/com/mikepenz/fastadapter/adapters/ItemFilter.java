package com.mikepenz.fastadapter.adapters;

import android.widget.Filter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.listeners.ItemFilterListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class ItemFilter<Model, Item extends IItem> extends Filter {
    private CharSequence mConstraint;
    private IItemAdapter.Predicate<Item> mFilterPredicate;
    private ModelAdapter<?, Item> mItemAdapter;
    protected ItemFilterListener<Item> mItemFilterListener;
    private List<Item> mOriginalItems;

    public ItemFilter(ModelAdapter<?, Item> modelAdapter) {
        this.mItemAdapter = modelAdapter;
    }

    public ItemFilter<Model, Item> withItemFilterListener(ItemFilterListener<Item> itemFilterListener) {
        this.mItemFilterListener = itemFilterListener;
        return this;
    }

    public ItemFilter<Model, Item> withFilterPredicate(IItemAdapter.Predicate<Item> predicate) {
        this.mFilterPredicate = predicate;
        return this;
    }

    public Filter.FilterResults performFiltering(@Nullable CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (this.mOriginalItems == null && (charSequence == null || charSequence.length() == 0)) {
            return filterResults;
        }
        for (IAdapterExtension<Item> performFiltering : this.mItemAdapter.getFastAdapter().getExtensions()) {
            performFiltering.performFiltering(charSequence);
        }
        this.mConstraint = charSequence;
        if (this.mOriginalItems == null) {
            this.mOriginalItems = new ArrayList(this.mItemAdapter.getAdapterItems());
        }
        if (charSequence == null || charSequence.length() == 0) {
            filterResults.values = this.mOriginalItems;
            filterResults.count = this.mOriginalItems.size();
            this.mOriginalItems = null;
            if (this.mItemFilterListener != null) {
                this.mItemFilterListener.onReset();
            }
        } else {
            List<Item> arrayList = new ArrayList<>();
            if (this.mFilterPredicate != null) {
                for (Item item : this.mOriginalItems) {
                    if (this.mFilterPredicate.filter(item, charSequence)) {
                        arrayList.add(item);
                    }
                }
            } else {
                arrayList = this.mItemAdapter.getAdapterItems();
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
        }
        return filterResults;
    }

    public CharSequence getConstraint() {
        return this.mConstraint;
    }

    /* access modifiers changed from: protected */
    public void publishResults(@Nullable CharSequence charSequence, Filter.FilterResults filterResults) {
        if (filterResults.values != null) {
            this.mItemAdapter.setInternal((List) filterResults.values, false, (IAdapterNotifier) null);
        }
        if (this.mItemFilterListener != null && this.mOriginalItems != null) {
            this.mItemFilterListener.itemsFiltered(charSequence, (List) filterResults.values);
        }
    }

    public Set<Integer> getSelections() {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.getFastAdapter().getSelections();
        }
        HashSet hashSet = new HashSet();
        int preItemCountByOrder = this.mItemAdapter.getFastAdapter().getPreItemCountByOrder(this.mItemAdapter.getOrder());
        int size = this.mOriginalItems.size();
        for (int i = 0; i < size; i++) {
            if (((IItem) this.mOriginalItems.get(i)).isSelected()) {
                hashSet.add(Integer.valueOf(i + preItemCountByOrder));
            }
        }
        return hashSet;
    }

    public Set<Item> getSelectedItems() {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.getFastAdapter().getSelectedItems();
        }
        HashSet hashSet = new HashSet();
        int size = this.mOriginalItems.size();
        for (int i = 0; i < size; i++) {
            IItem iItem = (IItem) this.mOriginalItems.get(i);
            if (iItem.isSelected()) {
                hashSet.add(iItem);
            }
        }
        return hashSet;
    }

    public int getAdapterPosition(Item item) {
        return getAdapterPosition(item.getIdentifier());
    }

    public int getAdapterPosition(long j) {
        int size = this.mOriginalItems.size();
        for (int i = 0; i < size; i++) {
            if (((IItem) this.mOriginalItems.get(i)).getIdentifier() == j) {
                return i;
            }
        }
        return -1;
    }

    @SafeVarargs
    public final ModelAdapter<?, Item> add(Item... itemArr) {
        return add(Arrays.asList(itemArr));
    }

    public ModelAdapter<?, Item> add(List<Item> list) {
        if (this.mOriginalItems == null || list.size() <= 0) {
            return this.mItemAdapter.addInternal((List) list);
        }
        if (this.mItemAdapter.isUseIdDistributor()) {
            this.mItemAdapter.getIdDistributor().checkIds(list);
        }
        this.mOriginalItems.addAll(list);
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }

    @SafeVarargs
    public final ModelAdapter<?, Item> add(int i, Item... itemArr) {
        return add(i, Arrays.asList(itemArr));
    }

    public ModelAdapter<?, Item> add(int i, List<Item> list) {
        if (this.mOriginalItems == null || list.size() <= 0) {
            return this.mItemAdapter.addInternal(i, (List) list);
        }
        if (this.mItemAdapter.isUseIdDistributor()) {
            this.mItemAdapter.getIdDistributor().checkIds(list);
        }
        this.mOriginalItems.addAll(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(i)) - this.mItemAdapter.getFastAdapter().getPreItemCount(i), list);
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }

    public ModelAdapter<?, Item> set(int i, Item item) {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.setInternal(i, (IItem) item);
        }
        if (this.mItemAdapter.isUseIdDistributor()) {
            this.mItemAdapter.getIdDistributor().checkId(item);
        }
        this.mOriginalItems.set(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(i)) - this.mItemAdapter.getFastAdapter().getPreItemCount(i), item);
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }

    public ModelAdapter<?, Item> move(int i, int i2) {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.move(i, i2);
        }
        int preItemCount = this.mItemAdapter.getFastAdapter().getPreItemCount(i);
        int adapterPosition = getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(i));
        int adapterPosition2 = getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(i2));
        int i3 = adapterPosition - preItemCount;
        this.mOriginalItems.remove(i3);
        this.mOriginalItems.add(adapterPosition2 - preItemCount, (IItem) this.mOriginalItems.get(i3));
        performFiltering(this.mConstraint);
        return this.mItemAdapter;
    }

    public ModelAdapter<?, Item> remove(int i) {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.remove(i);
        }
        this.mOriginalItems.remove(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(i)) - this.mItemAdapter.getFastAdapter().getPreItemCount(i));
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }

    public ModelAdapter<?, Item> removeRange(int i, int i2) {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.removeRange(i, i2);
        }
        int size = this.mOriginalItems.size();
        int preItemCount = this.mItemAdapter.getFastAdapter().getPreItemCount(i);
        int min = Math.min(i2, (size - i) + preItemCount);
        for (int i3 = 0; i3 < min; i3++) {
            this.mOriginalItems.remove(i - preItemCount);
        }
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }

    public ModelAdapter<?, Item> clear() {
        if (this.mOriginalItems == null) {
            return this.mItemAdapter.clear();
        }
        this.mOriginalItems.clear();
        publishResults(this.mConstraint, performFiltering(this.mConstraint));
        return this.mItemAdapter;
    }
}
