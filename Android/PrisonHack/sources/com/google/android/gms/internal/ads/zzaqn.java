package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzadh
public final class zzaqn extends zzaqh {
    private static final Set<String> zzdbg = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzdbh = new DecimalFormat("#,###");
    private File zzdbi;
    private boolean zzdbj;

    public zzaqn(zzapw zzapw) {
        super(zzapw);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzakb.zzdk("Context.getCacheDir() returned null");
            return;
        }
        this.zzdbi = new File(cacheDir, "admobVideoStreams");
        if (!this.zzdbi.isDirectory() && !this.zzdbi.mkdirs()) {
            String valueOf = String.valueOf(this.zzdbi.getAbsolutePath());
            zzakb.zzdk(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzdbi = null;
        } else if (!this.zzdbi.setReadable(true, false) || !this.zzdbi.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzdbi.getAbsolutePath());
            zzakb.zzdk(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzdbi = null;
        }
    }

    private final File zzc(File file) {
        return new File(this.zzdbi, String.valueOf(file.getName()).concat(".done"));
    }

    public final void abort() {
        this.zzdbj = true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:222|223|224|(3:225|226|227)) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ed, code lost:
        r3 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f3, code lost:
        com.google.android.gms.internal.ads.zzakb.zzck(r3);
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f9, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fe, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0209, code lost:
        if (r1 < 400) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r4 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x021b, code lost:
        if (r4.length() == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x021d, code lost:
        r3 = "HTTP request failed. Code: ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0227, code lost:
        r3 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r34).length() + 32);
        r6.append("HTTP status code ");
        r6.append(r1);
        r6.append(" at ");
        r6.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0250, code lost:
        throw new java.io.IOException(r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0251, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0252, code lost:
        r1 = r0;
        r4 = r3;
        r3 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0256, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0257, code lost:
        r1 = r0;
        r3 = "badUrl";
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x025a, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0261, code lost:
        if (r7 >= 0) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r2 = java.lang.String.valueOf(r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x026d, code lost:
        if (r2.length() == 0) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x026f, code lost:
        r1 = "Stream cache aborted, missing content-length header at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0274, code lost:
        r1 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x027a, code lost:
        com.google.android.gms.internal.ads.zzakb.zzdk(r1);
        zza(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zzdbg.remove(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x028b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r1 = zzdbh.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzkb.zzik().zzd(com.google.android.gms.internal.ads.zznk.zzauy)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02a3, code lost:
        if (r7 <= r3) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r34).length());
        r3.append("Content length ");
        r3.append(r1);
        r3.append(" exceeds limit at ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzakb.zzdk(r3.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02de, code lost:
        if (r1.length() == 0) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02e0, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02e5, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02ea, code lost:
        zza(r9, r12.getAbsolutePath(), "sizeExceeded", r1);
        zzdbg.remove(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02f8, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r34).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzakb.zzck(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r10 = com.google.android.gms.ads.internal.zzbv.zzer();
        r17 = r10.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0352, code lost:
        r20 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        r11 = new com.google.android.gms.internal.ads.zzamj(((java.lang.Long) com.google.android.gms.internal.ads.zzkb.zzik().zzd(com.google.android.gms.internal.ads.zznk.zzavb)).longValue());
        r14 = ((java.lang.Long) com.google.android.gms.internal.ads.zzkb.zzik().zzd(com.google.android.gms.internal.ads.zznk.zzava)).longValue();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x036e, code lost:
        r21 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0372, code lost:
        if (r21 < 0) goto L_0x047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0374, code lost:
        r6 = r6 + r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0376, code lost:
        if (r6 <= r3) goto L_0x03bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0378, code lost:
        r1 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0388, code lost:
        if (r3.length() == 0) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x038a, code lost:
        r10 = "File too big for full file cache. Size: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0395, code lost:
        r10 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x039d, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x039e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x039f, code lost:
        r3 = r1;
        r2 = r20;
        r1 = r0;
        r32 = r10;
        r10 = r4;
        r4 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ab, code lost:
        r3 = r1;
        r10 = r4;
        r2 = r20;
        r4 = null;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03b6, code lost:
        r3 = "error";
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03c3, code lost:
        if (r2.write(r1) > 0) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03c5, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03d6, code lost:
        if ((r10.currentTimeMillis() - r17) <= (1000 * r14)) goto L_0x0406;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03d8, code lost:
        r1 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:?, code lost:
        r2 = java.lang.Long.toString(r14);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 29);
        r5.append("Timeout exceeded. Limit: ");
        r5.append(r2);
        r5.append(" sec");
        r10 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0405, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0406, code lost:
        r26 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x040a, code lost:
        if (r8.zzdbj == false) goto L_0x0416;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x040c, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0415, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x041a, code lost:
        if (r11.tryAcquire() == false) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x041c, code lost:
        r21 = r12.getAbsolutePath();
        r27 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0426, code lost:
        r28 = r11;
        r23 = r26;
        r11 = com.google.android.gms.internal.ads.zzamu.zzsy;
        r1 = r1;
        r24 = r2;
        r25 = r3;
        r29 = r14;
        r14 = r4;
        r4 = r21;
        r19 = r6;
        r31 = r5;
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzaqi(r8, r9, r4, r6, r7, false);
        r11.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x044c, code lost:
        r24 = r2;
        r25 = r3;
        r31 = r5;
        r19 = r6;
        r21 = r7;
        r27 = r10;
        r28 = r11;
        r29 = r14;
        r23 = r26;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0460, code lost:
        r4 = r14;
        r6 = r19;
        r7 = r21;
        r1 = r23;
        r2 = r24;
        r3 = r25;
        r10 = r27;
        r11 = r28;
        r14 = r29;
        r5 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0475, code lost:
        r29 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0479, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x047a, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x047b, code lost:
        r1 = r0;
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x047f, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0488, code lost:
        if (com.google.android.gms.internal.ads.zzakb.isLoggable(3) == false) goto L_0x04c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        r1 = zzdbh.format((long) r6);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r34).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzakb.zzck(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04cc, code lost:
        if (r13.isFile() == false) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        r13.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        r13.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
        zza(r9, r12.getAbsolutePath(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04e2, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:?, code lost:
        zzdbg.remove(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04e7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04ed, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04ee, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04ef, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04f3, code lost:
        r14 = r4;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x04f5, code lost:
        r1 = r0;
        r10 = r14;
        r3 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04f9, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04fb, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0503, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0504, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0506, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0507, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0508, code lost:
        r1 = r0;
        r3 = "error";
        r4 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x050f, code lost:
        if ((r1 instanceof java.lang.RuntimeException) != false) goto L_0x0511;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0511, code lost:
        com.google.android.gms.ads.internal.zzbv.zzeo().zza(r1, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x051f, code lost:
        if (r8.zzdbj == false) goto L_0x0545;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0521, code lost:
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r34).length() + 26);
        r5.append("Preload aborted for URL \"");
        r5.append(r9);
        r5.append("\"");
        com.google.android.gms.internal.ads.zzakb.zzdj(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0545, code lost:
        r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r34).length() + 25);
        r6.append("Preload failed for URL \"");
        r6.append(r9);
        r6.append("\"");
        com.google.android.gms.internal.ads.zzakb.zzc(r6.toString(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0574, code lost:
        r5 = java.lang.String.valueOf(r12.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0582, code lost:
        if (r5.length() == 0) goto L_0x0589;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0584, code lost:
        r1 = "Could not delete partial cache file at ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0589, code lost:
        r1 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x058f, code lost:
        com.google.android.gms.internal.ads.zzakb.zzdk(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0592, code lost:
        zza(r9, r12.getAbsolutePath(), r3, r4);
        zzdbg.remove(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x059f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.ads.internal.zzbv.zzew();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzkb.zzik().zzd(com.google.android.gms.internal.ads.zznk.zzavc)).intValue();
        r3 = new java.net.URL(r9);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0153, code lost:
        if (r2 > 20) goto L_0x04fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0155, code lost:
        r5 = r3.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0161, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) != false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016a, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x016b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x016c, code lost:
        r1 = r0;
        r4 = null;
        r2 = r15;
        r3 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzamy();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018a, code lost:
        if ((r7 / 100) != 3) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0192, code lost:
        if (r4 != null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019b, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019c, code lost:
        r6 = new java.net.URL(r3, r4);
        r3 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a5, code lost:
        if (r3 != null) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ae, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b5, code lost:
        if (r3.equals("http") != false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01bd, code lost:
        if (r3.equals("https") != false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01bf, code lost:
        r3 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cb, code lost:
        if (r3.length() == 0) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cd, code lost:
        r2 = "Unsupported scheme: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d2, code lost:
        r2 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01db, code lost:
        throw new java.io.IOException(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01dc, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e6, code lost:
        if (r4.length() == 0) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e8, code lost:
        r3 = "Redirecting to ".concat(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:222:0x04d9 */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0589  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdp(java.lang.String r34) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            java.io.File r1 = r8.zzdbi
            r10 = 0
            r11 = 0
            if (r1 != 0) goto L_0x0010
            java.lang.String r1 = "noCacheDir"
        L_0x000c:
            r8.zza(r9, r10, r1, r10)
            return r11
        L_0x0010:
            java.io.File r1 = r8.zzdbi
            if (r1 != 0) goto L_0x0016
            r4 = 0
            goto L_0x0034
        L_0x0016:
            java.io.File r1 = r8.zzdbi
            java.io.File[] r1 = r1.listFiles()
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x001f:
            if (r3 >= r2) goto L_0x0034
            r5 = r1[r3]
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = ".done"
            boolean r5 = r5.endsWith(r6)
            if (r5 != 0) goto L_0x0031
            int r4 = r4 + 1
        L_0x0031:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x0034:
            com.google.android.gms.internal.ads.zzna<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zznk.zzaux
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r4 <= r1) goto L_0x0098
            java.io.File r1 = r8.zzdbi
            if (r1 != 0) goto L_0x004c
        L_0x004a:
            r1 = 0
            goto L_0x008d
        L_0x004c:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File r3 = r8.zzdbi
            java.io.File[] r3 = r3.listFiles()
            int r4 = r3.length
            r5 = r1
            r2 = r10
            r1 = 0
        L_0x005b:
            if (r1 >= r4) goto L_0x0078
            r7 = r3[r1]
            java.lang.String r12 = r7.getName()
            java.lang.String r13 = ".done"
            boolean r12 = r12.endsWith(r13)
            if (r12 != 0) goto L_0x0075
            long r12 = r7.lastModified()
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x0075
            r2 = r7
            r5 = r12
        L_0x0075:
            int r1 = r1 + 1
            goto L_0x005b
        L_0x0078:
            if (r2 == 0) goto L_0x004a
            boolean r1 = r2.delete()
            java.io.File r2 = r8.zzc(r2)
            boolean r3 = r2.isFile()
            if (r3 == 0) goto L_0x008d
            boolean r2 = r2.delete()
            r1 = r1 & r2
        L_0x008d:
            if (r1 != 0) goto L_0x0010
            java.lang.String r1 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)
            java.lang.String r1 = "expireFailed"
            goto L_0x000c
        L_0x0098:
            com.google.android.gms.internal.ads.zzkb.zzif()
            java.lang.String r1 = com.google.android.gms.internal.ads.zzamu.zzde(r34)
            java.io.File r12 = new java.io.File
            java.io.File r2 = r8.zzdbi
            r12.<init>(r2, r1)
            java.io.File r13 = r8.zzc(r12)
            boolean r1 = r12.isFile()
            r14 = 1
            if (r1 == 0) goto L_0x00de
            boolean r1 = r13.isFile()
            if (r1 == 0) goto L_0x00de
            long r1 = r12.length()
            int r1 = (int) r1
            java.lang.String r2 = "Stream cache hit at "
            java.lang.String r3 = java.lang.String.valueOf(r34)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x00cd
            java.lang.String r2 = r2.concat(r3)
            goto L_0x00d3
        L_0x00cd:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x00d3:
            com.google.android.gms.internal.ads.zzakb.zzck(r2)
            java.lang.String r2 = r12.getAbsolutePath()
            r8.zza((java.lang.String) r9, (java.lang.String) r2, (int) r1)
            return r14
        L_0x00de:
            java.io.File r1 = r8.zzdbi
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r34)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00f8
            java.lang.String r1 = r1.concat(r2)
            r15 = r1
            goto L_0x00fe
        L_0x00f8:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r15 = r2
        L_0x00fe:
            java.util.Set<java.lang.String> r1 = zzdbg
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = zzdbg     // Catch:{ all -> 0x05a0 }
            boolean r2 = r2.contains(r15)     // Catch:{ all -> 0x05a0 }
            if (r2 == 0) goto L_0x012e
            java.lang.String r2 = "Stream cache already in progress at "
            java.lang.String r3 = java.lang.String.valueOf(r34)     // Catch:{ all -> 0x05a0 }
            int r4 = r3.length()     // Catch:{ all -> 0x05a0 }
            if (r4 == 0) goto L_0x011a
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x05a0 }
            goto L_0x0120
        L_0x011a:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x05a0 }
            r3.<init>(r2)     // Catch:{ all -> 0x05a0 }
            r2 = r3
        L_0x0120:
            com.google.android.gms.internal.ads.zzakb.zzdk(r2)     // Catch:{ all -> 0x05a0 }
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ all -> 0x05a0 }
            java.lang.String r3 = "inProgress"
            r8.zza(r9, r2, r3, r10)     // Catch:{ all -> 0x05a0 }
            monitor-exit(r1)     // Catch:{ all -> 0x05a0 }
            return r11
        L_0x012e:
            java.util.Set<java.lang.String> r2 = zzdbg     // Catch:{ all -> 0x05a0 }
            r2.add(r15)     // Catch:{ all -> 0x05a0 }
            monitor-exit(r1)     // Catch:{ all -> 0x05a0 }
            java.lang.String r16 = "error"
            com.google.android.gms.ads.internal.zzbv.zzew()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzna<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zznk.zzavc     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzni r2 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r1 = r1.intValue()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r2.<init>(r9)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r3 = r2
            r2 = 0
        L_0x0150:
            int r2 = r2 + r14
            r4 = 20
            if (r2 > r4) goto L_0x04fb
            java.net.URLConnection r5 = r3.openConnection()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r5.setConnectTimeout(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r5.setReadTimeout(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException | RuntimeException -> 0x0506 }
            if (r6 != 0) goto L_0x0173
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "Invalid protocol."
            r1.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            throw r1     // Catch:{ IOException | RuntimeException -> 0x016b }
        L_0x016b:
            r0 = move-exception
            r1 = r0
            r4 = r10
            r2 = r15
            r3 = r16
            goto L_0x050d
        L_0x0173:
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzamy r6 = new com.google.android.gms.internal.ads.zzamy     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r6.<init>()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r6.zza((java.net.HttpURLConnection) r5, (byte[]) r10)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r7 = r5.getResponseCode()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r6.zza((java.net.HttpURLConnection) r5, (int) r7)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01fc
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r4 != 0) goto L_0x019c
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "Missing Location header in redirect"
            r1.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            throw r1     // Catch:{ IOException | RuntimeException -> 0x016b }
        L_0x019c:
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException | RuntimeException -> 0x016b }
            r6.<init>(r3, r4)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r3 = r6.getProtocol()     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r3 != 0) goto L_0x01af
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "Protocol is null"
            r1.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            throw r1     // Catch:{ IOException | RuntimeException -> 0x016b }
        L_0x01af:
            java.lang.String r7 = "http"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r7 != 0) goto L_0x01dc
            java.lang.String r7 = "https"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r7 != 0) goto L_0x01dc
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "Unsupported scheme: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r4 = r3.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r4 == 0) goto L_0x01d2
            java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException | RuntimeException -> 0x016b }
            goto L_0x01d8
        L_0x01d2:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r2 = r3
        L_0x01d8:
            r1.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            throw r1     // Catch:{ IOException | RuntimeException -> 0x016b }
        L_0x01dc:
            java.lang.String r3 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r7 = r4.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r7 == 0) goto L_0x01ed
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException | RuntimeException -> 0x016b }
            goto L_0x01f3
        L_0x01ed:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x016b }
            r4.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3 = r4
        L_0x01f3:
            com.google.android.gms.internal.ads.zzakb.zzck(r3)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r5.disconnect()     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3 = r6
            goto L_0x0150
        L_0x01fc:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException | RuntimeException -> 0x0506 }
            if (r1 == 0) goto L_0x025d
            r1 = r5
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r1 = r1.getResponseCode()     // Catch:{ IOException | RuntimeException -> 0x016b }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x025d
            java.lang.String r2 = "badUrl"
            java.lang.String r3 = "HTTP request failed. Code: "
            java.lang.String r4 = java.lang.Integer.toString(r1)     // Catch:{ IOException | RuntimeException -> 0x0256 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException | RuntimeException -> 0x0256 }
            int r5 = r4.length()     // Catch:{ IOException | RuntimeException -> 0x0256 }
            if (r5 == 0) goto L_0x0222
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException | RuntimeException -> 0x0256 }
            goto L_0x0228
        L_0x0222:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x0256 }
            r4.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x0256 }
            r3 = r4
        L_0x0228:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x0251 }
            java.lang.String r5 = java.lang.String.valueOf(r34)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            int r5 = r5.length()     // Catch:{ IOException | RuntimeException -> 0x0251 }
            int r5 = r5 + 32
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException | RuntimeException -> 0x0251 }
            r6.<init>(r5)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            java.lang.String r5 = "HTTP status code "
            r6.append(r5)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            r6.append(r1)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            java.lang.String r1 = " at "
            r6.append(r1)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            r6.append(r9)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            java.lang.String r1 = r6.toString()     // Catch:{ IOException | RuntimeException -> 0x0251 }
            r4.<init>(r1)     // Catch:{ IOException | RuntimeException -> 0x0251 }
            throw r4     // Catch:{ IOException | RuntimeException -> 0x0251 }
        L_0x0251:
            r0 = move-exception
            r1 = r0
            r4 = r3
            r3 = r2
            goto L_0x025a
        L_0x0256:
            r0 = move-exception
            r1 = r0
            r3 = r2
            r4 = r10
        L_0x025a:
            r2 = r15
            goto L_0x050d
        L_0x025d:
            int r7 = r5.getContentLength()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            if (r7 >= 0) goto L_0x028c
            java.lang.String r1 = "Stream cache aborted, missing content-length header at "
            java.lang.String r2 = java.lang.String.valueOf(r34)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r3 = r2.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r3 == 0) goto L_0x0274
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            goto L_0x027a
        L_0x0274:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x016b }
            r2.<init>(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r1 = r2
        L_0x027a:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "contentLengthMissing"
            r8.zza(r9, r1, r2, r10)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.util.Set<java.lang.String> r1 = zzdbg     // Catch:{ IOException | RuntimeException -> 0x016b }
            r1.remove(r15)     // Catch:{ IOException | RuntimeException -> 0x016b }
            return r11
        L_0x028c:
            java.text.DecimalFormat r1 = zzdbh     // Catch:{ IOException | RuntimeException -> 0x0506 }
            long r2 = (long) r7     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzna<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zznk.zzauy     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzni r3 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r3 = r2.intValue()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            if (r7 <= r3) goto L_0x02f9
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r2 = r2.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r2 = r2 + 33
            java.lang.String r3 = java.lang.String.valueOf(r34)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r3 = r3.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "Content length "
            r3.append(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3.append(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = " exceeds limit at "
            r3.append(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            r3.append(r9)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException | RuntimeException -> 0x016b }
            com.google.android.gms.internal.ads.zzakb.zzdk(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r2 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            int r3 = r1.length()     // Catch:{ IOException | RuntimeException -> 0x016b }
            if (r3 == 0) goto L_0x02e5
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            goto L_0x02ea
        L_0x02e5:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x016b }
            r1.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x016b }
        L_0x02ea:
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.lang.String r3 = "sizeExceeded"
            r8.zza(r9, r2, r3, r1)     // Catch:{ IOException | RuntimeException -> 0x016b }
            java.util.Set<java.lang.String> r1 = zzdbg     // Catch:{ IOException | RuntimeException -> 0x016b }
            r1.remove(r15)     // Catch:{ IOException | RuntimeException -> 0x016b }
            return r11
        L_0x02f9:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r2 = r2.length()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r34)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r4 = r4.length()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r4.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.String r2 = "Caching "
            r4.append(r2)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r4.append(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r4.append(r9)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            com.google.android.gms.internal.ads.zzakb.zzck(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException | RuntimeException -> 0x0506 }
            r4.<init>(r12)     // Catch:{ IOException | RuntimeException -> 0x0506 }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            com.google.android.gms.common.util.Clock r10 = com.google.android.gms.ads.internal.zzbv.zzer()     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            long r17 = r10.currentTimeMillis()     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r6 = com.google.android.gms.internal.ads.zznk.zzavb     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            com.google.android.gms.internal.ads.zzni r11 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            java.lang.Object r6 = r11.zzd(r6)     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException | RuntimeException -> 0x04f2 }
            r20 = r15
            long r14 = r6.longValue()     // Catch:{ IOException | RuntimeException -> 0x04ed }
            com.google.android.gms.internal.ads.zzamj r11 = new com.google.android.gms.internal.ads.zzamj     // Catch:{ IOException | RuntimeException -> 0x04ed }
            r11.<init>(r14)     // Catch:{ IOException | RuntimeException -> 0x04ed }
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r6 = com.google.android.gms.internal.ads.zznk.zzava     // Catch:{ IOException | RuntimeException -> 0x04ed }
            com.google.android.gms.internal.ads.zzni r14 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ IOException | RuntimeException -> 0x04ed }
            java.lang.Object r6 = r14.zzd(r6)     // Catch:{ IOException | RuntimeException -> 0x04ed }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException | RuntimeException -> 0x04ed }
            long r14 = r6.longValue()     // Catch:{ IOException | RuntimeException -> 0x04ed }
            r6 = 0
        L_0x036e:
            int r21 = r5.read(r1)     // Catch:{ IOException | RuntimeException -> 0x04ed }
            if (r21 < 0) goto L_0x047f
            int r6 = r6 + r21
            if (r6 <= r3) goto L_0x03bc
            java.lang.String r1 = "sizeExceeded"
            java.lang.String r2 = "File too big for full file cache. Size: "
            java.lang.String r3 = java.lang.Integer.toString(r6)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            int r5 = r3.length()     // Catch:{ IOException | RuntimeException -> 0x03aa }
            if (r5 == 0) goto L_0x0390
            java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            r10 = r2
            goto L_0x0396
        L_0x0390:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException | RuntimeException -> 0x03aa }
            r3.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            r10 = r3
        L_0x0396:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x039e }
            java.lang.String r3 = "stream cache file size limit exceeded"
            r2.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x039e }
            throw r2     // Catch:{ IOException | RuntimeException -> 0x039e }
        L_0x039e:
            r0 = move-exception
            r3 = r1
            r2 = r20
            r1 = r0
            r32 = r10
            r10 = r4
            r4 = r32
            goto L_0x050d
        L_0x03aa:
            r0 = move-exception
            r3 = r1
            r10 = r4
            r2 = r20
            r4 = 0
            r1 = r0
            goto L_0x050d
        L_0x03b3:
            r0 = move-exception
            r1 = r0
            r10 = r4
        L_0x03b6:
            r3 = r16
            r2 = r20
            goto L_0x04f9
        L_0x03bc:
            r1.flip()     // Catch:{ IOException | RuntimeException -> 0x0479 }
        L_0x03bf:
            int r21 = r2.write(r1)     // Catch:{ IOException | RuntimeException -> 0x0479 }
            if (r21 > 0) goto L_0x0475
            r1.clear()     // Catch:{ IOException | RuntimeException -> 0x0479 }
            long r21 = r10.currentTimeMillis()     // Catch:{ IOException | RuntimeException -> 0x0479 }
            r23 = 0
            long r23 = r21 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r14
            int r25 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r25 <= 0) goto L_0x0406
            java.lang.String r1 = "downloadTimeout"
            java.lang.String r2 = java.lang.Long.toString(r14)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            int r3 = r3.length()     // Catch:{ IOException | RuntimeException -> 0x03aa }
            int r3 = r3 + 29
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException | RuntimeException -> 0x03aa }
            r5.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r3 = "Timeout exceeded. Limit: "
            r5.append(r3)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            r5.append(r2)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r2 = " sec"
            r5.append(r2)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r10 = r5.toString()     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x039e }
            java.lang.String r3 = "stream cache time limit exceeded"
            r2.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x039e }
            throw r2     // Catch:{ IOException | RuntimeException -> 0x039e }
        L_0x0406:
            r26 = r1
            boolean r1 = r8.zzdbj     // Catch:{ IOException | RuntimeException -> 0x0479 }
            if (r1 == 0) goto L_0x0416
            java.lang.String r1 = "externalAbort"
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x03aa }
            java.lang.String r3 = "abort requested"
            r2.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x03aa }
            throw r2     // Catch:{ IOException | RuntimeException -> 0x03aa }
        L_0x0416:
            boolean r1 = r11.tryAcquire()     // Catch:{ IOException | RuntimeException -> 0x0479 }
            if (r1 == 0) goto L_0x044c
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException | RuntimeException -> 0x0479 }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzamu.zzsy     // Catch:{ IOException | RuntimeException -> 0x0479 }
            r27 = r10
            com.google.android.gms.internal.ads.zzaqi r10 = new com.google.android.gms.internal.ads.zzaqi     // Catch:{ IOException | RuntimeException -> 0x0479 }
            r22 = 0
            r28 = r11
            r23 = r26
            r11 = r1
            r1 = r10
            r24 = r2
            r2 = r8
            r25 = r3
            r3 = r9
            r29 = r14
            r14 = r4
            r4 = r21
            r15 = r5
            r5 = r6
            r19 = r6
            r31 = r15
            r15 = 3
            r6 = r7
            r21 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            r11.post(r10)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            goto L_0x0460
        L_0x044c:
            r24 = r2
            r25 = r3
            r31 = r5
            r19 = r6
            r21 = r7
            r27 = r10
            r28 = r11
            r29 = r14
            r23 = r26
            r15 = 3
            r14 = r4
        L_0x0460:
            r4 = r14
            r6 = r19
            r7 = r21
            r1 = r23
            r2 = r24
            r3 = r25
            r10 = r27
            r11 = r28
            r14 = r29
            r5 = r31
            goto L_0x036e
        L_0x0475:
            r29 = r14
            goto L_0x03bf
        L_0x0479:
            r0 = move-exception
            r14 = r4
        L_0x047b:
            r1 = r0
            r10 = r14
            goto L_0x03b6
        L_0x047f:
            r14 = r4
            r15 = 3
            r14.close()     // Catch:{ IOException | RuntimeException -> 0x04eb }
            boolean r1 = com.google.android.gms.internal.ads.zzakb.isLoggable(r15)     // Catch:{ IOException | RuntimeException -> 0x04eb }
            if (r1 == 0) goto L_0x04c3
            java.text.DecimalFormat r1 = zzdbh     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            long r2 = (long) r6     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            int r2 = r2.length()     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r34)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            int r3 = r3.length()     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            r3.<init>(r2)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            r3.append(r1)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            r3.append(r9)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            com.google.android.gms.internal.ads.zzakb.zzck(r1)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            goto L_0x04c3
        L_0x04c1:
            r0 = move-exception
            goto L_0x047b
        L_0x04c3:
            r1 = 0
            r2 = 1
            r12.setReadable(r2, r1)     // Catch:{ IOException | RuntimeException -> 0x04eb }
            boolean r1 = r13.isFile()     // Catch:{ IOException | RuntimeException -> 0x04eb }
            if (r1 == 0) goto L_0x04d6
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            r13.setLastModified(r1)     // Catch:{ IOException | RuntimeException -> 0x04c1 }
            goto L_0x04d9
        L_0x04d6:
            r13.createNewFile()     // Catch:{ IOException -> 0x04d9 }
        L_0x04d9:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException | RuntimeException -> 0x04eb }
            r8.zza((java.lang.String) r9, (java.lang.String) r1, (int) r6)     // Catch:{ IOException | RuntimeException -> 0x04eb }
            java.util.Set<java.lang.String> r1 = zzdbg     // Catch:{ IOException | RuntimeException -> 0x04eb }
            r2 = r20
            r1.remove(r2)     // Catch:{ IOException | RuntimeException -> 0x04e9 }
            r1 = 1
            return r1
        L_0x04e9:
            r0 = move-exception
            goto L_0x04f5
        L_0x04eb:
            r0 = move-exception
            goto L_0x04ef
        L_0x04ed:
            r0 = move-exception
            r14 = r4
        L_0x04ef:
            r2 = r20
            goto L_0x04f5
        L_0x04f2:
            r0 = move-exception
            r14 = r4
            r2 = r15
        L_0x04f5:
            r1 = r0
            r10 = r14
            r3 = r16
        L_0x04f9:
            r4 = 0
            goto L_0x050d
        L_0x04fb:
            r2 = r15
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException | RuntimeException -> 0x0504 }
            java.lang.String r3 = "Too many redirects (20)"
            r1.<init>(r3)     // Catch:{ IOException | RuntimeException -> 0x0504 }
            throw r1     // Catch:{ IOException | RuntimeException -> 0x0504 }
        L_0x0504:
            r0 = move-exception
            goto L_0x0508
        L_0x0506:
            r0 = move-exception
            r2 = r15
        L_0x0508:
            r1 = r0
            r3 = r16
            r4 = 0
            r10 = 0
        L_0x050d:
            boolean r5 = r1 instanceof java.lang.RuntimeException
            if (r5 == 0) goto L_0x051a
            com.google.android.gms.internal.ads.zzajm r5 = com.google.android.gms.ads.internal.zzbv.zzeo()
            java.lang.String r6 = "VideoStreamFullFileCache.preload"
            r5.zza(r1, r6)
        L_0x051a:
            r10.close()     // Catch:{ IOException | NullPointerException -> 0x051d }
        L_0x051d:
            boolean r5 = r8.zzdbj
            if (r5 == 0) goto L_0x0545
            java.lang.String r1 = java.lang.String.valueOf(r34)
            int r1 = r1.length()
            int r1 = r1 + 26
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            java.lang.String r1 = "Preload aborted for URL \""
            r5.append(r1)
            r5.append(r9)
            java.lang.String r1 = "\""
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            com.google.android.gms.internal.ads.zzakb.zzdj(r1)
            goto L_0x0568
        L_0x0545:
            java.lang.String r5 = java.lang.String.valueOf(r34)
            int r5 = r5.length()
            int r5 = r5 + 25
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Preload failed for URL \""
            r6.append(r5)
            r6.append(r9)
            java.lang.String r5 = "\""
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.google.android.gms.internal.ads.zzakb.zzc(r5, r1)
        L_0x0568:
            boolean r1 = r12.exists()
            if (r1 == 0) goto L_0x0592
            boolean r1 = r12.delete()
            if (r1 != 0) goto L_0x0592
            java.lang.String r1 = "Could not delete partial cache file at "
            java.lang.String r5 = r12.getAbsolutePath()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0589
            java.lang.String r1 = r1.concat(r5)
            goto L_0x058f
        L_0x0589:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1)
            r1 = r5
        L_0x058f:
            com.google.android.gms.internal.ads.zzakb.zzdk(r1)
        L_0x0592:
            java.lang.String r1 = r12.getAbsolutePath()
            r8.zza(r9, r1, r3, r4)
            java.util.Set<java.lang.String> r1 = zzdbg
            r1.remove(r2)
            r1 = 0
            return r1
        L_0x05a0:
            r0 = move-exception
            r2 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x05a0 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqn.zzdp(java.lang.String):boolean");
    }
}
