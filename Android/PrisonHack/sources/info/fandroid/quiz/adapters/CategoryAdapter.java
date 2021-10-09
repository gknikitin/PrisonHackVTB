package info.fandroid.quiz.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.quiz.CategoryModel;
import java.util.ArrayList;
import java.util.Random;

public class CategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity mActivity;
    private ArrayList<CategoryModel> mCategoryList;
    private Context mContext;
    private ListItemClickListener mItemClickListener;

    public CategoryAdapter(Context context, Activity activity, ArrayList<CategoryModel> arrayList) {
        this.mContext = context;
        this.mActivity = activity;
        this.mCategoryList = arrayList;
    }

    public void setItemClickListener(ListItemClickListener listItemClickListener) {
        this.mItemClickListener = listItemClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0683R.layout.item_category_recycler, viewGroup, false), i, this.mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListItemClickListener itemClickListener;
        /* access modifiers changed from: private */
        public RelativeLayout lytContainer;
        /* access modifiers changed from: private */
        public TextView tvCategoryId;
        /* access modifiers changed from: private */
        public TextView tvCategoryTitle;

        public ViewHolder(View view, int i, ListItemClickListener listItemClickListener) {
            super(view);
            this.itemClickListener = listItemClickListener;
            this.lytContainer = (RelativeLayout) view.findViewById(C0683R.C0686id.lyt_container);
            this.tvCategoryId = (TextView) view.findViewById(C0683R.C0686id.category_id);
            this.tvCategoryTitle = (TextView) view.findViewById(C0683R.C0686id.title_text);
            this.lytContainer.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (this.itemClickListener != null) {
                this.itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    public int getItemCount() {
        if (this.mCategoryList != null) {
            return this.mCategoryList.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvCategoryTitle.setText(Html.fromHtml(this.mCategoryList.get(i).getCategoryName()));
        viewHolder.tvCategoryId.setText(String.valueOf(i + 1));
        new Random().nextInt(6);
        switch (i) {
            case 0:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_yellow));
                return;
            case 1:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_green));
                return;
            case 2:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_blue));
                return;
            case 3:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_orange));
                return;
            case 4:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_red));
                return;
            case 5:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_purple));
                return;
            case 6:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_yellow));
                return;
            case 7:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_green));
                return;
            case 8:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_blue));
                return;
            case 9:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_orange));
                return;
            case 10:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_red));
                return;
            case 11:
                viewHolder.lytContainer.setBackground(ContextCompat.getDrawable(this.mContext, C0683R.C0685drawable.rectangle_purple));
                return;
            default:
                return;
        }
    }
}
