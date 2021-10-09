package android.support.p000v4.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.NestedScrollingChildHelper */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getNestedScrollingParentForType(i) != null;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i, i2)) {
                setNestedScrollingParentForType(i2, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i);
            setNestedScrollingParentForType(i, (ViewParent) null);
        }
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchNestedScroll(int r15, int r16, int r17, int r18, @android.support.annotation.Nullable int[] r19, int r20) {
        /*
            r14 = this;
            r0 = r14
            r1 = r19
            boolean r2 = r0.isNestedScrollingEnabled()
            r3 = 0
            if (r2 == 0) goto L_0x0053
            r2 = r20
            android.view.ViewParent r4 = r0.getNestedScrollingParentForType(r2)
            if (r4 != 0) goto L_0x0013
            return r3
        L_0x0013:
            r11 = 1
            if (r15 != 0) goto L_0x0024
            if (r16 != 0) goto L_0x0024
            if (r17 != 0) goto L_0x0024
            if (r18 == 0) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            if (r1 == 0) goto L_0x0053
            r1[r3] = r3
            r1[r11] = r3
            goto L_0x0053
        L_0x0024:
            if (r1 == 0) goto L_0x0032
            android.view.View r5 = r0.mView
            r5.getLocationInWindow(r1)
            r5 = r1[r3]
            r10 = r1[r11]
            r12 = r5
            r13 = r10
            goto L_0x0034
        L_0x0032:
            r12 = 0
            r13 = 0
        L_0x0034:
            android.view.View r5 = r0.mView
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r2
            android.support.p000v4.view.ViewParentCompat.onNestedScroll(r4, r5, r6, r7, r8, r9, r10)
            if (r1 == 0) goto L_0x0052
            android.view.View r2 = r0.mView
            r2.getLocationInWindow(r1)
            r2 = r1[r3]
            int r2 = r2 - r12
            r1[r3] = r2
            r2 = r1[r11]
            int r2 = r2 - r13
            r1[r11] = r2
        L_0x0052:
            return r11
        L_0x0053:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.NestedScrollingChildHelper.dispatchNestedScroll(int, int, int, int, int[], int):boolean");
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        ViewParent nestedScrollingParentForType;
        int i4;
        int i5;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            iArr = this.mTempNestedScrollConsumed;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    private ViewParent getNestedScrollingParentForType(int i) {
        switch (i) {
            case 0:
                return this.mNestedScrollingParentTouch;
            case 1:
                return this.mNestedScrollingParentNonTouch;
            default:
                return null;
        }
    }

    private void setNestedScrollingParentForType(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.mNestedScrollingParentTouch = viewParent;
                return;
            case 1:
                this.mNestedScrollingParentNonTouch = viewParent;
                return;
            default:
                return;
        }
    }
}
