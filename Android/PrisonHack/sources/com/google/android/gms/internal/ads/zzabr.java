package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzadh
public final class zzabr extends zzabh {
    /* access modifiers changed from: private */
    public final zzaqw zzbnd;
    private zzwy zzbtj;
    @VisibleForTesting
    private zzww zzbzq;
    protected zzxe zzbzr;
    /* access modifiers changed from: private */
    public boolean zzbzs;
    private final zznx zzvr;
    private zzxn zzwh;

    zzabr(Context context, zzaji zzaji, zzxn zzxn, zzabm zzabm, zznx zznx, zzaqw zzaqw) {
        super(context, zzaji, zzabm);
        this.zzwh = zzxn;
        this.zzbtj = zzaji.zzcod;
        this.zzvr = zznx;
        this.zzbnd = zzaqw;
    }

    public final void onStop() {
        synchronized (this.zzbzh) {
            super.onStop();
            if (this.zzbzq != null) {
                this.zzbzq.cancel();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final zzajh zzaa(int i) {
        zzwy zzwy;
        boolean z;
        String str;
        long j;
        zzael zzael;
        String str2;
        zzwy zzwy2;
        boolean z2;
        String str3;
        long j2;
        int i2;
        zzaef zzaef = this.zzbze.zzcgs;
        zzjj zzjj = zzaef.zzccv;
        zzaqw zzaqw = this.zzbnd;
        List<String> list = this.zzbzf.zzbsn;
        List<String> list2 = this.zzbzf.zzbso;
        List<String> list3 = this.zzbzf.zzces;
        int i3 = this.zzbzf.orientation;
        long j3 = this.zzbzf.zzbsu;
        String str4 = zzaef.zzccy;
        boolean z3 = this.zzbzf.zzceq;
        zzwx zzwx = this.zzbzr != null ? this.zzbzr.zzbtw : null;
        zzxq zzxq = this.zzbzr != null ? this.zzbzr.zzbtx : null;
        String name = this.zzbzr != null ? this.zzbzr.zzbty : AdMobAdapter.class.getName();
        zzwy zzwy3 = this.zzbtj;
        zzxa zzxa = this.zzbzr != null ? this.zzbzr.zzbtz : null;
        zzwx zzwx2 = zzwx;
        zzxq zzxq2 = zzxq;
        long j4 = this.zzbzf.zzcer;
        zzjn zzjn = this.zzbze.zzacv;
        long j5 = j4;
        long j6 = this.zzbzf.zzcep;
        long j7 = this.zzbze.zzcoh;
        long j8 = this.zzbzf.zzceu;
        String str5 = this.zzbzf.zzcev;
        JSONObject jSONObject = this.zzbze.zzcob;
        zzaig zzaig = this.zzbzf.zzcfe;
        List<String> list4 = this.zzbzf.zzcff;
        List<String> list5 = this.zzbzf.zzcfg;
        zzjn zzjn2 = zzjn;
        boolean z4 = this.zzbtj != null ? this.zzbtj.zzbsz : false;
        zzael zzael2 = this.zzbzf.zzcfi;
        if (this.zzbzq != null) {
            List<zzxe> zzme = this.zzbzq.zzme();
            zzael = zzael2;
            String str6 = "";
            if (zzme == null) {
                zzwy = zzwy3;
                str2 = str6.toString();
                str = str4;
                z = z3;
                j = j8;
            } else {
                Iterator<zzxe> it = zzme.iterator();
                while (it.hasNext()) {
                    Iterator<zzxe> it2 = it;
                    zzxe next = it.next();
                    if (next != null) {
                        j2 = j8;
                        if (next.zzbtw == null || TextUtils.isEmpty(next.zzbtw.zzbru)) {
                            zzwy2 = zzwy3;
                            str3 = str4;
                            z2 = z3;
                        } else {
                            String valueOf = String.valueOf(str6);
                            String str7 = next.zzbtw.zzbru;
                            switch (next.zzbtv) {
                                case -1:
                                    i2 = 4;
                                    break;
                                case 0:
                                    str3 = str4;
                                    z2 = z3;
                                    i2 = 0;
                                    break;
                                case 1:
                                    str3 = str4;
                                    z2 = z3;
                                    i2 = 1;
                                    break;
                                case 3:
                                    i2 = 2;
                                    break;
                                case 4:
                                    i2 = 3;
                                    break;
                                case 5:
                                    i2 = 5;
                                    break;
                                default:
                                    i2 = 6;
                                    break;
                            }
                            str3 = str4;
                            z2 = z3;
                            long j9 = next.zzbub;
                            zzwy2 = zzwy3;
                            StringBuilder sb = new StringBuilder(String.valueOf(str7).length() + 33);
                            sb.append(str7);
                            sb.append(".");
                            sb.append(i2);
                            sb.append(".");
                            sb.append(j9);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb2).length());
                            sb3.append(valueOf);
                            sb3.append(sb2);
                            sb3.append("_");
                            str6 = sb3.toString();
                        }
                    } else {
                        zzwy2 = zzwy3;
                        str3 = str4;
                        z2 = z3;
                        j2 = j8;
                    }
                    it = it2;
                    j8 = j2;
                    str4 = str3;
                    z3 = z2;
                    zzwy3 = zzwy2;
                }
                zzwy = zzwy3;
                str = str4;
                z = z3;
                j = j8;
                str2 = str6.substring(0, Math.max(0, str6.length() - 1));
            }
        } else {
            zzwy = zzwy3;
            zzael = zzael2;
            str = str4;
            z = z3;
            j = j8;
            str2 = null;
        }
        return new zzajh(zzjj, zzaqw, list, i, list2, list3, i3, j3, str, z, zzwx2, zzxq2, name, zzwy, zzxa, j5, zzjn2, j6, j7, j, str5, jSONObject, (zzpb) null, zzaig, list4, list5, z4, zzael, str2, this.zzbzf.zzbsr, this.zzbzf.zzcfl, this.zzbze.zzcoq, this.zzbzf.zzzl, this.zzbze.zzcor, this.zzbzf.zzcfp, this.zzbzf.zzbsp, this.zzbzf.zzzm, this.zzbzf.zzcfq);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v3, types: [com.google.android.gms.internal.ads.zzww] */
    /* JADX WARNING: type inference failed for: r18v2, types: [com.google.android.gms.internal.ads.zzxk] */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzxh] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00a3, code lost:
        r3 = r3.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(long r33) throws com.google.android.gms.internal.ads.zzabk {
        /*
            r32 = this;
            r1 = r32
            java.lang.Object r2 = r1.zzbzh
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzwy r3 = r1.zzbtj     // Catch:{ all -> 0x0176 }
            int r3 = r3.zzbsx     // Catch:{ all -> 0x0176 }
            r4 = -1
            if (r3 == r4) goto L_0x0043
            com.google.android.gms.internal.ads.zzxh r3 = new com.google.android.gms.internal.ads.zzxh     // Catch:{ all -> 0x0176 }
            android.content.Context r6 = r1.mContext     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaji r4 = r1.zzbze     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaef r7 = r4.zzcgs     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzxn r8 = r1.zzwh     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzwy r9 = r1.zzbtj     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r4 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            boolean r10 = r4.zzare     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r4 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            boolean r11 = r4.zzarg     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r4 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = r4.zzcfj     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r4 = com.google.android.gms.internal.ads.zznk.zzbao     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzni r5 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x0176 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ all -> 0x0176 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0176 }
            long r15 = r4.longValue()     // Catch:{ all -> 0x0176 }
            r17 = 2
            com.google.android.gms.internal.ads.zzaji r4 = r1.zzbze     // Catch:{ all -> 0x0176 }
            boolean r4 = r4.zzcor     // Catch:{ all -> 0x0176 }
            r5 = r3
            r13 = r33
            r18 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r18)     // Catch:{ all -> 0x0176 }
            goto L_0x008a
        L_0x0043:
            com.google.android.gms.internal.ads.zzxk r3 = new com.google.android.gms.internal.ads.zzxk     // Catch:{ all -> 0x0176 }
            android.content.Context r4 = r1.mContext     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaji r5 = r1.zzbze     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaef r5 = r5.zzcgs     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzxn r6 = r1.zzwh     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzwy r7 = r1.zzbtj     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r8 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            boolean r8 = r8.zzare     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r9 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            boolean r9 = r9.zzarg     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaej r10 = r1.zzbzf     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r10.zzcfj     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzna<java.lang.Long> r11 = com.google.android.gms.internal.ads.zznk.zzbao     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzni r12 = com.google.android.gms.internal.ads.zzkb.zzik()     // Catch:{ all -> 0x0176 }
            java.lang.Object r11 = r12.zzd(r11)     // Catch:{ all -> 0x0176 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0176 }
            long r28 = r11.longValue()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zznx r11 = r1.zzvr     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.ads.zzaji r12 = r1.zzbze     // Catch:{ all -> 0x0176 }
            boolean r12 = r12.zzcor     // Catch:{ all -> 0x0176 }
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r33
            r30 = r11
            r31 = r12
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31)     // Catch:{ all -> 0x0176 }
        L_0x008a:
            r1.zzbzq = r3     // Catch:{ all -> 0x0176 }
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            java.util.ArrayList r2 = new java.util.ArrayList
            com.google.android.gms.internal.ads.zzwy r3 = r1.zzbtj
            java.util.List<com.google.android.gms.internal.ads.zzwx> r3 = r3.zzbsm
            r2.<init>(r3)
            com.google.android.gms.internal.ads.zzaji r3 = r1.zzbze
            com.google.android.gms.internal.ads.zzaef r3 = r3.zzcgs
            com.google.android.gms.internal.ads.zzjj r3 = r3.zzccv
            android.os.Bundle r3 = r3.zzaqg
            java.lang.String r4 = "com.google.ads.mediation.admob.AdMobAdapter"
            r5 = 0
            if (r3 == 0) goto L_0x00b0
            android.os.Bundle r3 = r3.getBundle(r4)
            if (r3 == 0) goto L_0x00b0
            java.lang.String r6 = "_skipMediation"
            boolean r3 = r3.getBoolean(r6)
            goto L_0x00b1
        L_0x00b0:
            r3 = 0
        L_0x00b1:
            if (r3 == 0) goto L_0x00cf
            java.util.ListIterator r3 = r2.listIterator()
        L_0x00b7:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00cf
            java.lang.Object r6 = r3.next()
            com.google.android.gms.internal.ads.zzwx r6 = (com.google.android.gms.internal.ads.zzwx) r6
            java.util.List<java.lang.String> r6 = r6.zzbrt
            boolean r6 = r6.contains(r4)
            if (r6 != 0) goto L_0x00b7
            r3.remove()
            goto L_0x00b7
        L_0x00cf:
            com.google.android.gms.internal.ads.zzww r3 = r1.zzbzq
            com.google.android.gms.internal.ads.zzxe r2 = r3.zzh(r2)
            r1.zzbzr = r2
            com.google.android.gms.internal.ads.zzxe r2 = r1.zzbzr
            int r2 = r2.zzbtv
            switch(r2) {
                case 0: goto L_0x0104;
                case 1: goto L_0x00fb;
                default: goto L_0x00de;
            }
        L_0x00de:
            com.google.android.gms.internal.ads.zzabk r2 = new com.google.android.gms.internal.ads.zzabk
            com.google.android.gms.internal.ads.zzxe r3 = r1.zzbzr
            int r3 = r3.zzbtv
            r4 = 40
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.lang.String r4 = "Unexpected mediation result: "
            r6.append(r4)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r2.<init>(r3, r5)
            throw r2
        L_0x00fb:
            com.google.android.gms.internal.ads.zzabk r2 = new com.google.android.gms.internal.ads.zzabk
            java.lang.String r3 = "No fill from any mediation ad networks."
            r4 = 3
            r2.<init>(r3, r4)
            throw r2
        L_0x0104:
            com.google.android.gms.internal.ads.zzxe r2 = r1.zzbzr
            com.google.android.gms.internal.ads.zzwx r2 = r2.zzbtw
            if (r2 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzxe r2 = r1.zzbzr
            com.google.android.gms.internal.ads.zzwx r2 = r2.zzbtw
            java.lang.String r2 = r2.zzbsf
            if (r2 == 0) goto L_0x0175
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch
            r3 = 1
            r2.<init>(r3)
            android.os.Handler r3 = com.google.android.gms.internal.ads.zzakk.zzcrm
            com.google.android.gms.internal.ads.zzabs r4 = new com.google.android.gms.internal.ads.zzabs
            r4.<init>(r1, r2)
            r3.post(r4)
            r3 = 10
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x014e }
            r2.await(r3, r6)     // Catch:{ InterruptedException -> 0x014e }
            java.lang.Object r2 = r1.zzbzh
            monitor-enter(r2)
            boolean r3 = r1.zzbzs     // Catch:{ all -> 0x014a }
            if (r3 != 0) goto L_0x0138
            com.google.android.gms.internal.ads.zzabk r3 = new com.google.android.gms.internal.ads.zzabk     // Catch:{ all -> 0x014a }
            java.lang.String r4 = "View could not be prepared"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x014a }
            throw r3     // Catch:{ all -> 0x014a }
        L_0x0138:
            com.google.android.gms.internal.ads.zzaqw r3 = r1.zzbnd     // Catch:{ all -> 0x014a }
            boolean r3 = r3.isDestroyed()     // Catch:{ all -> 0x014a }
            if (r3 == 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzabk r3 = new com.google.android.gms.internal.ads.zzabk     // Catch:{ all -> 0x014a }
            java.lang.String r4 = "Assets not loaded, web view is destroyed"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x014a }
            throw r3     // Catch:{ all -> 0x014a }
        L_0x0148:
            monitor-exit(r2)     // Catch:{ all -> 0x014a }
            return
        L_0x014a:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x014a }
            throw r3
        L_0x014e:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzabk r3 = new com.google.android.gms.internal.ads.zzabk
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r4 = r4 + 38
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.lang.String r4 = "Interrupted while waiting for latch : "
            r6.append(r4)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.<init>(r2, r5)
            throw r3
        L_0x0175:
            return
        L_0x0176:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabr.zze(long):void");
    }
}
