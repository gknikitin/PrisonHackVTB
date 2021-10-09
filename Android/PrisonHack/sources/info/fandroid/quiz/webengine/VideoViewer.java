package info.fandroid.quiz.webengine;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.support.p000v4.view.InputDeviceCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import info.fandroid.quiz.C0683R;

public class VideoViewer {
    private static VideoViewer videoViewer;
    private AlertDialog dialog;
    private ProgressBar progressBar;
    private FrameLayout videoLayout;

    public static VideoViewer getInstance() {
        if (videoViewer == null) {
            videoViewer = new VideoViewer();
        }
        return videoViewer;
    }

    public void show(Activity activity) {
        dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C0683R.style.DialogTheme);
        View inflate = LayoutInflater.from(activity).inflate(C0683R.layout.layout_video_view, (ViewGroup) null);
        builder.setView(inflate);
        builder.setCancelable(true);
        this.videoLayout = (FrameLayout) inflate.findViewById(C0683R.C0686id.videoView);
        this.progressBar = (ProgressBar) inflate.findViewById(C0683R.C0686id.progressBar);
        this.dialog = builder.create();
        this.dialog.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = this.dialog.getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        window.setAttributes(layoutParams);
        this.dialog.getWindow().setFlags(1024, 1024);
        View decorView = window.getDecorView();
        decorView.setBackgroundResource(17170444);
        if (Build.VERSION.SDK_INT < 19) {
            decorView.setSystemUiVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 19) {
            decorView.setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    public void dismiss() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void setVideoLayout(View view) {
        if (this.videoLayout != null) {
            this.videoLayout.addView(view);
        }
    }
}
