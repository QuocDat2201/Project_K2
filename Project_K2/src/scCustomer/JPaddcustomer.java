package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import entites.Customer;
import models.CustomerModel;
import screen.Home;

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
		((AbstractDocument) Jphone.getDocument()).setDocumentFilter(new NumberDocumentFilter());
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
