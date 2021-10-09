package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.ads.AdView;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.adapters.ResultAdapter;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.models.quiz.ResultModel;
import info.fandroid.quiz.utility.ActivityUtilities;
import info.fandroid.quiz.utility.AdsUtilities;
import java.util.ArrayList;
import java.util.List;

public class ScoreCardActivity extends BaseActivity implements OnChartValueSelectedListener {
    /* access modifiers changed from: private */
    public Activity mActivity;
    private ResultAdapter mAdapter = null;
    private Button mBtnPlayAgain;
    private Button mBtnShare;
    /* access modifiers changed from: private */
    public String mCategoryId;
    private Context mContext;
    private TextView mGreetingTextView;
    private PieChart mPieChart;
    private RecyclerView mRecyclerResult;
    private ArrayList<ResultModel> mResultList;
    /* access modifiers changed from: private */
    public int mScore;
    private TextView mScoreTextView;
    private int mSkip;
    private TextView mSkipTextView;
    private int mWrongAns;
    private TextView mWrongAnsTextView;

    public void onNothingSelected() {
    }

    public void onValueSelected(Entry entry, int i, Highlight highlight) {
        if (entry != null) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.mScore = intent.getIntExtra("score", 0);
            this.mWrongAns = intent.getIntExtra(AppConstant.BUNDLE_KEY_WRONG_ANS, 0);
            this.mCategoryId = intent.getStringExtra("index");
            this.mResultList = intent.getParcelableArrayListExtra(AppConstant.BUNDLE_KEY_ITEM);
        }
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_score_card);
        this.mRecyclerResult = (RecyclerView) findViewById(C0683R.C0686id.rvContent);
        this.mRecyclerResult.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mBtnShare = (Button) findViewById(C0683R.C0686id.btn_share);
        this.mBtnPlayAgain = (Button) findViewById(C0683R.C0686id.btn_play_again);
        this.mScoreTextView = (TextView) findViewById(C0683R.C0686id.txt_score);
        this.mWrongAnsTextView = (TextView) findViewById(C0683R.C0686id.txt_wrong);
        this.mSkipTextView = (TextView) findViewById(C0683R.C0686id.txt_skip);
        this.mGreetingTextView = (TextView) findViewById(C0683R.C0686id.greeting_text);
        initToolbar(true);
        setToolbarTitle(getResources().getString(C0683R.string.score_card));
        enableUpButton();
    }

    public void initFunctionality() {
        this.mSkip = 25 - (this.mScore + this.mWrongAns);
        this.mScoreTextView.setText(String.valueOf(this.mScore));
        this.mWrongAnsTextView.setText(String.valueOf(this.mWrongAns));
        this.mSkipTextView.setText(String.valueOf(this.mSkip));
        switch (Math.round((((float) this.mScore) / ((float) ((this.mScore + this.mWrongAns) + this.mSkip))) * 10.0f)) {
            case 5:
            case 6:
            case 7:
                this.mGreetingTextView.setText(Html.fromHtml(getResources().getString(C0683R.string.greeting_text2)));
                break;
            case 8:
            case 9:
            case 10:
                this.mGreetingTextView.setText(Html.fromHtml(getResources().getString(C0683R.string.greeting_text3)));
                break;
            default:
                this.mGreetingTextView.setText(Html.fromHtml(getResources().getString(C0683R.string.greeting_text1)));
                break;
        }
        showPieChart();
        this.mAdapter = new ResultAdapter(this.mContext, this.mActivity, this.mResultList);
        this.mRecyclerResult.setAdapter(this.mAdapter);
        AdsUtilities.getInstance(this.mContext).showFullScreenAd();
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    public void initListener() {
        this.mBtnShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", ScoreCardActivity.this.getString(C0683R.string.sharing_text, new Object[]{Integer.valueOf(ScoreCardActivity.this.mScore)}) + " https://play.google.com/store/apps/details?id=" + ScoreCardActivity.this.mActivity.getPackageName());
                intent.setType("text/plain");
                ScoreCardActivity.this.startActivity(Intent.createChooser(intent, ScoreCardActivity.this.getResources().getText(C0683R.string.send_to)));
            }
        });
        this.mBtnPlayAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeCommonQuizActivity(ScoreCardActivity.this.mActivity, QuizPromptActivity.class, ScoreCardActivity.this.mCategoryId, true);
            }
        });
    }

    public void showPieChart() {
        this.mPieChart = (PieChart) findViewById(C0683R.C0686id.piechart);
        this.mPieChart.setUsePercentValues(true);
        this.mPieChart.setDrawHoleEnabled(true);
        this.mPieChart.setTransparentCircleRadius(65.0f);
        this.mPieChart.setHoleRadius(65.0f);
        this.mPieChart.setDescription(getString(C0683R.string.score_card));
        this.mPieChart.animateXY(AppConstant.ANIMATION_VALUE, AppConstant.ANIMATION_VALUE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Entry((float) this.mScore, 0));
        arrayList.add(new Entry((float) this.mWrongAns, 2));
        arrayList.add(new Entry((float) this.mSkip, 1));
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(C0683R.string.score));
        arrayList2.add(getString(C0683R.string.wrong));
        arrayList2.add(getString(C0683R.string.skipped));
        PieData pieData = new PieData((List<String>) arrayList2, (IPieDataSet) pieDataSet);
        pieData.setValueFormatter(new PercentFormatter());
        this.mPieChart.setData(pieData);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, MainActivity.class, true);
        return true;
    }

    public void onBackPressed() {
        ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, MainActivity.class, true);
    }
}
