package scHome;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//alo
public class JPhome extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel jpanel;
	/**
	 * Create the panel.
	 */
	public JPhome() {
		setLayout(new BorderLayout(0, 0));
		
		jpanel = new JPanel();
		jpanel.setBackground(new Color(255, 217, 232));
		add(jpanel);
		jpanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem Product = new JMenuItem("Doanh so");
		Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Product_actionPerformed(e);
			}
		});
		Product.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/897226_balance spendings_budget_money_save money_icon.png")));
		menuBar.add(Product);
		
		JMenu mnNewMenu = new JMenu("Bieu do");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mnNewMenu_actionPerformed(e);
			}
		});
		mnNewMenu.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/Bar Chart.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem bieudocategogy = new JMenuItem("ChartCategory");
		bieudocategogy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bieudocategogy_actionPerformed(e);
			}
		});
		mnNewMenu.add(bieudocategogy);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ChartProduct");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_2_actionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("BieudoDoanhthu");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tien Ich");
		mntmNewMenuItem_1.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/317717_operating system_windows_icon.png")));
		menuBar.add(mntmNewMenuItem_1);

	}
	public JPhome(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;
		jpanel.removeAll();
		jpanel.revalidate();
		jpaneldoanhso jpaneldoanhso=new jpaneldoanhso();
		jpanel.add(jpaneldoanhso);
		jpanel.setVisible(true);
		
	}
	protected void do_Product_actionPerformed(ActionEvent e) {
		jpanel.removeAll();
		jpanel.revalidate();
		jpaneldoanhso jpaneldoanhso=new jpaneldoanhso();
		jpanel.add(jpaneldoanhso);
		jpanel.setVisible(true);
	}
	protected void do_mnNewMenu_actionPerformed(ActionEvent e) {
		jpanel.removeAll();
		jpanel.revalidate();
		bieudo bieudo1=new bieudo();
		jpanel.add(bieudo1);
		jpanel.setVisible(true);
	}
	protected void do_bieudocategogy_actionPerformed(ActionEvent e) {
		jpanel.removeAll();
		jpanel.revalidate();
		bieudo bieudo1=new bieudo();
		jpanel.add(bieudo1);
		jpanel.setVisible(true);
	}
	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
		jpanel.removeAll();
		jpanel.revalidate();
		JPChartProduct bieudo1=new JPChartProduct();
		jpanel.add(bieudo1);
		jpanel.setVisible(true);
	}
}
