package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.internal.SignInClientImpl;

final class zzb extends Api.AbstractClientBuilder<SignInClientImpl, SignIn.SignInOptionsInternal> {
    zzb() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new SignInClientImpl(context, looper, false, clientSettings, ((SignIn.SignInOptionsInternal) obj).getSignInOptionsBundle(), connectionCallbacks, onConnectionFailedListener);
    }
}
