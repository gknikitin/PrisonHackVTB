package info.fandroid.quiz.models.quiz;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultModel implements Parcelable {
    public static final Parcelable.Creator<ResultModel> CREATOR = new Parcelable.Creator<ResultModel>() {
        public ResultModel createFromParcel(Parcel parcel) {
            return new ResultModel(parcel);
        }

        public ResultModel[] newArray(int i) {
            return new ResultModel[i];
        }
    };
    private String correctAns;
    private String givenAns;
    private boolean isCorrect;
    private boolean isSkip;
    private String question;

    public int describeContents() {
        return 0;
    }

    public ResultModel(String str, String str2, String str3, boolean z, boolean z2) {
        this.question = str;
        this.givenAns = str2;
        this.correctAns = str3;
        this.isCorrect = z;
        this.isSkip = z2;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getGivenAns() {
        return this.givenAns;
    }

    public String getCorrectAns() {
        return this.correctAns;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }

    public boolean isSkip() {
        return this.isSkip;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.question);
        parcel.writeString(this.givenAns);
        parcel.writeString(this.correctAns);
        parcel.writeByte(this.isCorrect ? (byte) 1 : 0);
        parcel.writeByte(this.isSkip ? (byte) 1 : 0);
    }

    protected ResultModel(Parcel parcel) {
        this.question = parcel.readString();
        this.givenAns = parcel.readString();
        this.correctAns = parcel.readString();
        boolean z = false;
        this.isCorrect = parcel.readByte() != 0;
        this.isSkip = parcel.readByte() != 0 ? true : z;
    }

    public static Parcelable.Creator<ResultModel> getCREATOR() {
        return CREATOR;
    }
}
