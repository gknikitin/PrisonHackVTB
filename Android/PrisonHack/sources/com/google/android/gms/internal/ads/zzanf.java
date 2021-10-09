package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzadh
public final class zzanf implements zzamx {
    @Nullable
    private final String zzcpq;

    public zzanf() {
        this((String) null);
    }

    public zzanf(@Nullable String str) {
        this.zzcpq = str;
    }

    @WorkerThread
    public final void zzcz(String str) {
        String message;
        StringBuilder sb;
        String str2;
        HttpURLConnection httpURLConnection;
        try {
            String valueOf = String.valueOf(str);
            zzane.zzck(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzkb.zzif();
            zzamu.zza(true, httpURLConnection, this.zzcpq);
            zzamy zzamy = new zzamy();
            zzamy.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzamy.zza(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                sb2.append("Received non-success response code ");
                sb2.append(responseCode);
                sb2.append(" from pinging URL: ");
                sb2.append(str);
                zzane.zzdk(sb2.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            message = e.getMessage();
            sb = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            str2 = "Error while parsing ping URL: ";
            sb.append(str2);
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzane.zzdk(sb.toString());
        } catch (IOException e2) {
            message = e2.getMessage();
            sb = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
            str2 = "Error while pinging URL: ";
            sb.append(str2);
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzane.zzdk(sb.toString());
        } catch (RuntimeException e3) {
            message = e3.getMessage();
            sb = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
            str2 = "Error while pinging URL: ";
            sb.append(str2);
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzane.zzdk(sb.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
