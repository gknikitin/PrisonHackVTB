package info.fandroid.quiz.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.p003v7.widget.CardView;
import android.support.p003v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.listeners.ListItemClickListener;
import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity mActivity;
    private ArrayList<String> mColorList;
    private Context mContext;
    private ListItemClickListener mItemClickListener;
    private ArrayList<String> mItemList;

    public QuizAdapter(Context context, Activity activity, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.mContext = context;
        this.mActivity = activity;
        this.mItemList = arrayList;
        this.mColorList = arrayList2;
    }

    public void setItemClickListener(ListItemClickListener listItemClickListener) {
        this.mItemClickListener = listItemClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0683R.layout.item_quiz, viewGroup, false), i, this.mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListItemClickListener itemClickListener;
        private CardView lytContainer;
        /* access modifiers changed from: private */
        public TextView tvItemTitle;

        public ViewHolder(View view, int i, ListItemClickListener listItemClickListener) {
            super(view);
            this.itemClickListener = listItemClickListener;
            this.tvItemTitle = (TextView) view.findViewById(C0683R.C0686id.answer_text);
            this.lytContainer = (CardView) view.findViewById(C0683R.C0686id.card_view);
            this.lytContainer.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (this.itemClickListener != null) {
                this.itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    public int getItemCount() {
        if (this.mItemList != null) {
            return this.mItemList.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvItemTitle.setText(Html.fromHtml(this.mItemList.get(i)));
        viewHolder.tvItemTitle.setBackgroundResource(this.mActivity.getResources().getIdentifier(this.mColorList.get(i), "drawable", this.mActivity.getPackageName()));
    }
}
