package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Customer;
import models.CustomerModel;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPaddcustomer extends JPanel {
	private JTextField Jname;
	private JTextField Jphone;

	/**
	 * Create the panel.
	 */
	public JPaddcustomer() {
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

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.add(btnNewButton);
		iniJFrame();
	}

	private void iniJFrame() {
		

	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Customer customer= new Customer();
		customer.setNameString(Jname.getText());
		customer.setPhoneString(Jphone.getText());
		customer.setPoint(0);
		customer.setRank(1);
		CustomerModel customerModel=new CustomerModel();
		
		if (customerModel.create(customer)) {
			JOptionPane.showMessageDialog(null, "Sucsess");
			JPcustomer jcustomer=new JPcustomer();
			Home.jbcusstomer.doClick();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
			
		}
	}
}
