package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;

public abstract class AbstractDrawerImageLoader implements DrawerImageLoader.IDrawerImageLoader {
    public void cancel(ImageView imageView) {
    }

    public void set(ImageView imageView, Uri uri, Drawable drawable) {
    }

    public void set(ImageView imageView, Uri uri, Drawable drawable, String str) {
        set(imageView, uri, drawable);
        Log.i("MaterialDrawer", "You have not specified a ImageLoader implementation through the DrawerImageLoader.init() method, or you are still overriding the deprecated method set(ImageView iv, Uri u, Drawable d) instead of set(ImageView iv, Uri u, Drawable d, String tag)");
    }

    public Drawable placeholder(Context context) {
        return DrawerUIUtils.getPlaceHolder(context);
    }

    public Drawable placeholder(Context context, String str) {
        return placeholder(context);
    }
}
