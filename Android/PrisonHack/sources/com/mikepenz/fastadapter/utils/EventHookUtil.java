package com.mikepenz.fastadapter.utils;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.CustomEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.LongClickEventHook;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

public class EventHookUtil {
    public static <Item extends IItem> void bind(RecyclerView.ViewHolder viewHolder, @Nullable List<EventHook<Item>> list) {
        if (list != null) {
            for (EventHook next : list) {
                View onBind = next.onBind(viewHolder);
                if (onBind != null) {
                    attachToView(next, viewHolder, onBind);
                }
                List<? extends View> onBindMany = next.onBindMany(viewHolder);
                if (onBindMany != null) {
                    for (View attachToView : onBindMany) {
                        attachToView(next, viewHolder, attachToView);
                    }
                }
            }
        }
    }

    public static <Item extends IItem> void attachToView(final EventHook<Item> eventHook, final RecyclerView.ViewHolder viewHolder, View view) {
        if (eventHook instanceof ClickEventHook) {
            view.setOnClickListener(new View.OnClickListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
                    r0 = (com.mikepenz.fastadapter.FastAdapter) r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onClick(android.view.View r5) {
                    /*
                        r4 = this;
                        android.support.v7.widget.RecyclerView$ViewHolder r0 = r2
                        android.view.View r0 = r0.itemView
                        int r1 = com.mikepenz.fastadapter.C0611R.C0614id.fastadapter_item_adapter
                        java.lang.Object r0 = r0.getTag(r1)
                        boolean r1 = r0 instanceof com.mikepenz.fastadapter.FastAdapter
                        if (r1 == 0) goto L_0x0026
                        com.mikepenz.fastadapter.FastAdapter r0 = (com.mikepenz.fastadapter.FastAdapter) r0
                        android.support.v7.widget.RecyclerView$ViewHolder r1 = r2
                        int r1 = r0.getHolderAdapterPosition(r1)
                        r2 = -1
                        if (r1 == r2) goto L_0x0026
                        com.mikepenz.fastadapter.IItem r2 = r0.getItem(r1)
                        if (r2 == 0) goto L_0x0026
                        com.mikepenz.fastadapter.listeners.EventHook r3 = r1
                        com.mikepenz.fastadapter.listeners.ClickEventHook r3 = (com.mikepenz.fastadapter.listeners.ClickEventHook) r3
                        r3.onClick(r5, r1, r0, r2)
                    L_0x0026:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.utils.EventHookUtil.C06301.onClick(android.view.View):void");
                }
            });
        } else if (eventHook instanceof LongClickEventHook) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
                    r0 = (com.mikepenz.fastadapter.FastAdapter) r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean onLongClick(android.view.View r5) {
                    /*
                        r4 = this;
                        android.support.v7.widget.RecyclerView$ViewHolder r0 = r2
                        android.view.View r0 = r0.itemView
                        int r1 = com.mikepenz.fastadapter.C0611R.C0614id.fastadapter_item_adapter
                        java.lang.Object r0 = r0.getTag(r1)
                        boolean r1 = r0 instanceof com.mikepenz.fastadapter.FastAdapter
                        if (r1 == 0) goto L_0x0028
                        com.mikepenz.fastadapter.FastAdapter r0 = (com.mikepenz.fastadapter.FastAdapter) r0
                        android.support.v7.widget.RecyclerView$ViewHolder r1 = r2
                        int r1 = r0.getHolderAdapterPosition(r1)
                        r2 = -1
                        if (r1 == r2) goto L_0x0028
                        com.mikepenz.fastadapter.IItem r2 = r0.getItem(r1)
                        if (r2 == 0) goto L_0x0028
                        com.mikepenz.fastadapter.listeners.EventHook r3 = r1
                        com.mikepenz.fastadapter.listeners.LongClickEventHook r3 = (com.mikepenz.fastadapter.listeners.LongClickEventHook) r3
                        boolean r5 = r3.onLongClick(r5, r1, r0, r2)
                        return r5
                    L_0x0028:
                        r5 = 0
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.utils.EventHookUtil.C06312.onLongClick(android.view.View):boolean");
                }
            });
        } else if (eventHook instanceof TouchEventHook) {
            view.setOnTouchListener(new View.OnTouchListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
                    r6 = (com.mikepenz.fastadapter.FastAdapter) r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
                    /*
                        r8 = this;
                        android.support.v7.widget.RecyclerView$ViewHolder r0 = r2
                        android.view.View r0 = r0.itemView
                        int r1 = com.mikepenz.fastadapter.C0611R.C0614id.fastadapter_item_adapter
                        java.lang.Object r0 = r0.getTag(r1)
                        boolean r1 = r0 instanceof com.mikepenz.fastadapter.FastAdapter
                        if (r1 == 0) goto L_0x002c
                        r6 = r0
                        com.mikepenz.fastadapter.FastAdapter r6 = (com.mikepenz.fastadapter.FastAdapter) r6
                        android.support.v7.widget.RecyclerView$ViewHolder r0 = r2
                        int r5 = r6.getHolderAdapterPosition(r0)
                        r0 = -1
                        if (r5 == r0) goto L_0x002c
                        com.mikepenz.fastadapter.IItem r7 = r6.getItem(r5)
                        if (r7 == 0) goto L_0x002c
                        com.mikepenz.fastadapter.listeners.EventHook r0 = r1
                        r2 = r0
                        com.mikepenz.fastadapter.listeners.TouchEventHook r2 = (com.mikepenz.fastadapter.listeners.TouchEventHook) r2
                        r3 = r9
                        r4 = r10
                        boolean r9 = r2.onTouch(r3, r4, r5, r6, r7)
                        return r9
                    L_0x002c:
                        r9 = 0
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.utils.EventHookUtil.C06323.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        } else if (eventHook instanceof CustomEventHook) {
            ((CustomEventHook) eventHook).attachEvent(view, viewHolder);
        }
    }

    public static List<View> toList(View... viewArr) {
        return Arrays.asList(viewArr);
    }
}
