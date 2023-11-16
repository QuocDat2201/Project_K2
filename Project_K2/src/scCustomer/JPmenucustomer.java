package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JPmenucustomer extends JPanel {
	private JPanel panel;
	public static JMenuItem mntmNewMenuItem_1 ;//rank
		
	
	/**
	 * Create the panel.
	 */
	public JPmenucustomer() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		JMenuItem mntmNewMenuItem = new JMenuItem("Customer");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(JPcustomer.class.getResource("/Icon/Profile.png")));
		menuBar.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Rank");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(JPcustomer.class.getResource("/Icon/7007523_rate_ranking_rank_finance_business_icon.png")));
		menuBar.add(mntmNewMenuItem_1);
		iniJFrame();
	}

	private void iniJFrame() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Phone");
		model.addColumn("Point");
		model.addColumn("Rank");
		CustomerModel customerModel = new CustomerModel();try {
			for (Customer customer : customerModel.findAll()) {
				model.addRow(new Object[] { customer.getNameString(), customer.getPhoneString(), customer.getPoint(),
						customer.getRank() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		int rowHeight = 25;
		panel.removeAll();
		panel.revalidate();
		JPcustomer jPcustomer=new JPcustomer();
		panel.add(jPcustomer);
		panel.setVisible(true);;

	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		panel.removeAll();
		panel.revalidate();
		JPcustomer jPcustomer=new JPcustomer();
		panel.add(jPcustomer);
		panel.setVisible(true);
	}
	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {
		panel.removeAll();
		panel.revalidate();
		JPrank jPrank=new JPrank();
		panel.add(jPrank);
		panel.setVisible(true);
	}
}
