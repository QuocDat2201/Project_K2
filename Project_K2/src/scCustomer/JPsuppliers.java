package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entites.Customer;
import entites.Suppliers;
import models.CustomerModel;
import models.Suppliers_model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPsuppliers extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public JPsuppliers() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);

		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Add Supplier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(
				JPcustomer.class.getResource("/Icon/403022_business man_male_user_avatar_profile_icon.png")));
		panel_1.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 0, 0));
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		iniJFrame();
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		JPaddsuppleir jPaddcustomer=new JPaddsuppleir();
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.add(jPaddcustomer);
		panel_1.setVisible(true);
	}

	private void iniJFrame() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		model.addColumn("SupplierName");
		model.addColumn("ContactName");
		model.addColumn("Email");
		model.addColumn("Phone");
		Suppliers_model suppliers_model=new Suppliers_model();
		try {
			for (Suppliers suppliers : suppliers_model.findAll()) {
				model.addRow(new Object[] { suppliers.getSupplierName(), suppliers.getContactName(), suppliers.getEmail(),
						suppliers.getPhone()});

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		int rowHeight = 25; // Đặt chiều cao hàng tùy ý
		table.setRowHeight(rowHeight);

	}
}
