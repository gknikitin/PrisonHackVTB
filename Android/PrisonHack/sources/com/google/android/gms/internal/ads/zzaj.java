package com.google.android.gms.internal.ads;

public class zzaj implements zzm {
    private static final boolean DEBUG = zzaf.DEBUG;
    @Deprecated
    private final zzar zzbo;
    private final zzai zzbp;
    private final zzak zzbq;

    public zzaj(zzai zzai) {
        this(zzai, new zzak(4096));
    }

    private zzaj(zzai zzai, zzak zzak) {
        this.zzbp = zzai;
        this.zzbo = zzai;
        this.zzbq = zzak;
    }

    @Deprecated
    public zzaj(zzar zzar) {
        this(zzar, new zzak(4096));
    }

    @Deprecated
    private zzaj(zzar zzar, zzak zzak) {
        this.zzbo = zzar;
        this.zzbp = new zzah(zzar);
        this.zzbq = zzak;
    }

    private static void zza(String str, zzr<?> zzr, zzae zzae) throws zzae {
        zzab zzj = zzr.zzj();
        int zzi = zzr.zzi();
        try {
            zzj.zza(zzae);
            zzr.zzb(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
        } catch (zzae e) {
            zzr.zzb(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] zza(java.io.InputStream r6, int r7) throws java.io.IOException, com.google.android.gms.internal.ads.zzac {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzau r0 = new com.google.android.gms.internal.ads.zzau
            com.google.android.gms.internal.ads.zzak r1 = r5.zzbq
            r0.<init>(r1, r7)
            r7 = 0
            r1 = 0
            if (r6 != 0) goto L_0x0013
            com.google.android.gms.internal.ads.zzac r2 = new com.google.android.gms.internal.ads.zzac     // Catch:{ all -> 0x0011 }
            r2.<init>()     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            goto L_0x0044
        L_0x0013:
            com.google.android.gms.internal.ads.zzak r2 = r5.zzbq     // Catch:{ all -> 0x0011 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r2 = r2.zzb(r3)     // Catch:{ all -> 0x0011 }
        L_0x001b:
            int r1 = r6.read(r2)     // Catch:{ all -> 0x0040 }
            r3 = -1
            if (r1 == r3) goto L_0x0026
            r0.write(r2, r7, r1)     // Catch:{ all -> 0x0040 }
            goto L_0x001b
        L_0x0026:
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0040 }
            if (r6 == 0) goto L_0x0037
            r6.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0037
        L_0x0030:
            java.lang.String r6 = "Error occurred when closing InputStream"
            java.lang.Object[] r7 = new java.lang.Object[r7]
            com.google.android.gms.internal.ads.zzaf.m38v(r6, r7)
        L_0x0037:
            com.google.android.gms.internal.ads.zzak r6 = r5.zzbq
            r6.zza(r2)
            r0.close()
            return r1
        L_0x0040:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0044:
            if (r6 == 0) goto L_0x0051
            r6.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x0051
        L_0x004a:
            java.lang.String r6 = "Error occurred when closing InputStream"
            java.lang.Object[] r7 = new java.lang.Object[r7]
            com.google.android.gms.internal.ads.zzaf.m38v(r6, r7)
        L_0x0051:
            com.google.android.gms.internal.ads.zzak r6 = r5.zzbq
            r6.zza(r1)
            r0.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaj.zza(java.io.InputStream, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d0, code lost:
        if (r13 != null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01d2, code lost:
        r11 = new com.google.android.gms.internal.ads.zzp(r5, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e2, code lost:
        if (r5 == 401) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01eb, code lost:
        if (r5 < 400) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f6, code lost:
        throw new com.google.android.gms.internal.ads.zzg(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01f9, code lost:
        if (r5 < 500) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0204, code lost:
        throw new com.google.android.gms.internal.ads.zzac(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x020a, code lost:
        throw new com.google.android.gms.internal.ads.zzac(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x020b, code lost:
        zza("auth", r2, new com.google.android.gms.internal.ads.zza(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0217, code lost:
        r5 = "network";
        r6 = new com.google.android.gms.internal.ads.zzo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0224, code lost:
        throw new com.google.android.gms.internal.ads.zzq(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0225, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0226, code lost:
        r3 = r0;
        r2 = java.lang.String.valueOf(r24.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0237, code lost:
        if (r2.length() != 0) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0239, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x023e, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0246, code lost:
        throw new java.lang.RuntimeException(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0247, code lost:
        r5 = "socket";
        r6 = new com.google.android.gms.internal.ads.zzad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x024e, code lost:
        zza(r5, r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0117, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0118, code lost:
        r5 = r0;
        r17 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011b, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0156, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0157, code lost:
        r13 = r5;
        r17 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x019c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x019f, code lost:
        r7 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a0, code lost:
        r13 = r5;
        r17 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a5, code lost:
        r5 = r0;
        r17 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ab, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01ac, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b7, code lost:
        r5 = r10.getStatusCode();
        com.google.android.gms.internal.ads.zzaf.m37e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r5), r24.getUrl());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0225 A[ExcHandler: MalformedURLException (r0v0 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x021f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzp zzc(com.google.android.gms.internal.ads.zzr<?> r24) throws com.google.android.gms.internal.ads.zzae {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.List r5 = java.util.Collections.emptyList()
            r9 = 0
            com.google.android.gms.internal.ads.zzc r10 = r24.zzf()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            if (r10 != 0) goto L_0x0018
            java.util.Map r10 = java.util.Collections.emptyMap()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            goto L_0x003c
        L_0x0018:
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            r11.<init>()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            java.lang.String r12 = r10.zza     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            if (r12 == 0) goto L_0x0028
            java.lang.String r12 = "If-None-Match"
            java.lang.String r13 = r10.zza     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            r11.put(r12, r13)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
        L_0x0028:
            long r12 = r10.zzc     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x003b
            java.lang.String r12 = "If-Modified-Since"
            long r13 = r10.zzc     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            java.lang.String r10 = com.google.android.gms.internal.ads.zzap.zzb((long) r13)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            r11.put(r12, r10)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
        L_0x003b:
            r10 = r11
        L_0x003c:
            com.google.android.gms.internal.ads.zzai r11 = r1.zzbp     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            com.google.android.gms.internal.ads.zzaq r10 = r11.zza(r2, r10)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01af }
            int r12 = r10.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01ab }
            java.util.List r11 = r10.zzq()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01ab }
            r5 = 304(0x130, float:4.26E-43)
            if (r12 != r5) goto L_0x011e
            com.google.android.gms.internal.ads.zzc r5 = r24.zzf()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r5 != 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzp r5 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r14 = 304(0x130, float:4.26E-43)
            r15 = 0
            r16 = 1
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r17 = 0
            long r17 = r12 - r3
            r13 = r5
            r19 = r11
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List<com.google.android.gms.internal.ads.zzl>) r19)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            return r5
        L_0x006a:
            java.util.TreeSet r12 = new java.util.TreeSet     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.Comparator r13 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r12.<init>(r13)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            boolean r13 = r11.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r13 != 0) goto L_0x008f
            java.util.Iterator r13 = r11.iterator()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
        L_0x007b:
            boolean r14 = r13.hasNext()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r14 == 0) goto L_0x008f
            java.lang.Object r14 = r13.next()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            com.google.android.gms.internal.ads.zzl r14 = (com.google.android.gms.internal.ads.zzl) r14     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.String r14 = r14.getName()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r12.add(r14)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            goto L_0x007b
        L_0x008f:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r13.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.List<com.google.android.gms.internal.ads.zzl> r14 = r5.zzg     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r14 == 0) goto L_0x00c0
            java.util.List<com.google.android.gms.internal.ads.zzl> r14 = r5.zzg     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            boolean r14 = r14.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r14 != 0) goto L_0x00ff
            java.util.List<com.google.android.gms.internal.ads.zzl> r14 = r5.zzg     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
        L_0x00a6:
            boolean r15 = r14.hasNext()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r15 == 0) goto L_0x00ff
            java.lang.Object r15 = r14.next()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            com.google.android.gms.internal.ads.zzl r15 = (com.google.android.gms.internal.ads.zzl) r15     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.String r8 = r15.getName()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            boolean r8 = r12.contains(r8)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r8 != 0) goto L_0x00a6
            r13.add(r15)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            goto L_0x00a6
        L_0x00c0:
            java.util.Map<java.lang.String, java.lang.String> r8 = r5.zzf     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            boolean r8 = r8.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r8 != 0) goto L_0x00ff
            java.util.Map<java.lang.String, java.lang.String> r8 = r5.zzf     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
        L_0x00d2:
            boolean r14 = r8.hasNext()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r14 == 0) goto L_0x00ff
            java.lang.Object r14 = r8.next()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            boolean r15 = r12.contains(r15)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            if (r15 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzl r15 = new com.google.android.gms.internal.ads.zzl     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.Object r16 = r14.getKey()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r15.<init>(r6, r14)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r13.add(r15)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            goto L_0x00d2
        L_0x00ff:
            com.google.android.gms.internal.ads.zzp r6 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r16 = 304(0x130, float:4.26E-43)
            byte[] r5 = r5.data     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r18 = 1
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            r8 = 0
            long r19 = r14 - r3
            r15 = r6
            r17 = r5
            r21 = r13
            r15.<init>((int) r16, (byte[]) r17, (boolean) r18, (long) r19, (java.util.List<com.google.android.gms.internal.ads.zzl>) r21)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            return r6
        L_0x0117:
            r0 = move-exception
            r5 = r0
            r17 = r11
        L_0x011b:
            r13 = 0
            goto L_0x01b5
        L_0x011e:
            java.io.InputStream r5 = r10.getContent()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01a4 }
            if (r5 == 0) goto L_0x012d
            int r6 = r10.getContentLength()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            byte[] r5 = r1.zza(r5, r6)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0117 }
            goto L_0x012f
        L_0x012d:
            byte[] r5 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x01a4 }
        L_0x012f:
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r6 = 0
            long r7 = r13 - r3
            boolean r6 = DEBUG     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            if (r6 != 0) goto L_0x0140
            r13 = 3000(0xbb8, double:1.482E-320)
            int r6 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0179
        L_0x0140:
            java.lang.String r6 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r13 = 5
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r13[r9] = r2     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r8 = 1
            r13[r8] = r7     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            if (r5 == 0) goto L_0x015b
            int r7 = r5.length     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0156 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x0156 }
            goto L_0x015d
        L_0x0156:
            r0 = move-exception
            r13 = r5
            r17 = r11
            goto L_0x01b4
        L_0x015b:
            java.lang.String r7 = "null"
        L_0x015d:
            r8 = 2
            r13[r8] = r7     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r7 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r13[r7] = r8     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r7 = 4
            com.google.android.gms.internal.ads.zzab r8 = r24.zzj()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            int r8 = r8.zzd()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r13[r7] = r8     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            com.google.android.gms.internal.ads.zzaf.m36d(r6, r13)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
        L_0x0179:
            r6 = 200(0xc8, float:2.8E-43)
            if (r12 < r6) goto L_0x0195
            r6 = 299(0x12b, float:4.19E-43)
            if (r12 <= r6) goto L_0x0182
            goto L_0x0195
        L_0x0182:
            com.google.android.gms.internal.ads.zzp r6 = new com.google.android.gms.internal.ads.zzp     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r14 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019e }
            r13 = 0
            long r15 = r7 - r3
            r7 = r11
            r11 = r6
            r13 = r5
            r17 = r7
            r11.<init>((int) r12, (byte[]) r13, (boolean) r14, (long) r15, (java.util.List<com.google.android.gms.internal.ads.zzl>) r17)     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019c }
            return r6
        L_0x0195:
            r7 = r11
            java.io.IOException r6 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019c }
            r6.<init>()     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019c }
            throw r6     // Catch:{ SocketTimeoutException -> 0x0247, MalformedURLException -> 0x0225, IOException -> 0x019c }
        L_0x019c:
            r0 = move-exception
            goto L_0x01a0
        L_0x019e:
            r0 = move-exception
            r7 = r11
        L_0x01a0:
            r13 = r5
            r17 = r7
            goto L_0x01b4
        L_0x01a4:
            r0 = move-exception
            r7 = r11
            r5 = r0
            r17 = r7
            goto L_0x011b
        L_0x01ab:
            r0 = move-exception
            r17 = r5
            goto L_0x01b3
        L_0x01af:
            r0 = move-exception
            r17 = r5
            r10 = 0
        L_0x01b3:
            r13 = 0
        L_0x01b4:
            r5 = r0
        L_0x01b5:
            if (r10 == 0) goto L_0x021f
            int r5 = r10.getStatusCode()
            java.lang.String r6 = "Unexpected response code %d for %s"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r7[r9] = r8
            java.lang.String r8 = r24.getUrl()
            r9 = 1
            r7[r9] = r8
            com.google.android.gms.internal.ads.zzaf.m37e(r6, r7)
            if (r13 == 0) goto L_0x0217
            com.google.android.gms.internal.ads.zzp r6 = new com.google.android.gms.internal.ads.zzp
            r14 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r15 = r7 - r3
            r11 = r6
            r12 = r5
            r11.<init>((int) r12, (byte[]) r13, (boolean) r14, (long) r15, (java.util.List<com.google.android.gms.internal.ads.zzl>) r17)
            r7 = 401(0x191, float:5.62E-43)
            if (r5 == r7) goto L_0x020b
            r7 = 403(0x193, float:5.65E-43)
            if (r5 != r7) goto L_0x01e9
            goto L_0x020b
        L_0x01e9:
            r2 = 400(0x190, float:5.6E-43)
            if (r5 < r2) goto L_0x01f7
            r2 = 499(0x1f3, float:6.99E-43)
            if (r5 > r2) goto L_0x01f7
            com.google.android.gms.internal.ads.zzg r2 = new com.google.android.gms.internal.ads.zzg
            r2.<init>(r6)
            throw r2
        L_0x01f7:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r5 < r2) goto L_0x0205
            r2 = 599(0x257, float:8.4E-43)
            if (r5 > r2) goto L_0x0205
            com.google.android.gms.internal.ads.zzac r2 = new com.google.android.gms.internal.ads.zzac
            r2.<init>(r6)
            throw r2
        L_0x0205:
            com.google.android.gms.internal.ads.zzac r2 = new com.google.android.gms.internal.ads.zzac
            r2.<init>(r6)
            throw r2
        L_0x020b:
            java.lang.String r5 = "auth"
            com.google.android.gms.internal.ads.zza r7 = new com.google.android.gms.internal.ads.zza
            r7.<init>(r6)
            zza(r5, r2, r7)
            goto L_0x0008
        L_0x0217:
            java.lang.String r5 = "network"
            com.google.android.gms.internal.ads.zzo r6 = new com.google.android.gms.internal.ads.zzo
            r6.<init>()
            goto L_0x024e
        L_0x021f:
            com.google.android.gms.internal.ads.zzq r2 = new com.google.android.gms.internal.ads.zzq
            r2.<init>(r5)
            throw r2
        L_0x0225:
            r0 = move-exception
            r3 = r0
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "Bad URL "
            java.lang.String r2 = r24.getUrl()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r2.length()
            if (r6 == 0) goto L_0x023e
            java.lang.String r2 = r5.concat(r2)
            goto L_0x0243
        L_0x023e:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5)
        L_0x0243:
            r4.<init>(r2, r3)
            throw r4
        L_0x0247:
            java.lang.String r5 = "socket"
            com.google.android.gms.internal.ads.zzad r6 = new com.google.android.gms.internal.ads.zzad
            r6.<init>()
        L_0x024e:
            zza(r5, r2, r6)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaj.zzc(com.google.android.gms.internal.ads.zzr):com.google.android.gms.internal.ads.zzp");
    }
}
