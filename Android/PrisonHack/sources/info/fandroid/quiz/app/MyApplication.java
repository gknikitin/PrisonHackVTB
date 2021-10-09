package info.fandroid.quiz.app;

import android.app.Application;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        FirebaseMessaging.getInstance().subscribeToTopic("quiznotification");
        FirebaseInstanceId.getInstance().getToken();
    }
}
