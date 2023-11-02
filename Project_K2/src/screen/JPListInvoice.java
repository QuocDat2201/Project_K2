package screen;

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

public class JPListInvoice extends JPanel {
	private JTextField jCustomerName;
	private JDateChooser jdateChooser;
	private JComboBox jcomboBox;
	private JTextField jtextQuantily;
	private JTextField jtotal;
	private JComboBox jcomboBoxProductID;
	private JTextField jProductName;
	private JTextField jProductPrice;
	private JTable jtableListInvoice;
	private JPopupMenu popupMenu;

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
		panel_2.setBorder(new TitledBorder(null, "List Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 21, 501, 178);
		panel_2.add(scrollPane);
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Delete");
		popupMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem_1);
		
		jtableListInvoice = new JTable();
		jtableListInvoice.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(jtableListInvoice);
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
		Sales_model sales_model = new Sales_model() ;
		Invoice_model invoice_model = new Invoice_model() ; 
		fillDataToJTable(sales_model.findAll(), invoice_model.findAll());
		
		jtableListInvoice.setComponentPopupMenu(popupMenu);
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
			 
			fillDataToJTable(sales_model.findAll(), invoice_model.findAll());

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
	
	public void fillDataToJTable(List<Sales> sales, List<Invoices> invoices) {
	    DefaultTableModel model = new DefaultTableModel();
	    
	    // Thêm cột cho JTable
	    model.addColumn("ID");
	    model.addColumn("Invoice Date");
	    model.addColumn("Customer Name");
	    model.addColumn("Product Name");
	    model.addColumn("Quantity");
	    model.addColumn("Total");

	    // Tạo danh sách tạm thời để lưu thông tin sáp nhập từ Sales và Invoices
	    List<CombinedData> combinedDataList = new ArrayList<CombinedData>();
	    Product_model product_model = new Product_model() ; 
	    
	    for (Sales sale : sales) {
	        CombinedData combinedData = new CombinedData(
	            sale.getSaleID(),
	            null,  // Để trống Invoice Date
	            null,  // Để trống Customer Name
	            sale.getProductID(),
	     
	            sale.getQuantity(),
	            sale.getPrice()
	        );
	        combinedDataList.add(combinedData);
	    }

	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    for (Invoices invoice : invoices) {
	        // Tìm đối tượng CombinedData tương ứng dựa trên SaleID
	        for (CombinedData combinedData : combinedDataList) {
	            if (combinedData.getSaleID() == invoice.getSaleID()) {
	                combinedData.setInvoiceDate(invoice.getInvoiceDate());
	                combinedData.setCustomerName(invoice.getCustomerName());
	                break;  // Thoát khỏi vòng lặp khi tìm thấy SaleID tương ứng
	            }
	        }
	    }

	    // Hiển thị dữ liệu từ danh sách CombinedData lên JTable
	    for (CombinedData combinedData : combinedDataList) {
	        model.addRow(new Object[] {
	            combinedData.getSaleID(),
	            (combinedData.getInvoiceDate() != null) ? simpleDateFormat.format(combinedData.getInvoiceDate()) : "",
	            combinedData.getCustomerName(),
	            product_model.find(combinedData.getProductID()).getProductName(),
	            combinedData.getQuantity(),
	            combinedData.getPrice()
	        });
	    }
	    jtableListInvoice.getTableHeader().setReorderingAllowed(false);
	    jtableListInvoice.setModel(model);
	 // Lấy ra model của cột từ JTable
	    TableColumnModel columnModel = jtableListInvoice.getColumnModel();

	    // Lấy ra cột "Customer Name" và thiết lập chiều rộng
	    TableColumn customerNameColumn = columnModel.getColumn(2); // Cột "Customer Name" ở index 2
	    customerNameColumn.setMinWidth(100);  // Chiều rộng tối thiểu
	    customerNameColumn.setMaxWidth(200);  // Chiều rộng tối đa

	    // Lấy ra cột "Product Name" và thiết lập chiều rộng
	    TableColumn productNameColumn = columnModel.getColumn(3); // Cột "Product Name" ở index 3
	    productNameColumn.setMinWidth(100);  // Chiều rộng tối thiểu
	    productNameColumn.setMaxWidth(200);  // Chiều rộng tối đa

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
}
