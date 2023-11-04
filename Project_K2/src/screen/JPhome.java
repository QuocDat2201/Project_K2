package screen;

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
		Product.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/897226_balance spendings_budget_money_save money_icon.png")));
		menuBar.add(Product);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Bieu do");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_2_actionPerformed(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/Bar Chart.png")));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tien Ich");
		mntmNewMenuItem_1.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/317717_operating system_windows_icon.png")));
		menuBar.add(mntmNewMenuItem_1);

	}
	public JPhome(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;		
		
	}
	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
		jpanel.removeAll();
		jpanel.revalidate();
		bieudo bieudo1=new bieudo();
		jpanel.add(bieudo1);
		jpanel.setVisible(true);
	}
}
