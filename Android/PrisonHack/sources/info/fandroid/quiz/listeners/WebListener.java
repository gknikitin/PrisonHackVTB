package info.fandroid.quiz.listeners;

public interface WebListener {
    void onLoaded();

    void onNetworkError();

    void onPageTitle(String str);

    void onProgress(int i);

    void onStart();
}
