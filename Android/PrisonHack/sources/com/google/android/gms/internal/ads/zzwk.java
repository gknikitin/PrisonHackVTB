package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class zzwk {
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final zzwj<JSONObject> zzbrc = new zzwm();
    private static final zzwh<InputStream> zzbrd = zzwl.zzbre;

    static final /* synthetic */ InputStream zzf(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
