package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C0577R;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.CrashUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import info.fandroid.quiz.billing.Constants;
import java.util.Map;

@zzadh
public final class zzzy extends zzaal {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzbgp;
    private String zzbvs = zzbu(Constants.RESPONSE_DESCRIPTION);
    private long zzbvt = zzbv("start_ticks");
    private long zzbvu = zzbv("end_ticks");
    private String zzbvv = zzbu("summary");
    private String zzbvw = zzbu(FirebaseAnalytics.Param.LOCATION);

    public zzzy(zzaqw zzaqw, Map<String, String> map) {
        super(zzaqw, "createCalendarEvent");
        this.zzbgp = map;
        this.mContext = zzaqw.zzto();
    }

    private final String zzbu(String str) {
        return TextUtils.isEmpty(this.zzbgp.get(str)) ? "" : this.zzbgp.get(str);
    }

    private final long zzbv(String str) {
        String str2 = this.zzbgp.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzbvs);
        data.putExtra("eventLocation", this.zzbvw);
        data.putExtra(Constants.RESPONSE_DESCRIPTION, this.zzbvv);
        if (this.zzbvt > -1) {
            data.putExtra("beginTime", this.zzbvt);
        }
        if (this.zzbvu > -1) {
            data.putExtra("endTime", this.zzbvu);
        }
        data.setFlags(CrashUtils.ErrorDialogData.BINDER_CRASH);
        return data;
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbw("Activity context is not available.");
            return;
        }
        zzbv.zzek();
        if (!zzakk.zzao(this.mContext).zziz()) {
            zzbw("This feature is not available on the device.");
            return;
        }
        zzbv.zzek();
        AlertDialog.Builder zzan = zzakk.zzan(this.mContext);
        Resources resources = zzbv.zzeo().getResources();
        zzan.setTitle(resources != null ? resources.getString(C0577R.string.f73s5) : "Create calendar event");
        zzan.setMessage(resources != null ? resources.getString(C0577R.string.f74s6) : "Allow Ad to create a calendar event?");
        zzan.setPositiveButton(resources != null ? resources.getString(C0577R.string.f71s3) : "Accept", new zzzz(this));
        zzan.setNegativeButton(resources != null ? resources.getString(C0577R.string.f72s4) : "Decline", new zzaaa(this));
        zzan.create().show();
    }
}
