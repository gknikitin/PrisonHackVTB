package info.fandroid.quiz.webengine;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.preference.AppPreference;
import info.fandroid.quiz.listeners.WebListener;
import info.fandroid.quiz.utility.FilePickerUtilities;
import info.fandroid.quiz.utility.PermissionUtilities;
import java.io.File;

public class WebEngine {
    private static final String GOOGLE_DOCS_VIEWER = "https://docs.google.com/viewerng/viewer?url=";
    public static final int KEY_FILE_PICKER = 554;
    /* access modifiers changed from: private */
    public Activity mActivity;
    private Context mContext = this.mActivity.getApplicationContext();
    /* access modifiers changed from: private */
    public String mDownloadUrl;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mFilePathCallback;
    private Fragment mFragment;
    private ValueCallback<Uri> mUploadMessage;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback mVideoViewCallback;
    /* access modifiers changed from: private */
    public VideoViewer mVideoViewer = VideoViewer.getInstance();
    private WebListener mWebListener;
    /* access modifiers changed from: private */
    public WebView webView;

    public WebEngine(WebView webView2, Activity activity) {
        this.webView = webView2;
        this.mActivity = activity;
    }

    public void initWebView() {
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setAppCacheMaxSize(AppConstant.SITE_CACHE_SIZE);
        this.webView.getSettings().setAppCachePath(this.mContext.getCacheDir().getAbsolutePath());
        this.webView.getSettings().setAllowFileAccess(true);
        this.webView.getSettings().setAppCacheEnabled(true);
        this.webView.getSettings().setCacheMode(-1);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setDefaultTextEncodingName("utf-8");
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        if (!isNetworkAvailable(this.mContext)) {
            this.webView.getSettings().setCacheMode(1);
        }
        if (AppPreference.getInstance(this.mContext).getTextSize().equals(this.mContext.getResources().getString(C0683R.string.small_text))) {
            this.webView.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
        } else if (AppPreference.getInstance(this.mContext).getTextSize().equals(this.mContext.getResources().getString(C0683R.string.default_text))) {
            this.webView.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
        } else if (AppPreference.getInstance(this.mContext).getTextSize().equals(this.mContext.getResources().getString(C0683R.string.large_text))) {
            this.webView.getSettings().setTextSize(WebSettings.TextSize.LARGER);
        }
    }

    public void initListeners(final WebListener webListener) {
        this.mWebListener = webListener;
        this.webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                webListener.onProgress(i);
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (WebEngine.this.mFilePathCallback != null) {
                    WebEngine.this.mFilePathCallback.onReceiveValue((Object) null);
                }
                ValueCallback unused = WebEngine.this.mFilePathCallback = valueCallback;
                WebEngine.this.invokeImagePickerActivity();
                return true;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                webListener.onPageTitle(WebEngine.this.webView.getTitle());
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
                WebChromeClient.CustomViewCallback unused = WebEngine.this.mVideoViewCallback = customViewCallback;
                WebEngine.this.mVideoViewer.show(WebEngine.this.mActivity);
                WebEngine.this.mVideoViewer.setVideoLayout(view);
            }

            public void onHideCustomView() {
                super.onHideCustomView();
                WebEngine.this.mVideoViewer.dismiss();
                WebEngine.this.mVideoViewCallback.onCustomViewHidden();
            }
        });
        this.webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WebEngine.this.loadPage(str);
                return true;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                webListener.onStart();
            }

            public void onPageFinished(WebView webView, String str) {
                webListener.onLoaded();
            }
        });
        this.webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = WebEngine.this.mDownloadUrl = str;
                WebEngine.this.downloadFile();
            }
        });
    }

    public void loadPage(String str) {
        if (!isNetworkAvailable(this.mContext)) {
            this.mWebListener.onNetworkError();
        } else if (str.startsWith("tel:") || str.startsWith("sms:") || str.startsWith("smsto:") || str.startsWith("mms:") || str.startsWith("mmsto:") || str.startsWith("mailto:") || str.contains("geo:")) {
            invokeNativeApp(str);
        } else if (str.contains("?target=blank")) {
            invokeNativeApp(str.replace("?target=blank", ""));
        } else if (str.endsWith(".doc") || str.endsWith(".docx") || str.endsWith(".xls") || str.endsWith(".xlsx") || str.endsWith(".pptx") || str.endsWith(".pdf")) {
            WebView webView2 = this.webView;
            webView2.loadUrl(GOOGLE_DOCS_VIEWER + str);
            this.webView.getSettings().setBuiltInZoomControls(true);
        } else {
            this.webView.loadUrl(str);
        }
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private void invokeNativeApp(String str) {
        this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void invokeImagePickerActivity() {
        if (PermissionUtilities.isPermissionGranted(this.mActivity, PermissionUtilities.SD_WRITE_PERMISSIONS, 113)) {
            Intent pickFileIntent = FilePickerUtilities.getPickFileIntent(this.mActivity);
            if (this.mFragment == null) {
                this.mActivity.startActivityForResult(pickFileIntent, KEY_FILE_PICKER);
            } else {
                this.mFragment.startActivityForResult(pickFileIntent, KEY_FILE_PICKER);
            }
        }
    }

    public void uploadFile(Intent intent, String str) {
        String dataString;
        if (Build.VERSION.SDK_INT >= 21) {
            Uri[] uriArr = str != null ? new Uri[]{Uri.fromFile(new File(str))} : null;
            if (uriArr == null && (dataString = intent.getDataString()) != null) {
                uriArr = new Uri[]{Uri.parse(dataString)};
            }
            if (this.mFilePathCallback != null) {
                this.mFilePathCallback.onReceiveValue(uriArr);
                this.mFilePathCallback = null;
            }
        } else if (Build.VERSION.SDK_INT <= 19) {
            Uri fromFile = intent == null ? Uri.fromFile(new File(str)) : intent.getData();
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue(fromFile);
                this.mUploadMessage = null;
            }
        }
    }

    public void cancelUpload() {
        if (this.mFilePathCallback != null) {
            this.mFilePathCallback.onReceiveValue((Object) null);
        }
        this.mFilePathCallback = null;
    }

    public void downloadFile() {
        if (PermissionUtilities.isPermissionGranted(this.mActivity, PermissionUtilities.SD_WRITE_PERMISSIONS, 112)) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.mDownloadUrl));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Downloading file...");
            ((DownloadManager) this.mContext.getSystemService("download")).enqueue(request);
        }
    }
}
