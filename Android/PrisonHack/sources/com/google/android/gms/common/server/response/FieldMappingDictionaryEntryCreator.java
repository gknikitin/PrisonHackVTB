package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class FieldMappingDictionaryEntryCreator implements Parcelable.Creator<FieldMappingDictionary.Entry> {
    public static final int CONTENT_DESCRIPTION = 0;

    public FieldMappingDictionary.Entry createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        int i = 0;
        ArrayList<FieldMappingDictionary.FieldMapPair> arrayList = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, FieldMappingDictionary.FieldMapPair.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new FieldMappingDictionary.Entry(i, str, arrayList);
    }

    public FieldMappingDictionary.Entry[] newArray(int i) {
        return new FieldMappingDictionary.Entry[i];
    }
}
