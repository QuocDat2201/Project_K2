package screen;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPaccount extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel panel;
	private JTextField jpass;
	private JPasswordField jnewPassword;
	private JPasswordField jConfimNewPassword;
	private JMenuItem jmenuAddAccount;
	private URL url1=JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png");
	private URL url2=JPaccount.class.getResource("/Icon/8666618_eye_icon.png");
	private JButton jeyecurent;
	private char f1='\u2022';
	private char f2='\0';
	/**
	 * Create the panel.
	 */
	public JPaccount() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Current Password");
		lblNewLabel.setBounds(34, 76, 145, 25);
		panel.add(lblNewLabel);
		
		jpass = new JTextField();
		jpass.setBounds(204, 76, 176, 28);
		panel.add(jpass);
		jpass.setColumns(10);
		jeyecurent = new JButton();
		jeyecurent.setRequestFocusEnabled(false);
		jeyecurent.setBorderPainted(false);
		jeyecurent.setContentAreaFilled(false);
		jeyecurent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblNewLabel2_mouseClicked(e);
			}
		});
		jeyecurent.setIcon(new ImageIcon(JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png")));
		jeyecurent.setBounds(400, 76, 25, 25);
		panel.add(jeyecurent, BorderLayout.EAST);
		JLabel lblPassword = new JLabel("New Password");
		lblPassword.setBounds(34, 112, 160, 32);
		panel.add(lblPassword);
		JButton lblNewLabel23 = new JButton();
		lblNewLabel23.setRequestFocusEnabled(false);
		lblNewLabel23.setContentAreaFilled(false);
		lblNewLabel23.setBorderPainted(false);
		lblNewLabel23.setIcon(new ImageIcon(JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png")));
		lblNewLabel23.setBounds(400, 112, 25, 25);
		panel.add(lblNewLabel23, BorderLayout.EAST);
		jnewPassword = new JPasswordField();
		jnewPassword.setVerifyInputWhenFocusTarget(false);
		
		jnewPassword.setColumns(10);
		jnewPassword.setBounds(204, 122, 176, 25);
		panel.add(jnewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setBounds(34, 155, 145, 39);
		panel.add(lblConfirmNewPassword);
		
		jConfimNewPassword = new JPasswordField();
		jConfimNewPassword.setColumns(10);
		jConfimNewPassword.setBounds(204, 169, 176, 28);
		panel.add(jConfimNewPassword);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 0));
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Password");
		mntmNewMenuItem.setBackground(new Color(255, 255, 128));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(JPaccount.class.getResource("/Icon/211855_locked_icon.png")));
		menuBar.add(mntmNewMenuItem);
		
		jmenuAddAccount = new JMenuItem("add account");
		jmenuAddAccount.setBackground(new Color(255, 255, 128));
		jmenuAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jmenuAddAccount_actionPerformed(e);
			}
		});
		jmenuAddAccount.setHorizontalAlignment(SwingConstants.LEFT);
		jmenuAddAccount.setIcon(new ImageIcon(JPaccount.class.getResource("/Icon/39039_gtk_add_icon.png")));
		menuBar.add(jmenuAddAccount);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setBackground(new Color(255, 255, 128));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mntmNewMenuItem_3.setBackground(new Color(255, 255, 128));
		menuBar.add(mntmNewMenuItem_3);
		panel.setLayout(new BorderLayout(0, 0));

	}
	public JPaccount(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;
	}
	protected void do_jmenuAddAccount_actionPerformed(ActionEvent e) {
		JPaddAcount jPaccount=new JPaddAcount(dataMap);
		panel.removeAll();
		panel.revalidate();
		panel.add(jPaccount);
		panel.setVisible(true);
	}
	
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		JPaccount jPaccount=new JPaccount();
		this.removeAll();
		this.revalidate();
		this.add(jPaccount);
		this.setVisible(true);
		
	}
	
	protected void do_lblNewLabel2_mouseClicked(MouseEvent e) {
		URL u1=url1;
		url1=url2;
		url2=u1;
		jeyecurent.setIcon(new ImageIcon(url1));
		char ff1=f1;
		f1=f2;
		f2=ff1;	
		jnewPassword.setEchoChar(f1);
		
		
	}
}
