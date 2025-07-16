package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i2, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX WARNING: type inference failed for: r4v12, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04e1  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x038f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r36, androidx.constraintlayout.solver.LinearSystem r37, int r38, int r39, androidx.constraintlayout.solver.widgets.ChainHead r40) {
        /*
            r0 = r36
            r9 = r37
            r1 = r40
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 1
            if (r4 != r5) goto L_0x0021
            r4 = r6
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r38 != 0) goto L_0x0038
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x002b
            r8 = r6
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.mHorizontalChainStyle
            if (r14 != r6) goto L_0x0032
            r14 = r6
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.mHorizontalChainStyle
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.mVerticalChainStyle
            if (r8 != 0) goto L_0x003e
            r8 = r6
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.mVerticalChainStyle
            if (r14 != r6) goto L_0x0045
            r14 = r6
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.mVerticalChainStyle
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = r6
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r6 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x0051:
            r21 = 0
            if (r8 != 0) goto L_0x0130
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r39]
            if (r4 != 0) goto L_0x0061
            if (r5 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r23 = 4
            goto L_0x0063
        L_0x0061:
            r23 = 1
        L_0x0063:
            int r24 = r7.getMargin()
            r25 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mTarget
            if (r3 == 0) goto L_0x0077
            if (r6 == r10) goto L_0x0077
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mTarget
            int r3 = r3.getMargin()
            int r24 = r24 + r3
        L_0x0077:
            r3 = r24
            if (r5 == 0) goto L_0x0085
            if (r6 == r10) goto L_0x0085
            if (r6 == r12) goto L_0x0085
            r24 = r8
            r23 = r15
            r8 = 6
            goto L_0x0095
        L_0x0085:
            if (r14 == 0) goto L_0x008f
            if (r4 == 0) goto L_0x008f
            r24 = r8
            r23 = r15
            r8 = 4
            goto L_0x0095
        L_0x008f:
            r24 = r8
            r8 = r23
            r23 = r15
        L_0x0095:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.mTarget
            if (r15 == 0) goto L_0x00c2
            if (r6 != r12) goto L_0x00aa
            androidx.constraintlayout.solver.SolverVariable r15 = r7.mSolverVariable
            r26 = r14
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r27 = r2
            r2 = 5
            r9.addGreaterThan(r15, r14, r3, r2)
            goto L_0x00b8
        L_0x00aa:
            r27 = r2
            r26 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r15 = 6
            r9.addGreaterThan(r2, r14, r3, r15)
        L_0x00b8:
            androidx.constraintlayout.solver.SolverVariable r2 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r9.addEquality(r2, r7, r3, r8)
            goto L_0x00c6
        L_0x00c2:
            r27 = r2
            r26 = r14
        L_0x00c6:
            if (r4 == 0) goto L_0x00fd
            int r2 = r6.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00ec
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r6.mListDimensionBehaviors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00ec
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 5
            r8 = 0
            r9.addGreaterThan(r2, r3, r8, r7)
            goto L_0x00ed
        L_0x00ec:
            r8 = 0
        L_0x00ed:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            r2 = r2[r39]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 6
            r9.addGreaterThan(r2, r3, r8, r7)
        L_0x00fd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x011e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x011e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r6) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r21 = r2
        L_0x011e:
            if (r21 == 0) goto L_0x0125
            r6 = r21
            r8 = r24
            goto L_0x0126
        L_0x0125:
            r8 = 1
        L_0x0126:
            r15 = r23
            r3 = r25
            r14 = r26
            r2 = r27
            goto L_0x0051
        L_0x0130:
            r27 = r2
            r25 = r3
            r26 = r14
            r23 = r15
            if (r13 == 0) goto L_0x015c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x015c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r7 = 5
            r9.addLowerThan(r6, r3, r2, r7)
            goto L_0x015d
        L_0x015c:
            r7 = 5
        L_0x015d:
            if (r4 == 0) goto L_0x0179
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r39 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r2 = r4[r2]
            int r2 = r2.getMargin()
            r4 = 6
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x0179:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x0230
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0230
            boolean r4 = r1.mHasUndefinedWeights
            if (r4 == 0) goto L_0x0190
            boolean r4 = r1.mHasComplexMatchWeights
            if (r4 != 0) goto L_0x0190
            int r4 = r1.mWidgetsMatchCount
            float r4 = (float) r4
            goto L_0x0192
        L_0x0190:
            r4 = r25
        L_0x0192:
            r6 = 0
            r29 = r6
            r14 = r21
            r8 = 0
        L_0x0198:
            if (r8 >= r2) goto L_0x0230
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r3 = r15.mWeight
            r3 = r3[r38]
            int r19 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r19 >= 0) goto L_0x01c6
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 == 0) goto L_0x01c1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r19 = r39 + 1
            r3 = r3[r19]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.mListAnchors
            r15 = r15[r39]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r6 = 0
            r7 = 4
            r9.addEquality(r3, r15, r6, r7)
            r7 = 6
            goto L_0x01de
        L_0x01c1:
            r7 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            goto L_0x01c7
        L_0x01c6:
            r7 = 4
        L_0x01c7:
            int r20 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r20 != 0) goto L_0x01e3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r20 = r39 + 1
            r3 = r3[r20]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.mListAnchors
            r15 = r15[r39]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r6 = 0
            r7 = 6
            r9.addEquality(r3, r15, r6, r7)
        L_0x01de:
            r25 = r0
            r22 = r2
            goto L_0x0225
        L_0x01e3:
            r6 = 0
            r7 = 6
            if (r14 == 0) goto L_0x021e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r14.mListAnchors
            int r22 = r39 + 1
            r14 = r14[r22]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r7 = r7[r39]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r25 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r15.mListAnchors
            r0 = r0[r22]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r22 = r2
            androidx.constraintlayout.solver.ArrayRow r2 = r37.createRow()
            r28 = r2
            r30 = r4
            r31 = r3
            r32 = r6
            r33 = r14
            r34 = r7
            r35 = r0
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r9.addConstraint(r2)
            goto L_0x0222
        L_0x021e:
            r25 = r0
            r22 = r2
        L_0x0222:
            r29 = r3
            r14 = r15
        L_0x0225:
            int r8 = r8 + 1
            r2 = r22
            r0 = r25
            r3 = 1
            r6 = 0
            r7 = 5
            goto L_0x0198
        L_0x0230:
            if (r12 == 0) goto L_0x029a
            if (r12 == r13) goto L_0x0236
            if (r5 == 0) goto L_0x029a
        L_0x0236:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0251
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0253
        L_0x0251:
            r3 = r21
        L_0x0253:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0265
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r5 = r4
            goto L_0x0267
        L_0x0265:
            r5 = r21
        L_0x0267:
            if (r12 != r13) goto L_0x0271
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x0271:
            if (r3 == 0) goto L_0x04c2
            if (r5 == 0) goto L_0x04c2
            if (r38 != 0) goto L_0x027c
            r2 = r27
            float r2 = r2.mHorizontalBiasPercent
            goto L_0x0280
        L_0x027c:
            r2 = r27
            float r2 = r2.mVerticalBiasPercent
        L_0x0280:
            r4 = r2
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04c2
        L_0x029a:
            if (r26 == 0) goto L_0x0393
            if (r12 == 0) goto L_0x0393
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02ab
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x02ab
            r16 = 1
            goto L_0x02ad
        L_0x02ab:
            r16 = 0
        L_0x02ad:
            r14 = r12
            r15 = r14
        L_0x02af:
            if (r14 == 0) goto L_0x04c2
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r38]
            r8 = r0
        L_0x02b6:
            if (r8 == 0) goto L_0x02c5
            int r0 = r8.getVisibility()
            r7 = 8
            if (r0 != r7) goto L_0x02c7
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r38]
            goto L_0x02b6
        L_0x02c5:
            r7 = 8
        L_0x02c7:
            if (r8 != 0) goto L_0x02d4
            if (r14 != r13) goto L_0x02cc
            goto L_0x02d4
        L_0x02cc:
            r17 = r8
            r18 = 4
            r20 = 6
            goto L_0x0386
        L_0x02d4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02e3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02e5
        L_0x02e3:
            r2 = r21
        L_0x02e5:
            if (r15 == r14) goto L_0x02f0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0307
        L_0x02f0:
            if (r14 != r12) goto L_0x0307
            if (r15 != r14) goto L_0x0307
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0305
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0307
        L_0x0305:
            r2 = r21
        L_0x0307:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r39 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x0324
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            goto L_0x0337
        L_0x0324:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x032f
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0331
        L_0x032f:
            r6 = r21
        L_0x0331:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x0337:
            if (r5 == 0) goto L_0x033e
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x033e:
            if (r15 == 0) goto L_0x0349
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x0349:
            if (r1 == 0) goto L_0x02cc
            if (r2 == 0) goto L_0x02cc
            if (r6 == 0) goto L_0x02cc
            if (r7 == 0) goto L_0x02cc
            if (r14 != r12) goto L_0x035b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            int r0 = r0.getMargin()
        L_0x035b:
            r5 = r0
            if (r14 != r13) goto L_0x0369
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x036b
        L_0x0369:
            r17 = r3
        L_0x036b:
            if (r16 == 0) goto L_0x0370
            r19 = 6
            goto L_0x0372
        L_0x0370:
            r19 = 4
        L_0x0372:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r3 = r5
            r5 = r6
            r6 = r7
            r18 = 4
            r20 = 6
            r7 = r17
            r17 = r8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0386:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x038f
            r15 = r14
        L_0x038f:
            r14 = r17
            goto L_0x02af
        L_0x0393:
            r8 = 8
            r18 = 4
            r20 = 6
            if (r23 == 0) goto L_0x04c2
            if (r12 == 0) goto L_0x04c2
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03aa
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x03aa
            r16 = 1
            goto L_0x03ac
        L_0x03aa:
            r16 = 0
        L_0x03ac:
            r14 = r12
            r15 = r14
        L_0x03ae:
            if (r14 == 0) goto L_0x0469
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r38]
        L_0x03b4:
            if (r0 == 0) goto L_0x03c1
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x03c1
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r38]
            goto L_0x03b4
        L_0x03c1:
            if (r14 == r12) goto L_0x0458
            if (r14 == r13) goto L_0x0458
            if (r0 == 0) goto L_0x0458
            if (r0 != r13) goto L_0x03cc
            r7 = r21
            goto L_0x03cd
        L_0x03cc:
            r7 = r0
        L_0x03cd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x03db
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x03db:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0403
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x0400
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            goto L_0x0416
        L_0x0400:
            r8 = r21
            goto L_0x0416
        L_0x0403:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r14.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x040e
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0410
        L_0x040e:
            r6 = r21
        L_0x0410:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x0416:
            if (r5 == 0) goto L_0x041d
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x041d:
            r17 = r4
            if (r15 == 0) goto L_0x042a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x042a:
            r3 = r0
            if (r16 == 0) goto L_0x0430
            r22 = r20
            goto L_0x0432
        L_0x0430:
            r22 = r18
        L_0x0432:
            if (r1 == 0) goto L_0x044f
            if (r2 == 0) goto L_0x044f
            if (r6 == 0) goto L_0x044f
            if (r8 == 0) goto L_0x044f
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r5 = r6
            r6 = r8
            r19 = r7
            r8 = 5
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r22
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0455
        L_0x044f:
            r19 = r7
            r17 = r15
            r15 = 8
        L_0x0455:
            r0 = r19
            goto L_0x045b
        L_0x0458:
            r17 = r15
            r15 = r8
        L_0x045b:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x0462
            goto L_0x0464
        L_0x0462:
            r14 = r17
        L_0x0464:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x03ae
        L_0x0469:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r39 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            if (r1 == 0) goto L_0x04b1
            if (r12 == r13) goto L_0x0490
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r15 = 5
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x04b2
        L_0x0490:
            r15 = 5
            if (r14 == 0) goto L_0x04b2
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r5 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r14.mSolverVariable
            int r7 = r10.getMargin()
            r8 = 5
            r16 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04b2
        L_0x04b1:
            r15 = 5
        L_0x04b2:
            if (r14 == 0) goto L_0x04c2
            if (r12 == r13) goto L_0x04c2
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x04c2:
            if (r26 != 0) goto L_0x04c6
            if (r23 == 0) goto L_0x052a
        L_0x04c6:
            if (r12 == 0) goto L_0x052a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x04db
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x04dd
        L_0x04db:
            r3 = r21
        L_0x04dd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04e6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04e8
        L_0x04e6:
            r4 = r21
        L_0x04e8:
            if (r11 == r13) goto L_0x04fb
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x04f8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r21 = r4
        L_0x04f8:
            r5 = r21
            goto L_0x04fc
        L_0x04fb:
            r5 = r4
        L_0x04fc:
            if (r12 != r13) goto L_0x0506
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x0506:
            if (r3 == 0) goto L_0x052a
            if (r5 == 0) goto L_0x052a
            int r4 = r0.getMargin()
            if (r13 != 0) goto L_0x0511
            goto L_0x0512
        L_0x0511:
            r11 = r13
        L_0x0512:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r2 = r6[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r1.mSolverVariable
            r8 = 5
            r10 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x052a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
