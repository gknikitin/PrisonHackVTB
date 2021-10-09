package info.fandroid.quiz.notification;

import android.content.Intent;
import android.support.p000v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.sqlite.NotificationDbController;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String CHANNEL_NAME = "Notification Channel";
    public static final String NOTIFICATION_CHANNEL_ID = "channel_id";
    int importance = 3;

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("FCMess", "onMessageReceived: " + remoteMessage);
        if (remoteMessage.getData().size() > 0) {
            Map<String, String> data = remoteMessage.getData();
            sendNotification(data.get("title"), data.get(AppConstant.BUNDLE_KEY_MESSAGE), data.get("url"));
            broadcastNewNotification();
        }
    }

    public void onMessageSent(String str) {
        super.onMessageSent(str);
        Log.d("FCMess", "onMessageSent: " + str);
    }

    private void sendNotification(String str, String str2, String str3) {
        new NotificationDbController(this).insertData(str, str2, str3);
    }

    private void broadcastNewNotification() {
        Intent intent = new Intent(AppConstant.NEW_NOTI);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Log.d("FCMess", "broadcastNewNotification: " + intent);
    }
}
