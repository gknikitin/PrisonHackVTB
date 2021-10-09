package info.fandroid.quiz.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.billing.BillingProcessor;
import info.fandroid.quiz.billing.TransactionDetails;

public class SettingsFragment extends PreferenceFragment implements BillingProcessor.IBillingHandler {
    private static String PRODUCT_ID_BOUGHT = "item_1_bought";
    private static String PRODUCT_ID_SUBSCRIBE = "item_1_subscribe";
    public static String SHOW_DIALOG = "show_dialog";
    boolean HIDE_RATE_MY_APP = false;

    /* renamed from: bp */
    BillingProcessor f94bp;
    AlertDialog dialog;
    String menu;
    Preference preferencepurchase;
    Preference preferencesubscribe;
    String start;

    public void onBillingInitialized() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C0683R.xml.settings_preference);
        String string = getResources().getString(C0683R.string.google_play_license);
        this.f94bp = new BillingProcessor(getActivity(), string, this);
        this.f94bp.loadOwnedPurchasesFromGoogle();
        this.preferencepurchase = findPreference("purchase");
        if (string != null && !string.equals("")) {
            this.preferencepurchase.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    SettingsFragment.this.f94bp.purchase(SettingsFragment.this.getActivity(), SettingsFragment.this.PRODUCT_ID());
                    return true;
                }
            });
            if (getIsPurchased(getActivity())) {
                this.preferencepurchase.setIcon(C0683R.C0685drawable.ic_action_action_done);
            }
        }
    }

    public void onProductPurchased(String str, TransactionDetails transactionDetails) {
        if (str.equals(PRODUCT_ID())) {
            setIsPurchased(true, getActivity());
            this.preferencepurchase.setIcon(C0683R.C0685drawable.ic_action_action_done);
            Toast.makeText(getActivity(), getResources().getString(C0683R.string.settings_purchase_success), 1).show();
            Log.v("TAG", "Purchase purchased");
        }
        Log.v("TAG", "Purchase or subscribe purchased");
    }

    public void onBillingError(int i, Throwable th) {
        Toast.makeText(getActivity(), getResources().getString(C0683R.string.settings_purchase_fail), 1).show();
        Log.v("TAG", "Error");
    }

    public void onPurchaseHistoryRestored() {
        if (this.f94bp.isPurchased(PRODUCT_ID())) {
            setIsPurchased(true, getActivity());
            Log.v("TAG", "Purchase actually restored");
            this.preferencepurchase.setIcon(C0683R.C0685drawable.ic_action_action_done);
            if (this.dialog != null) {
                this.dialog.cancel();
            }
            Toast.makeText(getActivity(), getResources().getString(C0683R.string.settings_restore_purchase_success), 1).show();
        }
        Log.v("TAG", "Purchase and subscription restored called");
    }

    public void setIsPurchased(boolean z, Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(PRODUCT_ID_BOUGHT, z);
        edit.apply();
    }

    public static boolean getIsPurchased(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PRODUCT_ID_BOUGHT, false);
    }

    /* access modifiers changed from: private */
    public String PRODUCT_ID() {
        return getResources().getString(C0683R.string.product_id);
    }

    private String SUBSCRIPTION_ID() {
        return getResources().getString(C0683R.string.subscription_id);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f94bp.handleActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        if (this.f94bp != null) {
            this.f94bp.release();
        }
        super.onDestroy();
    }
}
