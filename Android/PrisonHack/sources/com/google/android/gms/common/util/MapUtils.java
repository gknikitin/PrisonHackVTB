package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static <K, V> K getKeyFromMap(Map<K, V> map, K k) {
        if (!map.containsKey(k)) {
            return null;
        }
        for (K next : map.keySet()) {
            if (next.equals(k)) {
                return next;
            }
        }
        return null;
    }

    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        String str;
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            String str2 = hashMap.get(next);
            sb.append("\"");
            sb.append(next);
            sb.append("\":");
            if (str2 == null) {
                str = "null";
            } else {
                sb.append("\"");
                sb.append(str2);
                str = "\"";
            }
            sb.append(str);
        }
        sb.append("}");
    }
}
