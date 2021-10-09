package info.fandroid.quiz.utility;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import info.fandroid.quiz.C0683R;

public class AdsUtilities {
    private static AdsUtilities mAdsUtilities;
    private boolean mDisableBannerAd = false;
    private boolean mDisableInterstitialAd = false;
    private InterstitialAd mInterstitialAd;

    private AdsUtilities(Context context) {
        MobileAds.initialize(context, context.getResources().getString(C0683R.string.app_ad_id));
    }

    public static AdsUtilities getInstance(Context context) {
        if (mAdsUtilities == null) {
            mAdsUtilities = new AdsUtilities(context);
        }
        return mAdsUtilities;
    }

    public void showBannerAd(final AdView adView) {
        if (this.mDisableBannerAd) {
            adView.setVisibility(8);
            return;
        }
        adView.loadAd(new AdRequest.Builder().build());
        adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                super.onAdLoaded();
                adView.setVisibility(0);
            }

            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                adView.setVisibility(8);
            }
        });
    }

    public void loadFullScreenAd(Activity activity) {
        if (!this.mDisableInterstitialAd) {
            this.mInterstitialAd = new InterstitialAd(activity);
            this.mInterstitialAd.setAdUnitId(activity.getResources().getString(C0683R.string.interstitial_ad_unit_id));
            this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }

    public boolean showFullScreenAd() {
        if (this.mDisableInterstitialAd || this.mInterstitialAd == null || !this.mInterstitialAd.isLoaded()) {
            return false;
        }
        this.mInterstitialAd.show();
        return true;
    }

    public void disableBannerAd() {
        this.mDisableBannerAd = true;
    }

    public void disableInterstitialAd() {
        this.mDisableInterstitialAd = true;
    }
}
