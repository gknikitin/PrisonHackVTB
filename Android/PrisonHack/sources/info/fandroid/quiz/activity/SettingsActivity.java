package info.fandroid.quiz.activity;

import android.os.Bundle;
import android.view.MenuItem;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.fragments.SettingsFragment;
import info.fandroid.quiz.utility.ActivityUtilities;

public class SettingsActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(C0683R.C0686id.content, new SettingsFragment()).commit();
        initToolbar(true);
        setToolbarTitle(getString(C0683R.string.settings));
        enableUpButton();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActivityUtilities.getInstance().invokeNewActivity(this, MainActivity.class, true);
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtilities.getInstance().invokeNewActivity(this, MainActivity.class, true);
    }
}
