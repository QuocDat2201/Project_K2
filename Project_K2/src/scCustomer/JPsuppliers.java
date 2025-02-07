package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import entites.Customer;
import entites.Suppliers;
import models.CustomerModel;
import models.Suppliers_model;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;

public class JPsuppliers extends JPanel {
	private JTable table;
	private JPanel panel_1;
	private JTextField jname;
	private JTextField jphone;
	private JTextField jemail;
	private JTextField jcontact;

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
		panel_1.setBackground(new Color(192, 192, 192));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suppleir Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(24, 11, 104, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(24, 48, 104, 26);
		panel_1.add(lblNewLabel_1);
		
		jname = new JTextField();
		jname.setBounds(128, 11, 149, 26);
		panel_1.add(jname);
		jname.setColumns(10);
		
		jphone = new JTextField();
		jphone.setBounds(128, 48, 149, 25);
		((AbstractDocument) jphone.getDocument()).setDocumentFilter(new NumberDocumentFilter());
		panel_1.add(jphone);
		jphone.setColumns(10);
		
		jemail = new JTextField();
		jemail.setColumns(10);
		jemail.setBounds(401, 49, 149, 25);
		panel_1.add(jemail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setBounds(287, 48, 104, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Suppleir Contact");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(287, 11, 110, 26);
		panel_1.add(lblNewLabel_2);
		
		jcontact = new JTextField();
		jcontact.setColumns(10);
		jcontact.setBounds(401, 12, 149, 26);
		panel_1.add(jcontact);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(566, 47, 84, 26);
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
		Suppliers_model suppliers_model=new Suppliers_model();
		filldata(suppliers_model.findAll());
	}
	private void filldata(List<Suppliers> sup) {
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
		
		try {
			for (Suppliers suppliers : sup) {
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
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Suppliers suppliers=new Suppliers();
		suppliers.setSupplierName(jname.getText());
		suppliers.setContactName(jcontact.getText());
		suppliers.setEmail(jemail.getText());
		suppliers.setPhone(jphone.getText());
		Suppliers_model suppliers_model=new Suppliers_model();
		
		if ( suppliers_model.Create(suppliers)) {
			JOptionPane.showMessageDialog(null, "Success");
			
			filldata(suppliers_model.findAll());
			
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
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
