package info.fandroid.quiz.billing;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

class BillingCache extends BillingBase {
    private static final String ENTRY_DELIMITER = "#####";
    private static final String LINE_DELIMITER = ">>>>>";
    private static final String VERSION_KEY = ".version";
    private String cacheKey;
    private HashMap<String, PurchaseInfo> data = new HashMap<>();
    private String version;

    public BillingCache(Context context, String str) {
        super(context);
        this.cacheKey = str;
        load();
    }

    private String getPreferencesCacheKey() {
        return getPreferencesBaseKey() + this.cacheKey;
    }

    private String getPreferencesVersionKey() {
        return getPreferencesCacheKey() + VERSION_KEY;
    }

    private void load() {
        for (String str : loadString(getPreferencesCacheKey(), "").split(Pattern.quote(ENTRY_DELIMITER))) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(Pattern.quote(LINE_DELIMITER));
                if (split.length > 2) {
                    this.data.put(split[0], new PurchaseInfo(split[1], split[2]));
                } else if (split.length > 1) {
                    this.data.put(split[0], new PurchaseInfo(split[1], (String) null));
                }
            }
        }
        this.version = getCurrentVersion();
    }

    private void flush() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.data.keySet()) {
            PurchaseInfo purchaseInfo = this.data.get(next);
            arrayList.add(next + LINE_DELIMITER + purchaseInfo.responseData + LINE_DELIMITER + purchaseInfo.signature);
        }
        saveString(getPreferencesCacheKey(), TextUtils.join(ENTRY_DELIMITER, arrayList));
        this.version = Long.toString(new Date().getTime());
        saveString(getPreferencesVersionKey(), this.version);
    }

    public boolean includesProduct(String str) {
        reloadDataIfNeeded();
        return this.data.containsKey(str);
    }

    public PurchaseInfo getDetails(String str) {
        reloadDataIfNeeded();
        if (this.data.containsKey(str)) {
            return this.data.get(str);
        }
        return null;
    }

    public void put(String str, String str2, String str3) {
        reloadDataIfNeeded();
        if (!this.data.containsKey(str)) {
            this.data.put(str, new PurchaseInfo(str2, str3));
            flush();
        }
    }

    public void remove(String str) {
        reloadDataIfNeeded();
        if (this.data.containsKey(str)) {
            this.data.remove(str);
            flush();
        }
    }

    public void clear() {
        reloadDataIfNeeded();
        this.data.clear();
        flush();
    }

    private String getCurrentVersion() {
        return loadString(getPreferencesVersionKey(), "0");
    }

    private void reloadDataIfNeeded() {
        if (!this.version.equalsIgnoreCase(getCurrentVersion())) {
            this.data.clear();
            load();
        }
    }

    public List<String> getContents() {
        return new ArrayList(this.data.keySet());
    }

    public String toString() {
        return TextUtils.join(", ", this.data.keySet());
    }
}
