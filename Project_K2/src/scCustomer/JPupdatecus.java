package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Customer;
import models.CustomerModel;
import screen.Home;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPupdatecus extends JPanel {
	private JTextField Jname;
	private JTextField Jphone;
	private int Id;

	/**
	 * Create the panel.
	 */
	public JPupdatecus() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Name");
		panel.add(lblNewLabel);

		Jname = new JTextField();
		panel.add(Jname);
		Jname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Phone");
		panel.add(lblNewLabel_1);

		Jphone = new JTextField();
		panel.add(Jphone);
		Jphone.setColumns(10);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.add(btnNewButton);
		iniJFrame();
	}

	public JPupdatecus(int id) {
		this();
		Id = id;
		CustomerModel customerModel = new CustomerModel();
		for (Customer customer : customerModel.findAll()) {
			if (customer.getId() == Id) {
				Jname.setText(customer.getNameString());
				Jphone.setText(customer.getPhoneString());
				break;
			} 
		}
	}

	private void iniJFrame() {

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {

		CustomerModel customerModel = new CustomerModel();
		for (Customer customer : customerModel.findAll()) {
			if (customer.getId() == Id) {
				customer.setNameString(Jname.getText());
				customer.setPhoneString(Jphone.getText());
				JOptionPane.showMessageDialog(null, "Sucsess");
				customerModel.update(customer);
				Home.jbcusstomer.doClick();
			} 
		}

	}
}
