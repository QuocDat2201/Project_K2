package scHome;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entites.CombinedData;
import entites.Invoices;
import entites.Purchaseinvoices;
import entites.Sales;
import models.Invoice_model;
import models.Product_model;
import models.Purchaseinvoices_model;
import models.Sales_model;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class jpaneldoanhso extends JPanel {
	private JTable table_1;
	private JLabel jthu;
	private JLabel jchi;

	/**
	 * Create the panel.
	 */
	public jpaneldoanhso() {

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(234, 247, 255));
		panel.setBounds(0, 105, 662, 98);
		Dimension Dimension = new Dimension(panel.getPreferredSize().width, 50);
		setLayout(null);
		panel.setPreferredSize(Dimension);
		add(panel);
		revalidate();
		repaint();
		panel.setLayout(null);
		
		JLabel Revenue = new JLabel("Revenue");
		Revenue.setFont(new Font("Arial", Font.BOLD, 18));
		Revenue.setBounds(122, 0, 87, 24);
		panel.add(Revenue);
		
		jthu = new JLabel("New label");
		jthu.setBorder(new LineBorder(new Color(0, 255, 64), 4));
		jthu.setFont(new Font("Arial", Font.BOLD, 25));
		jthu.setHorizontalAlignment(SwingConstants.CENTER);
		jthu.setBounds(10, 25, 319, 58);
		panel.add(jthu);
		
		jchi = new JLabel("New label");
		jchi.setBorder(new LineBorder(new Color(255, 0, 0), 4));
		jchi.setFont(new Font("Arial", Font.BOLD, 25));
		jchi.setHorizontalAlignment(SwingConstants.CENTER);
		jchi.setBounds(339, 25, 303, 58);
		panel.add(jchi);
		
		JLabel lblNewLabel_3_1 = new JLabel("Exspen");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(463, 0, 87, 24);
		panel.add(lblNewLabel_3_1);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 199, 477, 234);
		
		add(panel1);
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(232, 249, 255));
		panel2.setBounds(0, 81, 662, 30);
		add(panel2);

		JLabel lblNewLabel = new JLabel("doanh so 30 ngay gan nhat");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel2.add(lblNewLabel);
		Dimension newDimension = new Dimension(panel1.getPreferredSize().width, 190);
		panel1.setPreferredSize(newDimension);
		panel1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 477, 201);
		panel1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(0, 0, 332, 84);
		add(panel_1);
		panel_1.setLayout(null);//add
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpaneldoanhso.class.getResource("/Icon/403022_business man_male_user_avatar_profile_icon.png")));
		lblNewLabel_1.setBounds(85, 29, 54, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel jtextkhachhang = new JLabel("50000+");
		jtextkhachhang.setFont(new Font("Dialog", Font.BOLD, 15));
		jtextkhachhang.setForeground(new Color(193, 241, 255));
		jtextkhachhang.setBounds(149, 29, 93, 44);
		panel_1.add(jtextkhachhang);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Khach Hang");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_2.setForeground(new Color(193, 241, 255));
		lblNewLabel_1_1_2.setBounds(119, 0, 130, 32);
		panel_1.add(lblNewLabel_1_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(193, 241, 255));
		panel_2.setBackground(new Color(0, 128, 0));
		panel_2.setBounds(336, 0, 345, 84);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(jpaneldoanhso.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		lblNewLabel_1_2.setBounds(69, 30, 55, 43);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("200000+");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1_1_1.setForeground(new Color(193, 241, 255));
		lblNewLabel_1_1_1.setBounds(152, 30, 90, 43);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("So san pham da ban");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setForeground(new Color(193, 241, 255));
		lblNewLabel_1_1_2_1.setBounds(83, 0, 184, 32);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JPanel panel1_1 = new JPanel();
		panel1_1.setBackground(new Color(0, 128, 255));
		panel1_1.setLayout(null);
		panel1_1.setPreferredSize(new Dimension(10, 190));
		panel1_1.setBounds(476, 199, 186, 234);
		add(panel1_1);
		
		JLabel lblNewLabel_2 = new JLabel("top 10 products\r\n\r\r\n");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(37, 0, 116, 20);
		panel1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("best saler\r\r\n");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(65, 10, 69, 27);
		panel1_1.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 40, 186, 162);
		panel1_1.add(scrollPane_2);

		revalidate();
		repaint();
		iniJFrame();
	}

	private void iniJFrame() {

		DefaultTableModel model = new DefaultTableModel();
		Purchaseinvoices_model purchaseinvoices_model=new Purchaseinvoices_model();
		BigDecimal totalthu = BigDecimal.ZERO;
		for (Purchaseinvoices purchaseinvoices : purchaseinvoices_model.findAll()) {
				totalthu= totalthu.add(purchaseinvoices.getTotalAmount());
		}
		Invoice_model invoice_model=new Invoice_model();
		Invoices invoices=new Invoices();
		BigDecimal total = BigDecimal.ZERO;
		for (Invoices invoice: invoice_model.findAll()) {
			total = total.add(invoice.getTotal());
		}
		jchi.setText(String.valueOf(total)+" $");
		jthu.setText(String.valueOf(totalthu)+" $");
		Sales_model sales_model1 = new Sales_model();
		Invoice_model invoice_model1 = new Invoice_model();
		//fillDataToJTable(sales_model1.findAll(), invoice_model1.findAll());
		
		fillDataToJTable(invoice_model1.findAll());
	}
	public void fillDataToJTable(List<Invoices> invoicess) {
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
		model.addColumn("Date");
		model.addColumn("Status");
		// Tạo danh sách tạm thời để lưu thông tin sáp nhập từ Sales và Invoices
		List<CombinedData> combinedDataList = new ArrayList<CombinedData>();
		Product_model product_model = new Product_model();

		for (Invoices invoi : invoicess) {
			model.addRow(new Object[] { invoi.getInvoiceID(), invoi.getCustomerName(), invoi.getCustomerPhone(),
					invoi.getTotal(), invoi.getInvoiceDate(), invoi.isStatus() ? "Confirm" : "Cancel" });

		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setModel(model);
//		jtableListInvoice.setDefaultRenderer(Object.class,new ColoredCellRenderer());
		// Lấy ra model của cột từ JTable
		TableColumnModel columnModel = table_1.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn customerNameColumn = columnModel.getColumn(0); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(30); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(30); // Chiều rộng tối đa

		// Lấy ra cột "Product Name" và thiết lập chiều rộng
		TableColumn productNameColumn = columnModel.getColumn(1); // Cột "Product Name" ở index 3
		productNameColumn.setMinWidth(110); // Chiều rộng tối thiểu
		productNameColumn.setMaxWidth(110); // Chiều rộng tối đa

		TableColumn DateNameColumn = columnModel.getColumn(2); // Cột "Product Name" ở index 3
		DateNameColumn.setMinWidth(110); // Chiều rộng tối thiểu
		DateNameColumn.setMaxWidth(110); // Chiều rộng tối đa
		TableColumn DateNameColumn3 = columnModel.getColumn(3); // Cột "Product Name" ở index 3
		DateNameColumn3.setMinWidth(40); // Chiều rộng tối thiểu
		DateNameColumn3.setMaxWidth(40); // Chiều rộng tối đa

	}	
}


