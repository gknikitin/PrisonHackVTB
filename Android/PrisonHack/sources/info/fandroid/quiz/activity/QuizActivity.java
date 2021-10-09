package info.fandroid.quiz.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import info.fandroid.quiz.C0683R;
import info.fandroid.quiz.adapters.QuizAdapter;
import info.fandroid.quiz.data.constant.AppConstant;
import info.fandroid.quiz.data.preference.AppPreference;
import info.fandroid.quiz.data.preference.PrefKey;
import info.fandroid.quiz.listeners.ListItemClickListener;
import info.fandroid.quiz.models.quiz.QuizModel;
import info.fandroid.quiz.models.quiz.ResultModel;
import info.fandroid.quiz.utility.ActivityUtilities;
import info.fandroid.quiz.utility.AdsUtilities;
import info.fandroid.quiz.utility.BeatBox;
import info.fandroid.quiz.utility.DialogUtilities;
import info.fandroid.quiz.utility.SoundUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuizActivity extends BaseActivity implements RewardedVideoAdListener, DialogUtilities.OnCompleteListener {
    /* access modifiers changed from: private */
    public boolean isSoundOn;
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public QuizAdapter mAdapter = null;
    ArrayList<String> mBackgroundColorList;
    /* access modifiers changed from: private */
    public BeatBox mBeatBox;
    private Button mBtnNext;
    private ImageButton mBtnSpeaker;
    private String mCategoryId;
    private Context mContext;
    /* access modifiers changed from: private */
    public String mCorrectAnsText;
    /* access modifiers changed from: private */
    public String mGivenAnsText;
    private ImageView mImgFifthLife;
    private ImageView mImgFirstLife;
    private ImageView mImgFourthLife;
    private ImageView mImgSecondLife;
    private ImageView mImgThirdLife;
    /* access modifiers changed from: private */
    public boolean mIsCorrect = false;
    private boolean mIsSkipped = false;
    /* access modifiers changed from: private */
    public List<QuizModel> mItemList;
    private int mLifeCounter = 5;
    ArrayList<String> mOptionList;
    /* access modifiers changed from: private */
    public int mQuestionPosition = 0;
    private String mQuestionText;
    private TextView mQuestionTextView;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerQuiz;
    private ArrayList<ResultModel> mResultList;
    private RewardedVideoAd mRewardedVideoAd;
    private int mScore = 0;
    private int mSkip = 0;
    /* access modifiers changed from: private */
    public List<SoundUtilities> mSounds;
    /* access modifiers changed from: private */
    public boolean mUserHasPressed = false;
    private int mWrongAns = 0;

    public void onRewardedVideoAdFailedToLoad(int i) {
    }

    public void onRewardedVideoAdLeftApplication() {
    }

    public void onRewardedVideoAdLoaded() {
    }

    public void onRewardedVideoAdOpened() {
    }

    public void onRewardedVideoCompleted() {
    }

    public void onRewardedVideoStarted() {
    }

    static /* synthetic */ int access$1008(QuizActivity quizActivity) {
        int i = quizActivity.mWrongAns;
        quizActivity.mWrongAns = i + 1;
        return i;
    }

    static /* synthetic */ int access$608(QuizActivity quizActivity) {
        int i = quizActivity.mScore;
        quizActivity.mScore = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    @RequiresApi(api = 21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initializeRewardedAds();
        loadRewardedVideoAds();
        initVar();
        initView();
        loadData();
        initListener();
        AdsUtilities.getInstance(this.mContext).showBannerAd((AdView) findViewById(C0683R.C0686id.adsView));
    }

    private void initVar() {
        this.mActivity = this;
        this.mContext = this.mActivity.getApplicationContext();
        Intent intent = getIntent();
        if (intent != null) {
            this.mCategoryId = intent.getStringExtra("index");
        }
        this.mItemList = new ArrayList();
        this.mOptionList = new ArrayList<>();
        this.mBackgroundColorList = new ArrayList<>();
        this.mResultList = new ArrayList<>();
        this.mBeatBox = new BeatBox(this.mActivity);
        this.mSounds = this.mBeatBox.getSounds();
    }

    private void initView() {
        setContentView((int) C0683R.layout.activity_quiz);
        this.mImgFirstLife = (ImageView) findViewById(C0683R.C0686id.first_life);
        this.mImgSecondLife = (ImageView) findViewById(C0683R.C0686id.second_life);
        this.mImgThirdLife = (ImageView) findViewById(C0683R.C0686id.third_life);
        this.mImgFourthLife = (ImageView) findViewById(C0683R.C0686id.fourth_life);
        this.mImgFifthLife = (ImageView) findViewById(C0683R.C0686id.fifth_life);
        this.mBtnSpeaker = (ImageButton) findViewById(C0683R.C0686id.btn_speaker);
        this.mBtnNext = (Button) findViewById(C0683R.C0686id.btn_next);
        this.mQuestionTextView = (TextView) findViewById(C0683R.C0686id.question_text);
        this.mRecyclerQuiz = (RecyclerView) findViewById(C0683R.C0686id.rvQuiz);
        this.mRecyclerQuiz.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new QuizAdapter(this.mContext, this.mActivity, this.mOptionList, this.mBackgroundColorList);
        this.mRecyclerQuiz.setAdapter(this.mAdapter);
        initToolbar(true);
        setToolbarTitle(getString(C0683R.string.quiz));
        enableUpButton();
        initLoader();
    }

    @RequiresApi(api = 21)
    private void loadData() {
        showLoader();
        this.isSoundOn = AppPreference.getInstance(this.mActivity).getBoolean(PrefKey.KEY_SOUND, true).booleanValue();
        setSpeakerImage();
        loadJson();
    }

    /* access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void setSpeakerImage() {
        if (this.isSoundOn) {
            this.mBtnSpeaker.setImageResource(C0683R.C0685drawable.ic_speaker);
        } else {
            this.mBtnSpeaker.setImageResource(C0683R.C0685drawable.ic_speaker_not);
        }
    }

    public void initListener() {
        this.mBtnSpeaker.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = 21)
            public void onClick(View view) {
                boolean unused = QuizActivity.this.isSoundOn = !QuizActivity.this.isSoundOn;
                AppPreference.getInstance(QuizActivity.this.mActivity).setBoolean(PrefKey.KEY_SOUND, QuizActivity.this.isSoundOn);
                QuizActivity.this.setSpeakerImage();
            }
        });
        this.mBtnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!QuizActivity.this.mUserHasPressed) {
                    DialogUtilities.newInstance(QuizActivity.this.getString(C0683R.string.skip_text), QuizActivity.this.getString(C0683R.string.skip_prompt), QuizActivity.this.getString(C0683R.string.yes), QuizActivity.this.getString(C0683R.string.f84no), "skip").show(QuizActivity.this.getSupportFragmentManager(), AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
                    return;
                }
                QuizActivity.this.updateResultSet();
                QuizActivity.this.setNextQuestion();
            }
        });
        this.mAdapter.setItemClickListener(new ListItemClickListener() {
            public void onItemClick(int i, View view) {
                if (!QuizActivity.this.mUserHasPressed) {
                    if (((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getCorrectAnswer() != -1) {
                        for (int i2 = 0; i2 < QuizActivity.this.mOptionList.size(); i2++) {
                            if (i2 == i && i2 == ((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getCorrectAnswer()) {
                                QuizActivity.this.mBackgroundColorList.set(i2, AppConstant.COLOR_GREEN);
                                QuizActivity.access$608(QuizActivity.this);
                                boolean unused = QuizActivity.this.mIsCorrect = true;
                                if (QuizActivity.this.isSoundOn) {
                                    QuizActivity.this.mBeatBox.play((SoundUtilities) QuizActivity.this.mSounds.get(0));
                                }
                            } else if (i2 == i && i2 != ((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getCorrectAnswer()) {
                                QuizActivity.this.mBackgroundColorList.set(i2, AppConstant.COLOR_RED);
                                QuizActivity.access$1008(QuizActivity.this);
                                if (QuizActivity.this.isSoundOn) {
                                    QuizActivity.this.mBeatBox.play((SoundUtilities) QuizActivity.this.mSounds.get(2));
                                }
                                QuizActivity.this.decreaseLifeAndStatus();
                            } else if (i2 == ((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getCorrectAnswer()) {
                                QuizActivity.this.mBackgroundColorList.set(i2, AppConstant.COLOR_GREEN);
                                ((LinearLayoutManager) QuizActivity.this.mRecyclerQuiz.getLayoutManager()).scrollToPosition(i2);
                            }
                        }
                    } else {
                        QuizActivity.this.mBackgroundColorList.set(i, AppConstant.COLOR_GREEN);
                        QuizActivity.access$608(QuizActivity.this);
                        boolean unused2 = QuizActivity.this.mIsCorrect = true;
                        QuizActivity.this.mBeatBox.play((SoundUtilities) QuizActivity.this.mSounds.get(0));
                    }
                    String unused3 = QuizActivity.this.mGivenAnsText = ((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getAnswers().get(i);
                    String unused4 = QuizActivity.this.mCorrectAnsText = ((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getAnswers().get(((QuizModel) QuizActivity.this.mItemList.get(QuizActivity.this.mQuestionPosition)).getCorrectAnswer());
                    boolean unused5 = QuizActivity.this.mUserHasPressed = true;
                    QuizActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void initializeRewardedAds() {
        MobileAds.initialize(getApplicationContext(), getResources().getString(C0683R.string.app_ad_id));
        this.mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        this.mRewardedVideoAd.setRewardedVideoAdListener(this);
    }

    private void loadRewardedVideoAds() {
        this.mRewardedVideoAd.loadAd(getResources().getString(C0683R.string.rewarded_ad_unit_id), new AdRequest.Builder().build());
    }

    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAds();
    }

    public void onRewarded(RewardItem rewardItem) {
        increaseLifeAndStatus();
        updateResultSet();
        setNextQuestion();
    }

    public void onResume() {
        this.mRewardedVideoAd.resume(this);
        AdsUtilities.getInstance(this.mContext).loadFullScreenAd(this.mActivity);
        super.onResume();
    }

    public void onPause() {
        this.mRewardedVideoAd.pause(this);
        super.onPause();
    }

    public void onDestroy() {
        this.mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    public void decreaseLifeAndStatus() {
        this.mLifeCounter--;
        setLifeStatus();
    }

    /* access modifiers changed from: package-private */
    public void increaseLifeAndStatus() {
        if (this.mLifeCounter < 5) {
            this.mLifeCounter++;
            setLifeStatus();
        }
    }

    public void setLifeStatus() {
        switch (this.mLifeCounter) {
            case 1:
                this.mImgFirstLife.setVisibility(0);
                this.mImgSecondLife.setVisibility(8);
                this.mImgThirdLife.setVisibility(8);
                this.mImgFourthLife.setVisibility(8);
                this.mImgFifthLife.setVisibility(8);
                return;
            case 2:
                this.mImgFirstLife.setVisibility(0);
                this.mImgSecondLife.setVisibility(0);
                this.mImgThirdLife.setVisibility(8);
                this.mImgFourthLife.setVisibility(8);
                this.mImgFifthLife.setVisibility(8);
                return;
            case 3:
                this.mImgFirstLife.setVisibility(0);
                this.mImgSecondLife.setVisibility(0);
                this.mImgThirdLife.setVisibility(0);
                this.mImgFourthLife.setVisibility(8);
                this.mImgFifthLife.setVisibility(8);
                return;
            case 4:
                this.mImgFirstLife.setVisibility(0);
                this.mImgSecondLife.setVisibility(0);
                this.mImgThirdLife.setVisibility(0);
                this.mImgFourthLife.setVisibility(0);
                this.mImgFifthLife.setVisibility(8);
                return;
            case 5:
                this.mImgFirstLife.setVisibility(0);
                this.mImgSecondLife.setVisibility(0);
                this.mImgThirdLife.setVisibility(0);
                this.mImgFourthLife.setVisibility(0);
                this.mImgFifthLife.setVisibility(0);
                return;
            default:
                this.mImgFirstLife.setVisibility(8);
                this.mImgSecondLife.setVisibility(8);
                this.mImgThirdLife.setVisibility(8);
                this.mImgFourthLife.setVisibility(8);
                this.mImgFifthLife.setVisibility(8);
                return;
        }
    }

    public void updateResultSet() {
        this.mResultList.add(new ResultModel(this.mQuestionText, this.mGivenAnsText, this.mCorrectAnsText, this.mIsCorrect, this.mIsSkipped));
        this.mIsCorrect = false;
        this.mIsSkipped = false;
    }

    public void setNextQuestion() {
        if (this.isSoundOn) {
            this.mBeatBox.play(this.mSounds.get(1));
        }
        this.mUserHasPressed = false;
        if (this.mQuestionPosition < this.mItemList.size() - 1 && this.mLifeCounter > 0) {
            this.mQuestionPosition++;
            updateQuestionsAndAnswers();
        } else if (this.mQuestionPosition >= this.mItemList.size() - 1 || this.mLifeCounter != 0 || !this.mRewardedVideoAd.isLoaded()) {
            ActivityUtilities.getInstance().invokeScoreCardActivity(this.mActivity, ScoreCardActivity.class, this.mScore, this.mWrongAns, this.mSkip, this.mCategoryId, this.mResultList, true);
        } else {
            DialogUtilities.newInstance(getString(C0683R.string.reward_dialog_title), getString(C0683R.string.reward_dialog_message), getString(C0683R.string.yes), getString(C0683R.string.f84no), AppConstant.BUNDLE_KEY_REWARD_OPTION).show(getSupportFragmentManager(), AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
        }
    }

    public void updateQuestionsAndAnswers() {
        this.mOptionList.clear();
        this.mBackgroundColorList.clear();
        ((LinearLayoutManager) this.mRecyclerQuiz.getLayoutManager()).scrollToPosition(0);
        this.mOptionList.addAll(this.mItemList.get(this.mQuestionPosition).getAnswers());
        this.mBackgroundColorList.addAll(this.mItemList.get(this.mQuestionPosition).getBackgroundColors());
        this.mAdapter.notifyDataSetChanged();
        this.mQuestionTextView.setText(Html.fromHtml(this.mItemList.get(this.mQuestionPosition).getQuestion()));
        this.mQuestionText = this.mItemList.get(this.mQuestionPosition).getQuestion();
    }

    public void quizActivityClosePrompt() {
        DialogUtilities.newInstance(getString(C0683R.string.exit), getString(C0683R.string.cancel_prompt), getString(C0683R.string.yes), getString(C0683R.string.f84no), AppConstant.BUNDLE_KEY_CLOSE_OPTION).show(getSupportFragmentManager(), AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
    }

    private void loadJson() {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(getAssets().open(AppConstant.QUESTION_FILE)));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    BufferedReader bufferedReader3 = bufferedReader2;
                    e = e2;
                    bufferedReader = bufferedReader3;
                    try {
                        e.printStackTrace();
                        bufferedReader.close();
                        parseJson(stringBuffer.toString());
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    bufferedReader.close();
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            bufferedReader.close();
            parseJson(stringBuffer.toString());
        }
        parseJson(stringBuffer.toString());
    }

    public void parseJson(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(AppConstant.JSON_KEY_QUESTIONNAIRY);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(AppConstant.JSON_KEY_QUESTION);
                int parseInt = Integer.parseInt(jSONObject.getString(AppConstant.JSON_KEY_CORRECT_ANS));
                String string2 = jSONObject.getString(AppConstant.JSON_KEY_CATEGORY_ID);
                JSONArray jSONArray2 = jSONObject.getJSONArray(AppConstant.JSON_KEY_ANSWERS);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(jSONArray2.get(i2).toString());
                    arrayList2.add(AppConstant.COLOR_WHITE);
                }
                if (this.mCategoryId.equals(string2)) {
                    this.mItemList.add(new QuizModel(string, arrayList, parseInt, string2, arrayList2));
                }
            }
            Collections.shuffle(this.mItemList);
            hideLoader();
            updateQuestionsAndAnswers();
        } catch (JSONException e) {
            e.printStackTrace();
            showEmptyView();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        quizActivityClosePrompt();
        return true;
    }

    public void onBackPressed() {
        quizActivityClosePrompt();
    }

    public void onComplete(Boolean bool, String str) {
        if (bool.booleanValue()) {
            if (str.equals(AppConstant.BUNDLE_KEY_CLOSE_OPTION)) {
                ActivityUtilities.getInstance().invokeNewActivity(this.mActivity, MainActivity.class, true);
            } else if (str.equals("skip")) {
                this.mSkip++;
                this.mIsSkipped = true;
                this.mGivenAnsText = getResources().getString(C0683R.string.skipped_text);
                this.mCorrectAnsText = this.mItemList.get(this.mQuestionPosition).getAnswers().get(this.mItemList.get(this.mQuestionPosition).getCorrectAnswer());
                updateResultSet();
                setNextQuestion();
            } else if (str.equals(AppConstant.BUNDLE_KEY_REWARD_OPTION)) {
                this.mRewardedVideoAd.show();
            }
        } else if (!bool.booleanValue() && str.equals(AppConstant.BUNDLE_KEY_REWARD_OPTION)) {
            ActivityUtilities.getInstance().invokeScoreCardActivity(this.mActivity, ScoreCardActivity.class, this.mScore, this.mWrongAns, this.mSkip, this.mCategoryId, this.mResultList, true);
        }
    }
}
