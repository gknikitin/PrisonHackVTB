package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.Editable;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IconicsUtils {
    public static char ICON_END = '}';
    public static char ICON_START = '{';

    public static LinkedList<StyleContainer> findIconsFromEditable(Editable editable, HashMap<String, ITypeface> hashMap) {
        StyleContainer placeFontIcon;
        LinkedList<StyleContainer> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        int i = 0;
        for (ParcelableSpan parcelableSpan : (ParcelableSpan[]) editable.getSpans(0, editable.length(), ParcelableSpan.class)) {
            linkedList2.add(new StyleContainer(editable.getSpanStart(parcelableSpan), editable.getSpanEnd(parcelableSpan), parcelableSpan, editable.getSpanFlags(parcelableSpan)));
        }
        for (CharacterStyle characterStyle : (CharacterStyle[]) editable.getSpans(0, editable.length(), CharacterStyle.class)) {
            linkedList2.add(new StyleContainer(editable.getSpanStart(characterStyle), editable.getSpanEnd(characterStyle), characterStyle, editable.getSpanFlags(characterStyle)));
        }
        try {
            editable.clearSpans();
        } catch (Exception unused) {
        }
        int i2 = -1;
        while (i < editable.length()) {
            Character valueOf = Character.valueOf(editable.charAt(i));
            if (valueOf.charValue() == ICON_START) {
                i2 = i;
            } else if (valueOf.charValue() == ICON_END) {
                if (i2 > -1 && (placeFontIcon = placeFontIcon(editable, i2, i, hashMap)) != null) {
                    linkedList.add(placeFontIcon);
                    Iterator it = linkedList2.iterator();
                    while (it.hasNext()) {
                        StyleContainer styleContainer = (StyleContainer) it.next();
                        if (styleContainer.startIndex > i) {
                            int i3 = i - i2;
                            styleContainer.startIndex -= i3;
                            styleContainer.endIndex -= i3;
                        } else if (styleContainer.endIndex > i) {
                            styleContainer.endIndex -= i - i2;
                        }
                    }
                    i = i2;
                }
                i2 = -1;
            }
            i++;
        }
        linkedList.addAll(linkedList2);
        return linkedList;
    }

    private static StyleContainer placeFontIcon(Editable editable, int i, int i2, HashMap<String, ITypeface> hashMap) {
        if (i2 - i < 6) {
            return null;
        }
        int i3 = i + 1;
        String replace = editable.subSequence(i3, i2).toString().replace("-", "_");
        String charSequence = editable.subSequence(i3, i + 4).toString();
        try {
            ITypeface iTypeface = hashMap.get(charSequence);
            if (iTypeface != null) {
                IIcon icon = iTypeface.getIcon(replace);
                if (icon != null) {
                    editable.replace(i, i2 + 1, String.valueOf(icon.getCharacter()));
                    return new StyleContainer(i, i3, replace, hashMap.get(charSequence));
                }
                String str = Iconics.TAG;
                Log.e(str, "Wrong icon name: " + replace);
                return null;
            }
            String str2 = Iconics.TAG;
            Log.e(str2, "Wrong fontId: " + replace);
            return null;
        } catch (IllegalArgumentException unused) {
            String str3 = Iconics.TAG;
            Log.e(str3, "Wrong icon name: " + replace);
            return null;
        }
    }

    public static TextStyleContainer findIcons(Spanned spanned, HashMap<String, ITypeface> hashMap) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (ParcelableSpan parcelableSpan : (ParcelableSpan[]) spanned.getSpans(0, spanned.length(), ParcelableSpan.class)) {
            linkedList2.add(new StyleContainer(spanned.getSpanStart(parcelableSpan), spanned.getSpanEnd(parcelableSpan), parcelableSpan, spanned.getSpanFlags(parcelableSpan)));
        }
        for (CharacterStyle characterStyle : (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class)) {
            linkedList2.add(new StyleContainer(spanned.getSpanStart(characterStyle), spanned.getSpanEnd(characterStyle), characterStyle, spanned.getSpanFlags(characterStyle)));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < spanned.length(); i2++) {
            Character valueOf = Character.valueOf(spanned.charAt(i2));
            if (valueOf.charValue() == ICON_START) {
                spannableStringBuilder.append(spannableStringBuilder2);
                spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append(valueOf.charValue());
            } else if (valueOf.charValue() == ICON_END) {
                spannableStringBuilder2.append(valueOf.charValue());
                if (spannableStringBuilder2.length() > 5) {
                    StyleContainer placeFontIcon = placeFontIcon(spannableStringBuilder, spannableStringBuilder2, hashMap);
                    if (placeFontIcon != null) {
                        linkedList.add(placeFontIcon);
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            StyleContainer styleContainer = (StyleContainer) it.next();
                            int i3 = i2 - i;
                            if (styleContainer.startIndex > i3) {
                                styleContainer.startIndex = (styleContainer.startIndex - spannableStringBuilder2.length()) + 1;
                            }
                            if (styleContainer.endIndex > i3) {
                                styleContainer.endIndex = (styleContainer.endIndex - spannableStringBuilder2.length()) + 1;
                            }
                        }
                        i += spannableStringBuilder2.length() - 1;
                    }
                } else {
                    spannableStringBuilder.append(spannableStringBuilder2);
                }
                spannableStringBuilder2 = new SpannableStringBuilder();
            } else if (spannableStringBuilder2.length() == 0) {
                spannableStringBuilder.append(valueOf.charValue());
            } else {
                spannableStringBuilder2.append(valueOf.charValue());
            }
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        linkedList.addAll(linkedList2);
        return new TextStyleContainer(spannableStringBuilder, linkedList);
    }

    private static StyleContainer placeFontIcon(SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, HashMap<String, ITypeface> hashMap) {
        if (spannableStringBuilder2.length() >= 6) {
            String replace = spannableStringBuilder2.subSequence(1, spannableStringBuilder2.length() - 1).toString().replace("-", "_");
            String charSequence = spannableStringBuilder2.subSequence(1, 4).toString();
            try {
                ITypeface iTypeface = hashMap.get(charSequence);
                if (iTypeface != null) {
                    IIcon icon = iTypeface.getIcon(replace);
                    if (icon != null) {
                        spannableStringBuilder.append(icon.getCharacter());
                        return new StyleContainer(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), replace, hashMap.get(charSequence));
                    }
                    String str = Iconics.TAG;
                    Log.e(str, "Wrong icon name: " + replace);
                } else {
                    String str2 = Iconics.TAG;
                    Log.e(str2, "Wrong fontId: " + replace);
                }
            } catch (IllegalArgumentException unused) {
                String str3 = Iconics.TAG;
                Log.e(str3, "Wrong icon name: " + replace);
            }
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        return null;
    }

    public static void applyStyles(Context context, Spannable spannable, List<StyleContainer> list, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
        for (StyleContainer next : list) {
            if (next.style != null) {
                spannable.setSpan(next.style, next.startIndex, next.endIndex, next.flags);
            } else if (next.span != null) {
                spannable.setSpan(next.span, next.startIndex, next.endIndex, next.flags);
            } else {
                spannable.setSpan(new IconicsTypefaceSpan("sans-serif", next.font.getTypeface(context)), next.startIndex, next.endIndex, 33);
            }
            if (hashMap != null && hashMap.containsKey(next.icon)) {
                for (CharacterStyle wrap : hashMap.get(next.icon)) {
                    spannable.setSpan(CharacterStyle.wrap(wrap), next.startIndex, next.endIndex, next.flags);
                }
            } else if (list2 != null) {
                for (CharacterStyle wrap2 : list2) {
                    spannable.setSpan(CharacterStyle.wrap(wrap2), next.startIndex, next.endIndex, next.flags);
                }
            }
        }
    }
}
