package scHome;
import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.TickUnit;
import org.jfree.data.category.CategoryDataset;


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

        // Thiết lập giá trị cho cột trục x
        setCategoryLabels(chart, catagory);
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

    private void setCategoryLabels(JFreeChart chart, String[] catagory) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();

        // Đặt vị trí và xoay nhãn của trục x
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Đặt font tùy chỉnh cho nhãn
        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));

        // Ẩn nhãn số mặc định của trục x
        domainAxis.setTickLabelsVisible(false);

        // Xóa tất cả các nhãn trục x hiện có
        domainAxis.clearCategoryLabels();

        // Thêm nhãn tùy chỉnh cho từng danh mục
        for (int i = 0; i < catagory.length; i++) {
            CategoryLabelTool tool = new CategoryLabelTool(i, catagory[i]);
            domainAxis.addCategoryLabelTool(tool);
        }
    }

    // ...

    class CategoryLabelTool implements CategoryLabelGenerator {
        private final int index;
        private final String label;

        public CategoryLabelTool(int index, String label) {
            this.index = index;
            this.label = label;
        }

        @Override
        public String generateLabel(CategoryDataset dataset, int row, int column) {
            return (column == index) ? label : "";
        }
    }



}
