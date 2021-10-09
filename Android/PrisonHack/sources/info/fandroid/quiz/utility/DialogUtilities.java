package info.fandroid.quiz.utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p003v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;

public class DialogUtilities extends DialogFragment {
    private String dialogText;
    private String dialogTitle;
    private Activity mActivity;
    /* access modifiers changed from: private */
    public OnCompleteListener mListener;
    private String negativeText;
    private String positiveText;
    private TextView txtDialogText;
    private TextView txtDialogTitle;
    /* access modifiers changed from: private */
    public String viewIdText;

    public interface OnCompleteListener {
        void onComplete(Boolean bool, String str);
    }

    public static DialogUtilities newInstance(String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString(AppConstant.BUNDLE_KEY_MESSAGE, str2);
        bundle.putString(AppConstant.BUNDLE_KEY_YES, str3);
        bundle.putString(AppConstant.BUNDLE_KEY_NO, str4);
        bundle.putString(AppConstant.BUNDLE_KEY_VIEW_ID, str5);
        DialogUtilities dialogUtilities = new DialogUtilities();
        dialogUtilities.setArguments(bundle);
        return dialogUtilities;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        try {
            this.mListener = (OnCompleteListener) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString());
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(C0683R.layout.fragment_custom_dialog, (ViewGroup) null);
        initVar();
        initView(inflate);
        initFunctionality();
        return new AlertDialog.Builder(this.mActivity).setView(inflate).setPositiveButton((CharSequence) this.positiveText, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogUtilities.this.mListener.onComplete(true, DialogUtilities.this.viewIdText);
            }
        }).setNegativeButton((CharSequence) this.negativeText, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    DialogUtilities.this.mListener.onComplete(false, DialogUtilities.this.viewIdText);
                }
            }
        }).create();
    }

    public void initVar() {
        if (getArguments() != null) {
            this.dialogTitle = getArguments().getString("title");
            this.dialogText = getArguments().getString(AppConstant.BUNDLE_KEY_MESSAGE);
            this.positiveText = getArguments().getString(AppConstant.BUNDLE_KEY_YES);
            this.negativeText = getArguments().getString(AppConstant.BUNDLE_KEY_NO);
            this.viewIdText = getArguments().getString(AppConstant.BUNDLE_KEY_VIEW_ID);
        }
    }

    public void initView(View view) {
        this.txtDialogTitle = (TextView) view.findViewById(C0683R.C0686id.dialog_title);
        this.txtDialogText = (TextView) view.findViewById(C0683R.C0686id.dialog_text);
    }

    public void initFunctionality() {
        this.txtDialogTitle.setText(this.dialogTitle);
        this.txtDialogText.setText(this.dialogText);
    }
}
