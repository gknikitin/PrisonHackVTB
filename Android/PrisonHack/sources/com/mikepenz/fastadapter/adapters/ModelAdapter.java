package com.mikepenz.fastadapter.adapters;

import android.support.annotation.NonNull;
import com.mikepenz.fastadapter.AbstractAdapter;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IIdDistributor;
import com.mikepenz.fastadapter.IInterceptor;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.IItemList;
import com.mikepenz.fastadapter.IModelItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import com.mikepenz.fastadapter.utils.DefaultItemList;
import com.mikepenz.fastadapter.utils.DefaultItemListImpl;
import com.mikepenz.fastadapter.utils.Triple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

public class ModelAdapter<Model, Item extends IItem> extends AbstractAdapter<Item> implements IItemAdapter<Model, Item> {
    private IIdDistributor<Item> mIdDistributor;
    private IInterceptor<Model, Item> mInterceptor;
    private ItemFilter<Model, Item> mItemFilter;
    private final IItemList<Item> mItems;
    private IInterceptor<Item, Model> mReverseInterceptor;
    private boolean mUseIdDistributor;

    public ModelAdapter(IInterceptor<Model, Item> iInterceptor) {
        this(new DefaultItemListImpl(), iInterceptor);
    }

    public ModelAdapter(IItemList<Item> iItemList, IInterceptor<Model, Item> iInterceptor) {
        this.mUseIdDistributor = true;
        this.mItemFilter = new ItemFilter<>(this);
        this.mInterceptor = iInterceptor;
        this.mItems = iItemList;
    }

    public AbstractAdapter<Item> withFastAdapter(FastAdapter<Item> fastAdapter) {
        if (this.mItems instanceof DefaultItemList) {
            ((DefaultItemList) this.mItems).setFastAdapter(fastAdapter);
        }
        return super.withFastAdapter(fastAdapter);
    }

    public IItemList<Item> getItemList() {
        return this.mItems;
    }

    public static <Model, Item extends IItem> ModelAdapter<Model, Item> models(IInterceptor<Model, Item> iInterceptor) {
        return new ModelAdapter<>(iInterceptor);
    }

    public IInterceptor<Model, Item> getInterceptor() {
        return this.mInterceptor;
    }

    public ModelAdapter<Model, Item> withInterceptor(IInterceptor<Model, Item> iInterceptor) {
        this.mInterceptor = iInterceptor;
        return this;
    }

    public IInterceptor<Item, Model> getReverseInterceptor() {
        return this.mReverseInterceptor;
    }

    public ModelAdapter<Model, Item> withReverseInterceptor(IInterceptor<Item, Model> iInterceptor) {
        this.mReverseInterceptor = iInterceptor;
        return this;
    }

    @Nullable
    public Item intercept(Model model) {
        return (IItem) this.mInterceptor.intercept(model);
    }

