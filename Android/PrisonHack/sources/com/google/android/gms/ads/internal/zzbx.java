package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzald;
import com.google.android.gms.internal.ads.zzamt;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.ArrayList;

public final class zzbx extends ViewSwitcher {
    private final zzald zzaed;
    @Nullable
    private final zzamt zzaee;
    private boolean zzaef = true;

    public zzbx(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.zzaed = new zzald(context);
        this.zzaed.setAdUnitId(str);
        this.zzaed.zzda(str2);
        if (context instanceof Activity) {
            this.zzaee = new zzamt((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.zzaee = new zzamt((Activity) null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.zzaee.zzsc();
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.zzaee != null) {
            this.zzaee.onAttachedToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.zzaee != null) {
            this.zzaee.onDetachedFromWindow();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zzaef) {
            return false;
        }
        this.zzaed.zze(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof zzaqw)) {
                arrayList.add((zzaqw) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzaqw) obj).destroy();
        }
    }

    public final zzald zzfr() {
        return this.zzaed;
    }

    public final void zzfs() {
        zzakb.m39v("Disable position monitoring on adFrame.");
        if (this.zzaee != null) {
            this.zzaee.zzsd();
        }
    }

    public final void zzft() {
        zzakb.m39v("Enable debug gesture detector on adFrame.");
        this.zzaef = true;
    }

    public final void zzfu() {
        zzakb.m39v("Disable debug gesture detector on adFrame.");
        this.zzaef = false;
    }
}
