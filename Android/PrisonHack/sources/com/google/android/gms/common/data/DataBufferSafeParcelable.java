package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    public static final String DATA_FIELD = "data";
    private static final String[] zznk = {DATA_FIELD};
    private final Parcelable.Creator<T> zznl;

    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zznl = creator;
    }

    public static <T extends SafeParcelable> void addValue(DataHolder.Builder builder, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA_FIELD, obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
    }

    public static DataHolder.Builder buildDataHolder() {
        return DataHolder.builder(zznk);
    }

    public T get(int i) {
        byte[] byteArray = this.mDataHolder.getByteArray(DATA_FIELD, i, this.mDataHolder.getWindowIndex(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.zznl.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
