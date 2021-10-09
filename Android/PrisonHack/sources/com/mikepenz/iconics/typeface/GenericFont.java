package com.mikepenz.iconics.typeface;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Collection;
import java.util.HashMap;

public class GenericFont implements ITypeface {
    private String mAuthor;
    private HashMap<String, Character> mChars;
    private String mFontFile;
    private String mFontName;
    private String mMappingPrefix;
    private Typeface typeface;

    public String getDescription() {
        return "";
    }

    public String getLicense() {
        return "";
    }

    public String getLicenseUrl() {
        return "";
    }

    public String getUrl() {
        return "";
    }

    public String getVersion() {
        return "1.0.0";
    }

    protected GenericFont() {
        this.typeface = null;
        this.mChars = new HashMap<>();
    }

    public GenericFont(String str, String str2) {
        this("GenericFont", "GenericAuthor", str, str2);
    }

    public GenericFont(String str, String str2, String str3, String str4) {
        this.typeface = null;
        this.mChars = new HashMap<>();
        if (str3.length() != 3) {
            new IllegalArgumentException("MappingPrefix must be 3 char long");
        }
        this.mFontName = str;
        this.mAuthor = str2;
        this.mMappingPrefix = str3;
        this.mFontFile = str4;
    }

    public void registerIcon(String str, char c) {
        HashMap<String, Character> hashMap = this.mChars;
        hashMap.put(this.mMappingPrefix + "_" + str, Character.valueOf(c));
    }

    public IIcon getIcon(String str) {
        return new Icon(this.mChars.get(str).charValue()).withTypeface(this);
    }

    public HashMap<String, Character> getCharacters() {
        return new HashMap<>();
    }

    public String getMappingPrefix() {
        return this.mMappingPrefix;
    }

    public String getFontName() {
        return this.mFontName;
    }

    public int getIconCount() {
        return this.mChars.size();
    }

    public Collection<String> getIcons() {
        return this.mChars.keySet();
    }

    public String getAuthor() {
        return this.mAuthor;
    }

    public Typeface getTypeface(Context context) {
        if (this.typeface == null) {
            try {
                this.typeface = Typeface.createFromAsset(context.getAssets(), this.mFontFile);
            } catch (Exception unused) {
                return null;
            }
        }
        return this.typeface;
    }

    public class Icon implements IIcon {
        private char aChar;
        private String mName;
        private ITypeface mTypeface;

        public Icon(char c) {
            this.aChar = c;
        }

        public Icon(String str, char c) {
            this.mName = str;
            this.aChar = c;
        }

        public Icon withTypeface(ITypeface iTypeface) {
            this.mTypeface = iTypeface;
            return this;
        }

        public String getFormattedName() {
            return "{" + getName() + "}";
        }

        public String getName() {
            if (this.mName != null) {
                return this.mName;
            }
            return String.valueOf(this.aChar);
        }

        public char getCharacter() {
            return this.aChar;
        }

        public ITypeface getTypeface() {
            if (this.mTypeface != null) {
                return this.mTypeface;
            }
            return GenericFont.this;
        }
    }
}
