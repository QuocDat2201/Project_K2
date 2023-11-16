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
import java.awt.Font;
import java.awt.FlowLayout;

public class JPsuppliers extends JPanel {
	private JTable table;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public JPsuppliers() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 402);
		add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 660, 95);
		panel_1.setBackground(new Color(56, 51, 253));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(24, 11, 104, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(24, 48, 104, 26);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 11, 149, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 48, 149, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(391, 48, 149, 25);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(287, 48, 104, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(287, 11, 104, 26);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(391, 11, 149, 26);
		panel_1.add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(577, 50, 73, 23);
		panel_1.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 94, 660, 314);
		scrollPane.setBackground(new Color(0, 64, 0));
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		iniJFrame();
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
