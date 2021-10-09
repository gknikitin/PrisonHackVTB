package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class Legend extends ComponentBase {
    private Boolean[] mCalculatedLabelBreakPoints;
    private FSize[] mCalculatedLabelSizes;
    private FSize[] mCalculatedLineSizes;
    private int[] mColors;
    private LegendDirection mDirection;
    private int[] mExtraColors;
    private String[] mExtraLabels;
    private float mFormSize;
    private float mFormToTextSpace;
    private boolean mIsLegendCustom;
    private String[] mLabels;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendPosition mPosition;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public Legend() {
        this.mIsLegendCustom = false;
        this.mPosition = LegendPosition.BELOW_CHART_LEFT;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new FSize[0];
        this.mCalculatedLabelBreakPoints = new Boolean[0];
        this.mCalculatedLineSizes = new FSize[0];
        this.mFormSize = Utils.convertDpToPixel(8.0f);
        this.mXEntrySpace = Utils.convertDpToPixel(6.0f);
        this.mYEntrySpace = Utils.convertDpToPixel(0.0f);
        this.mFormToTextSpace = Utils.convertDpToPixel(5.0f);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mStackSpace = Utils.convertDpToPixel(3.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public Legend(int[] iArr, String[] strArr) {
        this();
        if (iArr == null || strArr == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (iArr.length != strArr.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        } else {
            this.mColors = iArr;
            this.mLabels = strArr;
        }
    }

    public Legend(List<Integer> list, List<String> list2) {
        this();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        } else {
            this.mColors = Utils.convertIntegers(list);
            this.mLabels = Utils.convertStrings(list2);
        }
    }

    public void setComputedColors(List<Integer> list) {
        this.mColors = Utils.convertIntegers(list);
    }

    public void setComputedLabels(List<String> list) {
        this.mLabels = Utils.convertStrings(list);
    }

    public float getMaximumEntryWidth(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                float calcTextWidth = (float) Utils.calcTextWidth(paint, this.mLabels[i]);
                if (calcTextWidth > f) {
                    f = calcTextWidth;
                }
            }
        }
        return f + this.mFormSize + this.mFormToTextSpace;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                float calcTextHeight = (float) Utils.calcTextHeight(paint, this.mLabels[i]);
                if (calcTextHeight > f) {
                    f = calcTextHeight;
                }
            }
        }
        return f;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public String[] getLabels() {
        return this.mLabels;
    }

    public String getLabel(int i) {
        return this.mLabels[i];
    }

    public int[] getExtraColors() {
        return this.mExtraColors;
    }

    public String[] getExtraLabels() {
        return this.mExtraLabels;
    }

    public void setExtra(List<Integer> list, List<String> list2) {
        this.mExtraColors = Utils.convertIntegers(list);
        this.mExtraLabels = Utils.convertStrings(list2);
    }

    public void setExtra(int[] iArr, String[] strArr) {
        this.mExtraColors = iArr;
        this.mExtraLabels = strArr;
    }

    public void setCustom(int[] iArr, String[] strArr) {
        if (iArr.length != strArr.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mLabels = strArr;
        this.mColors = iArr;
        this.mIsLegendCustom = true;
    }

    public void setCustom(List<Integer> list, List<String> list2) {
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mColors = Utils.convertIntegers(list);
        this.mLabels = Utils.convertStrings(list2);
        this.mIsLegendCustom = true;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public LegendPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(LegendPosition legendPosition) {
        this.mPosition = legendPosition;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormSize(float f) {
        this.mFormSize = Utils.convertDpToPixel(f);
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public void setXEntrySpace(float f) {
        this.mXEntrySpace = Utils.convertDpToPixel(f);
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public void setYEntrySpace(float f) {
        this.mYEntrySpace = Utils.convertDpToPixel(f);
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public void setFormToTextSpace(float f) {
        this.mFormToTextSpace = Utils.convertDpToPixel(f);
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public void setStackSpace(float f) {
        this.mStackSpace = f;
    }

    public float getFullWidth(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                if (this.mColors[i] != 1122868) {
                    f += this.mFormSize + this.mFormToTextSpace;
                }
                f += (float) Utils.calcTextWidth(paint, this.mLabels[i]);
                if (i < this.mLabels.length - 1) {
                    f += this.mXEntrySpace;
                }
            } else {
                f += this.mFormSize;
                if (i < this.mLabels.length - 1) {
                    f += this.mStackSpace;
                }
            }
        }
        return f;
    }

    public float getFullHeight(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                f += (float) Utils.calcTextHeight(paint, this.mLabels[i]);
                if (i < this.mLabels.length - 1) {
                    f += this.mYEntrySpace;
                }
            }
        }
        return f;
    }

    public void setWordWrapEnabled(boolean z) {
        this.mWordWrapEnabled = z;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public void setMaxSizePercent(float f) {
        this.mMaxSizePercent = f;
    }

    public FSize[] getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public Boolean[] getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public FSize[] getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0146 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateDimensions(android.graphics.Paint r19, com.github.mikephil.charting.utils.ViewPortHandler r20) {
        /*
            r18 = this;
            r0 = r18
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            if (r1 == r2) goto L_0x01a3
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r1 == r2) goto L_0x01a3
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r1 == r2) goto L_0x01a3
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r1 == r2) goto L_0x01a3
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.PIECHART_CENTER
            if (r1 != r2) goto L_0x0022
            goto L_0x01a3
        L_0x0022:
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r1 == r2) goto L_0x005f
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r1 == r2) goto L_0x005f
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r1 == r2) goto L_0x005f
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r1 == r2) goto L_0x005f
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r1 == r2) goto L_0x005f
            com.github.mikephil.charting.components.Legend$LegendPosition r1 = r0.mPosition
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r1 != r2) goto L_0x0047
            goto L_0x005f
        L_0x0047:
            float r1 = r18.getFullWidth(r19)
            r0.mNeededWidth = r1
            float r1 = r18.getMaximumEntryHeight(r19)
            r0.mNeededHeight = r1
            float r1 = r18.getMaximumEntryWidth(r19)
            r0.mTextWidthMax = r1
            float r1 = r0.mNeededHeight
            r0.mTextHeightMax = r1
            goto L_0x01bb
        L_0x005f:
            java.lang.String[] r1 = r0.mLabels
            int r1 = r1.length
            float r2 = com.github.mikephil.charting.utils.Utils.getLineHeight(r19)
            float r3 = com.github.mikephil.charting.utils.Utils.getLineSpacing(r19)
            float r4 = r0.mYEntrySpace
            float r3 = r3 + r4
            float r4 = r20.contentWidth()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r1)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r1)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = -1
            r14 = 0
            r15 = 0
        L_0x0086:
            if (r11 >= r1) goto L_0x014d
            int[] r10 = r0.mColors
            r10 = r10[r11]
            r9 = 1122868(0x112234, float:1.573473E-39)
            if (r10 == r9) goto L_0x0093
            r9 = 1
            goto L_0x0094
        L_0x0093:
            r9 = 0
        L_0x0094:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r8)
            r6.add(r10)
            r10 = -1
            if (r13 != r10) goto L_0x00a0
            r10 = 0
            goto L_0x00a3
        L_0x00a0:
            float r10 = r0.mStackSpace
            float r10 = r10 + r14
        L_0x00a3:
            java.lang.String[] r14 = r0.mLabels
            r14 = r14[r11]
            if (r14 == 0) goto L_0x00cd
            java.lang.String[] r14 = r0.mLabels
            r14 = r14[r11]
            r8 = r19
            com.github.mikephil.charting.utils.FSize r14 = com.github.mikephil.charting.utils.Utils.calcTextSize(r8, r14)
            r5.add(r14)
            if (r9 == 0) goto L_0x00be
            float r9 = r0.mFormToTextSpace
            float r14 = r0.mFormSize
            float r9 = r9 + r14
            goto L_0x00bf
        L_0x00be:
            r9 = 0
        L_0x00bf:
            float r10 = r10 + r9
            java.lang.Object r9 = r5.get(r11)
            com.github.mikephil.charting.utils.FSize r9 = (com.github.mikephil.charting.utils.FSize) r9
            float r9 = r9.width
            float r10 = r10 + r9
            r17 = r3
        L_0x00cb:
            r14 = r10
            goto L_0x00e6
        L_0x00cd:
            r8 = r19
            com.github.mikephil.charting.utils.FSize r14 = new com.github.mikephil.charting.utils.FSize
            r17 = r3
            r3 = 0
            r14.<init>(r3, r3)
            r5.add(r14)
            if (r9 == 0) goto L_0x00df
            float r3 = r0.mFormSize
            goto L_0x00e0
        L_0x00df:
            r3 = 0
        L_0x00e0:
            float r10 = r10 + r3
            r3 = -1
            if (r13 != r3) goto L_0x00cb
            r14 = r10
            r13 = r11
        L_0x00e6:
            java.lang.String[] r3 = r0.mLabels
            r3 = r3[r11]
            if (r3 != 0) goto L_0x00f4
            int r3 = r1 + -1
            if (r11 != r3) goto L_0x00f1
            goto L_0x00f4
        L_0x00f1:
            r3 = 0
            r9 = -1
            goto L_0x013f
        L_0x00f4:
            r3 = 0
            int r9 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x00fb
            r10 = 0
            goto L_0x00fd
        L_0x00fb:
            float r10 = r0.mXEntrySpace
        L_0x00fd:
            boolean r9 = r0.mWordWrapEnabled
            if (r9 == 0) goto L_0x012b
            int r9 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r9 == 0) goto L_0x012b
            float r9 = r4 - r15
            float r16 = r10 + r14
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x010e
            goto L_0x012b
        L_0x010e:
            com.github.mikephil.charting.utils.FSize r9 = new com.github.mikephil.charting.utils.FSize
            r9.<init>(r15, r2)
            r7.add(r9)
            float r12 = java.lang.Math.max(r12, r15)
            r9 = -1
            if (r13 <= r9) goto L_0x0120
            r10 = r13
        L_0x011e:
            r15 = 1
            goto L_0x0122
        L_0x0120:
            r10 = r11
            goto L_0x011e
        L_0x0122:
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            r6.set(r10, r15)
            r10 = r14
            goto L_0x012e
        L_0x012b:
            r9 = -1
            float r10 = r10 + r14
            float r10 = r10 + r15
        L_0x012e:
            int r15 = r1 + -1
            if (r11 != r15) goto L_0x013e
            com.github.mikephil.charting.utils.FSize r15 = new com.github.mikephil.charting.utils.FSize
            r15.<init>(r10, r2)
            r7.add(r15)
            float r12 = java.lang.Math.max(r12, r10)
        L_0x013e:
            r15 = r10
        L_0x013f:
            java.lang.String[] r10 = r0.mLabels
            r10 = r10[r11]
            if (r10 == 0) goto L_0x0146
            r13 = -1
        L_0x0146:
            int r11 = r11 + 1
            r3 = r17
            r8 = 0
            goto L_0x0086
        L_0x014d:
            r8 = r19
            r17 = r3
            int r1 = r5.size()
            com.github.mikephil.charting.utils.FSize[] r1 = new com.github.mikephil.charting.utils.FSize[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            com.github.mikephil.charting.utils.FSize[] r1 = (com.github.mikephil.charting.utils.FSize[]) r1
            r0.mCalculatedLabelSizes = r1
            int r1 = r6.size()
            java.lang.Boolean[] r1 = new java.lang.Boolean[r1]
            java.lang.Object[] r1 = r6.toArray(r1)
            java.lang.Boolean[] r1 = (java.lang.Boolean[]) r1
            r0.mCalculatedLabelBreakPoints = r1
            int r1 = r7.size()
            com.github.mikephil.charting.utils.FSize[] r1 = new com.github.mikephil.charting.utils.FSize[r1]
            java.lang.Object[] r1 = r7.toArray(r1)
            com.github.mikephil.charting.utils.FSize[] r1 = (com.github.mikephil.charting.utils.FSize[]) r1
            r0.mCalculatedLineSizes = r1
            float r1 = r18.getMaximumEntryWidth(r19)
            r0.mTextWidthMax = r1
            float r1 = r18.getMaximumEntryHeight(r19)
            r0.mTextHeightMax = r1
            r0.mNeededWidth = r12
            com.github.mikephil.charting.utils.FSize[] r1 = r0.mCalculatedLineSizes
            int r1 = r1.length
            float r1 = (float) r1
            float r2 = r2 * r1
            com.github.mikephil.charting.utils.FSize[] r1 = r0.mCalculatedLineSizes
            int r1 = r1.length
            if (r1 != 0) goto L_0x0196
            r8 = 0
            goto L_0x019c
        L_0x0196:
            com.github.mikephil.charting.utils.FSize[] r1 = r0.mCalculatedLineSizes
            int r1 = r1.length
            r3 = 1
            int r8 = r1 + -1
        L_0x019c:
            float r1 = (float) r8
            float r3 = r17 * r1
            float r2 = r2 + r3
            r0.mNeededHeight = r2
            goto L_0x01bb
        L_0x01a3:
            r8 = r19
            float r1 = r18.getMaximumEntryWidth(r19)
            r0.mNeededWidth = r1
            float r1 = r18.getFullHeight(r19)
            r0.mNeededHeight = r1
            float r1 = r0.mNeededWidth
            r0.mTextWidthMax = r1
            float r1 = r18.getMaximumEntryHeight(r19)
            r0.mTextHeightMax = r1
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.calculateDimensions(android.graphics.Paint, com.github.mikephil.charting.utils.ViewPortHandler):void");
    }
}
