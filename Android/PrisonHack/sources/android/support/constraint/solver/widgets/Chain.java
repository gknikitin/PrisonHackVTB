package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ConstraintWidget[] constraintWidgetArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            i2 = i5;
            constraintWidgetArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            ConstraintWidget constraintWidget = constraintWidgetArr[i6];
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, constraintWidget);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, constraintWidget)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, constraintWidget);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r6.mListAnchors[r41].mTarget.mOwner == r5) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (r5.mHorizontalChainStyle == 2) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007d, code lost:
        if (r5.mVerticalChainStyle == 2) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0175, code lost:
        if (r2.mListAnchors[r41].mTarget.mOwner == r13) goto L_0x0178;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0486 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0498  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x049d  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04a9  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04c9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:296:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r38, android.support.constraint.solver.LinearSystem r39, int r40, int r41, android.support.constraint.solver.widgets.ConstraintWidget r42) {
        /*
            r0 = r38
            r9 = r39
            r11 = r42
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r1 = r1[r40]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r4 = 1
            if (r1 != r2) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            r12 = 0
            if (r40 != 0) goto L_0x0044
            boolean r2 = r38.isRtl()
            if (r2 == 0) goto L_0x0044
            r5 = r11
            r2 = 0
        L_0x001d:
            if (r2 != 0) goto L_0x0045
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            int r7 = r41 + 1
            r6 = r6[r7]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x003d
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r6.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x003d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r7.mOwner
            if (r7 == r5) goto L_0x003e
        L_0x003d:
            r6 = r12
        L_0x003e:
            if (r6 == 0) goto L_0x0042
            r5 = r6
            goto L_0x001d
        L_0x0042:
            r2 = 1
            goto L_0x001d
        L_0x0044:
            r5 = r11
        L_0x0045:
            r2 = 2
            r6 = 0
            if (r40 != 0) goto L_0x006d
            int r7 = r5.mHorizontalChainStyle
            if (r7 != 0) goto L_0x004f
            r7 = 1
            goto L_0x0050
        L_0x004f:
            r7 = 0
        L_0x0050:
            int r8 = r5.mHorizontalChainStyle
            if (r8 != r4) goto L_0x0056
            r8 = 1
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            int r13 = r5.mHorizontalChainStyle
            if (r13 != r2) goto L_0x005d
        L_0x005b:
            r2 = 1
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            r16 = r7
            r17 = r8
            r13 = r11
            r4 = r12
            r8 = r4
            r14 = r8
            r15 = r14
            r6 = 0
            r26 = 0
            r7 = r2
            r2 = 0
            goto L_0x0080
        L_0x006d:
            int r7 = r5.mVerticalChainStyle
            if (r7 != 0) goto L_0x0073
            r7 = 1
            goto L_0x0074
        L_0x0073:
            r7 = 0
        L_0x0074:
            int r8 = r5.mVerticalChainStyle
            if (r8 != r4) goto L_0x007a
            r8 = 1
            goto L_0x007b
        L_0x007a:
            r8 = 0
        L_0x007b:
            int r13 = r5.mVerticalChainStyle
            if (r13 != r2) goto L_0x005d
            goto L_0x005b
        L_0x0080:
            if (r2 != 0) goto L_0x0187
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r13.mListNextVisibleWidget
            r3[r40] = r12
            int r3 = r13.getVisibility()
            r12 = 8
            if (r3 == r12) goto L_0x0098
            if (r14 == 0) goto L_0x0094
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r14.mListNextVisibleWidget
            r3[r40] = r13
        L_0x0094:
            if (r8 != 0) goto L_0x0097
            r8 = r13
        L_0x0097:
            r14 = r13
        L_0x0098:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r3 = r3[r41]
            r18 = 4
            if (r1 != 0) goto L_0x00a6
            if (r7 == 0) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            r19 = 4
            goto L_0x00a8
        L_0x00a6:
            r19 = 1
        L_0x00a8:
            int r20 = r3.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r3.mTarget
            if (r12 == 0) goto L_0x00ba
            if (r13 == r11) goto L_0x00ba
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r3.mTarget
            int r12 = r12.getMargin()
            int r20 = r20 + r12
        L_0x00ba:
            r12 = r20
            if (r7 == 0) goto L_0x00c8
            if (r13 == r11) goto L_0x00c8
            if (r13 == r8) goto L_0x00c8
            r27 = r2
            r28 = r14
            r2 = 6
            goto L_0x00d8
        L_0x00c8:
            if (r16 == 0) goto L_0x00d2
            if (r1 == 0) goto L_0x00d2
            r27 = r2
            r28 = r14
            r2 = 4
            goto L_0x00d8
        L_0x00d2:
            r27 = r2
            r28 = r14
            r2 = r19
        L_0x00d8:
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r3.mTarget
            if (r14 == 0) goto L_0x0105
            if (r13 != r8) goto L_0x00ed
            android.support.constraint.solver.SolverVariable r14 = r3.mSolverVariable
            r29 = r8
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r3.mTarget
            android.support.constraint.solver.SolverVariable r8 = r8.mSolverVariable
            r30 = r5
            r5 = 5
            r9.addGreaterThan(r14, r8, r12, r5)
            goto L_0x00fb
        L_0x00ed:
            r30 = r5
            r29 = r8
            android.support.constraint.solver.SolverVariable r5 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r3.mTarget
            android.support.constraint.solver.SolverVariable r8 = r8.mSolverVariable
            r14 = 6
            r9.addGreaterThan(r5, r8, r12, r14)
        L_0x00fb:
            android.support.constraint.solver.SolverVariable r5 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r9.addEquality(r5, r3, r12, r2)
            goto L_0x0109
        L_0x0105:
            r30 = r5
            r29 = r8
        L_0x0109:
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r13.mListNextMatchConstraintsWidget
            r12 = 0
            r2[r40] = r12
            int r2 = r13.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x0144
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r2 = r2[r40]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0144
            int r6 = r6 + 1
            float[] r2 = r13.mWeight
            r2 = r2[r40]
            float r26 = r26 + r2
            if (r15 != 0) goto L_0x012a
            r15 = r13
            goto L_0x012e
        L_0x012a:
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r4.mListNextMatchConstraintsWidget
            r2[r40] = r13
        L_0x012e:
            if (r1 == 0) goto L_0x0143
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r41 + 1
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r4 = 0
            r5 = 5
            r9.addGreaterThan(r2, r3, r4, r5)
        L_0x0143:
            r4 = r13
        L_0x0144:
            if (r1 == 0) goto L_0x0158
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r41]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r5 = 0
            r8 = 6
            r9.addGreaterThan(r2, r3, r5, r8)
            goto L_0x0159
        L_0x0158:
            r5 = 0
        L_0x0159:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r41 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0177
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0177
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r13) goto L_0x0178
        L_0x0177:
            r2 = r12
        L_0x0178:
            if (r2 == 0) goto L_0x017e
            r13 = r2
            r2 = r27
            goto L_0x017f
        L_0x017e:
            r2 = 1
        L_0x017f:
            r14 = r28
            r8 = r29
            r5 = r30
            goto L_0x0080
        L_0x0187:
            r30 = r5
            r5 = 0
            if (r14 == 0) goto L_0x01ae
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r41 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x01ae
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r4 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r3 = r5[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r5 = 5
            r9.addLowerThan(r4, r3, r2, r5)
            goto L_0x01af
        L_0x01ae:
            r5 = 5
        L_0x01af:
            if (r1 == 0) goto L_0x01cb
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r1 = r41 + 1
            r0 = r0[r1]
            android.support.constraint.solver.SolverVariable r0 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r1]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r1 = r3[r1]
            int r1 = r1.getMargin()
            r3 = 6
            r9.addGreaterThan(r0, r2, r1, r3)
        L_0x01cb:
            if (r6 <= 0) goto L_0x022c
            r0 = r15
        L_0x01ce:
            if (r0 == 0) goto L_0x022c
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r0.mListNextMatchConstraintsWidget
            r1 = r1[r40]
            if (r1 == 0) goto L_0x0228
            float[] r2 = r0.mWeight
            r19 = r2[r40]
            float[] r2 = r1.mWeight
            r21 = r2[r40]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r41]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            int r4 = r41 + 1
            r3 = r3[r4]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r1.mListAnchors
            r6 = r6[r41]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r1.mListAnchors
            r4 = r5[r4]
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            if (r40 != 0) goto L_0x01ff
            int r0 = r0.mMatchConstraintDefaultWidth
            int r5 = r1.mMatchConstraintDefaultWidth
            goto L_0x0203
        L_0x01ff:
            int r0 = r0.mMatchConstraintDefaultHeight
            int r5 = r1.mMatchConstraintDefaultHeight
        L_0x0203:
            r12 = 3
            if (r0 == 0) goto L_0x0208
            if (r0 != r12) goto L_0x020d
        L_0x0208:
            if (r5 == 0) goto L_0x020f
            if (r5 != r12) goto L_0x020d
            goto L_0x020f
        L_0x020d:
            r0 = 0
            goto L_0x0210
        L_0x020f:
            r0 = 1
        L_0x0210:
            if (r0 == 0) goto L_0x0228
            android.support.constraint.solver.ArrayRow r0 = r39.createRow()
            r18 = r0
            r20 = r26
            r22 = r2
            r23 = r3
            r24 = r6
            r25 = r4
            r18.createRowEqualMatchDimensions(r19, r20, r21, r22, r23, r24, r25)
            r9.addConstraint(r0)
        L_0x0228:
            r0 = r1
            r5 = 5
            r12 = 0
            goto L_0x01ce
        L_0x022c:
            if (r8 == 0) goto L_0x0298
            if (r8 == r14) goto L_0x0232
            if (r7 == 0) goto L_0x0298
        L_0x0232:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r11.mListAnchors
            r0 = r0[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r41 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x024d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x024e
        L_0x024d:
            r3 = 0
        L_0x024e:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0260
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            r5 = r4
            goto L_0x0261
        L_0x0260:
            r5 = 0
        L_0x0261:
            if (r8 != r14) goto L_0x026b
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            r0 = r0[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r1 = r1[r2]
        L_0x026b:
            if (r3 == 0) goto L_0x0295
            if (r5 == 0) goto L_0x0295
            if (r40 != 0) goto L_0x0277
            r11 = r30
            float r2 = r11.mHorizontalBiasPercent
        L_0x0275:
            r4 = r2
            goto L_0x027c
        L_0x0277:
            r11 = r30
            float r2 = r11.mVerticalBiasPercent
            goto L_0x0275
        L_0x027c:
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r10 = r1.mSolverVariable
            r11 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r10
            r12 = r8
            r8 = r11
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0482
        L_0x0295:
            r12 = r8
            goto L_0x0482
        L_0x0298:
            r12 = r8
            if (r16 == 0) goto L_0x0374
            if (r12 == 0) goto L_0x0374
            r0 = r12
            r8 = r0
        L_0x029f:
            if (r8 == 0) goto L_0x0482
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r8.mListNextVisibleWidget
            r7 = r1[r40]
            if (r7 != 0) goto L_0x02af
            if (r8 != r14) goto L_0x02aa
            goto L_0x02af
        L_0x02aa:
            r15 = r7
            r18 = r8
            goto L_0x036f
        L_0x02af:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r1 = r1[r41]
            android.support.constraint.solver.SolverVariable r2 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x02be
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02bf
        L_0x02be:
            r3 = 0
        L_0x02bf:
            if (r0 == r8) goto L_0x02ca
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            int r4 = r41 + 1
            r3 = r3[r4]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02e0
        L_0x02ca:
            if (r8 != r12) goto L_0x02e0
            if (r0 != r8) goto L_0x02e0
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x02df
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02e0
        L_0x02df:
            r3 = 0
        L_0x02e0:
            int r1 = r1.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r8.mListAnchors
            int r5 = r41 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0304
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r41]
            r31 = r7
            android.support.constraint.solver.SolverVariable r7 = r6.mSolverVariable
            r32 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r15 = r6
            r6 = r32
            goto L_0x031f
        L_0x0304:
            r31 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x0313
            android.support.constraint.solver.SolverVariable r7 = r6.mSolverVariable
            r33 = r6
            goto L_0x0316
        L_0x0313:
            r33 = r6
            r7 = 0
        L_0x0316:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r5]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r15 = r6
            r6 = r33
        L_0x031f:
            if (r6 == 0) goto L_0x0326
            int r6 = r6.getMargin()
            int r4 = r4 + r6
        L_0x0326:
            if (r0 == 0) goto L_0x0331
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r0 = r0[r5]
            int r0 = r0.getMargin()
            int r1 = r1 + r0
        L_0x0331:
            if (r2 == 0) goto L_0x036b
            if (r3 == 0) goto L_0x036b
            if (r7 == 0) goto L_0x036b
            if (r15 == 0) goto L_0x036b
            if (r8 != r12) goto L_0x0345
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r41]
            int r0 = r0.getMargin()
            r6 = r0
            goto L_0x0346
        L_0x0345:
            r6 = r1
        L_0x0346:
            if (r8 != r14) goto L_0x0353
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r5]
            int r0 = r0.getMargin()
            r18 = r0
            goto L_0x0355
        L_0x0353:
            r18 = r4
        L_0x0355:
            r4 = 1056964608(0x3f000000, float:0.5)
            r19 = 4
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r6
            r5 = r7
            r6 = r15
            r15 = r31
            r7 = r18
            r18 = r8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x036f
        L_0x036b:
            r18 = r8
            r15 = r31
        L_0x036f:
            r8 = r15
            r0 = r18
            goto L_0x029f
        L_0x0374:
            if (r17 == 0) goto L_0x0482
            if (r12 == 0) goto L_0x0482
            r0 = r12
            r8 = r0
        L_0x037a:
            if (r8 == 0) goto L_0x041f
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r8.mListNextVisibleWidget
            r1 = r1[r40]
            if (r8 == r12) goto L_0x041a
            if (r8 == r14) goto L_0x041a
            if (r1 == 0) goto L_0x041a
            if (r1 != r14) goto L_0x038a
            r7 = 0
            goto L_0x038b
        L_0x038a:
            r7 = r1
        L_0x038b:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r1 = r1[r41]
            android.support.constraint.solver.SolverVariable r2 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x0399
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
        L_0x0399:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            int r4 = r41 + 1
            r3 = r3[r4]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            int r1 = r1.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            if (r7 == 0) goto L_0x03c4
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r41]
            r34 = r7
            android.support.constraint.solver.SolverVariable r7 = r6.mSolverVariable
            r35 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r6.mTarget
            if (r7 == 0) goto L_0x03c2
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r6.mTarget
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            goto L_0x03e1
        L_0x03c2:
            r7 = 0
            goto L_0x03e1
        L_0x03c4:
            r34 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x03d3
            android.support.constraint.solver.SolverVariable r7 = r6.mSolverVariable
            r36 = r6
            goto L_0x03d6
        L_0x03d3:
            r36 = r6
            r7 = 0
        L_0x03d6:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r4]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r35 = r7
            r7 = r6
            r6 = r36
        L_0x03e1:
            if (r6 == 0) goto L_0x03e8
            int r6 = r6.getMargin()
            int r5 = r5 + r6
        L_0x03e8:
            r15 = r5
            if (r0 == 0) goto L_0x03f4
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            int r1 = r1 + r0
        L_0x03f4:
            r4 = r1
            if (r2 == 0) goto L_0x0414
            if (r3 == 0) goto L_0x0414
            if (r35 == 0) goto L_0x0414
            if (r7 == 0) goto L_0x0414
            r5 = 1056964608(0x3f000000, float:0.5)
            r18 = 4
            r0 = r9
            r1 = r2
            r2 = r3
            r6 = 5
            r3 = r4
            r4 = r5
            r5 = r35
            r6 = r7
            r19 = r34
            r7 = r15
            r15 = r8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0417
        L_0x0414:
            r15 = r8
            r19 = r34
        L_0x0417:
            r8 = r19
            goto L_0x041c
        L_0x041a:
            r15 = r8
            r8 = r1
        L_0x041c:
            r0 = r15
            goto L_0x037a
        L_0x041f:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r41 + 1
            r10 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r2.mTarget
            if (r1 == 0) goto L_0x046e
            if (r12 == r14) goto L_0x0446
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r8 = 5
            r9.addEquality(r2, r1, r0, r8)
            goto L_0x046e
        L_0x0446:
            r8 = 5
            if (r11 == 0) goto L_0x046e
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r6 = r10.mSolverVariable
            android.support.constraint.solver.SolverVariable r7 = r11.mSolverVariable
            int r15 = r10.getMargin()
            r18 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r37 = r13
            r13 = 5
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0471
        L_0x046e:
            r37 = r13
            r13 = 5
        L_0x0471:
            if (r11 == 0) goto L_0x0484
            if (r12 == r14) goto L_0x0484
            android.support.constraint.solver.SolverVariable r0 = r10.mSolverVariable
            android.support.constraint.solver.SolverVariable r1 = r11.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r13)
            goto L_0x0484
        L_0x0482:
            r37 = r13
        L_0x0484:
            if (r16 != 0) goto L_0x0488
            if (r17 == 0) goto L_0x04eb
        L_0x0488:
            if (r12 == 0) goto L_0x04eb
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            int r2 = r41 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x049d
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x049e
        L_0x049d:
            r3 = 0
        L_0x049e:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04a9
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            r11 = r37
            goto L_0x04ac
        L_0x04a9:
            r11 = r37
            r4 = 0
        L_0x04ac:
            if (r11 == r14) goto L_0x04bc
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x04bb
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04bc
        L_0x04bb:
            r4 = 0
        L_0x04bc:
            r5 = r4
            if (r12 != r14) goto L_0x04c7
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r41]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x04c7:
            if (r3 == 0) goto L_0x04eb
            if (r5 == 0) goto L_0x04eb
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            if (r14 != 0) goto L_0x04d4
            goto L_0x04d5
        L_0x04d4:
            r11 = r14
        L_0x04d5:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ConstraintWidget):void");
    }
}
