package info.fandroid.quiz.models.quiz;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {
    public static final Parcelable.Creator<CategoryModel> CREATOR = new Parcelable.Creator<CategoryModel>() {
        public CategoryModel createFromParcel(Parcel parcel) {
            return new CategoryModel(parcel);
        }

        public CategoryModel[] newArray(int i) {
            return new CategoryModel[i];
        }
    };
    String categoryId;
    String categoryName;

    public int describeContents() {
        return 0;
    }

    public CategoryModel(String str, String str2) {
        this.categoryId = str;
        this.categoryName = str2;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.categoryId);
        parcel.writeString(this.categoryName);
    }

    protected CategoryModel(Parcel parcel) {
        this.categoryId = parcel.readString();
        this.categoryName = parcel.readString();
    }

    public static Parcelable.Creator<CategoryModel> getCREATOR() {
        return CREATOR;
    }
}
