package info.fandroid.quiz.models.quiz;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class QuizModel implements Parcelable {
    public static final Parcelable.Creator<QuizModel> CREATOR = new Parcelable.Creator<QuizModel>() {
        public QuizModel createFromParcel(Parcel parcel) {
            return new QuizModel(parcel);
        }

        public QuizModel[] newArray(int i) {
            return new QuizModel[i];
        }
    };
    ArrayList<String> answers;
    ArrayList<String> backgroundColors;
    int correctAnswer;
    String questinCategoryId;
    String question;

    public int describeContents() {
        return 0;
    }

    public QuizModel(String str, ArrayList<String> arrayList, int i, String str2, ArrayList<String> arrayList2) {
        this.question = str;
        this.correctAnswer = i;
        this.answers = arrayList;
        this.questinCategoryId = str2;
        this.backgroundColors = arrayList2;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public String getQuestingCategoryId() {
        return this.questinCategoryId;
    }

    public void setBackgroundColors(ArrayList<String> arrayList) {
        this.backgroundColors = arrayList;
    }

    public ArrayList<String> getBackgroundColors() {
        return this.backgroundColors;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.question);
        parcel.writeList(this.answers);
        parcel.writeInt(this.correctAnswer);
        parcel.writeString(this.questinCategoryId);
        parcel.writeList(this.backgroundColors);
    }

    protected QuizModel(Parcel parcel) {
        this.question = parcel.readString();
        parcel.readList(this.answers, QuizModel.class.getClassLoader());
        this.correctAnswer = parcel.readInt();
        this.questinCategoryId = parcel.readString();
        parcel.readList(this.backgroundColors, QuizModel.class.getClassLoader());
    }

    public static Parcelable.Creator<QuizModel> getCREATOR() {
        return CREATOR;
    }
}
