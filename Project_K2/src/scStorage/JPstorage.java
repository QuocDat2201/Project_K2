package scStorage;

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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

import entites.Category;
import entites.Products;
import models.Category_model;
import models.Product_model;
import screen.JFrameLogin;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.math.BigDecimal;
import java.awt.event.MouseWheelEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.border.EtchedBorder;

public class JPstorage extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JTextField jtextField_Search;
	private JTable jtableProduct;
	private JComboBox jcomboBox_status;
	private JComboBox jcomboBox_category;
	private JButton jButton_Search;
	private JMenuItem JMenuItem_Edit;
	private JMenuItem JMenuItem_Delete;
	private JPopupMenu popupMenu;
	private JPanel panel_main;
	private JPanel panel_storage;
	private JPanel panel_edit;
	private JTextField JtextField_name;
	private JTextField JtextField_price;
	private JTextField JtextField_quantity;
	private JTextField JtextField_status;
	private JButton JButton_Save;
	private JButton JButton_Cancel;
	private Products products;
	private JComboBox JcomboBox_Category;
	private JPanel panel_CreateProduct;
	private JLabel JLabel_createName;
	private JLabel lblCreateProduct;
	private JTextField jtextField_createName;
	private JLabel JLabel_createPrice;
	private JTextField jtextField_createPrice;
	private JLabel JLabel_createQuantity;
	private JLabel JLabel_createStatus;
	private JTextField jtextField_createQuantity;
	private JTextField jtextField_createStatus;
	private JLabel JLabel_createCategory;
	private JComboBox JcomboBox_createCategory;
	private JButton JButton_Cancel_1;
	private JButton JButton_Save_1;
	private JPanel panel_CategoryList;
	private JPanel panel_SearchCatName;
	private JTextField JtextField_Catname;
	private JButton jButton_SearchCatName;
	private JTable Jtable_Category;

	/**
	 * Create the panel.
	 */
	public JPstorage() {
		setLayout(new BorderLayout(0, 0));

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

		JMenuItem jmenuitem_Category = new JMenuItem("Category");
		jmenuitem_Category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuitem_Category_actionPerformed(e);
			}
		});
		jmenuitem_Category.setHorizontalAlignment(SwingConstants.CENTER);
		jmenuitem_Category.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/categories.png")));
		jmenuitem_Category.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_Category);

		JMenu jMenu_Create = new JMenu("New Create");
		jMenu_Create.setHorizontalAlignment(SwingConstants.CENTER);
		jMenu_Create.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/add.png")));
		menuBar.add(jMenu_Create);

		JMenuItem jMenuItem_CreateProduct = new JMenuItem("Create Product");
		jMenuItem_CreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_CreateProduct_actionPerformed(e);
			}
		});
		jMenuItem_CreateProduct.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/box.png")));
		jMenu_Create.add(jMenuItem_CreateProduct);

		JMenuItem jMenuItem_CreateCategory = new JMenuItem("Create Category");
		jMenuItem_CreateCategory.setIcon(new ImageIcon(JPstorage.class.getResource("/Icon/categories.png")));
		jMenu_Create.add(jMenuItem_CreateCategory);

		panel_main = new JPanel();
		add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new CardLayout(0, 0));

		panel_storage = new JPanel();
		panel_storage.setLayout(null);
		panel_main.add(panel_storage, "name_793040110708900");

		JPanel panel_searchname = new JPanel();
		panel_searchname.setLayout(null);
		panel_searchname.setBorder(
				new TitledBorder(null, "Search By Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_searchname.setBounds(10, 10, 293, 116);
		panel_storage.add(panel_searchname);

		jtextField_Search = new JTextField();
		jtextField_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textField_keyReleased(e);
			}
		});
		jtextField_Search.setColumns(10);
		jtextField_Search.setBounds(10, 28, 273, 31);
		panel_searchname.add(jtextField_Search);

		jButton_Search = new JButton("Search");
		jButton_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Search_actionPerformed(e);
			}
		});
		jButton_Search.setBounds(96, 69, 85, 25);
		panel_searchname.add(jButton_Search);

		JPanel panel_category = new JPanel();
		panel_category.setLayout(null);
		panel_category.setBorder(
				new TitledBorder(null, "Search By Category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_category.setBounds(311, 10, 293, 53);
		panel_storage.add(panel_category);

		jcomboBox_category = new JComboBox();
		jcomboBox_category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBox_category_actionPerformed(e);
			}
		});
		jcomboBox_category.setBounds(10, 22, 273, 21);
		panel_category.add(jcomboBox_category);

		JPanel panel_status = new JPanel();
		panel_status.setLayout(null);
		panel_status.setBorder(
				new TitledBorder(null, "Search By Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_status.setBounds(311, 73, 293, 53);
		panel_storage.add(panel_status);

		jcomboBox_status = new JComboBox();
		jcomboBox_status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBox_status_actionPerformed(e);
			}
		});
		jcomboBox_status.setBounds(10, 22, 273, 21);
		panel_status.add(jcomboBox_status);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, JFrameLogin.frameWidth-140,JFrameLogin.frameHeight-250);
		panel_storage.add(scrollPane);

		jtableProduct = new JTable();
		jtableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableProduct.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableProduct_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableProduct);

		popupMenu = new JPopupMenu();
		addPopup(jtableProduct, popupMenu);

		JMenuItem_Delete = new JMenuItem("Delete");
		JMenuItem_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenuItem_Delete_actionPerformed(e);
			}
		});
		JMenuItem_Delete.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/bin (1).png")));
		popupMenu.add(JMenuItem_Delete);

		JMenuItem_Edit = new JMenuItem("Edit");
		JMenuItem_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenuItem_Edit_actionPerformed(e);
			}
		});
		JMenuItem_Edit.setIcon(new ImageIcon(JPstorage.class.getResource("/Small_Icon/edit.png")));
		popupMenu.add(JMenuItem_Edit);

		panel_edit = new JPanel();
		panel_edit.setBorder(
				new TitledBorder(null, "Update Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_main.add(panel_edit, "name_795440720438400");
		panel_edit.setLayout(null);

		JLabel JLabel_name = new JLabel("Product's Name");
		JLabel_name.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_name.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_name.setBounds(20, 69, 277, 24);
		panel_edit.add(JLabel_name);

		JLabel lblNewLabel = new JLabel("Update Product");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 35, 594, 24);
		panel_edit.add(lblNewLabel);

		JtextField_name = new JTextField();
		JtextField_name.setColumns(10);
		JtextField_name.setBounds(20, 98, 271, 24);
		panel_edit.add(JtextField_name);

		JLabel JLabel_price = new JLabel("Price");
		JLabel_price.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_price.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_price.setBounds(317, 69, 271, 24);
		panel_edit.add(JLabel_price);

		JtextField_price = new JTextField();
		JtextField_price.setColumns(10);
		JtextField_price.setBounds(317, 98, 271, 24);
		panel_edit.add(JtextField_price);

		JLabel JLabel_quantity = new JLabel("Quantity");
		JLabel_quantity.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_quantity.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_quantity.setBounds(20, 132, 277, 24);
		panel_edit.add(JLabel_quantity);

		JLabel JLabel_status = new JLabel("Status");
		JLabel_status.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_status.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_status.setBounds(317, 132, 271, 24);
		panel_edit.add(JLabel_status);

		JtextField_quantity = new JTextField();
		JtextField_quantity.setColumns(10);
		JtextField_quantity.setBounds(20, 166, 271, 24);
		panel_edit.add(JtextField_quantity);

		JtextField_status = new JTextField();
		JtextField_status.setEnabled(false);
		JtextField_status.setEditable(false);
		JtextField_status.setColumns(10);
		JtextField_status.setBounds(317, 166, 271, 24);
		panel_edit.add(JtextField_status);

		JLabel JLabel_category = new JLabel("Category");
		JLabel_category.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_category.setBounds(20, 200, 277, 24);
		panel_edit.add(JLabel_category);

		JcomboBox_Category = new JComboBox();
		JcomboBox_Category.setBounds(20, 234, 271, 24);
		panel_edit.add(JcomboBox_Category);

		JButton_Cancel = new JButton("Cancel");
		JButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton_Cancel_actionPerformed(e);
			}
		});
		JButton_Cancel.setBounds(403, 236, 85, 21);
		panel_edit.add(JButton_Cancel);

		JButton_Save = new JButton("Save");
		JButton_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton_Save_actionPerformed(e);
			}
		});
		JButton_Save.setBounds(498, 236, 85, 21);
		panel_edit.add(JButton_Save);
		
		panel_CreateProduct = new JPanel();
		panel_CreateProduct.setLayout(null);
		panel_CreateProduct.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Create Product", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_CreateProduct, "name_1041333684938200");
		
		JLabel_createName = new JLabel("Product's Name");
		JLabel_createName.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_createName.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_createName.setBounds(20, 69, 277, 24);
		panel_CreateProduct.add(JLabel_createName);
		
		lblCreateProduct = new JLabel("Create Product");
		lblCreateProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateProduct.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCreateProduct.setBounds(10, 35, 594, 24);
		panel_CreateProduct.add(lblCreateProduct);
		
		jtextField_createName = new JTextField();
		jtextField_createName.setColumns(10);
		jtextField_createName.setBounds(20, 98, 271, 24);
		panel_CreateProduct.add(jtextField_createName);
		
		JLabel_createPrice = new JLabel("Price");
		JLabel_createPrice.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_createPrice.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_createPrice.setBounds(317, 69, 271, 24);
		panel_CreateProduct.add(JLabel_createPrice);
		
		jtextField_createPrice = new JTextField();
		jtextField_createPrice.setColumns(10);
		jtextField_createPrice.setBounds(317, 98, 271, 24);
		panel_CreateProduct.add(jtextField_createPrice);
		
		JLabel_createQuantity = new JLabel("Quantity");
		JLabel_createQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_createQuantity.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_createQuantity.setBounds(20, 132, 277, 24);
		panel_CreateProduct.add(JLabel_createQuantity);
		
		JLabel_createStatus = new JLabel("Status");
		JLabel_createStatus.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_createStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel_createStatus.setBounds(317, 132, 271, 24);
		panel_CreateProduct.add(JLabel_createStatus);
		
		jtextField_createQuantity = new JTextField();
		jtextField_createQuantity.setColumns(10);
		jtextField_createQuantity.setBounds(20, 166, 271, 24);
		panel_CreateProduct.add(jtextField_createQuantity);
		
		jtextField_createStatus = new JTextField();
		jtextField_createStatus.setEnabled(false);
		jtextField_createStatus.setEditable(false);
		jtextField_createStatus.setColumns(10);
		jtextField_createStatus.setBounds(317, 166, 271, 24);
		panel_CreateProduct.add(jtextField_createStatus);
		
		JLabel_createCategory = new JLabel("Category");
		JLabel_createCategory.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel_createCategory.setBounds(20, 200, 277, 24);
		panel_CreateProduct.add(JLabel_createCategory);
		
		JcomboBox_createCategory = new JComboBox();
		JcomboBox_createCategory.setBounds(20, 234, 271, 24);
		panel_CreateProduct.add(JcomboBox_createCategory);
		
		JButton_Cancel_1 = new JButton("Cancel");
		JButton_Cancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton_Cancel_1_actionPerformed(e);
			}
		});
		JButton_Cancel_1.setBounds(403, 236, 85, 21);
		panel_CreateProduct.add(JButton_Cancel_1);
		
		JButton_Save_1 = new JButton("Save");
		JButton_Save_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton_Save_1_actionPerformed(e);
			}
		});
		JButton_Save_1.setBounds(498, 236, 85, 21);
		panel_CreateProduct.add(JButton_Save_1);
		
		panel_CategoryList = new JPanel();
		panel_CategoryList.setLayout(null);
		panel_main.add(panel_CategoryList, "name_1051396032192500");
		
		panel_SearchCatName = new JPanel();
		panel_SearchCatName.setLayout(null);
		panel_SearchCatName.setBorder(new TitledBorder(null, "Search By Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SearchCatName.setBounds(10, 10, 600, 116);
		panel_CategoryList.add(panel_SearchCatName);
		
		JtextField_Catname = new JTextField();
		JtextField_Catname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JtextField_Catname_keyReleased(e);
			}
		});
		JtextField_Catname.setColumns(10);
		JtextField_Catname.setBounds(10, 28, 580, 31);
		panel_SearchCatName.add(JtextField_Catname);
		
		jButton_SearchCatName = new JButton("Search");
		jButton_SearchCatName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_SearchCatName_actionPerformed(e);
			}
		});
		jButton_SearchCatName.setBounds(254, 68, 85, 25);
		panel_SearchCatName.add(jButton_SearchCatName);
		
		JScrollPane JscrollPane_Category = new JScrollPane();
		JscrollPane_Category.setBounds(10, 136, 600, 245);
		panel_CategoryList.add(JscrollPane_Category);
		
		Jtable_Category = new JTable();
		Jtable_Category.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JscrollPane_Category.setViewportView(Jtable_Category);

	}

	public JPstorage(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		initJFrame();
	}
