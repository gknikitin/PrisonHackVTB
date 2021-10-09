package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class CombinedChartRenderer extends DataRenderer {
    protected List<DataRenderer> mRenderers;

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        createRenderers(combinedChart, chartAnimator, viewPortHandler);
    }

    /* access modifiers changed from: protected */
    public void createRenderers(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        this.mRenderers = new ArrayList();
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            switch (drawOrder) {
                case BAR:
                    if (combinedChart.getBarData() == null) {
                        break;
                    } else {
                        this.mRenderers.add(new BarChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                        break;
                    }
                case BUBBLE:
                    if (combinedChart.getBubbleData() == null) {
                        break;
                    } else {
                        this.mRenderers.add(new BubbleChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                        break;
                    }
                case LINE:
                    if (combinedChart.getLineData() == null) {
                        break;
                    } else {
                        this.mRenderers.add(new LineChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                        break;
                    }
                case CANDLE:
                    if (combinedChart.getCandleData() == null) {
                        break;
                    } else {
                        this.mRenderers.add(new CandleStickChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                        break;
                    }
                case SCATTER:
                    if (combinedChart.getScatterData() == null) {
                        break;
                    } else {
                        this.mRenderers.add(new ScatterChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                        break;
                    }
            }
        }
    }

    public void initBuffers() {
        for (DataRenderer initBuffers : this.mRenderers) {
            initBuffers.initBuffers();
        }
    }

    public void drawData(Canvas canvas) {
        for (DataRenderer drawData : this.mRenderers) {
            drawData.drawData(canvas);
        }
    }

    public void drawValues(Canvas canvas) {
        for (DataRenderer drawValues : this.mRenderers) {
            drawValues.drawValues(canvas);
        }
    }

    public void drawExtras(Canvas canvas) {
        for (DataRenderer drawExtras : this.mRenderers) {
            drawExtras.drawExtras(canvas);
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (DataRenderer drawHighlighted : this.mRenderers) {
            drawHighlighted.drawHighlighted(canvas, highlightArr);
        }
    }

    public void calcXBounds(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, int i) {
        for (DataRenderer calcXBounds : this.mRenderers) {
            calcXBounds.calcXBounds(barLineScatterCandleBubbleDataProvider, i);
        }
    }

    public DataRenderer getSubRenderer(int i) {
        if (i >= this.mRenderers.size() || i < 0) {
            return null;
        }
        return this.mRenderers.get(i);
    }

    public List<DataRenderer> getSubRenderers() {
        return this.mRenderers;
    }

    public void setSubRenderers(List<DataRenderer> list) {
        this.mRenderers = list;
    }
}
