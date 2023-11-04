package screen;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.Value;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.StrokeSample;
import org.jfree.chart.ui.PaintSample;
public class SwingChartExample extends JPanel {
private double[] Value;
    public SwingChartExample(int x,int y,double[] value) {
        Value=value;
        // Tạo biểu đồ
        JFreeChart chart = createChart(createDataset());

        // Hiển thị biểu đồ trong JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(x, y));
        chartPanel.setMouseWheelEnabled(true);

        // Thêm JPanel vào JFrame
        setLayout(new BorderLayout());
        JPanel panel=new JPanel();
       add(panel,null);
       panel.add(chartPanel);

    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Value[0], "Category 1", "T1");
        dataset.addValue(Value[1], "Category 2", "T1");
        dataset.addValue(Value[2], "Category 1", "T2");
        dataset.addValue(Value[3], "Category 2", "T2");
        dataset.addValue(Value[4], "Category 1", "T3");
        dataset.addValue(Value[5], "Category 2", "T3");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
            "Biểu đồ doanh so",
            "Chu thich",
            "USD $",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
    }

}

