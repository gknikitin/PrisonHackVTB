package info.fandroid.quiz.models.notification;

public class NotificationModel {

    /* renamed from: id */
    private int f95id;
    private boolean isUnread;
    private String message;
    private String title;
    private String url;

    public NotificationModel(int i, String str, String str2, boolean z, String str3) {
        this.f95id = i;
        this.title = str;
        this.message = str2;
        this.isUnread = z;
        this.url = str3;
    }

    public int getId() {
        return this.f95id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isUnread() {
        return this.isUnread;
    }
}
