package android.support.p003v7.recyclerview.extensions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.p003v7.util.AdapterListUpdateCallback;
import android.support.p003v7.util.DiffUtil;
import android.support.p003v7.util.ListUpdateCallback;
import android.support.p003v7.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.recyclerview.extensions.AsyncListDiffer */
public class AsyncListDiffer<T> {
    /* access modifiers changed from: private */
    public final AsyncDifferConfig<T> mConfig;
    @Nullable
    private List<T> mList;
    /* access modifiers changed from: private */
    public int mMaxScheduledGeneration;
    @NonNull
    private List<T> mReadOnlyList = Collections.emptyList();
    private final ListUpdateCallback mUpdateCallback;

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new AsyncDifferConfig.Builder(itemCallback).build();
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void submitList(final List<T> list) {
        if (list != this.mList) {
            final int i = this.mMaxScheduledGeneration + 1;
            this.mMaxScheduledGeneration = i;
            if (list == null) {
                this.mUpdateCallback.onRemoved(0, this.mList.size());
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
            } else if (this.mList == null) {
                this.mUpdateCallback.onInserted(0, list.size());
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
            } else {
                final List<T> list2 = this.mList;
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                            public int getOldListSize() {
                                return list2.size();
                            }

                            public int getNewListSize() {
                                return list.size();
                            }

                            public boolean areItemsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(list2.get(i), list.get(i2));
                            }

                            public boolean areContentsTheSame(int i, int i2) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(list2.get(i), list.get(i2));
                            }
                        });
                        AsyncListDiffer.this.mConfig.getMainThreadExecutor().execute(new Runnable() {
                            public void run() {
                                if (AsyncListDiffer.this.mMaxScheduledGeneration == i) {
                                    AsyncListDiffer.this.latchList(list, calculateDiff);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
    }
}
