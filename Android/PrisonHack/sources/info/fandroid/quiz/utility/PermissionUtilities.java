package info.fandroid.quiz.utility;

import android.app.Activity;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.content.ContextCompat;

public class PermissionUtilities {
    public static String[] CALL_PERMISSIONS = {"android.permission.CALL_PHONE"};
    public static final int REQUEST_CALL = 114;
    public static final int REQUEST_WRITE_STORAGE_DOWNLOAD = 112;
    public static final int REQUEST_WRITE_STORAGE_UPLOAD = 113;
    public static String[] SD_WRITE_PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    public static boolean isPermissionGranted(Activity activity, String[] strArr, int i) {
        boolean z;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (ContextCompat.checkSelfPermission(activity, strArr[i2]) != 0) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        if (!z) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, strArr, i);
        return false;
    }

    public static boolean isPermissionResultGranted(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
