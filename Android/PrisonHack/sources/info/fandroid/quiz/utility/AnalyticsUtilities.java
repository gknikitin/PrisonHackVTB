package info.fandroid.quiz.utility;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AnalyticsUtilities {
    private static AnalyticsUtilities mAnalyticsUtilities;
    private FirebaseAnalytics mFirebaseAnalytics;

    public static AnalyticsUtilities getAnalyticsUtils(Context context) {
        if (mAnalyticsUtilities == null) {
            mAnalyticsUtilities = new AnalyticsUtilities(context);
        }
        return mAnalyticsUtilities;
    }

    private AnalyticsUtilities(Context context) {
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void trackEvent(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, str);
        this.mFirebaseAnalytics.logEvent("PAGE_VISIT", bundle);
    }
}
