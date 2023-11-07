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

public class JPaddsuppleir extends JPanel {
	private JTextField jsuppleirname;
	private JTextField jcontactname;
	private JTextField jemail;
	private JTextField jphone;

	/**
	 * Create the panel.
	 */
	public JPaddsuppleir() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("SuppleirName");
		panel.add(lblNewLabel);

		jsuppleirname = new JTextField();
		panel.add(jsuppleirname);
		jsuppleirname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ContactName");
		panel.add(lblNewLabel_1);

		jcontactname = new JTextField();
		panel.add(jcontactname);
		jcontactname.setColumns(10);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		panel.add(lblNewLabel_2);
		
		jemail = new JTextField();
		jemail.setColumns(10);
		panel.add(jemail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		panel.add(lblNewLabel_1_1);
		
		jphone = new JTextField();
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
			JPmenucustomer.mntmNewMenuItem_2.doClick();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
			
		}
	}
}
