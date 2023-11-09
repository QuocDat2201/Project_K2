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
import java.util.List;

import javax.swing.JLabel;

public class bieudo extends JPanel {
	private JPanel jpanel_1;

	/**
	 * Create the panel.
	 */
	public bieudo() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Bieu do");
		panel_2.add(lblNewLabel);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		initJframe();
		
	}

	private void initJframe() {
		fill();
	}
	private void fill() {
	    Category_model category_model = new Category_model();
	    Invoice_model invoice_model = new Invoice_model();

	    List<Category> categories = category_model.findAll();
	    List<Double> totals = invoice_model.findtotal();

	    String[] categoriesArray = new String[categories.size()];
	    double[] valuesArray = new double[categories.size()];

	    for (int i = 0; i < categories.size(); i++) {
	        Category category = categories.get(i);
	        if (totals.size()>i) {
	        	 Double total = totals.get(i);
	        	 valuesArray[i] = total;
			}
	       

	        categoriesArray[i] = category.getCategoryName();
	       
	    }

	    String namechart = "Biểu đồ doanh số theo danh mục trong tháng 10";
	    int x = JFrameLogin.frameWidth - 140;
	    int y = JFrameLogin.frameHeight - 300;

	    Chartbar swingChartExample = new Chartbar(namechart, categoriesArray, "USD", "Category", x, y, valuesArray);
	    jpanel_1.add(swingChartExample);
	}

	
}
