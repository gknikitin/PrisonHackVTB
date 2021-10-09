package info.fandroid.quiz.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.p000v4.content.LocalBroadcastManager;
import android.support.p003v7.widget.GridLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.adapters.CategoryAdapter;
import info.fandroid.quiz.billing.BillingProcessor;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.sqlite.NotificationDbController;
import info.fandroid.quiz.fragments.SettingsFragment;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.notification.NotificationModel;
import info.fandroid.quiz.models.quiz.CategoryModel;
import info.fandroid.quiz.notification.MyFirebaseInstanceIDService;
import info.fandroid.quiz.notification.MyFirebaseMessagingService;
import info.fandroid.quiz.utility.ActivityUtilities;
import info.fandroid.quiz.utility.AdsUtilities;
import info.fandroid.quiz.utility.AppUtilities;
import info.fandroid.quiz.utility.DialogUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements DialogUtilities.OnCompleteListener {
    public static String FRAGMENT_CLASS = "transation_target";
    public static String FRAGMENT_DATA = "transaction_data";
    /* access modifiers changed from: private */
    public static String PRODUCT_ID_BOUGHT = "item_1_bought";
    private static String PRODUCT_ID_SUBSCRIBE = "item_1_subscribe";

    /* renamed from: bp */
    BillingProcessor f93bp;
    private AccountHeader headerResult = null;
    /* access modifiers changed from: private */
    public Activity mActivity;
    private CategoryAdapter mAdapter = null;
    /* access modifiers changed from: private */
    public ArrayList<CategoryModel> mCategoryList;
    private Context mContext;
    private RelativeLayout mNotificationView;
    private RecyclerView mRecycler;
    private Toolbar mToolbar;
    private BroadcastReceiver newNotificationReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.initNotification();
        }
    };
    private Drawer result = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            for (String str : getIntent().getExtras().keySet()) {
                Object obj = getIntent().getExtras().get(str);
                Log.d("TAG", "Key: " + str + " Value: " + obj);
            }
        }
        Log.v("TAG", "MainActivity.onCreate");
        initVar();
        initView();
        loadData();
        initListener();
        this.mToolbar = (Toolbar) findViewById(C0683R.C0686id.toolbar);
        setSupportActionBar(this.mToolbar);
        ProfileDrawerItem withIcon = new ProfileDrawerItem().withIcon((int) C0683R.C0685drawable.ic_dev);
        this.headerResult = new AccountHeaderBuilder().withActivity(this).withTranslucentStatusBar(true).withHeaderBackground((int) C0683R.C0685drawable.f9620211008_220322).withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
            public boolean onProfileImageLongClick(View view, IProfile iProfile, boolean z) {
                return false;
            }

            public boolean onProfileImageClick(View view, IProfile iProfile, boolean z) {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(MainActivity.this.mActivity, CustomUrlActivity.class, MainActivity.this.getResources().getString(C0683R.string.site), MainActivity.this.getResources().getString(C0683R.string.site_url), false);
                return false;
            }
        }).addProfiles(withIcon).build();
        this.result = new DrawerBuilder().withActivity(this).withToolbar(this.mToolbar).withHasStableIds(true).withAccountHeader(this.headerResult).addDrawerItems((IDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withName((int) C0683R.string.about_dev)).withIcon((int) C0683R.C0685drawable.ic_dev)).withIdentifier(1)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.youtube)).withIcon((int) C0683R.C0685drawable.ic_youtube)).withIdentifier(20)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.facebook)).withIcon((int) C0683R.C0685drawable.ic_facebook)).withIdentifier(21)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.twitter)).withIcon((int) C0683R.C0685drawable.ic_twitter)).withIdentifier(22)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.google_plus)).withIcon((int) C0683R.C0685drawable.ic_google_plus)).withIdentifier(23)).withSelectable(false), new DividerDrawerItem(), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.settings)).withIcon((int) C0683R.C0685drawable.f99history)).withIdentifier(30)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.rate)).withIcon((int) C0683R.C0685drawable.ic_rating)).withIdentifier(31)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.share)).withIcon((int) C0683R.C0685drawable.ic_share)).withIdentifier(32)).withSelectable(false), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.privacy)).withIcon((int) C0683R.C0685drawable.f98IMG_20211009_173626_319)).withIdentifier(33)).withSelectable(false), new DividerDrawerItem(), (IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName((int) C0683R.string.exit)).withIcon((int) C0683R.C0685drawable.ic_exit)).withIdentifier(40)).withSelectable(false)).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                if (iDrawerItem != null) {
                    if (iDrawerItem.getIdentifier() == 1) {
                        ActivityUtilities.getInstance().invokeNewActivity(MainActivity.this.mActivity, AboutDevActivity.class, false);
                    } else if (iDrawerItem.getIdentifier() == 20) {
                        AppUtilities.youtubeLink(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 21) {
                        AppUtilities.faceBookLink(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 22) {
                        AppUtilities.twitterLink(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 23) {
                        AppUtilities.googlePlusLink(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 30) {
                        ActivityUtilities.getInstance().invokeNewActivity(MainActivity.this.mActivity, SettingsActivity.class, true);
                    } else if (iDrawerItem.getIdentifier() == 31) {
                        AppUtilities.rateThisApp(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 32) {
                        AppUtilities.shareApp(MainActivity.this.mActivity);
                    } else if (iDrawerItem.getIdentifier() == 33) {
                        ActivityUtilities.getInstance().invokeCustomUrlActivity(MainActivity.this.mActivity, CustomUrlActivity.class, MainActivity.this.getResources().getString(C0683R.string.privacy), MainActivity.this.getResources().getString(C0683R.string.privacy_url), false);
                    } else if (iDrawerItem.getIdentifier() == 40) {
                        DialogUtilities.newInstance(MainActivity.this.getString(C0683R.string.exit), MainActivity.this.getString(C0683R.string.close_prompt), MainActivity.this.getString(C0683R.string.yes), MainActivity.this.getString(C0683R.string.f84no), AppConstant.BUNDLE_KEY_EXIT_OPTION).show(MainActivity.this.getSupportFragmentManager(), AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
                    }
                }
                return false;
            }
        }).withSavedInstance(bundle).withShowDrawerOnFirstLaunch(true).withShowDrawerUntilDraggedOpened(true).build();
        if (isMyServiceRunning(MyFirebaseMessagingService.class)) {
            Log.d("RUNNING", " MyFirebaseMessagingService is RUNNING");
        }
        if (isMyServiceRunning(MyFirebaseInstanceIDService.class)) {
            Log.d("RUNNING", " MyFirebaseInstanceIDService is RUNNING");
        }
    }

    private boolean isMyServiceRunning(Class<?> cls) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (cls.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.newNotificationReceiver);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.newNotificationReceiver, new IntentFilter(AppConstant.NEW_NOTI));
        initNotification();
        AdsUtilities.getInstance(this.mContext).loadFullScreenAd(this.mActivity);
    }

    private boolean isPurchased() {
        return SettingsFragment.getIsPurchased(this) || getResources().getString(C0683R.string.google_play_license).equals("");
    }

    public void onBackPressed() {
        if (this.result == null || !this.result.isDrawerOpen()) {
            AppUtilities.tapPromptToExit(this.mActivity);
        } else {
            this.result.closeDrawer();
        }
    }

    private void initVar() {
        this.mActivity = this;
        this.mContext = getApplicationContext();
        this.mCategoryList = new ArrayList<>();
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_main);
        this.mNotificationView = (RelativeLayout) findViewById(C0683R.C0686id.notificationView);
        this.mRecycler = (RecyclerView) findViewById(C0683R.C0686id.rvContent);
        this.mRecycler.setLayoutManager(new GridLayoutManager((Context) this.mActivity, 2, 1, false));
        this.mAdapter = new CategoryAdapter(this.mContext, this.mActivity, this.mCategoryList);
        this.mRecycler.setAdapter(this.mAdapter);
        initLoader();
    }

    private void initListener() {
        this.mNotificationView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(MainActivity.this.mActivity, NotificationListActivity.class, false);
            }
        });
        this.mAdapter.setItemClickListener(new ListItemClickListener() {
            public void onItemClick(int i, View view) {
                boolean z = PreferenceManager.getDefaultSharedPreferences(MainActivity.this.mActivity).getBoolean(MainActivity.PRODUCT_ID_BOUGHT, false);
                if (i <= 3 || z) {
                    ActivityUtilities.getInstance().invokeCommonQuizActivity(MainActivity.this.mActivity, QuizPromptActivity.class, ((CategoryModel) MainActivity.this.mCategoryList.get(i)).getCategoryId(), true);
                } else {
                    ((Snackbar) Snackbar.make(view, (int) C0683R.string.alert_for_purchase, 0).setAction((CharSequence) "Ок", (View.OnClickListener) new View.OnClickListener() {
                        public void onClick(View view) {
                            ActivityUtilities.getInstance().invokeNewActivity(MainActivity.this.mActivity, SettingsActivity.class, true);
                        }
                    }).setDuration(4000)).show();
                }
            }
        });
    }

    private void loadData() {
        showLoader();
        loadJson();
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    private void loadJson() {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(getAssets().open(AppConstant.CONTENT_FILE)));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    BufferedReader bufferedReader3 = bufferedReader2;
                    e = e2;
                    bufferedReader = bufferedReader3;
                    try {
                        e.printStackTrace();
                        bufferedReader.close();
                        parseJson(stringBuffer.toString());
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    bufferedReader.close();
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            bufferedReader.close();
            parseJson(stringBuffer.toString());
        }
        parseJson(stringBuffer.toString());
    }

    private void parseJson(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(AppConstant.JSON_KEY_ITEMS);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                this.mCategoryList.add(new CategoryModel(jSONObject.getString(AppConstant.JSON_KEY_CATEGORY_ID), jSONObject.getString(AppConstant.JSON_KEY_CATEGORY_NAME)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hideLoader();
        this.mAdapter.notifyDataSetChanged();
    }

    public void initNotification() {
        NotificationDbController notificationDbController = new NotificationDbController(this.mContext);
        TextView textView = (TextView) findViewById(C0683R.C0686id.notificationCount);
        textView.setVisibility(4);
        ArrayList<NotificationModel> unreadData = notificationDbController.getUnreadData();
        if (unreadData != null && !unreadData.isEmpty()) {
            int size = unreadData.size();
            if (size > 0) {
                textView.setVisibility(0);
                textView.setText(String.valueOf(size));
                return;
            }
            textView.setVisibility(4);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0683R.C0687menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C0683R.C0686id.action_settings) {
            ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, SettingsActivity.class, true);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onComplete(Boolean bool, String str) {
        if (bool.booleanValue() && str.equals(AppConstant.BUNDLE_KEY_EXIT_OPTION)) {
            this.mActivity.finishAffinity();
        }
    }
}
