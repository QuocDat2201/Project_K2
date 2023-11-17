package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entites.Products;
import entites.Purchaseinvoices;
import entites.Suppliers;
import models.Product_model;
import models.Purchaseinvoices_model;
import models.Suppliers_model;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.awt.Color;

public class JPb extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPb() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 235, 253));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 88, 607, 291);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("List Purchase");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(195, 22, 225, 55);
		panel.add(lblNewLabel);
		intiJFram();
	}

	private void intiJFram() {
		Purchaseinvoices_model purchaseinvoices_model = new Purchaseinvoices_model();
		fillDataToJTable(purchaseinvoices_model.findAll());
	}

	public void fillDataToJTable(List<Purchaseinvoices> purchaseinvoices) {
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		model.addColumn("InvoiceID");
		model.addColumn("Supplier name");
		model.addColumn("Date");
		model.addColumn("Total Amount");
		Suppliers_model xModel = new Suppliers_model();
		for (Purchaseinvoices purchaseinvoice : purchaseinvoices) {
			String nameString = null;

			for (Suppliers suppliers : xModel.findAll()) {
				if (suppliers.getSupplierID() == purchaseinvoice.getSupplierID()) {
					nameString = suppliers.getSupplierName();
				}
			}
			
			model.addRow(new Object[] { purchaseinvoice.getInvoiceID(), nameString, purchaseinvoice.getInvoiceDate(),
					purchaseinvoice.getTotalAmount() });
		}
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);

	}
}
