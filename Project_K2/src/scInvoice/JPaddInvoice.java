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
import javax.swing.table.DefaultTableCellRenderer;
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
import entites.Customer;
import entites.Invoices;
import entites.Products;
import entites.Rank;
import entites.Sales;
import models.CustomerModel;
import models.Invoice_model;
import models.Product_model;
import models.RankModel;
import models.Sales_model;
import screen.PlacehoclderTextField;

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
import java.awt.Insets;

public class JPaddInvoice extends JPanel {
	private PlacehoclderTextField jCustomerphone;
	private JDateChooser jdateChooser;
	private PlacehoclderTextField jtextQuantily;
	private JTextField jtotal;
	private JComboBox jcomboBoxProductID;
	private JTable jtableListInvoice;
	private JPanel panel;
	private JTable jtable1;
	private List<Sales> invoiceItemList = new ArrayList<Sales>();
	private JScrollPane scrollPane_1;
	private JTextField jcurrentQuantity;
	private PlacehoclderTextField jNameCustomer;
	private Customer customer;

	/**
	 * Create the panel.
	 */
	public JPaddInvoice() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(232, 249, 255));
		panel_1.setBorder(new TitledBorder(null, "Create Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);

		jtextQuantily = new PlacehoclderTextField("quantity");
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
		jcomboBoxProductID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxProductID_actionPerformed(e);
			}
		});
		jcomboBoxProductID.setBounds(94, 14, 124, 23);
		panel_1.add(jcomboBoxProductID);

		JLabel lblNewLabel_2_1_1 = new JLabel("Current Quantity");
		lblNewLabel_2_1_1.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1_1.setBounds(359, 11, 98, 26);
		panel_1.add(lblNewLabel_2_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 38, 599, 157);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setBounds(192, 116, 62, 25);
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 10));
		panel_3.add(btnNewButton);

		jtotal = new JTextField();
		jtotal.setBounds(95, 116, 98, 26);
		panel_3.add(jtotal);
		jtotal.setEditable(false);
		jtotal.setColumns(10);

		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(95, 83, 159, 22);
		panel_3.add(jdateChooser);
		jdateChooser.setDateFormatString("dd/MM/yyyy");

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setBounds(0, 79, 86, 26);
		panel_3.add(lblInvoiceDate);
		lblInvoiceDate.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));

		JLabel lblNewLabel_2 = new JLabel("Customer Phone");
		lblNewLabel_2.setBounds(0, 46, 98, 26);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));

		jCustomerphone = new PlacehoclderTextField("input 10 number");
		jCustomerphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jCustomerName_keyReleased(e);
			}
		});
		((AbstractDocument) jCustomerphone.getDocument()).setDocumentFilter(new NumberDocumentFilter());
		jCustomerphone.setBounds(95, 50, 159, 22);
		panel_3.add(jCustomerphone);
		jCustomerphone.setColumns(10);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblTotal.setBounds(0, 115, 54, 26);
		panel_3.add(lblTotal);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(264, 11, 325, 130);
		panel_3.add(scrollPane_1);

		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Delete");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_2_actionPerformed(e);
			}
		});
		mntmNewMenuItem_2.setBackground(new Color(240, 240, 240));
		popupMenu_1.add(mntmNewMenuItem_2);

		jtable1 = new JTable();
		jtable1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(jtable1);

		JLabel lblNewLabel_2_1 = new JLabel("Customer Name");
		lblNewLabel_2_1.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2_1.setBounds(0, 10, 98, 26);
		panel_3.add(lblNewLabel_2_1);

		jNameCustomer = new PlacehoclderTextField("name customer");
		jNameCustomer.setColumns(10);
		jNameCustomer.setBounds(95, 13, 159, 22);
		panel_3.add(jNameCustomer);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(530, 11, 58, 26);
		panel_1.add(btnNewButton_1);

		jcurrentQuantity = new JTextField();
		jcurrentQuantity.setBackground(new Color(255, 255, 255));
		jcurrentQuantity.setEnabled(false);
		jcurrentQuantity.setBounds(456, 14, 50, 22);
		panel_1.add(jcurrentQuantity);
		jcurrentQuantity.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(232, 249, 255));
		panel_2.setBorder(new TitledBorder(null, "List Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 128)));
		scrollPane.setBounds(26, 22, 600, 150);
		panel_2.add(scrollPane);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("More");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		popupMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cancel");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		popupMenu.add(mntmNewMenuItem_1);

		jtableListInvoice = new JTable();
		jtableListInvoice.setBorder(new LineBorder(new Color(255, 240, 245), 2));
		jtableListInvoice.setBackground(new Color(251, 251, 251));
		jtableListInvoice.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jtableListInvoice.setComponentPopupMenu(popupMenu);
		scrollPane.setViewportView(jtableListInvoice);

		JButton btnNewButton_3 = new JButton("Recieve");
		btnNewButton_3.setBackground(new Color(0, 128, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(508, 177, 85, 21);
		panel_2.add(btnNewButton_3);
		jtable1.setComponentPopupMenu(popupMenu_1);
		initJFrame();
	}

	public void initJFrame() {

		Calendar calendar = Calendar.getInstance(); // Lấy ngày tháng năm hiện tại
		Date currentDate = calendar.getTime(); // Chuyển Calendar sang Date
		jdateChooser.setDate(currentDate);

		Sales_model sales_model = new Sales_model();
		Invoice_model invoice_model = new Invoice_model();
//		fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
		fillDataToJTable1(invoiceItemList);
		fillDataToJTable(invoice_model.findAll());

	}

	public class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}

	}

	public void fillDataToJTable(List<Invoices> invoicess) {
		DefaultComboBoxModel modela = new DefaultComboBoxModel();
		modela.addElement(0);
		modela.addElement(1);

		DefaultComboBoxModel<Products> modelsa = new DefaultComboBoxModel<Products>();
		Product_model product_modela = new Product_model();
		Products productsa = new Products();
		for (Products product : product_modela.findAll()) {
			modelsa.addElement(product);
		}
		jcomboBoxProductID.setModel(modelsa);
		jcomboBoxProductID.setRenderer(new ProductCellRender());
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		// Thêm cột cho JTable
		model.addColumn("ID");

		model.addColumn("Customer Name");
		model.addColumn("Customer Phone");
		model.addColumn("Total");
		model.addColumn("Invoice Date");
		model.addColumn("Status");
		// Tạo danh sách tạm thời để lưu thông tin sáp nhập từ Sales và Invoices
		List<CombinedData> combinedDataList = new ArrayList<CombinedData>();
		Product_model product_model = new Product_model();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Invoices invoi : invoicess) {
			model.addRow(new Object[] { invoi.getInvoiceID(), invoi.getCustomerName(), invoi.getCustomerPhone(),
					invoi.getTotal(),simpleDateFormat.format(invoi.getInvoiceDate()) , invoi.isStatus() ? "Confirm" : "Cancel" });

		}

	
		jtableListInvoice.getTableHeader().setReorderingAllowed(false);
		jtableListInvoice.setModel(model);
		 for (int i = 0; i < jtableListInvoice.getColumnCount(); i++) {
			 jtableListInvoice.getColumnModel().getColumn(i).setCellRenderer(new CustomColorRenderer());
         }
//		jtableListInvoice.setDefaultRenderer(Object.class,new ColoredCellRenderer());
		// Lấy ra model của cột từ JTable
		TableColumnModel columnModel = jtableListInvoice.getColumnModel();

		TableColumn customerNameColumn = columnModel.getColumn(0); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(30); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(30); // Chiều rộng tối đa

		TableColumn productNameColumn = columnModel.getColumn(1);
		productNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		productNameColumn.setMaxWidth(100); // Chiều rộng tối đa

		TableColumn DateNameColumn = columnModel.getColumn(2);
		DateNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		DateNameColumn.setMaxWidth(100); // Chiều rộng tối đa

	}

	public void fillDataToJTable1(List<Sales> sales) {
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		// Thêm cột cho JTable
		model.addColumn("STT");
		model.addColumn("Product Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Total");
		Product_model product_model = new Product_model();
		int sl = 0;
		for (Sales sale : sales) {
			sl++;
			model.addRow(new Object[] { sl, sale.getProductName(), sale.getPrice(), sale.getQuantity(),
					sale.getPrice().multiply(new BigDecimal(sale.getQuantity())) });
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		jtable1.getTableHeader().setReorderingAllowed(false);
		jtable1.setModel(model);
		
		// Lấy ra model của cột từ JTable
		TableColumnModel columnModel = jtable1.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn customerNameColumn = columnModel.getColumn(2); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(50); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(50); // Chiều rộng tối đa

		// Lấy ra cột "Product Name" và thiết lập chiều rộng
		TableColumn productNameColumn = columnModel.getColumn(3); // Cột "Product Name" ở index 3
		productNameColumn.setMinWidth(60); // Chiều rộng tối thiểu
		productNameColumn.setMaxWidth(60); // Chiều rộng tối đa

		TableColumn DateNameColumn = columnModel.getColumn(1);
		DateNameColumn.setMinWidth(80); // Chiều rộng tối thiểu
		DateNameColumn.setMaxWidth(200); // Chiều rộng tối đa
		TableColumn DateNameColumn0 = columnModel.getColumn(0); //
		DateNameColumn0.setMinWidth(35); // Chiều rộng tối thiểu
		DateNameColumn0.setMaxWidth(35); // Chiều rộng tối đa
		TableColumn DateNameColumn2 = columnModel.getColumn(4); //
		DateNameColumn2.setMinWidth(60); // Chiều rộng tối thiểu
		DateNameColumn2.setMaxWidth(60); // Chiều rộng tối đa

	}

	public void fillDataToJTable2(List<Sales> sales) {
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		// Thêm cột cho JTable
		model.addColumn("STT");
		model.addColumn("Product Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Total");
		Product_model product_model = new Product_model();
		int sl = 0;
		for (Sales sale : sales) {
			sl++;
			model.addRow(new Object[] { sl, sale.getProductName(), sale.getPrice(), sale.getQuantity(),
					sale.getPrice().multiply(new BigDecimal(sale.getQuantity())) });
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		jtableListInvoice.getTableHeader().setReorderingAllowed(false);
		jtableListInvoice.setModel(model);
		// Lấy ra model của cột từ JTable
		TableColumnModel columnModel = jtableListInvoice.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn customerNameColumn = columnModel.getColumn(1); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(30); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(300); // Chiều rộng tối đa

		// Lấy ra cột "Product Name" và thiết lập chiều rộng
		TableColumn productNameColumn = columnModel.getColumn(3); // Cột "Product Name" ở index 3
		productNameColumn.setMinWidth(60); // Chiều rộng tối thiểu
		productNameColumn.setMaxWidth(100); // Chiều rộng tối đa

		TableColumn DateNameColumn = columnModel.getColumn(2);
		DateNameColumn.setMinWidth(70); // Chiều rộng tối thiểu
		DateNameColumn.setMaxWidth(200); // Chiều rộng tối đa
		TableColumn DateNameColumn0 = columnModel.getColumn(0); //
		DateNameColumn0.setMinWidth(40); // Chiều rộng tối thiểu
		DateNameColumn0.setMaxWidth(40); // Chiều rộng tối đa
		TableColumn DateNameColumn2 = columnModel.getColumn(4); //
		DateNameColumn2.setMinWidth(60); // Chiều rộng tối thiểu
		DateNameColumn2.setMaxWidth(100); // Chiều rộng tối đa

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
		JPContact jpContact = new JPContact();
		panel.add(jpContact);
		panel.setVisible(true);
	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {// add invoiceItem
		Sales sales = new Sales();
		sales.setProductID(((Products) jcomboBoxProductID.getSelectedItem()).getProductID());
		sales.setProductName(((Products) jcomboBoxProductID.getSelectedItem()).getProductName());
		sales.setQuantity(Integer.valueOf(jtextQuantily.getText()));
		sales.setPrice(((Products) jcomboBoxProductID.getSelectedItem()).getPrice());
		int j = 0, flag = 0;

		for (Sales sales1 : invoiceItemList) {
			if (sales1.getProductName()
					.equalsIgnoreCase(((Products) jcomboBoxProductID.getSelectedItem()).getProductName())) {
				sales.setQuantity(sales.getQuantity() + sales1.getQuantity());
				invoiceItemList.set(j, sales);
				flag = 1;
				break;

			}

			j++;
		}
		if (flag == 0) {
			invoiceItemList.add(sales);
		} else {

		}

		fillDataToJTable1(invoiceItemList);
		BigDecimal sum = new BigDecimal(0);
		for (int i = 0; i < jtable1.getRowCount(); i++) {
			BigDecimal cellValue = (BigDecimal) jtable1.getValueAt(i, 4);
			sum = sum.add(cellValue);
		}
		jtotal.setText(String.valueOf(sum));

	}

	protected void do_jcomboBoxProductID_actionPerformed(ActionEvent e) {
		Products product = (Products) jcomboBoxProductID.getSelectedItem();
		jcurrentQuantity.setText(String.valueOf(product.getQuantity()));
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if (jCustomerphone.getText().length() == 10) {
			if (invoiceItemList.size() != 0) {
				Product_model product_modell = new Product_model();
				int quantititi = 0;
				for (Sales saless : invoiceItemList) {
					for (Products productss : product_modell.findAll()) {
						if (saless.getProductID() ==productss.getProductID() &&saless.getQuantity() > productss.getQuantity()) {
						
							JOptionPane.showMessageDialog(null, "product is out of stock");
							quantititi = 1;
							break;
						}
					}
				}
				if (quantititi == 0) {
					Invoice_model model = new Invoice_model();
					CustomerModel customerModel = new CustomerModel();
					Sales_model sales_model = new Sales_model();
					Sales sales;
					Customer customerr;
					Invoices invoice = new Invoices();
					int flag = 1;

					// tao hoa don
					if (jNameCustomer.getText().equalsIgnoreCase("")) {
						invoice.setCustomerName("Khach le");
					} else {
						invoice.setCustomerName(jNameCustomer.getText());
					}
					invoice.setCustomerPhone(jCustomerphone.getText());
					invoice.setInvoiceDate(jdateChooser.getDate());
					invoice.setStatus(true);
					invoice.setTotal(new BigDecimal(jtotal.getText()));
					if (model.Create(invoice)) {
						// tao sale
						for (int i = 0; i < invoiceItemList.size(); i++) {
							sales = invoiceItemList.get(i);
							int idInvoice = model.findAllsort().getInvoiceID();
							sales.setInvoice_id(idInvoice);
							if (sales_model.Create(sales)) {
								Product_model product_model = new Product_model();
								for (Products product : product_model.findAll()) {
									if (sales.getProductID() == product.getCategory_id()) {
										product.setQuantity(product.getQuantity() - sales.getQuantity());
										product_model.UpdateQuantity(product);
									}

								}
							} else {
								flag = 0;
								break;
							}
						}
					} else {
						flag = 0;

					}

					// tao customer
					customer.setPoint(
							Integer.valueOf((int) (customer.getPoint() + (Double.valueOf(jtotal.getText()) / 10))));

					int flagCreateCustomer = 0;
					for (Customer customert11 : customerModel.findAll()) {
						if (customert11.getPhoneString().equalsIgnoreCase(jCustomerphone.getText())) {
							customer.setNameString(jNameCustomer.getText());
							customerModel.Update(customer);
							flagCreateCustomer = 1;
							break;
						}
					}
					if (flagCreateCustomer == 0) {
			
						customerModel.create(customer);
					}

					if (flag == 1) {
						JOptionPane.showMessageDialog(null, "Success");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid");
					}
					customer = null;
					invoiceItemList.clear();
					fillDataToJTable1(invoiceItemList);
					jNameCustomer.setText("");
					jCustomerphone.setText("");
					jcurrentQuantity.setText("");
					jtextQuantily.setText("");
					jtotal.setText("");
					fillDataToJTable(model.findAll());
				}

			} else {
				JOptionPane.showMessageDialog(null, "item null");
			}
		} else {
			JOptionPane.showMessageDialog(null, "phone error");
		}

	}

	protected void do_jCustomerName_keyReleased(KeyEvent e) {

		if (jCustomerphone.getText().length() == 10) {
			CustomerModel model = new CustomerModel();
			RankModel rankModel = new RankModel();
			boolean flag = false;
			for (Customer customer1 : model.findAll()) {
				if (jCustomerphone.getText().equalsIgnoreCase(customer1.getPhoneString())) {
					customer = null;
					jNameCustomer.setText(customer1.getNameString());
					customer = customer1;
					double tol = Double.valueOf(jtotal.getText());
					for (Rank rank : rankModel.findAll()) {
						if (customer1.getPoint() >= rank.getPoint()) {
							
							double tol1 = tol * (((double) rank.getDiscount()) / 100);
							jtotal.setText(String.valueOf(tol - tol1));
						}
					}
					flag = true;
					break;
				} else {
					BigDecimal total = new BigDecimal(0);
					for (int j = 0; j < invoiceItemList.size(); j++) {
						total = total.add(invoiceItemList.get(j).getPrice()
								.multiply(new BigDecimal(invoiceItemList.get(j).getQuantity())));
					}
					jtotal.setText(String.valueOf(total));

				}
			}
			if (!flag) {
				if (jNameCustomer.getText().equalsIgnoreCase("")) {
					customer = new Customer();
					customer.setNameString("Khach le");
					customer.setPhoneString(jCustomerphone.getText());
					customer.setPoint(0);
					customer.setRank(1);

				} else {
					customer = new Customer();
					customer.setNameString(jNameCustomer.getText());
					customer.setPhoneString(jCustomerphone.getText());
					customer.setPoint(0);
					customer.setRank(1);

				}

			}
		}

	}

	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {// xem them
		Sales_model sales_model = new Sales_model();
		int indexrow = jtableListInvoice.getSelectedRow();
		int id = (int) jtableListInvoice.getValueAt(indexrow, 0);
		List<Sales> listSales = new ArrayList<Sales>();
		for (Sales sales : sales_model.findAll()) {
	
			if (sales.getInvoice_id() == id) {
				listSales.add(sales);
			
			}
		}
		fillDataToJTable2(listSales);
	}

	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {// huy
		int indexrow = jtableListInvoice.getSelectedRow();
		int id = (int) jtableListInvoice.getValueAt(indexrow, 0);
		Invoice_model invoice_model = new Invoice_model();
		Invoices invoices = invoice_model.findID(id);
		invoices.setStatus(false);
		if (invoice_model.update(invoices)) {
			JOptionPane.showMessageDialog(null, "Success");
			fillDataToJTable(invoice_model.findAll());
		} else {
			JOptionPane.showMessageDialog(null, "Invaild");
		}

	}

	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {// delete sales
		int index = jtable1.getSelectedRow();
		String nameProS = (String) jtable1.getValueAt(index, 1);
		BigDecimal total = new BigDecimal(0);
		for (int j = 0; j < invoiceItemList.size(); j++) {
			Sales sales = invoiceItemList.get(j);
			if (sales.getProductName().equalsIgnoreCase(nameProS)) {
				invoiceItemList.remove(j);
			}
		}
		for (int j = 0; j < invoiceItemList.size(); j++) {
			total = total.add(
					invoiceItemList.get(j).getPrice().multiply(new BigDecimal(invoiceItemList.get(j).getQuantity())));

		}
		fillDataToJTable1(invoiceItemList);
		jtotal.setText(String.valueOf(total));

	}
	class CustomColorRenderer extends DefaultTableCellRenderer {

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value,
	                                                   boolean isSelected, boolean hasFocus,
	                                                   int row, int column) {
	        Component c = super.getTableCellRendererComponent(table, value,
	                isSelected, hasFocus, row, column);

	        // Lấy dữ liệu từ tất cả các cột trong dòng
	        String firstName = String.valueOf(table.getValueAt(row, 0)); // Giả sử cột "First Name" ở cột thứ 0
	        String lastName = String.valueOf(table.getValueAt(row, 1)); // Giả sử cột "Last Name" ở cột thứ 1
	        String age = String.valueOf(table.getValueAt(row, 2)); // Giả sử cột "Age" ở cột thứ 2
	        String status = String.valueOf(table.getValueAt(row, 5)); // Giả sử cột "Status" ở cột thứ 5

	        // Thay đổi màu sắc dựa trên điều kiện (ví dụ: màu đỏ nếu giá trị "Cancel")
	        if (status.equalsIgnoreCase("Cancel")) {
	            c.setBackground(Color.RED);
	            c.setForeground(Color.WHITE); // Đặt màu chữ trắng để đảm bảo đọc được trên nền đỏ
	        } else {
	            // Mặc định cho các hàng khác
	            c.setBackground(table.getBackground());
	            c.setForeground(table.getForeground());
	        }

	        return c;
	    }
}}
