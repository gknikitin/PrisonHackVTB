package android.support.design.widget;

import android.support.p000v4.view.animation.FastOutLinearInInterpolator;
import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
import android.support.p000v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class AnimationUtils {
    static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    AnimationUtils() {
    }

    static int lerp(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
