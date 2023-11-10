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
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
		 YearMonth yearMonth = YearMonth.of(2023,jmonthChooser.getMonth());
	        long daysInMonth = ChronoUnit.DAYS.between(yearMonth.atDay(1), yearMonth.atEndOfMonth()) + 1;
	    Category_model category_model = new Category_model();
	    Invoice_model invoice_model = new Invoice_model();

	    List<Double> totals = invoice_model.findtotal();

	   
	    double[] valuesArray =

	    for (int i = 0; i < daysInMonth; i++) {
	        if (totals.size()>i) {
	        	 Double total = totals.get(i);
	        	 valuesArray[i] = total;
			}
	       

	        categoriesArray[i] = category.getCategoryName();
	       
	    }

	    String namechart = "Biểu đồ doanh số theo danh mục trong tháng 10";
	    int x = JFrameLogin.frameWidth - 140;
	    int y = JFrameLogin.frameHeight - 400;
	    Chartbar Chartbar=new Chartbar(namechart, categoriesArray,"USD", "Category", x, y, valuesArray);
	    jpanel_1.removeAll();
	    jpanel_1.revalidate();
	    jpanel_1.add(Chartbar);
	    jpanel_1.setVisible(true);
	}

	
}
