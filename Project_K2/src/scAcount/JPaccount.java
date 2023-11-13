package scAcount;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import javax.swing.border.LineBorder;

import org.mindrot.jbcrypt.BCrypt;

import entites.Users;
import models.UsersModel;

import java.awt.Font;
import javax.swing.border.TitledBorder;

public class JPaccount extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JPanel panel;
	private JPasswordField jpass;
	private JPasswordField jnewPassword;
	private JPasswordField jConfimNewPassword;
	private JMenuItem jmenuAddAccount;
	private URL url1 = JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png");
	private URL url2 = JPaccount.class.getResource("/Icon/8666618_eye_icon.png");
	private JButton jeyecurent;
	private char f1 = '\u2022';
	private char f2 = '\0';
	private JButton jeyenewpass;
	private JButton jeyenewpass_1;

	/**
	 * Create the panel.
	 */
	public JPaccount() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Change Password", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(240, 240, 240));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Current Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(168, 46, 176, 25);
		panel.add(lblNewLabel);

		jpass = new JPasswordField();
		jpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jpass.setBackground(new Color(255, 255, 255));
		jpass.setBounds(168, 73, 243, 28);
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
		jeyecurent.setIcon(
				new ImageIcon(JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png")));
		jeyecurent.setBounds(421, 73, 25, 28);
		panel.add(jeyecurent);
		JLabel lblPassword = new JLabel("New Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(168, 111, 176, 25);
		panel.add(lblPassword);
		jeyenewpass = new JButton();
		jeyenewpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_lblNewLabel23_actionPerformed(e);
			}
		});
		jeyenewpass.setRequestFocusEnabled(false);
		jeyenewpass.setContentAreaFilled(false);
		jeyenewpass.setBorderPainted(false);
		jeyenewpass.setIcon(
				new ImageIcon(JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png")));
		jeyenewpass.setBounds(421, 134, 25, 25);
		panel.add(jeyenewpass);
		jnewPassword = new JPasswordField();
		jnewPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jnewPassword.setBackground(new Color(255, 255, 255));
		jnewPassword.setVerifyInputWhenFocusTarget(false);

		jnewPassword.setColumns(10);
		jnewPassword.setBounds(168, 134, 243, 28);
		panel.add(jnewPassword);

		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmNewPassword.setBounds(168, 172, 176, 25);
		panel.add(lblConfirmNewPassword);

		jConfimNewPassword = new JPasswordField();
		jConfimNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jConfimNewPassword.setBackground(new Color(255, 255, 255));
		jConfimNewPassword.setColumns(10);
		jConfimNewPassword.setBounds(168, 195, 243, 28);
		panel.add(jConfimNewPassword);

		jeyenewpass_1 = new JButton();
		jeyenewpass_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jeyenewpass_1_actionPerformed(e);
			}
		});
		jeyenewpass_1.setIcon(
				new ImageIcon(JPaccount.class.getResource("/Icon/3994371_eye_hidden_hide_invisible_private_icon.png")));
		jeyenewpass_1.setRequestFocusEnabled(false);
		jeyenewpass_1.setContentAreaFilled(false);
		jeyenewpass_1.setBorderPainted(false);
		jeyenewpass_1.setBounds(421, 195, 25, 25);
		panel.add(jeyenewpass_1);

		JButton jButton_Save = new JButton("Save");
		jButton_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Save_actionPerformed(e);
			}
		});
		jButton_Save.setBounds(259, 233, 85, 21);
		panel.add(jButton_Save);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 0));
		add(menuBar, BorderLayout.NORTH);

		JMenuItem jmenuitem_password = new JMenuItem("Change Password");
		jmenuitem_password.setBackground(new Color(255, 255, 128));
		jmenuitem_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		jmenuitem_password.setIcon(new ImageIcon(JPaccount.class.getResource("/Icon/211855_locked_icon.png")));
		menuBar.add(jmenuitem_password);

		jmenuAddAccount = new JMenuItem("Create Account");
		jmenuAddAccount.setBackground(new Color(255, 255, 128));
		jmenuAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jmenuAddAccount_actionPerformed(e);
			}
		});
		jmenuAddAccount.setHorizontalAlignment(SwingConstants.LEFT);
		jmenuAddAccount.setIcon(new ImageIcon(JPaccount.class.getResource("/Small_Icon/add.png")));
		menuBar.add(jmenuAddAccount);
	}

	public JPaccount(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		Users users = (Users) dataMap.get("user");
		
		if (users.getRoleID() == 1) {
			jmenuAddAccount.setVisible(true);
		} else {
			jmenuAddAccount.setVisible(false);
		}
	}

	protected void do_jmenuAddAccount_actionPerformed(ActionEvent e) {
		JPaddAcount jPaddaccount = new JPaddAcount(dataMap);
		this.removeAll();
		this.revalidate();
		this.add(jPaddaccount);
		this.setVisible(true);
	}

	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		JPaccount jPaccount = new JPaccount(dataMap);
		this.removeAll();
		this.revalidate();
		this.add(jPaccount);
		this.setVisible(true);

	}

	protected void do_lblNewLabel2_mouseClicked(MouseEvent e) {
		URL u1 = url1;
		url1 = url2;
		url2 = u1;
		jeyecurent.setIcon(new ImageIcon(url1));
		char ff1 = f1;
		f1 = f2;
		f2 = ff1;
		jpass.setEchoChar(f1);

	}

	protected void do_lblNewLabel23_actionPerformed(ActionEvent e) {
		URL u1 = url1;
		url1 = url2;
		url2 = u1;
		jeyenewpass.setIcon(new ImageIcon(url1));
		char ff1 = f1;
		f1 = f2;
		f2 = ff1;
		jnewPassword.setEchoChar(f1);
	}

	protected void do_jeyenewpass_1_actionPerformed(ActionEvent e) {
		URL u1 = url1;
		url1 = url2;
		url2 = u1;
		jeyenewpass_1.setIcon(new ImageIcon(url1));
		char ff1 = f1;
		f1 = f2;
		f2 = ff1;
		jConfimNewPassword.setEchoChar(f1);
	}

	protected void jButton_Save_actionPerformed(ActionEvent e) {
		Users users = (Users) dataMap.get("user");
		UsersModel usersModel = new UsersModel();

		String currentpass = new String(jpass.getPassword());
		boolean hashpass = BCrypt.checkpw(currentpass, users.getPassword());
		if (hashpass == true) {
			String newpass = new String(jnewPassword.getPassword());
			String confirmpass = new String(jConfimNewPassword.getPassword());

			if (newpass.equalsIgnoreCase(confirmpass)) {
				users.setPassword(BCrypt.hashpw(confirmpass, BCrypt.gensalt()));
				if (usersModel.update(users, users.getUserID())) {
					JOptionPane.showMessageDialog(null, "Change password success !");
				}
			} else {
				JOptionPane.showMessageDialog(null, "New password do not match !");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Current Password not correct !");
		}
		
	}
}
