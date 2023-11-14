package scInvoice;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entites.Products;
import entites.Purchaseinvoicedetails;
import entites.Purchaseinvoices;
import entites.Suppliers;
import models.Product_model;
import models.Purchaseinvoicedetails_model;
import models.Purchaseinvoices_model;
import models.Suppliers_model;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPPurchase extends JPanel {
	private JComboBox jcomboBoxSupplier;
	private JDateChooser jdateChooser;
	private Map<String,Object> data ;
	private List<Integer> saleIDs ; 
	private JLabel jlabelTotal;
	/**
	 * Create the panel.
	 */
	public JPPurchase() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBorder(new TitledBorder(null, "Purchase", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supplier");
		lblNewLabel.setBounds(75, 57, 90, 22);
		panel_1.add(lblNewLabel);
		
		jcomboBoxSupplier = new JComboBox();
		jcomboBoxSupplier.setBounds(175, 58, 132, 21);
		panel_1.add(jcomboBoxSupplier);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(75, 101, 90, 22);
		panel_1.add(lblDate);
		
		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(175, 95, 132, 28);
		panel_1.add(jdateChooser);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total");
		lblNewLabel_1_1.setBounds(75, 142, 90, 22);
		panel_1.add(lblNewLabel_1_1);
		
		jlabelTotal = new JLabel("");
		jlabelTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelTotal.setBounds(175, 142, 78, 22);
		panel_1.add(jlabelTotal);
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(368, 143, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(175, 188, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
	}
	public JPPurchase(Map<String,Object> data) {
		this();
		this.data = data ; 
		initJFrame();
	}
	
	
	public void initJFrame(){
		saleIDs = (List)data.get("saleIDs");
		DefaultComboBoxModel<Suppliers> models = new DefaultComboBoxModel<Suppliers>() ; 
		Suppliers_model suppliers_model = new Suppliers_model() ; 
		for(Suppliers supplier : suppliers_model.findAll()) {
			models.addElement(supplier);
		}
		jcomboBoxSupplier.setModel(models);
		jcomboBoxSupplier.setRenderer(new SupplierCellRender());
		
		
		
		Purchaseinvoicedetails_model purchaseinvoicedetails_model = new Purchaseinvoicedetails_model() ; 
		BigDecimal total = new BigDecimal("0.00");

		for(Purchaseinvoicedetails purchaseinvoicedetails : purchaseinvoicedetails_model.findInvoice_id()) {
			total = total.add(purchaseinvoicedetails.getUnitPrice());
		}
		jlabelTotal.setText(String.valueOf(total));
		
		
	}
	
	private class SupplierCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Suppliers supplier = (Suppliers) value ;
			return super.getListCellRendererComponent(list, supplier.getSupplierName(), index, isSelected, cellHasFocus);
		}
		
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			Purchaseinvoices purchaseinvoices = new Purchaseinvoices() ; 
			Purchaseinvoices_model purchaseinvoices_model = new Purchaseinvoices_model() ; 
			
			Object selectedSupplier = jcomboBoxSupplier.getSelectedItem();
			
	        Suppliers suppliers = (Suppliers) selectedSupplier;
			purchaseinvoices.setInvoiceDate(jdateChooser.getDate());
			purchaseinvoices.setSupplierID(suppliers.getSupplierID());
			BigDecimal total = new BigDecimal(jlabelTotal.getText());
			purchaseinvoices.setTotalAmount(total);
			try {
				int id = purchaseinvoices_model.Create(purchaseinvoices);
				Purchaseinvoicedetails_model purchaseinvoicedetails_model = new Purchaseinvoicedetails_model() ;
				if(id != -1) {
					JOptionPane.showMessageDialog(null,"Succes" + id );
					for(Integer saleID : saleIDs) {
						Purchaseinvoicedetails purchaseinvoicedetails = new Purchaseinvoicedetails() ; 
						purchaseinvoicedetails.setDetailID(saleID);
						purchaseinvoicedetails.setInvoiceID(id);
						purchaseinvoicedetails_model.Update(purchaseinvoicedetails);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Please complete all information");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Faild");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,"Please check Profile");
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Purchaseinvoicedetails_model purchaseinvoicedetails_model = new Purchaseinvoicedetails_model() ; 
		Product_model product_model = new Product_model() ;
		
		for(Integer saleID : saleIDs) {
			Purchaseinvoicedetails purchaseinvoicedetails = purchaseinvoicedetails_model.find(saleID) ; 
			int addquantity = purchaseinvoicedetails.getQuantity();//so luong them
			Products products = product_model.find(purchaseinvoicedetails.getProductID());
			System.out.println(products.getProductID());
			System.out.println(products.getProductName());
			System.out.println(products.getQuantity());
			int oldquantity = products.getQuantity() ; //so luong hien tai
			int newquantity = oldquantity + addquantity ; //so luong moi nhat
			products.setProductID(purchaseinvoicedetails.getProductID());
			products.setQuantity(newquantity);
			if(product_model.Update(products)) {
				JOptionPane.showMessageDialog(null,"Succes");
			}
		}
		
		
	}
}
