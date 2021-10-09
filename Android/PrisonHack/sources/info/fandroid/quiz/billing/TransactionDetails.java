package info.fandroid.quiz.billing;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class TransactionDetails {
    public final String orderId;
    public final String productId;
    public final PurchaseInfo purchaseInfo;
    public final Date purchaseTime;
    public final String purchaseToken;

    public TransactionDetails(PurchaseInfo purchaseInfo2) throws JSONException {
        JSONObject jSONObject = new JSONObject(purchaseInfo2.responseData);
        this.purchaseInfo = purchaseInfo2;
        this.productId = jSONObject.getString(Constants.RESPONSE_PRODUCT_ID);
        this.orderId = jSONObject.optString(Constants.RESPONSE_ORDER_ID);
        this.purchaseToken = jSONObject.getString(Constants.RESPONSE_PURCHASE_TOKEN);
        this.purchaseTime = new Date(jSONObject.getLong(Constants.RESPONSE_PURCHASE_TIME));
    }

    public String toString() {
        return String.format("%s purchased at %s(%s). Token: %s, Signature: %s", new Object[]{this.productId, this.purchaseTime, this.orderId, this.purchaseToken, this.purchaseInfo.signature});
    }
}
