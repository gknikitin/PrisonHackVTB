package info.fandroid.quiz.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.p003v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.quiz.ResultModel;
import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity mActivity;
    private Context mContext;
    private ListItemClickListener mItemClickListener;
    private ArrayList<ResultModel> mItemList;

    public ResultAdapter(Context context, Activity activity, ArrayList<ResultModel> arrayList) {
        this.mContext = context;
        this.mActivity = activity;
        this.mItemList = arrayList;
    }

    public void setItemClickListener(ListItemClickListener listItemClickListener) {
        this.mItemClickListener = listItemClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0683R.layout.item_result, viewGroup, false), i, this.mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /* access modifiers changed from: private */
        public ImageView imgAns;
        private ListItemClickListener itemClickListener;
        /* access modifiers changed from: private */
        public RelativeLayout lytAnsContainer;
        /* access modifiers changed from: private */
        public TextView tvCorrectAns;
        /* access modifiers changed from: private */
        public TextView tvGivenAns;
        /* access modifiers changed from: private */
        public TextView tvQuestion;

        public ViewHolder(View view, int i, ListItemClickListener listItemClickListener) {
            super(view);
            this.itemClickListener = listItemClickListener;
            this.imgAns = (ImageView) view.findViewById(C0683R.C0686id.ans_icon);
            this.tvQuestion = (TextView) view.findViewById(C0683R.C0686id.question_text);
            this.tvGivenAns = (TextView) view.findViewById(C0683R.C0686id.given_ans_text);
            this.tvCorrectAns = (TextView) view.findViewById(C0683R.C0686id.correct_ans_text);
            this.lytAnsContainer = (RelativeLayout) view.findViewById(C0683R.C0686id.your_ans_container);
            view.setOnClickListener(this);
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
        int i2;
        ResultModel resultModel = this.mItemList.get(i);
        viewHolder.tvQuestion.setText(Html.fromHtml(resultModel.getQuestion()));
        viewHolder.tvCorrectAns.setText(Html.fromHtml(resultModel.getCorrectAns()));
        if (resultModel.isCorrect()) {
            viewHolder.lytAnsContainer.setVisibility(8);
        } else {
            viewHolder.tvGivenAns.setText(Html.fromHtml(resultModel.getGivenAns()));
        }
        if (resultModel.isSkip()) {
            i2 = 0;
        } else {
            i2 = resultModel.isCorrect() ? 1 : 2;
        }
        RequestManager with = Glide.with(this.mContext);
        Resources resources = this.mContext.getResources();
        with.load(Integer.valueOf(resources.getIdentifier(AppConstant.DIRECTORY + i2, (String) null, this.mContext.getPackageName()))).into(viewHolder.imgAns);
    }
}
