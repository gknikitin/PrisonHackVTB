package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.widget.LinearLayout;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.utility.AdsUtilities;

public class BaseActivity extends AppCompatActivity {
    private static String PRODUCT_ID_BOUGHT = "item_1_bought";
    private static String PRODUCT_ID_SUBSCRIBE = "item_1_subscribe";
    private Activity mActivity;
    private Context mContext;
    private LinearLayout mLoadingView;
    private LinearLayout mNoDataView;
    private Toolbar mToolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        if (PreferenceManager.getDefaultSharedPreferences(this.mActivity).getBoolean(PRODUCT_ID_BOUGHT, false)) {
            disableAds();
        }
    }

    public void initToolbar(boolean z) {
        this.mToolbar = (Toolbar) findViewById(C0683R.C0686id.toolbar);
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(z);
    }

    public void setToolbarTitle(String str) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle((CharSequence) str);
        }
    }

    public void enableUpButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void initLoader() {
        this.mLoadingView = (LinearLayout) findViewById(C0683R.C0686id.loadingView);
        this.mNoDataView = (LinearLayout) findViewById(C0683R.C0686id.noDataView);
    }

    public void showLoader() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(0);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void hideLoader() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showEmptyView() {
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(8);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    private void disableAds() {
        AdsUtilities.getInstance(this.mContext).disableBannerAd();
        AdsUtilities.getInstance(this.mContext).disableInterstitialAd();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
