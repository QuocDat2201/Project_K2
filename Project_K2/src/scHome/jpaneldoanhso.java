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
import entites.Sales;
import models.Invoice_model;
import models.Product_model;
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

public class jpaneldoanhso extends JPanel {
	private JTable jtable;
	private JTable jtable_1;

	/**
	 * Create the panel.
	 */
	public jpaneldoanhso() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		Dimension Dimension = new Dimension(panel.getPreferredSize().width, 50);
		panel.setPreferredSize(Dimension);
		add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		jtable = new JTable();
		scrollPane.setViewportView(jtable);
		JPanel panel1 = new JPanel();
		
		add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new BorderLayout(0, 0));
		JPanel panel2 = new JPanel();
		add(panel2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("doanh so 30 ngay gan nhat");
		panel2.add(lblNewLabel);
		Dimension newDimension = new Dimension(panel1.getPreferredSize().width, 190);
		panel1.setPreferredSize(newDimension);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel1.add(scrollPane_1, BorderLayout.CENTER);
		
		jtable_1 = new JTable();
		scrollPane_1.setViewportView(jtable_1);

		revalidate();
		repaint();
		iniJFrame();
	}

	private void iniJFrame() {

		DefaultTableModel model = new DefaultTableModel();
		Sales_model sales_model = new Sales_model();
		BigDecimal total = BigDecimal.ZERO;
		for (Sales sale : sales_model.findAll()) {
			total = total.add(sale.getPrice().multiply(new BigDecimal(sale.getQuantity())) );
		}
		model.addColumn("Thu");
		model.addColumn("Chi");
		model.addRow(new Object[] { total, total });

		jtable.setModel(model); // Set the model to the existing jtable field
		jtable.setDefaultRenderer(Object.class, new render());

		TableColumnModel columnModel = jtable.getColumnModel();
		TableColumn column = columnModel.getColumn(0); // Cột "Thu" (cột đầu tiên)
		int rowHeight = 50; // Đặt chiều cao hàng tùy ý
		jtable.setRowHeight(rowHeight);
		Sales_model sales_model1 = new Sales_model();
		Invoice_model invoice_model1 = new Invoice_model();
		//fillDataToJTable(sales_model1.findAll(), invoice_model1.findAll());
	}
	private class render extends DefaultTableCellRenderer {
		public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			if (column == 0) {
				c.setForeground(Color.GREEN); 
				c.setFont(c.getFont().deriveFont(50f));
			}else {
				c.setForeground(Color.RED);
				c.setFont(c.getFont().deriveFont(50f));
			}
			return c;
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

		// Tạo danh sách tạm thời để lưu thông tin sáp nhập từ Sales và Invoices
		List<CombinedData> combinedDataList = new ArrayList<CombinedData>();
		Product_model product_model = new Product_model();

		for (Sales sale : sales) {
			CombinedData combinedData = new CombinedData(sale.getSaleID(), null, // Để trống Invoice Date
					null, // Để trống Customer Name
					sale.getProductID(),

					sale.getQuantity(), sale.getPrice());
			combinedDataList.add(combinedData);
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Invoices invoice : invoices) {
			// Tìm đối tượng CombinedData tương ứng dựa trên SaleID
			for (CombinedData combinedData : combinedDataList) {
				if (combinedData.getSaleID() == invoice.getInvoiceID()) {
					combinedData.setInvoiceDate(invoice.getInvoiceDate());
					combinedData.setCustomerName(invoice.getCustomerName());
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
					combinedData.getQuantity(), combinedData.getPrice() });
		}
		jtable_1.getTableHeader().setReorderingAllowed(false);
		jtable_1.setModel(model);
		// Lấy ra model của cột từ JTable
	}

}
