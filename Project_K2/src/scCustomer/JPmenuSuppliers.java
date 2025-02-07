package scCustomer;

import javax.swing.JPanel;

import scInvoice.JPPurchaseDetails;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JPmenuSuppliers extends JPanel {
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public JPmenuSuppliers() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("                                    Supplier");
		mntmNewMenuItem.setIcon(new ImageIcon(JPmenuSuppliers.class.getResource("/Icon/Profile.png")));
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmNewMenuItem.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem.setBackground(new Color(224, 255, 255));
		mntmNewMenuItem.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Purchase");
		mntmNewMenuItem_1.setIcon(new ImageIcon(JPmenuSuppliers.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_1.setBackground(new Color(250, 235, 215));
		mntmNewMenuItem_1.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ListPurchase");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_2_actionPerformed(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(JPmenuSuppliers.class.getResource("/Icon/Modify.png")));
		menuBar.add(mntmNewMenuItem_2);
		initJFrame();
	}
	public void initJFrame() {
		JPsuppliers jPsuppliers = new JPsuppliers() ; 
		panel.removeAll();
		panel.revalidate();
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(jPsuppliers);
		panel.setVisible(true);
	}
	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {
		panel.removeAll(); 
		panel.revalidate();
		JPPurchaseDetails jpPurchaseDetails = new JPPurchaseDetails() ; 
		panel.add(jpPurchaseDetails);
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		panel.removeAll(); 
		panel.revalidate();
		JPsuppliers jPsuppliers = new JPsuppliers() ;
		panel.add(jPsuppliers);
	}
	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
		panel.removeAll(); 
		panel.revalidate();
		JPb jPsuppliers = new JPb() ;
		panel.add(jPsuppliers);
	}
}
