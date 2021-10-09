package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.utility.ActivityUtilities;
import info.fandroid.quiz.utility.AdsUtilities;

public class QuizPromptActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public Activity mActivity;
    private Button mBtnNo;
    private Button mBtnYes;
    /* access modifiers changed from: private */
    public String mCategoryId;
    private Context mContext;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initVar();
        initView();
        initListener();
    }

    private void initVar() {
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.mCategoryId = intent.getStringExtra("index");
        }
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_quiz_prompt);
        this.mBtnYes = (Button) findViewById(C0683R.C0686id.btn_yes);
        this.mBtnNo = (Button) findViewById(C0683R.C0686id.btn_no);
        initToolbar(true);
        setToolbarTitle(getString(C0683R.string.quiz_prompt));
        enableUpButton();
        AdsUtilities.getInstance(this.mContext).showFullScreenAd();
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    private void initListener() {
        this.mBtnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeCommonQuizActivity(QuizPromptActivity.this.mActivity, QuizActivity.class, QuizPromptActivity.this.mCategoryId, true);
            }
        });
        this.mBtnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(QuizPromptActivity.this.mActivity, MainActivity.class, true);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, MainActivity.class, true);
        return true;
    }

    public void onBackPressed() {
        ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, MainActivity.class, true);
    }
}
