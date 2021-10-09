package info.fandroid.quiz.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import info.fandroid.quiz.models.notification.NotificationModel;
import java.util.ArrayList;

public class NotificationDbController {
    private static final String mREAD = "read";
    private static final String mUNREAD = "unread";
    private SQLiteDatabase mDb;

    public NotificationDbController(Context context) {
        this.mDb = DbHelper.getInstance(context).getWritableDatabase();
    }

    public int insertData(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbConstants.COLUMN_NOTI_TITLE, str);
        contentValues.put(DbConstants.COLUMN_NOTI_MESSAGE, str2);
        contentValues.put(DbConstants.COLUMN_NOTI_READ_STATUS, mUNREAD);
        contentValues.put(DbConstants.COLUMN_NOTI_CONTENT_URL, str3);
        return (int) this.mDb.insert(DbConstants.NOTIFICATION_TABLE_NAME, DbConstants.COLUMN_NAME_NULLABLE, contentValues);
    }

    public ArrayList<NotificationModel> getAllData() {
        return fetchData(this.mDb.query(DbConstants.NOTIFICATION_TABLE_NAME, new String[]{"_id", DbConstants.COLUMN_NOTI_TITLE, DbConstants.COLUMN_NOTI_MESSAGE, DbConstants.COLUMN_NOTI_READ_STATUS, DbConstants.COLUMN_NOTI_CONTENT_URL}, (String) null, (String[]) null, (String) null, (String) null, "_id DESC"));
    }

    public ArrayList<NotificationModel> getUnreadData() {
        return fetchData(this.mDb.query(DbConstants.NOTIFICATION_TABLE_NAME, new String[]{"_id", DbConstants.COLUMN_NOTI_TITLE, DbConstants.COLUMN_NOTI_MESSAGE, DbConstants.COLUMN_NOTI_READ_STATUS, DbConstants.COLUMN_NOTI_CONTENT_URL}, "not_status=?", new String[]{mUNREAD}, (String) null, (String) null, "_id DESC"));
    }

    private ArrayList<NotificationModel> fetchData(Cursor cursor) {
        ArrayList<NotificationModel> arrayList = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.COLUMN_NOTI_TITLE));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.COLUMN_NOTI_MESSAGE));
                    String string3 = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.COLUMN_NOTI_READ_STATUS));
                    arrayList.add(new NotificationModel(i, string, string2, !string3.equals(mREAD), cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.COLUMN_NOTI_CONTENT_URL))));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return arrayList;
    }

    public void updateStatus(int i, boolean z) {
        String str = mUNREAD;
        if (z) {
            str = mREAD;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbConstants.COLUMN_NOTI_READ_STATUS, str);
        this.mDb.update(DbConstants.NOTIFICATION_TABLE_NAME, contentValues, "_id=?", new String[]{String.valueOf(i)});
    }

    public void deleteAllNot() {
        this.mDb.delete(DbConstants.NOTIFICATION_TABLE_NAME, (String) null, (String[]) null);
    }
}
