package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 3;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget r3, int r4) {
        /*
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r3.mListDimensionBehaviors
            r0 = r0[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r3.mDimensionRatio
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x0020
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r3.mListDimensionBehaviors
            if (r4 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r3 = r3[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x001f
            return r2
        L_0x001f:
            return r2
        L_0x0020:
            if (r4 != 0) goto L_0x0030
            int r4 = r3.mMatchConstraintDefaultWidth
            if (r4 == 0) goto L_0x0027
            return r2
        L_0x0027:
            int r4 = r3.mMatchConstraintMinWidth
            if (r4 != 0) goto L_0x002f
            int r3 = r3.mMatchConstraintMaxWidth
            if (r3 == 0) goto L_0x003e
        L_0x002f:
            return r2
        L_0x0030:
            int r4 = r3.mMatchConstraintDefaultHeight
            if (r4 == 0) goto L_0x0035
            return r2
        L_0x0035:
            int r4 = r3.mMatchConstraintMinHeight
            if (r4 != 0) goto L_0x003f
            int r3 = r3.mMatchConstraintMaxHeight
            if (r3 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r1
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void analyze(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget2.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget2.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget2.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget2.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 0);
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget != null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget != null) {
                    if (constraintWidget2.mLeft.mTarget != null || constraintWidget2.mRight.mTarget == null) {
                        if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget2.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 1);
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaseline.mTarget != null) {
                        constraintWidget2.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget2.mBaseline.getResolutionNode(), -constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                }
            } else if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget2.mTop.mTarget == null || constraintWidget2.mBottom.mTarget != null) {
                    if (constraintWidget2.mTop.mTarget != null || constraintWidget2.mBottom.mTarget == null) {
                        if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget2.setHeight(height);
                            if (constraintWidget2.mBaselineDistance > 0) {
                                constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                            }
                        }
                    } else if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r6.mListAnchors[r24].mTarget.mOwner == r5) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r5.mHorizontalChainStyle == 2) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0069, code lost:
        if (r5.mVerticalChainStyle == 2) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012d, code lost:
        if (r3.mListAnchors[r24].mTarget.mOwner == r9) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer r21, android.support.constraint.solver.LinearSystem r22, int r23, int r24, android.support.constraint.solver.widgets.ConstraintWidget r25) {
        /*
            r0 = r22
            r1 = r21
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r2 = r2[r23]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r2 = 0
            r4 = 1
            if (r23 != 0) goto L_0x003e
            boolean r1 = r21.isRtl()
            if (r1 == 0) goto L_0x003e
            r5 = r25
            r1 = 0
        L_0x0017:
            if (r1 != 0) goto L_0x0040
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            int r7 = r24 + 1
            r6 = r6[r7]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x0037
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r6.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r24]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0037
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r24]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r7.mOwner
            if (r7 == r5) goto L_0x0038
        L_0x0037:
            r6 = r2
        L_0x0038:
            if (r6 == 0) goto L_0x003c
            r5 = r6
            goto L_0x0017
        L_0x003c:
            r1 = 1
            goto L_0x0017
        L_0x003e:
            r5 = r25
        L_0x0040:
            r1 = 2
            if (r23 != 0) goto L_0x0059
            int r6 = r5.mHorizontalChainStyle
            if (r6 != 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            int r7 = r5.mHorizontalChainStyle
            if (r7 != r4) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            int r5 = r5.mHorizontalChainStyle
            if (r5 != r1) goto L_0x0057
        L_0x0055:
            r1 = 1
            goto L_0x006c
        L_0x0057:
            r1 = 0
            goto L_0x006c
        L_0x0059:
            int r6 = r5.mVerticalChainStyle
            if (r6 != 0) goto L_0x005f
            r6 = 1
            goto L_0x0060
        L_0x005f:
            r6 = 0
        L_0x0060:
            int r7 = r5.mVerticalChainStyle
            if (r7 != r4) goto L_0x0066
            r7 = 1
            goto L_0x0067
        L_0x0066:
            r7 = 0
        L_0x0067:
            int r5 = r5.mVerticalChainStyle
            if (r5 != r1) goto L_0x0057
            goto L_0x0055
        L_0x006c:
            r9 = r25
            r5 = r2
            r10 = r5
            r11 = r10
            r17 = r11
            r8 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x007a:
            if (r8 != 0) goto L_0x0138
            android.support.constraint.solver.widgets.ConstraintWidget[] r4 = r9.mListNextVisibleWidget
            r4[r23] = r2
            int r4 = r9.getVisibility()
            r3 = 8
            if (r4 == r3) goto L_0x00c5
            if (r10 == 0) goto L_0x008e
            android.support.constraint.solver.widgets.ConstraintWidget[] r4 = r10.mListNextVisibleWidget
            r4[r23] = r9
        L_0x008e:
            if (r11 != 0) goto L_0x0091
            r11 = r9
        L_0x0091:
            int r12 = r12 + 1
            if (r23 != 0) goto L_0x009c
            int r4 = r9.getWidth()
            float r4 = (float) r4
            float r14 = r14 + r4
            goto L_0x00a2
        L_0x009c:
            int r4 = r9.getHeight()
            float r4 = (float) r4
            float r14 = r14 + r4
        L_0x00a2:
            if (r9 == r11) goto L_0x00ae
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            r4 = r4[r24]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r14 = r14 + r4
        L_0x00ae:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            r4 = r4[r24]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r15 = r15 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            int r10 = r24 + 1
            r4 = r4[r10]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r15 = r15 + r4
            r10 = r9
        L_0x00c5:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            r4 = r4[r24]
            android.support.constraint.solver.widgets.ConstraintWidget[] r4 = r9.mListNextMatchConstraintsWidget
            r4[r23] = r2
            int r4 = r9.getVisibility()
            if (r4 == r3) goto L_0x0111
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r9.mListDimensionBehaviors
            r3 = r3[r23]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x0111
            int r13 = r13 + 1
            if (r23 != 0) goto L_0x00ef
            int r3 = r9.mMatchConstraintDefaultWidth
            if (r3 == 0) goto L_0x00e5
            r3 = 0
            return r3
        L_0x00e5:
            r3 = 0
            int r4 = r9.mMatchConstraintMinWidth
            if (r4 != 0) goto L_0x00ee
            int r4 = r9.mMatchConstraintMaxWidth
            if (r4 == 0) goto L_0x00fe
        L_0x00ee:
            return r3
        L_0x00ef:
            r3 = 0
            int r4 = r9.mMatchConstraintDefaultHeight
            if (r4 == 0) goto L_0x00f5
            return r3
        L_0x00f5:
            int r3 = r9.mMatchConstraintMinHeight
            if (r3 != 0) goto L_0x010f
            int r3 = r9.mMatchConstraintMaxHeight
            if (r3 == 0) goto L_0x00fe
            goto L_0x010f
        L_0x00fe:
            float[] r3 = r9.mWeight
            r3 = r3[r23]
            float r16 = r16 + r3
            if (r17 != 0) goto L_0x0109
            r17 = r9
            goto L_0x010d
        L_0x0109:
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r5.mListNextMatchConstraintsWidget
            r3[r23] = r9
        L_0x010d:
            r5 = r9
            goto L_0x0111
        L_0x010f:
            r0 = 0
            return r0
        L_0x0111:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            int r4 = r24 + 1
            r3 = r3[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x012f
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r3.mListAnchors
            r4 = r4[r24]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x012f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r3.mListAnchors
            r4 = r4[r24]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r4.mOwner
            if (r4 == r9) goto L_0x0130
        L_0x012f:
            r3 = r2
        L_0x0130:
            if (r3 == 0) goto L_0x0134
            r9 = r3
            goto L_0x0135
        L_0x0134:
            r8 = 1
        L_0x0135:
            r4 = 1
            goto L_0x007a
        L_0x0138:
            r3 = r25
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r3.mListAnchors
            r2 = r2[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            int r5 = r24 + 1
            r4 = r4[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r2.target
            if (r8 == 0) goto L_0x039e
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r4.target
            if (r8 != 0) goto L_0x0156
            goto L_0x039e
        L_0x0156:
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r2.target
            int r8 = r8.state
            r3 = 1
            if (r8 == r3) goto L_0x0165
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r4.target
            int r8 = r8.state
            if (r8 == r3) goto L_0x0165
            r3 = 0
            return r3
        L_0x0165:
            r3 = 0
            if (r13 <= 0) goto L_0x016b
            if (r13 == r12) goto L_0x016b
            return r3
        L_0x016b:
            if (r1 != 0) goto L_0x0174
            if (r6 != 0) goto L_0x0174
            if (r7 == 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r3 = 0
            goto L_0x018d
        L_0x0174:
            if (r11 == 0) goto L_0x0180
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r24]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            goto L_0x0181
        L_0x0180:
            r3 = 0
        L_0x0181:
            if (r10 == 0) goto L_0x018d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r10.mListAnchors
            r8 = r8[r5]
            int r8 = r8.getMargin()
            float r8 = (float) r8
            float r3 = r3 + r8
        L_0x018d:
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r2.target
            float r8 = r8.resolvedOffset
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.target
            float r4 = r4.resolvedOffset
            int r17 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r17 >= 0) goto L_0x019c
            float r4 = r4 - r8
            float r4 = r4 - r14
            goto L_0x019f
        L_0x019c:
            float r4 = r8 - r4
            float r4 = r4 - r14
        L_0x019f:
            r18 = 1
            if (r13 <= 0) goto L_0x0268
            if (r13 != r12) goto L_0x0268
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r9.getParent()
            if (r1 == 0) goto L_0x01b9
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r9.getParent()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r1 = r1[r23]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r7) goto L_0x01b9
            r1 = 0
            return r1
        L_0x01b9:
            float r4 = r4 + r14
            float r4 = r4 - r15
            if (r6 == 0) goto L_0x01bf
            float r15 = r15 - r3
            float r4 = r4 - r15
        L_0x01bf:
            if (r6 == 0) goto L_0x01db
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r5]
            int r1 = r1.getMargin()
            float r1 = (float) r1
            float r8 = r8 + r1
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r11.mListNextVisibleWidget
            r1 = r1[r23]
            if (r1 == 0) goto L_0x01db
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r1.mListAnchors
            r1 = r1[r24]
            int r1 = r1.getMargin()
            float r1 = (float) r1
            float r8 = r8 + r1
        L_0x01db:
            if (r11 == 0) goto L_0x0266
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r1 == 0) goto L_0x01fc
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r1.nonresolvedWidgets
            r20 = r2
            long r2 = r6 - r18
            r1.nonresolvedWidgets = r2
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r2 = r1.resolvedWidgets
            long r6 = r2 + r18
            r1.resolvedWidgets = r6
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r2 = r1.chainConnectionResolved
            long r6 = r2 + r18
            r1.chainConnectionResolved = r6
            goto L_0x01fe
        L_0x01fc:
            r20 = r2
        L_0x01fe:
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r11.mListNextVisibleWidget
            r1 = r1[r23]
            if (r1 != 0) goto L_0x020b
            if (r11 != r10) goto L_0x0207
            goto L_0x020b
        L_0x0207:
            r9 = r20
            r3 = 0
            goto L_0x0262
        L_0x020b:
            float r2 = (float) r13
            float r2 = r4 / r2
            r3 = 0
            int r6 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x021b
            float[] r2 = r11.mWeight
            r2 = r2[r23]
            float r2 = r2 * r4
            float r2 = r2 / r16
        L_0x021b:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r24]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r8 = r8 + r6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r9 = r20
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            r6.resolve(r7, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            float r8 = r8 + r2
            r6.resolve(r7, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            r2.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            r2.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r5]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r8 = r8 + r2
        L_0x0262:
            r11 = r1
            r2 = r9
            goto L_0x01db
        L_0x0266:
            r1 = 1
            return r1
        L_0x0268:
            r9 = r2
            int r2 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x026f
            r2 = 0
            return r2
        L_0x026f:
            if (r1 == 0) goto L_0x02f6
            float r4 = r4 - r3
            float r1 = r25.getHorizontalBiasPercent()
            float r4 = r4 * r1
            float r8 = r8 + r4
        L_0x0279:
            if (r11 == 0) goto L_0x02f3
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r1 == 0) goto L_0x0297
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r2 = r1.nonresolvedWidgets
            long r6 = r2 - r18
            r1.nonresolvedWidgets = r6
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r2 = r1.resolvedWidgets
            long r6 = r2 + r18
            r1.resolvedWidgets = r6
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.sMetrics
            long r2 = r1.chainConnectionResolved
            long r6 = r2 + r18
            r1.chainConnectionResolved = r6
        L_0x0297:
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r11.mListNextVisibleWidget
            r1 = r1[r23]
            if (r1 != 0) goto L_0x029f
            if (r11 != r10) goto L_0x02f1
        L_0x029f:
            if (r23 != 0) goto L_0x02a7
            int r2 = r11.getWidth()
            float r2 = (float) r2
            goto L_0x02ac
        L_0x02a7:
            int r2 = r11.getHeight()
            float r2 = (float) r2
        L_0x02ac:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r24]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r8 = r8 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r9.resolvedTarget
            r3.resolve(r4, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r9.resolvedTarget
            float r8 = r8 + r2
            r3.resolve(r4, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            r2.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            r2.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r5]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r8 = r8 + r2
        L_0x02f1:
            r11 = r1
            goto L_0x0279
        L_0x02f3:
            r0 = 1
            goto L_0x039d
        L_0x02f6:
            if (r6 != 0) goto L_0x02fa
            if (r7 == 0) goto L_0x02f3
        L_0x02fa:
            if (r6 == 0) goto L_0x02fe
            float r4 = r4 - r3
            goto L_0x0301
        L_0x02fe:
            if (r7 == 0) goto L_0x0301
            float r4 = r4 - r3
        L_0x0301:
            int r1 = r12 + 1
            float r1 = (float) r1
            float r1 = r4 / r1
            if (r7 == 0) goto L_0x0315
            r2 = 1
            if (r12 <= r2) goto L_0x0311
            int r1 = r12 + -1
            float r1 = (float) r1
            float r1 = r4 / r1
            goto L_0x0315
        L_0x0311:
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r4 / r1
        L_0x0315:
            float r2 = r8 + r1
            if (r7 == 0) goto L_0x0326
            r3 = 1
            if (r12 <= r3) goto L_0x0326
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r24]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r2 = r2 + r8
        L_0x0326:
            if (r6 == 0) goto L_0x0334
            if (r11 == 0) goto L_0x0334
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r24]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r2 = r2 + r3
        L_0x0334:
            if (r11 == 0) goto L_0x02f3
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x0352
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r3.nonresolvedWidgets
            long r12 = r6 - r18
            r3.nonresolvedWidgets = r12
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r3.resolvedWidgets
            long r12 = r6 + r18
            r3.resolvedWidgets = r12
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r3.chainConnectionResolved
            long r12 = r6 + r18
            r3.chainConnectionResolved = r12
        L_0x0352:
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r11.mListNextVisibleWidget
            r3 = r3[r23]
            if (r3 != 0) goto L_0x035a
            if (r11 != r10) goto L_0x039b
        L_0x035a:
            if (r23 != 0) goto L_0x0362
            int r4 = r11.getWidth()
            float r4 = (float) r4
            goto L_0x0367
        L_0x0362:
            int r4 = r11.getHeight()
            float r4 = (float) r4
        L_0x0367:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            r6.resolve(r7, r2)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            float r8 = r2 + r4
            r6.resolve(r7, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r24]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r6.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r6.addResolvedValue(r0)
            float r4 = r4 + r1
            float r2 = r2 + r4
        L_0x039b:
            r11 = r3
            goto L_0x0334
        L_0x039d:
            return r0
        L_0x039e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ConstraintWidget):boolean");
    }
}
