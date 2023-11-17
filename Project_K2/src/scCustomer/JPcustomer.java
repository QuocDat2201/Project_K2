package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entites.Customer;
import models.CustomerModel;
import screen.Home;
import screen.PlacehoclderTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPcustomer extends JPanel {
	private JTable table;
	private JPanel panel_1;
	private JButton jSeacrch;
	private PlacehoclderTextField jsearch;

	/**
	 * Create the panel.
	 */
	public JPcustomer() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);

		jsearch = new PlacehoclderTextField("search name or phone");
		jsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jsearch_keyReleased(e);
			}
		});
		jsearch.setMargin(new Insets(3, 20, 3, 20));
		panel_1.add(jsearch);
		jsearch.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setMargin(new Insets(2, 10, 2, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		jSeacrch = new JButton("");
		jSeacrch.setMargin(new Insets(2, 2, 2, 2));
		jSeacrch.setIcon(new ImageIcon(JPcustomer.class.getResource("/Icon/4781817_brows_browsing_find_search_seo_icon.png")));
		panel_1.add(jSeacrch);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(JPcustomer.class.getResource("/Icon/customer (1).png")));
		panel_1.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 0, 0));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		popupMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		popupMenu.add(mntmNewMenuItem_1);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setComponentPopupMenu(popupMenu);
		iniJFrame();
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		JPaddcustomer jPaddcustomer = new JPaddcustomer();
		panel_1.removeAll();
		panel_1.revalidate();
		panel_1.add(jPaddcustomer);
		panel_1.setVisible(true);
	}

	private void iniJFrame() {
		CustomerModel customerModel = new CustomerModel();
		filldata(customerModel.findAll());

	}
	private void filldata(List<Customer> cus) {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	   }};
	   model.addColumn("Id");
	model.addColumn("Name");
	model.addColumn("Phone");
	model.addColumn("Point");
	model.addColumn("Rank");
	try {
		for (Customer customer : cus) {
			model.addRow(new Object[] {customer.getId(), customer.getNameString(), customer.getPhoneString(), customer.getPoint(),
					customer.getRank() });

		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	table.setModel(model);
	int rowHeight = 25; // Đặt chiều cao hàng tùy ý
	table.setRowHeight(rowHeight);
	table.getTableHeader().setReorderingAllowed(false);

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
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {//edit
		int index = table.getSelectedRow();
		int id =(int) table.getValueAt(index,0);
		panel_1.removeAll();
		panel_1.revalidate();
		JPupdatecus uPupdatecus=new JPupdatecus(id);
		panel_1.add(uPupdatecus);
		panel_1.setVisible(true);
		
	}
	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {//delete
		int index = table.getSelectedRow();
		int id =(int) table.getValueAt(index,0);
		CustomerModel customerModel=new CustomerModel();
		if (customerModel.deleteById(id)) {
			JOptionPane.showMessageDialog(null, "sucess");
			Home.jbcusstomer.doClick();
		} else {
			JOptionPane.showMessageDialog(null, "faild");
		}
	}
	protected void do_jsearch_keyReleased(KeyEvent e) {
		CustomerModel customerModel=new CustomerModel();
		String keyString=jsearch.getText();
	
		filldata(customerModel.searchByNameOrPhone(keyString));
	}
}
