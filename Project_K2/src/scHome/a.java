package scHome;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class a extends JPanel {

    public a(String chartTitle, String[] catagory, int x, int y, double[] valuet) {
        // Tạo dữ liệu cho biểu đồ
        DefaultCategoryDataset dataset = createDataset(catagory, valuet);

        // Tạo biểu đồ đường
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Day", // Tên trục X
                "USD", // Tên trục Y
                dataset,   // Dữ liệu
                PlotOrientation.VERTICAL, // Định dạng biểu đồ (có thể là HORIZONTAL)
                true,     // Có hiển thị legend (chú thích)
                true,
                false
        );

        // Hiển thị biểu đồ trong JPanel
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(x, y));
        setLayout(new BorderLayout());
        add(chartPanel);
    }

    private DefaultCategoryDataset createDataset(String[] catagory, double[] valuet) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 for (int i = 0; i < catagory.length; i++) {
     dataset.addValue(valuet[i],"Doanh Thu", catagory[i]);
 }

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Line Chart Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String []cate= {"a","b"};//Day
            double[] b= {0,1}; //value
    
            frame.add(new a("Example Line Chart",cate,400,200,b));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
