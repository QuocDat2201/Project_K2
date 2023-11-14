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
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

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
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_actionPerformed(e);
			}
		});
		panel_2.add(comboBox);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(JPChartProduct.class.getResource("/Icon/4781817_brows_browsing_find_search_seo_icon.png")));
		panel_2.add(btnNewButton);
		
		jmonthChooser = new JMonthChooser();
		jmonthChooser.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				do_jmonthChooser_ancestorAdded(event);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_2.add(jmonthChooser);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		jpanel_1. setLayout(new BorderLayout());;
		
		 iniJrame();
		 
	}
	private void iniJrame() {
		DefaultComboBoxModel<Products> models = new DefaultComboBoxModel<Products>();
		Product_model product_model = new Product_model();
		for (Products product : product_model.findAll()) {
			models.addElement(product);
		}
		comboBox.setModel(models);
		comboBox.setRenderer(new ProductCellRender());

	}
private void fill(String name,int month) {
	try {	
    Invoice_model invoice_model1 = new Invoice_model();
    Products products2 = (Products) comboBox.getSelectedItem();
    Map<String, Object> map = invoice_model1.findProductMap(name,month);
	String[] dates2 = new String[31];
    double[] valuesArray = new double[30];
    String[] nameStrings = new String[31];
    if (map!=null) {
    
       
    		List<Date> dates = (List<Date>) map.get("dates");
    		   
    	    List<Double> values = (List<Double>) map.get("values");
    	   
//    	    List<String> nameProduct = (List<String>) map.get("nameproducts");
    	    

    	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

    	    for (int i = 0; i < 30; i++) {
    	        dates2[i] = String.valueOf(i + 1);
    	        valuesArray[i] = 0;
    	        for (int j = 0; j < dates.size(); j++){
    	            if (i+1 == Integer.valueOf(dateFormat.format(dates.get(j)))){	               
    	                valuesArray[i] = values.get(j);	       
    	            }
    	        }	                 
    	    }

	} else {
		for (int i = 0; i < 30; i++) {
	        dates2[i] = String.valueOf(i + 1);
	        valuesArray[i] = 0;
	       	                 
	    }
	}
    
	
    
    String namechart = "Biểu đồ doanh số cua san pham " + products2.getProductName() + " trong tháng " + month;
    int x = JFrameLogin.frameWidth - 140;
    int y = JFrameLogin.frameHeight - 400;
    
    a sA = new a(namechart, dates2, x, y, valuesArray);
    
    // Xóa và cập nhật panel
     SwingUtilities.invokeLater(() -> {
        jpanel_1.removeAll();
        jpanel_1.add(sA);
        jpanel_1.revalidate();
        jpanel_1.repaint();
    });
	} catch (Exception e) {
 		// TODO: handle exception
		e.printStackTrace();
 	}
}
private class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}

	}

	
	protected void do_comboBox_actionPerformed(ActionEvent e) {
		Products products2 = (Products) comboBox.getSelectedItem();
		String nameString=products2.getProductName();
		int month=	Integer.valueOf(jmonthChooser.getMonth()+1);
		fill(nameString, month);
	}
	protected void do_jmonthChooser_ancestorAdded(AncestorEvent event) {
		Products products2 = (Products) comboBox.getSelectedItem();
		String nameString=products2.getProductName();
		int month=	Integer.valueOf(jmonthChooser.getMonth()+1);
		fill(nameString, month);
	}
}