    public List<Item> intercept(List<Model> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Model intercept : list) {
            IItem intercept2 = intercept(intercept);
            if (intercept2 != null) {
                arrayList.add(intercept2);
            }
        }
        return arrayList;
    }

    public ModelAdapter<Model, Item> withIdDistributor(IIdDistributor<Item> iIdDistributor) {
        this.mIdDistributor = iIdDistributor;
        return this;
    }

    public IIdDistributor<Item> getIdDistributor() {
        if (this.mIdDistributor == null) {
            return IIdDistributor.DEFAULT;
        }
        return this.mIdDistributor;
    }

    public ModelAdapter<Model, Item> withUseIdDistributor(boolean z) {
        this.mUseIdDistributor = z;
        return this;
    }

    public boolean isUseIdDistributor() {
        return this.mUseIdDistributor;
    }

    public ModelAdapter<Model, Item> withItemFilter(ItemFilter<Model, Item> itemFilter) {
        this.mItemFilter = itemFilter;
        return this;
    }

    public ItemFilter<Model, Item> getItemFilter() {
        return this.mItemFilter;
    }

    public void filter(@Nullable CharSequence charSequence) {
        this.mItemFilter.filter(charSequence);
    }

    public List<Model> getModels() {
        ArrayList arrayList = new ArrayList(this.mItems.size());
        for (Item item : this.mItems.getItems()) {
            if (this.mReverseInterceptor != null) {
                arrayList.add(this.mReverseInterceptor.intercept(item));
            } else if (item instanceof IModelItem) {
                arrayList.add(((IModelItem) item).getModel());
            } else {
                throw new RuntimeException("to get the list of models, the item either needs to implement `IModelItem` or you have to provide a `reverseInterceptor`");
            }
        }
        return arrayList;
    }

    public int getAdapterItemCount() {
        return this.mItems.size();
    }

    public List<Item> getAdapterItems() {
        return this.mItems.getItems();
    }

    public int getAdapterPosition(Item item) {
        return getAdapterPosition(item.getIdentifier());
    }

    public int getAdapterPosition(long j) {
        return this.mItems.getAdapterPosition(j);
    }

    public int getGlobalPosition(int i) {
        return i + getFastAdapter().getPreItemCountByOrder(getOrder());
    }

    public Item getAdapterItem(int i) {
        return (IItem) this.mItems.get(i);
    }

    public ModelAdapter<Model, Item> set(List<Model> list) {
        return set(list, true);
    }

    /* access modifiers changed from: protected */
    public ModelAdapter<Model, Item> set(List<Model> list, boolean z) {
        return setInternal(intercept(list), z, (IAdapterNotifier) null);
    }

    public ModelAdapter<Model, Item> set(List<Model> list, boolean z, @Nullable IAdapterNotifier iAdapterNotifier) {
        return setInternal(intercept(list), z, iAdapterNotifier);
    }

    public ModelAdapter<Model, Item> setInternal(List<Item> list, boolean z, @Nullable IAdapterNotifier iAdapterNotifier) {
        if (this.mUseIdDistributor) {
            getIdDistributor().checkIds(list);
        }
        if (z && getItemFilter().getConstraint() != null) {
            getItemFilter().performFiltering((CharSequence) null);
        }
        for (IAdapterExtension iAdapterExtension : getFastAdapter().getExtensions()) {
            iAdapterExtension.set(list, z);
        }
        mapPossibleTypes(list);
        this.mItems.set(list, getFastAdapter().getPreItemCountByOrder(getOrder()), iAdapterNotifier);
        return this;
    }

    public ModelAdapter<Model, Item> setNewList(List<Model> list) {
        return setNewList(list, false);
    }

    public ModelAdapter<Model, Item> setNewList(List<Model> list, boolean z) {
        CharSequence charSequence;
        List<Item> intercept = intercept(list);
        if (this.mUseIdDistributor) {
            getIdDistributor().checkIds(intercept);
        }
        if (getItemFilter().getConstraint() != null) {
            charSequence = getItemFilter().getConstraint();
            getItemFilter().performFiltering((CharSequence) null);
        } else {
            charSequence = null;
        }
        mapPossibleTypes(intercept);
        boolean z2 = charSequence != null && z;
        if (z2) {
            getItemFilter().publishResults(charSequence, getItemFilter().performFiltering(charSequence));
        }
        this.mItems.setNewList(intercept, !z2);
        return this;
    }

    public void remapMappedTypes() {
        getFastAdapter().clearTypeInstance();
        mapPossibleTypes(this.mItems.getItems());
    }

    @SafeVarargs
    public final ModelAdapter<Model, Item> add(Model... modelArr) {
        return add(Arrays.asList(modelArr));
    }

    public ModelAdapter<Model, Item> add(List<Model> list) {
        return addInternal((List) intercept(list));
    }

    public ModelAdapter<Model, Item> addInternal(List<Item> list) {
        if (this.mUseIdDistributor) {
            getIdDistributor().checkIds(list);
        }
        this.mItems.addAll(list, getFastAdapter().getPreItemCountByOrder(getOrder()));
        mapPossibleTypes(list);
        return this;
    }

    @SafeVarargs
    public final ModelAdapter<Model, Item> add(int i, Model... modelArr) {
        return add(i, Arrays.asList(modelArr));
    }

    public ModelAdapter<Model, Item> add(int i, List<Model> list) {
        return addInternal(i, (List) intercept(list));
    }

    public ModelAdapter<Model, Item> addInternal(int i, List<Item> list) {
        if (this.mUseIdDistributor) {
            getIdDistributor().checkIds(list);
        }
        if (list.size() > 0) {
            this.mItems.addAll(i, list, getFastAdapter().getPreItemCountByOrder(getOrder()));
            mapPossibleTypes(list);
        }
        return this;
    }

    public ModelAdapter<Model, Item> set(int i, Model model) {
        IItem intercept = intercept(model);
        if (intercept == null) {
            return this;
        }
        return setInternal(i, intercept);
    }

    public ModelAdapter<Model, Item> setInternal(int i, Item item) {
        if (this.mUseIdDistributor) {
            getIdDistributor().checkId(item);
        }
        this.mItems.set(i, item, getFastAdapter().getPreItemCount(i));
        this.mFastAdapter.registerTypeInstance(item);
        return this;
    }

    public ModelAdapter<Model, Item> move(int i, int i2) {
        this.mItems.move(i, i2, getFastAdapter().getPreItemCount(i));
        return this;
    }

    public ModelAdapter<Model, Item> remove(int i) {
        this.mItems.remove(i, getFastAdapter().getPreItemCount(i));
        return this;
    }

    public ModelAdapter<Model, Item> removeRange(int i, int i2) {
        this.mItems.removeRange(i, i2, getFastAdapter().getPreItemCount(i));
        return this;
    }

    public ModelAdapter<Model, Item> clear() {
        this.mItems.clear(getFastAdapter().getPreItemCountByOrder(getOrder()));
        return this;
    }

    public ModelAdapter<Model, Item> removeByIdentifier(final long j) {
        recursive(new AdapterPredicate<Item>() {
            public boolean apply(@NonNull IAdapter<Item> iAdapter, int i, Item item, int i2) {
                IExpandable iExpandable;
                if (j != item.getIdentifier()) {
                    return false;
                }
                if ((item instanceof ISubItem) && (iExpandable = (IExpandable) ((ISubItem) item).getParent()) != null) {
                    iExpandable.getSubItems().remove(item);
                }
                if (i2 == -1) {
                    return false;
                }
                ModelAdapter.this.remove(i2);
                return false;
            }
        }, false);
        return this;
    }

    @NonNull
    public Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> adapterPredicate, boolean z) {
        int preItemCountByOrder = getFastAdapter().getPreItemCountByOrder(getOrder());
        for (int i = 0; i < getAdapterItemCount(); i++) {
            int i2 = i + preItemCountByOrder;
            FastAdapter.RelativeInfo relativeInfo = getFastAdapter().getRelativeInfo(i2);
            Item item = relativeInfo.item;
            if (adapterPredicate.apply(relativeInfo.adapter, i2, item, i2) && z) {
                return new Triple<>(true, item, Integer.valueOf(i2));
            }
            if (item instanceof IExpandable) {
                Triple<Boolean, Item, Integer> recursiveSub = FastAdapter.recursiveSub(relativeInfo.adapter, i2, (IExpandable) item, adapterPredicate, z);
                if (((Boolean) recursiveSub.first).booleanValue() && z) {
                    return recursiveSub;
                }
            }
        }
        return new Triple<>(false, null, null);
    }
}
