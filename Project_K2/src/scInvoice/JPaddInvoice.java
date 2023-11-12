package scInvoice;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entites.CombinedData;
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
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;

public class JPaddInvoice extends JPanel {
	private JTextField jCustomerName;
	private JDateChooser jdateChooser;
	private JTextField jtextQuantily;
	private JTextField jtotal;
	private JComboBox jcomboBoxProductID;
	private JTable jtableListInvoice;
	private JPanel panel;
	private JLabel jcurrentQuantity;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPaddInvoice() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBorder(new TitledBorder(null, "Create Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);

		jtextQuantily = new JTextField();
		jtextQuantily.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextQuantily_keyReleased(e);
			}
		});
		jtextQuantily.setColumns(10);
		jtextQuantily.setBounds(299, 14, 50, 22);
		panel_1.add(jtextQuantily);

		((AbstractDocument) jtextQuantily.getDocument()).setDocumentFilter(new NumberDocumentFilter());

		JLabel lblQuantily = new JLabel("Quantily");
		lblQuantily.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblQuantily.setBounds(239, 11, 50, 26);
		panel_1.add(lblQuantily);

		JLabel ProductID = new JLabel("Product Name");
		ProductID.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		ProductID.setBounds(10, 11, 98, 26);
		panel_1.add(ProductID);

		jcomboBoxProductID = new JComboBox();
		jcomboBoxProductID.setBounds(94, 14, 124, 23);
		panel_1.add(jcomboBoxProductID);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Current Quantity");
		lblNewLabel_2_1_1.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1_1.setBounds(359, 11, 98, 26);
		panel_1.add(lblNewLabel_2_1_1);
		
		jcurrentQuantity = new JLabel("");
		jcurrentQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		jcurrentQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jcurrentQuantity.setBounds(455, 10, 65, 26);
		panel_1.add(jcurrentQuantity);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 47, 599, 148);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(172, 100, 61, 23);
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 10));
		panel_3.add(btnNewButton);
		
				jtotal = new JTextField();
				jtotal.setBounds(95, 101, 67, 20);
				panel_3.add(jtotal);
				jtotal.setEditable(false);
				jtotal.setColumns(10);
				
						jdateChooser = new JDateChooser();
						jdateChooser.setBounds(95, 50, 138, 22);
						panel_3.add(jdateChooser);
						jdateChooser.setDateFormatString("dd/MM/yyyy");
						
								JLabel lblInvoiceDate = new JLabel("Invoice Date");
								lblInvoiceDate.setBounds(0, 50, 86, 26);
								panel_3.add(lblInvoiceDate);
								lblInvoiceDate.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
								
										JLabel lblNewLabel_2 = new JLabel("Customer Phone");
										lblNewLabel_2.setBounds(0, 0, 98, 26);
										panel_3.add(lblNewLabel_2);
										lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
										
												jCustomerName = new JTextField();
												jCustomerName.setBounds(95, 4, 138, 22);
												panel_3.add(jCustomerName);
												jCustomerName.setColumns(10);
												
												JLabel lblTotal = new JLabel("Total");
												lblTotal.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
												lblTotal.setBounds(0, 97, 54, 26);
												panel_3.add(lblTotal);
												
												JScrollPane scrollPane_1 = new JScrollPane();
												scrollPane_1.setBounds(264, 0, 325, 130);
												panel_3.add(scrollPane_1);
												
												table = new JTable();
												scrollPane_1.setViewportView(table);
												
												JButton btnNewButton_1 = new JButton("Add");
												btnNewButton_1.setBounds(530, 14, 58, 23);
												panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBorder(new TitledBorder(null, "List Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 192, 203), 3));
		scrollPane.setBounds(29, 21, 538, 162);
		panel_2.add(scrollPane);

		jtableListInvoice = new JTable();
		jtableListInvoice.setBorder(new LineBorder(new Color(255, 240, 245), 2));
		jtableListInvoice.setBackground(new Color(255, 240, 245));
		jtableListInvoice.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(jtableListInvoice);

		JButton btnNewButton_2 = new JButton("Huy hoa don");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(479, 181, 85, 21);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Recieve");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(395, 181, 85, 21);
		panel_2.add(btnNewButton_3);
		initJFrame();
	}

	public void initJFrame() {

		Calendar calendar = Calendar.getInstance(); // Lấy ngày tháng năm hiện tại
		Date currentDate = calendar.getTime(); // Chuyển Calendar sang Date
		jdateChooser.setDate(currentDate);
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(0);
		model.addElement(1);

		DefaultComboBoxModel<Products> models = new DefaultComboBoxModel<Products>();
		Product_model product_model = new Product_model();
		Products products = new Products();
		for (Products product : product_model.findAll()) {
			models.addElement(product);
		}
		jcomboBoxProductID.setModel(models);
		jcomboBoxProductID.setRenderer(new ProductCellRender());
		Sales_model sales_model = new Sales_model();
		Invoice_model invoice_model = new Invoice_model();
		fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
	}

	public class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}

	}

