package info.fandroid.quiz.utility;

import android.app.Activity;
import android.content.Intent;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.models.quiz.ResultModel;
import java.util.ArrayList;

public class ActivityUtilities {
    private static ActivityUtilities sActivityUtilities;

    public static ActivityUtilities getInstance() {
        if (sActivityUtilities == null) {
            sActivityUtilities = new ActivityUtilities();
        }
        return sActivityUtilities;
    }

    public void invokeNewActivity(Activity activity, Class<?> cls, boolean z) {
        activity.startActivity(new Intent(activity, cls));
        if (z) {
            activity.finish();
        }
    }

    public void invokeCustomUrlActivity(Activity activity, Class<?> cls, String str, String str2, boolean z) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("title", str);
        intent.putExtra("url", str2);
        activity.startActivity(intent);
        if (z) {
            activity.finish();
        }
    }

    public void invokeCommonQuizActivity(Activity activity, Class<?> cls, String str, boolean z) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("index", str);
        activity.startActivity(intent);
        if (z) {
            activity.finish();
        }
    }

    public void invokeScoreCardActivity(Activity activity, Class<?> cls, int i, int i2, int i3, String str, ArrayList<ResultModel> arrayList, boolean z) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("score", i);
        intent.putExtra(AppConstant.BUNDLE_KEY_WRONG_ANS, i2);
        intent.putExtra("skip", i3);
        intent.putExtra("index", str);
        intent.putParcelableArrayListExtra(AppConstant.BUNDLE_KEY_ITEM, arrayList);
        activity.startActivity(intent);
        if (z) {
            activity.finish();
        }
    }
}
