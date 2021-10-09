package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.utility.ActivityUtilities;

public class AboutDevActivity extends BaseActivity {
    ImageView imgDev;
    private Activity mActivity;
    private Context mContext;
    TextView tvDevSubTitle;
    TextView tvDevText;
    TextView tvDevTitle;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        initView();
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_about_dev);
        this.imgDev = (ImageView) findViewById(C0683R.C0686id.img_dev);
        this.tvDevTitle = (TextView) findViewById(C0683R.C0686id.tv_dev_title);
        this.tvDevSubTitle = (TextView) findViewById(C0683R.C0686id.tv_dev_sub_title);
        this.tvDevText = (TextView) findViewById(C0683R.C0686id.tv_dev_text);
        initToolbar(true);
        setToolbarTitle(getString(C0683R.string.about_dev));
        enableUpButton();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void clickView(View view) {
        ActivityUtilities.getInstance().invokeCustomUrlActivity(this.mActivity, CustomUrlActivity.class, getResources().getString(C0683R.string.site), getResources().getString(C0683R.string.site_url), false);
    }
}
