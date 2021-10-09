package info.fandroid.quiz.utility;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import info.fandroid.quiz.utility.DateUtilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FilePickerUtilities {
    private static final String CHOOSER_MSG = "Choose Option";
    private static final String IMAGE_EXTENSION = ".jpg";
    private static final String IMAGE_PREFIX = "IMG_";
    private static String pictureTempPath = "";

    public static Intent getPickFileIntent(Context context) {
        ArrayList arrayList = new ArrayList();
        addIntentsToList(context, arrayList, getGalleryIntent());
        addIntentsToList(context, arrayList, getCameraIntent(context));
        addIntentsToList(context, arrayList, getFileIntent());
        if (arrayList.size() <= 0) {
            return null;
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), CHOOSER_MSG);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        return createChooser;
    }

    public static Intent getCameraPickerIntent(Context context) {
        ArrayList arrayList = new ArrayList();
        addIntentsToList(context, arrayList, getCameraIntent(context));
        if (arrayList.size() <= 0) {
            return null;
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), CHOOSER_MSG);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        return createChooser;
    }

    public static Intent getGalleryPickerIntent(Context context) {
        ArrayList arrayList = new ArrayList();
        addIntentsToList(context, arrayList, getGalleryIntent());
        if (arrayList.size() <= 0) {
            return null;
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), CHOOSER_MSG);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        return createChooser;
    }

    public static String getPickedFilePath(Context context, Intent intent) {
        if (intent == null || intent.getData() == null) {
            return pictureTempPath;
        }
        return getImagePath(context, intent.getData());
    }

    private static String getImagePath(Context context, Uri uri) {
        String str;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            str = query.getString(query.getColumnIndex("_data"));
            try {
                query.close();
                return str;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            e.printStackTrace();
            return str;
        }
    }

    private static Intent getFileIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        return intent;
    }

    private static Intent getCameraIntent(Context context) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            intent.putExtra("return-data", true);
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), (IMAGE_PREFIX + new SimpleDateFormat(DateUtilities.DateTimeFormat.YYMMDD_HHMMSS.toString(), Locale.US).format(new Date())) + IMAGE_EXTENSION);
            pictureTempPath = file.getAbsolutePath();
            intent.putExtra("output", Uri.fromFile(file));
        }
        return intent;
    }

    private static Intent getGalleryIntent() {
        return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    private static void addIntentsToList(Context context, List<Intent> list, Intent intent) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            Intent intent2 = new Intent(intent);
            intent2.setPackage(str);
            list.add(intent2);
        }
    }
}
