package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class GenericsUtil {
    public static String[] getFields(Context context) {
        Class resolveRClass = resolveRClass(context.getPackageName());
        if (resolveRClass != null) {
            return getDefinedFonts(context, resolveRClass.getFields());
        }
        return new String[0];
    }

    private static Class resolveRClass(String str) {
        do {
            try {
                return Class.forName(str + ".R$string");
            } catch (ClassNotFoundException unused) {
                str = str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : "";
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
            }
        } while (TextUtils.isEmpty(str));
        return null;
    }

    private static String[] getDefinedFonts(Context context, Field[] fieldArr) {
        ArrayList arrayList = new ArrayList();
        for (Field field : fieldArr) {
            if (field.getName().contains("define_font_")) {
                arrayList.add(getStringResourceByName(context, field.getName()));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String getStringResourceByName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return "";
        }
        return context.getString(identifier);
    }
}
