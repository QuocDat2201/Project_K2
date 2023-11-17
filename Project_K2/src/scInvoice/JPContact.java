package scInvoice;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Products;
import entites.Recieve;
import entites.Suppliers;
import models.Product_model;
import models.Recieve_model;
import models.Suppliers_model;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;

public class JPContact extends JPanel {
	private JTextField jtextFieldCustomerName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldPhone;
	private JTextArea jtextAreaReason;
	private JDateChooser jdateChooser;
	private JTable jtableRecieve;
	private JTextField jtextFieldQuantity;
	private JComboBox jcomboBoxProduct;

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
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel.setBounds(44, 27, 88, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblContactname = new JLabel("Address");
		lblContactname.setFont(new Font("Dialog", Font.BOLD, 11));
		lblContactname.setBounds(44, 63, 88, 26);
		panel_1.add(lblContactname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEmail.setBounds(44, 99, 88, 26);
		panel_1.add(lblEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(44, 135, 88, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Dialog", Font.BOLD, 11));
		lblReason.setBounds(314, 27, 44, 26);
		panel_1.add(lblReason);
		
		jtextFieldCustomerName = new JTextField();//ad
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
		scrollPane.setBounds(388, 27, 150, 62);
		panel_1.add(scrollPane);
		
		jtextAreaReason = new JTextArea();
		scrollPane.setViewportView(jtextAreaReason);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(388, 171, 94, 26);
		panel_1.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDate.setBounds(44, 171, 44, 26);
		panel_1.add(lblDate);
		
		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(135, 172, 134, 26);
		panel_1.add(jdateChooser);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Product");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(314, 99, 88, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(388, 135, 139, 26);
		panel_1.add(jtextFieldQuantity);
		jtextFieldQuantity.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		            e.consume();
		        }
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        do_jtextFieldQuantity_keyReleased(e);
		    }

			private void do_jtextFieldQuantity_keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantity");
		lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(314, 134, 88, 26);
		panel_1.add(lblNewLabel_1_1_2);
		
		jcomboBoxProduct = new JComboBox();
		jcomboBoxProduct.setBounds(388, 103, 150, 24);
		panel_1.add(jcomboBoxProduct);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "List Recieve", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(224, 255, 255));
		scrollPane_1.setBounds(22, 29, 603, 123);
		panel_2.add(scrollPane_1);
		
		jtableRecieve = new JTable();
		scrollPane_1.setViewportView(jtableRecieve);
		initJFrame();  
	}
	
	public void initJFrame() {
		DefaultComboBoxModel<Products> models = new DefaultComboBoxModel<Products>();
		Product_model product_model = new Product_model();
		Products products = new Products();
		for (Products product : product_model.findAll()) {
			models.addElement(product);
		}
		jcomboBoxProduct.setModel(models);
		jcomboBoxProduct.setRenderer(new ProductCellRender());
		
		Recieve_model recieve_model = new Recieve_model() ; 
		fillDataToJTable(recieve_model.findAll());
		
	}
	
	private class ProductCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Products products = (Products) value;
			return super.getListCellRendererComponent(list, products.getProductName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			Object selectedProduct = jcomboBoxProduct.getSelectedItem();
			Products product = (Products) selectedProduct;
			String productName = product.getProductName();
			
			String reason = jtextAreaReason.getText() ;
			Recieve recieve = new Recieve() ; 
			Recieve_model recieve_model = new Recieve_model() ;
			
			recieve.setAddress(jtextFieldAddress.getText());
			recieve.setCustomer_recieve(jtextFieldCustomerName.getText());
			recieve.setDate(jdateChooser.getDate());
			recieve.setEmail(jtextFieldEmail.getText());
			recieve.setPhone(jtextFieldPhone.getText());
			recieve.setReason(jtextAreaReason.getText());
			recieve.setProduct_name(productName);
			recieve.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
			if(recieve_model.Create(recieve)) {
				JOptionPane.showMessageDialog(null,"Succes");
				fillDataToJTable(recieve_model.findAll());
			}else {
				JOptionPane.showMessageDialog(null,"Faild");
			}
		} catch (Exception e2) {
			// TODO: handle exception
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
		model.addColumn("Date");
		model.addColumn("Product Name");
		model.addColumn("Quantity");
		for(Recieve recieve : recieves) {
			model.addRow(new Object[] {
					recieve.getId_recieve(),
					recieve.getCustomer_recieve(),
					recieve.getDate(),
					recieve.getProduct_name(),
					recieve.getQuantity()
			});
		}
		jtableRecieve.setModel(model);
		jtableRecieve.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = jtableRecieve.getColumnModel();

		// Lấy ra cột "Customer Name" và thiết lập chiều rộng
		TableColumn id = columnModel.getColumn(0); // Cột "Customer Name" ở index 2
		id.setMinWidth(100); // Chiều rộng tối thiểu
		id.setMaxWidth(200); // Chiều rộng tối đa
		
		TableColumn customerNameColumn = columnModel.getColumn(1); // Cột "Customer Name" ở index 2
		customerNameColumn.setMinWidth(100); // Chiều rộng tối thiểu
		customerNameColumn.setMaxWidth(200); // Chiều rộng tối đa
		
		TableColumn email = columnModel.getColumn(4); // Cột "Customer Name" ở index 2
		email.setMinWidth(100); // Chiều rộng tối thiểu
		email.setMaxWidth(200); // Chiều rộng tối đa
		
	}
}
