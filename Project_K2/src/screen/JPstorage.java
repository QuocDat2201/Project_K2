package screen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import entites.Products ;
import models.Category_model;
import models.Product_model;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class JPstorage extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JTable jtableProduct;
	private JTextField jtextField_Search;
	private JPopupMenu popupMenu;

	/**
	 * Create the panel.
	 */
	public JPstorage() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 594, 266);
		panel.add(scrollPane);
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem JMenuItem_Edit = new JMenuItem("Edit");
		JMenuItem_Edit.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/edit.png")));
		popupMenu.add(JMenuItem_Edit);
		
		JMenuItem JMenuItem_Delete = new JMenuItem("Delete");
		JMenuItem_Delete.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/bin (1).png")));
		popupMenu.add(JMenuItem_Delete);
		
		jtableProduct = new JTable();
		jtableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableProduct);
		
		JPanel panel_searchname = new JPanel();
		panel_searchname.setBorder(new TitledBorder(null, "Search By Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_searchname.setBounds(10, 10, 293, 116);
		panel.add(panel_searchname);
		panel_searchname.setLayout(null);
		
		jtextField_Search = new JTextField();
		jtextField_Search.setBounds(10, 28, 273, 25);
		panel_searchname.add(jtextField_Search);
		jtextField_Search.setColumns(10);
		
		JButton jButton_Search = new JButton("Search");
		jButton_Search.setBounds(96, 63, 85, 25);
		panel_searchname.add(jButton_Search);
		
		JPanel panel_category = new JPanel();
		panel_category.setBorder(new TitledBorder(null, "Search By Category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_category.setBounds(311, 10, 293, 53);
		panel.add(panel_category);
		panel_category.setLayout(null);
		
		JComboBox jcomboBox_category = new JComboBox();
		jcomboBox_category.setBounds(10, 22, 273, 21);
		panel_category.add(jcomboBox_category);
		
		JPanel panel_status = new JPanel();
		panel_status.setBorder(new TitledBorder(null, "Search By Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_status.setBounds(311, 73, 293, 53);
		panel.add(panel_status);
		panel_status.setLayout(null);
		
		JComboBox jcomboBox_status = new JComboBox();
		jcomboBox_status.setBounds(10, 22, 273, 21);
		panel_status.add(jcomboBox_status);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 0));
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem jmenuitem_storage = new JMenuItem("Storage");
		jmenuitem_storage.setHorizontalAlignment(SwingConstants.CENTER);
		jmenuitem_storage.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/boxes.png")));
		jmenuitem_storage.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_storage);
		
		JMenuItem jmenuitem_password_1 = new JMenuItem("Change Password");
		jmenuitem_password_1.setHorizontalAlignment(SwingConstants.CENTER);
		jmenuitem_password_1.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/211855_locked_icon.png")));
		jmenuitem_password_1.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_password_1);
		
		JMenuItem jmenuitem_password_2 = new JMenuItem("Change Password");
		jmenuitem_password_2.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_password_2);

	}

	public JPstorage(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		initJFrame();
	}
	
	public void initJFrame() {
		Product_model product_model = new Product_model() ; 
		fillDatatoJTable(product_model.findAll());
		jtableProduct.setComponentPopupMenu(popupMenu);
	}
	
	public void fillDatatoJTable(List<Products> products) {
		Category_model category_model = new Category_model();
		DefaultTableModel models = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		} ; 
		models.addColumn("Product's Name");
		models.addColumn("Category");
		models.addColumn("Price");
		models.addColumn("Quantily");
		models.addColumn("Status");
		for(Products product : products) {
			models.addRow(new Object[] {
					product.getProductName(),
					category_model.find(product.getCategory_id()).getCategoryName(),
					product.getPrice(),
					product.getQuantity(),
					product.isStatus() == true ? "Stocking" : "Out of stock"
			});
		}
		jtableProduct.setModel(models);
		jtableProduct.getTableHeader().setReorderingAllowed(false);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
