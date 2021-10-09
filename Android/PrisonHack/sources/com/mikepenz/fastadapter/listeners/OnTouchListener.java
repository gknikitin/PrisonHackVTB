package com.mikepenz.fastadapter.listeners;

import android.view.MotionEvent;
import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;

public interface OnTouchListener<Item extends IItem> {
    boolean onTouch(View view, MotionEvent motionEvent, IAdapter<Item> iAdapter, Item item, int i);
}
