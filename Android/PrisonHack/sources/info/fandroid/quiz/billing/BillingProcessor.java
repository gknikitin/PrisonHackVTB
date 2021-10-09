package info.fandroid.quiz.billing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class BillingProcessor extends BillingBase {
    private static final String LOG_TAG = "iabv3";
    private static final String MANAGED_PRODUCTS_CACHE_KEY = ".products.cache.v2_6";
    private static final int PURCHASE_FLOW_REQUEST_CODE = 32459;
    private static final String PURCHASE_PAYLOAD_CACHE_KEY = ".purchase.last.v2_6";
    private static final String RESTORE_KEY = ".products.restored.v2_6";
    private static final String SETTINGS_VERSION = ".v2_6";
    private static final String SUBSCRIPTIONS_CACHE_KEY = ".subscriptions.cache.v2_6";
    /* access modifiers changed from: private */
    public IInAppBillingService billingService;
    private BillingCache cachedProducts;
    private BillingCache cachedSubscriptions;
    private String contextPackageName;
    /* access modifiers changed from: private */
    public IBillingHandler eventHandler;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName componentName) {
            IInAppBillingService unused = BillingProcessor.this.billingService = null;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IInAppBillingService unused = BillingProcessor.this.billingService = IInAppBillingService.Stub.asInterface(iBinder);
            if (!BillingProcessor.this.isPurchaseHistoryRestored() && BillingProcessor.this.loadOwnedPurchasesFromGoogle()) {
                BillingProcessor.this.setPurchaseHistoryRestored();
                if (BillingProcessor.this.eventHandler != null) {
                    BillingProcessor.this.eventHandler.onPurchaseHistoryRestored();
                }
            }
            if (BillingProcessor.this.eventHandler != null) {
                BillingProcessor.this.eventHandler.onBillingInitialized();
            }
        }
    };
    private String signatureBase64;

    public interface IBillingHandler {
        void onBillingError(int i, Throwable th);

        void onBillingInitialized();

        void onProductPurchased(String str, TransactionDetails transactionDetails);

        void onPurchaseHistoryRestored();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public BillingProcessor(Context context, String str, IBillingHandler iBillingHandler) {
        super(context);
        this.signatureBase64 = str;
        this.eventHandler = iBillingHandler;
        this.contextPackageName = context.getApplicationContext().getPackageName();
        this.cachedProducts = new BillingCache(context, MANAGED_PRODUCTS_CACHE_KEY);
        this.cachedSubscriptions = new BillingCache(context, SUBSCRIPTIONS_CACHE_KEY);
        bindPlayServices();
    }

    private void bindPlayServices() {
        try {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            getContext().bindService(intent, this.serviceConnection, 1);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString());
        }
    }

    public void release() {
        if (!(this.serviceConnection == null || getContext() == null)) {
            try {
                getContext().unbindService(this.serviceConnection);
            } catch (Exception e) {
                Log.e(LOG_TAG, e.toString());
            }
            this.billingService = null;
        }
        this.cachedProducts.release();
        super.release();
    }

    public boolean isInitialized() {
        return this.billingService != null;
    }

    public boolean isPurchased(String str) {
        return this.cachedProducts.includesProduct(str);
    }

    public boolean isSubscribed(String str) {
        return this.cachedSubscriptions.includesProduct(str);
    }

    public List<String> listOwnedProducts() {
        return this.cachedProducts.getContents();
    }

    public List<String> listOwnedSubscriptions() {
        return this.cachedSubscriptions.getContents();
    }

    private boolean loadPurchasesByType(String str, BillingCache billingCache) {
        if (!isInitialized()) {
            return false;
        }
        try {
            Bundle purchases = this.billingService.getPurchases(3, this.contextPackageName, str, (String) null);
            if (purchases.getInt(Constants.RESPONSE_CODE) != 0) {
                return true;
            }
            billingCache.clear();
            ArrayList<String> stringArrayList = purchases.getStringArrayList(Constants.INAPP_PURCHASE_DATA_LIST);
            ArrayList<String> stringArrayList2 = purchases.getStringArrayList(Constants.INAPP_DATA_SIGNATURE_LIST);
            int i = 0;
            while (i < stringArrayList.size()) {
                String str2 = stringArrayList.get(i);
                billingCache.put(new JSONObject(str2).getString(Constants.RESPONSE_PRODUCT_ID), str2, (stringArrayList2 == null || stringArrayList2.size() <= i) ? null : stringArrayList2.get(i));
                i++;
            }
            return true;
        } catch (Exception e) {
            if (this.eventHandler != null) {
                this.eventHandler.onBillingError(100, e);
            }
            Log.e(LOG_TAG, e.toString());
            return false;
        }
    }

    public boolean loadOwnedPurchasesFromGoogle() {
        return isInitialized() && loadPurchasesByType(Constants.PRODUCT_TYPE_MANAGED, this.cachedProducts) && loadPurchasesByType(Constants.PRODUCT_TYPE_SUBSCRIPTION, this.cachedSubscriptions);
    }

    public boolean purchase(Activity activity, String str) {
        return purchase(activity, str, Constants.PRODUCT_TYPE_MANAGED);
    }

    public boolean subscribe(Activity activity, String str) {
        return purchase(activity, str, Constants.PRODUCT_TYPE_SUBSCRIPTION);
    }

    private boolean purchase(Activity activity, String str, String str2) {
        if (!isInitialized() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String str3 = str2 + ":" + UUID.randomUUID().toString();
            savePurchasePayload(str3);
            Bundle buyIntent = this.billingService.getBuyIntent(3, this.contextPackageName, str, str2, str3);
            if (buyIntent == null) {
                return true;
            }
            int i = buyIntent.getInt(Constants.RESPONSE_CODE);
            if (i == 0) {
                PendingIntent pendingIntent = (PendingIntent) buyIntent.getParcelable(Constants.BUY_INTENT);
                if (activity != null) {
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), PURCHASE_FLOW_REQUEST_CODE, new Intent(), 0, 0, 0);
                    return true;
                } else if (this.eventHandler == null) {
                    return true;
                } else {
                    this.eventHandler.onBillingError(103, (Throwable) null);
                    return true;
                }
            } else if (i == 7) {
                if (!isPurchased(str) && !isSubscribed(str)) {
                    loadOwnedPurchasesFromGoogle();
                }
                if (this.eventHandler == null) {
                    return true;
                }
                TransactionDetails purchaseTransactionDetails = getPurchaseTransactionDetails(str);
                if (purchaseTransactionDetails == null) {
                    purchaseTransactionDetails = getSubscriptionTransactionDetails(str);
                }
                this.eventHandler.onProductPurchased(str, purchaseTransactionDetails);
                return true;
            } else if (this.eventHandler == null) {
                return true;
            } else {
                this.eventHandler.onBillingError(101, (Throwable) null);
                return true;
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString());
            return false;
        }
    }

    private TransactionDetails getPurchaseTransactionDetails(String str, BillingCache billingCache) {
        PurchaseInfo details = billingCache.getDetails(str);
        if (details == null || TextUtils.isEmpty(details.responseData)) {
            return null;
        }
        try {
            return new TransactionDetails(details);
        } catch (JSONException unused) {
            Log.e(LOG_TAG, "Failed to load saved purchase details for " + str);
            return null;
        }
    }

    public boolean consumePurchase(String str) {
        if (!isInitialized()) {
            return false;
        }
        try {
            TransactionDetails purchaseTransactionDetails = getPurchaseTransactionDetails(str, this.cachedProducts);
            if (purchaseTransactionDetails != null && !TextUtils.isEmpty(purchaseTransactionDetails.purchaseToken)) {
                int consumePurchase = this.billingService.consumePurchase(3, this.contextPackageName, purchaseTransactionDetails.purchaseToken);
                if (consumePurchase == 0) {
                    this.cachedProducts.remove(str);
                    Log.d(LOG_TAG, "Successfully consumed " + str + " purchase.");
                    return true;
                }
                if (this.eventHandler != null) {
                    this.eventHandler.onBillingError(consumePurchase, (Throwable) null);
                }
                Log.e(LOG_TAG, String.format("Failed to consume %s: error %d", new Object[]{str, Integer.valueOf(consumePurchase)}));
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString());
        }
        return false;
    }

    private SkuDetails getSkuDetails(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<SkuDetails> skuDetails = getSkuDetails((ArrayList<String>) arrayList, str2);
        if (skuDetails == null || skuDetails.size() <= 0) {
            return null;
        }
        return skuDetails.get(0);
    }

    private List<SkuDetails> getSkuDetails(ArrayList<String> arrayList, String str) {
        if (!(this.billingService == null || arrayList == null || arrayList.size() <= 0)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(Constants.PRODUCTS_LIST, arrayList);
                Bundle skuDetails = this.billingService.getSkuDetails(3, this.contextPackageName, str, bundle);
                int i = skuDetails.getInt(Constants.RESPONSE_CODE);
                if (i == 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> it = skuDetails.getStringArrayList(Constants.DETAILS_LIST).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new SkuDetails(new JSONObject(it.next())));
                    }
                    return arrayList2;
                }
                if (this.eventHandler != null) {
                    this.eventHandler.onBillingError(i, (Throwable) null);
                }
                Log.e(LOG_TAG, String.format("Failed to retrieve info for %d products, %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(i)}));
            } catch (Exception e) {
                Log.e(LOG_TAG, String.format("Failed to call getSkuDetails %s", new Object[]{e.toString()}));
            }
        }
        return null;
    }

    public SkuDetails getPurchaseListingDetails(String str) {
        return getSkuDetails(str, Constants.PRODUCT_TYPE_MANAGED);
    }

    public SkuDetails getSubscriptionListingDetails(String str) {
        return getSkuDetails(str, Constants.PRODUCT_TYPE_SUBSCRIPTION);
    }

    public List<SkuDetails> getPurchaseListingDetails(ArrayList<String> arrayList) {
        return getSkuDetails(arrayList, Constants.PRODUCT_TYPE_MANAGED);
    }

    public List<SkuDetails> getSubscriptionListingDetails(ArrayList<String> arrayList) {
        return getSkuDetails(arrayList, Constants.PRODUCT_TYPE_SUBSCRIPTION);
    }

    public TransactionDetails getPurchaseTransactionDetails(String str) {
        return getPurchaseTransactionDetails(str, this.cachedProducts);
    }

    public TransactionDetails getSubscriptionTransactionDetails(String str) {
        return getPurchaseTransactionDetails(str, this.cachedSubscriptions);
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        if (i != PURCHASE_FLOW_REQUEST_CODE) {
            return false;
        }
        if (intent == null) {
            Log.e(LOG_TAG, "handleActivityResult: data is null!");
            return false;
        }
        int intExtra = intent.getIntExtra(Constants.RESPONSE_CODE, 0);
        Log.d(LOG_TAG, String.format("resultCode = %d, responseCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(intExtra)}));
        String purchasePayload = getPurchasePayload();
        if (i2 == -1 && intExtra == 0 && !TextUtils.isEmpty(purchasePayload)) {
            String stringExtra = intent.getStringExtra(Constants.INAPP_PURCHASE_DATA);
            String stringExtra2 = intent.getStringExtra(Constants.RESPONSE_INAPP_SIGNATURE);
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String string = jSONObject.getString(Constants.RESPONSE_PRODUCT_ID);
                String string2 = jSONObject.getString(Constants.RESPONSE_PAYLOAD);
                if (string2 == null) {
                    string2 = "";
                }
                boolean startsWith = purchasePayload.startsWith(Constants.PRODUCT_TYPE_SUBSCRIPTION);
                if (!purchasePayload.equals(string2)) {
                    Log.e(LOG_TAG, String.format("Payload mismatch: %s != %s", new Object[]{purchasePayload, string2}));
                    if (this.eventHandler != null) {
                        this.eventHandler.onBillingError(102, (Throwable) null);
                    }
                } else if (verifyPurchaseSignature(string, stringExtra, stringExtra2)) {
                    (startsWith ? this.cachedSubscriptions : this.cachedProducts).put(string, stringExtra, stringExtra2);
                    if (this.eventHandler != null) {
                        this.eventHandler.onProductPurchased(string, new TransactionDetails(new PurchaseInfo(stringExtra, stringExtra2)));
                    }
                } else {
                    Log.e(LOG_TAG, "Public key signature doesn't match!");
                    if (this.eventHandler != null) {
                        this.eventHandler.onBillingError(102, (Throwable) null);
                    }
                }
            } catch (Exception e) {
                Log.e(LOG_TAG, e.toString());
                if (this.eventHandler != null) {
                    this.eventHandler.onBillingError(110, (Throwable) null);
                }
            }
        } else if (this.eventHandler != null) {
            this.eventHandler.onBillingError(intExtra, (Throwable) null);
        }
        return true;
    }

    private boolean verifyPurchaseSignature(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(this.signatureBase64)) {
                return true;
            }
            return Security.verifyPurchase(str, this.signatureBase64, str2, str3);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isValid(TransactionDetails transactionDetails) {
        return verifyPurchaseSignature(transactionDetails.productId, transactionDetails.purchaseInfo.responseData, transactionDetails.purchaseInfo.signature);
    }

    /* access modifiers changed from: private */
    public boolean isPurchaseHistoryRestored() {
        return loadBoolean(getPreferencesBaseKey() + RESTORE_KEY, false);
    }

    public void setPurchaseHistoryRestored() {
        saveBoolean(getPreferencesBaseKey() + RESTORE_KEY, true);
    }

    private void savePurchasePayload(String str) {
        saveString(getPreferencesBaseKey() + PURCHASE_PAYLOAD_CACHE_KEY, str);
    }

    private String getPurchasePayload() {
        return loadString(getPreferencesBaseKey() + PURCHASE_PAYLOAD_CACHE_KEY, (String) null);
    }
}
