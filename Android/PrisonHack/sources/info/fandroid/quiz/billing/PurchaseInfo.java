package info.fandroid.quiz.billing;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseInfo {
    public final String responseData;
    public final String signature;

    public enum PurchaseState {
        PurchasedSuccessfully,
        Canceled,
        Refunded,
        SubscriptionExpired
    }

    PurchaseInfo(String str, String str2) {
        this.responseData = str;
        this.signature = str2;
    }

    public class ResponseData {
        public boolean autoRenewing;
        public String developerPayload;
        public String orderId;
        public String packageName;
        public String productId;
        public PurchaseState purchaseState;
        public Date purchaseTime;
        public String purchaseToken;

        public ResponseData() {
        }
    }

    public static PurchaseState getPurchaseState(int i) {
        switch (i) {
            case 0:
                return PurchaseState.PurchasedSuccessfully;
            case 1:
                return PurchaseState.Canceled;
            case 2:
                return PurchaseState.Refunded;
            case 3:
                return PurchaseState.SubscriptionExpired;
            default:
                return PurchaseState.Canceled;
        }
    }

    public ResponseData parseResponseData() {
        try {
            JSONObject jSONObject = new JSONObject(this.responseData);
            ResponseData responseData2 = new ResponseData();
            responseData2.orderId = jSONObject.optString(Constants.RESPONSE_ORDER_ID);
            responseData2.packageName = jSONObject.optString("packageName");
            responseData2.productId = jSONObject.optString(Constants.RESPONSE_PRODUCT_ID);
            long optLong = jSONObject.optLong(Constants.RESPONSE_PURCHASE_TIME, 0);
            responseData2.purchaseTime = optLong != 0 ? new Date(optLong) : null;
            responseData2.purchaseState = getPurchaseState(jSONObject.optInt("purchaseState", 1));
            responseData2.developerPayload = jSONObject.optString(Constants.RESPONSE_PAYLOAD);
            responseData2.purchaseToken = jSONObject.getString(Constants.RESPONSE_PURCHASE_TOKEN);
            responseData2.autoRenewing = jSONObject.optBoolean("autoRenewing");
            return responseData2;
        } catch (JSONException unused) {
            return null;
        }
    }
}
