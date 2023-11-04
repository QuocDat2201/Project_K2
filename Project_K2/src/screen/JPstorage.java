package screen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

import entites.Category;
import entites.Products;
import models.Category_model;
import models.Product_model;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class JPstorage extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JTable jtableProduct;
	private JTextField jtextField_Search;
	private JPopupMenu popupMenu;
	private JComboBox jcomboBox_category;
	private JComboBox jcomboBox_status;

	/**
	 * Create the panel.
	 */
	public JPstorage() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, JFrameLogin.frameWidth-140,JFrameLogin.frameHeight-300);
		panel.add(scrollPane);
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);

		JMenuItem JMenuItem_Edit = new JMenuItem("Edit");
		JMenuItem_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenuItem_Edit_actionPerformed(e);
			}
		});
		JMenuItem_Edit.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/edit.png")));
		popupMenu.add(JMenuItem_Edit);

		JMenuItem JMenuItem_Delete = new JMenuItem("Delete");
		JMenuItem_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenuItem_Delete_actionPerformed(e);
			}
		});
		JMenuItem_Delete.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/bin (1).png")));
		popupMenu.add(JMenuItem_Delete);

		jtableProduct = new JTable();
		jtableProduct.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableProduct_mouseClicked(e);
			}
		});
		jtableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableProduct);

		JPanel panel_searchname = new JPanel();
		panel_searchname.setBorder(
				new TitledBorder(null, "Search By Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_searchname.setBounds(10, 10, 293, 116);
		panel.add(panel_searchname);
		panel_searchname.setLayout(null);

		jtextField_Search = new JTextField();
		jtextField_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jtextField_Search_keyReleased(e);
			}
		});
		jtextField_Search.setBounds(10, 28, 273, 31);
		panel_searchname.add(jtextField_Search);
		jtextField_Search.setColumns(10);

		JButton jButton_Search = new JButton("Search");
		jButton_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Search_actionPerformed(e);
			}
		});
		jButton_Search.setBounds(96, 69, 85, 25);
		panel_searchname.add(jButton_Search);

		JPanel panel_category = new JPanel();
		panel_category.setBorder(
				new TitledBorder(null, "Search By Category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_category.setBounds(311, 10, 293, 53);
		panel.add(panel_category);
		panel_category.setLayout(null);

		jcomboBox_category = new JComboBox();
		
		jcomboBox_category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBox_category_actionPerformed(e);
			}
		});
		jcomboBox_category.setBounds(10, 22, 273, 21);
		panel_category.add(jcomboBox_category);

		JPanel panel_status = new JPanel();
		panel_status.setBorder(
				new TitledBorder(null, "Search By Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_status.setBounds(311, 73, 293, 53);
		panel.add(panel_status);
		panel_status.setLayout(null);

		jcomboBox_status = new JComboBox();
		jcomboBox_status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBox_status_actionPerformed(e);
			}
		});
		jcomboBox_status.setBounds(10, 22, 273, 21);
		panel_status.add(jcomboBox_status);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 0));
		add(menuBar, BorderLayout.NORTH);

		JMenuItem jmenuitem_storage = new JMenuItem("Storage");
		jmenuitem_storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuitem_storage_actionPerformed(e);
			}
		});
		jmenuitem_storage.setHorizontalAlignment(SwingConstants.CENTER);
		jmenuitem_storage.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/boxes.png")));
		jmenuitem_storage.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_storage);

		JMenuItem jmenuitem_password_1 = new JMenuItem("Change Password");
		jmenuitem_password_1.setHorizontalAlignment(SwingConstants.CENTER);
		jmenuitem_password_1.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/211855_locked_icon.png")));
		jmenuitem_password_1.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_password_1);

		JMenu jMenu_Create = new JMenu("Create Stuff");
		jMenu_Create.setHorizontalAlignment(SwingConstants.CENTER);
		jMenu_Create.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/add.png")));
		menuBar.add(jMenu_Create);

		JMenuItem jMenuItem_CreateProduct = new JMenuItem("Create Product");
		jMenuItem_CreateProduct.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/box.png")));
		jMenu_Create.add(jMenuItem_CreateProduct);

		JMenuItem jMenuItem_CreateCategory = new JMenuItem("Create Category");
		jMenuItem_CreateCategory.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/categories.png")));
		jMenu_Create.add(jMenuItem_CreateCategory);

	}

	public JPstorage(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		initJFrame();
		System.out.println(JFrameLogin.frameHeight+"asdsdd");
	}

	public void initJFrame() {
		Category_model category_model = new Category_model();
		Product_model product_model = new Product_model();
		fillDatatoJTable(product_model.findAll());
		jtableProduct.setComponentPopupMenu(popupMenu);

		DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<Category>();
		for (Category category : category_model.findAll()) {
			model.addElement(category);
		}

		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement("Stocking");
		model2.addElement("Out of stock");

		jcomboBox_category.setModel(model);
		jcomboBox_status.setModel(model2);
		jcomboBox_category.setRenderer(new CategoryCellRender());
		jcomboBox_status.setRenderer(new StatusCellRender());
	}

	public void fillDatatoJTable(List<Products> products) {
		Category_model category_model = new Category_model();
		DefaultTableModel models = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		models.addColumn("Product's ID");
		models.addColumn("Product's Name");
		models.addColumn("Category");
		models.addColumn("Price");
		models.addColumn("Quantily");
		models.addColumn("Status");
		for (Products product : products) {
			models.addRow(new Object[] {
					product.getProductID(),
					product.getProductName(),
					category_model.find(product.getCategory_id()).getCategoryName(), 
					product.getPrice(),
					product.getQuantity(), 
					product.isStatus() == true ? "Stocking" : "Out of stock" });
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

	private class CategoryCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Category category = (Category) value;
			return super.getListCellRendererComponent(list, category.getCategoryName(), index, isSelected,
					cellHasFocus);
		}

	}

	private class StatusCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}

	}

	protected void jButton_Search_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		String name = jtextField_Search.getText().trim();

		fillDatatoJTable(product_model.Search(name));
	}

	protected void jtextField_Search_keyReleased(KeyEvent e) {
		Product_model product_model = new Product_model();
		String name = jtextField_Search.getText().trim();

		fillDatatoJTable(product_model.Search(name));
	}

	protected void jcomboBox_category_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		Category category = (Category) jcomboBox_category.getSelectedItem();
		int id = category.getCategoryID();

		fillDatatoJTable(product_model.Search_Cateogry(id));
	}

	protected void jcomboBox_status_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		String statusName = jcomboBox_status.getSelectedItem().toString();
		boolean status;

		if (statusName.equals("Stocking")) {
			status = true;
		} else {
			status = false;
		}

		fillDatatoJTable(product_model.Search_Status(status));
	}

	protected void jtableProduct_mouseClicked(MouseEvent e) {
		Product_model product_model = new Product_model();
		Category_model category_model = new Category_model();
		JTableHeader header = (JTableHeader) e.getSource();
		int column = header.columnAtPoint(e.getPoint());
		int column2 = header.columnAtPoint(e.getPoint());
		
		switch (column) {
		case 0:
			if (e.getClickCount() % 2 == 0) {
				fillDatatoJTable(product_model.Sort_Name_desc());
			}else {
				fillDatatoJTable(product_model.Sort_Name_asc());
			}
			break;
		case 1:
			if (e.getClickCount() % 2 == 0) {
				fillDatatoJTable(product_model.Sort_Cateogry_desc());
			}else {
				fillDatatoJTable(product_model.Sort_Cateogry_asc());
			}
			break;
		case 2:
			if (e.getClickCount() % 2 == 0) {
				fillDatatoJTable(product_model.Sort_Price_desc());
			}else {
				fillDatatoJTable(product_model.Sort_Price_asc());
			}
			break;
		case 3:
			if (e.getClickCount() % 2 == 0) {
				fillDatatoJTable(product_model.Sort_Quantity_desc());
			}else {
				fillDatatoJTable(product_model.Sort_Quantity_asc());
			}
			break;
		case 4:
			if (e.getClickCount() % 2 == 0) {
				fillDatatoJTable(product_model.Sort_Status_desc());
			}else {
				fillDatatoJTable(product_model.Sort_Status_asc());
			}
			break;
		default:
			fillDatatoJTable(product_model.findAll());
			break;
		}
		
	}
	
	protected void jmenuitem_storage_actionPerformed(ActionEvent e) {
		this.removeAll();
		this.revalidate();
		this.setVisible(true);
	}
	protected void JMenuItem_Delete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure !", "Confirm", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			Product_model product_model = new Product_model();
			int selected = jtableProduct.getSelectedRow();
			int id = Integer.parseInt(jtableProduct.getValueAt(selected, 0).toString());
			
			if (product_model.Delete(id)) {
				JOptionPane.showMessageDialog(null, "Success");
				fillDatatoJTable(product_model.findAll());
			} else {
				JOptionPane.showMessageDialog(null, "Fail");
			}
		}
	}
	protected void JMenuItem_Edit_actionPerformed(ActionEvent e) {
		int selected = jtableProduct.getSelectedRow();
		int id = Integer.parseInt(jtableProduct.getValueAt(selected, 0).toString());
	}
}
