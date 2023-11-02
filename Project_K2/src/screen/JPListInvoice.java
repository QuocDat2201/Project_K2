package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entites.Invoices;
import entites.Products;
import entites.Sales;
import models.Invoice_model;
import models.Product_model;
import models.Sales_model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

public class JPListInvoice extends JPanel {
	private JTextField jCustomerName;
	private JDateChooser jdateChooser;
	private JComboBox jcomboBox;
	private JTextField jtextQuantily;
	private JTextField jtotal;
	private JComboBox jcomboBoxProductID;
	private JTextField jProductName;
	private JTextField jProductPrice;

	/**
	 * Create the panel.
	 */
	public JPListInvoice() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Create Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setBounds(24, 67, 98, 26);
		panel_1.add(lblInvoiceDate);

		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setBounds(24, 103, 98, 26);
		panel_1.add(lblNewLabel_2);

		jCustomerName = new JTextField();
		jCustomerName.setColumns(10);
		jCustomerName.setBounds(132, 106, 124, 22);
		panel_1.add(jCustomerName);

		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setBounds(24, 139, 98, 26);
		panel_1.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Create2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(132, 182, 85, 21);
		panel_1.add(btnNewButton);

		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(132, 71, 124, 22);
		jdateChooser.setDateFormatString("dd/MM/yyyy");
		panel_1.add(jdateChooser);

		jcomboBox = new JComboBox();
		jcomboBox.setBounds(132, 142, 43, 23);
		panel_1.add(jcomboBox);

		jtextQuantily = new JTextField();
		jtextQuantily.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextQuantily_keyReleased(e);
			}
		});
		jtextQuantily.setColumns(10);
		jtextQuantily.setBounds(398, 144, 124, 22);
		panel_1.add(jtextQuantily);

		JLabel lblQuantily = new JLabel("Quantily");
		lblQuantily.setBounds(290, 141, 98, 26);
		panel_1.add(lblQuantily);

		jtotal = new JTextField();
		jtotal.setColumns(10);
		jtotal.setBounds(398, 180, 124, 22);
		panel_1.add(jtotal);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(290, 177, 98, 26);
		panel_1.add(lblTotal);

		JLabel ProductID = new JLabel("ProductID");
		ProductID.setBounds(290, 31, 98, 26);
		panel_1.add(ProductID);

		jcomboBoxProductID = new JComboBox();
		jcomboBoxProductID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxProductID_actionPerformed(e);
			}
		});
		jcomboBoxProductID.setBounds(398, 34, 43, 23);
		panel_1.add(jcomboBoxProductID);

		jProductName = new JTextField();
		jProductName.setColumns(10);
		jProductName.setBounds(398, 70, 124, 23);
		panel_1.add(jProductName);

		JLabel lblNewLabel_1 = new JLabel("ProductName");
		lblNewLabel_1.setBounds(290, 67, 98, 26);
		panel_1.add(lblNewLabel_1);

		jProductPrice = new JTextField();
		jProductPrice.setColumns(10);
		jProductPrice.setBounds(398, 106, 124, 22);
		panel_1.add(jProductPrice);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(290, 103, 98, 26);
		panel_1.add(lblPrice);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		initJFrame();
	}

	public void initJFrame() {
		Calendar calendar = Calendar.getInstance(); // Lấy ngày tháng năm hiện tại
		Date currentDate = calendar.getTime(); // Chuyển Calendar sang Date
		jdateChooser.setDate(currentDate);
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(0);
		model.addElement(1);
		jcomboBox.setModel(model);

		DefaultComboBoxModel<Products> models = new DefaultComboBoxModel<Products>();
		Product_model product_model = new Product_model();
		Products products = new Products();
		for (Products product : product_model.findAll()) {
			models.addElement(product);
		}
		jcomboBoxProductID.setModel(models);
		jcomboBoxProductID.setRenderer(new ProductCellRender());

	}

	private class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductID(), index, isSelected, cellHasFocus);
		}

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			Object selectedProduct = jcomboBoxProductID.getSelectedItem();
			Products product = (Products) selectedProduct;
			int productID = product.getProductID();
			
			Sales_model sales_model = new Sales_model();
			Sales sales = new Sales();
			BigDecimal total = new BigDecimal(jtotal.getText());

			sales.setPrice(total);
			sales.setProductID(productID);
			sales.setQuantity(Integer.parseInt(jtextQuantily.getText()));
			
				
				int newSalesID = sales_model.getNewlyCreatedSalesID(sales); // Lấy ID của Sales mới tạo
				

				Invoice_model invoice_model = new Invoice_model();
				Invoices invoices = new Invoices();
				invoices.setSaleID(newSalesID);
				invoices.setCustomerName(jCustomerName.getText());
				invoices.setInvoiceDate(jdateChooser.getDate());
				if (Integer.parseInt(jcomboBox.getSelectedItem().toString()) == 1) {
					invoices.setStatus(true);
				} else {
					invoices.setStatus(false);
				}

				if (invoice_model.Create(invoices)) {
					JOptionPane.showMessageDialog(null, "Succes");
				} else {
					JOptionPane.showMessageDialog(null, "Faild");
				}
			 
			

		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	protected void do_jcomboBoxProductID_actionPerformed(ActionEvent e) {
		Object selectedProduct = jcomboBoxProductID.getSelectedItem();
		Products product = (Products) selectedProduct;
		jProductName.setText(product.getProductName());
		jProductPrice.setText(product.getPrice().toString());

	}

	protected void do_jtextQuantily_keyReleased(KeyEvent e) {
		double quantily = Double.parseDouble(jtextQuantily.getText());
		double total = quantily * Double.parseDouble(jProductPrice.getText());
		jtotal.setText(String.valueOf(total));
	}
}
