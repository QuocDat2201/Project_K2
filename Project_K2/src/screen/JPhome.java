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
	private JLabel jlblNewLabel;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu;
	/**
	 * Create the panel.
	 */
	public JPhome() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 217, 232));
		add(panel);
		panel.setLayout(null);
		
		jlblNewLabel = new JLabel("Home");
		jlblNewLabel.setBounds(189, 93, 198, 75);
		panel.add(jlblNewLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(354, 233, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(340, 53, 46, 14);
		panel.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("New menu");
		mnNewMenu.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/39039_gtk_add_icon.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnNewMenu.add(mnNewMenu_1);
		
		
		mnNewMenu_2 = new JMenu("New menu");
		mnNewMenu_2.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/39516_dialog_error_icon.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		mnNewMenu_3.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/29280_new_spreadsheet_icon.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setIcon(new ImageIcon(JPhome.class.getResource("/Icon/Bar Chart.png")));
		menuBar.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("New menu");
		menuBar.add(mnNewMenu_4);

	}
	public JPhome(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;		
		jlblNewLabel.setText((String) dataMap.get("key"));
		if (String.valueOf(dataMap.get("key")).equalsIgnoreCase("abc") ) {
			mnNewMenu.setEnabled(false);
			
		} else {

		}
	}
}
