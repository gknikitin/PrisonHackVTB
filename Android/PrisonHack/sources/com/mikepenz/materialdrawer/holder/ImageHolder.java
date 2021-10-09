package com.mikepenz.materialdrawer.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.p003v7.content.res.AppCompatResources;
import android.widget.ImageView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import java.io.FileNotFoundException;

public class ImageHolder extends com.mikepenz.materialize.holder.ImageHolder {
    private IIcon mIIcon;

    public ImageHolder(String str) {
        super(str);
    }

    public ImageHolder(Uri uri) {
        super(uri);
    }

    public ImageHolder(Drawable drawable) {
        super(drawable);
    }

    public ImageHolder(Bitmap bitmap) {
        super(bitmap);
    }

    public ImageHolder(@DrawableRes int i) {
        super(i);
    }

    public ImageHolder(IIcon iIcon) {
        super((Bitmap) null);
        this.mIIcon = iIcon;
    }

    public IIcon getIIcon() {
        return this.mIIcon;
    }

    public void setIIcon(IIcon iIcon) {
        this.mIIcon = iIcon;
    }

    public boolean applyTo(ImageView imageView, String str) {
        if (getUri() != null) {
            if (DrawerImageLoader.getInstance().setImage(imageView, getUri(), str)) {
                return true;
            }
            imageView.setImageURI(getUri());
            return true;
        } else if (getIcon() != null) {
            imageView.setImageDrawable(getIcon());
            return true;
        } else if (getBitmap() != null) {
            imageView.setImageBitmap(getBitmap());
            return true;
        } else if (getIconRes() != -1) {
            imageView.setImageResource(getIconRes());
            return true;
        } else if (this.mIIcon != null) {
            imageView.setImageDrawable(new IconicsDrawable(imageView.getContext(), this.mIIcon).actionBar());
            return true;
        } else {
            imageView.setImageBitmap((Bitmap) null);
            return false;
        }
    }

    public Drawable decideIcon(Context context, int i, boolean z, int i2) {
        Drawable icon = getIcon();
        if (this.mIIcon != null) {
            icon = new IconicsDrawable(context, this.mIIcon).color(i).sizeDp(24).paddingDp(i2);
        } else if (getIconRes() != -1) {
            icon = AppCompatResources.getDrawable(context, getIconRes());
        } else if (getUri() != null) {
            try {
                icon = Drawable.createFromStream(context.getContentResolver().openInputStream(getUri()), getUri().toString());
            } catch (FileNotFoundException unused) {
            }
        }
        if (icon == null || !z || this.mIIcon != null) {
            return icon;
        }
        Drawable mutate = icon.mutate();
        mutate.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return mutate;
    }

    public static Drawable decideIcon(ImageHolder imageHolder, Context context, int i, boolean z, int i2) {
        if (imageHolder == null) {
            return null;
        }
        return imageHolder.decideIcon(context, i, z, i2);
    }

    public static void applyDecidedIconOrSetGone(ImageHolder imageHolder, ImageView imageView, int i, boolean z, int i2) {
        if (imageHolder != null && imageView != null) {
            Drawable decideIcon = decideIcon(imageHolder, imageView.getContext(), i, z, i2);
            if (decideIcon != null) {
                imageView.setImageDrawable(decideIcon);
                imageView.setVisibility(0);
            } else if (imageHolder.getBitmap() != null) {
                imageView.setImageBitmap(imageHolder.getBitmap());
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