/************************** Begin of Storage JPanel *********************************/
	
	public void initJFrame() {
		Category_model category_model = new Category_model();
		Product_model product_model = new Product_model();
		FillDataToJTableProduct(product_model.findAll());
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

	public void FillDataToJTableProduct(List<Products> products) {
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
			models.addRow(new Object[] { product.getProductID(), product.getProductName(),
					category_model.find(product.getCategory_id()).getCategoryName(), product.getPrice(),
					product.getQuantity(), product.isStatus() == true ? "Stocking" : "Out of stock" });
		}

		jtableProduct.setModel(models);
		jtableProduct.getTableHeader().setReorderingAllowed(false);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
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

	protected void jtableProduct_mouseClicked(MouseEvent e) {
		Product_model product_model = new Product_model();
		Category_model category_model = new Category_model();
		JTableHeader header = (JTableHeader) e.getSource();
		int column = header.columnAtPoint(e.getPoint());
		int column2 = header.columnAtPoint(e.getPoint());

		switch (column) {
		case 0:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_ID_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_ID_asc());
			}
			break;
		case 1:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_Name_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_Name_asc());
			}
			break;
		case 2:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_Cateogry_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_Cateogry_asc());
			}
			break;
		case 3:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_Price_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_Price_asc());
			}
			break;
		case 4:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_Quantity_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_Quantity_asc());
			}
			break;
		case 5:
			if (e.getClickCount() % 2 == 0) {
				FillDataToJTableProduct(product_model.Sort_Status_desc());
			} else {
				FillDataToJTableProduct(product_model.Sort_Status_asc());
			}
			break;
		default:
			FillDataToJTableProduct(product_model.findAll());
			break;
		}

	}

	protected void jmenuitem_storage_actionPerformed(ActionEvent e) {
		panel_storage.setVisible(true);
	}

	protected void JMenuItem_Delete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure !", "Confirm", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			Product_model product_model = new Product_model();
			int selected = jtableProduct.getSelectedRow();
			int id = Integer.parseInt(jtableProduct.getValueAt(selected, 0).toString());

			if (product_model.Delete(id)) {
				JOptionPane.showMessageDialog(null, "Success");
				FillDataToJTableProduct(product_model.findAll());
			} else {
				JOptionPane.showMessageDialog(null, "Fail");
			}
		}
	}

	protected void textField_keyReleased(KeyEvent e) {
		Product_model product_model = new Product_model();
		String name = jtextField_Search.getText().trim();

		FillDataToJTableProduct(product_model.Search(name));
	}

	protected void jcomboBox_category_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		Category category = (Category) jcomboBox_category.getSelectedItem();
		int id = category.getCategoryID();

		FillDataToJTableProduct(product_model.Search_Cateogry(id));
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

		FillDataToJTableProduct(product_model.Search_Status(status));
	}

	protected void jButton_Search_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		String name = jtextField_Search.getText().trim();

		FillDataToJTableProduct(product_model.Search(name));
	}

