package scInvoice;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Recieve;
import entites.Suppliers;
import models.Recieve_model;
import models.Suppliers_model;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JTable;

public class JPContact extends JPanel {
	private JTextField jtextFieldCustomerName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldPhone;
	private JTextArea jtextAreaReason;
	private JDateChooser jdateChooser;
	private JTable jtableRecieve;

	/**
	 * Create the panel.
	 */
	public JPContact() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setForeground(new Color(230, 230, 250));
		panel_1.setBorder(new TitledBorder(null, "Recieve", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setBounds(44, 27, 88, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblContactname = new JLabel("Address");
		lblContactname.setBounds(44, 63, 88, 26);
		panel_1.add(lblContactname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(44, 99, 88, 26);
		panel_1.add(lblEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setBounds(44, 135, 88, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(285, 27, 44, 26);
		panel_1.add(lblReason);
		
		jtextFieldCustomerName = new JTextField();
		jtextFieldCustomerName.setBounds(135, 29, 122, 24);
		panel_1.add(jtextFieldCustomerName);
		jtextFieldCustomerName.setColumns(10);
		
		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(135, 65, 122, 24);
		panel_1.add(jtextFieldAddress);
		
		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setText("@gmail.com");
		jtextFieldEmail.setColumns(10);
		jtextFieldEmail.setBounds(135, 99, 122, 26);
		panel_1.add(jtextFieldEmail);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(135, 136, 122, 26);
		panel_1.add(jtextFieldPhone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(359, 20, 153, 91);
		panel_1.add(scrollPane);
		
		jtextAreaReason = new JTextArea();
		scrollPane.setViewportView(jtextAreaReason);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(359, 189, 85, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(285, 135, 44, 26);
		panel_1.add(lblDate);
		
		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(359, 135, 134, 26);
		panel_1.add(jdateChooser);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 557, 238);
		panel_2.add(scrollPane_1);
		
		jtableRecieve = new JTable();
		scrollPane_1.setViewportView(jtableRecieve);
		initJFrame();  
	}
	
	public void initJFrame() {
		Recieve_model recieve_model = new Recieve_model() ; 
		fillDataToJTable(recieve_model.findAll());
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String reason = jtextAreaReason.getText() ; 
		System.out.println(reason);
		
		Recieve recieve = new Recieve() ; 
		Recieve_model recieve_model = new Recieve_model() ;
		
		recieve.setAddress(jtextFieldAddress.getText());
		recieve.setCustomer_recieve(jtextFieldCustomerName.getText());
		recieve.setDate(jdateChooser.getDate());
		recieve.setEmail(jtextFieldEmail.getText());
		recieve.setPhone(jtextFieldPhone.getText());
		recieve.setReason(jtextAreaReason.getText());
		if(recieve_model.Create(recieve)) {
			JOptionPane.showMessageDialog(null,"Succes");
			fillDataToJTable(recieve_model.findAll());
		}else {
			JOptionPane.showMessageDialog(null,"Faild");
		}
		
	}
	
	public void fillDataToJTable(List<Recieve> recieves) {
		DefaultTableModel model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		}; 
		model.addColumn("ID");
		model.addColumn("Customer Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("Reason");
		model.addColumn("Date");
		for(Recieve recieve : recieves) {
			model.addRow(new Object[] {
					recieve.getId_recieve(),
					recieve.getCustomer_recieve(),
					recieve.getAddress(),
					recieve.getPhone(),
					recieve.getEmail(),
					recieve.getReason(),
					recieve.getDate()
			});
		}
		jtableRecieve.setModel(model);
		jtableRecieve.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = jtableRecieve.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn customerNameColumn = columnModel.getColumn(1); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(200); // Chiều rộng tối đa
		
		TableColumn email = columnModel.getColumn(4); // Cột "Customer Name" ở index 2
		email.setMinWidth(100); // Chiều rộng tối thiểu
		email.setMaxWidth(200); // Chiều rộng tối đa
		
	}
}
