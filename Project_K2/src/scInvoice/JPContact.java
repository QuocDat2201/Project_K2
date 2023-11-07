package scInvoice;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Suppliers;
import models.Suppliers_model;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPContact extends JPanel {
	private JTextField jtextFieldSpName;
	private JTextField jtextFieldContactName;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldPhone;
	private JTextArea jtextAreaReason;

	/**
	 * Create the panel.
	 */
	public JPContact() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setBounds(44, 27, 88, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblContactname = new JLabel("Contact Name");
		lblContactname.setBounds(44, 63, 88, 26);
		panel_1.add(lblContactname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(44, 99, 88, 26);
		panel_1.add(lblEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setBounds(44, 127, 88, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(285, 20, 64, 26);
		panel_1.add(lblReason);
		
		jtextFieldSpName = new JTextField();
		jtextFieldSpName.setBounds(123, 29, 134, 24);
		panel_1.add(jtextFieldSpName);
		jtextFieldSpName.setColumns(10);
		
		jtextFieldContactName = new JTextField();
		jtextFieldContactName.setColumns(10);
		jtextFieldContactName.setBounds(123, 65, 134, 24);
		panel_1.add(jtextFieldContactName);
		
		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setText("@gmail.com");
		jtextFieldEmail.setColumns(10);
		jtextFieldEmail.setBounds(123, 99, 134, 26);
		panel_1.add(jtextFieldEmail);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(123, 136, 134, 26);
		panel_1.add(jtextFieldPhone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(359, 20, 172, 99);
		panel_1.add(scrollPane);
		
		jtextAreaReason = new JTextArea();
		scrollPane.setViewportView(jtextAreaReason);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(356, 146, 85, 21);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String reason = jtextAreaReason.getText() ; 
		System.out.println(reason);
		
		Suppliers suppliers = new Suppliers() ; 
		Suppliers_model suppliers_model = new Suppliers_model() ; 
		suppliers.setContactName(jtextFieldContactName.getText());
		suppliers.setEmail(jtextFieldEmail.getText());
		suppliers.setPhone(jtextFieldPhone.getText());
		suppliers.setSupplierName(jtextFieldSpName.getText());
		if(suppliers_model.Create(suppliers)) {
			JOptionPane.showMessageDialog(null,"Succes");
		}else {
			JOptionPane.showMessageDialog(null,"Faild");
		}
	}
}
