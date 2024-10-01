package DLWJ.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class CoordinatePainter extends JFrame {
    public CoordinatePainter(XYSeries series) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create a scatter plot
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot",
                "X-Axis", "Y-Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,  // Show legend
                true,  // Use tooltips
                false  // Configure chart for URLs (if needed)
        );

        // Customize the chart appearance
        chart.setBackgroundPaint(Color.white);

        // Add the chart to a panel and display
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public CoordinatePainter(XYSeriesCollection dataset) {
        // Create a scatter plot
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot",
                "X-Axis", "Y-Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,  // Show legend
                true,  // Use tooltips
                false  // Configure chart for URLs (if needed)
        );

        // Customize the chart appearance
        chart.setBackgroundPaint(Color.white);

        // Add the chart to a panel and display
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static XYSeries getXYSeries(Comparable key, double[][] pairs, int length) {
        XYSeries series = new XYSeries(key);
        for (int i = 0; i < length; i++) {
            series.add(pairs[i][0], pairs[i][1]);
        }
        return series;
    }

    public static void paint(XYSeriesCollection dataset) {
        SwingUtilities.invokeLater(() -> {
            CoordinatePainter example = new CoordinatePainter(dataset);
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }

    public static void paint(double[][] pairs, int length) {
        SwingUtilities.invokeLater(() -> {
            CoordinatePainter example = new CoordinatePainter(getXYSeries("Data1", pairs, length));
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
