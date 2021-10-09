package info.fandroid.quiz.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.google.android.gms.common.util.CrashUtils;
import info.fandroid.quiz.C0683R;

public class AppUtilities {
    private static long backPressed;

    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void tapPromptToExit(Activity activity) {
        if (backPressed + 2500 > System.currentTimeMillis()) {
            activity.finish();
        } else {
            showToast(activity.getApplicationContext(), activity.getResources().getString(C0683R.string.tapAgain));
        }
        backPressed = System.currentTimeMillis();
    }

    public static void youtubeLink(Activity activity) {
        updateLink(activity, activity.getString(C0683R.string.youtube_url));
    }

    public static void faceBookLink(Activity activity) {
        try {
            if (activity.getPackageManager().getApplicationInfo("com.facebook.katana", 0).enabled) {
                updateLink(activity, "fb://facewebmodal/f?href=" + activity.getString(C0683R.string.facebook_url));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        updateLink(activity, activity.getString(C0683R.string.facebook_url));
    }

    public static void twitterLink(Activity activity) {
        try {
            if (activity.getPackageManager().getApplicationInfo("com.twitter.android", 0).enabled) {
                updateLink(activity, activity.getString(C0683R.string.f100dummy_ae_de));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        updateLink(activity, activity.getString(C0683R.string.twitter_url));
    }

    public static void googlePlusLink(Activity activity) {
        updateLink(activity, activity.getString(C0683R.string.google_plus_url));
    }

    private static void updateLink(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(CrashUtils.ErrorDialogData.BINDER_CRASH);
        if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
            activity.startActivity(intent);
        }
    }

    public static void shareApp(Activity activity) {
        try {
            String packageName = activity.getPackageName();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", activity.getResources().getString(C0683R.string.share_text) + " https://play.google.com/store/apps/details?id=" + packageName);
            intent.setType("text/plain");
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rateThisApp(Activity activity) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
