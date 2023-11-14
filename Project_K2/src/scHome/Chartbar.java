package scHome;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chartbar extends JPanel {

    public Chartbar(String chartName, String[] categories, String unit, String legend, int width, int height, double[] values) {
        // Tạo biểu đồ
        JFreeChart chart = createChart(createDataset(categories, values), unit, chartName, legend);

        // Hiển thị biểu đồ trong JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(width, height));
        chartPanel.setMouseWheelEnabled(true);

        // Thêm JPanel vào JFrame
        setLayout(new BorderLayout());
        add(chartPanel);

        // Thiết lập giá trị cho cột trục x
        customizeXAxis();
    }

    private DefaultCategoryDataset createDataset(String[] categories, double[] values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < categories.length; i++) {
            dataset.addValue(values[i], categories[i], String.valueOf(i));
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String unit, String chartName, String legend) {
        return ChartFactory.createBarChart(
                chartName,
                legend,
                unit,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    private void customizeXAxis() {
        CategoryPlot plot = (CategoryPlot) getChart().getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Đặt kích thước của thanh cột (đơn vị là % của chiều rộng mỗi nhóm)
        renderer.setMaximumBarWidth(50);;// Đặt giá trị tùy ý, ví dụ 0.5 là 50%
        // Thay đổi vị trí nhãn trục x
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);

        // Thay đổi font cho nhãn trục x
        xAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 12));

        // Đặt khoảng cách giữa các nhãn trục x
        xAxis.setCategoryMargin(0.5); // Đặt giá trị tùy ý, ví dụ 0.5 là 50
    }


    private JFreeChart getChart() {
        return ((ChartPanel) getComponent(0)).getChart();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4"};
        double[] values = {10.0, 15.0, 7.0, 22.0};

        Chartbar chartBar = new Chartbar("Bar Chart Example", categories, "Unit", "Legend", 600, 400, values);
        frame.getContentPane().add(chartBar);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
