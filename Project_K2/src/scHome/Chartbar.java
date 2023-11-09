package scHome;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chartbar extends JPanel {

    public Chartbar(String chartName, String[] catagory, String unit, String chuThich, int x, int y, double[] value) {
        // Tạo biểu đồ
        JFreeChart chart = createChart(createDataset(catagory, value), unit, chartName, chuThich);

        // Hiển thị biểu đồ trong JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(x, y));
        chartPanel.setMouseWheelEnabled(true);

        // Thêm JPanel vào JFrame
        setLayout(new BorderLayout());
        add(chartPanel);
    }

    private DefaultCategoryDataset createDataset(String[] catagory, double[] value) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < catagory.length; i++) {
            dataset.addValue(value[i], catagory[i], String.valueOf(i));
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String unit, String chartName, String chuThich) {
        return ChartFactory.createBarChart(
            chartName,
            chuThich,
            unit,
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
    }
}
