package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

public class DrawerImageLoader {
    private static DrawerImageLoader SINGLETON;
    private IDrawerImageLoader imageLoader;
    private boolean mHandleAllUris = false;

    public interface IDrawerImageLoader {
        void cancel(ImageView imageView);

        Drawable placeholder(Context context);

        Drawable placeholder(Context context, String str);

        @Deprecated
        void set(ImageView imageView, Uri uri, Drawable drawable);

        void set(ImageView imageView, Uri uri, Drawable drawable, String str);
    }

    public enum Tags {
        PROFILE,
        PROFILE_DRAWER_ITEM,
        ACCOUNT_HEADER
    }

    private DrawerImageLoader(IDrawerImageLoader iDrawerImageLoader) {
        this.imageLoader = iDrawerImageLoader;
    }

    public static DrawerImageLoader init(IDrawerImageLoader iDrawerImageLoader) {
        SINGLETON = new DrawerImageLoader(iDrawerImageLoader);
        return SINGLETON;
    }

    public static DrawerImageLoader getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new DrawerImageLoader(new AbstractDrawerImageLoader() {
            });
        }
        return SINGLETON;
    }

    public DrawerImageLoader withHandleAllUris(boolean z) {
        this.mHandleAllUris = z;
        return this;
    }

    public boolean setImage(ImageView imageView, Uri uri, String str) {
        if (!this.mHandleAllUris && !"http".equals(uri.getScheme()) && !"https".equals(uri.getScheme())) {
            return false;
        }
        if (this.imageLoader == null) {
            return true;
        }
        this.imageLoader.set(imageView, uri, this.imageLoader.placeholder(imageView.getContext(), str), str);
        return true;
    }

    public void cancelImage(ImageView imageView) {
        if (this.imageLoader != null) {
            this.imageLoader.cancel(imageView);
        }
    }

    public IDrawerImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public void setImageLoader(IDrawerImageLoader iDrawerImageLoader) {
        this.imageLoader = iDrawerImageLoader;
    }
}
