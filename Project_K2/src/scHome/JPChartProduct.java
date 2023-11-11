package scHome;

import javax.swing.JPanel;

import entites.Category;
import entites.Products;
import models.Category_model;
import models.Invoice_model;
import models.Product_model;
import screen.JFrameLogin;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import java.awt.geom.Area;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
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
	private JComboBox comboBox;

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
		
		comboBox = new JComboBox();
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
		DefaultComboBoxModel<Products> models = new DefaultComboBoxModel<Products>();
		Product_model product_model = new Product_model();
		Products products = new Products();
		for (Products product : product_model.findAll()) {
			models.addElement(product);
		}
		comboBox.setModel(models);
		comboBox.setRenderer(new ProductCellRender());
	    Invoice_model invoice_model1 = new Invoice_model();
	    Products products2=(Products) comboBox.getSelectedItem();
	    Map<String, List> map = invoice_model1.findProductMap(products2.getProductName(),Integer.valueOf(jmonthChooser.getMonth()));
	    List<Date> dates = map.get("dates");
	    String[] dates2 = new String[30];
	    List<Double> values = map.get("values");
	    double[] valuesArray = new double[30];
	    List<String> nameProduct = map.get("nameproducts");
	    String[] nameStrings = new String[30];

	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
	    
	    for (int i = 0; i < 30; i++) {
	    	dates2[i]=String.valueOf(i+1);
	    	for(int j=0;j < dates.size();j++) {
	    		if(i==Integer.valueOf(dateFormat.format(dates.get(j)))) {
	    			dates2[i] = dateFormat.format(dates.get(j));
			        valuesArray[i] = values.get(j);
			        nameStrings[i] = nameProduct.get(j);
	    		}
	    		
	    	}
	        
	    }

	    String namechart = "Biểu đồ doanh số cua san pham "+products2.getProductName()+"trong tháng "+jmonthChooser.getMonth();
	    int x = JFrameLogin.frameWidth - 140;
	    int y = JFrameLogin.frameHeight - 400;	    
	    a sA =new a(namechart,dates2, x, y, valuesArray);
	    jpanel_1.removeAll();
	    jpanel_1.revalidate();
	    jpanel_1.add(sA);
	    jpanel_1.setVisible(true);
	    
	}
	private class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}

	}

	
}
