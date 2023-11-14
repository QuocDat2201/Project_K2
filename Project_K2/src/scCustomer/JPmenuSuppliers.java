package scCustomer;

import javax.swing.JPanel;

import scInvoice.JPPurchaseDetails;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Supplier");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Purchase");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_1_actionPerformed(e);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
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
}
