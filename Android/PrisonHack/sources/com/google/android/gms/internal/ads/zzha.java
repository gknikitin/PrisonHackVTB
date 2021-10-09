package com.google.android.gms.internal.ads;

@zzadh
public final class zzha {
    private final int zzaiz;
    private final zzgq zzajb;
    private String zzajj;
    private String zzajk;
    private final boolean zzajl = false;
    private final int zzajm;
    private final int zzajn;

    public zzha(int i, int i2, int i3) {
        this.zzaiz = i;
        if (i2 > 64 || i2 < 0) {
            this.zzajm = 64;
        } else {
            this.zzajm = i2;
        }
        if (i3 <= 0) {
            this.zzajn = 1;
        } else {
            this.zzajn = i3;
        }
        this.zzajb = new zzgz(this.zzajm);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0108, code lost:
        if (r3.size() < r1.zzaiz) goto L_0x010c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0113 A[LOOP:0: B:1:0x0012->B:65:0x0113, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0117 A[EDGE_INSN: B:76:0x0117->B:66:0x0117 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(java.util.ArrayList<java.lang.String> r18, java.util.ArrayList<com.google.android.gms.internal.ads.zzgp> r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r19
            com.google.android.gms.internal.ads.zzhb r3 = new com.google.android.gms.internal.ads.zzhb
            r3.<init>(r1)
            java.util.Collections.sort(r2, r3)
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r5 = 0
        L_0x0012:
            int r6 = r19.size()
            if (r5 >= r6) goto L_0x0117
            java.lang.Object r6 = r2.get(r5)
            com.google.android.gms.internal.ads.zzgp r6 = (com.google.android.gms.internal.ads.zzgp) r6
            int r6 = r6.zzhf()
            r7 = r18
            java.lang.Object r6 = r7.get(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.text.Normalizer$Form r8 = java.text.Normalizer.Form.NFKC
            java.lang.String r6 = java.text.Normalizer.normalize(r6, r8)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r6 = r6.toLowerCase(r8)
            java.lang.String r8 = "\n"
            java.lang.String[] r6 = r6.split(r8)
            int r8 = r6.length
            if (r8 == 0) goto L_0x0110
            r8 = 0
        L_0x0040:
            int r10 = r6.length
            if (r8 >= r10) goto L_0x0110
            r10 = r6[r8]
            java.lang.String r11 = "'"
            int r11 = r10.indexOf(r11)
            r12 = -1
            if (r11 == r12) goto L_0x00a8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            r12 = 1
            r13 = 0
        L_0x0055:
            int r14 = r12 + 2
            int r15 = r11.length()
            if (r14 > r15) goto L_0x009b
            char r15 = r11.charAt(r12)
            r4 = 39
            if (r15 != r4) goto L_0x0098
            int r4 = r12 + -1
            char r4 = r11.charAt(r4)
            r13 = 32
            if (r4 == r13) goto L_0x0092
            int r4 = r12 + 1
            char r15 = r11.charAt(r4)
            r9 = 115(0x73, float:1.61E-43)
            if (r15 == r9) goto L_0x0081
            char r4 = r11.charAt(r4)
            r9 = 83
            if (r4 != r9) goto L_0x0092
        L_0x0081:
            int r4 = r11.length()
            if (r14 == r4) goto L_0x008d
            char r4 = r11.charAt(r14)
            if (r4 != r13) goto L_0x0092
        L_0x008d:
            r11.insert(r12, r13)
            r12 = r14
            goto L_0x0095
        L_0x0092:
            r11.setCharAt(r12, r13)
        L_0x0095:
            r4 = 1
            r13 = 1
            goto L_0x0099
        L_0x0098:
            r4 = 1
        L_0x0099:
            int r12 = r12 + r4
            goto L_0x0055
        L_0x009b:
            if (r13 == 0) goto L_0x00a2
            java.lang.String r4 = r11.toString()
            goto L_0x00a3
        L_0x00a2:
            r4 = 0
        L_0x00a3:
            if (r4 == 0) goto L_0x00a8
            r1.zzajk = r4
            goto L_0x00a9
        L_0x00a8:
            r4 = r10
        L_0x00a9:
            r9 = 1
            java.lang.String[] r4 = com.google.android.gms.internal.ads.zzgu.zzb(r4, r9)
            int r10 = r4.length
            int r11 = r1.zzajn
            if (r10 < r11) goto L_0x010c
            r10 = 0
        L_0x00b4:
            int r11 = r4.length
            if (r10 >= r11) goto L_0x0102
            java.lang.String r11 = ""
            r12 = r11
            r11 = 0
        L_0x00bb:
            int r13 = r1.zzajn
            if (r11 >= r13) goto L_0x00f0
            int r13 = r10 + r11
            int r14 = r4.length
            if (r13 < r14) goto L_0x00c6
            r11 = 0
            goto L_0x00f1
        L_0x00c6:
            if (r11 <= 0) goto L_0x00d2
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r14 = " "
            java.lang.String r12 = r12.concat(r14)
        L_0x00d2:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13 = r4[r13]
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r14 = r13.length()
            if (r14 == 0) goto L_0x00e7
            java.lang.String r12 = r12.concat(r13)
            goto L_0x00ed
        L_0x00e7:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
            r12 = r13
        L_0x00ed:
            int r11 = r11 + 1
            goto L_0x00bb
        L_0x00f0:
            r11 = 1
        L_0x00f1:
            if (r11 == 0) goto L_0x0102
            r3.add(r12)
            int r11 = r3.size()
            int r12 = r1.zzaiz
            if (r11 < r12) goto L_0x00ff
            goto L_0x010a
        L_0x00ff:
            int r10 = r10 + 1
            goto L_0x00b4
        L_0x0102:
            int r4 = r3.size()
            int r10 = r1.zzaiz
            if (r4 < r10) goto L_0x010c
        L_0x010a:
            r9 = 0
            goto L_0x0111
        L_0x010c:
            int r8 = r8 + 1
            goto L_0x0040
        L_0x0110:
            r9 = 1
        L_0x0111:
            if (r9 == 0) goto L_0x0117
            int r5 = r5 + 1
            goto L_0x0012
        L_0x0117:
            com.google.android.gms.internal.ads.zzgt r2 = new com.google.android.gms.internal.ads.zzgt
            r2.<init>()
            java.lang.String r4 = ""
            r1.zzajj = r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0124:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0141
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.internal.ads.zzgq r5 = r1.zzajb     // Catch:{ IOException -> 0x013a }
            byte[] r4 = r5.zzx(r4)     // Catch:{ IOException -> 0x013a }
            r2.write(r4)     // Catch:{ IOException -> 0x013a }
            goto L_0x0124
        L_0x013a:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = "Error while writing hash to byteStream"
            com.google.android.gms.internal.ads.zzakb.zzb(r4, r3)
        L_0x0141:
            java.lang.String r2 = r2.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzha.zza(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
