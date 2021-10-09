package com.mikepenz.fastadapter.listeners;

import android.support.p003v7.widget.RecyclerView;
import android.util.Log;
import com.mikepenz.fastadapter.C0611R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import java.util.List;

public class OnBindViewHolderListenerImpl implements OnBindViewHolderListener {
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        IItem item;
        Object tag = viewHolder.itemView.getTag(C0611R.C0614id.fastadapter_item_adapter);
        if ((tag instanceof FastAdapter) && (item = ((FastAdapter) tag).getItem(i)) != null) {
            item.bindView(viewHolder, list);
            if (viewHolder instanceof FastAdapter.ViewHolder) {
                ((FastAdapter.ViewHolder) viewHolder).bindView(item, list);
            }
            viewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item, item);
        }
    }

    public void unBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IItem iItem = (IItem) viewHolder.itemView.getTag(C0611R.C0614id.fastadapter_item);
        if (iItem != null) {
            iItem.unbindView(viewHolder);
            if (viewHolder instanceof FastAdapter.ViewHolder) {
                ((FastAdapter.ViewHolder) viewHolder).unbindView(iItem);
            }
            viewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item, (Object) null);
            viewHolder.itemView.setTag(C0611R.C0614id.fastadapter_item_adapter, (Object) null);
            return;
        }
        Log.e("FastAdapter", "The bindView method of this item should set the `Tag` on its itemView (https://github.com/mikepenz/FastAdapter/blob/develop/library-core/src/main/java/com/mikepenz/fastadapter/items/AbstractItem.java#L189)");
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, int i) {
        IItem holderAdapterItem = FastAdapter.getHolderAdapterItem(viewHolder, i);
        if (holderAdapterItem != null) {
            try {
                holderAdapterItem.attachToWindow(viewHolder);
                if (viewHolder instanceof FastAdapter.ViewHolder) {
                    ((FastAdapter.ViewHolder) viewHolder).attachToWindow(holderAdapterItem);
                }
            } catch (AbstractMethodError e) {
                Log.e("FastAdapter", e.toString());
            }
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder, int i) {
        IItem holderAdapterItem = FastAdapter.getHolderAdapterItem(viewHolder, i);
        if (holderAdapterItem != null) {
            holderAdapterItem.detachFromWindow(viewHolder);
            if (viewHolder instanceof FastAdapter.ViewHolder) {
                ((FastAdapter.ViewHolder) viewHolder).detachFromWindow(holderAdapterItem);
            }
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder, int i) {
        IItem iItem = (IItem) viewHolder.itemView.getTag(C0611R.C0614id.fastadapter_item);
        if (iItem == null) {
            return false;
        }
        boolean failedToRecycle = iItem.failedToRecycle(viewHolder);
        if (viewHolder instanceof FastAdapter.ViewHolder) {
            return failedToRecycle || ((FastAdapter.ViewHolder) viewHolder).failedToRecycle(iItem);
        }
        return failedToRecycle;
    }
}
