package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class zzai implements ComponentFactory {
    static final ComponentFactory zzcf = new zzai();

    private zzai() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.get(FirebaseApp.class));
    }
}
