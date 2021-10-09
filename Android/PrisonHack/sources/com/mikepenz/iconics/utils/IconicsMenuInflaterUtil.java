package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuInflater;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsAttrsApplier;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class IconicsMenuInflaterUtil {
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";

    public static void inflate(MenuInflater menuInflater, Context context, int i, Menu menu) {
        inflate(menuInflater, context, i, menu, false);
    }

    public static void inflate(MenuInflater menuInflater, Context context, int i, Menu menu, boolean z) {
        menuInflater.inflate(i, menu);
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            parseMenu(context, Xml.asAttributeSet(xml), xml, menu, z);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void parseMenu(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser, Menu menu, boolean z) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (XML_MENU.equals(name)) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            switch (i) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z3) {
                        String name2 = xmlPullParser.getName();
                        char c = 65535;
                        int hashCode = name2.hashCode();
                        if (hashCode != 3242771) {
                            if (hashCode == 3347807 && name2.equals(XML_MENU)) {
                                c = 1;
                            }
                        } else if (name2.equals("item")) {
                            c = 0;
                        }
                        switch (c) {
                            case 0:
                                HashMap hashMap = new HashMap();
                                for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                                    hashMap.put(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                                }
                                IconicsDrawable iconicsDrawable = IconicsAttrsApplier.getIconicsDrawable(context, attributeSet);
                                if (iconicsDrawable != null) {
                                    menu.findItem(Integer.parseInt(((String) hashMap.get("id")).replace("@", ""))).setIcon(iconicsDrawable);
                                    break;
                                }
                                break;
                            case 1:
                                if (z) {
                                    parseMenu(context, attributeSet, xmlPullParser, menu, z);
                                    break;
                                }
                                break;
                            default:
                                z3 = true;
                                break;
                        }
                        name2 = str;
                        str = name2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z3 || !name3.equals(str)) {
                        if (!XML_MENU.equals(name3)) {
                            break;
                        } else {
                            z2 = true;
                            break;
                        }
                    } else {
                        str = null;
                        z3 = false;
                        break;
                    }
                    break;
            }
            i = xmlPullParser.next();
        }
    }
}
