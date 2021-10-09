package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.ads.AdView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.adapters.NotificationAdapter;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.sqlite.NotificationDbController;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.notification.NotificationModel;
import info.fandroid.quiz.utility.ActivityUtilities;
import info.fandroid.quiz.utility.AdsUtilities;
import info.fandroid.quiz.utility.DialogUtilities;
import java.util.ArrayList;

public class NotificationListActivity extends BaseActivity implements DialogUtilities.OnCompleteListener {
    /* access modifiers changed from: private */
    public Activity mActivity;
    private Context mContext;
    private MenuItem mMenuItemDeleteAll;
    private NotificationAdapter mNotificationAdapter;
    /* access modifiers changed from: private */
    public NotificationDbController mNotificationDbController;
    /* access modifiers changed from: private */
    public ArrayList<NotificationModel> mNotificationList;
    private RecyclerView mRecycler;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        this.mNotificationList = new ArrayList<>();
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_notification);
        this.mRecycler = (RecyclerView) findViewById(C0683R.C0686id.rv_recycler);
        this.mNotificationAdapter = new NotificationAdapter(this.mActivity, this.mNotificationList);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this.mActivity));
        this.mRecycler.setAdapter(this.mNotificationAdapter);
        initLoader();
        initToolbar(true);
        setToolbarTitle(getString(C0683R.string.notifications));
        enableUpButton();
    }

    private void initFunctionality() {
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    private void updateUI() {
        showLoader();
        if (this.mNotificationDbController == null) {
            this.mNotificationDbController = new NotificationDbController(this.mContext);
        }
        this.mNotificationList.clear();
        this.mNotificationList.addAll(this.mNotificationDbController.getAllData());
        this.mNotificationAdapter.notifyDataSetChanged();
        hideLoader();
        if (this.mNotificationList.size() == 0) {
            showEmptyView();
            if (this.mMenuItemDeleteAll != null) {
                this.mMenuItemDeleteAll.setVisible(false);
            }
        } else if (this.mMenuItemDeleteAll != null) {
            this.mMenuItemDeleteAll.setVisible(true);
        }
    }

    private void initListener() {
        this.mNotificationAdapter.setItemClickListener(new ListItemClickListener() {
            public void onItemClick(int i, View view) {
                NotificationListActivity.this.mNotificationDbController.updateStatus(((NotificationModel) NotificationListActivity.this.mNotificationList.get(i)).getId(), true);
                ActivityUtilities.getInstance().invokeCustomUrlActivity(NotificationListActivity.this.mActivity, CustomUrlActivity.class, ((NotificationModel) NotificationListActivity.this.mNotificationList.get(i)).getTitle(), ((NotificationModel) NotificationListActivity.this.mNotificationList.get(i)).getUrl(), false);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == C0683R.C0686id.menus_delete_all) {
                DialogUtilities.newInstance(getString(C0683R.string.notifications), getString(C0683R.string.delete_all_notification), getString(C0683R.string.yes), getString(C0683R.string.f84no), AppConstant.BUNDLE_KEY_DELETE_ALL_NOT).show(getSupportFragmentManager(), AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0683R.C0687menu.menu_delete_all, menu);
        this.mMenuItemDeleteAll = menu.findItem(C0683R.C0686id.menus_delete_all);
        updateUI();
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.mNotificationAdapter != null) {
            updateUI();
        }
    }

    public void onComplete(Boolean bool, String str) {
        if (bool.booleanValue() && str.equals(AppConstant.BUNDLE_KEY_DELETE_ALL_NOT)) {
            this.mNotificationDbController.deleteAllNot();
            updateUI();
        }
    }
}
