package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Customer;
import entites.Suppliers;
import models.CustomerModel;
import models.Suppliers_model;

import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JPaddsuppleir extends JPanel {
	private JTextField jsuppleirname;
	private JTextField jcontactname;
	private JTextField jemail;
	private JTextField jphone;

	/**
	 * Create the panel.
	 */
	public JPaddsuppleir() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 0));
		panel.setBounds(0, 0, 621, 64);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("SuppleirName");
		lblNewLabel.setBounds(6, 8, 65, 14);
		panel.add(lblNewLabel);

		jsuppleirname = new JTextField();
		jsuppleirname.setBounds(76, 5, 140, 20);
		panel.add(jsuppleirname);
		jsuppleirname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ContactName");
		lblNewLabel_1.setBounds(238, 8, 65, 14);
		panel.add(lblNewLabel_1);

		jcontactname = new JTextField();
		jcontactname.setBounds(313, 5, 142, 20);
		panel.add(jcontactname);
		jcontactname.setColumns(10);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(465, 29, 65, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(238, 33, 24, 14);
		panel.add(lblNewLabel_2);
		
		jemail = new JTextField();
		jemail.setBounds(313, 30, 142, 20);
		jemail.setColumns(10);
		panel.add(jemail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setBounds(41, 33, 30, 14);
		panel.add(lblNewLabel_1_1);
		
		jphone = new JTextField();
		jphone.setBounds(76, 30, 140, 20);
		jphone.setColumns(10);
		panel.add(jphone);
		panel.add(btnNewButton);
		iniJFrame();
	}

	private void iniJFrame() {
		

	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Suppliers suppliers=new Suppliers();
		suppliers.setSupplierName(jsuppleirname.getText());
		suppliers.setContactName(jcontactname.getText());
		suppliers.setEmail(jemail.getText());
		suppliers.setPhone(jphone.getText());
		Suppliers_model suppliers_model =new Suppliers_model();
		
		if (suppliers_model.Create(suppliers)) {
			JOptionPane.showMessageDialog(null, "Sucsess");
			JPcustomer jcustomer=new JPcustomer();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
			
		}
	}
}
