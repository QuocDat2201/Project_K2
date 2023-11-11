package scHome;

import javax.swing.JPanel;

import entites.Category;
import models.Category_model;
import models.Invoice_model;
import screen.JFrameLogin;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

public class JPChartProduct extends JPanel {
	private JPanel jpanel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JMonthChooser jmonthChooser;

	/**
	 * Create the panel.
	 */
	public JPChartProduct() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(JPChartProduct.class.getResource("/Icon/4781817_brows_browsing_find_search_seo_icon.png")));
		panel_2.add(btnNewButton);
		
		jmonthChooser = new JMonthChooser();
		panel_2.add(jmonthChooser);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		jpanel_1. setLayout(new BorderLayout());;
		fill();
		
	}
	private void fill() {
	    Invoice_model invoice_model1 = new Invoice_model();
	    Map<String, List> map = invoice_model1.findProductMap();
	    List<Date> dates = map.get("dates");
	    String[] dates2 = new String[dates.size()];
	    List<Double> values = map.get("values");
	    double[] valuesArray = new double[values.size()];
	    List<String> nameProduct = map.get("nameproducts");
	    String[] nameStrings = new String[nameProduct.size()];

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    for (int i = 0; i < dates.size(); i++) {
	        dates2[i] = dateFormat.format(dates.get(i));
	        valuesArray[i] = values.get(i);
	        nameStrings[i] = nameProduct.get(i);
	    }

	    String namechart = "Biểu đồ doanh số theo danh mục trong tháng 10";
	    int x = JFrameLogin.frameWidth - 140;
	    int y = JFrameLogin.frameHeight - 400;
	    Chartbar chartBar = new Chartbar(namechart, dates2, "USD", "Category", x, y, valuesArray);
	    jpanel_1.removeAll();
	    jpanel_1.revalidate();
	    jpanel_1.add(chartBar);
	    jpanel_1.setVisible(true);
	}

	
}
