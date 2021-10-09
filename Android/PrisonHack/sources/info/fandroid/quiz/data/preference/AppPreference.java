package info.fandroid.quiz.data.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;

public class AppPreference {
    private static AppPreference mAppPreference;
    private static Context mContext;
    private SharedPreferences.Editor mEditor = this.mSharedPreferences.edit();
    private SharedPreferences mSettingsPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    private SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PrefKey.APP_PREF_NAME, 0);

    public static AppPreference getInstance(Context context) {
        if (mAppPreference == null) {
            mContext = context;
            mAppPreference = new AppPreference();
        }
        return mAppPreference;
    }

    private AppPreference() {
    }

    public String getString(String str) {
        return this.mSharedPreferences.getString(str, (String) null);
    }

    public void setBoolean(String str, boolean z) {
        this.mEditor.putBoolean(str, z);
        this.mEditor.commit();
    }

    public Boolean getBoolean(String str, boolean z) {
        return Boolean.valueOf(this.mSharedPreferences.getBoolean(str, z));
    }

    public boolean isNotificationOn() {
        return this.mSettingsPreferences.getBoolean(AppConstant.PREF_NOTIFICATION, true);
    }

    public String getTextSize() {
        return this.mSettingsPreferences.getString(AppConstant.PREF_FONT_SIZE, mContext.getResources().getString(C0683R.string.default_text));
    }
}
