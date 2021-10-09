package com.mikepenz.materialdrawer.icons;

import android.content.Context;
import android.graphics.Typeface;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class MaterialDrawerFont implements ITypeface {
    private static final String TTF_FILE = "materialdrawerfont-font-v5.0.0.ttf";
    private static HashMap<String, Character> mChars;
    private static Typeface typeface;

    public String getAuthor() {
        return "";
    }

    public String getDescription() {
        return "";
    }

    public String getFontName() {
        return "MaterialDrawerFont";
    }

    public String getLicense() {
        return "";
    }

    public String getLicenseUrl() {
        return "";
    }

    public String getMappingPrefix() {
        return "mdf";
    }

    public String getUrl() {
        return "";
    }

    public String getVersion() {
        return "5.0.0";
    }

    public IIcon getIcon(String str) {
        return Icon.valueOf(str);
    }

    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> hashMap = new HashMap<>();
            for (Icon icon : Icon.values()) {
                hashMap.put(icon.name(), Character.valueOf(icon.character));
            }
            mChars = hashMap;
        }
        return mChars;
    }

    public int getIconCount() {
        return mChars.size();
    }

    public Collection<String> getIcons() {
        LinkedList linkedList = new LinkedList();
        for (Icon name : Icon.values()) {
            linkedList.add(name.name());
        }
        return linkedList;
    }

    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/materialdrawerfont-font-v5.0.0.ttf");
            } catch (Exception unused) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {
        mdf_arrow_drop_down(58821),
        mdf_arrow_drop_up(58823),
        mdf_expand_less(58830),
        mdf_expand_more(58831),
        mdf_person(59389);
        
        private static ITypeface typeface;
        char character;

        private Icon(char c) {
            this.character = c;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return this.character;
        }

        public String getName() {
            return name();
        }

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new MaterialDrawerFont();
            }
            return typeface;
        }
    }
}
