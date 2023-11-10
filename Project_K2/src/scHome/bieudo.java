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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

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
		
		JDateChooser JdateChooser = new JDateChooser();
		panel_2.add(JdateChooser);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		jpanel_1. setLayout(new BorderLayout());;
		fill();
		
	}
	private void fill() {
		System.out.println("avc");
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
	    int y = JFrameLogin.frameHeight - 400;
	    Chartbar Chartbar=new Chartbar(namechart, categoriesArray,"USD", "Category", x, y, valuesArray);
	    jpanel_1.removeAll();
	    jpanel_1.revalidate();
	    jpanel_1.add(Chartbar);
	    jpanel_1.setVisible(true);
	}

	
}
