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

public class JPhome extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPhome() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 217, 232));
		add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem Product = new JMenuItem("New menu item");
		menuBar.add(Product);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_4);

	}
	public JPhome(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;		
		
	}
}
