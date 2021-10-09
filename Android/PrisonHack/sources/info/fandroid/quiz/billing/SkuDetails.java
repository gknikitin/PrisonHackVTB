package info.fandroid.quiz.billing;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
    public final String currency;
    public final String description;
    public final boolean isSubscription;
    public final String priceText;
    public final Double priceValue;
    public final String productId;
    public final String title;

    public SkuDetails(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("type");
        optString = optString == null ? Constants.PRODUCT_TYPE_MANAGED : optString;
        this.productId = jSONObject.optString(Constants.RESPONSE_PRODUCT_ID);
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString(Constants.RESPONSE_DESCRIPTION);
        this.isSubscription = optString.equalsIgnoreCase(Constants.PRODUCT_TYPE_SUBSCRIPTION);
        this.currency = jSONObject.optString(Constants.RESPONSE_PRICE_CURRENCY);
        this.priceValue = Double.valueOf(jSONObject.optDouble(Constants.RESPONSE_PRICE_MICROS) / 1000000.0d);
        this.priceText = jSONObject.optString("price");
    }

    public String toString() {
        return String.format("%s: %s(%s) %f in %s (%s)", new Object[]{this.productId, this.title, this.description, this.priceValue, this.currency, this.priceText});
    }
}
