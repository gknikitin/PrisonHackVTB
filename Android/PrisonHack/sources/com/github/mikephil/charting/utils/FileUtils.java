package com.github.mikephil.charting.utils;

import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("#");
                if (split.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                } else {
                    float[] fArr = new float[(split.length - 1)];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr[i] = Float.parseFloat(split[i]);
                    }
                    arrayList.add(new BarEntry(fArr, Integer.parseInt(split[split.length - 1])));
                }
            }
        } catch (IOException e) {
            Log.e(LOG, e.toString());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[SYNTHETIC, Splitter:B:28:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.Entry> loadEntriesFromAssets(android.content.res.AssetManager r5, java.lang.String r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0072 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0072 }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0072 }
            java.lang.String r6 = "UTF-8"
            r3.<init>(r5, r6)     // Catch:{ IOException -> 0x0072 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0072 }
            java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x006c, all -> 0x006a }
        L_0x001a:
            if (r5 == 0) goto L_0x0064
            java.lang.String r6 = "#"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r6 = r5.length     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r1 = 2
            r3 = 0
            r4 = 1
            if (r6 > r1) goto L_0x003d
            com.github.mikephil.charting.data.Entry r6 = new com.github.mikephil.charting.data.Entry     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r1 = r5[r3]     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r5 = r5[r4]     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r6.<init>(r1, r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r0.add(r6)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            goto L_0x005f
        L_0x003d:
            int r6 = r5.length     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r6 = r6 - r4
            float[] r6 = new float[r6]     // Catch:{ IOException -> 0x006c, all -> 0x006a }
        L_0x0041:
            int r1 = r6.length     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            if (r3 >= r1) goto L_0x004f
            r1 = r5[r3]     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r6[r3] = r1     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r3 = r3 + 1
            goto L_0x0041
        L_0x004f:
            com.github.mikephil.charting.data.BarEntry r1 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r3 = r5.length     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r3 = r3 - r4
            r5 = r5[r3]     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r1.<init>((float[]) r6, (int) r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r0.add(r1)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
        L_0x005f:
            java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            goto L_0x001a
        L_0x0064:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x008c
        L_0x006a:
            r5 = move-exception
            goto L_0x008d
        L_0x006c:
            r5 = move-exception
            r1 = r2
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            r2 = r1
            goto L_0x008d
        L_0x0072:
            r5 = move-exception
        L_0x0073:
            java.lang.String r6 = "MPChart-FileUtils"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006f }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x008c
            r1.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x008c
        L_0x0082:
            r5 = move-exception
            java.lang.String r6 = "MPChart-FileUtils"
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r6, r5)
        L_0x008c:
            return r0
        L_0x008d:
            if (r2 == 0) goto L_0x009d
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x009d
        L_0x0093:
            r6 = move-exception
            java.lang.String r0 = "MPChart-FileUtils"
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r0, r6)
        L_0x009d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e(LOG, e.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry next : list) {
                bufferedWriter.append(next.getVal() + "#" + next.getXIndex());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e2) {
            Log.e(LOG, e2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[SYNTHETIC, Splitter:B:20:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[SYNTHETIC, Splitter:B:26:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.BarEntry> loadBarEntriesFromAssets(android.content.res.AssetManager r4, java.lang.String r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004b }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ IOException -> 0x004b }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x004b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x004b }
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
        L_0x001a:
            if (r4 == 0) goto L_0x003d
            java.lang.String r5 = "#"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            com.github.mikephil.charting.data.BarEntry r5 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r1 = 0
            r1 = r4[r1]     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r3 = 1
            r4 = r4[r3]     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r5.<init>((float) r1, (int) r4)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r0.add(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            goto L_0x001a
        L_0x003d:
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0065
        L_0x0043:
            r4 = move-exception
            goto L_0x0066
        L_0x0045:
            r4 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x0048:
            r4 = move-exception
            r2 = r1
            goto L_0x0066
        L_0x004b:
            r4 = move-exception
        L_0x004c:
            java.lang.String r5 = "MPChart-FileUtils"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0048 }
            android.util.Log.e(r5, r4)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r4 = move-exception
            java.lang.String r5 = "MPChart-FileUtils"
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r5, r4)
        L_0x0065:
            return r0
        L_0x0066:
            if (r2 == 0) goto L_0x0076
            r2.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0076
        L_0x006c:
            r5 = move-exception
            java.lang.String r0 = "MPChart-FileUtils"
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L_0x0076:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadBarEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }
}
