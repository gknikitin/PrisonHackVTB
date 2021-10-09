package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class LegendRenderer extends Renderer {
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint = new Paint(1);

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        this.mLegendLabelPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        this.mLegendFormPaint = new Paint(1);
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
        this.mLegendFormPaint.setStrokeWidth(3.0f);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [com.github.mikephil.charting.data.ChartData, com.github.mikephil.charting.data.ChartData<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r12) {
        /*
            r11 = this;
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            boolean r0 = r0.isLegendCustom()
            if (r0 != 0) goto L_0x014a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 0
        L_0x0014:
            int r4 = r12.getDataSetCount()
            if (r3 >= r4) goto L_0x0112
            com.github.mikephil.charting.interfaces.datasets.IDataSet r4 = r12.getDataSetByIndex(r3)
            java.util.List r5 = r4.getColors()
            int r6 = r4.getEntryCount()
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IBarDataSet
            r8 = 1122868(0x112234, float:1.573473E-39)
            if (r7 == 0) goto L_0x006f
            r7 = r4
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r7
            boolean r9 = r7.isStacked()
            if (r9 == 0) goto L_0x006f
            java.lang.String[] r4 = r7.getStackLabels()
            r6 = 0
        L_0x003b:
            int r9 = r5.size()
            if (r6 >= r9) goto L_0x0059
            int r9 = r7.getStackSize()
            if (r6 >= r9) goto L_0x0059
            int r9 = r4.length
            int r9 = r6 % r9
            r9 = r4[r9]
            r0.add(r9)
            java.lang.Object r9 = r5.get(r6)
            r1.add(r9)
            int r6 = r6 + 1
            goto L_0x003b
        L_0x0059:
            java.lang.String r4 = r7.getLabel()
            if (r4 == 0) goto L_0x010e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r1.add(r4)
            java.lang.String r4 = r7.getLabel()
            r0.add(r4)
            goto L_0x010e
        L_0x006f:
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IPieDataSet
            if (r7 == 0) goto L_0x00ae
            java.util.List r7 = r12.getXVals()
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r4
            r9 = 0
        L_0x007a:
            int r10 = r5.size()
            if (r9 >= r10) goto L_0x0099
            if (r9 >= r6) goto L_0x0099
            int r10 = r7.size()
            if (r9 >= r10) goto L_0x0099
            java.lang.Object r10 = r7.get(r9)
            r0.add(r10)
            java.lang.Object r10 = r5.get(r9)
            r1.add(r10)
            int r9 = r9 + 1
            goto L_0x007a
        L_0x0099:
            java.lang.String r5 = r4.getLabel()
            if (r5 == 0) goto L_0x010e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r1.add(r5)
            java.lang.String r4 = r4.getLabel()
            r0.add(r4)
            goto L_0x010e
        L_0x00ae:
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
            r8 = 0
            if (r7 == 0) goto L_0x00e0
            r7 = r4
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r7
            int r9 = r7.getDecreasingColor()
            r10 = 1122867(0x112233, float:1.573472E-39)
            if (r9 == r10) goto L_0x00e0
            int r5 = r7.getDecreasingColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
            int r5 = r7.getIncreasingColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
            r0.add(r8)
            java.lang.String r4 = r4.getLabel()
            r0.add(r4)
            goto L_0x010e
        L_0x00e0:
            r4 = 0
        L_0x00e1:
            int r7 = r5.size()
            if (r4 >= r7) goto L_0x010e
            if (r4 >= r6) goto L_0x010e
            int r7 = r5.size()
            int r7 = r7 + -1
            if (r4 >= r7) goto L_0x00f9
            int r7 = r6 + -1
            if (r4 >= r7) goto L_0x00f9
            r0.add(r8)
            goto L_0x0104
        L_0x00f9:
            com.github.mikephil.charting.interfaces.datasets.IDataSet r7 = r12.getDataSetByIndex(r3)
            java.lang.String r7 = r7.getLabel()
            r0.add(r7)
        L_0x0104:
            java.lang.Object r7 = r5.get(r4)
            r1.add(r7)
            int r4 = r4 + 1
            goto L_0x00e1
        L_0x010e:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x0112:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            int[] r12 = r12.getExtraColors()
            if (r12 == 0) goto L_0x0140
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            java.lang.String[] r12 = r12.getExtraLabels()
            if (r12 == 0) goto L_0x0140
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            int[] r12 = r12.getExtraColors()
            int r3 = r12.length
        L_0x0129:
            if (r2 >= r3) goto L_0x0137
            r4 = r12[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            int r2 = r2 + 1
            goto L_0x0129
        L_0x0137:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            java.lang.String[] r12 = r12.getExtraLabels()
            java.util.Collections.addAll(r0, r12)
        L_0x0140:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            r12.setComputedColors(r1)
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            r12.setComputedLabels(r0)
        L_0x014a:
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            android.graphics.Typeface r12 = r12.getTypeface()
            if (r12 == 0) goto L_0x0157
            android.graphics.Paint r0 = r11.mLegendLabelPaint
            r0.setTypeface(r12)
        L_0x0157:
            android.graphics.Paint r12 = r11.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            float r0 = r0.getTextSize()
            r12.setTextSize(r0)
            android.graphics.Paint r12 = r11.mLegendLabelPaint
            com.github.mikephil.charting.components.Legend r0 = r11.mLegend
            int r0 = r0.getTextColor()
            r12.setColor(r0)
            com.github.mikephil.charting.components.Legend r12 = r11.mLegend
            android.graphics.Paint r0 = r11.mLegendLabelPaint
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r11.mViewPortHandler
            r12.calculateDimensions(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    public void renderLegend(Canvas canvas) {
        float f;
        FSize[] fSizeArr;
        Legend.LegendPosition legendPosition;
        int i;
        Boolean[] boolArr;
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        float f6;
        Legend.LegendDirection legendDirection;
        Boolean bool;
        float f7;
        Canvas canvas2 = canvas;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint) + this.mLegend.getYEntrySpace();
            float calcTextHeight = lineHeight - (((float) Utils.calcTextHeight(this.mLegendLabelPaint, "ABC")) / 2.0f);
            String[] labels = this.mLegend.getLabels();
            int[] colors = this.mLegend.getColors();
            float formToTextSpace = this.mLegend.getFormToTextSpace();
            float xEntrySpace = this.mLegend.getXEntrySpace();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float formSize = this.mLegend.getFormSize();
            float stackSpace = this.mLegend.getStackSpace();
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            Legend.LegendPosition position = this.mLegend.getPosition();
            int i3 = C05741.f65x7d277f6a[position.ordinal()];
            int i4 = ColorTemplate.COLOR_SKIP;
            float f8 = 0.0f;
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    float f9 = calcTextHeight;
                    float f10 = xEntrySpace;
                    float f11 = stackSpace;
                    Legend.LegendDirection legendDirection2 = direction;
                    float contentWidth = this.mViewPortHandler.contentWidth();
                    if (position == Legend.LegendPosition.BELOW_CHART_LEFT || position == Legend.LegendPosition.ABOVE_CHART_LEFT) {
                        f = xOffset + this.mViewPortHandler.contentLeft();
                        if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f += this.mLegend.mNeededWidth;
                        }
                    } else if (position == Legend.LegendPosition.BELOW_CHART_RIGHT || position == Legend.LegendPosition.ABOVE_CHART_RIGHT) {
                        f = this.mViewPortHandler.contentRight() - xOffset;
                        if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f -= this.mLegend.mNeededWidth;
                        }
                    } else {
                        f = (this.mViewPortHandler.contentLeft() + (contentWidth / 2.0f)) - (this.mLegend.mNeededWidth / 2.0f);
                    }
                    float f12 = f;
                    FSize[] calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                    FSize[] calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                    Boolean[] calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                    if (!(position == Legend.LegendPosition.ABOVE_CHART_LEFT || position == Legend.LegendPosition.ABOVE_CHART_RIGHT || position == Legend.LegendPosition.ABOVE_CHART_CENTER)) {
                        f8 = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                    }
                    int length = labels.length;
                    float f13 = f12;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = length;
                        if (i6 < calculatedLabelBreakPoints.length && calculatedLabelBreakPoints[i6].booleanValue()) {
                            f8 += lineHeight + lineSpacing;
                            f13 = f12;
                        }
                        if (f13 == f12 && position == Legend.LegendPosition.BELOW_CHART_CENTER && i5 < calculatedLineSizes.length) {
                            f13 += (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes[i5].width : -calculatedLineSizes[i5].width) / 2.0f;
                            i5++;
                        }
                        int i8 = i5;
                        boolean z = colors[i6] != 1122868;
                        boolean z2 = labels[i6] == null;
                        if (z) {
                            if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f13 -= formSize;
                            }
                            i = i6;
                            legendPosition = position;
                            boolArr = calculatedLabelBreakPoints;
                            fSizeArr = calculatedLineSizes;
                            drawForm(canvas2, f13, f8 + f9, i, this.mLegend);
                            if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f13 += formSize;
                            }
                        } else {
                            i = i6;
                            legendPosition = position;
                            boolArr = calculatedLabelBreakPoints;
                            fSizeArr = calculatedLineSizes;
                        }
                        if (!z2) {
                            if (z) {
                                f13 += legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -formToTextSpace : formToTextSpace;
                            }
                            if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f13 -= calculatedLabelSizes[i].width;
                            }
                            float f14 = f13;
                            drawLabel(canvas2, f14, f8 + lineHeight, labels[i]);
                            if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f14 += calculatedLabelSizes[i].width;
                            }
                            f13 = f14 + (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -f10 : f10);
                        } else {
                            f13 += legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -f11 : f11;
                        }
                        i6 = i + 1;
                        i5 = i8;
                        calculatedLabelBreakPoints = boolArr;
                        length = i7;
                        position = legendPosition;
                        calculatedLineSizes = fSizeArr;
                    }
                    return;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    if (position == Legend.LegendPosition.PIECHART_CENTER) {
                        float chartWidth = (this.mViewPortHandler.getChartWidth() / 2.0f) + ((direction == Legend.LegendDirection.LEFT_TO_RIGHT ? -this.mLegend.mTextWidthMax : this.mLegend.mTextWidthMax) / 2.0f);
                        f3 = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                        f2 = chartWidth;
                    } else {
                        if (position == Legend.LegendPosition.RIGHT_OF_CHART || position == Legend.LegendPosition.RIGHT_OF_CHART_CENTER || position == Legend.LegendPosition.RIGHT_OF_CHART_INSIDE) {
                            xOffset = this.mViewPortHandler.getChartWidth() - xOffset;
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                xOffset -= this.mLegend.mTextWidthMax;
                            }
                        } else if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            xOffset += this.mLegend.mTextWidthMax;
                        }
                        if (position == Legend.LegendPosition.RIGHT_OF_CHART || position == Legend.LegendPosition.LEFT_OF_CHART) {
                            f3 = this.mViewPortHandler.contentTop() + yOffset;
                        } else {
                            f3 = (position == Legend.LegendPosition.RIGHT_OF_CHART_CENTER || position == Legend.LegendPosition.LEFT_OF_CHART_CENTER) ? (this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f) : this.mViewPortHandler.contentTop() + yOffset;
                        }
                        f2 = xOffset;
                    }
                    float f15 = f3;
                    int i9 = 0;
                    float f16 = 0.0f;
                    boolean z3 = false;
                    while (i9 < labels.length) {
                        Boolean valueOf = Boolean.valueOf(colors[i9] != i4);
                        if (valueOf.booleanValue()) {
                            float f17 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f2 + f16 : f2 - (formSize - f16);
                            bool = valueOf;
                            i2 = i9;
                            f5 = f2;
                            f6 = stackSpace;
                            f4 = calcTextHeight;
                            legendDirection = direction;
                            drawForm(canvas2, f17, f15 + calcTextHeight, i2, this.mLegend);
                            f7 = legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? f17 + formSize : f17;
                        } else {
                            bool = valueOf;
                            i2 = i9;
                            f4 = calcTextHeight;
                            f5 = f2;
                            f6 = stackSpace;
                            legendDirection = direction;
                            f7 = f5;
                        }
                        if (labels[i2] != null) {
                            if (bool.booleanValue() && !z3) {
                                f7 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? formToTextSpace : -formToTextSpace;
                            } else if (z3) {
                                f7 = f5;
                            }
                            if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f7 -= (float) Utils.calcTextWidth(this.mLegendLabelPaint, labels[i2]);
                            }
                            if (!z3) {
                                drawLabel(canvas2, f7, f15 + lineHeight, labels[i2]);
                            } else {
                                f15 += lineHeight + lineSpacing;
                                drawLabel(canvas2, f7, f15 + lineHeight, labels[i2]);
                            }
                            f15 += lineHeight + lineSpacing;
                            f16 = 0.0f;
                        } else {
                            f16 += formSize + f6;
                            z3 = true;
                        }
                        i9 = i2 + 1;
                        direction = legendDirection;
                        stackSpace = f6;
                        f2 = f5;
                        calcTextHeight = f4;
                        i4 = ColorTemplate.COLOR_SKIP;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawForm(Canvas canvas, float f, float f2, int i, Legend legend) {
        if (legend.getColors()[i] != 1122868) {
            this.mLegendFormPaint.setColor(legend.getColors()[i]);
            float formSize = legend.getFormSize();
            float f3 = formSize / 2.0f;
            switch (legend.getForm()) {
                case CIRCLE:
                    canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
                    return;
                case SQUARE:
                    canvas.drawRect(f, f2 - f3, f + formSize, f2 + f3, this.mLegendFormPaint);
                    return;
                case LINE:
                    canvas.drawLine(f, f2, f + formSize, f2, this.mLegendFormPaint);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1 */
    static /* synthetic */ class C05741 {

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendPosition */
        static final /* synthetic */ int[] f65x7d277f6a = new int[Legend.LegendPosition.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b9 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendForm[] r0 = com.github.mikephil.charting.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64xfbec3b85 = r0
                r0 = 1
                int[] r1 = f64xfbec3b85     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f64xfbec3b85     // Catch:{ NoSuchFieldError -> 0x001f }
                com.github.mikephil.charting.components.Legend$LegendForm r3 = com.github.mikephil.charting.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f64xfbec3b85     // Catch:{ NoSuchFieldError -> 0x002a }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.github.mikephil.charting.components.Legend$LegendPosition[] r3 = com.github.mikephil.charting.components.Legend.LegendPosition.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f65x7d277f6a = r3
                int[] r3 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.github.mikephil.charting.components.Legend$LegendPosition r4 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.github.mikephil.charting.components.Legend$LegendPosition r3 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.PIECHART_CENTER     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f65x7d277f6a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.C05741.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }
}
