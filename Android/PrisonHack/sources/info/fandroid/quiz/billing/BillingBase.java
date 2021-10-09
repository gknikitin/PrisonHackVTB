package info.fandroid.quiz.billing;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;

class BillingBase {
    private WeakReference<Context> contextReference;

    public BillingBase(Context context) {
        this.contextReference = new WeakReference<>(context);
    }

    public Context getContext() {
        return (Context) this.contextReference.get();
    }

    /* access modifiers changed from: protected */
    public String getPreferencesBaseKey() {
        return ((Context) this.contextReference.get()).getPackageName() + "_preferences";
    }

    private SharedPreferences getPreferences() {
        if (this.contextReference.get() != null) {
            return PreferenceManager.getDefaultSharedPreferences((Context) this.contextReference.get());
        }
        return null;
    }

    public void release() {
        if (this.contextReference != null) {
            this.contextReference.clear();
        }
    }

    /* access modifiers changed from: protected */
    public boolean saveString(String str, String str2) {
        SharedPreferences preferences = getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(str, str2);
        edit.commit();
        return true;
    }

    /* access modifiers changed from: protected */
    public String loadString(String str, String str2) {
        SharedPreferences preferences = getPreferences();
        return preferences != null ? preferences.getString(str, str2) : str2;
    }

    /* access modifiers changed from: protected */
    public boolean saveBoolean(String str, Boolean bool) {
        SharedPreferences preferences = getPreferences();
        if (preferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.commit();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean loadBoolean(String str, boolean z) {
        SharedPreferences preferences = getPreferences();
        return preferences != null ? preferences.getBoolean(str, z) : z;
    }
}
