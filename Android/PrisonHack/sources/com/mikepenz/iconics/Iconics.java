package com.mikepenz.iconics;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.GenericsUtil;
import com.mikepenz.iconics.utils.IconicsUtils;
import com.mikepenz.iconics.utils.TextStyleContainer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Iconics {
    private static HashMap<String, ITypeface> FONTS = new HashMap<>();
    private static boolean INIT_DONE = false;
    public static final String TAG = "Iconics";

    public static void init(Context context) {
        if (!INIT_DONE) {
            for (String str : GenericsUtil.getFields(context)) {
                try {
                    ITypeface iTypeface = (ITypeface) Class.forName(str).newInstance();
                    validateFont(iTypeface);
                    FONTS.put(iTypeface.getMappingPrefix(), iTypeface);
                } catch (Exception unused) {
                    Log.e("Android-Iconics", "Can't init: " + str);
                }
            }
            INIT_DONE = true;
        }
    }

    private static HashMap<String, ITypeface> init(Context context, HashMap<String, ITypeface> hashMap) {
        init(context);
        return (hashMap == null || hashMap.size() == 0) ? FONTS : hashMap;
    }

    public static void markInitDone() {
        if (FONTS.size() == 0) {
            throw new IllegalArgumentException("At least one font needs to be registered first via `registerFont`.");
        }
        INIT_DONE = true;
    }

    public static boolean iconExists(Context context, String str) {
        try {
            findFont(context, str.substring(0, 3)).getIcon(str.replace("-", "_"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean registerFont(ITypeface iTypeface) {
        validateFont(iTypeface);
        FONTS.put(iTypeface.getMappingPrefix(), iTypeface);
        return true;
    }

    private static void validateFont(ITypeface iTypeface) {
        if (iTypeface.getMappingPrefix().length() != 3) {
            throw new IllegalArgumentException("The mapping prefix of a font must be three characters long.");
        }
    }

    public static Collection<ITypeface> getRegisteredFonts(Context context) {
        init(context);
        return FONTS.values();
    }

    public static ITypeface findFont(Context context, String str) {
        init(context);
        return FONTS.get(str);
    }

    public static ITypeface findFont(IIcon iIcon) {
        return iIcon.getTypeface();
    }

    private Iconics() {
    }

    public static Spanned style(Context context, Spanned spanned) {
        return style(context, (HashMap<String, ITypeface>) null, spanned, (List<CharacterStyle>) null, (HashMap<String, List<CharacterStyle>>) null);
    }

    public static Spanned style(Context context, HashMap<String, ITypeface> hashMap, Spanned spanned, List<CharacterStyle> list, HashMap<String, List<CharacterStyle>> hashMap2) {
        TextStyleContainer findIcons = IconicsUtils.findIcons(spanned, init(context, hashMap));
        SpannableString valueOf = SpannableString.valueOf(findIcons.spannableStringBuilder);
        IconicsUtils.applyStyles(context, valueOf, findIcons.styleContainers, list, hashMap2);
        return valueOf;
    }

    public static void styleEditable(Context context, Editable editable) {
        styleEditable(context, (HashMap<String, ITypeface>) null, editable, (List<CharacterStyle>) null, (HashMap<String, List<CharacterStyle>>) null);
    }

    public static void styleEditable(Context context, HashMap<String, ITypeface> hashMap, Editable editable, List<CharacterStyle> list, HashMap<String, List<CharacterStyle>> hashMap2) {
        IconicsUtils.applyStyles(context, editable, IconicsUtils.findIconsFromEditable(editable, init(context, hashMap)), list, hashMap2);
    }

    public static class IconicsBuilderString {
        private Context ctx;
        private List<ITypeface> fonts;
        private Spanned text;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;

        public IconicsBuilderString(Context context, List<ITypeface> list, Spanned spanned, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
            this.ctx = context;
            this.fonts = list;
            this.text = spanned;
            this.withStyles = list2;
            this.withStylesFor = hashMap;
        }

        public Spanned build() {
            HashMap hashMap = new HashMap();
            for (ITypeface next : this.fonts) {
                hashMap.put(next.getMappingPrefix(), next);
            }
            return Iconics.style(this.ctx, hashMap, this.text, this.withStyles, this.withStylesFor);
        }
    }

    public static class IconicsBuilderView {
        private Context ctx;
        private List<ITypeface> fonts;
        private TextView view;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;

        public IconicsBuilderView(Context context, List<ITypeface> list, TextView textView, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
            this.ctx = context;
            this.fonts = list;
            this.view = textView;
            this.withStyles = list2;
            this.withStylesFor = hashMap;
        }

        public void build() {
            HashMap hashMap = new HashMap();
            for (ITypeface next : this.fonts) {
                hashMap.put(next.getMappingPrefix(), next);
            }
            if (this.view.getText() instanceof Spanned) {
                this.view.setText(Iconics.style(this.ctx, hashMap, (Spanned) this.view.getText(), this.withStyles, this.withStylesFor));
            } else {
                this.view.setText(Iconics.style(this.ctx, hashMap, new SpannableString(this.view.getText()), this.withStyles, this.withStylesFor));
            }
            if (this.view instanceof Button) {
                this.view.setAllCaps(false);
            }
        }
    }

    public static class IconicsBuilder {
        private Context ctx;
        private List<ITypeface> fonts = new LinkedList();
        private List<CharacterStyle> styles = new LinkedList();
        private HashMap<String, List<CharacterStyle>> stylesFor = new HashMap<>();

        public IconicsBuilder ctx(Context context) {
            this.ctx = context;
            return this;
        }

        public IconicsBuilder style(CharacterStyle... characterStyleArr) {
            if (characterStyleArr != null && characterStyleArr.length > 0) {
                Collections.addAll(this.styles, characterStyleArr);
            }
            return this;
        }

        public IconicsBuilder styleFor(IIcon iIcon, CharacterStyle... characterStyleArr) {
            return styleFor(iIcon.getName(), characterStyleArr);
        }

        public IconicsBuilder styleFor(String str, CharacterStyle... characterStyleArr) {
            String replace = str.replace("-", "_");
            if (!this.stylesFor.containsKey(replace)) {
                this.stylesFor.put(replace, new LinkedList());
            }
            if (characterStyleArr != null && characterStyleArr.length > 0) {
                for (CharacterStyle add : characterStyleArr) {
                    this.stylesFor.get(replace).add(add);
                }
            }
            return this;
        }

        public IconicsBuilder font(ITypeface iTypeface) {
            this.fonts.add(iTypeface);
            return this;
        }

        /* renamed from: on */
        public IconicsBuilderString mo17747on(Spanned spanned) {
            return new IconicsBuilderString(this.ctx, this.fonts, spanned, this.styles, this.stylesFor);
        }

        /* renamed from: on */
        public IconicsBuilderString mo17749on(String str) {
            return mo17747on((Spanned) new SpannableString(str));
        }

        /* renamed from: on */
        public IconicsBuilderString mo17748on(CharSequence charSequence) {
            return mo17749on(charSequence.toString());
        }

        /* renamed from: on */
        public IconicsBuilderString mo17750on(StringBuilder sb) {
            return mo17749on(sb.toString());
        }

        /* renamed from: on */
        public IconicsBuilderView mo17752on(TextView textView) {
            return new IconicsBuilderView(this.ctx, this.fonts, textView, this.styles, this.stylesFor);
        }

        /* renamed from: on */
        public IconicsBuilderView mo17751on(Button button) {
            return new IconicsBuilderView(this.ctx, this.fonts, button, this.styles, this.stylesFor);
        }
    }
}
