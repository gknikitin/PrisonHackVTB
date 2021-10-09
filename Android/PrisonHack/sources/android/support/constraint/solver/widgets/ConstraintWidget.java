package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    protected ConstraintWidget[] mListNextVisibleWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected int mOffsetX;
    protected int mOffsetY;
    ConstraintWidget mParent;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;

    /* renamed from: mX */
    protected int f5mX;

    /* renamed from: mY */
    protected int f6mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void resolve() {
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = 0.0f;
        this.mWeight[1] = 0.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        if (this.mResolutionWidth != null) {
            this.mResolutionWidth.reset();
        }
        if (this.mResolutionHeight != null) {
            this.mResolutionHeight.reset();
        }
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public boolean isFullyResolved() {
        if (this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1) {
            return true;
        }
        return false;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{0.0f, 0.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mListNextVisibleWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f5mX = 0;
        this.f6mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{0.0f, 0.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mListNextVisibleWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.f5mX = i;
        this.f6mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        return (this instanceof ConstraintWidgetContainer) && (this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer));
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f5mX);
        sb.append(", ");
        sb.append(this.f6mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawX() {
        return this.mDrawX;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.f5mX;
    }

    public int getY() {
        return this.f6mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            i = this.mMatchConstraintMinWidth;
            this.mWidth = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxWidth <= 0 || this.mMatchConstraintMaxWidth >= i) ? i : this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            i = this.mMatchConstraintMinHeight;
            this.mHeight = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxHeight <= 0 || this.mMatchConstraintMaxHeight >= i) ? i : this.mMatchConstraintMaxHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.f5mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.f6mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.f5mX = i;
    }

    public void setY(int i) {
        this.f6mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.f5mX = i;
        this.f6mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        switch (type) {
            case LEFT:
                this.mLeft.mGoneMargin = i;
                return;
            case TOP:
                this.mTop.mGoneMargin = i;
                return;
            case RIGHT:
                this.mRight.mGoneMargin = i;
                return;
            case BOTTOM:
                this.mBottom.mGoneMargin = i;
                return;
            default:
                return;
        }
    }

    public void updateDrawPosition() {
        int i = this.f5mX;
        int i2 = this.f6mY;
        int i3 = this.f5mX + this.mWidth;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = (this.f6mY + this.mHeight) - i2;
    }

    public void forceUpdateDrawPosition() {
        int i = this.f5mX;
        int i2 = this.f6mY;
        int i3 = this.f5mX + this.mWidth;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = (this.f6mY + this.mHeight) - i2;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.mOffsetX;
        this.mDrawY = i2 - this.mOffsetY;
        this.f5mX = this.mDrawX;
        this.f6mY = this.mDrawY;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.mOffsetX;
        this.f5mX = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.mOffsetY;
        this.f6mY = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r1
        L_0x008d:
            return
        L_0x008e:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = i2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f5mX = i;
        this.f6mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i5 < this.mWidth) {
            i5 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i6 < this.mHeight) {
            i6 = this.mHeight;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f5mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.f6mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        boolean z;
        ConstraintAnchor.Type type3 = type;
        ConstraintWidget constraintWidget2 = constraintWidget;
        ConstraintAnchor.Type type4 = type2;
        int i3 = i2;
        int i4 = 0;
        if (type3 == ConstraintAnchor.Type.CENTER) {
            if (type4 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    ConstraintWidget constraintWidget3 = constraintWidget2;
                    ConstraintAnchor.Strength strength2 = strength;
                    int i5 = i3;
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget3, ConstraintAnchor.Type.LEFT, 0, strength2, i5);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget3, ConstraintAnchor.Type.RIGHT, 0, strength2, i5);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    ConstraintWidget constraintWidget4 = constraintWidget2;
                    ConstraintAnchor.Strength strength3 = strength;
                    int i6 = i3;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.TOP, 0, strength3, i6);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget4, ConstraintAnchor.Type.BOTTOM, 0, strength3, i6);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER), 0, i3);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i3);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i3);
                }
            } else if (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT) {
                ConstraintWidget constraintWidget5 = constraintWidget2;
                ConstraintAnchor.Type type5 = type4;
                ConstraintAnchor.Strength strength4 = strength;
                int i7 = i3;
                connect(ConstraintAnchor.Type.LEFT, constraintWidget5, type5, 0, strength4, i7);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget5, type5, 0, strength4, i7);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
            } else if (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM) {
                ConstraintWidget constraintWidget6 = constraintWidget2;
                ConstraintAnchor.Type type6 = type4;
                ConstraintAnchor.Strength strength5 = strength;
                int i8 = i3;
                connect(ConstraintAnchor.Type.TOP, constraintWidget6, type6, 0, strength5, i8);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget6, type6, 0, strength5, i8);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
            }
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i3);
            anchor7.connect(anchor6, 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i3);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && type4 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), 0, i3);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && type4 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP), 0, i3);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i3);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i3);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type3 == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else {
                    if (type3 == ConstraintAnchor.Type.TOP || type3 == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor13 != null) {
                            anchor13.reset();
                        }
                        ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor14.getTarget() != anchor10) {
                            anchor14.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (anchor15.isConnected()) {
                            opposite.reset();
                            anchor15.reset();
                        }
                    } else if (type3 == ConstraintAnchor.Type.LEFT || type3 == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor10) {
                            anchor16.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                        if (anchor17.isConnected()) {
                            opposite2.reset();
                            anchor17.reset();
                        }
                    }
                    i4 = i;
                }
                anchor9.connect(anchor10, i4, strength, i3);
                anchor10.getOwner().connectedTo(anchor9.getOwner());
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01da, code lost:
        if (r15.mResolvedDimensionRatioSide == -1) goto L_0x01de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0287 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x036f  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(android.support.constraint.solver.LinearSystem r41) {
        /*
            r40 = this;
            r15 = r40
            r14 = r41
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.SolverVariable r21 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mRight
            android.support.constraint.solver.SolverVariable r13 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mTop
            android.support.constraint.solver.SolverVariable r12 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBottom
            android.support.constraint.solver.SolverVariable r11 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.SolverVariable r10 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            r1 = 8
            r9 = 1
            r8 = 0
            if (r0 == 0) goto L_0x00e5
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x003a
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.mParent
            if (r2 == 0) goto L_0x004b
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x004b
            r2 = 1
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x005c
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mLeft
            if (r3 == r4) goto L_0x006c
        L_0x005c:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0075
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r15.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mRight
            if (r3 != r4) goto L_0x0075
        L_0x006c:
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r3
            r3.addChain(r15, r8)
            r3 = 1
            goto L_0x0076
        L_0x0075:
            r3 = 0
        L_0x0076:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0086
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mTop
            if (r4 == r5) goto L_0x0096
        L_0x0086:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x009f
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r15.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mBottom
            if (r4 != r5) goto L_0x009f
        L_0x0096:
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r4
            r4.addChain(r15, r9)
            r4 = 1
            goto L_0x00a0
        L_0x009f:
            r4 = 0
        L_0x00a0:
            if (r0 == 0) goto L_0x00bd
            int r5 = r15.mVisibility
            if (r5 == r1) goto L_0x00bd
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00bd
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00bd
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mRight
            android.support.constraint.solver.SolverVariable r5 = r14.createObjectVariable(r5)
            r14.addGreaterThan(r5, r13, r8, r9)
        L_0x00bd:
            if (r2 == 0) goto L_0x00de
            int r5 = r15.mVisibility
            if (r5 == r1) goto L_0x00de
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00de
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00de
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mBaseline
            if (r5 != 0) goto L_0x00de
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mBottom
            android.support.constraint.solver.SolverVariable r5 = r14.createObjectVariable(r5)
            r14.addGreaterThan(r5, r11, r8, r9)
        L_0x00de:
            r7 = r2
            r16 = r3
            r22 = r4
            r2 = r0
            goto L_0x00eb
        L_0x00e5:
            r2 = 0
            r7 = 0
            r16 = 0
            r22 = 0
        L_0x00eb:
            int r0 = r15.mWidth
            int r3 = r15.mMinWidth
            if (r0 >= r3) goto L_0x00f3
            int r0 = r15.mMinWidth
        L_0x00f3:
            int r3 = r15.mHeight
            int r4 = r15.mMinHeight
            if (r3 >= r4) goto L_0x00fb
            int r3 = r15.mMinHeight
        L_0x00fb:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r15.mListDimensionBehaviors
            r4 = r4[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 == r5) goto L_0x0105
            r4 = 1
            goto L_0x0106
        L_0x0105:
            r4 = 0
        L_0x0106:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r5 = r5[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 == r6) goto L_0x0110
            r5 = 1
            goto L_0x0111
        L_0x0110:
            r5 = 0
        L_0x0111:
            int r6 = r15.mDimensionRatioSide
            r15.mResolvedDimensionRatioSide = r6
            float r6 = r15.mDimensionRatio
            r15.mResolvedDimensionRatio = r6
            int r6 = r15.mMatchConstraintDefaultWidth
            int r9 = r15.mMatchConstraintDefaultHeight
            float r8 = r15.mDimensionRatio
            r17 = 0
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            r17 = 4
            if (r8 <= 0) goto L_0x01c7
            int r8 = r15.mVisibility
            r1 = 8
            if (r8 == r1) goto L_0x01c7
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 0
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r27 = r0
            r0 = 3
            if (r1 != r8) goto L_0x013c
            if (r6 != 0) goto L_0x013c
            r6 = 3
        L_0x013c:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 1
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x0148
            if (r9 != 0) goto L_0x0148
            r9 = 3
        L_0x0148:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 0
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x0162
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 1
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x0162
            if (r6 != r0) goto L_0x0162
            if (r9 != r0) goto L_0x0162
            r15.setupDimensionRatio(r2, r7, r4, r5)
            goto L_0x01be
        L_0x0162:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r4 = 0
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x0188
            if (r6 != r0) goto L_0x0188
            r15.mResolvedDimensionRatioSide = r4
            float r0 = r15.mResolvedDimensionRatio
            int r1 = r15.mHeight
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r4 = 1
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r5) goto L_0x0185
            r27 = r0
            r28 = r3
            goto L_0x01cd
        L_0x0185:
            r27 = r0
            goto L_0x01be
        L_0x0188:
            r4 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x01be
            if (r9 != r0) goto L_0x01be
            r15.mResolvedDimensionRatioSide = r4
            int r0 = r15.mDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x01a1
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r15.mResolvedDimensionRatio
            float r0 = r0 / r1
            r15.mResolvedDimensionRatio = r0
        L_0x01a1:
            float r0 = r15.mResolvedDimensionRatio
            int r1 = r15.mWidth
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r3 = 0
            r1 = r1[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r3) goto L_0x01bb
            r28 = r0
            r17 = r6
            r25 = 0
            r29 = 4
            goto L_0x01d1
        L_0x01bb:
            r28 = r0
            goto L_0x01c0
        L_0x01be:
            r28 = r3
        L_0x01c0:
            r17 = r6
            r29 = r9
            r25 = 1
            goto L_0x01d1
        L_0x01c7:
            r27 = r0
            r28 = r3
            r17 = r6
        L_0x01cd:
            r29 = r9
            r25 = 0
        L_0x01d1:
            if (r25 == 0) goto L_0x01e1
            int r0 = r15.mResolvedDimensionRatioSide
            if (r0 == 0) goto L_0x01dd
            int r0 = r15.mResolvedDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x01e2
            goto L_0x01de
        L_0x01dd:
            r1 = -1
        L_0x01de:
            r18 = 1
            goto L_0x01e4
        L_0x01e1:
            r1 = -1
        L_0x01e2:
            r18 = 0
        L_0x01e4:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r3 = 0
            r0 = r0[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x01f3
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x01f3
            r6 = 1
            goto L_0x01f4
        L_0x01f3:
            r6 = 0
        L_0x01f4:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mCenter
            boolean r0 = r0.isConnected()
            r9 = 1
            r23 = r0 ^ 1
            int r0 = r15.mHorizontalResolution
            r8 = 2
            r26 = 0
            if (r0 == r8) goto L_0x0278
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0212
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mRight
            android.support.constraint.solver.SolverVariable r0 = r14.createObjectVariable(r0)
            r4 = r0
            goto L_0x0214
        L_0x0212:
            r4 = r26
        L_0x0214:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0222
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mLeft
            android.support.constraint.solver.SolverVariable r0 = r14.createObjectVariable(r0)
            r3 = r0
            goto L_0x0224
        L_0x0222:
            r3 = r26
        L_0x0224:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r19 = 0
            r5 = r0[r19]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.mRight
            int r9 = r15.f5mX
            r31 = r11
            int r11 = r15.mMinWidth
            int[] r1 = r15.mMaxDimension
            r20 = r1[r19]
            float r1 = r15.mHorizontalBiasPercent
            r33 = r13
            int r13 = r15.mMatchConstraintMinWidth
            r34 = r13
            int r13 = r15.mMatchConstraintMaxWidth
            r35 = r13
            float r13 = r15.mMatchConstraintPercentWidth
            r24 = r0
            r0 = r15
            r32 = r1
            r1 = r14
            r36 = r7
            r7 = r24
            r37 = r10
            r10 = r27
            r24 = r31
            r38 = r12
            r12 = r20
            r30 = r13
            r27 = r33
            r19 = r34
            r20 = r35
            r13 = r32
            r14 = r18
            r15 = r16
            r16 = r17
            r17 = r19
            r18 = r20
            r19 = r30
            r20 = r23
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r15 = r40
            goto L_0x0282
        L_0x0278:
            r36 = r7
            r37 = r10
            r24 = r11
            r38 = r12
            r27 = r13
        L_0x0282:
            int r0 = r15.mVerticalResolution
            r1 = 2
            if (r0 != r1) goto L_0x0288
            return
        L_0x0288:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r14 = 1
            r0 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0297
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0297
            r6 = 1
            goto L_0x0298
        L_0x0297:
            r6 = 0
        L_0x0298:
            if (r25 == 0) goto L_0x02a6
            int r0 = r15.mResolvedDimensionRatioSide
            if (r0 == r14) goto L_0x02a3
            int r0 = r15.mResolvedDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x02a6
        L_0x02a3:
            r16 = 1
            goto L_0x02a8
        L_0x02a6:
            r16 = 0
        L_0x02a8:
            int r0 = r15.mBaselineDistance
            if (r0 <= 0) goto L_0x02e7
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            int r0 = r0.state
            if (r0 != r14) goto L_0x02c4
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r13 = r41
            r0.addResolvedValue(r13)
            r12 = r38
            goto L_0x02eb
        L_0x02c4:
            r13 = r41
            int r0 = r40.getBaselineDistance()
            r1 = 6
            r2 = r37
            r12 = r38
            r13.addEquality(r2, r12, r0, r1)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x02eb
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r3 = 0
            r13.addEquality(r2, r0, r3, r1)
            r20 = 0
            goto L_0x02ed
        L_0x02e7:
            r12 = r38
            r13 = r41
        L_0x02eb:
            r20 = r23
        L_0x02ed:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x02fb
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r4 = r0
            goto L_0x02fd
        L_0x02fb:
            r4 = r26
        L_0x02fd:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x030b
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTop
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r3 = r0
            goto L_0x030d
        L_0x030b:
            r3 = r26
        L_0x030d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r5 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.mBottom
            int r9 = r15.f6mY
            int r11 = r15.mMinHeight
            int[] r0 = r15.mMaxDimension
            r17 = r0[r14]
            float r10 = r15.mVerticalBiasPercent
            int r2 = r15.mMatchConstraintMinHeight
            int r1 = r15.mMatchConstraintMaxHeight
            float r0 = r15.mMatchConstraintPercentHeight
            r19 = r0
            r0 = r15
            r18 = r1
            r1 = r13
            r23 = r2
            r2 = r36
            r26 = r10
            r10 = r28
            r28 = r12
            r12 = r17
            r13 = r26
            r14 = r16
            r15 = r22
            r16 = r29
            r17 = r23
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r25 == 0) goto L_0x036f
            r6 = 6
            r7 = r40
            int r0 = r7.mResolvedDimensionRatioSide
            r1 = 1
            if (r0 != r1) goto L_0x035f
            float r5 = r7.mResolvedDimensionRatio
            r6 = 6
            r0 = r41
            r1 = r24
            r2 = r28
            r3 = r27
            r4 = r21
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0371
        L_0x035f:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r41
            r1 = r27
            r2 = r21
            r3 = r24
            r4 = r28
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0371
        L_0x036f:
            r7 = r40
        L_0x0371:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0399
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r3 = r41
            r3.addCenterPoint(r7, r0, r1, r2)
        L_0x0399:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.addToSolver(android.support.constraint.solver.LinearSystem):void");
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(android.support.constraint.solver.LinearSystem r33, boolean r34, android.support.constraint.solver.SolverVariable r35, android.support.constraint.solver.SolverVariable r36, android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour r37, boolean r38, android.support.constraint.solver.widgets.ConstraintAnchor r39, android.support.constraint.solver.widgets.ConstraintAnchor r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, int r48, int r49, int r50, float r51, boolean r52) {
        /*
            r32 = this;
            r0 = r32
            r10 = r33
            r11 = r35
            r12 = r36
            r1 = r43
            r2 = r44
            r13 = r39
            android.support.constraint.solver.SolverVariable r9 = r10.createObjectVariable(r13)
            r8 = r40
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r39.getTarget()
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r40.getTarget()
            android.support.constraint.solver.SolverVariable r14 = r10.createObjectVariable(r14)
            r20 = r14
            boolean r14 = r10.graphOptimizer
            r15 = 1
            if (r14 == 0) goto L_0x0069
            android.support.constraint.solver.widgets.ResolutionAnchor r14 = r39.getResolutionNode()
            int r14 = r14.state
            r11 = 1
            if (r14 != r11) goto L_0x0069
            android.support.constraint.solver.widgets.ResolutionAnchor r14 = r40.getResolutionNode()
            int r14 = r14.state
            if (r14 != r11) goto L_0x0069
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r1 == 0) goto L_0x0051
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r2 = r1.resolvedWidgets
            long r5 = r2 + r15
            r1.resolvedWidgets = r5
        L_0x0051:
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r39.getResolutionNode()
            r1.addResolvedValue(r10)
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r40.getResolutionNode()
            r1.addResolvedValue(r10)
            if (r47 != 0) goto L_0x0068
            if (r34 == 0) goto L_0x0068
            r1 = 0
            r2 = 6
            r10.addGreaterThan(r12, r7, r1, r2)
        L_0x0068:
            return
        L_0x0069:
            android.support.constraint.solver.Metrics r11 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r11 == 0) goto L_0x007e
            android.support.constraint.solver.Metrics r11 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r1 = r11.nonresolvedWidgets
            r22 = r6
            r21 = r7
            long r6 = r1 + r15
            r11.nonresolvedWidgets = r6
            goto L_0x0082
        L_0x007e:
            r22 = r6
            r21 = r7
        L_0x0082:
            boolean r1 = r39.isConnected()
            boolean r2 = r40.isConnected()
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r0.mCenter
            boolean r6 = r6.isConnected()
            if (r1 == 0) goto L_0x0094
            r7 = 1
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            if (r2 == 0) goto L_0x0099
            int r7 = r7 + 1
        L_0x0099:
            if (r6 == 0) goto L_0x009d
            int r7 = r7 + 1
        L_0x009d:
            if (r46 == 0) goto L_0x00a1
            r14 = 3
            goto L_0x00a3
        L_0x00a1:
            r14 = r48
        L_0x00a3:
            int[] r15 = android.support.constraint.solver.widgets.ConstraintWidget.C00201.f8x27577131
            int r16 = r37.ordinal()
            r15 = r15[r16]
            r11 = 4
            switch(r15) {
                case 1: goto L_0x00af;
                case 2: goto L_0x00af;
                case 3: goto L_0x00af;
                case 4: goto L_0x00b1;
                default: goto L_0x00af;
            }
        L_0x00af:
            r15 = 0
            goto L_0x00b5
        L_0x00b1:
            if (r14 != r11) goto L_0x00b4
            goto L_0x00af
        L_0x00b4:
            r15 = 1
        L_0x00b5:
            int r11 = r0.mVisibility
            r8 = 8
            if (r11 != r8) goto L_0x00be
            r8 = 0
            r11 = 0
            goto L_0x00c1
        L_0x00be:
            r8 = r42
            r11 = r15
        L_0x00c1:
            if (r52 == 0) goto L_0x00e2
            if (r1 != 0) goto L_0x00cf
            if (r2 != 0) goto L_0x00cf
            if (r6 != 0) goto L_0x00cf
            r12 = r41
            r10.addEquality(r9, r12)
            goto L_0x00e2
        L_0x00cf:
            if (r1 == 0) goto L_0x00e2
            if (r2 != 0) goto L_0x00e2
            int r12 = r39.getMargin()
            r24 = r2
            r23 = r6
            r6 = r22
            r2 = 6
            r10.addEquality(r9, r6, r12, r2)
            goto L_0x00e9
        L_0x00e2:
            r24 = r2
            r23 = r6
            r6 = r22
            r2 = 6
        L_0x00e9:
            if (r11 != 0) goto L_0x0122
            if (r38 == 0) goto L_0x010d
            r25 = r11
            r12 = r21
            r2 = 0
            r11 = 3
            r10.addEquality(r12, r9, r2, r11)
            r2 = r43
            if (r2 <= 0) goto L_0x00ff
            r11 = 6
            r10.addGreaterThan(r12, r9, r2, r11)
            goto L_0x0100
        L_0x00ff:
            r11 = 6
        L_0x0100:
            r8 = 2147483647(0x7fffffff, float:NaN)
            r26 = r6
            r6 = r44
            if (r6 >= r8) goto L_0x0119
            r10.addLowerThan(r12, r9, r6, r11)
            goto L_0x0119
        L_0x010d:
            r26 = r6
            r25 = r11
            r12 = r21
            r2 = r43
            r11 = 6
            r10.addEquality(r12, r9, r8, r11)
        L_0x0119:
            r2 = r49
            r11 = r50
            r0 = r14
            r6 = r20
            goto L_0x01fa
        L_0x0122:
            r26 = r6
            r25 = r11
            r12 = r21
            r2 = r43
            r6 = -2
            r11 = r49
            if (r11 != r6) goto L_0x0133
            r11 = r50
            r2 = r8
            goto L_0x0136
        L_0x0133:
            r2 = r11
            r11 = r50
        L_0x0136:
            if (r11 != r6) goto L_0x0139
            r11 = r8
        L_0x0139:
            if (r2 <= 0) goto L_0x014b
            if (r34 == 0) goto L_0x0142
            r6 = 6
            r10.addGreaterThan(r12, r9, r2, r6)
            goto L_0x0146
        L_0x0142:
            r6 = 6
            r10.addGreaterThan(r12, r9, r2, r6)
        L_0x0146:
            int r8 = java.lang.Math.max(r8, r2)
            goto L_0x014c
        L_0x014b:
            r6 = 6
        L_0x014c:
            if (r11 <= 0) goto L_0x015d
            if (r34 == 0) goto L_0x0156
            r6 = 1
            r10.addLowerThan(r12, r9, r11, r6)
            r6 = 6
            goto L_0x0159
        L_0x0156:
            r10.addLowerThan(r12, r9, r11, r6)
        L_0x0159:
            int r8 = java.lang.Math.min(r8, r11)
        L_0x015d:
            r6 = 1
            if (r14 != r6) goto L_0x0176
            if (r34 == 0) goto L_0x0168
            r6 = 6
            r10.addEquality(r12, r9, r8, r6)
            goto L_0x01e0
        L_0x0168:
            if (r47 == 0) goto L_0x0170
            r6 = 4
            r10.addEquality(r12, r9, r8, r6)
            goto L_0x01e0
        L_0x0170:
            r6 = 1
            r10.addEquality(r12, r9, r8, r6)
            goto L_0x01e0
        L_0x0176:
            r6 = 2
            if (r14 != r6) goto L_0x01e0
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = r39.getType()
            r27 = r14
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r6 == r14) goto L_0x01ab
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = r39.getType()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r6 != r14) goto L_0x018c
            goto L_0x01ab
        L_0x018c:
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r14)
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            android.support.constraint.solver.widgets.ConstraintWidget r14 = r0.mParent
            r28 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r14.getAnchor(r6)
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            r17 = r6
            r18 = r28
            goto L_0x01c9
        L_0x01ab:
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r14)
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            android.support.constraint.solver.widgets.ConstraintWidget r14 = r0.mParent
            r29 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r6 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r14.getAnchor(r6)
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            r17 = r6
            r18 = r29
        L_0x01c9:
            android.support.constraint.solver.ArrayRow r14 = r33.createRow()
            r6 = r20
            r0 = r27
            r15 = r12
            r16 = r9
            r19 = r51
            android.support.constraint.solver.ArrayRow r14 = r14.createRowDimensionRatio(r15, r16, r17, r18, r19)
            r10.addConstraint(r14)
            r25 = 0
            goto L_0x01e3
        L_0x01e0:
            r0 = r14
            r6 = r20
        L_0x01e3:
            if (r25 == 0) goto L_0x01fa
            r14 = 2
            if (r7 == r14) goto L_0x01fa
            if (r46 != 0) goto L_0x01fa
            int r8 = java.lang.Math.max(r2, r8)
            if (r11 <= 0) goto L_0x01f4
            int r8 = java.lang.Math.min(r11, r8)
        L_0x01f4:
            r14 = 6
            r10.addEquality(r12, r9, r8, r14)
            r25 = 0
        L_0x01fa:
            if (r52 == 0) goto L_0x0303
            if (r47 == 0) goto L_0x0200
            goto L_0x0303
        L_0x0200:
            r4 = 5
            if (r1 != 0) goto L_0x0213
            if (r24 != 0) goto L_0x0213
            if (r23 != 0) goto L_0x0213
            if (r34 == 0) goto L_0x020f
            r5 = 0
            r14 = r36
            r10.addGreaterThan(r14, r12, r5, r4)
        L_0x020f:
            r2 = 6
        L_0x0210:
            r3 = 0
            goto L_0x02fb
        L_0x0213:
            r5 = 0
            r14 = r36
            if (r1 == 0) goto L_0x0220
            if (r24 != 0) goto L_0x0220
            if (r34 == 0) goto L_0x020f
            r10.addGreaterThan(r14, r12, r5, r4)
            goto L_0x020f
        L_0x0220:
            if (r1 != 0) goto L_0x0235
            if (r24 == 0) goto L_0x0235
            int r0 = r40.getMargin()
            int r0 = -r0
            r1 = 6
            r10.addEquality(r12, r6, r0, r1)
            if (r34 == 0) goto L_0x020f
            r8 = r35
            r10.addGreaterThan(r9, r8, r5, r4)
            goto L_0x020f
        L_0x0235:
            r7 = 1
            r8 = r35
            if (r1 == 0) goto L_0x020f
            if (r24 == 0) goto L_0x020f
            if (r25 == 0) goto L_0x02a4
            if (r34 == 0) goto L_0x0248
            r1 = r43
            if (r1 != 0) goto L_0x0248
            r1 = 6
            r10.addGreaterThan(r12, r9, r5, r1)
        L_0x0248:
            if (r0 != 0) goto L_0x0273
            if (r11 > 0) goto L_0x0252
            if (r2 <= 0) goto L_0x024f
            goto L_0x0252
        L_0x024f:
            r0 = 6
            r1 = 0
            goto L_0x0254
        L_0x0252:
            r0 = 4
            r1 = 1
        L_0x0254:
            int r3 = r39.getMargin()
            r5 = r26
            r10.addEquality(r9, r5, r3, r0)
            int r3 = r40.getMargin()
            int r3 = -r3
            r10.addEquality(r12, r6, r3, r0)
            if (r11 > 0) goto L_0x026c
            if (r2 <= 0) goto L_0x026a
            goto L_0x026c
        L_0x026a:
            r11 = 0
            goto L_0x026d
        L_0x026c:
            r11 = 1
        L_0x026d:
            r15 = r1
            r7 = r11
            r0 = r32
            r11 = 5
            goto L_0x02bb
        L_0x0273:
            r5 = r26
            if (r0 != r7) goto L_0x027c
            r0 = r32
            r11 = 6
        L_0x027a:
            r15 = 1
            goto L_0x02bb
        L_0x027c:
            r1 = 3
            if (r0 != r1) goto L_0x02a0
            if (r46 != 0) goto L_0x028c
            r0 = r32
            int r1 = r0.mResolvedDimensionRatioSide
            r2 = -1
            if (r1 == r2) goto L_0x028e
            if (r11 > 0) goto L_0x028e
            r1 = 6
            goto L_0x028f
        L_0x028c:
            r0 = r32
        L_0x028e:
            r1 = 4
        L_0x028f:
            int r2 = r39.getMargin()
            r10.addEquality(r9, r5, r2, r1)
            int r2 = r40.getMargin()
            int r2 = -r2
            r10.addEquality(r12, r6, r2, r1)
            r11 = 5
            goto L_0x027a
        L_0x02a0:
            r0 = r32
            r7 = 0
            goto L_0x02b9
        L_0x02a4:
            r5 = r26
            r0 = r32
            if (r34 == 0) goto L_0x02b9
            int r1 = r39.getMargin()
            r10.addGreaterThan(r9, r5, r1, r4)
            int r1 = r40.getMargin()
            int r1 = -r1
            r10.addLowerThan(r12, r6, r1, r4)
        L_0x02b9:
            r11 = 5
            r15 = 0
        L_0x02bb:
            if (r7 == 0) goto L_0x02d8
            int r4 = r39.getMargin()
            int r16 = r40.getMargin()
            r1 = r10
            r2 = r9
            r3 = r5
            r7 = r5
            r5 = r45
            r30 = r6
            r0 = r7
            r7 = r12
            r14 = r8
            r8 = r16
            r14 = r9
            r9 = r11
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x02dc
        L_0x02d8:
            r0 = r5
            r30 = r6
            r14 = r9
        L_0x02dc:
            if (r15 == 0) goto L_0x02f1
            int r1 = r39.getMargin()
            r2 = 6
            r10.addGreaterThan(r14, r0, r1, r2)
            int r0 = r40.getMargin()
            int r0 = -r0
            r1 = r30
            r10.addLowerThan(r12, r1, r0, r2)
            goto L_0x02f2
        L_0x02f1:
            r2 = 6
        L_0x02f2:
            if (r34 == 0) goto L_0x0210
            r1 = r14
            r0 = r35
            r3 = 0
            r10.addGreaterThan(r1, r0, r3, r2)
        L_0x02fb:
            if (r34 == 0) goto L_0x0302
            r0 = r36
            r10.addGreaterThan(r0, r12, r3, r2)
        L_0x0302:
            return
        L_0x0303:
            r1 = r9
            r0 = r36
            r2 = 6
            r3 = 0
            r4 = r35
            r5 = 2
            if (r7 >= r5) goto L_0x0315
            if (r34 == 0) goto L_0x0315
            r10.addGreaterThan(r1, r4, r3, r2)
            r10.addGreaterThan(r0, r12, r3, r2)
        L_0x0315:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.applyConstraints(android.support.constraint.solver.LinearSystem, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        setFrame(linearSystem.getObjectVariableValue(this.mLeft), linearSystem.getObjectVariableValue(this.mTop), linearSystem.getObjectVariableValue(this.mRight), linearSystem.getObjectVariableValue(this.mBottom));
    }
}
