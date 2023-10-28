package screen;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.StrokeSample;
import org.jfree.chart.ui.PaintSample;
public class SwingChartExample extends JFrame {
	/**
	 * @wbp.nonvisual location=51,169
	 */
	private final StrokeSample strokeSample = new StrokeSample((Stroke) null);
	/**
	 * @wbp.nonvisual location=44,229
	 */
	private final PaintSample paintSample = new PaintSample((Paint) null);

    public SwingChartExample() {
        super("Biểu đồ Swing Example");

        // Tạo biểu đồ
        JFreeChart chart = createChart(createDataset());

        // Hiển thị biểu đồ trong JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(100, 80));
        chartPanel.setMouseWheelEnabled(true);

        // Thêm JPanel vào JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(chartPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Category 1", "Data 1");
        dataset.addValue(2.0, "Category 2", "Data 2");
        dataset.addValue(3.0, "Category 3", "Data 3");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
            "Biểu đồ dạng cột",
            "Category",
            "Valueadasfsdg",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingChartExample example = new SwingChartExample();
            example.setVisible(true);
        });
    }
}

