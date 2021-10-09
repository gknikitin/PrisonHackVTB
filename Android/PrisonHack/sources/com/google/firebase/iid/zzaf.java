package com.google.firebase.iid;

public final class zzaf extends Exception {
    private final int errorCode;

    public zzaf(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
