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
import javax.swing.ImageIcon;

public class JPListInvoice extends JPanel {
	private JTextField jCustomerName;
	private JDateChooser jdateChooser;
	private JComboBox jcomboBox;
	private JTextField jtextQuantily;
	private JTextField jtotal;
	private JComboBox jcomboBoxProductID;
	private JTextField jProductPrice;
	private JTable jtableListInvoice;

	/**
	 * Create the panel.
	 */
	public JPListInvoice() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBorder(new TitledBorder(null, "Create Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblInvoiceDate.setBounds(330, 32, 98, 26);
		panel_1.add(lblInvoiceDate);

		JLabel lblNewLabel_2 = new JLabel("Customer Phone");
		lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(330, 64, 98, 26);
		panel_1.add(lblNewLabel_2);

		jCustomerName = new JTextField();
		jCustomerName.setColumns(10);
		jCustomerName.setBounds(438, 67, 124, 22);
//		jCustomerName.setBounds(438, 67, 124, 22);
		panel_1.add(jCustomerName);
		JButton btnaddButton = new JButton("");
		btnaddButton.setContentAreaFilled(false);
		btnaddButton.setBorderPainted(false);
		btnaddButton.setIcon(new ImageIcon(JPListInvoice.class.getResource("/Icon/39039_gtk_add_icon.png")));
		btnaddButton.setBounds(560, 67, 30, 22);
		panel_1.add(btnaddButton);
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(330, 100, 98, 26);
		panel_1.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(132, 182, 85, 21);
		panel_1.add(btnNewButton);

		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(438, 32, 124, 22);
		jdateChooser.setDateFormatString("dd/MM/yyyy");
		panel_1.add(jdateChooser);

		jcomboBox = new JComboBox();
		jcomboBox.setBounds(438, 105, 43, 23);
		panel_1.add(jcomboBox);

		jtextQuantily = new JTextField();
		jtextQuantily.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextQuantily_keyReleased(e);
			}
		});
		jtextQuantily.setColumns(10);
		jtextQuantily.setBounds(132, 106, 124, 22);
		panel_1.add(jtextQuantily);

		((AbstractDocument) jtextQuantily.getDocument()).setDocumentFilter(new NumberDocumentFilter());

		JLabel lblQuantily = new JLabel("Quantily");
		lblQuantily.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblQuantily.setBounds(24, 103, 98, 26);
		panel_1.add(lblQuantily);

		jtotal = new JTextField();
		jtotal.setEditable(false);
		jtotal.setColumns(10);
		jtotal.setBounds(132, 138, 124, 22);
		panel_1.add(jtotal);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblTotal.setBounds(24, 140, 98, 26);
		panel_1.add(lblTotal);

		JLabel ProductID = new JLabel("Product Name");
		ProductID.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		ProductID.setBounds(24, 32, 98, 26);
		panel_1.add(ProductID);

		jcomboBoxProductID = new JComboBox();
		jcomboBoxProductID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxProductID_actionPerformed(e);
			}
		});
		jcomboBoxProductID.setBounds(132, 34, 124, 23);
		panel_1.add(jcomboBoxProductID);

		jProductPrice = new JTextField();
		jProductPrice.setEditable(false);
		jProductPrice.setColumns(10);
		jProductPrice.setBounds(132, 67, 124, 22);
		panel_1.add(jProductPrice);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblPrice.setBounds(24, 68, 98, 26);
		panel_1.add(lblPrice);

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

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Stencil", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(483, 182, 85, 21);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(385, 181, 85, 21);
		panel_2.add(btnNewButton_2);
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
		Sales_model sales_model = new Sales_model();
		Invoice_model invoice_model = new Invoice_model();
		fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
	}

	private class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			if (jCustomerName.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Faildroi");
			} else {
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

					JOptionPane.showMessageDialog(null, "SuccesInvoices");
				} else {
					JOptionPane.showMessageDialog(null, "FaildInvoice");
				}

				fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
			}
		} catch (Exception e2) {

		}

	}

	protected void do_jcomboBoxProductID_actionPerformed(ActionEvent e) {
		Object selectedProduct = jcomboBoxProductID.getSelectedItem();
		Products product = (Products) selectedProduct;
		jProductPrice.setText(product.getPrice().toString());

	}

	protected void do_jtextQuantily_keyReleased(KeyEvent e) {
		try {
			double quantily = Double.parseDouble(jtextQuantily.getText());
			double total = quantily * Double.parseDouble(jProductPrice.getText());
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
		for (Invoices invoice : invoices) {
			// Tìm đối tượng CombinedData tương ứng dựa trên SaleID
			for (CombinedData combinedData : combinedDataList) {
				if (combinedData.getSaleID() == invoice.getSaleID()) {
					combinedData.setInvoiceDate(invoice.getInvoiceDate());
					combinedData.setCustomerName(invoice.getCustomerName());
					combinedData.setStatus(invoice.isStatus());
					break; // Thoát khỏi vòng lặp khi tìm thấy SaleID tương ứng
				}
			}
		}

		// Hiển thị dữ liệu từ danh sách CombinedData lên JTable
		for (CombinedData combinedData : combinedDataList) {
			model.addRow(new Object[] { combinedData.getSaleID(),
					(combinedData.getInvoiceDate() != null) ? simpleDateFormat.format(combinedData.getInvoiceDate())
							: "",
					combinedData.getCustomerName(), product_model.find(combinedData.getProductID()).getProductName(),
					combinedData.getQuantity(), combinedData.getPrice(),
					combinedData.isStatus() ? "Destroy" : "Live" });
		}
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

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure", "Confirm", JOptionPane.YES_NO_OPTION);
		int selectedIndex = jtableListInvoice.getSelectedRow();
		int id = Integer.parseInt(jtableListInvoice.getValueAt(selectedIndex, 0).toString());
		Invoice_model invoice_model = new Invoice_model();
		Sales_model sales_model = new Sales_model();
		if (result == JOptionPane.YES_OPTION) {
			if (invoice_model.delete(id)) {
				if (sales_model.delete(id)) {
					JOptionPane.showMessageDialog(null, "Succes");
					fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Faild");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
			}
		}

	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure", "Confirm", JOptionPane.YES_NO_OPTION);
		int selectedIndex = jtableListInvoice.getSelectedRow();
		int id = Integer.parseInt(jtableListInvoice.getValueAt(selectedIndex, 0).toString());
		Invoice_model invoice_model = new Invoice_model();
		Sales_model sales_model = new Sales_model();
		Invoices invoices = new Invoices();
		invoices.setSaleID(id);
		invoices.setStatus(true);
		if (invoice_model.update(invoices)) {
			JOptionPane.showMessageDialog(null, "Success");
			fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
		}

	}

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
}