//	protected void do_jcomboBoxProductID_actionPerformed(ActionEvent e) {
//		Object selectedProduct = jcomboBoxProductID.getSelectedItem();
//		Products product = (Products) selectedProduct;
//		jProductPrice.setText(product.getPrice().toString());
//		jcurrentQuantity.setText(String.valueOf(product.getQuantity()));
//
//	}
//
	protected void do_jtextQuantily_keyReleased(KeyEvent e) {
		try {
			double quantily = Double.parseDouble(jtextQuantily.getText());
			double total = quantily * Double.parseDouble("2");
			jtotal.setText(String.valueOf(total));
		} catch (Exception e2) {

		}
	}

	public void fillDataToJTable(List<Sales> sales, List<Invoices> invoices) {
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		// Thêm cột cho JTable
		model.addColumn("ID");
		model.addColumn("Invoice Date");
		model.addColumn("Customer Name");
		model.addColumn("Product Name");
		model.addColumn("Quantity");
		model.addColumn("Total");
		model.addColumn("Status");

		// Tạo danh sách tạm thời để lưu thông tin sáp nhập từ Sales và Invoices
		List<CombinedData> combinedDataList = new ArrayList<CombinedData>();
		Product_model product_model = new Product_model();

		for (Sales sale : sales) {
			CombinedData combinedData = new CombinedData(sale.getSaleID(), null, // Để trống Invoice Date
					null, // Để trống Customer Name
					sale.getProductID(), sale.getQuantity(), sale.getPrice());

			combinedDataList.add(combinedData);
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		jtableListInvoice.getTableHeader().setReorderingAllowed(false);
		jtableListInvoice.setModel(model);
		// Lấy ra model của cột từ JTable
		TableColumnModel columnModel = jtableListInvoice.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn customerNameColumn = columnModel.getColumn(2); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(200); // Chiều rộng tối đa

		// Lấy ra cột "Product Name" và thiết lập chiều rộng
		TableColumn productNameColumn = columnModel.getColumn(3); // Cột "Product Name" ở index 3
		productNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		productNameColumn.setMaxWidth(200); // Chiều rộng tối đa
		
		TableColumn DateNameColumn = columnModel.getColumn(1); // Cột "Product Name" ở index 3
		DateNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		DateNameColumn.setMaxWidth(200); // Chiều rộng tối đa

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	

//	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
//		int result = JOptionPane.showConfirmDialog(null, "Are you sure", "Confirm", JOptionPane.YES_NO_OPTION);
//		int selectedIndex = jtableListInvoice.getSelectedRow();
//		int id = Integer.parseInt(jtableListInvoice.getValueAt(selectedIndex, 0).toString());
//		Invoice_model invoice_model = new Invoice_model();
//		Sales_model sales_model = new Sales_model();
//		Invoices invoices = new Invoices();
//		invoices.setStatus(true);
//		if (invoice_model.update(invoices)) {
//			JOptionPane.showMessageDialog(null, "Success");
//			fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
//		}
//
//	}

	class NumberDocumentFilter extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			// Kiểm tra xem chuỗi được thêm vào có chứa chỉ số hay không
			if (string.matches("^[0-9]*$")) {
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			// Kiểm tra xem chuỗi thay thế có chứa chỉ số hay không
			if (text.matches("^[0-9]*$")) {
				super.replace(fb, offset, length, text, attrs);
			}
		}
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		panel.removeAll();
		panel.revalidate();
		JPContact jpContact = new JPContact() ;
		panel.add(jpContact);
		panel.setVisible(true);
	}
}


