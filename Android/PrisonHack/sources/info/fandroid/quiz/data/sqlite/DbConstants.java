package info.fandroid.quiz.data.sqlite;

import android.provider.BaseColumns;

public class DbConstants implements BaseColumns {
    public static final String COLUMN_NAME_NULLABLE = null;
    public static final String COLUMN_NOTI_CONTENT_URL = "content_url";
    public static final String COLUMN_NOTI_MESSAGE = "not_message";
    public static final String COLUMN_NOTI_READ_STATUS = "not_status";
    public static final String COLUMN_NOTI_TITLE = "not_title";
    private static final String COMMA_SEP = ",";
    public static final String NOTIFICATION_TABLE_NAME = "notifications";
    public static final String SQL_CREATE_NOTIFICATION_ENTRIES = "CREATE TABLE notifications (_id INTEGER PRIMARY KEY,not_title TEXT,not_message TEXT,content_url TEXT,not_status TEXT )";
    public static final String SQL_DELETE_NOTIFICATION_ENTRIES = "DROP TABLE IF EXISTS notifications";
    private static final String TEXT_TYPE = " TEXT";
}
