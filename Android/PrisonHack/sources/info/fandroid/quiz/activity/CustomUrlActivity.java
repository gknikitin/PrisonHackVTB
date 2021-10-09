package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import com.google.android.gms.ads.AdView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.listeners.WebListener;
import info.fandroid.quiz.utility.AdsUtilities;
import info.fandroid.quiz.utility.AppUtilities;
import info.fandroid.quiz.utility.FilePickerUtilities;
import info.fandroid.quiz.utility.PermissionUtilities;
import info.fandroid.quiz.webengine.WebEngine;

public class CustomUrlActivity extends BaseActivity {
    private Activity mActivity;
    private Context mContext;
    private boolean mFromPush = false;
    private String mPageTitle;
    private String mPageUrl;
    private WebEngine mWebEngine;
    private WebView mWebView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initVar();
        initView();
        initFunctionality();
    }

    private void initVar() {
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.mPageTitle = intent.getStringExtra("title");
            this.mPageUrl = intent.getStringExtra("url");
            this.mFromPush = intent.getBooleanExtra(AppConstant.BUNDLE_FROM_PUSH, false);
        }
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_custom_url);
        initWebEngine();
        initLoader();
        initToolbar(true);
        setToolbarTitle(this.mPageTitle);
        enableUpButton();
    }

    public void initWebEngine() {
        this.mWebView = (WebView) findViewById(C0683R.C0686id.web_view);
        this.mWebEngine = new WebEngine(this.mWebView, this.mActivity);
        this.mWebEngine.initWebView();
        this.mWebEngine.initListeners(new WebListener() {
            public void onPageTitle(String str) {
            }

            public void onProgress(int i) {
            }

            public void onStart() {
                CustomUrlActivity.this.showLoader();
            }

            public void onLoaded() {
                CustomUrlActivity.this.hideLoader();
            }

            public void onNetworkError() {
                CustomUrlActivity.this.showEmptyView();
            }
        });
    }

    private void initFunctionality() {
        this.mWebEngine.loadPage(this.mPageUrl);
        AdsUtilities.getInstance(this.mContext).showFullScreenAd();
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (!PermissionUtilities.isPermissionResultGranted(iArr)) {
            AppUtilities.showToast(this.mActivity, getString(C0683R.string.permission_not_granted));
        } else if (i == 113) {
            if (this.mWebEngine != null) {
                this.mWebEngine.invokeImagePickerActivity();
            }
        } else if (i == 112 && this.mWebEngine != null) {
            this.mWebEngine.downloadFile();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 554) {
                String pickedFilePath = FilePickerUtilities.getPickedFilePath(this, intent);
                if (this.mWebEngine != null) {
                    this.mWebEngine.uploadFile(intent, pickedFilePath);
                } else {
                    AppUtilities.showToast(this.mContext, getString(C0683R.string.failed));
                }
            }
        } else if (i2 == 0 && this.mWebEngine != null) {
            this.mWebEngine.cancelUpload();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        goToHome();
        return true;
    }

    public void onBackPressed() {
        goToHome();
    }

    private void goToHome() {
        if (this.mFromPush) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
            return;
        }
        finish();
    }
}
