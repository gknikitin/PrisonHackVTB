package com.mikepenz.fastadapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.util.Pair;
import android.support.p003v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.LongClickEventHook;
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListener;
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListenerImpl;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.mikepenz.fastadapter.listeners.OnCreateViewHolderListener;
import com.mikepenz.fastadapter.listeners.OnCreateViewHolderListenerImpl;
import com.mikepenz.fastadapter.listeners.OnLongClickListener;
import com.mikepenz.fastadapter.listeners.OnTouchListener;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import com.mikepenz.fastadapter.utils.DefaultTypeInstanceCache;
import com.mikepenz.fastadapter.utils.EventHookUtil;
import com.mikepenz.fastadapter.utils.Triple;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class FastAdapter<Item extends IItem> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "FastAdapter";
    private List<EventHook<Item>> eventHooks;
    private ClickEventHook<Item> fastAdapterViewClickListener = new ClickEventHook<Item>() {
        public void onClick(View view, int i, FastAdapter<Item> fastAdapter, Item item) {
            IAdapter<Item> adapter = fastAdapter.getAdapter(i);
            if (adapter != null && item != null && item.isEnabled()) {
                boolean z = false;
                boolean z2 = item instanceof IClickable;
                if (z2) {
                    IClickable iClickable = (IClickable) item;
                    if (iClickable.getOnPreItemClickListener() != null) {
                        z = iClickable.getOnPreItemClickListener().onClick(view, adapter, item, i);
                    }
                }
                if (!z && fastAdapter.mOnPreClickListener != null) {
                    z = fastAdapter.mOnPreClickListener.onClick(view, adapter, item, i);
                }
                for (IAdapterExtension iAdapterExtension : fastAdapter.mExtensions.values()) {
                    if (z) {
                        break;
                    }
                    z = iAdapterExtension.onClick(view, i, fastAdapter, item);
                }
                if (!z && z2) {
                    IClickable iClickable2 = (IClickable) item;
                    if (iClickable2.getOnItemClickListener() != null) {
                        z = iClickable2.getOnItemClickListener().onClick(view, adapter, item, i);
                    }
                }
                if (!z && fastAdapter.mOnClickListener != null) {
                    fastAdapter.mOnClickListener.onClick(view, adapter, item, i);
                }
            }
        }
    };
    private LongClickEventHook<Item> fastAdapterViewLongClickListener = new LongClickEventHook<Item>() {
        public boolean onLongClick(View view, int i, FastAdapter<Item> fastAdapter, Item item) {
            IAdapter<Item> adapter = fastAdapter.getAdapter(i);
            boolean z = false;
            if (adapter == null || item == null || !item.isEnabled()) {
                return false;
            }
            if (fastAdapter.mOnPreLongClickListener != null) {
                z = fastAdapter.mOnPreLongClickListener.onLongClick(view, adapter, item, i);
            }
            for (IAdapterExtension iAdapterExtension : fastAdapter.mExtensions.values()) {
                if (z) {
                    break;
                }
                z = iAdapterExtension.onLongClick(view, i, fastAdapter, item);
            }
            return (z || fastAdapter.mOnLongClickListener == null) ? z : fastAdapter.mOnLongClickListener.onLongClick(view, adapter, item, i);
        }
    };
    private TouchEventHook<Item> fastAdapterViewTouchListener = new TouchEventHook<Item>() {
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
            r5 = r13.getAdapter(r12);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r10, android.view.MotionEvent r11, int r12, com.mikepenz.fastadapter.FastAdapter<Item> r13, Item r14) {
            /*
                r9 = this;
                java.util.Map r0 = r13.mExtensions
                java.util.Collection r0 = r0.values()
                java.util.Iterator r0 = r0.iterator()
                r1 = 0
            L_0x000d:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0026
                java.lang.Object r2 = r0.next()
                r3 = r2
                com.mikepenz.fastadapter.IAdapterExtension r3 = (com.mikepenz.fastadapter.IAdapterExtension) r3
                if (r1 != 0) goto L_0x0026
                r4 = r10
                r5 = r11
                r6 = r12
                r7 = r13
                r8 = r14
                boolean r1 = r3.onTouch(r4, r5, r6, r7, r8)
                goto L_0x000d
            L_0x0026:
                com.mikepenz.fastadapter.listeners.OnTouchListener r0 = r13.mOnTouchListener
                if (r0 == 0) goto L_0x003f
                com.mikepenz.fastadapter.IAdapter r5 = r13.getAdapter(r12)
                if (r5 == 0) goto L_0x003f
                com.mikepenz.fastadapter.listeners.OnTouchListener r2 = r13.mOnTouchListener
                r3 = r10
                r4 = r11
                r6 = r14
                r7 = r12
                boolean r10 = r2.onTouch(r3, r4, r5, r6, r7)
                return r10
            L_0x003f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.FastAdapter.C06063.onTouch(android.view.View, android.view.MotionEvent, int, com.mikepenz.fastadapter.FastAdapter, com.mikepenz.fastadapter.IItem):boolean");
        }
    };
    private final SparseArray<IAdapter<Item>> mAdapterSizes = new SparseArray<>();
    private final ArrayList<IAdapter<Item>> mAdapters = new ArrayList<>();
    private boolean mAttachDefaultListeners = true;
    /* access modifiers changed from: private */
    public final Map<Class, IAdapterExtension<Item>> mExtensions = new ArrayMap();
    private int mGlobalSize = 0;
    private boolean mLegacyBindViewMode = false;
    private OnBindViewHolderListener mOnBindViewHolderListener = new OnBindViewHolderListenerImpl();
    /* access modifiers changed from: private */
    public OnClickListener<Item> mOnClickListener;
    private OnCreateViewHolderListener mOnCreateViewHolderListener = new OnCreateViewHolderListenerImpl();
    /* access modifiers changed from: private */
    public OnLongClickListener<Item> mOnLongClickListener;
    /* access modifiers changed from: private */
    public OnClickListener<Item> mOnPreClickListener;
    /* access modifiers changed from: private */
    public OnLongClickListener<Item> mOnPreLongClickListener;
    /* access modifiers changed from: private */
    public OnTouchListener<Item> mOnTouchListener;
    private SelectExtension<Item> mSelectExtension = new SelectExtension<>();
    private ITypeInstanceCache<Item> mTypeInstanceCache;
    private boolean mVerbose = false;

    public static class RelativeInfo<Item extends IItem> {
        public IAdapter<Item> adapter = null;
        public Item item = null;
        public int position = -1;
    }

    private static int floorIndex(SparseArray<?> sparseArray, int i) {
        int indexOfKey = sparseArray.indexOfKey(i);
        return indexOfKey < 0 ? (indexOfKey ^ -1) - 1 : indexOfKey;
    }

    public FastAdapter() {
        setHasStableIds(true);
    }

    public FastAdapter<Item> enableVerboseLog() {
        this.mVerbose = true;
        return this;
    }

    public void setTypeInstanceCache(ITypeInstanceCache<Item> iTypeInstanceCache) {
        this.mTypeInstanceCache = iTypeInstanceCache;
    }

    public ITypeInstanceCache<Item> getTypeInstanceCache() {
        if (this.mTypeInstanceCache == null) {
            this.mTypeInstanceCache = new DefaultTypeInstanceCache();
        }
        return this.mTypeInstanceCache;
    }

    public static <Item extends IItem, A extends IAdapter> FastAdapter<Item> with(A a) {
        FastAdapter<Item> fastAdapter = new FastAdapter<>();
        fastAdapter.addAdapter(0, a);
        return fastAdapter;
    }

    public static <Item extends IItem, A extends IAdapter> FastAdapter<Item> with(@Nullable Collection<A> collection) {
        return with(collection, (Collection) null);
    }

    public static <Item extends IItem, A extends IAdapter> FastAdapter<Item> with(@Nullable Collection<A> collection, @Nullable Collection<IAdapterExtension<Item>> collection2) {
        FastAdapter<Item> fastAdapter = new FastAdapter<>();
        if (collection == null) {
            fastAdapter.mAdapters.add(ItemAdapter.items());
        } else {
            for (A add : collection) {
                fastAdapter.mAdapters.add(add);
            }
        }
        for (int i = 0; i < fastAdapter.mAdapters.size(); i++) {
            fastAdapter.mAdapters.get(i).withFastAdapter(fastAdapter).setOrder(i);
        }
        fastAdapter.cacheSizes();
        if (collection2 != null) {
            for (IAdapterExtension<Item> addExtension : collection2) {
                fastAdapter.addExtension(addExtension);
            }
        }
        return fastAdapter;
    }

    public <A extends IAdapter<Item>> FastAdapter<Item> addAdapter(int i, A a) {
        this.mAdapters.add(i, a);
        for (int i2 = 0; i2 < this.mAdapters.size(); i2++) {
            this.mAdapters.get(i2).withFastAdapter(this).setOrder(i2);
        }
        cacheSizes();
        return this;
    }

    @Nullable
    public IAdapter<Item> adapter(int i) {
        if (this.mAdapters.size() <= i) {
            return null;
        }
        return this.mAdapters.get(i);
    }

    public <E extends IAdapterExtension<Item>> FastAdapter<Item> addExtension(E e) {
        if (this.mExtensions.containsKey(e.getClass())) {
            throw new IllegalStateException("The given extension was already registered with this FastAdapter instance");
        }
        this.mExtensions.put(e.getClass(), e);
        e.init(this);
        return this;
    }

    public Collection<IAdapterExtension<Item>> getExtensions() {
        return this.mExtensions.values();
    }

    @Nullable
    public <T extends IAdapterExtension<Item>> T getExtension(Class<? super T> cls) {
        return (IAdapterExtension) this.mExtensions.get(cls);
    }

    @Deprecated
    public FastAdapter<Item> withItemEvent(EventHook<Item> eventHook) {
        return withEventHook(eventHook);
    }

    public List<EventHook<Item>> getEventHooks() {
        return this.eventHooks;
    }

    public FastAdapter<Item> withEventHook(EventHook<Item> eventHook) {
        if (this.eventHooks == null) {
            this.eventHooks = new LinkedList();
        }
        this.eventHooks.add(eventHook);
        return this;
    }

    public FastAdapter<Item> withEventHooks(@Nullable Collection<? extends EventHook<Item>> collection) {
        if (collection == null) {
            return this;
        }
        if (this.eventHooks == null) {
            this.eventHooks = new LinkedList();
        }
        this.eventHooks.addAll(collection);
        return this;
    }

    public FastAdapter<Item> withOnClickListener(OnClickListener<Item> onClickListener) {
        this.mOnClickListener = onClickListener;
        return this;
    }

    public OnClickListener<Item> getOnClickListener() {
        return this.mOnClickListener;
    }

    public FastAdapter<Item> withOnPreClickListener(OnClickListener<Item> onClickListener) {
        this.mOnPreClickListener = onClickListener;
        return this;
    }

    public FastAdapter<Item> withOnLongClickListener(OnLongClickListener<Item> onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        return this;
    }

    public FastAdapter<Item> withOnPreLongClickListener(OnLongClickListener<Item> onLongClickListener) {
        this.mOnPreLongClickListener = onLongClickListener;
        return this;
    }

    public FastAdapter<Item> withOnTouchListener(OnTouchListener<Item> onTouchListener) {
        this.mOnTouchListener = onTouchListener;
        return this;
    }

    public FastAdapter<Item> withOnCreateViewHolderListener(OnCreateViewHolderListener onCreateViewHolderListener) {
        this.mOnCreateViewHolderListener = onCreateViewHolderListener;
        return this;
    }

    public FastAdapter<Item> withOnBindViewHolderListener(OnBindViewHolderListener onBindViewHolderListener) {
        this.mOnBindViewHolderListener = onBindViewHolderListener;
        return this;
    }

    public FastAdapter<Item> withSelectWithItemUpdate(boolean z) {
        this.mSelectExtension.withSelectWithItemUpdate(z);
        return this;
    }

    public FastAdapter<Item> withMultiSelect(boolean z) {
        this.mSelectExtension.withMultiSelect(z);
        return this;
    }

    public FastAdapter<Item> withSelectOnLongClick(boolean z) {
        this.mSelectExtension.withSelectOnLongClick(z);
        return this;
    }

    public FastAdapter<Item> withAllowDeselection(boolean z) {
        this.mSelectExtension.withAllowDeselection(z);
        return this;
    }

    public FastAdapter<Item> withSelectable(boolean z) {
        if (z) {
            addExtension(this.mSelectExtension);
        } else {
            this.mExtensions.remove(this.mSelectExtension.getClass());
        }
        this.mSelectExtension.withSelectable(z);
        return this;
    }

    public FastAdapter<Item> withLegacyBindViewMode(boolean z) {
        this.mLegacyBindViewMode = z;
        return this;
    }

    public FastAdapter<Item> withAttachDefaultListeners(boolean z) {
        this.mAttachDefaultListeners = z;
        return this;
    }

    public FastAdapter<Item> withSelectionListener(ISelectionListener<Item> iSelectionListener) {
        this.mSelectExtension.withSelectionListener(iSelectionListener);
        return this;
    }

    public boolean isSelectable() {
        return this.mSelectExtension.isSelectable();
    }

    public FastAdapter<Item> withSavedInstanceState(Bundle bundle) {
        return withSavedInstanceState(bundle, "");
    }

    public FastAdapter<Item> withSavedInstanceState(@Nullable Bundle bundle, String str) {
        for (IAdapterExtension<Item> withSavedInstanceState : this.mExtensions.values()) {
            withSavedInstanceState.withSavedInstanceState(bundle, str);
        }
        return this;
    }

    public void registerTypeInstance(Item item) {
        if (getTypeInstanceCache().register(item) && (item instanceof IHookable)) {
            withEventHooks(((IHookable) item).getEventHooks());
        }
    }

    public Item getTypeInstance(int i) {
        return getTypeInstanceCache().get(i);
    }

    public void clearTypeInstance() {
        getTypeInstanceCache().clear();
    }

    public int getHolderAdapterPosition(@NonNull RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mVerbose) {
            Log.v(TAG, "onCreateViewHolder: " + i);
        }
        RecyclerView.ViewHolder onPreCreateViewHolder = this.mOnCreateViewHolderListener.onPreCreateViewHolder(this, viewGroup, i);
        onPreCreateViewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item_adapter, this);
        if (this.mAttachDefaultListeners) {
            EventHookUtil.attachToView(this.fastAdapterViewClickListener, onPreCreateViewHolder, onPreCreateViewHolder.itemView);
            EventHookUtil.attachToView(this.fastAdapterViewLongClickListener, onPreCreateViewHolder, onPreCreateViewHolder.itemView);
            EventHookUtil.attachToView(this.fastAdapterViewTouchListener, onPreCreateViewHolder, onPreCreateViewHolder.itemView);
        }
        return this.mOnCreateViewHolderListener.onPostCreateViewHolder(this, onPreCreateViewHolder);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.mLegacyBindViewMode) {
            if (this.mVerbose) {
                Log.v(TAG, "onBindViewHolderLegacy: " + i + "/" + viewHolder.getItemViewType() + " isLegacy: true");
            }
            viewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item_adapter, this);
            this.mOnBindViewHolderListener.onBindViewHolder(viewHolder, i, Collections.EMPTY_LIST);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (!this.mLegacyBindViewMode) {
            if (this.mVerbose) {
                Log.v(TAG, "onBindViewHolder: " + i + "/" + viewHolder.getItemViewType() + " isLegacy: false");
            }
            viewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item_adapter, this);
            this.mOnBindViewHolderListener.onBindViewHolder(viewHolder, i, list);
        }
        super.onBindViewHolder(viewHolder, i, list);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (this.mVerbose) {
            Log.v(TAG, "onViewRecycled: " + viewHolder.getItemViewType());
        }
        super.onViewRecycled(viewHolder);
        this.mOnBindViewHolderListener.unBindViewHolder(viewHolder, viewHolder.getAdapterPosition());
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (this.mVerbose) {
            Log.v(TAG, "onViewDetachedFromWindow: " + viewHolder.getItemViewType());
        }
        super.onViewDetachedFromWindow(viewHolder);
        this.mOnBindViewHolderListener.onViewDetachedFromWindow(viewHolder, viewHolder.getAdapterPosition());
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (this.mVerbose) {
            Log.v(TAG, "onViewAttachedToWindow: " + viewHolder.getItemViewType());
        }
        super.onViewAttachedToWindow(viewHolder);
        this.mOnBindViewHolderListener.onViewAttachedToWindow(viewHolder, viewHolder.getAdapterPosition());
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        if (this.mVerbose) {
            Log.v(TAG, "onFailedToRecycleView: " + viewHolder.getItemViewType());
        }
        return this.mOnBindViewHolderListener.onFailedToRecycleView(viewHolder, viewHolder.getAdapterPosition()) || super.onFailedToRecycleView(viewHolder);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.mVerbose) {
            Log.v(TAG, "onAttachedToRecyclerView");
        }
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (this.mVerbose) {
            Log.v(TAG, "onDetachedFromRecyclerView");
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public int getPosition(Item item) {
        if (item.getIdentifier() != -1) {
            return getPosition(item.getIdentifier());
        }
        Log.e(TAG, "You have to define an identifier for your item to retrieve the position via this method");
        return -1;
    }

    public int getPosition(long j) {
        Iterator<IAdapter<Item>> it = this.mAdapters.iterator();
        int i = 0;
        while (it.hasNext()) {
            IAdapter next = it.next();
            if (next.getOrder() >= 0) {
                int adapterPosition = next.getAdapterPosition(j);
                if (adapterPosition != -1) {
                    return i + adapterPosition;
                }
                i = next.getAdapterItemCount();
            }
        }
        return -1;
    }

    public Item getItem(int i) {
        if (i < 0 || i >= this.mGlobalSize) {
            return null;
        }
        int floorIndex = floorIndex(this.mAdapterSizes, i);
        return this.mAdapterSizes.valueAt(floorIndex).getAdapterItem(i - this.mAdapterSizes.keyAt(floorIndex));
    }

    public Pair<Item, Integer> getItemById(final long j) {
        if (j == -1) {
            return null;
        }
        Triple recursive = recursive(new AdapterPredicate() {
            public boolean apply(@NonNull IAdapter iAdapter, int i, @NonNull IItem iItem, int i2) {
                return iItem.getIdentifier() == j;
            }
        }, true);
        if (recursive.second == null) {
            return null;
        }
        return new Pair<>(recursive.second, recursive.third);
    }

    public RelativeInfo<Item> getRelativeInfo(int i) {
        if (i < 0 || i >= getItemCount()) {
            return new RelativeInfo<>();
        }
        RelativeInfo<Item> relativeInfo = new RelativeInfo<>();
        int floorIndex = floorIndex(this.mAdapterSizes, i);
        if (floorIndex != -1) {
            relativeInfo.item = this.mAdapterSizes.valueAt(floorIndex).getAdapterItem(i - this.mAdapterSizes.keyAt(floorIndex));
            relativeInfo.adapter = this.mAdapterSizes.valueAt(floorIndex);
            relativeInfo.position = i;
        }
        return relativeInfo;
    }

    @Nullable
    public IAdapter<Item> getAdapter(int i) {
        if (i < 0 || i >= this.mGlobalSize) {
            return null;
        }
        if (this.mVerbose) {
            Log.v(TAG, "getAdapter");
        }
        return this.mAdapterSizes.valueAt(floorIndex(this.mAdapterSizes, i));
    }

    public int getItemViewType(int i) {
        return getItem(i).getType();
    }

    public long getItemId(int i) {
        return getItem(i).getIdentifier();
    }

    public int getItemCount() {
        return this.mGlobalSize;
    }

    public int getPreItemCountByOrder(int i) {
        if (this.mGlobalSize == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < Math.min(i, this.mAdapters.size()); i3++) {
            i2 += this.mAdapters.get(i3).getAdapterItemCount();
        }
        return i2;
    }

    public int getPreItemCount(int i) {
        if (this.mGlobalSize == 0) {
            return 0;
        }
        return this.mAdapterSizes.keyAt(floorIndex(this.mAdapterSizes, i));
    }

    public Bundle saveInstanceState(@Nullable Bundle bundle) {
        return saveInstanceState(bundle, "");
    }

    public Bundle saveInstanceState(@Nullable Bundle bundle, String str) {
        for (IAdapterExtension<Item> saveInstanceState : this.mExtensions.values()) {
            saveInstanceState.saveInstanceState(bundle, str);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void cacheSizes() {
        this.mAdapterSizes.clear();
        Iterator<IAdapter<Item>> it = this.mAdapters.iterator();
        int i = 0;
        while (it.hasNext()) {
            IAdapter next = it.next();
            if (next.getAdapterItemCount() > 0) {
                this.mAdapterSizes.append(i, next);
                i += next.getAdapterItemCount();
            }
        }
        if (i == 0 && this.mAdapters.size() > 0) {
            this.mAdapterSizes.append(0, this.mAdapters.get(0));
        }
        this.mGlobalSize = i;
    }

    public ClickEventHook<Item> getViewClickListener() {
        return this.fastAdapterViewClickListener;
    }

    public LongClickEventHook<Item> getViewLongClickListener() {
        return this.fastAdapterViewLongClickListener;
    }

    public TouchEventHook<Item> getViewTouchListener() {
        return this.fastAdapterViewTouchListener;
    }

    @Deprecated
    public SelectExtension<Item> getSelectExtension() {
        return this.mSelectExtension;
    }

    @Deprecated
    public Set<Integer> getSelections() {
        return this.mSelectExtension.getSelections();
    }

    @Deprecated
    public Set<Item> getSelectedItems() {
        return this.mSelectExtension.getSelectedItems();
    }

    @Deprecated
    public void toggleSelection(int i) {
        this.mSelectExtension.toggleSelection(i);
    }

    @Deprecated
    public void select(Iterable<Integer> iterable) {
        this.mSelectExtension.select(iterable);
    }

    @Deprecated
    public void select(int i) {
        this.mSelectExtension.select(i, false, false);
    }

    @Deprecated
    public void select(int i, boolean z) {
        this.mSelectExtension.select(i, z, false);
    }

    @Deprecated
    public void select(int i, boolean z, boolean z2) {
        this.mSelectExtension.select(i, z, z2);
    }

    @Deprecated
    public void deselect() {
        this.mSelectExtension.deselect();
    }

    @Deprecated
    public void select() {
        this.mSelectExtension.select(false);
    }

    @Deprecated
    public void select(boolean z) {
        this.mSelectExtension.select(z);
    }

    @Deprecated
    public void deselect(Iterable<Integer> iterable) {
        this.mSelectExtension.deselect(iterable);
    }

    @Deprecated
    public void deselect(int i) {
        this.mSelectExtension.deselect(i);
    }

    @Deprecated
    public void deselect(int i, Iterator<Integer> it) {
        this.mSelectExtension.deselect(i, it);
    }

    @Deprecated
    public List<Item> deleteAllSelectedItems() {
        return this.mSelectExtension.deleteAllSelectedItems();
    }

    public void notifyAdapterDataSetChanged() {
        for (IAdapterExtension<Item> notifyAdapterDataSetChanged : this.mExtensions.values()) {
            notifyAdapterDataSetChanged.notifyAdapterDataSetChanged();
        }
        cacheSizes();
        notifyDataSetChanged();
    }

    public void notifyAdapterItemInserted(int i) {
        notifyAdapterItemRangeInserted(i, 1);
    }

    public void notifyAdapterItemRangeInserted(int i, int i2) {
        for (IAdapterExtension<Item> notifyAdapterItemRangeInserted : this.mExtensions.values()) {
            notifyAdapterItemRangeInserted.notifyAdapterItemRangeInserted(i, i2);
        }
        cacheSizes();
        notifyItemRangeInserted(i, i2);
    }

    public void notifyAdapterItemRemoved(int i) {
        notifyAdapterItemRangeRemoved(i, 1);
    }

    public void notifyAdapterItemRangeRemoved(int i, int i2) {
        for (IAdapterExtension<Item> notifyAdapterItemRangeRemoved : this.mExtensions.values()) {
            notifyAdapterItemRangeRemoved.notifyAdapterItemRangeRemoved(i, i2);
        }
        cacheSizes();
        notifyItemRangeRemoved(i, i2);
    }

    public void notifyAdapterItemMoved(int i, int i2) {
        for (IAdapterExtension<Item> notifyAdapterItemMoved : this.mExtensions.values()) {
            notifyAdapterItemMoved.notifyAdapterItemMoved(i, i2);
        }
        notifyItemMoved(i, i2);
    }

    public void notifyAdapterItemChanged(int i) {
        notifyAdapterItemChanged(i, (Object) null);
    }

    public void notifyAdapterItemChanged(int i, @Nullable Object obj) {
        notifyAdapterItemRangeChanged(i, 1, obj);
    }

    public void notifyAdapterItemRangeChanged(int i, int i2) {
        notifyAdapterItemRangeChanged(i, i2, (Object) null);
    }

    public void notifyAdapterItemRangeChanged(int i, int i2, @Nullable Object obj) {
        for (IAdapterExtension<Item> notifyAdapterItemRangeChanged : this.mExtensions.values()) {
            notifyAdapterItemRangeChanged.notifyAdapterItemRangeChanged(i, i2, obj);
        }
        if (obj == null) {
            notifyItemRangeChanged(i, i2);
        } else {
            notifyItemRangeChanged(i, i2, obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r0 = (com.mikepenz.fastadapter.FastAdapter) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <Item extends com.mikepenz.fastadapter.IItem> Item getHolderAdapterItem(@javax.annotation.Nullable android.support.p003v7.widget.RecyclerView.ViewHolder r2) {
        /*
            if (r2 == 0) goto L_0x001c
            android.view.View r0 = r2.itemView
            int r1 = com.mikepenz.fastadapter.C0611R.C0614id.fastadapter_item_adapter
            java.lang.Object r0 = r0.getTag(r1)
            boolean r1 = r0 instanceof com.mikepenz.fastadapter.FastAdapter
            if (r1 == 0) goto L_0x001c
            com.mikepenz.fastadapter.FastAdapter r0 = (com.mikepenz.fastadapter.FastAdapter) r0
            int r2 = r0.getHolderAdapterPosition(r2)
            r1 = -1
            if (r2 == r1) goto L_0x001c
            com.mikepenz.fastadapter.IItem r2 = r0.getItem(r2)
            return r2
        L_0x001c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.FastAdapter.getHolderAdapterItem(android.support.v7.widget.RecyclerView$ViewHolder):com.mikepenz.fastadapter.IItem");
    }

    public static <Item extends IItem> Item getHolderAdapterItem(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder == null) {
            return null;
        }
        Object tag = viewHolder.itemView.getTag(C0611R.C0614id.fastadapter_item_adapter);
        if (tag instanceof FastAdapter) {
            return ((FastAdapter) tag).getItem(i);
        }
        return null;
    }

    @NonNull
    public Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> adapterPredicate, boolean z) {
        return recursive(adapterPredicate, 0, z);
    }

    @NonNull
    public Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> adapterPredicate, int i, boolean z) {
        while (i < getItemCount()) {
            RelativeInfo relativeInfo = getRelativeInfo(i);
            Item item = relativeInfo.item;
            if (adapterPredicate.apply(relativeInfo.adapter, i, item, i) && z) {
                return new Triple<>(true, item, Integer.valueOf(i));
            }
            if (item instanceof IExpandable) {
                Triple<Boolean, Item, Integer> recursiveSub = recursiveSub(relativeInfo.adapter, i, (IExpandable) item, adapterPredicate, z);
                if (((Boolean) recursiveSub.first).booleanValue() && z) {
                    return recursiveSub;
                }
            }
            i++;
        }
        return new Triple<>(false, null, null);
    }

    public static <Item extends IItem> Triple<Boolean, Item, Integer> recursiveSub(IAdapter<Item> iAdapter, int i, IExpandable iExpandable, AdapterPredicate<Item> adapterPredicate, boolean z) {
        if (!iExpandable.isExpanded() && iExpandable.getSubItems() != null) {
            for (int i2 = 0; i2 < iExpandable.getSubItems().size(); i2++) {
                IItem iItem = (IItem) iExpandable.getSubItems().get(i2);
                if (adapterPredicate.apply(iAdapter, i, iItem, -1) && z) {
                    return new Triple<>(true, iItem, null);
                }
                if (iItem instanceof IExpandable) {
                    Triple<Boolean, Item, Integer> recursiveSub = recursiveSub(iAdapter, i, (IExpandable) iItem, adapterPredicate, z);
                    if (((Boolean) recursiveSub.first).booleanValue()) {
                        return recursiveSub;
                    }
                }
            }
        }
        return new Triple<>(false, null, null);
    }

    public static abstract class ViewHolder<Item extends IItem> extends RecyclerView.ViewHolder {
        public void attachToWindow(Item item) {
        }

        public abstract void bindView(Item item, List<Object> list);

        public void detachFromWindow(Item item) {
        }

        public boolean failedToRecycle(Item item) {
            return false;
        }

        public abstract void unbindView(Item item);

        public ViewHolder(View view) {
            super(view);
        }
    }
}
