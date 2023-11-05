package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.TitledBorder;

import entites.Category;
import entites.Products;
import models.Category_model;
import models.Product_model;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditProduct extends JPanel {
	private JTextField JtextField_Name;
	private JTextField JtextField_Price;
	private JTextField JtextField_Quantity;
	private JTextField JtextField_Status;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Products products;
	
	public EditProduct() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Update Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Product");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 368, 24);
		panel.add(lblNewLabel);
		
		JLabel JLabel_name = new JLabel("Product's Name");
		JLabel_name.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_name.setBounds(79, 61, 228, 18);
		panel.add(JLabel_name);
		
		JtextField_Name = new JTextField();
		JtextField_Name.setBounds(79, 89, 228, 19);
		panel.add(JtextField_Name);
		JtextField_Name.setColumns(10);
		
		JLabel JLabel_price = new JLabel("Price");
		JLabel_price.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_price.setBounds(79, 118, 228, 18);
		panel.add(JLabel_price);
		
		JtextField_Price = new JTextField();
		JtextField_Price.setColumns(10);
		JtextField_Price.setBounds(79, 146, 228, 19);
		panel.add(JtextField_Price);
		
		JLabel JLabel_quantity = new JLabel("Quantity");
		JLabel_quantity.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_quantity.setBounds(79, 175, 228, 18);
		panel.add(JLabel_quantity);
		
		JtextField_Quantity = new JTextField();
		JtextField_Quantity.setColumns(10);
		JtextField_Quantity.setBounds(79, 202, 228, 19);
		panel.add(JtextField_Quantity);
		
		JLabel JLabel_status = new JLabel("Status");
		JLabel_status.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_status.setBounds(79, 232, 228, 18);
		panel.add(JLabel_status);
		
		JtextField_Status = new JTextField();
		JtextField_Status.setEditable(false);
		JtextField_Status.setColumns(10);
		JtextField_Status.setBounds(79, 260, 228, 19);
		panel.add(JtextField_Status);
		
		JComboBox JcomboBox_Category = new JComboBox();
		JcomboBox_Category.setBounds(79, 320, 228, 21);
		panel.add(JcomboBox_Category);
		
		JLabel JLabel_category = new JLabel("Category");
		JLabel_category.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_category.setBounds(79, 289, 228, 18);
		panel.add(JLabel_category);
		
		JButton JButton_Save = new JButton("Save");
		JButton_Save.setBounds(222, 380, 85, 21);
		panel.add(JButton_Save);
		
		JButton JButton_Cancel = new JButton("Cancel");
		JButton_Cancel.setBounds(127, 380, 85, 21);
		panel.add(JButton_Cancel);
		
	}
	
	public EditProduct(Map<String, Object> data) {
		this();
		this.data = data;
		initJPanel();
	}
	
	public void initJPanel() {
		Product_model product_model = new Product_model();
		DefaultComboBoxModel<Products> model = new DefaultComboBoxModel<Products>();
		
		
		products = product_model.find(Integer.parseInt(data.get("id").toString()));
		JtextField_Name.setText(products.getProductName());
		JtextField_Price.setText(String.valueOf(products.getPrice()));
		JtextField_Quantity.setText(String.valueOf(products.getQuantity()));
		boolean status = products.isStatus();
		
		System.out.println(status);
		if (status == true) {
			JtextField_Status.setText("Stocking");
		} else {
			JtextField_Status.setText("Out of Stock");
		}
	}
	
	
}
