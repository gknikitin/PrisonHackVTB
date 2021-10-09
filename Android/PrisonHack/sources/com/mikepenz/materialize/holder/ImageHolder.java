package com.mikepenz.materialize.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.p000v4.content.ContextCompat;
import android.widget.ImageView;
import com.mikepenz.materialize.drawable.PressedEffectStateListDrawable;
import com.mikepenz.materialize.util.UIUtils;
import java.io.FileNotFoundException;

public class ImageHolder {
    private Bitmap mBitmap;
    private Drawable mIcon;
    private int mIconRes = -1;
    private Uri mUri;

    public ImageHolder(String str) {
        this.mUri = Uri.parse(str);
    }

    public ImageHolder(Uri uri) {
        this.mUri = uri;
    }

    public ImageHolder(Drawable drawable) {
        this.mIcon = drawable;
    }

    public ImageHolder(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public ImageHolder(@DrawableRes int i) {
        this.mIconRes = i;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public int getIconRes() {
        return this.mIconRes;
    }

    public void setIconRes(int i) {
        this.mIconRes = i;
    }

    public boolean applyTo(ImageView imageView) {
        return applyTo(imageView, (String) null);
    }

    public boolean applyTo(ImageView imageView, String str) {
        if (this.mUri != null) {
            imageView.setImageURI(this.mUri);
            return true;
        } else if (this.mIcon != null) {
            imageView.setImageDrawable(this.mIcon);
            return true;
        } else if (this.mBitmap != null) {
            imageView.setImageBitmap(this.mBitmap);
            return true;
        } else if (this.mIconRes != -1) {
            imageView.setImageResource(this.mIconRes);
            return true;
        } else {
            imageView.setImageBitmap((Bitmap) null);
            return false;
        }
    }

    public Drawable decideIcon(Context context, int i, boolean z) {
        Drawable drawable = this.mIcon;
        if (this.mIconRes != -1) {
            drawable = ContextCompat.getDrawable(context, this.mIconRes);
        } else if (this.mUri != null) {
            try {
                drawable = Drawable.createFromStream(context.getContentResolver().openInputStream(this.mUri), this.mUri.toString());
            } catch (FileNotFoundException unused) {
            }
        }
        if (drawable == null || !z) {
            return drawable;
        }
        Drawable mutate = drawable.mutate();
        mutate.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return mutate;
    }

    public static boolean applyTo(ImageHolder imageHolder, ImageView imageView) {
        return applyTo(imageHolder, imageView, (String) null);
    }

    public static boolean applyTo(ImageHolder imageHolder, ImageView imageView, String str) {
        if (imageHolder == null || imageView == null) {
            return false;
        }
        return imageHolder.applyTo(imageView, str);
    }

    public static void applyToOrSetInvisible(ImageHolder imageHolder, ImageView imageView) {
        applyToOrSetInvisible(imageHolder, imageView, (String) null);
    }

    public static void applyToOrSetInvisible(ImageHolder imageHolder, ImageView imageView, String str) {
        boolean applyTo = applyTo(imageHolder, imageView, str);
        if (imageView == null) {
            return;
        }
        if (applyTo) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
    }

    public static void applyToOrSetGone(ImageHolder imageHolder, ImageView imageView) {
        applyToOrSetGone(imageHolder, imageView, (String) null);
    }

    public static void applyToOrSetGone(ImageHolder imageHolder, ImageView imageView, String str) {
        boolean applyTo = applyTo(imageHolder, imageView, str);
        if (imageView == null) {
            return;
        }
        if (applyTo) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static Drawable decideIcon(ImageHolder imageHolder, Context context, int i, boolean z) {
        if (imageHolder == null) {
            return null;
        }
        return imageHolder.decideIcon(context, i, z);
    }

    public static void applyDecidedIconOrSetGone(ImageHolder imageHolder, ImageView imageView, int i, boolean z) {
        if (imageHolder != null && imageView != null) {
            Drawable decideIcon = decideIcon(imageHolder, imageView.getContext(), i, z);
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

    public static void applyMultiIconTo(Drawable drawable, int i, Drawable drawable2, int i2, boolean z, ImageView imageView) {
        if (drawable != null) {
            if (drawable2 != null) {
                if (z) {
                    imageView.setImageDrawable(new PressedEffectStateListDrawable(drawable, drawable2, i, i2));
                } else {
                    imageView.setImageDrawable(UIUtils.getIconStateList(drawable, drawable2));
                }
            } else if (z) {
                imageView.setImageDrawable(new PressedEffectStateListDrawable(drawable, i, i2));
            } else {
                imageView.setImageDrawable(drawable);
            }
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }
}
