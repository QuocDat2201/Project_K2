package scAcount;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;

import org.mindrot.jbcrypt.BCrypt;

import entites.Role;
import entites.Users;
import models.Role_model;
import models.UsersModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class JPaddAcount extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JPanel panel;
	private JTextField jusername;
	private JComboBox jcomboBox;
	private JPasswordField Jpassword;
	private JPasswordField JConfirm_passwordField;

	/**
	 * Create the panel.
	 */
	public JPaddAcount() {
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Create Account", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(240, 240, 240));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(40, 46, 176, 25);
		panel.add(lblNewLabel);

		jusername = new JTextField();
		jusername.setBounds(40, 73, 243, 28);
		panel.add(jusername);
		jusername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(40, 111, 176, 25);
		panel.add(lblPassword);

		JLabel lblConfirmNewPassword = new JLabel("Confirm Password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmNewPassword.setBounds(40, 172, 176, 25);
		panel.add(lblConfirmNewPassword);

		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(307, 46, 176, 25);
		panel.add(lblNewLabel_2);

		jcomboBox = new JComboBox();
		jcomboBox.setBounds(307, 72, 247, 28);
		panel.add(jcomboBox);

		JButton Jbutton_register = new JButton("Create");
		Jbutton_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jbutton_register_actionPerformed(e);
			}
		});
		Jbutton_register.setBounds(469, 114, 85, 21);
		panel.add(Jbutton_register);

		Jpassword = new JPasswordField();
		Jpassword.setBounds(40, 134, 243, 28);
		panel.add(Jpassword);

		JConfirm_passwordField = new JPasswordField();
		JConfirm_passwordField.setBounds(40, 195, 243, 28);
		panel.add(JConfirm_passwordField);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 0));
		add(menuBar, BorderLayout.NORTH);

		JMenuItem jmenuitem_password = new JMenuItem("Change Password");
		jmenuitem_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuitem_password_actionPerformed(e);
			}
		});
		jmenuitem_password.setIcon(new ImageIcon(JPaddAcount.class.getResource("/Icon/211855_locked_icon.png")));
		jmenuitem_password.setBackground(new Color(255, 255, 128));
		menuBar.add(jmenuitem_password);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Create Account");
		mntmNewMenuItem.setIcon(new ImageIcon(JPaddAcount.class.getResource("/Small_Icon/add.png")));
		menuBar.add(mntmNewMenuItem);
	}

	public JPaddAcount(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		intiJfame();
	}

	private void intiJfame() {
		DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		Role_model role_model = new Role_model();

		for (Role role : role_model.findAll()) {
			model.addElement(role);
		}
		jcomboBox.setModel(model);
		jcomboBox.setRenderer(new rederCombobox());
	}

	class rederCombobox extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getRole_Name(), index, isSelected, cellHasFocus);
		}

	}

	protected void Jbutton_register_actionPerformed(ActionEvent e) {
		Users users = new Users();
		UsersModel usersModel = new UsersModel();

		users.setUsername(jusername.getText().trim());
		String password = new String(Jpassword.getPassword());
		String confirm = new String(JConfirm_passwordField.getPassword());
		Role role = (Role) jcomboBox.getSelectedItem();
		users.setRoleID(role.getRole_id());
		boolean username = true;

		for (Users users2 : usersModel.findAll()) {
			if (users2.getUsername().equalsIgnoreCase(jusername.getText().trim())) {
				username = false;
			}
		}
		
		if (username == false) {
			JOptionPane.showMessageDialog(null, "Username already exists !");
		} else {
			if (password.equals(confirm)) {
				users.setPassword(BCrypt.hashpw(confirm, BCrypt.gensalt()));
				if (usersModel.register(users)) {
					JOptionPane.showMessageDialog(null, "Register Success !");
				} else {
					JOptionPane.showMessageDialog(null, "Register Fail !");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Password do not match !");
			}
		}
	}

	protected void jmenuitem_password_actionPerformed(ActionEvent e) {
		JPaccount jPaccount = new JPaccount(dataMap);
		this.removeAll();
		this.revalidate();
		this.add(jPaccount);
		this.setVisible(true);
	}
}
