package scInvoice;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entites.Products;
import entites.Purchaseinvoicedetails;
import models.Product_model;
import models.Purchaseinvoicedetails_model;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class JPPurchaseDetails extends JPanel {
	private JTextField jtextFieldQuantity;
	private int invoiceID = 0 ;
	private JComboBox jcomboBoxProduct;
	private JLabel jlabelPrice;
	private JLabel jlabelTotalPrice;
	private JTable jtableListPurchase;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public JPPurchaseDetails() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 218, 185));
		panel_2.setBorder(new TitledBorder(null, "Create Purchase", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ProductName");
		lblNewLabel.setBounds(97, 48, 77, 24);
		panel_2.add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(97, 89, 77, 24);
		panel_2.add(lblQuantity);
		
		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldQuantity_keyReleased(e);
			}
		});
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(184, 90, 135, 24);
		panel_2.add(jtextFieldQuantity);
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
		});

		
		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setBounds(97, 123, 77, 24);
		panel_2.add(lblNewLabel_2_1);
		
		jlabelPrice = new JLabel("");
		jlabelPrice.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPrice.setBounds(186, 123, 62, 24);
		panel_2.add(jlabelPrice);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(342, 178, 85, 21);
		panel_2.add(btnNewButton);
		
		jcomboBoxProduct = new JComboBox();
		jcomboBoxProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxProduct_actionPerformed(e);
			}
		});
		jcomboBoxProduct.setBounds(184, 48, 135, 24);
		panel_2.add(jcomboBoxProduct);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total");
		lblNewLabel_2_1_1.setBounds(97, 157, 77, 24);
		panel_2.add(lblNewLabel_2_1_1);
		
		jlabelTotalPrice = new JLabel("");
		jlabelTotalPrice.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelTotalPrice.setBounds(186, 157, 62, 24);
		panel_2.add(jlabelTotalPrice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "ListPurchase", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 250, 205));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(255, 182, 193), 2));
		scrollPane.setBounds(10, 29, 586, 136);
		panel_1.add(scrollPane);
		
		jtableListPurchase = new JTable();
		scrollPane.setViewportView(jtableListPurchase);
		
		JButton btnNewButton_2 = new JButton("Thanh Toan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(484, 175, 112, 21);
		panel_1.add(btnNewButton_2);
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
		Purchaseinvoicedetails_model purchaseinvoicedetails_model = new Purchaseinvoicedetails_model() ;
		purchaseinvoicedetails_model.deletepurchase_id();
		
		fillDataToJTable(purchaseinvoicedetails_model.findInvoice_id());
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
			int productID = product.getProductID();
			
			Purchaseinvoicedetails purchaseinvoicedetails = new Purchaseinvoicedetails() ; 
			Purchaseinvoicedetails_model purchaseinvoicedetails_model = new Purchaseinvoicedetails_model() ; 
			purchaseinvoicedetails.setInvoiceID(invoiceID);
			purchaseinvoicedetails.setProductID(product.getProductID());
			purchaseinvoicedetails.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
			BigDecimal total = new BigDecimal(jlabelTotalPrice.getText());
			purchaseinvoicedetails.setUnitPrice(total);
			if(purchaseinvoicedetails_model.Create(purchaseinvoicedetails)) {
				JOptionPane.showMessageDialog(null,"Succes");
				fillDataToJTable(purchaseinvoicedetails_model.findInvoice_id());
			}else {
				JOptionPane.showMessageDialog(null,"Faild");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	protected void do_jcomboBoxProduct_actionPerformed(ActionEvent e) {
		Object selectedProduct = jcomboBoxProduct.getSelectedItem();
		Products product = (Products) selectedProduct;
		int productID = product.getProductID();
		Product_model product_model = new Product_model() ; 
		Products products = product_model.find(productID);
		jlabelPrice.setText(String.valueOf(products.getPrice()));
	}
	protected void do_jtextFieldQuantity_keyReleased(KeyEvent e) {
		try {
//			
			
	        BigDecimal quantity1 = new BigDecimal(jtextFieldQuantity.getText());
	        BigDecimal price1 = new BigDecimal(jlabelPrice.getText());
	        BigDecimal total1 = quantity1.multiply(price1);
	
	        jlabelTotalPrice.setText(total1.toString());

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	public void fillDataToJTable(List<Purchaseinvoicedetails> purchaseinvoicedetails) {
		Product_model product_model = new Product_model() ; 
		DefaultTableModel model = new DefaultTableModel() ; 
		model.addColumn("DetailsID");
		model.addColumn("ProductName");
		model.addColumn("Quantity");
		model.addColumn("Total");
		for(Purchaseinvoicedetails purchaseinvoicedetail : purchaseinvoicedetails ) {
			model.addRow(new Object[]{
				purchaseinvoicedetail.getDetailID(),
				product_model.find(purchaseinvoicedetail.getProductID()).getProductName(),
				purchaseinvoicedetail.getQuantity(),
				purchaseinvoicedetail.getUnitPrice()
			});
		}
		jtableListPurchase.setModel(model);
		jtableListPurchase.getTableHeader().setReorderingAllowed(false);
	}
	
	private List<Integer> getAllSaleIDs() {
	    List<Integer> saleIDs = new ArrayList<>();

	    try {
	        DefaultTableModel model = (DefaultTableModel) jtableListPurchase.getModel();

	        int rowCount = model.getRowCount();

	        for (int i = 0; i < rowCount; i++) {
	            // Lấy giá trị từ cột ID (giả sử ID ở cột 0)
	            Object idObject = model.getValueAt(i, 0);

	            // Chuyển đổi giá trị thành kiểu Integer và thêm vào mảng
	            if (idObject != null) {
	                int saleID = Integer.parseInt(idObject.toString());
	                saleIDs.add(saleID);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return saleIDs;
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		List<Integer> saleIDs = getAllSaleIDs();
		Map<String,Object> data = new HashMap<String,Object>();
		
		data.put("saleIDs",saleIDs);
		if(saleIDs.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No item is Choose.", "Warning", JOptionPane.WARNING_MESSAGE);

		}else {
			panel.removeAll();
			panel.revalidate();
			JPPurchase jpPurchase = new JPPurchase(data) ; 
			panel.add(jpPurchase);
		}
		
	}
}
