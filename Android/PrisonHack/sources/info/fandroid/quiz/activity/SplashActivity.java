package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.sqlite.NotificationDbController;
import info.fandroid.quiz.utility.ActivityUtilities;

public class SplashActivity extends AppCompatActivity {
    public static final String CHANNEL_NAME = "Notification Channel";
    public static final String NOTIFICATION_CHANNEL_ID = "channel_id";
    private static final int SPLASH_DURATION = 2500;
    int importance = 3;
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public Animation mAnimation_1;
    private Context mContext;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    /* access modifiers changed from: private */
    public ProgressBar mProgressBar;
    private RelativeLayout mRootLayout;
    String message;
    String title;
    String url;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        initVar();
        initView();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                this.title = extras.get("title").toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.message = extras.get(AppConstant.BUNDLE_KEY_MESSAGE).toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.url = extras.get("url").toString();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (this.url != null) {
                sendNotification(this.title, this.message, this.url);
            }
        }
    }

    private void sendNotification(String str, String str2, String str3) {
        new NotificationDbController(this).insertData(str, str2, str3);
    }

    private void initVar() {
        this.mContext = getApplicationContext();
        this.mActivity = this;
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_splash);
        this.mProgressBar = (ProgressBar) findViewById(C0683R.C0686id.progressBar);
        this.mRootLayout = (RelativeLayout) findViewById(C0683R.C0686id.splashBody);
        this.mImageView = (ImageView) findViewById(C0683R.C0686id.splashIcon);
        this.mAnimation_1 = AnimationUtils.loadAnimation(getBaseContext(), C0683R.anim.rotate);
    }

    private void initFunctionality() {
        this.mRootLayout.postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.mProgressBar.setVisibility(8);
                SplashActivity.this.mImageView.startAnimation(SplashActivity.this.mAnimation_1);
                SplashActivity.this.mAnimation_1.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        ActivityUtilities.getInstance().invokeNewActivity(SplashActivity.this.mActivity, MainActivity.class, true);
                    }
                });
            }
        }, 2500);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initFunctionality();
    }
}