/************************************** End of Storage JPanel ************************************/
	
/************************************** Start of Edit JPanel ************************************/
	protected void JMenuItem_Edit_actionPerformed(ActionEvent e) {
		Product_model product_model = new Product_model();
		Category_model category_model = new Category_model();
		int selected = jtableProduct.getSelectedRow();
		int id = Integer.parseInt(jtableProduct.getValueAt(selected, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);

		products = product_model.find(Integer.parseInt(data.get("id").toString()));
		JtextField_name.setText(products.getProductName());
		JtextField_price.setText(String.valueOf(products.getPrice()));
		JtextField_quantity.setText(String.valueOf(products.getQuantity()));

		boolean status = products.isStatus();
		
		if (status == true) {
			JtextField_status.setText("Stocking");
		} else {
			JtextField_status.setText("Out of Stock");
		}
		
		DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<Category>();
		for (Category category : category_model.findAll()) {
			model.addElement(category);
			model.setSelectedItem(category_model.find(products.getCategory_id()));
		}
		
		JcomboBox_Category.setModel(model);
		JcomboBox_Category.setRenderer(new CategoryEditCellRender());
		
		panel_edit.setVisible(true);
		panel_storage.setVisible(false);
		panel_CreateProduct.setVisible(false);
		panel_CategoryList.setVisible(false);

	}
	
	protected void JButton_Save_actionPerformed(ActionEvent e) {
		try {

			Product_model product_model = new Product_model();
			
			products.setProductName(JtextField_name.getText());
			Category category = (Category) JcomboBox_Category.getSelectedItem();
			products.setCategory_id(category.getCategoryID());
			
			// start same name and same category
			boolean productname = true;
				for (Products products2 : product_model.findAll()) {
					if (products2.getProductName().equalsIgnoreCase(JtextField_name.getText().trim()) && products2.getCategory_id() == category.getCategoryID() && products2.getProductID() != products.getProductID()) {
						productname = false;
					}
				}
			// end same name and same category
			
			if (productname == false) {
				JOptionPane.showMessageDialog(null, "This product already exists in category " + category.getCategoryName());
			} else {
				// start price < 0	
				BigDecimal price = new BigDecimal(JtextField_price.getText());
				int result = price.compareTo(BigDecimal.ZERO);
				if (result < 0) {
					products.setPrice(new BigDecimal(0));
				} else {
					products.setPrice(new BigDecimal(JtextField_price.getText()));
				}
				// end price < 0
				
				// start quantity < 0
				if (Integer.parseInt(JtextField_quantity.getText()) < 0) {
					products.setQuantity(0);
				} else {
					products.setQuantity(Integer.parseInt(JtextField_quantity.getText()));
				}
				// end quantity < 0			
				
				// start status set boolean
				if (Integer.parseInt(JtextField_quantity.getText()) <= 10) {
					products.setStatus(false);
				} else {
					products.setStatus(true);
				}
				// end status set boolean			
				
				if (product_model.Update(products)) {
					JOptionPane.showMessageDialog(null, "Update Completed !");	
					panel_edit.setVisible(false);
					panel_storage.setVisible(true);
					FillDataToJTableProduct(product_model.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Update Failed !");
				}
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	protected void JButton_Cancel_actionPerformed(ActionEvent e) {
		panel_edit.setVisible(false);
		panel_storage.setVisible(true);
	}
	
	private class CategoryEditCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Category category = (Category) value;
			return super.getListCellRendererComponent(list, category.getCategoryName(), index, isSelected,
					cellHasFocus);
		}

	}
	/************************************** End of Edit JPanel ************************************/
	
	/************************************** Start of Create Products JPanel ************************************/
	protected void jMenuItem_CreateProduct_actionPerformed(ActionEvent e) {
		Category_model category_model = new Category_model();
		panel_CreateProduct.setVisible(true);
		panel_storage.setVisible(false);
		panel_CategoryList.setVisible(false);
		panel_edit.setVisible(false);
		
		DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<Category>();
		for (Category category : category_model.findAll()) {
			model.addElement(category);
		}
		
		JcomboBox_createCategory.setModel(model);
		JcomboBox_createCategory.setRenderer(new CategoryCPCellRender());
	}
	
	protected void JButton_Save_1_actionPerformed(ActionEvent e) {
		Products products = new Products();
		Product_model product_model = new Product_model();

		Category selected = (Category) JcomboBox_createCategory.getSelectedItem();
		products.setCategory_id(selected.getCategoryID());
		
		// start same name and same category
		boolean productname = true;
			for (Products products2 : product_model.findAll()) {
				if (products2.getProductName().equalsIgnoreCase(jtextField_createName.getText().trim()) && products2.getCategory_id() == selected.getCategoryID()) {
					productname = false;
				}
			}
		// end same name and same category
			if (productname == false) {
				JOptionPane.showMessageDialog(null, "This product name already exists in category " + selected.getCategoryName());
			} else {
				products.setProductName(jtextField_createName.getText());
			
			// start price < 0	
				BigDecimal price = new BigDecimal(jtextField_createPrice.getText());
				int result = price.compareTo(BigDecimal.ZERO);
				if (result < 0) {
					products.setPrice(new BigDecimal(0));
				} else {
					products.setPrice(new BigDecimal(jtextField_createPrice.getText()));
				}
			// end price < 0
						
			// start quantity < 0
				if (Integer.parseInt(jtextField_createQuantity.getText()) < 0) {
					products.setQuantity(0);
				} else {
					products.setQuantity(Integer.parseInt(jtextField_createQuantity.getText()));
				}
			// end quantity < 0			
						
			// start status set boolean
				if (Integer.parseInt(jtextField_createQuantity.getText()) <= 10) {
					products.setStatus(false);
				} else {
					products.setStatus(true);
				}
			// end status set boolean
				
				if (product_model.Create(products)) {
					JOptionPane.showMessageDialog(null, "Create Product Completed !");
					panel_edit.setVisible(false);
					panel_storage.setVisible(true);
					FillDataToJTableProduct(product_model.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Create Product Failed");
				}
			}
	}
	
	protected void JButton_Cancel_1_actionPerformed(ActionEvent e) {
		panel_CreateProduct.setVisible(false);
		panel_storage.setVisible(true);
	}
	
	private class CategoryCPCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Category category = (Category) value;
			return super.getListCellRendererComponent(list, category.getCategoryName(), index, isSelected,
					cellHasFocus);
		}

	}
	
	/************************************** End of Create Products JPanel ************************************/
	
	/************************************** Start of Listed Category JPanel ************************************/
	protected void jmenuitem_Category_actionPerformed(ActionEvent e) {
		Category category = new Category();
		Category_model category_model = new Category_model();
		FillDataToJTableCategory(category_model.findAll());
		
		panel_CategoryList.setVisible(true);
		panel_storage.setVisible(false);
		panel_CreateProduct.setVisible(false);
		panel_edit.setVisible(false);
	}
	
	public void FillDataToJTableCategory(List<Category> categories) {
		Category_model category_model = new Category_model();
		Product_model product_model = new Product_model();
		DefaultTableModel models = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		models.addColumn("Category's ID");
		models.addColumn("Category's Name");
		models.addColumn("Number of Products");
		for (Category category : categories) {
			models.addRow(new Object[] { 
					category.getCategoryID(), 
					category.getCategoryName(),
					product_model.findCID(category.getCategoryID()) + " Products"
			});
		}
		
		Jtable_Category.setModel(models);
		Jtable_Category.getTableHeader().setReorderingAllowed(false);
		Jtable_Category.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Jtable_Category.getColumnModel().getColumn(0).setPreferredWidth(100);
		Jtable_Category.getColumnModel().getColumn(1).setPreferredWidth(247);
		Jtable_Category.getColumnModel().getColumn(2).setPreferredWidth(247);
	}
	protected void JtextField_Catname_keyReleased(KeyEvent e) {
		Category_model category_model = new Category_model();
		String name = JtextField_Catname.getText();
		
		FillDataToJTableCategory(category_model.Search(name));
	}
	
	protected void jButton_SearchCatName_actionPerformed(ActionEvent e) {
		Category_model category_model = new Category_model();
		String name = JtextField_Catname.getText();
		
		FillDataToJTableCategory(category_model.Search(name));
	}
}
