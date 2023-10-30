package screen;

import java.util.HashMap;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JPstorage extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JTable table;
	private JTextField jtextField_Search;

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
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
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
		
	}
}
