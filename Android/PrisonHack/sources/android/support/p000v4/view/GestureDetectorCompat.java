package android.support.p000v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.GestureDetectorCompat */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler */
        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.mDoubleTapListener == null) {
                            return;
                        }
                        if (!GestureDetectorCompatImplBase.this.mStillDown) {
                            GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                            return;
                        } else {
                            GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARNING: Removed duplicated region for block: B:93:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0221  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r12) {
            /*
                r11 = this;
                int r0 = r12.getAction()
                android.view.VelocityTracker r1 = r11.mVelocityTracker
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r11.mVelocityTracker = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r11.mVelocityTracker
                r1.addMovement(r12)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r1 = 1
                goto L_0x001d
            L_0x001c:
                r1 = 0
            L_0x001d:
                if (r1 == 0) goto L_0x0024
                int r4 = r12.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r4 = -1
            L_0x0025:
                int r5 = r12.getPointerCount()
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
            L_0x002d:
                if (r7 >= r5) goto L_0x003f
                if (r4 != r7) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r10 = r12.getX(r7)
                float r8 = r8 + r10
                float r10 = r12.getY(r7)
                float r9 = r9 + r10
            L_0x003c:
                int r7 = r7 + 1
                goto L_0x002d
            L_0x003f:
                if (r1 == 0) goto L_0x0044
                int r1 = r5 + -1
                goto L_0x0045
            L_0x0044:
                r1 = r5
            L_0x0045:
                float r1 = (float) r1
                float r8 = r8 / r1
                float r9 = r9 / r1
                r1 = 1000(0x3e8, float:1.401E-42)
                r4 = 2
                r7 = 3
                switch(r0) {
                    case 0: goto L_0x01bb;
                    case 1: goto L_0x0127;
                    case 2: goto L_0x00b0;
                    case 3: goto L_0x00ab;
                    case 4: goto L_0x004f;
                    case 5: goto L_0x009e;
                    case 6: goto L_0x0051;
                    default: goto L_0x004f;
                }
            L_0x004f:
                goto L_0x0253
            L_0x0051:
                r11.mLastFocusX = r8
                r11.mDownFocusX = r8
                r11.mLastFocusY = r9
                r11.mDownFocusY = r9
                android.view.VelocityTracker r0 = r11.mVelocityTracker
                int r2 = r11.mMaximumFlingVelocity
                float r2 = (float) r2
                r0.computeCurrentVelocity(r1, r2)
                int r0 = r12.getActionIndex()
                int r1 = r12.getPointerId(r0)
                android.view.VelocityTracker r2 = r11.mVelocityTracker
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r11.mVelocityTracker
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0076:
                if (r4 >= r5) goto L_0x0253
                if (r4 != r0) goto L_0x007b
                goto L_0x009b
            L_0x007b:
                int r7 = r12.getPointerId(r4)
                android.view.VelocityTracker r8 = r11.mVelocityTracker
                float r8 = r8.getXVelocity(r7)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r11.mVelocityTracker
                float r7 = r9.getYVelocity(r7)
                float r7 = r7 * r1
                float r8 = r8 + r7
                int r7 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r7 >= 0) goto L_0x009b
                android.view.VelocityTracker r12 = r11.mVelocityTracker
                r12.clear()
                goto L_0x0253
            L_0x009b:
                int r4 = r4 + 1
                goto L_0x0076
            L_0x009e:
                r11.mLastFocusX = r8
                r11.mDownFocusX = r8
                r11.mLastFocusY = r9
                r11.mDownFocusY = r9
                r11.cancelTaps()
                goto L_0x0253
            L_0x00ab:
                r11.cancel()
                goto L_0x0253
            L_0x00b0:
                boolean r0 = r11.mInLongPress
                if (r0 == 0) goto L_0x00b6
                goto L_0x0253
            L_0x00b6:
                float r0 = r11.mLastFocusX
                float r0 = r0 - r8
                float r1 = r11.mLastFocusY
                float r1 = r1 - r9
                boolean r5 = r11.mIsDoubleTapping
                if (r5 == 0) goto L_0x00c9
                android.view.GestureDetector$OnDoubleTapListener r0 = r11.mDoubleTapListener
                boolean r12 = r0.onDoubleTapEvent(r12)
                r3 = r3 | r12
                goto L_0x0253
            L_0x00c9:
                boolean r5 = r11.mAlwaysInTapRegion
                if (r5 == 0) goto L_0x0107
                float r5 = r11.mDownFocusX
                float r5 = r8 - r5
                int r5 = (int) r5
                float r6 = r11.mDownFocusY
                float r6 = r9 - r6
                int r6 = (int) r6
                int r5 = r5 * r5
                int r6 = r6 * r6
                int r5 = r5 + r6
                int r6 = r11.mTouchSlopSquare
                if (r5 <= r6) goto L_0x00fe
                android.view.GestureDetector$OnGestureListener r6 = r11.mListener
                android.view.MotionEvent r10 = r11.mCurrentDownEvent
                boolean r12 = r6.onScroll(r10, r12, r0, r1)
                r11.mLastFocusX = r8
                r11.mLastFocusY = r9
                r11.mAlwaysInTapRegion = r3
                android.os.Handler r0 = r11.mHandler
                r0.removeMessages(r7)
                android.os.Handler r0 = r11.mHandler
                r0.removeMessages(r2)
                android.os.Handler r0 = r11.mHandler
                r0.removeMessages(r4)
                goto L_0x00ff
            L_0x00fe:
                r12 = 0
            L_0x00ff:
                int r0 = r11.mTouchSlopSquare
                if (r5 <= r0) goto L_0x01b8
                r11.mAlwaysInBiggerTapRegion = r3
                goto L_0x01b8
            L_0x0107:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0119
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0253
            L_0x0119:
                android.view.GestureDetector$OnGestureListener r2 = r11.mListener
                android.view.MotionEvent r3 = r11.mCurrentDownEvent
                boolean r3 = r2.onScroll(r3, r12, r0, r1)
                r11.mLastFocusX = r8
                r11.mLastFocusY = r9
                goto L_0x0253
            L_0x0127:
                r11.mStillDown = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r12)
                boolean r5 = r11.mIsDoubleTapping
                if (r5 == 0) goto L_0x0139
                android.view.GestureDetector$OnDoubleTapListener r1 = r11.mDoubleTapListener
                boolean r12 = r1.onDoubleTapEvent(r12)
                r12 = r12 | r3
                goto L_0x0193
            L_0x0139:
                boolean r5 = r11.mInLongPress
                if (r5 == 0) goto L_0x0145
                android.os.Handler r12 = r11.mHandler
                r12.removeMessages(r7)
                r11.mInLongPress = r3
                goto L_0x0189
            L_0x0145:
                boolean r5 = r11.mAlwaysInTapRegion
                if (r5 == 0) goto L_0x015e
                android.view.GestureDetector$OnGestureListener r1 = r11.mListener
                boolean r1 = r1.onSingleTapUp(r12)
                boolean r5 = r11.mDeferConfirmSingleTap
                if (r5 == 0) goto L_0x015c
                android.view.GestureDetector$OnDoubleTapListener r5 = r11.mDoubleTapListener
                if (r5 == 0) goto L_0x015c
                android.view.GestureDetector$OnDoubleTapListener r5 = r11.mDoubleTapListener
                r5.onSingleTapConfirmed(r12)
            L_0x015c:
                r12 = r1
                goto L_0x0193
            L_0x015e:
                android.view.VelocityTracker r5 = r11.mVelocityTracker
                int r6 = r12.getPointerId(r3)
                int r7 = r11.mMaximumFlingVelocity
                float r7 = (float) r7
                r5.computeCurrentVelocity(r1, r7)
                float r1 = r5.getYVelocity(r6)
                float r5 = r5.getXVelocity(r6)
                float r6 = java.lang.Math.abs(r1)
                int r7 = r11.mMinimumFlingVelocity
                float r7 = (float) r7
                int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                if (r6 > 0) goto L_0x018b
                float r6 = java.lang.Math.abs(r5)
                int r7 = r11.mMinimumFlingVelocity
                float r7 = (float) r7
                int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                if (r6 <= 0) goto L_0x0189
                goto L_0x018b
            L_0x0189:
                r12 = 0
                goto L_0x0193
            L_0x018b:
                android.view.GestureDetector$OnGestureListener r6 = r11.mListener
                android.view.MotionEvent r7 = r11.mCurrentDownEvent
                boolean r12 = r6.onFling(r7, r12, r5, r1)
            L_0x0193:
                android.view.MotionEvent r1 = r11.mPreviousUpEvent
                if (r1 == 0) goto L_0x019c
                android.view.MotionEvent r1 = r11.mPreviousUpEvent
                r1.recycle()
            L_0x019c:
                r11.mPreviousUpEvent = r0
                android.view.VelocityTracker r0 = r11.mVelocityTracker
                if (r0 == 0) goto L_0x01aa
                android.view.VelocityTracker r0 = r11.mVelocityTracker
                r0.recycle()
                r0 = 0
                r11.mVelocityTracker = r0
            L_0x01aa:
                r11.mIsDoubleTapping = r3
                r11.mDeferConfirmSingleTap = r3
                android.os.Handler r0 = r11.mHandler
                r0.removeMessages(r2)
                android.os.Handler r0 = r11.mHandler
                r0.removeMessages(r4)
            L_0x01b8:
                r3 = r12
                goto L_0x0253
            L_0x01bb:
                android.view.GestureDetector$OnDoubleTapListener r0 = r11.mDoubleTapListener
                if (r0 == 0) goto L_0x01fb
                android.os.Handler r0 = r11.mHandler
                boolean r0 = r0.hasMessages(r7)
                if (r0 == 0) goto L_0x01cc
                android.os.Handler r1 = r11.mHandler
                r1.removeMessages(r7)
            L_0x01cc:
                android.view.MotionEvent r1 = r11.mCurrentDownEvent
                if (r1 == 0) goto L_0x01f3
                android.view.MotionEvent r1 = r11.mPreviousUpEvent
                if (r1 == 0) goto L_0x01f3
                if (r0 == 0) goto L_0x01f3
                android.view.MotionEvent r0 = r11.mCurrentDownEvent
                android.view.MotionEvent r1 = r11.mPreviousUpEvent
                boolean r0 = r11.isConsideredDoubleTap(r0, r1, r12)
                if (r0 == 0) goto L_0x01f3
                r11.mIsDoubleTapping = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r11.mDoubleTapListener
                android.view.MotionEvent r1 = r11.mCurrentDownEvent
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r11.mDoubleTapListener
                boolean r1 = r1.onDoubleTapEvent(r12)
                r0 = r0 | r1
                goto L_0x01fc
            L_0x01f3:
                android.os.Handler r0 = r11.mHandler
                int r1 = DOUBLE_TAP_TIMEOUT
                long r5 = (long) r1
                r0.sendEmptyMessageDelayed(r7, r5)
            L_0x01fb:
                r0 = 0
            L_0x01fc:
                r11.mLastFocusX = r8
                r11.mDownFocusX = r8
                r11.mLastFocusY = r9
                r11.mDownFocusY = r9
                android.view.MotionEvent r1 = r11.mCurrentDownEvent
                if (r1 == 0) goto L_0x020d
                android.view.MotionEvent r1 = r11.mCurrentDownEvent
                r1.recycle()
            L_0x020d:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12)
                r11.mCurrentDownEvent = r1
                r11.mAlwaysInTapRegion = r2
                r11.mAlwaysInBiggerTapRegion = r2
                r11.mStillDown = r2
                r11.mInLongPress = r3
                r11.mDeferConfirmSingleTap = r3
                boolean r1 = r11.mIsLongpressEnabled
                if (r1 == 0) goto L_0x023b
                android.os.Handler r1 = r11.mHandler
                r1.removeMessages(r4)
                android.os.Handler r1 = r11.mHandler
                android.view.MotionEvent r3 = r11.mCurrentDownEvent
                long r5 = r3.getDownTime()
                int r3 = TAP_TIMEOUT
                long r7 = (long) r3
                long r9 = r5 + r7
                int r3 = LONGPRESS_TIMEOUT
                long r5 = (long) r3
                long r7 = r9 + r5
                r1.sendEmptyMessageAtTime(r4, r7)
            L_0x023b:
                android.os.Handler r1 = r11.mHandler
                android.view.MotionEvent r3 = r11.mCurrentDownEvent
                long r3 = r3.getDownTime()
                int r5 = TAP_TIMEOUT
                long r5 = (long) r5
                long r7 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r7)
                android.view.GestureDetector$OnGestureListener r1 = r11.mListener
                boolean r12 = r1.onDown(r12)
                r3 = r0 | r12
            L_0x0253:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.mDoubleTapSlopSquare) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
