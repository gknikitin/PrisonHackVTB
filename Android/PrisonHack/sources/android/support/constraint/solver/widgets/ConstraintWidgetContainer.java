package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    private boolean mHeightMeasuredTooSmall = false;
    ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
    int mHorizontalChainsSize = 0;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 3;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
    int mVerticalChainsSize = 0;
    private boolean mWidthMeasuredTooSmall = false;

    public String getType() {
        return "ConstraintLayout";
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int i) {
        if ((this.mOptimizationLevel & i) == i) {
            return USE_SNAPSHOT;
        }
        return false;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return USE_SNAPSHOT;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = USE_SNAPSHOT;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = USE_SNAPSHOT;
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.mChildren.get(i2)).analyze(i);
        }
    }

    /* JADX WARNING: type inference failed for: r12v8, types: [boolean] */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r18 = this;
            r1 = r18
            int r2 = r1.f5mX
            int r3 = r1.f6mY
            int r4 = r18.getWidth()
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            int r6 = r18.getHeight()
            int r6 = java.lang.Math.max(r5, r6)
            r1.mWidthMeasuredTooSmall = r5
            r1.mHeightMeasuredTooSmall = r5
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r1.mParent
            if (r7 == 0) goto L_0x0046
            android.support.constraint.solver.widgets.Snapshot r7 = r1.mSnapshot
            if (r7 != 0) goto L_0x002a
            android.support.constraint.solver.widgets.Snapshot r7 = new android.support.constraint.solver.widgets.Snapshot
            r7.<init>(r1)
            r1.mSnapshot = r7
        L_0x002a:
            android.support.constraint.solver.widgets.Snapshot r7 = r1.mSnapshot
            r7.updateFrom(r1)
            int r7 = r1.mPaddingLeft
            r1.setX(r7)
            int r7 = r1.mPaddingTop
            r1.setY(r7)
            r18.resetAnchors()
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            android.support.constraint.solver.Cache r7 = r7.getCache()
            r1.resetSolverVariables(r7)
            goto L_0x004a
        L_0x0046:
            r1.f5mX = r5
            r1.f6mY = r5
        L_0x004a:
            int r7 = r1.mOptimizationLevel
            r8 = 8
            r9 = 1
            if (r7 == 0) goto L_0x0062
            boolean r7 = r1.optimizeFor(r8)
            if (r7 != 0) goto L_0x005a
            r18.optimizeReset()
        L_0x005a:
            r18.optimize()
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            r7.graphOptimizer = r9
            goto L_0x0066
        L_0x0062:
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            r7.graphOptimizer = r5
        L_0x0066:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r7 = r7[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r1.mListDimensionBehaviors
            r10 = r10[r5]
            r18.resetChains()
            java.util.ArrayList r11 = r1.mChildren
            int r11 = r11.size()
            r12 = 0
        L_0x0078:
            if (r12 >= r11) goto L_0x008e
            java.util.ArrayList r13 = r1.mChildren
            java.lang.Object r13 = r13.get(r12)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = (android.support.constraint.solver.widgets.ConstraintWidget) r13
            boolean r14 = r13 instanceof android.support.constraint.solver.widgets.WidgetContainer
            if (r14 == 0) goto L_0x008b
            android.support.constraint.solver.widgets.WidgetContainer r13 = (android.support.constraint.solver.widgets.WidgetContainer) r13
            r13.layout()
        L_0x008b:
            int r12 = r12 + 1
            goto L_0x0078
        L_0x008e:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0091:
            if (r12 == 0) goto L_0x020c
            int r13 = r13 + r9
            android.support.constraint.solver.LinearSystem r15 = r1.mSystem     // Catch:{ Exception -> 0x00a9 }
            r15.reset()     // Catch:{ Exception -> 0x00a9 }
            android.support.constraint.solver.LinearSystem r15 = r1.mSystem     // Catch:{ Exception -> 0x00a9 }
            boolean r15 = r1.addChildrenToSolver(r15)     // Catch:{ Exception -> 0x00a9 }
            if (r15 == 0) goto L_0x00c5
            android.support.constraint.solver.LinearSystem r12 = r1.mSystem     // Catch:{ Exception -> 0x00a7 }
            r12.minimize()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00c5
        L_0x00a7:
            r0 = move-exception
            goto L_0x00ab
        L_0x00a9:
            r0 = move-exception
            r15 = r12
        L_0x00ab:
            r12 = r0
            r12.printStackTrace()
            java.io.PrintStream r8 = java.lang.System.out
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "EXCEPTION : "
            r9.append(r5)
            r9.append(r12)
            java.lang.String r5 = r9.toString()
            r8.println(r5)
        L_0x00c5:
            r5 = 2
            if (r15 == 0) goto L_0x00d3
            android.support.constraint.solver.LinearSystem r8 = r1.mSystem
            boolean[] r9 = android.support.constraint.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r8, r9)
        L_0x00cf:
            r5 = 8
            r9 = 2
            goto L_0x011d
        L_0x00d3:
            android.support.constraint.solver.LinearSystem r8 = r1.mSystem
            r1.updateFromSolver(r8)
            r8 = 0
        L_0x00d9:
            if (r8 >= r11) goto L_0x011a
            java.util.ArrayList r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r8)
            android.support.constraint.solver.widgets.ConstraintWidget r9 = (android.support.constraint.solver.widgets.ConstraintWidget) r9
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r9.mListDimensionBehaviors
            r15 = 0
            r12 = r12[r15]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r15) goto L_0x00fc
            int r12 = r9.getWidth()
            int r15 = r9.getWrapWidth()
            if (r12 >= r15) goto L_0x00fc
            boolean[] r8 = android.support.constraint.solver.widgets.Optimizer.flags
            r12 = 1
            r8[r5] = r12
            goto L_0x00cf
        L_0x00fc:
            r12 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r15 = r9.mListDimensionBehaviors
            r15 = r15[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r5) goto L_0x0115
            int r5 = r9.getHeight()
            int r9 = r9.getWrapHeight()
            if (r5 >= r9) goto L_0x0115
            boolean[] r5 = android.support.constraint.solver.widgets.Optimizer.flags
            r9 = 2
            r5[r9] = r12
            goto L_0x011b
        L_0x0115:
            r9 = 2
            int r8 = r8 + 1
            r5 = 2
            goto L_0x00d9
        L_0x011a:
            r9 = 2
        L_0x011b:
            r5 = 8
        L_0x011d:
            if (r13 >= r5) goto L_0x018a
            boolean[] r8 = android.support.constraint.solver.widgets.Optimizer.flags
            boolean r8 = r8[r9]
            if (r8 == 0) goto L_0x018a
            r8 = 0
            r9 = 0
            r12 = 0
        L_0x0128:
            if (r8 >= r11) goto L_0x014e
            java.util.ArrayList r15 = r1.mChildren
            java.lang.Object r15 = r15.get(r8)
            android.support.constraint.solver.widgets.ConstraintWidget r15 = (android.support.constraint.solver.widgets.ConstraintWidget) r15
            int r5 = r15.f5mX
            int r16 = r15.getWidth()
            int r5 = r5 + r16
            int r9 = java.lang.Math.max(r9, r5)
            int r5 = r15.f6mY
            int r15 = r15.getHeight()
            int r5 = r5 + r15
            int r12 = java.lang.Math.max(r12, r5)
            int r8 = r8 + 1
            r5 = 8
            goto L_0x0128
        L_0x014e:
            int r5 = r1.mMinWidth
            int r5 = java.lang.Math.max(r5, r9)
            int r8 = r1.mMinHeight
            int r8 = java.lang.Math.max(r8, r12)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r9) goto L_0x0171
            int r9 = r18.getWidth()
            if (r9 >= r5) goto L_0x0171
            r1.setWidth(r5)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r12 = 0
            r5[r12] = r9
            r5 = 1
            r9 = 1
            goto L_0x0173
        L_0x0171:
            r9 = r14
            r5 = 0
        L_0x0173:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r12) goto L_0x018c
            int r12 = r18.getHeight()
            if (r12 >= r8) goto L_0x018c
            r1.setHeight(r8)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r9 = 1
            r5[r9] = r8
            r5 = 1
            r9 = 1
            goto L_0x018c
        L_0x018a:
            r9 = r14
            r5 = 0
        L_0x018c:
            int r8 = r1.mMinWidth
            int r12 = r18.getWidth()
            int r8 = java.lang.Math.max(r8, r12)
            int r12 = r18.getWidth()
            if (r8 <= r12) goto L_0x01a8
            r1.setWidth(r8)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = 0
            r5[r9] = r8
            r5 = 1
            r9 = 1
        L_0x01a8:
            int r8 = r1.mMinHeight
            int r12 = r18.getHeight()
            int r8 = java.lang.Math.max(r8, r12)
            int r12 = r18.getHeight()
            if (r8 <= r12) goto L_0x01c5
            r1.setHeight(r8)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12 = 1
            r5[r12] = r8
            r5 = 1
            r9 = 1
            goto L_0x01c6
        L_0x01c5:
            r12 = 1
        L_0x01c6:
            if (r9 != 0) goto L_0x0204
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r1.mListDimensionBehaviors
            r14 = 0
            r8 = r8[r14]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r15) goto L_0x01e6
            if (r4 <= 0) goto L_0x01e6
            int r8 = r18.getWidth()
            if (r8 <= r4) goto L_0x01e6
            r1.mWidthMeasuredTooSmall = r12
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r5[r14] = r8
            r1.setWidth(r4)
            r5 = 1
            r9 = 1
        L_0x01e6:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r1.mListDimensionBehaviors
            r8 = r8[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r14) goto L_0x0204
            if (r6 <= 0) goto L_0x0204
            int r8 = r18.getHeight()
            if (r8 <= r6) goto L_0x0204
            r1.mHeightMeasuredTooSmall = r12
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r5[r12] = r8
            r1.setHeight(r6)
            r12 = 1
            r14 = 1
            goto L_0x0206
        L_0x0204:
            r12 = r5
            r14 = r9
        L_0x0206:
            r5 = 0
            r8 = 8
            r9 = 1
            goto L_0x0091
        L_0x020c:
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r1.mParent
            if (r4 == 0) goto L_0x023c
            int r2 = r1.mMinWidth
            int r3 = r18.getWidth()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.mMinHeight
            int r4 = r18.getHeight()
            int r3 = java.lang.Math.max(r3, r4)
            android.support.constraint.solver.widgets.Snapshot r4 = r1.mSnapshot
            r4.applyTo(r1)
            int r4 = r1.mPaddingLeft
            int r2 = r2 + r4
            int r4 = r1.mPaddingRight
            int r2 = r2 + r4
            r1.setWidth(r2)
            int r2 = r1.mPaddingTop
            int r3 = r3 + r2
            int r2 = r1.mPaddingBottom
            int r3 = r3 + r2
            r1.setHeight(r3)
            goto L_0x0240
        L_0x023c:
            r1.f5mX = r2
            r1.f6mY = r3
        L_0x0240:
            if (r14 == 0) goto L_0x024c
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r3 = 0
            r2[r3] = r10
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r3 = 1
            r2[r3] = r7
        L_0x024c:
            android.support.constraint.solver.LinearSystem r2 = r1.mSystem
            android.support.constraint.solver.Cache r2 = r2.getCache()
            r1.resetSolverVariables(r2)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r2 = r18.getRootConstraintContainer()
            if (r1 != r2) goto L_0x025e
            r18.updateDrawPosition()
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void optimizeForDimensions(int i, int i2) {
        if (!(this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            while (constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner.mRight.mTarget != null && constraintWidget.mLeft.mTarget.mOwner.mRight.mTarget == constraintWidget.mLeft && constraintWidget.mLeft.mTarget.mOwner != constraintWidget) {
                constraintWidget = constraintWidget.mLeft.mTarget.mOwner;
            }
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            while (constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner.mBottom.mTarget != null && constraintWidget.mTop.mTarget.mOwner.mBottom.mTarget == constraintWidget.mTop && constraintWidget.mTop.mTarget.mOwner != constraintWidget) {
                constraintWidget = constraintWidget.mTop.mTarget.mOwner;
            }
            addVerticalChain(constraintWidget);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.mHorizontalChainsSize) {
            if (this.mHorizontalChainsArray[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = constraintWidget;
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.mVerticalChainsSize) {
            if (this.mVerticalChainsArray[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = constraintWidget;
        this.mVerticalChainsSize++;
    }
}
