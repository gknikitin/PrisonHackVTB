package info.fandroid.quiz.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.notification.NotificationModel;
import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private ListItemClickListener mItemClickListener;
    private ArrayList<NotificationModel> mNotificationList;

    public NotificationAdapter(Context context, ArrayList<NotificationModel> arrayList) {
        this.mContext = context;
        this.mNotificationList = arrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgVw;
        private ListItemClickListener itemClickListener;
        /* access modifiers changed from: private */
        public TextView tvSubTitle;
        /* access modifiers changed from: private */
        public TextView tvTitle;

        public ViewHolder(View view, int i, ListItemClickListener listItemClickListener) {
            super(view);
            this.itemClickListener = listItemClickListener;
            view.setOnClickListener(this);
            this.tvTitle = (TextView) view.findViewById(C0683R.C0686id.tv_noti_title);
            this.tvSubTitle = (TextView) view.findViewById(C0683R.C0686id.tv_noti_sub_title);
            this.imgVw = (ImageView) view.findViewById(C0683R.C0686id.img_noti);
        }

        public void onClick(View view) {
            if (this.itemClickListener != null) {
                this.itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0683R.layout.item_notification, viewGroup, false), i, this.mItemClickListener);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String title = this.mNotificationList.get(i).getTitle();
        String message = this.mNotificationList.get(i).getMessage();
        if (title != null) {
            if (this.mNotificationList.get(i).isUnread()) {
                viewHolder.tvTitle.setTypeface((Typeface) null, 1);
            } else {
                viewHolder.tvTitle.setTypeface((Typeface) null, 0);
            }
            viewHolder.tvTitle.setText(title);
            viewHolder.tvSubTitle.setText(message);
        }
    }

    public int getItemCount() {
        return this.mNotificationList.size();
    }

    public void setItemClickListener(ListItemClickListener listItemClickListener) {
        this.mItemClickListener = listItemClickListener;
    }
}
