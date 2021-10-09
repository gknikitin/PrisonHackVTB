package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialdrawer.view.BezelImageView;
import com.mikepenz.materialize.util.UIUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AccountHeaderBuilder {
    protected View mAccountHeader;
    protected ImageView mAccountHeaderBackground;
    protected View mAccountHeaderContainer;
    protected View mAccountHeaderTextSection;
    protected int mAccountHeaderTextSectionBackgroundResource = -1;
    protected ImageView mAccountSwitcherArrow;
    protected Activity mActivity;
    protected boolean mAlternativeProfileHeaderSwitching = false;
    protected Boolean mCloseDrawerOnProfileListClick = null;
    protected boolean mCompactStyle = false;
    protected boolean mCurrentHiddenInList = false;
    protected IProfile mCurrentProfile;
    protected TextView mCurrentProfileEmail;
    protected TextView mCurrentProfileName;
    protected BezelImageView mCurrentProfileView;
    protected boolean mDividerBelowHeader = true;
    protected Drawer mDrawer;
    protected Typeface mEmailTypeface;
    protected ImageHolder mHeaderBackground;
    protected ImageView.ScaleType mHeaderBackgroundScaleType = null;
    protected DimenHolder mHeight;
    protected Typeface mNameTypeface;
    protected AccountHeader.OnAccountHeaderItemLongClickListener mOnAccountHeaderItemLongClickListener;
    protected AccountHeader.OnAccountHeaderListener mOnAccountHeaderListener;
    protected AccountHeader.OnAccountHeaderProfileImageListener mOnAccountHeaderProfileImageListener;
    protected AccountHeader.OnAccountHeaderSelectionViewClickListener mOnAccountHeaderSelectionViewClickListener;
    protected int mOnProfileClickDrawerCloseDelay = 100;
    protected boolean mOnlyMainProfileImageVisible = false;
    protected boolean mOnlySmallProfileImagesVisible = false;
    protected boolean mPaddingBelowHeader = true;
    protected IProfile mProfileFirst;
    protected BezelImageView mProfileFirstView;
    protected boolean mProfileImagesClickable = true;
    protected boolean mProfileImagesVisible = true;
    protected IProfile mProfileSecond;
    protected BezelImageView mProfileSecondView;
    protected IProfile mProfileThird;
    protected BezelImageView mProfileThirdView;
    protected List<IProfile> mProfiles;
    protected boolean mResetDrawerOnProfileListClick = true;
    protected Bundle mSavedInstance;
    protected String mSelectionFirstLine;
    protected boolean mSelectionFirstLineShown = true;
    protected boolean mSelectionListEnabled = true;
    protected boolean mSelectionListEnabledForSingleProfile = true;
    protected boolean mSelectionListShown = false;
    protected String mSelectionSecondLine;
    protected boolean mSelectionSecondLineShown = true;
    protected ColorHolder mTextColor;
    protected boolean mThreeSmallProfileImages = false;
    protected boolean mTranslucentStatusBar = true;
    protected Typeface mTypeface;
    private View.OnClickListener onCurrentProfileClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AccountHeaderBuilder.this.onProfileImageClick(view, true);
        }
    };
    private View.OnLongClickListener onCurrentProfileLongClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            if (AccountHeaderBuilder.this.mOnAccountHeaderProfileImageListener == null) {
                return false;
            }
            return AccountHeaderBuilder.this.mOnAccountHeaderProfileImageListener.onProfileImageLongClick(view, (IProfile) view.getTag(C0658R.C0661id.material_drawer_profile_header), true);
        }
    };
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
            boolean switchProfiles = (iDrawerItem == null || !(iDrawerItem instanceof IProfile) || !iDrawerItem.isSelectable()) ? false : AccountHeaderBuilder.this.switchProfiles((IProfile) iDrawerItem);
            if (AccountHeaderBuilder.this.mResetDrawerOnProfileListClick) {
                AccountHeaderBuilder.this.mDrawer.setOnDrawerItemClickListener((Drawer.OnDrawerItemClickListener) null);
            }
            if (!(!AccountHeaderBuilder.this.mResetDrawerOnProfileListClick || AccountHeaderBuilder.this.mDrawer == null || view == null || view.getContext() == null)) {
                AccountHeaderBuilder.this.resetDrawerContent(view.getContext());
            }
            if (!(AccountHeaderBuilder.this.mDrawer == null || AccountHeaderBuilder.this.mDrawer.getDrawerBuilder() == null || AccountHeaderBuilder.this.mDrawer.getDrawerBuilder().mMiniDrawer == null)) {
                AccountHeaderBuilder.this.mDrawer.getDrawerBuilder().mMiniDrawer.onProfileClick();
            }
            boolean onProfileChanged = (iDrawerItem == null || !(iDrawerItem instanceof IProfile) || AccountHeaderBuilder.this.mOnAccountHeaderListener == null) ? false : AccountHeaderBuilder.this.mOnAccountHeaderListener.onProfileChanged(view, (IProfile) iDrawerItem, switchProfiles);
            if (AccountHeaderBuilder.this.mCloseDrawerOnProfileListClick != null) {
                onProfileChanged = onProfileChanged && !AccountHeaderBuilder.this.mCloseDrawerOnProfileListClick.booleanValue();
            }
            if (AccountHeaderBuilder.this.mDrawer != null && !onProfileChanged) {
                AccountHeaderBuilder.this.mDrawer.mDrawerBuilder.closeDrawerDelayed();
            }
            return true;
        }
    };
    private Drawer.OnDrawerItemLongClickListener onDrawerItemLongClickListener = new Drawer.OnDrawerItemLongClickListener() {
        public boolean onItemLongClick(View view, int i, IDrawerItem iDrawerItem) {
            if (AccountHeaderBuilder.this.mOnAccountHeaderItemLongClickListener != null) {
                boolean z = iDrawerItem != null && iDrawerItem.isSelected();
                if (iDrawerItem != null && (iDrawerItem instanceof IProfile)) {
                    return AccountHeaderBuilder.this.mOnAccountHeaderItemLongClickListener.onProfileLongClick(view, (IProfile) iDrawerItem, z);
                }
            }
            return false;
        }
    };
    private View.OnClickListener onProfileClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AccountHeaderBuilder.this.onProfileImageClick(view, false);
        }
    };
    private View.OnLongClickListener onProfileLongClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            if (AccountHeaderBuilder.this.mOnAccountHeaderProfileImageListener == null) {
                return false;
            }
            return AccountHeaderBuilder.this.mOnAccountHeaderProfileImageListener.onProfileImageLongClick(view, (IProfile) view.getTag(C0658R.C0661id.material_drawer_profile_header), false);
        }
    };
    private View.OnClickListener onSelectionClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            boolean onClick = AccountHeaderBuilder.this.mOnAccountHeaderSelectionViewClickListener != null ? AccountHeaderBuilder.this.mOnAccountHeaderSelectionViewClickListener.onClick(view, (IProfile) view.getTag(C0658R.C0661id.material_drawer_profile_header)) : false;
            if (AccountHeaderBuilder.this.mAccountSwitcherArrow.getVisibility() == 0 && !onClick) {
                AccountHeaderBuilder.this.toggleSelectionList(view.getContext());
            }
        }
    };

    public AccountHeaderBuilder withActivity(@NonNull Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public AccountHeaderBuilder withCompactStyle(boolean z) {
        this.mCompactStyle = z;
        return this;
    }

    public AccountHeaderBuilder withTypeface(@NonNull Typeface typeface) {
        this.mTypeface = typeface;
        return this;
    }

    public AccountHeaderBuilder withNameTypeface(@NonNull Typeface typeface) {
        this.mNameTypeface = typeface;
        return this;
    }

    public AccountHeaderBuilder withEmailTypeface(@NonNull Typeface typeface) {
        this.mEmailTypeface = typeface;
        return this;
    }

    public AccountHeaderBuilder withHeightPx(int i) {
        this.mHeight = DimenHolder.fromPixel(i);
        return this;
    }

    public AccountHeaderBuilder withHeightDp(int i) {
        this.mHeight = DimenHolder.fromDp(i);
        return this;
    }

    public AccountHeaderBuilder withHeightRes(@DimenRes int i) {
        this.mHeight = DimenHolder.fromResource(i);
        return this;
    }

    public AccountHeaderBuilder withTextColor(@ColorInt int i) {
        this.mTextColor = ColorHolder.fromColor(i);
        return this;
    }

    public AccountHeaderBuilder withTextColorRes(@ColorRes int i) {
        this.mTextColor = ColorHolder.fromColorRes(i);
        return this;
    }

    public AccountHeaderBuilder withCurrentProfileHiddenInList(boolean z) {
        this.mCurrentHiddenInList = z;
        return this;
    }

    @Deprecated
    public AccountHeaderBuilder withSelectionFistLineShown(boolean z) {
        this.mSelectionFirstLineShown = z;
        return this;
    }

    public AccountHeaderBuilder withSelectionFirstLineShown(boolean z) {
        this.mSelectionFirstLineShown = z;
        return this;
    }

    public AccountHeaderBuilder withSelectionSecondLineShown(boolean z) {
        this.mSelectionSecondLineShown = z;
        return this;
    }

    public AccountHeaderBuilder withSelectionFirstLine(String str) {
        this.mSelectionFirstLine = str;
        return this;
    }

    public AccountHeaderBuilder withSelectionSecondLine(String str) {
        this.mSelectionSecondLine = str;
        return this;
    }

    public AccountHeaderBuilder withPaddingBelowHeader(boolean z) {
        this.mPaddingBelowHeader = z;
        return this;
    }

    public AccountHeaderBuilder withDividerBelowHeader(boolean z) {
        this.mDividerBelowHeader = z;
        return this;
    }

    public AccountHeaderBuilder withTranslucentStatusBar(boolean z) {
        this.mTranslucentStatusBar = z;
        return this;
    }

    public AccountHeaderBuilder withHeaderBackground(Drawable drawable) {
        this.mHeaderBackground = new ImageHolder(drawable);
        return this;
    }

    public AccountHeaderBuilder withHeaderBackground(@DrawableRes int i) {
        this.mHeaderBackground = new ImageHolder(i);
        return this;
    }

    public AccountHeaderBuilder withHeaderBackground(ImageHolder imageHolder) {
        this.mHeaderBackground = imageHolder;
        return this;
    }

    public AccountHeaderBuilder withHeaderBackgroundScaleType(ImageView.ScaleType scaleType) {
        this.mHeaderBackgroundScaleType = scaleType;
        return this;
    }

    public AccountHeaderBuilder withProfileImagesVisible(boolean z) {
        this.mProfileImagesVisible = z;
        return this;
    }

    public AccountHeaderBuilder withOnlyMainProfileImageVisible(boolean z) {
        this.mOnlyMainProfileImageVisible = z;
        return this;
    }

    public AccountHeaderBuilder withOnlySmallProfileImagesVisible(boolean z) {
        this.mOnlySmallProfileImagesVisible = z;
        return this;
    }

    public AccountHeaderBuilder withCloseDrawerOnProfileListClick(boolean z) {
        this.mCloseDrawerOnProfileListClick = Boolean.valueOf(z);
        return this;
    }

    public AccountHeaderBuilder withResetDrawerOnProfileListClick(boolean z) {
        this.mResetDrawerOnProfileListClick = z;
        return this;
    }

    public AccountHeaderBuilder withProfileImagesClickable(boolean z) {
        this.mProfileImagesClickable = z;
        return this;
    }

    public AccountHeaderBuilder withAlternativeProfileHeaderSwitching(boolean z) {
        this.mAlternativeProfileHeaderSwitching = z;
        return this;
    }

    public AccountHeaderBuilder withThreeSmallProfileImages(boolean z) {
        this.mThreeSmallProfileImages = z;
        return this;
    }

    public AccountHeaderBuilder withOnProfileClickDrawerCloseDelay(int i) {
        this.mOnProfileClickDrawerCloseDelay = i;
        return this;
    }

    public AccountHeaderBuilder withOnAccountHeaderProfileImageListener(AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener) {
        this.mOnAccountHeaderProfileImageListener = onAccountHeaderProfileImageListener;
        return this;
    }

    public AccountHeaderBuilder withOnAccountHeaderSelectionViewClickListener(AccountHeader.OnAccountHeaderSelectionViewClickListener onAccountHeaderSelectionViewClickListener) {
        this.mOnAccountHeaderSelectionViewClickListener = onAccountHeaderSelectionViewClickListener;
        return this;
    }

    public AccountHeaderBuilder withSelectionListEnabledForSingleProfile(boolean z) {
        this.mSelectionListEnabledForSingleProfile = z;
        return this;
    }

    public AccountHeaderBuilder withSelectionListEnabled(boolean z) {
        this.mSelectionListEnabled = z;
        return this;
    }

    public AccountHeaderBuilder withAccountHeader(@NonNull View view) {
        this.mAccountHeaderContainer = view;
        return this;
    }

    public AccountHeaderBuilder withAccountHeader(@LayoutRes int i) {
        if (this.mActivity == null) {
            throw new RuntimeException("please pass an activity first to use this call");
        }
        if (i != -1) {
            this.mAccountHeaderContainer = this.mActivity.getLayoutInflater().inflate(i, (ViewGroup) null, false);
        } else if (this.mCompactStyle) {
            this.mAccountHeaderContainer = this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer_compact_header, (ViewGroup) null, false);
        } else {
            this.mAccountHeaderContainer = this.mActivity.getLayoutInflater().inflate(C0658R.layout.material_drawer_header, (ViewGroup) null, false);
        }
        return this;
    }

    public AccountHeaderBuilder withProfiles(@NonNull List<IProfile> list) {
        if (this.mDrawer != null) {
            this.mDrawer.mDrawerBuilder.idDistributor.checkIds(list);
        }
        this.mProfiles = list;
        return this;
    }

    public AccountHeaderBuilder addProfiles(@NonNull IProfile... iProfileArr) {
        if (this.mProfiles == null) {
            this.mProfiles = new ArrayList();
        }
        if (this.mDrawer != null) {
            this.mDrawer.mDrawerBuilder.idDistributor.checkIds((Identifiable[]) iProfileArr);
        }
        Collections.addAll(this.mProfiles, iProfileArr);
        return this;
    }

    public AccountHeaderBuilder withOnAccountHeaderListener(AccountHeader.OnAccountHeaderListener onAccountHeaderListener) {
        this.mOnAccountHeaderListener = onAccountHeaderListener;
        return this;
    }

    public AccountHeaderBuilder withOnAccountHeaderItemLongClickListener(AccountHeader.OnAccountHeaderItemLongClickListener onAccountHeaderItemLongClickListener) {
        this.mOnAccountHeaderItemLongClickListener = onAccountHeaderItemLongClickListener;
        return this;
    }

    public AccountHeaderBuilder withDrawer(@NonNull Drawer drawer) {
        this.mDrawer = drawer;
        drawer.getRecyclerView().setPadding(drawer.getRecyclerView().getPaddingLeft(), 0, drawer.getRecyclerView().getPaddingRight(), drawer.getRecyclerView().getPaddingBottom());
        return this;
    }

    public AccountHeaderBuilder withSavedInstance(Bundle bundle) {
        this.mSavedInstance = bundle;
        return this;
    }

    private void setHeaderHeight(int i) {
        if (this.mAccountHeaderContainer != null) {
            ViewGroup.LayoutParams layoutParams = this.mAccountHeaderContainer.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.mAccountHeaderContainer.setLayoutParams(layoutParams);
            }
            View findViewById = this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header);
            if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = i;
                findViewById.setLayoutParams(layoutParams2);
            }
            View findViewById2 = this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header_background);
            if (findViewById2 != null) {
                ViewGroup.LayoutParams layoutParams3 = findViewById2.getLayoutParams();
                layoutParams3.height = i;
                findViewById2.setLayoutParams(layoutParams3);
            }
        }
    }

    private void handleSelectionView(IProfile iProfile, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((FrameLayout) this.mAccountHeaderContainer).setForeground(AppCompatResources.getDrawable(this.mAccountHeaderContainer.getContext(), this.mAccountHeaderTextSectionBackgroundResource));
                this.mAccountHeaderContainer.setOnClickListener(this.onSelectionClickListener);
                this.mAccountHeaderContainer.setTag(C0658R.C0661id.material_drawer_profile_header, iProfile);
                return;
            }
            this.mAccountHeaderTextSection.setBackgroundResource(this.mAccountHeaderTextSectionBackgroundResource);
            this.mAccountHeaderTextSection.setOnClickListener(this.onSelectionClickListener);
            this.mAccountHeaderTextSection.setTag(C0658R.C0661id.material_drawer_profile_header, iProfile);
        } else if (Build.VERSION.SDK_INT >= 21) {
            ((FrameLayout) this.mAccountHeaderContainer).setForeground((Drawable) null);
            this.mAccountHeaderContainer.setOnClickListener((View.OnClickListener) null);
        } else {
            UIUtils.setBackground(this.mAccountHeaderTextSection, (Drawable) null);
            this.mAccountHeaderTextSection.setOnClickListener((View.OnClickListener) null);
        }
    }

    public AccountHeader build() {
        int i;
        int i2;
        if (this.mAccountHeaderContainer == null) {
            withAccountHeader(-1);
        }
        this.mAccountHeader = this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header);
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_account_header_height);
        int statusBarHeight = UIUtils.getStatusBarHeight(this.mActivity, true);
        if (this.mHeight != null) {
            i = this.mHeight.asPixel(this.mActivity);
        } else if (this.mCompactStyle) {
            i = this.mActivity.getResources().getDimensionPixelSize(C0658R.dimen.material_drawer_account_header_height_compact);
        } else {
            i = (int) (((double) DrawerUIUtils.getOptimalDrawerWidth(this.mActivity)) * 0.5625d);
            if (Build.VERSION.SDK_INT < 19) {
                int i3 = i - statusBarHeight;
                if (((float) i3) > ((float) dimensionPixelSize) - UIUtils.convertDpToPixel(8.0f, this.mActivity)) {
                    i = i3;
                }
            }
        }
        if (this.mTranslucentStatusBar && Build.VERSION.SDK_INT >= 21) {
            this.mAccountHeader.setPadding(this.mAccountHeader.getPaddingLeft(), this.mAccountHeader.getPaddingTop() + statusBarHeight, this.mAccountHeader.getPaddingRight(), this.mAccountHeader.getPaddingBottom());
            if (this.mCompactStyle) {
                i += statusBarHeight;
            } else if (i - statusBarHeight <= dimensionPixelSize) {
                i = dimensionPixelSize + statusBarHeight;
            }
        }
        setHeaderHeight(i);
        this.mAccountHeaderBackground = (ImageView) this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header_background);
        ImageHolder.applyTo(this.mHeaderBackground, this.mAccountHeaderBackground, DrawerImageLoader.Tags.ACCOUNT_HEADER.name());
        if (this.mHeaderBackgroundScaleType != null) {
            this.mAccountHeaderBackground.setScaleType(this.mHeaderBackgroundScaleType);
        }
        int color = ColorHolder.color(this.mTextColor, this.mActivity, C0658R.attr.material_drawer_header_selection_text, C0658R.C0659color.material_drawer_header_selection_text);
        if (this.mCompactStyle) {
            this.mAccountHeaderTextSection = this.mAccountHeader;
        } else {
            this.mAccountHeaderTextSection = this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header_text_section);
        }
        this.mAccountHeaderTextSectionBackgroundResource = UIUtils.getSelectableBackgroundRes(this.mActivity);
        handleSelectionView(this.mCurrentProfile, true);
        this.mAccountSwitcherArrow = (ImageView) this.mAccountHeaderContainer.findViewById(C0658R.C0661id.material_drawer_account_header_text_switcher);
        this.mAccountSwitcherArrow.setImageDrawable(new IconicsDrawable((Context) this.mActivity, (IIcon) MaterialDrawerFont.Icon.mdf_arrow_drop_down).sizeRes(C0658R.dimen.material_drawer_account_header_dropdown).paddingRes(C0658R.dimen.material_drawer_account_header_dropdown_padding).color(color));
        this.mCurrentProfileView = (BezelImageView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_current);
        this.mCurrentProfileName = (TextView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_name);
        this.mCurrentProfileEmail = (TextView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_email);
        if (this.mNameTypeface != null) {
            this.mCurrentProfileName.setTypeface(this.mNameTypeface);
        } else if (this.mTypeface != null) {
            this.mCurrentProfileName.setTypeface(this.mTypeface);
        }
        if (this.mEmailTypeface != null) {
            this.mCurrentProfileEmail.setTypeface(this.mEmailTypeface);
        } else if (this.mTypeface != null) {
            this.mCurrentProfileEmail.setTypeface(this.mTypeface);
        }
        this.mCurrentProfileName.setTextColor(color);
        this.mCurrentProfileEmail.setTextColor(color);
        this.mProfileFirstView = (BezelImageView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_small_first);
        this.mProfileSecondView = (BezelImageView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_small_second);
        this.mProfileThirdView = (BezelImageView) this.mAccountHeader.findViewById(C0658R.C0661id.material_drawer_account_header_small_third);
        calculateProfiles();
        buildProfiles();
        if (!(this.mSavedInstance == null || (i2 = this.mSavedInstance.getInt("bundle_selection_header", -1)) == -1 || this.mProfiles == null || i2 <= -1 || i2 >= this.mProfiles.size())) {
            switchProfiles(this.mProfiles.get(i2));
        }
        if (this.mDrawer != null) {
            this.mDrawer.setHeader(this.mAccountHeaderContainer, this.mPaddingBelowHeader, this.mDividerBelowHeader);
        }
        this.mActivity = null;
        return new AccountHeader(this);
    }

    /* access modifiers changed from: protected */
    public void calculateProfiles() {
        boolean z;
        if (this.mProfiles == null) {
            this.mProfiles = new ArrayList();
        }
        int i = 0;
        if (this.mCurrentProfile == null) {
            int size = this.mProfiles.size();
            int i2 = 0;
            while (i < size) {
                if (this.mProfiles.size() > i && this.mProfiles.get(i).isSelectable()) {
                    if (i2 == 0 && this.mCurrentProfile == null) {
                        this.mCurrentProfile = this.mProfiles.get(i);
                    } else if (i2 == 1 && this.mProfileFirst == null) {
                        this.mProfileFirst = this.mProfiles.get(i);
                    } else if (i2 == 2 && this.mProfileSecond == null) {
                        this.mProfileSecond = this.mProfiles.get(i);
                    } else if (i2 == 3 && this.mProfileThird == null) {
                        this.mProfileThird = this.mProfiles.get(i);
                    }
                    i2++;
                }
                i++;
            }
            return;
        }
        IProfile[] iProfileArr = {this.mCurrentProfile, this.mProfileFirst, this.mProfileSecond, this.mProfileThird};
        IProfile[] iProfileArr2 = new IProfile[4];
        Stack stack = new Stack();
        for (int i3 = 0; i3 < this.mProfiles.size(); i3++) {
            IProfile iProfile = this.mProfiles.get(i3);
            if (iProfile.isSelectable()) {
                int i4 = 0;
                while (true) {
                    if (i4 >= 4) {
                        z = false;
                        break;
                    } else if (iProfileArr[i4] == iProfile) {
                        iProfileArr2[i4] = iProfile;
                        z = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    stack.push(iProfile);
                }
            }
        }
        Stack stack2 = new Stack();
        while (i < 4) {
            if (iProfileArr2[i] != null) {
                stack2.push(iProfileArr2[i]);
            } else if (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            i++;
        }
        Stack stack3 = new Stack();
        while (!stack2.empty()) {
            stack3.push(stack2.pop());
        }
        if (stack3.isEmpty()) {
            this.mCurrentProfile = null;
        } else {
            this.mCurrentProfile = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.mProfileFirst = null;
        } else {
            this.mProfileFirst = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.mProfileSecond = null;
        } else {
            this.mProfileSecond = (IProfile) stack3.pop();
        }
        if (stack3.isEmpty()) {
            this.mProfileThird = null;
        } else {
            this.mProfileThird = (IProfile) stack3.pop();
        }
    }

    /* access modifiers changed from: protected */
    public boolean switchProfiles(IProfile iProfile) {
        if (iProfile == null) {
            return false;
        }
        if (this.mCurrentProfile == iProfile) {
            return true;
        }
        char c = 65535;
        if (this.mAlternativeProfileHeaderSwitching) {
            if (this.mProfileFirst == iProfile) {
                c = 1;
            } else if (this.mProfileSecond == iProfile) {
                c = 2;
            } else if (this.mProfileThird == iProfile) {
                c = 3;
            }
            IProfile iProfile2 = this.mCurrentProfile;
            this.mCurrentProfile = iProfile;
            if (c == 1) {
                this.mProfileFirst = iProfile2;
            } else if (c == 2) {
                this.mProfileSecond = iProfile2;
            } else if (c == 3) {
                this.mProfileThird = iProfile2;
            }
        } else if (this.mProfiles != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new IProfile[]{this.mCurrentProfile, this.mProfileFirst, this.mProfileSecond, this.mProfileThird}));
            if (arrayList.contains(iProfile)) {
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        i = -1;
                        break;
                    } else if (arrayList.get(i) == iProfile) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    arrayList.remove(i);
                    arrayList.add(0, iProfile);
                    this.mCurrentProfile = (IProfile) arrayList.get(0);
                    this.mProfileFirst = (IProfile) arrayList.get(1);
                    this.mProfileSecond = (IProfile) arrayList.get(2);
                    this.mProfileThird = (IProfile) arrayList.get(3);
                }
            } else {
                this.mProfileThird = this.mProfileSecond;
                this.mProfileSecond = this.mProfileFirst;
                this.mProfileFirst = this.mCurrentProfile;
                this.mCurrentProfile = iProfile;
            }
        }
        if (this.mOnlySmallProfileImagesVisible) {
            this.mProfileThird = this.mProfileSecond;
            this.mProfileSecond = this.mProfileFirst;
            this.mProfileFirst = this.mCurrentProfile;
        }
        buildProfiles();
        return false;
    }

    /* access modifiers changed from: protected */
    public void buildProfiles() {
        this.mCurrentProfileView.setVisibility(4);
        this.mAccountHeaderTextSection.setVisibility(4);
        this.mAccountSwitcherArrow.setVisibility(8);
        this.mProfileFirstView.setVisibility(8);
        this.mProfileFirstView.setOnClickListener((View.OnClickListener) null);
        this.mProfileSecondView.setVisibility(8);
        this.mProfileSecondView.setOnClickListener((View.OnClickListener) null);
        this.mProfileThirdView.setVisibility(8);
        this.mProfileThirdView.setOnClickListener((View.OnClickListener) null);
        this.mCurrentProfileName.setText("");
        this.mCurrentProfileEmail.setText("");
        if (!this.mCompactStyle) {
            this.mAccountHeaderTextSection.setPadding(0, 0, (int) UIUtils.convertDpToPixel(56.0f, this.mAccountHeaderTextSection.getContext()), 0);
        }
        handleSelectionView(this.mCurrentProfile, true);
        if (this.mCurrentProfile != null) {
            if ((this.mProfileImagesVisible || this.mOnlyMainProfileImageVisible) && !this.mOnlySmallProfileImagesVisible) {
                setImageOrPlaceholder(this.mCurrentProfileView, this.mCurrentProfile.getIcon());
                if (this.mProfileImagesClickable) {
                    this.mCurrentProfileView.setOnClickListener(this.onCurrentProfileClickListener);
                    this.mCurrentProfileView.setOnLongClickListener(this.onCurrentProfileLongClickListener);
                    this.mCurrentProfileView.disableTouchFeedback(false);
                } else {
                    this.mCurrentProfileView.disableTouchFeedback(true);
                }
                this.mCurrentProfileView.setVisibility(0);
                this.mCurrentProfileView.invalidate();
            } else if (this.mCompactStyle) {
                this.mCurrentProfileView.setVisibility(8);
            }
            this.mAccountHeaderTextSection.setVisibility(0);
            handleSelectionView(this.mCurrentProfile, true);
            this.mAccountSwitcherArrow.setVisibility(0);
            this.mCurrentProfileView.setTag(C0658R.C0661id.material_drawer_profile_header, this.mCurrentProfile);
            StringHolder.applyTo(this.mCurrentProfile.getName(), this.mCurrentProfileName);
            StringHolder.applyTo(this.mCurrentProfile.getEmail(), this.mCurrentProfileEmail);
            if (this.mProfileFirst != null && this.mProfileImagesVisible && !this.mOnlyMainProfileImageVisible) {
                setImageOrPlaceholder(this.mProfileFirstView, this.mProfileFirst.getIcon());
                this.mProfileFirstView.setTag(C0658R.C0661id.material_drawer_profile_header, this.mProfileFirst);
                if (this.mProfileImagesClickable) {
                    this.mProfileFirstView.setOnClickListener(this.onProfileClickListener);
                    this.mProfileFirstView.setOnLongClickListener(this.onProfileLongClickListener);
                    this.mProfileFirstView.disableTouchFeedback(false);
                } else {
                    this.mProfileFirstView.disableTouchFeedback(true);
                }
                this.mProfileFirstView.setVisibility(0);
                this.mProfileFirstView.invalidate();
            }
            if (this.mProfileSecond != null && this.mProfileImagesVisible && !this.mOnlyMainProfileImageVisible) {
                setImageOrPlaceholder(this.mProfileSecondView, this.mProfileSecond.getIcon());
                this.mProfileSecondView.setTag(C0658R.C0661id.material_drawer_profile_header, this.mProfileSecond);
                if (this.mProfileImagesClickable) {
                    this.mProfileSecondView.setOnClickListener(this.onProfileClickListener);
                    this.mProfileSecondView.setOnLongClickListener(this.onProfileLongClickListener);
                    this.mProfileSecondView.disableTouchFeedback(false);
                } else {
                    this.mProfileSecondView.disableTouchFeedback(true);
                }
                this.mProfileSecondView.setVisibility(0);
                this.mProfileSecondView.invalidate();
            }
            if (this.mProfileThird != null && this.mThreeSmallProfileImages && this.mProfileImagesVisible && !this.mOnlyMainProfileImageVisible) {
                setImageOrPlaceholder(this.mProfileThirdView, this.mProfileThird.getIcon());
                this.mProfileThirdView.setTag(C0658R.C0661id.material_drawer_profile_header, this.mProfileThird);
                if (this.mProfileImagesClickable) {
                    this.mProfileThirdView.setOnClickListener(this.onProfileClickListener);
                    this.mProfileThirdView.setOnLongClickListener(this.onProfileLongClickListener);
                    this.mProfileThirdView.disableTouchFeedback(false);
                } else {
                    this.mProfileThirdView.disableTouchFeedback(true);
                }
                this.mProfileThirdView.setVisibility(0);
                this.mProfileThirdView.invalidate();
            }
        } else if (this.mProfiles != null && this.mProfiles.size() > 0) {
            this.mAccountHeaderTextSection.setTag(C0658R.C0661id.material_drawer_profile_header, this.mProfiles.get(0));
            this.mAccountHeaderTextSection.setVisibility(0);
            handleSelectionView(this.mCurrentProfile, true);
            this.mAccountSwitcherArrow.setVisibility(0);
            if (this.mCurrentProfile != null) {
                StringHolder.applyTo(this.mCurrentProfile.getName(), this.mCurrentProfileName);
                StringHolder.applyTo(this.mCurrentProfile.getEmail(), this.mCurrentProfileEmail);
            }
        }
        if (!this.mSelectionFirstLineShown) {
            this.mCurrentProfileName.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mSelectionFirstLine)) {
            this.mCurrentProfileName.setText(this.mSelectionFirstLine);
            this.mAccountHeaderTextSection.setVisibility(0);
        }
        if (!this.mSelectionSecondLineShown) {
            this.mCurrentProfileEmail.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mSelectionSecondLine)) {
            this.mCurrentProfileEmail.setText(this.mSelectionSecondLine);
            this.mAccountHeaderTextSection.setVisibility(0);
        }
        if (!this.mSelectionListEnabled || (!this.mSelectionListEnabledForSingleProfile && this.mProfileFirst == null && (this.mProfiles == null || this.mProfiles.size() == 1))) {
            this.mAccountSwitcherArrow.setVisibility(8);
            handleSelectionView((IProfile) null, false);
            if (!this.mCompactStyle) {
                this.mAccountHeaderTextSection.setPadding(0, 0, (int) UIUtils.convertDpToPixel(16.0f, this.mAccountHeaderTextSection.getContext()), 0);
            }
        }
        if (this.mOnAccountHeaderSelectionViewClickListener != null) {
            handleSelectionView(this.mCurrentProfile, true);
        }
    }

    private void setImageOrPlaceholder(ImageView imageView, ImageHolder imageHolder) {
        DrawerImageLoader.getInstance().cancelImage(imageView);
        imageView.setImageDrawable(DrawerImageLoader.getInstance().getImageLoader().placeholder(imageView.getContext(), DrawerImageLoader.Tags.PROFILE.name()));
        ImageHolder.applyTo(imageHolder, imageView, DrawerImageLoader.Tags.PROFILE.name());
    }

    /* access modifiers changed from: private */
    public void onProfileImageClick(View view, boolean z) {
        if (!(this.mOnAccountHeaderProfileImageListener != null ? this.mOnAccountHeaderProfileImageListener.onProfileImageClick(view, (IProfile) view.getTag(C0658R.C0661id.material_drawer_profile_header), z) : false)) {
            onProfileClick(view, z);
        }
    }

    /* access modifiers changed from: protected */
    public void onProfileClick(View view, boolean z) {
        IProfile iProfile = (IProfile) view.getTag(C0658R.C0661id.material_drawer_profile_header);
        switchProfiles(iProfile);
        resetDrawerContent(view.getContext());
        if (!(this.mDrawer == null || this.mDrawer.getDrawerBuilder() == null || this.mDrawer.getDrawerBuilder().mMiniDrawer == null)) {
            this.mDrawer.getDrawerBuilder().mMiniDrawer.onProfileClick();
        }
        boolean z2 = false;
        if (this.mOnAccountHeaderListener != null) {
            z2 = this.mOnAccountHeaderListener.onProfileChanged(view, iProfile, z);
        }
        if (z2) {
            return;
        }
        if (this.mOnProfileClickDrawerCloseDelay > 0) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (AccountHeaderBuilder.this.mDrawer != null) {
                        AccountHeaderBuilder.this.mDrawer.closeDrawer();
                    }
                }
            }, (long) this.mOnProfileClickDrawerCloseDelay);
        } else if (this.mDrawer != null) {
            this.mDrawer.closeDrawer();
        }
    }

    /* access modifiers changed from: protected */
    public int getCurrentSelection() {
        if (this.mCurrentProfile == null || this.mProfiles == null) {
            return -1;
        }
        int i = 0;
        for (IProfile iProfile : this.mProfiles) {
            if (iProfile == this.mCurrentProfile) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void toggleSelectionList(Context context) {
        if (this.mDrawer == null) {
            return;
        }
        if (this.mDrawer.switchedDrawerContent()) {
            resetDrawerContent(context);
            this.mSelectionListShown = false;
            return;
        }
        buildDrawerSelectionList();
        this.mAccountSwitcherArrow.clearAnimation();
        ViewCompat.animate(this.mAccountSwitcherArrow).rotation(180.0f).start();
        this.mSelectionListShown = true;
    }

    /* access modifiers changed from: protected */
    public void buildDrawerSelectionList() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if (this.mProfiles != null) {
            int i2 = 0;
            for (IProfile next : this.mProfiles) {
                if (next == this.mCurrentProfile) {
                    if (!this.mCurrentHiddenInList) {
                        i = this.mDrawer.mDrawerBuilder.getItemAdapter().getGlobalPosition(i2);
                    }
                }
                if (next instanceof IDrawerItem) {
                    IDrawerItem iDrawerItem = (IDrawerItem) next;
                    iDrawerItem.withSetSelected(false);
                    arrayList.add(iDrawerItem);
                }
                i2++;
            }
        }
        this.mDrawer.switchDrawerContent(this.onDrawerItemClickListener, this.onDrawerItemLongClickListener, arrayList, i);
    }

    /* access modifiers changed from: private */
    public void resetDrawerContent(Context context) {
        if (this.mDrawer != null) {
            this.mDrawer.resetDrawerContent();
        }
        this.mAccountSwitcherArrow.clearAnimation();
        ViewCompat.animate(this.mAccountSwitcherArrow).rotation(0.0f).start();
    }

    /* access modifiers changed from: protected */
    public void updateHeaderAndList() {
        calculateProfiles();
        buildProfiles();
        if (this.mSelectionListShown) {
            buildDrawerSelectionList();
        }
    }
}
