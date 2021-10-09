package com.google.android.gms.internal.ads;

final class zzbdk {

    /* renamed from: info  reason: collision with root package name */
    private final String f115info;
    private int position = 0;

    zzbdk(String str) {
        this.f115info = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean hasNext() {
        return this.position < this.f115info.length();
    }

    /* access modifiers changed from: package-private */
    public final int next() {
        String str = this.f115info;
        int i = this.position;
        this.position = i + 1;
        char charAt = str.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        char c = charAt & 8191;
        int i2 = 13;
        while (true) {
            String str2 = this.f115info;
            int i3 = this.position;
            this.position = i3 + 1;
            char charAt2 = str2.charAt(i3);
            if (charAt2 < 55296) {
                return c | (charAt2 << i2);
            }
            c |= (charAt2 & 8191) << i2;
            i2 += 13;
        }
    }
}
