package com.google.android.gms.internal.measurement;

final class zzfi implements Runnable {
    private final /* synthetic */ int zzajg;
    private final /* synthetic */ String zzajh;
    private final /* synthetic */ Object zzaji;
    private final /* synthetic */ Object zzajj;
    private final /* synthetic */ Object zzajk;
    private final /* synthetic */ zzfh zzajl;

    zzfi(zzfh zzfh, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzajl = zzfh;
        this.zzajg = i;
        this.zzajh = str;
        this.zzaji = obj;
        this.zzajj = obj2;
        this.zzajk = obj3;
    }

    public final void run() {
        zzfh zzfh;
        char c;
        zzfs zzgg = this.zzajl.zzacw.zzgg();
        if (!zzgg.isInitialized()) {
            this.zzajl.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzajl.zzaiv == 0) {
            if (this.zzajl.zzgh().zzds()) {
                zzfh = this.zzajl;
                this.zzajl.zzgi();
                c = 'C';
            } else {
                zzfh = this.zzajl;
                this.zzajl.zzgi();
                c = 'c';
            }
            char unused = zzfh.zzaiv = c;
        }
        if (this.zzajl.zzadu < 0) {
            long unused2 = this.zzajl.zzadu = 12451;
        }
        char charAt = "01VDIWEA?".charAt(this.zzajg);
        char zza = this.zzajl.zzaiv;
        long zzb = this.zzajl.zzadu;
        String zza2 = zzfh.zza(true, this.zzajh, this.zzaji, this.zzajj, this.zzajk);
        StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(zza);
        sb.append(zzb);
        sb.append(":");
        sb.append(zza2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzajh.substring(0, 1024);
        }
        zzgg.zzakc.zzc(sb2, 1);
    }
}
